package com.igorbobar.m2016.Utilities;

public class Utility { 

    static public boolean isNetworkAvailable(Context c) {
        ConnectivityManager cm = 
                (ConnectivityManager)c.getSystemService(Context.CONNECTIVITY_SERVICE);
            
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    } 
}
