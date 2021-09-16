package com.webkype.happiroo;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.webkype.happiroo.databinding.ActivityAddEditAddressBindingImpl;
import com.webkype.happiroo.databinding.ActivityAddressBindingImpl;
import com.webkype.happiroo.databinding.ActivityBookingDetailBindingImpl;
import com.webkype.happiroo.databinding.ActivityCartBindingImpl;
import com.webkype.happiroo.databinding.ActivityCartOverviewBindingImpl;
import com.webkype.happiroo.databinding.ActivityFavProductListBindingImpl;
import com.webkype.happiroo.databinding.ActivityListingBindingImpl;
import com.webkype.happiroo.databinding.ActivityOrderDetailBindingImpl;
import com.webkype.happiroo.databinding.ActivityOrderListBindingImpl;
import com.webkype.happiroo.databinding.ActivityProductDetailBindingImpl;
import com.webkype.happiroo.databinding.ActivityProductListBindingImpl;
import com.webkype.happiroo.databinding.ActivityProfileEditBindingImpl;
import com.webkype.happiroo.databinding.ActivitySelectSlotBindingImpl;
import com.webkype.happiroo.databinding.ActivityServiceDetailBindingImpl;
import com.webkype.happiroo.databinding.ActivityShopProductDetailActivityBindingImpl;
import com.webkype.happiroo.databinding.ActivityShoppingCatBindingImpl;
import com.webkype.happiroo.databinding.AddressItmBindingImpl;
import com.webkype.happiroo.databinding.BookingHistoryBindingImpl;
import com.webkype.happiroo.databinding.BookingOngoingBindingImpl;
import com.webkype.happiroo.databinding.FavServiceListBindingImpl;
import com.webkype.happiroo.databinding.FragmentAddProductRatingBindingImpl;
import com.webkype.happiroo.databinding.FragmentAddVendorReviewBindingImpl;
import com.webkype.happiroo.databinding.FragmentFavBindingImpl;
import com.webkype.happiroo.databinding.FragmentHistoryBookingBindingImpl;
import com.webkype.happiroo.databinding.FragmentHomeBindingImpl;
import com.webkype.happiroo.databinding.FragmentOngoingBookingBindingImpl;
import com.webkype.happiroo.databinding.FragmentProfileBindingImpl;
import com.webkype.happiroo.databinding.FragmentShopBindingImpl;
import com.webkype.happiroo.databinding.FragmentWalletBindingImpl;
import com.webkype.happiroo.databinding.ImageItemBindingImpl;
import com.webkype.happiroo.databinding.IncludeItemBindingImpl;
import com.webkype.happiroo.databinding.ItemInOrderBindingImpl;
import com.webkype.happiroo.databinding.OrderItemBindingImpl;
import com.webkype.happiroo.databinding.PagerItemBindingImpl;
import com.webkype.happiroo.databinding.PriceDetailLayoutBindingImpl;
import com.webkype.happiroo.databinding.ProductInCartBindingImpl;
import com.webkype.happiroo.databinding.ProductItemBindingImpl;
import com.webkype.happiroo.databinding.ReviewItemBindingImpl;
import com.webkype.happiroo.databinding.ShopCatItemBindingImpl;
import com.webkype.happiroo.databinding.ShopProductItemBindingImpl;
import com.webkype.happiroo.databinding.ToolbarLayoutBindingImpl;
import com.webkype.happiroo.databinding.TransactionItemBindingImpl;
import com.webkype.happiroo.databinding.UserInputRatingBindingImpl;
import com.webkype.happiroo.databinding.UserProductReviewBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYADDEDITADDRESS = 1;

  private static final int LAYOUT_ACTIVITYADDRESS = 2;

  private static final int LAYOUT_ACTIVITYBOOKINGDETAIL = 3;

  private static final int LAYOUT_ACTIVITYCART = 4;

  private static final int LAYOUT_ACTIVITYCARTOVERVIEW = 5;

  private static final int LAYOUT_ACTIVITYFAVPRODUCTLIST = 6;

  private static final int LAYOUT_ACTIVITYLISTING = 7;

  private static final int LAYOUT_ACTIVITYORDERDETAIL = 8;

  private static final int LAYOUT_ACTIVITYORDERLIST = 9;

  private static final int LAYOUT_ACTIVITYPRODUCTDETAIL = 10;

  private static final int LAYOUT_ACTIVITYPRODUCTLIST = 11;

  private static final int LAYOUT_ACTIVITYPROFILEEDIT = 12;

  private static final int LAYOUT_ACTIVITYSELECTSLOT = 13;

  private static final int LAYOUT_ACTIVITYSERVICEDETAIL = 14;

  private static final int LAYOUT_ACTIVITYSHOPPRODUCTDETAILACTIVITY = 15;

  private static final int LAYOUT_ACTIVITYSHOPPINGCAT = 16;

  private static final int LAYOUT_ADDRATINGDIALOG = 17;

  private static final int LAYOUT_ADDRESSITEM = 18;

  private static final int LAYOUT_BOOKHISTORYITEM = 19;

  private static final int LAYOUT_BOOKONGOINGITEM = 20;

  private static final int LAYOUT_CUSTOMERREVIEWITEM = 21;

  private static final int LAYOUT_FAVSERVICEITEM = 22;

  private static final int LAYOUT_FRAGMENTADDPRODUCTRATING = 23;

  private static final int LAYOUT_FRAGMENTBOTTOMADDVENDORREVIEW = 24;

  private static final int LAYOUT_FRAGMENTFAV = 25;

  private static final int LAYOUT_FRAGMENTHISTORYBOOKING = 26;

  private static final int LAYOUT_FRAGMENTHOME = 27;

  private static final int LAYOUT_FRAGMENTONGOINGBOOKING = 28;

  private static final int LAYOUT_FRAGMENTPROFILE = 29;

  private static final int LAYOUT_FRAGMENTSHOP = 30;

  private static final int LAYOUT_FRAGMENTWALLET = 31;

  private static final int LAYOUT_IMAGEBANNERLAYOUT = 32;

  private static final int LAYOUT_ITEMINORDERLAYOUT = 33;

  private static final int LAYOUT_ITEMINCLUDELAYOUT = 34;

  private static final int LAYOUT_ORDERITEMLAYOUT = 35;

  private static final int LAYOUT_PAGERBANNERLAYOUT = 36;

  private static final int LAYOUT_PRICEDETAILLAYOUT = 37;

  private static final int LAYOUT_PRODUCTSINCARTITEM = 38;

  private static final int LAYOUT_PRODUCTSITEM = 39;

  private static final int LAYOUT_SHOPCATITEM = 40;

  private static final int LAYOUT_SHOPPRODUCTITEMLAYOUT = 41;

  private static final int LAYOUT_TOOLBARLAYOUT = 42;

  private static final int LAYOUT_USERREVIEWITEM = 43;

  private static final int LAYOUT_WALLETTRANSACTIONITEM = 44;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(44);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_add_edit_address, LAYOUT_ACTIVITYADDEDITADDRESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_address, LAYOUT_ACTIVITYADDRESS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_booking_detail, LAYOUT_ACTIVITYBOOKINGDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_cart, LAYOUT_ACTIVITYCART);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_cart_overview, LAYOUT_ACTIVITYCARTOVERVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_fav_product_list, LAYOUT_ACTIVITYFAVPRODUCTLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_listing, LAYOUT_ACTIVITYLISTING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_order_detail, LAYOUT_ACTIVITYORDERDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_order_list, LAYOUT_ACTIVITYORDERLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_product_detail, LAYOUT_ACTIVITYPRODUCTDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_product_list, LAYOUT_ACTIVITYPRODUCTLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_profile_edit, LAYOUT_ACTIVITYPROFILEEDIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_select_slot, LAYOUT_ACTIVITYSELECTSLOT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_service_detail, LAYOUT_ACTIVITYSERVICEDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_shop_product_detail_activity, LAYOUT_ACTIVITYSHOPPRODUCTDETAILACTIVITY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.activity_shopping_cat, LAYOUT_ACTIVITYSHOPPINGCAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.add_rating_dialog, LAYOUT_ADDRATINGDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.address_item, LAYOUT_ADDRESSITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.book_history_item, LAYOUT_BOOKHISTORYITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.book_ongoing_item, LAYOUT_BOOKONGOINGITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.customer_review_item, LAYOUT_CUSTOMERREVIEWITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.fav_service_item, LAYOUT_FAVSERVICEITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.fragment_add_product_rating, LAYOUT_FRAGMENTADDPRODUCTRATING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.fragment_bottom_add_vendor_review, LAYOUT_FRAGMENTBOTTOMADDVENDORREVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.fragment_fav, LAYOUT_FRAGMENTFAV);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.fragment_history_booking, LAYOUT_FRAGMENTHISTORYBOOKING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.fragment_ongoing_booking, LAYOUT_FRAGMENTONGOINGBOOKING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.fragment_shop, LAYOUT_FRAGMENTSHOP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.fragment_wallet, LAYOUT_FRAGMENTWALLET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.image_banner_layout, LAYOUT_IMAGEBANNERLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.item_in_order_layout, LAYOUT_ITEMINORDERLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.item_include_layout, LAYOUT_ITEMINCLUDELAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.order_item_layout, LAYOUT_ORDERITEMLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.pager_banner_layout, LAYOUT_PAGERBANNERLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.price_detail_layout, LAYOUT_PRICEDETAILLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.products_in_cart_item, LAYOUT_PRODUCTSINCARTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.products_item, LAYOUT_PRODUCTSITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.shop_cat_item, LAYOUT_SHOPCATITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.shop_product_item_layout, LAYOUT_SHOPPRODUCTITEMLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.toolbar_layout, LAYOUT_TOOLBARLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.user_review_item, LAYOUT_USERREVIEWITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.webkype.happiroo.R.layout.wallet_transaction_item, LAYOUT_WALLETTRANSACTIONITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYADDEDITADDRESS: {
          if ("layout/activity_add_edit_address_0".equals(tag)) {
            return new ActivityAddEditAddressBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_add_edit_address is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYADDRESS: {
          if ("layout/activity_address_0".equals(tag)) {
            return new ActivityAddressBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_address is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYBOOKINGDETAIL: {
          if ("layout/activity_booking_detail_0".equals(tag)) {
            return new ActivityBookingDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_booking_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCART: {
          if ("layout/activity_cart_0".equals(tag)) {
            return new ActivityCartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_cart is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCARTOVERVIEW: {
          if ("layout/activity_cart_overview_0".equals(tag)) {
            return new ActivityCartOverviewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_cart_overview is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYFAVPRODUCTLIST: {
          if ("layout/activity_fav_product_list_0".equals(tag)) {
            return new ActivityFavProductListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_fav_product_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLISTING: {
          if ("layout/activity_listing_0".equals(tag)) {
            return new ActivityListingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_listing is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYORDERDETAIL: {
          if ("layout/activity_order_detail_0".equals(tag)) {
            return new ActivityOrderDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_order_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYORDERLIST: {
          if ("layout/activity_order_list_0".equals(tag)) {
            return new ActivityOrderListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_order_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRODUCTDETAIL: {
          if ("layout/activity_product_detail_0".equals(tag)) {
            return new ActivityProductDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_product_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRODUCTLIST: {
          if ("layout/activity_product_list_0".equals(tag)) {
            return new ActivityProductListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_product_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPROFILEEDIT: {
          if ("layout/activity_profile_edit_0".equals(tag)) {
            return new ActivityProfileEditBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_profile_edit is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSELECTSLOT: {
          if ("layout/activity_select_slot_0".equals(tag)) {
            return new ActivitySelectSlotBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_select_slot is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSERVICEDETAIL: {
          if ("layout/activity_service_detail_0".equals(tag)) {
            return new ActivityServiceDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_service_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSHOPPRODUCTDETAILACTIVITY: {
          if ("layout/activity_shop_product_detail_activity_0".equals(tag)) {
            return new ActivityShopProductDetailActivityBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_shop_product_detail_activity is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSHOPPINGCAT: {
          if ("layout/activity_shopping_cat_0".equals(tag)) {
            return new ActivityShoppingCatBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_shopping_cat is invalid. Received: " + tag);
        }
        case  LAYOUT_ADDRATINGDIALOG: {
          if ("layout/add_rating_dialog_0".equals(tag)) {
            return new UserInputRatingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for add_rating_dialog is invalid. Received: " + tag);
        }
        case  LAYOUT_ADDRESSITEM: {
          if ("layout/address_item_0".equals(tag)) {
            return new AddressItmBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for address_item is invalid. Received: " + tag);
        }
        case  LAYOUT_BOOKHISTORYITEM: {
          if ("layout/book_history_item_0".equals(tag)) {
            return new BookingHistoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for book_history_item is invalid. Received: " + tag);
        }
        case  LAYOUT_BOOKONGOINGITEM: {
          if ("layout/book_ongoing_item_0".equals(tag)) {
            return new BookingOngoingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for book_ongoing_item is invalid. Received: " + tag);
        }
        case  LAYOUT_CUSTOMERREVIEWITEM: {
          if ("layout/customer_review_item_0".equals(tag)) {
            return new ReviewItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for customer_review_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FAVSERVICEITEM: {
          if ("layout/fav_service_item_0".equals(tag)) {
            return new FavServiceListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fav_service_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTADDPRODUCTRATING: {
          if ("layout/fragment_add_product_rating_0".equals(tag)) {
            return new FragmentAddProductRatingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_add_product_rating is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTBOTTOMADDVENDORREVIEW: {
          if ("layout/fragment_bottom_add_vendor_review_0".equals(tag)) {
            return new FragmentAddVendorReviewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_bottom_add_vendor_review is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFAV: {
          if ("layout/fragment_fav_0".equals(tag)) {
            return new FragmentFavBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_fav is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHISTORYBOOKING: {
          if ("layout/fragment_history_booking_0".equals(tag)) {
            return new FragmentHistoryBookingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_history_booking is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTONGOINGBOOKING: {
          if ("layout/fragment_ongoing_booking_0".equals(tag)) {
            return new FragmentOngoingBookingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_ongoing_booking is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPROFILE: {
          if ("layout/fragment_profile_0".equals(tag)) {
            return new FragmentProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSHOP: {
          if ("layout/fragment_shop_0".equals(tag)) {
            return new FragmentShopBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_shop is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWALLET: {
          if ("layout/fragment_wallet_0".equals(tag)) {
            return new FragmentWalletBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_wallet is invalid. Received: " + tag);
        }
        case  LAYOUT_IMAGEBANNERLAYOUT: {
          if ("layout/image_banner_layout_0".equals(tag)) {
            return new ImageItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for image_banner_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMINORDERLAYOUT: {
          if ("layout/item_in_order_layout_0".equals(tag)) {
            return new ItemInOrderBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_in_order_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMINCLUDELAYOUT: {
          if ("layout/item_include_layout_0".equals(tag)) {
            return new IncludeItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_include_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_ORDERITEMLAYOUT: {
          if ("layout/order_item_layout_0".equals(tag)) {
            return new OrderItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for order_item_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_PAGERBANNERLAYOUT: {
          if ("layout/pager_banner_layout_0".equals(tag)) {
            return new PagerItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for pager_banner_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_PRICEDETAILLAYOUT: {
          if ("layout/price_detail_layout_0".equals(tag)) {
            return new PriceDetailLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for price_detail_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_PRODUCTSINCARTITEM: {
          if ("layout/products_in_cart_item_0".equals(tag)) {
            return new ProductInCartBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for products_in_cart_item is invalid. Received: " + tag);
        }
        case  LAYOUT_PRODUCTSITEM: {
          if ("layout/products_item_0".equals(tag)) {
            return new ProductItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for products_item is invalid. Received: " + tag);
        }
        case  LAYOUT_SHOPCATITEM: {
          if ("layout/shop_cat_item_0".equals(tag)) {
            return new ShopCatItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for shop_cat_item is invalid. Received: " + tag);
        }
        case  LAYOUT_SHOPPRODUCTITEMLAYOUT: {
          if ("layout/shop_product_item_layout_0".equals(tag)) {
            return new ShopProductItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for shop_product_item_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_TOOLBARLAYOUT: {
          if ("layout/toolbar_layout_0".equals(tag)) {
            return new ToolbarLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for toolbar_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_USERREVIEWITEM: {
          if ("layout/user_review_item_0".equals(tag)) {
            return new UserProductReviewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for user_review_item is invalid. Received: " + tag);
        }
        case  LAYOUT_WALLETTRANSACTIONITEM: {
          if ("layout/wallet_transaction_item_0".equals(tag)) {
            return new TransactionItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for wallet_transaction_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(44);

    static {
      sKeys.put("layout/activity_add_edit_address_0", com.webkype.happiroo.R.layout.activity_add_edit_address);
      sKeys.put("layout/activity_address_0", com.webkype.happiroo.R.layout.activity_address);
      sKeys.put("layout/activity_booking_detail_0", com.webkype.happiroo.R.layout.activity_booking_detail);
      sKeys.put("layout/activity_cart_0", com.webkype.happiroo.R.layout.activity_cart);
      sKeys.put("layout/activity_cart_overview_0", com.webkype.happiroo.R.layout.activity_cart_overview);
      sKeys.put("layout/activity_fav_product_list_0", com.webkype.happiroo.R.layout.activity_fav_product_list);
      sKeys.put("layout/activity_listing_0", com.webkype.happiroo.R.layout.activity_listing);
      sKeys.put("layout/activity_order_detail_0", com.webkype.happiroo.R.layout.activity_order_detail);
      sKeys.put("layout/activity_order_list_0", com.webkype.happiroo.R.layout.activity_order_list);
      sKeys.put("layout/activity_product_detail_0", com.webkype.happiroo.R.layout.activity_product_detail);
      sKeys.put("layout/activity_product_list_0", com.webkype.happiroo.R.layout.activity_product_list);
      sKeys.put("layout/activity_profile_edit_0", com.webkype.happiroo.R.layout.activity_profile_edit);
      sKeys.put("layout/activity_select_slot_0", com.webkype.happiroo.R.layout.activity_select_slot);
      sKeys.put("layout/activity_service_detail_0", com.webkype.happiroo.R.layout.activity_service_detail);
      sKeys.put("layout/activity_shop_product_detail_activity_0", com.webkype.happiroo.R.layout.activity_shop_product_detail_activity);
      sKeys.put("layout/activity_shopping_cat_0", com.webkype.happiroo.R.layout.activity_shopping_cat);
      sKeys.put("layout/add_rating_dialog_0", com.webkype.happiroo.R.layout.add_rating_dialog);
      sKeys.put("layout/address_item_0", com.webkype.happiroo.R.layout.address_item);
      sKeys.put("layout/book_history_item_0", com.webkype.happiroo.R.layout.book_history_item);
      sKeys.put("layout/book_ongoing_item_0", com.webkype.happiroo.R.layout.book_ongoing_item);
      sKeys.put("layout/customer_review_item_0", com.webkype.happiroo.R.layout.customer_review_item);
      sKeys.put("layout/fav_service_item_0", com.webkype.happiroo.R.layout.fav_service_item);
      sKeys.put("layout/fragment_add_product_rating_0", com.webkype.happiroo.R.layout.fragment_add_product_rating);
      sKeys.put("layout/fragment_bottom_add_vendor_review_0", com.webkype.happiroo.R.layout.fragment_bottom_add_vendor_review);
      sKeys.put("layout/fragment_fav_0", com.webkype.happiroo.R.layout.fragment_fav);
      sKeys.put("layout/fragment_history_booking_0", com.webkype.happiroo.R.layout.fragment_history_booking);
      sKeys.put("layout/fragment_home_0", com.webkype.happiroo.R.layout.fragment_home);
      sKeys.put("layout/fragment_ongoing_booking_0", com.webkype.happiroo.R.layout.fragment_ongoing_booking);
      sKeys.put("layout/fragment_profile_0", com.webkype.happiroo.R.layout.fragment_profile);
      sKeys.put("layout/fragment_shop_0", com.webkype.happiroo.R.layout.fragment_shop);
      sKeys.put("layout/fragment_wallet_0", com.webkype.happiroo.R.layout.fragment_wallet);
      sKeys.put("layout/image_banner_layout_0", com.webkype.happiroo.R.layout.image_banner_layout);
      sKeys.put("layout/item_in_order_layout_0", com.webkype.happiroo.R.layout.item_in_order_layout);
      sKeys.put("layout/item_include_layout_0", com.webkype.happiroo.R.layout.item_include_layout);
      sKeys.put("layout/order_item_layout_0", com.webkype.happiroo.R.layout.order_item_layout);
      sKeys.put("layout/pager_banner_layout_0", com.webkype.happiroo.R.layout.pager_banner_layout);
      sKeys.put("layout/price_detail_layout_0", com.webkype.happiroo.R.layout.price_detail_layout);
      sKeys.put("layout/products_in_cart_item_0", com.webkype.happiroo.R.layout.products_in_cart_item);
      sKeys.put("layout/products_item_0", com.webkype.happiroo.R.layout.products_item);
      sKeys.put("layout/shop_cat_item_0", com.webkype.happiroo.R.layout.shop_cat_item);
      sKeys.put("layout/shop_product_item_layout_0", com.webkype.happiroo.R.layout.shop_product_item_layout);
      sKeys.put("layout/toolbar_layout_0", com.webkype.happiroo.R.layout.toolbar_layout);
      sKeys.put("layout/user_review_item_0", com.webkype.happiroo.R.layout.user_review_item);
      sKeys.put("layout/wallet_transaction_item_0", com.webkype.happiroo.R.layout.wallet_transaction_item);
    }
  }
}
