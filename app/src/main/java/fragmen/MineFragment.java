package fragmen;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kk.blanceaccount.AccountProjectListActivity;
import com.example.kk.blanceaccount.CompanyListActivity;
import com.example.kk.blanceaccount.CompanyMouthListActivity;
import com.example.kk.blanceaccount.LoginActivity;
import com.example.kk.blanceaccount.MyAccountListActivity;
import com.example.kk.blanceaccount.R;
import com.example.kk.blanceaccount.SettingActivity;

import adapter.BaseViewHolder;
import base.BaseFragment;
import base.MyApplication;
import butterknife.Bind;
import widget.CircleImageView;
import widget.MyGridView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.text_account_query)
    TextView text_account_query;
    @Bind(R.id.text_myaccount)
    TextView text_myaccount;

    @Bind(R.id.image_exit)
    ImageView image_exit;
    @Bind(R.id.tv_account)
    TextView  tv_account;
    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return createView(inflater.inflate(R.layout.fragment_mine, container, false));
    }

    @Override
    protected void findWidgets() {
        text_account_query.setOnClickListener(this);
        text_myaccount.setOnClickListener(this);
        image_exit.setOnClickListener(this);
        //tv_account.setText("账号："+MyApplication.loginBean.getData().getName()+" "+MyApplication.loginBean.getData().getId());
    }

    @Override
    public void onResume() {
        super.onResume();
        tv_account.setText(""+MyApplication.loginBean.getData().getName());

    }

    @Override
    protected void initComponent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_account_query:
                if(MyApplication.loginBean.getData().getChildCompanys()!=null&&MyApplication.loginBean.getData().getChildCompanys().size()!=0){
                    Intent intent=new Intent(getActivity(),CompanyListActivity.class);
                    intent.putExtra("type","mine");
                    startActivity(intent);
                }else {
                    Intent intent=new Intent(getActivity(),CompanyMouthListActivity.class);
                    intent.putExtra("companyName",MyApplication.loginBean.getData().getSelfCompany().getCompanyName());
                    intent.putExtra("companyId",MyApplication.loginBean.getData().getSelfCompany().getId());
                    startActivity(intent);
                }
                break;
            case R.id.text_myaccount:
//                Intent intent =new Intent(getActivity(), AccountProjectListActivity.class);
//                intent.putExtra("type","mine");
//                startActivity(intent);
                Intent intent=new Intent(getActivity(),MyAccountListActivity.class);
                startActivity(intent);

                break;
            case R.id.image_exit:
//                Intent intent =new Intent(getActivity(), AccountProjectListActivity.class);
//                intent.putExtra("type","mine");
//                startActivity(intent);
                Intent exitintent=new Intent(getActivity(),SettingActivity.class);
                startActivity(exitintent);

                break;
        }
    }
}
