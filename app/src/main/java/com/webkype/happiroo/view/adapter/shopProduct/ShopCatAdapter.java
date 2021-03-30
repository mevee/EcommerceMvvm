package com.webkype.happiroo.view.adapter.shopProduct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.webkype.happiroo.R;
import com.webkype.happiroo.databinding.ShopCatItemBinding;
import com.webkype.happiroo.model.CategoryModel;
import com.webkype.happiroo.view.CommonListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShopCatAdapter extends RecyclerView.Adapter<ShopCatAdapter.ViewHolder> {

    private final CommonListener listener;
    private Context context;
    private List<CategoryModel> serviceCatList;

    public ShopCatAdapter(Context context, List<CategoryModel> serviceCatList, CommonListener listener){
        this.context = context;
        this.serviceCatList = serviceCatList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ShopCatItemBinding itemView = ShopCatItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final ShopCatItemBinding binding = holder.binding;

        final CategoryModel serviceCatItem = serviceCatList.get(position);

        Glide.with(context).load(serviceCatItem.getImage())
                .thumbnail(Glide.with(context).load(R.drawable.image_placeholder))
                .into(binding.serviceImage);

        binding.tvTitle.setText(serviceCatItem.getName());

        binding.serviceCatLayoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClicked(position,CommonListener.CLICKED);

            }
        });
    }

    @Override
    public int getItemCount() {
        return (serviceCatList != null ? serviceCatList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ShopCatItemBinding binding;
        public ViewHolder(@NonNull ShopCatItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
         }
    }
}
