// Generated by data binding compiler. Do not edit!
package com.webkype.happiroo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.webkype.happiroo.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class PriceDetailLayoutBinding extends ViewDataBinding {
  @NonNull
  public final TextView cartTotal;

  @NonNull
  public final RelativeLayout cartTotalLay;

  @NonNull
  public final TextView deliveryCharges;

  @NonNull
  public final RelativeLayout discountLay;

  @NonNull
  public final TextView discountTV;

  @NonNull
  public final RelativeLayout otherChargesLay;

  @NonNull
  public final RelativeLayout totalAmtLay;

  @NonNull
  public final TextView tvAmtToBePaid;

  @NonNull
  public final RelativeLayout walletCreditLay;

  @NonNull
  public final TextView walletPointsTV;

  protected PriceDetailLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView cartTotal, RelativeLayout cartTotalLay, TextView deliveryCharges,
      RelativeLayout discountLay, TextView discountTV, RelativeLayout otherChargesLay,
      RelativeLayout totalAmtLay, TextView tvAmtToBePaid, RelativeLayout walletCreditLay,
      TextView walletPointsTV) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cartTotal = cartTotal;
    this.cartTotalLay = cartTotalLay;
    this.deliveryCharges = deliveryCharges;
    this.discountLay = discountLay;
    this.discountTV = discountTV;
    this.otherChargesLay = otherChargesLay;
    this.totalAmtLay = totalAmtLay;
    this.tvAmtToBePaid = tvAmtToBePaid;
    this.walletCreditLay = walletCreditLay;
    this.walletPointsTV = walletPointsTV;
  }

  @NonNull
  public static PriceDetailLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.price_detail_layout, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static PriceDetailLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<PriceDetailLayoutBinding>inflateInternal(inflater, R.layout.price_detail_layout, root, attachToRoot, component);
  }

  @NonNull
  public static PriceDetailLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.price_detail_layout, null, false, component)
   */
  @NonNull
  @Deprecated
  public static PriceDetailLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<PriceDetailLayoutBinding>inflateInternal(inflater, R.layout.price_detail_layout, null, false, component);
  }

  public static PriceDetailLayoutBinding bind(@NonNull View view) {
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
  public static PriceDetailLayoutBinding bind(@NonNull View view, @Nullable Object component) {
    return (PriceDetailLayoutBinding)bind(component, view, R.layout.price_detail_layout);
  }
}
