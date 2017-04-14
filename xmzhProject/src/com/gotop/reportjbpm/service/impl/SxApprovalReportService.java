package com.gotop.reportjbpm.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gotop.reportjbpm.dao.ISxApprovalReportDao;
import com.gotop.reportjbpm.model.SxApprovalReport;
import com.gotop.reportjbpm.service.ISxApprovalReportService;
import com.primeton.utils.Page;

public class SxApprovalReportService implements ISxApprovalReportService  {

	public ISxApprovalReportDao getSxApprovalReportDao() {
		return sxApprovalReportDao;
	}

	public void setSxApprovalReportDao(ISxApprovalReportDao sxApprovalReportDao) {
		this.sxApprovalReportDao = sxApprovalReportDao;
	}

	private ISxApprovalReportDao sxApprovalReportDao;
	@Override
	public List<SxApprovalReport> querySxApprovalReportList(
			SxApprovalReport sxApprovalReport, Page page,List<SxApprovalReport> sxApprovalReportTitleList) {
		List<SxApprovalReport> sxApprovalReportList =new ArrayList<SxApprovalReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		System.out.println("开始行:"+page.getBegin());
		int endPage=page.getBegin()+page.getLength();
		System.out.println("结束行:"+endPage);
		//是否有结果集
		map.put("beginPage", page.getBegin());
		map.put("endPage",endPage);
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<2;i++){
			String temp=sxApprovalReportTitleList.get(i).getOneCategory();
			if(i==0){
				sb.append("'");	
			}
			sb.append(temp);
			if(i!=1){
				sb.append("','");	
			}else if(i==1){
				sb.append("'");	
			}
		}
		
		StringBuffer sb2=new StringBuffer();
		for(int i=0;i<2;i++){
			String temp=sxApprovalReportTitleList.get(i).getOneCategory();
			if(i==0){
				sb2.append("\"'");	
			}
			sb2.append(temp);
			if(i!=1){
				sb2.append("\"',\"'");	
			}else if(i==1){
				sb2.append("\"'");	
			}
		}
		
		StringBuffer sb3=new StringBuffer();
		for(int i=0;i<2;i++){
			String temp=sxApprovalReportTitleList.get(i).getOneCategory();
			if(i==0){
				sb3.append("\"'");	
			}
			
                
				sb3.append(temp);
				sb3.append("'_A\", \"'");	
				sb3.append(temp);
				if(i==1){
					sb3.append("'_B\"");	
				}else{
					sb3.append("'_B\", \"'");	
				}
				
		
		}
		
		StringBuffer sb4=new StringBuffer();
		for(int i=0;i<2;i++){
			String temp=sxApprovalReportTitleList.get(i).getOneCategory();
			if(i==0){
				sb4.append("SUM(\"'");	
			}
			
                
				sb4.append(temp);
				sb4.append("'_A\"), SUM(\"'");	
				sb4.append(temp);
				if(i==1){
					sb4.append("'_B\")");	
				}else{
					sb4.append("'_B\"), SUM(\"'");	
				}
				
		
		}
		System.out.println("sssss:"+sb.toString());
	//	System.out.println("sssss222222:"+sb2.toString());
		System.out.println("sssss22222233:"+sb3.toString());
		System.out.println("sssss2222223377777777777:"+sb4.toString());
		map.put("oneParams", sb.toString());
	//map.put("twoParams", sb.toString());
		map.put("threeParams", sb3.toString());
		map.put("fourParams", sb4.toString());
		sxApprovalReportList=sxApprovalReportDao.querySxApprovalReportList(map);
		return sxApprovalReportList;
	}

	@Override
	public List<SxApprovalReport> querySxApprovalReportListForExcel(
			SxApprovalReport sxApprovalReport) {
		return null;
	}

	@Override
	public List<SxApprovalReport> querySxApprovalReportTitleList(
			SxApprovalReport sxApprovalReport) {
		 List<SxApprovalReport> sxApprovalReportTitleList =new ArrayList<SxApprovalReport>();
		 Map<String, Object>map=new HashMap<String, Object>();
		 sxApprovalReportTitleList=sxApprovalReportDao.querySxApprovalReportTitleList(map);
		return sxApprovalReportTitleList;
	}

	@Override
	public List<SxApprovalReport> querySxApprovalReportOrgNameOneList(
			SxApprovalReport sxApprovalReport, Page page) {
		List<SxApprovalReport> sxApprovalReportOrgNameOneList =new ArrayList<SxApprovalReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		sxApprovalReportOrgNameOneList=sxApprovalReportDao.querySxApprovalReportOrgNameOneList(map, page);
		return sxApprovalReportOrgNameOneList;
	}

	

}
