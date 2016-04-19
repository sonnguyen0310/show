package sng.com.showme.service.dataprovider;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import sng.com.showme.model.Data;
import sng.com.showme.model.UserSession;

/**
 * Created by son.nguyen on 3/19/2016.
 */
public interface ApiCall {
    /*UserSession*/
    @FormUrlEncoded
    @POST("/user")
    Data<UserSession> register(@Field("email") String email,
                               @Field("pwd") String pwd,
                               @Field("dob") String dob,
                               @Field("firstname") String firstname,
                               @Field("lastname") String lastname,
                               @Field("device_uiid") String device_uiid);
    @FormUrlEncoded
    @POST("/login")
    Data<UserSession> login(@Field("email") String email,
                            @Field("pwd") String pwd,
                            @Field("device_uiid") String device_uiid);
}
