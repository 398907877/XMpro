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
			MortgageReserve mortgageReserve, Page page) {
		List<MortgageReserveRes> mortgageReserveList =new ArrayList<MortgageReserveRes>();
		Map<String, Object>map=new HashMap<String, Object>();
		String mortgageType= mortgageReserve.getMortgageType();
		if(!"".equals(mortgageType)&&mortgageType!=null){
			map.put("mortgageType", mortgageType);
		}
		mortgageReserveList=mortgageReserveDao.queryMortgageReserveList(map, page);
		return mortgageReserveList;
	}
	@Override
	public String checkOtherWarrantsNumber(MortgageReserve mortgageReserve) {
        String reslutNums="fails";
		Map<String, Object>map=new HashMap<String, Object>();
		if(mortgageReserve.getOtherWarrantsNumber()!= null && !"".equals(mortgageReserve.getOtherWarrantsNumber())){
			map.put("otherWarrantsNumber",mortgageReserve.getOtherWarrantsNumber());
		}
		reslutNums=mortgageReserveDao.checkOtherWarrantsNumber(map);
		return reslutNums;
	}
	@Override
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
			map=resMortgageReserveMap(pkey,mortgageReserve,address,inserttime);
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
					result=insertMortgageOperatingLog(operatingType, userID, pkey, inserttime, "新增入库");
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
			map=resMortgageReserveMap(pkey,mortgageReserve,address,inserttime);
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
					result=insertMortgageOperatingLog(operatingType, userID, pkey, inserttime, "添加机动车押品信息");
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
	
	
	/**
	 * 生成MortgageReserveMap值
	 * @param pkey
	 * @param mortgageReserve
	 * @return
	 */
	public Map<String, Object> resMortgageReserveMap(Long pkey,MortgageReserve mortgageReserve,String address,String inserttime)  throws Exception{
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
			map.put("fileName",address);
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
}
