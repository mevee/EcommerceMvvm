// Generated code from Butter Knife. Do not modify!
package com.webkype.happiroo.view.activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.webkype.happiroo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ImagePagerActivity_ViewBinding implements Unbinder {
  private ImagePagerActivity target;

  private View view7f0a0063;

  @UiThread
  public ImagePagerActivity_ViewBinding(ImagePagerActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ImagePagerActivity_ViewBinding(final ImagePagerActivity target, View source) {
    this.target = target;

    View view;
    target.zoomImagePager = Utils.findRequiredViewAsType(source, R.id.zoomImagePager, "field 'zoomImagePager'", ViewPager.class);
    view = Utils.findRequiredView(source, R.id.backImagePager, "method 'backImagePager'");
    view7f0a0063 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.backImagePager();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ImagePagerActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.zoomImagePager = null;

    view7f0a0063.setOnClickListener(null);
    view7f0a0063 = null;
  }
}
