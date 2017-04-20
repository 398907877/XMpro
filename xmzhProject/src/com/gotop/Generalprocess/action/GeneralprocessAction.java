package com.gotop.Generalprocess.action;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.gotop.Generalprocess.annonation.GeneralprocessFieldBean;
import com.gotop.Generalprocess.model.GeneralprocessDto;
import com.gotop.Generalprocess.model.ProcessMistake;
import com.gotop.Generalprocess.model.ProcessModelOne;
import com.gotop.Generalprocess.model.ProcessModelTwo;
import com.gotop.Generalprocess.model.TGeneralprocessMain;
import com.gotop.Generalprocess.service.IGeneralprocessMistakeService;
import com.gotop.Generalprocess.service.IGeneralprocessService;
import com.gotop.Generalprocess.service.ITGeneralprocessMainService;
import com.gotop.Generalprocess.service.ITGeneralprocessModeloneService;
import com.gotop.Generalprocess.service.ITGeneralprocessModeltwoService;
import com.gotop.Generalprocess.util.GeneralprocessUtil;
import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.dto.TaskAssgineeDto;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.opinion.model.TDefaultOpinion;
import com.gotop.opinion.service.ITDefaultOpinionService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;
import com.gotop.vo.tyjg.Omorganization;

/****
 * 
 * @author yyx
 *
 */
public class GeneralprocessAction extends BaseAction {
	
	
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


	
	
	private String yxry;
	public String getYxry() {
		return yxry;
	}

	public void setYxry(String yxry) {
		this.yxry = yxry;
	}








	private ProcessMistake processMistake;
	private List<ProcessMistake> processMistakeList = new ArrayList<ProcessMistake>();
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
	public ProcessMistake getProcessMistake() {
		return processMistake;
	}

	public void setProcessMistake(ProcessMistake processMistake) {
		this.processMistake = processMistake;
	}

	public List<ProcessMistake> getProcessMistakeList() {
		return processMistakeList;
	}

	public void setProcessMistakeList(List<ProcessMistake> processMistakeList) {
		this.processMistakeList = processMistakeList;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orgcode;
	
	/**
	 * 
	 * @author wsd
	 * @desc 模式一页面对象
	 * 
	 */
	private ProcessModelOne modelOne;

	/**
	 * @author wsd
	 * @desc 模式二页面对象
	 * 
	 */
	private ProcessModelTwo modelTwo;

	/**
	 * 
	 * @author wsd
	 * @desc 默认意见
	 * 
	 */
	private List<TDefaultOpinion> defaultOps;
	
	/**
	 * 
	 * @author wsd
	 * @desc 与流程相关的对象
	 * 
	 */
	private TaskAssgineeDto taskAssgineeDto;
	
	private GeneralprocessDto generalprocessDto;
	private String taskName;
	
	/**
	 * 
	 * @author yyx
	 * 信贷通用流程列表
	 */
	List<GeneralprocessDto> generalprocessDtos;
	
	/**
	 * isView :1、为只读状态， 默认为空
	 */
	private String isView;
	
	
	/**
	 * isView :1为导出， 默认为空
	 */
	private String isExport;
	
	

	public String getTaskName() {
		return taskName;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * 
	 * @author wsd
	 * @desc 默认意见服务
	 * 
	 */
	private ITDefaultOpinionService tDefaultOpinionService;

	private IGeneralprocessService generalProcessService;

	/**
	 * 模式一服务
	 */
	private ITGeneralprocessModeloneService generalprocessModeloneService;

	/**
	 * 模式二服务
	 */
	private ITGeneralprocessModeltwoService generalprocessModeltwoService;

	/**
	 * 模式主表服务
	 */
	private ITGeneralprocessMainService generalprocessMainService;

	/**
	 * jbpm服务
	 */
	private JbpmService jbpmService;

	public ITGeneralprocessModeltwoService getGeneralprocessModeltwoService() {
		return generalprocessModeltwoService;
	}

	public void setGeneralprocessModeltwoService(
			ITGeneralprocessModeltwoService generalprocessModeltwoService) {
		this.generalprocessModeltwoService = generalprocessModeltwoService;
	}

	public JbpmService getJbpmService() {
		return jbpmService;
	}

	public void setJbpmService(JbpmService jbpmService) {
		this.jbpmService = jbpmService;
	}

	public ProcessModelTwo getModelTwo() {
		return modelTwo;
	}

	public void setModelTwo(ProcessModelTwo modelTwo) {
		this.modelTwo = modelTwo;
	}

	public ITGeneralprocessModeloneService getGeneralprocessModeloneService() {
		return generalprocessModeloneService;
	}

	public void setGeneralprocessModeloneService(
			ITGeneralprocessModeloneService generalprocessModeloneService) {
		this.generalprocessModeloneService = generalprocessModeloneService;
	}

	public ITGeneralprocessMainService getGeneralprocessMainService() {
		return generalprocessMainService;
	}

	public void setGeneralprocessMainService(
			ITGeneralprocessMainService generalprocessMainService) {
		this.generalprocessMainService = generalprocessMainService;
	}

	public String getIsView() {
		return isView;
	}

	public void setIsView(String isView) {
		this.isView = isView;
	}

	public String getIsExport() {
		return isExport;
	}

	public void setIsExport(String isExport) {
		this.isExport = isExport;
	}

	public IGeneralprocessService getGeneralProcessService() {
		return generalProcessService;
	}

	public void setGeneralProcessService(
			IGeneralprocessService generalProcessService) {
		this.generalProcessService = generalProcessService;
	}

	public TaskAssgineeDto getTaskAssgineeDto() {
		return taskAssgineeDto;
	}

	public void setTaskAssgineeDto(TaskAssgineeDto taskAssgineeDto) {
		this.taskAssgineeDto = taskAssgineeDto;
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

	public ProcessModelOne getModelOne() {
		return modelOne;
	}

	public void setModelOne(ProcessModelOne modelOne) {
		this.modelOne = modelOne;
	}

	public GeneralprocessDto getGeneralprocessDto() {
		return generalprocessDto;
	}

	public void setGeneralprocessDto(GeneralprocessDto generalprocessDto) {
		this.generalprocessDto = generalprocessDto;
	}

	public List<GeneralprocessDto> getGeneralprocessDtos() {
		return generalprocessDtos;
	}

	public void setGeneralprocessDtos(List<GeneralprocessDto> generalprocessDtos) {
		this.generalprocessDtos = generalprocessDtos;
	}

	/**
	 * 
	 * @author wsd
	 * @desc 查询当前登录者的默认意见信息
	 * 
	 */
	public void queryDefault() {
		try {
			defaultOps = tDefaultOpinionService.queryDefaultOpsForshow(this
					.getCurrentOnlineUser().getEmpid());
		} catch (Exception e) {
			log.error("[获取默认意见失败]", e);
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @author wsd
	 * @desc 跳转到模式一的表单页面
	 * @return
	 * 
	 */
	public String toModelOne() {
		try {
			/*
			 * String flowId=""; String processModelId="";
			 * if(taskAssgineeDto!=null
			 * &&taskAssgineeDto.getBusinessKey()!=null&&
			 * !"".equals(taskAssgineeDto.getBusinessKey()))
			 * processModelId=String.valueOf(taskAssgineeDto.getBusinessKey());
			 * if
			 * (taskAssgineeDto!=null&&taskAssgineeDto.getExecutionId()!=null&&
			 * !"".equals(taskAssgineeDto.getExecutionId()))
			 * flowId=taskAssgineeDto.getExecutionId();
			 * modelOne=this.generalprocessModeloneService
			 * .queryModelOne(processModelId,flowId);
			 */
			// 获取流程实例id
			String businessId = taskAssgineeDto.getExecutionId();
			taskName = taskAssgineeDto.getTaskName();

			System.out.println("+++++++++++" + taskName);

			// 获取流程配置主表对象
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
			String taskName1 = null;
			if (taskAssgineeDto.getNextTaskId() != null) {
				// 待办-办理
				taskName1 = jbpmService.getTaskNameById(taskAssgineeDto
						.getNextTaskId());
			} else {
				if (taskAssgineeDto.getActivityName() != null) {
					// 已办-查看详情
					taskName1 = taskAssgineeDto.getActivityName();
					taskName = taskName1;
				}
			}
			ProcessModelOne newModelOne = new ProcessModelOne();
			if (businessId != null && taskName1 != null) {
				ProcessModelOne modelOne = new ProcessModelOne();
				modelOne.setFlow_Id(businessId);
				modelOne.setTaskName(taskName1);

				newModelOne = this.generalprocessModeloneService
						.queryModelOne(modelOne);
				
				if(newModelOne != null && newModelOne.getRate_float_scale() != null){
					newModelOne.setRate_float_scale( (newModelOne.getRate_float_scale()).replace("%","") );
				}
			}

			String[] rulesArray = null;
			String[] idsArray = null;
			if (main != null) {
				if (main.getRules() != null && !"".equals(main.getRules())) {
					String rules = main.getRules();
					rulesArray = rules.split(",");
				}

				if (main.getIds() != null && !"".equals(main.getIds())) {
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
			if (newModelOne != null) {
				rm = "ProcessModelOne" + "-" + newModelOne.getProcessModelId();
				map.remove(rm);
			}

			this.setModelOne(newModelOne);

			List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil
					.returnAllObj(map);
			
			
			
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

		} catch (Exception e) {
			log.error("查询模式一表单信息失败", e);
		}
		queryDefault(); 
		return "toModelOne";
	}

	/**
	 * 
	 * @author wsd
	 * @desc 跳转到模式二的表单页面
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public String toModelTwo() throws ClassNotFoundException,
			IllegalArgumentException, SecurityException,
			IllegalAccessException, NoSuchFieldException,
			NoSuchMethodException, InvocationTargetException,
			InstantiationException {
		// 获取流程实例id
		String businessId = taskAssgineeDto.getExecutionId();

		taskName = taskAssgineeDto.getTaskName();

		// 获取流程配置主表对象
		TGeneralprocessMain main = this.generalprocessMainService
				.queryMainByBusinessId(businessId);
		
		if(main != null){
			if(main.getBeginEmpId() != null && main.getBeginOrgId() != null){
				taskAssgineeDto.setBeginAssingee(main.getBeginEmpId());
				taskAssgineeDto.setBeginOrg(main.getBeginOrgId());
			}
		}
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		String taskName1 = null;
		if (taskAssgineeDto.getNextTaskId() != null) {
			// 待办-办理
			taskName1 = jbpmService.getTaskNameById(taskAssgineeDto
					.getNextTaskId());
		} else {
			if (taskAssgineeDto.getActivityName() != null) {
				// 已办-查看详情
				taskName1 = taskAssgineeDto.getActivityName();
				taskName = taskName1;
			}
		}

		ProcessModelTwo newModelTwo = new ProcessModelTwo();
		if (businessId != null && taskName1 != null) {
			ProcessModelTwo modelTwo = new ProcessModelTwo();
			modelTwo.setFlow_id(businessId);
			modelTwo.setTaskName(taskName1);
			newModelTwo = this.generalprocessModeltwoService
					.queryModelTwo(modelTwo);
		}

		String[] rulesArray = null;
		String[] idsArray = null;
		if (main != null) {
			if (main.getRules() != null && !"".equals(main.getRules())) {
				String rules = main.getRules();
				rulesArray = rules.split(",");
			}

			if (main.getIds() != null && !"".equals(main.getIds())) {
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
		if (newModelTwo != null) {
			rm = "ProcessModelTwo" + "-" + newModelTwo.getProcessModelId();
			map.remove(rm);
		}

		this.setModelTwo(newModelTwo);

		List<List<GeneralprocessFieldBean>> beans = GeneralprocessUtil
				.returnAllObj(map);

		
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
		return "toModelTwo";
	}

	/**
	 * 
	 * @author wsd
	 * @desc 后台处理模式一的新增模式一表单、结束流程、记录流程日志
	 * @return
	 * @throws Exception
	 * 
	 */
	public void handleModelOne() throws Exception {
		String info = "success";
		MUOUserSession muo = getCurrentOnlineUser();
		modeType="mod1";
		try {
			
			//若利率浮动比例有值，给它加%
			if(modelOne != null &&  !"".equals(modelOne.getRate_float_scale())  ){
				modelOne.setRate_float_scale( modelOne.getRate_float_scale()+"%" );
			}
			
			this.generalProcessService.handleModelOne(muo, modelOne, taskAssgineeDto, files, filesFileName);
			this.updateProcessMistakes();
		} catch (Exception e) {
			info = "fails";
			log.error("[提交模式一表单失败！]", e);
			throw e;
		}
		Struts2Utils.renderText(info);
	}

	/**
	 * 
	 * @author wsd
	 * @desc 后台处理模式二表单、结束节点、记录流程日志
	 * @return
	 * @throws Exception
	 * 
	 */
	public void handleModelTwo() throws Exception {
		String info = "success";
		String nextTaskId = this.taskAssgineeDto.getNextTaskId();
		if ("".equals(nextTaskId) || nextTaskId == null) {
			info = "noFirst";
		} else {
			MUOUserSession muo = getCurrentOnlineUser();
			try {
				this.generalProcessService.handleModelTwo(muo, modelTwo, taskAssgineeDto, files, filesFileName);
				this.updateProcessMistakes();
			} catch (Exception e) {
				info = "fails";
				log.error("[提交模式二表单失败！]", e);
				throw e;
			}
		}
		Struts2Utils.renderText(info);
	}
	
	/**
	 * 判断当前登录者的上上级机构是否为空
	 * 为空，则当前登录者的所属机构为二级机构，上级为厦门分行
	 * 不为空，则当前登录者的所属机构为区级机构，上级机构为区分行
	 * @return
	 */
	public void isHaveParentOrgId(){
		String info = "success";
		String parentOrgId = null;
		Omorganization om = null;
		parentOrgId = this.generalProcessService.isHaveParentOrgId(orgcode);
		if(parentOrgId != null){
			om = this.generalProcessService.getParentOrgId(orgcode);
			info = om.getOrgid()+"," + om.getOrgCode()+","+om.getOrgName();
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

    /**
     * @author yyx
     * @return 
     * @throws Exception
     * @creattime 2015-12-17下午5:29:45
     */
    public String queryGeneralprocessList() throws Exception{
    	
    	MUOUserSession muo = getCurrentOnlineUser();
    	if("1".equals(this.getIsExport())){
    		try {
    			List<GeneralprocessDto> generalprocessDtos=this.generalProcessService.queryGeneralprocessList(muo,generalprocessDto,null);
        		this.setGeneralprocessDtos(generalprocessDtos);
        		return "generalprocess_export";
			} catch (Exception e) {
				return e.toString();
			}
    		
    	}else{
    		try {
    			List<GeneralprocessDto> generalprocessDtos=this.generalProcessService.queryGeneralprocessList(muo,generalprocessDto,this.getPage());
        		this.setGeneralprocessDtos(generalprocessDtos);
        		return "generalprocess_list";
			} catch (Exception e) {
				return e.toString();
			}
    		
    	}
    }
    
    /**
     * @author lmt
     * @return 
     * @throws Exception
     * @creattime 2016-06-01上午00:34:45
     */
    public String queryGeneralprocessList2() throws Exception{
    	
    	MUOUserSession muo = getCurrentOnlineUser();
    	if("1".equals(this.getIsExport())){
    		try {
    			List<GeneralprocessDto> generalprocessDtos=this.generalProcessService.queryGeneralprocessList2(muo,generalprocessDto,null);
        		this.setGeneralprocessDtos(generalprocessDtos);
        		return "generalprocess_export2";
			} catch (Exception e) {
				return e.toString();
			}
    		
    	}else{
    		try {
    			List<GeneralprocessDto> generalprocessDtos=this.generalProcessService.queryGeneralprocessList2(muo,generalprocessDto,this.getPage());
        		this.setGeneralprocessDtos(generalprocessDtos);
        		return "generalprocess_list2";
			} catch (Exception e) {
				return e.toString();
			}
    		
    	}
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
 * 查询营销人员机构	
 * @return
 */
	
	
	private    	List< ?>  orgnameList;
	
	
	
public List<?> getOrgnameList() {
	return orgnameList;
}

public void setOrgnameList(List<?> orgnameList) {
	this.orgnameList = orgnameList;
}

public String queryyxryjg(){
	if (yxry!=null&!"".equals(yxry)) {
		
		orgnameList=this.generalProcessService.queryyxryjg(yxry);
		
		
		
		
	}
	return"yxryjgs";
	}
	
	
}
