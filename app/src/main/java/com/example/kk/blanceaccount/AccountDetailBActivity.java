package com.example.kk.blanceaccount;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

import base.BaseActivity;
import butterknife.Bind;
import model.bean.FindFinanceBean;
import tools.ProxyUtils;

public class AccountDetailBActivity extends BaseActivity {
    @Bind(R.id.text_zw)
    TextView text_zw;
    @Bind(R.id.text_zq)
    TextView text_zq;
    @Bind(R.id.imave_account_status)
    ImageView imave_account_status;
    @Bind(R.id.tv_account_status)
    TextView tv_account_status;

    @Bind(R.id.tv_zq_qu_zy_wz)
    TextView tv_zq_qu_zy_wz;

    @Bind(R.id.tv_zw_qu_zy_wz)
    TextView tv_zw_qu_zy_wz;
    @Bind(R.id.tv_zq_qu_zy_zb)
    TextView tv_zq_qu_zy_zb;
    @Bind(R.id.tv_zw_qu_zy_zb)
    TextView tv_zw_qu_zy_zb;

    @Bind(R.id.tv_sum_zq_gk_sum)
    TextView tv_sum_zq_gk_sum;
    @Bind(R.id.tv_sum_zw_gk_sum)
    TextView tv_sum_zw_gk_sum;
    @Bind(R.id.tv_zq_byjy_zy_wz)
    TextView tv_zq_byjy_zy_wz;
    @Bind(R.id.tv_zw_bujy_zy_wz)
    TextView tv_zw_bujy_zy_wz;
    @Bind(R.id.tv_zq_byjy_zy_zb)
    TextView tv_zq_byjy_zy_zb;

    @Bind(R.id.tv_zw_bujy_zy_zb)
    TextView tv_zw_bujy_zy_zb;
    @Bind(R.id.tv_sum_zq_byjy_gk_sum)
    TextView tv_sum_zq_byjy_gk_sum;
    @Bind(R.id.tv_sum_zw_byjy_gk_sum)
    TextView tv_sum_zw_byjy_gk_sum;
    @Bind(R.id.tv_sum_zq_byjy_zy_wz)
    TextView tv_sum_zq_byjy_zy_wz;
    @Bind(R.id.tv_sum_zw_bujy_zy_wz)
    TextView tv_sum_zw_bujy_zy_wz;

    @Bind(R.id.tv_sum_zq_byjy_zy_zb)
    TextView tv_sum_zq_byjy_zy_zb;
    @Bind(R.id.tv_sum_zw_byjy_zy_zb)
    TextView tv_sum_zw_byjy_zy_zb;

    @Bind(R.id.tv_zq_byjy_wd_zgjy)
    TextView tv_zq_byjy_wd_zgjy;
    @Bind(R.id.tv_zw_byjy_wd_zgjy)
    TextView tv_zw_byjy_wd_zgjy;
    @Bind(R.id.tv_zq_byjy_wd_zy)
    TextView tv_zq_byjy_wd_zy;
    @Bind(R.id.tv_zw_byjy_wd_zy)
    TextView tv_zw_byjy_wd_zy;
    @Bind(R.id.tv_zq_byjy_zy_sum)
    TextView tv_zq_byjy_zy_sum;
    @Bind(R.id.tv_zw_byjy_zy_sum)
    TextView tv_zw_byjy_zy_sum;
    @Bind(R.id.tv_zq_byjy_gk_wu)
    TextView tv_zq_byjy_gk_wu;
    @Bind(R.id.tv_zw_byjy_gk_wu)
    TextView tv_zw_byjy_gk_wu;
    @Bind(R.id.tv_zq_byjy_wd_gk_zgjy)
    TextView tv_zq_byjy_wd_gk_zgjy;
    @Bind(R.id.tv_zw_byjy_wd__gk_zgjy)
    TextView tv_zw_byjy_wd__gk_zgjy;
    @Bind(R.id.tv_zq_byje_wd_gk)
    TextView tv_zq_byje_wd_gk;
    @Bind(R.id.tv_zw_byje_wd_gk)
    TextView tv_zw_byje_wd_gk;
    @Bind(R.id.tv_zq_byjy_sum)
    TextView tv_zq_byjy_sum;
    @Bind(R.id.tv_zw_byjy_sum)
    TextView tv_zw_byjy_sum;
    @Bind(R.id.tv_zq_byzf_zy_wz)
    TextView tv_zq_byzf_zy_wz;
    @Bind(R.id.tv_zw_buzf_zy_wz)
    TextView tv_zw_buzf_zy_wz;
    @Bind(R.id.tv_zq_qu_byzf_zy_zb)
    TextView tv_zq_qu_byzf_zy_zb;
    @Bind(R.id.tv_zw_qu_buzf_zy_zb)
    TextView tv_zw_qu_buzf_zy_zb;
    @Bind(R.id.tv_sum_zq_byzf_gk_sum)
    TextView tv_sum_zq_byzf_gk_sum;
    @Bind(R.id.tv_sum_zw_byzf_gk_sum)
    TextView tv_sum_zw_byzf_gk_sum;
    @Bind(R.id.tv_sum_zq_byzf_zy_wz)
    TextView tv_sum_zq_byzf_zy_wz;
    @Bind(R.id.tv_sum_zw_buzf_zy_wz)
    TextView tv_sum_zw_buzf_zy_wz;

    @Bind(R.id.tv_sum_zq_qu_byzf_zy_zb)
    TextView tv_sum_zq_qu_byzf_zy_zb;
    @Bind(R.id.tv_sum_zw_qu_buzf_zy_zb)
    TextView tv_sum_zw_qu_buzf_zy_zb;

    @Bind(R.id.tv_zq_byzf_gk_sum)
    TextView tv_zq_byzf_gk_sum;
    @Bind(R.id.tv_zw_byzf_gk_sum)
    TextView tv_zw_byzf_gk_sum;
    @Bind(R.id.tv_zq_end_zy_wz)
    TextView tv_zq_end_zy_wz;
    @Bind(R.id.tv_zw_end_zy_wz)
    TextView tv_zw_end_zy_wz;
    @Bind(R.id.tv_zq_end_zy_zb)
    TextView tv_zq_end_zy_zb;
    @Bind(R.id.tv_zw_end_zy_zb)
    TextView tv_zw_end_zy_zb;
    @Bind(R.id.tv_zq_end_zgjy)
    TextView tv_zq_end_zgjy;
    @Bind(R.id.tv_zw_end_zgjy)
    TextView tv_zw_end_zgjy;
    @Bind(R.id.tv_zq_end_wd_zy)
    TextView tv_zq_end_wd_zy;
    @Bind(R.id.tv_zw_end_wd_zy)
    TextView tv_zw_end_wd_zy;
    @Bind(R.id.tv_zq_end_zy_sum)
    TextView tv_zq_end_zy_sum;
    @Bind(R.id.tv_zw_end_zy_sum)
    TextView tv_zw_end_zy_sum;

    @Bind(R.id.tv_zq_end_wd_sum)
    TextView tv_zq_end_wd_sum;
    @Bind(R.id.tv_zw_end_wd_sum)
    TextView tv_zw_end_wd_sum;
    @Bind(R.id.imag_qu_status)
    ImageView imag_qu_status;

    @Bind(R.id.image_byjy_satus)
    ImageView image_byjy_satus;
    @Bind(R.id.image_zf_status)
    ImageView image_zf_status;
    @Bind(R.id.image_end_status)
    ImageView image_end_status;

    boolean qustatus=false;
    boolean jystatus=false;
    boolean zfstatus=false;
    @Bind(R.id.text_wd_zq)
    TextView text_wd_zq;
    @Bind(R.id.text_wd_zw)
    TextView text_wd_zw;
    @Bind(R.id.text_wd_zq_sm)
    TextView text_wd_zq_sm;
    @Bind(R.id.text_wd_zw_sm)
    TextView text_wd_zw_sm;
    DecimalFormat df = new DecimalFormat("###,##0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(R.layout.activity_account_detail_b);
    }

    @Override
    protected void findWidgets() {

    }

    @Override
    protected void initComponent() {
        //TODO 查询账务详情
        ProxyUtils.GetHttpCheckProxy().findFinance(this,getIntent().getStringExtra("resultKey"));


    }
    protected void findFinance(FindFinanceBean bean) {


        if (bean.getData().getZq_is_ok() == 1 && bean.getData().getZw_is_ok() == 1) {
            tv_account_status.setText("对账成功");
            tv_account_status.setTextColor(Color.parseColor("#46C472"));
            imave_account_status.setBackground(getResources().getDrawable(R.mipmap.success));
        } else {
            tv_account_status.setText("对账失败");
            tv_account_status.setTextColor(Color.parseColor("#F45555"));
            imave_account_status.setBackground(getResources().getDrawable(R.mipmap.file));
        }

        if(bean.getData().getZq_company_name()==null){
            text_zw.setText(bean.getData().getZw_company_name());
            text_zq.setText(bean.getData().getZw_dz_company_name());
            text_wd_zq.setText("债权单位"+bean.getData().getZw_dz_company_name());
                    text_wd_zw.setText("债务单位"+bean.getData().getZw_company_name());
        }else {
            text_zq.setText(bean.getData().getZq_company_name());
            text_zw.setText(bean.getData().getZq_dz_company_name());
            text_wd_zq.setText("债权单位: "+bean.getData().getZq_dz_company_name());
            text_wd_zw.setText("债务单位: "+bean.getData().getZq_company_name());
        }
        text_wd_zq_sm.setText(bean.getData().getZq_wd_sm());
        text_wd_zw_sm.setText(bean.getData().getZw_wd_sm());
        //TODO 期初板块
        tv_zq_qu_zy_wz.setText(df.format(bean.getData().getZq_qc_zy_wu()));
        tv_zw_qu_zy_wz.setText(df.format(bean.getData().getZw_qc_zy_wu()));
        tv_zq_qu_zy_zb.setText(df.format( bean.getData().getZq_qc_zy_zb()));
        tv_zw_qu_zy_zb.setText(df.format(bean.getData().getZw_qc_zy_zb()));
        tv_sum_zq_gk_sum.setText(df.format(bean.getData().getZq_qc_gk_gck()));
        tv_sum_zw_gk_sum.setText(df.format(bean.getData().getZw_qc_gk_gck()));
        if (bean.getData().getZq_qc_zy_wu() == bean.getData().getZw_qc_zy_wu() && bean.getData().getZq_qc_zy_zb() == bean.getData().getZw_qc_zy_zb()
                && bean.getData().getZq_qc_gk_gck() == bean.getData().getZw_qc_gk_gck()) {
            imag_qu_status.setBackground(getResources().getDrawable(R.mipmap.green));
            qustatus=true;
        } else {
            imag_qu_status.setBackground(getResources().getDrawable(R.mipmap.red));
            qustatus=false;
        }
        //TODO 本月交易
        tv_zq_byjy_zy_wz.setText(df.format(bean.getData().getZq_byjy_zy_wu()));
        tv_zw_bujy_zy_wz.setText(df.format( bean.getData().getZw_byjy_zy_wu()));
        tv_zq_byjy_zy_zb.setText(df.format( bean.getData().getZq_byjy_zy_zb()));
        tv_zw_bujy_zy_zb.setText(df.format(bean.getData().getZw_byjy_zy_zb()));
        tv_sum_zq_byjy_gk_sum.setText(df.format( bean.getData().getZq_byjy_gk_gck()));
        tv_sum_zw_byjy_gk_sum.setText(df.format( bean.getData().getZw_byjy_gk_gck()));

        tv_sum_zq_byjy_zy_wz.setText(df.format( bean.getData().getSum_zq_byjy_zy_wu()));
        tv_sum_zw_bujy_zy_wz.setText(df.format(bean.getData().getSum_zw_byjy_zy_wu()));
        tv_sum_zq_byjy_zy_zb.setText(df.format(bean.getData().getSum_zq_byjy_zy_zb()));
        tv_sum_zw_byjy_zy_zb.setText(df.format(bean.getData().getSum_zw_byjy_zy_zb()));
        tv_zq_byjy_wd_zgjy.setText(df.format(bean.getData().getZq_wd_zy_zgje()));
        tv_zw_byjy_wd_zgjy.setText(df.format(bean.getData().getZw_wd_zy_zgje()));
        tv_zq_byjy_wd_zy.setText(df.format(bean.getData().getZq_wd_zy()));
        tv_zw_byjy_wd_zy.setText(df.format( bean.getData().getZw_wd_zy()));
        // TODO
        Double zq_zy_byjy=(bean.getData().getSum_zq_byjy_zy_wu() + bean.getData().getSum_zq_byjy_zy_zb() + bean.getData().getZq_wd_zy_zgje()
                + bean.getData().getZq_wd_zy());
        tv_zq_byjy_zy_sum.setText(df.format(zq_zy_byjy));
        Double zw_zy_byjy=(bean.getData().getSum_zw_byjy_zy_wu() + bean.getData().getSum_zw_byjy_zy_zb() + bean.getData().getZw_wd_zy_zgje()
                + bean.getData().getZw_wd_zy());
        tv_zw_byjy_zy_sum.setText(df.format(zw_zy_byjy));

        tv_zq_byjy_gk_wu.setText(df.format(bean.getData().getSum_zq_byjy_gk_gck()));
        tv_zw_byjy_gk_wu.setText(df.format(bean.getData().getSum_zw_byjy_gk_gck()));
        tv_zq_byjy_wd_gk_zgjy.setText(df.format(bean.getData().getZq_wd_gk_zgje()));
        tv_zw_byjy_wd__gk_zgjy.setText(df.format( bean.getData().getZw_wd_gk_zgje()));
        tv_zq_byje_wd_gk.setText(df.format(bean.getData().getZq_wd_gk()));
        tv_zw_byje_wd_gk.setText(df.format(bean.getData().getZw_wd_gk()));
        Double zq_gk_byjy= (bean.getData().getSum_zq_byjy_gk_gck() + bean.getData().getZq_wd_gk_zgje() + bean.getData().getZq_wd_gk());
        tv_zq_byjy_sum.setText(df.format(zq_gk_byjy) );
        Double zw_gk_byjy=bean.getData().getSum_zw_byjy_gk_gck() + bean.getData().getZw_wd_gk_zgje() + bean.getData().getZw_wd_gk();
        tv_zw_byjy_sum.setText(df.format(zw_gk_byjy) );
        if (bean.getData().getZq_byjy_zy_wu() == bean.getData().getZw_byjy_zy_wu() && bean.getData().getZq_byjy_zy_zb() == bean.getData().getZw_byjy_zy_zb()
                && bean.getData().getZq_byjy_gk_gck() == bean.getData().getZw_byjy_gk_gck() && bean.getData().getSum_zq_byjy_zy_wu() == bean.getData().getSum_zw_byjy_zy_wu()
                && bean.getData().getSum_zq_byjy_zy_zb() == bean.getData().getSum_zw_byjy_zy_zb() && bean.getData().getZq_wd_zy_zgje() == bean.getData().getZw_wd_zy_zgje()
                && bean.getData().getZq_wd_zy() == bean.getData().getZw_wd_zy() && bean.getData().getSum_zq_byjy_gk_gck() == bean.getData().getSum_zw_byjy_gk_gck()
                && bean.getData().getZq_wd_gk_zgje() == bean.getData().getZw_wd_gk_zgje() && bean.getData().getZq_wd_gk() == bean.getData().getZw_wd_gk()) {

            image_byjy_satus.setBackground(getResources().getDrawable(R.mipmap.green));
            jystatus=true;

        } else {
            image_byjy_satus.setBackground(getResources().getDrawable(R.mipmap.red));
            jystatus=false;
        }

        tv_zq_byzf_zy_wz.setText(df.format(bean.getData().getZq_byzf_zy_wu()));
        tv_zw_buzf_zy_wz.setText(df.format(bean.getData().getZw_byzf_zy_wu()));
        tv_zq_qu_byzf_zy_zb.setText(df.format( bean.getData().getZq_byzf_zy_zb()));
        tv_zw_qu_buzf_zy_zb.setText(df.format(bean.getData().getZw_byzf_zy_zb()));
        tv_sum_zq_byzf_gk_sum.setText(df.format(bean.getData().getZq_byzf_gk_gck()));
        tv_sum_zw_byzf_gk_sum.setText(df.format(bean.getData().getZw_byzf_gk_gck()));

        tv_sum_zq_byzf_zy_wz.setText(df.format(bean.getData().getSum_zq_byzf_zy_wu()));
        tv_sum_zw_buzf_zy_wz.setText(df.format(bean.getData().getSum_zw_byzf_zy_wu()));
        tv_sum_zq_qu_byzf_zy_zb.setText(df.format(bean.getData().getSum_zq_byzf_zy_zb()));
        tv_sum_zw_qu_buzf_zy_zb.setText(df.format( bean.getData().getSum_zw_byzf_zy_zb()));
        tv_zq_byzf_gk_sum.setText(df.format(bean.getData().getSum_zq_byzf_gk_gck()));
        tv_zw_byzf_gk_sum.setText(df.format(bean.getData().getSum_zw_byzf_gk_gck()));

        if (bean.getData().getZq_byzf_zy_wu() == bean.getData().getZw_byzf_zy_wu() && bean.getData().getZq_byzf_zy_zb() == bean.getData().getZw_byzf_zy_zb()
                && bean.getData().getZq_byzf_gk_gck() == bean.getData().getZw_byzf_gk_gck() && bean.getData().getSum_zq_byjy_zy_wu() == bean.getData().getSum_zw_byjy_zy_wu()
                && bean.getData().getSum_zq_byjy_zy_zb() == bean.getData().getSum_zw_byjy_zy_zb() && bean.getData().getSum_zq_byzf_gk_gck() == bean.getData().getSum_zw_byzf_gk_gck()) {

            image_zf_status.setBackground(getResources().getDrawable(R.mipmap.green));
            zfstatus=true;
        } else {
            image_zf_status.setBackground(getResources().getDrawable(R.mipmap.red));
            zfstatus=false;
        }
        Double zq_end_zy_wz=(bean.getData().getZq_qc_zy_wu() + bean.getData().getSum_zq_byjy_zy_wu() - bean.getData().getSum_zq_byzf_zy_wu());
            tv_zq_end_zy_wz.setText(df.format(zq_end_zy_wz));
        Double zw_end_zy_wz= (bean.getData().getZw_qc_zy_wu() + bean.getData().getSum_zw_byjy_zy_wu() - bean.getData().getSum_zw_byzf_zy_wu());
            tv_zw_end_zy_wz.setText(df.format(zw_end_zy_wz));
        Double zq_end_zy_zb=(bean.getData().getZq_qc_zy_zb() + bean.getData().getSum_zq_byjy_zy_zb() - bean.getData().getSum_zq_byzf_zy_zb());
            tv_zq_end_zy_zb.setText(df.format(zq_end_zy_zb));
        Double zw_end_zy_zb=(bean.getData().getZw_qc_zy_zb() + bean.getData().getSum_zw_byjy_zy_zb() - bean.getData().getSum_zw_byzf_zy_zb());
            tv_zw_end_zy_zb.setText(df.format(zw_end_zy_zb) );
            tv_zq_end_zgjy.setText(df.format(bean.getData().getZq_wd_zy_zgje()));
            tv_zw_end_zgjy.setText(df.format(bean.getData().getZw_wd_zy_zgje()));
            tv_zq_end_wd_zy.setText(df.format(bean.getData().getZq_wd_zy()));
            tv_zw_end_wd_zy.setText(df.format(bean.getData().getZw_wd_zy()));
        Double zq_end_zy_sum=zq_end_zy_wz+zq_end_zy_zb+bean.getData().getZq_wd_zy_zgje()+bean.getData().getZq_wd_zy();
            tv_zq_end_zy_sum.setText(df.format(zq_end_zy_sum) );
        Double zw_end_zy_sum= zw_end_zy_wz+zw_end_zy_zb+bean.getData().getZw_wd_zy_zgje()+bean.getData().getZw_wd_zy();
            tv_zw_end_zy_sum.setText(df.format(zw_end_zy_sum));
        Double zq_end_wd_sum=(bean.getData().getZq_qc_gk_gck() + bean.getData().getSum_zq_byjy_gk_gck() - bean.getData().getSum_zq_byzf_gk_gck());
            tv_zq_end_wd_sum.setText(df.format(zq_end_wd_sum));
        Double zw_end_wd_sum=(bean.getData().getZw_qc_gk_gck() + bean.getData().getSum_zw_byjy_gk_gck() - bean.getData().getSum_zw_byzf_gk_gck());
            tv_zw_end_wd_sum.setText(df.format(zw_end_wd_sum));
if (tv_zq_end_zy_wz.getText().toString().substring(1).equals(tv_zw_end_zy_wz.getText().toString().substring(1))&&
        tv_zq_end_zy_zb.getText().toString().substring(1).equals(tv_zw_end_zy_zb.getText().toString().substring(1))&&
        tv_zq_end_zgjy.getText().toString().substring(1).equals(tv_zw_end_zgjy.getText().toString().substring(1))&&
        tv_zq_end_wd_zy.getText().toString().substring(1).equals(tv_zw_end_wd_zy.getText().toString().substring(1))&&
        tv_zq_end_wd_sum.getText().toString().substring(1).equals(tv_zw_end_wd_sum.getText().toString().substring(1))){
    image_end_status.setBackground(getResources().getDrawable(R.mipmap.green));
}else {
    image_end_status.setBackground(getResources().getDrawable(R.mipmap.red));
}
        }

}
