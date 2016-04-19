package sng.com.showme.loader;

import android.content.Context;

import sng.com.showme.exception.UserException;
import sng.com.showme.model.Data;
import sng.com.showme.model.UserSession;
import sng.com.showme.service.impl.DefaultServiceFactory;

/**
 * Created by son.nguyen on 4/18/2016.
 */
public class RegisterLoader extends BaseLoader<Data<UserSession>> {
    String body;

    public RegisterLoader(Context context, UserSession data) {
        super(context);
    }

    @Override
    protected Data<UserSession> doLoadInBackground() throws UserException {
        return DefaultServiceFactory.getsInstance(getContext()).getImpUserService().register(body);
    }
}
