package com.webkype.happiroo.view.activity.orders;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.CommonResponse;
import com.webkype.happiroo.controller.network.responses.prod_order_detail.Bookingdata;
import com.webkype.happiroo.controller.network.responses.prod_order_detail.OrderDetailResp;
import com.webkype.happiroo.controller.network.responses.prod_order_detail.Servicedetum;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ActivityOrderDetailBinding;
import com.webkype.happiroo.view.adapter.shopProduct.ItemsInOrderAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetailActivity extends AppCompatActivity {
    private final String TAG = OrderDetailActivity.class.getName();
    private ActivityOrderDetailBinding binding;
    private ItemsInOrderAdapter itemsInOrderAdapter;
    private List<Servicedetum> productList = new ArrayList<>();
    private String orderID;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_detail);
        binding.toolbarOrdDetail.tvToolbarTitle.setText("Order Detail");
        binding.toolbarOrdDetail.ivToolbarBackBtn.setOnClickListener(v -> onBackPressed());
        if (getIntent().getExtras() != null) {
            orderID = getIntent().getExtras().getString("orderID");
        }
        context = this;

        itemsInOrderAdapter = new ItemsInOrderAdapter(this, productList);

        binding.rvProductList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvProductList.setAdapter(itemsInOrderAdapter);
        binding.rvProductList.setVisibility(View.VISIBLE);
        binding.rvProductList.setFocusable(false);
        binding.rvProductList.setNestedScrollingEnabled(false);

        binding.btnCancelOrder.setEnabled(false);
        binding.nsvOrdDetail.setVisibility(View.GONE);
        binding.btnCancelOrder.setOnClickListener(v -> {
            binding.btnCancelOrder.setEnabled(false);
            askForCancelOrder();
        });

        getOrderDetail();
    }

    private void askForCancelOrder() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to cancel this order?");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cancelOrder();
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void cancelOrder() {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressBarOrderDetail.setVisibility(View.VISIBLE);
            NetworkProvider.instance().cancelOrder(orderID).enqueue(new Callback<CommonResponse>() {
                @Override
                public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                    binding.progressBarOrderDetail.setVisibility(View.GONE);
                    binding.btnCancelOrder.setEnabled(true);
                    CommonResponse resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                        getOrderDetail();
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CommonResponse> call, Throwable t) {
                    binding.progressBarOrderDetail.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }


    public void getOrderDetail() {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressBarOrderDetail.setVisibility(View.VISIBLE);

            NetworkProvider.instance().getOrderDetail(orderID).enqueue(new Callback<OrderDetailResp>() {
                @Override
                public void onResponse(Call<OrderDetailResp> call, Response<OrderDetailResp> response) {
                    binding.progressBarOrderDetail.setVisibility(View.GONE);
                    binding.nsvOrdDetail.setVisibility(View.VISIBLE);

                    OrderDetailResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        Bookingdata detail = resp.getBookingdata();
                        binding.tvOrderID.setText("Order Id: " + orderID);
                        binding.tvOrderStatus.setText("Order Status - " + detail.getBookingstatus());
                        binding.tvOrderTime.setText(detail.getServicedate());
                        binding.tvOrderName.setText(detail.getFullname());
                        binding.tvPaymentType.setText("Payment Mode: " + detail.getPaymentmode());
                        String fullAddress = "";
                        fullAddress += detail.getAddress();
                        fullAddress += "\n" + detail.getLocation();
                        fullAddress += "\nCity: " + detail.getCity();
                        fullAddress += "\nState: " + detail.getState();
                        fullAddress += "\nCountry: " + detail.getCountry();
                        fullAddress += "\nPhone Number: " + detail.getMobileno();
                        binding.tvFullAddress.setText(fullAddress);

                        binding.tvSellingPrice.setText("\u20B9" + detail.getSellingamount());
                        binding.tvShippingFee.setText("\u20B9" +/*detail.d()*/"0");
                        binding.tvTotalAmount.setText("\u20B9" + detail.getSellingamount());
                        if ("Pending".equals(detail.getBookingstatus())) {
                            binding.btnCancelOrder.setEnabled(true);
                        } else {
                            binding.btnCancelOrder.setEnabled(false);
                            binding.btnCancelOrder.setAlpha(.6f);
                        }
                        productList.clear();
                        if (detail.getServicedeta() != null && detail.getServicedeta().size() > 0) {
                            productList.addAll(detail.getServicedeta());
                        }
                        itemsInOrderAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<OrderDetailResp> call, Throwable t) {
                    binding.progressBarOrderDetail.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }


}