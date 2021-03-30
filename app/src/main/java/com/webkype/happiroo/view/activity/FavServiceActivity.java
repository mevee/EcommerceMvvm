package com.webkype.happiroo.view.activity;

import android.os.Bundle;

import com.webkype.happiroo.R;
import com.webkype.happiroo.view.fragment.dashboard.FavFragment;

import androidx.appcompat.app.AppCompatActivity;

public class FavServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_service);

        getSupportFragmentManager().beginTransaction().add(R.id.fsvServiceHost, new FavFragment(), "FavFragment")
                .commit();
    }

    @Override
    public void onBackPressed() {
        int backEntry = getSupportFragmentManager().getBackStackEntryCount();
        if (backEntry >= 1) {
            finish();
        } else
            super.onBackPressed();


    }
}