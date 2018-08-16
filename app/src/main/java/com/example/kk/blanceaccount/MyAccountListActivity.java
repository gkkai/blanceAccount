package com.example.kk.blanceaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.test.suitebuilder.TestMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Iterator;

import adapter.AccountProjectListAdapter;
import adapter.BaseViewHolder;
import adapter.CompanytListAdapter;
import base.BaseActivity;
import base.MyApplication;
import butterknife.Bind;
import model.bean.CompanyBean;
import model.bean.FindCompanyYearFinanceMouthBean;
import model.bean.LoginBean;
import tools.ProxyUtils;
import widget.XListView;

public class MyAccountListActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.text_build_account)
    TextView build_account;
    private CompanytListAdapter<FindCompanyYearFinanceMouthBean.FinanceMouthBean> Adapter;
    @Bind(R.id.listView)
    XListView listView;
    @Bind(R.id.rl_nodata)
    RelativeLayout rl_nodata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(R.layout.activity_my_account_list);
    }

    @Override
    protected void findWidgets() {
        build_account.setOnClickListener(this);
        listView.setPullRefreshEnable(false);
        listView.setPullLoadEnable(false);
        Adapter=new CompanytListAdapter<FindCompanyYearFinanceMouthBean.FinanceMouthBean>(this,listView,R.layout.company_list_item) {
            @Override
            public void convert(BaseViewHolder helper, FindCompanyYearFinanceMouthBean.FinanceMouthBean item) {
                if(item.getZqCompany().equals(MyApplication.loginBean.getData().getSelfCompany().getCompanyName())){
                    helper.setText(R.id.tv_company_name,item.getYear()+"-"+item.getMonth()+"  "+item.getZwCompany());

                }else if(item.getZwCompany().equals(MyApplication.loginBean.getData().getSelfCompany().getCompanyName())){
                    helper.setText(R.id.tv_company_name,item.getYear()+"-"+item.getMonth()+"  "+item.getZqCompany());


                }

            }
        };
        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getBaseContext(),AccountCActivity.class);
                intent.putExtra("resultKey",Adapter.getItem(position-1).getResultKey());
                startActivity(intent);

            }
        });
    }

    @Override
    protected void initComponent() {


    }

    @Override
    protected void onResume() {
        super.onResume();
        ProxyUtils.GetHttpCheckProxy().companyNotOk(this, String.valueOf(MyApplication.loginBean.getData().getCompanyId()));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_build_account:
                Intent intent=new Intent(this,BuildAccountActivity.class);
                startActivity(intent);

                break;
        }
    }
    protected void companyNotOk(FindCompanyYearFinanceMouthBean bean) {
//        int louth=bean.getData().size();
//        for (int i=0;i<louth;i++){
//            if(bean.getData().get(i).getZqCompany().equals(MyApplication.loginBean.getData().getSelfCompany().getCompanyName())||
//                    bean.getData().get(i).getZwCompany().equals(MyApplication.loginBean.getData().getSelfCompany().getCompanyName())){
//
//            }else {
//                bean.getData().remove(i);
//
//            }
//        }
        Iterator<FindCompanyYearFinanceMouthBean.FinanceMouthBean> it = bean.getData().iterator();
        while(it.hasNext()){
            FindCompanyYearFinanceMouthBean.FinanceMouthBean x = it.next();
            if(MyApplication.loginBean.getData().getSelfCompany().getCompanyName().equals(x.getZqCompany())||MyApplication.loginBean.getData().getSelfCompany().getCompanyName().equals(x.getZwCompany())){

            }else {
                it.remove();
            }
        }
        if(bean.getData().size()==0){
            rl_nodata.setVisibility(View.VISIBLE);
        }else {
            rl_nodata.setVisibility(View.GONE);
        }
        Adapter.setDatas(bean.getData());


    }
}
