package sng.com.showme.service.intentService;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

import sng.com.showme.R;
import sng.com.showme.model.UserSession;

/**
 * Created by son.nguyen on 4/19/2016.
 */
public class RegistrationIntentService extends IntentService {

    // abbreviated tag name
    private static final String TAG = "RegIntentService";

    public RegistrationIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Make a call to Instance API
        InstanceID instanceID = InstanceID.getInstance(this);
        String senderId = getResources().getString(R.string.gcm_key);
        try {
            // request token that will be used by the server to send push notifications
            String token = instanceID.getToken(senderId, GoogleCloudMessaging.INSTANCE_ID_SCOPE);
            Log.d(TAG, "GCM Registration Token: " + token);
            // pass along this data
            saveToken(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToken(String token) {
        // Add custom implementation, as needed.
        UserSession.getInstance().setDeviceUiid(token);
    }
}