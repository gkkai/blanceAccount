package fragmen;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kk.blanceaccount.R;

import java.text.DecimalFormat;

import base.BaseFragment;
import base.MyApplication;
import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class EndBalanceFragment extends BaseFragment {

    @Bind(R.id.tv_end_zq_zy_wu)
    TextView tv_end_zq_zy_wu;
    @Bind(R.id.tv_end_zw_zy_wu)
    TextView tv_end_zw_zy_wu;
    @Bind(R.id.tv_end_zq_zy_zb)
    TextView tv_end_zq_zy_zb;
    @Bind(R.id.tv_end_zw_zy_zb)
    TextView tv_end_zw_zy_zb;
    @Bind(R.id.tv_zq_wd_zy_zgje)
    TextView tv_zq_wd_zy_zgje;
    @Bind(R.id.tv_zw_wd_zy_zgje)
    TextView tv_zw_wd_zy_zgje;
    @Bind(R.id.tv_zq_wd_zy)
    TextView tv_zq_wd_zy;
    @Bind(R.id.tv_zw_wd_zy)
    TextView tv_zw_wd_zy;
    @Bind(R.id.tv_zq_end_zy_sum)
    TextView tv_zq_end_zy_sum;
    @Bind(R.id.tv_zw_end_zy_sum)
    TextView tv_zw_end_zy_sum;
    DecimalFormat df = new DecimalFormat("###,##0.00");
    @Bind(R.id.tv_zq_end_sum_gk)
    TextView tv_zq_end_sum_gk;
    @Bind(R.id.tv_zw_end_sum_gk)
    TextView tv_zw_end_sum_gk;
    @Bind(R.id.text_zy)
    TextView text_zy;
    @Bind(R.id.text_gk)
    TextView text_gk;
    @Bind(R.id.text_zq_)
    TextView text_zq_;
    @Bind(R.id.text_zw_)
    TextView text_zw_;
    @Bind(R.id.text_sm_zq)
    TextView text_sm_zq;
    @Bind(R.id.text_sm_zw)
    TextView text_sm_zw;

    public EndBalanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return createView(inflater.inflate(R.layout.fragment_end_balance, container, false));
    }

    @Override
    protected void findWidgets() {
        Drawable drawable = getResources().getDrawable(R.mipmap.green);// 找到资源图片
        Drawable drawable1 = getResources().getDrawable(R.mipmap.red);// 找到资源图片
        Double end_zq_zy_wu=MyApplication.findFinanceBean.getData().getZq_qc_zy_wu()+MyApplication.findFinanceBean.getData().getSum_zq_byjy_zy_wu()
                -MyApplication.findFinanceBean.getData().getSum_zq_byzf_zy_wu();
        tv_end_zq_zy_wu.setText(df.format(end_zq_zy_wu));
        Double zq_zy_wu=MyApplication.findFinanceBean.getData().getZw_qc_zy_wu()+MyApplication.findFinanceBean.getData().getSum_zw_byjy_zy_wu()
                -MyApplication.findFinanceBean.getData().getSum_zw_byzf_zy_wu();
        tv_end_zw_zy_wu.setText(df.format(zq_zy_wu));
        Double end_zq_zy_zb=MyApplication.findFinanceBean.getData().getZq_qc_zy_zb()+MyApplication.findFinanceBean.getData().getSum_zq_byjy_zy_zb()
                -MyApplication.findFinanceBean.getData().getSum_zq_byzf_zy_zb();
        tv_end_zq_zy_zb.setText(df.format(end_zq_zy_zb));
        Double end_zw_zy_zb=MyApplication.findFinanceBean.getData().getZw_qc_zy_zb()+MyApplication.findFinanceBean.getData().getSum_zw_byjy_zy_zb()
                -MyApplication.findFinanceBean.getData().getSum_zw_byzf_zy_zb();
        tv_end_zw_zy_zb.setText(df.format(end_zw_zy_zb));
        tv_zq_wd_zy_zgje.setText(df.format(MyApplication.findFinanceBean.getData().getZq_wd_zy_zgje()));
        tv_zw_wd_zy_zgje.setText(df.format(MyApplication.findFinanceBean.getData().getZw_wd_zy_zgje()));
        tv_zq_wd_zy.setText(df.format(MyApplication.findFinanceBean.getData().getZq_wd_zy()));
        tv_zw_wd_zy.setText(df.format(MyApplication.findFinanceBean.getData().getZw_wd_zy()));
        if(tv_end_zq_zy_wu.getText().equals(tv_end_zw_zy_wu.getText())&&tv_end_zq_zy_zb.getText().equals(tv_end_zw_zy_zb.getText())
                &&tv_zq_wd_zy_zgje.getText().equals(tv_zw_wd_zy_zgje.getText())&&tv_zq_wd_zy.getText().equals(tv_zw_wd_zy.getText())){
            drawable.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_zy.setCompoundDrawables(null, null, drawable, null);// 设置到控件中
        }else {
            drawable1.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_zy.setCompoundDrawables(null, null, drawable1, null);// 设置到控件中
        }
        Double zq_end_zy_sum=MyApplication.findFinanceBean.getData().getZq_qc_zy_wu()+MyApplication.findFinanceBean.getData().getSum_zq_byjy_zy_wu()
                -MyApplication.findFinanceBean.getData().getSum_zq_byzf_zy_wu()+MyApplication.findFinanceBean.getData().getZq_qc_zy_zb()+MyApplication.findFinanceBean.getData().getSum_zq_byjy_zy_zb()
                -MyApplication.findFinanceBean.getData().getSum_zq_byzf_zy_zb()+MyApplication.findFinanceBean.getData().getZq_wd_zy_zgje()
                +MyApplication.findFinanceBean.getData().getZq_wd_zy();
        tv_zq_end_zy_sum.setText(df.format(zq_end_zy_sum));
        Double zw_end_zy_sum=MyApplication.findFinanceBean.getData().getZw_qc_zy_wu()+MyApplication.findFinanceBean.getData().getSum_zw_byjy_zy_wu()
                -MyApplication.findFinanceBean.getData().getSum_zw_byzf_zy_wu()+MyApplication.findFinanceBean.getData().getZw_qc_zy_zb()+MyApplication.findFinanceBean.getData().getSum_zw_byjy_zy_zb()
                -MyApplication.findFinanceBean.getData().getSum_zw_byzf_zy_zb() +MyApplication.findFinanceBean.getData().getZw_wd_zy_zgje()+MyApplication.findFinanceBean.getData().getZw_wd_zy();
        tv_zw_end_zy_sum.setText(df.format(zw_end_zy_sum));
        Double zq_end_sum_gk=MyApplication.findFinanceBean.getData().getZq_qc_gk_gck()+MyApplication.findFinanceBean.getData().getSum_zq_byjy_gk_gck()
                -MyApplication.findFinanceBean.getData().getSum_zq_byzf_gk_gck();

        tv_zq_end_sum_gk.setText(df.format(zq_end_sum_gk));
        Double zw_end_sum_gk= MyApplication.findFinanceBean.getData().getZw_qc_gk_gck()+MyApplication.findFinanceBean.getData().getSum_zw_byjy_gk_gck()
                -MyApplication.findFinanceBean.getData().getSum_zw_byzf_gk_gck();
        tv_zw_end_sum_gk.setText(df.format(zw_end_sum_gk));
        if(tv_zq_end_sum_gk.getText().equals(tv_zw_end_sum_gk.getText())){
            drawable.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_gk.setCompoundDrawables(null, null, drawable, null);// 设置到控件中
        }else {
            drawable1.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_gk.setCompoundDrawables(null, null, drawable1, null);// 设置到控件中
        }
        if(MyApplication.findFinanceBean.getData().getZq_company_name()==null){
            text_zw_.setText("债务单位："+MyApplication.findFinanceBean.getData().getZw_company_name());
            text_zq_.setText("债权单位："+MyApplication.findFinanceBean.getData().getZw_dz_company_name());
        }else {
            text_zq_.setText("债权单位："+MyApplication.findFinanceBean.getData().getZq_company_name());
            text_zw_.setText("债务单位："+MyApplication.findFinanceBean.getData().getZq_dz_company_name());
        }
        text_sm_zq.setText(MyApplication.findFinanceBean.getData().getZq_wd_sm());
        text_sm_zw.setText(MyApplication.findFinanceBean.getData().getZw_wd_sm());

    }

    @Override
    protected void initComponent() {

    }
}
