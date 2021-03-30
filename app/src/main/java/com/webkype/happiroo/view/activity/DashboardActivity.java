package com.webkype.happiroo.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.AppApi;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.CommonResponse;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.model.User;
import com.webkype.happiroo.view.fragment.dashboard.BookingsFragment;
import com.webkype.happiroo.view.fragment.dashboard.FavFragment;
import com.webkype.happiroo.view.fragment.dashboard.HomeFragment;
import com.webkype.happiroo.view.fragment.dashboard.ProfileFragment;
import com.webkype.happiroo.view.fragment.dashboard.ShopFragment;
import com.webkype.happiroo.view.fragment.dashboard.WalletFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity implements PaymentResultListener {
    private String TAG = "DashboardActivity";

    private Context context;
    private boolean doubleBackToExitPressedOnce = false;
    @BindView(R.id.bottomNav)
    BottomNavigationView bottomNav;
    private String fragment = "";
    private User user;
    private int amountToBeAdded = 0;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        context = DashboardActivity.this;
        ButterKnife.bind(this);
        user = Preference.getUser(this);
        progressDialog = new ProgressDialog(this);

        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction transaction = ((DashboardActivity) this).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout_home, new HomeFragment());
        transaction.commit();
        bottomNav.setSelectedItemId(R.id.action_home);
        if (user!=null)
        getFirebaseToken();
        setUpFragmentFlow();
    }

    private void getFirebaseToken() {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }
                        // Get new FCM registration token
                        String token = task.getResult();
                        // Log and toast
                        String msg = "token: " + token;
                        Log.d(TAG, msg);
//                        Toast.makeText(HomePageActivity.this, msg, Toast.LENGTH_SHORT).show();
                        sendTokenToServer(token);
                    }
                });
    }

    private void sendTokenToServer(String token) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            NetworkProvider.instance().sendTokenToServer(user.getUserId(), token)
                    .enqueue(new Callback<CommonResponse>() {
                        @Override
                        public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                            CommonResponse resp = response.body();
                            if ("200".equals(resp.getStatus())) {
                                Log.d(TAG, "token sent success full");
                            }
                        }

                        @Override
                        public void onFailure(Call<CommonResponse> call, Throwable t) {
                            Log.d(TAG, t.getMessage());
                        }
                    });

        } else {
            Toast.makeText(context, "Check internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    /*
     * For Opening desired Fragment through intent
     * */
    private void setUpFragmentFlow() {

        if (getIntent().getExtras() != null) {
            fragment = getIntent().getStringExtra("from");

            if (fragment.equals("home")) {

                FragmentTransaction transaction = ((DashboardActivity) this).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout_home, new HomeFragment());
                transaction.commit();
                bottomNav.setSelectedItemId(R.id.action_home);

            } else if (fragment.equals("booking")) {

                FragmentTransaction transaction = ((DashboardActivity) this).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout_home, new BookingsFragment());
                transaction.commit();
                bottomNav.setSelectedItemId(R.id.action_booking);

            } else if (fragment.equals("fav")) {

                FragmentTransaction transaction = ((DashboardActivity) this).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout_home, new ShopFragment());
                transaction.commit();
                bottomNav.setSelectedItemId(R.id.action_fav);

            } else if (fragment.equals("wallet")) {

                FragmentTransaction transaction = ((DashboardActivity) this).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout_home, new WalletFragment());
                transaction.commit();
                bottomNav.setSelectedItemId(R.id.action_wallet);

            } else if (fragment.equals("profile")) {

                FragmentTransaction transaction = ((DashboardActivity) this).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout_home, new ProfileFragment());
                transaction.commit();
                bottomNav.setSelectedItemId(R.id.action_profile);

            } else {
                FragmentTransaction transaction = ((DashboardActivity) this).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout_home, new HomeFragment());
                transaction.commit();
                bottomNav.setSelectedItemId(R.id.action_home);
            }

        } else {
            FragmentTransaction transaction = ((DashboardActivity) this).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout_home, new HomeFragment());
            transaction.commit();
            bottomNav.setSelectedItemId(R.id.action_home);
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.action_home:
                    if (bottomNav.getSelectedItemId() != R.id.action_home) {
                        fragment = new HomeFragment();
                        loadFragment(fragment);
                        return true;
                    } else {
                        return false;
                    }
                case R.id.action_booking:
                    if (bottomNav.getSelectedItemId() != R.id.action_booking) {
                        fragment = new BookingsFragment();
                        loadFragment(fragment);
                        return true;
                    } else {
                        return false;
                    }
                case R.id.action_fav:
                    if (bottomNav.getSelectedItemId() != R.id.action_fav) {
                        fragment = new ShopFragment();
                        loadFragment(fragment);
                        return true;
                    } else {
                        return false;
                    }
                case R.id.action_wallet:
                    if (bottomNav.getSelectedItemId() != R.id.action_wallet) {
                        fragment = new WalletFragment();
                        loadFragment(fragment);
                        return true;
                    } else {
                        return false;
                    }
                case R.id.action_profile:
                    if (bottomNav.getSelectedItemId() != R.id.action_profile) {
                        fragment = new ProfileFragment();
                        loadFragment(fragment);
                        return true;
                    } else {
                        return false;
                    }
            }

            return false;
        }
    };


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout_home, fragment);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onStart() {
        super.onStart();
        user = Preference.getUser(this);
    }

    public void goToPaymentGateWay(int amount) {
        this.amountToBeAdded = amount;
        String email = user.getEmail();
        String mobile = user.getMobile();
//        startPayment(amount, email, mobile, "Wallet Recharge");
    }

    private void startPayment(double orderAmount, String email, String phone, String from) {
        final Checkout co = new Checkout();
        try {
            JSONObject option = new JSONObject();
            option.put("name", getString(R.string.app_name));
            option.put("description", from);
            option.put("image", "");
            option.put("currency", "INR");
            option.put("amount", (int) (orderAmount * 100));
            JSONObject preFill = new JSONObject();
            preFill.put("email", email);
            preFill.put("contact", phone);
            option.put("prefill", preFill);
            co.open(this, option);
        } catch (Exception e) {
            Toast.makeText(this, "Error In Payment.Please try again!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        addWalletAmount(user.getUserId(), "" + amountToBeAdded);
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(context, "Transaction Cancelled", Toast.LENGTH_SHORT).show();
    }


    private void addWalletAmount(String userId, String amount) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            progressDialog.setMessage("Don't press back transaction is in process...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            NetworkProvider.instance().addWalletAmout(userId, "Added From Android-App", amount)
                    .enqueue(new Callback<CommonResponse>() {
                        @Override
                        public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                            progressDialog.dismiss();
                            CommonResponse resp = response.body();
                            if ("200".equals(resp.getStatus())) {
                                Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                                onStart();
                            } else {
                                Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<CommonResponse> call, Throwable t) {
                            progressDialog.dismiss();
                            Log.d("TAGWalllet", "" + t.getMessage());
                        }
                    });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        if (bottomNav.getSelectedItemId() != R.id.action_home) {

            FragmentTransaction transaction = ((DashboardActivity) this).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout_home, new HomeFragment());
            transaction.commit();
            bottomNav.setSelectedItemId(R.id.action_home);

        } else {

            if (doubleBackToExitPressedOnce) {
                this.finishAffinity();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);

        }
    }
}
