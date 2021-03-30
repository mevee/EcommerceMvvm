package com.webkype.happiroo.view.activity.checout_process;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.CommonResponse;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ActivityAddEditAddressBinding;
import com.webkype.happiroo.model.SelectModel;
import com.webkype.happiroo.model.User;
import com.webkype.happiroo.view.CommonListener;
import com.webkype.happiroo.view.adapter.SelectItemAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEditAddressActivity extends AppCompatActivity {

    private static final String TAG = AddEditAddressActivity.class.getName();
    private Context context;


    private SelectItemAdapter selectAdressTypeAdapter;
    private List<SelectModel> mAdressTypeList = new ArrayList<>();
    private String addressId;
    private String name;
    private String country;
    private String state;
    private String city;
    private String mobile;
    private String locality;
    private String address;
    private String type;
    private String walletUsed;
    private String option;
    ActivityAddEditAddressBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_edit_address);
        context = AddEditAddressActivity.this;
        if (getIntent().getExtras() != null) {
            addressId = getIntent().getExtras().getString("addressId");
            name = getIntent().getExtras().getString("fullName");
            mobile = getIntent().getExtras().getString("mobile");
            address = getIntent().getExtras().getString("address");
            locality = getIntent().getExtras().getString("locality");
            type = getIntent().getExtras().getString("type");
            country = getIntent().getExtras().getString("country");
            state = getIntent().getExtras().getString("state");
            city = getIntent().getExtras().getString("city");
            walletUsed = getIntent().getExtras().getString("walletUsed");

        }
        user = Preference.getUser(context);

        mAdressTypeList.add(new SelectModel("Home", ""));
        mAdressTypeList.add(new SelectModel("Office", ""));
        mAdressTypeList.add(new SelectModel("Other", ""));

        StaggeredGridLayoutManager stgDate = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
        selectAdressTypeAdapter = new SelectItemAdapter(context, mAdressTypeList, new CommonListener() {
            @Override
            public void onClicked(int position, int action) {
                if (action == CLICKED) {
                    type = mAdressTypeList.get(position).getItemName();
                }
            }
        });
        binding.rvAddressTypeList.setLayoutManager(stgDate);
        binding.rvAddressTypeList.setAdapter(selectAdressTypeAdapter);

        if (!(Preference.getAddress(context)!=null)) {
            binding.etFullAddress.setText(Preference.getAddress(context).getAddress());
        }

        binding.backAddEditAddress.setOnClickListener(v -> onBackPressed());
        binding.changeCurrentAddressTV.setOnClickListener(v -> changeAddress());
        binding.updateAddressCard.setOnClickListener(v -> vaidate());
        if (!TextUtils.isEmpty(addressId)) {
            getAdressDetail();
        } else {
            option = "add";
            binding.etFullAddress.setText("");
            binding.etLocality.setText("");
            binding.etMobileAddress.setText(user.getMobile());
            binding.etNameAddress.setText(user.getName());
            selectAdressTypeAdapter.setSelection(0);
        }
    }

    private void vaidate() {
        name = binding.etNameAddress.getText().toString();
        mobile = binding.etMobileAddress.getText().toString();
        locality = binding.etLocality.getText().toString();
        address = binding.etFullAddress.getText().toString();
        country = binding.etCountry.getText().toString();
        state = binding.etState.getText().toString();
        city = binding.etCity.getText().toString();

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(context, "Name is required", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(mobile)) {
            Toast.makeText(context, "Mobile is required", Toast.LENGTH_SHORT).show();
            return;
        } else if (mobile.length() < 10) {
            Toast.makeText(context, "Valid mobile is required", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(country)) {
            Toast.makeText(context, "Country is required", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(state)) {
            Toast.makeText(context, "State is required", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(city)) {
            Toast.makeText(context, "City is required", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(locality)) {
            Toast.makeText(context, "Locality is required", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(address)) {
            Toast.makeText(context, "Address is required", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(type)) {
            Toast.makeText(context, "Address type is required", Toast.LENGTH_SHORT).show();
            return;
        }

        addAddressToServer(user.getUserId(), option);
    }

    public void addAddressToServer(String userId, String option) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressbarAddAddress.setVisibility(View.VISIBLE);
            NetworkProvider.instance().addUpdateAddress(userId, addressId, option, name, mobile,country,state,city, address, locality, type).enqueue(new Callback<CommonResponse>() {
                @Override
                public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                    binding.progressbarAddAddress.setVisibility(View.GONE);
                    CommonResponse resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CommonResponse> call, Throwable t) {
                    binding.progressbarAddAddress.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }


    private void changeAddress() {

    }

    private void getAdressDetail() {
        binding.etFullAddress.setText(address);
        binding.etLocality.setText(locality);
        binding.etMobileAddress.setText(mobile);
        binding.etNameAddress.setText(name);
        binding.etCountry.setText(country);
        binding.etCity.setText(city);
        binding.etState.setText(state);
        option = "";

        for (int i = 0; i < mAdressTypeList.size(); i++) {
            SelectModel model = mAdressTypeList.get(i);
            if (model.getItemName().equals(type)) {
                selectAdressTypeAdapter.setSelection(i);
            }
        }
    }


    @Override
    public void onBackPressed() {
        finish();
    }
}
