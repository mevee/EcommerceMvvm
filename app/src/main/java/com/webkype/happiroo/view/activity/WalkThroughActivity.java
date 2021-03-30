package com.webkype.happiroo.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.view.activity.auth.AuthenticateActivity;
import com.webkype.happiroo.view.adapter.WelcomePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.relex.circleindicator.CircleIndicator;

public class WalkThroughActivity extends AppCompatActivity {

    private Context context;
    private List<Integer> pagerList = new ArrayList<>();
    private WelcomePagerAdapter welcomePagerAdapter;

    @BindView(R.id.welcomeViewPager)
    ViewPager welcomeViewPager;
    @BindView(R.id.welcomePagerIndicator)
    CircleIndicator welcomePagerIndicator;
    @BindView(R.id.btnWelcomeTxt)
    TextView btnWelcomeTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_through);
        context = WalkThroughActivity.this;
        ButterKnife.bind(this);

        String isThisScreenVisitedAlready = Preference.getFirstLogin(context);

        if ("1".equals(isThisScreenVisitedAlready)) {
            if (Preference.getUser(this) != null) {
                startActivity(new Intent(context, FetchLocationActivity.class));

            } else {
                startActivity(new Intent(context, AuthenticateActivity.class));
            }
            finish();
        }

        init();
    }

    @OnClick({R.id.skipWelcome_tV, R.id.btnWelcomeCard})
    void onClick(View view) {
        switch (view.getId()) {

            case R.id.skipWelcome_tV:
                Preference.setFirstLogin(context, "1");
                startActivity(new Intent(context, AuthenticateActivity.class));
                finish();
                break;

            case R.id.btnWelcomeCard:

                int current = getItem(+1);
                if (current < pagerList.size()) {
                    welcomeViewPager.setCurrentItem(current);
                } else {
                    Preference.setFirstLogin(context, "1");
                    startActivity(new Intent(context, AuthenticateActivity.class));
                    finish();
                }
                break;
        }
    }


    private void init() {
        pagerList.clear();
        pagerList.add(R.drawable.slider1);
        pagerList.add(R.drawable.slider2);
        pagerList.add(R.drawable.slider3);
        pagerList.add(R.drawable.slider4);

        welcomePagerAdapter = new WelcomePagerAdapter(this, pagerList);
        welcomeViewPager.setAdapter(welcomePagerAdapter);
        welcomePagerIndicator.setViewPager(welcomeViewPager);
        welcomeViewPager.setOnPageChangeListener(viewPagerPageChangeListener);
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {

            if (position == pagerList.size() - 1) {
                btnWelcomeTxt.setText("Start");
            } else {
                btnWelcomeTxt.setText("Next");
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private int getItem(int i) {
        return welcomeViewPager.getCurrentItem() + i;
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }
}
