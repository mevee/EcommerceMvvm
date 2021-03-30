package com.webkype.happiroo.controller.pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.webkype.happiroo.model.AddressModel;
import com.webkype.happiroo.model.User;


public class Preference {

    private static final String PREFS_NAME = "com_mclap_prefs";
    private static SharedPreferences _sharedPreferences = null;

    public static SharedPreferences getInstance(Context aContext) {
        if (_sharedPreferences == null)
            _sharedPreferences = aContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        return _sharedPreferences;
    }


    public static void saveUser(Context context, User userDataItem) {
        String userItemString = new Gson().toJson(userDataItem);
        getInstance(context).edit().putString(PrefConstants.User_OBJECT, userItemString).apply();
    }

    public static User getUser(Context context) {
        String userItemstr = getInstance(context).getString(PrefConstants.User_OBJECT, null);
        if (userItemstr == null)
            return null;
        else
            return new Gson().fromJson(userItemstr, User.class);
    }


    public static void save(Context context, String key, int value) {
        getInstance(context).edit().putInt(key, value).commit();
    }

    public static void save(Context context, String key, long value) {
        getInstance(context).edit().putLong(key, value).commit();
    }


    public static void save(Context context, String key, String value) {
        getInstance(context).edit().putString(key, value).commit();
    }

    public static void save(Context context, String key, Boolean status) {
        getInstance(context).edit().putBoolean(key, status).commit();
    }

    public static String getString(Context context, String key) {
        return getInstance(context).getString(key, "");
    }


    public static int getInt(Context context, String key) {
        return getInstance(context).getInt(key, 0);
    }

    public static long getLong(Context context, String key) {
        return getInstance(context).getLong(key, 0);
    }


    public static boolean getBoolean(Context context, String key) {

        return getInstance(context).getBoolean(key, false);
    }


    public static String getFirstLogin(Context c) {
        return getInstance(c).getString(PrefConstants.FISRT_LOGIN, "");
    }

    public static void setFirstLogin(Context c, String skipLogin) {
        getInstance(c).edit().putString(PrefConstants.FISRT_LOGIN, skipLogin).commit();
    }

    public static String getLoginSkipped(Context c) {
        return getInstance(c).getString(PrefConstants.LOGIN_SKIPPED, "");
    }

    public static void setLoginSkipped(Context c, String skipLogin) {
        getInstance(c).edit().putString(PrefConstants.LOGIN_SKIPPED, skipLogin).commit();
    }

    public static String getCartId(Context c) {
        return getInstance(c).getString(PrefConstants.CART_ID, "");
    }
    public static void setCartId(Context c, String cartId) {
        getInstance(c).edit().putString(PrefConstants.CART_ID, cartId).commit();
    }

  public static String getActiveShopping(Context c) {
        return getInstance(c).getString(PrefConstants.CART_ACTVE_SHOPPING, "");
    }
    public static void setActiveShopping(Context c, String cartId) {
        getInstance(c).edit().putString(PrefConstants.CART_ACTVE_SHOPPING, cartId).commit();
    }

    public static void saveAddress(Context context, AddressModel addressModel) {
        String userItemString = new Gson().toJson(addressModel);
        getInstance(context).edit().putString(PrefConstants.USER_ADDRESS, userItemString).apply();
    }

    public static AddressModel getAddress(Context context) {
        String userItemstr = getInstance(context).getString(PrefConstants.USER_ADDRESS, null);
        if (userItemstr == null)
            return null;
        else
            return new Gson().fromJson(userItemstr, AddressModel.class);
    }

    public static boolean logOut(Context context) {
        saveUser(context, null);
        setCartId(context, "");
        setActiveShopping(context, "");
        return true;
    }


}

