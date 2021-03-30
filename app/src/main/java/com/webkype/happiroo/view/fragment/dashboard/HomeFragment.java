package com.webkype.happiroo.view.fragment.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.home_page_resp.Addbanner;
import com.webkype.happiroo.controller.network.responses.home_page_resp.Bannerdetum;
import com.webkype.happiroo.controller.network.responses.home_page_resp.Categorydetum;
import com.webkype.happiroo.controller.network.responses.home_page_resp.HomeApiResp;
import com.webkype.happiroo.controller.network.responses.home_page_resp.Stripdatum;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.FragmentHomeBinding;
import com.webkype.happiroo.model.CategoryModel;
import com.webkype.happiroo.view.activity.ChangeLocationActivity;
import com.webkype.happiroo.view.adapter.HomeBannerAdapter;
import com.webkype.happiroo.view.adapter.HomeServicesAdapter;
import com.webkype.happiroo.view.adapter.HomeStripAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private Context context;

    private HomeBannerAdapter homeBannerAdapter;
    private HomeServicesAdapter homeServicesAdapter;
    private HomeStripAdapter homeStripAdapter;
    private List<CategoryModel> topBannerList = new ArrayList<>();
    private List<CategoryModel> adBannerList = new ArrayList<>();
    private List<CategoryModel> homeServiceList = new ArrayList<>();
    private List<Stripdatum> stripdatumList = new ArrayList<>();
    private FragmentHomeBinding binding;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (Preference.getAddress(context)!=null) {
            binding.homeLocationAddTxt.setText(Preference.getAddress(context).getAddress());
        }

        binding.homeLocationAddLayout.setOnClickListener(v -> {
            startActivity(new Intent(context, ChangeLocationActivity.class));
        });
        binding.homeSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.homeSwipeRefresh.setRefreshing(false);
                getHomeData();
            }
        });
        binding.mainLayout.setVisibility(View.GONE);
        binding.rlShopping.setVisibility(View.GONE);
        getHomeData();

    }

    void setTopBanner() {

        binding.homeBannerViewPager.setFocusable(true);
        binding.homeBannerViewPager.setClipToPadding(false);
        binding.homeBannerViewPager.setPadding(40, 20, 160, 20);
        binding.homeBannerViewPager.setPageMargin(40);
        homeBannerAdapter = new HomeBannerAdapter(context, topBannerList);
        binding.homeBannerViewPager.setAdapter(homeBannerAdapter);

    }

    void setShoppingView() {
        binding.rlShopping.setVisibility(View.VISIBLE);
//        final String imag1 ="https://image.freepik.com/free-vector/elements-online-shopping-flat-style_1085-847.jpg";
//        final String imag2 ="https://st4.depositphotos.com/8696740/26761/v/1600/depositphotos_267614420-stock-illustration-online-shopping-banner-vector-illustration.jpg";
//        adBannerList.clear();
//        adBannerList.add(new CategoryModel(imag2,"","id"));

        binding.homeShoppingPager.setClipToPadding(false);
        binding.homeShoppingPager.setPadding(40, 20, 40, 20);
        binding.homeShoppingPager.setPageMargin(40);
        homeBannerAdapter = new HomeBannerAdapter(context, adBannerList);
        binding.homeShoppingPager.setAdapter(homeBannerAdapter);
        binding.homeAdPagerIndicator.setViewPager(binding.homeShoppingPager);

    }

    void setHomeService() {
        binding.homeServicesRecycler.setNestedScrollingEnabled(false);
        binding.homeServicesRecycler.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        homeServicesAdapter = new HomeServicesAdapter(context, homeServiceList);
        binding.homeServicesRecycler.setAdapter(homeServicesAdapter);
    }

    void setHomeStripAdapter() {
        binding.homeStripRecycler.setNestedScrollingEnabled(false);
        binding.homeStripRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        homeStripAdapter = new HomeStripAdapter(context, stripdatumList);
        binding.homeStripRecycler.setAdapter(homeStripAdapter);

    }

    private void getHomeData() {
        if (InternetConnectionCheck.haveNetworkConnection(getContext())) {
            binding.progressbar.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getHomePageData().enqueue(new Callback<HomeApiResp>() {
                @Override
                public void onResponse(Call<HomeApiResp> call, Response<HomeApiResp> response) {
                    binding.progressbar.setVisibility(View.GONE);
                    binding.mainLayout.setVisibility(View.VISIBLE);

                    HomeApiResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {

                        if (resp.getBannerdeta() != null && resp.getBannerdeta().size() > 0) {
                            topBannerList.clear();
                            for (Bannerdetum detail : resp.getBannerdeta()) {
                                topBannerList.add(new CategoryModel("" + detail.getBanner(), detail.getId(), ""));
                            }
                            setTopBanner();
                        }
                        if (resp.getAddbanner() != null && resp.getAddbanner().size() > 0) {
                            adBannerList.clear();
                            for (Addbanner detail : resp.getAddbanner()) {
                                adBannerList.add(new CategoryModel("" + detail.getBanner(), detail.getId(), ""));
                            }
                            setShoppingView();
                        }
//                            setShoppingView();
                        if (resp.getCategorydeta() != null && resp.getCategorydeta().size() > 0) {
                            homeServiceList.clear();
                            for (Categorydetum detail : resp.getCategorydeta()) {
                                homeServiceList.add(new CategoryModel("" + detail.getCatthumb(), detail.getCataname(), detail.getCatid()));
                            }
                            setHomeService();
                        }
                        if (resp.getStripdata() != null && resp.getStripdata().size() > 0) {
                            stripdatumList.clear();
                            stripdatumList.addAll(resp.getStripdata());
                            setHomeStripAdapter();
                        }

                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<HomeApiResp> call, Throwable t) {
                    binding.progressbar.setVisibility(View.GONE);
                    Log.d("OtpActivity", "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

}
