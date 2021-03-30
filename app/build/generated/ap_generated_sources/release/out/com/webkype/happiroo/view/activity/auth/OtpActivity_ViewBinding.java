// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.activity.auth;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import in.aabhasjindal.otptextview.OtpTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OtpActivity_ViewBinding implements Unbinder {
  private OtpActivity target;

  private View view7f0a0066;

  private View view7f0a028e;

  @UiThread
  public OtpActivity_ViewBinding(OtpActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OtpActivity_ViewBinding(final OtpActivity target, View source) {
    this.target = target;

    View view;
    target.mobileOTPTxt = Utils.findRequiredViewAsType(source, R.id.mobileOTPTxt, "field 'mobileOTPTxt'", TextView.class);
    target.otp_view = Utils.findRequiredViewAsType(source, R.id.otp_view, "field 'otp_view'", OtpTextView.class);
    view = Utils.findRequiredView(source, R.id.backOtp, "method 'onClick'");
    view7f0a0066 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.submitOtpTxtBtn, "method 'onClick'");
    view7f0a028e = view;
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
    OtpActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mobileOTPTxt = null;
    target.otp_view = null;

    view7f0a0066.setOnClickListener(null);
    view7f0a0066 = null;
    view7f0a028e.setOnClickListener(null);
    view7f0a028e = null;
  }
}
