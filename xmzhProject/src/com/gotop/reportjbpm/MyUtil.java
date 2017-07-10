package com.gotop.reportjbpm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.Generalprocess.util.SpringContextUtil;
import com.gotop.jbpm.model.WorkTimeMainBean;
import com.gotop.jbpm.model.WorkTimeSideBean;
import com.gotop.timeMachine.model.TModelTimeday;
import com.gotop.timeMachine.service.ITModelTimedayService;

/**
 * 公用的工具类
 * @author lmt
 *
 */
public class MyUtil {

	protected     ITModelTimedayService tModelTimedayService;

	public ITModelTimedayService gettModelTimedayService() {
		return tModelTimedayService;
	}

	public void settModelTimedayService(ITModelTimedayService tModelTimedayService) {
		this.tModelTimedayService = tModelTimedayService;
	}
	
	
	/**
	 * 调用公用方法计算时间差的  使用 例子！！！仅供调用参考！！
	 */
	public  void demo() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		//前提需要在对应的actionContext这个spring文件里 配置MyUtil
    	Object bean = SpringContextUtil.getBean("myUtil"); 
    	Class<?> classes = Class.forName("com.gotop.reportjbpm.MyUtil");
    	
    	//计算消耗的工作时间(单位：小时)
    	//Method thismethod = classes.getDeclaredMethod("getworkTimeDiff_forHours", String.class,String.class);
    	
    	//计算消耗的工作时间(单位：工作日)
    	Method thismethod = classes.getDeclaredMethod("getworkTimeDiff_forDays", String.class,String.class);
    	
    	Double expendtime = (Double) thismethod.invoke(bean, "20170101080000", "20170102080000");
    	
	}

	/**
	 * 计算出的两个节点之间消耗多少工作时长（单位：小时，double四舍五入保留2位小数）
	 * 
	 * @param start 节点开始时间（14位字符串 格式：yyyyMMddHHmmss    如：20170101080000）
	 * @param end  节点结束时间（14位字符串 格式：yyyyMMddHHmmss    如：20170102080000）
	 * @return  expendHours 消耗的工作时长（单位：小时）
	 * @throws ParseException
	 */
	public    double  getworkTimeDiff_forHours(String start, String end) throws ParseException{
		
		
    	//消耗时间 = （结束时间-开始时间）的工作时长 - 期间的非工作日
    	double expendHours = 0;
    	
    	//例时间的传入格式为20160520115501
    	String my_startDStr = start.substring(0, 8); //节点开始日期。不包含第8位
    	String my_endDStr = end.substring(0, 8); //节点结束日期
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		 Date my_startD = sdf.parse(my_startDStr);//节点开始日期
		 Date my_endD = sdf.parse(my_endDStr);//节点结束日期
		 
		 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
		 Date my_startT = sdf2.parse(start);//节点开始时间
		 Date my_endT = sdf2.parse(end);//节点结束时间
    	
		 SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHH:mm:ss");

    	List<WorkTimeMainBean> workTimeMainBeans = tModelTimedayService.queryWorkTimeMain();  	

    	List<WorkTimeSideBean> workTimeSideBeans = new ArrayList<WorkTimeSideBean>();
    	
    	for (WorkTimeMainBean workTimeMainBean : workTimeMainBeans) {
			String startDStr = workTimeMainBean.getStartDate();
			String endDStr = workTimeMainBean.getEndDate();
			
			 Date startD = sdf.parse(startDStr);
			 Date endD = sdf.parse(endDStr);
			 Date endD2;
			 
			if( my_startD.compareTo(startD) >= 0 && my_endD.compareTo(endD) < 0 ){//因为有效日包前不包后，故不取等号
				//1.节点开始和结束日期在同一个有效日范围内
				
				double everydaytimeSum=0;//每天工作时间和
				double starttimeSum = 0; //第一天工作时间和
				double endtimeSum = 0;//最后一天工作时间和
				double timeSum = 0; //开始和结束日期是同一天时用，用于存放不同上班时间段的累计时间
				
				 //查询该有效日对应的工作时间配置
				 workTimeSideBeans = tModelTimedayService.queryWorkTimeSide(workTimeMainBean);  
				 
				 if(workTimeSideBeans.size() != 0){
					 for (WorkTimeSideBean workTimeSideBean : workTimeSideBeans) {
							
							String startTStr = workTimeSideBean.getStartTime();
							String endTStr = workTimeSideBean.getEndTime();
							
							//将节点日期与查到的时间字符串连接一起，用于时间比较
							 Date startT1 = sdf3.parse(my_startDStr+startTStr); //为节点开始日期，但开始时间是数据库查的
							 Date startT2 = sdf3.parse(my_endDStr+startTStr);  //为节点结束日期，但开始时间是数据库查的
							 Date endT1 = sdf3.parse(my_startDStr+endTStr);   //为节点开始日期，但结束时间是数据库查的
							 Date endT2 = sdf3.parse(my_endDStr+endTStr);    //为节点结束日期，但结束时间是数据库查的
							
							//A.计算数据库配置的每天工作时间的时间差
							double between_hours = get_betweenHours(startT1, endT1);  //用get_betweenHours(startT2, endT2)也可以，只要日期同一天即可，一个workTimeSideBean的时间差
							everydaytimeSum = everydaytimeSum + between_hours;
							
							if(my_startDStr.equals(my_endDStr)){  //开始和结束日期是同一天
								
								if( (my_startT.compareTo(startT1) > 0 && my_startT.compareTo(endT1) < 0) &&  my_endT.compareTo(endT1) >= 0 ){ //开始时间在工作时间段之间，结束时间在工作时间段之后或相等
									timeSum = timeSum + get_betweenHours(my_startT, endT1);
								}else if( my_startT.compareTo(startT1) <= 0  &&  my_endT.compareTo(endT1) >= 0 ){ //开始时间在工作时间段之前或相等，结束时间在工作时间段之后或相等
									timeSum = timeSum + get_betweenHours(startT1, endT1);
								}else if( my_startT.compareTo(endT1) >= 0  &&  my_endT.compareTo(endT1) >= 0 ){ //开始时间和结束时间都在工作时间段之后或相等
									timeSum = timeSum+0;
								}else if( (my_startT.compareTo(startT1) > 0 && my_startT.compareTo(endT1) < 0) &&  (my_endT.compareTo(startT1) > 0 && my_endT.compareTo(endT1) < 0) ){ //开始时间和结束时间都在工作时间段之间
									timeSum = timeSum+get_betweenHours(my_startT, my_endT);
								}else if(  my_startT.compareTo(startT1) <= 0 &&  (my_endT.compareTo(startT1) > 0 && my_endT.compareTo(endT1) < 0) ){ //开始时间在工作时间段之前或相等，结束时间在工作时间段之间
									timeSum = timeSum+get_betweenHours(startT1, my_endT);
								}else if(my_endT.compareTo(endT1) <= 0 ){ //结束时间在工作时间段之前或相等
									timeSum = timeSum + 0;
								}else{
									
								}
								
							}else{  //开始和结束日期不是同一天
								double between_hours2 = 0;
								double between_hours3 = 0;
								
								//B.判断传入的开始时间，计算开始的那天工作和
								if( my_startT.compareTo(startT1) > 0 && my_startT.compareTo(endT1) < 0 ){
									
									//a.传入的开始时间my_startTStr 位于workTimeSideBean的某个时间段内，要累加
									between_hours2 = get_betweenHours(my_startT, endT1);
									starttimeSum = starttimeSum + between_hours2;
									
								}else if(my_startT.compareTo(startT1)	<= 0){
									
									//b.传入的开始时间my_startTStr 位于workTimeSideBean的开始时间前面或相等时，要累加
									starttimeSum = starttimeSum + between_hours;
								}else{
									//c.传入的开始时间my_startTStr 位于workTimeSideBean的结束时间后面或相等时，无需累加
								}
								
								//C.判断传入的结束时间，计算结束的那天工作和
								if( my_endT.compareTo(startT2) > 0 && my_endT.compareTo(endT2) < 0 ){
									
									//a.传入的结束时间my_endTStr 位于workTimeSideBean的某个时间段内，要累加
									between_hours3 = get_betweenHours(startT2,my_endT);
									endtimeSum = endtimeSum + between_hours3;
									
								}else if(my_endT.compareTo(endT2)	>= 0){
									
									//b.传入的结束时间my_endTStr 位于workTimeSideBean的结束时间后面或相等时，要累加
									endtimeSum = endtimeSum + between_hours;
								}else{
									//c.传入的结束时间my_endTStr 位于workTimeSideBean的开始时间前面或相等时，无需累加
									continue;
								}
							}
							
						}
					 
					 if(my_startDStr.equals(my_endDStr)){  //开始和结束日期是同一天
						 expendHours = timeSum;
						 
					 }else{//开始和结束日期不是同一天
						 
						//计算传入开始时间~结束时间 的工作时长总和（=相差天数-周末-节假日+特殊维护的工作日 的工作时长）
							expendHours = get_alltimesum(my_startD, my_endD, starttimeSum, everydaytimeSum, endtimeSum);
					 } 
					 
				 }else{
					 expendHours = 0;
				 }
				
				break;	
				
			}else if( (my_startD.compareTo(startD) >=0 && my_startD.compareTo(endD) <0 && my_endD.compareTo(endD) >=0)
					|| (my_startD.compareTo(startD) <0 && my_endD.compareTo(endD) >=0)
					|| (my_startD.compareTo(startD) <0 && my_endD.compareTo(startD) >=0 && my_endD.compareTo(endD) <0) ){
				//2.节点开始和结束日期在两个不同的有效日范围内
				
				double everydaytimeSum=0;//每天工作时间和
				double starttimeSum = 0; //第一天工作时间和
				double endtimeSum = 0;//最后一天工作时间和
				double expendtime1 = 0;
				double expendtime2 = 0;
				double expendtime3 = 0;
				
				 //查询该有效日对应的工作时间配置
				 workTimeSideBeans = tModelTimedayService.queryWorkTimeSide(workTimeMainBean);  
				
				 if(workTimeSideBeans.size() != 0){
					 if(my_startD.compareTo(startD) >=0 && my_startD.compareTo(endD) <0 && my_endD.compareTo(endD) >=0){
							//(1)节点开始日期在有效日范围内，节点结束日期不在这个时间范围内	
						
							for (WorkTimeSideBean workTimeSideBean : workTimeSideBeans) {
								String startTStr = workTimeSideBean.getStartTime();
								String endTStr = workTimeSideBean.getEndTime();
								
								//将节点日期与查到的时间字符串连接一起，用于时间比较
								 Date startT1 = sdf3.parse(my_startDStr+startTStr); //为节点开始日期，但开始时间是数据库查的
								 Date endT1 = sdf3.parse(my_startDStr+endTStr);   //为节点开始日期，但结束时间是数据库查的
								 
								//A.计算数据库配置的每天工作时间的时间差
								double between_hours = get_betweenHours(startT1, endT1);  //get_betweenHours(startT2, endT2)也可以，只要日期同一天即可，一个workTimeSideBean的时间差
								everydaytimeSum = everydaytimeSum + between_hours;
								
								double between_hours2 = 0;
								
								//B.判断传入的开始时间，计算开始的那天工作和
								if( my_startT.compareTo(startT1) > 0 && my_startT.compareTo(endT1) < 0 ){
									
									//a.传入的开始时间my_startTStr 位于workTimeSideBean的某个时间段内，要累加
									between_hours2 = get_betweenHours(my_startT, endT1);
									starttimeSum = starttimeSum + between_hours2;
									
								}else if(my_startT.compareTo(startT1)	<= 0){
									
									//b.传入的开始时间my_startTStr 位于workTimeSideBean的开始时间前面或相等时，要累加
									starttimeSum = starttimeSum + between_hours;
								}else{
									//c.传入的开始时间my_startTStr 位于workTimeSideBean的结束时间后面或相等时，无需累加
									continue;
								}
								
							}
							
							endtimeSum = everydaytimeSum;
							endD2 = new Date();
							endD2 =sdf.parse(sdf.format(endD)) ; //因为endD有效日结束日期不包含，故需要转换一下，并取前一天
							endD2.setDate(endD2.getDate()-1);
							
							//计算传入开始时间~结束时间 的工作时长总和（=相差天数-周末-节假日+特殊维护的工作日 的工作时长）
							expendtime1 = get_alltimesum(my_startD, endD2, starttimeSum, everydaytimeSum, endtimeSum);
							expendHours = expendHours + expendtime1;
							
						}else if(my_startD.compareTo(startD) <0 && my_endD.compareTo(startD) >=0 && my_endD.compareTo(endD) <0){
							//(2)节点开始日期不在这个时间范围内	，节点结束日期在有效日范围内
							
							for (WorkTimeSideBean workTimeSideBean : workTimeSideBeans) {
								String startTStr = workTimeSideBean.getStartTime();
								String endTStr = workTimeSideBean.getEndTime();
								
								//将节点日期与查到的时间字符串连接一起，用于时间比较
								 Date startT2 = sdf3.parse(my_endDStr+startTStr);  //为节点结束日期，但开始时间是数据库查的
								 Date endT2 = sdf3.parse(my_endDStr+endTStr);    //为节点结束日期，但结束时间是数据库查的
								 
								//A.计算数据库配置的每天工作时间的时间差
								double between_hours = get_betweenHours(startT2, endT2);  //一个workTimeSideBean的时间差
								everydaytimeSum = everydaytimeSum + between_hours;
								
								double between_hours3 = 0;
								
								//B.判断传入的结束时间，计算结束的那天工作和
								if( my_endT.compareTo(startT2) > 0 && my_endT.compareTo(endT2) < 0 ){
									
									//a.传入的结束时间my_endTStr 位于workTimeSideBean的某个时间段内，要累加
									between_hours3 = get_betweenHours(startT2,my_endT);
									endtimeSum = endtimeSum + between_hours3;
									
								}else if(my_endT.compareTo(endT2)	>= 0){
									
									//b.传入的结束时间my_endTStr 位于workTimeSideBean的结束时间后面或相等时，要累加
									endtimeSum = endtimeSum + between_hours;
								}else{
									//c.传入的结束时间my_endTStr 位于workTimeSideBean的开始时间前面或相等时，无需累加
								}
							}
							
							starttimeSum = everydaytimeSum;
							
							//计算传入开始时间~结束时间 的工作时长总和（=相差天数-周末-节假日+特殊维护的工作日 的工作时长）
							expendtime2 = get_alltimesum(startD, my_endD, starttimeSum, everydaytimeSum, endtimeSum);
							expendHours = expendHours + expendtime2;
							
						}else if(my_startD.compareTo(startD) <0 && my_endD.compareTo(endD) >=0){
							//(3)节点开始日期在有效日范围之前，节点结束日期在这个有效日范围之后	
							
							for (WorkTimeSideBean workTimeSideBean : workTimeSideBeans) {
								String startTStr = workTimeSideBean.getStartTime();
								String endTStr = workTimeSideBean.getEndTime();
								
								//将节点日期与查到的时间字符串连接一起，用于时间比较
								 Date startT1 = sdf3.parse(my_startDStr+startTStr); //为节点开始日期，但开始时间是数据库查的
								 Date endT1 = sdf3.parse(my_startDStr+endTStr);   //为节点开始日期，但结束时间是数据库查的
								 
								//A.计算数据库配置的每天工作时间的时间差
								double between_hours = get_betweenHours(startT1, endT1);  //用get_betweenHours(startT2, endT2)也可以，一个workTimeSideBean的时间差
								everydaytimeSum = everydaytimeSum + between_hours;
							}
							
							starttimeSum = everydaytimeSum;
							endtimeSum = everydaytimeSum;
							
							endD2 = new Date();
							endD2 =sdf.parse(sdf.format(endD)) ; //因为endD有效日结束日期不包含，故需要转换一下，并取前一天
							endD2.setDate(endD2.getDate()-1);
							
							//计算传入开始时间~结束时间 的工作时长总和（=相差天数-周末-节假日+特殊维护的工作日 的工作时长）
							expendtime3 = get_alltimesum(startD, endD2, starttimeSum, everydaytimeSum, endtimeSum);
							expendHours = expendHours + expendtime3;
							
						}
				 }else{
					 expendHours = 0;
				 }
				
				
			}else{
				//3.节点开始和结束日期都在有效日范围之前 或者 之后
				continue;
			}
    	}  	
    	
    	return (double)Math.round(expendHours*100)/100;   //四舍五入保留2位小数
    }
	
	
	/**
	 * 计算出的两个节点之间消耗多少工作日（单位：工作日，double四舍五入保留2位小数）
	 * 
	 * @param start 节点开始时间（14位字符串 格式：yyyyMMddHHmmss    如：20170101080000）
	 * @param end  节点结束时间（14位字符串 格式：yyyyMMddHHmmss    如：20170102080000）
	 * @return  expendDays 消耗的工作日（单位：工作日）
	 * @throws ParseException
	 */
	public    double  getworkTimeDiff_forDays(String start, String end) throws ParseException{
		
		
    	//消耗的工作时长 = （结束时间-开始时间）的工作时长 - 期间的非工作日
    	double expendHours = 0;
    	
    	//消耗的工作日 = 工作时长/有效日范围内的每天工作时长
    	double expendDays = 0;
    	
    	//例时间的传入格式为20160520115501
    	String my_startDStr = start.substring(0, 8); //节点开始日期。不包含第8位
    	String my_endDStr = end.substring(0, 8); //节点结束日期
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		 Date my_startD = sdf.parse(my_startDStr);//节点开始日期
		 Date my_endD = sdf.parse(my_endDStr);//节点结束日期
		 
		 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
		 Date my_startT = sdf2.parse(start);//节点开始时间
		 Date my_endT = sdf2.parse(end);//节点结束时间
    	
		 SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHH:mm:ss");

    	List<WorkTimeMainBean> workTimeMainBeans = tModelTimedayService.queryWorkTimeMain();  	

    	List<WorkTimeSideBean> workTimeSideBeans = new ArrayList<WorkTimeSideBean>();
    	
    	for (WorkTimeMainBean workTimeMainBean : workTimeMainBeans) {
			String startDStr = workTimeMainBean.getStartDate();
			String endDStr = workTimeMainBean.getEndDate();
			
			 Date startD = sdf.parse(startDStr);
			 Date endD = sdf.parse(endDStr);
			 Date endD2;
			 
			if( my_startD.compareTo(startD) >= 0 && my_endD.compareTo(endD) < 0 ){//因为有效日包前不包后，故不取等号
				//1.节点开始和结束日期在同一个有效日范围内
				
				double everydaytimeSum=0;//每天工作时间和
				double starttimeSum = 0; //第一天工作时间和
				double endtimeSum = 0;//最后一天工作时间和
				double timeSum = 0; //开始和结束日期是同一天时用，用于存放不同上班时间段的累计时间
				
				 //查询该有效日对应的工作时间配置
				 workTimeSideBeans = tModelTimedayService.queryWorkTimeSide(workTimeMainBean);  
				 
				 if(workTimeSideBeans.size() != 0){
					 for (WorkTimeSideBean workTimeSideBean : workTimeSideBeans) {
							
							String startTStr = workTimeSideBean.getStartTime();
							String endTStr = workTimeSideBean.getEndTime();
							
							//将节点日期与查到的时间字符串连接一起，用于时间比较
							 Date startT1 = sdf3.parse(my_startDStr+startTStr); //为节点开始日期，但开始时间是数据库查的
							 Date startT2 = sdf3.parse(my_endDStr+startTStr);  //为节点结束日期，但开始时间是数据库查的
							 Date endT1 = sdf3.parse(my_startDStr+endTStr);   //为节点开始日期，但结束时间是数据库查的
							 Date endT2 = sdf3.parse(my_endDStr+endTStr);    //为节点结束日期，但结束时间是数据库查的
							
							//A.计算数据库配置的每天工作时间的时间差
							double between_hours = get_betweenHours(startT1, endT1);  //用get_betweenHours(startT2, endT2)也可以，只要日期同一天即可，一个workTimeSideBean的时间差
							everydaytimeSum = everydaytimeSum + between_hours;
							
							if(my_startDStr.equals(my_endDStr)){  //开始和结束日期是同一天
								if( (my_startT.compareTo(startT1) > 0 && my_startT.compareTo(endT1) < 0) &&  my_endT.compareTo(endT1) >= 0 ){ //开始时间在工作时间段之间，结束时间在工作时间段之后或相等
									timeSum = timeSum + get_betweenHours(my_startT, endT1);
								}else if( my_startT.compareTo(startT1) <= 0  &&  my_endT.compareTo(endT1) >= 0 ){ //开始时间在工作时间段之前或相等，结束时间在工作时间段之后或相等
									timeSum = timeSum + get_betweenHours(startT1, endT1);
								}else if( my_startT.compareTo(endT1) >= 0  &&  my_endT.compareTo(endT1) >= 0 ){ //开始时间和结束时间都在工作时间段之后或相等
									timeSum = timeSum+0;
								}else if( (my_startT.compareTo(startT1) > 0 && my_startT.compareTo(endT1) < 0) &&  (my_endT.compareTo(startT1) > 0 && my_endT.compareTo(endT1) < 0) ){ //开始时间和结束时间都在工作时间段之间
									timeSum = timeSum+get_betweenHours(my_startT, my_endT);
								}else if(  my_startT.compareTo(startT1) <= 0 &&  (my_endT.compareTo(startT1) > 0 && my_endT.compareTo(endT1) < 0) ){ //开始时间在工作时间段之前或相等，结束时间在工作时间段之间
									timeSum = timeSum+get_betweenHours(startT1, my_endT);
								}else if(my_endT.compareTo(endT1) <= 0 ){ //结束时间在工作时间段之前或相等
									timeSum = timeSum + 0;
								}else{
									
								}
								
							}else{  //开始和结束日期不是同一天
								double between_hours2 = 0;
								double between_hours3 = 0;
								
								//B.判断传入的开始时间，计算开始的那天工作和
								if( my_startT.compareTo(startT1) > 0 && my_startT.compareTo(endT1) < 0 ){
									
									//a.传入的开始时间my_startTStr 位于workTimeSideBean的某个时间段内，要累加
									between_hours2 = get_betweenHours(my_startT, endT1);
									starttimeSum = starttimeSum + between_hours2;
									
								}else if(my_startT.compareTo(startT1)	<= 0){
									
									//b.传入的开始时间my_startTStr 位于workTimeSideBean的开始时间前面或相等时，要累加
									starttimeSum = starttimeSum + between_hours;
								}else{
									//c.传入的开始时间my_startTStr 位于workTimeSideBean的结束时间后面或相等时，无需累加
								}
								
								//C.判断传入的结束时间，计算结束的那天工作和
								if( my_endT.compareTo(startT2) > 0 && my_endT.compareTo(endT2) < 0 ){
									
									//a.传入的结束时间my_endTStr 位于workTimeSideBean的某个时间段内，要累加
									between_hours3 = get_betweenHours(startT2,my_endT);
									endtimeSum = endtimeSum + between_hours3;
									
								}else if(my_endT.compareTo(endT2)	>= 0){
									
									//b.传入的结束时间my_endTStr 位于workTimeSideBean的结束时间后面或相等时，要累加
									endtimeSum = endtimeSum + between_hours;
								}else{
									//c.传入的结束时间my_endTStr 位于workTimeSideBean的开始时间前面或相等时，无需累加
									continue;
								}
								
							}
						}
						
					 
					 if(my_startDStr.equals(my_endDStr)){  //开始和结束日期是同一天
						 expendDays = timeSum/everydaytimeSum;
					 }else{//开始和结束日期不是同一天
						 
						//计算传入开始时间~结束时间 的工作时长总和（=相差天数-周末-节假日+特殊维护的工作日 的工作时长）
							expendHours = get_alltimesum(my_startD, my_endD, starttimeSum, everydaytimeSum, endtimeSum);
							expendDays = expendHours/everydaytimeSum;
					 }
						
				 }else{
					 expendDays = 0;
				 }
				
				break;	
				
			}else if( (my_startD.compareTo(startD) >=0 && my_startD.compareTo(endD) <0 && my_endD.compareTo(endD) >=0)
					|| (my_startD.compareTo(startD) <0 && my_endD.compareTo(endD) >=0)
					|| (my_startD.compareTo(startD) <0 && my_endD.compareTo(startD) >=0 && my_endD.compareTo(endD) <0) ){
				//2.节点开始和结束日期在两个不同的有效日范围内
				
				double everydaytimeSum=0;//每天工作时间和
				double starttimeSum = 0; //第一天工作时间和
				double endtimeSum = 0;//最后一天工作时间和
				double expendtime1 = 0;
				double expendtime2 = 0;
				double expendtime3 = 0;
				
				 //查询该有效日对应的工作时间配置
				 workTimeSideBeans = tModelTimedayService.queryWorkTimeSide(workTimeMainBean); 
				 
				 if(workTimeSideBeans.size() != 0){
					 if(my_startD.compareTo(startD) >=0 && my_startD.compareTo(endD) <0 && my_endD.compareTo(endD) >=0){
							//(1)节点开始日期在有效日范围内，节点结束日期不在这个时间范围内	
						
							for (WorkTimeSideBean workTimeSideBean : workTimeSideBeans) {
								String startTStr = workTimeSideBean.getStartTime();
								String endTStr = workTimeSideBean.getEndTime();
								
								//将节点日期与查到的时间字符串连接一起，用于时间比较
								 Date startT1 = sdf3.parse(my_startDStr+startTStr); //为节点开始日期，但开始时间是数据库查的
								 Date endT1 = sdf3.parse(my_startDStr+endTStr);   //为节点开始日期，但结束时间是数据库查的
								 
								//A.计算数据库配置的每天工作时间的时间差
								double between_hours = get_betweenHours(startT1, endT1);  //get_betweenHours(startT2, endT2)也可以，只要日期同一天即可，一个workTimeSideBean的时间差
								everydaytimeSum = everydaytimeSum + between_hours;
								
								double between_hours2 = 0;
								
								//B.判断传入的开始时间，计算开始的那天工作和
								if( my_startT.compareTo(startT1) > 0 && my_startT.compareTo(endT1) < 0 ){
									
									//a.传入的开始时间my_startTStr 位于workTimeSideBean的某个时间段内，要累加
									between_hours2 = get_betweenHours(my_startT, endT1);
									starttimeSum = starttimeSum + between_hours2;
									
								}else if(my_startT.compareTo(startT1)	<= 0){
									
									//b.传入的开始时间my_startTStr 位于workTimeSideBean的开始时间前面或相等时，要累加
									starttimeSum = starttimeSum + between_hours;
								}else{
									//c.传入的开始时间my_startTStr 位于workTimeSideBean的结束时间后面或相等时，无需累加
									continue;
								}
								
							}
							
							endtimeSum = everydaytimeSum;
							endD2 = new Date();
							endD2 =sdf.parse(sdf.format(endD)) ; //因为endD有效日结束日期不包含，故需要转换一下，并取前一天
							endD2.setDate(endD2.getDate()-1);
							
							//计算传入开始时间~结束时间 的工作时长总和（=相差天数-周末-节假日+特殊维护的工作日 的工作时长）
							expendtime1 = get_alltimesum(my_startD, endD2, starttimeSum, everydaytimeSum, endtimeSum);
							expendDays = expendDays + expendtime1/everydaytimeSum;
							
						}else if(my_startD.compareTo(startD) <0 && my_endD.compareTo(startD) >=0 && my_endD.compareTo(endD) <0){
							//(2)节点开始日期不在这个时间范围内	，节点结束日期在有效日范围内
							
							for (WorkTimeSideBean workTimeSideBean : workTimeSideBeans) {
								String startTStr = workTimeSideBean.getStartTime();
								String endTStr = workTimeSideBean.getEndTime();
								
								//将节点日期与查到的时间字符串连接一起，用于时间比较
								 Date startT2 = sdf3.parse(my_endDStr+startTStr);  //为节点结束日期，但开始时间是数据库查的
								 Date endT2 = sdf3.parse(my_endDStr+endTStr);    //为节点结束日期，但结束时间是数据库查的
								 
								//A.计算数据库配置的每天工作时间的时间差
								double between_hours = get_betweenHours(startT2, endT2);  //一个workTimeSideBean的时间差
								everydaytimeSum = everydaytimeSum + between_hours;
								
								double between_hours3 = 0;
								
								//B.判断传入的结束时间，计算结束的那天工作和
								if( my_endT.compareTo(startT2) > 0 && my_endT.compareTo(endT2) < 0 ){
									
									//a.传入的结束时间my_endTStr 位于workTimeSideBean的某个时间段内，要累加
									between_hours3 = get_betweenHours(startT2,my_endT);
									endtimeSum = endtimeSum + between_hours3;
									
								}else if(my_endT.compareTo(endT2)	>= 0){
									
									//b.传入的结束时间my_endTStr 位于workTimeSideBean的结束时间后面或相等时，要累加
									endtimeSum = endtimeSum + between_hours;
								}else{
									//c.传入的结束时间my_endTStr 位于workTimeSideBean的开始时间前面或相等时，无需累加
								}
							}
							
							starttimeSum = everydaytimeSum;
							
							//计算传入开始时间~结束时间 的工作时长总和（=相差天数-周末-节假日+特殊维护的工作日 的工作时长）
							expendtime2 = get_alltimesum(startD, my_endD, starttimeSum, everydaytimeSum, endtimeSum);
							expendDays = expendDays + expendtime2/everydaytimeSum;
							
						}else if(my_startD.compareTo(startD) <0 && my_endD.compareTo(endD) >=0){
							//(3)节点开始日期在有效日范围之前，节点结束日期在这个有效日范围之后	
							
							for (WorkTimeSideBean workTimeSideBean : workTimeSideBeans) {
								String startTStr = workTimeSideBean.getStartTime();
								String endTStr = workTimeSideBean.getEndTime();
								
								//将节点日期与查到的时间字符串连接一起，用于时间比较
								 Date startT1 = sdf3.parse(my_startDStr+startTStr); //为节点开始日期，但开始时间是数据库查的
								 Date endT1 = sdf3.parse(my_startDStr+endTStr);   //为节点开始日期，但结束时间是数据库查的
								 
								//A.计算数据库配置的每天工作时间的时间差
								double between_hours = get_betweenHours(startT1, endT1);  //用get_betweenHours(startT2, endT2)也可以，一个workTimeSideBean的时间差
								everydaytimeSum = everydaytimeSum + between_hours;
							}
							
							starttimeSum = everydaytimeSum;
							endtimeSum = everydaytimeSum;
							
							endD2 = new Date();
							endD2 =sdf.parse(sdf.format(endD)) ; //因为endD有效日结束日期不包含，故需要转换一下，并取前一天
							endD2.setDate(endD2.getDate()-1);
							
							//计算传入开始时间~结束时间 的工作时长总和（=相差天数-周末-节假日+特殊维护的工作日 的工作时长）
							expendtime3 = get_alltimesum(startD, endD2, starttimeSum, everydaytimeSum, endtimeSum);
							expendDays = expendDays + expendtime3/everydaytimeSum;
							
						}
				 }else{
					 expendDays = 0;
				 }
				
				
				
			}else{
				//3.节点开始和结束日期都在有效日范围之前 或者 之后
				continue;
			}
    	}  	
    	
    	return (double)Math.round(expendDays*100)/100;   //四舍五入保留2位小数
    }
	
	
	
	/**
     * @desc 计算两个时间之间相差的小时数
     * @author liaomeiting
     * @param startTStr
     * @param endTStr
     * @return between_hours 
     * @throws ParseException
     */
    public  double get_betweenHours(Date startT, Date endT)  throws ParseException {
    	
    	long diff = endT.getTime() - startT.getTime();
    	double between_hours = diff * 1.0 / (1000 * 60 * 60);  //单位为小时
    	return between_hours;
    }
    
    /**
     * @desc 计算传入开始时间~结束时间 的工作时长总和（=相差天数-周末-节假日+特殊维护的工作日 的工作时长）
     * @author liaomeiting
     * @return alltimeSum
     * @throws ParseException
     */
    public   double get_alltimesum(Date startD, Date endD, double starttimeSum, double everydaytimeSum, double endtimeSum) throws ParseException{
    	
    	SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
    	
    	//将startD的时间赋给startD2，不能用等号直接赋值，否则当startD2值变了，startD也会跟着累加变化
    	String startDstr = sd.format(startD);
    	String endDstr = sd.format(endD);
    	Date startD2 = sd.parse(startDstr);  //用于日期累加
		
		int between_days = 0;  
		Date startD3;
		List<Date> datelist = new ArrayList<Date>(); //用于存放传入的开始~结束时间里遇到的 周六或周日的日期
		
		//1.判断除去周末所占天数
		while (startD2.compareTo(endD) <= 0) {
			
			if (startD2.getDay() != 6 && startD2.getDay() != 0){  //getDay()=6代表周六， getDay()=0代表周日
				between_days++;  
			}else{
				startD3 = new Date();
				startD3 = sd.parse(sd.format(startD2));
				datelist.add(startD3);
			}
	
			startD2.setDate(startD2.getDate() + 1);  
		}  
		
		double alltimeSum = 0;
		boolean flag1 = false;
		boolean flag2 = false;
		
		for (Date date : datelist) {
			if(date.compareTo(startD) == 0){ //开始日期是周末
				flag1 = true;
			}
			
			if(date.compareTo(endD) == 0){ //结束日期是周末
				flag2 = true;
			}
		}
		
		if(flag1 == true && flag2 == true){ //开始日期和结束日期都是周末
			alltimeSum = everydaytimeSum * between_days;
		}else if(flag1 == true && flag2 == false){ //开始日期是周末，而结束日期不是周末
			alltimeSum = everydaytimeSum * (between_days-1) + endtimeSum;
		}else if(flag1 == false && flag2 == true){//结束日期是周末，而开始日期不是周末
			alltimeSum = starttimeSum + everydaytimeSum * (between_days-1);
		}else{//开始日期和结束日期都不是周末
			alltimeSum = starttimeSum+everydaytimeSum*(between_days-2)+endtimeSum;
		}
		
		//2.判断为节假日要除去，为特殊维护的工作日要加上
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("startD", startDstr);
		map.put("endD", endDstr);
		
		//查找配置的日期在 传入的日期范围之间 的节假日、工作日
		List<TModelTimeday> list = tModelTimedayService.queryWorkDayList(map);
		 
		for (TModelTimeday tModelTimeday : list) { //循环节假日、工作日
			Date timedate =  sd.parse(tModelTimeday.getTime());
			boolean weekend_flag = false; //该标志用于判断节假日是否与周末是同一天，默认不是
			
			for (Date date : datelist) {//循环周末日期
				if(timedate.compareTo(date) == 0){//节假日/工作日 与周末是同一天
					weekend_flag = true;
					break;
				}
				//节假日与周末不是同一天，则继续判断下一条
			}
			
			//当遇到配置类型为“节假日”，要扣掉
			if( "1".equals(tModelTimeday.getType()) ){
				//节假日是开始日期，且节假日周末不重叠
				if( timedate.compareTo(startD) == 0 && weekend_flag == false ){
					alltimeSum = alltimeSum - starttimeSum;
				}
				
				//节假日是结束日期，且节假日周末不重叠
				if(timedate.compareTo(endD) == 0 && weekend_flag == false){
					alltimeSum = alltimeSum - endtimeSum;
				}
				
				//节假日不是开始日期也不是结束日期，且节假日周末不重叠
				if(timedate.compareTo(startD) != 0 && timedate.compareTo(endD) != 0 && weekend_flag == false){
					alltimeSum = alltimeSum - everydaytimeSum;
				}
			}
			
			//当遇到配置类型为“工作日”，要加上
			if( "2".equals(tModelTimeday.getType()) ){
				//特殊维护的工作日是开始日期，且周末设为工作日
				if(timedate.compareTo(startD) == 0 && weekend_flag == true){
					alltimeSum = alltimeSum + starttimeSum;
				}
				
				//特殊维护的工作日是结束日期，且周末设为工作日
				if(timedate.compareTo(endD) == 0 && weekend_flag == true){
					alltimeSum = alltimeSum + endtimeSum;
				}
				
				//特殊维护的工作日不是开始日期也不是结束日期，且周末设为工作日
				if(timedate.compareTo(startD) != 0 && timedate.compareTo(endD) != 0 && weekend_flag == true){
					alltimeSum = alltimeSum + everydaytimeSum;
				}
			}
				
		}
		
		return alltimeSum;
		
    }
    
    
   
    
    
}
