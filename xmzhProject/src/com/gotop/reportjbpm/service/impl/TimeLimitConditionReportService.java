package com.gotop.reportjbpm.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gotop.reportjbpm.dao.ITimeLimitConditionReportDao;
import com.gotop.reportjbpm.model.TimeLimitConditionReport;
import com.gotop.reportjbpm.service.ITimeLimitConditionReportService;
import com.gotop.util.string.Obj2StrUtils;
import com.primeton.utils.Page;

public class TimeLimitConditionReportService implements ITimeLimitConditionReportService  {

	private ITimeLimitConditionReportDao timeLimitConditionReportDao;
	

	public ITimeLimitConditionReportDao getTimeLimitConditionReportDao() {
		return timeLimitConditionReportDao;
	}

	public void setTimeLimitConditionReportDao(
			ITimeLimitConditionReportDao timeLimitConditionReportDao) {
		this.timeLimitConditionReportDao = timeLimitConditionReportDao;
	}

	@Override
	public List<TimeLimitConditionReport> queryTimeLimitConditionReportList(
			TimeLimitConditionReport timeLimitConditionReport, Page page) {
	    List<TimeLimitConditionReport> timeLimitConditionReportList =new ArrayList<TimeLimitConditionReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		if(timeLimitConditionReport.getRepTimeStart()!=null&&!"".equals(timeLimitConditionReport.getRepTimeStart())){
			map.put("repTimeStart", timeLimitConditionReport.getRepTimeStart());
			
		}
		if(timeLimitConditionReport.getRepTimeEnd()!=null&&!"".equals(timeLimitConditionReport.getRepTimeEnd())){
			map.put("repTimeEnd", timeLimitConditionReport.getRepTimeEnd());
			
		}
		if(timeLimitConditionReport.getOrgCodeOne()!=null&&!"".equals(timeLimitConditionReport.getOrgCodeOne())){
			map.put("orgCodeOne", timeLimitConditionReport.getOrgCodeOne());
			
		}
		
		if(timeLimitConditionReport.getOrgCodeTwo()!=null&&!"".equals(timeLimitConditionReport.getOrgCodeTwo())){
			map.put("orgCodeTwo", timeLimitConditionReport.getOrgCodeTwo());
			
		}
		if(timeLimitConditionReport.getOneCategory()!=null && !"".equals(timeLimitConditionReport.getOneCategory())){
			String[] oneCategorys=timeLimitConditionReport.getOneCategory().split(", ");
			String oneCategory="";
			try {
				oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("oneCategory",oneCategory);
		}
		if(timeLimitConditionReport.getLoanCategory()!=null && !"".equals(timeLimitConditionReport.getLoanCategory())){
			String[] loanCategorys=timeLimitConditionReport.getLoanCategory().split(", ");
			String loanCategory="";
			try {
				loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("loanCategory",loanCategory);
		}
		
		
		
		if(timeLimitConditionReport.getZdCustManager()!=null&&!"".equals(timeLimitConditionReport.getZdCustManager())){
			map.put("zdCustManager", timeLimitConditionReport.getZdCustManager());
			
		}
		timeLimitConditionReportList=timeLimitConditionReportDao.queryTimeLimitConditionReportList(map, page);
		return timeLimitConditionReportList;
	}

	@Override
	public List<TimeLimitConditionReport> queryTimeLimitConditionReportListForExcel(
			TimeLimitConditionReport timeLimitConditionReport) {
		List<TimeLimitConditionReport> timeLimitConditionReportList =new ArrayList<TimeLimitConditionReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		if(timeLimitConditionReport.getRepTimeStart()!=null&&!"".equals(timeLimitConditionReport.getRepTimeStart())){
			map.put("repTimeStart", timeLimitConditionReport.getRepTimeStart());
			
		}
		if(timeLimitConditionReport.getRepTimeEnd()!=null&&!"".equals(timeLimitConditionReport.getRepTimeEnd())){
			map.put("repTimeEnd", timeLimitConditionReport.getRepTimeEnd());
			
		}
		if(timeLimitConditionReport.getOrgCodeOne()!=null&&!"".equals(timeLimitConditionReport.getOrgCodeOne())){
			map.put("orgCodeOne", timeLimitConditionReport.getOrgCodeOne());
			
		}
		
		if(timeLimitConditionReport.getOrgCodeTwo()!=null&&!"".equals(timeLimitConditionReport.getOrgCodeTwo())){
			map.put("orgCodeTwo", timeLimitConditionReport.getOrgCodeTwo());
			
		}
		if(timeLimitConditionReport.getOneCategory()!=null && !"".equals(timeLimitConditionReport.getOneCategory())){
			String[] oneCategorys=timeLimitConditionReport.getOneCategory().split(", ");
			String oneCategory="";
			try {
				oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("oneCategory",oneCategory);
		}
		if(timeLimitConditionReport.getLoanCategory()!=null && !"".equals(timeLimitConditionReport.getLoanCategory())){
			String[] loanCategorys=timeLimitConditionReport.getLoanCategory().split(", ");
			String loanCategory="";
			try {
				loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("loanCategory",loanCategory);
		}
		
		
		
		if(timeLimitConditionReport.getZdCustManager()!=null&&!"".equals(timeLimitConditionReport.getZdCustManager())){
			map.put("zdCustManager", timeLimitConditionReport.getZdCustManager());
			
		}
		timeLimitConditionReportList=timeLimitConditionReportDao.queryTimeLimitConditionReportListForExcel(map);
		return timeLimitConditionReportList;
	}


}
