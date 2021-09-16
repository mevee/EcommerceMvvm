// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RateCardAdapter$ViewHolder_ViewBinding implements Unbinder {
  private RateCardAdapter.ViewHolder target;

  @UiThread
  public RateCardAdapter$ViewHolder_ViewBinding(RateCardAdapter.ViewHolder target, View source) {
    this.target = target;

    target.rateCardImageItem = Utils.findRequiredViewAsType(source, R.id.rateCardImageItem, "field 'rateCardImageItem'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RateCardAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rateCardImageItem = null;
  }
}
