package sng.com.showme.service.impl;

import android.content.Context;

import sng.com.showme.service.ServiceFactory;

/**
 * Created by son.nguyen on 3/18/2016.
 */
public class DefaultServiceFactory implements ServiceFactory {
    private static DefaultServiceFactory sInstance;
    private static ImpUserService sImpUserService;

    public DefaultServiceFactory(Context context) {
        sImpUserService = new ImpUserService();
    }

    public static DefaultServiceFactory getsInstance(Context context) {
        if (null == sInstance) {
            sInstance = new DefaultServiceFactory(context);
        }
        return sInstance;
    }

    public ImpUserService getImpUserService() {
        return sImpUserService;
    }

}
