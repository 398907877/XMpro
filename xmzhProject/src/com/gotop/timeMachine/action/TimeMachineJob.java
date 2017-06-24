package com.gotop.timeMachine.action;

import java.lang.reflect.Method;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.gotop.Generalprocess.util.SpringContextUtil;




/**
 * 
 * @author WUJIAJUN
 * @desc   to  Job
 */

public class TimeMachineJob   {
	
	
	
	private  TModelTimedayAction  TimedayAction;

	public TModelTimedayAction getTimedayAction() {
		return TimedayAction;
	}

	public void setTimedayAction(TModelTimedayAction timedayAction) {
		TimedayAction = timedayAction;
	}
	
	
	protected void executeExcel(JobExecutionContext context)
	throws JobExecutionException {
 
		try {
			TimedayAction.queryOvertimeReport();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			System.out.println("执行超限时长报表 出错  ERROR!!");
		}
 
	}

	
	private void executeInternal() {
		// TODO Auto-generated method stub
		
		try {
			
			System.out.println("+++++++++++++ 超限时长报表  START+++++++++++");
			
		Object bean = SpringContextUtil.getBean("tModelTimedayaction"); 
		
		Class<?> classes = Class.forName("com.gotop.timeMachine.action.TModelTimedayAction");

		// 目前只有值，需要加入加入 @ 注解的 值

		Method thismethod = classes.getDeclaredMethod("handleTimeReport");

		// bean
		String  back = (String) thismethod.invoke(bean);
		
		
		
		
		System.out.println("+++++++++++++ 超限时长报表   END+++++++++++");
		
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}

		
	}
	
	
	
	

	
	private void processUsedTimeReport() {
		// TODO Auto-generated method stub
		
		try {
			
			System.out.println("+++++++++++++时限情况统计  流程用时统计 START+++++++++++");
			
		Object bean = SpringContextUtil.getBean("processUsedTimeReportAction"); 
		
		Class<?> classes = Class.forName("com.gotop.reportjbpm.action.ProcessUsedTimeReportAction");

		// 目前只有值，需要加入加入 @ 注解的 值

		Method thismethod = classes.getDeclaredMethod("processUsedTimeReport");

		// bean
		String  back = (String) thismethod.invoke(bean);
		
		
		
		
		System.out.println("+++++++++++++ 时限情况统计  流程用时统计   END+++++++++++");
		
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}

		
	}
	
	private void inventoryStatTimeReport() {
		// TODO Auto-generated method stub
		
		try {
			
			System.out.println("+++++++++++++ 库存统计   START+++++++++++");
			
		Object bean = SpringContextUtil.getBean("inventoryStatQueryAction"); 
		
		Class<?> classes = Class.forName("com.gotop.mortgage.action.InventoryStatQueryAction");

		// 目前只有值，需要加入加入 @ 注解的 值

		Method thismethod = classes.getDeclaredMethod("inventoryStatTimeReport");

		// bean
		String  back = (String) thismethod.invoke(bean);
		
		
		
		
		System.out.println("+++++++++++++ 库存统计   END+++++++++++");
		
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}

		
	}
	
	
	
	

}
