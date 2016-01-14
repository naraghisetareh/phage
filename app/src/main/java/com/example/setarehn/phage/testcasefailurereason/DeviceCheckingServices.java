package com.example.setarehn.phage.testcasefailurereason;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by SetarehN on 1/8/2016.
 */
public class DeviceCheckingServices {


    Context context;


    // internet connection
    public boolean checkInternetConnection()
    {
    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    if(activeNetwork!=null)

    { // connected to the internet
        if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
            // connected to wifi
            Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
            return true;
        } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
            // connected to the mobile provider's data plan
            Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    else

    {
        // not connected to the internet
        return false;
    }
        return false;
}





















}
