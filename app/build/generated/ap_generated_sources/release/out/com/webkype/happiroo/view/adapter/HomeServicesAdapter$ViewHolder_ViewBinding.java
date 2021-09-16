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

public class HomeServicesAdapter$ViewHolder_ViewBinding implements Unbinder {
  private HomeServicesAdapter.ViewHolder target;

  @UiThread
  public HomeServicesAdapter$ViewHolder_ViewBinding(HomeServicesAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.homeServicesLayoutItem = Utils.findRequiredViewAsType(source, R.id.homeServicesLayoutItem, "field 'homeServicesLayoutItem'", LinearLayout.class);
    target.homeServicesImageItem = Utils.findRequiredViewAsType(source, R.id.homeServicesImageItem, "field 'homeServicesImageItem'", ImageView.class);
    target.homeServicesTxtItem = Utils.findRequiredViewAsType(source, R.id.homeServicesTxtItem, "field 'homeServicesTxtItem'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeServicesAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.homeServicesLayoutItem = null;
    target.homeServicesImageItem = null;
    target.homeServicesTxtItem = null;
  }
}
