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

public abstract class ActivityOrderListBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout noOrderAvailable;

  @NonNull
  public final ProgressBar progressBarOrderList;

  @NonNull
  public final RecyclerView rvOrderList;

  @NonNull
  public final ToolbarLayoutBinding toolbarOrdList;

  protected ActivityOrderListBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout noOrderAvailable, ProgressBar progressBarOrderList, RecyclerView rvOrderList,
      ToolbarLayoutBinding toolbarOrdList) {
    super(_bindingComponent, _root, _localFieldCount);
    this.noOrderAvailable = noOrderAvailable;
    this.progressBarOrderList = progressBarOrderList;
    this.rvOrderList = rvOrderList;
    this.toolbarOrdList = toolbarOrdList;
  }

  @NonNull
  public static ActivityOrderListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_order_list, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityOrderListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityOrderListBinding>inflateInternal(inflater, R.layout.activity_order_list, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityOrderListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_order_list, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityOrderListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityOrderListBinding>inflateInternal(inflater, R.layout.activity_order_list, null, false, component);
  }

  public static ActivityOrderListBinding bind(@NonNull View view) {
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
  public static ActivityOrderListBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityOrderListBinding)bind(component, view, R.layout.activity_order_list);
  }
}
