package com.webkype.happiroo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.responses.home_page_resp.Adddetum;
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
            setArrays(data.getStripcategories(),data.getBannersdeta(),holder);
    }

    private void setArrays(List<Stripcategory> catList, List<Adddetum> addList, ViewHolder holder) {
        int firstList=0,secondList=0;
        final List<CategoryModel> mList = new ArrayList<>();
        final List<CategoryModel> mAddList = new ArrayList<>();
        for (Stripcategory detail : catList) {
            firstList++;
            mList.add(new CategoryModel("" + detail.getCatimgnew(), detail.getCategoryname(), detail.getCatId()));
//            if (firstList==4)break;

        }
        for (Adddetum detail : addList) {
            secondList++;
            mAddList.add(new CategoryModel("" + detail.getBanner(), detail.getId(), detail.getId()));
            if (secondList==2)break;
        }
        holder.stripCategoryRecycler.setNestedScrollingEnabled(false);
        holder.stripCategoryRecycler.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        holder.stripCategoryAdapter = new StripCategoryAdapter(context, mList);

        holder.stripAddRecycler.setNestedScrollingEnabled(false);
        holder.stripAddRecycler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        holder.stripAddAdapter = new StripAddvertAdapter(context, mAddList);
        holder.stripCategoryRecycler.setAdapter(holder.stripCategoryAdapter);
        holder.stripAddRecycler.setAdapter(holder.stripAddAdapter);
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
        @BindView(R.id.stripAddRecycler)
        RecyclerView stripAddRecycler;
        private StripCategoryAdapter stripCategoryAdapter;
        private StripAddvertAdapter stripAddAdapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
