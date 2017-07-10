package com.gotop.deviceManagement.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.deviceManagement.dao.IDeviceManagementDAO;
import com.gotop.deviceManagement.model.DevicePo;
import com.gotop.dict.model.EosDictType;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;


/**
 * 
 * @author wujiajun
 *
 */
public class DeviceManagementDAO extends SqlMapClientDao implements IDeviceManagementDAO {
	
/**
 * 已经通过集成类 ，获取到了 访问数据库的实例！  可以获取到对象进行DAO操作
 */
	protected Logger log = Logger.getLogger(DeviceManagementDAO.class);

	
	public DeviceManagementDAO() {
	super();
	// TODO 自动生成的构造函数存根
}


	@Override
	public List deviceList(Map<String, Object> map, Page page) {
		if(page!=null)
			return queryForList("T_DEVICE_SqlMap.queryList", map, page);
		else
			return queryForList("T_DEVICE_SqlMap.queryList", map);
	}


	@Override
	public DevicePo selectByPrimaryKey(Long deviceId) {
		DevicePo key = new DevicePo();
        key.setDeviceId(deviceId);
        DevicePo record = (DevicePo) queryForObject("T_DEVICE_SqlMap.selectByPrimaryKey", key);
        return record;
	}


	@Override
	public void insert(DevicePo device) {
		getSqlMapClientTemplate().insert("T_DEVICE_SqlMap.insert", device);
	}


	@Override
	public int updateByPrimaryKey(DevicePo device) {
		 int rows = getSqlMapClientTemplate().update("T_DEVICE_SqlMap.updateByPrimaryKey", device);
	        return rows;
	}


	@Override
	public int deleteByPrimaryKey(Long deviceId) {
		DevicePo key = new DevicePo();
        key.setDeviceId(deviceId);
        int rows = getSqlMapClientTemplate().delete("T_DEVICE_SqlMap.deleteByPrimaryKey", key);
        return rows;
	}


	@Override
	public int queryOrg(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("T_DEVICE_SqlMap.queryOrg", map);
		if(count==null){
			return 0;
		}else{
			return count.intValue();
		}
	}


	@Override
	public List sumUpList(Map<String, Object> map, Page page) {
		if(page!=null)
			return queryForList("T_DEVICE_SqlMap.querySumList", map, page);
		else
			return queryForList("T_DEVICE_SqlMap.querySumList", map);
	}



	public List queryOrgList() {
		HashMap map = new HashMap();
		List list = queryForList("T_DEVICE_SqlMap.queryOrglist", map);
		return list;
	}


	@Override
	public List deviceList(Map<String, Object> map) {
		List list = queryForList("T_DEVICE_SqlMap.queryList", map);
		return list;
	}

//查询设备型号
	@Override
	public List queryType(Map<String, String> map) {
		
		List list = new ArrayList();
		if(map.get("deviceName") == null){//若页面没有选择设备名称，则显示数据字典里配置的所有设备型号
			list =  queryForList("T_DEVICE_SqlMap.queryType2", map);
		}else{//若页面有选择设备名称，则显示 设备名称和设备型号关系表 里配置的设备型号
			list =  queryForList("T_DEVICE_SqlMap.queryType", map);
		}
		return list;
	}

//导出Excel
	@Override
	public List sumUpListExcel(Map<String, Object> map) {
		return queryForList("T_DEVICE_SqlMap.querySumList", map);
	}


	@Override
	public List heJi(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return queryForList("T_DEVICE_SqlMap.querySumList2",map);
	}

	//属性名称查询
	@Override
	public String getEosDictTypeBydictTypeId(EosDictType eosDictType) {
		//String dictTypeName=  getEosDictTypeNameBydictTypeId
		//EosDictType dictType=(EosDictType) getSqlMapClientTemplate().queryForObject(dictTypeId);
		EosDictType dictType=(EosDictType) queryForObject("T_DEVICE_SqlMap.getEosDictTypeNameBydictTypeId", eosDictType);
		String dictTypeName=dictType.getDictTypeName();
		return dictTypeName;
	}
}
