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
	public List<BjErrorNumReport> queryBjErrorNumReportList(BjErrorNumReport bjErrorNumReport, Page page) {
		List<BjErrorNumReport> bjErrorNumReportList=new ArrayList<BjErrorNumReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (bjErrorNumReport.getRepTimeStart() !=null&&!"".equals(bjErrorNumReport.getRepTimeStart())) {
		
				try {
					map.put("repTimeStrat",sdf.format(sdf1.parse(bjErrorNumReport.getRepTimeStart())));
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
			
		}
		
		if (bjErrorNumReport.getRepTimeEnd() !=null&&!"".equals(bjErrorNumReport.getRepTimeEnd())) {
			try {
				map.put("repTimeEnd",  sdf.format(sdf1.parse(bjErrorNumReport.getRepTimeEnd())));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
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
		
		for (int i = 0; i < bjErrorNumReportLists.size(); i++) {
			 NumberFormat percent = NumberFormat.getPercentInstance();
		     percent.setMaximumFractionDigits(2);
			BigDecimal oneBjErrorNum=new BigDecimal(bjErrorNumReportLists.get(i).getOneBjErrorNum());
			BigDecimal oneBjNums=new BigDecimal(bjErrorNumReportLists.get(i).getOneBjNums());
			int r1=oneBjErrorNum.compareTo(BigDecimal.ZERO);
			int r2=oneBjNums.compareTo(BigDecimal.ZERO);
			if(r1!=0 && r2!=0){
				BigDecimal bjErrorNum=oneBjErrorNum.divide(oneBjNums, 4,  BigDecimal.ROUND_HALF_UP);//ROUND_DOWN直接截断
				bjErrorNumReportLists.get(i).setBjErrorNum(percent.format(bjErrorNum.doubleValue()));
			}
				
			
		}
		
		return bjErrorNumReportLists;
	}

	@Override
	public List<BjErrorNumReport> queryBjErrorNumReportListForExcel(BjErrorNumReport bjErrorNumReport) {
		List<BjErrorNumReport> bjErrorNumReportList=new ArrayList<BjErrorNumReport>();
		Map<String, Object>map=new HashMap<String, Object>();
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
		for (int i = 0; i < bjErrorNumReportLists.size(); i++) {
			 NumberFormat percent = NumberFormat.getPercentInstance();
		     percent.setMaximumFractionDigits(2);
			BigDecimal oneBjErrorNum=new BigDecimal(bjErrorNumReportLists.get(i).getOneBjErrorNum());
			BigDecimal oneBjNums=new BigDecimal(bjErrorNumReportLists.get(i).getOneBjNums());
			int r1=oneBjErrorNum.compareTo(BigDecimal.ZERO);
			int r2=oneBjNums.compareTo(BigDecimal.ZERO);
			if(r1!=0 && r2!=0){
				BigDecimal bjErrorNum=oneBjErrorNum.divide(oneBjNums, 4,  BigDecimal.ROUND_HALF_UP);//ROUND_DOWN直接截断
				bjErrorNumReportLists.get(i).setBjErrorNum(percent.format(bjErrorNum.doubleValue()));
			}
				
			
		}
		
		return bjErrorNumReportLists;
	}

}