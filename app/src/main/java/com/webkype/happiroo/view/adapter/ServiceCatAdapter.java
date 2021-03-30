package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.webkype.happiroo.R;
import com.webkype.happiroo.model.CategoryModel;
import com.webkype.happiroo.view.CommonListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceCatAdapter extends RecyclerView.Adapter<ServiceCatAdapter.ViewHolder> {

    private final CommonListener listener;
    private Context context;
    private List<CategoryModel> serviceCatList;

    public ServiceCatAdapter(Context context, List<CategoryModel> serviceCatList, CommonListener listener){
        this.context = context;
        this.serviceCatList = serviceCatList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.service_cat_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CategoryModel serviceCatItem = serviceCatList.get(position);

        Glide.with(context).load(serviceCatItem.getImage())
                .thumbnail(Glide.with(context).load(R.drawable.image_placeholder))
                .into(holder.serviceCatImageItem);

        holder.serviceCatTxtItem.setText(serviceCatItem.getName());

        holder.serviceCatLayoutItem.setOnClickListener(new View.OnClickListener() {
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

        @BindView(R.id.serviceCatLayoutItem) LinearLayout serviceCatLayoutItem;
        @BindView(R.id.service_image) ImageView serviceCatImageItem;
        @BindView(R.id.tv_title) TextView serviceCatTxtItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
