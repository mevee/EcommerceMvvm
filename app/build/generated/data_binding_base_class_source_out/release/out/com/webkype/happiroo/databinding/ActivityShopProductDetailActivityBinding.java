// Generated by data binding compiler. Do not edit!
package com.webkype.happiroo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
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
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityShopProductDetailActivityBinding extends ViewDataBinding {
  @NonNull
  public final CardView cardReview;

  @NonNull
  public final ImageView ivAdd;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final ImageView ivCart;

  @NonNull
  public final ImageView ivFav;

  @NonNull
  public final ImageView ivMinus;

  @NonNull
  public final LinearLayout llBottomButtons;

  @NonNull
  public final LinearLayout llRatingDetail;

  @NonNull
  public final LinearLayout llVariant;

  @NonNull
  public final NestedScrollView nsvMain;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RatingBar rbRating;

  @NonNull
  public final RatingBar rbRatingReview;

  @NonNull
  public final RecyclerView rvExtraImages;

  @NonNull
  public final RecyclerView rvRatings;

  @NonNull
  public final RecyclerView rvVarients;

  @NonNull
  public final TextView tvBtnAddToCart;

  @NonNull
  public final TextView tvCartQntt;

  @NonNull
  public final TextView tvCostPrice;

  @NonNull
  public final TextView tvCurrentimage;

  @NonNull
  public final TextView tvDesc;

  @NonNull
  public final TextView tvNoOfSold;

  @NonNull
  public final TextView tvNoRatings;

  @NonNull
  public final TextView tvProductName;

  @NonNull
  public final TextView tvQnt;

  @NonNull
  public final TextView tvRating;

  @NonNull
  public final TextView tvRatingAndTotalReview;

  @NonNull
  public final TextView tvSellerName;

  @NonNull
  public final TextView tvSellingPrice;

  @NonNull
  public final TextView tvTotalAmount;

  @NonNull
  public final ViewPager vpProductDetail;

  protected ActivityShopProductDetailActivityBinding(Object _bindingComponent, View _root,
      int _localFieldCount, CardView cardReview, ImageView ivAdd, ImageView ivBack,
      ImageView ivCart, ImageView ivFav, ImageView ivMinus, LinearLayout llBottomButtons,
      LinearLayout llRatingDetail, LinearLayout llVariant, NestedScrollView nsvMain,
      ProgressBar progressBar, RatingBar rbRating, RatingBar rbRatingReview,
      RecyclerView rvExtraImages, RecyclerView rvRatings, RecyclerView rvVarients,
      TextView tvBtnAddToCart, TextView tvCartQntt, TextView tvCostPrice, TextView tvCurrentimage,
      TextView tvDesc, TextView tvNoOfSold, TextView tvNoRatings, TextView tvProductName,
      TextView tvQnt, TextView tvRating, TextView tvRatingAndTotalReview, TextView tvSellerName,
      TextView tvSellingPrice, TextView tvTotalAmount, ViewPager vpProductDetail) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cardReview = cardReview;
    this.ivAdd = ivAdd;
    this.ivBack = ivBack;
    this.ivCart = ivCart;
    this.ivFav = ivFav;
    this.ivMinus = ivMinus;
    this.llBottomButtons = llBottomButtons;
    this.llRatingDetail = llRatingDetail;
    this.llVariant = llVariant;
    this.nsvMain = nsvMain;
    this.progressBar = progressBar;
    this.rbRating = rbRating;
    this.rbRatingReview = rbRatingReview;
    this.rvExtraImages = rvExtraImages;
    this.rvRatings = rvRatings;
    this.rvVarients = rvVarients;
    this.tvBtnAddToCart = tvBtnAddToCart;
    this.tvCartQntt = tvCartQntt;
    this.tvCostPrice = tvCostPrice;
    this.tvCurrentimage = tvCurrentimage;
    this.tvDesc = tvDesc;
    this.tvNoOfSold = tvNoOfSold;
    this.tvNoRatings = tvNoRatings;
    this.tvProductName = tvProductName;
    this.tvQnt = tvQnt;
    this.tvRating = tvRating;
    this.tvRatingAndTotalReview = tvRatingAndTotalReview;
    this.tvSellerName = tvSellerName;
    this.tvSellingPrice = tvSellingPrice;
    this.tvTotalAmount = tvTotalAmount;
    this.vpProductDetail = vpProductDetail;
  }

  @NonNull
  public static ActivityShopProductDetailActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_shop_product_detail_activity, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityShopProductDetailActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityShopProductDetailActivityBinding>inflateInternal(inflater, R.layout.activity_shop_product_detail_activity, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityShopProductDetailActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_shop_product_detail_activity, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityShopProductDetailActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityShopProductDetailActivityBinding>inflateInternal(inflater, R.layout.activity_shop_product_detail_activity, null, false, component);
  }

  public static ActivityShopProductDetailActivityBinding bind(@NonNull View view) {
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
  public static ActivityShopProductDetailActivityBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (ActivityShopProductDetailActivityBinding)bind(component, view, R.layout.activity_shop_product_detail_activity);
  }
}