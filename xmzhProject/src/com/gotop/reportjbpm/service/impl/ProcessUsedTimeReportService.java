package com.gotop.reportjbpm.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gotop.reportjbpm.dao.IProcessUsedTimeReportDao;
import com.gotop.reportjbpm.model.ProcessUsedTimeReport;
import com.gotop.reportjbpm.service.IProcessUsedTimeReportService;
import com.gotop.util.string.Obj2StrUtils;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public class ProcessUsedTimeReportService implements IProcessUsedTimeReportService {

	private IProcessUsedTimeReportDao processUsedTimeReportDao;
	public IProcessUsedTimeReportDao getProcessUsedTimeReportDao() {
		return processUsedTimeReportDao;
	}

	public void setProcessUsedTimeReportDao(
			IProcessUsedTimeReportDao processUsedTimeReportDao) {
		this.processUsedTimeReportDao = processUsedTimeReportDao;
	}

	@Override
	public List<ProcessUsedTimeReport> queryProcessUsedTimeReportList(MUOUserSession muo,
			ProcessUsedTimeReport processUsedTimeReport, Page page) {
		
	    List<ProcessUsedTimeReport> processUsedTimeReportList =new ArrayList<ProcessUsedTimeReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		
		String orgcode = muo.getOrgcode();
		List list  = processUsedTimeReportDao.yesOrNot_dep(orgcode); //查询当前机构是部门还是机构
		
		if (list.size() != 0){
			 HashMap<String, Object>  hp = (HashMap<String, Object>) list.get(0);
			 if("no".equals(hp.get("IS_DEP"))) { //当前机构不是部门，说明是支行
				 map.put("defaultOrgcode", hp.get("ORGCODE")); //查询列表默认显示本级及下级的数据
			 }
		}
		
		if(processUsedTimeReport.getRepTimeStart()!=null&&!"".equals(processUsedTimeReport.getRepTimeStart())){
			map.put("repTimeStart", processUsedTimeReport.getRepTimeStart());
			
		}
		if(processUsedTimeReport.getRepTimeEnd()!=null&&!"".equals(processUsedTimeReport.getRepTimeEnd())){
			map.put("repTimeEnd", processUsedTimeReport.getRepTimeEnd());
			
		}
		if(processUsedTimeReport.getOrgCodeOne()!=null&&!"".equals(processUsedTimeReport.getOrgCodeOne())){
			map.put("orgCodeOne", processUsedTimeReport.getOrgCodeOne());
			
		}
		
		if(processUsedTimeReport.getOrgCodeTwo()!=null&&!"".equals(processUsedTimeReport.getOrgCodeTwo())){
			map.put("orgCodeTwo", processUsedTimeReport.getOrgCodeTwo());
			
		}
		if(processUsedTimeReport.getOneCategory()!=null && !"".equals(processUsedTimeReport.getOneCategory())){
			String[] oneCategorys=processUsedTimeReport.getOneCategory().split(", ");
			String oneCategory="";
			try {
				oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("oneCategory",oneCategory);
		}
		if(processUsedTimeReport.getLoanCategory()!=null && !"".equals(processUsedTimeReport.getLoanCategory())){
			String[] loanCategorys=processUsedTimeReport.getLoanCategory().split(", ");
			String loanCategory="";
			try {
				loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("loanCategory",loanCategory);
		}
		if(processUsedTimeReport.getTimeLimitType()!=null&&!"".equals(processUsedTimeReport.getTimeLimitType())){
			map.put("timeLimitType", processUsedTimeReport.getTimeLimitType());
			
		}
		if(processUsedTimeReport.getSppTimeStart()!=null&&!"".equals(processUsedTimeReport.getSppTimeStart())){
			map.put("sppTimeType", "0");
			map.put("sppTimeStart", processUsedTimeReport.getSppTimeStart());
			
		}
		if(processUsedTimeReport.getSppTimeEnd()!=null&&!"".equals(processUsedTimeReport.getSppTimeEnd())){
			map.put("sppTimeType", "1");
			map.put("sppTimeEnd", processUsedTimeReport.getSppTimeEnd());
			
		}
		if(processUsedTimeReport.getSppTimeEnd()!=null&&!"".equals(processUsedTimeReport.getSppTimeEnd())&&processUsedTimeReport.getSppTimeStart()!=null&&!"".equals(processUsedTimeReport.getSppTimeStart())){
			map.put("sppTimeType", "2");
			map.put("sppTimeStart", processUsedTimeReport.getSppTimeStart());
			map.put("sppTimeEnd", processUsedTimeReport.getSppTimeEnd());
			
		}
	    processUsedTimeReportList=processUsedTimeReportDao.queryProcessUsedTimeReportList(map, page);
		return processUsedTimeReportList;
	}

	@Override
	public List<ProcessUsedTimeReport> queryProcessUsedTimeReportListForExcel(MUOUserSession muo,
			ProcessUsedTimeReport processUsedTimeReport) {
		
		List<ProcessUsedTimeReport> processUsedTimeReportList =new ArrayList<ProcessUsedTimeReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		
		String orgcode = muo.getOrgcode();
		List list  = processUsedTimeReportDao.yesOrNot_dep(orgcode); //查询当前机构是部门还是机构
		
		if (list.size() != 0){
			 HashMap<String, Object>  hp = (HashMap<String, Object>) list.get(0);
			 if("no".equals(hp.get("IS_DEP"))) { //当前机构不是部门，说明是支行
				 map.put("defaultOrgcode", hp.get("ORGCODE")); //查询列表默认显示本级及下级的数据
			 }
		}
		
		if(processUsedTimeReport.getRepTimeStart()!=null&&!"".equals(processUsedTimeReport.getRepTimeStart())){
			map.put("repTimeStart", processUsedTimeReport.getRepTimeStart());
			
		}
		if(processUsedTimeReport.getRepTimeEnd()!=null&&!"".equals(processUsedTimeReport.getRepTimeEnd())){
			map.put("repTimeEnd", processUsedTimeReport.getRepTimeEnd());
			
		}
		if(processUsedTimeReport.getOrgCodeOne()!=null&&!"".equals(processUsedTimeReport.getOrgCodeOne())){
			map.put("orgCodeOne", processUsedTimeReport.getOrgCodeOne());
			
		}
		
		if(processUsedTimeReport.getOrgCodeTwo()!=null&&!"".equals(processUsedTimeReport.getOrgCodeTwo())){
			map.put("orgCodeTwo", processUsedTimeReport.getOrgCodeTwo());
			
		}
		if(processUsedTimeReport.getOneCategory()!=null && !"".equals(processUsedTimeReport.getOneCategory())){
			String[] oneCategorys=processUsedTimeReport.getOneCategory().split(", ");
			String oneCategory="";
			try {
				oneCategory = Obj2StrUtils.join(oneCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("oneCategory",oneCategory);
		}
		if(processUsedTimeReport.getLoanCategory()!=null && !"".equals(processUsedTimeReport.getLoanCategory())){
			String[] loanCategorys=processUsedTimeReport.getLoanCategory().split(", ");
			String loanCategory="";
			try {
				loanCategory = Obj2StrUtils.join(loanCategorys, String.class, ",");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			map.put("loanCategory",loanCategory);
		}
		if(processUsedTimeReport.getTimeLimitType()!=null&&!"".equals(processUsedTimeReport.getTimeLimitType())){
			map.put("timeLimitType", processUsedTimeReport.getTimeLimitType());
			
		}
		if(processUsedTimeReport.getSppTimeStart()!=null&&!"".equals(processUsedTimeReport.getSppTimeStart())){
			map.put("sppTimeType", "0");
			map.put("sppTimeStart", processUsedTimeReport.getSppTimeStart());
			
		}
		if(processUsedTimeReport.getSppTimeEnd()!=null&&!"".equals(processUsedTimeReport.getSppTimeEnd())){
			map.put("sppTimeType", "1");
			map.put("sppTimeEnd", processUsedTimeReport.getSppTimeEnd());
			
		}
		if(processUsedTimeReport.getSppTimeEnd()!=null&&!"".equals(processUsedTimeReport.getSppTimeEnd())&&processUsedTimeReport.getSppTimeStart()!=null&&!"".equals(processUsedTimeReport.getSppTimeStart())){
			map.put("sppTimeType", "2");
			map.put("sppTimeStart", processUsedTimeReport.getSppTimeStart());
			map.put("sppTimeEnd", processUsedTimeReport.getSppTimeEnd());
			
		}
	    processUsedTimeReportList=processUsedTimeReportDao.queryProcessUsedTimeReportListForExcel(map);
		return processUsedTimeReportList;
	}

	@Override
	public List<ProcessUsedTimeReport> queryProcessUsedTimeReportListTemp() {
	    List<ProcessUsedTimeReport> processUsedTimeReportList =new ArrayList<ProcessUsedTimeReport>();
	    processUsedTimeReportList=processUsedTimeReportDao.queryProcessUsedTimeReportListTemp();
		return processUsedTimeReportList;
	}

	@Override
	public void insertProcessUsedTimeReportTemp(
			HashMap<String, String> hmp)  {
		processUsedTimeReportDao.insertProcessUsedTimeReportTemp(hmp);
		
	}

	@Override
	public List<ProcessUsedTimeReport> queryProcessUsedTimeType() {
		 List<ProcessUsedTimeReport> processUsedTimeTypeList =new ArrayList<ProcessUsedTimeReport>();
		 processUsedTimeTypeList=processUsedTimeReportDao.queryProcessUsedTimeType();
		return processUsedTimeTypeList;
	}

	@Override
	public Object queryReportUpdatetime() {
		
		Object object = this.processUsedTimeReportDao.queryReportUpdatetime();
		return object;
	}


}
