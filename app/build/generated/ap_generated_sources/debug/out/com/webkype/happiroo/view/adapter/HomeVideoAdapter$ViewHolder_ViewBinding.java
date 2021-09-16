// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.exoplayer2.ui.PlayerView;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeVideoAdapter$ViewHolder_ViewBinding implements Unbinder {
  private HomeVideoAdapter.ViewHolder target;

  @UiThread
  public HomeVideoAdapter$ViewHolder_ViewBinding(HomeVideoAdapter.ViewHolder target, View source) {
    this.target = target;

    target.stripCatLayoutItem = Utils.findRequiredViewAsType(source, R.id.stripCatLayoutItem, "field 'stripCatLayoutItem'", ConstraintLayout.class);
    target.pbVideo = Utils.findRequiredViewAsType(source, R.id.pbVideo, "field 'pbVideo'", ProgressBar.class);
    target.stripCatImageItem = Utils.findRequiredViewAsType(source, R.id.stripCatImageItem, "field 'stripCatImageItem'", ImageView.class);
    target.playerView = Utils.findRequiredViewAsType(source, R.id.headerVideoPlayer, "field 'playerView'", PlayerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeVideoAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.stripCatLayoutItem = null;
    target.pbVideo = null;
    target.stripCatImageItem = null;
    target.playerView = null;
  }
}
