package model.bean;

import java.util.List;

/**
 * Created by kk on 2018/5/23.
 */

public class LoginBean {
    private int code;
    private String message;
    private LoginBeanData data;
    public static class LoginBeanData{
        private int id;
        private int companyId;
        private String name;
        private String password;
        private SelfCompany selfCompany;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public SelfCompany getSelfCompany() {
            return selfCompany;
        }

        public void setSelfCompany(SelfCompany selfCompany) {
            this.selfCompany = selfCompany;
        }

        public List<ChildCompanys> getChildCompanys() {
            return childCompanys;
        }

        public void setChildCompanys(List<ChildCompanys> childCompanys) {
            this.childCompanys = childCompanys;
        }

        public static class SelfCompany{
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
        private List<ChildCompanys> childCompanys;
        public static class ChildCompanys{

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

    public LoginBeanData getData() {
        return data;
    }

    public void setData(LoginBeanData data) {
        this.data = data;
    }
}
