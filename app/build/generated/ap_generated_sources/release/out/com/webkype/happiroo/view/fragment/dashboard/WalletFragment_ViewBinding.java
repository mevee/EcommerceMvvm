// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.fragment.dashboard;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WalletFragment_ViewBinding implements Unbinder {
  private WalletFragment target;

  @UiThread
  public WalletFragment_ViewBinding(WalletFragment target, View source) {
    this.target = target;

    target.rv_wallet_transaction = Utils.findRequiredViewAsType(source, R.id.rv_wallet_transaction, "field 'rv_wallet_transaction'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    WalletFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv_wallet_transaction = null;
  }
}
