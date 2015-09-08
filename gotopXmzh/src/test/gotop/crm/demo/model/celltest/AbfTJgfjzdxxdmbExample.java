package test.gotop.crm.demo.model.celltest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class AbfTJgfjzdxxdmbExample {

	/**
	 * @abatorgenerated
	 */
	protected Logger log = Logger.getLogger(AbfTJgfjzdxxdmbExample.class);
	/**
	 * 排序字段.
	 * @abatorgenerated
	 */
	protected String orderByClause;
	/**
	 * sql条件.
	 * @abatorgenerated
	 */
	protected List oredCriteria;
	/**
	 * 分页查询的起始行数.
	 * @abatorgenerated
	 */
	private Integer oracleStart;
	/**
	 * 分页查询结束行数.
	 * @abatorgenerated
	 */
	private Integer oracleEnd;

	/**
	 * @abatorgenerated  
	 */
	public AbfTJgfjzdxxdmbExample() {
		oredCriteria = new ArrayList();
	}

	/**
	 * @abatorgenerated  
	 */
	protected AbfTJgfjzdxxdmbExample(AbfTJgfjzdxxdmbExample example) {
		this.orderByClause = example.orderByClause;
		this.oredCriteria = example.oredCriteria;
		this.oracleStart = example.oracleStart;
		this.oracleEnd = example.oracleEnd;
	}

	/**
	 * @abatorgenerated  
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * @abatorgenerated  
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * @abatorgenerated  
	 */
	public List getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * @abatorgenerated  
	 */
	public Integer getOracleStart() {
		return oracleStart;
	}

	/**
	 * @abatorgenerated  
	 */
	public void setOracleStart(Integer oracleStart) {
		this.oracleStart = oracleStart;
	}

	/**
	 * @abatorgenerated  
	 */
	public Integer getOracleEnd() {
		return oracleEnd;
	}

	/**
	 * @abatorgenerated  
	 */
	public void setOracleEnd(Integer oracleEnd) {
		this.oracleEnd = oracleEnd;
	}

	/**
	 * 增加整个新查询条件(Criteria)，增加后以or方式查询.
	 * @abatorgenerated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * 创新新Criteria，如果为第一个则加入到Criteria列表。并且返回
	 * @abatorgenerated
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * 仅创新新Criteria,并且返回
	 * @abatorgenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * 清除查询条件
	 * @abatorgenerated
	 */
	public void clear() {
		oredCriteria.clear();
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to the database table BKLS.ABF_T_JGFJZDXXDMB
	 * @abatorgenerated  Fri Nov 18 10:28:06 CST 2011
	 */
	public static class Criteria {
		protected List criteriaWithoutValue;
		protected List criteriaWithSingleValue;
		protected List criteriaWithListValue;
		protected List criteriaWithBetweenValue;

		protected Criteria() {
			super();
			criteriaWithoutValue = new ArrayList();
			criteriaWithSingleValue = new ArrayList();
			criteriaWithListValue = new ArrayList();
			criteriaWithBetweenValue = new ArrayList();
		}

		public boolean isValid() {
			return criteriaWithoutValue.size() > 0
					|| criteriaWithSingleValue.size() > 0
					|| criteriaWithListValue.size() > 0
					|| criteriaWithBetweenValue.size() > 0;
		}

		public List getCriteriaWithoutValue() {
			return criteriaWithoutValue;
		}

		public List getCriteriaWithSingleValue() {
			return criteriaWithSingleValue;
		}

		public List getCriteriaWithListValue() {
			return criteriaWithListValue;
		}

		public List getCriteriaWithBetweenValue() {
			return criteriaWithBetweenValue;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteriaWithoutValue.add(condition);
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("value", value);
			criteriaWithSingleValue.add(map);
		}

		protected void addCriterion(String condition, List values,
				String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("values", values);
			criteriaWithListValue.add(map);
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			List list = new ArrayList();
			list.add(value1);
			list.add(value2);
			Map map = new HashMap();
			map.put("condition", condition);
			map.put("values", list);
			criteriaWithBetweenValue.add(map);
		}

		public Criteria andIdIsNull() {
			addCriterion("a.ID is null");
			return this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("a.ID is not null");
			return this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("a.ID =", value, "id");
			return this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("a.ID <>", value, "id");
			return this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("a.ID >", value, "id");
			return this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("a.ID >=", value, "id");
			return this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("a.ID <", value, "id");
			return this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("a.ID <=", value, "id");
			return this;
		}

		public Criteria andIdIn(List values) {
			addCriterion("a.ID in", values, "id");
			return this;
		}

		public Criteria andIdNotIn(List values) {
			addCriterion("a.ID not in", values, "id");
			return this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("a.ID between", value1, value2, "id");
			return this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("a.ID not between", value1, value2, "id");
			return this;
		}

		public Criteria andCodeIsNull() {
			addCriterion("a.CODE is null");
			return this;
		}

		public Criteria andCodeIsNotNull() {
			addCriterion("a.CODE is not null");
			return this;
		}

		public Criteria andCodeEqualTo(String value) {
			addCriterion("a.CODE =", value, "code");
			return this;
		}

		public Criteria andCodeNotEqualTo(String value) {
			addCriterion("a.CODE <>", value, "code");
			return this;
		}

		public Criteria andCodeGreaterThan(String value) {
			addCriterion("a.CODE >", value, "code");
			return this;
		}

		public Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("a.CODE >=", value, "code");
			return this;
		}

		public Criteria andCodeLessThan(String value) {
			addCriterion("a.CODE <", value, "code");
			return this;
		}

		public Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("a.CODE <=", value, "code");
			return this;
		}

		public Criteria andCodeLike(String value) {
			addCriterion("a.CODE like", value, "code");
			return this;
		}

		public Criteria andCodeNotLike(String value) {
			addCriterion("a.CODE not like", value, "code");
			return this;
		}

		public Criteria andCodeIn(List values) {
			addCriterion("a.CODE in", values, "code");
			return this;
		}

		public Criteria andCodeNotIn(List values) {
			addCriterion("a.CODE not in", values, "code");
			return this;
		}

		public Criteria andCodeBetween(String value1, String value2) {
			addCriterion("a.CODE between", value1, value2, "code");
			return this;
		}

		public Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("a.CODE not between", value1, value2, "code");
			return this;
		}

		public Criteria andNameIsNull() {
			addCriterion("a.NAME is null");
			return this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("a.NAME is not null");
			return this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("a.NAME =", value, "name");
			return this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("a.NAME <>", value, "name");
			return this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("a.NAME >", value, "name");
			return this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("a.NAME >=", value, "name");
			return this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("a.NAME <", value, "name");
			return this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("a.NAME <=", value, "name");
			return this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("a.NAME like", value, "name");
			return this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("a.NAME not like", value, "name");
			return this;
		}

		public Criteria andNameIn(List values) {
			addCriterion("a.NAME in", values, "name");
			return this;
		}

		public Criteria andNameNotIn(List values) {
			addCriterion("a.NAME not in", values, "name");
			return this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("a.NAME between", value1, value2, "name");
			return this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("a.NAME not between", value1, value2, "name");
			return this;
		}

		public Criteria andParentidIsNull() {
			addCriterion("a.PARENTID is null");
			return this;
		}

		public Criteria andParentidIsNotNull() {
			addCriterion("a.PARENTID is not null");
			return this;
		}

		public Criteria andParentidEqualTo(Integer value) {
			addCriterion("a.PARENTID =", value, "parentid");
			return this;
		}

		public Criteria andParentidNotEqualTo(Integer value) {
			addCriterion("a.PARENTID <>", value, "parentid");
			return this;
		}

		public Criteria andParentidGreaterThan(Integer value) {
			addCriterion("a.PARENTID >", value, "parentid");
			return this;
		}

		public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
			addCriterion("a.PARENTID >=", value, "parentid");
			return this;
		}

		public Criteria andParentidLessThan(Integer value) {
			addCriterion("a.PARENTID <", value, "parentid");
			return this;
		}

		public Criteria andParentidLessThanOrEqualTo(Integer value) {
			addCriterion("a.PARENTID <=", value, "parentid");
			return this;
		}

		public Criteria andParentidIn(List values) {
			addCriterion("a.PARENTID in", values, "parentid");
			return this;
		}

		public Criteria andParentidNotIn(List values) {
			addCriterion("a.PARENTID not in", values, "parentid");
			return this;
		}

		public Criteria andParentidBetween(Integer value1, Integer value2) {
			addCriterion("a.PARENTID between", value1, value2, "parentid");
			return this;
		}

		public Criteria andParentidNotBetween(Integer value1, Integer value2) {
			addCriterion("a.PARENTID not between", value1, value2, "parentid");
			return this;
		}

		public Criteria andCommentsIsNull() {
			addCriterion("a.COMMENTS is null");
			return this;
		}

		public Criteria andCommentsIsNotNull() {
			addCriterion("a.COMMENTS is not null");
			return this;
		}

		public Criteria andCommentsEqualTo(String value) {
			addCriterion("a.COMMENTS =", value, "comments");
			return this;
		}

		public Criteria andCommentsNotEqualTo(String value) {
			addCriterion("a.COMMENTS <>", value, "comments");
			return this;
		}

		public Criteria andCommentsGreaterThan(String value) {
			addCriterion("a.COMMENTS >", value, "comments");
			return this;
		}

		public Criteria andCommentsGreaterThanOrEqualTo(String value) {
			addCriterion("a.COMMENTS >=", value, "comments");
			return this;
		}

		public Criteria andCommentsLessThan(String value) {
			addCriterion("a.COMMENTS <", value, "comments");
			return this;
		}

		public Criteria andCommentsLessThanOrEqualTo(String value) {
			addCriterion("a.COMMENTS <=", value, "comments");
			return this;
		}

		public Criteria andCommentsLike(String value) {
			addCriterion("a.COMMENTS like", value, "comments");
			return this;
		}

		public Criteria andCommentsNotLike(String value) {
			addCriterion("a.COMMENTS not like", value, "comments");
			return this;
		}

		public Criteria andCommentsIn(List values) {
			addCriterion("a.COMMENTS in", values, "comments");
			return this;
		}

		public Criteria andCommentsNotIn(List values) {
			addCriterion("a.COMMENTS not in", values, "comments");
			return this;
		}

		public Criteria andCommentsBetween(String value1, String value2) {
			addCriterion("a.COMMENTS between", value1, value2, "comments");
			return this;
		}

		public Criteria andCommentsNotBetween(String value1, String value2) {
			addCriterion("a.COMMENTS not between", value1, value2, "comments");
			return this;
		}
	}
}