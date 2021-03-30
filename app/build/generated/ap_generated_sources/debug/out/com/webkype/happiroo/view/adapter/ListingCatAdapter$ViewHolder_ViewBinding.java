// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListingCatAdapter$ViewHolder_ViewBinding implements Unbinder {
  private ListingCatAdapter.ViewHolder target;

  @UiThread
  public ListingCatAdapter$ViewHolder_ViewBinding(ListingCatAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.listingCatLayoutItem = Utils.findRequiredViewAsType(source, R.id.listingCatLayoutItem, "field 'listingCatLayoutItem'", RelativeLayout.class);
    target.listingCatTxtItem = Utils.findRequiredViewAsType(source, R.id.listingCatTxtItem, "field 'listingCatTxtItem'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListingCatAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listingCatLayoutItem = null;
    target.listingCatTxtItem = null;
  }
}
