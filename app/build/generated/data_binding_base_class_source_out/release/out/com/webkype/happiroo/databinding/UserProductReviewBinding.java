// Generated by data binding compiler. Do not edit!
package com.webkype.happiroo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.webkype.happiroo.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class UserProductReviewBinding extends ViewDataBinding {
  @NonNull
  public final RatingBar rbProdRateByUser;

  @NonNull
  public final RelativeLayout rlBackUserReview;

  @NonNull
  public final TextView tvMessage;

  @NonNull
  public final TextView tvUserName;

  @NonNull
  public final CircleImageView userImage;

  protected UserProductReviewBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RatingBar rbProdRateByUser, RelativeLayout rlBackUserReview, TextView tvMessage,
      TextView tvUserName, CircleImageView userImage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.rbProdRateByUser = rbProdRateByUser;
    this.rlBackUserReview = rlBackUserReview;
    this.tvMessage = tvMessage;
    this.tvUserName = tvUserName;
    this.userImage = userImage;
  }

  @NonNull
  public static UserProductReviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.user_review_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static UserProductReviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<UserProductReviewBinding>inflateInternal(inflater, R.layout.user_review_item, root, attachToRoot, component);
  }

  @NonNull
  public static UserProductReviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.user_review_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static UserProductReviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<UserProductReviewBinding>inflateInternal(inflater, R.layout.user_review_item, null, false, component);
  }

  public static UserProductReviewBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static UserProductReviewBinding bind(@NonNull View view, @Nullable Object component) {
    return (UserProductReviewBinding)bind(component, view, R.layout.user_review_item);
  }
}
