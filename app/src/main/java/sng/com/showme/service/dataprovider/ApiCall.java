package sng.com.showme.service.dataprovider;

import retrofit.http.Body;
import retrofit.http.POST;
import sng.com.showme.model.Data;
import sng.com.showme.model.UserSession;

/**
 * Created by son.nguyen on 3/19/2016.
 */
public interface ApiCall {
    /*UserSession*/
    @POST("/user")
    Data<UserSession> register(@Body String json);
}
