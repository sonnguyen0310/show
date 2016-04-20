package sng.com.showme.loader;

import android.content.Context;

import sng.com.showme.model.Data;
import sng.com.showme.service.apiRequestModel.UserReturn;
import sng.com.showme.service.impl.DefaultServiceFactory;

/**
 * Created by son.nguyen on 4/19/2016.
 */
public class LoginLoader extends BaseLoader<Data<UserReturn>> {
    private String mEmail;
    private String mPass;
    private String mKey;

    public LoginLoader(Context context, String email, String pass, String key) {
        super(context);
        mEmail = email;
        mPass = pass;
        mKey = key;
    }

    @Override
    protected Data<UserReturn> doLoadInBackground() throws Exception {
        return DefaultServiceFactory.getsInstance(getContext()).getImpUserService().login(mEmail, mPass, mKey);
    }
}
