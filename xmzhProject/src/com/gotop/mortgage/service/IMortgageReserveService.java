package com.gotop.mortgage.service;

import java.io.File;
import java.util.List;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveCar;
import com.gotop.mortgage.model.MortgageReserveHouse;
import com.gotop.mortgage.model.MortgageReserveOut;
import com.gotop.mortgage.model.MortgageReserveRes;
import com.gotop.mortgage.model.MortgageReserveUpdLog;
import com.gotop.mortgage.model.WarrantsFile;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface IMortgageReserveService {
	
	/**
	 * 查询抵押品库存
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveRes> queryMortgageReserveList(MortgageReserve mortgageReserve,MortgageReserveHouse mortgageReserveHouse,MortgageReserveCar mortgageReserveCar, Page page);
	
	/**
	 * 查询抵押品库存导出EXCEL
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveRes> queryMortgageReserveListExcel(MortgageReserve mortgageReserve,MortgageReserveHouse mortgageReserveHouse,MortgageReserveCar mortgageReserveCar);
	
	/**
	 * 查询权证信息详情
	 * @param id
	 * @param mortgageType
	 * @return
	 */
	MortgageReserve queryMortgageReserveListInfo(String id,String mortgageType);
	
	/**
	 * 查询房产抵押品详情
	 * @param id
	 * @return
	 */
	List<MortgageReserveHouse> queryMortgageReserveListHouseInfo(String id);
	
	/**
	 * 查询机动车抵押品详情
	 * @param id
	 * @return
	 */
	List<MortgageReserveCar> queryMortgageReserveListCarInfo(String id);
	
	
	/**
	 * 检验 他项权证号是否已存在
	 * @param mortgageReserve
	 * @return
	 */
	String checkOtherWarrantsNumber(MortgageReserve mortgageReserve);
	
	/**
	 * 插入权证信息和押品信息
	 * @param mortgageReserve
	 * @param mortgageReserveHouse
	 */
	boolean insertItemALL(MortgageReserve mortgageReserve,MortgageReserveHouse mortgageReserveHouse,MortgageReserveCar mortgageReserveCar,File[] files,String[] filesFileName,MUOUserSession muo) throws Exception;
	
	
	
	
	/**
	 * 插入房产押品类型
	 * @param mortgageReserve
	 * @param mortgageReserveHouse
	 */
	boolean insertCollateralHouse(Long pkey,MortgageReserveHouse mortgageReserveHouse,MUOUserSession muo) throws Exception;
	

	/**
	 * 插入机动车押品类型
	 * @param mortgageReserve
	 * @param mortgageReserveHouse
	 */
	boolean insertCollateralCar(Long pkey,MortgageReserveCar mortgageReserveCar,MUOUserSession muo) throws Exception;
	
	/**
	 * 根据主键和类型获得文件信息
	 * @param id
	 * @param resourceType
	 * @return
	 */
	List<WarrantsFile> queryFileByIdandType(Long id);
	
	/**
	 * 根据主键获得文件信息
	 * @param fileId
	 * @return
	 */
	public WarrantsFile getFileResource(String fileId);
	
	/**
	 * 库存变更
	 * @param mortgageReserve
	 * @param mortgageReserveHouse
	 */
	boolean updCollAll(MortgageReserve mortgageReserve,MortgageReserveHouse mortgageReserveHouse,MortgageReserveCar mortgageReserveCar,File[] files,String[] filesFileName,MUOUserSession muo);
	

	
	/**
	 * 查询房产、机动车类型押品信息详情
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveRes> queryMortgageReserveAllList(MortgageReserveRes mortgageReserveRes);
	
	
	
	
	

	/**
	 * 出入库变更操作
	 * @param mortgageReserve
	 * @param mortgageReserveHouse
	 */
	boolean insertMortgageReserveOut(MortgageReserveOut mortgageReserveOut,MUOUserSession muo);
	

	/**
	 * 入库撤销变更操作
	 * @param mortgageReserve
	 * @param mortgageReserveHouse
	 */
	boolean insertMortgageReserveOutBack(MortgageReserveOut mortgageReserveOut,MUOUserSession muo);
	
	/**
	 * 检验 机动车登记证号是否已存在
	 * @param mortgageReserve
	 * @return
	 */
	String checkCarRegisterNo(MortgageReserveCar mortgageReserveCar);
	
	/**
	 * 生成部分权证信息详情
	 * @param mortgageReserve
	 * @return
	 */
	MortgageReserve openGenerate(MortgageReserve mortgageReserve);
	
	/**
	 * 机构号查询
	 * @param mortgageReserve
	 * @return
	 */
	public List<MortgageReserve> queryOrgs(MortgageReserve mortgageReserve);
	
	
	/**
	 * 检验 他项权证号是否已存在
	 * @param mortgageReserve
	 * @return
	 */
	String checkIsLog(MortgageReserveOut mortgageReserveOut);
	

	/**
	 * 生成部分权证信息详情
	 * @param mortgageReserve
	 * @return
	 */
	public MortgageReserveOut showBorrowerNums(MortgageReserveOut mortgageReserveOut);
	
	
	/**
	 * 生成权证信息状态详情
	 * @param mortgageReserve
	 * @return
	 */
	public MortgageReserveRes showStatus(MortgageReserveOut mortgageReserveOut);
	

	/**
	 * 出入库信息详情
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveRes> queryOutInList(MortgageReserveRes mortgageReserveRes);
	
	/**
	 * 查询房产抵押品详情
	 * @param id
	 * @return
	 */
	List<MortgageReserveUpdLog> queryDetailColl(MortgageReserveRes mortgageReserveRes);
	

	/**
	 * 查看是否可以入库注销
	 * @param mortgageReserve
	 * @return
	 */
	String checkIsBack(MortgageReserveOut mortgageReserveOut);
	
}
