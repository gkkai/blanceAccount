package model.bean;

import java.util.List;

/**
 * Created by kk on 2018/5/23.
 */

public class FindFinanceBean {
    private int code;
    private String message;
    private FindFinanceBeanData data;

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

    public FindFinanceBeanData getData() {
        return data;
    }

    public void setData(FindFinanceBeanData data) {
        this.data = data;
    }

    public class FindFinanceBeanData{
        private String id;
        private int zq_id;
        private String zq_dz_key;
        private String zq_year;
        private String zq_month;
        private int zq_company;
        private String zq_company_name;
        private int zq_dz_company;
        private String zq_dz_company_name;
        private double zq_qc_zy_wu;
        private double zq_qc_zy_zb;
        private double zq_qc_gk_gck;
        private double zq_byjy_zy_wu;
        private double zq_byjy_zy_zb;
        private double zq_byjy_gk_gck;
        private double zq_byzf_zy_wu;
        private double zq_byzf_zy_zb;
        private double zq_byzf_gk_gck;
        private double zq_wd_zy;
        private double zq_wd_zy_zgje;
        private double zq_wd_gk;
        private double zq_wd_gk_zgje;
        private double zq_is_ok;
        private String zq_wd_sm;
        private int zw_id;
        private String zw_dz_key;
        private String zw_year;
        private String zw_month;
        private int zw_company;
        private String zw_company_name;
        private String zw_dz_company_name;
        private int zw_dz_company;
        private double zw_qc_zy_wu;
        private double zw_qc_zy_zb;
        private double zw_qc_gk_gck;
        private double zw_byjy_zy_wu;
        private double zw_byjy_zy_zb;
        private double zw_byjy_gk_gck;
        private double zw_byzf_zy_wu;
        private double zw_byzf_zy_zb;
        private double zw_byzf_gk_gck;
        private double zw_wd_zy;
        private double zw_wd_zy_zgje;
        private double zw_wd_gk;
        private double zw_wd_gk_zgje;
        private int zw_is_ok;
        private String zw_wd_sm;
        private double sum_zq_byjy_zy_wu;
        private double sum_zq_byjy_zy_zb;
        private double sum_zq_byjy_gk_gck;
        private double sum_zq_byzf_zy_wu;
        private double sum_zq_byzf_zy_zb;
        private double sum_zq_byzf_gk_gck;
        private double sum_zw_byjy_zy_wu;
        private double sum_zw_byjy_zy_zb;
        private double sum_zw_byjy_gk_gck;
        private double sum_zw_byzf_zy_wu;
        private double sum_zw_byzf_zy_zb;
        private double sum_zw_byzf_gk_gck;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getZq_id() {
            return zq_id;
        }

        public void setZq_id(int zq_id) {
            this.zq_id = zq_id;
        }

        public String getZq_dz_key() {
            return zq_dz_key;
        }

        public void setZq_dz_key(String zq_dz_key) {
            this.zq_dz_key = zq_dz_key;
        }

        public String getZq_year() {
            return zq_year;
        }

        public void setZq_year(String zq_year) {
            this.zq_year = zq_year;
        }

        public String getZq_month() {
            return zq_month;
        }

        public void setZq_month(String zq_month) {
            this.zq_month = zq_month;
        }

        public int getZq_company() {
            return zq_company;
        }

        public void setZq_company(int zq_company) {
            this.zq_company = zq_company;
        }

        public String getZq_company_name() {
            return zq_company_name;
        }

        public void setZq_company_name(String zq_company_name) {
            this.zq_company_name = zq_company_name;
        }

        public int getZq_dz_company() {
            return zq_dz_company;
        }

        public void setZq_dz_company(int zq_dz_company) {
            this.zq_dz_company = zq_dz_company;
        }

        public String getZq_dz_company_name() {
            return zq_dz_company_name;
        }

        public void setZq_dz_company_name(String zq_dz_company_name) {
            this.zq_dz_company_name = zq_dz_company_name;
        }

        public double getZq_qc_zy_wu() {
            return zq_qc_zy_wu;
        }

        public void setZq_qc_zy_wu(int zq_qc_zy_wu) {
            this.zq_qc_zy_wu = zq_qc_zy_wu;
        }

        public double getZq_qc_zy_zb() {
            return zq_qc_zy_zb;
        }

        public void setZq_qc_zy_zb(int zq_qc_zy_zb) {
            this.zq_qc_zy_zb = zq_qc_zy_zb;
        }

        public double getZq_qc_gk_gck() {
            return zq_qc_gk_gck;
        }

        public void setZq_qc_gk_gck(int zq_qc_gk_gck) {
            this.zq_qc_gk_gck = zq_qc_gk_gck;
        }

        public double getZq_byjy_zy_wu() {
            return zq_byjy_zy_wu;
        }

        public void setZq_byjy_zy_wu(int zq_byjy_zy_wu) {
            this.zq_byjy_zy_wu = zq_byjy_zy_wu;
        }

        public double getZq_byjy_zy_zb() {
            return zq_byjy_zy_zb;
        }

        public void setZq_byjy_zy_zb(int zq_byjy_zy_zb) {
            this.zq_byjy_zy_zb = zq_byjy_zy_zb;
        }

        public double getZq_byjy_gk_gck() {
            return zq_byjy_gk_gck;
        }

        public void setZq_byjy_gk_gck(int zq_byjy_gk_gck) {
            this.zq_byjy_gk_gck = zq_byjy_gk_gck;
        }

        public double getZq_byzf_zy_wu() {
            return zq_byzf_zy_wu;
        }

        public void setZq_byzf_zy_wu(int zq_byzf_zy_wu) {
            this.zq_byzf_zy_wu = zq_byzf_zy_wu;
        }

        public double getZq_byzf_zy_zb() {
            return zq_byzf_zy_zb;
        }

        public void setZq_byzf_zy_zb(int zq_byzf_zy_zb) {
            this.zq_byzf_zy_zb = zq_byzf_zy_zb;
        }

        public double getZq_byzf_gk_gck() {
            return zq_byzf_gk_gck;
        }

        public void setZq_byzf_gk_gck(int zq_byzf_gk_gck) {
            this.zq_byzf_gk_gck = zq_byzf_gk_gck;
        }

        public double getZq_wd_zy() {
            return zq_wd_zy;
        }

        public void setZq_wd_zy(int zq_wd_zy) {
            this.zq_wd_zy = zq_wd_zy;
        }

        public double getZq_wd_zy_zgje() {
            return zq_wd_zy_zgje;
        }

        public void setZq_wd_zy_zgje(int zq_wd_zy_zgje) {
            this.zq_wd_zy_zgje = zq_wd_zy_zgje;
        }

        public double getZq_wd_gk() {
            return zq_wd_gk;
        }

        public void setZq_wd_gk(int zq_wd_gk) {
            this.zq_wd_gk = zq_wd_gk;
        }

        public double getZq_wd_gk_zgje() {
            return zq_wd_gk_zgje;
        }

        public void setZq_wd_gk_zgje(int zq_wd_gk_zgje) {
            this.zq_wd_gk_zgje = zq_wd_gk_zgje;
        }

        public double getZq_is_ok() {
            return zq_is_ok;
        }

        public void setZq_is_ok(int zq_is_ok) {
            this.zq_is_ok = zq_is_ok;
        }

        public String getZq_wd_sm() {
            return zq_wd_sm;
        }

        public void setZq_wd_sm(String zq_wd_sm) {
            this.zq_wd_sm = zq_wd_sm;
        }

        public int getZw_id() {
            return zw_id;
        }

        public void setZw_id(int zw_id) {
            this.zw_id = zw_id;
        }

        public String getZw_dz_key() {
            return zw_dz_key;
        }

        public void setZw_dz_key(String zw_dz_key) {
            this.zw_dz_key = zw_dz_key;
        }

        public String getZw_year() {
            return zw_year;
        }

        public void setZw_year(String zw_year) {
            this.zw_year = zw_year;
        }

        public String getZw_month() {
            return zw_month;
        }

        public void setZw_month(String zw_month) {
            this.zw_month = zw_month;
        }

        public int getZw_company() {
            return zw_company;
        }

        public void setZw_company(int zw_company) {
            this.zw_company = zw_company;
        }

        public String getZw_company_name() {
            return zw_company_name;
        }

        public void setZw_company_name(String zw_company_name) {
            this.zw_company_name = zw_company_name;
        }

        public String getZw_dz_company_name() {
            return zw_dz_company_name;
        }

        public void setZw_dz_company_name(String zw_dz_company_name) {
            this.zw_dz_company_name = zw_dz_company_name;
        }

        public int getZw_dz_company() {
            return zw_dz_company;
        }

        public void setZw_dz_company(int zw_dz_company) {
            this.zw_dz_company = zw_dz_company;
        }

        public double getZw_qc_zy_wu() {
            return zw_qc_zy_wu;
        }

        public void setZw_qc_zy_wu(int zw_qc_zy_wu) {
            this.zw_qc_zy_wu = zw_qc_zy_wu;
        }

        public double getZw_qc_zy_zb() {
            return zw_qc_zy_zb;
        }

        public void setZw_qc_zy_zb(int zw_qc_zy_zb) {
            this.zw_qc_zy_zb = zw_qc_zy_zb;
        }

        public double getZw_qc_gk_gck() {
            return zw_qc_gk_gck;
        }

        public void setZw_qc_gk_gck(int zw_qc_gk_gck) {
            this.zw_qc_gk_gck = zw_qc_gk_gck;
        }

        public double getZw_byjy_zy_wu() {
            return zw_byjy_zy_wu;
        }

        public void setZw_byjy_zy_wu(int zw_byjy_zy_wu) {
            this.zw_byjy_zy_wu = zw_byjy_zy_wu;
        }

        public double getZw_byjy_zy_zb() {
            return zw_byjy_zy_zb;
        }

        public void setZw_byjy_zy_zb(int zw_byjy_zy_zb) {
            this.zw_byjy_zy_zb = zw_byjy_zy_zb;
        }

        public double getZw_byjy_gk_gck() {
            return zw_byjy_gk_gck;
        }

        public void setZw_byjy_gk_gck(int zw_byjy_gk_gck) {
            this.zw_byjy_gk_gck = zw_byjy_gk_gck;
        }

        public double getZw_byzf_zy_wu() {
            return zw_byzf_zy_wu;
        }

        public void setZw_byzf_zy_wu(int zw_byzf_zy_wu) {
            this.zw_byzf_zy_wu = zw_byzf_zy_wu;
        }

        public double getZw_byzf_zy_zb() {
            return zw_byzf_zy_zb;
        }

        public void setZw_byzf_zy_zb(int zw_byzf_zy_zb) {
            this.zw_byzf_zy_zb = zw_byzf_zy_zb;
        }

        public double getZw_byzf_gk_gck() {
            return zw_byzf_gk_gck;
        }

        public void setZw_byzf_gk_gck(int zw_byzf_gk_gck) {
            this.zw_byzf_gk_gck = zw_byzf_gk_gck;
        }

        public double getZw_wd_zy() {
            return zw_wd_zy;
        }

        public void setZw_wd_zy(int zw_wd_zy) {
            this.zw_wd_zy = zw_wd_zy;
        }

        public double getZw_wd_zy_zgje() {
            return zw_wd_zy_zgje;
        }

        public void setZw_wd_zy_zgje(int zw_wd_zy_zgje) {
            this.zw_wd_zy_zgje = zw_wd_zy_zgje;
        }

        public double getZw_wd_gk() {
            return zw_wd_gk;
        }

        public void setZw_wd_gk(int zw_wd_gk) {
            this.zw_wd_gk = zw_wd_gk;
        }

        public double getZw_wd_gk_zgje() {
            return zw_wd_gk_zgje;
        }

        public void setZw_wd_gk_zgje(int zw_wd_gk_zgje) {
            this.zw_wd_gk_zgje = zw_wd_gk_zgje;
        }

        public int getZw_is_ok() {
            return zw_is_ok;
        }

        public void setZw_is_ok(int zw_is_ok) {
            this.zw_is_ok = zw_is_ok;
        }

        public String getZw_wd_sm() {
            return zw_wd_sm;
        }

        public void setZw_wd_sm(String zw_wd_sm) {
            this.zw_wd_sm = zw_wd_sm;
        }

        public double getSum_zq_byjy_zy_wu() {
            return sum_zq_byjy_zy_wu;
        }

        public void setSum_zq_byjy_zy_wu(int sum_zq_byjy_zy_wu) {
            this.sum_zq_byjy_zy_wu = sum_zq_byjy_zy_wu;
        }

        public double getSum_zq_byjy_zy_zb() {
            return sum_zq_byjy_zy_zb;
        }

        public void setSum_zq_byjy_zy_zb(int sum_zq_byjy_zy_zb) {
            this.sum_zq_byjy_zy_zb = sum_zq_byjy_zy_zb;
        }

        public double getSum_zq_byjy_gk_gck() {
            return sum_zq_byjy_gk_gck;
        }

        public void setSum_zq_byjy_gk_gck(int sum_zq_byjy_gk_gck) {
            this.sum_zq_byjy_gk_gck = sum_zq_byjy_gk_gck;
        }

        public double getSum_zq_byzf_zy_wu() {
            return sum_zq_byzf_zy_wu;
        }

        public void setSum_zq_byzf_zy_wu(int sum_zq_byzf_zy_wu) {
            this.sum_zq_byzf_zy_wu = sum_zq_byzf_zy_wu;
        }

        public double getSum_zq_byzf_zy_zb() {
            return sum_zq_byzf_zy_zb;
        }

        public void setSum_zq_byzf_zy_zb(int sum_zq_byzf_zy_zb) {
            this.sum_zq_byzf_zy_zb = sum_zq_byzf_zy_zb;
        }

        public double getSum_zq_byzf_gk_gck() {
            return sum_zq_byzf_gk_gck;
        }

        public void setSum_zq_byzf_gk_gck(int sum_zq_byzf_gk_gck) {
            this.sum_zq_byzf_gk_gck = sum_zq_byzf_gk_gck;
        }

        public double getSum_zw_byjy_zy_wu() {
            return sum_zw_byjy_zy_wu;
        }

        public void setSum_zw_byjy_zy_wu(int sum_zw_byjy_zy_wu) {
            this.sum_zw_byjy_zy_wu = sum_zw_byjy_zy_wu;
        }

        public double getSum_zw_byjy_zy_zb() {
            return sum_zw_byjy_zy_zb;
        }

        public void setSum_zw_byjy_zy_zb(int sum_zw_byjy_zy_zb) {
            this.sum_zw_byjy_zy_zb = sum_zw_byjy_zy_zb;
        }

        public double getSum_zw_byjy_gk_gck() {
            return sum_zw_byjy_gk_gck;
        }

        public void setSum_zw_byjy_gk_gck(int sum_zw_byjy_gk_gck) {
            this.sum_zw_byjy_gk_gck = sum_zw_byjy_gk_gck;
        }

        public double getSum_zw_byzf_zy_wu() {
            return sum_zw_byzf_zy_wu;
        }

        public void setSum_zw_byzf_zy_wu(int sum_zw_byzf_zy_wu) {
            this.sum_zw_byzf_zy_wu = sum_zw_byzf_zy_wu;
        }

        public double getSum_zw_byzf_zy_zb() {
            return sum_zw_byzf_zy_zb;
        }

        public void setSum_zw_byzf_zy_zb(int sum_zw_byzf_zy_zb) {
            this.sum_zw_byzf_zy_zb = sum_zw_byzf_zy_zb;
        }

        public double getSum_zw_byzf_gk_gck() {
            return sum_zw_byzf_gk_gck;
        }

        public void setSum_zw_byzf_gk_gck(int sum_zw_byzf_gk_gck) {
            this.sum_zw_byzf_gk_gck = sum_zw_byzf_gk_gck;
        }
    }
}
