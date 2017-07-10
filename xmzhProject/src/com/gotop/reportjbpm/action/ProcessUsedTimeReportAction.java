package com.gotop.reportjbpm.action;


import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.gotop.Generalprocess.util.SpringContextUtil;
import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.ProcessUsedTimeReport;
import com.gotop.reportjbpm.service.IProcessUsedTimeReportService;
import com.gotop.vo.system.MUOUserSession;
public class ProcessUsedTimeReportAction extends BaseAction {

	private ProcessUsedTimeReport processUsedTimeReport;
	private IProcessUsedTimeReportService processUsedTimeReportService;
	private List<ProcessUsedTimeReport> processUsedTimeReportList =new ArrayList<ProcessUsedTimeReport>();
	private String reslut;
    
    private String update_time;
	
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getReslut() {
		return reslut;
	}
	public void setReslut(String reslut) {
		this.reslut = reslut;
	}
	public List<ProcessUsedTimeReport> getProcessUsedTimeReportList() {
		return processUsedTimeReportList;
	}
	public void setProcessUsedTimeReportList(
			List<ProcessUsedTimeReport> processUsedTimeReportList) {
		this.processUsedTimeReportList = processUsedTimeReportList;
	}
	public IProcessUsedTimeReportService getProcessUsedTimeReportService() {
		return processUsedTimeReportService;
	}
	public void setProcessUsedTimeReportService(
			IProcessUsedTimeReportService processUsedTimeReportService) {
		this.processUsedTimeReportService = processUsedTimeReportService;
	}
	public ProcessUsedTimeReport getProcessUsedTimeReport() {
		return processUsedTimeReport;
	}
	public void setProcessUsedTimeReport(ProcessUsedTimeReport processUsedTimeReport) {
		this.processUsedTimeReport = processUsedTimeReport;
	}
	public String processUsedTimeReportList(){
		
		
//		try {
//			processUsedTimeReport();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		
		MUOUserSession muo = getCurrentOnlineUser();
		processUsedTimeReportList=processUsedTimeReportService.queryProcessUsedTimeReportList(muo,processUsedTimeReport, this.getPage());
		this.setPage(page);
		//查询超限报表更新时间，显示在页面
    	String update_time =  (String) this.processUsedTimeReportService.queryReportUpdatetime();
    	this.setUpdate_time(update_time);
		this.setProcessUsedTimeReportList(processUsedTimeReportList);
	
		return "processUsedTimeReportList";
	}
	
	public String processUsedTimeReportExcel(){
		
		MUOUserSession muo = getCurrentOnlineUser();
		processUsedTimeReportList=processUsedTimeReportService.queryProcessUsedTimeReportListForExcel(muo,processUsedTimeReport);
		this.setProcessUsedTimeReportList(processUsedTimeReportList);
		return "processUsedTimeReportExcel";
	}
	
	 public String processUsedTimeReport() throws Exception {
		 String res="激活失败";
		 try {
			
		
		    Object bean = SpringContextUtil.getBean("myUtil"); 
	    	Class<?> classes = Class.forName("com.gotop.reportjbpm.MyUtil");
	    //	Method thismethod = classes.getDeclaredMethod("getworkTimeDiff_forDays", String.class,String.class);
	    	List<ProcessUsedTimeReport> processUsedTimeReportList=processUsedTimeReportService.queryProcessUsedTimeReportListTemp();
	    	if(processUsedTimeReportList.size()>0){
	    	    Date d=new Date();
 				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
				String inserttime = sdf2.format(d);  //此时的survey_time格式为yyyyMMddHHmmss， 如：20160217000000
	    		//循环每一个信贷流程 processUsedTimeReportList.size()
		    	for (int i=0;i<processUsedTimeReportList.size();i++) {
		    		List<ProcessUsedTimeReport> processUsedTimeTypeList=processUsedTimeReportService.queryProcessUsedTimeType();
		    		if(processUsedTimeTypeList.size()>0){
			    		for(int j=0;j<processUsedTimeTypeList.size();j++){
							HashMap<String, String> tempMap = new HashMap<String, String>();
							tempMap.put("orgcodeone", processUsedTimeReportList.get(i).getOrgCodeOne());
							tempMap.put("orgnameone", processUsedTimeReportList.get(i).getOrgNameOne());
							tempMap.put("orgcodetwo", processUsedTimeReportList.get(i).getOrgCodeTwo());
							tempMap.put("orgnametwo", processUsedTimeReportList.get(i).getOrgNameTwo());
							tempMap.put("displayorderone", processUsedTimeReportList.get(i).getDisplayOrderOne());
							tempMap.put("displayordertwo", processUsedTimeReportList.get(i).getDisplayOrderTwo());
							tempMap.put("onecategory", processUsedTimeReportList.get(i).getOneCategory());
							tempMap.put("loancategory", processUsedTimeReportList.get(i).getLoanCategory());
							tempMap.put("zdcustmanager", processUsedTimeReportList.get(i).getZdCustManager());
							tempMap.put("reporttime", processUsedTimeReportList.get(i).getReportTime());
							tempMap.put("flowid", processUsedTimeReportList.get(i).getFlowId());
							tempMap.put("timelimittype", processUsedTimeTypeList.get(j).getTimeLimitType());
							//tempMap.put("activitynamelast", processUsedTimeReportList.get(i).getActivityNameLast());
							//tempMap.put("activitynamenext", processUsedTimeReportList.get(i).getActivityNameNext());
							//tempMap.put("activitynamern", processUsedTimeReportList.get(i).getActivityNameRN());
//				    		ProcessUsedTimeReportTemp processUsedTimeReportTemp=new ProcessUsedTimeReportTemp();
//				    		processUsedTimeReportTemp.setOrgcodeone(processUsedTimeReportList.get(i).getOrgcodeone());
//				    		processUsedTimeReportTemp.setOrgnameone(processUsedTimeReportList.get(i).getOrgnameone());
//				    		processUsedTimeReportTemp.setOrgcodetwo(processUsedTimeReportList.get(i).getOrgcodetwo());
//				    		processUsedTimeReportTemp.setOrgnametwo(processUsedTimeReportList.get(i).getOrgnametwo());
//				    		processUsedTimeReportTemp.setDisplayorderone(processUsedTimeReportList.get(i).getDisplayorderone());
//				    		processUsedTimeReportTemp.setDisplayordertwo(processUsedTimeReportList.get(i).getDisplayordertwo());
//				    		processUsedTimeReportTemp.setOnecategory(processUsedTimeReportList.get(i).getOnecategory());
//				    		processUsedTimeReportTemp.setLoancategory(processUsedTimeReportList.get(i).getLoancategory());
//				    		processUsedTimeReportTemp.setReporttime(processUsedTimeReportList.get(i).getReporttime());
//				    		processUsedTimeReportTemp.setActivitynamelast(processUsedTimeReportList.get(i).getActivitynamelast());
//				    		processUsedTimeReportTemp.setActivitynamenext(processUsedTimeReportList.get(i).getActivitynamenext());
//				    		processUsedTimeReportTemp.setActivitynamern(processUsedTimeReportList.get(i).getActivitynamern());
							String tempTime=processUsedTimeReportList.get(i).getTempTime();
							String tempObj[]=tempTime.split(";");
							String worktimeTemp=tempObj[j];
				    		//String startTime=processUsedTimeReportList.get(i).getRepTimeStart();
				    		//String endTime=processUsedTimeReportList.get(i).getRepTimeEnd();
			    			String worktime="0";
			    			worktime=getWorkTimeforDays(bean,classes,worktimeTemp);
//				    		if(!"0".equals(startTime)&&!"0".equals(endTime)){
//				    			Double expendtime = (Double) thismethod.invoke(bean, startTime, endTime);
//				    			worktime=String.valueOf(expendtime);
//				    		}
							tempMap.put("worktime", worktime);
							tempMap.put("inserttime", inserttime);
				    		//processUsedTimeReportTemp.setWorktime(worktime);
				    		//processUsedTimeReportTemp.setInserttime(inserttime);
				    		processUsedTimeReportService.insertProcessUsedTimeReportTemp(tempMap);
				    		res="激活成功";
			    		}
		    		}
		    		
		    	}
	    	}
		 } catch (Exception e) {
			    res="激活失败";
				e.printStackTrace();
			}
	    	this.setReslut(res);
	    	return "processUsedTimeReport";		
	 }
	 
	 /**
		 * 处理开始结束时间：格式20151218031212,20151218031244
		 * @param tempTime
		 * @return
		 */
	    private String getWorkTimeforDays(Object bean,Class<?> classes,String tempTime){
	    	String resulttempTime="0";
	    	if(!"0".equals(tempTime)){
				String zhgpdTimeOneObj[]=tempTime.split(",");
				String zhgpdTimeOneEnd=zhgpdTimeOneObj[1];
				String zhgpdTimeOneStart=zhgpdTimeOneObj[0];
				if(!"0".equals(zhgpdTimeOneStart)&&!"0".equals(zhgpdTimeOneEnd)){
					try {

				    	Method thismethod = classes.getDeclaredMethod("getworkTimeDiff_forDays", String.class,String.class);
				    	Double resultTime = (Double) thismethod.invoke(bean, zhgpdTimeOneStart, zhgpdTimeOneEnd);
				    	if(resultTime>0){
							resulttempTime=String.valueOf(resultTime);
				    	}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
	    	return  resulttempTime;
	    }
}
