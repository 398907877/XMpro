package com.gotop.Generalprocess.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.Generalprocess.model.GeneralprocessDto;
import com.gotop.vo.tyjg.Omorganization;
import com.primeton.utils.Page;

public interface IGeneralprocessDAO {

	/**
	 * 根据多个empid查询出机构名称列表
	 * @param empIds
	 * @return
	 */
	public List queryOrgName(String empIds);

	public String isHaveParentOrgId(HashMap<String, Object> map);

	public Omorganization getParentOrgId(HashMap<String, Object> map);

	public List<GeneralprocessDto> queryGeneralprocessList(
			Map<String, Object> map, Page page);
	
	public List<GeneralprocessDto> queryGeneralprocessList2(
			Map<String, Object> map, Page page);
	
	public List<GeneralprocessDto> myStartGeneralProcessList(
			Map<String, Object> map, Page page);

	public List queryyxryjg(Map<String, Object> map);

	public List<Omorganization> isOneOrg(Map<String, Object> map2);

	public List queryBackoverTaskIsSave(Map<String, Object> map);

	public void insertBackoverTaskIsSave(Map<String, Object> map);

	public void uptBackoverTaskIsSave(Map<String, Object> map);


}
