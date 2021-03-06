// Generated by data binding compiler. Do not edit!
package com.webkype.happiroo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.webkype.happiroo.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityFavProductListBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout noDataView;

  @NonNull
  public final ProgressBar progressBarProductList;

  @NonNull
  public final RecyclerView rvMore;

  @NonNull
  public final ToolbarLayoutBinding toolbarFavList;

  protected ActivityFavProductListBinding(Object _bindingComponent, View _root,
      int _localFieldCount, LinearLayout noDataView, ProgressBar progressBarProductList,
      RecyclerView rvMore, ToolbarLayoutBinding toolbarFavList) {
    super(_bindingComponent, _root, _localFieldCount);
    this.noDataView = noDataView;
    this.progressBarProductList = progressBarProductList;
    this.rvMore = rvMore;
    this.toolbarFavList = toolbarFavList;
  }

  @NonNull
  public static ActivityFavProductListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_fav_product_list, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityFavProductListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityFavProductListBinding>inflateInternal(inflater, R.layout.activity_fav_product_list, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityFavProductListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_fav_product_list, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityFavProductListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityFavProductListBinding>inflateInternal(inflater, R.layout.activity_fav_product_list, null, false, component);
  }

  public static ActivityFavProductListBinding bind(@NonNull View view) {
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
  public static ActivityFavProductListBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityFavProductListBinding)bind(component, view, R.layout.activity_fav_product_list);
  }
}
