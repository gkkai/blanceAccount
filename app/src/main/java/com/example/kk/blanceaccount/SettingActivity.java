package com.example.kk.blanceaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import base.BaseActivity;
import butterknife.Bind;

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.rl_setpwd)
    RelativeLayout rl_setpwd;
    @Bind(R.id.text_next)
    TextView text_next;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(R.layout.activity_setting);
    }

    @Override
    protected void findWidgets() {
        rl_setpwd.setOnClickListener(this);
        text_next.setOnClickListener(this);
    }

    @Override
    protected void initComponent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_setpwd:
                Intent setintent=new Intent(this,SetPwdActivity.class);
                startActivity(setintent);

                break;
            case R.id.text_next:

                Intent exitintent=new Intent(this,LoginActivity.class);
                startActivity(exitintent);
                Destroy();
                break;
        }

    }
}
