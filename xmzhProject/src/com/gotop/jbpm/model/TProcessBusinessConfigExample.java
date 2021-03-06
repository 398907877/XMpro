package com.gotop.jbpm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class TProcessBusinessConfigExample {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TProcessBusinessConfigExample.class);

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

    /** * @abatorgenerated  */
    public TProcessBusinessConfigExample() {
        oredCriteria = new ArrayList();
    }

    /** * @abatorgenerated  */
    protected TProcessBusinessConfigExample(TProcessBusinessConfigExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.oracleStart = example.oracleStart;
        this.oracleEnd = example.oracleEnd;
    }

    /** * @abatorgenerated  */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /** * @abatorgenerated  */
    /** * @abatorgenerated  */
    public String getOrderByClause() {
        return orderByClause;
    }

    /** * @abatorgenerated  */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /** * @abatorgenerated  */
    public Integer getOracleStart() {
        return oracleStart;
    }

    /** * @abatorgenerated  */
    public void setOracleStart(Integer oracleStart) {
        this.oracleStart = oracleStart;
    }

    /** * @abatorgenerated  */
    public Integer getOracleEnd() {
        return oracleEnd;
    }

    /** * @abatorgenerated  */
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
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table T_PROCESS_BUSINESS_CONFIG
     *
     * @abatorgenerated 
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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
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
            addCriterion("ID is null");
            return this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return this;
        }

        public Criteria andIdIn(List values) {
            addCriterion("ID in", values, "id");
            return this;
        }

        public Criteria andIdNotIn(List values) {
            addCriterion("ID not in", values, "id");
            return this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("BUSINESS_TYPE is null");
            return this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("BUSINESS_TYPE is not null");
            return this;
        }

        public Criteria andBusinessTypeEqualTo(String value) {
            addCriterion("BUSINESS_TYPE =", value, "businessType");
            return this;
        }

        public Criteria andBusinessTypeNotEqualTo(String value) {
            addCriterion("BUSINESS_TYPE <>", value, "businessType");
            return this;
        }

        public Criteria andBusinessTypeGreaterThan(String value) {
            addCriterion("BUSINESS_TYPE >", value, "businessType");
            return this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE >=", value, "businessType");
            return this;
        }

        public Criteria andBusinessTypeLessThan(String value) {
            addCriterion("BUSINESS_TYPE <", value, "businessType");
            return this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TYPE <=", value, "businessType");
            return this;
        }

        public Criteria andBusinessTypeLike(String value) {
            addCriterion("BUSINESS_TYPE like", value, "businessType");
            return this;
        }

        public Criteria andBusinessTypeNotLike(String value) {
            addCriterion("BUSINESS_TYPE not like", value, "businessType");
            return this;
        }

        public Criteria andBusinessTypeIn(List values) {
            addCriterion("BUSINESS_TYPE in", values, "businessType");
            return this;
        }

        public Criteria andBusinessTypeNotIn(List values) {
            addCriterion("BUSINESS_TYPE not in", values, "businessType");
            return this;
        }

        public Criteria andBusinessTypeBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE between", value1, value2, "businessType");
            return this;
        }

        public Criteria andBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_TYPE not between", value1, value2, "businessType");
            return this;
        }

        public Criteria andBusinessColumnIsNull() {
            addCriterion("BUSINESS_COLUMN is null");
            return this;
        }

        public Criteria andBusinessColumnIsNotNull() {
            addCriterion("BUSINESS_COLUMN is not null");
            return this;
        }

        public Criteria andBusinessColumnEqualTo(String value) {
            addCriterion("BUSINESS_COLUMN =", value, "businessColumn");
            return this;
        }

        public Criteria andBusinessColumnNotEqualTo(String value) {
            addCriterion("BUSINESS_COLUMN <>", value, "businessColumn");
            return this;
        }

        public Criteria andBusinessColumnGreaterThan(String value) {
            addCriterion("BUSINESS_COLUMN >", value, "businessColumn");
            return this;
        }

        public Criteria andBusinessColumnGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_COLUMN >=", value, "businessColumn");
            return this;
        }

        public Criteria andBusinessColumnLessThan(String value) {
            addCriterion("BUSINESS_COLUMN <", value, "businessColumn");
            return this;
        }

        public Criteria andBusinessColumnLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_COLUMN <=", value, "businessColumn");
            return this;
        }

        public Criteria andBusinessColumnLike(String value) {
            addCriterion("BUSINESS_COLUMN like", value, "businessColumn");
            return this;
        }

        public Criteria andBusinessColumnNotLike(String value) {
            addCriterion("BUSINESS_COLUMN not like", value, "businessColumn");
            return this;
        }

        public Criteria andBusinessColumnIn(List values) {
            addCriterion("BUSINESS_COLUMN in", values, "businessColumn");
            return this;
        }

        public Criteria andBusinessColumnNotIn(List values) {
            addCriterion("BUSINESS_COLUMN not in", values, "businessColumn");
            return this;
        }

        public Criteria andBusinessColumnBetween(String value1, String value2) {
            addCriterion("BUSINESS_COLUMN between", value1, value2, "businessColumn");
            return this;
        }

        public Criteria andBusinessColumnNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_COLUMN not between", value1, value2, "businessColumn");
            return this;
        }

        public Criteria andBusinessTableIsNull() {
            addCriterion("BUSINESS_TABLE is null");
            return this;
        }

        public Criteria andBusinessTableIsNotNull() {
            addCriterion("BUSINESS_TABLE is not null");
            return this;
        }

        public Criteria andBusinessTableEqualTo(String value) {
            addCriterion("BUSINESS_TABLE =", value, "businessTable");
            return this;
        }

        public Criteria andBusinessTableNotEqualTo(String value) {
            addCriterion("BUSINESS_TABLE <>", value, "businessTable");
            return this;
        }

        public Criteria andBusinessTableGreaterThan(String value) {
            addCriterion("BUSINESS_TABLE >", value, "businessTable");
            return this;
        }

        public Criteria andBusinessTableGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TABLE >=", value, "businessTable");
            return this;
        }

        public Criteria andBusinessTableLessThan(String value) {
            addCriterion("BUSINESS_TABLE <", value, "businessTable");
            return this;
        }

        public Criteria andBusinessTableLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_TABLE <=", value, "businessTable");
            return this;
        }

        public Criteria andBusinessTableLike(String value) {
            addCriterion("BUSINESS_TABLE like", value, "businessTable");
            return this;
        }

        public Criteria andBusinessTableNotLike(String value) {
            addCriterion("BUSINESS_TABLE not like", value, "businessTable");
            return this;
        }

        public Criteria andBusinessTableIn(List values) {
            addCriterion("BUSINESS_TABLE in", values, "businessTable");
            return this;
        }

        public Criteria andBusinessTableNotIn(List values) {
            addCriterion("BUSINESS_TABLE not in", values, "businessTable");
            return this;
        }

        public Criteria andBusinessTableBetween(String value1, String value2) {
            addCriterion("BUSINESS_TABLE between", value1, value2, "businessTable");
            return this;
        }

        public Criteria andBusinessTableNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_TABLE not between", value1, value2, "businessTable");
            return this;
        }
    }
}