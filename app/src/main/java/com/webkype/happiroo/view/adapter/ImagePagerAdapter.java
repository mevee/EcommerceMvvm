package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.webkype.happiroo.R;
import com.webkype.happiroo.model.SampleModel;

import java.util.List;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ImagePagerAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<SampleModel> imageLists;

    public ImagePagerAdapter(Context context, List<SampleModel> imageLists) {
        this.mContext = context;
        this.mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.imageLists = imageLists;
    }

    @Override
    public int getCount() {
        return this.imageLists.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.slider_layout, container, false);
        ImageView sliderImage = itemView.findViewById(R.id.sliderImageView);

        Glide.with(mContext).load(imageLists.get(position).getImage())

                .into(sliderImage);


        try {
            PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(sliderImage);
            photoViewAttacher.update();
            photoViewAttacher.setScaleType(ImageView.ScaleType.MATRIX);
            photoViewAttacher.setMinimumScale(0f);
        } catch (Exception e) {
            e.printStackTrace();
        }

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
