package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.webkype.happiroo.R;
import com.webkype.happiroo.model.PaymentModel;
import com.webkype.happiroo.view.CommonListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectItemWithImageAdapter extends RecyclerView.Adapter<SelectItemWithImageAdapter.ViewHolder> {

    private final CommonListener listener;
    private Context context;
    private List<PaymentModel> productList;
    private int activePosition = -1;

    public SelectItemWithImageAdapter(Context context, List<PaymentModel> productList, CommonListener listener) {
        this.context = context;
        this.productList = productList;
        this.listener = listener;
    }

    public void setSelection(int newPosition) {
        if (newPosition > productList.size())
            return;
        this.activePosition = newPosition;
        listener.onClicked(newPosition, CommonListener.CLICKED);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.payment_mode_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PaymentModel productItem = productList.get(position);

        holder.tv_modename.setText(productItem.getName());

        Glide.with(context).load(productItem.getImage()).into(holder.iv_modeicon);
        if (activePosition == position) {
            holder.cod_rB.setChecked(true);
        } else {
            holder.cod_rB.setChecked(false);
        }
        holder.ll_payment_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activePosition = position;
                listener.onClicked(position, CommonListener.CLICKED);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ll_payment_layout)
        LinearLayout ll_payment_layout;
        @BindView(R.id.tv_modename)
        TextView tv_modename;
        @BindView(R.id.cod_rB)
        RadioButton cod_rB;
   @BindView(R.id.iv_modeicon)
   ImageView iv_modeicon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
