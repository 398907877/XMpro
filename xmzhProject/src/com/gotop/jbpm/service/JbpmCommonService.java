package com.gotop.jbpm.service;

import org.json.JSONException;

public interface JbpmCommonService {

	/**
	 * 根据流程配置页面配置的流程图生成的data数据
	 * 进行JBPM XML文件的生成和解析
	 * 返回JBPM的XML文件内容
	 * @param data		  页面配置json数据	
	 * @param processName 流程名称
	 * @return
	 */
	public String makeJbpmJsonByData(String data,String processName) throws JSONException;
}
