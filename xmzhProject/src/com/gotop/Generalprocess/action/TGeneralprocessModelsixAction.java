package com.gotop.Generalprocess.action;


import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.ProcessMistake;
import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelSix;
import com.gotop.Generalprocess.model.ProcessSubmitter;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.IGeneralprocessMistakeService;
import com.gotop.Generalprocess.service.ITGeneralprocessCdtypeService;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModeloneService;
import com.gotop.Generalprocess.service.ITGeneralprocessModelsixService;
import com.gotop.Generalprocess.util.GeneralprocessUtil;
import com.gotop.crm.util.BaseAction;

import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.opinion.model.TDefaultOpinion;
import com.gotop.opinion.service.ITDefaultOpinionService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;

/**
 * 
 * @author wujiajun
 * 
 *
 */
public class TGeneralprocessModelsixAction extends BaseAction {
	
	private String[] rectification;
	private String[] mistakeId;

	public String[] getMistakeId() {
		return mistakeId;
	}

	public void setMistakeId(String[] mistakeId) {
		this.mistakeId = mistakeId;
	}

	public String[] getRectification() {
		return rectification;
	}

	public void setRectification(String[] rectification) {
		this.rectification = rectification;
	}
	
	
	/**
	 * 当前用户和提交人po
	 */
	private ProcessSubmitter processSubmitter;
	private ProcessMistake processMistake;
	private List<ProcessMistake> processMistakeList = new ArrayList<ProcessMistake>();
	public List<ProcessMistake> getProcessMistakeList() {
		return processMistakeList;
	}

	public void setProcessMistakeList(List<ProcessMistake> processMistakeList) {
		this.processMistakeList = processMistakeList;
	}

	public ProcessMistake getProcessMistake() {
		return processMistake;
	}

	public void setProcessMistake(ProcessMistake processMistake) {
		this.processMistake = processMistake;
	}

	public ProcessSubmitter getProcessSubmitter() {
		return processSubmitter;
	}

	public void setProcessSubmitter(ProcessSubmitter processSubmitter) {
		this.processSubmitter = processSubmitter;
	}
	/**
	 * 差错相关的service
	 */
	private IGeneralprocessMistakeService generalprocessMistakeService;
	
	public IGeneralprocessMistakeService getGeneralprocessMistakeService() {
		return generalprocessMistakeService;
	}

	public void setGeneralprocessMistakeService(
			IGeneralprocessMistakeService generalprocessMistakeService) {
		this.generalprocessMistakeService = generalprocessMistakeService;
	}
	
	
	
	//output    input 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	private  List<String>  supportCategory;

	private  String isStrat;
	
	public List<String> getSupportCategory() {
		return supportCategory;
	}


	public void setSupportCategory(List<String> supportCategory) {
		this.supportCategory = supportCategory;
	}


	/**
	 * 模式对象
	 */
	private ProcessModelSix modelSix;
	
	private ProcessModelOne modelOne;
	
	/**
	 * 页面传输对象
	 */
	private TaskAssgineeDto taskAssgineeDto;
	/**
	 * 模式主表服务
	 */
	private ITGeneralprocessMainService generalprocessMainService;
	/**
	 * jbpm服务
	 */
	private JbpmService jbpmService;
	
	/**
	 * 模式一服务
	 */
	private ITGeneralprocessModeloneService generalprocessModeloneService;
	
	
	/**
	 * 页面标题展示
	 */
	private String taskName;
	
	/**
	 * isView :1、为只读状态， 默认为空
	 */
	private String isView;
	

    /**
     * 通过spring注入的Service对象.
     * @abatorgenerated
     */
    protected ITGeneralprocessModelsixService tGeneralprocessModelsixService;

    private List<TDefaultOpinion> defaultOps;
	
	private ITDefaultOpinionService tDefaultOpinionService;
    
    //action 开始
    
    
    
    
    public String toModelSix() throws SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException{
    	
    	//获取流程实例id
    	
    	         
    	//显示客户姓名  不可改        
    	
    	
    			String businessId = taskAssgineeDto.getExecutionId();
    			
    			
    			taskName= taskAssgineeDto.getTaskName();
    			
    			
    			//one   oooo
    			
    			
    			//null
    			
    			//获取流程配置主表对象
    			TGeneralprocessMain main = this.generalprocessMainService.queryMainByBusinessId(businessId);
    			
    			MUOUserSession muo = getCurrentOnlineUser();
    			if(main != null){
    				if(main.getBeginEmpId() != null && main.getBeginOrgId() != null){
    					taskAssgineeDto.setBeginAssingee(main.getBeginEmpId());
    					taskAssgineeDto.setBeginOrg(main.getBeginOrgId());
    				}
    			}else{
    				taskAssgineeDto.setBeginAssingee(muo.getEmpid());
					taskAssgineeDto.setBeginOrg(muo.getOrgid());
    			}
    			
    			Map<String, Object> map = new LinkedHashMap<String, Object>();
    			String taskName1 = "";
    			if(taskAssgineeDto.getNextTaskId() != null){
    				//待办-办理
    				taskName1 = jbpmService.getTaskNameById(taskAssgineeDto.getNextTaskId());
    			}else{
    				if(taskAssgineeDto.getActivityName() != null){
    					//已办-查看详情
    					taskName1 = taskAssgineeDto.getActivityName();
    					taskName=taskName1;
    				}
    			}
    			
    			
    			ProcessModelSix newModelSix = new ProcessModelSix();
    			if(businessId != null && taskName1 != null){
    				ProcessModelSix modelSix = new ProcessModelSix();
        			modelSix.setFlowId(businessId);
        			modelSix.setTaskName(taskName1);
        			newModelSix = this.tGeneralprocessModelsixService.queryModelSixByFlowIdAndTaskName(modelSix);
        			
        			if(newModelSix != null && newModelSix.getRate_float_scale() != null){
        				newModelSix.setRate_float_scale( (newModelSix.getRate_float_scale()).replace("%","") );
        			}
    			}
    			
    			String[] rulesArray = null;
    			String[] idsArray = null;
    			if(main != null){
    				if(main.getRules() != null && !"".equals(main.getRules())){
    					String rules = main.getRules();
    					rulesArray = rules.split(",");
    				}
    				
    				if(main.getIds() != null && !"".equals(main.getIds())){
    					String ids = main.getIds();
    					idsArray = ids.split(",");
    				}
    				
    				for (int i = 0; i < idsArray.length; i++) {
    					String id = idsArray[i];
    					String rule = rulesArray[i];
    					if(map.containsKey(rule + "-" + id)){
    						continue;
    					}else{
    						map.put(rule + "-" + id, id);
    					}
    				}
    			}
    			
    			String rm = "";
    			if(newModelSix != null){
    				rm="ProcessModelSix" + "-" + newModelSix.getProcessModelId();
    				map.remove(rm);
    			}
    			
    			//模式6显示 客户名称
    			this.setModelSix(newModelSix);
    			
    			
    			
    			if(modelSix==null){
    				modelSix= new ProcessModelSix();
    			}
    			if(businessId!=null){
    				
    				ProcessModelOne modelOne =new ProcessModelOne();
    				modelOne.setFlow_Id(taskAssgineeDto.getExecutionId());
    				ProcessModelOne modelOne1=generalprocessModeloneService.queryModelOne(modelOne);
    				
    				//是否有经过模式一 0：没有经过 		 1：有经过
    				isStrat="0";
    				if(modelOne1!=null)
    				{
    					modelSix.setOneCategory(modelOne1.getOneCategory());
    					modelSix.setLoanCategory(modelOne1.getLoanCategory());

    					if(modelOne1.getCust_grade() != null){
    						modelSix.setCust_grade(modelOne1.getCust_grade());
    					}
    					if(modelOne1.getBasic_rate_float() != null){
    						modelSix.setBasic_rate_float(modelOne1.getBasic_rate_float());
    					}
    					if(modelOne1.getRate_float_scale() != null){
    						modelSix.setRate_float_scale(modelOne1.getRate_float_scale().replace("%",""));
    					}
    					
    					isStrat="1";
    					this.setModelOne(modelOne1);
    				}
    				
    				
    			}
    			//获取模式一的一级分类以及贷种分类
    			
    			if((!"start".equals(taskAssgineeDto.getStartFlag()))&&(!"detial".equals(taskAssgineeDto.getStartFlag()))&&(taskAssgineeDto.getBusinessTitle()!=null)){
    				//不是第一次  才能set  custname
    				modelSix.setCustName(taskAssgineeDto.getBusinessTitle().split("-")[1]);
    				
    			}
    			// 
    			//页面的支用类型！  显示的东西  更具 T_GENERALPROCESS_SIXCONFIG 的配置信息读取！
    			String seachName=  taskAssgineeDto.getProcessName();
    			
    			if(seachName==null||"".equals(seachName)){
    				//如果传入的参数为空  那么就不要去查询了 因为查询出来的会是全部
    				supportCategory=null;
    			}else{
    				
    				supportCategory = generalprocessMainService.querySupportCategory(seachName);

    				
    			}
    			
    			
    			List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil.returnAllObj(map);
    			
    			
    		//将换行符\r\n 替换成 <br> ，因为\r\n在json字符串转成json格式会报错，无法转换
    			for(int i = 0;  i<beans.size();  i++){
    				
    				List<GeneralprocessFieldBean> list = beans.get(i);
    				
    				for(int j = 0;  j<list.size();  j++){
    					
    					String name = list.get(j).getName();
    					if("超限说明".equals(name) || "处理意见".equals(name)){
    						
    						String val = (String) list.get(j).getValue();
    						if(val != null && val.indexOf("\r\n") != -1){
    							val = val.replace("\r\n", "<br>");
    							list.get(j).setValue(val);
    						}
    						
    					}
    				}
    			}
    			
    			
    			
    			String fxJson = JSONArray.fromObject(beans).toString();
    			taskAssgineeDto.setFxJson(fxJson);
    			
    			queryDefault(); 
    	return "modelSix_input";
    }
    
	public void queryDefault() {
		try {
			defaultOps = tDefaultOpinionService.queryDefaultOpsForshow(this
					.getCurrentOnlineUser().getEmpid());
		} catch (Exception e) {
			log.error("[获取默认意见失败]", e);
			e.printStackTrace();
		}
	}
    
    
      public  void  handleModelSix() throws Exception{

  		String info ="success";
      	MUOUserSession muo = getCurrentOnlineUser();
  		try {
  		    //若利率浮动比例有值，给它加%
			if(modelSix != null &&  !"".equals(modelSix.getRate_float_scale())  ){
				modelSix.setRate_float_scale( modelSix.getRate_float_scale()+"%" );
			}
			
  			this.tGeneralprocessModelsixService.handleModelSix(muo,modelSix,taskAssgineeDto,files,filesFileName,"test1","test2");
  			this.updateProcessMistakes();
  		} catch (Exception e) {
  			info="fails";
  			log.error("[提交模式六表单失败！]", e);
  			throw e;
  		}
  		Struts2Utils.renderText(info);

      }
    
    
    
    
    
    
    
    
    
    
	
	
	

    /**
     * 通过spring注入Service的set类.
     * @abatorgenerated
     */
    public void settGeneralprocessModelsixService(ITGeneralprocessModelsixService tGeneralprocessModelsixService) {
        this.tGeneralprocessModelsixService = tGeneralprocessModelsixService;
    }

    public String getIsView() {
		return isView;
	}




	public void setIsView(String isView) {
		this.isView = isView;
	}




	/**
     * 通过spring注入Service的get类.
     * @abatorgenerated
     */
    public ITGeneralprocessModelsixService gettGeneralprocessModelsixService() {
        return this.tGeneralprocessModelsixService;
    }

	public ProcessModelSix getModelSix() {
		return modelSix;
	}

	public void setModelSix(ProcessModelSix modelSix) {
		this.modelSix = modelSix;
	}

	
	
	public ProcessModelOne getModelOne() {
		return modelOne;
	}

	public void setModelOne(ProcessModelOne modelOne) {
		this.modelOne = modelOne;
	}

	public TaskAssgineeDto getTaskAssgineeDto() {
		return taskAssgineeDto;
	}

	public void setTaskAssgineeDto(TaskAssgineeDto taskAssgineeDto) {
		this.taskAssgineeDto = taskAssgineeDto;
	}

	public ITGeneralprocessMainService getGeneralprocessMainService() {
		return generalprocessMainService;
	}

	public void setGeneralprocessMainService(
			ITGeneralprocessMainService generalprocessMainService) {
		this.generalprocessMainService = generalprocessMainService;
	}

	public JbpmService getJbpmService() {
		return jbpmService;
	}

	public void setJbpmService(JbpmService jbpmService) {
		this.jbpmService = jbpmService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public List<TDefaultOpinion> getDefaultOps() {
		return defaultOps;
	}


	public void setDefaultOps(List<TDefaultOpinion> defaultOps) {
		this.defaultOps = defaultOps;
	}


	public ITDefaultOpinionService gettDefaultOpinionService() {
		return tDefaultOpinionService;
	}


	public void settDefaultOpinionService(
			ITDefaultOpinionService tDefaultOpinionService) {
		this.tDefaultOpinionService = tDefaultOpinionService;
	}


	public ITGeneralprocessModeloneService getGeneralprocessModeloneService() {
		return generalprocessModeloneService;
	}


	public void setGeneralprocessModeloneService(
			ITGeneralprocessModeloneService generalprocessModeloneService) {
		this.generalprocessModeloneService = generalprocessModeloneService;
	}


	public String getIsStrat() {
		return isStrat;
	}


	public void setIsStrat(String isStrat) {
		this.isStrat = isStrat;
	}

    
    
    //文件操作
	private File[] files;
	private String[] filesFileName;
	private String modeId;
    private String executionId; 
	private  String modeType;
    private String fileId;


	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String[] getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

	public String getModeId() {
		return modeId;
	}

	public void setModeId(String modeId) {
		this.modeId = modeId;
	}

	public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public String getModeType() {
		return modeType;
	}

	public void setModeType(String modeType) {
		this.modeType = modeType;
	}
    
	
	
	/**
	 * 查询提交人
	 */
	public String querySubmitter(){
		if (processSubmitter!=null&&!"".equals(processSubmitter)) {
			if (processSubmitter.getFlowId()!=null&&!"".equals(processSubmitter.getFlowId())) {
				processSubmitter=generalprocessMistakeService.querySubmitter(processSubmitter);
				
			}
		}
		MUOUserSession user = this.getCurrentOnlineUser();
		processSubmitter.setCurrenUser(user.getEmpname());
		this.setProcessSubmitter(processSubmitter);
		return "processSubmitter";
	}
	/**
	 * 查询差错相关
	 */
 public String queryProcessMistake(){
	List<ProcessMistake> processMistakeList= generalprocessMistakeService.queryProcessMistake(processMistake);
	this.setProcessMistakeList(processMistakeList);
   return "processMistakeList";
 }
	/**
	 * 更新整改情况
	 * @throws Exception 
	 */
	
	public void updateProcessMistake() throws Exception {
		processMistakeList.add(processMistake);
		String info = "success";
		try {
			this.generalprocessMistakeService.updateProcessMistake(processMistakeList);
		} catch (Exception e) {
			info = "fails";
			log.error("[保存错误失败！]", e);
			throw e;
		}
		Struts2Utils.renderText(info);
	}  
    
	/**
	 * 提交时批量更新整改情况
	 * @throws Exception 
	 */
	
	public void updateProcessMistakes() throws Exception {
		if (mistakeId!=null&&mistakeId.length!=0&&rectification!=null&&!"".equals(rectification)) {
			
			for (int i = 0; i < mistakeId.length; i++) {
				processMistake=new ProcessMistake();
			    processMistake.setMistakeId(mistakeId[i]);
				processMistake.setRectification(rectification[i]);
				processMistakeList.add(processMistake);
				
			}
		}
		
	
			this.generalprocessMistakeService.updateProcessMistake(processMistakeList);
		
	}
}