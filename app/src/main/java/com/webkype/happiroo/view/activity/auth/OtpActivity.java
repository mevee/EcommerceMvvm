package com.webkype.happiroo.view.activity.auth;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.auth.LoginResp;
import com.webkype.happiroo.controller.network.responses.auth.Userdetail;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.model.User;
import com.webkype.happiroo.view.activity.FetchLocationActivity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.aabhasjindal.otptextview.OtpTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpActivity extends AppCompatActivity {

    private Context context;
    private String mob;
    private String otpToBeCheckedAgaienst;

    @BindView(R.id.mobileOTPTxt)
    TextView mobileOTPTxt;
    @BindView(R.id.otp_view)
    OtpTextView otp_view;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        context = OtpActivity.this;
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Verifying OTP...");

        if (getIntent().getExtras() != null) {
            mob = getIntent().getStringExtra("mob");
            otpToBeCheckedAgaienst = getIntent().getStringExtra("otp");

            mobileOTPTxt.setText("+91 " + mob);
        }
//        assigning the otp from previous page
        otp_view.setOTP(otpToBeCheckedAgaienst);
    }

    @OnClick({R.id.backOtp, R.id.submitOtpTxtBtn})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.backOtp:
                onBackPressed();
                break;
            case R.id.submitOtpTxtBtn:
                validate();
                break;
        }
    }


    private void validate() {
        String otp = otp_view.getOTP();
        if (TextUtils.isEmpty(otp)) {
            Toast.makeText(context, "OTP is required", Toast.LENGTH_SHORT).show();
            return;
        } else if (otp.length() < 4) {
            Toast.makeText(context, "Valid OTP is required", Toast.LENGTH_SHORT).show();
            return;
        }

        hitLogINApi(otp);
    }

    private void hitLogINApi(String otp) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            progressDialog.show();
            NetworkProvider.instance().otpVarification(mob, otp).enqueue(new Callback<LoginResp>() {
                @Override
                public void onResponse(Call<LoginResp> call, Response<LoginResp> response) {
                    progressDialog.dismiss();
                    LoginResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        Userdetail userData = resp.getUserdetail();
                        User user = new User(userData.getId(), userData.getFullname(), userData.getEmailid(), userData.getMobileno());
                        Preference.saveUser(context, user);
                        Intent intent = new Intent(context, FetchLocationActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResp> call, Throwable t) {
                    Log.d("OtpActivity", "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

}
