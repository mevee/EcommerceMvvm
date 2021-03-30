package com.webkype.happiroo.view.fragment.booking;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.booking.Bookinglist;
import com.webkype.happiroo.controller.network.responses.booking.BookingsResp;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.FragmentOngoingBookingBinding;
import com.webkype.happiroo.model.User;
import com.webkype.happiroo.view.adapter.BookOngoingAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OngoingBookingFragment extends Fragment {
    private String TAG = OngoingBookingFragment.class.getName();

    private Context context;

    private BookOngoingAdapter historyAdapter;
    private List<Bookinglist> mHistoryList = new ArrayList<>();

    FragmentOngoingBookingBinding binding;

    private User user;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentOngoingBookingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        user = Preference.getUser(context);
        historyAdapter = new BookOngoingAdapter(context, mHistoryList);
        binding.rvBookOngoing.setLayoutManager(new LinearLayoutManager(context));
        binding.rvBookOngoing.setAdapter(historyAdapter);

        if (user != null) {
            getBookingList(user.getUserId());
         }else {
//            show please login widget
        }
    }

    private void getBookingList(String userId) {
        if (InternetConnectionCheck.haveNetworkConnection(getActivity())) {
            binding.progressbarOngoingBooking.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getBookingList(userId).enqueue(new Callback<BookingsResp>() {
                @Override
                public void onResponse(Call<BookingsResp> call, Response<BookingsResp> response) {
                    binding.progressbarOngoingBooking.setVisibility(View.GONE);
                    BookingsResp resp = response.body();
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
                public void onFailure(Call<BookingsResp> call, Throwable t) {
                    binding.progressbarOngoingBooking.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(getContext(), "Check your internet connection", Toast.LENGTH_SHORT).show();
        }

    }


}
