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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.webkype.happiroo.R;
import com.webkype.happiroo.model.CategoryModel;
import com.webkype.happiroo.view.activity.shopService.ServiceDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StripAddvertAdapter extends RecyclerView.Adapter<StripAddvertAdapter.ViewHolder> {

    private Context context;
    private List<CategoryModel> stripCatList;

    public StripAddvertAdapter(Context context, List<CategoryModel> stripCatList){
        this.context = context;
        this.stripCatList = stripCatList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(context).inflate(R.layout.strip_addvert_item, parent, false);
       return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CategoryModel stripCatItem = stripCatList.get(position);

        Glide.with(context).load(stripCatItem.getImage())
                .thumbnail(Glide.with(context).load(R.drawable.image_placeholder))
                .into(holder.stripCatImageItem);

        holder.stripCatLayoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(context, ServiceDetailActivity.class);
//                intent.putExtra("catId",stripCatItem.getCatId());
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (stripCatList != null ? stripCatList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.stripCatLayoutItem)
        ConstraintLayout stripCatLayoutItem;
        @BindView(R.id.stripCatImageItem) ImageView stripCatImageItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
