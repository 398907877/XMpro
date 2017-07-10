package com.gotop.jbpm.service;

import java.util.HashMap;
import java.util.List;

import com.gotop.jbpm.dao.IXdProcessDAO;
import com.gotop.jbpm.model.WaterInfo;
import com.gotop.jbpm.model.WorkTimeBean;
import com.gotop.jbpm.model.XdCdtypeBean;
import com.gotop.jbpm.model.XdProcessBean;
import com.gotop.jbpm.model.XdProcessTaskAssignee;
import com.primeton.utils.Page;

public interface IXdProcessService {

	IXdProcessDAO getXdProcessDAO();
	
	void setXdProcessDAO(IXdProcessDAO xdProcessDAO);
	
	List<XdProcessTaskAssignee> queryXdMyToDoList(
			String relationids, XdProcessTaskAssignee xdProcessTaskAssignee, Page page);

	List<XdProcessBean> queryXdProcessList(XdProcessBean xdProcessBean,
			Page page);

	List<XdCdtypeBean> queryOneCategoryList(XdCdtypeBean xdCdtypeBean,
			Page page);
	
	List<XdCdtypeBean> queryLoanCategoryList(XdCdtypeBean xdCdtypeBean2,
			Page page);

	List<XdCdtypeBean> checkOneCategory(XdCdtypeBean xdCdtypeBean);

	void insert(XdCdtypeBean xdCdtypeBean);

	void delete(XdCdtypeBean xdCdtypeBean);

	List<XdCdtypeBean> checkLoanCategory(XdCdtypeBean xdCdtypeBean);

	List<XdProcessTaskAssignee> queryXdStartProcessList(
			String relationids, XdProcessTaskAssignee xdProcessTaskAssignee, Page page);

	int uptModelOneInfo(XdProcessTaskAssignee xdProcessTaskAssignee);
	//根据executionId查询修改明细表是否有数据0
	int  selectIsfirst(String executionId);
	//修改模式三保单次数
	int uptModelThreeInfo(XdProcessTaskAssignee xdProcessTaskAssignee);
	//根据id 获取最原始的数据，只有修改明细中没有记录的才调用
	XdProcessTaskAssignee getxdProcessTaskAssigneeById(String executionId);
	
	void insertWater(WaterInfo waterInfo);
	//插入 第一条贷款 信息修改 时间为null
	void insertWaterOne(WaterInfo waterInfo);
	List<WaterInfo> queryLoanUptWater(WaterInfo waterInfo, Page page);

	List<WorkTimeBean> queryWorkTime(WorkTimeBean workTimeBean);

	void insertWorkTime(WorkTimeBean workTimeBean);

	void updateWorkTime(WorkTimeBean workTimeBean);

	void updateTitle(XdProcessTaskAssignee xdProcessTaskAssignee);

	HashMap queryTimeDiff(String executionId);

}
