package com.webkype.happiroo.databinding;
import com.webkype.happiroo.R;
import com.webkype.happiroo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityListingBindingImpl extends ActivityListingBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.listingHeaderCard, 1);
        sViewsWithIds.put(R.id.backListing, 2);
        sViewsWithIds.put(R.id.cartListing, 3);
        sViewsWithIds.put(R.id.tv_cart_quantity, 4);
        sViewsWithIds.put(R.id.listingCatRecycler, 5);
        sViewsWithIds.put(R.id.main_listing, 6);
        sViewsWithIds.put(R.id.selectedListingServiceTxt, 7);
        sViewsWithIds.put(R.id.homeBannerViewPager, 8);
        sViewsWithIds.put(R.id.productListRecycler, 9);
        sViewsWithIds.put(R.id.cartLayoutListing, 10);
        sViewsWithIds.put(R.id.goCartListingLayout, 11);
        sViewsWithIds.put(R.id.tv_quantity, 12);
        sViewsWithIds.put(R.id.progressbar_listing, 13);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityListingBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityListingBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[2]
            , (android.widget.RelativeLayout) bindings[10]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.RelativeLayout) bindings[11]
            , (androidx.viewpager2.widget.ViewPager2) bindings[8]
            , (androidx.recyclerview.widget.RecyclerView) bindings[5]
            , (androidx.cardview.widget.CardView) bindings[1]
            , (androidx.core.widget.NestedScrollView) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[9]
            , (android.widget.ProgressBar) bindings[13]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[12]
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