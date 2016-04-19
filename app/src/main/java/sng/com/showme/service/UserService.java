package sng.com.showme.service;

import sng.com.showme.model.Data;
import sng.com.showme.model.UserSession;

/**
 * Created by son.nguyen on 4/18/2016.
 */
public interface UserService {
    Data<UserSession> register(String email, String pwd, String dob, String firstname, String lastname, String device_uiid);

    Data<UserSession> login(String email, String pwd, String device_uiid);
}
