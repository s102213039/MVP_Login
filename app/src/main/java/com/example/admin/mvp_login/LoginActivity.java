package com.example.admin.mvp_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.View{
    private LoginContract.Presenter mPresenter;
    private UserModel mUser;

    @BindView(R.id.account_edit)
    EditText accountEdit;
    @BindView(R.id.password_edit)
    EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mPresenter = new LoginPresenter(getApplicationContext(),this);
    }
    @OnClick({R.id.login_button})
    void onClick(View view){
        switch (view.getId()){
            case R.id.login_button:
                mUser = new UserModel(accountEdit.getText().toString(),passwordEdit.getText().toString());
                mPresenter.onLoginClick(mUser);
                break;
        }
    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
