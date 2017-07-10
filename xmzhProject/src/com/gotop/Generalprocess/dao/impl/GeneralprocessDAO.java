package com.gotop.Generalprocess.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.Generalprocess.dao.IGeneralprocessDAO;
import com.gotop.Generalprocess.model.GeneralprocessDto;
import com.gotop.euipApply.dao.impl.TApplyEuipDAO;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.gotop.vo.tyjg.Omorganization;
import com.primeton.utils.Page;

public class GeneralprocessDAO extends SqlMapClientDao implements IGeneralprocessDAO{

	 /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TApplyEuipDAO.class);
    
    public GeneralprocessDAO() {
    	 super();
	}
    
	@Override
	public List queryOrgName(String empIds) {
		return queryForList("GENERAL_PROCESS_SqlMap.queryOrgName",empIds);
	}

	@Override
	public String isHaveParentOrgId(HashMap<String, Object> map) {
		return (String) queryForObject("GENERAL_PROCESS_SqlMap.isHaveParentOrgId",map);
	}

	@Override
	public Omorganization getParentOrgId(HashMap<String, Object> map) {
		return (Omorganization) queryForObject("GENERAL_PROCESS_SqlMap.getParentOrgId",map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GeneralprocessDto> queryGeneralprocessList(
			Map<String, Object> map, Page page) {
		// TODO Auto-generated method stub
		List<GeneralprocessDto> list=null;
		if(page!=null){
			list = (List<GeneralprocessDto>)queryForList("GENERAL_PROCESS_SqlMap.queryGeneralprocessList", map,page);
			//list = (List<GeneralprocessDto>)queryForList("GENERAL_PROCESS_SqlMap.myStartGeneralProcessList", map,page);
		}
		else {
			list = (List<GeneralprocessDto>)queryForList("GENERAL_PROCESS_SqlMap.queryGeneralprocessList", map);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GeneralprocessDto> queryGeneralprocessList2(
			Map<String, Object> map, Page page) {
		// TODO Auto-generated method stub
		List<GeneralprocessDto> list=null;
		if(page!=null){
			list = (List<GeneralprocessDto>)queryForList("GENERAL_PROCESS_SqlMap.queryGeneralprocessList2", map,page);
			//list = (List<GeneralprocessDto>)queryForList("GENERAL_PROCESS_SqlMap.myStartGeneralProcessList", map,page);
		}
		else {
			list = (List<GeneralprocessDto>)queryForList("GENERAL_PROCESS_SqlMap.queryGeneralprocessList2", map);
		}
		return list;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<GeneralprocessDto> myStartGeneralProcessList(Map<String, Object> map,
			Page page) {
		List list = queryForList("GENERAL_PROCESS_SqlMap.myStartGeneralProcessList", map,page);
		return list;
	}
	
	

	@Override
	public List queryyxryjg(Map<String, Object> map) {
		List list = queryForList("GENERAL_PROCESS_SqlMap.queryyxryjg", map);
		return list;
		
	}

	@Override
	public List<Omorganization> isOneOrg(Map<String, Object> map2) {
		
		List list = queryForList("GENERAL_PROCESS_SqlMap.isOneOrg", map2);
		return list;
	}

	@Override
	public List queryBackoverTaskIsSave(Map<String, Object> map) {
		
		List list = queryForList("GENERAL_PROCESS_SqlMap.queryBackoverTaskIsSave", map);
		return list;
	}

	@Override
	public void insertBackoverTaskIsSave(Map<String, Object> map) {
		
		getSqlMapClientTemplate().insert("GENERAL_PROCESS_SqlMap.insertBackoverTaskIsSave", map);
		
	}

	@Override
	public void uptBackoverTaskIsSave(Map<String, Object> map) {
		
		getSqlMapClientTemplate().update("GENERAL_PROCESS_SqlMap.uptBackoverTaskIsSave", map);
		
	}

}
