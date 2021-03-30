package com.webkype.happiroo.databinding;
import com.webkype.happiroo.R;
import com.webkype.happiroo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentHomeBindingImpl extends FragmentHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.main_layout, 1);
        sViewsWithIds.put(R.id.homeLocationAddLayout, 2);
        sViewsWithIds.put(R.id.homeLocationAddTxt, 3);
        sViewsWithIds.put(R.id.homeSwipeRefresh, 4);
        sViewsWithIds.put(R.id.homeBannerViewPager, 5);
        sViewsWithIds.put(R.id.rlShopping, 6);
        sViewsWithIds.put(R.id.homeShoppingPager, 7);
        sViewsWithIds.put(R.id.homeAdPagerIndicator, 8);
        sViewsWithIds.put(R.id.homeServicesRecycler, 9);
        sViewsWithIds.put(R.id.homeStripRecycler, 10);
        sViewsWithIds.put(R.id.progressbar, 11);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragmentHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (me.relex.circleindicator.CircleIndicator) bindings[8]
            , (androidx.viewpager.widget.ViewPager) bindings[5]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (androidx.recyclerview.widget.RecyclerView) bindings[9]
            , (androidx.viewpager.widget.ViewPager) bindings[7]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) bindings[4]
            , (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[1]
            , (android.widget.ProgressBar) bindings[11]
            , (android.widget.RelativeLayout) bindings[6]
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