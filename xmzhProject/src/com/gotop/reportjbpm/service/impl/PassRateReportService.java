package com.gotop.reportjbpm.service.impl;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.IPassRateReportDao;
import com.gotop.reportjbpm.model.PassRateReport;
import com.gotop.reportjbpm.service.IPassRateReportService;
import com.gotop.util.string.Obj2StrUtils;
import com.primeton.utils.Page;

public class PassRateReportService implements IPassRateReportService {

	private IPassRateReportDao passRateReportDao;
	
	

	public IPassRateReportDao getPassRateReportDao() {
		return passRateReportDao;
	}

	public void setPassRateReportDao(IPassRateReportDao passRateReportDao) {
		this.passRateReportDao = passRateReportDao;
	}

	@Override
	public List<PassRateReport> queryPassRateReportList(PassRateReport passRateReport, Page page) {
		List<PassRateReport> passRateReportList=new ArrayList<PassRateReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		//SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
		if (passRateReport.getRepTimeStart() !=null&&!"".equals(passRateReport.getRepTimeStart())) {
		
				map.put("repTimeStrat",passRateReport.getRepTimeStart());
			
		}
		if (passRateReport.getRepTimeEnd() !=null&&!"".equals(passRateReport.getRepTimeEnd())) {
			map.put("repTimeEnd",  passRateReport.getRepTimeEnd());
		}
		//一级支行
				if(passRateReport.getOrgCodeOne()!=null && !"".equals(passRateReport.getOrgCodeOne())){
					map.put("orgCodeOne", passRateReport.getOrgCodeOne());
				}
				 //二级支行
				if(passRateReport.getOrgCodeTwo()!=null && !"".equals(passRateReport.getOrgCodeTwo())){
					map.put("orgCodeTwo", passRateReport.getOrgCodeTwo());
				}
				if (passRateReport.getOneCategoryId()!=null&&!"".equals(passRateReport.getOneCategoryId())) {
					String[] oneCategorys=passRateReport.getOneCategoryId().split(", ");
					String oneCategory="";
					try {
						oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
					} catch (Exception e) {
						e.printStackTrace();
					}
					map.put("oneCategory", oneCategory);
				}
				if (passRateReport.getLoanCategoryId() !=null&&!"".equals(passRateReport.getLoanCategoryId() )) {
					String[] loanCategorys=passRateReport.getLoanCategoryId().split(", ");
					String loanCategory="";
					try {
						loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
					} catch (Exception e) {
						e.printStackTrace();
					}
					 map.put("loanCategory",loanCategory);
				}
		
				//审查人
				if(passRateReport.getReviewEmpname()!=null && !"".equals(passRateReport.getReviewEmpname())){
					map.put("reviewEmpname", passRateReport.getReviewEmpname());
				}
				//审批人
				if(passRateReport.getApprovalEmpname()!=null && !"".equals(passRateReport.getApprovalEmpname())){
					map.put("approvalEmpname", passRateReport.getApprovalEmpname());
				}
		
		List<PassRateReport> passRateReportLists  =passRateReportDao.queryPassRateReportList(map,page);
		
		return passRateReportLists;
	}

	@Override
	public List<PassRateReport> queryPassRateReportListForExcel(PassRateReport passRateReport) {
		Map<String, Object>map=new HashMap<String, Object>();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
	  try {
			if (passRateReport.getRepTimeStart() !=null&&!"".equals(passRateReport.getRepTimeStart())) {
				map.put("repTimeStrat",sdf.format(sdf1.parse(passRateReport.getRepTimeStart())));
					
			}
			if (passRateReport.getRepTimeEnd() !=null&&!"".equals(passRateReport.getRepTimeEnd())) {
				map.put("repTimeEnd",  sdf.format(sdf1.parse(passRateReport.getRepTimeEnd())));
			}
		  } catch (ParseException e) {
				e.printStackTrace();
		 }
			

		
		//一级支行
		if(passRateReport.getOrgCodeOne()!=null && !"".equals(passRateReport.getOrgCodeOne())){
			map.put("orgCodeOne", passRateReport.getOrgCodeOne());
		}
		 //二级支行
		if(passRateReport.getOrgCodeTwo()!=null && !"".equals(passRateReport.getOrgCodeTwo())){
			map.put("orgCodeTwo", passRateReport.getOrgCodeTwo());
		}
		if (passRateReport.getOneCategoryId()!=null&&!"".equals(passRateReport.getOneCategoryId())) {
			String[] oneCategorys=passRateReport.getOneCategoryId().split(", ");
			String oneCategory="";
			try {
				oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("oneCategory", oneCategory);
		}
		if (passRateReport.getLoanCategoryId() !=null&&!"".equals(passRateReport.getLoanCategoryId() )) {
			String[] loanCategorys=passRateReport.getLoanCategoryId().split(", ");
			String loanCategory="";
			try {
				loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
			} catch (Exception e) {
				e.printStackTrace();
			}
			 map.put("loanCategory",loanCategory);
		}
		
		//审查人
		if(passRateReport.getReviewEmpname()!=null && !"".equals(passRateReport.getReviewEmpname())){
			map.put("reviewEmpname", passRateReport.getReviewEmpname());
		}
		//审批人
		if(passRateReport.getApprovalEmpname()!=null && !"".equals(passRateReport.getApprovalEmpname())){
			map.put("approvalEmpname", passRateReport.getApprovalEmpname());
		}
		
		List<PassRateReport> passRateReportLists  =passRateReportDao.queryPassRateReportListForExcel(map);
		
		return passRateReportLists;
	}

}
