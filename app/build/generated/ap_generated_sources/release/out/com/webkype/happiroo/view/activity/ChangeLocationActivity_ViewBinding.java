// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChangeLocationActivity_ViewBinding implements Unbinder {
  private ChangeLocationActivity target;

  private View view7f0a0062;

  private View view7f0a00bc;

  @UiThread
  public ChangeLocationActivity_ViewBinding(ChangeLocationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ChangeLocationActivity_ViewBinding(final ChangeLocationActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.backChangeLocation, "method 'onClick'");
    view7f0a0062 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.currentLocationRelative, "method 'onClick'");
    view7f0a00bc = view;
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
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f0a0062.setOnClickListener(null);
    view7f0a0062 = null;
    view7f0a00bc.setOnClickListener(null);
    view7f0a00bc = null;
  }
}
