package com.webkype.happiroo.view.activity.policyes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.webkype.happiroo.R;

public class DisclaimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);
        findViewById(R.id.back).setOnClickListener(v ->{onBackPressed();});

    }
}