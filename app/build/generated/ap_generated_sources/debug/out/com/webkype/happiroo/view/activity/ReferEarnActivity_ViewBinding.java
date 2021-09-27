// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.activity;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReferEarnActivity_ViewBinding implements Unbinder {
  private ReferEarnActivity target;

  private View view7f0a006c;

  private View view7f0a0346;

  private View view7f0a0126;

  private View view7f0a032c;

  private View view7f0a00b5;

  private View view7f0a0157;

  private View view7f0a01a4;

  private View view7f0a027c;

  private View view7f0a0177;

  private View view7f0a0138;

  private View view7f0a01a3;

  @UiThread
  public ReferEarnActivity_ViewBinding(ReferEarnActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReferEarnActivity_ViewBinding(final ReferEarnActivity target, View source) {
    this.target = target;

    View view;
    target.referTxt_eT = Utils.findRequiredViewAsType(source, R.id.referTxt_eT, "field 'referTxt_eT'", EditText.class);
    view = Utils.findRequiredView(source, R.id.backReferEarn, "method 'onClick'");
    view7f0a006c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.whatsappicon, "method 'onClick'");
    view7f0a0346 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fbicon, "method 'onClick'");
    view7f0a0126 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.twittericon, "method 'onClick'");
    view7f0a032c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.copy, "method 'onClick'");
    view7f0a00b5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.instagramIcon, "method 'onClick'");
    view7f0a0157 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.messengerIcon, "method 'onClick'");
    view7f0a01a4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.skypeIcon, "method 'onClick'");
    view7f0a027c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.linkedInIcon, "method 'onClick'");
    view7f0a0177 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.gmailIcon, "method 'onClick'");
    view7f0a0138 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.messageIcon, "method 'onClick'");
    view7f0a01a3 = view;
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
    ReferEarnActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.referTxt_eT = null;

    view7f0a006c.setOnClickListener(null);
    view7f0a006c = null;
    view7f0a0346.setOnClickListener(null);
    view7f0a0346 = null;
    view7f0a0126.setOnClickListener(null);
    view7f0a0126 = null;
    view7f0a032c.setOnClickListener(null);
    view7f0a032c = null;
    view7f0a00b5.setOnClickListener(null);
    view7f0a00b5 = null;
    view7f0a0157.setOnClickListener(null);
    view7f0a0157 = null;
    view7f0a01a4.setOnClickListener(null);
    view7f0a01a4 = null;
    view7f0a027c.setOnClickListener(null);
    view7f0a027c = null;
    view7f0a0177.setOnClickListener(null);
    view7f0a0177 = null;
    view7f0a0138.setOnClickListener(null);
    view7f0a0138 = null;
    view7f0a01a3.setOnClickListener(null);
    view7f0a01a3 = null;
  }
}
