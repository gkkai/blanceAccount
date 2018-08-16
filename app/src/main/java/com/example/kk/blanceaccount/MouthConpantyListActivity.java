package com.example.kk.blanceaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import adapter.BaseViewHolder;
import adapter.CompanytListAdapter;
import base.BaseActivity;
import base.MyApplication;
import butterknife.Bind;
import model.bean.FindCompanyYearFinanceBean;
import model.bean.FindCompanyYearFinanceMouthBean;
import tools.ProxyUtils;
import widget.XListView;

public class MouthConpantyListActivity extends BaseActivity {
    @Bind(R.id.listView)
    XListView listView;
    @Bind(R.id.tv_title_train)
    TextView tv_title_train;
    String mouth;
    String years;
    String companyId;
    @Bind(R.id.rl_nodata)
    RelativeLayout rl_nodata;
    private CompanytListAdapter<FindCompanyYearFinanceMouthBean.FinanceMouthBean> Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(R.layout.activity_mouth_conpanty_list);
    }

    @Override
    protected void findWidgets() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
        companyId=getIntent().getStringExtra("companyId");
        mouth=String.valueOf(getIntent().getIntExtra("mouth",1));
        years=getIntent().getStringExtra("years");
        if(years==null){
            years=sdf.format(new java.util.Date());
        }
        tv_title_train.setText(getIntent().getStringExtra("companyName")+mouth+"月");
        listView.setPullRefreshEnable(false);
        listView.setPullLoadEnable(false);
        Adapter=new CompanytListAdapter<FindCompanyYearFinanceMouthBean.FinanceMouthBean>(this,listView,R.layout.company_list_item) {
            @Override
            public void convert(BaseViewHolder helper, FindCompanyYearFinanceMouthBean.FinanceMouthBean item) {
                if(item.getZqCompany().equals(getIntent().getStringExtra("companyName"))){
                    helper.setText(R.id.tv_company_name,item.getZwCompany());
                }
                if(item.getZwCompany().equals(getIntent().getStringExtra("companyName"))){
                    helper.setText(R.id.tv_company_name,item.getZqCompany());
                }


            }
        };
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO 查询账目详情
                Intent intent=new Intent(MouthConpantyListActivity.this,AccountDetailBActivity.class);
                intent.putExtra("resultKey",Adapter.getItem(position-1).getResultKey());
                startActivity(intent);

            }
        });
    }

    @Override
    protected void initComponent() {
        if(getIntent().getIntExtra("mouth",1)>=10){
            ProxyUtils.GetHttpCheckProxy().findCompanyYearAndMonthFinance(this, companyId,years,mouth);

        }else {
            ProxyUtils.GetHttpCheckProxy().findCompanyYearAndMonthFinance(this, companyId,years,"0"+mouth);

        }

    }
    protected void findCompanyYearAndMonthFinance(FindCompanyYearFinanceMouthBean bean) {
        Adapter.setDatas(bean.getData());
        if(bean.getData().size()==0){
            rl_nodata.setVisibility(View.VISIBLE);
        }else {
            rl_nodata.setVisibility(View.GONE);
        }

    }
}
