package com.example.admin.mvp_login.LoginTest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.admin.mvp_login.RecyclerViewTest.MainActivity;
import com.example.admin.mvp_login.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private LoginContract.Presenter mPresenter;

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
                mPresenter.onLoginReq(accountEdit.getText().toString(),passwordEdit.getText().toString());
                break;
        }
    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
