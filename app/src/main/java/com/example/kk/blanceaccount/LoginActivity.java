package com.example.kk.blanceaccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import base.BaseActivity;
import base.MyApplication;
import butterknife.Bind;
import model.bean.LoginBean;
import tools.ProxyUtils;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.et_pwd)
    EditText et_pwd;
    @Bind(R.id.et_phone)
    EditText et_phone;
    @Bind(R.id.tv_login)
    TextView tv_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(R.layout.activity_login);

    }

        @Override
        protected void findWidgets() {

        }

        @Override
        protected void initComponent() {
            tv_login.setOnClickListener(this);

        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login:
                if(TextUtils.isEmpty(et_phone.getText())){
                    Toast.makeText(this,"请输入手机号码",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(et_pwd.getText())){
                    Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                String name=et_phone.getText().toString().trim();
                String pwd=et_pwd.getText().toString().trim();

                //TODO 请求登录
                ProxyUtils.GetHttpCheckProxy().login(this,name,pwd);
                break;
        }
    }
    protected void login(LoginBean bean) {
        MyApplication.loginBean=bean;
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    protected void showErrorMessage(String errorMessage) {
        super.showErrorMessage("用户名或者着密码错误");
    }

    @Override
    protected void showErrorMessage(Integer errorCode, String errorMessage) {
        super.showErrorMessage(errorCode, "用户名或者着密码错误");
    }
}

