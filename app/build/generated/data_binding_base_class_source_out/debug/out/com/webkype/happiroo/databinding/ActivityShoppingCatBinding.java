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

public abstract class ActivityShoppingCatBinding extends ViewDataBinding {
  @NonNull
  public final ProgressBar progressBarShopCat;

  @NonNull
  public final RecyclerView rvCategoryList;

  @NonNull
  public final ToolbarLayoutBinding toolbarShoppingCat;

  protected ActivityShoppingCatBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ProgressBar progressBarShopCat, RecyclerView rvCategoryList,
      ToolbarLayoutBinding toolbarShoppingCat) {
    super(_bindingComponent, _root, _localFieldCount);
    this.progressBarShopCat = progressBarShopCat;
    this.rvCategoryList = rvCategoryList;
    this.toolbarShoppingCat = toolbarShoppingCat;
  }

  @NonNull
  public static ActivityShoppingCatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_shopping_cat, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityShoppingCatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityShoppingCatBinding>inflateInternal(inflater, R.layout.activity_shopping_cat, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityShoppingCatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_shopping_cat, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityShoppingCatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityShoppingCatBinding>inflateInternal(inflater, R.layout.activity_shopping_cat, null, false, component);
  }

  public static ActivityShoppingCatBinding bind(@NonNull View view) {
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
  public static ActivityShoppingCatBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityShoppingCatBinding)bind(component, view, R.layout.activity_shopping_cat);
  }
}
