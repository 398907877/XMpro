package com.gotop.mortgage.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.mortgage.dao.IMortgageLogDao;
import com.gotop.mortgage.model.LoanInfo;
import com.gotop.mortgage.model.MortgageLog;
import com.gotop.mortgage.service.IMortgageLogService;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public class MortgageLogService implements IMortgageLogService {

	private IMortgageLogDao mortgageLogDao;
	
	public IMortgageLogDao getMortgageLogDao() {
		return mortgageLogDao;
	}

	public void setMortgageLogDao(IMortgageLogDao mortgageLogDao) {
		this.mortgageLogDao = mortgageLogDao;
	}

	@Override
    public List<MortgageLog> queryMortgageLogList(MUOUserSession muo, MortgageLog mortgageLog, Page page) {
		
		Map<String, Object>map=new HashMap<String, Object>();
		
		//操作类型
		if (mortgageLog.getOperateType() !=null&&!"".equals(mortgageLog.getOperateType())) {
			map.put("operateType", mortgageLog.getOperateType());
	    }
		//操作开始日期
		if (mortgageLog.getAirTime() !=null&&!"".equals(mortgageLog.getAirTime())) {
				map.put("airTime", mortgageLog.getAirTime());
		}
		
		//操作结束日期
		if (mortgageLog.getStopTime() !=null&&!"".equals(mortgageLog.getStopTime())) {
			map.put("stopTime", mortgageLog.getStopTime());
	    }
		
		List<MortgageLog> mortgageLogLists =mortgageLogDao.queryMortgageLogList(map,page);
		return mortgageLogLists;
	}
	
	@Override
	public List<MortgageLog> queryMortgageLogListForExcel(MUOUserSession muo, MortgageLog mortgageLog) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List<MortgageLog> mortgageLogList=new ArrayList<MortgageLog>();
		Map<String, Object>map=new HashMap<String, Object>();
		
		String orgcode = muo.getOrgcode();
		
		//操作类型
				if (mortgageLog.getOperateType() !=null&&!"".equals(mortgageLog.getOperateType())) {
					map.put("operateType", mortgageLog.getOperateType());
			    }
		try {
				//操作开始日期
				if (mortgageLog.getAirTime() !=null&&!"".equals(mortgageLog.getAirTime())) {
						map.put("airTime", sdf1.format(sdf.parse(mortgageLog.getAirTime())));
				}
				
				//操作结束日期
				if (mortgageLog.getStopTime() !=null&&!"".equals(mortgageLog.getStopTime())) {
					map.put("stopTime", sdf1.format(sdf.parse(mortgageLog.getStopTime())));
			    }
		    } catch (ParseException e) {
						e.printStackTrace();
					}
		List<MortgageLog> mortgageLogLists =mortgageLogDao.queryMortgageLogListForExcel(map);
//		MortgageLog aa= new MortgageLog();
//		aa.setOperateTime("2017-05-24 00:00:00");
//		aa.setEmpName("小萌");
//		aa.setRemark("aaa");
//		mortgageLogLists.add(aa);
		return mortgageLogLists;
	}
}
