package test.gotop.demo.system.model;

import java.math.BigDecimal;
import java.util.Date;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.abftdbsybs;

public class Tuser {

	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.USID
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private BigDecimal usid;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.PWD
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private String pwd;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.ZCSJ
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private Date zcsj;
	/**
	 * 
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.GMZQ
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private BigDecimal gmzq;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.XZQX
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private BigDecimal xzqx;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.YHNC
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private String yhnc;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.YHMC
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private String yhmc;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.DLCS
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private BigDecimal dlcs;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.YHZT
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private BigDecimal yhzt;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.BZ
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private String bz;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.LID
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private String lid;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.ORGID
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private String orgid;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.EMAIL
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private String email;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.MOBILE
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private String mobile;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.FAX
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private String fax;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.ROLETYPE
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private String roletype;
	/**
	 * This field was generated by GOTOP for iBATIS. This field corresponds to the database column TUSER.USEDATE
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private Date usedate;

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.USID
	 * @return  the value of TUSER.USID
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public BigDecimal getUsid() {
		return usid;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.USID
	 * @param usid  the value for TUSER.USID
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setUsid(BigDecimal usid) {
		this.usid = usid;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.PWD
	 * @return  the value of TUSER.PWD
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.PWD
	 * @param pwd  the value for TUSER.PWD
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.ZCSJ
	 * @return  the value of TUSER.ZCSJ
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public Date getZcsj() {
		return zcsj;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.ZCSJ
	 * @param zcsj  the value for TUSER.ZCSJ
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setZcsj(Date zcsj) {
		this.zcsj = zcsj;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.GMZQ
	 * @return  the value of TUSER.GMZQ
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public BigDecimal getGmzq() {
		return gmzq;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.GMZQ
	 * @param gmzq  the value for TUSER.GMZQ
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setGmzq(BigDecimal gmzq) {
		this.gmzq = gmzq;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.XZQX
	 * @return  the value of TUSER.XZQX
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public BigDecimal getXzqx() {
		return xzqx;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.XZQX
	 * @param xzqx  the value for TUSER.XZQX
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setXzqx(BigDecimal xzqx) {
		this.xzqx = xzqx;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.YHNC
	 * @return  the value of TUSER.YHNC
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public String getYhnc() {
		return yhnc;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.YHNC
	 * @param yhnc  the value for TUSER.YHNC
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setYhnc(String yhnc) {
		this.yhnc = yhnc;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.YHMC
	 * @return  the value of TUSER.YHMC
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public String getYhmc() {
		return yhmc;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.YHMC
	 * @param yhmc  the value for TUSER.YHMC
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setYhmc(String yhmc) {
		this.yhmc = yhmc;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.DLCS
	 * @return  the value of TUSER.DLCS
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public BigDecimal getDlcs() {
		return dlcs;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.DLCS
	 * @param dlcs  the value for TUSER.DLCS
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setDlcs(BigDecimal dlcs) {
		this.dlcs = dlcs;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.YHZT
	 * @return  the value of TUSER.YHZT
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public BigDecimal getYhzt() {
		return yhzt;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.YHZT
	 * @param yhzt  the value for TUSER.YHZT
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setYhzt(BigDecimal yhzt) {
		this.yhzt = yhzt;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.BZ
	 * @return  the value of TUSER.BZ
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public String getBz() {
		return bz;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.BZ
	 * @param bz  the value for TUSER.BZ
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.LID
	 * @return  the value of TUSER.LID
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public String getLid() {
		return lid;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.LID
	 * @param lid  the value for TUSER.LID
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setLid(String lid) {
		this.lid = lid;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.ORGID
	 * @return  the value of TUSER.ORGID
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.ORGID
	 * @param orgid  the value for TUSER.ORGID
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.EMAIL
	 * @return  the value of TUSER.EMAIL
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.EMAIL
	 * @param email  the value for TUSER.EMAIL
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.MOBILE
	 * @return  the value of TUSER.MOBILE
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.MOBILE
	 * @param mobile  the value for TUSER.MOBILE
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.FAX
	 * @return  the value of TUSER.FAX
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.FAX
	 * @param fax  the value for TUSER.FAX
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.ROLETYPE
	 * @return  the value of TUSER.ROLETYPE
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public String getRoletype() {
		return roletype;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.ROLETYPE
	 * @param roletype  the value for TUSER.ROLETYPE
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method returns the value of the database column TUSER.USEDATE
	 * @return  the value of TUSER.USEDATE
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public Date getUsedate() {
		return usedate;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method sets the value of the database column TUSER.USEDATE
	 * @param usedate  the value for TUSER.USEDATE
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void setUsedate(Date usedate) {
		this.usedate = usedate;
	}
}