package com.webkype.happiroo.view.activity.shopProduct;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.webkype.happiroo.controller.network.AppApi;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.CommonResponse;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.FragmentAddProductRatingBinding;
import com.webkype.happiroo.view.CommonListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddProductRatingFragment extends BottomSheetDialogFragment {
    public static final String TAG = AddProductRatingFragment.class.getName();
    public static final String PID = "PID";
    public static final String UID = "UID";
    private String productId;
    private String userId;
    private FragmentAddProductRatingBinding binding;

    public AddProductRatingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            productId = getArguments().getString(PID);
            userId = getArguments().getString(UID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddProductRatingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.ivClose.setOnClickListener(v -> {
            dismiss();
        });
        binding.tvBtnSubmit.setOnClickListener(v -> {
            float rating = binding.rbRatingBar.getRating();
            String message = binding.etReviewMessage.getText().toString();
            if (rating == 0) {
                Toast.makeText(getContext(), "Rating is not selected", Toast.LENGTH_SHORT).show();
                return;
            } else if (TextUtils.isEmpty(message)) {
                Toast.makeText(getContext(), "Review is required", Toast.LENGTH_SHORT).show();
                return;
            }
            setnRaingToServer(rating, message);
        });
    }

    private CommonListener listener;

    public void setListener(CommonListener listener) {
        this.listener = listener;
    }

    private void setnRaingToServer(float rating, String message) {

        if (InternetConnectionCheck.haveNetworkConnection(getActivity())) {
            binding.progressBarAddRating.setVisibility(View.VISIBLE);
            AppApi api = NetworkProvider.instance();
            Call<CommonResponse> call = api.addProductReview(userId, productId, message,"" + rating );
            call.enqueue(new Callback<CommonResponse>() {
                @Override
                public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                    binding.progressBarAddRating.setVisibility(View.GONE);
                    CommonResponse res = response.body();
                    if ("200".equals(res.getStatus())) {
                        Toast.makeText(getActivity(), "Review added successfully", Toast.LENGTH_SHORT).show();
                        if (listener != null)
                            listener.onClicked(1, CommonListener.UPDATED);
                        dismiss();
                    } else {
                        Log.d("TAG", "error :" + res.getMsg());

                    }
                }

                @Override
                public void onFailure(Call<CommonResponse> call, Throwable t) {
                    binding.progressBarAddRating.setVisibility(View.GONE);
                    Log.d("TAG", "error :" + t.getMessage());
                }
            });


        } else {
            Toast.makeText(getContext(), "Check your internet connection", Toast.LENGTH_SHORT).show();
        }

    }

}