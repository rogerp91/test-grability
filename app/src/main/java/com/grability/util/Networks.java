package com.grability.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.grability.TestGrability;

/**
 * Created by rogerp91 on 03/03/17.
 */

public class Networks {

    /**
     * Networks
     *
     * @param context {@link Context}
     * @return boolean
     */
    public static boolean isOnline(Context context) {
        Context ctx = context == null ? TestGrability.getContext() : context;
        ConnectivityManager connMgr = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}