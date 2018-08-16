package com.example.kk.blanceaccount;

import android.Manifest;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import base.BaseActivity;
import fragmen.IndexFragment;
import fragmen.MineFragment;
import widget.FragmentTabHost;

import static config.Constant.INDEX;
import static config.Constant.Mine;

public class MainActivity extends BaseActivity  {

    private static final int REQUEST_CODE_PERMISSION_CAMERA_SD = 100;

    private FragmentTabHost mTabHost;
    Bundle savedInstanceState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState=savedInstanceState;
        onCreateView(R.layout.activity_main);

    }

    @Override
    protected void findWidgets() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        AndPermission.with(MainActivity.this)
                .requestCode(REQUEST_CODE_PERMISSION_CAMERA_SD)
                .permission(Manifest.permission.READ_PHONE_STATE)
                // rationale作用是：用户拒绝一次权限，再次申请时先征求用户同意，再打开授权对话框，避免用户勾选不再提示。
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        AndPermission.rationaleDialog(MainActivity.this, rationale).show();
                    }
                })
                .send();

    }

    @Override
    protected void initComponent() {
        initTabHost();

    }
    private void initTabHost() {

        if(savedInstanceState==null){
            mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
            mTabHost.addTab(mTabHost.newTabSpec(INDEX).setIndicator(createIndicatorView(R.drawable.index_selector, R.string.stringIndex)), IndexFragment.class, new Bundle());
            mTabHost.addTab(mTabHost.newTabSpec(Mine).setIndicator(createIndicatorView(R.drawable.main_selector, R.string.stringMine)), MineFragment.class, new Bundle());
            mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);

        }


    }
    private View createIndicatorView(int selectorRes, int finddesigner) {

        View view = getLayoutInflater().inflate(R.layout.item_maintab_navigation, null);
        ImageView iv = (ImageView) view.findViewById(R.id.ivTab);
        iv.setImageResource(selectorRes);
        TextView tvTabText = (TextView) view.findViewById(R.id.tvTabText);
        tvTabText.setText(finddesigner);
        return view;
    }



}
