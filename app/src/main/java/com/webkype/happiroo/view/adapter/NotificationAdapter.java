package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.webkype.happiroo.R;
import com.webkype.happiroo.model.NotoficationModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private Context context;
    private List<NotoficationModel> productList;

    public NotificationAdapter(Context context, List<NotoficationModel> productList){
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.notification_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final NotoficationModel productItem = productList.get(position);

        /*Glide.with(context).load(productItem.getImage())
                .thumbnail(Glide.with(context).load(R.drawable.image_placeholder))
                .transform(new CenterCrop(),new RoundedCorners(16))
                .into(holder.productImageItem);

        holder.productNameItem.setText(productItem.getName());
        holder.originalProductPrice.setPaintFlags(holder.originalProductPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.productAddBtnTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.productAddBtnTxt.setVisibility(View.GONE);
                holder.productCountLay.setVisibility(View.VISIBLE);

                ((ListingActivity)context).showCartValue();
            }
        });

        holder.productItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ProductDetailActivity.class));
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        /*@BindView(R.id.productItemLayout)RelativeLayout productItemLayout;
        @BindView(R.id.productImageItem) ImageView productImageItem;
        @BindView(R.id.productNameItem) TextView productNameItem;
        @BindView(R.id.originalProductPrice)TextView originalProductPrice;
        @BindView(R.id.productAddBtnTxt)TextView productAddBtnTxt;
        @BindView(R.id.productCountLay) RelativeLayout productCountLay;*/

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
