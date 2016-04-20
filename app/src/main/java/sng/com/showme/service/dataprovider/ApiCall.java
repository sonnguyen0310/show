package sng.com.showme.service.dataprovider;

import java.util.HashMap;

import retrofit.http.Body;
import retrofit.http.POST;
import sng.com.showme.model.Data;
import sng.com.showme.service.apiRequestModel.UserReturn;

/**
 * Created by son.nguyen on 3/19/2016.
 */
public interface ApiCall {
    /*UserSession*/
    @POST("/user")
    Data<UserReturn> register(@Body HashMap<String, String>body);
    @POST("/login")
    Data<UserReturn> login(@Body HashMap<String, String> body);
}
