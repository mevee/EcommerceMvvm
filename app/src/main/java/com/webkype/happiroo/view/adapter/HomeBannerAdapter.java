package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.webkype.happiroo.R;
import com.webkype.happiroo.model.CategoryModel;
import com.webkype.happiroo.view.activity.shopProduct.ShoppingCatActivity;

import java.util.List;

public class HomeBannerAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<CategoryModel> topBannerList;

    public HomeBannerAdapter(Context context, List<CategoryModel> topBannerList) {
        this.mContext = context;
        this.mLayoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.topBannerList = topBannerList;
    }

    @Override
    public int getCount() {
        return (topBannerList != null ? topBannerList.size() : 0);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((CardView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_banner_layout, container, false);

        final ImageView imageView =  itemView.findViewById(R.id.iv_slider);
        final TextView bannerTxt = itemView.findViewById(R.id.bannerTxt);
        final ProgressBar bannersProgressBar = itemView.findViewById(R.id.bannersProgressBar);

        final CategoryModel topBanner = topBannerList.get(position);

        Glide.with(mContext).load(topBanner.getImage())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        bannersProgressBar.setVisibility(View.GONE);
                        imageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.image_placeholder));
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        bannersProgressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("id".equals(topBanner.getCatId())){
//                    mContext.startActivity(new Intent(mContext, ShoppingCatActivity.class));
                }
            }
        });

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((CardView) object);
    }
}
