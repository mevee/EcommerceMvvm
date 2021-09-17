package com.webkype.happiroo.view.activity.bookings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.CommonResponse;
import com.webkype.happiroo.controller.network.responses.booking.BookingDetailResp;
import com.webkype.happiroo.controller.network.responses.booking.Bookingdatum;
import com.webkype.happiroo.controller.network.responses.booking.Servicedetum;
import com.webkype.happiroo.controller.network.responses.booking.VendorDetail;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ActivityBookingDetailBinding;
import com.webkype.happiroo.view.CommonListener;
import com.webkype.happiroo.view.activity.DashboardActivity;
import com.webkype.happiroo.view.adapter.ItemIncludeAdapter;
import com.webkype.happiroo.view.fragment.booking.AddVendorReviewBottomFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingDetailActivity extends AppCompatActivity {

    private static final String TAG = BookingDetailActivity.class.getName();
    private Context context;
    private String type;
    private String bookingId;
    private String from;
    private ActivityBookingDetailBinding binding;
    private List<Servicedetum> serviceList = new ArrayList<>();
    private ItemIncludeAdapter itemIncludeAdapter;
    private String vendorId;
    private String image;
    private String name;
    private String rating;
    private String totalRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_booking_detail);
        context = BookingDetailActivity.this;

        itemIncludeAdapter = new ItemIncludeAdapter(context, serviceList, new CommonListener() {
            @Override
            public void onClicked(int position, int action) {

            }
        });
        binding.rvServiceInclude.setLayoutManager(new LinearLayoutManager(context));
        binding.rvServiceInclude.setFocusable(false);
        binding.rvServiceInclude.setAdapter(itemIncludeAdapter);
/* if (getIntent().getExtras() != null) {
            bookingId = getIntent().getExtras().getString("id");
        }*/
        if (getIntent().getExtras() != null) {
            type = getIntent().getStringExtra("type");
            bookingId = getIntent().getStringExtra("bookingId");
            from = getIntent().getStringExtra("notificaton");
            init();
        }
        binding.backBookingDetail.setOnClickListener(v -> onBackPressed());
        binding.bookingDetailHelpBtn.setOnClickListener(v -> showHelpDialogue());
        binding.addReviewVendorBtn.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("vId", vendorId);
            bundle.putString("name", name);
            bundle.putString("image", image);
            bundle.putString("rating", rating);
            bundle.putString("totalRating", totalRating);

            AddVendorReviewBottomFragment addVendorReviewBottomFragment = new AddVendorReviewBottomFragment();
            addVendorReviewBottomFragment.setArguments(bundle);
            addVendorReviewBottomFragment.show(getSupportFragmentManager(), addVendorReviewBottomFragment.getTag());
        });
        binding.mainLayoutBookingDetail.setVisibility(View.GONE);

        binding.cancelBookingLayout.setOnClickListener(v -> {
            askForCancelBooking();
        });
        getBookingDetail(bookingId);
    }

    private void showHelpDialogue() {

        final String mobileNumber = "9999028002";
        final String email = "happiroo.in@gmail.com";
        final CharSequence options[] = new CharSequence[]{"Call : " + mobileNumber, "Mail : " + email};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);

        builder.setTitle("Complaint desk");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {
                    String uri = "tel:" + mobileNumber.trim() ;
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse(uri));
                    startActivity(intent);
//                     call
                } else if (i == 1) {
                     Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/html");
                    intent.putExtra(Intent.EXTRA_EMAIL, email);
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Need Help for product");
                     startActivity(Intent.createChooser(intent, "Send Email"));
                }
            }
        });

        builder.show();
    }

    private void askForCancelBooking() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to cancel booking?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cancelBookingApi(bookingId);
                dialog.dismiss();
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }

    private void cancelBookingApi(String bookingId) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressbarBookingDetail.setVisibility(View.VISIBLE);
            binding.cancelBookingLayout.setEnabled(false);
            NetworkProvider.instance().cancelABooking(bookingId).enqueue(new Callback<CommonResponse>() {
                @Override
                public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                    binding.progressbarBookingDetail.setVisibility(View.GONE);
                    binding.cancelBookingLayout.setEnabled(true);
                    CommonResponse resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        binding.cancelBookingLayout.setEnabled(false);
                        getBookingDetail(bookingId);
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CommonResponse> call, Throwable t) {
                    binding.progressbarBookingDetail.setVisibility(View.GONE);
                    binding.cancelBookingLayout.setEnabled(false);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }

    }

    private void getBookingDetail(String bookingId) {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressbarBookingDetail.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getBookingDetail(bookingId).enqueue(new Callback<BookingDetailResp>() {
                @Override
                public void onResponse(Call<BookingDetailResp> call, Response<BookingDetailResp> response) {
                    binding.progressbarBookingDetail.setVisibility(View.GONE);
                    binding.mainLayoutBookingDetail.setVisibility(View.VISIBLE);

                    BookingDetailResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        Bookingdatum detail = resp.getBookingdata();
                        binding.tvBookingIdBd.setText("Booking ID: " + detail.getId());
                        binding.tvServiceNameBd.setText(detail.getCategoryname());
                        String bookingStatus = detail.getBookingstatus();
                        binding.bookingDetailStatusTxt.setText(bookingStatus);
                        binding.tvBookingStatusBd.setText("Cancel Booking");
                        binding.tvServiceOtp.setText(detail.getOtp());
                        binding.tvServiceTimingBd.setText(detail.getServicedate() + ", from " + detail.getTimeslot());

                        StringBuilder builder = new StringBuilder();
                        builder.append(detail.getFullname());
                        builder.append("\n" + detail.getMobileno());

                        builder.append("\n" + detail.getLocationtype());
                        builder.append("\nCity : " + detail.getCity());
                        builder.append("\nState : " + detail.getState());
                        builder.append("\nCountry : " + detail.getCountry());
                        builder.append("\n" + detail.getAddress());
                        builder.append("\nLandmark : " + detail.getLocation());
                        binding.tvPaymentMode.setText(detail.getPaymentmode());
                        binding.tvAmountPaid.setText("\u20B9" + detail.getSellingamount());
                        binding.tvServiceAddressBd.setText(builder.toString());
                        if ("Completed".equals(bookingStatus)) {
                            binding.cancelBookingLayout.setVisibility(View.GONE);
                            binding.otpBookingLayout.setVisibility(View.GONE);
                        } else if ("Pending".equals(bookingStatus)) {
                            binding.cancelBookingLayout.setVisibility(View.VISIBLE);
                            binding.otpBookingLayout.setVisibility(View.VISIBLE);
                        } else if ("Booking Canceled".equals(bookingStatus)) {
                            binding.cancelBookingLayout.setVisibility(View.GONE);
                            binding.otpBookingLayout.setVisibility(View.GONE);
                        } else {
                            binding.cancelBookingLayout.setVisibility(View.VISIBLE);
                            binding.otpBookingLayout.setVisibility(View.VISIBLE);
                        }

                        if (detail.getServicedeta() != null && detail.getServicedeta().size() > 0) {
                            serviceList.clear();
                            for (Servicedetum pd : detail.getServicedeta()) {
                                Servicedetum item = new Servicedetum(pd.getProductname() + " (" + pd.getQuantity() + ")", pd.getSellingprice());
                                serviceList.add(item);
                            }
                        }
                        itemIncludeAdapter.notifyDataSetChanged();
                        VendorDetail vendorDetail = detail.getVendordeta();
                        if (vendorDetail != null) {
                            vendorId = vendorDetail.getId();
                            name = vendorDetail.getVendorname();
                            image = vendorDetail.getLogo();
                            rating = vendorDetail.getRating();
                            totalRating = vendorDetail.getNoofrating();
                            binding.tvVendorNameBd.setText(vendorDetail.getVendorname());
                            binding.ivTotalVendorRaingsBd.setText("" + vendorDetail.getNoofrating() + " Ratings");
                            binding.tvVendorRatingBd.setText(vendorDetail.getRating());

                            if (!TextUtils.isEmpty(vendorDetail.getLogo()))
                                Glide.with(context).load(vendorDetail.getLogo()).into(binding.ivVendorImageBd);
                        }


                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<BookingDetailResp> call, Throwable t) {
                    binding.progressbarBookingDetail.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        if (!TextUtils.isEmpty(from)) {
            startActivity(new Intent(this, DashboardActivity.class));
            finish();
        } else
            finish();
    }

    private void init() {

        if (type.equals("history")) {
            binding.bookingDetailStatusTxt.setText("Job Completed");
            binding.cancelBookingLayout.setVisibility(View.GONE);
            binding.otpBookingLayout.setVisibility(View.GONE);
        } else if (type.equals("ongoing")) {
            binding.bookingDetailStatusTxt.setText("Job Pending");
            binding.cancelBookingLayout.setVisibility(View.VISIBLE);
            binding.otpBookingLayout.setVisibility(View.VISIBLE);
        }
    }
}
