package com.webkype.happiroo.databinding;
import com.webkype.happiroo.R;
import com.webkype.happiroo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityBookingDetailBindingImpl extends ActivityBookingDetailBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.bookingDetailHeaderCard, 1);
        sViewsWithIds.put(R.id.backBookingDetail, 2);
        sViewsWithIds.put(R.id.tvServiceNameBd, 3);
        sViewsWithIds.put(R.id.bookingDetailStatusTxt, 4);
        sViewsWithIds.put(R.id.bookingDetailHelpBtn, 5);
        sViewsWithIds.put(R.id.main_layout_booking_detail, 6);
        sViewsWithIds.put(R.id.cancelBookingLayout, 7);
        sViewsWithIds.put(R.id.tvBookingStatusBd, 8);
        sViewsWithIds.put(R.id.otpBookingLayout, 9);
        sViewsWithIds.put(R.id.tvServiceOtp, 10);
        sViewsWithIds.put(R.id.vendorImageItem, 11);
        sViewsWithIds.put(R.id.ivVendorImageBd, 12);
        sViewsWithIds.put(R.id.tv_vendor_name_bd, 13);
        sViewsWithIds.put(R.id.tv_vendor_rating_bd, 14);
        sViewsWithIds.put(R.id.ivTotalVendorRaingsBd, 15);
        sViewsWithIds.put(R.id.addReviewVendorBtn, 16);
        sViewsWithIds.put(R.id.tvBookingIdBd, 17);
        sViewsWithIds.put(R.id.tvServiceAddressBd, 18);
        sViewsWithIds.put(R.id.tvServiceTimingBd, 19);
        sViewsWithIds.put(R.id.rvServiceInclude, 20);
        sViewsWithIds.put(R.id.tvAmountPaid, 21);
        sViewsWithIds.put(R.id.progressbarBookingDetail, 22);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityBookingDetailBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }
    private ActivityBookingDetailBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[16]
            , (android.widget.ImageView) bindings[2]
            , (androidx.cardview.widget.CardView) bindings[1]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.TextView) bindings[15]
            , (android.widget.ImageView) bindings[12]
            , (androidx.core.widget.NestedScrollView) bindings[6]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.ProgressBar) bindings[22]
            , (androidx.recyclerview.widget.RecyclerView) bindings[20]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (androidx.cardview.widget.CardView) bindings[11]
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