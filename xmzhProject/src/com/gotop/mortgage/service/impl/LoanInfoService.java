package com.gotop.mortgage.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.mortgage.dao.ILoanInfoDao;
import com.gotop.mortgage.model.LoanInfo;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.Scan;
import com.gotop.mortgage.service.ILoanInfoService;
import com.gotop.reportjbpm.model.BjErrorNumReport;
import com.gotop.util.string.Obj2StrUtils;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public class LoanInfoService implements ILoanInfoService {

	private ILoanInfoDao loanInfoDao;
	
	public ILoanInfoDao getLoanInfoDao() {
		return loanInfoDao;
	}

	public void setLoanInfoDao(ILoanInfoDao loanInfoDao) {
		this.loanInfoDao = loanInfoDao;
	}

	@Override
    public List<LoanInfo> queryLoanInfoList(MUOUserSession muo, LoanInfo loanInfo, Page page) {
		List<LoanInfo> loanInfoLists =new ArrayList<LoanInfo>();
		Map<String, Object>map=new HashMap<String, Object>();
		
		//押品类型
		if (loanInfo.getMortgageType() !=null&&!"".equals(loanInfo.getMortgageType())) {
			map.put("mortgageType", loanInfo.getMortgageType());
	    }
		//查询时间
		if (loanInfo.getQueryTime() !=null&&!"".equals(loanInfo.getQueryTime())) {
				map.put("queryTime", loanInfo.getQueryTime());
		}
		
		//是否超限
		if (loanInfo.getWhetherOverrun() !=null&&!"".equals(loanInfo.getWhetherOverrun())) {
			map.put("whetherOverrun", loanInfo.getWhetherOverrun());
	    }
		
		if("0".equals(loanInfo.getMortgageType())){
			loanInfoLists =loanInfoDao.queryHouseLoanInfoList(map,page);
		}
		if("1".equals(loanInfo.getMortgageType())){
			loanInfoLists =loanInfoDao.queryCarLoanInfoList(map,page);
		}
		
		System.out.println("数据库中返回的记录个数："+loanInfoLists.size());

//		for (int i = 0; i < loanInfoLists.size(); i++) {
//			if(loanInfoLists.get(i).getOtherType()=="3"){
//				if(Double.valueOf(loanInfoLists.get(i).getAlreadyLoanDay())>90){
//					loanInfoLists.get(i).setWhetherOverrun("0");//超限
//				}else{
//					loanInfoLists.get(i).setWhetherOverrun("1");
//				}
//			}else{
//				if(Double.valueOf(loanInfoLists.get(i).getAlreadyLoanDay())>15){
//					loanInfoLists.get(i).setWhetherOverrun("0");//超限
//				}else{
//					loanInfoLists.get(i).setWhetherOverrun("1");
//				}
//			}
//			
//			
//		}
		return loanInfoLists;
	}
	
	
	@Override
	public List<LoanInfo> queryLoanInfoListForExcel(MUOUserSession muo, LoanInfo loanInfo) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List<LoanInfo> loanInfoLists=new ArrayList<LoanInfo>();
		Map<String, Object>map=new HashMap<String, Object>();
		
		String orgcode = muo.getOrgcode();
//		List list  = loanInfoDao.yesOrNot_dep(orgcode); //查询当前机构是部门还是机构
//		
//		if (list.size() != 0){
//			 HashMap<String, Object>  hp = (HashMap<String, Object>) list.get(0);
//			 if("no".equals(hp.get("IS_DEP"))) { //当前机构不是部门，说明是支行
//				 map.put("defaultOrgcode", hp.get("ORGCODE")); //查询列表默认显示本级及下级的数据
//			 }
//		}
		
		      //押品类型
				if (loanInfo.getMortgageType() !=null&&!"".equals(loanInfo.getMortgageType())) {
					map.put("mortgageType", loanInfo.getMortgageType());
			    }
				try {
				//查询时间
				if (loanInfo.getQueryTime() !=null&&!"".equals(loanInfo.getQueryTime())) {
						map.put("queryTime", sdf1.format(sdf.parse(loanInfo.getQueryTime())));
				}
				  } catch (ParseException e) {
						e.printStackTrace();
				}
				//是否超限
				if (loanInfo.getWhetherOverrun() !=null&&!"".equals(loanInfo.getWhetherOverrun())) {
					map.put("whetherOverrun", loanInfo.getWhetherOverrun());
			    }
		if("0".equals(loanInfo.getMortgageType())){
			loanInfoLists =loanInfoDao.queryHouseLoanInfoListForExcel(map);
		}
		if("1".equals(loanInfo.getMortgageType())){
			loanInfoLists =loanInfoDao.queryCarLoanInfoListForExcel(map);
		}
		
		return loanInfoLists;
	}
}
