package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.responses.category.Subcat;
import com.webkype.happiroo.view.CommonListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListingCatAdapter extends RecyclerView.Adapter<ListingCatAdapter.ViewHolder> {

    private final CommonListener listener;
    private Context context;
    private List<Subcat> serviceCatList;
    private int lastSelectedPos = -1;

    public ListingCatAdapter(Context context, List<Subcat> serviceCatList, CommonListener listener) {
        this.context = context;
        this.serviceCatList = serviceCatList;
        this.listener = listener;
    }

    public void setSelection(int newPosition) {
        lastSelectedPos = newPosition;
        listener.onClicked(lastSelectedPos, CommonListener.CLICKED);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.listing_cat_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Subcat serviceCatItem = serviceCatList.get(position);

        holder.listingCatTxtItem.setText(serviceCatItem.getCataname());

        if (position == lastSelectedPos) {
            holder.listingCatLayoutItem.setBackground(context.getResources().getDrawable(R.drawable.button_background));
            holder.listingCatTxtItem.setTextColor(context.getResources().getColor(R.color.white));
        } else {
            holder.listingCatLayoutItem.setBackground(context.getResources().getDrawable(R.drawable.cat_back));
            holder.listingCatTxtItem.setTextColor(context.getResources().getColor(R.color.html_txt_color));
        }

        holder.listingCatLayoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lastSelectedPos == position)
                    return;
                lastSelectedPos = position;
                listener.onClicked(position, CommonListener.CLICKED);
                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        return (serviceCatList != null ? serviceCatList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.listingCatLayoutItem)
        RelativeLayout listingCatLayoutItem;
        @BindView(R.id.listingCatTxtItem)
        TextView listingCatTxtItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
