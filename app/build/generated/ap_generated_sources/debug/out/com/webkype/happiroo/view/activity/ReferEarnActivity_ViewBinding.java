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

  private View view7f0a006a;

  private View view7f0a033c;

  private View view7f0a0124;

  private View view7f0a0322;

  private View view7f0a00b3;

  private View view7f0a0156;

  private View view7f0a019e;

  private View view7f0a0275;

  private View view7f0a0174;

  private View view7f0a0136;

  private View view7f0a019d;

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
    view7f0a006a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.whatsappicon, "method 'onClick'");
    view7f0a033c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fbicon, "method 'onClick'");
    view7f0a0124 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.twittericon, "method 'onClick'");
    view7f0a0322 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.copy, "method 'onClick'");
    view7f0a00b3 = view;
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
    view7f0a019e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.skypeIcon, "method 'onClick'");
    view7f0a0275 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.linkedInIcon, "method 'onClick'");
    view7f0a0174 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.gmailIcon, "method 'onClick'");
    view7f0a0136 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.messageIcon, "method 'onClick'");
    view7f0a019d = view;
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

    view7f0a006a.setOnClickListener(null);
    view7f0a006a = null;
    view7f0a033c.setOnClickListener(null);
    view7f0a033c = null;
    view7f0a0124.setOnClickListener(null);
    view7f0a0124 = null;
    view7f0a0322.setOnClickListener(null);
    view7f0a0322 = null;
    view7f0a00b3.setOnClickListener(null);
    view7f0a00b3 = null;
    view7f0a0156.setOnClickListener(null);
    view7f0a0156 = null;
    view7f0a019e.setOnClickListener(null);
    view7f0a019e = null;
    view7f0a0275.setOnClickListener(null);
    view7f0a0275 = null;
    view7f0a0174.setOnClickListener(null);
    view7f0a0174 = null;
    view7f0a0136.setOnClickListener(null);
    view7f0a0136 = null;
    view7f0a019d.setOnClickListener(null);
    view7f0a019d = null;
  }
}
