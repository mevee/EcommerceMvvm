package com.webkype.happiroo.view.activity.shopService;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.category.Bannerimage;
import com.webkype.happiroo.controller.network.responses.category.Categorydetails;
import com.webkype.happiroo.controller.network.responses.category.CatgoryDetailResp;
import com.webkype.happiroo.controller.network.responses.category.Ratecardsimgdetum;
import com.webkype.happiroo.controller.network.responses.category.ServiceCategory;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.CartUtils;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ActivityServiceDetailBinding;
import com.webkype.happiroo.model.CategoryModel;
import com.webkype.happiroo.model.SampleModel;
import com.webkype.happiroo.view.CommonListener;
import com.webkype.happiroo.view.activity.ImagePagerActivity;
import com.webkype.happiroo.view.activity.checout_process.CartActivity;
import com.webkype.happiroo.view.adapter.RateCardAdapter;
import com.webkype.happiroo.view.adapter.ServiceCatAdapter;
import com.webkype.happiroo.view.adapter.ServiceDetailPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceDetailActivity extends AppCompatActivity {

    private static final String TAG = ServiceDetailActivity.class.getName();
    private Context context;
    private ActivityServiceDetailBinding binding;
    private ServiceDetailPagerAdapter serviceDetailPagerAdapter;
    private ServiceCatAdapter serviceCatAdapter;
    private RateCardAdapter rateCardAdapter;
    private List<SampleModel> serviceBannerList = new ArrayList<>();
    private List<CategoryModel> serviceCatList = new ArrayList<>();
    private List<SampleModel> rateCardList = new ArrayList<>();
    private SimpleExoPlayer player;

    int currentPage = 0;
    Timer timer;
    long DELAY_MS = 2000;//delay in milliseconds before task is to be executed
    long PERIOD_MS = 4000; // time in milliseconds between successive task executions.
    private String catId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_service_detail);
        context = ServiceDetailActivity.this;
        if (getIntent().getExtras() != null) {
            catId = getIntent().getExtras().getString("catId");
        }

        binding.backServiceDetail.setOnClickListener(v -> {
            onBackPressed();

        });
        binding.cartServiceDetail.setOnClickListener(v -> {
            startActivity(new Intent(context, CartActivity.class));
        });
        binding.mainServiceDetail.setVisibility(View.GONE);
        getServiceDetail();
    }

    private void setHeaderVideoView(String videoLink) {
        Uri uri = Uri.parse(videoLink);
        MediaItem mediaItem = MediaItem.fromUri(uri);
        player = new SimpleExoPlayer.Builder(this).build();
        binding.headerVideoPlayer.setPlayer(player);
        player.addMediaItem(mediaItem);
        player.addListener(new Player.EventListener() {
            @Override
            public void onPlaybackStateChanged(int playbackState) {
                String stateString;
                switch (playbackState) {
                    case ExoPlayer.STATE_IDLE:
                        stateString = "ExoPlayer.STATE_IDLE      -";
                        break;
                    case ExoPlayer.STATE_BUFFERING:
                        binding.pbVideo.setVisibility(View.VISIBLE);
                        stateString = "ExoPlayer.STATE_BUFFERING -";
                        break;
                    case ExoPlayer.STATE_READY:
                        binding.pbVideo.setVisibility(View.GONE);
                        binding.rlIndicatorHolder.setVisibility(View.GONE);
                        binding.serviceDetailViewPager.setVisibility(View.GONE);
                        binding.headerVideoPlayer.setVisibility(View.VISIBLE);
                        player.setRepeatMode(Player.REPEAT_MODE_ALL);
                        stateString = "ExoPlayer.STATE_READY     -";
                        break;
                    case ExoPlayer.STATE_ENDED:
                        binding.pbVideo.setVisibility(View.GONE);
                        stateString = "ExoPlayer.STATE_ENDED     -";
                        break;
                    default:
                        stateString = "UNKNOWN_STATE             -";
                        break;
                }
                Log.d(TAG, "changed state to " + stateString);
            }
        });
        player.prepare();
        player.setVolume(0f);
        player.setPlayWhenReady(true);

//        binding.headerVideoPlayer.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_ZOOM);
        player.setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
        /* binding.rlIndicatorHolder.setVisibility(View.GONE);
                binding.serviceDetailViewPager.setVisibility(View.GONE);
                binding.headerVideoPlayer.setVisibility(View.VISIBLE);*/
    }


    @Override
    protected void onStart() {
        super.onStart();
        CartUtils.getCartDetail(binding.tvCartQuantity, context, Preference.getCartId(context));
    }

    private void getServiceDetail() {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressBarServiceDetail.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getCategoryDetail(catId).enqueue(new Callback<CatgoryDetailResp>() {
                @Override
                public void onResponse(Call<CatgoryDetailResp> call, Response<CatgoryDetailResp> response) {
                    binding.progressBarServiceDetail.setVisibility(View.GONE);
                    binding.mainServiceDetail.setVisibility(View.VISIBLE);

                    CatgoryDetailResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        Categorydetails detail = resp.getCategorydetails();

                        binding.tvTitleServiceDetail.setText(detail.getCategoryname());

                        if (!TextUtils.isEmpty(detail.getVideo())){
                            setHeaderVideoView(detail.getVideo());
                        }else if(detail.getBannerimages() != null && detail.getBannerimages().size() > 0) {
                            serviceBannerList.clear();
                            for (Bannerimage banner : detail.getBannerimages()) {
                                serviceBannerList.add(new SampleModel("" + banner.getBanerimgs(), banner.getId(), ""));
                            }
                            setTopBanner();
                        }

                        if (TextUtils.isEmpty(detail.getBelowbanner())) {
                            binding.serviceDetailAdImage.setVisibility(View.GONE);
                        } else {
                            /*SERVICE AD BANNER*/
                            Glide.with(context).load(detail.getBelowbanner())
                                    .thumbnail(Glide.with(context).load(R.drawable.image_placeholder))
                                    .transform(new CenterInside(), new RoundedCorners(16))
                                    .into(binding.serviceDetailAdImage);
                        }

                        if (TextUtils.isEmpty(detail.getHowwedo())) {
                            binding.llVideoDetail.setVisibility(View.GONE);
                        } else {
                            setVideoView(detail.getHowwedo());
                        }


                        if (detail.getSubcategorydetails() != null && detail.getSubcategorydetails().size() > 0) {
                            serviceCatList.clear();
                            for (ServiceCategory banner : detail.getSubcategorydetails()) {
                                serviceCatList.add(new CategoryModel("" + banner.getBanerimgs(), banner.getSubcatname(), banner.getId()));
                            }
                            setServiceCatListView();
                        }

                        if (detail.getRatecardsimgdeta() != null && detail.getRatecardsimgdeta().size() > 0) {
                            rateCardList.clear();
                            for (Ratecardsimgdetum banner : detail.getRatecardsimgdeta()) {
                                rateCardList.add(new SampleModel("" + banner.getBanerimgs(), banner.getId(), ""));
                            }
                            setRateCardList();
                        } else {
                            binding.tvRateCardTile.setVisibility(View.GONE);
                        }

                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CatgoryDetailResp> call, Throwable t) {
                    binding.progressBarServiceDetail.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    private void setRateCardList() {

        /*RATE CARD*/
        binding.rateCardRecycler.setNestedScrollingEnabled(false);
        binding.rateCardRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        rateCardAdapter = new RateCardAdapter(context, rateCardList, (position, action) -> {
            if (action == CommonListener.CLICKED) {
                Intent intent = new Intent(context, ImagePagerActivity.class);
                intent.putParcelableArrayListExtra("imageList", (ArrayList<? extends Parcelable>) rateCardList);
                startActivity(intent);
            }
        });
        binding.rateCardRecycler.setFocusable(false);
        binding.rateCardRecycler.setAdapter(rateCardAdapter);

    }

    private void setServiceCatListView() {
        /*SUB CATEGORY*/
        binding.serviceCatRecycler.setNestedScrollingEnabled(false);
        binding.serviceCatRecycler.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        serviceCatAdapter = new ServiceCatAdapter(context, serviceCatList, ((position, action) -> {
            if (action == CommonListener.CLICKED) {
                Intent intent = new Intent(context, ServiceListingActivity.class);
                intent.putExtra("selectedCat", serviceCatList.get(position).getName());
                intent.putExtra("mainCatId", catId);
                intent.putExtra("subCatId", serviceCatList.get(position).getCatId());
                context.startActivity(intent);
            }
        }));
        binding.serviceCatRecycler.setFocusable(false);
        binding.serviceCatRecycler.setAdapter(serviceCatAdapter);

    }


    private void setVideoView(String videoLink) {

        /*SERVICE SAMPLE VIDEO*/
        Uri uri = Uri.parse(videoLink);
        binding.serviceDetailSampleVideo.setVideoURI(uri);
        binding.serviceDetailSampleVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0f, 0f);
                mp.setLooping(true);
            }
        });
//        binding.serviceDetailSampleVideo.setFocusable(false);
        binding.serviceDetailSampleVideo.start();
        binding.serviceDetailSampleVideo.setFocusable(false);

    }

    private void setTopBanner() {
        /*TOP BANNERS*/
        serviceDetailPagerAdapter = new ServiceDetailPagerAdapter(context, serviceBannerList);
        binding.serviceDetailViewPager.setAdapter(serviceDetailPagerAdapter);
        binding.serviceDetailPagerIndicator.setViewPager(binding.serviceDetailViewPager);
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


    @Override
    public void onBackPressed() {
        finish();
    }


}
