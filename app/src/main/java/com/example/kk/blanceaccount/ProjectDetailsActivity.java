package com.example.kk.blanceaccount;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import base.BaseActivity;
import base.MyApplication;
import butterknife.Bind;
import fragmen.BalanceFragment;
import fragmen.EndBalanceFragment;
import fragmen.IncomeAmountFragment;
import fragmen.IndexFragment;
import fragmen.MineFragment;
import fragmen.TransactionAmountFragment;
import model.bean.FindFinanceBean;
import tools.ProxyUtils;

import static config.Constant.END;
import static config.Constant.INCOM;
import static config.Constant.INDEX;
import static config.Constant.Mine;
import static config.Constant.START;
import static config.Constant.TRANSA;

public class ProjectDetailsActivity extends BaseActivity {
    private FragmentTabHost mTabHost;
    public FindFinanceBean bean;

    @Bind(R.id.imave_account_status)
    ImageView imave_account_status;
    @Bind(R.id.tv_account_status)
    TextView tv_account_status;
    @Bind(R.id.text_zq)
    TextView text_zq;
    @Bind(R.id.text_zw)
    TextView text_zw;
    public  String zq,zw;
    Bundle savedInstanceState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(R.layout.activity_project_details);
        this.savedInstanceState=savedInstanceState;

    }

    @Override
    protected void findWidgets() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
    }

    @Override
    protected void initComponent() {
//TODO 查询账务详情
        ProxyUtils.GetHttpCheckProxy().findFinance(this,getIntent().getStringExtra("resultKey"));

    }
    protected void findFinance(FindFinanceBean bean){
        this.bean=bean;
        MyApplication.findFinanceBean=bean;
        initTabHost();


        if(bean.getData().getZq_is_ok()==1&&bean.getData().getZw_is_ok()==1){
            tv_account_status.setText("对账成功");
            tv_account_status.setTextColor(Color.parseColor("#46C472"));
            imave_account_status.setBackground(getResources().getDrawable(R.mipmap.success));
        }else {
            tv_account_status.setText("对账失败");
            tv_account_status.setTextColor(Color.parseColor("#F45555"));

            imave_account_status.setBackground(getResources().getDrawable(R.mipmap.file));
        }
        if(bean.getData().getZq_company_name()==null){
            text_zw.setText(bean.getData().getZw_company_name());
            text_zq.setText(bean.getData().getZw_dz_company_name());
        }else {
            text_zq.setText(bean.getData().getZq_company_name());
            text_zw.setText(bean.getData().getZq_dz_company_name());
        }

    }
    private void initTabHost() {
        if(savedInstanceState==null) {
            mTabHost.setup(this, getSupportFragmentManager(), R.id.main_realabcontent);

            mTabHost.addTab(mTabHost.newTabSpec(START).setIndicator(createIndicatorView1(R.drawable.selector_start_balance, R.string.stringblanc)), BalanceFragment.class, new Bundle());
            mTabHost.addTab(mTabHost.newTabSpec(TRANSA).setIndicator(createIndicatorView(R.drawable.selector_transaction, R.string.stringtrancaion)), TransactionAmountFragment.class, new Bundle());

            mTabHost.addTab(mTabHost.newTabSpec(INCOM).setIndicator(createIndicatorView(R.drawable.selector_income_amount, R.string.stringincome)), IncomeAmountFragment.class, new Bundle());
            mTabHost.addTab(mTabHost.newTabSpec(END).setIndicator(createIndicatorView(R.drawable.selector_end_balance, R.string.stringendblance)), EndBalanceFragment.class, new Bundle());
            mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        }
    }
    private View createIndicatorView(int selectorRes, int finddesigner) {

        View view = getLayoutInflater().inflate(R.layout.account_details_, null);
        ImageView iv = (ImageView) view.findViewById(R.id.ivTab);
        iv.setImageResource(selectorRes);
        TextView tvTabText = (TextView) view.findViewById(R.id.tvTabText);
        tvTabText.setText(finddesigner);
        return view;
    }
    private View createIndicatorView1(int selectorRes, int finddesigner) {

        View view = getLayoutInflater().inflate(R.layout.account_details, null);
        ImageView iv = (ImageView) view.findViewById(R.id.ivTab);
        iv.setImageResource(selectorRes);
        TextView tvTabText = (TextView) view.findViewById(R.id.tvTabText);
        tvTabText.setText(finddesigner);
        return view;
    }
}
