package com.gotop.Generalprocess.dao.impl;

import com.gotop.Generalprocess.dao.ITGeneralprocessModelthreeDAO;
import com.gotop.Generalprocess.model.TGeneralprocessModelthree;
import com.gotop.Generalprocess.model.TGeneralprocessModelthreeExample;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

public class TGeneralprocessModelthreeDAO extends SqlMapClientDao implements ITGeneralprocessModelthreeDAO {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModelthreeDAO.class);

    /**
     * This method was generated by Abator for iBATIS.
     * This method corresponds to the database table T_GENERALPROCESS_MODELTHREE
     *
     * @abatorgenerated 
     */
    public TGeneralprocessModelthreeDAO() {
        super();
    }

    /**
     * 插入一条新数据.
     * @abatorgenerated
     */
    public void insert(TGeneralprocessModelthree record) {
        getSqlMapClientTemplate().insert("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_insert", record);
    }

    /**
     * 通过查询实例，查询记录
     * @abatorgenerated
     */
    public List selectByExample(TGeneralprocessModelthreeExample example) {
        List list = queryForList("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_selectByExample", example);
        return list;
    }

    /**
     * 通过Map方式的动态条件，查询分页数据
     * @abatorgenerated
     */
    public List selectByMapAndPage(HashMap example) {
        List list = queryForList("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_selectByMapAndPage", example);
        return list;
    }

    /**
     * 通过Bean方式的动态条件，查询分页数据
     * @abatorgenerated
     */
    public List selectByExampleAndPage(TGeneralprocessModelthree record, TGeneralprocessModelthreeExample example, Page page) {
         UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
         List list = queryForList("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_selectByExampleAndPage",parms,page);
        return list;
    }

    /**
     * 根据查询模板的查询结果扩展一个实例
     * @abatorgenerated
     * @param example 条件
     */
    public TGeneralprocessModelthree expandEntityByTemplate(TGeneralprocessModelthree example) {
        TGeneralprocessModelthree result = (TGeneralprocessModelthree)queryForObject("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_expandEntityByTemplate", example);
        return result;
    }

    /**
     * 根据Bean数据模板查询条件查询所有记录
     * @abatorgenerated
     * @param example 条件
     */
    public List queryEntitiesByTemplate(TGeneralprocessModelthree example) {
        List<TGeneralprocessModelthree> result = (List<TGeneralprocessModelthree>)queryForList("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_queryEntitiesByTemplate", example);
        return result;
    }

    /**
     * 根据Bean数据模板分页查询
     * @abatorgenerated
     * @param example 条件
     * @param page 分页信息
     */
    public List queryEntitiesByTemplateWithPage(TGeneralprocessModelthree example, Page page) {
        List<TGeneralprocessModelthree> result = (List<TGeneralprocessModelthree>)queryForList("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_queryEntitiesByTemplate", example,page);
        return result;
    }

    /**
     * 通过查询实例，删除数据
     * @abatorgenerated
     */
    public int deleteByExample(TGeneralprocessModelthreeExample example) {
        int rows = getSqlMapClientTemplate().delete("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_deleteByExample", example);
        return rows;
    }

    /**
     * 根据Bean数据模板查询条件更新记录
     * @abatorgenerated
     * @param example 条件
     */
    public int deleteByTemplate(TGeneralprocessModelthree example) {
        int rows = getSqlMapClientTemplate().delete("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_deleteByTemplate", example);
        return rows;
    }

    /**
     * 通过查询实例，统计总数
     * @abatorgenerated
     */
    public int countByExample(TGeneralprocessModelthreeExample example) {
        Integer count = (Integer)  queryForObject("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_countByExample", example);
        return count.intValue();
    }

    /**
     * 通过查询Bean数据模板，统计总数
     * @abatorgenerated
     * @param example 条件
     */
    public int countByTemplate(TGeneralprocessModelthree example) {
        Integer rows = (Integer)queryForObject("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_countByTemplate", example);
        return rows.intValue();
    }

    /**
     * 通过查询实例，更新非null字段
     * @abatorgenerated
     */
    public int updateByExampleSelective(TGeneralprocessModelthree record, TGeneralprocessModelthreeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * 通过查询实例，更新全部字段
     * @abatorgenerated
     */
    public int updateByExample(TGeneralprocessModelthree record, TGeneralprocessModelthreeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_updateByExample", parms);
        return rows;
    }

    /**
     * 根据Bean数据模板查询条件更新记录
     * @abatorgenerated
     * @param record 值
     * @param example 条件
     */
    public int updateEntityByTemplate(TGeneralprocessModelthree record, TGeneralprocessModelthree example) {
        HashMap<String,TGeneralprocessModelthree> params = new HashMap<String,TGeneralprocessModelthree>();
        params.put("record", record);
        params.put("template", example);
        int rows = getSqlMapClientTemplate().update("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_updateEntityByTemplate", params);
        return rows;
    }

    /**
     * 分页查询信息
     * @abatorgenerated
     */
    public List selectByDynamic(HashMap map, Page page) throws Exception {
        List list = queryForList("T_GENERALPROCESS_MODELTHREE_SqlMap.abatorgenerated_selectByDynamic", map, page);
        return list;
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table T_GENERALPROCESS_MODELTHREE
     *
     * @abatorgenerated 
     */
    private static class UpdateByExampleParms extends TGeneralprocessModelthreeExample {
        private Object record;

        public UpdateByExampleParms(Object record, TGeneralprocessModelthreeExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}