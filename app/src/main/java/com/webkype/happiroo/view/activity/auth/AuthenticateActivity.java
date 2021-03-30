package com.webkype.happiroo.view.activity.auth;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.auth.OtpResp;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.view.activity.FetchLocationActivity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthenticateActivity extends AppCompatActivity {

    private Context context;
    @BindView(R.id.mobileLogin_eT)
    EditText mobileLogin_eT;
    @BindView(R.id.loginBtnLinear)
    LinearLayout loginBtnLinear;
    @BindView(R.id.skipLoginTxtBtn)
    TextView skipLoginTxtBtn;
    private String from;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticate);
        context = AuthenticateActivity.this;
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Getting OTP...");
        if (getIntent().getExtras() != null) {
            from = getIntent().getExtras().getString("from");
        }
        String isLogInSkipped = Preference.getLoginSkipped(context);

        if (!TextUtils.isEmpty(from)) {
            skipLoginTxtBtn.setVisibility(View.GONE);
        } else {
            if (!TextUtils.isEmpty(isLogInSkipped)) {
                startActivity(new Intent(context, FetchLocationActivity.class));
            }
        }

        init();
    }

    @OnClick({R.id.loginBtnLinear})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginBtnLinear:
                validate();
                break;
        }
    }

    private void validate() {
        String mobile = mobileLogin_eT.getText().toString();
        if (TextUtils.isEmpty(mobile)) {
            Toast.makeText(context, "Mobile no is required", Toast.LENGTH_SHORT).show();
            return;
        } else if (mobile.length() < 10) {
            Toast.makeText(context, "Valid mobile is required", Toast.LENGTH_SHORT).show();
            return;
        }

        hitLogINApi(mobile);
    }

    private void hitLogINApi(String mobile) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            progressDialog.show();
            NetworkProvider.instance().loginSignUp(mobile).enqueue(new Callback<OtpResp>() {
                @Override
                public void onResponse(Call<OtpResp> call, Response<OtpResp> response) {
                    progressDialog.dismiss();
                    OtpResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        Intent intent = new Intent(context, OtpActivity.class);
                        intent.putExtra("mob", mobile);
                        intent.putExtra("otp", "" + resp.getOtp());
                        startActivity(intent);
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<OtpResp> call, Throwable t) {
                    Log.d("AuthenticateActivity", "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void init() {
        skipLoginTxtBtn.setOnClickListener(v -> {
            Preference.setLoginSkipped(this, "skipped");
            startActivity(new Intent(context, FetchLocationActivity.class));
        });
        mobileLogin_eT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (mobileLogin_eT.length() == 10) {
                    loginBtnLinear.setVisibility(View.VISIBLE);
                } else {
                    loginBtnLinear.setVisibility(View.GONE);
                }
            }
        });
    }
}
