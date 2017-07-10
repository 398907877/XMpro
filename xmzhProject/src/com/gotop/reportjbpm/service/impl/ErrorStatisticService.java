package com.gotop.reportjbpm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.enterprisedt.util.debug.Logger;
import com.gotop.reportjbpm.dao.IErrorStatisticDao;
import com.gotop.reportjbpm.model.ErrorStatistic;
import com.gotop.reportjbpm.service.IErrorStatisticService;
import com.gotop.util.string.Obj2StrUtils;
import com.primeton.utils.Page;

public class ErrorStatisticService implements IErrorStatisticService {

	protected Logger log = Logger.getLogger(ErrorStatisticService.class);
	private IErrorStatisticDao errorStatisticDao;
	
	public IErrorStatisticDao getErrorStatisticDao() {
		return errorStatisticDao;
	}
	public void setErrorStatisticDao(IErrorStatisticDao errorStatisticDao) {
		this.errorStatisticDao = errorStatisticDao;
	}
	

	@Override
	public List<ErrorStatistic> queryErrorStatistic(ErrorStatistic errorStatistic, Page page) {
		
		
		Map<String, Object>map = new HashMap<String, Object>();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 StringBuffer stringBuffer = new StringBuffer();
		 if (errorStatistic.getTaskName()!=null&&!"".equals(errorStatistic.getTaskName())) {
			 String[] array =errorStatistic.getTaskName().split(",");
			 for (int i = 0; i < array.length; i++) {
				 stringBuffer.append("'");
				stringBuffer.append(array[i]);
				stringBuffer.append("'");
				stringBuffer.append(",");
			}
			 stringBuffer=stringBuffer.deleteCharAt(stringBuffer.length()-1);
			 
			 map.put("taskName", stringBuffer); 
		}
			
		 try {
		if (errorStatistic.getStartTime()!=null&&!"".equals(errorStatistic.getStartTime())) {
				map.put("startTime", sdf.format(sdf1.parse(errorStatistic.getStartTime())));
			
		}
		if (errorStatistic.getEndTime()!=null&&!"".equals(errorStatistic.getEndTime())) {
			map.put("endTime",sdf.format(sdf1.parse(errorStatistic.getEndTime())));
		}
		 } catch (ParseException e) {
				e.printStackTrace();
			}
		if (errorStatistic.getCustName()!=null&&!"".equals(errorStatistic.getCustName())) {
			map.put("custName", errorStatistic.getCustName());
		}
		
		if (errorStatistic.getYxzg()!=null&&!"".equals(errorStatistic.getYxzg())) {
			map.put("yxzg", errorStatistic.getYxzg());
		}
		
		if (errorStatistic.getCreatorName()!=null&&!"".equals(errorStatistic.getCreatorName())) {
			map.put("creatorName", errorStatistic.getCreatorName());
		}
		
		if(errorStatistic.getOneCategory()!=null && !"".equals(errorStatistic.getOneCategory())){
			String[] oneCategorys=errorStatistic.getOneCategory().split(", ");
			String oneCategory="";
			try {
				oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("oneCategory",oneCategory);
		}
		if(errorStatistic.getLoanCategory()!=null && !"".equals(errorStatistic.getLoanCategory())){
			String[] loanCategorys=errorStatistic.getLoanCategory().split(", ");
			String loanCategory="";
			try {
				loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("loanCategory",loanCategory);
		}
		
		 if(!"".equals(errorStatistic.getOrgCodeOne()) && errorStatistic.getOrgCodeOne()!=null){

			   String orgCodeOne=errorStatistic.getOrgCodeOne();
				map.put("orgCodeOne", orgCodeOne);
		}
		 
		 if(!"".equals(errorStatistic.getOrgCodeTwo()) && errorStatistic.getOrgCodeTwo()!=null){

			   String orgCodeTwo=errorStatistic.getOrgCodeTwo();
				map.put("orgCodeTwo", orgCodeTwo);
		}
		
		
		List<ErrorStatistic> errorStatistics = errorStatisticDao.queryErrorStatistic(map,page);
		
		for (int i = 0; i < errorStatistics.size(); i++) {
			errorStatistics.get(i).setMistakeNumber("1");
			
		}
		return errorStatistics;
	}
	@Override
	public List<ErrorStatistic> queryErrorStatisticExcel(ErrorStatistic errorStatistic) {
		
		Map<String, Object>map = new HashMap<String, Object>();
		 StringBuffer stringBuffer = new StringBuffer();
		 if (errorStatistic.getTaskName()!=null&&!"".equals(errorStatistic.getTaskName())) {
			 String[] array =errorStatistic.getTaskName().split(",");
			 for (int i = 0; i < array.length; i++) {
				 stringBuffer.append("'");
				stringBuffer.append(array[i]);
				stringBuffer.append("'");
				stringBuffer.append(",");
			}
			 stringBuffer=stringBuffer.deleteCharAt(stringBuffer.length()-1);
			 
			 map.put("taskName", stringBuffer); 
		}
			
		
		if (errorStatistic.getStartTime()!=null&&!"".equals(errorStatistic.getStartTime())) {
			map.put("startTime", errorStatistic.getStartTime());
		}
		if (errorStatistic.getEndTime()!=null&&!"".equals(errorStatistic.getEndTime())) {
			map.put("endTime", errorStatistic.getEndTime());
		}
		if (errorStatistic.getCustName()!=null&&!"".equals(errorStatistic.getCustName())) {
			map.put("custName", errorStatistic.getCustName());
		}
		
		if (errorStatistic.getYxzg()!=null&&!"".equals(errorStatistic.getYxzg())) {
			map.put("yxzg", errorStatistic.getYxzg());
		}
		
		if (errorStatistic.getCreatorName()!=null&&!"".equals(errorStatistic.getCreatorName())) {
			map.put("creatorName", errorStatistic.getCreatorName());
		}
		
		if(errorStatistic.getOneCategory()!=null && !"".equals(errorStatistic.getOneCategory())){
			String[] oneCategorys=errorStatistic.getOneCategory().split(", ");
			String oneCategory="";
			try {
				oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("oneCategory",oneCategory);
		}
		if(errorStatistic.getLoanCategory()!=null && !"".equals(errorStatistic.getLoanCategory())){
			String[] loanCategorys=errorStatistic.getLoanCategory().split(", ");
			String loanCategory="";
			try {
				loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("loanCategory",loanCategory);
		}
		
		 if(!"".equals(errorStatistic.getOrgCodeOne()) && errorStatistic.getOrgCodeOne()!=null){

			   String orgCodeOne=errorStatistic.getOrgCodeOne();
				map.put("orgCodeOne", orgCodeOne);
		}
		 
		 if(!"".equals(errorStatistic.getOrgCodeTwo()) && errorStatistic.getOrgCodeTwo()!=null){

			   String orgCodeTwo=errorStatistic.getOrgCodeTwo();
				map.put("orgCodeTwo", orgCodeTwo);
		}
		
		List<ErrorStatistic> errorStatistics = errorStatisticDao.queryErrorStatisticForExcel(map);
		for (int i = 0; i < errorStatistics.size(); i++) {
			errorStatistics.get(i).setMistakeNumber("1");
			
		}
		return errorStatistics;
	}
	@Override
	public List<ErrorStatistic> querytaskNameList() {
		List<ErrorStatistic> errorStatistics=errorStatisticDao.querytaskNameList();
		return errorStatistics;
	}
	@Override
	public List<ErrorStatistic> queryErrorStatisticSummary(
			ErrorStatistic errorStatistic, Page page) {
		
		Map<String, Object>map = new HashMap<String, Object>();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 StringBuffer stringBuffer = new StringBuffer();
		 if (errorStatistic.getTaskName()!=null&&!"".equals(errorStatistic.getTaskName())) {
			 String[] array =errorStatistic.getTaskName().split(",");
			 for (int i = 0; i < array.length; i++) {
				 stringBuffer.append("'");
				stringBuffer.append(array[i]);
				stringBuffer.append("'");
				stringBuffer.append(",");
			}
			 stringBuffer=stringBuffer.deleteCharAt(stringBuffer.length()-1);
			 
			 map.put("taskName", stringBuffer); 
		}
			
		 try {
		if (errorStatistic.getStartTime()!=null&&!"".equals(errorStatistic.getStartTime())) {
				map.put("startTime", sdf.format(sdf1.parse(errorStatistic.getStartTime())));
			
		}
		if (errorStatistic.getEndTime()!=null&&!"".equals(errorStatistic.getEndTime())) {
			map.put("endTime",sdf.format(sdf1.parse(errorStatistic.getEndTime())));
		}
		 } catch (ParseException e) {
				e.printStackTrace();
			}
		if (errorStatistic.getCustName()!=null&&!"".equals(errorStatistic.getCustName())) {
			map.put("custName", errorStatistic.getCustName());
		}
		
		if (errorStatistic.getYxzg()!=null&&!"".equals(errorStatistic.getYxzg())) {
			map.put("yxzg", errorStatistic.getYxzg());
		}
		
		if (errorStatistic.getCreatorName()!=null&&!"".equals(errorStatistic.getCreatorName())) {
			map.put("creatorName", errorStatistic.getCreatorName());
		}
		
		if(errorStatistic.getOneCategory()!=null && !"".equals(errorStatistic.getOneCategory())){
			String[] oneCategorys=errorStatistic.getOneCategory().split(", ");
			String oneCategory="";
			try {
				oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("oneCategory",oneCategory);
		}
		if(errorStatistic.getLoanCategory()!=null && !"".equals(errorStatistic.getLoanCategory())){
			String[] loanCategorys=errorStatistic.getLoanCategory().split(", ");
			String loanCategory="";
			try {
				loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("loanCategory",loanCategory);
		}
		
		 if(!"".equals(errorStatistic.getOrgCodeOne()) && errorStatistic.getOrgCodeOne()!=null){

			   String orgCodeOne=errorStatistic.getOrgCodeOne();
				map.put("orgCodeOne", orgCodeOne);
		}
		 
		 if(!"".equals(errorStatistic.getOrgCodeTwo()) && errorStatistic.getOrgCodeTwo()!=null){

			   String orgCodeTwo=errorStatistic.getOrgCodeTwo();
				map.put("orgCodeTwo", orgCodeTwo);
		}
		
		
		List<ErrorStatistic> errorStatistics = errorStatisticDao.queryErrorStatisticSummary(map,page);
		
		return errorStatistics;
		
	}
	@Override
	public List<ErrorStatistic> queryErrorStatisticSummaryForExcel(
			ErrorStatistic errorStatistic) {
		
		Map<String, Object>map = new HashMap<String, Object>();
		 StringBuffer stringBuffer = new StringBuffer();
		 if (errorStatistic.getTaskName()!=null&&!"".equals(errorStatistic.getTaskName())) {
			 String[] array =errorStatistic.getTaskName().split(",");
			 for (int i = 0; i < array.length; i++) {
				 stringBuffer.append("'");
				stringBuffer.append(array[i]);
				stringBuffer.append("'");
				stringBuffer.append(",");
			}
			 stringBuffer=stringBuffer.deleteCharAt(stringBuffer.length()-1);
			 
			 map.put("taskName", stringBuffer); 
		}
			
		
		if (errorStatistic.getStartTime()!=null&&!"".equals(errorStatistic.getStartTime())) {
			map.put("startTime", errorStatistic.getStartTime());
		}
		if (errorStatistic.getEndTime()!=null&&!"".equals(errorStatistic.getEndTime())) {
			map.put("endTime", errorStatistic.getEndTime());
		}
		if (errorStatistic.getCustName()!=null&&!"".equals(errorStatistic.getCustName())) {
			map.put("custName", errorStatistic.getCustName());
		}
		
		if (errorStatistic.getYxzg()!=null&&!"".equals(errorStatistic.getYxzg())) {
			map.put("yxzg", errorStatistic.getYxzg());
		}
		
		if (errorStatistic.getCreatorName()!=null&&!"".equals(errorStatistic.getCreatorName())) {
			map.put("creatorName", errorStatistic.getCreatorName());
		}
		
		if(errorStatistic.getOneCategory()!=null && !"".equals(errorStatistic.getOneCategory())){
			String[] oneCategorys=errorStatistic.getOneCategory().split(", ");
			String oneCategory="";
			try {
				oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("oneCategory",oneCategory);
		}
		if(errorStatistic.getLoanCategory()!=null && !"".equals(errorStatistic.getLoanCategory())){
			String[] loanCategorys=errorStatistic.getLoanCategory().split(", ");
			String loanCategory="";
			try {
				loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("loanCategory",loanCategory);
		}
		
		 if(!"".equals(errorStatistic.getOrgCodeOne()) && errorStatistic.getOrgCodeOne()!=null){

			   String orgCodeOne=errorStatistic.getOrgCodeOne();
				map.put("orgCodeOne", orgCodeOne);
		}
		 
		 if(!"".equals(errorStatistic.getOrgCodeTwo()) && errorStatistic.getOrgCodeTwo()!=null){

			   String orgCodeTwo=errorStatistic.getOrgCodeTwo();
				map.put("orgCodeTwo", orgCodeTwo);
		}
		
		List<ErrorStatistic> errorStatistics = errorStatisticDao.queryErrorStatisticSummaryForExcel(map);

		return errorStatistics;
	}

}
