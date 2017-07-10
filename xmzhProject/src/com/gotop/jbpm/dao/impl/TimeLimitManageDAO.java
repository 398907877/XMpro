package com.gotop.jbpm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.jbpm.dao.ITimeLimitManageDAO;
import com.gotop.jbpm.model.NodeTimeLimitBean;
import com.gotop.jbpm.model.OneAndLoanBean;
import com.gotop.jbpm.model.ProLoanBean;
import com.gotop.jbpm.model.ProTimeModelBean;
import com.gotop.jbpm.model.WorkTimeMainBean;
import com.gotop.jbpm.model.WorkTimeSideBean;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class TimeLimitManageDAO extends SqlMapClientDao  implements ITimeLimitManageDAO{

	protected Logger log = Logger.getLogger(TimeLimitManageDAO.class);

	public TimeLimitManageDAO() {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public List<OneAndLoanBean> queryOneAndLoanList(
			Map<String, Object> map, Page page) {
		
		List<OneAndLoanBean> oneAndLoanBeans = this.queryForList("TimeLimitManage_SqlMap.queryOneAndLoanList", map, page);
		return oneAndLoanBeans;
	}

	@Override
	public List checkOneAndLoan(Map<String, Object> map) {
		List list = queryForList("TimeLimitManage_SqlMap.checkOneAndLoan", map);
		return list;
	}

	@Override
	public void addOneAndLoan(OneAndLoanBean oneAndLoanBean) {
		getSqlMapClientTemplate().insert("TimeLimitManage_SqlMap.addOneAndLoan", oneAndLoanBean);
		
	}

	@Override
	public int delOneAndLoan(OneAndLoanBean oneAndLoanBean) {
		int rows = getSqlMapClientTemplate().delete("TimeLimitManage_SqlMap.delOneAndLoan", oneAndLoanBean);
        return rows;
	}

	@Override
	public List queryOneCategorylist(Map<String, Object> map) {
		List list = queryForList("TimeLimitManage_SqlMap.queryOneCategorylist", map);
		return list;
	}
	
	@Override
	public List queryOneCategorylist1(Map<String, Object> map) {
		List list = queryForList("TimeLimitManage_SqlMap.queryOneCategorylist1", map);
		return list;
	}

	@Override
	public List queryLoanCategorylist(Map<String, Object> map) {
		List list = queryForList("TimeLimitManage_SqlMap.queryLoanCategorylist", map);
		return list;
	}
	@Override
	public List queryLoanCategorylist1(Map<String, Object> map) {
		List list = queryForList("TimeLimitManage_SqlMap.queryLoanCategorylist1", map);
		return list;
	}

	@Override
	public void insertProTimeLimitModel(ProTimeModelBean proTimeModelBean) {
		getSqlMapClientTemplate().insert("TimeLimitManage_SqlMap.insertProTimeLimitModel",proTimeModelBean);
	}

	@Override
	public void insertProLoanTimeLimit(ProLoanBean proLoanBean2) {
		getSqlMapClientTemplate().insert("TimeLimitManage_SqlMap.insertProLoanTimeLimit", proLoanBean2);
	}

	@Override
	public List queryNodeTimeLimitList(Map<String, Object> map) {
		List list = queryForList("TimeLimitManage_SqlMap.queryNodeTimeLimitList", map);
		return list;
	}

	@Override
	public void insertNodeTimeLimit(NodeTimeLimitBean nodeTimeLimitBean) {
		getSqlMapClientTemplate().insert("TimeLimitManage_SqlMap.insertNodeTimeLimit", nodeTimeLimitBean);
	}

	@Override
	public int updateNodeTimeLimit(NodeTimeLimitBean nodeTimeLimitBean) {
		int count = getSqlMapClientTemplate().update("TimeLimitManage_SqlMap.updateNodeTimeLimit", nodeTimeLimitBean);
		return count;
	}

	@Override
	public List querySelectModel(Map<String, Object> map) {
		List list = queryForList("TimeLimitManage_SqlMap.querySelectModel", map);
		return list;
	}

	@Override
	public List checkTimeModelName(Map<String, Object> map) {
		List list = this.queryForList("TimeLimitManage_SqlMap.checkTimeModelName", map);
		return list;
	}

	@Override
	public List queryProLoanTimeLimit(Map<String, Object> map) {
		List list = this.queryForList("TimeLimitManage_SqlMap.queryProLoanTimeLimit", map);
		return list;
	}

	@Override
	public int updateProLoanTimeLimit(ProLoanBean my_proLoanBean2) {
		int count = getSqlMapClientTemplate().update("TimeLimitManage_SqlMap.updateProLoanTimeLimit", my_proLoanBean2);
		return count;
	}

	@Override
	public int deleteTimeLimitManage(ProLoanBean proLoanBean) {
		int count = getSqlMapClientTemplate().delete("TimeLimitManage_SqlMap.deleteTimeLimitManage", proLoanBean);
		return count;
	}

	@Override
	public void saveWorkTimeIntoTimeMain(WorkTimeMainBean workTimeMainBean) {
		getSqlMapClientTemplate().insert("TimeLimitManage_SqlMap.saveWorkTimeIntoTimeMain", workTimeMainBean);
	}

	@Override
	public void saveWorkTimeIntoTimeSide(WorkTimeSideBean workTimeSideBean) {
		getSqlMapClientTemplate().insert("TimeLimitManage_SqlMap.saveWorkTimeIntoTimeSide", workTimeSideBean);
	}

	@Override
	public List queryValidDayList(Map<String, Object> map, Page page) {
		List list = this.queryForList("TimeLimitManage_SqlMap.queryValidDayList", map, page);
		return list;
	}

	@Override
	public List checkDate(Map<String, String> time) {
		List list = this.queryForList("TimeLimitManage_SqlMap.checkDate", time);
		return list;
	}

	@Override
	public List queryWorkTimeList(WorkTimeMainBean workTimeMainBean) {
		List list = this.queryForList("TimeLimitManage_SqlMap.queryWorkTimeList", workTimeMainBean);
		return list;
	}

	@Override
	public void updateTimeMain_delState(WorkTimeMainBean workTimeMainBean) {
		getSqlMapClientTemplate().update("TimeLimitManage_SqlMap.updateTimeMain_delState", workTimeMainBean);
	}

	@Override
	public void updateWorkTimeById(WorkTimeSideBean workTimeSideBean) {
		getSqlMapClientTemplate().update("TimeLimitManage_SqlMap.updateWorkTimeById", workTimeSideBean);
	}

	@Override
	public void deleteWorkTimeById(WorkTimeSideBean workTimeSideBean) {
		getSqlMapClientTemplate().delete("TimeLimitManage_SqlMap.deleteWorkTimeById", workTimeSideBean);
	}


	@Override
	public List checkWorkTime(Map<String, String> time) {
		List list = this.queryForList("TimeLimitManage_SqlMap.checkWorkTime", time);
		return list;
	}

	@Override
	public List queryValidDayById(WorkTimeMainBean workTimeMainBean) {
		
		List list = this.queryForList("TimeLimitManage_SqlMap.queryValidDayById", workTimeMainBean);
		return list;
	}

	@Override
	public void uptValidDayById(WorkTimeMainBean workTimeMainBean) {
		
		getSqlMapClientTemplate().update("TimeLimitManage_SqlMap.uptValidDayById", workTimeMainBean);
		
	}


}
