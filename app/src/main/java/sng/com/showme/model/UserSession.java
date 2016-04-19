package sng.com.showme.model;

/**
 * Created by son.nguyen on 4/18/2016.
 */
public class UserSession {
    private static UserSession sUserSession;

    private UserSession() {
        sUserSession = this;
    }

    public static UserSession getInstance() {
        if (sUserSession == null) {
            sUserSession = new UserSession();
        }
        return sUserSession;
    }

    public static void setUserSession(UserSession userSession) {
        sUserSession = userSession;
    }
}
