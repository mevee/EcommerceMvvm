package com.webkype.happiroo.view.activity.shopProduct;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.product_cat.ProdCategory;
import com.webkype.happiroo.controller.network.responses.product_cat.ProdSubCategory;
import com.webkype.happiroo.controller.network.responses.product_cat.ProductCategoryResp;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ActivityShoppingCatBinding;
import com.webkype.happiroo.model.CategoryModel;
import com.webkype.happiroo.view.CommonListener;
import com.webkype.happiroo.view.adapter.shopProduct.ShopCatAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShoppingCatActivity extends AppCompatActivity {
    private static final String TAG = ShoppingCatActivity.class.getName();
    ActivityShoppingCatBinding binding;
    private ShopCatAdapter serviceMainCatAdapter;
    private ShopCatAdapter subCatAdapter;
    private List<CategoryModel> serviceCatList = new ArrayList<>();
    private Context context;

    private String mainCat;
    private String catId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shopping_cat);
        context = this;
        binding.toolbarShoppingCat.ivToolbarBackBtn.setOnClickListener(v -> onBackPressed());
        binding.toolbarShoppingCat.tvToolbarTitle.setText("Shop By Category");

        if (getIntent().getExtras() != null) {
            mainCat = getIntent().getExtras().getString("cat");
            catId = getIntent().getExtras().getString("catId");

        }
        StaggeredGridLayoutManager stg = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        binding.rvCategoryList.setLayoutManager(stg);

        if (!TextUtils.isEmpty(catId)) {
            binding.toolbarShoppingCat.tvToolbarTitle.setText(mainCat);
            setSubCatListView();
        } else {
            setServiceCatListView();
        }

    }

    private void setServiceCatListView() {
        binding.rvCategoryList.setNestedScrollingEnabled(false);
        serviceMainCatAdapter = new ShopCatAdapter(this, serviceCatList, ((position, action) -> {
            if (action == CommonListener.CLICKED) {
                if (serviceCatList.get(position).getIsHaveSubCat().equals("1")){
                    Intent intent = new Intent(this, ShoppingCatActivity.class);
                    intent.putExtra("cat", serviceCatList.get(position).getName());
                    intent.putExtra("catId", serviceCatList.get(position).getCatId());
                    startActivity(intent);
                }else if (serviceCatList.get(position).getIsHaveSubCat().equals("0")){
                    Intent intent = new Intent(this, ProductListActivity.class);
                    intent.putExtra("cat", serviceCatList.get(position).getName());
                     intent.putExtra("catId", serviceCatList.get(position).getCatId());
                    startActivity(intent);
                }

            }
        }));
        binding.rvCategoryList.setFocusable(false);
        binding.rvCategoryList.setAdapter(serviceMainCatAdapter);
        getCategoryList();
    }

    private void setSubCatListView() {
        binding.rvCategoryList.setNestedScrollingEnabled(false);
        subCatAdapter = new ShopCatAdapter(this, serviceCatList, ((position, action) -> {
            if (action == CommonListener.CLICKED) {
                Intent intent = new Intent(this, ProductListActivity.class);
                intent.putExtra("cat", serviceCatList.get(position).getName());
                intent.putExtra("catId", serviceCatList.get(position).getCatId());
                startActivity(intent);
            }
        }));
        binding.rvCategoryList.setFocusable(false);
        binding.rvCategoryList.setAdapter(serviceMainCatAdapter);
        getSubCatList();
    }

    private void getCategoryList() {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressBarShopCat.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getSellCategory().enqueue(new Callback<ProductCategoryResp>() {
                @Override
                public void onResponse(Call<ProductCategoryResp> call, Response<ProductCategoryResp> response) {
                    binding.progressBarShopCat.setVisibility(View.GONE);

                    ProductCategoryResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {

                        if (resp.getCatList() != null && resp.getCatList().size() > 0) {
                            serviceCatList.clear();
                            for (ProdCategory banner : resp.getCatList()) {
                                serviceCatList.add(new CategoryModel(banner.getCatthumb(), banner.getCataname(), banner.getCatid(),banner.getSubcat()));
                            }
                            binding.rvCategoryList.setAdapter(serviceMainCatAdapter);
                        }
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ProductCategoryResp> call, Throwable t) {
                    binding.progressBarShopCat.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }
    private void getSubCatList() {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressBarShopCat.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getSellSubCategory(catId).enqueue(new Callback<ProductCategoryResp>() {
                @Override
                public void onResponse(Call<ProductCategoryResp> call, Response<ProductCategoryResp> response) {
                    binding.progressBarShopCat.setVisibility(View.GONE);
//                    binding.progressBarShopCat.setVisibility(View.VISIBLE);

                    ProductCategoryResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {

                        if (resp.getProductsubcatdeta() != null && resp.getProductsubcatdeta().size() > 0) {
                            serviceCatList.clear();
                            for (ProdSubCategory banner : resp.getProductsubcatdeta()) {
                                serviceCatList.add(new CategoryModel(banner.getCatthumb(), banner.getCataname(), banner.getCatid()));
                            }

                            binding.rvCategoryList.setAdapter(subCatAdapter);
                         }
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ProductCategoryResp> call, Throwable t) {
                    binding.progressBarShopCat.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }


}