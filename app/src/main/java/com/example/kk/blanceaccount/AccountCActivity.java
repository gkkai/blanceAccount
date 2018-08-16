package com.example.kk.blanceaccount;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import base.BaseActivity;
import base.MyApplication;
import butterknife.Bind;
import model.bean.AddZqBean;
import model.bean.FindFinanceBean;
import tools.ProxyUtils;

public class AccountCActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.text_bianji)
    TextView text_bianji;
    @Bind(R.id.text_comepany_name)
    TextView text_comepany_name;
    @Bind(R.id.text_type)
    TextView text_type;
    @Bind(R.id.text_time)
    TextView text_time;
    @Bind(R.id.text_qu_zy_wu)
    TextView text_qu_zy_wu;
    @Bind(R.id.text_qu_zy_zb)
    TextView text_qu_zy_zb;
    @Bind(R.id.text_qu_gk_gck)
    TextView text_qu_gk_gck;
    @Bind(R.id.text_qu_sum)
    TextView text_qu_sum;

    @Bind(R.id.text_byjy_zy_wu)
    TextView text_byjy_zy_wu;
    @Bind(R.id.text_byjy_zy_zb)
    TextView text_byjy_zy_zb;
    @Bind(R.id.text_byjy_gk_gck)
    TextView text_byjy_gk_gck;

    @Bind(R.id.text_byjy_sum)
    TextView text_byjy_sum;
    @Bind(R.id.text_byzf_zy_wu)
    TextView text_byzf_zy_wu;
    @Bind(R.id.text_byzf_zy_zb)
    TextView text_byzf_zy_zb;
    @Bind(R.id.text_byzf_gk_gck)
    TextView text_byzf_gk_gck;
    @Bind(R.id.text_byzf_sum)
    TextView text_byzf_sum;
    @Bind(R.id.text_zy_wd)
    TextView text_zy_wd;
    @Bind(R.id.text_zy_wd_zgjy)
    TextView text_zy_wd_zgjy;
    @Bind(R.id.text_gk_wd)
    TextView text_gk_wd;
    @Bind(R.id.text_gk_wd_zgje)
    TextView text_gk_wd_zgje;
    @Bind(R.id.text_wd_sum)
    TextView text_wd_sum;

    private Dialog dialog;
    private View inflate;
    private FindFinanceBean bean;
    DecimalFormat df = new DecimalFormat("###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(R.layout.activity_account_c);
    }

    @Override
    protected void findWidgets() {
        text_bianji.setOnClickListener(this);

    }

    @Override
    protected void initComponent() {
        //TODO 查询账务详情
        ProxyUtils.GetHttpCheckProxy().findFinance(this,getIntent().getStringExtra("resultKey"));


    }
    protected void findFinance(FindFinanceBean bean){
        this.bean=bean;
        if(bean.getData().getZq_company_name()!=null){
            if(bean.getData().getZq_company_name().equals(MyApplication.loginBean.getData().getSelfCompany().getCompanyName())){
                    text_comepany_name.setText(bean.getData().getZq_dz_company_name());
                    text_type.setText("债权");
                text_time.setText(bean.getData().getZq_year()+"-"+bean.getData().getZq_month());
                text_qu_zy_wu.setText("¥"+df.format(bean.getData().getZq_qc_zy_wu()));
                text_qu_zy_zb.setText("¥"+df.format(bean.getData().getZq_qc_zy_zb()));
                text_qu_gk_gck.setText("¥"+df.format(bean.getData().getZq_qc_gk_gck()));
                Double qc=bean.getData().getZq_qc_zy_wu()+bean.getData().getZq_qc_gk_gck()+bean.getData().getZq_qc_zy_zb();

                text_qu_sum.setText("¥"+df.format(qc));
                text_byjy_zy_wu.setText("¥"+df.format(bean.getData().getZq_byjy_zy_wu()));
                text_byjy_zy_zb.setText("¥"+df.format(bean.getData().getZq_byjy_zy_zb()));
                text_byjy_gk_gck.setText("¥"+df.format(bean.getData().getZq_byjy_gk_gck()));
                Double byjy=bean.getData().getZq_byjy_zy_wu()+bean.getData().getZq_byjy_zy_zb()+bean.getData().getZq_byjy_gk_gck();
                text_byjy_sum.setText("¥"+df.format(byjy));
                text_byzf_zy_wu.setText("¥"+df.format(bean.getData().getZq_byzf_zy_wu()));
                text_byzf_zy_zb.setText("¥"+df.format(bean.getData().getZq_byzf_zy_zb()));
                text_byzf_gk_gck.setText("¥"+df.format(bean.getData().getZq_byzf_gk_gck()));
                Double zf=bean.getData().getZq_byzf_zy_wu()+bean.getData().getZq_byzf_zy_zb()+bean.getData().getZq_byzf_gk_gck();
                text_byzf_sum.setText("¥"+df.format(zf));
                text_zy_wd.setText("¥"+df.format(bean.getData().getZq_wd_zy()));
                text_zy_wd_zgjy.setText("¥"+df.format(bean.getData().getZq_wd_zy_zgje()));
                text_gk_wd.setText("¥"+df.format(bean.getData().getZq_wd_gk()));
                text_gk_wd_zgje.setText("¥"+df.format(bean.getData().getZq_wd_gk_zgje()));
                Double wd=bean.getData().getZq_wd_zy()+bean.getData().getZq_wd_zy_zgje()+bean.getData().getZq_wd_gk()+bean.getData().getZq_wd_gk_zgje();
                text_wd_sum.setText("¥"+df.format(wd));
            }else {
                text_comepany_name.setText(bean.getData().getZw_dz_company_name());
                text_type.setText("债务");
                text_time.setText(bean.getData().getZw_year()+"-"+bean.getData().getZw_month());
                text_qu_zy_wu.setText("¥"+df.format(bean.getData().getZw_qc_zy_wu()));
                text_qu_zy_zb.setText("¥"+df.format(bean.getData().getZw_qc_zy_zb()));
                text_qu_gk_gck.setText("¥"+df.format(bean.getData().getZw_qc_gk_gck()));
                Double qc=bean.getData().getZw_qc_zy_wu()+bean.getData().getZw_qc_gk_gck()+bean.getData().getZw_qc_zy_zb();
                text_qu_sum.setText("¥"+df.format(qc));
                text_byjy_zy_wu.setText("¥"+df.format(bean.getData().getZw_byjy_zy_wu()));
                text_byjy_zy_zb.setText("¥"+df.format(bean.getData().getZw_byjy_zy_zb()));
                text_byjy_gk_gck.setText("¥"+df.format(bean.getData().getZw_byjy_gk_gck()));
                Double byjy=bean.getData().getZw_byjy_zy_wu()+bean.getData().getZw_byjy_zy_zb()+bean.getData().getZw_byjy_gk_gck();
                text_byjy_sum.setText("¥"+df.format(byjy));
                text_byzf_zy_wu.setText("¥"+df.format(bean.getData().getZw_byzf_zy_wu()));
                text_byzf_zy_zb.setText("¥"+df.format(bean.getData().getZw_byzf_zy_zb()));
                text_byzf_gk_gck.setText("¥"+df.format(bean.getData().getZw_byzf_gk_gck()));
                Double zf=bean.getData().getZw_byzf_zy_wu()+bean.getData().getZw_byzf_zy_zb()+bean.getData().getZw_byzf_gk_gck();
                text_byzf_sum.setText("¥"+df.format(zf));
                text_zy_wd.setText("¥"+df.format(bean.getData().getZw_wd_zy()));
                text_zy_wd_zgjy.setText("¥"+df.format(bean.getData().getZw_wd_zy_zgje()));
                text_gk_wd.setText("¥"+df.format(bean.getData().getZw_wd_gk()));
                text_gk_wd_zgje.setText("¥"+df.format(bean.getData().getZw_wd_gk_zgje()));
                Double wd=bean.getData().getZw_wd_zy()+bean.getData().getZw_wd_zy_zgje()+bean.getData().getZw_wd_gk()+bean.getData().getZw_wd_gk_zgje();
                text_wd_sum.setText("¥"+df.format(wd));
            }

        }else {
            if(bean.getData().getZw_company_name().equals(MyApplication.loginBean.getData().getSelfCompany().getCompanyName())){
                text_comepany_name.setText(bean.getData().getZw_dz_company_name());
                text_type.setText("债务");
                text_time.setText(bean.getData().getZw_year()+"-"+bean.getData().getZw_month());
                text_qu_zy_wu.setText("¥"+df.format(bean.getData().getZw_qc_zy_wu()));
                text_qu_zy_zb.setText("¥"+df.format(bean.getData().getZw_qc_zy_zb()));
                text_qu_gk_gck.setText("¥"+df.format(bean.getData().getZw_qc_gk_gck()));
                Double qc=bean.getData().getZw_qc_zy_wu()+bean.getData().getZw_qc_gk_gck()+bean.getData().getZw_qc_zy_zb();
                text_qu_sum.setText("¥"+df.format(qc));
                text_byjy_zy_wu.setText("¥"+df.format(bean.getData().getZw_byjy_zy_wu()));
                text_byjy_zy_zb.setText("¥"+df.format(bean.getData().getZw_byjy_zy_zb()));
                text_byjy_gk_gck.setText("¥"+df.format(bean.getData().getZw_byjy_gk_gck()));
                Double byjy=bean.getData().getZw_byjy_zy_wu()+bean.getData().getZw_byjy_zy_zb()+bean.getData().getZw_byjy_gk_gck();
                text_byjy_sum.setText("¥"+df.format(byjy));
                text_byzf_zy_wu.setText("¥"+df.format(bean.getData().getZw_byzf_zy_wu()));
                text_byzf_zy_zb.setText("¥"+df.format(bean.getData().getZw_byzf_zy_zb()));
                text_byzf_gk_gck.setText("¥"+df.format(bean.getData().getZw_byzf_gk_gck()));
                Double zf=bean.getData().getZw_byzf_zy_wu()+bean.getData().getZw_byzf_zy_zb()+bean.getData().getZw_byzf_gk_gck();
                text_byzf_sum.setText("¥"+df.format(zf));
                text_zy_wd.setText("¥"+df.format(bean.getData().getZw_wd_zy()));
                text_zy_wd_zgjy.setText("¥"+df.format(bean.getData().getZw_wd_zy_zgje()));
                text_gk_wd.setText("¥"+bean.getData().getZw_wd_gk());
                text_gk_wd_zgje.setText("¥"+df.format(bean.getData().getZw_wd_gk_zgje()));
                Double wd=bean.getData().getZw_wd_zy()+bean.getData().getZw_wd_zy_zgje()+bean.getData().getZw_wd_gk()+bean.getData().getZw_wd_gk_zgje();
                text_wd_sum.setText("¥"+df.format(wd));
            }else {
                text_comepany_name.setText(bean.getData().getZq_dz_company_name());
                text_type.setText("债权");
                text_time.setText(bean.getData().getZq_year()+"-"+bean.getData().getZq_month());
                text_qu_zy_wu.setText("¥"+df.format(bean.getData().getZq_qc_zy_wu()));
                text_qu_zy_zb.setText("¥"+df.format(bean.getData().getZq_qc_zy_zb()));
                text_qu_gk_gck.setText("¥"+df.format(bean.getData().getZq_qc_gk_gck()));
                Double qc=bean.getData().getZq_qc_zy_wu()+bean.getData().getZq_qc_gk_gck()+bean.getData().getZq_qc_zy_zb();

                text_qu_sum.setText("¥"+df.format(qc));
                text_byjy_zy_wu.setText("¥"+df.format(bean.getData().getZq_byjy_zy_wu()));
                text_byjy_zy_zb.setText("¥"+df.format(bean.getData().getZq_byjy_zy_zb()));
                text_byjy_gk_gck.setText("¥"+df.format(bean.getData().getZq_byjy_gk_gck()));
                Double byjy=bean.getData().getZq_byjy_zy_wu()+bean.getData().getZq_byjy_zy_zb()+bean.getData().getZq_byjy_gk_gck();
                text_byjy_sum.setText("¥"+df.format(byjy));
                text_byzf_zy_wu.setText("¥"+df.format(bean.getData().getZq_byzf_zy_wu()));
                text_byzf_zy_zb.setText("¥"+df.format(bean.getData().getZq_byzf_zy_zb()));
                text_byzf_gk_gck.setText("¥"+df.format(bean.getData().getZq_byzf_gk_gck()));
                Double zf=bean.getData().getZq_byzf_zy_wu()+bean.getData().getZq_byzf_zy_zb()+bean.getData().getZq_byzf_gk_gck();
                text_byzf_sum.setText("¥"+df.format(zf));
                text_zy_wd.setText("¥"+df.format(bean.getData().getZq_wd_zy()));
                text_zy_wd_zgjy.setText("¥"+df.format(bean.getData().getZq_wd_zy_zgje()));
                text_gk_wd.setText("¥"+df.format(bean.getData().getZq_wd_gk()));
                text_gk_wd_zgje.setText("¥"+df.format(bean.getData().getZq_wd_gk_zgje()));
                Double wd=bean.getData().getZq_wd_zy()+bean.getData().getZq_wd_zy_zgje()+bean.getData().getZq_wd_gk()+bean.getData().getZq_wd_gk_zgje();
                text_wd_sum.setText("¥"+df.format(wd));
            }


        }



    }
protected void delete(AddZqBean bean){
    Toast.makeText(this,"删除成功",Toast.LENGTH_SHORT).show();
    finish();
}
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_bianji:
                shownavigation();
                break;
            case R.id.text_xiugai:



                if("债权".equals(text_type.getText().toString().trim())){
                    Intent intent=new Intent(getBaseContext(),BuildAccountActivity.class);
                    intent.putExtra("zq_id",bean.getData().getZq_id());
                    intent.putExtra("type","债权");
                    intent.putExtra("resultKey",getIntent().getStringExtra("resultKey"));
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent=new Intent(getBaseContext(),BuildAccountActivity.class);
                    intent.putExtra("resultKey",getIntent().getStringExtra("resultKey"));
                    intent.putExtra("zw_id",bean.getData().getZw_id());
                    intent.putExtra("type","债务");
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.text_delete:
                //TODO 删除
                if("债权".equals(text_type.getText().toString().trim())){
                    ProxyUtils.GetHttpCheckProxy().delete(this,bean.getData().getZq_id(),0);
                }else {
                    ProxyUtils.GetHttpCheckProxy().delete(this,bean.getData().getZw_id(),1);
                }

                break;
            case R.id.text_quxiao:
                dialog.dismiss();
                break;
        }
    }
    public void shownavigation() {
        inflate = LayoutInflater.from(this).inflate(R.layout.bianji_dialog_layout, null);
        TextView xiugai=inflate.findViewById(R.id.text_xiugai);
        TextView delete=inflate.findViewById(R.id.text_delete);
        TextView quxiao=inflate.findViewById(R.id.text_quxiao);
        xiugai.setOnClickListener(this);
        delete.setOnClickListener(this);
        quxiao.setOnClickListener(this);
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
        lp.y = 30;//设置Dialog距离底部的距离
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();//显示对话框
    }
}
