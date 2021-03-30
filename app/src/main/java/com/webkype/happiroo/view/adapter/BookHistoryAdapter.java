package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.webkype.happiroo.controller.network.responses.booking.BookingHistory;
import com.webkype.happiroo.databinding.BookingHistoryBinding;
import com.webkype.happiroo.view.activity.bookings.BookingDetailActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookHistoryAdapter extends RecyclerView.Adapter<BookHistoryAdapter.ViewHolder> {

    private Context context;
    private List<BookingHistory> productList;

    public BookHistoryAdapter(Context context, List<BookingHistory> productList){
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BookingHistoryBinding binding = BookingHistoryBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ViewHolder hd = (ViewHolder)holder;
        final BookingHistory item = productList.get(position);
        final BookingHistoryBinding binding = hd.binding;
        binding.tvServiceName.setText(item.getCategoryname());
        binding.tvStatusHistory.setText(item.getBookingstatus());
        binding.tvBookingTime.setText(item.getTimeslot()+" , "+item.getServicedate());

        binding.tvVendorName.setText(item.getVendorname());
        binding.tvVenorRatingHistory.setText(item.getRating());
        binding.tvTotalRatings.setText(item.getNoofrating()+" Ratings");
        if (!TextUtils.isEmpty(item.getLogo()))
        Glide.with(context).load(item.getLogo()).into(binding.ivVendorImage);

        binding.bookingHistoryItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BookingDetailActivity.class);
                intent.putExtra("type", "history");
                intent.putExtra("bookingId",item.getId() );
                context.startActivity(intent);
            }
        });

        binding.viewProjectLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BookingDetailActivity.class);
                intent.putExtra("type", "history");
                intent.putExtra("bookingId",item.getId() );
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        BookingHistoryBinding binding;
        public ViewHolder(@NonNull BookingHistoryBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
         }
    }
}
