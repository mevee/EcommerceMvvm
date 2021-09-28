package com.webkype.happiroo.view.activity.checout_process;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.CommonResponse;
import com.webkype.happiroo.controller.network.responses.book_serive_resp.BookServiceResp;
import com.webkype.happiroo.controller.network.responses.booking.Servicedetum;
import com.webkype.happiroo.controller.network.responses.cart.CartDetailResp;
import com.webkype.happiroo.controller.network.responses.cart.Productdetail;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ActivityCartOverviewBinding;
import com.webkype.happiroo.model.PaymentModel;
import com.webkype.happiroo.model.User;
import com.webkype.happiroo.view.CommonListener;
import com.webkype.happiroo.view.activity.DashboardActivity;
import com.webkype.happiroo.view.adapter.ItemIncludeAdapter;
import com.webkype.happiroo.view.adapter.SelectItemWithImageAdapter;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartOverviewActivity extends AppCompatActivity implements PaymentResultListener {

    private static final String TAG = CartOverviewActivity.class.getName();
    private Context context;
    private String paymentMode;
    private String serviceDate;
    private String serviceTime;
    private String address;
    private String walletUsed;
    private String addressType;
    private ActivityCartOverviewBinding binding;
    private SelectItemWithImageAdapter selectPaymetModeAdpater;

    private String addressId;
    private String transactionId;
    private List<PaymentModel> mPaymentModes = new ArrayList<>();

    private List<Servicedetum> serviceList = new ArrayList<>();
    private ItemIncludeAdapter includeServiceAdapter;
    private String activeShopping = "";
    private ProgressDialog progressDialog;
    private User user;
    private int finalPaymentAmount = 0;
    private int totalWalletBalance = 0;

    private String orderId;

    private String bookingId;
    private double amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart_overview);
        context = CartOverviewActivity.this;

//        Checkout.preload(getApplicationContext());

        progressDialog = new ProgressDialog(context);
        user = Preference.getUser(context);
        if (getIntent().getExtras() != null) {
            addressId = getIntent().getExtras().getString("addressId");
            serviceDate = getIntent().getExtras().getString("date");
            serviceTime = getIntent().getExtras().getString("time");
            address = getIntent().getExtras().getString("address");
//                        intent.putExtra("walletUsed", walletUsed);
            walletUsed = getIntent().getExtras().getString("walletUsed");
            addressType = getIntent().getExtras().getString("addressType");
        }
        activeShopping = Preference.getActiveShopping(context);

        if ("Product".equals(activeShopping))
            mPaymentModes.add(new PaymentModel(R.drawable.coin, "Cash On Delivery", "cod"));
        else
            mPaymentModes.add(new PaymentModel(R.drawable.coin, "Pay after service", "cod"));
        mPaymentModes.add(new PaymentModel(R.drawable.online_icon, "Pay via UPI App (GooglePay/ PhonePay/ PayTm etc)", "online"));

        selectPaymetModeAdpater = new SelectItemWithImageAdapter(this, mPaymentModes, new CommonListener() {
            @Override
            public void onClicked(int position, int action) {
                if (action == CLICKED) {
                    paymentMode = mPaymentModes.get(position).getId();
                    transactionId = "";
                    /*if ("online".equals(paymentMode)) {
                        binding.llOnline.setVisibility(View.VISIBLE);
                    } else {
                        binding.llOnline.setVisibility(View.GONE);
                    }*/
                }
            }
        });
        includeServiceAdapter = new ItemIncludeAdapter(this, serviceList, new CommonListener() {
            @Override
            public void onClicked(int position, int action) {

            }
        });

        binding.rvPaymentMode.setLayoutManager(new LinearLayoutManager(this));
        binding.rvPaymentMode.setFocusable(false);
        binding.rvPaymentMode.setAdapter(selectPaymetModeAdpater);
        selectPaymetModeAdpater.setSelection(0);
        binding.rvServiceInclude.setLayoutManager(new LinearLayoutManager(this));
        binding.rvServiceInclude.setFocusable(false);
        binding.rvServiceInclude.setAdapter(includeServiceAdapter);

        binding.tvDateTimeSelected.setText(serviceDate + " , from " + serviceTime);

        binding.tvAddressDetailOverview.setText(addressType + " ,\n" + address);
        binding.backCartOverview.setOnClickListener(v -> onBackPressed());

        binding.confirmBookingRelative.setOnClickListener(v -> {

            if (TextUtils.isEmpty(paymentMode)) {
                Toast.makeText(context, "Payment mode is not selected", Toast.LENGTH_SHORT).show();
                return;
            }
            if ("online".equals(paymentMode)) {
              /*  if (TextUtils.isEmpty(binding.etTransactionId.getText().toString())) {
                    Toast.makeText(context, "Transaction Id is required. Please enter it", Toast.LENGTH_SHORT).show();
                    return;
                }
                transactionId = binding.etTransactionId.getText().toString();
              */
                bookService(walletUsed, Preference.getUser(context).getUserId());
//                goToPaymentGateWay();
            } else if ("cod".equals(paymentMode)) {
                if ("Service".equals(activeShopping)) {

                    bookService(walletUsed, Preference.getUser(context).getUserId());

                }/* else if ("Product".equals(activeShopping)) {
                    bookProduct(walletUsed, Preference.getUser(context).getUserId());
                }*/
            }/* else if ("wallet".equals(paymentMode)) {
                if ("Service".equals(activeShopping)) {
                    bookService(walletUsed, Preference.getUser(context).getUserId());
                } else if ("Product".equals(activeShopping)) {
//                    bookProduct(walletUsed, Preference.getUser(context).getUserId());
                }
            }*/
        });

        binding.mainCartOverview.setVisibility(View.GONE);

        if ("Service".equals(activeShopping)) {

        } else if ("Product".equals(activeShopping)) {
            binding.tvTimeSlotTitle.setVisibility(View.GONE);
            binding.tvDateTimeSelected.setVisibility(View.GONE);
        }
        getCartDetail(Preference.getCartId(this));
    }


    private void paymentResponseAPI(String paymentId, String status) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            progressDialog.setMessage("Don't press back payment processing...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            NetworkProvider.instance().approveServicePayment(bookingId, orderId, user.getUserId())
                    .enqueue(new Callback<CommonResponse>() {
                        @Override
                        public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                            progressDialog.dismiss();
                            CommonResponse resp = response.body();
                            if ("200".equals(resp.getStatus())) {
                                bookingDone("Order Successful");
                            } else {
                                Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<CommonResponse> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(context, "Server Not Responding", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }


    public void bookService(String walletUsed, String userID) {
        String cartId = Preference.getCartId(context);
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            progressDialog.setMessage("Processing request...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            NetworkProvider.instance().bookService(userID, cartId, paymentMode, serviceDate, serviceTime, addressId, transactionId, walletUsed)
                    .enqueue(new Callback<BookServiceResp>() {
                        @Override
                        public void onResponse(Call<BookServiceResp> call, Response<BookServiceResp> response) {
                            progressDialog.dismiss();
                            BookServiceResp resp = response.body();
                            if ("200".equals(resp.getStatus())) {

                                if ("online".equals(paymentMode)) {

                                    bookingId = "" + resp.getBooking_id();
                                    try {
                                        orderId = resp.getOrderid();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    try {
                                        amount = Double.parseDouble(resp.getOrderamount());
                                    } catch (NumberFormatException e) {
                                        e.printStackTrace();
                                    }
                                    startPayment(amount, user.getEmail(), user.getMobile(), " Book service");

                                } else {
                                    bookingDone(resp.getMsg());
                                }

                            } else {
                                Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<BookServiceResp> call, Throwable t) {
                            progressDialog.dismiss();
                            Log.d(TAG, "" + t.getMessage());
                        }
                    });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    void bookingDone(String message) {
        Toast.makeText(context, "" + message, Toast.LENGTH_SHORT).show();
        Preference.setCartId(context, "");
        Intent intent = new Intent(context, DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

/*
        public void bookProduct (String walletUsed, String userID){
            String cartId = Preference.getCartId(context);
            if (InternetConnectionCheck.haveNetworkConnection(this)) {
                binding.progressbarCartOverView.setVisibility(View.VISIBLE);
                NetworkProvider.instance().bookProduct(userID, cartId, paymentMode, serviceDate, serviceTime, addressId, transactionId, walletUsed).enqueue(new Callback<CommonResponse>() {
                    @Override
                    public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                        binding.progressbarCartOverView.setVisibility(View.GONE);
                        CommonResponse resp = response.body();
                        if ("200".equals(resp.getStatus())) {
                        bookingDone( "Order Successful");

                        } else {
                            Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<CommonResponse> call, Throwable t) {
                        binding.progressbarCartOverView.setVisibility(View.GONE);
                        Log.d(TAG, "" + t.getMessage());
                    }
                });

            } else {
                Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
            }
        }
*/

    public void getCartDetail(String cartID) {
        User user = Preference.getUser(context);
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressbarCartOverView.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getCartProducts(cartID, walletUsed, user.getUserId()).enqueue(new Callback<CartDetailResp>() {
                @Override
                public void onResponse(Call<CartDetailResp> call, Response<CartDetailResp> response) {
                    binding.mainCartOverview.setVisibility(View.VISIBLE);
                    binding.progressbarCartOverView.setVisibility(View.GONE);
                    CartDetailResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        binding.costDistrLayout.cartTotal.setText("\u20B9" + resp.getTotalcost());
                        binding.costDistrLayout.discountTV.setText("\u20B9" + resp.getDiscountvalue());
                        binding.costDistrLayout.walletPointsTV.setText("\u20B9" + resp.getUsewalletamount());
                        finalPaymentAmount = resp.getFinalamount();
                        try {
                            totalWalletBalance = Integer.parseInt(resp.getUserwallet());
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                        binding.costDistrLayout.tvAmtToBePaid.setText("\u20B9" + finalPaymentAmount);
                        binding.costDistrLayout.otherChargesLay.setVisibility(View.GONE);

                        if ("0".equals(resp.getUsewalletamount())) {
                            binding.costDistrLayout.walletCreditLay.setVisibility(View.GONE);
                        } else {
                            binding.costDistrLayout.walletCreditLay.setVisibility(View.VISIBLE);
                        }

                        if (resp.getProductdetails() != null && resp.getProductdetails().size() > 0) {
                            serviceList.clear();

                            for (Productdetail pd : resp.getProductdetails()) {
                                serviceList.add(new Servicedetum(pd.getProductname() + " (" + pd.getQty() + ")", pd.getSellingprice()));
                            }
                        }
                        includeServiceAdapter.notifyDataSetChanged();
                        if (totalWalletBalance >= finalPaymentAmount) {
                            paymentMode = "wallet";
                            binding.tvPaymentModeTitle.setVisibility(View.GONE);
                            binding.rvPaymentMode.setVisibility(View.GONE);
                        } else {
                            binding.rvPaymentMode.setVisibility(View.VISIBLE);
                            binding.tvPaymentModeTitle.setVisibility(View.VISIBLE);
                        }

                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CartDetailResp> call, Throwable t) {
                    binding.progressbarCartOverView.setVisibility(View.GONE);
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

    private void startPayment(double orderAmount, String email, String phone, String from) {
        final Checkout checkout = new Checkout();
//        checkout.setKeyID(getResources().getString(R.string.razerKey));
//        checkout.setImage(R.drawable.logo);
        Activity activity = this;

        try {
            JSONObject option = new JSONObject();

            option.put("name", getString(R.string.app_name));
            option.put("description", from);
            option.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            option.put("order_id", orderId);
            option.put("currency", "INR");
            option.put("amount", (int) (orderAmount * 100));
            option.put("prefill.email", email);
            option.put("prefill.contact", phone);

            checkout.open(activity, option);

        } catch (Exception e) {
            Toast.makeText(this, "Error In Payment.Please try again!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
//            transactionId = s;
        if ("Service".equals(activeShopping)) {
            paymentResponseAPI(s, "success");

        } /*else if ("Product".equals(activeShopping)) {
            bookProduct(walletUsed, Preference.getUser(context).getUserId());
        }*/
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(context, "Transaction Cancelled", Toast.LENGTH_SHORT).show();
    }

}