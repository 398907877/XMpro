package com.gotop.reportjbpm.service.impl;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.IBjErrorNumReportDao;
import com.gotop.reportjbpm.model.BjErrorNumReport;
import com.gotop.reportjbpm.model.PassRateReport;
import com.gotop.reportjbpm.service.IBjErrorNumReportService;
import com.gotop.util.string.Obj2StrUtils;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public class BjErrorNumReportService implements IBjErrorNumReportService {

	private IBjErrorNumReportDao bjErrorNumReportDao;
	
	

	public IBjErrorNumReportDao getBjErrorNumReportDao() {
		return bjErrorNumReportDao;
	}

	public void setBjErrorNumReportDao(IBjErrorNumReportDao bjErrorNumReportDao) {
		this.bjErrorNumReportDao = bjErrorNumReportDao;
	}

	@Override
	public List<BjErrorNumReport> queryBjErrorNumReportList(MUOUserSession muo, BjErrorNumReport bjErrorNumReport, Page page) {
		
		List<BjErrorNumReport> bjErrorNumReportList=new ArrayList<BjErrorNumReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		
		String orgcode = muo.getOrgcode();
		List list  = bjErrorNumReportDao.yesOrNot_dep(orgcode); //查询当前机构是部门还是机构
		
		if (list.size() != 0){
			 HashMap<String, Object>  hp = (HashMap<String, Object>) list.get(0);
			 if("no".equals(hp.get("IS_DEP"))) { //当前机构不是部门，说明是支行
				 map.put("defaultOrgcode", hp.get("ORGCODE")); //查询列表默认显示本级及下级的数据
			 }
		}
		
		if (bjErrorNumReport.getRepTimeStart() !=null&&!"".equals(bjErrorNumReport.getRepTimeStart())) {
				map.put("repTimeStrat", bjErrorNumReport.getRepTimeStart());
		}
		
		if (bjErrorNumReport.getRepTimeEnd() !=null&&!"".equals(bjErrorNumReport.getRepTimeEnd())) {
				map.put("repTimeEnd",  bjErrorNumReport.getRepTimeEnd());
		}
		//一级支行
		if(bjErrorNumReport.getOrgCodeOne()!=null && !"".equals(bjErrorNumReport.getOrgCodeOne())){
			map.put("orgCodeOne", bjErrorNumReport.getOrgCodeOne());
		}
		 //二级支行
		if(bjErrorNumReport.getOrgCodeTwo()!=null && !"".equals(bjErrorNumReport.getOrgCodeTwo())){
			map.put("orgCodeTwo", bjErrorNumReport.getOrgCodeTwo());
		}
		if (bjErrorNumReport.getOneCategoryId()!=null&&!"".equals(bjErrorNumReport.getOneCategoryId())) {
			String[] oneCategorys=bjErrorNumReport.getOneCategoryId().split(", ");
			String oneCategory="";
			try {
				oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("oneCategory", oneCategory);
		}
		if (bjErrorNumReport.getLoanCategoryId() !=null&&!"".equals(bjErrorNumReport.getLoanCategoryId() )) {
			String[] loanCategorys=bjErrorNumReport.getLoanCategoryId().split(", ");
			String loanCategory="";
			try {
				loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
			} catch (Exception e) {
				e.printStackTrace();
			}
			 map.put("loanCategory",loanCategory);
		}
		
		
		List<BjErrorNumReport> bjErrorNumReportLists =bjErrorNumReportDao.queryBjErrorNumReportList(map,page);
		
		return bjErrorNumReportLists;
	}

	@Override
	public List<BjErrorNumReport> queryBjErrorNumReportListForExcel(MUOUserSession muo, BjErrorNumReport bjErrorNumReport) {
		
		List<BjErrorNumReport> bjErrorNumReportList=new ArrayList<BjErrorNumReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		
		String orgcode = muo.getOrgcode();
		List list  = bjErrorNumReportDao.yesOrNot_dep(orgcode); //查询当前机构是部门还是机构
		
		if (list.size() != 0){
			 HashMap<String, Object>  hp = (HashMap<String, Object>) list.get(0);
			 if("no".equals(hp.get("IS_DEP"))) { //当前机构不是部门，说明是支行
				 map.put("defaultOrgcode", hp.get("ORGCODE")); //查询列表默认显示本级及下级的数据
			 }
		}
		
		if (bjErrorNumReport.getRepTimeStart() !=null&&!"".equals(bjErrorNumReport.getRepTimeStart())) {
		
				map.put("repTimeStrat",bjErrorNumReport.getRepTimeStart());
			
		}
		if (bjErrorNumReport.getRepTimeEnd() !=null&&!"".equals(bjErrorNumReport.getRepTimeEnd())) {
			map.put("repTimeEnd",  bjErrorNumReport.getRepTimeEnd());
		}
		//一级支行
				if(bjErrorNumReport.getOrgCodeOne()!=null && !"".equals(bjErrorNumReport.getOrgCodeOne())){
					map.put("orgCodeOne", bjErrorNumReport.getOrgCodeOne());
				}
				 //二级支行
				if(bjErrorNumReport.getOrgCodeTwo()!=null && !"".equals(bjErrorNumReport.getOrgCodeTwo())){
					map.put("orgCodeTwo", bjErrorNumReport.getOrgCodeTwo());
				}
				if (bjErrorNumReport.getOneCategoryId()!=null&&!"".equals(bjErrorNumReport.getOneCategoryId())) {
					String[] oneCategorys=bjErrorNumReport.getOneCategoryId().split(", ");
					String oneCategory="";
					try {
						oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
					} catch (Exception e) {
						e.printStackTrace();
					}
					map.put("oneCategory", oneCategory);
				}
				if (bjErrorNumReport.getLoanCategoryId() !=null&&!"".equals(bjErrorNumReport.getLoanCategoryId() )) {
					String[] loanCategorys=bjErrorNumReport.getLoanCategoryId().split(", ");
					String loanCategory="";
					try {
						loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
					} catch (Exception e) {
						e.printStackTrace();
					}
					 map.put("loanCategory",loanCategory);
				}
				
		List<BjErrorNumReport> bjErrorNumReportLists =bjErrorNumReportDao.queryBjErrorNumReportListForExcel(map);
		
		return bjErrorNumReportLists;
	}

}
