package com.example.admin.mvp_login;

import android.os.Bundle;

public interface BasePresenter {
    void onCreate(Bundle savedInstanceState);

    void onResume();

    void onStart();

    void onPause();

    void onStop();

    void onDestroy();
}
