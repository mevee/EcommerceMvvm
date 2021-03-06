// Generated by data binding compiler. Do not edit!
package com.webkype.happiroo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.webkype.happiroo.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentHomeBinding extends ViewDataBinding {
  @NonNull
  public final ViewPager addvertiseRecycler;

  @NonNull
  public final ViewPager homeBannerViewPager;

  @NonNull
  public final LinearLayout homeLocationAddLayout;

  @NonNull
  public final TextView homeLocationAddTxt;

  @NonNull
  public final RecyclerView homeServicesRecycler;

  @NonNull
  public final RecyclerView homeStripRecycler;

  @NonNull
  public final SwipeRefreshLayout homeSwipeRefresh;

  @NonNull
  public final RecyclerView homeVideoPager;

  @NonNull
  public final CoordinatorLayout mainLayout;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final RelativeLayout rlShopping;

  protected FragmentHomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ViewPager addvertiseRecycler, ViewPager homeBannerViewPager,
      LinearLayout homeLocationAddLayout, TextView homeLocationAddTxt,
      RecyclerView homeServicesRecycler, RecyclerView homeStripRecycler,
      SwipeRefreshLayout homeSwipeRefresh, RecyclerView homeVideoPager,
      CoordinatorLayout mainLayout, ProgressBar progressbar, RelativeLayout rlShopping) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addvertiseRecycler = addvertiseRecycler;
    this.homeBannerViewPager = homeBannerViewPager;
    this.homeLocationAddLayout = homeLocationAddLayout;
    this.homeLocationAddTxt = homeLocationAddTxt;
    this.homeServicesRecycler = homeServicesRecycler;
    this.homeStripRecycler = homeStripRecycler;
    this.homeSwipeRefresh = homeSwipeRefresh;
    this.homeVideoPager = homeVideoPager;
    this.mainLayout = mainLayout;
    this.progressbar = progressbar;
    this.rlShopping = rlShopping;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, R.layout.fragment_home, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, R.layout.fragment_home, null, false, component);
  }

  public static FragmentHomeBinding bind(@NonNull View view) {
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
  public static FragmentHomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentHomeBinding)bind(component, view, R.layout.fragment_home);
  }
}
