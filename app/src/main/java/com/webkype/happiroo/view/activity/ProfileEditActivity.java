package com.webkype.happiroo.view.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.auth.LoginResp;
import com.webkype.happiroo.controller.network.responses.auth.Userdetail;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ActivityProfileEditBinding;
import com.webkype.happiroo.model.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileEditActivity extends AppCompatActivity {

    private Context context;
    private ActivityProfileEditBinding binding;
    private User user;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile_edit);
        context = ProfileEditActivity.this;
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Uploading data...");

        binding.backProfile.setOnClickListener(v -> onBackPressed());
        binding.cardUpdateProfile.setOnClickListener(v -> validate());
        user = Preference.getUser(context);
        binding.etEmail.setText(user.getEmail());
        binding.etMobile.setText(user.getMobile());
        binding.etFullname.setText(user.getName());
    }

    private void validate() {
        String email = binding.etEmail.getText().toString();
        String mobile = binding.etMobile.getText().toString();
        String name = binding.etFullname.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(context, "Email is required", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(name)) {
            Toast.makeText(context, "Name is required", Toast.LENGTH_SHORT).show();
            return;
        }
        hitLogINApi(user.getUserId(), email, name);
    }

    private void hitLogINApi(String userId, String email, String name) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            progressDialog.show();
            NetworkProvider.instance().updateUserDetail(userId, email, name).enqueue(new Callback<LoginResp>() {
                @Override
                public void onResponse(Call<LoginResp> call, Response<LoginResp> response) {
                    progressDialog.dismiss();
                    LoginResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        Userdetail userData = resp.getUserdetail();
                        User user = new User(userData.getId(), userData.getFullname(), userData.getEmailid(), userData.getMobileno());
                        Preference.saveUser(context, user);
                        Toast.makeText(context, "Uploading Completed", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onBackPressed() {
        finish();
    }
}
