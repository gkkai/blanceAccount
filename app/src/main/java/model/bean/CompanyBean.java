package model.bean;

import java.util.List;

/**
 * Created by kk on 2018/5/24.
 */

public class CompanyBean {
    private int code;
    private String message;
    private List<CompanyBeanData> data;
    public  class CompanyBeanData{

        private int id;
        private String companyName;
        private int parentId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }
    }

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

    public List<CompanyBeanData> getData() {
        return data;
    }

    public void setData(List<CompanyBeanData> data) {
        this.data = data;
    }
}
