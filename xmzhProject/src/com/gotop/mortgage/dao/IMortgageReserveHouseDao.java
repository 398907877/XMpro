package com.gotop.mortgage.dao;

import java.util.List;
import java.util.Map;

import com.gotop.mortgage.model.MortgageList;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveHouseCar;
import com.primeton.utils.Page;

public interface IMortgageReserveHouseDao {

	/**
	 * 查询押品类型为房产的库存信息
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	public List<MortgageReserveHouseCar> queryMortgageReserveList(Map<String, Object> map, Page page);
	
	public List<MortgageReserveHouseCar> queryPropertyNameAndNoList(Map<String, Object> map);
	/**
     * 通过主键更新部分字段，部分字段说明：当字段为null时不更新，当字段值为''空值是更新为空值
     * @abatorgenerated
     */
    int updateByPrimaryKeySelective(Map<String, Object> map);
    
    /**
	 * 房产库存信息导出功能导出excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<MortgageReserveHouseCar> queryMortgageReserveHouseForExcel(Map<String, Object> map);
	/**
     * 插入一条新数据.
     * @abatorgenerated
     */
    void insert(Map<String, Object> map);
    /**
	 * 根据id查询押品类型为房产的库存信息
	 * @param mortgageReserve
	 * @return
	 */
    public MortgageReserve queryMortgageReserveHouseById(Map<String, Object> map);
    /**
	 * 出入库房产查询
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
    public List<MortgageList> queryMortgageReserveHouseInOutList(Map<String, Object> map, Page page);
    /**
	 * 出入库机动车查询
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
    public List<MortgageList> queryMortgageReserveCarInOutList(Map<String, Object> map, Page page);
    /**
	 * 出入库房产导出功能导出excel
	 * @param map
	 * @return
	 */
	public List<MortgageList> queryMortgageReserveHouseInOutForExcel(Map<String, Object> map);
	/**
	 * 出入库机动车导出功能导出excel
	 * @param map
	 * @return
	 */
	public List<MortgageList> queryMortgageReserveCarInOutForExcel(Map<String, Object> map);
	/**
	 * 出入库房产明细查询
	 * @param map
	 * @return
	 */
	public List<MortgageList> queryMortgageReserveHouseDetailInOutList(Map<String, Object> map, Page page);
	/**
	 * 出入库机动车明细查询
	 * @param map
	 * @return
	 */
	public List<MortgageList> queryMortgageReserveCarDetailInOutList(Map<String, Object> map, Page page);
	/**
	 * 出入库机动车明细导出功能导出excel
	 * @param map
	 * @return
	 */
	public List<MortgageList> queryMortgageReserveCarDetailInOutForExcel(Map<String, Object> map);
	/**
	 * 出入库房产明细导出功能导出excel
	 * @param map
	 * @return
	 */
	public List<MortgageList> queryMortgageReserveHouseDetailInOutForExcel(Map<String, Object> map);
	/**
	 * 通过登录用户id找到上级机构id
	 * @param orgcode
	 * @return
	 */
	String byOrgcodeFindParentorgid(String orgcode);
	/**
	 * 找到一类支行的orgid
	 * @param orgcode
	 * @return
	 */
	String queryOneOrgCode(String orgcode);
	/**
	 * 判断登陆用户的机构id是否属于一类支行 属于就返回1，不属于就返回0
	 * @param orgcode
	 * @return
	 */
	String judgeYesAndNoOneOrgCode(String orgcode);
}
