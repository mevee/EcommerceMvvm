// Generated by data binding compiler. Do not edit!
package com.webkype.happiroo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import androidx.viewpager.widget.ViewPager;
import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.utils.UnderlineTextView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityProductDetailBinding extends ViewDataBinding {
  @NonNull
  public final UnderlineTextView addRatingBtnTV;

  @NonNull
  public final ImageView backPdp;

  @NonNull
  public final TextView brandUsed;

  @NonNull
  public final RelativeLayout cartLayoutPdp;

  @NonNull
  public final ImageView cartPdp;

  @NonNull
  public final TextView equipmentUsed;

  @NonNull
  public final RelativeLayout goCartPdpLayout;

  @NonNull
  public final NestedScrollView mainDetail;

  @NonNull
  public final TextView pdpAddToCart;

  @NonNull
  public final TextView pdpCostPrice;

  @NonNull
  public final LinearLayout pdpCounterLayout;

  @NonNull
  public final CardView pdpHeaderCard;

  @NonNull
  public final TextView pdpSellingPrice;

  @NonNull
  public final ImageView productFavImage;

  @NonNull
  public final ProgressBar progressbarProductDetail;

  @NonNull
  public final RecyclerView rvCustomerReviewList;

  @NonNull
  public final ViewPager serviceDetailViewPager;

  @NonNull
  public final TextView tvAdditionalDetail;

  @NonNull
  public final TextView tvAssurance;

  @NonNull
  public final TextView tvBtnAdd;

  @NonNull
  public final TextView tvBtnSubtract;

  @NonNull
  public final TextView tvCartCount;

  @NonNull
  public final TextView tvCartQuantity;

  @NonNull
  public final TextView tvCartTotal;

  @NonNull
  public final TextView tvIncludes;

  @NonNull
  public final TextView tvProcessTime;

  @NonNull
  public final TextView tvServiceDetailRating;

  @NonNull
  public final TextView tvServiceName;

  @NonNull
  public final TextView tvSmallDetail;

  @NonNull
  public final TextView tvWhatExcluded;

  protected ActivityProductDetailBinding(Object _bindingComponent, View _root, int _localFieldCount,
      UnderlineTextView addRatingBtnTV, ImageView backPdp, TextView brandUsed,
      RelativeLayout cartLayoutPdp, ImageView cartPdp, TextView equipmentUsed,
      RelativeLayout goCartPdpLayout, NestedScrollView mainDetail, TextView pdpAddToCart,
      TextView pdpCostPrice, LinearLayout pdpCounterLayout, CardView pdpHeaderCard,
      TextView pdpSellingPrice, ImageView productFavImage, ProgressBar progressbarProductDetail,
      RecyclerView rvCustomerReviewList, ViewPager serviceDetailViewPager,
      TextView tvAdditionalDetail, TextView tvAssurance, TextView tvBtnAdd, TextView tvBtnSubtract,
      TextView tvCartCount, TextView tvCartQuantity, TextView tvCartTotal, TextView tvIncludes,
      TextView tvProcessTime, TextView tvServiceDetailRating, TextView tvServiceName,
      TextView tvSmallDetail, TextView tvWhatExcluded) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addRatingBtnTV = addRatingBtnTV;
    this.backPdp = backPdp;
    this.brandUsed = brandUsed;
    this.cartLayoutPdp = cartLayoutPdp;
    this.cartPdp = cartPdp;
    this.equipmentUsed = equipmentUsed;
    this.goCartPdpLayout = goCartPdpLayout;
    this.mainDetail = mainDetail;
    this.pdpAddToCart = pdpAddToCart;
    this.pdpCostPrice = pdpCostPrice;
    this.pdpCounterLayout = pdpCounterLayout;
    this.pdpHeaderCard = pdpHeaderCard;
    this.pdpSellingPrice = pdpSellingPrice;
    this.productFavImage = productFavImage;
    this.progressbarProductDetail = progressbarProductDetail;
    this.rvCustomerReviewList = rvCustomerReviewList;
    this.serviceDetailViewPager = serviceDetailViewPager;
    this.tvAdditionalDetail = tvAdditionalDetail;
    this.tvAssurance = tvAssurance;
    this.tvBtnAdd = tvBtnAdd;
    this.tvBtnSubtract = tvBtnSubtract;
    this.tvCartCount = tvCartCount;
    this.tvCartQuantity = tvCartQuantity;
    this.tvCartTotal = tvCartTotal;
    this.tvIncludes = tvIncludes;
    this.tvProcessTime = tvProcessTime;
    this.tvServiceDetailRating = tvServiceDetailRating;
    this.tvServiceName = tvServiceName;
    this.tvSmallDetail = tvSmallDetail;
    this.tvWhatExcluded = tvWhatExcluded;
  }

  @NonNull
  public static ActivityProductDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_product_detail, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityProductDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityProductDetailBinding>inflateInternal(inflater, R.layout.activity_product_detail, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityProductDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_product_detail, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityProductDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityProductDetailBinding>inflateInternal(inflater, R.layout.activity_product_detail, null, false, component);
  }

  public static ActivityProductDetailBinding bind(@NonNull View view) {
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
  public static ActivityProductDetailBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityProductDetailBinding)bind(component, view, R.layout.activity_product_detail);
  }
}
