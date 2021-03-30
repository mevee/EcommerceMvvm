package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 import com.webkype.happiroo.controller.network.responses.address.Addresslist;
import com.webkype.happiroo.databinding.AddressItmBinding;
import com.webkype.happiroo.view.CommonListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {

    private final CommonListener listener;
    private Context context;
    private List<Addresslist> productList;

    public AddressAdapter(Context context, List<Addresslist> productList, CommonListener listener) {
        this.context = context;
        this.productList = productList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AddressItmBinding binding = AddressItmBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Addresslist productItem = productList.get(position);
        final AddressItmBinding binding = holder.binding;
        binding.addressItemType.setText(productItem.getLocationtype());
        binding.addressItemUser.setText(productItem.getFullname());

        String string = "City : "+productItem.getCity();
        string+=",\nState : "+productItem.getState();
        string+=",\nCountry : "+productItem.getCountry();
        string+=",\nAddress : "+productItem.getAddress();
        string+=",\nLandmark : "+productItem.getLocation();
        binding.addressItemFullAddress.setText(string);
        binding.addressItemContactNo.setText("Mobile No. -"+productItem.getMobileno());

        binding.editAddressItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClicked(position, CommonListener.EDIT);
            }
        });
        binding.addressItemRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClicked(position, CommonListener.CLICKED);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (productList != null ? productList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AddressItmBinding binding;

        public ViewHolder(@NonNull AddressItmBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
