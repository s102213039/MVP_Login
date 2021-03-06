package com.example.admin.mvp_login.LoginTest;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;
    private Context mContext;

    public LoginPresenter(Context context, LoginContract.View mView) {
        this.mView = mView;
        this.mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        mView = null;
    }



    @Override
    public void onLoginReq(String account, String password) {
        if(account.equals("ann") && password.equals("123")) {
            mView.onLoginSuccess();
            Toast.makeText(mContext,"登入成功",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(mContext,"帳號或密碼錯誤",Toast.LENGTH_SHORT).show();
        }
    }


}
