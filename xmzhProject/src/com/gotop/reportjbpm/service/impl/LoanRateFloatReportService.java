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
		String orgcode = muo.getOrgcode();
		List list  = loanRateFloatReportDao.yesOrNot_dep(orgcode); //查询当前机构是部门还是机构
		
		if (list.size() != 0){
			 HashMap<String, Object>  hp = (HashMap<String, Object>) list.get(0);
			 if("no".equals(hp.get("IS_DEP"))) { //当前机构不是部门，说明是支行
				 map.put("defaultOrgcode", hp.get("ORGCODE")); //查询列表默认显示本级及下级的数据
			 }
		}
		
		 StringBuffer stringBuffer = new StringBuffer();
			
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
	    
	    
		List<LoanRateFloatReport> loanRateFloatReports = loanRateFloatReportDao.queryLoanRateFloatReport(map,page);
		
		return loanRateFloatReports;
	}
	@Override
	public List<LoanRateFloatReport> queryLoanRateFloatReportExcel(MUOUserSession muo,LoanRateFloatReport loanRateFloatReport) {
		
		Map<String, Object>map = new HashMap<String, Object>();
		String orgcode = muo.getOrgcode();
		List list  = loanRateFloatReportDao.yesOrNot_dep(orgcode); //查询当前机构是部门还是机构
		
		if (list.size() != 0){
			 HashMap<String, Object>  hp = (HashMap<String, Object>) list.get(0);
			 if("no".equals(hp.get("IS_DEP"))) { //当前机构不是部门，说明是支行
				 map.put("defaultOrgcode", hp.get("ORGCODE")); //查询列表默认显示本级及下级的数据
			 }
		}
		
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

		return loanRateFloatReports;
	}
	@Override
	public HashMap<String, Object> queryOrgInfoById(String orgid) {
		
		HashMap<String, Object> map = loanRateFloatReportDao.queryOrgInfoById(orgid);
		return map;
	}

}
