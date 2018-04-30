package com.example.admin.mvp_login.LoginTest;

public interface LoginContract {
    interface View {
        void onLoginSuccess();
    }
    interface Presenter extends BasePresenter {
        void onLoginReq(String account, String password);
    }
}
