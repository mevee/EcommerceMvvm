// Generated by data binding compiler. Do not edit!
package com.webkype.happiroo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.webkype.happiroo.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ProductItemBinding extends ViewDataBinding {
  @NonNull
  public final TextView addProduct;

  @NonNull
  public final TextView discountedProductPrice;

  @NonNull
  public final TextView originalProductPrice;

  @NonNull
  public final RelativeLayout productAddLayout;

  @NonNull
  public final TextView productAddToCartBtnTxt;

  @NonNull
  public final RelativeLayout productCountLay;

  @NonNull
  public final ImageView productImageItem;

  @NonNull
  public final RelativeLayout productItemLayout;

  @NonNull
  public final TextView productNameItem;

  @NonNull
  public final TextView subtractProduct;

  @NonNull
  public final TextView tvCount;

  @NonNull
  public final TextView tvDetail;

  @NonNull
  public final TextView tvServiceRating;

  @NonNull
  public final TextView tvServiceTime;

  protected ProductItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView addProduct, TextView discountedProductPrice, TextView originalProductPrice,
      RelativeLayout productAddLayout, TextView productAddToCartBtnTxt,
      RelativeLayout productCountLay, ImageView productImageItem, RelativeLayout productItemLayout,
      TextView productNameItem, TextView subtractProduct, TextView tvCount, TextView tvDetail,
      TextView tvServiceRating, TextView tvServiceTime) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addProduct = addProduct;
    this.discountedProductPrice = discountedProductPrice;
    this.originalProductPrice = originalProductPrice;
    this.productAddLayout = productAddLayout;
    this.productAddToCartBtnTxt = productAddToCartBtnTxt;
    this.productCountLay = productCountLay;
    this.productImageItem = productImageItem;
    this.productItemLayout = productItemLayout;
    this.productNameItem = productNameItem;
    this.subtractProduct = subtractProduct;
    this.tvCount = tvCount;
    this.tvDetail = tvDetail;
    this.tvServiceRating = tvServiceRating;
    this.tvServiceTime = tvServiceTime;
  }

  @NonNull
  public static ProductItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.products_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ProductItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ProductItemBinding>inflateInternal(inflater, R.layout.products_item, root, attachToRoot, component);
  }

  @NonNull
  public static ProductItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.products_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ProductItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ProductItemBinding>inflateInternal(inflater, R.layout.products_item, null, false, component);
  }

  public static ProductItemBinding bind(@NonNull View view) {
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
  public static ProductItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (ProductItemBinding)bind(component, view, R.layout.products_item);
  }
}