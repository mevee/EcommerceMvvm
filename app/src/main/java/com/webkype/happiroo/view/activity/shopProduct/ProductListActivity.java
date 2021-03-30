package com.webkype.happiroo.view.activity.shopProduct;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.network.NetworkProvider;
import com.webkype.happiroo.controller.network.responses.product_list.Product;
import com.webkype.happiroo.controller.network.responses.product_list.ProductListResp;
import com.webkype.happiroo.controller.pref.Preference;
import com.webkype.happiroo.controller.utils.CartUtils;
import com.webkype.happiroo.controller.utils.InternetConnectionCheck;
import com.webkype.happiroo.databinding.ActivityProductListBinding;
import com.webkype.happiroo.model.SortModel;
import com.webkype.happiroo.view.CommonListener;
import com.webkype.happiroo.view.activity.checout_process.CartActivity;
import com.webkype.happiroo.view.adapter.shopProduct.ItemAdapter;
import com.webkype.happiroo.view.fragment.ProductsFilterFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListActivity extends AppCompatActivity {
    private static final String TAG = ProductListActivity.class.getName();
    ActivityProductListBinding binding;
    private ItemAdapter itemAdapter;
    private List<Product> productdetailList = new ArrayList<>();
    private Context context;
    private String catId;
    private String catName;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list);
        context = this;
        if (getIntent().getExtras() != null) {
            catName = getIntent().getExtras().getString("cat");
            catId = getIntent().getExtras().getString("catId");
        }
        userId = Preference.getUser(this) != null ? Preference.getUser(this).getUserId() : "";

        String activeShopping = Preference.getActiveShopping(context);
        Log.d(TAG,"activeFlow"+activeShopping);
        Log.d(TAG,"CartId"+Preference.getCartId(this));
        Log.d(TAG,"uid"+userId);

        if (TextUtils.isEmpty(activeShopping)){
            Preference.setActiveShopping(context, "Product");
        }else if (activeShopping.equals("Service")){
            Preference.setCartId(this,"");
            Preference.setActiveShopping(context, "Product");
        }

        binding.ivBackBtn.setOnClickListener(v -> onBackPressed());
        itemAdapter = new ItemAdapter(this, productdetailList, new CommonListener() {
            @Override
            public void onClicked(int position, int action) {
                if (action == CommonListener.CLICKED) {
//                    Log.d(TAG, "item clicked ");
                    goToDetailPage(productdetailList.get(position).getId());
                }
            }
        });
        StaggeredGridLayoutManager stlm12 = new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL);
        binding.rvMore.setVisibility(View.VISIBLE);
        binding.rvMore.setLayoutManager(stlm12);
        binding.rvMore.setFocusable(false);
        binding.rvMore.setAdapter(itemAdapter);
//        binding.cardFilter.setVisibility(View.GONE);

/*        binding.rvMore.setOnScrollListener(new EndlessRecyclerViewScrollListener(stlm12) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (productdetailList.size() != totalProduct) {

                    if (pageCount <= totalProduct) {
                        pageCount = pageCount + pageSize;
                        getProductList();
                    } else {
                        //Toast.makeText(context, R.string.no_more_products, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Toast.makeText(context, R.string.no_more_products, Toast.LENGTH_SHORT).show();
                }
            }
        });*/
/*
        binding.etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
//                    searchKey = et_search.getText().toString();

                    if (TextUtils.isEmpty(searchKey)) {
                        Toast.makeText(context, "add some key", Toast.LENGTH_SHORT).show();
                        return false;
                    } else {
                        getProductList();
                        hideKeyboard(ProductListActivity.this);
                        return true;
                    }
                }
                return false;
            }
        });
*/
        binding.cartServiceDetail.setOnClickListener(v -> startActivity(new Intent(context, CartActivity.class)));
        binding.cardFilter.setOnClickListener(v -> showFilterScreen());
        binding.cardFilter.setVisibility(View.GONE);


        getProductList();
/*
        loadData();
*/
    }

    private void showFilterScreen() {
        ProductsFilterFragment filterView = new ProductsFilterFragment();
        filterView.showNow(getSupportFragmentManager(), ProductsFilterFragment.TAG);
    }

    private void goToDetailPage(String pid) {
        Intent intent = new Intent(this, ShopProductDetailActivity.class);
        intent.putExtra("pid", pid);
        startActivity(intent);
    }

    private void loadData() {
      /*  MyProduct product1 = new MyProduct("Denim jeans of pure denim for all sizeses",
                "700", "0",
                "https://5.imimg.com/data5/BO/TO/MY-34122381/img-20171006-wa0178-500x500.jpg",
                1.5f, "1",
                "this is beautifull denim to fo everyon ehsooas asn sndnfjdkv /zmkznckds",
                "1", "1000", "grey",
                "XYZ", "0", "0", "0");
        MyProduct product2 = new MyProduct("Denim jeans of pure denim for all sizeses",
                "500", "0",
                "https://images-na.ssl-images-amazon.com/images/I/71xTbz9Q-EL._UL1500_.jpg",
                2.5f, "1",
                "this is wenfkjnkjdfkjkdn denim to fo everyon ehsooas asn sndnfjdkv /zmkznckds",
                "2", "500", "white",
                "XYZ", "0", "0", "1");


        productdetailList.add(product1);
        productdetailList.add(product2);
        productdetailList.add(product1);
        productdetailList.add(product2);
        productdetailList.add(product2);
*/
/*
        binding.progressBarProductList.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.progressBarProductList.setVisibility(View.GONE);
                itemAdapter.notifyDataSetChanged();
                setAdapters();
            }
        }, 4000);
 */
    }

  /*  private void showFilterScreen() {
//        card_filter.setEnabled(false);
        ProductsFilterFragment filterView = new ProductsFilterFragment();
        filterView.setListener(new FilterListener() {
            @Override
            public void filterListener(int action, Bundle bundle) {
                if (action == FilterListener.RESET_FILTER) {
                    ProductListActivity.minPrice = null;
                    ProductListActivity.maxPrice = null;
                    ProductListActivity.sortColor = null;
                    ProductListActivity.sortSize = null;
                    getProductList();
                    card_filter.setCardBackgroundColor(getResources().getColor(R.color.white));

                } else if (action == FilterListener.APPLY_FILTER) {

                    ProductListActivity.minPrice = bundle.getString("minVal", "");
                    ProductListActivity.maxPrice = bundle.getString("maxVal", "");
                    ProductListActivity.sortSize = bundle.getString("sortSize", "");
                    ProductListActivity.sortColor = bundle.getString("sortColor", "");
//                    getProductList();
                    card_filter.setCardBackgroundColor(getResources().getColor(R.color.colorAccent));
                }
            }
        });
        filterView.showNow(getSupportFragmentManager(), ProductsFilterFragment.TAG);
        card_filter.setEnabled(true);
    }*/

    private void getProductList() {
        if (InternetConnectionCheck.haveNetworkConnection(this)) {
            binding.progressBarProductList.setVisibility(View.VISIBLE);
            NetworkProvider.instance().getSellProduct(catId, userId).enqueue(new Callback<ProductListResp>() {
                @Override
                public void onResponse(Call<ProductListResp> call, Response<ProductListResp> response) {
                    binding.progressBarProductList.setVisibility(View.GONE);
//                    binding.progressBarShopCat.setVisibility(View.VISIBLE);
                    binding.cardFilter.setVisibility(View.VISIBLE);

                    ProductListResp resp = response.body();
                    if ("200".equals(resp.getStatus())) {

                        if (resp.getProductList() != null && resp.getProductList().size() > 0) {
                            binding.noDataView.setVisibility(View.GONE);
                            productdetailList.clear();
                            productdetailList.addAll(resp.getProductList());
                            binding.progressBarProductList.setVisibility(View.GONE);
                        } else {
                            productdetailList.clear();
                            binding.noDataView.setVisibility(View.VISIBLE);
                        }
                        itemAdapter.notifyDataSetChanged();
                        setAdapters();

                    } else {
                        Toast.makeText(context, "" + resp.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ProductListResp> call, Throwable t) {
                    binding.progressBarProductList.setVisibility(View.GONE);
                    Log.d(TAG, "" + t.getMessage());
                }
            });

        } else {
            Toast.makeText(context, "Check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }


    void setAdapters() {
        List<SortModel> sortedByOptions = new ArrayList<>();
        sortedByOptions.add(new SortModel("Sort By", null));
        sortedByOptions.add(new SortModel("New Arrival", "id desc"));
        sortedByOptions.add(new SortModel("Popularity", "rating desc"));
        sortedByOptions.add(new SortModel("Rating", "rating desc"));
        sortedByOptions.add(new SortModel("Price: Low to High", "sellingprice asc"));
        sortedByOptions.add(new SortModel("Price: High to Low", "sellingprice desc"));

        ArrayAdapter<SortModel> sortedBy = new ArrayAdapter<>(this, R.layout.spinner_item, sortedByOptions);
        binding.spSortedBy.setAdapter(sortedBy);
        binding.spSortedBy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String val = binding.spSortedBy.getSelectedItem().toString();

              /*  if (val.equals("Sort By")) {
                    orderby = null;
                    if (isloadingFirstTimeCheckForSortFilter) {
                        isloadingFirstTimeCheckForSortFilter = false;
                    } else {
                        pageCount=0;
                        getProductList();
                    }
                } else {
                    for (int j = 0; j < sortedByOptions.size(); j++) {
                        SortModel model = sortedByOptions.get(j);
                        if (model.getSortTitle().equals(val)) {
                            orderby = model.getSortValue();
                            pageCount=0;
                            getProductList();
                        }
                    }
                }
*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        CartUtils.getCartDetail(binding.tvCartQuantityProdList,context, Preference.getCartId(context));
    }

}