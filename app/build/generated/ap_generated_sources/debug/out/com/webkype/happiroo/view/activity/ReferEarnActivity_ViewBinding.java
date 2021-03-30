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

  private View view7f0a0337;

  private View view7f0a0123;

  private View view7f0a031d;

  private View view7f0a00b3;

  private View view7f0a0155;

  private View view7f0a019c;

  private View view7f0a0273;

  private View view7f0a0173;

  private View view7f0a0135;

  private View view7f0a019b;

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
    view7f0a0337 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fbicon, "method 'onClick'");
    view7f0a0123 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.twittericon, "method 'onClick'");
    view7f0a031d = view;
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
    view7f0a0155 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.messengerIcon, "method 'onClick'");
    view7f0a019c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.skypeIcon, "method 'onClick'");
    view7f0a0273 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.linkedInIcon, "method 'onClick'");
    view7f0a0173 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.gmailIcon, "method 'onClick'");
    view7f0a0135 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.messageIcon, "method 'onClick'");
    view7f0a019b = view;
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
    view7f0a0337.setOnClickListener(null);
    view7f0a0337 = null;
    view7f0a0123.setOnClickListener(null);
    view7f0a0123 = null;
    view7f0a031d.setOnClickListener(null);
    view7f0a031d = null;
    view7f0a00b3.setOnClickListener(null);
    view7f0a00b3 = null;
    view7f0a0155.setOnClickListener(null);
    view7f0a0155 = null;
    view7f0a019c.setOnClickListener(null);
    view7f0a019c = null;
    view7f0a0273.setOnClickListener(null);
    view7f0a0273 = null;
    view7f0a0173.setOnClickListener(null);
    view7f0a0173 = null;
    view7f0a0135.setOnClickListener(null);
    view7f0a0135 = null;
    view7f0a019b.setOnClickListener(null);
    view7f0a019b = null;
  }
}
