package com.webkype.happiroo.view.fragment.dashboard;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.databinding.FragmentProfileBinding;
import com.webkype.happiroo.model.User;
import com.webkype.happiroo.view.activity.FavServiceActivity;
import com.webkype.happiroo.view.activity.NotificationsActivity;
import com.webkype.happiroo.view.activity.ProfileEditActivity;
import com.webkype.happiroo.view.activity.ReferEarnActivity;
import com.webkype.happiroo.view.activity.WebViewActivity;
import com.webkype.happiroo.view.activity.auth.AuthenticateActivity;
import com.webkype.happiroo.view.activity.checout_process.CartActivity;
import com.webkype.happiroo.view.activity.orders.OrderListActivity;
import com.webkype.happiroo.view.activity.policyes.CancellationPolicyActivity;
import com.webkype.happiroo.view.activity.policyes.CustromerSupportActivity;
import com.webkype.happiroo.view.activity.policyes.DisclaimerActivity;
import com.webkype.happiroo.view.activity.policyes.PrivacyPolicyActivity;
import com.webkype.happiroo.view.activity.policyes.TncActivity;
import com.webkype.happiroo.view.activity.shopProduct.FavProductListActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private Context context;
    private FragmentProfileBinding binding;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.llProfileShareApp.setOnClickListener(v -> {
            shareApp();
        });
        binding.llProfileRateApp.setOnClickListener(v -> {
            rateUs();
        });

        binding.editProfileIV.setOnClickListener(v -> {
            startActivity(new Intent(context, ProfileEditActivity.class));
        });
        binding.myFavProducts.setOnClickListener(v -> {
            startActivity(new Intent(context, FavProductListActivity.class));
        });
        binding.myCartLinear.setOnClickListener(v -> {
            startActivity(new Intent(context, CartActivity.class));
        });
        binding.myOrdersLinear.setOnClickListener(v -> {
            startActivity(new Intent(context, OrderListActivity.class));
        });
        binding.myFavServices.setOnClickListener(v -> {
            startActivity(new Intent(context, FavServiceActivity.class));
        });

        binding.notificationLinear.setOnClickListener(v -> {
            startActivity(new Intent(context, NotificationsActivity.class));
        });
        binding.referEarnLinear.setOnClickListener(v -> {
            startActivity(new Intent(context, ReferEarnActivity.class));
        });
        binding.llLoginProfile.setOnClickListener(v -> {
            Intent intent = new Intent(context, AuthenticateActivity.class);
            intent.putExtra("from", "profile");
            startActivity(intent);
        });
        binding.llLogoutProfile.setOnClickListener(v -> {
            logout();
        });
        binding.llAboutUs.setOnClickListener(v -> {
            goToHelpScreen("About App", "https://happiroo.in/about-us");
        });

        binding.llFaq.setOnClickListener(v -> {
            startActivity(new Intent(context, CustromerSupportActivity.class));
        });
        binding.llTnc.setOnClickListener(v -> {
            startActivity(new Intent(context, TncActivity.class));
        });

        binding.llCancellationPolicy.setOnClickListener(v -> {
            startActivity(new Intent(context, CancellationPolicyActivity.class));
        });

        binding.llDisclaimer.setOnClickListener(v -> {
            startActivity(new Intent(context, DisclaimerActivity.class));
        });
        binding.llPrivacyPolicies.setOnClickListener(v -> {
            startActivity(new Intent(context, PrivacyPolicyActivity.class));
        });


    }

    private void goToHelpScreen(String title, String urlLink) {
        Intent intent = new Intent(getContext(), WebViewActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("url", urlLink);
        startActivity(intent);
    }

    private void shareApp() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Hey check out Happiroo App app at: https://play.google.com/store/apps/details?id=" + context.getPackageName());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private void rateUs() {
        Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
        }
    }

    private void logout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Do you want to Logout?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Preference.logOut(getContext());
                onStart();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    @Override
    public void onStart() {
        super.onStart();
        User user = Preference.getUser(getContext());
        if (user == null) {
            binding.tvUserEmailProfile.setText("");
            binding.tvUserNameProfile.setText(R.string.welcome_to_mclap);
            binding.tvUserMobileProfile.setText("");
            binding.editProfileIV.setVisibility(View.GONE);
            binding.myFavProducts.setVisibility(View.GONE);
            binding.myFavServices.setVisibility(View.GONE);
            binding.myOrdersLinear.setVisibility(View.GONE);
            binding.myCartLinear.setVisibility(View.GONE);

            binding.llLoginProfile.setVisibility(View.VISIBLE);
            binding.llLogoutProfile.setVisibility(View.GONE);
        } else {
            binding.tvUserEmailProfile.setText(user.getEmail().isEmpty() ? "Complete your Profile" : user.getEmail());
            binding.tvUserNameProfile.setText(user.getName().isEmpty() ? "Complete your Profile" : user.getName());
            binding.tvUserMobileProfile.setText(user.getMobile());
            binding.editProfileIV.setVisibility(View.VISIBLE);
            binding.llLoginProfile.setVisibility(View.GONE);
            binding.llLogoutProfile.setVisibility(View.VISIBLE);

//            binding.myFavProducts.setVisibility(View.VISIBLE);
            binding.myFavProducts.setVisibility(View.GONE);
            binding.myFavServices.setVisibility(View.VISIBLE);
//            binding.myOrdersLinear.setVisibility(View.VISIBLE);
            binding.myOrdersLinear.setVisibility(View.GONE);
            binding.myCartLinear.setVisibility(View.VISIBLE);
        }
    }
}
