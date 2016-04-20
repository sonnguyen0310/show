package sng.com.showme.service.impl;

import java.util.HashMap;

import sng.com.showme.BaseApplication;
import sng.com.showme.model.Data;
import sng.com.showme.service.UserService;
import sng.com.showme.service.apiRequestModel.UserReturn;
import sng.com.showme.service.dataprovider.ApiService;

/**
 * Created by son.nguyen on 4/18/2016.
 */
public class ImpUserService implements UserService {

    @Override
    public Data<UserReturn> register(String email, String pwd, String dob, String firstname, String lastname, String device_uiid) {
        HashMap<String, String> body = new HashMap<>();
        body.put("email",email);
        body.put("pwd",pwd);
        body.put("dob",dob);
        body.put("firstname",firstname);
        body.put("lastname",lastname);
        body.put("device_uiid",device_uiid);
        return ApiService.getInstance(BaseApplication.getContext()).register(body);
    }

    @Override
    public Data<UserReturn> login(String email, String pwd, String device_uiid) {
        HashMap<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("pwd", pwd);
        body.put("device_uiid", device_uiid);
        return ApiService.getInstance(BaseApplication.getContext()).login(body);
    }

}
