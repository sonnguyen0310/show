package sng.com.showme.ui.fragment;


import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sng.com.showme.R;
import sng.com.showme.loader.RegisterLoader;
import sng.com.showme.model.Data;
import sng.com.showme.model.UserSession;
import sng.com.showme.util.Constant;
import sng.com.showme.util.Utils;


public class RegisterFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int LOADER_REGISTER = 1;
    private UserSession mUserSession;
    private DatePickerDialog mDatePickerDialog;
    private String mDob;
    @Bind(R.id.edt_email)
    EditText mEmail;
    @Bind(R.id.edt_birthdate)
    EditText mBirthDate;
    @Bind(R.id.edt_firstname)
    EditText mFirstName;
    @Bind(R.id.edt_name)
    EditText mLastName;
    @Bind(R.id.edt_pass)
    EditText mPassword;
    @Bind(R.id.btn_submit)
    View mBtnSubmit;

    public RegisterFragment() {
    }

    @OnClick(R.id.btn_submit)
    void onSubmit() {
        if (TextUtils.isEmpty(mEmail.getText()) ||
                TextUtils.isEmpty(mBirthDate.getText()) ||
                TextUtils.isEmpty(mFirstName.getText()) ||
                TextUtils.isEmpty(mLastName.getText()) ||
                TextUtils.isEmpty(mPassword.getText())
                ) {
            showToast(getString(R.string.register_missing_field));
            return;
        }
        if (!Utils.isValidEmail(mEmail.getText().toString())) {
            mEmail.requestFocus();
            showToast(getString(R.string.register_invalid_email));
            return;
        }
        if (mPassword.getText().toString().replace(" ", "").length() < 8) {
            mPassword.requestFocus();
            showToast(getString(R.string.register_invalid_password));
            return;
        }
        if (mFirstName.getText().toString().replace(" ", "").length() < 2) {
            mFirstName.requestFocus();
            showToast(getString(R.string.register_invalid_first_name));
            return;
        }
        if (mLastName.getText().toString().replace(" ", "").length() < 2) {
            mLastName.requestFocus();
            showToast(getString(R.string.register_invalid_last_name));
            return;
        }
        getLoaderManager().restartLoader(LOADER_REGISTER, null, mRegisterCallBack);
    }

    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setDateTimeField();
        mBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatePickerDialog.show();
            }
        });
    }


    LoaderManager.LoaderCallbacks<Data<UserSession>> mRegisterCallBack = new LoaderManager.LoaderCallbacks<Data<UserSession>>() {
        @Override
        public Loader<Data<UserSession>> onCreateLoader(int id, Bundle args) {
            return new RegisterLoader(getContext(), mEmail.getText().toString(),
                    mPassword.getText().toString(),
                    mDob,
                    mFirstName.getText().toString(),
                    mLastName.getText().toString(),
                    "");
        }

        @Override
        public void onLoadFinished(Loader<Data<UserSession>> loader, Data<UserSession> data) {
            if (data != null && data.getReturnCode() == Constant.API_RETURN_CODE_SUCCESS) {
                UserSession.setUserSession(data.getData());
                showToast("Register success");
            } else {
                if (data != null) {
                    showConfirmDialog(data.getMessage(), getString(R.string.common_error), true, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getLoaderManager().restartLoader(LOADER_REGISTER, null, mRegisterCallBack);
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

    private void setDateTimeField() {
        Calendar newCalendar = Calendar.getInstance();
        mDatePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar date = Calendar.getInstance();
                date.set(year, monthOfYear, dayOfMonth);
                mDob = year + "-" + monthOfYear + "-" + dayOfMonth;
                mBirthDate.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }
}
