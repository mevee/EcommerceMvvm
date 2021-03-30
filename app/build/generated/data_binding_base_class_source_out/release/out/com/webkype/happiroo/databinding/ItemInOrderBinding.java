// Generated by data binding compiler. Do not edit!
package com.webkype.happiroo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.webkype.happiroo.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemInOrderBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivItemImage;

  @NonNull
  public final TextView tvNoOfItems;

  @NonNull
  public final TextView tvPrice;

  @NonNull
  public final TextView tvProductName;

  protected ItemInOrderBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivItemImage, TextView tvNoOfItems, TextView tvPrice, TextView tvProductName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivItemImage = ivItemImage;
    this.tvNoOfItems = tvNoOfItems;
    this.tvPrice = tvPrice;
    this.tvProductName = tvProductName;
  }

  @NonNull
  public static ItemInOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_in_order_layout, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemInOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemInOrderBinding>inflateInternal(inflater, R.layout.item_in_order_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ItemInOrderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_in_order_layout, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemInOrderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemInOrderBinding>inflateInternal(inflater, R.layout.item_in_order_layout, null, false, component);
  }

  public static ItemInOrderBinding bind(@NonNull View view) {
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
  public static ItemInOrderBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemInOrderBinding)bind(component, view, R.layout.item_in_order_layout);
  }
}
