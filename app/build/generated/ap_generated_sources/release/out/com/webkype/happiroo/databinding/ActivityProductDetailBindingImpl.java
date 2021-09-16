package com.webkype.happiroo.databinding;
import com.webkype.happiroo.R;
import com.webkype.happiroo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityProductDetailBindingImpl extends ActivityProductDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.pdpHeaderCard, 1);
        sViewsWithIds.put(R.id.backPdp, 2);
        sViewsWithIds.put(R.id.cartPdp, 3);
        sViewsWithIds.put(R.id.tv_cart_quantity, 4);
        sViewsWithIds.put(R.id.main_detail, 5);
        sViewsWithIds.put(R.id.serviceDetailViewPager, 6);
        sViewsWithIds.put(R.id.productFavImage, 7);
        sViewsWithIds.put(R.id.tv_service_name, 8);
        sViewsWithIds.put(R.id.pdpCostPrice, 9);
        sViewsWithIds.put(R.id.pdpSellingPrice, 10);
        sViewsWithIds.put(R.id.pdpAddToCart, 11);
        sViewsWithIds.put(R.id.pdpCounterLayout, 12);
        sViewsWithIds.put(R.id.tvBtnSubtract, 13);
        sViewsWithIds.put(R.id.tvCartCount, 14);
        sViewsWithIds.put(R.id.tvBtnAdd, 15);
        sViewsWithIds.put(R.id.tv_process_time, 16);
        sViewsWithIds.put(R.id.tv_small_detail, 17);
        sViewsWithIds.put(R.id.tv_includes, 18);
        sViewsWithIds.put(R.id.tv_what_excluded, 19);
        sViewsWithIds.put(R.id.brand_used, 20);
        sViewsWithIds.put(R.id.equipment_used, 21);
        sViewsWithIds.put(R.id.tv_additional_detail, 22);
        sViewsWithIds.put(R.id.tv_assurance, 23);
        sViewsWithIds.put(R.id.tvServiceDetailRating, 24);
        sViewsWithIds.put(R.id.addRatingBtn_tV, 25);
        sViewsWithIds.put(R.id.rv_customer_review_list, 26);
        sViewsWithIds.put(R.id.cartLayoutPdp, 27);
        sViewsWithIds.put(R.id.goCartPdpLayout, 28);
        sViewsWithIds.put(R.id.tvCartTotal, 29);
        sViewsWithIds.put(R.id.progressbar_product_detail, 30);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityProductDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 31, sIncludes, sViewsWithIds));
    }
    private ActivityProductDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.webkype.happiroo.controller.utils.UnderlineTextView) bindings[25]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[20]
            , (android.widget.RelativeLayout) bindings[27]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.TextView) bindings[21]
            , (android.widget.RelativeLayout) bindings[28]
            , (androidx.core.widget.NestedScrollView) bindings[5]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[9]
            , (android.widget.LinearLayout) bindings[12]
            , (androidx.cardview.widget.CardView) bindings[1]
            , (android.widget.TextView) bindings[10]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.ProgressBar) bindings[30]
            , (androidx.recyclerview.widget.RecyclerView) bindings[26]
            , (androidx.viewpager.widget.ViewPager) bindings[6]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[19]
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