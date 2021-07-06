// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.activity.auth;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AuthenticateActivity_ViewBinding implements Unbinder {
  private AuthenticateActivity target;

  private View view7f0a0193;

  @UiThread
  public AuthenticateActivity_ViewBinding(AuthenticateActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AuthenticateActivity_ViewBinding(final AuthenticateActivity target, View source) {
    this.target = target;

    View view;
    target.mobileLogin_eT = Utils.findRequiredViewAsType(source, R.id.mobileLogin_eT, "field 'mobileLogin_eT'", EditText.class);
    view = Utils.findRequiredView(source, R.id.loginBtnLinear, "field 'loginBtnLinear' and method 'onClick'");
    target.loginBtnLinear = Utils.castView(view, R.id.loginBtnLinear, "field 'loginBtnLinear'", LinearLayout.class);
    view7f0a0193 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.skipLoginTxtBtn = Utils.findRequiredViewAsType(source, R.id.skipLoginTxtBtn, "field 'skipLoginTxtBtn'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AuthenticateActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mobileLogin_eT = null;
    target.loginBtnLinear = null;
    target.skipLoginTxtBtn = null;

    view7f0a0193.setOnClickListener(null);
    view7f0a0193 = null;
  }
}
