package com.gotop.reportjbpm.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gotop.reportjbpm.dao.ITimeLimitConditionReportDao;
import com.gotop.reportjbpm.model.TimeLimitConditionReport;
import com.gotop.reportjbpm.service.ITimeLimitConditionReportService;
import com.gotop.util.string.Obj2StrUtils;
import com.gotop.vo.system.MUOUserSession;
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
	public List<TimeLimitConditionReport> queryTimeLimitConditionReportList(MUOUserSession muo,
			TimeLimitConditionReport timeLimitConditionReport, Page page) {
	    List<TimeLimitConditionReport> timeLimitConditionReportList =new ArrayList<TimeLimitConditionReport>();
	   // List<TimeLimitConditionReport> resulettimeLimitConditionReportList =new ArrayList<TimeLimitConditionReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		
		String orgcode = muo.getOrgcode();
		List list  = timeLimitConditionReportDao.yesOrNot_dep(orgcode); //查询当前机构是部门还是机构
		
		if (list.size() != 0){
			 HashMap<String, Object>  hp = (HashMap<String, Object>) list.get(0);
			 if("no".equals(hp.get("IS_DEP"))) { //当前机构不是部门，说明是支行
				 map.put("defaultOrgcode", hp.get("ORGCODE")); //查询列表默认显示本级及下级的数据
			 }
		}
		
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
		
		if(timeLimitConditionReport.getSppTimeStart()!=null&&!"".equals(timeLimitConditionReport.getSppTimeStart())){
			map.put("sppTimeType", "0");
			map.put("sppTimeStart", timeLimitConditionReport.getSppTimeStart());
			
		}
		if(timeLimitConditionReport.getSppTimeEnd()!=null&&!"".equals(timeLimitConditionReport.getSppTimeEnd())){
			map.put("sppTimeType", "1");
			map.put("sppTimeEnd", timeLimitConditionReport.getSppTimeEnd());
			
		}
		if(timeLimitConditionReport.getSppTimeEnd()!=null&&!"".equals(timeLimitConditionReport.getSppTimeEnd())&&timeLimitConditionReport.getSppTimeStart()!=null&&!"".equals(timeLimitConditionReport.getSppTimeStart())){
			map.put("sppTimeType", "2");
			map.put("sppTimeStart", timeLimitConditionReport.getSppTimeStart());
			map.put("sppTimeEnd", timeLimitConditionReport.getSppTimeEnd());
			
		}
		if(timeLimitConditionReport.getScName()!=null&&!"".equals(timeLimitConditionReport.getScName())){
			map.put("scName", timeLimitConditionReport.getScName());
			
		}
		if(timeLimitConditionReport.getSpName()!=null&&!"".equals(timeLimitConditionReport.getSpName())){
			map.put("spName", timeLimitConditionReport.getSpName());
			
		}
		timeLimitConditionReportList=timeLimitConditionReportDao.queryTimeLimitConditionReportList(map, page);
//		
//		//讲结果集开始、结束时进行计算重新存入List
//		if(timeLimitConditionReportList.size()>0){
//			//前提需要在对应的actionContext这个spring文件里 配置MyUtil
//	    	try {
//		    	Object bean = SpringContextUtil.getBean("myUtil"); 
//				Class<?> classes = Class.forName("com.gotop.reportjbpm.MyUtil");
//			
//	    	
//	    	//计算消耗的工作时间(单位：小时)
//	    	//Method thismethod = classes.getDeclaredMethod("getworkTimeDiff_forHours", String.class,String.class);
//	    	
//	    	//计算消耗的工作时间(单位：工作日)
//	    	//Method thismethod = classes.getDeclaredMethod("getworkTimeDiff_forDays", String.class,String.class);
//			for(int i=0;i<timeLimitConditionReportList.size();i++){
//				TimeLimitConditionReport tt=new TimeLimitConditionReport();
//				tt.setOrgNameOne(timeLimitConditionReportList.get(i).getOrgNameOne());
//				tt.setOrgNameTwo(timeLimitConditionReportList.get(i).getOrgNameTwo());
//				tt.setOneCategory(timeLimitConditionReportList.get(i).getOneCategory());
//				tt.setLoanCategory(timeLimitConditionReportList.get(i).getLoanCategory());
//				tt.setZdCustManager(timeLimitConditionReportList.get(i).getZdCustManager());
//				
//				//判断开始结束时间
//				String zhgpdTimeOne=timeLimitConditionReportList.get(i).getZhgpdTimeOne();
//				//String  zhgpdTimeOnetest="20170729040559,20170623040136";
//				
//				zhgpdTimeOne=getWorkTimeforDays(bean,classes,zhgpdTimeOne);
//				tt.setZhgpdTimeOne(zhgpdTimeOne);
//				
//				String zhgpdTimeTwo=timeLimitConditionReportList.get(i).getZhgpdTimeTwo();
//				zhgpdTimeTwo=getWorkTimeforDays(bean,classes,zhgpdTimeTwo);
//				tt.setZhgpdTimeTwo(zhgpdTimeTwo);
//				
//				String zhgpdTimeThree=timeLimitConditionReportList.get(i).getZhgpdTimeThree();
//				zhgpdTimeThree=getWorkTimeforDays(bean,classes,zhgpdTimeThree);
//				tt.setZhgpdTimeThree(zhgpdTimeThree);
//				
//				String reviewApprovalOneTime=timeLimitConditionReportList.get(i).getReviewApprovalOneTime();
//				reviewApprovalOneTime=getWorkTimeforDays(bean,classes,reviewApprovalOneTime);
//				tt.setReviewApprovalOneTime(reviewApprovalOneTime);
//				
//				String reviewApprovalTwoTime=timeLimitConditionReportList.get(i).getReviewApprovalTwoTime();
//				reviewApprovalTwoTime=getWorkTimeforDays(bean,classes,reviewApprovalTwoTime);
//				tt.setReviewApprovalTwoTime(reviewApprovalTwoTime);
//				
//				
//				String reviewApprovalThreeOrMoreTime=timeLimitConditionReportList.get(i).getReviewApprovalThreeOrMoreTime();
//				reviewApprovalThreeOrMoreTime=getWorkTimeforDays(bean,classes,reviewApprovalThreeOrMoreTime);
//				tt.setReviewApprovalThreeOrMoreTime(reviewApprovalThreeOrMoreTime);
//				
//
//				String allProcessTimeOne=timeLimitConditionReportList.get(i).getAllProcessTimeOne();
//				allProcessTimeOne=getWorkTimeforDays(bean,classes,allProcessTimeOne);
//				tt.setAllProcessTimeOne(allProcessTimeOne);
//				
//				String allProcessTimeTwo=timeLimitConditionReportList.get(i).getAllProcessTimeTwo();
//				allProcessTimeTwo=getWorkTimeforDays(bean,classes,allProcessTimeTwo);
//				tt.setAllProcessTimeTwo(allProcessTimeTwo);
//				
//				String zlwzhApprovalTime=timeLimitConditionReportList.get(i).getZlwzhApprovalTime();
//				zlwzhApprovalTime=getWorkTimeforDays(bean,classes,zlwzhApprovalTime);
//				tt.setZlwzhApprovalTime(zlwzhApprovalTime);
//				
//				resulettimeLimitConditionReportList.add(tt);
//			}
//	    	} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		}else{
//			resulettimeLimitConditionReportList=timeLimitConditionReportList;
//		}
		
		return timeLimitConditionReportList;
	}

	@Override
	public List<TimeLimitConditionReport> queryTimeLimitConditionReportListForExcel(MUOUserSession muo,
			TimeLimitConditionReport timeLimitConditionReport) {
		List<TimeLimitConditionReport> timeLimitConditionReportList =new ArrayList<TimeLimitConditionReport>();
	    //List<TimeLimitConditionReport> resulettimeLimitConditionReportList =new ArrayList<TimeLimitConditionReport>();
		Map<String, Object>map=new HashMap<String, Object>();
		
		String orgcode = muo.getOrgcode();
		List list  = timeLimitConditionReportDao.yesOrNot_dep(orgcode); //查询当前机构是部门还是机构
		
		if (list.size() != 0){
			 HashMap<String, Object>  hp = (HashMap<String, Object>) list.get(0);
			 if("no".equals(hp.get("IS_DEP"))) { //当前机构不是部门，说明是支行
				 map.put("defaultOrgcode", hp.get("ORGCODE")); //查询列表默认显示本级及下级的数据
			 }
		}
		
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

		if(timeLimitConditionReport.getSppTimeStart()!=null&&!"".equals(timeLimitConditionReport.getSppTimeStart())){
			map.put("sppTimeType", "0");
			map.put("sppTimeStart", timeLimitConditionReport.getSppTimeStart());
			
		}
		if(timeLimitConditionReport.getSppTimeEnd()!=null&&!"".equals(timeLimitConditionReport.getSppTimeEnd())){
			map.put("sppTimeType", "1");
			map.put("sppTimeEnd", timeLimitConditionReport.getSppTimeEnd());
			
		}
		if(timeLimitConditionReport.getSppTimeEnd()!=null&&!"".equals(timeLimitConditionReport.getSppTimeEnd())&&timeLimitConditionReport.getSppTimeStart()!=null&&!"".equals(timeLimitConditionReport.getSppTimeStart())){
			map.put("sppTimeType", "2");
			map.put("sppTimeStart", timeLimitConditionReport.getSppTimeStart());
			map.put("sppTimeEnd", timeLimitConditionReport.getSppTimeEnd());
			
		}
		if(timeLimitConditionReport.getScName()!=null&&!"".equals(timeLimitConditionReport.getScName())){
			map.put("scName", timeLimitConditionReport.getScName());
			
		}
		if(timeLimitConditionReport.getSpName()!=null&&!"".equals(timeLimitConditionReport.getSpName())){
			map.put("spName", timeLimitConditionReport.getSpName());
			
		}
		timeLimitConditionReportList=timeLimitConditionReportDao.queryTimeLimitConditionReportListForExcel(map);
//		//讲结果集开始、结束时进行计算重新存入List
//		if(timeLimitConditionReportList.size()>0){
//			//前提需要在对应的actionContext这个spring文件里 配置MyUtil
//	    	try {
//		    	Object bean = SpringContextUtil.getBean("myUtil"); 
//				Class<?> classes = Class.forName("com.gotop.reportjbpm.MyUtil");
//			
//	    	
//	    	//计算消耗的工作时间(单位：小时)
//	    	//Method thismethod = classes.getDeclaredMethod("getworkTimeDiff_forHours", String.class,String.class);
//	    	
//	    	//计算消耗的工作时间(单位：工作日)
//	    	//Method thismethod = classes.getDeclaredMethod("getworkTimeDiff_forDays", String.class,String.class);
//			for(int i=0;i<timeLimitConditionReportList.size();i++){
//				TimeLimitConditionReport tt=new TimeLimitConditionReport();
//				tt.setOrgNameOne(timeLimitConditionReportList.get(i).getOrgNameOne());
//				tt.setOrgNameTwo(timeLimitConditionReportList.get(i).getOrgNameTwo());
//				tt.setOneCategory(timeLimitConditionReportList.get(i).getOneCategory());
//				tt.setLoanCategory(timeLimitConditionReportList.get(i).getLoanCategory());
//				tt.setZdCustManager(timeLimitConditionReportList.get(i).getZdCustManager());
//				
//				//判断开始结束时间
//				String zhgpdTimeOne=timeLimitConditionReportList.get(i).getZhgpdTimeOne();
//				//String  zhgpdTimeOnetest="20170729040559,20170623040136";
//				
//				zhgpdTimeOne=getWorkTimeforDays(bean,classes,zhgpdTimeOne);
//				tt.setZhgpdTimeOne(zhgpdTimeOne);
//				
//				String zhgpdTimeTwo=timeLimitConditionReportList.get(i).getZhgpdTimeTwo();
//				zhgpdTimeTwo=getWorkTimeforDays(bean,classes,zhgpdTimeTwo);
//				tt.setZhgpdTimeTwo(zhgpdTimeTwo);
//				
//				String zhgpdTimeThree=timeLimitConditionReportList.get(i).getZhgpdTimeThree();
//				zhgpdTimeThree=getWorkTimeforDays(bean,classes,zhgpdTimeThree);
//				tt.setZhgpdTimeThree(zhgpdTimeThree);
//				
//				String reviewApprovalOneTime=timeLimitConditionReportList.get(i).getReviewApprovalOneTime();
//				reviewApprovalOneTime=getWorkTimeforDays(bean,classes,reviewApprovalOneTime);
//				tt.setReviewApprovalOneTime(reviewApprovalOneTime);
//				
//				String reviewApprovalTwoTime=timeLimitConditionReportList.get(i).getReviewApprovalTwoTime();
//				reviewApprovalTwoTime=getWorkTimeforDays(bean,classes,reviewApprovalTwoTime);
//				tt.setReviewApprovalTwoTime(reviewApprovalTwoTime);
//				
//				
//				String reviewApprovalThreeOrMoreTime=timeLimitConditionReportList.get(i).getReviewApprovalThreeOrMoreTime();
//				reviewApprovalThreeOrMoreTime=getWorkTimeforDays(bean,classes,reviewApprovalThreeOrMoreTime);
//				tt.setReviewApprovalThreeOrMoreTime(reviewApprovalThreeOrMoreTime);
//				
//
//				String allProcessTimeOne=timeLimitConditionReportList.get(i).getAllProcessTimeOne();
//				allProcessTimeOne=getWorkTimeforDays(bean,classes,allProcessTimeOne);
//				tt.setAllProcessTimeOne(allProcessTimeOne);
//				
//				String allProcessTimeTwo=timeLimitConditionReportList.get(i).getAllProcessTimeTwo();
//				allProcessTimeTwo=getWorkTimeforDays(bean,classes,allProcessTimeTwo);
//				tt.setAllProcessTimeTwo(allProcessTimeTwo);
//				
//				String zlwzhApprovalTime=timeLimitConditionReportList.get(i).getZlwzhApprovalTime();
//				zlwzhApprovalTime=getWorkTimeforDays(bean,classes,zlwzhApprovalTime);
//				tt.setZlwzhApprovalTime(zlwzhApprovalTime);
//				
//				resulettimeLimitConditionReportList.add(tt);
//			}
//	    	} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		}else{
//			resulettimeLimitConditionReportList=timeLimitConditionReportList;
//		}
			
		return timeLimitConditionReportList;
	}

	@Override
	public Object queryReportUpdatetime() {
		Object object = this.timeLimitConditionReportDao.queryReportUpdatetime();
		return object;
	}

	/**
	 * 处理开始结束时间：格式20151218031212,20151218031244
	 * @param tempTime
	 * @return
	 */
//    private String getWorkTimeforDays(Object bean,Class<?> classes,String tempTime){
//    	String resulttempTime="0";
//    	if(!"0".equals(tempTime)){
//			String zhgpdTimeOneObj[]=tempTime.split(",");
//			String zhgpdTimeOneEnd=zhgpdTimeOneObj[1];
//			String zhgpdTimeOneStart=zhgpdTimeOneObj[0];
//			if(!"0".equals(zhgpdTimeOneStart)&&!"0".equals(zhgpdTimeOneEnd)){
//				try {
//
//			    	Method thismethod = classes.getDeclaredMethod("getworkTimeDiff_forDays", String.class,String.class);
//			    	Double resultTime = (Double) thismethod.invoke(bean, zhgpdTimeOneStart, zhgpdTimeOneEnd);
//			    	if(resultTime>0){
//						resulttempTime=String.valueOf(resultTime);
//			    	}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//    	return  resulttempTime;
//    }
    
    
}
