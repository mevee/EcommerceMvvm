package com.webkype.happiroo.view.activity.orders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.prod_orders.Order;
import com.webkype.happiroo.controller.network.responses.prod_orders.OrderListResp;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ActivityOrderListBinding;
import com.webkype.happiroo.model.OrderModel;
import com.webkype.happiroo.model.User;
import com.webkype.happiroo.view.adapter.shopProduct.OrdersAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderListActivity extends AppCompatActivity {
    private static final String TAG = OrderListActivity.class.getName();
    private ActivityOrderListBinding binding;
    private OrdersAdapter adapter;
    private List<Order> mOrderList = new ArrayList<>();
    private User user;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_list);
        user = Preference.getUser(this);
        context = this;
        binding.toolbarOrdList.tvToolbarTitle.setText("My Orders");
        binding.toolbarOrdList.ivToolbarBackBtn.setOnClickListener(v -> onBackPressed());

        adapter = new OrdersAdapter(this, mOrderList);

        binding.rvOrderList.setLayoutManager(new LinearLayoutManager(this));

//        loadData();
        getCartDetail();
    }

    public void getCartDetail() {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressBarOrderList.setVisibility(View.VISIBLE);

            Log.d(TAG, "uid" + user.getUserId());
            NetworkProvider.instance().getOrderList(user.getUserId()).enqueue(new Callback<OrderListResp>() {
                @Override
                public void onResponse(Call<OrderListResp> call, Response<OrderListResp> response) {
                    binding.progressBarOrderList.setVisibility(View.GONE);
                    OrderListResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                         if (resp.getBookinglist() != null && resp.getBookinglist().size() > 0) {
                            binding.noOrderAvailable.setVisibility(View.GONE);
                            mOrderList.clear();
                            mOrderList.addAll(resp.getBookinglist());
                        } else {
                            binding.noOrderAvailable.setVisibility(View.VISIBLE);
                        }
                        binding.rvOrderList.setAdapter(adapter);
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<OrderListResp> call, Throwable t) {
                    binding.progressBarOrderList.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }


    private void gotoOrdrDetailPage(int position) {
        startActivity(new Intent(this, OrderDetailActivity.class));
    }
}