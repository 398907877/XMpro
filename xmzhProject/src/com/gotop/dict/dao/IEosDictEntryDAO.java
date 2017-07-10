package com.gotop.dict.dao;

import com.gotop.dict.model.EosDictEntry;
import com.gotop.dict.model.EosDictType;
import com.primeton.utils.Page;
import java.util.List;
import java.util.Map;

public interface IEosDictEntryDAO {

	List dictTypeList(Map<String, Object> map, Page page);
	
	List queryDictEntryBydictTypeId(EosDictEntry dictEntry, Page page2);
	
	List queryDictEntryBydictTypeId(EosDictEntry dictEntry);

	EosDictEntry getDictEntryById(EosDictEntry dictEntry);
	//根据dictTypeId查询属性
	EosDictType getEosDictTypeBydictTypeId(EosDictType dictType);
	//修改属性名称
	int updateItemNameBydictTypeId(EosDictType dictType);
	void insert(EosDictEntry dictEntry);

	int updateById(EosDictEntry dictEntry);
	
	int deleteById(EosDictEntry dictEntry);

	int queryIsExist(EosDictEntry dictEntry);

}