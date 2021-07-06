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

  private View view7f0a006b;

  private View view7f0a0341;

  private View view7f0a0125;

  private View view7f0a0327;

  private View view7f0a00b4;

  private View view7f0a0156;

  private View view7f0a01a0;

  private View view7f0a0278;

  private View view7f0a0176;

  private View view7f0a0137;

  private View view7f0a019f;

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
    view7f0a006b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.whatsappicon, "method 'onClick'");
    view7f0a0341 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fbicon, "method 'onClick'");
    view7f0a0125 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.twittericon, "method 'onClick'");
    view7f0a0327 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.copy, "method 'onClick'");
    view7f0a00b4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.instagramIcon, "method 'onClick'");
    view7f0a0156 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.messengerIcon, "method 'onClick'");
    view7f0a01a0 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.skypeIcon, "method 'onClick'");
    view7f0a0278 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.linkedInIcon, "method 'onClick'");
    view7f0a0176 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.gmailIcon, "method 'onClick'");
    view7f0a0137 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.messageIcon, "method 'onClick'");
    view7f0a019f = view;
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

    view7f0a006b.setOnClickListener(null);
    view7f0a006b = null;
    view7f0a0341.setOnClickListener(null);
    view7f0a0341 = null;
    view7f0a0125.setOnClickListener(null);
    view7f0a0125 = null;
    view7f0a0327.setOnClickListener(null);
    view7f0a0327 = null;
    view7f0a00b4.setOnClickListener(null);
    view7f0a00b4 = null;
    view7f0a0156.setOnClickListener(null);
    view7f0a0156 = null;
    view7f0a01a0.setOnClickListener(null);
    view7f0a01a0 = null;
    view7f0a0278.setOnClickListener(null);
    view7f0a0278 = null;
    view7f0a0176.setOnClickListener(null);
    view7f0a0176 = null;
    view7f0a0137.setOnClickListener(null);
    view7f0a0137 = null;
    view7f0a019f.setOnClickListener(null);
    view7f0a019f = null;
  }
}
