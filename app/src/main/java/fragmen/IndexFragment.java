package fragmen;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.kk.blanceaccount.AccountProjectListActivity;
import com.example.kk.blanceaccount.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import adapter.AccountYearListAdapter;
import adapter.BaseViewHolder;
import base.BaseFragment;
import base.MyApplication;
import butterknife.Bind;
import model.bean.BannerBean;
import model.bean.FindCompanyYearFinanceBean;
import tools.ProxyUtils;
import widget.ImageCycleView;
import widget.MyGridView;
import widget.XListView;


public class IndexFragment extends BaseFragment {
    @Bind(R.id.icvView)
    ImageCycleView icvView;
    private AccountYearListAdapter<FindCompanyYearFinanceBean.FinanceBean> Adapter;
    @Bind(R.id.gridview)
    MyGridView myGridView;
    @Bind(R.id.spinner_year)
    Spinner spinner_year;

    @Bind(R.id.text_year)
    TextView text_year;
    ArrayAdapter<String> sinpadapter;
    private List<String> yearBean=new ArrayList<>();

    public IndexFragment() {
    }

    public static IndexFragment newInstance() {
        IndexFragment fragment = new IndexFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return createView(inflater.inflate(R.layout.fragment_index, container, false));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
    }


    @Override
    protected void findWidgets() {

        Adapter = new AccountYearListAdapter<FindCompanyYearFinanceBean.FinanceBean>(getActivity(), myGridView, R.layout.account_year_list) {
            @Override
            public void convert(BaseViewHolder helper, FindCompanyYearFinanceBean.FinanceBean item) {
                helper.setText(R.id.mouth, String.valueOf(item.getMonth())+"月");
                if(0==item.getHasResult()){
                    //TODO 没有账单核对
//TODO 变化颜色
                    Drawable drawable = getResources().getDrawable(R.mipmap.oval1);// 找到资源图片
                    //drawable.setBounds(left, top, right, bottom);
// 这一步必须要做，否则不会显示。
                    drawable.setBounds(0, 0, 60, 60);// 设置图片宽高
                    ((TextView) helper.getView(R.id.mouth)).setCompoundDrawables(drawable, null, null, null);// 设置到控件中


                }else {
                    if(0==item.getResult()){
                        //TODO 变化颜色
                        Drawable drawable = getResources().getDrawable(R.mipmap.red1);// 找到资源图片
                        //drawable.setBounds(left, top, right, bottom);
// 这一步必须要做，否则不会显示。
                        drawable.setBounds(0, 0, 60, 60);// 设置图片宽高
                        ((TextView) helper.getView(R.id.mouth)).setCompoundDrawables(drawable, null, null, null);// 设置到控件中

                    }else {
                        //TODO 变化颜色
                        Drawable drawable = getResources().getDrawable(R.mipmap.green1);// 找到资源图片
                        //drawable.setBounds(left, top, right, bottom);
// 这一步必须要做，否则不会显示。
                        drawable.setBounds(0, 0, 60, 60);// 设置图片宽高
                        ((TextView) helper.getView(R.id.mouth)).setCompoundDrawables(drawable, null, null, null);// 设置到控件中

                    }
                }


            }
        };
        //myGridView.addHeaderView(headView, null, false);
        myGridView.setAdapter(Adapter);


        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                Intent intent =new Intent(getActivity(), AccountProjectListActivity.class);
                                                intent.putExtra("mouth",Adapter.getItem(position).getMonth());
                                                intent.putExtra("year",text_year.getText().toString());
                                                startActivity(intent);
                                            }
                                        }

        );

    }

    @Override
    protected void initComponent() {

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
        String date=sdf.format(new java.util.Date());
        text_year.setText(date);
        int year=Integer.valueOf(date);
        for(int i=0;i<4;i++){
            yearBean.add(i,String.valueOf(year-i));
        }
        sinpadapter = new ArrayAdapter<String>(getActivity() ,R.layout.index_spinner_item ,yearBean );
        //设置样式
        sinpadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_year.setAdapter(sinpadapter);

        spinner_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //TODO 查询数据类型

                text_year.setText(sinpadapter.getItem(i));
                ProxyUtils.GetHttpCheckProxy().findCompanyYearFinance(IndexFragment.this, String.valueOf(MyApplication.loginBean.getData().getCompanyId()),text_year.getText().toString().trim());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        //ProxyUtils.getHttpProxyNoDialog().indexslideshow(this);
        //TODO 查询当前公司及所有子公司每个月对账的结果
        ProxyUtils.GetHttpCheckProxy().findCompanyYearFinance(this, String.valueOf(MyApplication.loginBean.getData().getCompanyId()),text_year.getText().toString().trim());

    }

    protected void indexslideshow(BannerBean bean) {
        icvView.setImageResources(bean.getData(), imageCycleListener);

    }
    protected void findCompanyYearFinance(FindCompanyYearFinanceBean bean) {

        MyApplication.findCompanyYearFinanceBean =bean;

        Adapter.setDatas(bean.getData());
    }

    ImageCycleView.ImageCycleViewListener imageCycleListener = new ImageCycleView.ImageCycleViewListener() {
        int id = 0;

        @Override
        public void displayImage(final String imageURL, ImageView imageView) {

            ImageLoader.getInstance().displayImage(imageURL, imageView);

//            imageView.setImageResource(R.mipmap.test_index_pic);
        }

        @Override
        public void onImageClick(int position, View imageView) {


        }
    };

}
