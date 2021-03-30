package com.webkype.happiroo.view.activity;

import android.content.Context;
import android.os.Bundle;

import com.webkype.happiroo.R;
import com.webkype.happiroo.model.SampleModel;
import com.webkype.happiroo.view.adapter.ImagePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImagePagerActivity extends AppCompatActivity {

    private Context context;
    @BindView(R.id.zoomImagePager)
    ViewPager zoomImagePager;
    private List<SampleModel> rateCardList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_pager);
        context = ImagePagerActivity.this;
        ButterKnife.bind(this);
        if (getIntent().getExtras() != null) {
            rateCardList = (ArrayList<SampleModel>) getIntent().getSerializableExtra("imageList");

        }
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(this, rateCardList);
        zoomImagePager.setAdapter(imagePagerAdapter);
    }

    @OnClick(R.id.backImagePager)
    void backImagePager() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        finish();
    }


}
