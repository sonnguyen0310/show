package sng.com.showme.service.impl;

import sng.com.showme.BaseApplication;
import sng.com.showme.model.Data;
import sng.com.showme.model.UserSession;
import sng.com.showme.service.UserService;
import sng.com.showme.service.dataprovider.ApiService;

/**
 * Created by son.nguyen on 4/18/2016.
 */
public class ImpUserService implements UserService {
    @Override
    public Data<UserSession> register(String json) {
        return ApiService.getInstance(BaseApplication.getContext()).register(json);
    }

    @Override
    public Data<UserSession> login(String json) {
        return null;
    }
}
