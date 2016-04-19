package sng.com.showme.ui.dialog;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;

import sng.com.showme.BaseApplication;


/**
 * Created by vinh.tran@tapptic.com on 10/15/15.
 */
public class BaseDialogFragment extends DialogFragment {

    protected Handler mHandler = new Handler();

    protected ProgressDialogFragment mProgressDialogFragment;

    protected BaseApplication mApp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialogFragment = ProgressDialogFragment.newInstance(null, 1);
        mApp = (BaseApplication)getActivity().getApplication();
    }

    /**
     * show or hide progress dialog
     *
     * @param isShow true : show, false : hide progress
     */
    public void showProgressDialog(final boolean isShow) {

        if (mProgressDialogFragment == null) {
            return;
        }

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (isShow) {
                    mProgressDialogFragment.show(getFragmentManager(), ProgressDialogFragment.class.getSimpleName());
                } else {
                    if (mProgressDialogFragment.getActivity() != null) {
                        mProgressDialogFragment.dismissAllowingStateLoss();
                    }
                }
            }
        });
    }

//    public void showAlertDialog(final String message){
//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                AlertDialogFragment dialogFragment = AlertDialogFragment.newInstance("", message, getString(R.string.common_ok));
//                dialogFragment.show(getFragmentManager(), dialogFragment.getClass().getSimpleName());
//            }
//        });
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
        mHandler = null;
    }
}
