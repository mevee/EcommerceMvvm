// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelectItemWithImageAdapter$ViewHolder_ViewBinding implements Unbinder {
  private SelectItemWithImageAdapter.ViewHolder target;

  @UiThread
  public SelectItemWithImageAdapter$ViewHolder_ViewBinding(
      SelectItemWithImageAdapter.ViewHolder target, View source) {
    this.target = target;

    target.ll_payment_layout = Utils.findRequiredViewAsType(source, R.id.ll_payment_layout, "field 'll_payment_layout'", LinearLayout.class);
    target.tv_modename = Utils.findRequiredViewAsType(source, R.id.tv_modename, "field 'tv_modename'", TextView.class);
    target.cod_rB = Utils.findRequiredViewAsType(source, R.id.cod_rB, "field 'cod_rB'", RadioButton.class);
    target.iv_modeicon = Utils.findRequiredViewAsType(source, R.id.iv_modeicon, "field 'iv_modeicon'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SelectItemWithImageAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ll_payment_layout = null;
    target.tv_modename = null;
    target.cod_rB = null;
    target.iv_modeicon = null;
  }
}
