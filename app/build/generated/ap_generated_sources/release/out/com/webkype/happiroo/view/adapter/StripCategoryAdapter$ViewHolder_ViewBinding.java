// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StripCategoryAdapter$ViewHolder_ViewBinding implements Unbinder {
  private StripCategoryAdapter.ViewHolder target;

  @UiThread
  public StripCategoryAdapter$ViewHolder_ViewBinding(StripCategoryAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.stripCatLayoutItem = Utils.findRequiredViewAsType(source, R.id.stripCatLayoutItem, "field 'stripCatLayoutItem'", LinearLayout.class);
    target.stripCatImageItem = Utils.findRequiredViewAsType(source, R.id.stripCatImageItem, "field 'stripCatImageItem'", ImageView.class);
    target.stripCatTextItem = Utils.findRequiredViewAsType(source, R.id.stripCatTextItem, "field 'stripCatTextItem'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StripCategoryAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.stripCatLayoutItem = null;
    target.stripCatImageItem = null;
    target.stripCatTextItem = null;
  }
}
