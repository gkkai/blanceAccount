package com.example.kk.blanceaccount;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import adapter.AccountProjectListAdapter;
import adapter.AccountYearListAdapter;
import adapter.BaseViewHolder;
import base.BaseActivity;
import base.MyApplication;
import butterknife.Bind;
import model.bean.FindCompanyYearFinanceMouthBean;
import tools.ProxyUtils;
import widget.XListView;

public class AccountProjectListActivity extends BaseActivity {
    private AccountProjectListAdapter<FindCompanyYearFinanceMouthBean.FinanceMouthBean> Adapter;
    @Bind(R.id.listView)
    XListView listView;
    @Bind(R.id.rl_nodata)
    RelativeLayout rl_nodata;

    String mouth;
    String year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(R.layout.activity_account_project_list);

    }

    @Override
    protected void findWidgets() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");

        listView.setPullLoadEnable(false);
        listView.setPullRefreshEnable(false);
        mouth=String.valueOf(getIntent().getIntExtra("mouth",1));
        year=getIntent().getStringExtra("year");
        if(year==null){
            year=sdf.format(new java.util.Date());

        }
        Adapter = new AccountProjectListAdapter<FindCompanyYearFinanceMouthBean.FinanceMouthBean>(this, listView, R.layout.account_list_item) {
                @Override
                public void convert(BaseViewHolder helper, FindCompanyYearFinanceMouthBean.FinanceMouthBean item) {
                    if(0==item.getIsOK()){
                        //TODO 对账失败
                        Drawable drawable = getResources().getDrawable(R.mipmap.red);// 找到资源图片
                        //drawable.setBounds(left, top, right, bottom);
// 这一步必须要做，否则不会显示。
                        drawable.setBounds(0, 0, 50, 50);// 设置图片宽高
                        helper.getView(R.id.image_account_status).setBackground(drawable);

                        if(Integer.valueOf(item.getMonth())>=10){
                            helper.setText(R.id.tv_acconut_list_mouth,item.getMonth()+"月");
                        }else {
                            helper.setText(R.id.tv_acconut_list_mouth,item.getMonth().substring(1)+"月");
                        }
                        helper.setText(R.id.tv_acconut_list_company_a,item.getZqCompany());
                        helper.setText(R.id.tv_acconut_list_company_b,item.getZwCompany());

                    }else {
                        //TODO 变化颜色
                        Drawable drawable = getResources().getDrawable(R.mipmap.green);// 找到资源图片
                        //drawable.setBounds(left, top, right, bottom);
// 这一步必须要做，否则不会显示。
                        drawable.setBounds(0, 0, 50, 50);// 设置图片宽高
                        helper.getView(R.id.image_account_status).setBackground(drawable);// 设置到控件中
                        if(Integer.valueOf(item.getMonth())>=10){
                            helper.setText(R.id.tv_acconut_list_mouth,item.getMonth()+"月");
                        }else {
                            helper.setText(R.id.tv_acconut_list_mouth,item.getMonth().substring(1)+"月");
                        }

                        helper.setText(R.id.tv_acconut_list_company_a,item.getZqCompany());
                        helper.setText(R.id.tv_acconut_list_company_b,item.getZwCompany());

                    }


                }
            };





        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(AccountProjectListActivity.this, ProjectDetailsActivity.class);
                intent.putExtra("resultKey",Adapter.getItem(position-1).getResultKey());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initComponent() {

            //TODO 取得年份月份 对应公司及子公司下的所有对账信息
            if(getIntent().getIntExtra("mouth",1)>=10){
                ProxyUtils.GetHttpCheckProxy().findCompanyYearAndMonthFinance(this, String.valueOf(MyApplication.loginBean.getData().getCompanyId()),year,mouth);

            }else {
                ProxyUtils.GetHttpCheckProxy().findCompanyYearAndMonthFinance(this, String.valueOf(MyApplication.loginBean.getData().getCompanyId()), year, "0" + mouth);


                //ProxyUtils.GetHttpCheckProxy().companyNotOk(this, String.valueOf(MyApplication.loginBean.getData().getCompanyId()));

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
