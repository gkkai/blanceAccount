package fragmen;


import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kk.blanceaccount.ProjectDetailsActivity;
import com.example.kk.blanceaccount.R;

import java.text.DecimalFormat;

import base.BaseFragment;
import base.MyApplication;
import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 * 期初余额
 */
public class BalanceFragment extends BaseFragment {
    @Bind(R.id.tv_zq_qu_zy_wz)
    TextView tv_zq_qu_zy_wz;

    @Bind(R.id.tv_zw_qu_zy_wz)
    TextView tv_zw_qu_zy_wz;
    @Bind(R.id.tv_zq_qu_zy_zb)
    TextView tv_zq_qu_zy_zb;

    @Bind(R.id.tv_zw_qu_zy_zb)
    TextView tv_zw_qu_zy_zb;
    @Bind(R.id.tv_zq_sum)
    TextView tv_zq_sum;
    @Bind(R.id.tv_zw_sum)
    TextView tv_zw_sum;
    @Bind(R.id.tv_zq_qu_gk_gck)
    TextView tv_zq_qu_gk_gck;
    @Bind(R.id.tv_zw_qu_gk_gck)
    TextView tv_zw_qu_gk_gck;

    @Bind(R.id.text_zy)
    TextView text_zy;
    @Bind(R.id.text_gk)
    TextView text_gk;


    DecimalFormat df = new DecimalFormat("###,##0.00");
    public BalanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return createView(inflater.inflate(R.layout.fragment_balance, container, false));
    }

    @Override
    protected void findWidgets() {
        Drawable drawable = getResources().getDrawable(R.mipmap.green);// 找到资源图片
        Drawable drawable1 = getResources().getDrawable(R.mipmap.red);// 找到资源图片
        tv_zw_qu_zy_wz.setText(df.format(MyApplication.findFinanceBean.getData().getZw_qc_zy_wu()));
        tv_zq_qu_zy_wz.setText(df.format(MyApplication.findFinanceBean.getData().getZq_qc_zy_wu()));
        tv_zq_qu_zy_zb.setText(df.format(MyApplication.findFinanceBean.getData().getZq_qc_zy_zb()));
        tv_zw_qu_zy_zb.setText(df.format(MyApplication.findFinanceBean.getData().getZw_qc_zy_zb()));
        Double zq_sum=MyApplication.findFinanceBean.getData().getZq_qc_zy_wu() + MyApplication.findFinanceBean.getData().getZq_qc_zy_zb();
        tv_zq_sum.setText(df.format(zq_sum));
        Double zw_sum=MyApplication.findFinanceBean.getData().getZw_qc_zy_wu() + MyApplication.findFinanceBean.getData().getZw_qc_zy_zb();
        tv_zw_sum.setText(df.format(zw_sum));
        tv_zq_qu_gk_gck.setText(df.format(MyApplication.findFinanceBean.getData().getZq_qc_gk_gck()));
        tv_zw_qu_gk_gck.setText("¥" + MyApplication.findFinanceBean.getData().getZw_qc_gk_gck());
        if (MyApplication.findFinanceBean.getData().getZw_qc_zy_wu() == MyApplication.findFinanceBean.getData().getZq_qc_zy_wu()
                && MyApplication.findFinanceBean.getData().getZq_qc_zy_zb() == MyApplication.findFinanceBean.getData().getZw_qc_zy_zb()) {
            //TODO 变化颜色

            //drawable.setBounds(left, top, right, bottom);
// 这一步必须要做，否则不会显示。
            drawable.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_zy.setCompoundDrawables(null, null, drawable, null);// 设置到控件中
        } else {
            //TODO 变化颜色

            //drawable.setBounds(left, top, right, bottom);
            drawable1.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_zy.setCompoundDrawables(null, null, drawable1, null);// 设置到控件中

        }
        if(MyApplication.findFinanceBean.getData().getZq_qc_gk_gck()==MyApplication.findFinanceBean.getData().getZw_qc_gk_gck()){
            drawable.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_gk.setCompoundDrawables(null, null, drawable, null);// 设置到控件中
        }else {
            drawable1.setBounds(0, 0, 50, 50);// 设置图片宽高
            text_gk.setCompoundDrawables(null, null, drawable1, null);// 设置到控件中
        }

    }

    @Override
    protected void initComponent() {

    }
}
