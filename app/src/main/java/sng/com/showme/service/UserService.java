package sng.com.showme.service;

import sng.com.showme.model.Data;
import sng.com.showme.model.UserSession;

/**
 * Created by son.nguyen on 4/18/2016.
 */
public interface UserService {
    Data<UserSession> register(String json);
    Data<UserSession> login(String json);
}
