package com.gotop.mortgage.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.struts2.ServletActionContext;
import com.gotop.mortgage.dao.IMortgageReserveDao;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveCar;
import com.gotop.mortgage.model.MortgageReserveHouse;
import com.gotop.mortgage.model.MortgageReserveOut;
import com.gotop.mortgage.model.MortgageReserveRes;
import com.gotop.mortgage.model.MortgageReserveUpdLog;
import com.gotop.mortgage.model.WarrantsFile;
import com.gotop.mortgage.service.IMortgageReserveService;
import com.gotop.util.FileUploadUtil;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public class MortgageReserveService implements IMortgageReserveService {

	private IMortgageReserveDao mortgageReserveDao;
	public IMortgageReserveDao getMortgageReserveDao() {
		return mortgageReserveDao;
	}
	public void setMortgageReserveDao(IMortgageReserveDao mortgageReserveDao) {
		this.mortgageReserveDao = mortgageReserveDao;
	}
	@Override
	public List<MortgageReserveRes> queryMortgageReserveList(
			MortgageReserve mortgageReserve,MortgageReserveHouse mortgageReserveHouse,MortgageReserveCar mortgageReserveCar, Page page) {
		List<MortgageReserveRes> mortgageReserveList =new ArrayList<MortgageReserveRes>();
		Map<String, Object>map=new HashMap<String, Object>();
		String mortgageType= mortgageReserve.getMortgageType();
		map.put("mortgageType", mortgageType);
		if(!"".equals(mortgageReserve.getProjectNumber())&&mortgageReserve.getProjectNumber()!=null){
			map.put("projectNumber", mortgageReserve.getProjectNumber());
		}
		if(!"".equals(mortgageReserve.getOtherType())&&mortgageReserve.getOtherType()!=null){
			map.put("otherType", mortgageReserve.getOtherType());
		}
		if(!"".equals(mortgageReserve.getStatus())&&mortgageReserve.getStatus()!=null){
			map.put("status", mortgageReserve.getStatus());
		}
		if(!"".equals(mortgageReserve.getBorrowerName())&&mortgageReserve.getBorrowerName()!=null){
			map.put("borrowerName", mortgageReserve.getBorrowerName());
		}
		if(!"".equals(mortgageReserve.getBorrowerCardNo())&&mortgageReserve.getBorrowerCardNo()!=null){
			map.put("borrowerCardNo", mortgageReserve.getBorrowerCardNo());
		}
		if("1".equals(mortgageType)){
			if(!"".equals(mortgageReserveHouse.getPropertyName())&&mortgageReserveHouse.getPropertyName()!=null){
				map.put("propertyName", mortgageReserveHouse.getPropertyName());
			}
			if(!"".equals(mortgageReserveHouse.getPropertyCardNo())&&mortgageReserveHouse.getPropertyCardNo()!=null){
				map.put("propertyCardNo", mortgageReserveHouse.getPropertyCardNo());
			}
			if(!"".equals(mortgageReserveHouse.getPropertyNo())&&mortgageReserveHouse.getPropertyNo()!=null){
				map.put("propertyNo", mortgageReserveHouse.getPropertyNo());
			}
			if(!"".equals(mortgageReserve.getOtherWarrantsNumber())&&mortgageReserve.getOtherWarrantsNumber()!=null){
				map.put("otherWarrantsNumber", mortgageReserve.getOtherWarrantsNumber());
			}
			if(!"".equals(mortgageReserveHouse.getPropertyAddres())&&mortgageReserveHouse.getPropertyAddres()!=null){
				map.put("propertyAddres", mortgageReserveHouse.getPropertyAddres());
			}
			if(!"".equals(mortgageReserve.getLoanType())&&mortgageReserve.getLoanType()!=null){
				map.put("loanType", mortgageReserve.getLoanType());
			}
			if(!"".equals(mortgageReserve.getOrgCode())&&mortgageReserve.getOrgCode()!=null){
				map.put("orgCode", mortgageReserve.getOrgCode());
			}
			if(!"".equals(mortgageReserve.getNoRegisterSign())&&mortgageReserve.getNoRegisterSign()!=null){
				map.put("noRegisterSign", mortgageReserve.getNoRegisterSign());
			}
			if("1".equals(mortgageReserve.getLogOutSign())){
				map.put("status", "2");
				map.put("afterMortgageStatus", "2");
			}
		}else if("2".equals(mortgageType)){
			if(!"".equals(mortgageReserveCar.getCarRegisterNo())&&mortgageReserveCar.getCarRegisterNo()!=null){
				map.put("carRegisterno", mortgageReserveCar.getCarRegisterNo());
			}
			if(!"".equals(mortgageReserveCar.getCarNo())&&mortgageReserveCar.getCarNo()!=null){
				map.put("carNo", mortgageReserveCar.getCarNo());
			}
			if(!"".equals(mortgageReserveCar.getCarFrameNo())&&mortgageReserveCar.getCarFrameNo()!=null){
				map.put("carFrameNo", mortgageReserveCar.getCarFrameNo());
			}
			if(!"".equals(mortgageReserveCar.getCarInvoiceNo())&&mortgageReserveCar.getCarInvoiceNo()!=null){
				map.put("carInvoiceNo", mortgageReserveCar.getCarInvoiceNo());
			}
			if(!"".equals(mortgageReserveCar.getCarDuesNo())&&mortgageReserveCar.getCarDuesNo()!=null){
				map.put("carDuesNo", mortgageReserveCar.getCarDuesNo());
			}
			if(!"".equals(mortgageReserveCar.getCarSafeNo())&&mortgageReserveCar.getCarSafeNo()!=null){
				map.put("carSafeNo", mortgageReserveCar.getCarSafeNo());
			}
		}
		mortgageReserveList=mortgageReserveDao.queryMortgageReserveList(map, page);
		return mortgageReserveList;
	}
	@Override
	public String checkOtherWarrantsNumber(MortgageReserve mortgageReserve) {
        String reslutNums="fails";
        String proNums="";
        String othNums="";
		Map<String, Object>map=new HashMap<String, Object>();
		try {
			if(mortgageReserve.getOtherWarrantsNumber()!= null && !"".equals(mortgageReserve.getOtherWarrantsNumber())){
				map.put("otherWarrantsNumber",mortgageReserve.getOtherWarrantsNumber());
			}
			if(mortgageReserve.getProjectNumber()!= null && !"".equals(mortgageReserve.getProjectNumber())){
				map.put("projectNumber",mortgageReserve.getProjectNumber());
			}
			if(mortgageReserve.getMortgageType()!= null && !"".equals(mortgageReserve.getMortgageType())){
				map.put("mortgageType",mortgageReserve.getMortgageType());
			}
			othNums=mortgageReserveDao.checkOtherWarrantsNumber(map);
			proNums=mortgageReserveDao.checkProjectNumber(map);
			if("0".equals(othNums)&&"0".equals(proNums)){
				return reslutNums="0";
			}
			if(!"0".equals(othNums)&&!"0".equals(proNums)){
				return reslutNums="twofails";
			}
			if(!"0".equals(othNums)){
				reslutNums="othfails";
			}
			if(!"0".equals(proNums)){
				reslutNums="profails";
			}
		} catch (Exception e) {
			reslutNums="fails";
			e.printStackTrace();
		}
		return reslutNums;
	}
	
	@Override
	public boolean insertItemALL(MortgageReserve mortgageReserve,
			MortgageReserveHouse mortgageReserveHouse,
			MortgageReserveCar mortgageReserveCar, File[] files,
			String[] filesFileName, MUOUserSession muo) throws Exception{
		Map<String, Object>map=new HashMap<String, Object>();
		Map<String, Object>mapHouse=new HashMap<String, Object>();
		Map<String, Object>mapCar=new HashMap<String, Object>();
		HashMap<String, String>hmp=new HashMap<String, String>();
		boolean result=false;
		try {
			//获取权证信息表id
			hmp.put("seqName", "seq_t_warrants_info");
			Long pkey = mortgageReserveDao.getNextSeqVal(hmp);
			Long userID=muo.getEmpid();
			Date d=new Date();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
			String inserttime = sdf2.format(d);  //此时的survey_time格式为yyyyMMddHHmmss， 如：20160217000000
    		String address=ServletActionContext.getServletContext().getRealPath("/uploadWarrantsInfofileName");
			map=resMortgageReserveMap(pkey,mortgageReserve,inserttime,muo);
			result=mortgageReserveDao.insertMortgage(map);
            try {
   	    		 //上传文件,不为空时
            	 if(filesFileName!=null&&!"".equals(filesFileName.toString())){
       	    		 uploadFileName(files, filesFileName, address,pkey,userID);
            	 }
   				 
				} catch (Exception e) {
					result=false;
					e.printStackTrace();
			}
    		if(result){
    			String mortgageType= mortgageReserve.getMortgageType();
    			String nextName=mortgageReserve.getNextName();
    			HashMap<String, String> hmpkey=new HashMap<String, String>();
    			Long idKey = null;
    			String logName="";
    			String houseWarrantsNums="1";
    			//判断押品类型
    			if("1".equals(mortgageType)){
    				houseWarrantsNums=mortgageReserveHouse.getPropertyNums();
    				hmpkey.put("seqName", "seq_t_mortgage_house_info");
    				idKey = mortgageReserveDao.getNextSeqVal(hmpkey);
        			mapHouse=resMortgageReserveHouseMap(idKey,pkey, mortgageReserveHouse);
        			result=mortgageReserveDao.insertMortgageHouse(mapHouse);
        			logName="新增入库押品类型为房产时";
    			}else if("2".equals(mortgageType)){
    				houseWarrantsNums="1";
    				hmpkey.put("seqName", "seq_t_mortgage_car_info");
    				idKey = mortgageReserveDao.getNextSeqVal(hmpkey);
        			mapCar=resMortgageReserveCarMap(idKey,pkey, mortgageReserveCar);
        			result=mortgageReserveDao.insertMortgageCar(mapCar);
        			logName="新增入库押品类型为机动车时";
    			}
				if(result){
					String operatingType="4";//新增入库
					updMortgageReserveOutMap(idKey,pkey,inserttime,houseWarrantsNums,nextName,logName);
					//插入日志
					result=insertMortgageOperatingLog(operatingType, userID, pkey, inserttime, logName);
				}
				
			}
    		
		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	


	@Override
	public boolean insertCollateralHouse(
			Long pkey,MortgageReserveHouse mortgageReserveHouse, MUOUserSession muo) throws Exception {
		Map<String, Object>mapHouse=new HashMap<String, Object>();
		HashMap<String, String>hmpkey=new HashMap<String, String>();
		boolean result=false;
		try {
			hmpkey.put("seqName", "seq_t_mortgage_house_info");
		    Long idKey = mortgageReserveDao.getNextSeqVal(hmpkey);
			mapHouse=resMortgageReserveHouseMap(idKey,pkey, mortgageReserveHouse);
			result=mortgageReserveDao.insertMortgageHouse(mapHouse);
			if(result){
				String operatingType="4";//新增入库
				Long userID=muo.getEmpid();
				Date d=new Date();
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
				String inserttime = sdf2.format(d);  //此时的survey_time格式为yyyyMMddHHmmss， 如：20160217000000
				updMortgageReserveOutMap(idKey,pkey,inserttime,mortgageReserveHouse.getPropertyNums(),mortgageReserveHouse.getPropertyName(),"添加房产押品信息");
				//插入日志
				result=insertMortgageOperatingLog(operatingType, userID, pkey, inserttime, "添加房产押品信息");
			}
		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean insertCollateralCar(Long pkey,MortgageReserveCar mortgageReserveCar,
			MUOUserSession muo) throws Exception{
		Map<String, Object>mapCar=new HashMap<String, Object>();
		HashMap<String, String>hmpkey=new HashMap<String, String>();
		boolean result=false;
		try {
			hmpkey.put("seqName", "seq_t_mortgage_house_info");
		    Long idKey = mortgageReserveDao.getNextSeqVal(hmpkey);
			mapCar=resMortgageReserveCarMap(idKey,pkey, mortgageReserveCar);
			result=mortgageReserveDao.insertMortgageCar(mapCar);
			if(result){
				String operatingType="4";//新增入库
				Long userID=muo.getEmpid();
				Date d=new Date();
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
				String inserttime = sdf2.format(d);  //此时的survey_time格式为yyyyMMddHHmmss， 如：20160217000000
				//插入日志
				updMortgageReserveOutMap(idKey,pkey,inserttime,"1",mortgageReserveCar.getCarName(),"添加房产押品信息");
				result=insertMortgageOperatingLog(operatingType, userID, pkey, inserttime, "添加房产押品信息");
			}
		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updCollAll(MortgageReserve mortgageReserve,
			MortgageReserveHouse mortgageReserveHouse,
			MortgageReserveCar mortgageReserveCar, File[] files,
			String[] filesFileName, MUOUserSession muo) {
		Map<String, Object>map=new HashMap<String, Object>();
		boolean result=false;
		try {
			Long pkey=Long.valueOf(mortgageReserve.getId());
			Long userID=muo.getEmpid();
			Date d=new Date();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
			String inserttime = sdf2.format(d);  //此时的survey_time格式为yyyyMMddHHmmss， 如：20160217000000
    		String address=ServletActionContext.getServletContext().getRealPath("/uploadWarrantsInfofileName");
			map=resMortgageReserveMap(pkey,mortgageReserve,inserttime, muo);
			String mortgageType= mortgageReserve.getMortgageType();
			//判断是否已经有记录了
			isLog(pkey,mortgageType);
			String empName=muo.getEmpname();
			resMortgageReserveLogMap(mortgageReserve,mortgageReserveHouse,mortgageReserveCar,empName,userID);
			result=mortgageReserveDao.updMortgage(map);
            try {
   	    		 //上传文件,不为空时
            	 if(filesFileName!=null&&!"".equals(filesFileName.toString())){
       	    		 uploadFileName(files, filesFileName, address,pkey,userID);
            	 }
   				 
				} catch (Exception e) {
					result=false;
					e.printStackTrace();
			}
    		if(result){
				String logName= "库存变更押品类型为房产时";
				if("1".equals(mortgageType)){
	    			if(mortgageReserveHouse.getId()!=null&&mortgageReserveHouse.getId()!=""){
	          		  result=updateMortgageHouse(mortgageReserveHouse);
	      			}
					
				}else if("2".equals(mortgageType)){
					if(mortgageReserveCar.getId()!=null&&mortgageReserveCar.getId()!=""){
		    		  result=updateMortgageCar( mortgageReserveCar);
	          		  logName="库存变更押品类型为机动车时";
		    		}
				}
				if(result){
					String operatingType="3";//库存变更
					//插入日志
					result=insertMortgageOperatingLog(operatingType, userID, pkey, inserttime, logName);
				}
				
			}
		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	//判断是否已经有记录
	public void updMortgageReserveOutMap(Long idKey,Long pkey,String insertTime, 
			String houseWarrantsNums,String nextName,String logName){
		try {
			Map<String, Object>map=new HashMap<String, Object>();
			MortgageReserveOut mortgageReserveOut=new MortgageReserveOut();
			mortgageReserveOut.setWarrantsId(String.valueOf(pkey));
			mortgageReserveOut.setBorrowerNums("0");//外借数量标志为0
			mortgageReserveOut.setBorrowerLog("5");//新增入库
			mortgageReserveOut.setOperatingMatters("5");//新增入库
			mortgageReserveOut.setRemark(logName);
			mortgageReserveOut.setInsertTime(insertTime);
			mortgageReserveOut.setOperatingId(String.valueOf(idKey));
			mortgageReserveOut.setOutInType("2");//入库
			mortgageReserveOut.setNextName(nextName);
			mortgageReserveOut.setLogRemark(houseWarrantsNums);
			map=resMortgageReserveOutMap(mortgageReserveOut);
			mortgageReserveDao.insertMortgageReserveOutMap(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 判断是否已经有记录
	 * @param pkey
	 * @param mortgageType
	 */
	public void isLog(Long pkey,String mortgageType){
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("warrantsId", pkey);
		map.put("mortgageType", mortgageType);
		String reslut=mortgageReserveDao.checkIsUpdLog(map);
		if("0".equals(reslut)){
			mortgageReserveDao.insertMortgageUpdLogSelect(map);
		}
	}
	
	
	/**
	 * 更新押品信息押品类型为房产时
	 * @param pkey
	 * @param mortgageReserveHouse
	 * @return
	 * @throws Exception
	 */
	public boolean updateMortgageHouse(MortgageReserveHouse mortgageReserveHouse)  throws Exception{
		boolean result=false;
		try {
			String [] resId=mortgageReserveHouse.getId().split(",");
			String [] resPropertyAddres=mortgageReserveHouse.getPropertyAddres().split(",");
			String [] resPropertyCardNo=mortgageReserveHouse.getPropertyCardNo().split(",");
			String [] resPropertyDate=mortgageReserveHouse.getPropertyDate().split(",");
			String [] resPropertyName=mortgageReserveHouse.getPropertyName().split(",");
			String [] resPropertyNo=mortgageReserveHouse.getPropertyNo().split(",");
			String [] resPropertyNums=mortgageReserveHouse.getPropertyNums().split(",");
			for (int i = 0; i <resId.length; i++) {
				Map<String, Object>map=new HashMap<String, Object>();
				map.put("id", resId[i].trim());
				map.put("propertyNo", resPropertyNo[i].trim());
				map.put("propertyName",resPropertyName[i].trim());
				map.put("propertyCardNo", resPropertyCardNo[i].trim());
				map.put("propertyAddres", resPropertyAddres[i].trim());
				String temp=resPropertyNums[i].trim();
				if("".equals(temp)||temp==null){
					temp="0";
				}
				map.put("propertyNums", temp);
				map.put("propertyDate", resPropertyDate[i].trim());
				result=mortgageReserveDao.updMortgageHouse(map);
			}
			result=true;
		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	

	/**
	 * 更新押品信息押品类型为机动车时
	 * @param pkey
	 * @param mortgageReserveHouse
	 * @return
	 * @throws Exception
	 */
	public boolean updateMortgageCar(MortgageReserveCar mortgageReserveCar)  throws Exception{
		boolean result=false;
		try {
			String [] resId=mortgageReserveCar.getId().split(",");
			String [] resCarCardNo=mortgageReserveCar.getCarCardNo().split(",");
			String [] resCarDuesNo=mortgageReserveCar.getCarDuesNo().split(",");
			String [] resCarFrameNo=mortgageReserveCar.getCarFrameNo().split(",");
			String [] resCarInvoiceNo=mortgageReserveCar.getCarInvoiceNo().split(",");
			String [] resCarName=mortgageReserveCar.getCarName().split(",");
			String [] resCarNo=mortgageReserveCar.getCarNo().split(",");
			String [] resCarRegisterNo=mortgageReserveCar.getCarRegisterNo().split(",");
			String [] resCarSafeNo=mortgageReserveCar.getCarSafeNo().split(",");
			for (int i = 0; i <resId.length; i++) {
				Map<String, Object>map=new HashMap<String, Object>();
				map.put("id", resId[i].trim());
				map.put("carName", resCarName[i].trim());
				map.put("carCardNo", resCarCardNo[i].trim());
				map.put("carRegisterNo",resCarRegisterNo[i].trim());
				map.put("carNo", resCarNo[i].trim());
				map.put("carFrameNo", resCarFrameNo[i].trim());
				map.put("carInvoiceNo",resCarInvoiceNo[i].trim());
				map.put("carDuesNo", resCarDuesNo[i].trim());
				map.put("carSafeNo", resCarSafeNo[i].trim());
				result=mortgageReserveDao.updMortgageCar(map);
			}
			result=true;
		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * 生成库存变更日志记录值
	 * @param pkey
	 * @param mortgageReserve
	 * @return
	 */
	public void resMortgageReserveLogMap(MortgageReserve mortgageReserve,
			MortgageReserveHouse mortgageReserveHouse,
			MortgageReserveCar mortgageReserveCar,String empName,Long userId)  throws Exception{
		Map<String, Object>map=new HashMap<String, Object>();
		try {
			String mortgageType= mortgageReserve.getMortgageType();
			map.put("warrantsId", mortgageReserve.getId());
			map.put("mortgageType", mortgageReserve.getMortgageType());
			if("".equals(mortgageReserve.getOtherType())||mortgageReserve.getOtherType()==null){
				if("1".equals(mortgageType)){
					if("".equals(mortgageReserve.getOtherTypeFC())||mortgageReserve.getOtherTypeFC()==null){
						mortgageReserve.setOtherType("3"); //他项类型  3：预告登记证明
					}else{
						mortgageReserve.setOtherType(mortgageReserve.getOtherTypeFC());
					}
					if("".equals(mortgageReserve.getLoanTypeFC())||mortgageReserve.getLoanTypeFC()==null){
						mortgageReserve.setLoanType("6");//贷款种类 6:小企业  ,旧数据处理
					}else{
						mortgageReserve.setLoanType(mortgageReserve.getLoanTypeFC());
					}
				}else if ("2".equals(mortgageType)){
					mortgageReserve.setOtherType(mortgageReserve.getOtherTypeJDC());
					mortgageReserve.setLoanType(mortgageReserve.getLoanTypeJDC());
				}
		    }
			map.put("noticeRegisterRelation", mortgageReserve.getNoticeRegisterRelation());
			map.put("projectNumber", mortgageReserve.getProjectNumber());
			map.put("otherWarrantsNumber", mortgageReserve.getOtherWarrantsNumber());
			map.put("otherWarrantsDate", mortgageReserve.getOtherWarrantsDate());
			map.put("borrowerName", mortgageReserve.getBorrowerName());
			map.put("borrowerCardNo", mortgageReserve.getBorrowerCardNo());
			map.put("orgCode", mortgageReserve.getOrgCode());
			map.put("orgName", mortgageReserve.getOrgCode());
			map.put("mangerName", mortgageReserve.getMangerName());
			map.put("borrowerContractNo", mortgageReserve.getBorrowerContractNo());
			map.put("loanYears", mortgageReserve.getLoanYears());
			map.put("recordValue", mortgageReserve.getRecordValue());
			map.put("packetNumber", mortgageReserve.getPacketNumber());
			map.put("nextName", mortgageReserve.getNextName());
			map.put("purchaseNumber", mortgageReserve.getPurchaseNumber());
			map.put("remark", mortgageReserve.getRemark());
			//map.put("noRegisterSign", mortgageReserve.getNoRegisterSign());
			//map.put("status", mortgageReserve.getStatus());
			map.put("otherType", mortgageReserve.getOtherType());
			map.put("loanType", mortgageReserve.getLoanType());
			map.put("empName", empName);
			map.put("empId", userId);
			if("1".equals(mortgageType)){
				String [] resId=mortgageReserveHouse.getId().split(",");
				String [] resPropertyAddres=mortgageReserveHouse.getPropertyAddres().split(",");
				String [] resPropertyCardNo=mortgageReserveHouse.getPropertyCardNo().split(",");
				String [] resPropertyDate=mortgageReserveHouse.getPropertyDate().split(",");
				String [] resPropertyName=mortgageReserveHouse.getPropertyName().split(",");
				String [] resPropertyNo=mortgageReserveHouse.getPropertyNo().split(",");
				String [] resPropertyNums=mortgageReserveHouse.getPropertyNums().split(",");
				for (int i = 0; i <resId.length; i++) {
					map.put("propertyNo", resPropertyNo[i].trim());
					map.put("propertyName",resPropertyName[i].trim());
					map.put("propertyCardNo", resPropertyCardNo[i].trim());
					map.put("propertyAddres", resPropertyAddres[i].trim());
					String temp=resPropertyNums[i].trim();
					if("".equals(temp)||temp==null){
						temp="0";
					}
					map.put("propertyNums", temp);
					map.put("propertyDate", resPropertyDate[i].trim());
					mortgageReserveDao.insertMortgageUpdLog(map);
				}
			}else if ("2".equals(mortgageType)){
				String [] resId=mortgageReserveCar.getId().split(",");
				String [] resCarCardNo=mortgageReserveCar.getCarCardNo().split(",");
				String [] resCarDuesNo=mortgageReserveCar.getCarDuesNo().split(",");
				String [] resCarFrameNo=mortgageReserveCar.getCarFrameNo().split(",");
				String [] resCarInvoiceNo=mortgageReserveCar.getCarInvoiceNo().split(",");
				String [] resCarName=mortgageReserveCar.getCarName().split(",");
				String [] resCarNo=mortgageReserveCar.getCarNo().split(",");
				String [] resCarRegisterNo=mortgageReserveCar.getCarRegisterNo().split(",");
				String [] resCarSafeNo=mortgageReserveCar.getCarSafeNo().split(",");
				for (int i = 0; i <resId.length; i++) {
					map.put("carName", resCarName[i].trim());
					map.put("carCardNo", resCarCardNo[i].trim());
					map.put("carRegisterNo",resCarRegisterNo[i].trim());
					map.put("carNo", resCarNo[i].trim());
					map.put("carFrameNo", resCarFrameNo[i].trim());
					map.put("carInvoiceNo",resCarInvoiceNo[i].trim());
					map.put("carDuesNo", resCarDuesNo[i].trim());
					map.put("carSafeNo", resCarSafeNo[i].trim());
					mortgageReserveDao.insertMortgageUpdLog(map);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	/**
	 * 生成MortgageReserveMap值
	 * @param pkey
	 * @param mortgageReserve
	 * @return
	 */
	public Map<String, Object> resMortgageReserveMap(Long pkey,MortgageReserve mortgageReserve,String inserttime,MUOUserSession muo)  throws Exception{
		Map<String, Object>map=new HashMap<String, Object>();
		try {
			String mortgageType= mortgageReserve.getMortgageType();
			map.put("id", pkey);
			map.put("mortgageType", mortgageReserve.getMortgageType());
			if("".equals(mortgageReserve.getOtherType())||mortgageReserve.getOtherType()==null){
				if("1".equals(mortgageType)){
					if("".equals(mortgageReserve.getOtherTypeFC())||mortgageReserve.getOtherTypeFC()==null){
						mortgageReserve.setOtherType("3"); //他项类型  3：预告登记证明
					}else{
						mortgageReserve.setOtherType(mortgageReserve.getOtherTypeFC());
					}
					if("".equals(mortgageReserve.getLoanTypeFC())||mortgageReserve.getLoanTypeFC()==null){
						mortgageReserve.setLoanType("6");//贷款种类 6:小企业  ,旧数据处理
					}else{
						mortgageReserve.setLoanType(mortgageReserve.getLoanTypeFC());
					}
				}else if ("2".equals(mortgageType)){
					mortgageReserve.setOtherType(mortgageReserve.getOtherTypeJDC());
					mortgageReserve.setLoanType(mortgageReserve.getLoanTypeJDC());
//					if("".equals(mortgageReserve.getLoanTypeJDC())||mortgageReserve.getLoanTypeJDC()==null){
//						mortgageReserve.setLoanType("8");//贷款种类 8:经营性车辆贷款  ,旧数据处理
//					}else{
//						mortgageReserve.setLoanType(mortgageReserve.getLoanTypeJDC());
//					}
				}
		    }
			map.put("noticeRegisterRelation", mortgageReserve.getNoticeRegisterRelation());
			map.put("projectNumber", mortgageReserve.getProjectNumber());
			map.put("otherWarrantsNumber", mortgageReserve.getOtherWarrantsNumber());
			map.put("otherWarrantsDate", mortgageReserve.getOtherWarrantsDate());
			map.put("borrowerName", mortgageReserve.getBorrowerName());
			map.put("borrowerCardNo", mortgageReserve.getBorrowerCardNo());
			map.put("orgCode", mortgageReserve.getOrgCode());
			map.put("orgName", mortgageReserve.getOrgName());
			map.put("mangerName", mortgageReserve.getMangerName());
			map.put("borrowerContractNo", mortgageReserve.getBorrowerContractNo());
			map.put("loanYears", mortgageReserve.getLoanYears());
			map.put("recordValue", mortgageReserve.getRecordValue());
			map.put("packetNumber", mortgageReserve.getPacketNumber());
			map.put("nextName", mortgageReserve.getNextName());
			map.put("purchaseNumber", mortgageReserve.getPurchaseNumber());
			map.put("remark", mortgageReserve.getRemark());
			map.put("noRegisterSign", mortgageReserve.getNoRegisterSign());
			map.put("status", mortgageReserve.getStatus());
			map.put("inserttime", inserttime);
			map.put("empId", muo.getEmpid());
			map.put("empName", muo.getEmpname());
			map.put("otherType", mortgageReserve.getOtherType());
			map.put("loanType", mortgageReserve.getLoanType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
		
	}
	
	
	/**
	 * 生成房产类型Map值
	 * @param pkey
	 * @param mortgageReserve
	 * @return
	 */
	public Map<String, Object> resMortgageReserveHouseMap(Long idKey,Long pkey,MortgageReserveHouse mortgageReserveHouse) throws Exception{
		Map<String, Object>map=new HashMap<String, Object>();
		try {
			map.put("id", idKey);
			map.put("warrantsId", pkey);
			map.put("propertyNo", mortgageReserveHouse.getPropertyNo());
			map.put("propertyName", mortgageReserveHouse.getPropertyName());
			map.put("propertyCardNo", mortgageReserveHouse.getPropertyCardNo());
			map.put("propertyAddres", mortgageReserveHouse.getPropertyAddres());
			map.put("propertyNums", mortgageReserveHouse.getPropertyNums());
			map.put("propertyDate", mortgageReserveHouse.getPropertyDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
		
	}
	
	
	/**
	 * 生成机动车Map值
	 * @param pkey
	 * @param mortgageReserve
	 * @return
	 */
	public Map<String, Object> resMortgageReserveCarMap(Long idKey,Long pkey,MortgageReserveCar mortgageReserveCar) throws Exception{
		Map<String, Object>map=new HashMap<String, Object>();
		try {
			map.put("id", idKey);
			map.put("warrantsId", pkey);
			map.put("carName", mortgageReserveCar.getCarName());
			map.put("carCardNo", mortgageReserveCar.getCarCardNo());
			map.put("carRegisterNo", mortgageReserveCar.getCarRegisterNo());
			map.put("carNo", mortgageReserveCar.getCarNo());
			map.put("carFrameNo", mortgageReserveCar.getCarFrameNo());
			map.put("carInvoiceNo", mortgageReserveCar.getCarInvoiceNo());
			map.put("carDuesNo", mortgageReserveCar.getCarDuesNo());
			map.put("carSafeNo", mortgageReserveCar.getCarSafeNo());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
		
	}
	
	/**
	 * 生成库存处理Map值
	 * @param pkey
	 * @param mortgageReserve
	 * @return
	 */
	public Map<String, Object> resMortgageReserveOutMap(MortgageReserveOut mortgageReserveOut) throws Exception{
		Map<String, Object>map=new HashMap<String, Object>();
		try {
			map.put("warrantsId", mortgageReserveOut.getWarrantsId());
			map.put("borrowerNums", mortgageReserveOut.getBorrowerNums());
			if("1".equals(mortgageReserveOut.getOutInType())){
                
				if("1".equals(mortgageReserveOut.getOperatingMatters())||"2".equals(mortgageReserveOut.getOperatingMatters()))
				{
					map.put("borrowerLog", mortgageReserveOut.getOperatingMatters());
				}
				
			}else if ("2".equals(mortgageReserveOut.getOutInType())){
				
				if("1".equals(mortgageReserveOut.getOperatingMatters()))
				{
					map.put("borrowerLog", "3");//外借已归还
				}
				if("2".equals(mortgageReserveOut.getOperatingMatters()))
				{
					map.put("borrowerLog", "4");//注销已完成
				}
			}
			//默认他項都是为1，产权证数为实际填写所有
			String otherWarrantsNums="1";
			String houseWarrantsNums=mortgageReserveOut.getLogRemark();
			//外借和领取时,他项数、产权证数都是为0
			if("1".equals(mortgageReserveOut.getOperatingMatters())||"4".equals(mortgageReserveOut.getOperatingMatters())){
				otherWarrantsNums="0";
				houseWarrantsNums="0";
			}
			if("5".equals(mortgageReserveOut.getOperatingMatters())){
				otherWarrantsNums="1";
			}
			map.put("houseWarrantsNums",houseWarrantsNums);
			map.put("otherWarrantsNums", otherWarrantsNums);
			map.put("operatingMatters", mortgageReserveOut.getOperatingMatters());
			map.put("remark", mortgageReserveOut.getRemark());
			map.put("operatingId", mortgageReserveOut.getOperatingId());
			map.put("insertTime", mortgageReserveOut.getInsertTime());
			if(!"".equals(mortgageReserveOut.getNextName())&&mortgageReserveOut.getNextName()!=null){
				map.put("nextName", mortgageReserveOut.getNextName());
			}else{
				map.put("nextName", mortgageReserveOut.getProNextName());
			}
			map.put("outInType", mortgageReserveOut.getOutInType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
		
	}
	/**
	 * 上传多个文件
	 * @param files
	 * @param filesFileName
	 * @param address
	 * @throws Exception
	 */
	public void uploadFileName(File[] files,String[] filesFileName,String address,Long pkey,Long userID) throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
  		 String fileDate=sdf.format(new Date());//时间
			 for(int i=0;i<filesFileName.length;i++){
	    		 String uuid = UUID.randomUUID().toString();//UUID
	    		 String suffixStr = filesFileName[i].substring(filesFileName[i].indexOf("."), filesFileName[i].length());//获取后缀名
	    		 FileUploadUtil.uploadFile(uuid, fileDate, address, filesFileName[i], files[i], suffixStr);
	    		 String filePath=address+File.separator+fileDate+File.separator+uuid+suffixStr;
	    		 String fileReName=uuid+suffixStr;
	    		 insertMortgageFile(pkey,userID,filesFileName[i],filePath,fileReName);
	       	 }
	}
	/**
	 * 插入上传文件表
	 * @param pkey
	 * @param userID
	 * @param filesFileName
	 * @param filePath
	 * @param fileReName
	 */
	public void insertMortgageFile(Long pkey,Long userID, String filesFileName, String filePath,String fileReName){
		Map<String, Object>map=new HashMap<String, Object>();
		try {
			map.put("warrantsId", pkey);
			map.put("fileName", filesFileName);
			map.put("filePath", filePath);
			map.put("userID", userID);
			map.put("fileReName", fileReName);
			mortgageReserveDao.insertMortgageFile(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 插入日志表信息
	 * @param operatingType 操作类型
	 * @param userID   操作人员id
	 * @param pkey    操作主表ID
	 * @param inserttime  插入时间与插入信息时间保持一致
	 * @param remark  备注
	 * @return
	 * @throws Exception
	 */
	public boolean insertMortgageOperatingLog(String operatingType,Long userID,Long pkey,String inserttime,String remark) throws Exception{
		Map<String, Object>map=new HashMap<String, Object>();
		boolean result=false;
		try {
			map.put("inserttime", inserttime);
			map.put("userID", userID);
			map.put("operatingType", operatingType);
			map.put("warrantsId", pkey);
			map.put("remark", remark);
			result=mortgageReserveDao.insertMortgageLog(map);
		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public MortgageReserve queryMortgageReserveListInfo(String id,String mortgageType) {
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("id", id);
		map.put("mortgageType", mortgageType);
		MortgageReserve mortgageReserve=mortgageReserveDao.queryMortgageReserveListInfo(map);
		return mortgageReserve;
	}
	@Override
	public List<MortgageReserveHouse> queryMortgageReserveListHouseInfo(String id) {
		Map<String, Object>map=new HashMap<String, Object>();
		List<MortgageReserveHouse> mortgageReserveList =new ArrayList<MortgageReserveHouse>();
		map.put("id", id);
		mortgageReserveList=mortgageReserveDao.queryMortgageReserveListHouseInfo(map);
		return mortgageReserveList;
	}
	@Override
	public List<MortgageReserveCar> queryMortgageReserveListCarInfo(String id) {
		Map<String, Object>map=new HashMap<String, Object>();
		List<MortgageReserveCar> mortgageReserveList =new ArrayList<MortgageReserveCar>();
		map.put("id", id);
		mortgageReserveList=mortgageReserveDao.queryMortgageReserveListCarInfo(map);
		return mortgageReserveList;
	}
	@Override
	public List<WarrantsFile> queryFileByIdandType(Long id) {
		return mortgageReserveDao.queryFileByIdandType(id);
	}
	@Override
	public WarrantsFile getFileResource(String fileId) {
		return mortgageReserveDao.getFileResource(fileId);
	}
	
	@Override
	public boolean insertMortgageReserveOut(
			MortgageReserveOut mortgageReserveOut, MUOUserSession muo) {
		Map<String, Object>map=new HashMap<String, Object>();
		boolean result=false;
		try {
			long pkey=Long.valueOf(mortgageReserveOut.getWarrantsId());
			Date d=new Date();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
			String inserttime = sdf2.format(d);  //此时的survey_time格式为yyyyMMddHHmmss， 如：20160217000000
			mortgageReserveOut.setInsertTime(inserttime);
			//String remark=mortgageReserveOut.getRemark();
			String textNmae="产权证本数:"+mortgageReserveOut.getLogRemark();
			map=resMortgageReserveOutMap(mortgageReserveOut);
			result=mortgageReserveDao.insertMortgageReserveOutMap(map);
			if(result){
				String outInType=mortgageReserveOut.getOutInType();
				
				if("2".equals(outInType)){
					textNmae="机动车登记号:"+mortgageReserveOut.getLogRemark();
					if("1".equals(mortgageReserveOut.getOperatingMatters())){
						Map<String, Object>mapHouse=new HashMap<String, Object>();
						mapHouse.put("operatingId", mortgageReserveOut.getOperatingId());
						mapHouse.put("warrantsId", mortgageReserveOut.getWarrantsId());
						mortgageReserveDao.updMortgageOutIn(mapHouse);//入库归还时修改出库状态为已归还
						
					}
				}else if("1".equals(outInType)){
					//更改主表信息
					if("2".equals(mortgageReserveOut.getOperatingMatters())||"3".equals(mortgageReserveOut.getOperatingMatters())){
						Map<String, Object>mapHouse=new HashMap<String, Object>();
						mapHouse.put("id", mortgageReserveOut.getOperatingId());
						mortgageReserveDao.updMortgageHouseNums(mapHouse);
						mapHouse.put("id", mortgageReserveOut.getWarrantsId());//注销
						mapHouse.put("status", "2");//注销
						mortgageReserveDao.updMortgageStatus(mapHouse);
						if("3".equals(mortgageReserveOut.getOperatingMatters())){
							mapHouse.put("afterMortgageStatus", "1");//不在库
							mortgageReserveDao.updMortgageAfterMortgageStatus(mapHouse);
						}
					}
					//出库领取时
					if("4".equals(mortgageReserveOut.getOperatingMatters())){
						Map<String, Object>mapHouse=new HashMap<String, Object>();
						mapHouse.put("id", mortgageReserveOut.getWarrantsId());
						mapHouse.put("afterMortgageStatus", "3");//已领取
						mortgageReserveDao.updMortgageAfterMortgageStatus(mapHouse);
						
					}
				}
				Long userID=muo.getEmpid();
				//插入日志
				result=insertMortgageOperatingLog(outInType, userID, pkey, inserttime, textNmae);
			}
		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public String checkCarRegisterNo(MortgageReserveCar mortgageReserveCar) {
		 String reslutNums="fails";
	        String carNums="";
			Map<String, Object>map=new HashMap<String, Object>();
			try {
				if(mortgageReserveCar.getCarRegisterNo()!= null && !"".equals(mortgageReserveCar.getCarRegisterNo())){
					map.put("carRegisterNo",mortgageReserveCar.getCarRegisterNo());
				}
				carNums=mortgageReserveDao.checkCarRegisterNo(map);
				
				if(!"0".equals(carNums)){
					reslutNums="carfails";
				}
			} catch (Exception e) {
				reslutNums="fails";
				e.printStackTrace();
			}
			return reslutNums;
	}
	@Override
	public MortgageReserve openGenerate(MortgageReserve mortgageReserve) {
		Map<String, Object>map=new HashMap<String, Object>();
		if(!"".equals(mortgageReserve.getNoticeRegisterRelation())&& mortgageReserve.getNoticeRegisterRelation()!=null){
			map.put("projectNumber", mortgageReserve.getNoticeRegisterRelation());
		}
		if(!"".equals(mortgageReserve.getMortgageType())&& mortgageReserve.getMortgageType()!=null){
			map.put("mortgageType", mortgageReserve.getMortgageType());
		}
		MortgageReserve mortgageReserves=mortgageReserveDao.openGenerate(map);
		return mortgageReserves;
	}
	@Override
	public List<MortgageReserveRes> queryMortgageReserveAllList(
			MortgageReserveRes mortgageReserveRes) {
		Map<String, Object>map=new HashMap<String, Object>();
		List<MortgageReserveRes> mortgageReserveList =new ArrayList<MortgageReserveRes>();
		String id=mortgageReserveRes.getWarrantsId();
		String mortgageType=mortgageReserveRes.getMortgageType();
	    map.put("id", id);
		if(!"".equals(mortgageReserveRes.getBorrowerName())&&mortgageReserveRes.getBorrowerName()!=null){
			map.put("borrowerName", mortgageReserveRes.getBorrowerName());
		}
		if(!"".equals(mortgageReserveRes.getBorrowerCardNo())&&mortgageReserveRes.getBorrowerCardNo()!=null){
			map.put("borrowerCardNo", mortgageReserveRes.getBorrowerCardNo());
		}
		if("1".equals(mortgageType)){
			mortgageReserveList=mortgageReserveDao.queryMortgageReserveHouseList(map);
		}else if("2".equals(mortgageType)){
			mortgageReserveList=mortgageReserveDao.queryMortgageReserveCarList(map);
		}
		return mortgageReserveList;
	}
	@Override
	public List<MortgageReserveRes> queryMortgageReserveListExcel(
			MortgageReserve mortgageReserve,
			MortgageReserveHouse mortgageReserveHouse,
			MortgageReserveCar mortgageReserveCar) {
		List<MortgageReserveRes> mortgageReserveList =new ArrayList<MortgageReserveRes>();
		Map<String, Object>map=new HashMap<String, Object>();
		String mortgageType= mortgageReserve.getMortgageType();
		map.put("mortgageType", mortgageType);
		if(!"".equals(mortgageReserve.getProjectNumber())&&mortgageReserve.getProjectNumber()!=null){
			map.put("projectNumber", mortgageReserve.getProjectNumber());
		}
		if(!"".equals(mortgageReserve.getStatus())&&mortgageReserve.getStatus()!=null){
			map.put("status", mortgageReserve.getStatus());
		}
		if(!"".equals(mortgageReserve.getBorrowerName())&&mortgageReserve.getBorrowerName()!=null){
			map.put("borrowerName", mortgageReserve.getBorrowerName());
		}
		if(!"".equals(mortgageReserve.getBorrowerCardNo())&&mortgageReserve.getBorrowerCardNo()!=null){
			map.put("borrowerCardNo", mortgageReserve.getBorrowerCardNo());
		}
		if("1".equals(mortgageType)){
			if(!"".equals(mortgageReserveHouse.getPropertyName())&&mortgageReserveHouse.getPropertyName()!=null){
				map.put("propertyName", mortgageReserveHouse.getPropertyName());
			}
			if(!"".equals(mortgageReserveHouse.getPropertyCardNo())&&mortgageReserveHouse.getPropertyCardNo()!=null){
				map.put("propertyCardNo", mortgageReserveHouse.getPropertyCardNo());
			}
			if(!"".equals(mortgageReserveHouse.getPropertyNo())&&mortgageReserveHouse.getPropertyNo()!=null){
				map.put("propertyNo", mortgageReserveHouse.getPropertyNo());
			}
			if(!"".equals(mortgageReserve.getOtherWarrantsNumber())&&mortgageReserve.getOtherWarrantsNumber()!=null){
				map.put("otherWarrantsNumber", mortgageReserve.getOtherWarrantsNumber());
			}
			if(!"".equals(mortgageReserveHouse.getPropertyAddres())&&mortgageReserveHouse.getPropertyAddres()!=null){
				map.put("propertyAddres", mortgageReserveHouse.getPropertyAddres());
			}
			if(!"".equals(mortgageReserve.getLoanType())&&mortgageReserve.getLoanType()!=null){
				map.put("loanType", mortgageReserve.getLoanType());
			}
			if(!"".equals(mortgageReserve.getOrgCode())&&mortgageReserve.getOrgCode()!=null){
				map.put("orgCode", mortgageReserve.getOrgCode());
			}
			if(!"".equals(mortgageReserve.getNoRegisterSign())&&mortgageReserve.getNoRegisterSign()!=null){
				map.put("noRegisterSign", mortgageReserve.getNoRegisterSign());
			}
			if("1".equals(mortgageReserve.getLogOutSign())){
				map.put("status", "2");
				map.put("afterMortgageStatus", "2");
			}
			mortgageReserveList=mortgageReserveDao.queryMortgageReserveListExcel(map);
		}else if("2".equals(mortgageType)){
			if(!"".equals(mortgageReserveCar.getCarRegisterNo())&&mortgageReserveCar.getCarRegisterNo()!=null){
				map.put("carRegisterno", mortgageReserveCar.getCarRegisterNo());
			}
			if(!"".equals(mortgageReserveCar.getCarNo())&&mortgageReserveCar.getCarNo()!=null){
				map.put("carNo", mortgageReserveCar.getCarNo());
			}
			if(!"".equals(mortgageReserveCar.getCarFrameNo())&&mortgageReserveCar.getCarFrameNo()!=null){
				map.put("carFrameNo", mortgageReserveCar.getCarFrameNo());
			}
			if(!"".equals(mortgageReserveCar.getCarInvoiceNo())&&mortgageReserveCar.getCarInvoiceNo()!=null){
				map.put("carInvoiceNo", mortgageReserveCar.getCarInvoiceNo());
			}
			if(!"".equals(mortgageReserveCar.getCarDuesNo())&&mortgageReserveCar.getCarDuesNo()!=null){
				map.put("carDuesNo", mortgageReserveCar.getCarDuesNo());
			}
			if(!"".equals(mortgageReserveCar.getCarSafeNo())&&mortgageReserveCar.getCarSafeNo()!=null){
				map.put("carSafeNo", mortgageReserveCar.getCarSafeNo());
			}
			mortgageReserveList=mortgageReserveDao.queryMortgageReserveListCarExcel(map);
		}
		return mortgageReserveList;
	}
	@Override
	public List<MortgageReserve> queryOrgs(MortgageReserve mortgageReserve) {
		List<MortgageReserve> mortgageReserveList =new ArrayList<MortgageReserve>();
		Map<String, Object>map =new HashMap<String, Object>();
		map.put("orgName", mortgageReserve.getOrgName());
		mortgageReserveList=mortgageReserveDao.queryOrgs(map);
		return mortgageReserveList;
	}
	@Override
	public String checkIsLog(MortgageReserveOut mortgageReserveOut) {
		 String reslut="fails";//0:可以进行操作,1表示外借或者注销
		Map<String, Object>map=new HashMap<String, Object>();
		try {
			map.put("warrantsId", mortgageReserveOut.getWarrantsId());
			map.put("operatingId",mortgageReserveOut.getOperatingId());
			
			reslut=mortgageReserveDao.checkIsLog(map);
			if("".equals(reslut)||reslut=="null"){
				//出库时可以没有记录,入库时必定要有记录
				if("1".equals(mortgageReserveOut.getOutInType())){
					reslut="0";
				}else if ("2".equals(mortgageReserveOut.getOutInType())){
					reslut="9";//表示没有记录
				}
			}
		} catch (Exception e) {
			reslut="fails";
			e.printStackTrace();
		}
		return reslut;
	}
	@Override
	public MortgageReserveOut showBorrowerNums(
			MortgageReserveOut mortgageReserveOut) {
		Map<String, Object>map=new HashMap<String, Object>();
		if(!"".equals(mortgageReserveOut.getOperatingId())&&mortgageReserveOut.getOperatingId()!=null){
			map.put("operatingId", mortgageReserveOut.getOperatingId());
		}
		if(!"".equals(mortgageReserveOut.getWarrantsId())&&mortgageReserveOut.getWarrantsId()!=null){
			map.put("warrantsId", mortgageReserveOut.getWarrantsId());
		}
		if(!"".equals(mortgageReserveOut.getOutInType())&&mortgageReserveOut.getOutInType()!=null){
			//只查出库的
			map.put("outInType", mortgageReserveOut.getOutInType());
		}
		MortgageReserveOut mortgageReserveOutres=mortgageReserveDao.showBorrowerNums(map);
		return mortgageReserveOutres;
	}
	@Override
	public List<MortgageReserveRes> queryOutInList(
			MortgageReserveRes mortgageReserveRes) {
		Map<String, Object>map=new HashMap<String, Object>();
		List<MortgageReserveRes> mortgageReserveList =new ArrayList<MortgageReserveRes>();
		String id=mortgageReserveRes.getWarrantsId();
		String mortgageType=mortgageReserveRes.getMortgageType();
	    map.put("id", id);
		if("1".equals(mortgageType)){
			mortgageReserveList=mortgageReserveDao.queryOutInHouseList(map);
		}else if("2".equals(mortgageType)){
			mortgageReserveList=mortgageReserveDao.queryOutInCarList(map);
		}
		return mortgageReserveList;
	}
	@Override
	public List<MortgageReserveUpdLog> queryDetailColl(
			MortgageReserveRes mortgageReserveRes) {
		Map<String, Object>map=new HashMap<String, Object>();
		List<MortgageReserveUpdLog> mortgageReserveList =new ArrayList<MortgageReserveUpdLog>();
		map.put("warrantsId", mortgageReserveRes.getWarrantsId());
		map.put("mortgageType", mortgageReserveRes.getMortgageType());
       if(!"".equals(mortgageReserveRes.getEmpName())&&mortgageReserveRes.getEmpName()!=null){
   		map.put("empName", mortgageReserveRes.getEmpName());
       }
		mortgageReserveList=mortgageReserveDao.queryDetailColl(map);
		return mortgageReserveList;
	}
	@Override
	public MortgageReserveRes showStatus(MortgageReserveOut mortgageReserveOut) {
		Map<String, Object>map=new HashMap<String, Object>();
		if(!"".equals(mortgageReserveOut.getWarrantsId())&&mortgageReserveOut.getWarrantsId()!=null){
			map.put("warrantsId", mortgageReserveOut.getWarrantsId());
		}
		MortgageReserveRes mortgageReserve=mortgageReserveDao.showStatus(map);
		return mortgageReserve;
	}
	
	
	
}
