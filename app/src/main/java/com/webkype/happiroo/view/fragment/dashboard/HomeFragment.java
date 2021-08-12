package com.webkype.happiroo.view.fragment.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.home_page_resp.Addbanner;
import com.webkype.happiroo.controller.network.responses.home_page_resp.BannerVieodetum;
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
import com.webkype.happiroo.view.adapter.HomeVideoAdapter;
import com.webkype.happiroo.view.adapter.StripAddvertAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Math.abs;

public class HomeFragment extends Fragment {

    private Context context;

    private HomeVideoAdapter homeVideoAdapter;
    private HomeBannerAdapter homeBannerAdapter;
    private HomeServicesAdapter homeServicesAdapter;
    private HomeStripAdapter homeStripAdapter;
    private HomeBannerAdapter addAdapter;
    private List<CategoryModel> topBannerList = new ArrayList<>();
    private List<CategoryModel> videoBannerList = new ArrayList<>();
    private List<CategoryModel> homeServiceList = new ArrayList<>();
    private List<Stripdatum> stripdatumList = new ArrayList<>();
    private List<CategoryModel> addvertiseList = new ArrayList<>();
    private FragmentHomeBinding binding;

    private int currentPage = 1;
    private Timer timer = null;
    private long delayInMillis = 2000; //delay in milliseconds before task is to be executed
    private long periodInMillis = 4000;
    // time in milliseconds between successive task executions.

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

        if (Preference.getAddress(context) != null) {
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
        homeBannerAdapter = new HomeBannerAdapter(context, topBannerList);
        binding.homeBannerViewPager.setAdapter(homeBannerAdapter);
        viewPagerAnimation();
    }

    private void viewPagerAnimation() {
        homeBannerAdapter.notifyDataSetChanged();
//        binding.homePagerIndicator.setViewPager(binding.homeBannerViewPager)''

//        val transformer = CompositePageTransformer()
//        CompositePageTransformer transformer = new CompositePageTransformer();
//        transformer.addTransformer(new MarginPageTransformer(16));
//        transformer.addTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull @org.jetbrains.annotations.NotNull View page, float position) {
//                float v = 1 - abs(position);
//                page.setScaleY(0.8f + v * 0.2f);
//            }
//        });
//
//        binding.homeBannerViewPager.setPageTransformer(true,transformer);

        timer = new Timer();

        Handler handler = new Handler();

        Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == topBannerList.size()) {
                    currentPage = 0;
                }
                binding.homeBannerViewPager.setCurrentItem(currentPage++, true);

            }
        };

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, delayInMillis, periodInMillis);
    }


    void setVideoView() {
        binding.rlShopping.setVisibility(View.VISIBLE);
        homeVideoAdapter = new HomeVideoAdapter(context, videoBannerList);
        binding.homeVideoPager.setNestedScrollingEnabled(false);
        binding.homeVideoPager.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        binding.homeVideoPager.setAdapter(homeVideoAdapter);


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

    void setAddStripAdapter() {
        binding.addvertiseRecycler.setFocusable(true);
        binding.addvertiseRecycler.setClipToPadding(false);
        addAdapter = new HomeBannerAdapter(context, addvertiseList);
        binding.addvertiseRecycler.setAdapter(addAdapter);
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
                                topBannerList.add(new CategoryModel("" + detail.getBanner(), detail.getId(), detail.getId()));
                            }
                            setTopBanner();
                        }
                        if (resp.getAddbanner() != null && resp.getAddbanner().size() > 0) {
                            addvertiseList.clear();
                            for (Addbanner detail : resp.getAddbanner()) {
                                addvertiseList.add(new CategoryModel("" + detail.getBanner(), detail.getId(), detail.getId()));
                            }
                            setAddStripAdapter();
                        }


                        if (resp.getBanner_video() != null && resp.getBanner_video().size() > 0) {
                            videoBannerList.clear();
                            for (BannerVieodetum detail : resp.getBanner_video()) {
                                videoBannerList.add(new CategoryModel("" + detail.getBanner(), detail.getBanner_vid(), detail.getId()));
                            }
                            setVideoView();
                        }

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
