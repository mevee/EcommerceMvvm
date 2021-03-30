package com.webkype.happiroo.view.activity.shopProduct;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.product_list.Product;
import com.webkype.happiroo.controller.network.responses.product_list.ProductListResp;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.CartUtils;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ActivityFavProductListBinding;
import com.webkype.happiroo.model.SortModel;
import com.webkype.happiroo.view.CommonListener;
import com.webkype.happiroo.view.adapter.shopProduct.ItemAdapter;
import com.webkype.happiroo.view.fragment.ProductsFilterFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavProductListActivity extends AppCompatActivity {
    private static final String TAG = FavProductListActivity.class.getName();
    ActivityFavProductListBinding binding;
    private ItemAdapter itemAdapter;
    private List<Product> productdetailList = new ArrayList<>();
    private Context context;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fav_product_list);
        context = this;
        userId = Preference.getUser(this) != null ? Preference.getUser(this).getUserId() : "";

        binding.toolbarFavList.tvToolbarTitle.setText("My Favourite Products");
        Log.d(TAG, "CartId" + Preference.getCartId(this));
        Log.d(TAG, "uid" + userId);

        binding.toolbarFavList.ivToolbarBackBtn.setOnClickListener(v -> onBackPressed());
        itemAdapter = new ItemAdapter(this, productdetailList, new CommonListener() {
            @Override
            public void onClicked(int position, int action) {
                if (action == CommonListener.CLICKED) {
                     goToDetailPage(productdetailList.get(position).getId());
                }
            }
        });
        StaggeredGridLayoutManager stlm12 = new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL);
        binding.rvMore.setVisibility(View.VISIBLE);
        binding.rvMore.setLayoutManager(stlm12);
        binding.rvMore.setFocusable(false);
        binding.rvMore.setAdapter(itemAdapter);

        getProductList();
    }

    private void goToDetailPage(String pid) {
        Intent intent = new Intent(this, ShopProductDetailActivity.class);
        intent.putExtra("pid", pid);
        startActivity(intent);
    }

    private void getProductList() {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressBarProductList.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getFavProductLIst( userId).enqueue(new Callback<ProductListResp>() {
                @Override
                public void onResponse(Call<ProductListResp> call, Response<ProductListResp> response) {
                    binding.progressBarProductList.setVisibility(View.GONE);

                    ProductListResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {

                        if (resp.getProductList() != null && resp.getProductList().size() > 0) {
                            binding.noDataView.setVisibility(View.GONE);
                            productdetailList.clear();
                            productdetailList.addAll(resp.getProductList());
                            binding.progressBarProductList.setVisibility(View.GONE);
                        } else {
                            productdetailList.clear();
                            binding.noDataView.setVisibility(View.VISIBLE);
                        }
                        itemAdapter.notifyDataSetChanged();

                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ProductListResp> call, Throwable t) {
                    binding.progressBarProductList.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }




}