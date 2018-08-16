package com.example.kk.blanceaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.Iterator;

import adapter.BaseViewHolder;
import adapter.CompanytListAdapter;
import base.BaseActivity;
import base.MyApplication;
import butterknife.Bind;
import model.bean.CompanyBean;
import model.bean.LoginBean;
import tools.ProxyUtils;
import widget.XListView;

public class CompanyListActivity extends BaseActivity {
    @Bind(R.id.listView)
    XListView listView;
    private CompanytListAdapter<LoginBean.LoginBeanData.ChildCompanys> Adapter;
    private CompanytListAdapter<CompanyBean.CompanyBeanData> AdapterBuild;
    private String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(R.layout.activity_company_list);
    }

    @Override
    protected void findWidgets() {
        type=getIntent().getStringExtra("type");
        listView.setPullLoadEnable(false);
        listView.setPullRefreshEnable(false);
        if("mine".equals(type)){
            Adapter=new CompanytListAdapter<LoginBean.LoginBeanData.ChildCompanys>(this,listView,R.layout.company_list_item) {
                @Override
                public void convert(BaseViewHolder helper, LoginBean.LoginBeanData.ChildCompanys item) {
                    helper.setText(R.id.tv_company_name,item.getCompanyName());

                }
            };
            listView.setAdapter(Adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   int companyId =Adapter.getItem(position-1).getId();
                    Intent intent=new Intent(CompanyListActivity.this,CompanyMouthListActivity.class);
                    intent.putExtra("companyName",Adapter.getItem(position-1).getCompanyName());
                    intent.putExtra("companyId",companyId);
                    startActivity(intent);
                }
            });
        }else {
            AdapterBuild=new CompanytListAdapter<CompanyBean.CompanyBeanData>(this,listView,R.layout.company_list_item) {
                @Override
                public void convert(BaseViewHolder helper, CompanyBean.CompanyBeanData item) {
                    helper.setText(R.id.tv_company_name,item.getCompanyName());
                    helper.showOrHideView(R.id.image,false);

                }
            };
            listView.setAdapter(AdapterBuild);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent mIntent = new Intent();
                    mIntent.putExtra("id",AdapterBuild.getItem(position-1).getId());
                    mIntent.putExtra("CompanyName",AdapterBuild.getItem(position-1).getCompanyName());
                    // 设置结果，并进行传送
                    setResult(102, mIntent);
                    finish();
                }
            });

        }



    }

    @Override
    protected void initComponent() {
        if("mine".equals(type)){
            Adapter.setDatas(MyApplication.loginBean.getData().getChildCompanys());
        }else {
            //TODO 查询公司下的所有子公司
            ProxyUtils.GetHttpCheckProxy().findChildsCompany(this,"1");
        }



    }
    protected void findChildsCompany(CompanyBean bean){
        Iterator<CompanyBean.CompanyBeanData> it = bean.getData().iterator();
        while(it.hasNext()){
            CompanyBean.CompanyBeanData x = it.next();
            if(MyApplication.loginBean.getData().getSelfCompany().getCompanyName().equals(x.getCompanyName())){
                it.remove();
            }
        }

        AdapterBuild.setDatas(bean.getData());
    }
}
