package com.gotop.Generalprocess.dao.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelfourDAO;
import com.gotop.Generalprocess.model.ProcessModelFour;
import com.gotop.Generalprocess.model.ProcessModelFourMistake;
import com.gotop.util.dataSource.SqlMapClientDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class TGeneralprocessModelfourDAO extends SqlMapClientDao implements ITGeneralprocessModelfourDAO {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModelfourDAO.class);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table T_GENERALPROCESS_MODELFOUR
     *
     * @abatorgenerated 
     */
    public TGeneralprocessModelfourDAO() {
        super();
    }
	@Override
	public ProcessModelFour queryProceeModelId(Map<String, Object> map) {
		return (ProcessModelFour) getSqlMapClientTemplate().queryForObject("T_GENERALPROCESS_MODELFOUR_SqlMap.queryProceeModelId", map);
	}

	@Override
	public ProcessModelFour queryModelFour(HashMap<String, Object> map) {
		return (ProcessModelFour) getSqlMapClientTemplate().queryForObject("T_GENERALPROCESS_MODELFOUR_SqlMap.queryModelFour", map);
	}

	@Override
	public void addModelFour(ProcessModelFour modelFour) {
		getSqlMapClientTemplate().insert("T_GENERALPROCESS_MODELFOUR_SqlMap.addModelFour", modelFour);
	}

	@Override
	public void uptModelFour(ProcessModelFour modelFour) {
		getSqlMapClientTemplate().update("T_GENERALPROCESS_MODELFOUR_SqlMap.uptModelFour", modelFour);
	}

	@Override
	public ProcessModelFour queryModelFourById(String processModelId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("processModelId", processModelId);
		return (ProcessModelFour) queryForObject("T_GENERALPROCESS_MODELFOUR_SqlMap.queryModelFourById", map);
	}

	@Override
	public void addModelFourMistake(ProcessModelFourMistake mistake) {
		getSqlMapClientTemplate().insert("T_GENERALPROCESS_MODELFOUR_SqlMap.addModelFourMistake", mistake);
	}
	
	@Override
	public void saveMistakeInfo(Map<String, Object> map) {
		// TODO 自动生成的方法存根
		
		getSqlMapClientTemplate().insert("T_GENERALPROCESS_MODELFOUR_SqlMap.saveMistakeInfo", map);
	}
	 
	@Override
	public void saveProcessModelFour(Map<String, Object> map) {
		getSqlMapClientTemplate().insert("T_GENERALPROCESS_MODELFOUR_SqlMap.saveProcessModelFour", map);
		
	}
	@Override
	public List<ProcessModelFourMistake> queryFourMistake(
			HashMap<String, Object> map) {
		return getSqlMapClientTemplate().queryForList("T_GENERALPROCESS_MODELFOUR_SqlMap.queryFourMistake", map);
	}

	@Override
	public void deleteModelFourMistake(ProcessModelFour modelFour) {
		getSqlMapClientTemplate().delete("T_GENERALPROCESS_MODELFOUR_SqlMap.deleteModelFourMistake", modelFour);
	}

	@Override
	public List<ProcessModelFourMistake> queryFourMistakeByFlowId(
			HashMap<String, Object> map) {
		return queryForList("T_GENERALPROCESS_MODELFOUR_SqlMap.queryFourMistakeByFlowId", map);
	}
	/**
	 * 查询流程整改情况
	 */
	@Override
	public List<ProcessModelFourMistake> queryMistakes(Map<String, Object>map) {
	
		 return queryForList("T_GENERALPROCESS_MODELFOUR_SqlMap.queryMistakes", map);
	}
	


	
}