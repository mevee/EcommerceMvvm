package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.responses.wallet_resp.Transaction;
import com.webkype.happiroo.databinding.TransactionItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WalletTransactionAdapter extends RecyclerView.Adapter<WalletTransactionAdapter.ViewHolder> {

    private Context context;
    private List<Transaction> productList;

    public WalletTransactionAdapter(Context context, List<Transaction> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TransactionItemBinding itemView = TransactionItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Transaction item = productList.get(position);
        final TransactionItemBinding productItem = holder.bind;

        if (TextUtils.isEmpty(item.getCredit())) {
            productItem.transTypeTV.setText("Debited From Wallet");
            productItem.creditOrDebitAmtTV.setText("Debited: " + item.getDebit());
            productItem.creditOrDebitAmtTV.setTextColor(context.getResources().getColor(R.color.red));
        } else {
            productItem.transTypeTV.setText("Credit To Wallet");
            productItem.creditOrDebitAmtTV.setText("Credit: " + item.getCredit());
            productItem.creditOrDebitAmtTV.setTextColor(context.getResources().getColor(R.color.green));
        }
        productItem.dateTimeWalletTV.setText("Transaction Date: " + item.getAdddate());
        productItem.transactionId.setText("Transaction Id : " + item.getId());

    }

    @Override
    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TransactionItemBinding bind;

        public ViewHolder(@NonNull TransactionItemBinding itemView) {
            super(itemView.getRoot());
            this.bind = itemView;
        }
    }
}
