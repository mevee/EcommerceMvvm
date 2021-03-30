package com.webkype.happiroo.view.activity.shopService;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.CommonResponse;
import com.webkype.happiroo.controller.network.responses.cart.AddToCartResponse;
import com.webkype.happiroo.controller.network.responses.cart.UpdateCartResp;
import com.webkype.happiroo.controller.network.responses.mservices.ProductUsed;
import com.webkype.happiroo.controller.network.responses.mservices.ReviewItem;
import com.webkype.happiroo.controller.network.responses.mservices.ServiceDetailResp;
import com.webkype.happiroo.controller.network.responses.mservices.Servicedetails;
import com.webkype.happiroo.controller.network.responses.mservices.Servicepic;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.CartUtils;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ActivityProductDetailBinding;
import com.webkype.happiroo.databinding.UserInputRatingBinding;
import com.webkype.happiroo.model.SampleModel;
import com.webkype.happiroo.model.User;
import com.webkype.happiroo.view.activity.auth.AuthenticateActivity;
import com.webkype.happiroo.view.activity.checout_process.CartActivity;
import com.webkype.happiroo.view.adapter.CustomerReviewAdapter;
import com.webkype.happiroo.view.adapter.ServiceDetailPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceProductDetailActivity extends AppCompatActivity {

    private static final String TAG = ServiceProductDetailActivity.class.getName();
    private Context context;
    private LayoutInflater layoutInflater;

    private ActivityProductDetailBinding binding;
    private CustomerReviewAdapter customerReviewAdapter;

    private List<SampleModel> serviceBannerList = new ArrayList<>();
    private ServiceDetailPagerAdapter serviceDetailPagerAdapter;


    private String pid;
    private List<ReviewItem> mList = new ArrayList<>();
    private boolean isFav = false;
    private String userId;
    private String cartId;
    int currentPage = 0;
    Timer timer;
    long DELAY_MS = 2000;//delay in milliseconds before task is to be executed
    long PERIOD_MS = 4000; // time in milliseconds between successive task executions.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail);
        context = ServiceProductDetailActivity.this;
        if (getIntent().getExtras() != null) {
            pid = getIntent().getExtras().getString("catId");
        }
        User user = Preference.getUser(context);
        cartId = Preference.getCartId(context);

        customerReviewAdapter = new CustomerReviewAdapter(this, mList);
        binding.rvCustomerReviewList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvCustomerReviewList.setFocusable(false);
        binding.rvCustomerReviewList.setAdapter(customerReviewAdapter);

        binding.backPdp.setOnClickListener(v -> onBackPressed());
        binding.cartPdp.setOnClickListener(v -> startActivity(new Intent(context, CartActivity.class)));
        binding.goCartPdpLayout.setOnClickListener(v -> startActivity(new Intent(context, CartActivity.class)));
        binding.pdpAddToCart.setOnClickListener(v -> {
            if (user == null) {
                Intent intent = new Intent(context, AuthenticateActivity.class);
                intent.putExtra("from", "profile");
                startActivity(intent);
                return;
            }
            String cartId = Preference.getCartId(context);
            if (TextUtils.isEmpty(cartId)) {
                addToCart(pid, user.getUserId());
            } else {
                addToCartConfirmation(pid, user.getUserId());
            }
        });
        if (user != null)
            userId = user.getUserId();
        init();

        binding.productFavImage.setOnClickListener(v -> {
            if (user == null) {
                Intent intent = new Intent(context, AuthenticateActivity.class);
                intent.putExtra("from", "profile");
                startActivity(intent);
                return;
            }
            addToFav(pid, user.getUserId());
        });
        binding.mainDetail.setVisibility(View.GONE);
        getServiceDetail(pid, userId);
        Log.d(TAG, "" + pid);


        binding.tvBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCart(pid, "add");
            }
        });
        binding.tvBtnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCart(pid, "sub");
            }
        });
        binding.addRatingBtnTV.setOnClickListener(v -> {
            addRatingDialog();
        });
    }

    private void addToCartConfirmation(String serviceId, String userID) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Do you want to replace this service with older service in cart? " +
                "\n*You can add only one service at time.");
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cartId = "";
                addToCart(serviceId, userID);
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void updateCart(String pid, String option) {
        binding.tvBtnAdd.setEnabled(false);
        binding.tvBtnSubtract.setEnabled(false);
        if (InternetConnectionCheck.haveNetworkConnection(context)) {
            NetworkProvider.instance().updateCartProduct(pid, cartId, option).enqueue(new Callback<UpdateCartResp>() {
                @Override
                public void onResponse(Call<UpdateCartResp> call, Response<UpdateCartResp> response) {
                    binding.tvBtnAdd.setEnabled(true);
                    binding.tvBtnSubtract.setEnabled(true);
                    UpdateCartResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        binding.tvCartCount.setText("" + resp.getQty());
                        binding.tvCartTotal.setText(binding.tvCartCount.getText().toString());
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UpdateCartResp> call, Throwable t) {
                    binding.tvBtnAdd.setEnabled(true);
                    binding.tvBtnSubtract.setEnabled(true);
                    Log.d("ProductAdapter", "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void addToFav(String serviceId, String userID) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressbarProductDetail.setVisibility(View.VISIBLE);
            NetworkProvider.instance().addremovefavorite(serviceId, userID).enqueue(new Callback<CommonResponse>() {
                @Override
                public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                    binding.progressbarProductDetail.setVisibility(View.GONE);
                    CommonResponse resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        if (isFav) {
                            isFav = false;
                            binding.productFavImage.setImageDrawable(getResources().getDrawable(R.drawable.fav_border));
                        } else {
                            binding.productFavImage.setImageDrawable(getResources().getDrawable(R.drawable.fav_fill));
                            isFav = true;
                        }

                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CommonResponse> call, Throwable t) {
                    binding.progressbarProductDetail.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void addToCart(String serviceId, String userID) {
        binding.pdpAddToCart.setEnabled(false);
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressbarProductDetail.setVisibility(View.VISIBLE);
            NetworkProvider.instance().addToCart(serviceId, cartId, "1","Service", userID).enqueue(new Callback<AddToCartResponse>() {
                @Override
                public void onResponse(Call<AddToCartResponse> call, Response<AddToCartResponse> response) {
                    binding.pdpAddToCart.setEnabled(true);
                    binding.progressbarProductDetail.setVisibility(View.GONE);
                    AddToCartResponse resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        Preference.setCartId(context, resp.getBid());
                        cartId = Preference.getCartId(context);
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                        binding.pdpAddToCart.setVisibility(View.GONE);
                        binding.pdpCounterLayout.setVisibility(View.VISIBLE);
                        binding.cartLayoutPdp.setVisibility(View.VISIBLE);
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<AddToCartResponse> call, Throwable t) {
                    binding.progressbarProductDetail.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void getServiceDetail(String serviceId, String userId) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressbarProductDetail.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getServiceDetail(serviceId, cartId, userId).enqueue(new Callback<ServiceDetailResp>() {
                @Override
                public void onResponse(Call<ServiceDetailResp> call, Response<ServiceDetailResp> response) {
                    binding.progressbarProductDetail.setVisibility(View.GONE);
                    binding.mainDetail.setVisibility(View.VISIBLE);
                    ServiceDetailResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        Servicedetails detail = resp.getServicedetails();
                        binding.tvServiceDetailRating.setText(detail.getRating());
                        binding.tvServiceName.setText(detail.getServicename());
                        binding.tvProcessTime.setText(detail.getServiceduration());
                        binding.pdpCostPrice.setText("\u20B9" + detail.getCostprice());
                        binding.pdpSellingPrice.setText("\u20B9" + detail.getSellingprice());
                        binding.tvSmallDetail.setText(Html.fromHtml(detail.getLongdescription()));
                        binding.tvIncludes.setText(Html.fromHtml(detail.getInclusion()));
                        binding.tvWhatExcluded.setText(Html.fromHtml(detail.getExculusion()));
                        binding.tvAdditionalDetail.setText(Html.fromHtml(detail.getAdditionaldetails()));
                        binding.tvAssurance.setText(Html.fromHtml(detail.getColortrayauusrance()));
                        if (TextUtils.isEmpty(detail.getEquipmentused()))
                        binding.brandUsed.setVisibility(View.GONE);
                        else
                        binding.brandUsed.setText(Html.fromHtml(detail.getEquipmentused()));
                        StringBuilder equipmentUsed = new StringBuilder();
                        int i = 0;
                        if (detail.getProductused() != null && detail.getProductused().size() > 0) {
                            for (ProductUsed productUsed : detail.getProductused()) {
                                if (i == 0)
                                    equipmentUsed.append((i+1) + ". " + productUsed.getProductname());
                                else
                                    equipmentUsed.append("\n" + (i+1) + ". " + productUsed.getProductname());
                                i++;
                            }
                        }
                        binding.equipmentUsed.setText(equipmentUsed.toString());

                        if (detail.getServicepics() != null && detail.getServicepics().size() > 0) {
                            serviceBannerList.clear();
                            for (Servicepic banner : detail.getServicepics()) {
                                serviceBannerList.add(new SampleModel("" + banner.getImage(), banner.getImgid(), ""));
                            }
                            setTopBanner();
                        }


                        if (detail.getReviews() != null && detail.getReviews().size() > 0) {
                            mList.clear();
                            mList.addAll(detail.getReviews());

                        }
                        customerReviewAdapter.notifyDataSetChanged();


                        if ("0".equals(detail.getIsfavorite())) {
                            isFav = false;
                            binding.productFavImage.setImageDrawable(getResources().getDrawable(R.drawable.fav_border));
                        } else {
                            binding.productFavImage.setImageDrawable(getResources().getDrawable(R.drawable.fav_fill));
                            isFav = true;
                        }

                        if (!TextUtils.isEmpty(detail.getCartQnt())) {
                            binding.pdpAddToCart.setVisibility(View.GONE);
                            binding.pdpCounterLayout.setVisibility(View.VISIBLE);
                            binding.cartLayoutPdp.setVisibility(View.VISIBLE);
                            binding.tvCartCount.setText(detail.getCartQnt());
                            binding.tvCartTotal.setText(detail.getCartQnt());

                        }

                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ServiceDetailResp> call, Throwable t) {
                    binding.progressbarProductDetail.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    private void setTopBanner() {
        /*TOP BANNERS*/
        serviceDetailPagerAdapter = new ServiceDetailPagerAdapter(context, serviceBannerList);
        binding.serviceDetailViewPager.setAdapter(serviceDetailPagerAdapter);
//        binding.serviceDetailPagerIndicator.setViewPager(binding.serviceDetailViewPager);
        binding.serviceDetailViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                final float normalizedposition = Math.abs(Math.abs(position) - 1);
                page.setAlpha(normalizedposition);
            }
        });

        timer = new Timer();
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (serviceBannerList != null) {
                    if (currentPage == serviceBannerList.size()) {
                        //currentPage = 0;
                        timer.cancel();
                    }
                }
                binding.serviceDetailViewPager.setCurrentItem(currentPage++, true);
            }
        };
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }


    private void sendReviewToApi(String review, float rating) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressbarProductDetail.setVisibility(View.VISIBLE);
            NetworkProvider.instance().addReview(pid, review, "" + rating, userId).enqueue(new Callback<CommonResponse>() {
                @Override
                public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                    binding.progressbarProductDetail.setVisibility(View.GONE);
                    CommonResponse resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        userInputRating = 0;
                        getServiceDetail(pid, userId);
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CommonResponse> call, Throwable t) {
                    binding.progressbarProductDetail.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onBackPressed() {
        this.finish();
    }

    private void init() {

        layoutInflater = LayoutInflater.from(context);

        binding.pdpCostPrice.setPaintFlags(binding.pdpCostPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    float userInputRating = 0;
    private Dialog ratingDialo;

    private void addRatingDialog() {

        UserInputRatingBinding ratingInputbinding = UserInputRatingBinding.inflate(layoutInflater, null, false);

        ratingInputbinding.rbRatingInputUser.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                userInputRating = rating;
            }
        });
        ratingInputbinding.tvSubmitUserRating.setOnClickListener(v -> {
            String review = ratingInputbinding.etReviewUeser.getText().toString();
            if (TextUtils.isEmpty(review)) {
                Toast.makeText(context, "Review is required", Toast.LENGTH_SHORT).show();
                return;
            }
            sendReviewToApi(review, userInputRating);
            ratingDialo.dismiss();
        });
//        View view1 = layoutInflater.inflate(R.layout.add_rating_dialog, null, false);
        final AlertDialog dialog = new AlertDialog.Builder(context)
                .setView(ratingInputbinding.getRoot())
                .create();

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ratingDialo = dialog;

        ratingDialo.show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        CartUtils.getCartDetail(binding.tvCartQuantity,context, Preference.getCartId(context));
    }
}
