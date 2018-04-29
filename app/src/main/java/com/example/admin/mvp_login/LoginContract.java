package com.example.admin.mvp_login;

public interface LoginContract {
    interface View {
        void onLoginSuccess();
    }
    interface Presenter extends BasePresenter{
        void onLoginClick(UserModel user);
    }
}
