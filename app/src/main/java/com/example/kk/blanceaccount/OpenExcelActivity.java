package com.example.kk.blanceaccount;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Field;

import base.BaseActivity;
import butterknife.Bind;
import ui.X5WebView;

public class OpenExcelActivity extends BaseActivity {
    @Bind(R.id.webview)
    X5WebView webview;
    String path;
    private String URL = "file://";
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(R.layout.activity_open_excel);
    }

    @Override
    protected void findWidgets() {
        path=getIntent().getStringExtra("path");
        path=URL+path;

        webview.loadUrl(path);//此处加载的是本地html"xxx"是文件名
    }

    @Override
    protected void initComponent() {
        // 提示好评
         dialog = new AlertDialog.Builder(this)
                .setTitle("版本更新")
                .setMessage("请确认安装应用宝进行更新")
                .setPositiveButton("更新", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog1, int which) {
                        openApplicationMarket("com.bitmain.btccom");
                        try {
                            Field field = dialog.getClass()
                                    .getSuperclass()
                                    .getDeclaredField("mShowing");
                            field.setAccessible(true);
                            field.set(dialog, false); // 此处设为true则可以关闭
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }

                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog1, int which) {
                        Toast.makeText(getApplicationContext(), "关闭", Toast.LENGTH_SHORT).show();


                    }
                })
                .setNeutralButton("下载应用宝", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog1, int which) {
                        if(!checkApkExist(OpenExcelActivity.this,"com.tencent.android.qqdownloader")){
                            String str = "market://details?id=com.tencent.android.qqdownloader";
                            Intent localIntent = new Intent(Intent.ACTION_VIEW);
                            localIntent.setData(Uri.parse(str));
                            startActivity(localIntent);
                        }else {
                            // TODO 已经安装应用宝
                            Toast.makeText(getApplicationContext(), "您已经安装应用宝", Toast.LENGTH_SHORT).show();

                            openApplicationMarket("com.bitmain.btccom");

                        }

                    }
                })
                .create();

        dialog.show();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 通过包名 在应用商店打开应用
     *
     * @param packageName 包名
     */
    private void openApplicationMarket(String packageName) {
        try {
            String str = "market://details?id=" + packageName;
            Intent localIntent = new Intent(Intent.ACTION_VIEW);
            localIntent.setData(Uri.parse(str));
            startActivity(localIntent);
           /* String url = "http://app.mi.com/detail/163525?ref=search";
            openLinkBySystem(url);*/
        } catch (Exception e) {
            // 打开应用商店失败 可能是没有手机没有安装应用市场
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "打开应用商店失败", Toast.LENGTH_SHORT).show();
            // 调用系统浏览器进入商城
            String url = "http://app.mi.com/detail/163525?ref=search";
            openLinkBySystem(url);
        }
    }
    /**
     * 调用系统浏览器打开网页
     *
     * @param url 地址
     */
    private void openLinkBySystem(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

        private static String facebookPkgName = "com.facebook.katana";

        public static boolean checkApkExist(Context context, String packageName){
            if (TextUtils.isEmpty(packageName))
                return false;
            try {
                ApplicationInfo info = context.getPackageManager()
                        .getApplicationInfo(packageName,
                                PackageManager.GET_UNINSTALLED_PACKAGES);
//                Timber.d(info.toString()); // Timber 是我打印 log 用的工具，这里只是打印一下 log
                return true;
            } catch (PackageManager.NameNotFoundException e) {
//                Timber.d(e.toString()); // Timber 是我打印 log 用的工具，这里只是打印一下 log
                return false;
            }
        }

        public static boolean checkFacebookExist(Context context){
            return checkApkExist(context, facebookPkgName);
        }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webview != null) webview.destroy();
    }
    /**
     * 使点击回退按钮不会直接退出整个应用程序而是返回上一个页面
     *
     * */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK&&webview.canGoBack()){
            webview.goBack();//返回上个页面
            return true;
        }else {

            finish();
            return false; }}
}

