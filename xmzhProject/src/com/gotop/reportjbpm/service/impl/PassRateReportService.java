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
import com.gotop.vo.system.MUOUserSession;
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
	public List<PassRateReport> queryPassRateReportList(MUOUserSession muo, PassRateReport passRateReport, Page page) {
		List<PassRateReport> passRateReportList=new ArrayList<PassRateReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		
		String orgcode = muo.getOrgcode();
		List list  = passRateReportDao.yesOrNot_dep(orgcode); //查询当前机构是部门还是机构
		
		if (list.size() != 0){
			 HashMap<String, Object>  hp = (HashMap<String, Object>) list.get(0);
			 if("no".equals(hp.get("IS_DEP"))) { //当前机构不是部门，说明是支行
				 map.put("defaultOrgcode", hp.get("ORGCODE")); //查询列表默认显示本级及下级的数据
			 }
		}
		
	
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
	public List<PassRateReport> queryPassRateReportListForExcel(MUOUserSession muo,PassRateReport passRateReport) {
		
		Map<String, Object>map=new HashMap<String, Object>();
		String orgcode = muo.getOrgcode();
		List list  = passRateReportDao.yesOrNot_dep(orgcode); //查询当前机构是部门还是机构
		
		if (list.size() != 0){
			 HashMap<String, Object>  hp = (HashMap<String, Object>) list.get(0);
			 if("no".equals(hp.get("IS_DEP"))) { //当前机构不是部门，说明是支行
				 map.put("defaultOrgcode", hp.get("ORGCODE")); //查询列表默认显示本级及下级的数据
			 }
		}
		
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
		
		List<PassRateReport> passRateReportLists  =passRateReportDao.queryPassRateReportListForExcel(map);
		
		return passRateReportLists;
	}

}
