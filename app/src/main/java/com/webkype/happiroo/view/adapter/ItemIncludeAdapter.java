package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.webkype.happiroo.controller.network.responses.booking.Servicedetum;
import com.webkype.happiroo.databinding.IncludeItemBinding;
import com.webkype.happiroo.view.CommonListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemIncludeAdapter extends RecyclerView.Adapter<ItemIncludeAdapter.ViewHolder> {

    private final CommonListener listener;
    private Context context;
    private List<Servicedetum> serviceCatList;

    public ItemIncludeAdapter(Context context, List<Servicedetum> serviceCatList, CommonListener listener) {
        this.context = context;
        this.serviceCatList = serviceCatList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        IncludeItemBinding binding = IncludeItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Servicedetum serviceCatItem = serviceCatList.get(position);
        final IncludeItemBinding binding = holder.binding;
        binding.tvServiceIncludesBd.setText(serviceCatItem.getProductname());
        binding.tvServicePrice.setText("\u20B9" + serviceCatItem.getSellingprice());
    }

    @Override
    public int getItemCount() {
        return (serviceCatList != null ? serviceCatList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        IncludeItemBinding binding;

        public ViewHolder(@NonNull IncludeItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
