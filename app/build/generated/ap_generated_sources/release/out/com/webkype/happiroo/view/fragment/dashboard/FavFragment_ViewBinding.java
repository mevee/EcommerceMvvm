// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.fragment.dashboard;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FavFragment_ViewBinding implements Unbinder {
  private FavFragment target;

  @UiThread
  public FavFragment_ViewBinding(FavFragment target, View source) {
    this.target = target;

    target.ll_no_fav_data = Utils.findRequiredViewAsType(source, R.id.ll_no_fav_data, "field 'll_no_fav_data'", LinearLayout.class);
    target.rv_fav_service = Utils.findRequiredViewAsType(source, R.id.rv_fav_service, "field 'rv_fav_service'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FavFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ll_no_fav_data = null;
    target.rv_fav_service = null;
  }
}
