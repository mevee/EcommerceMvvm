package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.responses.booking.Bookinglist;
import com.webkype.happiroo.databinding.BookingOngoingBinding;
import com.webkype.happiroo.view.activity.bookings.BookingDetailActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class BookOngoingAdapter extends RecyclerView.Adapter<BookOngoingAdapter.ViewHolder> {

    private Context context;
    private List<Bookinglist> productList;

    public BookOngoingAdapter(Context context, List<Bookinglist> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        BookingOngoingBinding binding = BookingOngoingBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Bookinglist item = productList.get(position);
        final BookingOngoingBinding binding = holder.binding;
        binding.tvBookingId.setText("Booking ID: "+item.getId());
        binding.tvServiceName.setText(item.getCategoryname());
        binding.tvStatus.setText(item.getBookingstatus());

        if ("Pending".equals(item.getBookingstatus())|| "Cancelled".equals(item.getBookingstatus())){
            binding.tvStatus.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.red));
        }else {
            binding.tvStatus.setBackgroundTintList(ContextCompat.getColorStateList(context, R.color.green));
        }
        binding.tvBookingTime.setText(item.getTimeslot()+" , "+item.getServicedate());
        binding.tvBookingInclude.setText(item.getServicename() + " (x"+item.getQuantity()+")");

        binding.bookingOngoingItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BookingDetailActivity.class);
                intent.putExtra("type", "ongoing");
                intent.putExtra("bookingId",item.getId() );

                context.startActivity(intent);
            }
        });

        binding.viewProjectOngoingLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BookingDetailActivity.class);
                intent.putExtra("type", "ongoing");
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

        BookingOngoingBinding binding;


        public ViewHolder(@NonNull BookingOngoingBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
