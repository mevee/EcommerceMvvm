// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NotificationsActivity_ViewBinding implements Unbinder {
  private NotificationsActivity target;

  private View view7f0a0066;

  @UiThread
  public NotificationsActivity_ViewBinding(NotificationsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NotificationsActivity_ViewBinding(final NotificationsActivity target, View source) {
    this.target = target;

    View view;
    target.rv_notification = Utils.findRequiredViewAsType(source, R.id.rv_notification, "field 'rv_notification'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.backNotification, "method 'onClick'");
    view7f0a0066 = view;
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
    NotificationsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv_notification = null;

    view7f0a0066.setOnClickListener(null);
    view7f0a0066 = null;
  }
}
