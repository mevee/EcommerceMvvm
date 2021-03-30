package com.webkype.happiroo.view.adapter.shopProduct;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.webkype.happiroo.controller.network.responses.booking.BookingHistory;
import com.webkype.happiroo.controller.network.responses.prod_orders.Order;
import com.webkype.happiroo.databinding.BookingHistoryBinding;
import com.webkype.happiroo.databinding.OrderItemBinding;
import com.webkype.happiroo.model.OrderModel;
import com.webkype.happiroo.view.activity.bookings.BookingDetailActivity;
import com.webkype.happiroo.view.activity.orders.OrderDetailActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {

    private Context context;
    private List<Order> productList;

    public OrdersAdapter(Context context, List<Order> productList){
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OrderItemBinding binding = OrderItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ViewHolder hd = (ViewHolder)holder;
        final Order item = productList.get(position);
        final OrderItemBinding binding = hd.binding;
        binding.tvServiceName.setText(item.getProductname());
        binding.tvStatusHistory.setText(item.getBookingstatus());
        binding.tvBookingTime.setText(item.getServicedate());
        binding.tvNoOfItems.setText("x"+item.getQuantity());
        binding.tvOrderValue.setText("\u20B9"+item.getSellingamount());
        binding.tvOrderID.setText("Order Id: "+item.getId());
        binding.tvOrderID.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        binding.bookingHistoryItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.putExtra("type", "history");
                intent.putExtra("orderID",item.getId() );
                context.startActivity(intent);
            }
        });

        binding.viewProjectLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.putExtra("type", "history");
                intent.putExtra("orderID",item.getId() );
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        OrderItemBinding binding;
        public ViewHolder(@NonNull OrderItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
         }
    }
}
