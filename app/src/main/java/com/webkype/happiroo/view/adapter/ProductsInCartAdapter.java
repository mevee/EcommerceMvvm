package com.webkype.happiroo.view.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.CommonResponse;
import com.webkype.happiroo.controller.network.responses.cart.Productdetail;
import com.webkype.happiroo.controller.network.responses.cart.UpdateCartResp;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ProductInCartBinding;
import com.webkype.happiroo.view.CommonListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsInCartAdapter extends RecyclerView.Adapter<ProductsInCartAdapter.ViewHolder> {

    private final CommonListener listener;
    private Context context;
    private List<Productdetail> productList;

    public ProductsInCartAdapter(Context context, List<Productdetail> productList, CommonListener listener) {
        this.context = context;
        this.productList = productList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductInCartBinding binding = ProductInCartBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Productdetail productItem = productList.get(position);
        ProductInCartBinding binding = holder.binding;
        try {
            holder.totalCount = Integer.parseInt(productItem.getQty());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            holder.totalCount = 0;
        }
        binding.cartItemName.setText(productItem.getProductname());
        binding.cartItemCostPrice.setText("₹" + productItem.getCostprice());
        binding.cartItemCostPrice.setPaintFlags(binding.cartItemCostPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        binding.cartItemSellingPrice.setText("₹" + productItem.getSellingprice());

        binding.tvCount.setText("" + (holder.totalCount));


        binding.addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCart(holder, productItem.getPid(), "add");
            }
        });
        binding.subtractProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCart(holder, productItem.getPid(), "sub");
            }
        });

        binding.removeProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToCartConfirmation(holder, productItem.getPid());
            }
        });
    }

    private void addToCartConfirmation(ViewHolder holder, String pid) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Do you want to delete service from cart?");
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteCartProduct(holder, pid);
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void updateCart(ViewHolder holder, String pid, String option) {
        ProductInCartBinding binding = holder.binding;
        binding.addProduct.setEnabled(false);
        binding.subtractProduct.setEnabled(false);
        String cartId = Preference.getCartId(context);
        if (InternetConnectionCheck.haveNetworkConnection(context)) {
            NetworkProvider.instance().updateCartProduct(pid, cartId, option).enqueue(new Callback<UpdateCartResp>() {
                @Override
                public void onResponse(Call<UpdateCartResp> call, Response<UpdateCartResp> response) {
                    binding.addProduct.setEnabled(true);
                    binding.subtractProduct.setEnabled(true);
                    UpdateCartResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {
//                        AppPref.setCartId(context,resp.getBid());
                        holder.totalCount = resp.getQty();
                        binding.tvCount.setText("" + holder.totalCount);
                        listener.onClicked(holder.getAdapterPosition(), CommonListener.UPDATED);
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<UpdateCartResp> call, Throwable t) {
                    binding.addProduct.setEnabled(true);
                    binding.subtractProduct.setEnabled(true);
                    Log.d("ProductAdapter", "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteCartProduct(ViewHolder holder, String pid) {
        ProductInCartBinding binding = holder.binding;
        binding.addProduct.setEnabled(false);
        binding.subtractProduct.setEnabled(false);
        String cartId = Preference.getCartId(context);
        if (InternetConnectionCheck.haveNetworkConnection(context)) {
            NetworkProvider.instance().deleteService(pid, cartId).enqueue(new Callback<CommonResponse>() {
                @Override
                public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                     binding.subtractProduct.setEnabled(true);
                    CommonResponse resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        listener.onClicked(holder.getAdapterPosition(), CommonListener.DELETED);
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CommonResponse> call, Throwable t) {
                    binding.addProduct.setEnabled(true);
                    binding.subtractProduct.setEnabled(true);
                    Log.d("ProductAdapter", "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        int totalCount = 1;

        ProductInCartBinding binding;

        public ViewHolder(@NonNull ProductInCartBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
