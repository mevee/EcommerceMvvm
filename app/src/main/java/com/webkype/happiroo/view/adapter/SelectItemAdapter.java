package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webkype.happiroo.R;
import com.webkype.happiroo.model.SelectModel;
import com.webkype.happiroo.view.CommonListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectItemAdapter extends RecyclerView.Adapter<SelectItemAdapter.ViewHolder> {

    private final CommonListener listener;
    private Context context;
    private List<SelectModel> productList;
    private int activePosition = -1;

    public SelectItemAdapter(Context context, List<SelectModel> productList, CommonListener listener) {
        this.context = context;
        this.productList = productList;
        this.listener = listener;
    }
    public void setSelection(int newPosition){
        if (newPosition>productList.size())
            return;
        this.activePosition =newPosition;
        listener.onClicked(newPosition,CommonListener.CLICKED);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.select_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final SelectModel productItem = productList.get(position);

        holder.tv_item.setText(productItem.getItemName());

      if (activePosition==position){
          holder.tv_item.setTextColor(context.getResources().getColor(R.color.white));
          holder.tv_item.setBackground(context.getResources().getDrawable(R.drawable.button_background));
      }else {
          holder.tv_item.setTextColor(context.getResources().getColor(R.color.dark_gray));
          holder.tv_item.setBackground(context.getResources().getDrawable(R.drawable.border_corner_background));
      }

        holder.tv_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activePosition = position;
                listener.onClicked(position,CommonListener.CLICKED);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item)
        TextView tv_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
