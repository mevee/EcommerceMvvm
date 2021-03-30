package com.webkype.happiroo.view.fragment.dashboard;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.CommonResponse;
import com.webkype.happiroo.controller.network.responses.wallet_resp.Transaction;
import com.webkype.happiroo.controller.network.responses.wallet_resp.WalletResp;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.controller.utils.ViewUtil;
import com.webkype.happiroo.databinding.FragmentWalletBinding;
import com.webkype.happiroo.model.User;
import com.webkype.happiroo.view.activity.DashboardActivity;
import com.webkype.happiroo.view.activity.auth.AuthenticateActivity;
import com.webkype.happiroo.view.adapter.WalletTransactionAdapter;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WalletFragment extends Fragment {

    private Context context;
    private LayoutInflater layoutInflater;

    private WalletTransactionAdapter walletTransactionAdapter;
    private List<Transaction> mWalletTransactionList = new ArrayList<>();
    @BindView(R.id.rv_wallet_transaction)
    RecyclerView rv_wallet_transaction;
    private User user;

    private ProgressDialog progressDialog;
    private FragmentWalletBinding binding;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentWalletBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user = Preference.getUser(getContext());
        progressDialog = new ProgressDialog(getActivity());
        layoutInflater = LayoutInflater.from(binding.getRoot().getContext());
        walletTransactionAdapter = new WalletTransactionAdapter(context, mWalletTransactionList);
        binding.rvWalletTransaction.setLayoutManager(new LinearLayoutManager(context));
        binding.rvWalletTransaction.setAdapter(walletTransactionAdapter);

        binding.rechargeWalletBtnTxt.setOnClickListener(v -> {
            showRechargeDialog();

        });
        binding.referralApplyRelativeBtn.setOnClickListener(v -> {
            applyReferralDialog();
        });
        binding.tvBtnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), AuthenticateActivity.class);
            intent.putExtra("from", "kjsjkcsd");
            startActivity(intent);
        });
        binding.nsvMainWallet.setVisibility(View.GONE);

    }

    public static final void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    public void onStart() {
        super.onStart();
        user = Preference.getUser(getContext());
        if (user == null) {
            binding.nsvMainWallet.setVisibility(View.GONE);
            binding.llNotLogged.setVisibility(View.VISIBLE);
        } else {
            getWalltInfo(user.getUserId());
            binding.llNotLogged.setVisibility(View.GONE);
        }
    }


    private void getWalltInfo(String userId) {
        if (InternetConnectionCheck.haveNetworkConnection(getContext())) {
            binding.progressbarWalletFrag.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getWalletDetail(userId).enqueue(new Callback<WalletResp>() {
                @Override
                public void onResponse(Call<WalletResp> call, Response<WalletResp> response) {
                    binding.nsvMainWallet.setVisibility(View.VISIBLE);

                    binding.progressbarWalletFrag.setVisibility(View.GONE);
                    WalletResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {

                        binding.tvAmountWallet.setText("\u20B9" + resp.getTotalbal());
                        mWalletTransactionList.clear();
                        if (resp.getProductList() != null && resp.getProductList().size() > 0) {
                            mWalletTransactionList.addAll(resp.getProductList());
                        }
                        walletTransactionAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<WalletResp> call, Throwable t) {
                    binding.progressbarWalletFrag.setVisibility(View.GONE);
                    Log.d("TAGWalllet", "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }


    private AlertDialog dialogAddAmount;

    private void showRechargeDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view1 = layoutInflater.inflate(R.layout.wallet_amout_recharge_dialog, null, false);
        TextView rechargeWalletApplyBtnTxt = view1.findViewById(R.id.rechargeWalletApplyBtnTxt);
        EditText etInputAmount = view1.findViewById(R.id.etInputAmount);

        rechargeWalletApplyBtnTxt.setOnClickListener(v -> {
            if (etInputAmount.length() == 0) {
                Toast.makeText(context, "Amount is required", Toast.LENGTH_SHORT).show();
                return;
            } else if (Integer.parseInt(etInputAmount.getText().toString()) <= 0) {
                Toast.makeText(context, "Valid amount is required", Toast.LENGTH_SHORT).show();
                return;
            } else {
                hideKeyboard(getActivity());
//                ((DashboardActivity)context).goToPaymentGateWay(Integer.parseInt(etInputAmount.getText().toString()));
                 dialogAddAmount.dismiss();
            }
        });

        builder.setView(view1);
        dialogAddAmount = builder.create();
        Objects.requireNonNull(dialogAddAmount.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogAddAmount.show();
    }

    private void applyReferralDialog() {
        View view1 = layoutInflater.inflate(R.layout.apply_promo_dialog, null, false);
        final AlertDialog dialog = new AlertDialog.Builder(context)
                .setView(view1)
                .create();
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
}
