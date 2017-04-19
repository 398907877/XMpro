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
		
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<sxApprovalReportTitleList.size();i++){
			String temp=sxApprovalReportTitleList.get(i).getOneCategory();
			String temp1=sxApprovalReportTitleList.get(i).getOneCategoryName();
			if(i==0){
				sb.append("'");	
			}
			sb.append(temp);
			if(i!=sxApprovalReportTitleList.size()-1){
				sb.append("' ");	
				sb.append(temp1);	
				sb.append(",'");	
			}else if(i==sxApprovalReportTitleList.size()-1){
				sb.append("' ");		
				sb.append(temp1);
			}
		}
		
//		StringBuffer sb2=new StringBuffer();
//		for(int i=0;i<sxApprovalReportTitleList.size();i++){
//			String temp=sxApprovalReportTitleList.get(i).getOneCategory();
//			String temp1=sxApprovalReportTitleList.get(i).getOneCategoryNum();
//			if(i==0){
//				sb2.append("\"'");	
//			}
//			sb2.append(temp);
//			if(i!=sxApprovalReportTitleList.size()-1){
//				sb2.append("\"' ");
//
//				sb2.append(temp1);
//				sb2.append(",\"'");
//			}else if(i==sxApprovalReportTitleList.size()-1){
//				sb2.append("\"'");	
//			}
//		}
		
		StringBuffer sb3=new StringBuffer();
		for(int i=0;i<sxApprovalReportTitleList.size();i++){
			String tempNum=sxApprovalReportTitleList.get(i).getOneCategoryNum();
			String tempMoney=sxApprovalReportTitleList.get(i).getOneCategoryMoney();
			
			
                
				sb3.append(tempNum);
				sb3.append(",");
				sb3.append(tempMoney);
				if(i!=sxApprovalReportTitleList.size()-1){
				
					sb3.append(",");
				}
				
		
		}
		
		StringBuffer sb4=new StringBuffer();
		for(int i=0;i<sxApprovalReportTitleList.size();i++){
			String tempNum=sxApprovalReportTitleList.get(i).getOneCategoryNum();
			String tempMoney=sxApprovalReportTitleList.get(i).getOneCategoryMoney();
				sb4.append("SUM(");	
				sb4.append(tempNum);
				sb4.append(") ");	
				sb4.append(tempNum);
				sb4.append(", SUM(");
				sb4.append(tempMoney);
				sb4.append(") ");
				sb4.append(tempMoney);	
				if(i!=sxApprovalReportTitleList.size()-1){
					
					sb4.append(",");
				}
				
				
		
		}
		
		map.put("oneParams", sb.toString());
	//map.put("twoParams", sb.toString());
		map.put("threeParams", sb3.toString());
		map.put("fourParams", sb4.toString());
		
		if(sxApprovalReport.getApprovalTimeStart()!=null&&!"".equals(sxApprovalReport.getApprovalTimeStart())){
			map.put("approvalTimeStart", sxApprovalReport.getApprovalTimeStart());
			
		}
		if(sxApprovalReport.getApprovalTimeEnd()!=null&&!"".equals(sxApprovalReport.getApprovalTimeEnd())){
			map.put("approvalTimeStart", sxApprovalReport.getApprovalTimeEnd());
			
		}
		sxApprovalReportList=sxApprovalReportDao.querySxApprovalReportList(map,page);
		return sxApprovalReportList;
		//return null;
	}

	@Override
	public List<SxApprovalReport> querySxApprovalReportListForExcel(
			SxApprovalReport sxApprovalReport,List<SxApprovalReport> sxApprovalReportTitleList) {
		List<SxApprovalReport> sxApprovalReportList =new ArrayList<SxApprovalReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<sxApprovalReportTitleList.size();i++){
			String temp=sxApprovalReportTitleList.get(i).getOneCategory();
			String temp1=sxApprovalReportTitleList.get(i).getOneCategoryName();
			if(i==0){
				sb.append("'");	
			}
			sb.append(temp);
			if(i!=sxApprovalReportTitleList.size()-1){
				sb.append("' ");	
				sb.append(temp1);	
				sb.append(",'");	
			}else if(i==sxApprovalReportTitleList.size()-1){
				sb.append("' ");		
				sb.append(temp1);
			}
		}
		
//		StringBuffer sb2=new StringBuffer();
//		for(int i=0;i<sxApprovalReportTitleList.size();i++){
//			String temp=sxApprovalReportTitleList.get(i).getOneCategory();
//			String temp1=sxApprovalReportTitleList.get(i).getOneCategoryNum();
//			if(i==0){
//				sb2.append("\"'");	
//			}
//			sb2.append(temp);
//			if(i!=sxApprovalReportTitleList.size()-1){
//				sb2.append("\"' ");
//
//				sb2.append(temp1);
//				sb2.append(",\"'");
//			}else if(i==sxApprovalReportTitleList.size()-1){
//				sb2.append("\"'");	
//			}
//		}
		
		StringBuffer sb3=new StringBuffer();
		for(int i=0;i<sxApprovalReportTitleList.size();i++){
			String tempNum=sxApprovalReportTitleList.get(i).getOneCategoryNum();
			String tempMoney=sxApprovalReportTitleList.get(i).getOneCategoryMoney();
			
			
                
				sb3.append(tempNum);
				sb3.append(",");
				sb3.append(tempMoney);
				if(i!=sxApprovalReportTitleList.size()-1){
				
					sb3.append(",");
				}
				
		
		}
		
		StringBuffer sb4=new StringBuffer();
		for(int i=0;i<sxApprovalReportTitleList.size();i++){
			String tempNum=sxApprovalReportTitleList.get(i).getOneCategoryNum();
			String tempMoney=sxApprovalReportTitleList.get(i).getOneCategoryMoney();
				sb4.append("SUM(");	
				sb4.append(tempNum);
				sb4.append(") ");	
				sb4.append(tempNum);
				sb4.append(", SUM(");
				sb4.append(tempMoney);
				sb4.append(") ");
				sb4.append(tempMoney);	
				if(i!=sxApprovalReportTitleList.size()-1){
					
					sb4.append(",");
				}
				
				
		
		}
		
		map.put("oneParams", sb.toString());
	   //map.put("twoParams", sb2.toString());
		map.put("threeParams", sb3.toString());
		map.put("fourParams", sb4.toString());
		if(sxApprovalReport.getApprovalTimeStart()!=null&&!"".equals(sxApprovalReport.getApprovalTimeStart())){
			map.put("approvalTimeStart", sxApprovalReport.getApprovalTimeStart());
			
		}
		if(sxApprovalReport.getApprovalTimeEnd()!=null&&!"".equals(sxApprovalReport.getApprovalTimeEnd())){
			map.put("approvalTimeStart", sxApprovalReport.getApprovalTimeEnd());
			
		}
		sxApprovalReportList=sxApprovalReportDao.querySxApprovalReportListForExcel(map);
		return sxApprovalReportList;
	}

	@Override
	public List<SxApprovalReport> querySxApprovalReportTitleList(
			SxApprovalReport sxApprovalReport) {
		 List<SxApprovalReport> sxApprovalReportTitleList =new ArrayList<SxApprovalReport>();
		 Map<String, Object>map=new HashMap<String, Object>();
		 sxApprovalReportTitleList=sxApprovalReportDao.querySxApprovalReportTitleList(map);
		return sxApprovalReportTitleList;
	}

	
	

}
