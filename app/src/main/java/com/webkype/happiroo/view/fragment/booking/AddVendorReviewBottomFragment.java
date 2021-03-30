package com.webkype.happiroo.view.fragment.booking;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.CommonResponse;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.FragmentAddVendorReviewBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddVendorReviewBottomFragment extends BottomSheetDialogFragment {
    private final String TAG = AddVendorReviewBottomFragment.class.getCanonicalName();
    private FragmentAddVendorReviewBinding binding;
    private float ratingValue = 0;
    private String userId;
    private String vendorId;
    private String name;
    private String rating;
    private String totalRating;
    private String image;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddVendorReviewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userId = Preference.getUser(getContext()).getUserId();
        if (getArguments() != null) {
            vendorId = getArguments().getString("vId");
            name = getArguments().getString("name");
            image = getArguments().getString("image");
            rating = getArguments().getString("rating");
            totalRating = getArguments().getString("totalRating");
        }

        if (!TextUtils.isEmpty(image))
            Glide.with(getContext()).load(image).into(binding.ivVendorImage);
        binding.ivVendorName.setText(name);
        binding.tvVendorRating.setText(rating);
        binding.vendorTotalRatings.setText(totalRating+" Ratings");

        binding.closeAddVendorReview.setOnClickListener(v -> dismiss());
        binding.btnSubmitReview.setOnClickListener(v -> validation());
        binding.rbReviewRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue = rating;
            }
        });
    }

    private void validation() {
        String review = binding.etReview.getText().toString();
        if (TextUtils.isEmpty(review)) {
            Toast.makeText(getContext(), "Review can't be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        sendReviewToApi(review);
    }

    private void sendReviewToApi(String review) {
        if (InternetConnectionCheck.haveNetworkConnection(getActivity())) {
            binding.progressbarVendorReview.setVisibility(View.VISIBLE);
            NetworkProvider.instance().addVendorReview(vendorId, review, "" + ratingValue, userId).enqueue(new Callback<CommonResponse>() {
                @Override
                public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                    binding.progressbarVendorReview.setVisibility(View.GONE);
                    CommonResponse resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        Toast.makeText(getContext(), "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                        dismiss();
                    } else {
                        Toast.makeText(getContext(), "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CommonResponse> call, Throwable t) {
                    binding.progressbarVendorReview.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(getContext(), "Check your internet connection", Toast.LENGTH_SHORT).show();
        }

    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialogInterface;
                setupFullHeight(bottomSheetDialog);
            }
        });
        return dialog;
    }


    private void setupFullHeight(BottomSheetDialog bottomSheetDialog) {
        FrameLayout bottomSheet = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        ViewGroup.LayoutParams layoutParams = bottomSheet.getLayoutParams();

        int windowHeight = getWindowHeight();
        if (layoutParams != null) {
            layoutParams.height = windowHeight;
        }
        bottomSheet.setLayoutParams(layoutParams);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    private int getWindowHeight() {
        // Calculate window height for fullscreen use
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }
}
