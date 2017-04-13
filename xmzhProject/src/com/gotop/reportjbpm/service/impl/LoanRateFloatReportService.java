package com.gotop.reportjbpm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.enterprisedt.util.debug.Logger;
import com.gotop.reportjbpm.dao.ILoanRateFloatReportDao;
import com.gotop.reportjbpm.model.LoanRateFloatReport;
import com.gotop.reportjbpm.service.ILoanRateFloatReportService;
import com.gotop.util.string.Obj2StrUtils;
import com.gotop.vo.system.MUOUserSession;
import com.gotop.vo.tyjg.Omorganization;
import com.primeton.utils.Page;

public class LoanRateFloatReportService implements ILoanRateFloatReportService {

	protected Logger log = Logger.getLogger(LoanRateFloatReportService.class);
	private ILoanRateFloatReportDao loanRateFloatReportDao;
	

	public ILoanRateFloatReportDao getLoanRateFloatReportDao() {
		return loanRateFloatReportDao;
	}
	public void setLoanRateFloatReportDao(
			ILoanRateFloatReportDao loanRateFloatReportDao) {
		this.loanRateFloatReportDao = loanRateFloatReportDao;
	}
	@Override
	public List<LoanRateFloatReport> queryLoanRateFloatReport(MUOUserSession muo,LoanRateFloatReport loanRateFloatReport, Page page) {
		
		
		Map<String, Object>map = new HashMap<String, Object>();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 StringBuffer stringBuffer = new StringBuffer();
			
		 try {
		if (loanRateFloatReport.getMakeLoansDateStart()!=null&&!"".equals(loanRateFloatReport.getMakeLoansDateStart())) {
				map.put("startTime", sdf.format(sdf1.parse(loanRateFloatReport.getMakeLoansDateStart())));
			
		}
		if (loanRateFloatReport.getMakeLoansDateEnd()!=null&&!"".equals(loanRateFloatReport.getMakeLoansDateEnd())) {
			map.put("endTime",sdf.format(sdf1.parse(loanRateFloatReport.getMakeLoansDateEnd())));
		}
		 } catch (ParseException e) {
				e.printStackTrace();
			}
		 //一级支行
		 if(loanRateFloatReport.getOrgCodeOne()!=null && !"".equals(loanRateFloatReport.getOrgCodeOne())){
				map.put("orgCodeOne", loanRateFloatReport.getOrgCodeOne());
			}
		 //二级支行
		  if(loanRateFloatReport.getOrgCodeTwo()!=null && !"".equals(loanRateFloatReport.getOrgCodeTwo())){
				map.put("orgCodeTwo", loanRateFloatReport.getOrgCodeTwo());
			}
		 //一级分类
		if (loanRateFloatReport.getOneCategoryId()!=null&&!"".equals(loanRateFloatReport.getOneCategoryId())) {
				String[] oneCategorys=loanRateFloatReport.getOneCategoryId().split(", ");
				String oneCategory="";
				try {
					oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
				} catch (Exception e) {
					e.printStackTrace();
				}
				map.put("oneCategory", oneCategory);
			}
		//货贷种类
		if (loanRateFloatReport.getLoanCategoryId() !=null&&!"".equals(loanRateFloatReport.getLoanCategoryId() )) {
			String[] loanCategorys=loanRateFloatReport.getLoanCategoryId().split(", ");
			String loanCategory="";
			try {
				loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
			} catch (Exception e) {
				e.printStackTrace();
			}
			 map.put("loanCategory",loanCategory);
		}
		//主调信贷员
		if(loanRateFloatReport.getCreatorName()!=null && !"".equals(loanRateFloatReport.getCreatorName())){
			map.put("creatorName", loanRateFloatReport.getCreatorName());
		}
		//营业主管
		if(loanRateFloatReport.getYyzg()!=null && !"".equals(loanRateFloatReport.getYyzg())){
			map.put("yxzg", loanRateFloatReport.getYyzg());
		}
		//利率区间(起)
	    if (loanRateFloatReport.getRateStart()!=null&&!"".equals(loanRateFloatReport.getRateStart())) {
	    	map.put("rateStart", loanRateFloatReport.getRateStart());
		
	    }
	    //利率区间(止)
	    if (loanRateFloatReport.getRateEnd()!=null&&!"".equals(loanRateFloatReport.getRateEnd())) {
	    	map.put("rateEnd", loanRateFloatReport.getRateEnd());
	    }
	    Long orgid = muo.getOrgid();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("orgid", orgid);
		
		//判断当前登录的机构是否属于 一类支行的本级及下级机构
		List<Omorganization> oms = this.loanRateFloatReportDao.isOneOrg(map2);
		if(oms.size() > 0){ //属于 一类支行的本级机下级机构
			
			if(orgid == 5478){ //当前登录机构就是 一类支行
				map.put("org_flag", 1);  /*信贷流程查询提交机构是本级及下级的机构 */
				map.put("orgid", orgid);
			}else if(oms.get(0).getParentOrgId() == 5478){ //当前登录机构是 一类支行 的区支行
				map.put("org_flag", 1);  /*信贷流程查询提交机构是当前登录机构的本级及下级的机构 */
				map.put("orgid", orgid);
			}else{ //当前登录机构是 一类支行 的区支行 下级的支行
				map.put("org_flag", 2);  /*信贷流程查询提交机构是当前登录机构的父类机构的本级及下级的机构 */
				map.put("orgid", orgid);
			}
			
		}
	    
		List<LoanRateFloatReport> loanRateFloatReports = loanRateFloatReportDao.queryLoanRateFloatReport(map,page);
		
		for (int i = 0; i < loanRateFloatReports.size(); i++) {
			loanRateFloatReports.get(i).setNums("1");
			
		}
		return loanRateFloatReports;
	}
	@Override
	public List<LoanRateFloatReport> queryLoanRateFloatReportExcel(MUOUserSession muo,LoanRateFloatReport loanRateFloatReport) {
		
		Map<String, Object>map = new HashMap<String, Object>();
				if (loanRateFloatReport.getMakeLoansDateStart()!=null&&!"".equals(loanRateFloatReport.getMakeLoansDateStart())) {
						map.put("startTime", loanRateFloatReport.getMakeLoansDateStart());
					
				}
				if (loanRateFloatReport.getMakeLoansDateEnd()!=null&&!"".equals(loanRateFloatReport.getMakeLoansDateEnd())) {
					map.put("endTime",loanRateFloatReport.getMakeLoansDateEnd());
				}
				 
				 //一级支行
				 if(loanRateFloatReport.getOrgCodeOne()!=null && !"".equals(loanRateFloatReport.getOrgCodeOne())){
						map.put("orgCodeOne", loanRateFloatReport.getOrgCodeOne());
					}
				 //二级支行
				  if(loanRateFloatReport.getOrgCodeTwo()!=null && !"".equals(loanRateFloatReport.getOrgCodeTwo())){
						map.put("orgCodeTwo", loanRateFloatReport.getOrgCodeTwo());
					}
				 //一级分类
				if (loanRateFloatReport.getOneCategoryId()!=null&&!"".equals(loanRateFloatReport.getOneCategoryId())) {
						String[] oneCategorys=loanRateFloatReport.getOneCategoryId().split(", ");
						String oneCategory="";
						try {
							oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
						} catch (Exception e) {
							e.printStackTrace();
						}
						map.put("oneCategory", oneCategory);
					}
				//货贷种类
				if (loanRateFloatReport.getLoanCategoryId() !=null&&!"".equals(loanRateFloatReport.getLoanCategoryId() )) {
					String[] loanCategorys=loanRateFloatReport.getLoanCategoryId().split(", ");
					String loanCategory="";
					try {
						loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
					} catch (Exception e) {
						e.printStackTrace();
					}
					 map.put("loanCategory",loanCategory);
				}
				//主调信贷员
				if(loanRateFloatReport.getCreatorName()!=null && !"".equals(loanRateFloatReport.getCreatorName())){
					map.put("creatorName", loanRateFloatReport.getCreatorName());
				}
				//营业主管
				if(loanRateFloatReport.getYyzg()!=null && !"".equals(loanRateFloatReport.getYyzg())){
					map.put("yxzg", loanRateFloatReport.getYyzg());
				}
				//利率区间(起)
			    if (loanRateFloatReport.getRateStart()!=null&&!"".equals(loanRateFloatReport.getRateStart())) {
			    	map.put("rateStart", loanRateFloatReport.getRateStart());
				
			    }
			    //利率区间(止)
			    if (loanRateFloatReport.getRateEnd()!=null&&!"".equals(loanRateFloatReport.getRateEnd())) {
			    	map.put("rateEnd", loanRateFloatReport.getRateEnd());
			    }
		
		List<LoanRateFloatReport> loanRateFloatReports = loanRateFloatReportDao.queryLoanRateFloatReportForExcel(map);
		for (int i = 0; i < loanRateFloatReports.size(); i++) {
			loanRateFloatReports.get(i).setNums("1");
			
		}
		return loanRateFloatReports;
	}

}
