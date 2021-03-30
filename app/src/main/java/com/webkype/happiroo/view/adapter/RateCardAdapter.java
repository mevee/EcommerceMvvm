package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.webkype.happiroo.R;
import com.webkype.happiroo.model.SampleModel;
import com.webkype.happiroo.view.CommonListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RateCardAdapter extends RecyclerView.Adapter<RateCardAdapter.ViewHolder> {

    private final CommonListener listener;
    private Context context;
    private List<SampleModel> rateCardList;

    public RateCardAdapter(Context context, List<SampleModel> rateCardList, CommonListener listener){
        this.context = context;
        this.rateCardList = rateCardList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.rate_card_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final SampleModel rateItem = rateCardList.get(position);
        Glide.with(context).load(rateItem.getImage())
                .thumbnail(Glide.with(context).load(R.drawable.image_placeholder))
                .transform(new CenterInside(),new RoundedCorners(16))
                .into(holder.rateCardImageItem);

        holder.rateCardImageItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClicked(position,CommonListener.CLICKED);

            }
        });
    }

    @Override
    public int getItemCount() {
        return (rateCardList != null ? rateCardList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rateCardImageItem) ImageView rateCardImageItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
