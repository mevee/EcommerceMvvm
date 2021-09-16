// Generated by data binding compiler. Do not edit!
package com.webkype.happiroo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.webkype.happiroo.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class BookingHistoryBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bookingHistoryItem;

  @NonNull
  public final ImageView ivVendorImage;

  @NonNull
  public final TextView tvBookingTime;

  @NonNull
  public final TextView tvServiceName;

  @NonNull
  public final TextView tvStatusHistory;

  @NonNull
  public final TextView tvTotalRatings;

  @NonNull
  public final TextView tvVendorName;

  @NonNull
  public final TextView tvVenorRatingHistory;

  @NonNull
  public final CardView vendorImageItem;

  @NonNull
  public final LinearLayout viewProjectLayoutBtn;

  protected BookingHistoryBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LinearLayout bookingHistoryItem, ImageView ivVendorImage, TextView tvBookingTime,
      TextView tvServiceName, TextView tvStatusHistory, TextView tvTotalRatings,
      TextView tvVendorName, TextView tvVenorRatingHistory, CardView vendorImageItem,
      LinearLayout viewProjectLayoutBtn) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bookingHistoryItem = bookingHistoryItem;
    this.ivVendorImage = ivVendorImage;
    this.tvBookingTime = tvBookingTime;
    this.tvServiceName = tvServiceName;
    this.tvStatusHistory = tvStatusHistory;
    this.tvTotalRatings = tvTotalRatings;
    this.tvVendorName = tvVendorName;
    this.tvVenorRatingHistory = tvVenorRatingHistory;
    this.vendorImageItem = vendorImageItem;
    this.viewProjectLayoutBtn = viewProjectLayoutBtn;
  }

  @NonNull
  public static BookingHistoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.book_history_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static BookingHistoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<BookingHistoryBinding>inflateInternal(inflater, R.layout.book_history_item, root, attachToRoot, component);
  }

  @NonNull
  public static BookingHistoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.book_history_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static BookingHistoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<BookingHistoryBinding>inflateInternal(inflater, R.layout.book_history_item, null, false, component);
  }

  public static BookingHistoryBinding bind(@NonNull View view) {
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
  public static BookingHistoryBinding bind(@NonNull View view, @Nullable Object component) {
    return (BookingHistoryBinding)bind(component, view, R.layout.book_history_item);
  }
}