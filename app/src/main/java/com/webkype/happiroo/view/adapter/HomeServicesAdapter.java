package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.webkype.happiroo.view.activity.shopService.ServiceDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeServicesAdapter extends RecyclerView.Adapter<HomeServicesAdapter.ViewHolder> {

    private Context context;
    private List<CategoryModel> homeServiceList;

    public HomeServicesAdapter(Context context, List<CategoryModel> homeServiceList){
        this.context = context;
        this.homeServiceList = homeServiceList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.home_services_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CategoryModel homeService = homeServiceList.get(position);

        Glide.with(context).load(homeService.getImage())
                .thumbnail(Glide.with(context).load(R.drawable.image_placeholder))
                .into(holder.homeServicesImageItem);

        holder.homeServicesTxtItem.setText(homeService.getName());

        holder.homeServicesLayoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ServiceDetailActivity.class);
                intent.putExtra("catId",homeService.getCatId());
                context.startActivity(intent);
             }
        });
    }

    @Override
    public int getItemCount() {
        return (homeServiceList != null ? homeServiceList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.homeServicesLayoutItem) LinearLayout homeServicesLayoutItem;
        @BindView(R.id.homeServicesImageItem) ImageView homeServicesImageItem;
        @BindView(R.id.homeServicesTxtItem) TextView homeServicesTxtItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
