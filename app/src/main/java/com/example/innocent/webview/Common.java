package com.example.innocent.webview;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by ADETUNJI on 7/16/2017.
 */

public class Common {

    public  static  boolean connectionAvailable(Context context){

        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo()!=null;
    }
}


