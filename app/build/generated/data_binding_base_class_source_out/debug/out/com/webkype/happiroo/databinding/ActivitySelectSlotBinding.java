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
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.webkype.happiroo.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySelectSlotBinding extends ViewDataBinding {
  @NonNull
  public final TextView abc;

  @NonNull
  public final ImageView backCartReview;

  @NonNull
  public final TextView def;

  @NonNull
  public final RelativeLayout proceedToBookRelative;

  @NonNull
  public final RecyclerView rvDateList;

  @NonNull
  public final RecyclerView rvTimeSlotList;

  @NonNull
  public final CardView timingSlotHeaderCard;

  @NonNull
  public final TextView tvServiceCost;

  @NonNull
  public final TextView userAddressType;

  @NonNull
  public final TextView userFullAddress;

  protected ActivitySelectSlotBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView abc, ImageView backCartReview, TextView def, RelativeLayout proceedToBookRelative,
      RecyclerView rvDateList, RecyclerView rvTimeSlotList, CardView timingSlotHeaderCard,
      TextView tvServiceCost, TextView userAddressType, TextView userFullAddress) {
    super(_bindingComponent, _root, _localFieldCount);
    this.abc = abc;
    this.backCartReview = backCartReview;
    this.def = def;
    this.proceedToBookRelative = proceedToBookRelative;
    this.rvDateList = rvDateList;
    this.rvTimeSlotList = rvTimeSlotList;
    this.timingSlotHeaderCard = timingSlotHeaderCard;
    this.tvServiceCost = tvServiceCost;
    this.userAddressType = userAddressType;
    this.userFullAddress = userFullAddress;
  }

  @NonNull
  public static ActivitySelectSlotBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_select_slot, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySelectSlotBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySelectSlotBinding>inflateInternal(inflater, R.layout.activity_select_slot, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySelectSlotBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_select_slot, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySelectSlotBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySelectSlotBinding>inflateInternal(inflater, R.layout.activity_select_slot, null, false, component);
  }

  public static ActivitySelectSlotBinding bind(@NonNull View view) {
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
  public static ActivitySelectSlotBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySelectSlotBinding)bind(component, view, R.layout.activity_select_slot);
  }
}
