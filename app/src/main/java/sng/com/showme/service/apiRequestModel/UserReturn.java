package sng.com.showme.service.apiRequestModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import sng.com.showme.model.UserSession;

/**
 * Created by son.nguyen on 4/19/2016.
 */
public class UserReturn {

    @SerializedName("user")
    @Expose
    private UserSession user;

    /**
     * @return The user
     */
    public UserSession getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    public void setUser(UserSession user) {
        this.user = user;
    }

}
