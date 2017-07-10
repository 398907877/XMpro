package com.gotop.tyjg.datadictionary.struts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import com.opensymphony.xwork2.ActionContext;


import com.gotop.crm.util.BaseAction;

import com.gotop.tyjg.datadictionary.model.*;
import com.gotop.tyjg.datadictionary.service.*;
import com.opensymphony.xwork2.ActionSupport;
import com.primeton.utils.AjaxParam;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;
import com.gotop.util.XmlConvert;

public class DictEntryAction extends BaseAction{
	private DictEntry dictEntry;
	private DictEntry dictEntryjson;
	private String dicttypeid;
	private String dictid;
	private String  json;
	
	
	public String getDicttypeid() {
		return dicttypeid;
	}

	public void setDicttypeid(String dicttypeid) {
		this.dicttypeid = dicttypeid;
	}

	public String getDictid() {
		return dictid;
	}

	public void setDictid(String dictid) {
		this.dictid = dictid;
	}


	public DictEntry getDictEntryjson() {
		return dictEntryjson;
	}

	public void setDictEntryjson(DictEntry dictEntryjson) {
		this.dictEntryjson = dictEntryjson;
	}

	private IDictEntryService dictEntryService;
	
	public IDictEntryService getDictEntryService() {
		return dictEntryService;
	}

	public void setDictEntryService(IDictEntryService dictEntryService) {
		this.dictEntryService = dictEntryService;
	}
    
	public String dictManger() {
		return ActionSupport.SUCCESS;
	}
	
	
	/**
	 * datacell查询
	 * 分页查询查询数据字典类型
	 * @return
	 * @throws Exception
	 */
	public String queryDictOneType() throws Exception {
		DictEntry dictEntry1=new DictEntry();
		DictEntry dictEntryresult=new DictEntry();
		String[] strarray=dictid.split(","); 
		dictEntry1.setDicttypeid(dicttypeid);
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < strarray.length; i++) {
			dictEntry1.setDictid(strarray[i]);
			dictEntryresult=this.getDictEntryService().queryDictOneType(dictEntry1);
			if (null!=dictEntryresult) {
				sb.append(dictEntryresult.getDictname());
				sb.append(',');
			}
			
		}
		json=sb.toString().substring(0, sb.length()-1);
		return "query1";
    }
	/**
	 * datacell查询
	 * 分页查询查询数据字典类型
	 * @return
	 * @throws Exception
	 */
	public String queryDictTypePage() throws Exception {
		AjaxParam ap = XmlConvert.queryDatacell();
		Page page = ap.getPage();
		HashMap hm = ap.getParams();
		List<DictType> dictTypeList0 = this.getDictEntryService().queryDictTypeList(hm, page);
		pageCondExpand pce = new pageCondExpand();
		page.setCount(true);
		pce.putPageCond(page);
		String xmlStr = XmlConvert.getXmlListBean(page,dictTypeList0);
		this.write(xmlStr);
		return null;
	}
	/**
	 * 数据字典类型的变更
	 * @return
	 * @throws Exception
	 */
	public String saveDictType() throws Exception {
		
		HashMap hm = XmlConvert.updateDatacell();
		
		this.getDictEntryService().saveDictType(hm);
		return null;
	}
	/**
	 * 查询数据字典实体节点
	 * @return
	 * @throws Exception
	 */
	public String queryDictEntryNode() throws Exception {
		String dicttypeid = XmlConvert.getAjax("dicttypeid");
		String dictid = XmlConvert.getAjax("dictid");
		List<HashMap> hmList = XmlConvert.getMapAjax("DictType");
		List<DictEntry> dictEntryList = this.getDictEntryService().queryDictEntryNode(hmList.iterator().next());
		String xmlStr = XmlConvert.getXmlListBean(dictEntryList);
		this.write(xmlStr);
		return null;
	}
	public String queryDictEntryChildNode() throws Exception {
		String dicttypeid = XmlConvert.getAjax("dicttypeid");
		String dictid = XmlConvert.getAjax("dictid");
		List<HashMap> hmList = XmlConvert.getMapAjax("DictEntry");
		List<DictEntry> dictEntryList = this.getDictEntryService().queryDictEntryNode(hmList.iterator().next());
		String xmlStr = XmlConvert.getXmlListBean(dictEntryList);
		this.write(xmlStr);
		return null;
	}
	public String queryDictEntryPage() throws Exception {
		AjaxParam ap = XmlConvert.queryDatacell();
		Page page = ap.getPage();
		HashMap hm = ap.getParams();
		List<DictEntry> dictEntryList0 = this.getDictEntryService().queryDictEntryList(hm, page);
		pageCondExpand pce = new pageCondExpand();
		page.setCount(true);
		pce.putPageCond(page);
		String xmlStr = XmlConvert.getXmlListBean(page,dictEntryList0);
		this.write(xmlStr);
		return null;
	}
	public String saveDictEntry() throws Exception {
		HashMap hm = XmlConvert.updateDatacell();
		AjaxParam ap = XmlConvert.queryDatacell();
		HashMap hm1 = ap.getParams();
		this.getDictEntryService().saveDictEntry(hm, hm1);
		String result = "<root><data><flag>1</flag></data></root>";
		this.write(result);
		return null;
	}
	
	public String insertDictEntry() throws Exception {
		AjaxParam ap = XmlConvert.queryDatacell();
		HashMap hm = ap.getParams();
		boolean res = this.getDictEntryService().insertDictEntry(hm);
		String flag = (res == true)? "1":"0";
		String result = "<root><data><flag>" + flag + "</flag></data></root>";
		this.write(result);
		return null;
	}
	public String toUpdateDictEntry() throws Exception {
		Map request = (Map)ActionContext.getContext().get("request");
		HashMap hm = new HashMap();
		hm.put("dictEntry.dicttypeid",request.get("dictEntry.dicttypeid"));
		hm.put("dictEntry.dictid", request.get("dictEntry.dictid"));
		hm.put("dictEntry.parentid", request.get("dictEntry.parentid"));
		this.dictEntry = this.getDictEntryService().queryDictEntry(hm);
		return "toUpdateDictEntry";
	}
	public String updateDictEntry() throws Exception {
		AjaxParam ap = XmlConvert.queryDatacell();
		HashMap hm = ap.getParams();
		boolean res = this.getDictEntryService().updateDictEntry(hm);
		String flag = (res == true)? "1":"0";
		String result = "<root><data><flag>" + flag + "</flag></data></root>";
		this.write(result);
		return null;
	}
	public String deleteDictEntry() throws Exception {
		AjaxParam ap = XmlConvert.queryDatacell();
		HashMap hm = ap.getParams();
		boolean res = this.getDictEntryService().deleteDictEntry(hm);
		String flag = (res == true)? "1":"0";
		String result = "<root><data><flag>" + flag + "</flag></data></root>";
		this.write(result);
		return null;
	}

	public DictEntry getDictEntry() {
		return dictEntry;
	}

	public void setDictEntry(DictEntry dictEntry) {
		this.dictEntry = dictEntry;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
}
