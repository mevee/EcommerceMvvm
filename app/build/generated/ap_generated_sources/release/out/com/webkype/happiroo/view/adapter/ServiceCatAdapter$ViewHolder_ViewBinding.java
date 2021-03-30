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

public class ServiceCatAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ServiceCatAdapter.ViewHolder target;

  @UiThread
  public ServiceCatAdapter$ViewHolder_ViewBinding(ServiceCatAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.serviceCatLayoutItem = Utils.findRequiredViewAsType(source, R.id.serviceCatLayoutItem, "field 'serviceCatLayoutItem'", LinearLayout.class);
    target.serviceCatImageItem = Utils.findRequiredViewAsType(source, R.id.service_image, "field 'serviceCatImageItem'", ImageView.class);
    target.serviceCatTxtItem = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'serviceCatTxtItem'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ServiceCatAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.serviceCatLayoutItem = null;
    target.serviceCatImageItem = null;
    target.serviceCatTxtItem = null;
  }
}
