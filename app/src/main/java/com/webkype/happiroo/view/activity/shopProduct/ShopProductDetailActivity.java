package com.webkype.happiroo.view.activity.shopProduct;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.AppApi;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.CommonResponse;
import com.webkype.happiroo.controller.network.responses.cart.AddToCartResponse;
import com.webkype.happiroo.controller.network.responses.prod_detail_resp.ProdImage;
import com.webkype.happiroo.controller.network.responses.prod_detail_resp.ProductDetail;
import com.webkype.happiroo.controller.network.responses.prod_detail_resp.ProductDetailResp;
import com.webkype.happiroo.controller.network.responses.prod_review_resp.ProductReviewResp;
import com.webkype.happiroo.controller.network.responses.prod_review_resp.Review;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.CartUtils;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.controller.utils.StringUtil;
import com.webkype.happiroo.databinding.ActivityShopProductDetailActivityBinding;
import com.webkype.happiroo.model.SampleModel;
import com.webkype.happiroo.view.CommonListener;
import com.webkype.happiroo.view.activity.auth.AuthenticateActivity;
import com.webkype.happiroo.view.activity.checout_process.CartActivity;
import com.webkype.happiroo.view.adapter.ServiceDetailPagerAdapter;
import com.webkype.happiroo.view.adapter.shopProduct.UserReviewAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopProductDetailActivity extends AppCompatActivity {
    private static final String TAG = ShopProductDetailActivity.class.getName();
    ActivityShopProductDetailActivityBinding binding;


    private ServiceDetailPagerAdapter serviceDetailPagerAdapter;
    //    private List<Reviewdetail> reviewList = new ArrayList<>();
    private String productId;
    private String sellerID;
    private String sellerName;
    private String cartId;
    private String userId;
    float selleingPrice = 0;

    int itemQuantityInCart = 0;
    private String sizeid;
    private boolean isFavorite = false;
    private ShopProductDetailActivity context;
    private List<SampleModel> serviceBannerList = new ArrayList<>();
    private UserReviewAdapter userReviewAdapter;

    private List<Review> userReviewList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shop_product_detail_activity);
        binding.ivBack.setOnClickListener(v -> onBackPressed());
        if (getIntent().getExtras() != null) {
            productId = getIntent().getExtras().getString("pid");
        }
        context = this;
        cartId = Preference.getCartId(this)/*.getValue(PrefConstants.CART_ID)*/;
        if (Preference.getUser(context) != null) {
            userId = Preference.getUser(context).getUserId();
        }
        userReviewAdapter = new UserReviewAdapter(this, userReviewList, new CommonListener() {
            @Override
            public void onClicked(int position, int action) {

            }
        });

        binding.rvRatings.setLayoutManager(new LinearLayoutManager(context));
        binding.rvRatings.setAdapter(userReviewAdapter);

        loadData();
    }

    private void loadData() {
        binding.ivCart.setOnClickListener(v -> startActivity(new Intent(context, CartActivity.class)));
        binding.ivAdd.setOnClickListener(v -> {
            if (TextUtils.isEmpty(userId)) {
                Intent intent = new Intent(context, AuthenticateActivity.class);
                intent.putExtra("from", "hjabsj");
                startActivity(intent);
                return;
            }
            itemQuantityInCart++;
            binding.tvQnt.setText("" + itemQuantityInCart);
            binding.tvTotalAmount.setText("\u20B9" + StringUtil.formatZerosAfterDecimal((int) (itemQuantityInCart * selleingPrice)));

            if (itemQuantityInCart > 0) {
                binding.tvBtnAddToCart.setEnabled(true);
            }
        });
        binding.ivMinus.setOnClickListener(v -> {
            if (TextUtils.isEmpty(userId)) {
                Intent intent = new Intent(context, AuthenticateActivity.class);
                startActivity(intent);
                return;
            }

            if (itemQuantityInCart > 1) {
                itemQuantityInCart--;
                binding.tvQnt.setText("" + itemQuantityInCart);

                binding.tvTotalAmount.setText("\u20B9" + StringUtil.formatZerosAfterDecimal((int) (itemQuantityInCart * selleingPrice)));
            }
            if (itemQuantityInCart > 0) {
                binding.tvBtnAddToCart.setEnabled(true);
            } else {
                binding.tvBtnAddToCart.setEnabled(false);
            }
        });

        binding.tvBtnAddToCart.setOnClickListener(v -> {
            cartId = Preference.getCartId(this);
//            String sellerIdIncart = Preference.instance(this).getValue(Preference.SELLER_IN_CART);

            if (TextUtils.isEmpty(userId)) {
                Intent intent = new Intent(context, AuthenticateActivity.class);
                intent.putExtra("from", "nsjbjksd");
                startActivity(intent);
                return;
            } else if (TextUtils.isEmpty(productId)) {
                Toast.makeText(context, "Re-load screen", Toast.LENGTH_LONG).show();
                return;
            }/* else if (TextUtils.isEmpty(sellerIdIncart)) {
                addToCart();
            } *//*else if (sellerIdIncart.equals(sellerID)) {
                addToCart();
            } *//*else {
                askForNewSellerProductsInCart();
            }*/
            addToCart(productId, userId);

        });


        binding.ivFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Preference.getUser(context) != null) {
                    if (isFavorite) {
                        changeFavSttaus(binding.progressBar, binding.ivFav, productId);
                    } else {
                        changeFavSttaus(binding.progressBar, binding.ivFav, productId);
                    }
                } else {
                    Intent intent = new Intent(context, AuthenticateActivity.class);
                    intent.putExtra("from", "najkskjs");
                    context.startActivity(intent);
                }
            }
        });
        binding.rvRatings.setLayoutManager(new LinearLayoutManager(context));
        binding.nsvMain.setVisibility(View.GONE);
        binding.llBottomButtons.setVisibility(View.GONE);
        binding.tvCurrentimage.setVisibility(View.GONE);
        getProductDetail(productId);
        binding.cardReview.setOnClickListener(v -> {
            if (Preference.getUser(context) != null) {
                showRatingDialog();
            } else {
                Intent intent = new Intent(context, AuthenticateActivity.class);
                intent.putExtra("from", "nSJKNckd");
                context.startActivity(intent);
            }
        });

    }

    private void showRatingDialog() {
        Bundle bundle = new Bundle();
        bundle.putString(AddProductRatingFragment.PID, productId);
        bundle.putString(AddProductRatingFragment.UID, userId);
        AddProductRatingFragment fragment = new AddProductRatingFragment();
        fragment.setArguments(bundle);
        fragment.setListener(new CommonListener() {
            @Override
            public void onClicked(int position, int action) {
                if (action == CommonListener.UPDATED) {
                    getProductDetail(productId);
                }
            }
        });
        fragment.show(getSupportFragmentManager(), AddProductRatingFragment.TAG);
    }


    void changeFavSttaus(final ProgressBar progress_bar, final ImageView iv_favourite, String pid) {
        String userId = Preference.getUser(context) != null ? Preference.getUser(context).getUserId() : "";
        if (InternetConnectionCheck.haveNetworkConnection(context)) {
            iv_favourite.setEnabled(false);
            progress_bar.setVisibility(View.VISIBLE);
            AppApi api = NetworkProvider.instance();
            Call<CommonResponse> call = api.addremovefavoriteproduct(pid, /*fav,*/ userId);
            call.enqueue(new Callback<CommonResponse>() {
                @Override
                public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                    progress_bar.setVisibility(View.GONE);
                    CommonResponse res = response.body();
                    if (res.getStatus().equals("200")) {
                        iv_favourite.setEnabled(true);
                        if (isFavorite) {
                            isFavorite = false;
                            iv_favourite.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite));
                        } else {
                            isFavorite = true;
                            iv_favourite.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
                        }

                    } else {
                        Log.d("TAG", "error :" + res.getMsg());
                    }
                }

                @Override
                public void onFailure(Call<CommonResponse> call, Throwable t) {
                    progress_bar.setVisibility(View.GONE);
                    Log.d("TAG", "error :" + t.getMessage());
                }
            });


        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    void getProductDetail(String pid) {
        String userId = Preference.getUser(context) != null ? Preference.getUser(context).getUserId() : "";
        if (InternetConnectionCheck.haveNetworkConnection(context)) {
            binding.progressBar.setVisibility(View.VISIBLE);
            Log.d(TAG, "PID" + pid);
            Log.d(TAG, "CartId" + cartId);
            Log.d(TAG, "uid" + userId);
            AppApi api = NetworkProvider.instance();
            Call<ProductDetailResp> call = api.getProductDetail(pid, cartId, userId);
            call.enqueue(new Callback<ProductDetailResp>() {
                @Override
                public void onResponse(Call<ProductDetailResp> call, Response<ProductDetailResp> response) {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.nsvMain.setVisibility(View.VISIBLE);
                    binding.llBottomButtons.setVisibility(View.VISIBLE);
                    ProductDetailResp res = response.body();
                    if ("200".equals(res.getStatus())) {
                        ProductDetail product = res.getProductList();

                        binding.tvCostPrice.setText("\u20B9" + product.getMrp());
                        binding.tvSellingPrice.setText("\u20B9" + product.getSellingprice());

                        binding.tvProductName.setText("" + StringUtil.capitalizeFirst(product.getProductname()));
                        binding.tvDesc.setText("" + Html.fromHtml(product.getLongdescription()));

                        sellerID = /*product.getId()*/"";
                        sellerName =/*product.getProductname()*/"";
                        int discount = 0;
                        discount = Integer.valueOf(product.getDiscount_percent());

//                        binding.tvSellerName.setText("By: " + sellerName);
                        if ("1".equals(product.getIsrate())) {
                            binding.cardReview.setVisibility(View.VISIBLE);
                        } else {
                            binding.cardReview.setVisibility(View.GONE);
                        }

                        binding.tvCostPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

                        if (discount <= 0)
                            binding.tvCostPrice.setVisibility(View.GONE);
                        else
                            binding.tvCostPrice.setVisibility(View.VISIBLE);

                        if (product.getProductpic() != null && product.getProductpic().size() > 0) {
                            serviceBannerList.clear();
                            for (ProdImage it : product.getProductpic()) {
                                serviceBannerList.add(new SampleModel(it.getImg(), "", ""));
                            }
                            setSlider();
                        } else {
                            binding.tvCurrentimage.setVisibility(View.GONE);
                        }

                        Float ratingValue = 0f;
                        try {
                            if (product.getRating() != null)
                                ratingValue = Float.valueOf(product.getRating());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (ratingValue <= 0) {
                            binding.rbRating.setVisibility(View.GONE);
                            binding.rbRatingReview.setVisibility(View.GONE);
                        } else {
                            binding.rbRating.setRating(ratingValue);
                            binding.rbRatingReview.setRating(ratingValue);
                        }

                        if (TextUtils.isEmpty(String.valueOf("2.5")) || 2.5 == 0) {
                            binding.llRatingDetail.setVisibility(View.GONE);
                        } else {
                            binding.llRatingDetail.setVisibility(View.VISIBLE);
                            binding.tvRating.setText("" + ratingValue);
                        }

                        if (TextUtils.isEmpty(String.valueOf("")) || 4.0 == 0) {
                            binding.tvRatingAndTotalReview.setText("");
                            binding.tvNoOfSold.setText("");
                        } else {
                            binding.tvRatingAndTotalReview.setText("" + 4.0);
                            binding.tvNoOfSold.setText(product.getIn_stock_qty());
                        }

                        try {
                            itemQuantityInCart = Integer.valueOf(product.getCartQnt());
                            binding.tvQnt.setText("" + itemQuantityInCart);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            itemQuantityInCart = 0;
                            binding.tvQnt.setText("" + itemQuantityInCart);
                        }

                        try {
                            selleingPrice = Float.valueOf(product.getSellingprice());
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        if (itemQuantityInCart > 0) {
                            binding.tvBtnAddToCart.setAlpha(.6f);
                            binding.ivAdd.setAlpha(.7f);
                            binding.ivMinus.setAlpha(.7f);
                            binding.tvBtnAddToCart.setEnabled(false);
                            binding.ivAdd.setEnabled(false);
                            binding.ivMinus.setEnabled(false);
                        }
                        if (itemQuantityInCart <= 0) {
                            itemQuantityInCart = 1;
                            binding.tvQnt.setText("" + itemQuantityInCart);
                        }
                        binding.tvTotalAmount.setText("\u20B9" + StringUtil.formatZerosAfterDecimal((int) (itemQuantityInCart * selleingPrice)));

                        binding.ivFav.setEnabled(true);

                        if ("0".equals(product.getIsfav())) {
                            isFavorite = false;
                            binding.ivFav.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite));
                        } else {
                            isFavorite = true;
                            binding.ivFav.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
                        }

     /*   if (res.getProduct().getSizedetails() != null && res.getProduct().getSizedetails().size() > 0) {
            variantList.clear();
            variantList.addAll(res.getProduct().getSizedetails());
            setVarientList();
        } else {
            binding.llVariant.setVisibility(View.GONE);
        }*/
                        getProductReview(productId);
                        CartUtils.getCartDetail(binding.tvCartQntt, context, Preference.getCartId(context));
                    } else {
                        Log.d("TAG", "error :" + res.getMsg());
                    }
                }

                @Override
                public void onFailure(Call<ProductDetailResp> call, Throwable t) {
                    binding.progressBar.setVisibility(View.GONE);
                    Log.d("TAG", "error :" + t.getMessage());
                }
            });


        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void addToCart(String productId, String userID) {
        binding.tvBtnAddToCart.setEnabled(false);
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressBar.setVisibility(View.VISIBLE);
            NetworkProvider.instance().addToCart(productId, cartId, "" + itemQuantityInCart, "Product", userID)
                    .enqueue(new Callback<AddToCartResponse>() {
                        @Override
                        public void onResponse(Call<AddToCartResponse> call, Response<AddToCartResponse> response) {
                            binding.tvBtnAddToCart.setEnabled(true);
                            binding.progressBar.setVisibility(View.GONE);
                            AddToCartResponse resp = response.body();
                            if ("200".equals(resp.getStatus())) {
                                Preference.setCartId(context, resp.getBid());
                                cartId = Preference.getCartId(context);
                                Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                                getProductDetail(productId);
                            } else {
                                Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<AddToCartResponse> call, Throwable t) {
                            binding.progressBar.setVisibility(View.GONE);
                            Log.d(TAG, "" + t.getMessage());
                        }
                    });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void getProductReview(String productId) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            NetworkProvider.instance().getProductReview(productId)
                    .enqueue(new Callback<ProductReviewResp>() {
                        @Override
                        public void onResponse(Call<ProductReviewResp> call, Response<ProductReviewResp> response) {
                            ProductReviewResp resp = response.body();
                            if ("200".equals(resp.getStatus())) {
                                if (resp.getRevlist() != null && resp.getRevlist().size() > 0) {
                                    binding.tvNoRatings.setVisibility(View.GONE);
                                    userReviewList.clear();
                                    userReviewList.addAll(resp.getRevlist());
                                } else {
                                    binding.tvNoRatings.setVisibility(View.VISIBLE);
                                }
                                userReviewAdapter.notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void onFailure(Call<ProductReviewResp> call, Throwable t) {
                            Log.d(TAG, "" + t.getMessage());
                        }
                    });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    private void setSlider() {

        /*TOP BANNERS*/
        serviceDetailPagerAdapter = new ServiceDetailPagerAdapter(context, serviceBannerList);
        binding.vpProductDetail.setAdapter(serviceDetailPagerAdapter);
//        binding.serviceDetailPagerIndicator.setViewPager(binding.serviceDetailViewPager);
        binding.vpProductDetail.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
              /*  final float normalizedposition = Math.abs(Math.abs(position) - 1);
                page.setAlpha(normalizedposition);*/
            }
        });
        binding.vpProductDetail.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                binding.tvCurrentimage.setVisibility(View.VISIBLE);
                binding.tvCurrentimage.setText("" + (position + 1) + "/" + serviceBannerList.size());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



/*
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
        }, DELAY_MS, PERIOD_MS);*/


        if (serviceBannerList.size() > 0) {
            binding.tvCurrentimage.setVisibility(View.VISIBLE);
            binding.tvCurrentimage.setText("" + (1) + "/" + serviceBannerList.size());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        CartUtils.getCartDetail(binding.tvCartQntt, context, Preference.getCartId(context));
    }

}