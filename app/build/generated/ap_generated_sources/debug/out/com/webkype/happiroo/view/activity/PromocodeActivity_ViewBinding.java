// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PromocodeActivity_ViewBinding implements Unbinder {
  private PromocodeActivity target;

  private View view7f0a006a;

  private View view7f0a0057;

  @UiThread
  public PromocodeActivity_ViewBinding(PromocodeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PromocodeActivity_ViewBinding(final PromocodeActivity target, View source) {
    this.target = target;

    View view;
    target.rv_promo_code_list = Utils.findRequiredViewAsType(source, R.id.rv_promo_code_list, "field 'rv_promo_code_list'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.backPromo, "method 'onClick'");
    view7f0a006a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.applyPromoCodeRelativeBtn, "method 'onClick'");
    view7f0a0057 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    PromocodeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv_promo_code_list = null;

    view7f0a006a.setOnClickListener(null);
    view7f0a006a = null;
    view7f0a0057.setOnClickListener(null);
    view7f0a0057 = null;
  }
}
