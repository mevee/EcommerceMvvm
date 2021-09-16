// Generated by data binding compiler. Do not edit!
package com.webkype.happiroo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.webkype.happiroo.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentShopBinding extends ViewDataBinding {
  @NonNull
  public final ProgressBar progressbarShopFrag;

  @NonNull
  public final RecyclerView rvShopCat;

  protected FragmentShopBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ProgressBar progressbarShopFrag, RecyclerView rvShopCat) {
    super(_bindingComponent, _root, _localFieldCount);
    this.progressbarShopFrag = progressbarShopFrag;
    this.rvShopCat = rvShopCat;
  }

  @NonNull
  public static FragmentShopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_shop, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentShopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentShopBinding>inflateInternal(inflater, R.layout.fragment_shop, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentShopBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_shop, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentShopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentShopBinding>inflateInternal(inflater, R.layout.fragment_shop, null, false, component);
  }

  public static FragmentShopBinding bind(@NonNull View view) {
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
  public static FragmentShopBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentShopBinding)bind(component, view, R.layout.fragment_shop);
  }
}