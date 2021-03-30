package com.webkype.happiroo.databinding;
import com.webkype.happiroo.R;
import com.webkype.happiroo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityShopProductDetailActivityBindingImpl extends ActivityShopProductDetailActivityBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.nsv_main, 1);
        sViewsWithIds.put(R.id.vp_product_detail, 2);
        sViewsWithIds.put(R.id.tv_currentimage, 3);
        sViewsWithIds.put(R.id.iv_fav, 4);
        sViewsWithIds.put(R.id.tv_product_name, 5);
        sViewsWithIds.put(R.id.tv_selling_price, 6);
        sViewsWithIds.put(R.id.tv_cost_price, 7);
        sViewsWithIds.put(R.id.ll_rating_detail, 8);
        sViewsWithIds.put(R.id.rb_rating, 9);
        sViewsWithIds.put(R.id.tv_rating, 10);
        sViewsWithIds.put(R.id.tv_no_of_sold, 11);
        sViewsWithIds.put(R.id.ll_variant, 12);
        sViewsWithIds.put(R.id.rv_varients, 13);
        sViewsWithIds.put(R.id.tv_seller_name, 14);
        sViewsWithIds.put(R.id.iv_minus, 15);
        sViewsWithIds.put(R.id.tv_qnt, 16);
        sViewsWithIds.put(R.id.iv_add, 17);
        sViewsWithIds.put(R.id.tv_total_amount, 18);
        sViewsWithIds.put(R.id.tv_desc, 19);
        sViewsWithIds.put(R.id.rv_extra_images, 20);
        sViewsWithIds.put(R.id.card_review, 21);
        sViewsWithIds.put(R.id.rb_rating_review, 22);
        sViewsWithIds.put(R.id.tv_rating_and_total_review, 23);
        sViewsWithIds.put(R.id.tv_no_ratings, 24);
        sViewsWithIds.put(R.id.rv_ratings, 25);
        sViewsWithIds.put(R.id.iv_back, 26);
        sViewsWithIds.put(R.id.iv_cart, 27);
        sViewsWithIds.put(R.id.tvCartQntt, 28);
        sViewsWithIds.put(R.id.ll_bottom_buttons, 29);
        sViewsWithIds.put(R.id.tvBtnAddToCart, 30);
        sViewsWithIds.put(R.id.progress_bar, 31);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityShopProductDetailActivityBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 32, sIncludes, sViewsWithIds));
    }
    private ActivityShopProductDetailActivityBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[21]
            , (android.widget.ImageView) bindings[17]
            , (android.widget.ImageView) bindings[26]
            , (android.widget.ImageView) bindings[27]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.LinearLayout) bindings[29]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[12]
            , (androidx.core.widget.NestedScrollView) bindings[1]
            , (android.widget.ProgressBar) bindings[31]
            , (android.widget.RatingBar) bindings[9]
            , (android.widget.RatingBar) bindings[22]
            , (androidx.recyclerview.widget.RecyclerView) bindings[20]
            , (androidx.recyclerview.widget.RecyclerView) bindings[25]
            , (androidx.recyclerview.widget.RecyclerView) bindings[13]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[18]
            , (androidx.viewpager.widget.ViewPager) bindings[2]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}