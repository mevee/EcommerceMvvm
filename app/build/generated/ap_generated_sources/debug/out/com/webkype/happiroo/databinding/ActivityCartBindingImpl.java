package com.webkype.happiroo.databinding;
import com.webkype.happiroo.R;
import com.webkype.happiroo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCartBindingImpl extends ActivityCartBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(19);
        sIncludes.setIncludes(1, 
            new String[] {"price_detail_layout"},
            new int[] {2},
            new int[] {com.webkype.happiroo.R.layout.price_detail_layout});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cartHeaderCard, 3);
        sViewsWithIds.put(R.id.backCart, 4);
        sViewsWithIds.put(R.id.main_cart, 5);
        sViewsWithIds.put(R.id.rlWallet, 6);
        sViewsWithIds.put(R.id.cbWallet, 7);
        sViewsWithIds.put(R.id.tv_wallet_balance, 8);
        sViewsWithIds.put(R.id.tv_you_used, 9);
        sViewsWithIds.put(R.id.applyPromoRelative, 10);
        sViewsWithIds.put(R.id.rv_items_in_cart, 11);
        sViewsWithIds.put(R.id.rl_continue_pay_layout, 12);
        sViewsWithIds.put(R.id.continueToPayRelative, 13);
        sViewsWithIds.put(R.id.tvToBePaid, 14);
        sViewsWithIds.put(R.id.ll_not_logged, 15);
        sViewsWithIds.put(R.id.tv_btn_login, 16);
        sViewsWithIds.put(R.id.ll_empty_cart, 17);
        sViewsWithIds.put(R.id.progressbar_cart, 18);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityCartBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private ActivityCartBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.RelativeLayout) bindings[10]
            , (android.widget.ImageView) bindings[4]
            , (androidx.cardview.widget.CardView) bindings[3]
            , (android.widget.CheckBox) bindings[7]
            , (android.widget.RelativeLayout) bindings[13]
            , (com.webkype.happiroo.databinding.PriceDetailLayoutBinding) bindings[2]
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.LinearLayout) bindings[15]
            , (androidx.core.widget.NestedScrollView) bindings[5]
            , (android.widget.ProgressBar) bindings[18]
            , (android.widget.RelativeLayout) bindings[12]
            , (android.widget.RelativeLayout) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[11]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        costDistrLayout.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (costDistrLayout.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        costDistrLayout.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeCostDistrLayout((com.webkype.happiroo.databinding.PriceDetailLayoutBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeCostDistrLayout(com.webkype.happiroo.databinding.PriceDetailLayoutBinding CostDistrLayout, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        executeBindingsOn(costDistrLayout);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): costDistrLayout
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}