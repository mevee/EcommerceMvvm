package com.webkype.happiroo.view.fragment.booking;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.booking.BookingHistory;
import com.webkype.happiroo.controller.network.responses.booking.BookingHistoryResp;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.FragmentHistoryBookingBinding;
import com.webkype.happiroo.model.User;
import com.webkype.happiroo.view.adapter.BookHistoryAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingHistoryFragment extends Fragment {
    private String TAG = BookingHistoryFragment.class.getName();

    private Context context;

    private BookHistoryAdapter historyAdapter;
    private List<BookingHistory> mHistoryList = new ArrayList<>();

    private FragmentHistoryBookingBinding binding;
    private User user;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHistoryBookingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user = Preference.getUser(context);
        historyAdapter = new BookHistoryAdapter(context, mHistoryList);
       binding.rvBookHistory.setLayoutManager(new LinearLayoutManager(context));
       binding.rvBookHistory.setAdapter(historyAdapter);

        if (user != null) {
            getBookingList(user.getUserId());
         }else {
         }
    }

    private void getBookingList(String userId) {
        if (InternetConnectionCheck.haveNetworkConnection(getActivity())) {
            binding.progressbarHistory.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getBookingHistoryList(userId).enqueue(new Callback<BookingHistoryResp>() {
                @Override
                public void onResponse(Call<BookingHistoryResp> call, Response<BookingHistoryResp> response) {
                    binding.progressbarHistory.setVisibility(View.GONE);
                    BookingHistoryResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {
                        mHistoryList.clear();
                        if (resp.getBookinglist() != null && resp.getBookinglist().size() > 0) {
                            mHistoryList.addAll(resp.getBookinglist());
                        }
                        historyAdapter.notifyDataSetChanged();
                    } else {
//                        Toast.makeText(getContext(), "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<BookingHistoryResp> call, Throwable t) {
                    binding.progressbarHistory.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(getContext(), "Check your internet connection", Toast.LENGTH_SHORT).show();
        }

    }

}
