// Generated by data binding compiler. Do not edit!
package com.webkype.happiroo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.webkype.happiroo.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityCartOverviewBinding extends ViewDataBinding {
  @NonNull
  public final ImageView backCartOverview;

  @NonNull
  public final CardView cartOverviewHeaderCard;

  @NonNull
  public final RelativeLayout confirmBookingRelative;

  @NonNull
  public final PriceDetailLayoutBinding costDistrLayout;

  @NonNull
  public final EditText etTransactionId;

  @NonNull
  public final LinearLayout llOnline;

  @NonNull
  public final NestedScrollView mainCartOverview;

  @NonNull
  public final ProgressBar progressbarCartOverView;

  @NonNull
  public final RecyclerView rvPaymentMode;

  @NonNull
  public final RecyclerView rvServiceInclude;

  @NonNull
  public final TextView tvAddressDetailOverview;

  @NonNull
  public final TextView tvDateTimeSelected;

  @NonNull
  public final TextView tvPaymentModeTitle;

  @NonNull
  public final TextView tvTimeSlotTitle;

  @NonNull
  public final TextView tvUpiId;

  @NonNull
  public final TextView tvUpiId2;

  protected ActivityCartOverviewBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView backCartOverview, CardView cartOverviewHeaderCard,
      RelativeLayout confirmBookingRelative, PriceDetailLayoutBinding costDistrLayout,
      EditText etTransactionId, LinearLayout llOnline, NestedScrollView mainCartOverview,
      ProgressBar progressbarCartOverView, RecyclerView rvPaymentMode,
      RecyclerView rvServiceInclude, TextView tvAddressDetailOverview, TextView tvDateTimeSelected,
      TextView tvPaymentModeTitle, TextView tvTimeSlotTitle, TextView tvUpiId, TextView tvUpiId2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.backCartOverview = backCartOverview;
    this.cartOverviewHeaderCard = cartOverviewHeaderCard;
    this.confirmBookingRelative = confirmBookingRelative;
    this.costDistrLayout = costDistrLayout;
    this.etTransactionId = etTransactionId;
    this.llOnline = llOnline;
    this.mainCartOverview = mainCartOverview;
    this.progressbarCartOverView = progressbarCartOverView;
    this.rvPaymentMode = rvPaymentMode;
    this.rvServiceInclude = rvServiceInclude;
    this.tvAddressDetailOverview = tvAddressDetailOverview;
    this.tvDateTimeSelected = tvDateTimeSelected;
    this.tvPaymentModeTitle = tvPaymentModeTitle;
    this.tvTimeSlotTitle = tvTimeSlotTitle;
    this.tvUpiId = tvUpiId;
    this.tvUpiId2 = tvUpiId2;
  }

  @NonNull
  public static ActivityCartOverviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_cart_overview, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCartOverviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityCartOverviewBinding>inflateInternal(inflater, R.layout.activity_cart_overview, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCartOverviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_cart_overview, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCartOverviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityCartOverviewBinding>inflateInternal(inflater, R.layout.activity_cart_overview, null, false, component);
  }

  public static ActivityCartOverviewBinding bind(@NonNull View view) {
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
  public static ActivityCartOverviewBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityCartOverviewBinding)bind(component, view, R.layout.activity_cart_overview);
  }
}
