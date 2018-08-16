package model.bean;

import java.util.List;

/**
 * Created by kk on 2018/5/23.
 */

public class FindCompanyYearFinanceBean {
    private int code;
    private String message;
    private List<FinanceBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FinanceBean> getData() {
        return data;
    }

    public void setData(List<FinanceBean> data) {
        this.data = data;
    }

    public class FinanceBean{
        private int month;
        private int result;
        private int hasResult;

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public int getHasResult() {
            return hasResult;
        }

        public void setHasResult(int hasResult) {
            this.hasResult = hasResult;
        }
    }
}
