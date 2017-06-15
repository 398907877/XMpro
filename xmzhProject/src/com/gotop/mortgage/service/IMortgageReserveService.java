package com.gotop.mortgage.service;

import java.io.File;
import java.util.List;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveCar;
import com.gotop.mortgage.model.MortgageReserveHouse;
import com.gotop.mortgage.model.MortgageReserveOut;
import com.gotop.mortgage.model.MortgageReserveRes;
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
	 * 插入押品类型为房产时
	 * @param mortgageReserve
	 * @param mortgageReserveHouse
	 */
	boolean insertItemHouse(MortgageReserve mortgageReserve,MortgageReserveHouse mortgageReserveHouse,File[] files,String[] filesFileName,MUOUserSession muo);
	

	/**
	 * 插入押品类型为机动车时
	 * @param mortgageReserve
	 * @param mortgageReserveHouse
	 */
	boolean insertItemCar(MortgageReserve mortgageReserve,MortgageReserveCar mortgageReserveCar,File[] files,String[] filesFileName,MUOUserSession muo);
	
	
	/**
	 * 插入房产押品类型
	 * @param mortgageReserve
	 * @param mortgageReserveHouse
	 */
	boolean insertCollateralHouse(Long pkey,MortgageReserveHouse mortgageReserveHouse,MUOUserSession muo);
	

	/**
	 * 插入机动车押品类型
	 * @param mortgageReserve
	 * @param mortgageReserveHouse
	 */
	boolean insertCollateralCar(Long pkey,MortgageReserveCar mortgageReserveCar,MUOUserSession muo);
	
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
	 * 库存变更为房产时
	 * @param mortgageReserve
	 * @param mortgageReserveHouse
	 */
	boolean updCollHouse(MortgageReserve mortgageReserve,MortgageReserveHouse mortgageReserveHouse,File[] files,String[] filesFileName,MUOUserSession muo);
	/**
	 * 库存变更为机动车时
	 * @param mortgageReserve
	 * @param mortgageReserveHouse
	 */
	boolean updCollCar(MortgageReserve mortgageReserve,MortgageReserveCar mortgageReserveCar,File[] files,String[] filesFileName,MUOUserSession muo);
	
	/**
	 * 查询房产类型押品信息详情
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveRes> queryMortgageReserveHouseList(String id,Page page);
	

	/**
	 * 查询机动车类型押品信息详情
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveRes> queryMortgageReserveCarList(String id,Page page);
	
	

	/**
	 * 出入库变更操作
	 * @param mortgageReserve
	 * @param mortgageReserveHouse
	 */
	boolean insertMortgageReserveOut(MortgageReserveOut mortgageReserveOut,MUOUserSession muo);
	
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
	MortgageReserve queryMortgageReserveListInfo(String noticeRegisterRelation);
}
