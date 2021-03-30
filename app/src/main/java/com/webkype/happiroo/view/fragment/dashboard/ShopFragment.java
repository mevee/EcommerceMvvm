package com.webkype.happiroo.view.fragment.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.product_cat.ProdCategory;
import com.webkype.happiroo.controller.network.responses.product_cat.ProdSubCategory;
import com.webkype.happiroo.controller.network.responses.product_cat.ProductCategoryResp;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.FragmentShopBinding;
import com.webkype.happiroo.model.CategoryModel;
import com.webkype.happiroo.view.CommonListener;
import com.webkype.happiroo.view.activity.shopProduct.ProductListActivity;
import com.webkype.happiroo.view.activity.shopProduct.ShoppingCatActivity;
import com.webkype.happiroo.view.adapter.shopProduct.ShopCatAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopFragment extends Fragment {
    public static final String TAG = ShopFragment.class.getName();
    private Context context;
    private FragmentShopBinding binding;
    private ShopCatAdapter serviceMainCatAdapter;
    private List<CategoryModel> serviceCatList = new ArrayList<>();


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentShopBinding.inflate(inflater, container, false);

        serviceMainCatAdapter = new ShopCatAdapter(getContext(), serviceCatList, ((position, action) -> {
            if (action == CommonListener.CLICKED) {
                if (serviceCatList.get(position).getIsHaveSubCat().equals("1")) {
                    Intent intent = new Intent(getContext(), ShoppingCatActivity.class);
                    intent.putExtra("cat", serviceCatList.get(position).getName());
                    intent.putExtra("catId", serviceCatList.get(position).getCatId());
                    startActivity(intent);
                } else if (serviceCatList.get(position).getIsHaveSubCat().equals("0")) {
                    Intent intent = new Intent(getContext(), ProductListActivity.class);
                    intent.putExtra("cat", serviceCatList.get(position).getName());
                    intent.putExtra("catId", serviceCatList.get(position).getCatId());
                    startActivity(intent);
                }

            }
        }));
        StaggeredGridLayoutManager stg = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        binding.rvShopCat.setLayoutManager(stg);
        binding.rvShopCat.setFocusable(false);
        binding.rvShopCat.setAdapter(serviceMainCatAdapter);
        getSubCatList();
        return binding.getRoot();
    }


    private void getSubCatList() {
        if (InternetConnectionCheck.haveNetworkConnection(getContext())) {
            binding.progressbarShopFrag.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getSellCategory().enqueue(new Callback<ProductCategoryResp>() {
                @Override
                public void onResponse(Call<ProductCategoryResp> call, Response<ProductCategoryResp> response) {
                    binding.progressbarShopFrag.setVisibility(View.GONE);

                    ProductCategoryResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        if (resp.getCatList() != null && resp.getCatList().size() > 0) {
                            serviceCatList.clear();
                            for (int i = 0; i < resp.getCatList().size(); i++) {
                                ProdCategory banner = resp.getCatList().get(i);
                                serviceCatList.add(new CategoryModel(banner.getCatthumb(), banner.getCataname(), banner.getCatid(),banner.getSubcat()));
                             }
                        }
                        serviceMainCatAdapter.notifyDataSetChanged();
//                            binding.rvShopCat.setAdapter(serviceMainCatAdapter);
                    } else {
                        Toast.makeText(getContext(), "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ProductCategoryResp> call, Throwable t) {
                    binding.progressbarShopFrag.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(getContext(), "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

}
