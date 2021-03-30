package com.webkype.happiroo.controller.utils;

import android.text.TextUtils;

import java.text.NumberFormat;
import java.util.Locale;

public class StringUtil {

    public static String capitalizeFirst(String inPutString) {
        String newString = "";
        if (TextUtils.isEmpty(inPutString))
            return newString;
        else {
            int i = 0;
            for (Character a : inPutString.toCharArray()) {
                if (i == 0)
                    newString += a.toString().toUpperCase();
                else
                    newString += a;
                i++;
            }
            return newString;
        }
    }

    public static String formatZerosAfterDecimal(float number) {
        Locale locale = Locale.ENGLISH;
        NumberFormat nf = NumberFormat.getNumberInstance(locale);
// for trailing zeros:
        nf.setMinimumFractionDigits(2);
// round to 2 digits:
        nf.setMaximumFractionDigits(2);
//        System.out.println(nf.format(.99));
        return nf.format(number);
    }
}