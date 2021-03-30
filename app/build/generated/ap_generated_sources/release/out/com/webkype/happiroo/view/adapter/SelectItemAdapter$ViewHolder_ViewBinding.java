// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelectItemAdapter$ViewHolder_ViewBinding implements Unbinder {
  private SelectItemAdapter.ViewHolder target;

  @UiThread
  public SelectItemAdapter$ViewHolder_ViewBinding(SelectItemAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.tv_item = Utils.findRequiredViewAsType(source, R.id.tv_item, "field 'tv_item'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SelectItemAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_item = null;
  }
}
