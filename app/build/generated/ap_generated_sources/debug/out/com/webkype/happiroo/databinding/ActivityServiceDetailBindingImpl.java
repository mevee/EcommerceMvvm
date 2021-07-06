package com.webkype.happiroo.databinding;
import com.webkype.happiroo.R;
import com.webkype.happiroo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityServiceDetailBindingImpl extends ActivityServiceDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.main_service_detail, 1);
        sViewsWithIds.put(R.id.serviceDetailViewPager, 2);
        sViewsWithIds.put(R.id.headerVideoPlayer, 3);
        sViewsWithIds.put(R.id.pbVideo, 4);
        sViewsWithIds.put(R.id.rlIndicatorHolder, 5);
        sViewsWithIds.put(R.id.serviceDetailPagerIndicator, 6);
        sViewsWithIds.put(R.id.productsHeaderLayout, 7);
        sViewsWithIds.put(R.id.backServiceDetail, 8);
        sViewsWithIds.put(R.id.tv_title_service_detail, 9);
        sViewsWithIds.put(R.id.cartServiceDetail, 10);
        sViewsWithIds.put(R.id.tv_cart_quantity, 11);
        sViewsWithIds.put(R.id.serviceCatRecycler, 12);
        sViewsWithIds.put(R.id.serviceDetailAdImage, 13);
        sViewsWithIds.put(R.id.ll_video_detail, 14);
        sViewsWithIds.put(R.id.serviceDetailSampleVideo, 15);
        sViewsWithIds.put(R.id.tvRateCardTile, 16);
        sViewsWithIds.put(R.id.rateCardRecycler, 17);
        sViewsWithIds.put(R.id.tvwhyProfCleaning, 18);
        sViewsWithIds.put(R.id.rvProfCleanList, 19);
        sViewsWithIds.put(R.id.ivImgL2, 20);
        sViewsWithIds.put(R.id.ivImgL1, 21);
        sViewsWithIds.put(R.id.progressBar_service_detail, 22);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityServiceDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }
    private ActivityServiceDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[10]
            , (com.google.android.exoplayer2.ui.PlayerView) bindings[3]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.ImageView) bindings[20]
            , (android.widget.LinearLayout) bindings[14]
            , (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[1]
            , (android.widget.ProgressBar) bindings[4]
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.ProgressBar) bindings[22]
            , (androidx.recyclerview.widget.RecyclerView) bindings[17]
            , (android.widget.RelativeLayout) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[19]
            , (androidx.recyclerview.widget.RecyclerView) bindings[12]
            , (android.widget.ImageView) bindings[13]
            , (me.relex.circleindicator.CircleIndicator) bindings[6]
            , (android.widget.VideoView) bindings[15]
            , (androidx.viewpager.widget.ViewPager) bindings[2]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[18]
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