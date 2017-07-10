package com.gotop.jbpm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.api.RepositoryService;
import org.jbpm.pvm.internal.model.ActivityImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;

import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.model.NodeTimeLimitBean;
import com.gotop.jbpm.model.OneAndLoanBean;
import com.gotop.jbpm.model.ProLoanBean;
import com.gotop.jbpm.model.ProTimeModelBean;
import com.gotop.jbpm.model.TimeBean;
import com.gotop.jbpm.model.WorkTimeMainBean;
import com.gotop.jbpm.model.WorkTimeSideBean;
import com.gotop.jbpm.model.XdProcessBean;
import com.gotop.jbpm.service.ITimeLimitManageService;
import com.gotop.jbpm.service.IXdProcessService;
import com.gotop.jbpm.service.JbpmService;
import com.gotop.util.Struts2Utils;

public class TimeLimitManageAction extends BaseAction {

	private OneAndLoanBean oneAndLoanBean;
	
	private List<OneAndLoanBean> oneAndLoanBeans;
	
	private ProLoanBean proLoanBean;
	
	private ProLoanBean my_proLoanBean;
	
	private List<ProLoanBean> proLoanBeans;
	
	private NodeTimeLimitBean nodeTimeLimitBean;
	
	private List<NodeTimeLimitBean> nodeTimeLimitBeans;
	
	private ProTimeModelBean proTimeModelBean;
	
	private List<ProTimeModelBean> proTimeModelBeans;
	
	private String ids;
	
	private XdProcessBean xdProcessBean;
	
	private List<XdProcessBean> xdProcessBeans ;
	
	private Map<String, String> time;
	
	private WorkTimeMainBean workTimeMainBean;
	
	private List<WorkTimeMainBean> workTimeMainBeans;
	
	private WorkTimeSideBean workTimeSideBean;
	
	private List<WorkTimeSideBean> workTimeSideBeans;
	
	protected ITimeLimitManageService timeLimitManageService;
	
	private TimeBean timeBean;
	
	protected IXdProcessService xdProcessService;

	private JbpmService jbpmService;
	
	
	public WorkTimeSideBean getWorkTimeSideBean() {
		return workTimeSideBean;
	}

	public void setWorkTimeSideBean(WorkTimeSideBean workTimeSideBean) {
		this.workTimeSideBean = workTimeSideBean;
	}

	public List<WorkTimeSideBean> getWorkTimeSideBeans() {
		return workTimeSideBeans;
	}

	public void setWorkTimeSideBeans(List<WorkTimeSideBean> workTimeSideBeans) {
		this.workTimeSideBeans = workTimeSideBeans;
	}

	public TimeBean getTimeBean() {
		return timeBean;
	}

	public void setTimeBean(TimeBean timeBean) {
		this.timeBean = timeBean;
	}

	public Map<String, String> getTime() {
		return time;
	}

	public void setTime(Map<String, String> time) {
		this.time = time;
	}


	public WorkTimeMainBean getWorkTimeMainBean() {
		return workTimeMainBean;
	}

	public void setWorkTimeMainBean(WorkTimeMainBean workTimeMainBean) {
		this.workTimeMainBean = workTimeMainBean;
	}

	public List<WorkTimeMainBean> getWorkTimeMainBeans() {
		return workTimeMainBeans;
	}

	public void setWorkTimeMainBeans(List<WorkTimeMainBean> workTimeMainBeans) {
		this.workTimeMainBeans = workTimeMainBeans;
	}

	public ProLoanBean getMy_proLoanBean() {
		return my_proLoanBean;
	}

	public void setMy_proLoanBean(ProLoanBean my_proLoanBean) {
		this.my_proLoanBean = my_proLoanBean;
	}

	public ProTimeModelBean getProTimeModelBean() {
		return proTimeModelBean;
	}

	public void setProTimeModelBean(ProTimeModelBean proTimeModelBean) {
		this.proTimeModelBean = proTimeModelBean;
	}

	public List<ProTimeModelBean> getProTimeModelBeans() {
		return proTimeModelBeans;
	}

	public void setProTimeModelBeans(List<ProTimeModelBean> proTimeModelBeans) {
		this.proTimeModelBeans = proTimeModelBeans;
	}

	public NodeTimeLimitBean getNodeTimeLimitBean() {
		return nodeTimeLimitBean;
	}

	public void setNodeTimeLimitBean(NodeTimeLimitBean nodeTimeLimitBean) {
		this.nodeTimeLimitBean = nodeTimeLimitBean;
	}

	public List<NodeTimeLimitBean> getNodeTimeLimitBeans() {
		return nodeTimeLimitBeans;
	}

	public void setNodeTimeLimitBeans(List<NodeTimeLimitBean> nodeTimeLimitBeans) {
		this.nodeTimeLimitBeans = nodeTimeLimitBeans;
	}

	public JbpmService getJbpmService() {
		return jbpmService;
	}

	public void setJbpmService(JbpmService jbpmService) {
		this.jbpmService = jbpmService;
	}

	public List<ProLoanBean> getProLoanBeans() {
		return proLoanBeans;
	}

	public void setProLoanBeans(List<ProLoanBean> proLoanBeans) {
		this.proLoanBeans = proLoanBeans;
	}

	public ProLoanBean getProLoanBean() {
		return proLoanBean;
	}

	public void setProLoanBean(ProLoanBean proLoanBean) {
		this.proLoanBean = proLoanBean;
	}

	public XdProcessBean getXdProcessBean() {
		return xdProcessBean;
	}

	public void setXdProcessBean(XdProcessBean xdProcessBean) {
		this.xdProcessBean = xdProcessBean;
	}

	public List<XdProcessBean> getXdProcessBeans() {
		return xdProcessBeans;
	}

	public void setXdProcessBeans(List<XdProcessBean> xdProcessBeans) {
		this.xdProcessBeans = xdProcessBeans;
	}

	public IXdProcessService getXdProcessService() {
		return xdProcessService;
	}

	public void setXdProcessService(IXdProcessService xdProcessService) {
		this.xdProcessService = xdProcessService;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public OneAndLoanBean getOneAndLoanBean() {
		return oneAndLoanBean;
	}

	public void setOneAndLoanBean(OneAndLoanBean oneAndLoanBean) {
		this.oneAndLoanBean = oneAndLoanBean;
	}

	public List<OneAndLoanBean> getOneAndLoanBeans() {
		return oneAndLoanBeans;
	}

	public void setOneAndLoanBeans(List<OneAndLoanBean> oneAndLoanBeans) {
		this.oneAndLoanBeans = oneAndLoanBeans;
	}

	public ITimeLimitManageService getTimeLimitManageService() {
		return timeLimitManageService;
	}

	public void setTimeLimitManageService(
			ITimeLimitManageService timeLimitManageService) {
		this.timeLimitManageService = timeLimitManageService;
	}

	/**
	 * 查询 所有 一级分类与贷种分类的对应关系
	 * @return
	 */
	public String queryOneAndLoanList(){
		oneAndLoanBeans = this.timeLimitManageService.queryOneAndLoanList(oneAndLoanBean,this.getPage());
		this.setOneAndLoanBeans(oneAndLoanBeans);
		return "oneAndLoanCategory_list";
	}
	
	/**
	 * 跳转到 新增 一级分类与贷种分类的对应关系 页面
	 * @return
	 */
	public String toAddOneAndLoan(){
		return "add_oneAndLoanCategory";
	}
	
	/**
	 * 检验 一级分类与贷种分类的对应关系是否已存在
	 */
	public void checkOneAndLoan(){
		String info ="";
		String err_info="";
		
		String loanCategory_str = oneAndLoanBean.getLoanCategory_name();
		String[] valueArra = loanCategory_str.split(", ");
		for(int i=0; i<valueArra.length; i++){
			oneAndLoanBean.setLoanCategory_name(valueArra[i]);
			oneAndLoanBeans = this.timeLimitManageService.checkOneAndLoan(oneAndLoanBean);
			if(oneAndLoanBeans.size() >0){
				if("".equals(err_info)){
					err_info = err_info+oneAndLoanBean.getLoanCategory_name();
				}else{
					err_info = err_info+","+oneAndLoanBean.getLoanCategory_name();
				}
			}
		}
		if("".equals(err_info)){
			info ="success";
			Struts2Utils.renderText(info);
		}else{
			info="fails";
			Struts2Utils.renderText(err_info);
		}
	}
	
	/**
	 * 添加 一级分类与贷种分类的对应关系
	 * @throws Exception 
	 */
	public void addOneAndLoan() throws Exception{
		String info ="success";
    	try {
    		String loanCategory_str = oneAndLoanBean.getLoanCategory_name();
    		String[] valueArra = loanCategory_str.split(", ");
    		
    		String loanCategoryId_str = oneAndLoanBean.getLoanCategory_id();
    		String[] valueArra2 = loanCategoryId_str.split(", ");
    		
			for(int i=0; i<valueArra.length; i++){
				oneAndLoanBean.setLoanCategory_name(valueArra[i]);
				oneAndLoanBean.setLoanCategory_id(valueArra2[i]);
				this.timeLimitManageService.addOneAndLoan(oneAndLoanBean);
			}
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	/**
	 * 删除 一级分类与贷种分类的对应关系
	 * @throws Exception 
	 */
	public void delOneAndLoan() throws Exception{
		String info ="success";
    	try {
    		String[] valueArra = ids.split(",");
			for(int i=0; i<valueArra.length; i++){
				if(oneAndLoanBean == null){
					oneAndLoanBean = new OneAndLoanBean();
				}
				oneAndLoanBean.setD_id(Long.valueOf(valueArra[i]) );
				this.timeLimitManageService.delOneAndLoan(oneAndLoanBean);
			}
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
	}
	
	/**
	 * 查询信贷流程列表 流程时限配置
	 */
	public String queryXdProcessList(){
		List<XdProcessBean> xdProcessBeans = this.xdProcessService.queryXdProcessList(xdProcessBean,this.getPage());
		this.setXdProcessBeans(xdProcessBeans);
		
		return "xdProcess_list";
	}
	
	/**
	 * 跳转到 选择模版 页面
	 */
	public String querySelectModel(){
		proTimeModelBeans =  this.timeLimitManageService.querySelectModel(proLoanBean);
			this.setProTimeModelBeans(proTimeModelBeans);
			return "selectModel";  //跳转到 选择模版 页面
	}
	
	public String addLoanTimeModel(){
		
		return "add_loanTimeModel";
	}
	
	/**
	 * 检验 同一流程 的 时限模版名称 是否已存在
	 */
	public void checkTimeModelName(){
		
		String info ="";
		proTimeModelBeans = this.timeLimitManageService.checkTimeModelName(proTimeModelBean);
		if(proTimeModelBeans.size() >0){
			info ="exist";	
		}else{
			info="notExist";
		}
		Struts2Utils.renderText(info);
		
	}
	
	public void saveModelName() throws Exception{
		
		String info ="success";
    	try {
    		this.timeLimitManageService.insertProTimeLimitModel(proTimeModelBean);
				
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
	}
	
	/**
	 * 跳转到 时限管理配置 页面
	 */
	public String toTimeLimitManage(){
		System.out.println(proLoanBean);
		return "timeLimitManage";
	}
	
	
	/**
	 * 查询已关联维护的一级分类列表，配置流程时限 功能时用，将查到的结果返回为json类型
	 * @return
	 */
	public String queryOneCategorylist(){
		proLoanBeans = this.timeLimitManageService.queryOneCategorylist();
		this.setProLoanBeans(proLoanBeans);
		return "oneCategorylist";
	}
	/**
	 * 查询相关流程下已关联维护的一级分类列表，配置流程时限 功能时用，将查到的结果返回为json类型
	 * @return
	 */
	public String queryOneCategorylist1(){
		proLoanBeans = this.timeLimitManageService.queryOneCategorylist1(proLoanBean);
		this.setProLoanBeans(proLoanBeans);
		return "oneCategorylist";
	}
	
	/**
	 * 查询已关联维护的贷种分类列表，配置流程时限 功能时用，将查到的结果返回为json类型
	 * @return
	 */
	public String queryLoanCategorylist(){
		proLoanBeans = this.timeLimitManageService.queryLoanCategorylist(proLoanBean);
		this.setProLoanBeans(proLoanBeans);
		return "loanCategorylist";
	}
	
	/**
	 * 查询相关流程下已关联维护的贷种分类列表，配置流程时限 功能时用，将查到的结果返回为json类型
	 * @return
	 */
	public String queryLoanCategorylist1(){
		proLoanBeans = this.timeLimitManageService.queryLoanCategorylist1(proLoanBean);
		this.setProLoanBeans(proLoanBeans);
		return "loanCategorylist";
	}
	
	public void saveTimeLimitManage() throws Exception{
		String info ="";
    	try {
    		
    		if(proLoanBean != null){
    			
    			String[] my_valueArra1 = my_proLoanBean.getOneCategory_name().split(",");
    			String[] my_valueArra2 = my_proLoanBean.getLoanCategory_name().split(",");
    			String[] init_valueArra1 = proLoanBean.getInit_oneCategory_name().split(",");
    			String[] init_valueArra2 = proLoanBean.getInit_loanCategory_name().split(",");
    			
    			String[] valueArra1 = proLoanBean.getOneCategory_name().split(",");
    			String[] valueArra2 = proLoanBean.getLoanCategory_name().split(",");
    			
				int flag1 = 0;
				int flag2 = 0;
				
    			//修改 一级 贷种分类 设置
				List<OneAndLoanBean> my_oneAndLoanBeans = new ArrayList<OneAndLoanBean>();
				ProLoanBean my_proLoanBean2 = new ProLoanBean();
				ProLoanBean my_proLoanBean3 = new ProLoanBean();
					for(int i=0; i<my_valueArra1.length; i++){
						 if(!"".equals(my_valueArra1[i])  && !"".equals(my_valueArra2[i])  ){
							 
							//校验 修改 一级/贷种 分类 是否存在
							my_proLoanBean3.setDefinitionId(proLoanBean.getDefinitionId());
							my_oneAndLoanBeans =  this.timeLimitManageService.queryProLoanTimeLimit(my_proLoanBean3);
							int a = 0;
							for (OneAndLoanBean oneAndLoanBean : my_oneAndLoanBeans) {
								if(oneAndLoanBean.getOneCategory_name().equals(my_valueArra1[i]) && oneAndLoanBean.getLoanCategory_name().equals(my_valueArra2[i]) ){
									info += "修改：一级分类（"+my_valueArra1[i]+"），贷种分类（"+my_valueArra2[i]+"）已存在！\n";
									flag1 = 1;
									a=1;
								}
							}
							
							if(a != 1){
								my_proLoanBean2.setDefinitionId(proLoanBean.getDefinitionId());
								my_proLoanBean2.setC_id(proLoanBean.getC_id());
								my_proLoanBean2.setInit_oneCategory_name(init_valueArra1[i] );
								my_proLoanBean2.setInit_loanCategory_name(init_valueArra2[i] );
								my_proLoanBean2.setOneCategory_name(my_valueArra1[i] );
								my_proLoanBean2.setLoanCategory_name(my_valueArra2[i] );
								my_proLoanBean2.setOp_empid(this.getCurrentOnlineUser().getEmpid());
								my_proLoanBean2.setOp_orgcode(this.getCurrentOnlineUser().getOrgcode());
								
								this.timeLimitManageService.updateProLoanTimeLimit(my_proLoanBean2); //修改（B表） t_model_proLoanTimeLimit 流程贷种时限关表
							}
						 }
					}
					
					//新增 一级 贷种分类 设置
					List<OneAndLoanBean> oneAndLoanBeans = new ArrayList<OneAndLoanBean>();
					ProLoanBean proLoanBean2 = new ProLoanBean();
					ProLoanBean proLoanBean3 = new ProLoanBean();
					 for(int i=0; i<valueArra1.length; i++){
						 if(!"".equals(valueArra1[i])  && !"".equals(valueArra2[i])  ){
							 int a = 0;
							//校验 新增 一级/贷种 分类 是否存在
							 proLoanBean3.setDefinitionId(proLoanBean.getDefinitionId());
							 oneAndLoanBeans =  this.timeLimitManageService.queryProLoanTimeLimit(proLoanBean3);
							for (OneAndLoanBean oneAndLoanBean : oneAndLoanBeans) {
								if(oneAndLoanBean.getOneCategory_name().equals(valueArra1[i]) && oneAndLoanBean.getLoanCategory_name().equals(valueArra2[i]) ){
									info += "新增：一级分类（"+valueArra1[i]+"），贷种分类（"+valueArra2[i]+"）已存在！\n";
									flag2 = 1;
									a=1;
								}
							}
							
							if(a != 1){
								proLoanBean2.setDefinitionId(proLoanBean.getDefinitionId());
								proLoanBean2.setC_id(proLoanBean.getC_id());
								proLoanBean2.setOneCategory_name(valueArra1[i] );
								proLoanBean2.setLoanCategory_name(valueArra2[i] );
								proLoanBean2.setOp_empid(this.getCurrentOnlineUser().getEmpid());
								proLoanBean2.setOp_orgcode(this.getCurrentOnlineUser().getOrgcode());
								
								this.timeLimitManageService.insertProLoanTimeLimit(proLoanBean2); //插入到（B表） t_model_proLoanTimeLimit 流程贷种时限关表
							}
						 }
		    		 }
					 
					 if(flag1 == 0 && flag2 == 0){
						 info ="success";
					 }
    			
    		}
    	} catch (Exception e) {
			info="fails";	
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	public String queryNodeTimeLimitList(){
		String definitionId = this.proTimeModelBean.getDefinitionId();
		RepositoryService repositoryService = jbpmService
				.getRepositoryService();
		ProcessDefinitionImpl processDefinition = (ProcessDefinitionImpl) repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionId(definitionId).uniqueResult();
		
		List<NodeTimeLimitBean> nodeTimeLimitBeans = new ArrayList<NodeTimeLimitBean>();
		List list = processDefinition.getActivities();
		
		for (int i = 0; i < list.size(); i++) {
			ActivityImpl activityImpl = (ActivityImpl) list.get(i);
			String type = activityImpl.getType();
			if (type.equals("task")) {
				NodeTimeLimitBean nodeTimeLimitBean = new NodeTimeLimitBean();
				nodeTimeLimitBean.setTaskName(activityImpl.getName());
				nodeTimeLimitBean.setC_id(proTimeModelBean.getC_id());
				List<NodeTimeLimitBean> nodeTimeLimitBeans2 = this.timeLimitManageService.queryNodeTimeLimitList(nodeTimeLimitBean);
				if(nodeTimeLimitBeans2.size() == 1){
					NodeTimeLimitBean nodeTimeLimitBean2 = nodeTimeLimitBeans2.get(0);
					nodeTimeLimitBean.setE_id(nodeTimeLimitBean2.getE_id());
					nodeTimeLimitBean.setTimeLimit(nodeTimeLimitBean2.getTimeLimit());
					nodeTimeLimitBean.setTwotimeLimit(nodeTimeLimitBean2.getTwotimeLimit());
				}
				
				nodeTimeLimitBeans.add(nodeTimeLimitBean);
			}
		}
		this.setNodeTimeLimitBeans(nodeTimeLimitBeans);
		this.setProTimeModelBean(proTimeModelBean);
		return "nodeTimeLimit_list";
	}
	
	public String toSetNodeTimeLimit(){
		return "setNodeTimeLimit";
	}
	
	public void saveNodeTimeLimit() throws Exception{
		String info ="success";
    	try {
    		if(nodeTimeLimitBean != null ){
    			nodeTimeLimitBean.setOp_empid(this.getCurrentOnlineUser().getEmpid());
    			nodeTimeLimitBean.setOp_orgcode(this.getCurrentOnlineUser().getOrgcode());
    			
    			if(nodeTimeLimitBean.getE_id() == null){
    				this.timeLimitManageService.insertNodeTimeLimit(nodeTimeLimitBean);
    			}else{
    				this.timeLimitManageService.updateNodeTimeLimit(nodeTimeLimitBean);
    			}
    		}
				
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
	}
	
	/**
	 * 通过definitionId和c_id查（B表）t_model_proLoanTimeLimit，得到c_id对应的一级和贷种分类名称
	 * @throws Exception 
	 */
	public String queryProLoanTimeLimit(){
    	oneAndLoanBeans =  this.timeLimitManageService.queryProLoanTimeLimit(proLoanBean);
		this.setOneAndLoanBeans(oneAndLoanBeans)	;
		return "oneAndLoanBeansList";
	}
	
	public void deleteTimeLimitManage() throws Exception{
		String info ="success";
    	try {
    		this.timeLimitManageService.deleteTimeLimitManage(proLoanBean);
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	/**
	 * 查询 有效日列表
	 * @return
	 */
	public String queryValidDayList(){
		List<WorkTimeMainBean>  workTimeMainBeans = this.timeLimitManageService.queryValidDayList(time, this.getPage());
		this.setWorkTimeMainBeans(workTimeMainBeans);
		return "validDay_list";
	}
	
	/**
	 * 查询 工作时间列表
	 * @return
	 */
	public String queryWorkTimeList(){
		List<WorkTimeSideBean>  workTimeSideBeans = this.timeLimitManageService.queryWorkTimeList(workTimeMainBean);
		this.setWorkTimeSideBeans(workTimeSideBeans);
		return "workTime_list";
	}
	

	/**
	 * @author liaomeiting
	 * 跳转到有效日维护新增页面
	 * @return
	 */
	public String toAddValidDay(){
		return "add_validDay";
	}
	
	/**
	 * @author liaomeiting
	 * 跳转到工作时间维护新增页面
	 * @return
	 */
	public String toAddWorkTime(){
		//System.out.println(workTimeSideBean.getMainID());
		return "add_workTime";
	}
	
	/**
	 * @author liaomeiting
	 * @desc 跳转到工作日维护新增页面
	 * @return
	 */
	public String toAddWorkDay(){
		return "add_workDay";
	}
	
	
	/**
	 * @author liaomeiting
	 * @desc 跳转到工作日修改页面
	 * @return
	 */
	public String toUptValidDay(){
		List list = this.timeLimitManageService.queryValidDayById(workTimeMainBean);
		if(list.size() == 1){
			Map<String, String> map = (Map<String, String>) list.get(0);
			workTimeMainBean.setStartDate(map.get("STARTDATE"));
			workTimeMainBean.setEndDate(map.get("ENDDATE"));
			this.setWorkTimeMainBean(workTimeMainBean);
		}
		return "upt_validDay";
	}
	
	/**
	 * @author liaomeiting
	 * @desc 有效日修改
	 * @return
	 */
	public void uptValidDayById() throws Exception{
		String info ="success";
    	try {
    		workTimeMainBean.setOrgcode(this.getCurrentOnlineUser().getOrgcode());
    		workTimeMainBean.setEmpid(this.getCurrentOnlineUser().getEmpid());
    		 this.timeLimitManageService.uptValidDayById(workTimeMainBean);
    		
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	/**
	 * @author liaomeiting
	 * @desc 删除有效日
	 * @return
	 */
	public void deleteValidDay() throws Exception{
		String info ="success";
    	try {
    		 this.timeLimitManageService.updateTimeMain_delState(workTimeMainBean);
    		
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	/**
	 * 保存 新增有效日
	 * @throws Exception
	 */
	public void saveValidDay() throws Exception{
		String info ="success";
		
    	try {
    		WorkTimeMainBean workTimeMainBean = new WorkTimeMainBean();
    		
    		workTimeMainBean.setStartDate( time.get("startDate") );
    		workTimeMainBean.setEndDate( time.get("endDate") );
    		workTimeMainBean.setOrgcode(this.getCurrentOnlineUser().getOrgcode());
    		workTimeMainBean.setEmpid(this.getCurrentOnlineUser().getEmpid());
    		
    		this.timeLimitManageService.saveWorkTimeIntoTimeMain(workTimeMainBean);
    		
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	/**
	 * 保存 工作时间
	 * @throws Exception
	 */
	public void saveWorkTime() throws Exception{
		String info ="success";
		
    	try {
    		String[] types = 	workTimeSideBean.getTimeType().split(",");
    		String[] starts = workTimeSideBean.getStartTime().split(",");
    		String[] ends = workTimeSideBean.getEndTime().split(",");
    		for (int i = 0; i < types.length; i++) {
				workTimeSideBean.setTimeType(types[i]);
				workTimeSideBean.setStartTime(starts[i]);
				workTimeSideBean.setEndTime(ends[i]);
				
				//插入一条 时间 的配置信息
    			this.timeLimitManageService.saveWorkTimeIntoTimeSide(workTimeSideBean);
    			
    			/*//修改一条 晚上 的配置信息
    			this.timeLimitManageService.updateWorkTimeById(workTimeSideBean);
    			//删除一条 晚上 的配置信息
    			this.timeLimitManageService.deleteWorkTimeById(workTimeSideBean);*/
			}
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	public void delWorkTime() {
		String info ="success";
		try {
			this.timeLimitManageService.deleteWorkTimeById(workTimeSideBean);
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
		}finally{	
			Struts2Utils.renderText(info);
		}
		
	}
	
	/**
	 * @author iaomeiting
	 * 校验 日期不能在之前配过的时间范围内
	 * @throws Exception
	 */
	public void checkDate() throws Exception{
		String info ="";
    	try {
    		List list = this.timeLimitManageService.checkDate(time);
    		if(list.size() > 0){
    			info = "exist";
    		}else{
    			info = "notExist";
    		}
    		
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	/**
	 * @author liaomeiting
	 * 校验 工作时间不能在之前配过的时间范围内
	 * @throws Exception
	 */
	public void checkWorkTime() throws Exception{
		String info ="";
    	try {
    		List list = this.timeLimitManageService.checkWorkTime(time);
    		if(list.size() > 0){
    			info = "exist";
    		}else{
    			info = "notExist";
    		}
    		
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	/**
	 * 查询已关联维护的一级分类列表，业务选择参数维护 功能时用，将查到的结果返回为列表
	 * @return
	 */
	public String queryOneCategorylist2(){
		proLoanBeans = this.timeLimitManageService.queryOneCategorylist();
		this.setProLoanBeans(proLoanBeans);
		return "oneCategory_list";
	}
	
	/**
	 * 查询已关联维护的贷种分类列表，业务选择参数维护 功能时用，将查到的结果返回为列表
	 * @return
	 */
	public String queryLoanCategorylist2(){
		proLoanBeans = this.timeLimitManageService.queryLoanCategorylist(proLoanBean);
		this.setProLoanBeans(proLoanBeans);
		return "loanCategory_list";
	}
	
}
