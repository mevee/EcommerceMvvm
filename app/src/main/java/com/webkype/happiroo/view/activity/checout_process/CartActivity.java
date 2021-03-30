package com.webkype.happiroo.view.activity.checout_process;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.cart.CartDetailResp;
import com.webkype.happiroo.controller.network.responses.cart.Productdetail;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ActivityCartBinding;
import com.webkype.happiroo.model.User;
import com.webkype.happiroo.view.CommonListener;
import com.webkype.happiroo.view.activity.PromocodeActivity;
import com.webkype.happiroo.view.activity.auth.AuthenticateActivity;
import com.webkype.happiroo.view.adapter.ProductsInCartAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity {

    private static final String TAG = CartActivity.class.getName();
    private Context context;

    private ProductsInCartAdapter productsInCartAdapter;
    private List<Productdetail> mProductList = new ArrayList<>();
    private ActivityCartBinding binding;
    private User user;
    private String cartId;
    private String serviceCost = "";
    private String walletUsed = "0";
    private String walletAmount = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart);
        context = CartActivity.this;

        user = Preference.getUser(this);
        cartId = Preference.getCartId(this);

        productsInCartAdapter = new ProductsInCartAdapter(this, mProductList, new CommonListener() {
            @Override
            public void onClicked(int position, int action) {
                if (action == UPDATED) {
                    getCartDetail(cartId);
                }
                if (action == DELETED) {
                    getCartDetail(cartId);
                }
            }
        });
        binding.rvItemsInCart.setLayoutManager(new LinearLayoutManager(this));
        binding.rvItemsInCart.setAdapter(productsInCartAdapter);
        binding.backCart.setOnClickListener(chootia -> onBackPressed());
        binding.applyPromoRelative.setOnClickListener(chootia -> startActivity(new Intent(context, PromocodeActivity.class)));
        binding.continueToPayRelative.setOnClickListener(chootia ->
                {
                    Intent intent = new Intent(context, AddressActivity.class);
                    intent.putExtra("serviceCost", serviceCost);
                    intent.putExtra("walletAmount", walletAmount);
                    intent.putExtra("walletUsed", walletUsed);
                    startActivity(intent);
                }
        );

        binding.tvBtnLogin.setOnClickListener(v ->
        {
            Intent intent = new Intent(context, AuthenticateActivity.class);
            intent.putExtra("from", "profile");
            startActivity(intent);
        });

        binding.cbWallet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    walletUsed = "1";
                    getCartDetail(cartId);
                } else {
                    walletUsed = "0";
                    getCartDetail(cartId);
                }
            }
        });

    }


    public void getCartDetail(String cartID) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressbarCart.setVisibility(View.VISIBLE);

            Log.d(TAG, "CartId" + cartID);
            Log.d(TAG, "uid" + user.getUserId());
            NetworkProvider.instance().getCartProducts(cartID, walletUsed, user.getUserId()).enqueue(new Callback<CartDetailResp>() {
                @Override
                public void onResponse(Call<CartDetailResp> call, Response<CartDetailResp> response) {
                    binding.rlContinuePayLayout.setVisibility(View.VISIBLE);
                    binding.mainCart.setVisibility(View.VISIBLE);
                    binding.progressbarCart.setVisibility(View.GONE);
                    CartDetailResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {

                        binding.tvWalletBalance.setText("Balance: \u20B9" + resp.getUserwallet());
                        if ("0".equals(resp.getUserwallet())) {
                            binding.rlWallet.setVisibility(View.GONE);
                            binding.costDistrLayout.walletCreditLay.setVisibility(View.GONE);
                        }

                        binding.tvYouUsed.setText("\u20B9" + resp.getUsewalletamount());
                        binding.costDistrLayout.cartTotal.setText("\u20B9" + resp.getTotalcost());
                        binding.costDistrLayout.discountTV.setText("\u20B9" + resp.getDiscountvalue());

                        binding.costDistrLayout.walletPointsTV.setText("\u20B9" + resp.getUsewalletamount());

                        try {
                            serviceCost = String.valueOf(resp.getFinalamount());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        binding.costDistrLayout.tvAmtToBePaid.setText("\u20B9" + serviceCost);
                        binding.tvToBePaid.setText("Total: \u20B9" + serviceCost);
                        binding.costDistrLayout.otherChargesLay.setVisibility(View.GONE);

                        if ("0".equals(resp.getUsewalletamount())) {
                            binding.costDistrLayout.walletCreditLay.setVisibility(View.GONE);
                        } else {
                            binding.costDistrLayout.walletCreditLay.setVisibility(View.VISIBLE);
                        }

                        if (resp.getProductdetails() != null && resp.getProductdetails().size() > 0) {
                            mProductList.clear();
                            mProductList.addAll(resp.getProductdetails());
                        } else {
                        }
                        productsInCartAdapter.notifyDataSetChanged();
                    } else if ("400".equals(resp.getStatus())) {
                        Preference.setCartId(context, "");
                        onStart();
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CartDetailResp> call, Throwable t) {
                    binding.progressbarCart.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        cartId = Preference.getCartId(this);
        binding.mainCart.setVisibility(View.GONE);
        binding.rlContinuePayLayout.setVisibility(View.GONE);

        if (user != null) {
            binding.llNotLogged.setVisibility(View.GONE);
            if (!TextUtils.isEmpty(cartId)) {
                getCartDetail(cartId);
            } else {
                binding.llEmptyCart.setVisibility(View.VISIBLE);
            }
        } else {
            binding.llNotLogged.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
