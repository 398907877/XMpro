package com.gotop.jbpm.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.jbpm.model.WaterInfo;
import com.gotop.jbpm.model.WorkTimeBean;
import com.gotop.jbpm.model.XdCdtypeBean;
import com.gotop.jbpm.model.XdProcessBean;
import com.gotop.jbpm.model.XdProcessTaskAssignee;
import com.primeton.utils.Page;

public interface IXdProcessDAO {

	List<XdProcessTaskAssignee> queryXdMyToDoList(Map<String, Object> map,Page page);

	List<XdProcessBean> queryXdProcessList(Map<String, Object> map, Page page);

	List queryOneCategoryList(Map<String, Object> map, Page page);

	List queryLoanCategoryList(Map<String, Object> map, Page page);

	List checkOneCategory(Map<String, Object> map);

	void insert(XdCdtypeBean xdCdtypeBean);

	int delete(XdCdtypeBean xdCdtypeBean);

	List checkLoanCategory(Map<String, Object> map);

	List<XdProcessTaskAssignee> queryXdStartProcessList(
			Map<String, Object> map, Page page);

	void insertWater(WaterInfo waterInfo);
	//插入 第一条贷款 信息修改 时间为null
	void insertWaterOne(WaterInfo waterInfo);
	int uptModelOneInfo(XdProcessTaskAssignee xdProcessTaskAssignee);
	//根据executionId查询修改明细表是否有数据0
	int selectIsfirst(Map<String, String> map);
	//修改模式三的报单次数
	int uptModelThreeInfo(XdProcessTaskAssignee xdProcessTaskAssignee);
	//根据id 获取最原始的数据，只有修改明细中没有记录的才调用
	XdProcessTaskAssignee getxdProcessTaskAssigneeById(XdProcessTaskAssignee xdProcessTaskAssignee);

	List<WaterInfo> queryLoanUptWater(Map<String, Object> map, Page page);

	List<WorkTimeBean> queryWorkTime(Map<String, Object> map);

	void insertWorkTime(WorkTimeBean workTimeBean);

	int updateWorkTime(WorkTimeBean workTimeBean);

	void updateTitle(XdProcessTaskAssignee xdProcessTaskAssignee);

	HashMap queryTimeDiff(String executionId);

}
