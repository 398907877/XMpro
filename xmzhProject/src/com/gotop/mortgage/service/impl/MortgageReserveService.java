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
import org.springframework.transaction.annotation.Transactional;

import com.gotop.mortgage.dao.IMortgageReserveDao;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveCar;
import com.gotop.mortgage.model.MortgageReserveHouse;
import com.gotop.mortgage.model.MortgageReserveOut;
import com.gotop.mortgage.model.MortgageReserveRes;
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
				map.put("status", "1");
				map.put("afterMortgageStatus", "3");
			}else if("2".equals(mortgageReserve.getLogOutSign())){
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
	@Transactional(rollbackFor=Exception.class)
	public boolean insertItemHouse(MortgageReserve mortgageReserve,
			MortgageReserveHouse mortgageReserveHouse,File[] files,String[] filesFileName,MUOUserSession muo) {
		Map<String, Object>map=new HashMap<String, Object>();
		Map<String, Object>mapHouse=new HashMap<String, Object>();
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
			map=resMortgageReserveMap(pkey,mortgageReserve,inserttime);
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
    			mapHouse=resMortgageReserveHouseMap(pkey, mortgageReserveHouse);
    			result=mortgageReserveDao.insertMortgageHouse(mapHouse);
				if(result){
					String operatingType="4";//新增入库
					//插入日志
					result=insertMortgageOperatingLog(operatingType, userID, pkey, inserttime, "新增入库押品类型为房产时");
				}
				
			}
    		
		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public boolean insertItemCar(MortgageReserve mortgageReserve,
			MortgageReserveCar mortgageReserveCar,File[] files,String[] filesFileName,MUOUserSession muo) {
		Map<String, Object>map=new HashMap<String, Object>();
		Map<String, Object>mapCar=new HashMap<String, Object>();
		HashMap<String, String>hmp=new HashMap<String, String>();
		System.out.println("car......");
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
			map=resMortgageReserveMap(pkey,mortgageReserve,inserttime);
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
    			mapCar=resMortgageReserveCarMap(pkey, mortgageReserveCar);
    			result=mortgageReserveDao.insertMortgageCar(mapCar);
				if(result){
					String operatingType="4";//新增入库
					//插入日志
					result=insertMortgageOperatingLog(operatingType, userID, pkey, inserttime, "新增入库押品类型为机动车时");
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
			Long pkey,MortgageReserveHouse mortgageReserveHouse, MUOUserSession muo) {
		Map<String, Object>mapHouse=new HashMap<String, Object>();
		boolean result=false;
		try {
			mapHouse=resMortgageReserveHouseMap(pkey, mortgageReserveHouse);
			result=mortgageReserveDao.insertMortgageHouse(mapHouse);
			if(result){
				String operatingType="4";//新增入库
				Long userID=muo.getEmpid();
				Date d=new Date();
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
				String inserttime = sdf2.format(d);  //此时的survey_time格式为yyyyMMddHHmmss， 如：20160217000000
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
			MUOUserSession muo) {
		Map<String, Object>mapCar=new HashMap<String, Object>();
		boolean result=false;
		try {
			mapCar=resMortgageReserveCarMap(pkey, mortgageReserveCar);
			result=mortgageReserveDao.insertMortgageCar(mapCar);
			if(result){
				String operatingType="4";//新增入库
				Long userID=muo.getEmpid();
				Date d=new Date();
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
				String inserttime = sdf2.format(d);  //此时的survey_time格式为yyyyMMddHHmmss， 如：20160217000000
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
	public boolean updCollHouse(MortgageReserve mortgageReserve,
			MortgageReserveHouse mortgageReserveHouse,File[] files,String[] filesFileName, MUOUserSession muo) {
		Map<String, Object>map=new HashMap<String, Object>();
		boolean result=false;
		try {
			Long pkey=Long.valueOf(mortgageReserve.getId());
			Long userID=muo.getEmpid();
			Date d=new Date();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
			String inserttime = sdf2.format(d);  //此时的survey_time格式为yyyyMMddHHmmss， 如：20160217000000
    		String address=ServletActionContext.getServletContext().getRealPath("/uploadWarrantsInfofileName");
			map=resMortgageReserveMap(pkey,mortgageReserve,inserttime);
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
    			if(mortgageReserveHouse.getId()!=null&&mortgageReserveHouse.getId()!=""){
        		  result=updateMortgageHouse(mortgageReserveHouse);
    			}
				if(result){
					String operatingType="3";//库存变更
					//插入日志
					result=insertMortgageOperatingLog(operatingType, userID, pkey, inserttime, "库存变更押品类型为房产时");
				}
				
			}
		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public boolean updCollCar(MortgageReserve mortgageReserve,
			MortgageReserveCar mortgageReserveCar,File[] files,String[] filesFileName, MUOUserSession muo) {
		Map<String, Object>map=new HashMap<String, Object>();
		System.out.println("car......");
		boolean result=false;
		try {
			//获取权证信息表id
			Long pkey=Long.valueOf(mortgageReserve.getId());
			Long userID=muo.getEmpid();
			Date d=new Date();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
			String inserttime = sdf2.format(d);  //此时的survey_time格式为yyyyMMddHHmmss， 如：20160217000000
    		String address=ServletActionContext.getServletContext().getRealPath("/uploadWarrantsInfofileName");
			map=resMortgageReserveMap(pkey,mortgageReserve,inserttime);
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
    			if(mortgageReserveCar.getId()!=null&&mortgageReserveCar.getId()!=""){
    			  result=updateMortgageCar( mortgageReserveCar);
    			}
				if(result){
					String operatingType="3";//库存变更
					//插入日志
					result=insertMortgageOperatingLog(operatingType, userID, pkey, inserttime, "库存变更押品类型为机动车时");
				}
				
			}
    		
		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		return result;
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
				map.put("id", resId[i]);
				map.put("propertyNo", resPropertyNo[i]);
				map.put("propertyName",resPropertyName[i]);
				map.put("propertyCardNo", resPropertyCardNo[i]);
				map.put("propertyAddres", resPropertyAddres[i]);
				map.put("propertyNums", resPropertyNums[i]);
				map.put("propertyDate", resPropertyDate[i]);
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
				map.put("id", resId[i]);
				map.put("carName", resCarName[i]);
				map.put("carCardNo", resCarCardNo[i]);
				map.put("carRegisterNo",resCarRegisterNo[i]);
				map.put("carNo", resCarNo[i]);
				map.put("carFrameNo", resCarFrameNo[i]);
				map.put("carInvoiceNo",resCarInvoiceNo[i]);
				map.put("carDuesNo", resCarDuesNo[i]);
				map.put("carSafeNo", resCarSafeNo[i]);
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
	 * 生成MortgageReserveMap值
	 * @param pkey
	 * @param mortgageReserve
	 * @return
	 */
	public Map<String, Object> resMortgageReserveMap(Long pkey,MortgageReserve mortgageReserve,String inserttime)  throws Exception{
		Map<String, Object>map=new HashMap<String, Object>();
		try {
			map.put("id", pkey);
			map.put("mortgageType", mortgageReserve.getMortgageType());
			map.put("otherType", mortgageReserve.getOtherType());
			map.put("noticeRegisterRelation", mortgageReserve.getNoticeRegisterRelation());
			map.put("projectNumber", mortgageReserve.getProjectNumber());
			map.put("otherWarrantsNumber", mortgageReserve.getOtherWarrantsNumber());
			map.put("otherWarrantsDate", mortgageReserve.getOtherWarrantsDate());
			map.put("borrowerName", mortgageReserve.getBorrowerName());
			map.put("borrowerCardNo", mortgageReserve.getBorrowerCardNo());
			map.put("orgCode", mortgageReserve.getOrgCode());
			map.put("mangerName", mortgageReserve.getMangerName());
			map.put("loanType", mortgageReserve.getLoanType());
			map.put("borrowerContractNo", mortgageReserve.getBorrowerContractNo());
			map.put("loanYears", mortgageReserve.getLoanYears());
			map.put("recordValue", mortgageReserve.getRecordValue());
			map.put("packetNumber", mortgageReserve.getPacketNumber());
			map.put("nextName", mortgageReserve.getNextName());
			map.put("remark", mortgageReserve.getRemark());
			map.put("noRegisterSign", mortgageReserve.getNoRegisterSign());
			map.put("status", mortgageReserve.getStatus());
			map.put("inserttime", inserttime);
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
	public Map<String, Object> resMortgageReserveHouseMap(Long pkey,MortgageReserveHouse mortgageReserveHouse) throws Exception{
		Map<String, Object>map=new HashMap<String, Object>();
		try {
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
	public Map<String, Object> resMortgageReserveCarMap(Long pkey,MortgageReserveCar mortgageReserveCar) throws Exception{
		Map<String, Object>map=new HashMap<String, Object>();
		try {
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
			map.put("borrowerLog", mortgageReserveOut.getBorrowerLog());
			map.put("operatingMatters", mortgageReserveOut.getOperatingMatters());
			map.put("remark", mortgageReserveOut.getRemark());
			map.put("operatingId", mortgageReserveOut.getOperatingId());
			map.put("insertTime", mortgageReserveOut.getInsertTime());
			map.put("nextName", mortgageReserveOut.getNextName());
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
	public List<MortgageReserveRes> queryMortgageReserveHouseList(String id, Page page) {
		Map<String, Object>map=new HashMap<String, Object>();
		List<MortgageReserveRes> mortgageReserveList =new ArrayList<MortgageReserveRes>();
		map.put("id", id);
		mortgageReserveList=mortgageReserveDao.queryMortgageReserveHouseList(map,page);
		return mortgageReserveList;
	}
	@Override
	public List<MortgageReserveRes> queryMortgageReserveCarList(String id, Page page) {
		Map<String, Object>map=new HashMap<String, Object>();
		List<MortgageReserveRes> mortgageReserveList =new ArrayList<MortgageReserveRes>();
		map.put("id", id);
		mortgageReserveList=mortgageReserveDao.queryMortgageReserveCarList(map,page);
		return mortgageReserveList;
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
			map=resMortgageReserveOutMap(mortgageReserveOut);
			result=mortgageReserveDao.insertMortgageReserveOutMap(map);
			if(result){
				String operatingType="4";//新增入库
				Long userID=muo.getEmpid();
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
	public MortgageReserve queryMortgageReserveListInfo(String noticeRegisterRelation) {
		Map<String, Object>map=new HashMap<String, Object>();
		if(!"".equals(noticeRegisterRelation)&& noticeRegisterRelation!=null){
			map.put("projectNumber", noticeRegisterRelation);
		}
		MortgageReserve mortgageReserves=mortgageReserveDao.queryMortgageReserveListInfo(map);
		System.out.println("ww"+mortgageReserves);
		return mortgageReserves;
	}
}
