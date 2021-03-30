package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.responses.home_page_resp.Stripcategory;
import com.webkype.happiroo.controller.network.responses.home_page_resp.Stripdatum;
import com.webkype.happiroo.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeStripAdapter extends RecyclerView.Adapter<HomeStripAdapter.ViewHolder> {

    private Context context;
    private List<Stripdatum> stripCatList = new ArrayList<>();

    public HomeStripAdapter(Context context, List<Stripdatum> stripCatList) {
        this.context = context;
        this.stripCatList = stripCatList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.home_strip_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder vh, int position) {
        final ViewHolder holder = (ViewHolder) vh;
        final Stripdatum data = stripCatList.get(position);
            holder.homeStripItemName.setText(data.getStripname());
            setArrays(data.getStripcategories(),holder);
    }

    private void setArrays(List<Stripcategory> stripcategories,ViewHolder holder) {

        final List<CategoryModel> mList = new ArrayList<>();
        for (Stripcategory detail : stripcategories) {
            mList.add(new CategoryModel("" + detail.getCatimgnew(), detail.getCategoryname(), detail.getCatId()));
        }
        holder.stripCategoryRecycler.setNestedScrollingEnabled(false);
        holder.stripCategoryRecycler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        holder.stripCategoryAdapter = new StripCategoryAdapter(context, mList);
        holder.stripCategoryRecycler.setAdapter(holder.stripCategoryAdapter);
    }


    @Override
    public int getItemCount() {
        return stripCatList != null ? stripCatList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.homeStripItemName)
        TextView homeStripItemName;
        @BindView(R.id.stripCategoryRecycler)
        RecyclerView stripCategoryRecycler;
        private StripCategoryAdapter stripCategoryAdapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
