package test.gotop.crm.demo.dao.datacell.impl;

import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import com.gotop.util.dataSource.SqlMapClientDao;
import test.gotop.crm.demo.dao.datacell.IAbfTJgfjxxbDAO;
import test.gotop.crm.demo.model.datacell.AbfTJgfjxxb;
import test.gotop.crm.demo.model.datacell.AbfTJgfjxxbExample;

public class AbfTJgfjxxbDAO extends SqlMapClientDao implements IAbfTJgfjxxbDAO {

	/**
	 * @abatorgenerated
	 */
	protected Logger log = Logger.getLogger(AbfTJgfjxxbDAO.class);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table BKLS.ABF_T_JGFJXXB
	 * @abatorgenerated  Fri Nov 18 10:28:06 CST 2011
	 */
	public AbfTJgfjxxbDAO() {
		super();
	}

	/**
	 * 插入一条新数据
	 * @abatorgenerated
	 */
	public void insert(AbfTJgfjxxb record) {
		this.insert(
				"BKLS_ABF_T_JGFJXXB.abatorgenerated_insert", record);
	}

	/**
	 * 通过主键更新一条全部字段内容
	 * @abatorgenerated
	 */
	public int updateByPrimaryKey(AbfTJgfjxxb record) {
		int rows = this.update(
						"BKLS_ABF_T_JGFJXXB.abatorgenerated_updateByPrimaryKey",
						record);
		return rows;
	}

	/**
	 * 通过主键更新部分字段，部分字段说明：当字段为null时不更新，当字段值为''空值是更新为空值
	 * @abatorgenerated
	 */
	public int updateByPrimaryKeySelective(AbfTJgfjxxb record) {
		int rows = this.update(
						"BKLS_ABF_T_JGFJXXB.abatorgenerated_updateByPrimaryKeySelective",
						record);
		return rows;
	}

	/**
	 * 通过查询实例，查询记录
	 * @abatorgenerated
	 */
	public List selectByExample(AbfTJgfjxxbExample example) {
		List list = this.queryForList(
				"BKLS_ABF_T_JGFJXXB.abatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * 通过Map方式的动态条件，查询分页数据
	 * @abatorgenerated
	 */
	public List selectByMapAndPage(HashMap example) {
		List list = this.queryForList(
				"BKLS_ABF_T_JGFJXXB.abatorgenerated_selectByMapAndPage",
				example);
		return list;
	}

	/**
	 * 通过Bean方式的动态条件，查询分页数据
	 * @abatorgenerated
	 */
	public List selectByExampleAndPage(AbfTJgfjxxb record,
			AbfTJgfjxxbExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		List list = this.queryForList(
				"BKLS_ABF_T_JGFJXXB.abatorgenerated_selectByExampleAndPage",
				parms);
		return list;
	}

	/**
	 * 通过主键查询一条记录
	 * @abatorgenerated
	 */
	public AbfTJgfjxxb selectByPrimaryKey(Integer orgid) {
		AbfTJgfjxxb key = new AbfTJgfjxxb();
		key.setOrgid(orgid);
		AbfTJgfjxxb record = (AbfTJgfjxxb) this.queryForObject(
						"BKLS_ABF_T_JGFJXXB.abatorgenerated_selectByPrimaryKey",
						key);
		return record;
	}

	/**
	 * 通过查询实例，删除数据
	 * @abatorgenerated
	 */
	public int deleteByExample(AbfTJgfjxxbExample example) {
		int rows = this.delete(
				"BKLS_ABF_T_JGFJXXB.abatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * 通过主键删除一条记录
	 * @abatorgenerated
	 */
	public int deleteByPrimaryKey(Integer orgid) {
		AbfTJgfjxxb key = new AbfTJgfjxxb();
		key.setOrgid(orgid);
		int rows = this.delete(
				"BKLS_ABF_T_JGFJXXB.abatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * 通过查询实例，统计总数
	 * @abatorgenerated
	 */
	public int countByExample(AbfTJgfjxxbExample example) {
		Integer count = (Integer) this.queryForObject(
				"BKLS_ABF_T_JGFJXXB.abatorgenerated_countByExample", example);
		return count.intValue();
	}

	/**
	 * 通过查询实例，更新非null字段
	 * @abatorgenerated
	 */
	public int updateByExampleSelective(AbfTJgfjxxb record,
			AbfTJgfjxxbExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = this.update(
				"BKLS_ABF_T_JGFJXXB.abatorgenerated_updateByExampleSelective",
				parms);
		return rows;
	}

	/**
	 * 通过查询实例，更新全部字段
	 * @abatorgenerated
	 */
	public int updateByExample(AbfTJgfjxxb record, AbfTJgfjxxbExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = this.update(
				"BKLS_ABF_T_JGFJXXB.abatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * 分页查询信息
	 * @abatorgenerated
	 */
	public List selectByDynamic(HashMap map) throws Exception {
		List list = this.queryForList(
				"BKLS_ABF_T_JGFJXXB.abatorgenerated_selectByDynamic", map);
		return list;
	}

	/**
	 * 批量提交开始
	 * @abatorgenerated
	 */
	public void startBatch() throws Exception {
		this.startBatch();
	}

	/**
	 * 批量提交
	 * @abatorgenerated
	 */
	public void executeBatch() throws Exception {
		this.executeBatch();
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to the database table BKLS.ABF_T_JGFJXXB
	 * @abatorgenerated  Fri Nov 18 10:28:06 CST 2011
	 */
	private static class UpdateByExampleParms extends AbfTJgfjxxbExample {
		private Object record;

		public UpdateByExampleParms(Object record, AbfTJgfjxxbExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}