// Generated by data binding compiler. Do not edit!
package com.webkype.happiroo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.webkype.happiroo.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ShopProductItemBinding extends ViewDataBinding {
  @NonNull
  public final CardView cardParent;

  @NonNull
  public final AppCompatRatingBar itemRatingBar;

  @NonNull
  public final ImageView ivCatgory;

  @NonNull
  public final ImageView ivFavourite;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final TextView tvCostPrice;

  @NonNull
  public final TextView tvDesc;

  @NonNull
  public final TextView tvNoOfSold;

  @NonNull
  public final TextView tvOff;

  @NonNull
  public final TextView tvPrice;

  @NonNull
  public final TextView tvProductTitle;

  protected ShopProductItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CardView cardParent, AppCompatRatingBar itemRatingBar, ImageView ivCatgory,
      ImageView ivFavourite, ProgressBar progressBar, TextView tvCostPrice, TextView tvDesc,
      TextView tvNoOfSold, TextView tvOff, TextView tvPrice, TextView tvProductTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cardParent = cardParent;
    this.itemRatingBar = itemRatingBar;
    this.ivCatgory = ivCatgory;
    this.ivFavourite = ivFavourite;
    this.progressBar = progressBar;
    this.tvCostPrice = tvCostPrice;
    this.tvDesc = tvDesc;
    this.tvNoOfSold = tvNoOfSold;
    this.tvOff = tvOff;
    this.tvPrice = tvPrice;
    this.tvProductTitle = tvProductTitle;
  }

  @NonNull
  public static ShopProductItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.shop_product_item_layout, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ShopProductItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ShopProductItemBinding>inflateInternal(inflater, R.layout.shop_product_item_layout, root, attachToRoot, component);
  }

  @NonNull
  public static ShopProductItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.shop_product_item_layout, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ShopProductItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ShopProductItemBinding>inflateInternal(inflater, R.layout.shop_product_item_layout, null, false, component);
  }

  public static ShopProductItemBinding bind(@NonNull View view) {
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
  public static ShopProductItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (ShopProductItemBinding)bind(component, view, R.layout.shop_product_item_layout);
  }
}