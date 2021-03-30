package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.webkype.happiroo.R;
import com.webkype.happiroo.model.SampleModel;

import java.util.List;

public class ServiceDetailPagerAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<SampleModel> topBannerList;

    public ServiceDetailPagerAdapter(Context context, List<SampleModel> topBannerList) {
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
        return view == ((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        final ImageView imageView =  itemView.findViewById(R.id.pager_iV);

        final SampleModel topBanner = topBannerList.get(position);

        Glide.with(mContext).load(topBanner.getImage())
                .thumbnail(Glide.with(mContext).load(R.drawable.image_placeholder))
                .into(imageView);


        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}

