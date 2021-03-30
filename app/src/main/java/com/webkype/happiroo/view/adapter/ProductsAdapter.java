package com.webkype.happiroo.view.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.cart.AddToCartResponse;
import com.webkype.happiroo.controller.network.responses.cart.UpdateCartResp;
import com.webkype.happiroo.controller.network.responses.mservices.Servicelist;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ProductItemBinding;
import com.webkype.happiroo.model.User;
import com.webkype.happiroo.view.CommonListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private final CommonListener listener;
    private Context context;
    private List<Servicelist> productList;
    User user;

    public ProductsAdapter(Context context, List<Servicelist> productList, CommonListener listener) {
        this.context = context;
        this.productList = productList;
        this.listener = listener;
        user = Preference.getUser(context);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemBinding binding = ProductItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Servicelist data = productList.get(position);
        final ProductItemBinding bd = holder.binding;

        Glide.with(context).load(data.getServicepic())
                .thumbnail(Glide.with(context).load(R.drawable.image_placeholder))
                .transform(new CenterCrop(), new RoundedCorners(16))
                .into(bd.productImageItem);

        bd.productNameItem.setText(data.getServicename());
        bd.discountedProductPrice.setText("\u20B9" + data.getDiscountValue());
        bd.originalProductPrice.setText("\u20B9" + data.getCostprice());
        bd.tvServiceRating.setText(data.getRating());
        bd.tvServiceTime.setText(data.getServiceduration());
        bd.tvDetail.setText(Html.fromHtml(data.getDescription()));
        bd.originalProductPrice.setPaintFlags(bd.originalProductPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        bd.productAddToCartBtnTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user != null) {
                    String cartId = Preference.getCartId(context);
                    if (TextUtils.isEmpty(cartId)) {
                        addToCart(-1, position, bd, data.getId(), user.getUserId(), cartId);
                    } else {
                        addToCartConfirmation(position, bd, data.getId(), user.getUserId());
                    }
                } else {
                    listener.onClicked(position, CommonListener.NOT_LOGGED);
                }
            }
        });

        bd.addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCart(holder, data.getId(), "add");
            }
        });
        bd.subtractProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCart(holder, data.getId(), "sub");
            }
        });

        if (!TextUtils.isEmpty(data.getCartQnt())) {
            bd.productAddToCartBtnTxt.setVisibility(View.GONE);
            bd.productCountLay.setVisibility(View.VISIBLE);
            bd.tvCount.setText(data.getCartQnt());
        }
        bd.productItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClicked(position, CommonListener.CLICKED);
            }
        });

    }

    private void addToCartConfirmation(int position, ProductItemBinding binding, String serviceId, String userID) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Do you want to replace this service with older service in cart? " +
                "\n*You can add only one service at time.");
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Preference.setCartId(context, "");
                addToCart(100000, position, binding, serviceId, user.getUserId(), "");
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void addToCart(int ISREPLACED, int position, ProductItemBinding binding, String serviceId, String userID, String cartId) {
        binding.productAddToCartBtnTxt.setEnabled(false);

        if (InternetConnectionCheck.haveNetworkConnection(context)) {
            NetworkProvider.instance().addToCart(serviceId, cartId, "1","Service", userID).enqueue(new Callback<AddToCartResponse>() {
                @Override
                public void onResponse(Call<AddToCartResponse> call, Response<AddToCartResponse> response) {
                    binding.productAddToCartBtnTxt.setEnabled(true);
                    AddToCartResponse resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        Preference.setCartId(context, resp.getBid());
                        binding.productAddToCartBtnTxt.setVisibility(View.GONE);
                        binding.productCountLay.setVisibility(View.VISIBLE);
                        productList.get(position).setCartQnt("1");
                        listener.onClicked(position, CommonListener.UPDATED);
                        if (ISREPLACED > 0)
                            listener.onClicked(position, CommonListener.REPLACED);
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<AddToCartResponse> call, Throwable t) {
                    Log.d("ProductAdapter", "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateCart(ViewHolder holder, String pid, String option) {
        ProductItemBinding binding = holder.binding;
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
                        binding.tvCount.setText("" + resp.getQty());
                        productList.get(holder.getAdapterPosition()).setCartQnt(binding.tvCount.getText().toString());
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


    @Override
    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ProductItemBinding binding;

        public ViewHolder(@NonNull ProductItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
