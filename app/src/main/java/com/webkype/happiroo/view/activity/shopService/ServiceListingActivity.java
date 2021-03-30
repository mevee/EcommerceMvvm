package com.webkype.happiroo.view.activity.shopService;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.category.SubCatListResp;
import com.webkype.happiroo.controller.network.responses.category.Subcat;
import com.webkype.happiroo.controller.network.responses.mservices.ServiceListResp;
import com.webkype.happiroo.controller.network.responses.mservices.Servicelist;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.CartUtils;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ActivityListingBinding;
import com.webkype.happiroo.view.CommonListener;
import com.webkype.happiroo.view.activity.auth.AuthenticateActivity;
import com.webkype.happiroo.view.activity.checout_process.CartActivity;
import com.webkype.happiroo.view.adapter.ListingCatAdapter;
import com.webkype.happiroo.view.adapter.ProductsAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceListingActivity extends AppCompatActivity {

    private static final String TAG = ServiceListingActivity.class.getName();
    private Context context;

    private ListingCatAdapter listingCatAdapter;
    private ProductsAdapter productsAdapter;
    private List<Subcat> serviceCatList = new ArrayList<>();
    private List<Servicelist> productList = new ArrayList<>();

    private String selectedCat;
    private String subCatId;
    private String mainCatId;
    private String cartid;
    ActivityListingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_listing);
        context = ServiceListingActivity.this;
        cartid = Preference.getCartId(context);
        String activeShopping = Preference.getActiveShopping(context);
        if (TextUtils.isEmpty(activeShopping)){
            Preference.setActiveShopping(context, "Service");
        }else if (activeShopping.equals("Product")){
            Preference.setCartId(this,"");
            cartid ="";
            Preference.setActiveShopping(context, "Service");
        }
        init();
    }


    @Override
    public void onBackPressed() {
        finish();
    }

    private void init() {
        if (getIntent().getExtras() != null) {
            selectedCat = getIntent().getStringExtra("selectedCat");
            mainCatId = getIntent().getStringExtra("mainCatId");
            subCatId = getIntent().getStringExtra("subCatId");
        }

        binding.backListing.setOnClickListener(v -> onBackPressed());
        binding.cartListing.setOnClickListener(v -> startActivity(new Intent(context, CartActivity.class)));
        binding.goCartListingLayout.setOnClickListener(v -> startActivity(new Intent(context, CartActivity.class)));

        binding.listingCatRecycler.setNestedScrollingEnabled(false);
        binding.listingCatRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        listingCatAdapter = new ListingCatAdapter(context, serviceCatList, new CommonListener() {
            @Override
            public void onClicked(int position, int action) {
                if (action == CommonListener.CLICKED) {
                    binding.selectedListingServiceTxt.setText(serviceCatList.get(position).getCataname());
                    subCatId = serviceCatList.get(position).getCatid();
                    getSelectedCatServices(subCatId);
                }
            }
        });
        binding.listingCatRecycler.setAdapter(listingCatAdapter);

        binding.productListRecycler.setNestedScrollingEnabled(false);
        binding.productListRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        productsAdapter = new ProductsAdapter(context, productList, new CommonListener() {
            @Override
            public void onClicked(int position, int action) {

                    CartUtils.getCartDetail(binding.tvCartQuantity,context, Preference.getCartId(context));
                if (action == CommonListener.UPDATED) {
                    cartid = Preference.getCartId(context);
                    showCartValue(productList.get(position).getCartQnt());
                } else if (action == CommonListener.CLICKED) {
                    Intent intent = new Intent(context, ServiceProductDetailActivity.class);
                    intent.putExtra("catId", productList.get(position).getId());
                    startActivity(intent);
                } else if (action == CommonListener.NOT_LOGGED) {
                    Intent intent = new Intent(context, AuthenticateActivity.class);
                    intent.putExtra("from", "profile");
                    startActivity(intent);
                } else if (action == CommonListener.REPLACED) {
                    cartid = Preference.getCartId(context);
                    showCartValue(productList.get(position).getCartQnt());
                     getSelectedCatServices(subCatId);
                }
            }
        });

        binding.productListRecycler.setFocusable(false);
        binding.productListRecycler.setAdapter(productsAdapter);

        if (!TextUtils.isEmpty(subCatId)) {
            getSubCatList(mainCatId);
        }
    }

    public void getSubCatList(String parentCategory) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressbarListing.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getSubCatLIst(parentCategory).enqueue(new Callback<SubCatListResp>() {
                @Override
                public void onResponse(Call<SubCatListResp> call, Response<SubCatListResp> response) {
                    binding.progressbarListing.setVisibility(View.GONE);
                    binding.mainListing.setVisibility(View.VISIBLE);
                    SubCatListResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {

                        if (resp.getSubcatlist() != null && resp.getSubcatlist().size() > 0) {
                            serviceCatList.clear();
                            serviceCatList.addAll(resp.getSubcatlist());
                        }
                        listingCatAdapter.notifyDataSetChanged();

                        setSelection();
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<SubCatListResp> call, Throwable t) {
                    binding.progressbarListing.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    void setSelection() {
        for (int i = 0; i < serviceCatList.size(); i++) {
            Subcat subcat = serviceCatList.get(i);
            if (subcat.getCatid().equals(subCatId)) {
                listingCatAdapter.setSelection(i);
            }
        }
    }


    public void getSelectedCatServices(String catId) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressbarListing.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getServices(catId, cartid).enqueue(new Callback<ServiceListResp>() {
                @Override
                public void onResponse(Call<ServiceListResp> call, Response<ServiceListResp> response) {
                    binding.progressbarListing.setVisibility(View.GONE);
                    binding.mainListing.setVisibility(View.VISIBLE);
                    ServiceListResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {

                        if (resp.getServicelist() != null && resp.getServicelist().size() > 0) {
                            productList.clear();
                            productList.addAll(resp.getServicelist());
                        }
                        binding.productListRecycler.setAdapter(productsAdapter);
                     } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ServiceListResp> call, Throwable t) {
                    binding.progressbarListing.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void showCartValue(String quantitiy) {
        binding.tvQuantity.setText("" + quantitiy);
        binding.cartLayoutListing.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        CartUtils.getCartDetail(binding.tvCartQuantity,context, Preference.getCartId(context));

    }
}
