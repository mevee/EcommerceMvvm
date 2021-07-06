// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.activity.checout_process;

import android.view.View;
import android.widget.RadioButton;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CovidMessageActivity_ViewBinding implements Unbinder {
  private CovidMessageActivity target;

  private View view7f0a0065;

  private View view7f0a00b8;

  @UiThread
  public CovidMessageActivity_ViewBinding(CovidMessageActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CovidMessageActivity_ViewBinding(final CovidMessageActivity target, View source) {
    this.target = target;

    View view;
    target.covidAgree_rB = Utils.findRequiredViewAsType(source, R.id.covidAgree_rB, "field 'covidAgree_rB'", RadioButton.class);
    view = Utils.findRequiredView(source, R.id.backMessage, "method 'onClick'");
    view7f0a0065 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.covidIAgreeRelative, "method 'onClick'");
    view7f0a00b8 = view;
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
    CovidMessageActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.covidAgree_rB = null;

    view7f0a0065.setOnClickListener(null);
    view7f0a0065 = null;
    view7f0a00b8.setOnClickListener(null);
    view7f0a00b8 = null;
  }
}
