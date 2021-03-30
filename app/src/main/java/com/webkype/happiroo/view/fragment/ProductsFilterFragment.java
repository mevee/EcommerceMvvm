package com.webkype.happiroo.view.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.webkype.happiroo.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsFilterFragment extends DialogFragment {
    public static final String TAG = "ProductsFilterFragment";

    @BindView(R.id.iv_close)
    ImageView iv_close;
    @BindView(R.id.et_minPrice)
    EditText et_minPrice;
    @BindView(R.id.et_maxPrice)
    EditText et_maxPrice;
    @BindView(R.id.btn_apply)
    Button btn_apply;
    @BindView(R.id.btn_reset)
    Button btn_reset;
    @BindView(R.id.rv_size)
    RecyclerView rv_size;

    @BindView(R.id.ll_size)
    LinearLayout ll_size;

    @BindView(R.id.rv_color)
    RecyclerView rv_color;
   /* private FilterAdapter sizeFilterAdapter;
    private FilterAdapter colorFilterAdapter;
    private List<FilterByModel> mSizeList = new ArrayList<>();
    private List<FilterByModel> mColorList = new ArrayList<>();
    private FilterListener listener;
*/
    private String valueSize;
    private String valueMin;
    private String valueMax;
    private String valueColor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.filter_products_layout, container, false);
    }

/*
    public void setListener(FilterListener listener) {
        this.listener = listener;
    }
*/

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        iv_close.setOnClickListener(v -> dismiss());
        btn_apply.setOnClickListener(v -> {
            valueMin = et_minPrice.getText().toString();
            valueMax = et_maxPrice.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("minVal", valueMin);
            bundle.putString("maxVal", valueMax);
            bundle.putString("sortSize", valueSize);
            bundle.putString("sortColor", valueColor);
           /* if (listener != null)
                listener.filterListener(FilterListener.APPLY_FILTER, bundle);
            else
                Toast.makeText(getContext(), "Reload Screen", Toast.LENGTH_SHORT).show();
           */ dismiss();
        });
        btn_reset.setOnClickListener(v -> {
            valueMin = null;
            valueMax = null;
            valueColor = null;
            valueSize = null;
        /*    if (listener != null)
                listener.filterListener(FilterListener.RESET_FILTER, null);
            else
                Toast.makeText(getContext(), "Reload Screen", Toast.LENGTH_SHORT).show();
          */  dismiss();
        });

      /*  sizeFilterAdapter = new FilterAdapter(getContext(), mSizeList, new CommonListener() {*/
     /*       @Override
            public void onClicked(int position, Actions action) {
                if (action == Actions.CLICKED) {
                    valueSize = mSizeList.get(position).getFilterName();
                }
            }
        });

        colorFilterAdapter = new FilterAdapter(getContext(), mColorList, new CommonListener() {
            @Override
            public void onClicked(int position, Actions action) {
                if (action == Actions.CLICKED) {
                    valueColor = mColorList.get(position).getFilterName();
                }
            }
        });*/

    /*    StaggeredGridLayoutManager stg1 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rv_size.setLayoutManager(stg1);
        rv_size.setAdapter(sizeFilterAdapter);

        StaggeredGridLayoutManager staggeredColor = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rv_color.setLayoutManager(staggeredColor);
        rv_color.setAdapter(colorFilterAdapter);

        if (!TextUtils.isEmpty(ProductListActivity.maxPrice)) {
            et_maxPrice.setText(ProductListActivity.maxPrice);
        }
        if (!TextUtils.isEmpty(ProductListActivity.minPrice)) {
            et_minPrice.setText(ProductListActivity.minPrice);
        }
        ll_size.setVisibility(View.VISIBLE);
*/
         /*
        if (!TextUtils.isEmpty(ServicesListActivity.sortRecen)) {
            valueByAdde = ServicesListActivity.sortRecen;
            if (SORT_BY_ADD.equals(valueByAdde)) {
                rg_sortBy.check(R.id.rb_recentAdded);
            } else if (SORT_BY_All.equals(valueByAdde)){
                rg_sortBy.setId(R.id.rb_old);
            }
        }*/
        /*setColorFiletrList();
        setSizeFilterList();*/

    }

  /*  private void setColorFiletrList() {
        if (ProductListActivity.mColorLIst.size() > 0) {
            mColorList.addAll(ProductListActivity.mColorLIst);

            colorFilterAdapter.notifyDataSetChanged();

            if (!TextUtils.isEmpty(ProductListActivity.sortColor)) {
                for (int i = 0; i < mColorList.size(); i++) {
                    FilterByModel model = mColorList.get(i);
                    if (model.getFilterName().equals(ProductListActivity.sortColor)) {
                        colorFilterAdapter.setChecked(i);
                    }
                }
            }
        }
    }

    private void setSizeFilterList() {
        if (ProductListActivity.mSizeLIst.size() > 0) {
            mSizeList.addAll(ProductListActivity.mSizeLIst);
            sizeFilterAdapter.notifyDataSetChanged();
            if (!TextUtils.isEmpty(ProductListActivity.sortSize)) {
                for (int i = 0; i < mSizeList.size(); i++) {
                    FilterByModel model = mSizeList.get(i);
                    if (model.getFilterName().equals(ProductListActivity.sortSize)) {
                        sizeFilterAdapter.setChecked(i);
                    }
                }
            }
        }
    }
*/
    @Override
    public void onStart() {
        super.onStart();

        // safety check
        if (getDialog() == null) {
            return;
        }

        // set the animations to use on showing and hiding the dialog
        getDialog().getWindow().setWindowAnimations(
                R.style.dialog_animation_fade);
        // alternative way of doing it
        //getDialog().getWindow().getAttributes().
        //    windowAnimations = R.style.dialog_animation_fade;

        // ... other stuff you want to do in your onStart() method
    }


    @Override
    public int getTheme() {
        return R.style.DialogTheme;
    }
}
