package com.pukingminion.cadbury;

import android.content.Context;

/**
 * Created by Samarth on 21/05/17.
 */

public class DisplayUtilities {

    public static void setDensity(Context context) {
        density = context.getResources().getDisplayMetrics().density;
    }

    private static float density = 1;
    private static Context context;

    public static int dp(float value) {
        if (value == 0) {
            return 0;
        }
        return (int) Math.ceil(density * value);
    }
}
