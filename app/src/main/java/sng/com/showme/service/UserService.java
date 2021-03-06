package sng.com.showme.service;

import sng.com.showme.model.Data;
import sng.com.showme.service.apiRequestModel.UserReturn;

/**
 * Created by son.nguyen on 4/18/2016.
 */
public interface UserService {
    Data<UserReturn> register(String email, String pwd, String dob, String firstname, String lastname, String device_uiid);

    Data<UserReturn> login(String email, String pwd, String device_uiid);
}
