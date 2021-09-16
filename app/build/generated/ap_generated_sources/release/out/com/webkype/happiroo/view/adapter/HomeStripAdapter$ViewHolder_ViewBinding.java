// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeStripAdapter$ViewHolder_ViewBinding implements Unbinder {
  private HomeStripAdapter.ViewHolder target;

  @UiThread
  public HomeStripAdapter$ViewHolder_ViewBinding(HomeStripAdapter.ViewHolder target, View source) {
    this.target = target;

    target.homeStripItemName = Utils.findRequiredViewAsType(source, R.id.homeStripItemName, "field 'homeStripItemName'", TextView.class);
    target.stripCategoryRecycler = Utils.findRequiredViewAsType(source, R.id.stripCategoryRecycler, "field 'stripCategoryRecycler'", RecyclerView.class);
    target.stripAddRecycler = Utils.findRequiredViewAsType(source, R.id.stripAddRecycler, "field 'stripAddRecycler'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeStripAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.homeStripItemName = null;
    target.stripCategoryRecycler = null;
    target.stripAddRecycler = null;
  }
}
