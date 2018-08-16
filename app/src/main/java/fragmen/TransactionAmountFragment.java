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
public class TransactionAmountFragment extends BaseFragment {

    @Bind(R.id.tv_zq_bujy_zy_wz)
    TextView tv_zq_bujy_zy_wz;
    @Bind(R.id.tv_zw_bujy_zy_wz)
    TextView tv_zw_bujy_zy_wz;
    @Bind(R.id.tv_zq_bujy_zy_zb)
    TextView tv_zq_bujy_zy_zb;
    @Bind(R.id.tv_zw_bujy_zy_zb)
    TextView tv_zw_bujy_zy_zb;

    @Bind(R.id.tv_zq_sum)
    TextView tv_zq_sum;
    @Bind(R.id.tv_zw_sum)
    TextView tv_zw_sum;
    @Bind(R.id.tv_zq_byjy_gk_gck)
    TextView tv_zq_byjy_gk_gck;
    @Bind(R.id.tv_zw_byjy_gk_gck)
    TextView tv_zw_byjy_gk_gck;
    @Bind(R.id.tv_sum_zq_byjy_zy_wu)
    TextView tv_sum_zq_byjy_zy_wu;
    @Bind(R.id.tv_sum_zw_byjy_zy_wu)
    TextView tv_sum_zw_byjy_zy_wu;
    @Bind(R.id.tv_sum_zq_byjy_zy_zb)
    TextView tv_sum_zq_byjy_zy_zb;
    @Bind(R.id.tv_sum_zw_byjy_zy_zb)
    TextView tv_sum_zw_byjy_zy_zb;
    @Bind(R.id.tv_zq_wd_zy_zgje)
    TextView tv_zq_wd_zy_zgje;
    @Bind(R.id.tv_zw_wd_zy_zgje)
    TextView tv_zw_wd_zy_zgje;
    @Bind(R.id.tv_zq_wd_zy)
    TextView tv_zq_wd_zy;
    @Bind(R.id.tv_zw_wd_zy)
    TextView tv_zw_wd_zy;
    @Bind(R.id.tv_sum_zq_sum)
    TextView tv_sum_zq_sum;
    @Bind(R.id.tv_sum_zw_sum)
    TextView tv_sum_zw_sum;
    @Bind(R.id.tv_sum_zq_byjy_gk_gck)
    TextView tv_sum_zq_byjy_gk_gck;
    @Bind(R.id.tv_sum_zw_byjy_gk_gck)
    TextView tv_sum_zw_byjy_gk_gck;
    @Bind(R.id.tv_zq_wd_gk_zgjy)
    TextView tv_zq_wd_gk_zgjy;
    @Bind(R.id.tv_zw_wd_gk_zgjy)
    TextView tv_zw_wd_gk_zgjy;
    @Bind(R.id.tv_zq_wd_gk)
    TextView tv_zq_wd_gk;
    @Bind(R.id.tv_zw_wd_gk)
    TextView tv_zw_wd_gk;

    @Bind(R.id.tv_sum_zq_gk_sum)
    TextView tv_sum_zq_gk_sum;
    @Bind(R.id.tv_sum_zw_gk_sum)
    TextView tv_sum_zw_gk_sum;

    @Bind(R.id.text_zy)
    TextView text_zy;
    @Bind(R.id.text_gk)
    TextView text_gk;
    @Bind(R.id.text_zy_sum)
    TextView text_zy_sum;
    @Bind(R.id.text_gk_sum)
    TextView text_gk_sum;

    DecimalFormat df = new DecimalFormat("###,##0.00");
    public TransactionAmountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return createView(inflater.inflate(R.layout.fragment_transaction_amount, container, false));
    }

    @Override
    protected void findWidgets() {
        Drawable drawable = getResources().getDrawable(R.mipmap.green);// 找到资源图片
        Drawable drawable1 = getResources().getDrawable(R.mipmap.red);// 找到资源图片
        tv_zq_bujy_zy_wz.setText(df.format(MyApplication.findFinanceBean.getData().getZq_byjy_zy_wu()));
        tv_zw_bujy_zy_wz.setText(df.format(MyApplication.findFinanceBean.getData().getZw_byjy_zy_wu()));
        tv_zq_bujy_zy_zb.setText(df.format(MyApplication.findFinanceBean.getData().getZq_byjy_zy_zb()));
        tv_zw_bujy_zy_zb.setText(df.format(MyApplication.findFinanceBean.getData().getZw_byjy_zy_zb()));
        if(MyApplication.findFinanceBean.getData().getZq_byjy_zy_wu()==MyApplication.findFinanceBean.getData().getZw_byjy_zy_wu()
                &&MyApplication.findFinanceBean.getData().getZq_byjy_zy_zb()==+MyApplication.findFinanceBean.getData().getZw_byjy_zy_zb()){
            drawable.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_zy.setCompoundDrawables(null, null, drawable, null);// 设置到控件中
        }else {
            drawable1.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_zy.setCompoundDrawables(null, null, drawable1, null);// 设置到控件中
        }
        Double zq_sum=(MyApplication.findFinanceBean.getData().getZq_byjy_zy_wu()+MyApplication.findFinanceBean.getData().getZq_byjy_zy_zb());
        tv_zq_sum.setText(df.format(zq_sum));
        Double zw_sum=(MyApplication.findFinanceBean.getData().getZw_byjy_zy_wu()+MyApplication.findFinanceBean.getData().getZw_byjy_zy_zb());
        tv_zw_sum.setText(df.format(zw_sum));

        tv_zq_byjy_gk_gck.setText(df.format(MyApplication.findFinanceBean.getData().getZq_byjy_gk_gck()));
        tv_zw_byjy_gk_gck.setText(df.format(MyApplication.findFinanceBean.getData().getZw_byjy_gk_gck()));
        if (MyApplication.findFinanceBean.getData().getZq_byjy_gk_gck()==MyApplication.findFinanceBean.getData().getZw_byjy_gk_gck()){
            drawable.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_gk.setCompoundDrawables(null, null, drawable, null);// 设置到控件中
        }else {
            drawable1.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_gk.setCompoundDrawables(null, null, drawable1, null);// 设置到控件中
        }
        tv_sum_zq_byjy_zy_wu.setText(df.format(MyApplication.findFinanceBean.getData().getSum_zq_byjy_zy_wu()));
        tv_sum_zw_byjy_zy_wu.setText(df.format(MyApplication.findFinanceBean.getData().getSum_zw_byjy_zy_wu()));
        tv_sum_zq_byjy_zy_zb.setText(df.format(MyApplication.findFinanceBean.getData().getSum_zq_byjy_zy_zb()));
        tv_sum_zw_byjy_zy_zb.setText(df.format(MyApplication.findFinanceBean.getData().getSum_zw_byjy_zy_zb()));
        tv_zq_wd_zy_zgje.setText(df.format(MyApplication.findFinanceBean.getData().getZq_wd_zy_zgje()));
        tv_zw_wd_zy_zgje.setText(df.format(MyApplication.findFinanceBean.getData().getZw_wd_zy_zgje()));
        tv_zq_wd_zy.setText(df.format(MyApplication.findFinanceBean.getData().getZq_wd_zy()));
        tv_zw_wd_zy.setText(df.format(MyApplication.findFinanceBean.getData().getZw_wd_zy()));
        if(MyApplication.findFinanceBean.getData().getSum_zq_byjy_zy_wu()==MyApplication.findFinanceBean.getData().getSum_zw_byjy_zy_wu()
                &&MyApplication.findFinanceBean.getData().getSum_zq_byjy_zy_zb()==MyApplication.findFinanceBean.getData().getSum_zw_byjy_zy_zb()
                &&MyApplication.findFinanceBean.getData().getZq_wd_zy_zgje()==MyApplication.findFinanceBean.getData().getZw_wd_zy_zgje()
                &&MyApplication.findFinanceBean.getData().getZq_wd_zy()==MyApplication.findFinanceBean.getData().getZw_wd_zy()){
            drawable.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_zy_sum.setCompoundDrawables(null, null, drawable, null);// 设置到控件中
        }else {
            drawable1.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_zy_sum.setCompoundDrawables(null, null, drawable1, null);// 设置到控件中
        }
        Double sum_zq_sum=(MyApplication.findFinanceBean.getData().getSum_zq_byjy_zy_wu()+MyApplication.findFinanceBean.getData().getSum_zq_byjy_zy_zb()
                +MyApplication.findFinanceBean.getData().getZq_wd_zy_zgje()+MyApplication.findFinanceBean.getData().getZq_wd_zy());
        tv_sum_zq_sum.setText(df.format(sum_zq_sum));
        Double sum_zw_sum= (MyApplication.findFinanceBean.getData().getSum_zw_byjy_zy_wu()+MyApplication.findFinanceBean.getData().getSum_zw_byjy_zy_zb()
                +MyApplication.findFinanceBean.getData().getZw_wd_zy_zgje()+MyApplication.findFinanceBean.getData().getZw_wd_zy());
        tv_sum_zw_sum.setText(df.format(sum_zw_sum));
        tv_sum_zq_byjy_gk_gck.setText(df.format(MyApplication.findFinanceBean.getData().getSum_zq_byjy_gk_gck()));
        tv_sum_zw_byjy_gk_gck.setText(df.format(MyApplication.findFinanceBean.getData().getSum_zw_byjy_gk_gck()));
        tv_zq_wd_gk_zgjy.setText(df.format(MyApplication.findFinanceBean.getData().getZq_wd_gk_zgje()));
        tv_zw_wd_gk_zgjy.setText(df.format(MyApplication.findFinanceBean.getData().getZw_wd_gk_zgje()));
        tv_zq_wd_gk.setText(df.format(MyApplication.findFinanceBean.getData().getZq_wd_gk()));
        tv_zw_wd_gk.setText(df.format(MyApplication.findFinanceBean.getData().getZw_wd_gk()));
        Double sum_zq_gk_sum= (MyApplication.findFinanceBean.getData().getSum_zq_byjy_gk_gck()+MyApplication.findFinanceBean.getData().getZq_wd_gk_zgje()
                +MyApplication.findFinanceBean.getData().getZq_wd_gk());
        tv_sum_zq_gk_sum.setText(df.format(sum_zq_gk_sum));
        Double sum_zw_gk_sum= MyApplication.findFinanceBean.getData().getSum_zw_byjy_gk_gck()+MyApplication.findFinanceBean.getData().getZw_wd_gk_zgje()
                +MyApplication.findFinanceBean.getData().getZw_wd_gk();
        tv_sum_zw_gk_sum.setText(df.format(sum_zw_gk_sum));
        if (MyApplication.findFinanceBean.getData().getSum_zq_byjy_gk_gck()==MyApplication.findFinanceBean.getData().getSum_zw_byjy_gk_gck()
        &&MyApplication.findFinanceBean.getData().getZq_wd_gk_zgje()==MyApplication.findFinanceBean.getData().getZw_wd_gk_zgje()
                &&MyApplication.findFinanceBean.getData().getZq_wd_gk()==MyApplication.findFinanceBean.getData().getZw_wd_gk()
                ){
            drawable.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_gk_sum.setCompoundDrawables(null, null, drawable, null);// 设置到控件中
        }else {
            drawable1.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_gk_sum.setCompoundDrawables(null, null, drawable1, null);// 设置到控件中
        }


    }

    @Override
    protected void initComponent() {

    }
}
