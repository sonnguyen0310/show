package sng.com.showme.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import sng.com.showme.BaseApplication;
import sng.com.showme.R;
import sng.com.showme.ui.dialog.AlertDialogFragment;
import sng.com.showme.ui.dialog.ProgressDialogFragment;

/**
 * Created by nguye on 3/17/2016.
 */
public class BaseFragment extends Fragment {
    protected static final int INDEX_CONTENT = 0;
    protected static final int INDEX_PROGRESS = 1;

    protected Handler mHandler = new Handler();

    protected ProgressDialogFragment mProgressDialogFragment;

    protected BaseApplication mApp;

    protected ViewSwitcher mViewSwitcher;
    private AlertDialog.Builder mBuilder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialogFragment = ProgressDialogFragment.newInstance(null, 1);
        mApp = (BaseApplication) getActivity().getApplication();
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
                    if (!mProgressDialogFragment.isAdded()) {
                        mProgressDialogFragment.show(getFragmentManager(), ProgressDialogFragment.class.getSimpleName());
                    }
                } else {
                    if (mProgressDialogFragment.getActivity() != null) {
                        mProgressDialogFragment.dismissAllowingStateLoss();
                    }
                }
            }
        });
    }

    public void showAlertDialog(final String message) {
        showAlertDialog(getString(R.string.common_error), message);
    }

    public void showAlertDialog(final String title, final String message) {
        showAlertDialog(title, message, R.drawable.fab_bg_mini);
    }

    public void showAlertDialog(final String title, final String message, final int alertId) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                AlertDialogFragment dialogFragment = AlertDialogFragment.newInstance(title,
                        message, getString(R.string.common_ok), alertId);
                dialogFragment.show(getFragmentManager(), dialogFragment.getClass().getSimpleName());
            }
        });
    }

    /*
    * show dialog with message and yes, no button, pass listener to do something when click on OK button*/
    public void showConfirmDialog(String mess, String button, boolean cancelable, DialogInterface.OnClickListener listener) {
        if (mBuilder == null) {
            mBuilder = new AlertDialog.Builder(getContext());
            mBuilder.setMessage(mess)
                    .setCancelable(cancelable)
                    .setPositiveButton(button, listener);
        }
        mBuilder.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
        mHandler = null;
    }

//    protected TabLayout.Tab createTabItem(TabLayout tabLayout, String title, boolean isActive, int color) {
//        TabLayout.Tab tab = tabLayout.newTab();
//        tab.setCustomView(R.layout.view_tab_item);
//        TextView textTitle = ((TextView) tab.getCustomView().findViewById(R.id.text_title));
//        textTitle.setText(title);
//        if(isActive) {
////            textTitle.setTypeface(TypefaceUtils.load(MPAApplication.getContext().getAssets(), "fonts/Montserrat-Bold.ttf"), Typeface.BOLD);
//        }
//
//        textTitle.setTextColor(ContextCompat.getColor(BaseApplication.getContext(), color));
//
//        return tab;
//    }

    /**
     * show progress inside view with view switcher
     *
     * @param isShow true : show, false : hide
     */
    public void showProgressbar(final boolean isShow) {
        if (mViewSwitcher != null) {
            mViewSwitcher.setDisplayedChild(isShow ? INDEX_PROGRESS : INDEX_CONTENT);
        }
    }

    public void showToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void replaceFragmmentWithStack(Fragment fragment, String tag) {
        Log.d("sonnguyen", "replaceFragmmentWithStack: " + tag);
        getFragmentManager().beginTransaction().addToBackStack(tag).replace(R.id.fragment_container, fragment, tag).commit();
        getFragmentManager().executePendingTransactions();
    }
}
