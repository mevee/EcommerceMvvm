package com.webkype.happiroo.view.activity.policyes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.webkype.happiroo.R;

public class TncActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tnc);


        findViewById(R.id.back).setOnClickListener(v ->{onBackPressed();});
        TextView title = findViewById(R.id.tvTnc) ;
//        title.setText(Html.fromHtml(getString(R.string.tnc) ));
    }
}