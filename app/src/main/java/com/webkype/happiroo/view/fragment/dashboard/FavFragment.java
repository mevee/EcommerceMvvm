package com.webkype.happiroo.view.fragment.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.mservices.FavServiceResp;
import com.webkype.happiroo.controller.network.responses.mservices.Service;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.FragmentFavBinding;
import com.webkype.happiroo.model.User;
import com.webkype.happiroo.view.activity.auth.AuthenticateActivity;
import com.webkype.happiroo.view.activity.DashboardActivity;
import com.webkype.happiroo.view.adapter.FavServiceAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavFragment extends Fragment {

    private Context context;

    @BindView(R.id.ll_no_fav_data)
    LinearLayout ll_no_fav_data;
    @BindView(R.id.rv_fav_service)
    RecyclerView rv_fav_service;
    private FragmentFavBinding binding;
    private FavServiceAdapter favServiceAdapter;
    private List<Service> mFavListItem = new ArrayList<>();
    private User user;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFavBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user = Preference.getUser(getContext());
        binding.rvFavService.setNestedScrollingEnabled(false);
        binding.rvFavService.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        favServiceAdapter = new FavServiceAdapter(context, mFavListItem);
        binding.rvFavService.setAdapter(favServiceAdapter);

        binding.ivBackButton.setOnClickListener(v-> {
            getActivity().onBackPressed();
        });

        binding.exploreFavBtn.setOnClickListener(v -> {
            startActivity(new Intent(context, DashboardActivity.class));
        });
        binding.tvBtnLogin.setOnClickListener(v -> {
            Intent intent = new Intent(context, AuthenticateActivity.class);
            intent.putExtra("from", "profile");
            startActivity(intent);
        });
        if (user == null) {
            binding.llNotLogged.setVisibility(View.VISIBLE);
        } else {
            binding.llNotLogged.setVisibility(View.GONE);
            getFavServiceList();
        }
    }

    private void getFavServiceList() {
        if (InternetConnectionCheck.haveNetworkConnection(getContext())) {
            binding.progressbarFavFrag.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getFavServiceList(user.getUserId()).enqueue(new Callback<FavServiceResp>() {
                @Override
                public void onResponse(Call<FavServiceResp> call, Response<FavServiceResp> response) {
                    binding.progressbarFavFrag.setVisibility(View.GONE);

                    FavServiceResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {

                        if (resp.getServices() != null && resp.getServices().size() > 0) {
                            binding.llNoFavData.setVisibility(View.GONE);
                            mFavListItem.addAll(resp.getServices());
                        } else {
                            binding.llNoFavData.setVisibility(View.VISIBLE);
                        }

                        favServiceAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<FavServiceResp> call, Throwable t) {
                    binding.progressbarFavFrag.setVisibility(View.GONE);
                    Log.d("OtpActivity", "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }
}
