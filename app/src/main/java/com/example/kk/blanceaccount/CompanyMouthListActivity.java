package com.example.kk.blanceaccount;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import adapter.BaseViewHolder;
import adapter.CompanytListAdapter;
import base.BaseActivity;
import base.MyApplication;
import butterknife.Bind;
import fragmen.IndexFragment;
import model.bean.FindCompanyYearFinanceBean;
import model.bean.LoginBean;
import tools.ProxyUtils;
import widget.XListView;

public class CompanyMouthListActivity extends BaseActivity {
    @Bind(R.id.listView)
    XListView listView;
    @Bind(R.id.tv_title_train)
    TextView tv_title_train;
    @Bind(R.id.spinner_year)
    Spinner spinner_year;
    ArrayAdapter<String> sinpadapter;
    private List<String> yearBean=new ArrayList<>();
    String years;
    String companyId;
    private CompanytListAdapter<FindCompanyYearFinanceBean.FinanceBean> Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(R.layout.activity_company_mouth_list);
    }

    @Override
    protected void findWidgets() {
        listView.setPullRefreshEnable(false);
        listView.setPullLoadEnable(false);
        companyId=String.valueOf(getIntent().getIntExtra("companyId",1));
        Adapter=new CompanytListAdapter<FindCompanyYearFinanceBean.FinanceBean>(this,listView,R.layout.company_list_item) {
            @Override
            public void convert(BaseViewHolder helper, FindCompanyYearFinanceBean.FinanceBean item) {
                helper.setText(R.id.tv_company_name,item.getMonth()+"月");

            }
        };
        listView.setAdapter(Adapter);

                tv_title_train.setText(getIntent().getStringExtra("companyName"));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(CompanyMouthListActivity.this,MouthConpantyListActivity.class);
                intent.putExtra("mouth",Adapter.getItem(position-1).getMonth());
                intent.putExtra("years",years);
                intent.putExtra("companyId",companyId);
                intent.putExtra("companyName",getIntent().getStringExtra("companyName"));
                startActivity(intent);

            }
        });

    }

    @Override
    protected void initComponent() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
        String date=sdf.format(new java.util.Date());
        int year=Integer.valueOf(date);
        for(int i=0;i<4;i++){
            yearBean.add(i,String.valueOf(year-i));
        }
        sinpadapter = new ArrayAdapter<String>(this ,R.layout.spinner_item ,yearBean );
        //设置样式
        sinpadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_year.setAdapter(sinpadapter);

        spinner_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //TODO 查询数据类型
                years=sinpadapter.getItem(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Adapter.setDatas(MyApplication.findCompanyYearFinanceBean.getData());

    }
}
