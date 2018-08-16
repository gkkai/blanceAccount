package model.bean;

import java.util.List;

/**
 * Created by kk on 2018/5/23.
 */

public class FindCompanyYearFinanceMouthBean {
    private int code;
    private String message;
    private List<FinanceMouthBean> data;

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

    public List<FinanceMouthBean> getData() {
        return data;
    }

    public void setData(List<FinanceMouthBean> data) {
        this.data = data;
    }

    public class FinanceMouthBean{
        private int isOK;
        private String zqCompany;
        private String zwCompany;
        private String year;
        private String month;
        private String resultKey;

        public int getIsOK() {
            return isOK;
        }

        public void setIsOK(int isOK) {
            this.isOK = isOK;
        }

        public String getZqCompany() {
            return zqCompany;
        }

        public void setZqCompany(String zqCompany) {
            this.zqCompany = zqCompany;
        }

        public String getZwCompany() {
            return zwCompany;
        }

        public void setZwCompany(String zwCompany) {
            this.zwCompany = zwCompany;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getResultKey() {
            return resultKey;
        }

        public void setResultKey(String resultKey) {
            this.resultKey = resultKey;
        }
    }
}
