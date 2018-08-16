package model.api;



import model.annotation.HttpRequest;
import model.bean.AddZqBean;
import model.bean.BannerBean;
import model.bean.CompanyBean;
import model.bean.FindCompanyYearFinanceBean;
import model.bean.FindCompanyYearFinanceMouthBean;
import model.bean.FindFinanceBean;
import model.bean.LoginBean;

public interface IHttpService {
    /**
     * 首页轮播图
     *
     * @param context 上下文对象
     */
    @HttpRequest(arguments = {}, url = "", resultClass = BannerBean.class, refreshMethod = "indexslideshow")
    public void indexslideshow(Object context);
    /**
     * 查询当前公司及所有子公司每个月对账的结果
     *
     * @param context 上下文对象
     */
    @HttpRequest(arguments = {"companyId","year"}, url = "", resultClass = FindCompanyYearFinanceBean.class, refreshMethod = "findCompanyYearFinance")
    public void findCompanyYearFinance(Object context,String companyId,String year);
    /**
     * 取得年份月份 对应公司及子公司下的所有对账信息
     *
     * @param context 上下文对象
     */
    @HttpRequest(arguments = {"companyId","year","month"}, url = "", resultClass = FindCompanyYearFinanceMouthBean.class, refreshMethod = "findCompanyYearAndMonthFinance")
    public void findCompanyYearAndMonthFinance(Object context,String companyId,String year,String month);
    /**
     * 查询公司没有对平的账目
     *
     * @param context 上下文对象
     */
    @HttpRequest(arguments = {"companyId"}, url = "", resultClass = FindCompanyYearFinanceMouthBean.class, refreshMethod = "companyNotOk")
    public void companyNotOk(Object context,String companyId);
    /**
     * 查询账务详情
     *
     * @param context 上下文对象
     */
    @HttpRequest(arguments = {"resultKey"}, url = "", resultClass = FindFinanceBean.class, refreshMethod = "findFinance")
    public void findFinance(Object context,String resultKey);

    /**
     * 登录
     *
     * @param context 上下文对象
     */
    @HttpRequest(arguments = {"name","password"}, url = "", resultClass = LoginBean.class, refreshMethod = "login")
    public void login(Object context,String name,String password);
    /**
     * 查询公司下的所有子公司
     *
     * @param context 上下文对象
     */
    @HttpRequest(arguments = {"companyId"}, url = "", resultClass = CompanyBean.class, refreshMethod = "findChildsCompany")
    public void findChildsCompany(Object context,String companyId);
       /**
     * 添加债权
     *
     * @param context 上下文对象
     */
    @HttpRequest(arguments = {"zq_dz_key","zq_year","zq_month","zq_company","zq_company_name","zq_dz_company",
            "zq_dz_company_name","zq_qc_zy_wu","zq_qc_zy_zb","zq_qc_gk_gck","zq_byjy_zy_wu","zq_byjy_zy_zb","zq_byjy_gk_gck"
            ,"zq_byzf_zy_wu","zq_byzf_zy_zb","zq_byzf_gk_gck","zq_wd_zy","zq_wd_zy_zgje","zq_wd_gk","zq_wd_gk_zgje","zq_is_ok","zq_wd_sm"}, url = "", resultClass = AddZqBean.class, refreshMethod = "addZq")
    public void addZq(Object context,String zq_dz_key,String zq_year,String zq_month,int zq_company,String zq_company_name,
                      int zq_dz_company,String zq_dz_company_name,double zq_qc_zy_wu,double zq_qc_zy_zb,
                      double zq_qc_gk_gck,double zq_byjy_zy_wu,double zq_byjy_zy_zb,double zq_byjy_gk_gck,double zq_byzf_zy_wu,double zq_byzf_zy_zb,double zq_byzf_gk_gck,double zq_wd_zy
            ,double zq_wd_zy_zgje,double zq_wd_gk,double zq_wd_gk_zgje,int zq_is_ok ,String zq_wd_sm);
    /**
     * 修改债权信息
     *
     * @param context 上下文对象
     */
    @HttpRequest(arguments = {"zq_id","zq_dz_key","zq_year","zq_month","zq_company","zq_company_name","zq_dz_company",
            "zq_dz_company_name","zq_qc_zy_wu","zq_qc_zy_zb","zq_qc_gk_gck","zq_byjy_zy_wu","zq_byjy_zy_zb","zq_byjy_gk_gck"
            ,"zq_byzf_zy_wu","zq_byzf_zy_zb","zq_byzf_gk_gck","zq_wd_zy","zq_wd_zy_zgje","zq_wd_gk","zq_wd_gk_zgje","zq_is_ok","zq_wd_sm"}, url = "", resultClass = AddZqBean.class, refreshMethod = "updateZq")
    public void updateZq(Object context,int zq_id,String zq_dz_key,String zq_year,String zq_month,int zq_company,String zq_company_name,
                      int zq_dz_company,String zq_dz_company_name,double zq_qc_zy_wu,double zq_qc_zy_zb,
                         double zq_qc_gk_gck,double zq_byjy_zy_wu,double zq_byjy_zy_zb,double zq_byjy_gk_gck,double zq_byzf_zy_wu,double zq_byzf_zy_zb,double zq_byzf_gk_gck,double zq_wd_zy
            ,double zq_wd_zy_zgje,double zq_wd_gk,double zq_wd_gk_zgje,int zq_is_ok ,String zq_wd_sm);


    /**
     * 添加债务
     *
     * @param context 上下文对象
     */
    @HttpRequest(arguments = {"zw_dz_key","zw_year","zw_month","zw_company","zw_company_name","zw_dz_company",
    "zw_dz_company_name","zw_qc_zy_wu","zw_qc_zy_zb","zw_qc_gk_gck","zw_byjy_zy_wu","zw_byjy_zy_zb","zw_byjy_gk_gck"
    ,"zw_byzf_zy_wu","zw_byzf_zy_zb","zw_byzf_gk_gck","zw_wd_zy","zw_wd_zy_zgje","zw_wd_gk","zw_wd_gk_zgje","zw_is_ok","zw_wd_sm"}, url = "", resultClass = AddZqBean.class, refreshMethod = "addZq")
    public void addZw(Object context,String zw_dz_key,String zw_year,String zw_month,int zw_company,String zw_company_name,
                      int zw_dz_company,String zw_dz_company_name,double zw_qc_zy_wu,double zw_qc_zy_zb,
                      double zw_qc_gk_gck,double zw_byjy_zy_wu,double zw_byjy_zy_zb,double zw_byjy_gk_gck,double zw_byzf_zy_wu,double zw_byzf_zy_zb,double zw_byzf_gk_gck,double zw_wd_zy
            ,double zw_wd_zy_zgje,double zw_wd_gk,double zw_wd_gk_zgje,int zw_is_ok ,String zw_wd_sm);
    /**
     * 修改债务信息
     *
     * @param context 上下文对象
     */
    @HttpRequest(arguments = {"zw_id","zw_dz_key","zw_year","zw_month","zw_company","zw_company_name","zw_dz_company",
            "zw_dz_company_name","zw_qc_zy_wu","zw_qc_zy_zb","zw_qc_gk_gck","zw_byjy_zy_wu","zw_byjy_zy_zb","zw_byjy_gk_gck"
            ,"zw_byzf_zy_wu","zw_byzf_zy_zb","zw_byzf_gk_gck","zw_wd_zy","zw_wd_zy_zgje","zw_wd_gk","zw_wd_gk_zgje","zw_is_ok","zw_wd_sm"}, url = "", resultClass = AddZqBean.class, refreshMethod = "updateZw")
    public void updateZw(Object context,int zw_id,String zw_dz_key,String zw_year,String zw_month,int zw_company,String zw_company_name,
                      int zw_dz_company,String zw_dz_company_name,double zw_qc_zy_wu,double zw_qc_zy_zb,
                         double zw_qc_gk_gck,double zw_byjy_zy_wu,double zw_byjy_zy_zb,double zw_byjy_gk_gck,double zw_byzf_zy_wu,double zw_byzf_zy_zb,double zw_byzf_gk_gck,double zw_wd_zy
            ,double zw_wd_zy_zgje,double zw_wd_gk,double zw_wd_gk_zgje,int zw_is_ok ,String zw_wd_sm);


    /**
     * 查询账务是否存在
     *
     * @param context 上下文对象
     */
    @HttpRequest(arguments = {"zqcompany","zwComapny","year","month","type"}, url = "", resultClass = AddZqBean.class, refreshMethod = "checkFiance")
    public void checkFiance(Object context,int zqcompany,int zwComapny,int year,int month,int type);
    /**
     * 查询账务是否存在
     *
     * @param context 上下文对象
     */
    @HttpRequest(arguments = {"id","type"}, url = "", resultClass = AddZqBean.class, refreshMethod = "delete")
    public void delete(Object context,int id,int type);
    /**
     * 修改密码
     *
     * @param context 上下文对象
     */
    @HttpRequest(arguments = {"userId","oldPassword","newPassword"}, url = "", resultClass = AddZqBean.class, refreshMethod = "updatePassword")
    public void updatePassword(Object context,String userId,String oldPassword,String newPassword);


}





