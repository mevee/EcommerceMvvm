package com.webkype.happiroo.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.webkype.happiroo.R;
import com.webkype.happiroo.model.NotoficationModel;
import com.webkype.happiroo.view.adapter.PromoCodeAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PromocodeActivity extends AppCompatActivity {

    private Context context;
    @BindView(R.id.rv_promo_code_list)
    RecyclerView rv_promo_code_list;
    private PromoCodeAdapter promoCodeAdapter;
    private List<NotoficationModel> mPromoCodeList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promocode);
        context = PromocodeActivity.this;
        ButterKnife.bind(this);

        mPromoCodeList.add(new NotoficationModel());
        mPromoCodeList.add(new NotoficationModel());
        promoCodeAdapter = new PromoCodeAdapter(this,mPromoCodeList);
        rv_promo_code_list.setLayoutManager(new LinearLayoutManager(this));
        rv_promo_code_list.setAdapter(promoCodeAdapter);

    }

    @OnClick({R.id.backPromo, R.id.applyPromoCodeRelativeBtn})
    void onClick(View view) {
        switch (view.getId()) {

            case R.id.backPromo:

                onBackPressed();
                break;

            case R.id.applyPromoCodeRelativeBtn:

                onBackPressed();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
