package com.example.kk.blanceaccount;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import base.BaseActivity;
import base.MyApplication;
import butterknife.Bind;
import model.bean.AddZqBean;
import model.bean.LoginBean;
import tools.ProxyUtils;

public class SetPwdActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.et_new_pwd)
    EditText et_new_pwd;
    @Bind(R.id.et_pwd)
    EditText et_pwd;
    @Bind(R.id.tv_login)
    TextView tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(R.layout.activity_set_pwd);
    }

    @Override
    protected void findWidgets() {
        tv_login.setOnClickListener(this);





    }

    @Override
    protected void initComponent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login:
                if(TextUtils.isEmpty(et_new_pwd.getText())){
                    Toast.makeText(this,"请输入手机号码",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(et_pwd.getText())){
                    Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                String new_pwd=et_new_pwd.getText().toString().trim();
                String pwd=et_pwd.getText().toString().trim();
                if(new_pwd.equals(pwd)){
//                    Pattern pattern = Pattern.compile("^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[_\\-@&=])[a-z0-9_\\-@&=]{6,}+$");
//
//                    Matcher m = pattern.matcher(et_pwd.getText());
                    if(pwd.length()>=6){
                        //TODO 修改密码
                        ProxyUtils.GetHttpCheckProxy().updatePassword(this, String.valueOf(MyApplication.loginBean.getData().getId()),
                               MyApplication.loginBean.getData().getPassword() ,pwd.trim());
                    }else {
                        Toast.makeText(this,"密码长度不够",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(this,"输入密码不一致",Toast.LENGTH_SHORT).show();
                    return;
                }


                break;
        }

    }
    protected void  updatePassword(AddZqBean bean){
        Toast.makeText(this,"修改完成",Toast.LENGTH_SHORT).show();
        //TODO 请求登录
        ProxyUtils.GetHttpCheckProxy().login(this, MyApplication.loginBean.getData().getName(),et_pwd.getText().toString().trim());
    }
    protected void login(LoginBean bean) {
        MyApplication.loginBean=bean;
        finish();

    }
}
