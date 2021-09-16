// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StripAddvertAdapter$ViewHolder_ViewBinding implements Unbinder {
  private StripAddvertAdapter.ViewHolder target;

  @UiThread
  public StripAddvertAdapter$ViewHolder_ViewBinding(StripAddvertAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.stripCatLayoutItem = Utils.findRequiredViewAsType(source, R.id.stripCatLayoutItem, "field 'stripCatLayoutItem'", ConstraintLayout.class);
    target.stripCatImageItem = Utils.findRequiredViewAsType(source, R.id.stripCatImageItem, "field 'stripCatImageItem'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StripAddvertAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.stripCatLayoutItem = null;
    target.stripCatImageItem = null;
  }
}
