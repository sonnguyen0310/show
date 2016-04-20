package sng.com.showme.loader;

import android.content.Context;

import sng.com.showme.exception.UserException;
import sng.com.showme.model.Data;
import sng.com.showme.service.apiRequestModel.UserReturn;
import sng.com.showme.service.impl.DefaultServiceFactory;

/**
 * Created by son.nguyen on 4/18/2016.
 */
public class RegisterLoader extends BaseLoader<Data<UserReturn>> {
    String body;
    String mEmail;
    String mPwd;
    String mDob;
    String mFirstName;
    String mLastname;
    String mDevice_uiid;

    public RegisterLoader(Context context, String email, String pwd, String dob, String firstname, String lastname, String device_uiid) {
        super(context);
        mEmail = email;
        mPwd = pwd;
        mDob = dob;
        mFirstName = firstname;
        mLastname = lastname;
        mDevice_uiid = device_uiid;

    }

    @Override
    protected Data<UserReturn> doLoadInBackground() throws UserException {
        return DefaultServiceFactory.getsInstance(getContext()).getImpUserService().register(mEmail,mPwd,mDob,mFirstName,mLastname,mDevice_uiid);
    }
}
