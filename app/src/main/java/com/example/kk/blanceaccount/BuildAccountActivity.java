package com.example.kk.blanceaccount;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import base.BaseActivity;
import base.MyApplication;
import butterknife.Bind;
import model.bean.AddZqBean;
import model.bean.FindFinanceBean;
import tools.ProxyUtils;
import tools.ToastUtils;
import widget.LastInputEditText;

public class BuildAccountActivity extends BaseActivity implements View.OnClickListener, TextWatcher, View.OnFocusChangeListener {
    @Bind(R.id.text_yuefen_xunaze)
    TextView text_yuefen_xunaze;
    private Dialog dialog;
    private View inflate;
    private com.wx.wheelview.widget.WheelView yearView;
    private com.wx.wheelview.widget.WheelView mouthView;
   List<String> years=new ArrayList<String>();
    List<String> mouths=new ArrayList<String>();
    @Bind(R.id.edit_qc_zy_wu)
    EditText edit_qc_zy_wu;
    @Bind(R.id.edit_qc_zy_zb)
    EditText edit_qc_zy_zb;
    @Bind(R.id.edit_qc_gk_gck)
    EditText edit_qc_gk_gck;
    @Bind(R.id.text_qu_sum)
    TextView text_qu_sum;
    @Bind(R.id.text_byjy_sum)
    TextView text_byjy_sum;
    @Bind(R.id.edit_byjy_zy_wu)
    EditText edit_byjy_zy_wu;
    @Bind(R.id.edit_byjy_zy_zb)
    EditText edit_byjy_zy_zb;
    @Bind(R.id.edit_bujy_gk_gck)
    EditText edit_bujy_gk_gck;
    @Bind(R.id.text_zf_sum)
    TextView text_zf_sum;
    @Bind(R.id.edit_byjy_zf_wu)
    EditText edit_byjy_zf_wu;
    @Bind(R.id.edit_byjy_zf_zb)
    EditText edit_byjy_zf_zb;
    @Bind(R.id.edit_bujy_zf_gck)
    EditText edit_bujy_zf_gck;
    @Bind(R.id.text_wd_sum)
    TextView text_wd_sum;
    @Bind(R.id.edit_wd_zy)
    EditText edit_wd_zy;
    @Bind(R.id.edit_zglj_zy)
    EditText edit_zglj_zy;
    @Bind(R.id.edit_gk_wd)
    EditText edit_gk_wd;
    @Bind(R.id.edit_gk_zgje)
    EditText edit_gk_zgje;

    @Bind(R.id.text_zq)
    TextView text_zq;
    @Bind(R.id.text_zw)
    TextView text_zw;
    @Bind(R.id.text_danwei_xunaze)
    TextView text_danwei_xunaze;
    @Bind(R.id.text_sumit)
    TextView text_sumit;


    int  companyid;
    private int type=0;
    private static final String[] PLANETS = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Uranus", "Neptune", "Pluto"};
    private Drawable drawable,drawable1;
    private String CompanyName;
    private int id;
    private String zq_dz_key,zq_year,zq_month,zq_company_name,zq_dz_company_name, zq_wd_sm;
    private double zq_qc_zy_wu,zq_qc_zy_zb,   zq_qc_gk_gck,zq_byjy_zy_wu, zq_byjy_zy_zb, zq_byjy_gk_gck, zq_byzf_zy_wu, zq_byzf_zy_zb, zq_byzf_gk_gck, zq_wd_zy
    ,zq_wd_zy_zgje, zq_wd_gk,zq_wd_gk_zgje ;
    private String zw_dz_key,zw_year,zw_month,zw_company_name,zw_dz_company_name, zw_wd_sm;
    private double  zw_qc_zy_wu,zw_qc_zy_zb,  zw_qc_gk_gck,zw_byjy_zy_wu, zw_byjy_zy_zb, zw_byjy_gk_gck, zw_byzf_zy_wu, zw_byzf_zy_zb, zw_byzf_gk_gck, zw_wd_zy
            ,zw_wd_zy_zgje, zw_wd_gk,zw_wd_gk_zgje;
    private  int zw_dz_company,zw_is_ok,zw_company,zq_dz_company,zq_company,zq_is_ok;


    @Bind(R.id.edit_wd_miaoshu)
    EditText edit_wd_miaoshu;
    private String year,mouth;
    private String iszq;
    List<String> qclist=new ArrayList<>();
    List<String> byjylist=new ArrayList<>();
    List<String> byzflist=new ArrayList<>();
    List<String> wdflist=new ArrayList<>();
    DecimalFormat df = new DecimalFormat("###,##0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(R.layout.activity_build_account);
    }

    @Override
    protected void findWidgets() {

        text_yuefen_xunaze.setOnClickListener(this);
        //TODO
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
        String date=sdf.format(new java.util.Date());
        int year=Integer.valueOf(date);
        for(int i=0;i<4;i++){
            years.add(i,String.valueOf(year-i));
        }
        //Collections.reverse(years);
        mouths.add(0,"1月");
        mouths.add(1,"2月");
        mouths.add(2,"3月");
        mouths.add(3,"4月");
        mouths.add(4,"5月");
        mouths.add(5,"6月");
        mouths.add(6,"7月");
        mouths.add(7,"8月");
        mouths.add(8,"9月");
        mouths.add(9,"10月");
        mouths.add(10,"11月");
        mouths.add(11,"12月");
        drawable= getResources().getDrawable(R.mipmap.xuanze);// 找到资源图片
         drawable1 = getResources().getDrawable(R.mipmap.weixuanze);// 找到资源图片



        drawable.setBounds(0, 0, 50, 50);// 设置图片宽高

        drawable1.setBounds(0, 0, 50, 50);// 设置图片宽高

        text_danwei_xunaze.setOnClickListener(this);

        text_sumit.setOnClickListener(this);
        initedit();
    }

    private void initedit() {
        if("债权".equals(getIntent().getStringExtra("type"))){
            text_zq.setCompoundDrawables(drawable, null, null, null);// 设置到控件中
            text_zw.setCompoundDrawables(drawable1, null, null, null);// 设置到控件中
            type=0;
            iszq="债权";

        }else if("债务".equals(getIntent().getStringExtra("type"))){
            text_zq.setCompoundDrawables(drawable1, null, null, null);// 设置到控件中
            text_zw.setCompoundDrawables(drawable, null, null, null);// 设置到控件中
            type=1;
            iszq="债务";
        }else {
            text_zq.setCompoundDrawables(drawable, null, null, null);// 设置到控件中
            text_zw.setCompoundDrawables(drawable1, null, null, null);// 设置到控件中
            text_zq.setOnClickListener(this);
            text_zw.setOnClickListener(this);

        }
        edit_qc_zy_wu.addTextChangedListener(this);
        edit_qc_zy_zb.addTextChangedListener(this);
        edit_qc_gk_gck.addTextChangedListener(this);
        edit_byjy_zy_wu.addTextChangedListener(this);
        edit_byjy_zy_zb.addTextChangedListener(this);
        edit_bujy_gk_gck.addTextChangedListener(this);
        edit_byjy_zf_wu.addTextChangedListener(this);
        edit_byjy_zf_zb.addTextChangedListener(this);
        edit_bujy_zf_gck.addTextChangedListener(this);
        edit_wd_zy.addTextChangedListener(this);
        edit_zglj_zy.addTextChangedListener(this);
        edit_gk_wd.addTextChangedListener(this);

        edit_gk_zgje.addTextChangedListener(this);
        edit_qc_zy_wu.setOnFocusChangeListener(this);
        edit_qc_zy_zb.setOnFocusChangeListener(this);
        edit_qc_gk_gck.setOnFocusChangeListener(this);
        edit_byjy_zy_wu.setOnFocusChangeListener(this);
        edit_byjy_zy_zb.setOnFocusChangeListener(this);
        edit_bujy_gk_gck.setOnFocusChangeListener(this);
        edit_byjy_zf_wu.setOnFocusChangeListener(this);
        edit_byjy_zf_zb.setOnFocusChangeListener(this);
        edit_bujy_zf_gck.setOnFocusChangeListener(this);
        edit_wd_zy.setOnFocusChangeListener(this);
        edit_zglj_zy.setOnFocusChangeListener(this);
        edit_gk_wd.setOnFocusChangeListener(this);

        edit_gk_zgje.setOnFocusChangeListener(this);



    }

    @Override
    protected void initComponent() {
        if("债权".equals(getIntent().getStringExtra("type"))){
//TODO 查询账务详情
            ProxyUtils.GetHttpCheckProxy().findFinance(this,getIntent().getStringExtra("resultKey"));

        }else if("债务".equals(getIntent().getStringExtra("type"))){
            //TODO 查询账务详情
            ProxyUtils.GetHttpCheckProxy().findFinance(this,getIntent().getStringExtra("resultKey"));

        }else {

        }
    }
    protected void findFinance(FindFinanceBean bean) {

        if("债权".equals(iszq)){
                text_danwei_xunaze.setText(bean.getData().getZq_dz_company_name());
                year=bean.getData().getZq_year();
            zq_company_name=bean.getData().getZq_company_name();
            zq_dz_company_name=bean.getData().getZq_dz_company_name();

            zq_company=bean.getData().getZq_company();
            zq_dz_company=bean.getData().getZq_dz_company();
                mouth=bean.getData().getZq_month();
                text_yuefen_xunaze.setText(year+"-"+mouth);
//                edit_qc_zy_wu.setText(String.valueOf(bean.getData().getZq_qc_zy_wu()));
//                edit_qc_zy_zb.setText(String.valueOf(bean.getData().getZq_qc_zy_zb()));
//                edit_qc_gk_gck.setText(String.valueOf(bean.getData().getZq_qc_gk_gck()));
//                edit_byjy_zy_wu.setText(String.valueOf(bean.getData().getZq_byjy_zy_wu()));
//                edit_byjy_zy_zb.setText(String.valueOf(bean.getData().getZq_byjy_zy_zb()));
//                edit_bujy_gk_gck.setText(String.valueOf(bean.getData().getZq_byjy_gk_gck()));
//                edit_byjy_zf_wu.setText(String.valueOf(bean.getData().getZq_byzf_zy_wu()));
//                edit_byjy_zf_zb.setText(String.valueOf(bean.getData().getZq_byzf_zy_zb()));
//                edit_bujy_zf_gck.setText(String.valueOf(bean.getData().getZq_byzf_gk_gck()));
//                edit_wd_zy.setText(String.valueOf(bean.getData().getZq_wd_zy()));
//                edit_zglj_zy.setText(String.valueOf(bean.getData().getZq_wd_zy_zgje()));
//                edit_gk_wd.setText(String.valueOf(bean.getData().getZq_wd_gk()));
//                edit_gk_zgje.setText(String.valueOf(bean.getData().getZq_wd_gk_zgje()));
            edit_qc_zy_wu.setText(df.format(bean.getData().getZq_qc_zy_wu()));
            edit_qc_zy_zb.setText(df.format(bean.getData().getZq_qc_zy_zb()));
            edit_qc_gk_gck.setText(df.format(bean.getData().getZq_qc_gk_gck()));
            edit_byjy_zy_wu.setText(df.format(bean.getData().getZq_byjy_zy_wu()));
            edit_byjy_zy_zb.setText(df.format(bean.getData().getZq_byjy_zy_zb()));
            edit_bujy_gk_gck.setText(df.format(bean.getData().getZq_byjy_gk_gck()));
            edit_byjy_zf_wu.setText(df.format(bean.getData().getZq_byzf_zy_wu()));
            edit_byjy_zf_zb.setText(df.format(bean.getData().getZq_byzf_zy_zb()));
            edit_bujy_zf_gck.setText(df.format(bean.getData().getZq_byzf_gk_gck()));
            edit_wd_zy.setText(df.format(bean.getData().getZq_wd_zy()));
            edit_zglj_zy.setText(df.format(bean.getData().getZq_wd_zy_zgje()));
            edit_gk_wd.setText(df.format(bean.getData().getZq_wd_gk()));
            edit_gk_zgje.setText(df.format(bean.getData().getZq_wd_gk_zgje()));
                edit_wd_miaoshu.setText(bean.getData().getZq_wd_sm());



        }else if("债务".equals(iszq)){
            text_danwei_xunaze.setText(bean.getData().getZw_dz_company_name());
            zw_company_name=bean.getData().getZw_company_name();
            zw_dz_company_name=bean.getData().getZw_dz_company_name();
            text_danwei_xunaze.setText(bean.getData().getZw_dz_company_name());
            zw_company=bean.getData().getZw_company();
            zw_dz_company=bean.getData().getZw_dz_company();
            year=bean.getData().getZw_year();
            mouth=bean.getData().getZw_month();
            text_yuefen_xunaze.setText(year+"-"+mouth);
            //edit_qc_zy_wu.setText(String.valueOf(bean.getData().getZw_qc_zy_wu()));
//            edit_qc_zy_zb.setText(String.valueOf(bean.getData().getZw_qc_zy_zb()));
//            edit_qc_gk_gck.setText(String.valueOf(bean.getData().getZw_qc_gk_gck()));
//            edit_byjy_zy_wu.setText(String.valueOf(bean.getData().getZw_byjy_zy_wu()));
//            edit_byjy_zy_zb.setText(String.valueOf(bean.getData().getZw_byjy_zy_zb()));
//            edit_bujy_gk_gck.setText(String.valueOf(bean.getData().getZw_byjy_gk_gck()));
//            edit_byjy_zf_wu.setText(String.valueOf(bean.getData().getZw_byzf_zy_wu()));
//            edit_byjy_zf_zb.setText(String.valueOf(bean.getData().getZw_byzf_zy_zb()));
//            edit_bujy_zf_gck.setText(String.valueOf(bean.getData().getZw_byzf_gk_gck()));
//            edit_wd_zy.setText(String.valueOf(bean.getData().getZw_wd_zy()));
//            edit_zglj_zy.setText(String.valueOf(bean.getData().getZw_wd_zy_zgje()));
//            edit_gk_wd.setText(String.valueOf(bean.getData().getZw_wd_gk()));
//            edit_gk_zgje.setText(String.valueOf(bean.getData().getZw_wd_gk_zgje()));
//            edit_wd_miaoshu.setText(bean.getData().getZw_wd_sm());
            edit_qc_zy_wu.setText(df.format(bean.getData().getZw_qc_zy_wu()));
            edit_qc_zy_zb.setText(df.format(bean.getData().getZw_qc_zy_zb()));
            edit_qc_gk_gck.setText(df.format(bean.getData().getZw_qc_gk_gck()));
            edit_byjy_zy_wu.setText(df.format(bean.getData().getZw_byjy_zy_wu()));
            edit_byjy_zy_zb.setText(df.format(bean.getData().getZw_byjy_zy_zb()));
            edit_bujy_gk_gck.setText(df.format(bean.getData().getZw_byjy_gk_gck()));
            edit_byjy_zf_wu.setText(df.format(bean.getData().getZw_byzf_zy_wu()));
            edit_byjy_zf_zb.setText(df.format(bean.getData().getZw_byzf_zy_zb()));
            edit_bujy_zf_gck.setText(df.format(bean.getData().getZw_byzf_gk_gck()));
            edit_wd_zy.setText(df.format(bean.getData().getZw_wd_zy()));
            edit_zglj_zy.setText(df.format(bean.getData().getZw_wd_zy_zgje()));
            edit_gk_wd.setText(df.format(bean.getData().getZw_wd_gk()));
            edit_gk_zgje.setText(df.format(bean.getData().getZw_wd_gk_zgje()));
            edit_wd_miaoshu.setText(bean.getData().getZw_wd_sm());

        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_yuefen_xunaze:
                shownavigation();
                break;
            case R.id.text_zq:
                type=0;
                text_zq.setCompoundDrawables(drawable, null, null, null);// 设置到控件中
                text_zw.setCompoundDrawables(drawable1, null, null, null);// 设置到控件中
                break;
            case R.id.text_zw:
                type=1;
                text_zq.setCompoundDrawables(drawable1, null, null, null);// 设置到控件中
                text_zw.setCompoundDrawables(drawable, null, null, null);// 设置到控件中
                break;
            case R.id.text_danwei_xunaze:
                Intent intent=new Intent(this,CompanyListActivity.class);
                intent.putExtra("tyep","buile");
                startActivityForResult(intent,101);
                break;
            case R.id.text_sumit:
                if(iszq!=null){
                if (type == 0) {
                    try {
                        if(id!=0){
                            zq_dz_company = id;
                        }

                        zq_dz_company_name=text_danwei_xunaze.getText().toString().trim();
                        if(zq_company<10&&zq_dz_company<10){
                            zq_dz_key = year + mouth +"0"+ zq_company + "0"+zq_dz_company;
                        }
                        if(zq_company>10&&zq_dz_company<10){
                            zq_dz_key = year + mouth + zq_company + "0"+zq_dz_company;
                        }
                        if(zq_company<10&&zq_dz_company>10){
                            zq_dz_key = year + mouth +"0"+ zq_company + zq_dz_company;
                        }
                        if(zq_company>0&&zq_dz_company>10){
                            zq_dz_key = year + mouth + zq_company + zq_dz_company;
                        }

                        checkEmpty(zq_dz_company_name, "请选择对帐单位");
                        checkEmpty(year, "请选择对帐时间");
                        checkEmpty(mouth, "请选择对帐时间");
                        checkEmpty(edit_qc_zy_wu.getText().toString(), "请输入期初余额，物质以及工程劳务金额");
                        checkEmpty(edit_qc_zy_zb.getText().toString(), "请输入期初余额，质保金金额");
                        checkEmpty(edit_qc_gk_gck.getText().toString(), "请输入期初余额，挂靠工程款金额");

                       // Double s=(Double)numberFormat.parse(edit_qc_zy_wu.getText().toString());
                        zq_qc_zy_wu = Double.valueOf(edit_qc_zy_wu.getText().toString().replaceAll(",",""));
                        zq_qc_zy_zb = Double.valueOf(edit_qc_zy_zb.getText().toString().replaceAll(",",""));
                        zq_qc_gk_gck = Double.valueOf(edit_qc_gk_gck.getText().toString().replaceAll(",",""));
                        checkEmpty(edit_byjy_zy_wu.getText().toString(), "请输入本月交易金额，物质以及工程劳务金额");
                        checkEmpty(edit_byjy_zy_zb.getText().toString(), "请输入本月交易金额，质保金金额");
                        checkEmpty(edit_bujy_gk_gck.getText().toString(), "请输入本月交易金额，挂靠工程款金额");

                        zq_byjy_zy_wu = Double.valueOf(edit_byjy_zy_wu.getText().toString().replaceAll(",",""));
                        zq_byjy_zy_zb = Double.valueOf(edit_byjy_zy_zb.getText().toString().replaceAll(",",""));
                        zq_byjy_gk_gck = Double.valueOf(edit_bujy_gk_gck.getText().toString().replaceAll(",",""));
                        checkEmpty(edit_byjy_zf_wu.getText().toString(), "请输入本月支付金额，物质以及工程劳务金额");
                        checkEmpty(edit_byjy_zf_zb.getText().toString(), "请输入本月支付金额，质保金金额");
                        checkEmpty(edit_bujy_zf_gck.getText().toString(), "请输入本月支付金额，挂靠工程款金额");

                        zq_byzf_zy_wu = Double.valueOf(edit_byjy_zf_wu.getText().toString().replaceAll(",",""));
                        zq_byzf_zy_zb = Double.valueOf(edit_byjy_zf_zb.getText().toString().replaceAll(",",""));
                        zq_byzf_gk_gck = Double.valueOf(edit_bujy_zf_gck.getText().toString().replaceAll(",",""));

                        checkEmpty(edit_wd_zy.getText().toString(), "自有项目—未达帐项，请输入金额");
                        checkEmpty(edit_zglj_zy.getText().toString(), "自有项目—累计暂估金额，请输入金额");
                        checkEmpty(edit_gk_wd.getText().toString(), "挂靠项目—未达帐项，请输入金额");
                        checkEmpty(edit_gk_zgje.getText().toString(), "挂靠项目—累计暂估金额，请输入金额");


                        zq_wd_zy = Double.valueOf(edit_wd_zy.getText().toString().replaceAll(",",""));
                        zq_wd_zy_zgje = Double.valueOf(edit_zglj_zy.getText().toString().replaceAll(",",""));
                        zq_wd_gk = Double.valueOf(edit_gk_wd.getText().toString().replaceAll(",",""));
                        zq_wd_gk_zgje = Double.valueOf(edit_gk_zgje.getText().toString().replaceAll(",",""));

                        zq_is_ok = 0;
                        zq_wd_sm = edit_wd_miaoshu.getText().toString();
                        ProxyUtils.PostHttpCheckProxy().updateZq(this, getIntent().getIntExtra("zq_id", 0), zq_dz_key, year, mouth, zq_company, zq_company_name
                                , zq_dz_company, zq_dz_company_name, zq_qc_zy_wu, zq_qc_zy_zb, zq_qc_gk_gck, zq_byjy_zy_wu, zq_byjy_zy_zb, zq_byjy_gk_gck
                                , zq_byzf_zy_wu, zq_byzf_zy_zb, zq_byzf_gk_gck, zq_wd_zy, zq_wd_zy_zgje, zq_wd_gk, zq_wd_gk_zgje, zq_is_ok, zq_wd_sm);


                    } catch (Exception e) {
                        ToastUtils.custom(e.getMessage());
                    }

                } else {
                    try {
                        if(id!=0){
                            zw_dz_company = id;
                        }

                        zw_dz_company_name=text_danwei_xunaze.getText().toString().trim();
                        if(zw_company<10&&zw_dz_company<10){
                            zw_dz_key = year + mouth +"0"+ zw_dz_company + "0"+zw_company;
                        }
                        if(zq_company>10&&zq_dz_company<10){
                            zw_dz_key = year + mouth + zw_dz_company + "0"+zw_company;
                        }
                        if(zq_company<10&&zq_dz_company>10){
                            zw_dz_key = year + mouth +"0"+ zw_dz_company + zw_company;
                        }
                        if(zq_company>0&&zq_dz_company>10){
                            zw_dz_key = year + mouth + zw_dz_company + zw_company;
                        }

                        //zw_dz_key = year + mouth + zw_dz_company+ zw_company;
                        checkEmpty(zw_company_name, "请选择对帐单位");
                        checkEmpty(year, "请选择对帐时间");
                        checkEmpty(mouth, "请选择对帐时间");
                        checkEmpty(edit_qc_zy_wu.getText().toString(), "请输入期初余额，物质以及工程劳务金额");
                        checkEmpty(edit_qc_zy_zb.getText().toString(), "请输入期初余额，质保金金额");
                        checkEmpty(edit_qc_gk_gck.getText().toString(), "请输入期初余额，挂靠工程款金额");


                        zw_qc_zy_wu = Double.valueOf(edit_qc_zy_wu.getText().toString().replaceAll(",",""));
                        zw_qc_zy_zb = Double.valueOf(edit_qc_zy_zb.getText().toString().replaceAll(",",""));
                        zw_qc_gk_gck = Double.valueOf(edit_qc_gk_gck.getText().toString().replaceAll(",",""));
                        checkEmpty(edit_byjy_zy_wu.getText().toString(), "请输入本月交易金额，物质以及工程劳务金额");
                        checkEmpty(edit_byjy_zy_zb.getText().toString(), "请输入本月交易金额，质保金金额");
                        checkEmpty(edit_bujy_gk_gck.getText().toString(), "请输入本月交易金额，挂靠工程款金额");


                        zw_byjy_zy_wu = Double.valueOf(edit_byjy_zy_wu.getText().toString().replaceAll(",",""));
                        zw_byjy_zy_zb = Double.valueOf(edit_byjy_zy_zb.getText().toString().replaceAll(",",""));
                        zw_byjy_gk_gck = Double.valueOf(edit_bujy_gk_gck.getText().toString().replaceAll(",",""));
                        checkEmpty(edit_byjy_zf_wu.getText().toString(), "请输入本月支付金额，物质以及工程劳务金额");
                        checkEmpty(edit_byjy_zf_zb.getText().toString(), "请输入本月支付金额，质保金金额");
                        checkEmpty(edit_bujy_zf_gck.getText().toString(), "请输入本月支付金额，挂靠工程款金额");


                        zw_byzf_zy_wu = Double.valueOf(edit_byjy_zf_wu.getText().toString().replaceAll(",",""));
                        zw_byzf_zy_zb = Double.valueOf(edit_byjy_zf_zb.getText().toString().replaceAll(",",""));
                        zw_byzf_gk_gck = Double.valueOf(edit_bujy_zf_gck.getText().toString().replaceAll(",",""));
                        checkEmpty(edit_wd_zy.getText().toString(), "自有项目—未达帐项，请输入金额");
                        checkEmpty(edit_zglj_zy.getText().toString(), "自有项目—累计暂估金额，请输入金额");
                        checkEmpty(edit_gk_wd.getText().toString(), "挂靠项目—未达帐项，请输入金额");
                        checkEmpty(edit_gk_zgje.getText().toString(), "挂靠项目—累计暂估金额，请输入金额");


                        zw_wd_zy = Double.valueOf(edit_wd_zy.getText().toString().replaceAll(",",""));
                        zw_wd_zy_zgje = Double.valueOf(edit_zglj_zy.getText().toString().replaceAll(",",""));
                        zw_wd_gk = Double.valueOf(edit_gk_wd.getText().toString().replaceAll(",",""));
                        zw_wd_gk_zgje = Double.valueOf(edit_gk_zgje.getText().toString().replaceAll(",",""));

                        zw_is_ok = 0;
                        zw_wd_sm = edit_wd_miaoshu.getText().toString();
                        ProxyUtils.PostHttpCheckProxy().updateZw(this, getIntent().getIntExtra("zw_id", 0), zw_dz_key, year, mouth, zw_company, zw_company_name
                                , zw_dz_company, zw_dz_company_name, zw_qc_zy_wu, zw_qc_zy_zb, zw_qc_gk_gck, zw_byjy_zy_wu, zw_byjy_zy_zb, zw_byjy_gk_gck
                                , zw_byzf_zy_wu, zw_byzf_zy_zb, zw_byzf_gk_gck, zw_wd_zy, zw_wd_zy_zgje, zw_wd_gk, zw_wd_gk_zgje, zw_is_ok, zw_wd_sm);


                    } catch (Exception e) {
                        ToastUtils.custom(e.getMessage());
                    }

                }

            }else {
                    if (type == 1) {
                        //TODO 提交
                        try {

                            zw_dz_company = id;
                            zw_dz_company_name = CompanyName;
                            zw_company = MyApplication.loginBean.getData().getCompanyId();
                            zw_company_name = MyApplication.loginBean.getData().getSelfCompany().getCompanyName();
                            if(zw_company<10&&zw_dz_company<10){
                                zw_dz_key = year + mouth +"0"+ zw_dz_company + "0"+zw_company;
                            }
                            if(zw_company>10&&zw_dz_company<10){
                                zw_dz_key = year + mouth + zw_dz_company + "0"+zw_company;
                            }
                            if(zw_company<10&&zw_dz_company>10){
                                zw_dz_key = year + mouth +"0"+ zw_dz_company + zw_company;
                            }
                            if(zw_company>0&&zw_dz_company>10){
                                zw_dz_key = year + mouth + zw_dz_company + zw_company;
                            }
                           // zw_dz_key = zw_year + zw_month + zw_dz_company + zw_company;
                            checkEmpty(zw_company_name, "请选择对帐单位");
                            checkEmpty(zw_year, "请选择对帐时间");
                            checkEmpty(zw_month, "请选择对帐时间");
                            checkEmpty(edit_qc_zy_wu.getText().toString(), "请输入期初余额，物质以及工程劳务金额");
                            checkEmpty(edit_qc_zy_zb.getText().toString(), "请输入期初余额，质保金金额");
                            checkEmpty(edit_qc_gk_gck.getText().toString(), "请输入期初余额，挂靠工程款金额");

                            String s=edit_qc_zy_wu.getText().toString().replaceAll(",","");
                            zw_qc_zy_wu = Double.valueOf(s);
                            zw_qc_zy_zb = Double.valueOf(edit_qc_zy_zb.getText().toString().replaceAll(",",""));
                            zw_qc_gk_gck = Double.valueOf(edit_qc_gk_gck.getText().toString().replaceAll(",",""));
                            checkEmpty(edit_byjy_zy_wu.getText().toString(), "请输入本月交易金额，物质以及工程劳务金额");
                            checkEmpty(edit_byjy_zy_zb.getText().toString(), "请输入本月交易金额，质保金金额");
                            checkEmpty(edit_bujy_gk_gck.getText().toString(), "请输入本月交易金额，挂靠工程款金额");


                            zw_byjy_zy_wu = Double.valueOf(edit_byjy_zy_wu.getText().toString().replaceAll(",",""));
                            zw_byjy_zy_zb = Double.valueOf(edit_byjy_zy_zb.getText().toString().replaceAll(",",""));
                            zw_byjy_gk_gck = Double.valueOf(edit_bujy_gk_gck.getText().toString().replaceAll(",",""));
                            checkEmpty(edit_byjy_zf_wu.getText().toString(), "请输入本月支付金额，物质以及工程劳务金额");
                            checkEmpty(edit_byjy_zf_zb.getText().toString(), "请输入本月支付金额，质保金金额");
                            checkEmpty(edit_bujy_zf_gck.getText().toString(), "请输入本月支付金额，挂靠工程款金额");


                            zw_byzf_zy_wu = Double.valueOf(edit_byjy_zf_wu.getText().toString().replaceAll(",",""));
                            zw_byzf_zy_zb = Double.valueOf(edit_byjy_zf_zb.getText().toString().replaceAll(",",""));
                            zw_byzf_gk_gck = Double.valueOf(edit_bujy_zf_gck.getText().toString().replaceAll(",",""));
                            checkEmpty(edit_wd_zy.getText().toString(), "自有项目—未达帐项，请输入金额");
                            checkEmpty(edit_zglj_zy.getText().toString(), "自有项目—累计暂估金额，请输入金额");
                            checkEmpty(edit_gk_wd.getText().toString(), "挂靠项目—未达帐项，请输入金额");
                            checkEmpty(edit_gk_zgje.getText().toString(), "挂靠项目—累计暂估金额，请输入金额");


                            zw_wd_zy = Double.valueOf(edit_wd_zy.getText().toString().replaceAll(",",""));
                            zw_wd_zy_zgje = Double.valueOf(edit_zglj_zy.getText().toString().replaceAll(",",""));
                            zw_wd_gk = Double.valueOf(edit_gk_wd.getText().toString().replaceAll(",",""));
                            zw_wd_gk_zgje = Double.valueOf(edit_gk_zgje.getText().toString().replaceAll(",",""));

                            zw_is_ok = 0;
                            zw_wd_sm = edit_wd_miaoshu.getText().toString();
//                            ProxyUtils.GetHttpCheckProxy().addZw(this, zw_dz_key, zw_year, zw_month, zw_company, zw_company_name
//                                    , zw_dz_company, zw_dz_company_name, zw_qc_zy_wu, zw_qc_zy_zb, zw_qc_gk_gck, zw_byjy_zy_wu, zw_byjy_zy_zb, zw_byjy_gk_gck
//                                    , zw_byzf_zy_wu, zw_byzf_zy_zb, zw_byzf_gk_gck, zw_wd_zy, zw_wd_zy_zgje, zw_wd_gk, zw_wd_gk_zgje, zw_is_ok, zw_wd_sm);
                            ProxyUtils.PostHttpCheckProxy().checkFiance(this,  zw_dz_company, zw_company,Integer.valueOf(zw_year), Integer.valueOf(zw_month), 1);


                        } catch (Exception e) {
                            ToastUtils.custom(e.getMessage());
                        }

                    } else {
                        //TODO 提交

                        try {

                            zq_company = MyApplication.loginBean.getData().getCompanyId();
                            zq_company_name = MyApplication.loginBean.getData().getSelfCompany().getCompanyName();
                            zq_dz_company = id;
                            zq_dz_company_name = CompanyName;
                            if(zq_company<10&&zq_dz_company<10){
                                zq_dz_key = year + mouth +"0"+ zq_company + "0"+zq_dz_company;
                            }
                            if(zq_company>10&&zq_dz_company<10){
                                zq_dz_key = year + mouth + zq_company + "0"+zq_dz_company;
                            }
                            if(zq_company<10&&zq_dz_company>10){
                                zq_dz_key = year + mouth +"0"+ zq_company + zq_dz_company;
                            }
                            if(zq_company>0&&zq_dz_company>10){
                                zq_dz_key = year + mouth + zq_company + zq_dz_company;
                            }
                            //zq_dz_key = zq_year + zq_month + zq_company + zq_dz_company;
                            checkEmpty(zq_dz_company_name, "请选择对帐单位");
                            checkEmpty(zq_year, "请选择对帐时间");
                            checkEmpty(zq_month, "请选择对帐时间");
                            checkEmpty(edit_qc_zy_wu.getText().toString(), "请输入期初余额，物质以及工程劳务金额");
                            checkEmpty(edit_qc_zy_zb.getText().toString(), "请输入期初余额，质保金金额");
                            checkEmpty(edit_qc_gk_gck.getText().toString(), "请输入期初余额，挂靠工程款金额");


                            zq_qc_zy_wu = Double.valueOf(edit_qc_zy_wu.getText().toString().replaceAll(",",""));
                            zq_qc_zy_zb = Double.valueOf(edit_qc_zy_zb.getText().toString().replaceAll(",",""));
                            zq_qc_gk_gck = Double.valueOf(edit_qc_gk_gck.getText().toString().replaceAll(",",""));
                            checkEmpty(edit_byjy_zy_wu.getText().toString(), "请输入本月交易金额，物质以及工程劳务金额");
                            checkEmpty(edit_byjy_zy_zb.getText().toString(), "请输入本月交易金额，质保金金额");
                            checkEmpty(edit_bujy_gk_gck.getText().toString(), "请输入本月交易金额，挂靠工程款金额");

                            zq_byjy_zy_wu = Double.valueOf(edit_byjy_zy_wu.getText().toString().replaceAll(",",""));
                            zq_byjy_zy_zb = Double.valueOf(edit_byjy_zy_zb.getText().toString().replaceAll(",",""));
                            zq_byjy_gk_gck = Double.valueOf(edit_bujy_gk_gck.getText().toString().replaceAll(",",""));
                            checkEmpty(edit_byjy_zf_wu.getText().toString(), "请输入本月支付金额，物质以及工程劳务金额");
                            checkEmpty(edit_byjy_zf_zb.getText().toString(), "请输入本月支付金额，质保金金额");
                            checkEmpty(edit_bujy_zf_gck.getText().toString(), "请输入本月支付金额，挂靠工程款金额");

                            zq_byzf_zy_wu = Double.valueOf(edit_byjy_zf_wu.getText().toString().replaceAll(",",""));
                            zq_byzf_zy_zb = Double.valueOf(edit_byjy_zf_zb.getText().toString().replaceAll(",",""));
                            zq_byzf_gk_gck = Double.valueOf(edit_bujy_zf_gck.getText().toString().replaceAll(",",""));

                            checkEmpty(edit_wd_zy.getText().toString(), "自有项目—未达帐项，请输入金额");
                            checkEmpty(edit_zglj_zy.getText().toString(), "自有项目—累计暂估金额，请输入金额");
                            checkEmpty(edit_gk_wd.getText().toString(), "挂靠项目—未达帐项，请输入金额");
                            checkEmpty(edit_gk_zgje.getText().toString(), "挂靠项目—累计暂估金额，请输入金额");


                            zq_wd_zy = Double.valueOf(edit_wd_zy.getText().toString().replaceAll(",",""));
                            zq_wd_zy_zgje = Double.valueOf(edit_zglj_zy.getText().toString().replaceAll(",",""));
                            zq_wd_gk = Double.valueOf(edit_gk_wd.getText().toString().replaceAll(",",""));
                            zq_wd_gk_zgje = Double.valueOf(edit_gk_zgje.getText().toString().replaceAll(",",""));

                            zq_is_ok = 0;
                            zq_wd_sm = edit_wd_miaoshu.getText().toString();
                            ProxyUtils.PostHttpCheckProxy().checkFiance(this, zq_company, zq_dz_company, Integer.valueOf(zq_year), Integer.valueOf(zq_month), 0);


                        } catch (Exception e) {
                            ToastUtils.custom(e.getMessage());
                        }


                    }
                }

                break;
            case R.id.text_sure:
                text_yuefen_xunaze.setText(zq_year+"."+zq_month);
                dialog.dismiss();
                break;
            case R.id.text_quxiao:
                dialog.dismiss();
                break;
        }
    }
    protected  void checkFiance(AddZqBean bean){
        if("false".equals(bean.getData())){
            if(type==1){
                ProxyUtils.PostHttpCheckProxy().addZw(this,zw_dz_key,zw_year,zw_month,zw_company,zw_company_name
                        ,zw_dz_company,zw_dz_company_name,zw_qc_zy_wu,zw_qc_zy_zb,zw_qc_gk_gck,zw_byjy_zy_wu,zw_byjy_zy_zb,zw_byjy_gk_gck
                        ,zw_byzf_zy_wu,zw_byzf_zy_zb,zw_byzf_gk_gck,zw_wd_zy,zw_wd_zy_zgje,zw_wd_gk,zw_wd_gk_zgje,zw_is_ok,zw_wd_sm);

            }else {
                ProxyUtils.PostHttpCheckProxy().addZq(this,zq_dz_key,zq_year,zq_month,zq_company,zq_company_name
                        ,zq_dz_company,zq_dz_company_name,zq_qc_zy_wu,zq_qc_zy_zb,zq_qc_gk_gck,zq_byjy_zy_wu,zq_byjy_zy_zb,zq_byjy_gk_gck
                        ,zq_byzf_zy_wu,zq_byzf_zy_zb,zq_byzf_gk_gck,zq_wd_zy,zq_wd_zy_zgje,zq_wd_gk,zq_wd_gk_zgje,zq_is_ok,zq_wd_sm);

            }

        }else {
            Toast.makeText(this,"本月账单已经存在",Toast.LENGTH_SHORT).show();

        }



    }
    protected  void addZq(AddZqBean bean){
        Toast.makeText(this,"账单创建完成",Toast.LENGTH_SHORT).show();
        finish();


    }
    protected  void updateZw(AddZqBean bean){
        Toast.makeText(this,"账单修改完成",Toast.LENGTH_SHORT).show();
        finish();


    }
    protected  void updateZq(AddZqBean bean){
        Toast.makeText(this,"账单创建完成",Toast.LENGTH_SHORT).show();
        finish();


    }
    public void shownavigation() {
        inflate = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
        TextView text_sure=inflate.findViewById(R.id.text_sure);
        TextView text_quxiao=inflate.findViewById(R.id.text_quxiao);
        text_sure.setOnClickListener(this);
        text_quxiao.setOnClickListener(this);
        yearView = (WheelView) inflate.findViewById(R.id.year_view);
        mouthView = (WheelView) inflate.findViewById(R.id.mouth_view);
        yearView.setWheelAdapter(new ArrayWheelAdapter(this));
        yearView.setSkin(com.wx.wheelview.widget.WheelView.Skin.Holo);
        yearView.setWheelSize(5);
        yearView.setWheelData(years);
        com.wx.wheelview.widget.WheelView.WheelViewStyle style = new com.wx.wheelview.widget.WheelView.WheelViewStyle();
        style.selectedTextColor = Color.parseColor("#0288ce");
        style.textColor = Color.GRAY;
        style.selectedTextSize = 20;
        yearView.setStyle(style);
        yearView.setExtraText("", Color.parseColor("#0288ce"), 40, 70);
        mouthView.setWheelAdapter(new ArrayWheelAdapter(this));
        mouthView.setSkin(com.wx.wheelview.widget.WheelView.Skin.Holo);
        mouthView.setWheelSize(5);
        mouthView.setSelection(3);
        mouthView.setWheelData(mouths);
        mouthView.setStyle(style);
        mouthView.setExtraText("", Color.parseColor("#0288ce"), 40, 70);
        yearView.setOnWheelItemSelectedListener(new com.wx.wheelview.widget.WheelView.OnWheelItemSelectedListener() {
            @Override
            public void onItemSelected(int position, Object o) {

                year   =zw_year =zq_year=   (String) yearView.getSelectionItem();
            }
        });
        mouthView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectedListener() {
            @Override
            public void onItemSelected(int position, Object o) {
                String mouth1=(String) mouthView.getSelectionItem();
                switch (mouth1){
                    case "1月":
                        zq_month="01";
                        break;
                    case "2月":
                        zq_month="02";
                        break;
                    case "3月":
                        zq_month="03";
                        break;
                    case "4月":
                        zq_month="04";
                        break;
                    case "5月":
                        zq_month="05";
                        break;
                    case "6月":
                        zq_month="06";
                        break;
                    case "7月":
                        zq_month="07";
                        break;
                    case "8月":
                        zq_month="08";
                        break;
                    case "9月":
                        zq_month="09";
                        break;
                    case "10月":
                        zq_month="10";
                        break;
                    case "11月":
                        zq_month="11";
                        break;
                    case "12月":
                        zq_month="12";
                        break;
                }
                mouth= zw_month= zq_month;


            }
        });

        dialog = new Dialog(this, R.style.ActionSheetDialogStyle);
//填充对话框的布局

        //将布局设置给Dialog
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 0;//设置Dialog距离底部的距离
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//       将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();//显示对话框

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        qclist.clear();
        byjylist.clear();
        byzflist.clear();
        wdflist.clear();
        try {
            // TODO 计算期初总额
            qclist.add(0,edit_qc_zy_wu.getText().toString().trim());

            qclist.add(1,edit_qc_zy_zb.getText().toString().trim());
            qclist.add(2,edit_qc_gk_gck.getText().toString().trim());
            for(int i=0;i<qclist.size();i++){
                if(qclist.get(i).equals("")){
                    qclist.set(i,"0");
                }
            }
            if(qclist.get(0).contains(",")){
                    qclist.set(0,qclist.get(0).replaceAll(",",""));

            }
            if(qclist.get(1).contains(",")){
                qclist.set(1,qclist.get(1).replaceAll(",",""));

            }
            if(qclist.get(2).contains(",")){
                qclist.set(2,qclist.get(2).replaceAll(",",""));

            }
            Double  qc=Double.valueOf(qclist.get(0))+Double.valueOf(qclist.get(1))+Double.valueOf(qclist.get(2));
            String qc1=df.format(qc);
            text_qu_sum.setText(qc1);
            //TODO 计算本月交易总额
            byjylist.add(0,edit_byjy_zy_wu.getText().toString().trim());
            byjylist.add(1,edit_byjy_zy_zb.getText().toString().trim());
            byjylist.add(2,edit_bujy_gk_gck.getText().toString().trim());
            for(int i=0;i<byjylist.size();i++){
                if(byjylist.get(i).equals("")){
                    byjylist.set(i,"0");
                }
            }
            if(byjylist.get(0).contains(",")){
//            if(qclist.get(0).contains(",")){
                byjylist.set(0,byjylist.get(0).replaceAll(",",""));

        }
        if(byjylist.get(1).contains(",")){
            byjylist.set(1,byjylist.get(1).replaceAll(",",""));

        }
        if(byjylist.get(2).contains(",")){
            byjylist.set(2,byjylist.get(2).replaceAll(",",""));

        }
            Double  byjy= (Double.valueOf(byjylist.get(0))+Double.valueOf(byjylist.get(1))+Double.valueOf(byjylist.get(2)));
            String byjy1=df.format(byjy);
            text_byjy_sum.setText(byjy1);



            //TODO 计算本月支付总额


            byzflist.add(0,edit_byjy_zf_wu.getText().toString().trim());
            byzflist.add(1,edit_byjy_zf_zb.getText().toString().trim());
            byzflist.add(2,edit_bujy_zf_gck.getText().toString().trim());
            for(int i=0;i<byzflist.size();i++) {
                if (byzflist.get(i).equals("")) {
                    byzflist.set(i, "0");
                }
            }
            if(byzflist.get(0).contains(",")){
//            if(qclist.get(0).contains(",")){
                byzflist.set(0,byzflist.get(0).replaceAll(",",""));

            }
            if(byzflist.get(1).contains(",")){
                byzflist.set(1,byzflist.get(1).replaceAll(",",""));

            }
            if(byzflist.get(2).contains(",")){
                byzflist.set(2,byzflist.get(2).replaceAll(",",""));

            }
            Double  zf=Double.valueOf(byzflist.get(0))+Double.valueOf(byzflist.get(1))+Double.valueOf(byzflist.get(2));
            String zf1=df.format(zf);
            text_zf_sum.setText(zf1);



            //TODO 计算未达以及暂估总额


            wdflist.add(0,edit_wd_zy.getText().toString().trim());
            wdflist.add(1,edit_zglj_zy.getText().toString().trim());
            wdflist.add(2,edit_gk_wd.getText().toString().trim());
            wdflist.add(3,edit_gk_zgje.getText().toString().trim());
            for(int i=0;i<wdflist.size();i++) {
                if (wdflist.get(i).equals("")) {
                    wdflist.set(i, "0");
                }
            }
            if(wdflist.get(0).contains(",")){
//            if(qclist.get(0).contains(",")){
                wdflist.set(0,wdflist.get(0).replaceAll(",",""));

            }
            if(wdflist.get(1).contains(",")){
                wdflist.set(1,wdflist.get(1).replaceAll(",",""));

            }
            if(wdflist.get(2).contains(",")){
                wdflist.set(2,wdflist.get(2).replaceAll(",",""));

            }
            if(wdflist.get(3).contains(",")){
                wdflist.set(3,wdflist.get(3).replaceAll(",",""));

            }
            Double  wd=Double.valueOf(wdflist.get(0))+Double.valueOf(wdflist.get(1))+Double.valueOf(wdflist.get(2))+Double.valueOf(wdflist.get(3));
            String wd1=df.format(wd);
            text_wd_sum.setText(wd1);


        }catch (NumberFormatException e){
            //ToastUtils.show("输入金额太大");


        }




    }

    @Override
    public void afterTextChanged(Editable s) {



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode){
            case 102:
                CompanyName=data.getStringExtra("CompanyName");
                id=data.getIntExtra("id",0);
                text_danwei_xunaze.setText(CompanyName);
                break;
        }
    }
    public static void checkEmpty(String content, String errMsg) {
        if (TextUtils.isEmpty(content)) {
            throw new IllegalArgumentException(errMsg);
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()){
            case R.id.edit_qc_zy_wu:
                if(!hasFocus){
                    if(edit_qc_zy_wu.getText().toString().contains(",")){
                        String s=edit_qc_zy_wu.getText().toString().replaceAll(",","");
                        edit_qc_zy_wu.setText(df.format(Double.valueOf(s)));
                    }else {
                        if(!"".equals(edit_qc_zy_wu.getText().toString())&&!"-".equals(edit_qc_zy_wu.getText().toString())){
                            edit_qc_zy_wu.setText(df.format(Double.valueOf(edit_qc_zy_wu.getText().toString())));
                        }
                    }

                }
                break;

            case R.id.edit_gk_zgje:
                if(!hasFocus){
                    if(edit_gk_zgje.getText().toString().contains(",")){
                        String s=edit_gk_zgje.getText().toString().replaceAll(",","");
                        edit_gk_zgje.setText(df.format(Double.valueOf(s)));
                    }else {
                        if(!"".equals(edit_gk_zgje.getText().toString())&&!"-".equals(edit_gk_zgje.getText().toString())){
                            edit_gk_zgje.setText(df.format(Double.valueOf(edit_gk_zgje.getText().toString())));
                        }
                    }

                }
                break;
            case R.id.edit_gk_wd:
                if(!hasFocus){
                    if(edit_gk_wd.getText().toString().contains(",")){
                        String s=edit_gk_wd.getText().toString().replaceAll(",","");
                        edit_gk_wd.setText(df.format(Double.valueOf(s)));
                    }else {
                        if(!"".equals(edit_gk_wd.getText().toString())&&!"-".equals(edit_gk_wd.getText().toString())){
                            edit_gk_wd.setText(df.format(Double.valueOf(edit_gk_wd.getText().toString())));
                        }
                    }

                }
                break;
            case R.id.edit_zglj_zy:
                if(!hasFocus){
                    if(edit_zglj_zy.getText().toString().contains(",")){
                        String s=edit_zglj_zy.getText().toString().replaceAll(",","");
                        edit_zglj_zy.setText(df.format(Double.valueOf(s)));
                    }else {
                        if(!"".equals(edit_zglj_zy.getText().toString())&&!"-".equals(edit_zglj_zy.getText().toString())){
                            edit_zglj_zy.setText(df.format(Double.valueOf(edit_zglj_zy.getText().toString())));
                        }
                    }

                }
                break;
            case R.id.edit_wd_zy:
                if(!hasFocus){
                    if(edit_wd_zy.getText().toString().contains(",")){
                        String s=edit_wd_zy.getText().toString().replaceAll(",","");
                        edit_wd_zy.setText(df.format(Double.valueOf(s)));
                    }else {
                        if(!"".equals(edit_wd_zy.getText().toString())&&!"-".equals(edit_wd_zy.getText().toString())){
                            edit_wd_zy.setText(df.format(Double.valueOf(edit_wd_zy.getText().toString())));
                        }
                    }

                }
                break;
            case R.id.edit_qc_zy_zb:
                if(!hasFocus){
                    if(edit_qc_zy_zb.getText().toString().contains(",")){
                        String s=edit_qc_zy_zb.getText().toString().replaceAll(",","");
                        edit_qc_zy_zb.setText(df.format(Double.valueOf(s)));
                    }else {
                        if(!"".equals(edit_qc_zy_zb.getText().toString())&&!"-".equals(edit_qc_zy_zb.getText().toString())){
                            edit_qc_zy_zb.setText(df.format(Double.valueOf(edit_qc_zy_zb.getText().toString())));
                        }
                    }

                }
                break;
            case R.id.edit_qc_gk_gck:
                if(!hasFocus){
                    if(edit_qc_gk_gck.getText().toString().contains(",")){
                        String s=edit_qc_gk_gck.getText().toString().replaceAll(",","");
                        edit_qc_gk_gck.setText(df.format(Double.valueOf(s)));
                    }else {
                       String s= edit_byjy_zy_wu.getText().toString();
                        if(!"".equals(edit_qc_gk_gck.getText().toString())&&!"-".equals(edit_qc_gk_gck.getText().toString())){
                            edit_qc_gk_gck.setText(df.format(Double.valueOf(edit_qc_gk_gck.getText().toString())));
                        }
                    }

                }
                break;
            case R.id.edit_byjy_zy_wu:
                if(!hasFocus){
                    if(edit_byjy_zy_wu.getText().toString().contains(",")){
                        String s=edit_byjy_zy_wu.getText().toString().replaceAll(",","");
                        edit_byjy_zy_wu.setText(df.format(Double.valueOf(s)));
                    }else {
                        if(!"".equals(edit_byjy_zy_wu.getText().toString())&&!"-".equals(edit_byjy_zy_wu.getText().toString())){
                            edit_byjy_zy_wu.setText(df.format(Double.valueOf(edit_byjy_zy_wu.getText().toString())));
                        }

                    }

                }
                break;
            case R.id.edit_byjy_zy_zb:
                if(!hasFocus){
                    if(edit_byjy_zy_zb.getText().toString().contains(",")){
                        String s=edit_byjy_zy_zb.getText().toString().replaceAll(",","");
                        edit_byjy_zy_zb.setText(df.format(Double.valueOf(s)));
                    }else {
                        if(!"".equals(edit_byjy_zy_zb.getText().toString())&&!"-".equals(edit_byjy_zy_zb.getText().toString())){
                            edit_byjy_zy_zb.setText(df.format(Double.valueOf(edit_byjy_zy_zb.getText().toString())));
                        }
                    }

                }
                break;
            case R.id.edit_bujy_gk_gck:
                if(!hasFocus){
                    if(edit_bujy_gk_gck.getText().toString().contains(",")){
                        String s=edit_bujy_gk_gck.getText().toString().replaceAll(",","");
                        edit_bujy_gk_gck.setText(df.format(Double.valueOf(s)));
                    }else {
                        if(!"".equals(edit_bujy_gk_gck.getText().toString())&&!"-".equals(edit_bujy_gk_gck.getText().toString())){
                            edit_bujy_gk_gck.setText(df.format(Double.valueOf(edit_bujy_gk_gck.getText().toString())));
                        }
                    }

                }
                break;
            case R.id.edit_byjy_zf_wu:
                if(!hasFocus){
                    if(edit_byjy_zf_wu.getText().toString().contains(",")){
                        String s=edit_byjy_zf_wu.getText().toString().replaceAll(",","");
                        edit_byjy_zf_wu.setText(df.format(Double.valueOf(s)));
                    }else {
                        if(!"".equals(edit_byjy_zf_wu.getText().toString())&&!"-".equals(edit_byjy_zf_wu.getText().toString())){
                            edit_byjy_zf_wu.setText(df.format(Double.valueOf(edit_byjy_zf_wu.getText().toString())));
                        }
                    }

                }
                break;
            case R.id.edit_byjy_zf_zb:
                if(!hasFocus){
                    if(edit_byjy_zf_zb.getText().toString().contains(",")){
                        String s=edit_byjy_zf_zb.getText().toString().replaceAll(",","");
                        edit_byjy_zf_zb.setText(df.format(Double.valueOf(s)));
                    }else {
                        if(!"".equals(edit_byjy_zf_zb.getText().toString())&&!"-".equals(edit_byjy_zf_zb.getText().toString())){
                            edit_byjy_zf_zb.setText(df.format(Double.valueOf(edit_byjy_zf_zb.getText().toString())));
                        }
                    }

                }
                break;
            case R.id.edit_bujy_zf_gck:
                if(!hasFocus){
                    if(edit_bujy_zf_gck.getText().toString().contains(",")){
                        String s=edit_bujy_zf_gck.getText().toString().replaceAll(",","");
                        edit_bujy_zf_gck.setText(df.format(Double.valueOf(s)));
                    }else {
                        if(!"".equals(edit_bujy_zf_gck.getText().toString())&&!"-".equals(edit_bujy_zf_gck.getText().toString())){
                            edit_bujy_zf_gck.setText(df.format(Double.valueOf(edit_bujy_zf_gck.getText().toString())));
                        }
                    }

                }
                break;

        }

    }
}
