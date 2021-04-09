// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;
import me.relex.circleindicator.CircleIndicator;

public class WalkThroughActivity_ViewBinding implements Unbinder {
  private WalkThroughActivity target;

  private View view7f0a0274;

  private View view7f0a007f;

  @UiThread
  public WalkThroughActivity_ViewBinding(WalkThroughActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WalkThroughActivity_ViewBinding(final WalkThroughActivity target, View source) {
    this.target = target;

    View view;
    target.welcomeViewPager = Utils.findRequiredViewAsType(source, R.id.welcomeViewPager, "field 'welcomeViewPager'", ViewPager.class);
    target.welcomePagerIndicator = Utils.findRequiredViewAsType(source, R.id.welcomePagerIndicator, "field 'welcomePagerIndicator'", CircleIndicator.class);
    target.btnWelcomeTxt = Utils.findRequiredViewAsType(source, R.id.btnWelcomeTxt, "field 'btnWelcomeTxt'", TextView.class);
    view = Utils.findRequiredView(source, R.id.skipWelcome_tV, "method 'onClick'");
    view7f0a0274 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnWelcomeCard, "method 'onClick'");
    view7f0a007f = view;
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
    WalkThroughActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.welcomeViewPager = null;
    target.welcomePagerIndicator = null;
    target.btnWelcomeTxt = null;

    view7f0a0274.setOnClickListener(null);
    view7f0a0274 = null;
    view7f0a007f.setOnClickListener(null);
    view7f0a007f = null;
  }
}
