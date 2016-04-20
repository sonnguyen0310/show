package sng.com.showme;

import android.content.Context;

/**
 * Created by son.nguyen on 3/17/2016.
 */
public class BaseApplication extends android.app.Application {
    private static BaseApplication sInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static Context getContext() {
        return sInstance;
    }

    public static String getGcmKey() {
        return "";
    }


}
