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
		
		

		List<PassRateReport> passRateReportLists  =passRateReportDao.queryPassRateReportList(map,page);
		for (int i = 0; i < passRateReportLists.size(); i++) {
			 NumberFormat percent = NumberFormat.getPercentInstance();
		     percent.setMaximumFractionDigits(2);
			BigDecimal businessNumberOne=new BigDecimal(passRateReportLists.get(i).getBusinessNumberOne());
			BigDecimal businessNumberTwo=new BigDecimal(passRateReportLists.get(i).getBusinessNumberTwo());
			BigDecimal businessNumberThree=new BigDecimal(passRateReportLists.get(i).getBusinessNumberThree());
			BigDecimal businessNumberMoreThree=new BigDecimal(passRateReportLists.get(i).getBusinessNumberMoreThree());
			BigDecimal businessNumberMoreFour=new BigDecimal(passRateReportLists.get(i).getBusinessNumberMoreFour());
			int r1=businessNumberOne.compareTo(BigDecimal.ZERO);
			int r2=businessNumberTwo.compareTo(BigDecimal.ZERO);
			int r3=businessNumberThree.compareTo(BigDecimal.ZERO);
			int r4=businessNumberMoreThree.compareTo(BigDecimal.ZERO);
			int r5=businessNumberMoreFour.compareTo(BigDecimal.ZERO);
			if(r1!=0 && r2!=0){
				BigDecimal onePassRate=businessNumberOne.divide(businessNumberOne.add(businessNumberTwo), 4,  BigDecimal.ROUND_HALF_UP);//ROUND_DOWN直接截断
				passRateReportLists.get(i).setOnePassRate(percent.format(onePassRate.doubleValue()));
			}
			if(r2!=0 && r3!=0){
				BigDecimal twoPassRate=businessNumberTwo.divide(businessNumberTwo.add(businessNumberThree), 4,  BigDecimal.ROUND_HALF_UP);
				passRateReportLists.get(i).setTwoPassRate(percent.format(twoPassRate.doubleValue()));
			}
			if(r4!=0 && r5!=0){
				BigDecimal threeOrMorePassRate=businessNumberMoreThree.divide(businessNumberMoreThree.add(businessNumberMoreFour), 4,  BigDecimal.ROUND_HALF_UP);
				passRateReportLists.get(i).setThreeOrMorePassRate(percent.format(threeOrMorePassRate.doubleValue()));
			}
				
			
		}
		
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
		List<PassRateReport> passRateReportLists  =passRateReportDao.queryPassRateReportListForExcel(map);
		for (int i = 0; i < passRateReportLists.size(); i++) {
			 NumberFormat percent = NumberFormat.getPercentInstance();
		     percent.setMaximumFractionDigits(2);
			BigDecimal businessNumberOne=new BigDecimal(passRateReportLists.get(i).getBusinessNumberOne());
			BigDecimal businessNumberTwo=new BigDecimal(passRateReportLists.get(i).getBusinessNumberTwo());
			BigDecimal businessNumberThree=new BigDecimal(passRateReportLists.get(i).getBusinessNumberThree());
			BigDecimal businessNumberMoreThree=new BigDecimal(passRateReportLists.get(i).getBusinessNumberMoreThree());
			BigDecimal businessNumberMoreFour=new BigDecimal(passRateReportLists.get(i).getBusinessNumberMoreFour());
			int r1=businessNumberOne.compareTo(BigDecimal.ZERO);
			int r2=businessNumberTwo.compareTo(BigDecimal.ZERO);
			int r3=businessNumberThree.compareTo(BigDecimal.ZERO);
			int r4=businessNumberMoreThree.compareTo(BigDecimal.ZERO);
			int r5=businessNumberMoreFour.compareTo(BigDecimal.ZERO);
			if(r1!=0 && r2!=0){
				BigDecimal onePassRate=businessNumberOne.divide(businessNumberOne.add(businessNumberTwo), 4,  BigDecimal.ROUND_HALF_UP);//ROUND_DOWN直接截断
				passRateReportLists.get(i).setOnePassRate(percent.format(onePassRate.doubleValue()));
			}
			if(r2!=0 && r3!=0){
				BigDecimal twoPassRate=businessNumberTwo.divide(businessNumberTwo.add(businessNumberThree), 4,  BigDecimal.ROUND_HALF_UP);
				passRateReportLists.get(i).setTwoPassRate(percent.format(twoPassRate.doubleValue()));
			}
			if(r4!=0 && r5!=0){
				BigDecimal threeOrMorePassRate=businessNumberMoreThree.divide(businessNumberMoreThree.add(businessNumberMoreFour), 4,  BigDecimal.ROUND_HALF_UP);
				passRateReportLists.get(i).setThreeOrMorePassRate(percent.format(threeOrMorePassRate.doubleValue()));
			}
				
			
		}
		
		return passRateReportLists;
	}

}
