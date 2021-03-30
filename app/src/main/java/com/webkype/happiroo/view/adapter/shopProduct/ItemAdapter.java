package com.webkype.happiroo.view.adapter.shopProduct;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.AppApi;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.CommonResponse;
import com.webkype.happiroo.controller.network.responses.product_list.Product;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.controller.utils.StringUtil;
import com.webkype.happiroo.databinding.ShopProductItemBinding;
import com.webkype.happiroo.model.MyProduct;
import com.webkype.happiroo.view.CommonListener;
import com.webkype.happiroo.view.activity.auth.AuthenticateActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private Context context;
    private List<Product> bookList;
    private CommonListener listener;

    public ItemAdapter(Context context, List<Product> bookList, CommonListener listener) {
        this.context = context;
        this.listener = listener;
        this.bookList = bookList;

    }


    public void setData() {
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ShopProductItemBinding binding = ShopProductItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final ViewHolder holder = (ViewHolder) viewHolder;
        final ShopProductItemBinding binding = holder.binding;
        final Product books = bookList.get(position);

        if (books.getProductpic() != null)
            Glide.with(context).load("" + books.getProductpic()).into(binding.ivCatgory);
        binding.tvProductTitle.setText("" + StringUtil.capitalizeFirst(books.getProductname()));
        binding.tvPrice.setText("\u20B9" + books.getSellingprice());
        binding.tvCostPrice.setText("\u20B9" + books.getMrp());
        binding.tvCostPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        if (TextUtils.isEmpty(books.getShortdescription())) {
            binding.tvDesc.setVisibility(View.GONE);
        } else {
            binding.tvDesc.setText("" + Html.fromHtml(books.getShortdescription()));
        }


        if (TextUtils.isEmpty(books.getIn_stock_qty())) {
            binding.tvNoOfSold.setText("");
        } else {
            if (books.getIn_stock_qty().equals("0")) {
                binding.tvNoOfSold.setText("(No stock)");
            } else {
                binding.tvNoOfSold.setText("(" + books.getIn_stock_qty() + " Left)");
            }
        }

        if (!TextUtils.isEmpty(books.getDiscount_percent())) {
            if (books.getDiscount_percent().equals("0") || books.getDiscount_percent().equals("100")) {
                binding.tvOff.setVisibility(View.GONE);
            } else
                binding.tvOff.setText("" + books.getDiscount_percent() + "%\nOFF");
        } else {
            binding.tvOff.setVisibility(View.GONE);
        }
        if ("0".equals(books.getIsfav())) {
            holder.isFavorite = false;
            binding.ivFavourite.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite));
        } else {
            holder.isFavorite = true;
            binding.ivFavourite.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
        }


        int discount = 0;
        try {
            discount = Integer.valueOf(books.getDiscount_value());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        float rating=0f;
        try {
            if (books.getRating()!=null)
            rating = Float.valueOf(books.getRating());
        } catch (NumberFormatException e){

        }

        binding.itemRatingBar.setRating(rating);
        if (discount <= 0) {
            binding.tvCostPrice.setVisibility(View.GONE);
        } else {
            binding.tvCostPrice.setVisibility(View.VISIBLE);
        }


        binding.ivFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Preference.getUser(context) != null) {
                    if (holder.isFavorite) {
                        changeFavSttaus(position, binding.progressBar, binding.ivFavourite, holder, "0", books.getId());
                    } else {
                        changeFavSttaus(position, binding.progressBar, binding.ivFavourite, holder, "1", books.getId());
                    }
                } else {
                    Intent intent = new Intent(context, AuthenticateActivity.class);
                    intent.putExtra("from", "najkskjs");
                    context.startActivity(intent);
                }
            }
        });


        try {
            binding.itemRatingBar.setRating(Float.valueOf(books.getRating()));
        } catch (Exception e) {
            e.printStackTrace();
            binding.itemRatingBar.setVisibility(View.GONE);
        }
//        }
        binding.cardParent.setOnClickListener(v -> {
            listener.onClicked(position, CommonListener.CLICKED);
        });
    }


    void changeFavSttaus(int position, final ProgressBar progress_bar, final ImageView iv_favourite, final ViewHolder holder, String fav, String pid) {
        String userId = Preference.getUser(context) != null ? Preference.getUser(context).getUserId() : "";
        if (InternetConnectionCheck.haveNetworkConnection(context)) {
            iv_favourite.setEnabled(false);
            progress_bar.setVisibility(View.VISIBLE);
            AppApi api = NetworkProvider.instance();
            Call<CommonResponse> call = api.addremovefavoriteproduct(pid, /*fav,*/ userId);
            call.enqueue(new Callback<CommonResponse>() {
                @Override
                public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                    progress_bar.setVisibility(View.GONE);
                    CommonResponse res = response.body();
                    if (res.getStatus().equals("200")) {
                        iv_favourite.setEnabled(true);
                        if ("0".equals(fav)) {
                            holder.isFavorite=false;
                           iv_favourite.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite));
                           listener.onClicked(position, CommonListener.DELETE);
                        } else {
                            holder.isFavorite=true;
                            iv_favourite.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_black_24dp));

                        }
                    } else {
                        Log.d("TAG", "error :" + res.getMsg());
                    }
                }

                @Override
                public void onFailure(Call<CommonResponse> call, Throwable t) {
                    progress_bar.setVisibility(View.GONE);
                    Log.d("TAG", "error :" + t.getMessage());
                }
            });


        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public int getItemCount() {
        return (bookList != null ? bookList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ShopProductItemBinding binding;
        private boolean isFavorite = false;

        public ViewHolder(@NonNull ShopProductItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }


}