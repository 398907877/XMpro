package com.gotop.reportjbpm.action;


import java.util.ArrayList;
import java.util.List;
import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.TimeLimitConditionReport;
import com.gotop.reportjbpm.service.ITimeLimitConditionReportService;
import com.gotop.vo.system.MUOUserSession;
public class TimeLimitConditionReportAction extends BaseAction {
    private  TimeLimitConditionReport timeLimitConditionReport;
    private  ITimeLimitConditionReportService timeLimitConditionReportService;
	private List<TimeLimitConditionReport> timeLimitConditionReportList =new ArrayList<TimeLimitConditionReport>();
	private String update_time;
	
	public List<TimeLimitConditionReport> getTimeLimitConditionReportList() {
		return timeLimitConditionReportList;
	}
	public void setTimeLimitConditionReportList(
			List<TimeLimitConditionReport> timeLimitConditionReportList) {
		this.timeLimitConditionReportList = timeLimitConditionReportList;
	}
	public ITimeLimitConditionReportService getTimeLimitConditionReportService() {
		return timeLimitConditionReportService;
	}
	public void setTimeLimitConditionReportService(
			ITimeLimitConditionReportService timeLimitConditionReportService) {
		this.timeLimitConditionReportService = timeLimitConditionReportService;
	}
	public TimeLimitConditionReport getTimeLimitConditionReport() {
		return timeLimitConditionReport;
	}
	public void setTimeLimitConditionReport(
			TimeLimitConditionReport timeLimitConditionReport) {
		this.timeLimitConditionReport = timeLimitConditionReport;
	}

    public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String timeLimitConditionReportList(){
		
		MUOUserSession muo = getCurrentOnlineUser();
		timeLimitConditionReportList=timeLimitConditionReportService.queryTimeLimitConditionReportList(muo,timeLimitConditionReport, this.getPage());
		this.setPage(page);
		//查询超限报表更新时间，显示在页面
    	String update_time =  (String) this.timeLimitConditionReportService.queryReportUpdatetime();
    	this.setUpdate_time(update_time);
		this.setTimeLimitConditionReportList(timeLimitConditionReportList);
		return "timeLimitConditionReportList";
	}
	
	public String timeLimitConditionReportExcel(){
		
		MUOUserSession muo = getCurrentOnlineUser();
		timeLimitConditionReportList=timeLimitConditionReportService.queryTimeLimitConditionReportListForExcel(muo,timeLimitConditionReport);
		this.setTimeLimitConditionReportList(timeLimitConditionReportList);
		return "timeLimitConditionReportExcel";
	}
}
