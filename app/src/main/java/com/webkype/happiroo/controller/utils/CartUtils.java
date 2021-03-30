package com.webkype.happiroo.controller.utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.cart.CartQuantityResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartUtils {
    private static final String TAG = "CARYasjbckjsbfx";

    public static void getCartDetail(final TextView tv, Context context, String cartId) {
        if (InternetConnectionCheck.haveNetworkConnection(context)) {

            NetworkProvider.instance().getCartDetail(cartId).enqueue(new Callback<CartQuantityResponse>() {
                @Override
                public void onResponse(Call<CartQuantityResponse> call, Response<CartQuantityResponse> response) {
                    CartQuantityResponse resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        tv.setVisibility(View.VISIBLE);
                        tv.setText(resp.getTotalrecords());
                        if ("0".equals(resp.getTotalrecords())){
                            tv.setVisibility(View.GONE);
                        }
                    } else {
                        tv.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onFailure(Call<CartQuantityResponse> call, Throwable t) {

                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }

    }

}
