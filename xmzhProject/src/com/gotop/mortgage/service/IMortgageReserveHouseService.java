package com.gotop.mortgage.service;

import java.util.List;
import java.util.Map;

import com.gotop.mortgage.model.MortgageList;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveHouse;
import com.gotop.mortgage.model.MortgageReserveHouseCar;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface IMortgageReserveHouseService {

	/**
     * 库存查询房产信息
     * @abatorgenerated
     */
	List<MortgageReserveHouseCar> queryHouseStockList(MUOUserSession muo,MortgageReserveHouseCar mortgageReserveHouse, Page page);
	/**
     * 更新单条记录，通过主键
     * @abatorgenerated
     */
    void update(MortgageReserve obj) throws Exception;
    /**
     * 库存查询房产导出功能
     * @abatorgenerated
     */
    List<MortgageReserveHouseCar> queryMortgageHouseForExcel(MUOUserSession muo,MortgageReserveHouseCar mortgageReserveHouse);

    /**
     * 插入单条记录
     * @abatorgenerated
     */
    void insert(Map<String, Object> map) throws Exception;
    /**
     * 通过id查询房产信息
     * @abatorgenerated
     */
    public MortgageReserve queryMortgageReserveHouseById(String id);
    /**
     * 出入库房产汇总查询
     * @abatorgenerated
     */
    List<MortgageList> queryMortgageReserveHouseInOutList(MortgageList mortgageList, Page page);
    /**
     * 出入库房产导出
     * @abatorgenerated
     */
    List<MortgageList> queryMortgageReserveHouseInOutForExcel(MortgageList mortgageList);
    /**
     * 出入库机动车汇总查询
     * @abatorgenerated
     */
    public List<MortgageList> queryMortgageReserveCarInOutList(MortgageList mortgageList, Page page);
    /**
     * 出入库机动车导出功能
     * @abatorgenerated
     */
    List<MortgageList> queryMortgageReserveCarInOutForExcel(MortgageList mortgageList);
    /**
     * 出入库房产明细查询
     * @abatorgenerated
     */
    List<MortgageList> queryMortgageReserveHouseDetailInOutList(MortgageList mortgageList, Page page);
    /**
     * 出入库机动车明细查询
     * @abatorgenerated
     */
    List<MortgageList> queryMortgageReserveCarDetailInOutList(MortgageList mortgageList, Page page);
    /**
     * 出入库机动车导出功能
     * @abatorgenerated
     */
    public List<MortgageList> queryMortgageReserveCarDetailInOutForExcel(MortgageList mortgageList);
    /**
     * 出入库房产导出功能
     * @abatorgenerated
     */
    public List<MortgageList> queryMortgageReserveHouseDetailInOutForExcel(MortgageList mortgageList);
}
