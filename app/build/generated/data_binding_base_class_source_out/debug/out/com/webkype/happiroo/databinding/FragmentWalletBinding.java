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
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.webkype.happiroo.R;
import com.webkype.happiroo.controller.utils.UnderlineTextView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentWalletBinding extends ViewDataBinding {
  @NonNull
  public final ImageView img1;

  @NonNull
  public final ImageView img2;

  @NonNull
  public final LinearLayout llNotLogged;

  @NonNull
  public final NestedScrollView nsvMainWallet;

  @NonNull
  public final ProgressBar progressbarWalletFrag;

  @NonNull
  public final UnderlineTextView rechargeWalletBtnTxt;

  @NonNull
  public final RelativeLayout referralApplyRelativeBtn;

  @NonNull
  public final RecyclerView rvWalletTransaction;

  @NonNull
  public final TextView tvAmountWallet;

  @NonNull
  public final TextView tvBtnLogin;

  protected FragmentWalletBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView img1, ImageView img2, LinearLayout llNotLogged, NestedScrollView nsvMainWallet,
      ProgressBar progressbarWalletFrag, UnderlineTextView rechargeWalletBtnTxt,
      RelativeLayout referralApplyRelativeBtn, RecyclerView rvWalletTransaction,
      TextView tvAmountWallet, TextView tvBtnLogin) {
    super(_bindingComponent, _root, _localFieldCount);
    this.img1 = img1;
    this.img2 = img2;
    this.llNotLogged = llNotLogged;
    this.nsvMainWallet = nsvMainWallet;
    this.progressbarWalletFrag = progressbarWalletFrag;
    this.rechargeWalletBtnTxt = rechargeWalletBtnTxt;
    this.referralApplyRelativeBtn = referralApplyRelativeBtn;
    this.rvWalletTransaction = rvWalletTransaction;
    this.tvAmountWallet = tvAmountWallet;
    this.tvBtnLogin = tvBtnLogin;
  }

  @NonNull
  public static FragmentWalletBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_wallet, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentWalletBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentWalletBinding>inflateInternal(inflater, R.layout.fragment_wallet, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentWalletBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_wallet, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentWalletBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentWalletBinding>inflateInternal(inflater, R.layout.fragment_wallet, null, false, component);
  }

  public static FragmentWalletBinding bind(@NonNull View view) {
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
  public static FragmentWalletBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentWalletBinding)bind(component, view, R.layout.fragment_wallet);
  }
}
