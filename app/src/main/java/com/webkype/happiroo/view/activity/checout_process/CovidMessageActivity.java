package com.webkype.happiroo.view.activity.checout_process;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.pref.Preference;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CovidMessageActivity extends AppCompatActivity {

    private Context context;
    @BindView(R.id.covidAgree_rB)
    RadioButton covidAgree_rB;
    private String addressId;
    private String address;
    private String addressType;
    private String serviceCost;
    private String walletUsed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_message);
        if (getIntent().getExtras() != null) {
            addressId = getIntent().getExtras().getString("addressId");
            address = getIntent().getExtras().getString("address");
            addressType = getIntent().getExtras().getString("addressType");
            serviceCost = getIntent().getExtras().getString("serviceCost");
            walletUsed = getIntent().getExtras().getString("walletUsed");
        }
        context = CovidMessageActivity.this;
        ButterKnife.bind(this);
    }

    @OnClick({R.id.backMessage, R.id.covidIAgreeRelative})
    void onClick(View view) {
        switch (view.getId()) {

            case R.id.backMessage:

                onBackPressed();
                break;

            case R.id.covidIAgreeRelative:

                if (covidAgree_rB.isChecked()) {
                    String activeShopping = Preference.getActiveShopping(context);
                    if ("Service".equals(activeShopping)) {
                        Intent intent = new Intent(context, SelectSlotActivity.class);
                        intent.putExtra("addressId", addressId);
                        intent.putExtra("address", address);
                        intent.putExtra("walletUsed", walletUsed);
                        intent.putExtra("addressType", addressType);
                        intent.putExtra("serviceCost", serviceCost);
                        startActivity(intent);
                    } else if ("Product".equals(activeShopping)) {
                        Intent intent = new Intent(context, CartOverviewActivity.class);
                        intent.putExtra("date", "");
                        intent.putExtra("time", "");
                        intent.putExtra("addressId", addressId);
                        intent.putExtra("address", address);
                        intent.putExtra("walletUsed", walletUsed);
                        intent.putExtra("addressType", addressType);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(context, "Please agree to the above", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    @Override
    public void onBackPressed() {
        this.finish();
    }
}
