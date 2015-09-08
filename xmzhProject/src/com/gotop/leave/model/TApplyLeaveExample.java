package com.gotop.leave.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class TApplyLeaveExample {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TApplyLeaveExample.class);

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
    public TApplyLeaveExample() {
        oredCriteria = new ArrayList();
    }

    /** * @abatorgenerated  */
    protected TApplyLeaveExample(TApplyLeaveExample example) {
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
     * This class corresponds to the database table T_APPLY_LEAVE
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

        public Criteria andLvIdIsNull() {
            addCriterion("LV_ID is null");
            return this;
        }

        public Criteria andLvIdIsNotNull() {
            addCriterion("LV_ID is not null");
            return this;
        }

        public Criteria andLvIdEqualTo(Long value) {
            addCriterion("LV_ID =", value, "lvId");
            return this;
        }

        public Criteria andLvIdNotEqualTo(Long value) {
            addCriterion("LV_ID <>", value, "lvId");
            return this;
        }

        public Criteria andLvIdGreaterThan(Long value) {
            addCriterion("LV_ID >", value, "lvId");
            return this;
        }

        public Criteria andLvIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LV_ID >=", value, "lvId");
            return this;
        }

        public Criteria andLvIdLessThan(Long value) {
            addCriterion("LV_ID <", value, "lvId");
            return this;
        }

        public Criteria andLvIdLessThanOrEqualTo(Long value) {
            addCriterion("LV_ID <=", value, "lvId");
            return this;
        }

        public Criteria andLvIdIn(List values) {
            addCriterion("LV_ID in", values, "lvId");
            return this;
        }

        public Criteria andLvIdNotIn(List values) {
            addCriterion("LV_ID not in", values, "lvId");
            return this;
        }

        public Criteria andLvIdBetween(Long value1, Long value2) {
            addCriterion("LV_ID between", value1, value2, "lvId");
            return this;
        }

        public Criteria andLvIdNotBetween(Long value1, Long value2) {
            addCriterion("LV_ID not between", value1, value2, "lvId");
            return this;
        }

        public Criteria andEmpIdIsNull() {
            addCriterion("EMP_ID is null");
            return this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("EMP_ID is not null");
            return this;
        }

        public Criteria andEmpIdEqualTo(Long value) {
            addCriterion("EMP_ID =", value, "empId");
            return this;
        }

        public Criteria andEmpIdNotEqualTo(Long value) {
            addCriterion("EMP_ID <>", value, "empId");
            return this;
        }

        public Criteria andEmpIdGreaterThan(Long value) {
            addCriterion("EMP_ID >", value, "empId");
            return this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(Long value) {
            addCriterion("EMP_ID >=", value, "empId");
            return this;
        }

        public Criteria andEmpIdLessThan(Long value) {
            addCriterion("EMP_ID <", value, "empId");
            return this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(Long value) {
            addCriterion("EMP_ID <=", value, "empId");
            return this;
        }

        public Criteria andEmpIdIn(List values) {
            addCriterion("EMP_ID in", values, "empId");
            return this;
        }

        public Criteria andEmpIdNotIn(List values) {
            addCriterion("EMP_ID not in", values, "empId");
            return this;
        }

        public Criteria andEmpIdBetween(Long value1, Long value2) {
            addCriterion("EMP_ID between", value1, value2, "empId");
            return this;
        }

        public Criteria andEmpIdNotBetween(Long value1, Long value2) {
            addCriterion("EMP_ID not between", value1, value2, "empId");
            return this;
        }

        public Criteria andLvTitleIsNull() {
            addCriterion("LV_TITLE is null");
            return this;
        }

        public Criteria andLvTitleIsNotNull() {
            addCriterion("LV_TITLE is not null");
            return this;
        }

        public Criteria andLvTitleEqualTo(String value) {
            addCriterion("LV_TITLE =", value, "lvTitle");
            return this;
        }

        public Criteria andLvTitleNotEqualTo(String value) {
            addCriterion("LV_TITLE <>", value, "lvTitle");
            return this;
        }

        public Criteria andLvTitleGreaterThan(String value) {
            addCriterion("LV_TITLE >", value, "lvTitle");
            return this;
        }

        public Criteria andLvTitleGreaterThanOrEqualTo(String value) {
            addCriterion("LV_TITLE >=", value, "lvTitle");
            return this;
        }

        public Criteria andLvTitleLessThan(String value) {
            addCriterion("LV_TITLE <", value, "lvTitle");
            return this;
        }

        public Criteria andLvTitleLessThanOrEqualTo(String value) {
            addCriterion("LV_TITLE <=", value, "lvTitle");
            return this;
        }

        public Criteria andLvTitleLike(String value) {
            addCriterion("LV_TITLE like", value, "lvTitle");
            return this;
        }

        public Criteria andLvTitleNotLike(String value) {
            addCriterion("LV_TITLE not like", value, "lvTitle");
            return this;
        }

        public Criteria andLvTitleIn(List values) {
            addCriterion("LV_TITLE in", values, "lvTitle");
            return this;
        }

        public Criteria andLvTitleNotIn(List values) {
            addCriterion("LV_TITLE not in", values, "lvTitle");
            return this;
        }

        public Criteria andLvTitleBetween(String value1, String value2) {
            addCriterion("LV_TITLE between", value1, value2, "lvTitle");
            return this;
        }

        public Criteria andLvTitleNotBetween(String value1, String value2) {
            addCriterion("LV_TITLE not between", value1, value2, "lvTitle");
            return this;
        }

        public Criteria andPhoneNoIsNull() {
            addCriterion("PHONE_NO is null");
            return this;
        }

        public Criteria andPhoneNoIsNotNull() {
            addCriterion("PHONE_NO is not null");
            return this;
        }

        public Criteria andPhoneNoEqualTo(String value) {
            addCriterion("PHONE_NO =", value, "phoneNo");
            return this;
        }

        public Criteria andPhoneNoNotEqualTo(String value) {
            addCriterion("PHONE_NO <>", value, "phoneNo");
            return this;
        }

        public Criteria andPhoneNoGreaterThan(String value) {
            addCriterion("PHONE_NO >", value, "phoneNo");
            return this;
        }

        public Criteria andPhoneNoGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE_NO >=", value, "phoneNo");
            return this;
        }

        public Criteria andPhoneNoLessThan(String value) {
            addCriterion("PHONE_NO <", value, "phoneNo");
            return this;
        }

        public Criteria andPhoneNoLessThanOrEqualTo(String value) {
            addCriterion("PHONE_NO <=", value, "phoneNo");
            return this;
        }

        public Criteria andPhoneNoLike(String value) {
            addCriterion("PHONE_NO like", value, "phoneNo");
            return this;
        }

        public Criteria andPhoneNoNotLike(String value) {
            addCriterion("PHONE_NO not like", value, "phoneNo");
            return this;
        }

        public Criteria andPhoneNoIn(List values) {
            addCriterion("PHONE_NO in", values, "phoneNo");
            return this;
        }

        public Criteria andPhoneNoNotIn(List values) {
            addCriterion("PHONE_NO not in", values, "phoneNo");
            return this;
        }

        public Criteria andPhoneNoBetween(String value1, String value2) {
            addCriterion("PHONE_NO between", value1, value2, "phoneNo");
            return this;
        }

        public Criteria andPhoneNoNotBetween(String value1, String value2) {
            addCriterion("PHONE_NO not between", value1, value2, "phoneNo");
            return this;
        }

        public Criteria andLvTypeIsNull() {
            addCriterion("LV_TYPE is null");
            return this;
        }

        public Criteria andLvTypeIsNotNull() {
            addCriterion("LV_TYPE is not null");
            return this;
        }

        public Criteria andLvTypeEqualTo(String value) {
            addCriterion("LV_TYPE =", value, "lvType");
            return this;
        }

        public Criteria andLvTypeNotEqualTo(String value) {
            addCriterion("LV_TYPE <>", value, "lvType");
            return this;
        }

        public Criteria andLvTypeGreaterThan(String value) {
            addCriterion("LV_TYPE >", value, "lvType");
            return this;
        }

        public Criteria andLvTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LV_TYPE >=", value, "lvType");
            return this;
        }

        public Criteria andLvTypeLessThan(String value) {
            addCriterion("LV_TYPE <", value, "lvType");
            return this;
        }

        public Criteria andLvTypeLessThanOrEqualTo(String value) {
            addCriterion("LV_TYPE <=", value, "lvType");
            return this;
        }

        public Criteria andLvTypeLike(String value) {
            addCriterion("LV_TYPE like", value, "lvType");
            return this;
        }

        public Criteria andLvTypeNotLike(String value) {
            addCriterion("LV_TYPE not like", value, "lvType");
            return this;
        }

        public Criteria andLvTypeIn(List values) {
            addCriterion("LV_TYPE in", values, "lvType");
            return this;
        }

        public Criteria andLvTypeNotIn(List values) {
            addCriterion("LV_TYPE not in", values, "lvType");
            return this;
        }

        public Criteria andLvTypeBetween(String value1, String value2) {
            addCriterion("LV_TYPE between", value1, value2, "lvType");
            return this;
        }

        public Criteria andLvTypeNotBetween(String value1, String value2) {
            addCriterion("LV_TYPE not between", value1, value2, "lvType");
            return this;
        }

        public Criteria andLvReasonIsNull() {
            addCriterion("LV_REASON is null");
            return this;
        }

        public Criteria andLvReasonIsNotNull() {
            addCriterion("LV_REASON is not null");
            return this;
        }

        public Criteria andLvReasonEqualTo(String value) {
            addCriterion("LV_REASON =", value, "lvReason");
            return this;
        }

        public Criteria andLvReasonNotEqualTo(String value) {
            addCriterion("LV_REASON <>", value, "lvReason");
            return this;
        }

        public Criteria andLvReasonGreaterThan(String value) {
            addCriterion("LV_REASON >", value, "lvReason");
            return this;
        }

        public Criteria andLvReasonGreaterThanOrEqualTo(String value) {
            addCriterion("LV_REASON >=", value, "lvReason");
            return this;
        }

        public Criteria andLvReasonLessThan(String value) {
            addCriterion("LV_REASON <", value, "lvReason");
            return this;
        }

        public Criteria andLvReasonLessThanOrEqualTo(String value) {
            addCriterion("LV_REASON <=", value, "lvReason");
            return this;
        }

        public Criteria andLvReasonLike(String value) {
            addCriterion("LV_REASON like", value, "lvReason");
            return this;
        }

        public Criteria andLvReasonNotLike(String value) {
            addCriterion("LV_REASON not like", value, "lvReason");
            return this;
        }

        public Criteria andLvReasonIn(List values) {
            addCriterion("LV_REASON in", values, "lvReason");
            return this;
        }

        public Criteria andLvReasonNotIn(List values) {
            addCriterion("LV_REASON not in", values, "lvReason");
            return this;
        }

        public Criteria andLvReasonBetween(String value1, String value2) {
            addCriterion("LV_REASON between", value1, value2, "lvReason");
            return this;
        }

        public Criteria andLvReasonNotBetween(String value1, String value2) {
            addCriterion("LV_REASON not between", value1, value2, "lvReason");
            return this;
        }

        public Criteria andLvStartIsNull() {
            addCriterion("LV_START is null");
            return this;
        }

        public Criteria andLvStartIsNotNull() {
            addCriterion("LV_START is not null");
            return this;
        }

        public Criteria andLvStartEqualTo(String value) {
            addCriterion("LV_START =", value, "lvStart");
            return this;
        }

        public Criteria andLvStartNotEqualTo(String value) {
            addCriterion("LV_START <>", value, "lvStart");
            return this;
        }

        public Criteria andLvStartGreaterThan(String value) {
            addCriterion("LV_START >", value, "lvStart");
            return this;
        }

        public Criteria andLvStartGreaterThanOrEqualTo(String value) {
            addCriterion("LV_START >=", value, "lvStart");
            return this;
        }

        public Criteria andLvStartLessThan(String value) {
            addCriterion("LV_START <", value, "lvStart");
            return this;
        }

        public Criteria andLvStartLessThanOrEqualTo(String value) {
            addCriterion("LV_START <=", value, "lvStart");
            return this;
        }

        public Criteria andLvStartLike(String value) {
            addCriterion("LV_START like", value, "lvStart");
            return this;
        }

        public Criteria andLvStartNotLike(String value) {
            addCriterion("LV_START not like", value, "lvStart");
            return this;
        }

        public Criteria andLvStartIn(List values) {
            addCriterion("LV_START in", values, "lvStart");
            return this;
        }

        public Criteria andLvStartNotIn(List values) {
            addCriterion("LV_START not in", values, "lvStart");
            return this;
        }

        public Criteria andLvStartBetween(String value1, String value2) {
            addCriterion("LV_START between", value1, value2, "lvStart");
            return this;
        }

        public Criteria andLvStartNotBetween(String value1, String value2) {
            addCriterion("LV_START not between", value1, value2, "lvStart");
            return this;
        }

        public Criteria andLvDaysIsNull() {
            addCriterion("LV_DAYS is null");
            return this;
        }

        public Criteria andLvDaysIsNotNull() {
            addCriterion("LV_DAYS is not null");
            return this;
        }

        public Criteria andLvDaysEqualTo(String value) {
            addCriterion("LV_DAYS =", value, "lvDays");
            return this;
        }

        public Criteria andLvDaysNotEqualTo(String value) {
            addCriterion("LV_DAYS <>", value, "lvDays");
            return this;
        }

        public Criteria andLvDaysGreaterThan(String value) {
            addCriterion("LV_DAYS >", value, "lvDays");
            return this;
        }

        public Criteria andLvDaysGreaterThanOrEqualTo(String value) {
            addCriterion("LV_DAYS >=", value, "lvDays");
            return this;
        }

        public Criteria andLvDaysLessThan(String value) {
            addCriterion("LV_DAYS <", value, "lvDays");
            return this;
        }

        public Criteria andLvDaysLessThanOrEqualTo(String value) {
            addCriterion("LV_DAYS <=", value, "lvDays");
            return this;
        }

        public Criteria andLvDaysLike(String value) {
            addCriterion("LV_DAYS like", value, "lvDays");
            return this;
        }

        public Criteria andLvDaysNotLike(String value) {
            addCriterion("LV_DAYS not like", value, "lvDays");
            return this;
        }

        public Criteria andLvDaysIn(List values) {
            addCriterion("LV_DAYS in", values, "lvDays");
            return this;
        }

        public Criteria andLvDaysNotIn(List values) {
            addCriterion("LV_DAYS not in", values, "lvDays");
            return this;
        }

        public Criteria andLvDaysBetween(String value1, String value2) {
            addCriterion("LV_DAYS between", value1, value2, "lvDays");
            return this;
        }

        public Criteria andLvDaysNotBetween(String value1, String value2) {
            addCriterion("LV_DAYS not between", value1, value2, "lvDays");
            return this;
        }

        public Criteria andAtimeIsNull() {
            addCriterion("ATIME is null");
            return this;
        }

        public Criteria andAtimeIsNotNull() {
            addCriterion("ATIME is not null");
            return this;
        }

        public Criteria andAtimeEqualTo(String value) {
            addCriterion("ATIME =", value, "atime");
            return this;
        }

        public Criteria andAtimeNotEqualTo(String value) {
            addCriterion("ATIME <>", value, "atime");
            return this;
        }

        public Criteria andAtimeGreaterThan(String value) {
            addCriterion("ATIME >", value, "atime");
            return this;
        }

        public Criteria andAtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ATIME >=", value, "atime");
            return this;
        }

        public Criteria andAtimeLessThan(String value) {
            addCriterion("ATIME <", value, "atime");
            return this;
        }

        public Criteria andAtimeLessThanOrEqualTo(String value) {
            addCriterion("ATIME <=", value, "atime");
            return this;
        }

        public Criteria andAtimeLike(String value) {
            addCriterion("ATIME like", value, "atime");
            return this;
        }

        public Criteria andAtimeNotLike(String value) {
            addCriterion("ATIME not like", value, "atime");
            return this;
        }

        public Criteria andAtimeIn(List values) {
            addCriterion("ATIME in", values, "atime");
            return this;
        }

        public Criteria andAtimeNotIn(List values) {
            addCriterion("ATIME not in", values, "atime");
            return this;
        }

        public Criteria andAtimeBetween(String value1, String value2) {
            addCriterion("ATIME between", value1, value2, "atime");
            return this;
        }

        public Criteria andAtimeNotBetween(String value1, String value2) {
            addCriterion("ATIME not between", value1, value2, "atime");
            return this;
        }
    }
}