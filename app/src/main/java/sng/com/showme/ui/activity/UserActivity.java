package sng.com.showme.ui.activity;

import android.os.Bundle;

import sng.com.showme.R;
import sng.com.showme.ui.fragment.SplashFragment;

/**
 * Created by son.nguyen on 4/19/2016.
 */
public class UserActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,SplashFragment.newInstance(), SplashFragment.class.getName()).addToBackStack(SplashFragment.class.getName()).commit();
    }

}
