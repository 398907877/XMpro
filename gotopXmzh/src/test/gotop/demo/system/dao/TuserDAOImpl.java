package test.gotop.demo.system.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import java.sql.SQLException;
import java.util.List;
import test.gotop.demo.system.model.Tuser;
import test.gotop.demo.system.model.TuserExample;
import com.gotop.util.dataSource.SqlMapClientDao;

public class TuserDAOImpl extends SqlMapClientDao implements TuserDAO {
    /**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table TUSER
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public TuserDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table TUSER
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public void insert(Tuser record) {
		this.insert("TUSER.abatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table TUSER
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public List selectByExample(TuserExample example) {
		List list = this.queryForList(
				"TUSER.abatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table TUSER
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public int deleteByExample(TuserExample example) {
		int rows = this.delete(
				"TUSER.abatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table TUSER
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public int countByExample(TuserExample example) {
		Integer count = (Integer) this.queryForObject(
				"TUSER.abatorgenerated_countByExample", example);
		return count.intValue();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table TUSER
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public int updateByExampleSelective(Tuser record, TuserExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = this.update(
				"TUSER.abatorgenerated_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table TUSER
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	public int updateByExample(Tuser record, TuserExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = this.update(
				"TUSER.abatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to the database table TUSER
	 * @abatorgenerated  Sun Oct 30 23:13:37 CST 2011
	 */
	private static class UpdateByExampleParms extends TuserExample {
		private Object record;

		public UpdateByExampleParms(Object record, TuserExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}

	@Override
	public int testFun() {
		// TODO Auto-generated method stub
		return 0;
	}
}