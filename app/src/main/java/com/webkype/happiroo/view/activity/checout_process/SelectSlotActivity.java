package com.webkype.happiroo.view.activity.checout_process;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.utils.TimeSlotGenerator;
import com.webkype.happiroo.databinding.ActivitySelectSlotBinding;
import com.webkype.happiroo.model.SelectModel;
import com.webkype.happiroo.view.CommonListener;
import com.webkype.happiroo.view.adapter.SelectItemAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class SelectSlotActivity extends AppCompatActivity {

    private Context context;

    ActivitySelectSlotBinding binding;

    private SelectItemAdapter selectDateAdapter;
    private SelectItemAdapter selectTimeIntervalAdapter;
    private List<SelectModel> mDateList = new ArrayList<>();
    private List<SelectModel> mTimeSlotList = new ArrayList<>();
    private String selectedTimeSlot;
    private String selectedDate;
    private String addressId;
    private String address;
    private String addressType;
    private String serviceCost;
    private String walletUsed;
    private TimeSlotGenerator timeSlotGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_slot);
        context = SelectSlotActivity.this;
        if (getIntent().getExtras() != null) {
            addressId = getIntent().getExtras().getString("addressId");
            address = getIntent().getExtras().getString("address");
            addressType = getIntent().getExtras().getString("addressType");
            serviceCost = getIntent().getExtras().getString("serviceCost");
            walletUsed = getIntent().getExtras().getString("walletUsed");
        }
       /* if (!(Preference.getAddress(context)!=null)) {
            binding.userFullAddress.setText(address);
        }*/
        timeSlotGenerator = new TimeSlotGenerator();

        binding.tvServiceCost.setText("Total: \u20b9" + serviceCost);
        binding.userAddressType.setText(addressType);
        binding.userFullAddress.setText(address);
        StaggeredGridLayoutManager stgTime = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        selectTimeIntervalAdapter = new SelectItemAdapter(context, mTimeSlotList, new CommonListener() {
            @Override
            public void onClicked(int position, int action) {
                if (action == CommonListener.CLICKED) {
                    selectedTimeSlot = mTimeSlotList.get(position).getItemName();
                }

            }
        });
        binding.rvTimeSlotList.setLayoutManager(stgTime);
        binding.rvTimeSlotList.setAdapter(selectTimeIntervalAdapter);

        StaggeredGridLayoutManager stgDate = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
        selectDateAdapter = new SelectItemAdapter(context, mDateList, new CommonListener() {
            @Override
            public void onClicked(int position, int action) {
                if (action == CommonListener.CLICKED) {
                    selectedDate = mDateList.get(position).getItemName();
                    if (position == 0) {
                        setTimeListData(true);
                    } else {
                        setTimeListData(false);
                    }
                }
            }
        });
        binding.rvDateList.setLayoutManager(stgDate);
        binding.rvDateList.setAdapter(selectDateAdapter);
        getNextSixDays();

        binding.backCartReview.setOnClickListener(v -> onBackPressed());
        binding.proceedToBookRelative.setOnClickListener(v -> {

            if (TextUtils.isEmpty(selectedDate)) {
                Toast.makeText(context, "Date is not selected", Toast.LENGTH_SHORT).show();
                return;
            } else if (TextUtils.isEmpty(selectedTimeSlot)) {
                Toast.makeText(context, "Time slot is not selected", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(context, CartOverviewActivity.class);
            intent.putExtra("date", selectedDate);
            intent.putExtra("time", selectedTimeSlot);
            intent.putExtra("addressId", addressId);
            intent.putExtra("address", address);
            intent.putExtra("addressType", addressType);
            intent.putExtra("walletUsed", walletUsed);
            startActivity(intent);
        });

    }

    private void setTimeListData(boolean isCurrentDay) {
        mTimeSlotList.clear();
        mTimeSlotList.addAll(timeSlotGenerator.getTimeSlot(isCurrentDay));
         selectedTimeSlot = "";
        if (mTimeSlotList.size() > 0)
            selectTimeIntervalAdapter.setSelection(0);
        else
            selectTimeIntervalAdapter.notifyDataSetChanged();
    }
    private void getNextSixDays() {
        selectedDate = "";
        mDateList.addAll(timeSlotGenerator.getNextSixDays());
        selectDateAdapter.notifyDataSetChanged();
        selectDateAdapter.setSelection(0);

    }


    @Override
    public void onBackPressed() {
        finish();
    }
}
