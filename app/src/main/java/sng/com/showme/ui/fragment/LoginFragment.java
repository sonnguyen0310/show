package sng.com.showme.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sng.com.showme.BaseApplication;
import sng.com.showme.R;
import sng.com.showme.loader.LoginLoader;
import sng.com.showme.model.Data;
import sng.com.showme.model.UserSession;
import sng.com.showme.util.Constant;
import sng.com.showme.util.Utils;

public class LoginFragment extends BaseFragment {
    private int LOADER_LOGIN = 0;
    @Bind(R.id.btn_submit)
    View mBtnSubmit;
    @Bind(R.id.edt_email)
    EditText mEdtEmail;
    @Bind(R.id.edt_pass)
    EditText mEditTextPass;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_submit)
    void onSubmit() {
        if (TextUtils.isEmpty(mEdtEmail.getText().toString()) || TextUtils.isEmpty(mEditTextPass.getText().toString())) {
            showToast(getString(R.string.register_missing_field));
        }
        if (!Utils.isValidEmail(mEdtEmail.getText().toString())) {
            mEdtEmail.requestFocus();
            showToast(getString(R.string.register_invalid_email));
            return;
        }
        getLoaderManager().restartLoader(LOADER_LOGIN, null, mLoginLoaderCallBack);
    }

    private LoaderManager.LoaderCallbacks<Data<UserSession>> mLoginLoaderCallBack = new LoaderManager.LoaderCallbacks<Data<UserSession>>() {
        @Override
        public Loader<Data<UserSession>> onCreateLoader(int id, Bundle args) {
            return new LoginLoader(getContext(), mEdtEmail.getText().toString(), mEditTextPass.getText().toString(), BaseApplication.getGcmKey());
        }

        @Override
        public void onLoadFinished(Loader<Data<UserSession>> loader, Data<UserSession> data) {
            if (data != null && data.getReturnCode() == Constant.API_RETURN_CODE_SUCCESS) {
                UserSession.setUserSession(data.getData());
                showToast("Login success");
            } else {
                if (data != null) {
                    showConfirmDialog(data.getMessage(), getString(R.string.common_ok), true, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getLoaderManager().restartLoader(LOADER_LOGIN, null, mLoginLoaderCallBack);
                        }
                    });
                } else {
                    showConfirmDialog(getString(R.string.common_error), getString(R.string.common_ok), false, null);
                }

            }

        }

        @Override
        public void onLoaderReset(Loader<Data<UserSession>> loader) {

        }
    };
}
