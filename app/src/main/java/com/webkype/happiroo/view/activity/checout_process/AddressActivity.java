package com.webkype.happiroo.view.activity.checout_process;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.address.AddressResp;
import com.webkype.happiroo.controller.network.responses.address.Addresslist;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ActivityAddressBinding;
import com.webkype.happiroo.model.User;
import com.webkype.happiroo.view.CommonListener;
import com.webkype.happiroo.view.adapter.AddressAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddressActivity extends AppCompatActivity {

    private static final String TAG = AddressActivity.class.getName();
    private Context context;

    private AddressAdapter addressAdapter;
    private List<Addresslist> mAddressList = new ArrayList<>();
    ActivityAddressBinding binding;
    private User user;
    private String serviceCost;
    private String walletUsed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_address);
        context = AddressActivity.this;
        if (getIntent().getExtras() != null) {
            serviceCost = getIntent().getExtras().getString("serviceCost");
            walletUsed = getIntent().getExtras().getString("walletUsed");
        }
        user = Preference.getUser(this);
        addressAdapter = new AddressAdapter(this, mAddressList, new CommonListener() {
            @Override
            public void onClicked(int position, int action) {
                Addresslist item =  mAddressList.get(position);
                if (action == CLICKED) {
                    String formatedAddress = "City : "+item.getCity();
                    formatedAddress+=",\nState : "+item.getState();
                    formatedAddress+=",\nCountry : "+item.getCountry();
                    formatedAddress+=",\nAddress : "+item.getAddress();
                    formatedAddress+=",\nLandmark : "+item.getLocation();

                    Intent intent = new Intent(context, CovidMessageActivity.class);
                    intent.putExtra("addressId", item.getId());
                    intent.putExtra("walletUsed", walletUsed);
                    intent.putExtra("address", formatedAddress);
                    intent.putExtra("addressType", item.getLocationtype());
                    intent.putExtra("serviceCost", serviceCost);

                    startActivity(intent);
                } else if (action == EDIT) {
                    Addresslist data = mAddressList.get(position);
                    Intent intent = new Intent(context, AddEditAddressActivity.class);
                    intent.putExtra("addressId", data.getId());
                    intent.putExtra("fullName", data.getFullname());
                    intent.putExtra("mobile", data.getMobileno());
                    intent.putExtra("address", data.getAddress());
                    intent.putExtra("locality", data.getLocation());
                    intent.putExtra("type", data.getLocationtype());
                    intent.putExtra("walletUsed", walletUsed);
                    intent.putExtra("country", data.getCountry());
                    intent.putExtra("state", data.getState());
                    intent.putExtra("city", data.getCity());
                     startActivity(intent);
                }
            }
        });
        binding.rvAddressList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvAddressList.setAdapter(addressAdapter);
        binding.mainAddressLayout.setVisibility(View.VISIBLE);
        binding.backAddress.setOnClickListener(v -> onBackPressed());
        binding.addNewAddressRelative.setOnClickListener(v -> startActivity(new Intent(context, AddEditAddressActivity.class)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        getAdressList(user.getUserId());

    }

    public void getAdressList(String userId) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressbarAddress.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getAddressList(userId).enqueue(new Callback<AddressResp>() {
                @Override
                public void onResponse(Call<AddressResp> call, Response<AddressResp> response) {
                    binding.mainAddressLayout.setVisibility(View.VISIBLE);
                    binding.progressbarAddress.setVisibility(View.GONE);
                    AddressResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                         if (resp.getAddresslist() != null && resp.getAddresslist().size() > 0) {
                            mAddressList.clear();
                            mAddressList.addAll(resp.getAddresslist());
                        } else {
                        }
                         addressAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<AddressResp> call, Throwable t) {
                    binding.progressbarAddress.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onBackPressed() {
        finish();
    }
}
