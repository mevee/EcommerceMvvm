// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProductsFilterFragment_ViewBinding implements Unbinder {
  private ProductsFilterFragment target;

  @UiThread
  public ProductsFilterFragment_ViewBinding(ProductsFilterFragment target, View source) {
    this.target = target;

    target.iv_close = Utils.findRequiredViewAsType(source, R.id.iv_close, "field 'iv_close'", ImageView.class);
    target.et_minPrice = Utils.findRequiredViewAsType(source, R.id.et_minPrice, "field 'et_minPrice'", EditText.class);
    target.et_maxPrice = Utils.findRequiredViewAsType(source, R.id.et_maxPrice, "field 'et_maxPrice'", EditText.class);
    target.btn_apply = Utils.findRequiredViewAsType(source, R.id.btn_apply, "field 'btn_apply'", Button.class);
    target.btn_reset = Utils.findRequiredViewAsType(source, R.id.btn_reset, "field 'btn_reset'", Button.class);
    target.rv_size = Utils.findRequiredViewAsType(source, R.id.rv_size, "field 'rv_size'", RecyclerView.class);
    target.ll_size = Utils.findRequiredViewAsType(source, R.id.ll_size, "field 'll_size'", LinearLayout.class);
    target.rv_color = Utils.findRequiredViewAsType(source, R.id.rv_color, "field 'rv_color'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductsFilterFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.iv_close = null;
    target.et_minPrice = null;
    target.et_maxPrice = null;
    target.btn_apply = null;
    target.btn_reset = null;
    target.rv_size = null;
    target.ll_size = null;
    target.rv_color = null;
  }
}
