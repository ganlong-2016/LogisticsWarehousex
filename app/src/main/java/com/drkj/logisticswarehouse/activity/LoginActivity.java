package com.drkj.logisticswarehouse.activity;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.drkj.logisticswarehouse.BaseActivity;
import com.drkj.logisticswarehouse.BaseApplication;
import com.drkj.logisticswarehouse.R;
import com.drkj.logisticswarehouse.bean.ResultLoginBean;
import com.drkj.logisticswarehouse.bean.ResultVaildBean;
import com.drkj.logisticswarehouse.net.NetClient;
import com.drkj.logisticswarehouse.util.KeybordUtils;
import com.drkj.logisticswarehouse.util.SupportMultipleScreensUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {

    private EditText phoneNumberText;

    private EditText passwordText;

    private Button loginButton;

    private ImageView clearImage;

    private ProgressBar progressBar;

    private Button getPasswordButton;

    private TextView verisonInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        View rootView = findViewById(android.R.id.content);
        SupportMultipleScreensUtil.init(getApplication());
        SupportMultipleScreensUtil.scale(rootView);
        initviews();
    }

    private void initviews() {
        phoneNumberText = (EditText) findViewById(R.id.text_phone_number);
        passwordText = (EditText) findViewById(R.id.text_password);
        loginButton = (Button) findViewById(R.id.button_login);
        clearImage = (ImageView) findViewById(R.id.image_clear);
        progressBar = findViewById(R.id.progressbar);
        verisonInfoText = findViewById(R.id.text_version_info);
        getPasswordButton = findViewById(R.id.button_get_password);
        getPasswordButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                NetClient.getInstance().getApi().sendVaildCode(phoneNumberText.getText().toString())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<ResultVaildBean>() {
                            @Override
                            public void accept(ResultVaildBean resultVaildBean) throws Exception {
//                                Log.i(TAG, "accept: ");
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                            }
                        });
                CountDownTimerUtils timer = new CountDownTimerUtils(getPasswordButton, 60000, 1000);
                timer.start();
            }
        });
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });
        clearImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumberText.setText("");
            }
        });
        phoneNumberText.setText(getPhoneNumber());
        verisonInfoText.setText("司机版本" + getVersionInfo());
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        KeybordUtils.closeKeybord(phoneNumberText, this);
        KeybordUtils.closeKeybord(passwordText, this);

        // Reset errors.
        phoneNumberText.setError(null);
        passwordText.setError(null);

        // Store values at the time of the login attempt.
        String email = phoneNumberText.getText().toString();
        String password = passwordText.getText().toString();

        boolean cancel = false;
        View focusView = null;

//        // Check for a valid password, if the user entered one.
//        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
//            mPasswordView.setError(getString(R.string.error_invalid_password));
//            focusView = mPasswordView;
//            cancel = true;
//        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            phoneNumberText.setError(getString(R.string.error_field_required));
            focusView = phoneNumberText;
            cancel = true;
        } else if (!isEmailValid(email)) {
            phoneNumberText.setError(getString(R.string.error_invalid_email));
            focusView = phoneNumberText;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
//            showProgress(true);
            progressBar.setVisibility(View.VISIBLE);
//            BaseApplication.getInstance().setLoginBean(bean);
            putPhoneNumber(email);
            startActivity(MainActivity.class);
            finish();
//            NetClient.getInstance().getApi().login(email, password)
//                    .subscribeOn(Schedulers.newThread())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new Consumer<ResultLoginBean>() {
//                        @Override
//                        public void accept(ResultLoginBean bean) throws Exception {
//                            progressBar.setVisibility(View.GONE);
//                            if (bean.getCode() == 200) {
//                                if (bean.getData().getUserType() == 6) {
//                                    BaseApplication.getInstance().setLoginBean(bean);
//                                    putPhoneNumber(email);
//                                    startActivity(MainActivity.class);
//                                    finish();
//                                } else {
//                                    Toast.makeText(LoginActivity.this, "该帐号不是司机帐号！", Toast.LENGTH_SHORT).show();
//                                }
//                            } else {
//                                Toast.makeText(LoginActivity.this, "手机验证失败！", Toast.LENGTH_SHORT).show();
//
//                            }
//                        }
//                    }, new Consumer<Throwable>() {
//                        @Override
//                        public void accept(Throwable throwable) throws Exception {
//                            progressBar.setVisibility(View.GONE);
//                             Toast.makeText(LoginActivity.this, "与服务器连接产生异常", Toast.LENGTH_SHORT).show();
//                            throwable.printStackTrace();
//                        }
//                    });

        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return true;
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    private String getPhoneNumber() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String phoneNumber = preferences.getString("phoneNumber", "");
        return phoneNumber;
    }

    private void putPhoneNumber(String phoneNumber) {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("phoneNumber", phoneNumber);
        editor.commit();
    }

    private String getVersionInfo() {
        String versionName = "";
        try {
            // ---get the package info---
            PackageManager pm = getPackageManager();
            PackageInfo pi = pm.getPackageInfo(getPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }

    class CountDownTimerUtils extends CountDownTimer {
        private Button button;

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public CountDownTimerUtils(Button button, long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            this.button = button;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            button.setEnabled(false);
            button.setText(millisUntilFinished / 1000 + "s");
        }

        @Override
        public void onFinish() {
            button.setText("重新获取验证码");
            button.setEnabled(true);
        }
    }
}

