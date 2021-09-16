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

public class FetchLocationActivity_ViewBinding implements Unbinder {
  private FetchLocationActivity target;

  private View view7f0a0062;

  private View view7f0a00ba;

  private View view7f0a0259;

  @UiThread
  public FetchLocationActivity_ViewBinding(FetchLocationActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public FetchLocationActivity_ViewBinding(final FetchLocationActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.backFetchLocation, "method 'onClick'");
    view7f0a0062 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.currentLocationLinear, "method 'onClick'");
    view7f0a00ba = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.searchLocationLinear, "method 'onClick'");
    view7f0a0259 = view;
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
    view7f0a00ba.setOnClickListener(null);
    view7f0a00ba = null;
    view7f0a0259.setOnClickListener(null);
    view7f0a0259 = null;
  }
}
