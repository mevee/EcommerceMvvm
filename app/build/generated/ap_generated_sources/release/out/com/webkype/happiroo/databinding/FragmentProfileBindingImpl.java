package com.webkype.happiroo.databinding;
import com.webkype.happiroo.R;
import com.webkype.happiroo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentProfileBindingImpl extends FragmentProfileBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_user_name_profile, 1);
        sViewsWithIds.put(R.id.tv_user_email_profile, 2);
        sViewsWithIds.put(R.id.tv_user_mobile_profile, 3);
        sViewsWithIds.put(R.id.editProfile_iV, 4);
        sViewsWithIds.put(R.id.myOrdersLinear, 5);
        sViewsWithIds.put(R.id.myFavProducts, 6);
        sViewsWithIds.put(R.id.myCartLinear, 7);
        sViewsWithIds.put(R.id.myFavServices, 8);
        sViewsWithIds.put(R.id.notificationLinear, 9);
        sViewsWithIds.put(R.id.referEarnLinear, 10);
        sViewsWithIds.put(R.id.llAboutUs, 11);
        sViewsWithIds.put(R.id.llProfileShareApp, 12);
        sViewsWithIds.put(R.id.llProfileRateApp, 13);
        sViewsWithIds.put(R.id.ll_tnc, 14);
        sViewsWithIds.put(R.id.ll_faq, 15);
        sViewsWithIds.put(R.id.ll_logout_profile, 16);
        sViewsWithIds.put(R.id.ll_login_profile, 17);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentProfileBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private FragmentProfileBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[4]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.FrameLayout) bindings[7]
            , (android.widget.FrameLayout) bindings[6]
            , (android.widget.FrameLayout) bindings[8]
            , (android.widget.FrameLayout) bindings[5]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[1]
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