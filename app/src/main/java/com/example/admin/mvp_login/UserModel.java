package com.example.admin.mvp_login;

public class UserModel {
    private String account;
    private String password;

    public UserModel() {
    }

    public UserModel(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
