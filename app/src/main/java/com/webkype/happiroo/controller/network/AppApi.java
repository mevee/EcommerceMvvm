package com.webkype.happiroo.controller.network;

import com.webkype.happiroo.controller.network.responses.CommonResponse;
import com.webkype.happiroo.controller.network.responses.address.AddressResp;
import com.webkype.happiroo.controller.network.responses.auth.LoginResp;
import com.webkype.happiroo.controller.network.responses.auth.OtpResp;
import com.webkype.happiroo.controller.network.responses.book_serive_resp.BookServiceResp;
import com.webkype.happiroo.controller.network.responses.booking.BookingDetailResp;
import com.webkype.happiroo.controller.network.responses.booking.BookingHistoryResp;
import com.webkype.happiroo.controller.network.responses.booking.BookingsResp;
import com.webkype.happiroo.controller.network.responses.cart.AddToCartResponse;
import com.webkype.happiroo.controller.network.responses.cart.CartDetailResp;
import com.webkype.happiroo.controller.network.responses.cart.CartQuantityResponse;
import com.webkype.happiroo.controller.network.responses.cart.UpdateCartResp;
import com.webkype.happiroo.controller.network.responses.category.CatgoryDetailResp;
import com.webkype.happiroo.controller.network.responses.category.SubCatListResp;
import com.webkype.happiroo.controller.network.responses.home_page_resp.HomeApiResp;
import com.webkype.happiroo.controller.network.responses.mservices.FavServiceResp;
import com.webkype.happiroo.controller.network.responses.mservices.ServiceDetailResp;
import com.webkype.happiroo.controller.network.responses.mservices.ServiceListResp;
import com.webkype.happiroo.controller.network.responses.prod_detail_resp.ProductDetailResp;
import com.webkype.happiroo.controller.network.responses.prod_order_detail.OrderDetailResp;
import com.webkype.happiroo.controller.network.responses.prod_orders.OrderListResp;
import com.webkype.happiroo.controller.network.responses.prod_review_resp.ProductReviewResp;
import com.webkype.happiroo.controller.network.responses.product_cat.ProductCategoryResp;
import com.webkype.happiroo.controller.network.responses.product_list.ProductListResp;
import com.webkype.happiroo.controller.network.responses.wallet_resp.WalletResp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AppApi {


    @FormUrlEncoded
    @POST("login-signup.php")
    Call<OtpResp> loginSignUp(@Field("phoneno") String phoneno);

    @FormUrlEncoded
    @POST("otp-verification.php")
    Call<LoginResp> otpVarification(@Field("mobile_no") String mobile_no, @Field("otp") String otp);
    @FormUrlEncoded
    @POST("user_tokenid.php/")
    Call<CommonResponse> sendTokenToServer(
            @Field("userid") String userid,
            @Field("token_id") String stoken_id
    );

    @FormUrlEncoded
    @POST("update_user_profile.php")
    Call<LoginResp> updateUserDetail(@Field("userid") String userid,
                                     @Field("emailid") String emailid,
                                     @Field("fullname") String fullname);
    @GET("home-page.php")
    Call<HomeApiResp> getHomePageData();

    @FormUrlEncoded
    @POST("address-add-update.php")
    Call<CommonResponse> addUpdateAddress(@Field("userid") String userid,
                                          @Field("addressid") String addressid,
                                          @Field("option") String option,
                                          @Field("fullname") String fullname,
                                          @Field("mobileno") String mobileno,
                                          @Field("country") String country,
                                          @Field("state") String state,
                                          @Field("city") String city,
                                          @Field("address") String address,
                                          @Field("location") String location,
                                          @Field("locationtype") String locationtype);

    @FormUrlEncoded
    @POST("address-list.php")
    Call<AddressResp> getAddressList(@Field("userid") String userid);


    @FormUrlEncoded
    @POST("services.php")
    Call<ServiceListResp> getServices(@Field("catid") String catid,
                                      @Field("cartid") String cartid);

    @FormUrlEncoded
    @POST("service_detail.php")
    Call<ServiceDetailResp> getServiceDetail(@Field("serviceid") String serviceid,
                                             @Field("cartid") String cartid,
                                             @Field("userid") String userid);

    @FormUrlEncoded
    @POST("subcategory-list.php")
    Call<SubCatListResp> getSubCatLIst(@Field("parentcatid") String parentcatid);


    @FormUrlEncoded
    @POST("addremovefavorite.php")
    Call<CommonResponse> addremovefavorite(@Field("servid") String servid,
                                           @Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("add-review.php")
    Call<CommonResponse> addReview(@Field("serviceid") String serviceid,
                                   @Field("message") String message,
                                   @Field("rating") String rating,
                                   @Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("add-vendor-reviews.php")
    Call<CommonResponse> addVendorReview(
            @Field("vendorid") String vendorid,
            @Field("message") String message,
            @Field("rating") String rating,
            @Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("cancel-booking.php")
    Call<CommonResponse> cancelABooking(@Field("bookingid") String bookingid);

    @FormUrlEncoded
    @POST("booking-history.php")
    Call<BookingHistoryResp> getBookingHistoryList(@Field("user_id") String user_id);


    @FormUrlEncoded
    @POST("booking-list.php")
    Call<BookingsResp> getBookingList(@Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("booking-details.php")
    Call<BookingDetailResp> getBookingDetail(@Field("bookingid") String bookingid);

    @FormUrlEncoded
    @POST("userfavoriteservice-list.php")
    Call<FavServiceResp> getFavServiceList(@Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("category-details.php")
    Call<CatgoryDetailResp> getCategoryDetail(@Field("catid") String catid);

    @FormUrlEncoded
    @POST("cart_product.php")
    Call<CartDetailResp> getCartProducts(@Field("cartid") String cartid,
                                         @Field("iswalletused") String iswalletused,
                                         @Field("userid") String userid);

    @FormUrlEncoded
    @POST("add_to_cart.php")
    Call<AddToCartResponse> addToCart(@Field("serviceid") String serviceid,
                                      @Field("cartid") String cartid,
                                      @Field("qty") String qty,
                                      @Field("type") String type,
                                      @Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("update_cart_product.php")
    Call<UpdateCartResp> updateCartProduct(@Field("pid") String pid,
                                           @Field("cartid") String cartid,
                                           @Field("option") String option);

    @FormUrlEncoded
    @POST("delete-cart-service.php")
    Call<CommonResponse> deleteService(@Field("serviceid") String serviceid,
                                       @Field("cartid") String cartid);

    @FormUrlEncoded
    @POST("cart-details-new.php")
    Call<CartQuantityResponse> getCartDetail(@Field("cartid") String cartid);

    @FormUrlEncoded
    @POST("book-service.php")
    Call<BookServiceResp> bookService(@Field("user_id") String user_id,
                                      @Field("cartid") String cartid,
                                      @Field("payment_mode") String payment_mode,
                                      @Field("servicedate") String servicedate,
                                      @Field("timeslot") String timeslot,
                                      @Field("addressid") String addressid,
                                      @Field("transaction_id") String transaction_id,
                                      @Field("iswalletused") String iswalletused);


    @FormUrlEncoded
    @POST("approve-service-payment.php")
    Call<CommonResponse> approveServicePayment(@Field("booking_id") String booking_id,
                                     @Field("orderid") String orderid,
                                     @Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("book-product.php")
    Call<CommonResponse> bookProduct(@Field("user_id") String user_id,
                                     @Field("cartid") String cartid,
                                     @Field("payment_mode") String payment_mode,
                                     @Field("servicedate") String servicedate,
                                     @Field("timeslot") String timeslot,
                                     @Field("addressid") String addressid,
                                     @Field("transaction_id") String transaction_id,
                                     @Field("iswalletused") String iswalletused);

//    shop or e-commmerce apis not for service
    @GET("product-category.php")
    Call<ProductCategoryResp> getSellCategory();


    @FormUrlEncoded
    @POST("product-sub-category.php")
    Call<ProductCategoryResp> getSellSubCategory(@Field("catid") String cartid);

    @FormUrlEncoded
    @POST("product.php")
    Call<ProductListResp> getSellProduct(@Field("catid") String cartid,
                                         @Field("user_id") String user_id);
    @FormUrlEncoded
    @POST("fav-pro-list.php")
    Call<ProductListResp> getFavProductLIst(@Field("user_id") String user_id);


    @FormUrlEncoded
    @POST("addremovefavoriteproduct.php")
    Call<CommonResponse> addremovefavoriteproduct(@Field("proid") String proid,
                                                  @Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("product_details.php")
    Call<ProductDetailResp> getProductDetail(@Field("proid") String proid,
                                             @Field("cartid") String cartid,
                                             @Field("user_id") String user_id);

    /*productid:11
cartid:1
qty:2
user_id:5*/
  /*  @FormUrlEncoded
    @POST("add_pro_to_cart.php")
    Call<AddToCartResponse> addToCartProduct(@Field("productid") String productid,
                                             @Field("cartid") String cartid,
                                             @Field("qty") String qty,
                                             @Field("type") String type ,
                                             @Field("user_id") String user_id);*/
/*user_id:1
productid:2
message:bn
rating:4*/
    @FormUrlEncoded
    @POST("add-pro-review.php")
    Call<CommonResponse> addProductReview(@Field("user_id") String user_id,
                                          @Field("productid") String productid,
                                          @Field("message") String message,
                                          @Field("rating") String rating);

    @FormUrlEncoded
    @POST("pro_reviews_list.php")
    Call<ProductReviewResp> getProductReview(@Field("productid") String productid);

    @FormUrlEncoded
    @POST("product-booking-list.php")
    Call<OrderListResp> getOrderList(@Field("user_id") String user_id);



    @FormUrlEncoded
    @POST("pro-order-details.php")
    Call<OrderDetailResp> getOrderDetail(@Field("bookingid") String bookingid);




    @FormUrlEncoded
    @POST("cancel-pro-booking.php")
    Call<CommonResponse> cancelOrder(@Field("bookingid") String bookingid);



    @FormUrlEncoded
    @POST("wallet.php")
    Call<WalletResp> getWalletDetail(@Field("user_id") String user_id);


    @FormUrlEncoded
    @POST("add-wallet.php")
    Call<CommonResponse> addWalletAmout(@Field("user_id") String user_id,
                                          @Field("reason") String reason,
                                          @Field("credit") String credit);

}
