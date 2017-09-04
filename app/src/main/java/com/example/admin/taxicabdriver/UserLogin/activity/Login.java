package com.example.admin.taxicabdriver.UserLogin.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.taxicabdriver.Activity.HomeScreen;
import com.example.admin.taxicabdriver.App.PrefManager;
import com.example.admin.taxicabdriver.R;
import com.example.admin.taxicabdriver.UserLogin.apihelper.WebUserLoginHelper;
import com.example.admin.taxicabdriver.UserLogin.database.Driver_Table;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Login extends AppCompatActivity {
   Button loginbtn;
    EditText edtMobile,edtPasswd;
    SweetAlertDialog loginDialog;

    @Override
    public void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/


    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();// ATTENTION: This was auto-generated to implement the App Indexing API.

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtMobile=(EditText)findViewById(R.id.mobile);
        edtPasswd=(EditText)findViewById(R.id.password);
        loginbtn = (Button) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new PrefManager(Login.this).setMobileNumber(edtMobile.getText().toString());

                loginDialog = new SweetAlertDialog(Login.this, SweetAlertDialog.PROGRESS_TYPE)
                        .setTitleText("Loading").setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        });

                loginDialog.show();
                loginDialog.setCancelable(false);

                WebUserLoginHelper.driverLogin(Login.this,edtPasswd.getText().toString());

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Driver_Table driver_table)
    {
        switch (driver_table.getUSER_LOGIN_STATUS()) {
            case Driver_Table.USER_LOGIN_FAILED:
                loginDialog.setTitleText("Failed!")
                        .setConfirmText("OK")
                        .changeAlertType(SweetAlertDialog.ERROR_TYPE);


                break;
            case Driver_Table.USER_LOGIN_SUCCESS:
                loginDialog.setTitleText("Success!")
                        .setConfirmText("OK")
                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);

                Intent intent=new Intent(Login.this,HomeScreen.class);
                startActivity(intent);
                this.finish();

                break;

        }
    }

}
