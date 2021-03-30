package com.webkype.happiroo.databinding;
import com.webkype.happiroo.R;
import com.webkype.happiroo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityAddEditAddressBindingImpl extends ActivityAddEditAddressBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.addEditAddressHeaderCard, 1);
        sViewsWithIds.put(R.id.backAddEditAddress, 2);
        sViewsWithIds.put(R.id.etNameAddress, 3);
        sViewsWithIds.put(R.id.etMobileAddress, 4);
        sViewsWithIds.put(R.id.etCountry, 5);
        sViewsWithIds.put(R.id.etState, 6);
        sViewsWithIds.put(R.id.etCity, 7);
        sViewsWithIds.put(R.id.etLocality, 8);
        sViewsWithIds.put(R.id.etFullAddress, 9);
        sViewsWithIds.put(R.id.changeCurrentAddress_tV, 10);
        sViewsWithIds.put(R.id.rv_address_type_list, 11);
        sViewsWithIds.put(R.id.updateAddressCard, 12);
        sViewsWithIds.put(R.id.progressbarAddAddress, 13);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityAddEditAddressBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityAddEditAddressBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[1]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[10]
            , (android.widget.EditText) bindings[7]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[9]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[4]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[6]
            , (android.widget.ProgressBar) bindings[13]
            , (androidx.recyclerview.widget.RecyclerView) bindings[11]
            , (androidx.cardview.widget.CardView) bindings[12]
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