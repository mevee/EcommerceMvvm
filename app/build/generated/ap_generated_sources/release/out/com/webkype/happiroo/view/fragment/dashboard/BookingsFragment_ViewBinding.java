// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.fragment.dashboard;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabLayout;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BookingsFragment_ViewBinding implements Unbinder {
  private BookingsFragment target;

  @UiThread
  public BookingsFragment_ViewBinding(BookingsFragment target, View source) {
    this.target = target;

    target.tabLayoutBooking = Utils.findRequiredViewAsType(source, R.id.tabLayoutBooking, "field 'tabLayoutBooking'", TabLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BookingsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tabLayoutBooking = null;
  }
}
