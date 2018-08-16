package model.bean;

import com.nostra13.universalimageloader.utils.L;

import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */

public class AccountYearListBean {



    private int status;
    private String msg;
   public  List<String> year;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getYear() {
        return year;
    }

    public void setYear(List<String> year) {
        this.year = year;
    }
}
