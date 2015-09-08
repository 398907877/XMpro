package com.gotop.jbpm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class TProcessTaskAssigneeExample {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TProcessTaskAssigneeExample.class);

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
    public TProcessTaskAssigneeExample() {
        oredCriteria = new ArrayList();
    }

    /** * @abatorgenerated  */
    protected TProcessTaskAssigneeExample(TProcessTaskAssigneeExample example) {
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
     * This class corresponds to the database table T_PROCESS_TASK_ASSIGNEE
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

        public Criteria andExecutionIdIsNull() {
            addCriterion("EXECUTION_ID is null");
            return this;
        }

        public Criteria andExecutionIdIsNotNull() {
            addCriterion("EXECUTION_ID is not null");
            return this;
        }

        public Criteria andExecutionIdEqualTo(String value) {
            addCriterion("EXECUTION_ID =", value, "executionId");
            return this;
        }

        public Criteria andExecutionIdNotEqualTo(String value) {
            addCriterion("EXECUTION_ID <>", value, "executionId");
            return this;
        }

        public Criteria andExecutionIdGreaterThan(String value) {
            addCriterion("EXECUTION_ID >", value, "executionId");
            return this;
        }

        public Criteria andExecutionIdGreaterThanOrEqualTo(String value) {
            addCriterion("EXECUTION_ID >=", value, "executionId");
            return this;
        }

        public Criteria andExecutionIdLessThan(String value) {
            addCriterion("EXECUTION_ID <", value, "executionId");
            return this;
        }

        public Criteria andExecutionIdLessThanOrEqualTo(String value) {
            addCriterion("EXECUTION_ID <=", value, "executionId");
            return this;
        }

        public Criteria andExecutionIdLike(String value) {
            addCriterion("EXECUTION_ID like", value, "executionId");
            return this;
        }

        public Criteria andExecutionIdNotLike(String value) {
            addCriterion("EXECUTION_ID not like", value, "executionId");
            return this;
        }

        public Criteria andExecutionIdIn(List values) {
            addCriterion("EXECUTION_ID in", values, "executionId");
            return this;
        }

        public Criteria andExecutionIdNotIn(List values) {
            addCriterion("EXECUTION_ID not in", values, "executionId");
            return this;
        }

        public Criteria andExecutionIdBetween(String value1, String value2) {
            addCriterion("EXECUTION_ID between", value1, value2, "executionId");
            return this;
        }

        public Criteria andExecutionIdNotBetween(String value1, String value2) {
            addCriterion("EXECUTION_ID not between", value1, value2, "executionId");
            return this;
        }

        public Criteria andPreTaskIdIsNull() {
            addCriterion("PRE_TASK_ID is null");
            return this;
        }

        public Criteria andPreTaskIdIsNotNull() {
            addCriterion("PRE_TASK_ID is not null");
            return this;
        }

        public Criteria andPreTaskIdEqualTo(String value) {
            addCriterion("PRE_TASK_ID =", value, "preTaskId");
            return this;
        }

        public Criteria andPreTaskIdNotEqualTo(String value) {
            addCriterion("PRE_TASK_ID <>", value, "preTaskId");
            return this;
        }

        public Criteria andPreTaskIdGreaterThan(String value) {
            addCriterion("PRE_TASK_ID >", value, "preTaskId");
            return this;
        }

        public Criteria andPreTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRE_TASK_ID >=", value, "preTaskId");
            return this;
        }

        public Criteria andPreTaskIdLessThan(String value) {
            addCriterion("PRE_TASK_ID <", value, "preTaskId");
            return this;
        }

        public Criteria andPreTaskIdLessThanOrEqualTo(String value) {
            addCriterion("PRE_TASK_ID <=", value, "preTaskId");
            return this;
        }

        public Criteria andPreTaskIdLike(String value) {
            addCriterion("PRE_TASK_ID like", value, "preTaskId");
            return this;
        }

        public Criteria andPreTaskIdNotLike(String value) {
            addCriterion("PRE_TASK_ID not like", value, "preTaskId");
            return this;
        }

        public Criteria andPreTaskIdIn(List values) {
            addCriterion("PRE_TASK_ID in", values, "preTaskId");
            return this;
        }

        public Criteria andPreTaskIdNotIn(List values) {
            addCriterion("PRE_TASK_ID not in", values, "preTaskId");
            return this;
        }

        public Criteria andPreTaskIdBetween(String value1, String value2) {
            addCriterion("PRE_TASK_ID between", value1, value2, "preTaskId");
            return this;
        }

        public Criteria andPreTaskIdNotBetween(String value1, String value2) {
            addCriterion("PRE_TASK_ID not between", value1, value2, "preTaskId");
            return this;
        }

        public Criteria andPreTaskAssingeeIsNull() {
            addCriterion("PRE_TASK_ASSINGEE is null");
            return this;
        }

        public Criteria andPreTaskAssingeeIsNotNull() {
            addCriterion("PRE_TASK_ASSINGEE is not null");
            return this;
        }

        public Criteria andPreTaskAssingeeEqualTo(Long value) {
            addCriterion("PRE_TASK_ASSINGEE =", value, "preTaskAssingee");
            return this;
        }

        public Criteria andPreTaskAssingeeNotEqualTo(Long value) {
            addCriterion("PRE_TASK_ASSINGEE <>", value, "preTaskAssingee");
            return this;
        }

        public Criteria andPreTaskAssingeeGreaterThan(Long value) {
            addCriterion("PRE_TASK_ASSINGEE >", value, "preTaskAssingee");
            return this;
        }

        public Criteria andPreTaskAssingeeGreaterThanOrEqualTo(Long value) {
            addCriterion("PRE_TASK_ASSINGEE >=", value, "preTaskAssingee");
            return this;
        }

        public Criteria andPreTaskAssingeeLessThan(Long value) {
            addCriterion("PRE_TASK_ASSINGEE <", value, "preTaskAssingee");
            return this;
        }

        public Criteria andPreTaskAssingeeLessThanOrEqualTo(Long value) {
            addCriterion("PRE_TASK_ASSINGEE <=", value, "preTaskAssingee");
            return this;
        }

        public Criteria andPreTaskAssingeeIn(List values) {
            addCriterion("PRE_TASK_ASSINGEE in", values, "preTaskAssingee");
            return this;
        }

        public Criteria andPreTaskAssingeeNotIn(List values) {
            addCriterion("PRE_TASK_ASSINGEE not in", values, "preTaskAssingee");
            return this;
        }

        public Criteria andPreTaskAssingeeBetween(Long value1, Long value2) {
            addCriterion("PRE_TASK_ASSINGEE between", value1, value2, "preTaskAssingee");
            return this;
        }

        public Criteria andPreTaskAssingeeNotBetween(Long value1, Long value2) {
            addCriterion("PRE_TASK_ASSINGEE not between", value1, value2, "preTaskAssingee");
            return this;
        }

        public Criteria andPreTaskOrgIsNull() {
            addCriterion("PRE_TASK_ORG is null");
            return this;
        }

        public Criteria andPreTaskOrgIsNotNull() {
            addCriterion("PRE_TASK_ORG is not null");
            return this;
        }

        public Criteria andPreTaskOrgEqualTo(Long value) {
            addCriterion("PRE_TASK_ORG =", value, "preTaskOrg");
            return this;
        }

        public Criteria andPreTaskOrgNotEqualTo(Long value) {
            addCriterion("PRE_TASK_ORG <>", value, "preTaskOrg");
            return this;
        }

        public Criteria andPreTaskOrgGreaterThan(Long value) {
            addCriterion("PRE_TASK_ORG >", value, "preTaskOrg");
            return this;
        }

        public Criteria andPreTaskOrgGreaterThanOrEqualTo(Long value) {
            addCriterion("PRE_TASK_ORG >=", value, "preTaskOrg");
            return this;
        }

        public Criteria andPreTaskOrgLessThan(Long value) {
            addCriterion("PRE_TASK_ORG <", value, "preTaskOrg");
            return this;
        }

        public Criteria andPreTaskOrgLessThanOrEqualTo(Long value) {
            addCriterion("PRE_TASK_ORG <=", value, "preTaskOrg");
            return this;
        }

        public Criteria andPreTaskOrgIn(List values) {
            addCriterion("PRE_TASK_ORG in", values, "preTaskOrg");
            return this;
        }

        public Criteria andPreTaskOrgNotIn(List values) {
            addCriterion("PRE_TASK_ORG not in", values, "preTaskOrg");
            return this;
        }

        public Criteria andPreTaskOrgBetween(Long value1, Long value2) {
            addCriterion("PRE_TASK_ORG between", value1, value2, "preTaskOrg");
            return this;
        }

        public Criteria andPreTaskOrgNotBetween(Long value1, Long value2) {
            addCriterion("PRE_TASK_ORG not between", value1, value2, "preTaskOrg");
            return this;
        }

        public Criteria andPreTaskTimeIsNull() {
            addCriterion("PRE_TASK_TIME is null");
            return this;
        }

        public Criteria andPreTaskTimeIsNotNull() {
            addCriterion("PRE_TASK_TIME is not null");
            return this;
        }

        public Criteria andPreTaskTimeEqualTo(String value) {
            addCriterion("PRE_TASK_TIME =", value, "preTaskTime");
            return this;
        }

        public Criteria andPreTaskTimeNotEqualTo(String value) {
            addCriterion("PRE_TASK_TIME <>", value, "preTaskTime");
            return this;
        }

        public Criteria andPreTaskTimeGreaterThan(String value) {
            addCriterion("PRE_TASK_TIME >", value, "preTaskTime");
            return this;
        }

        public Criteria andPreTaskTimeGreaterThanOrEqualTo(String value) {
            addCriterion("PRE_TASK_TIME >=", value, "preTaskTime");
            return this;
        }

        public Criteria andPreTaskTimeLessThan(String value) {
            addCriterion("PRE_TASK_TIME <", value, "preTaskTime");
            return this;
        }

        public Criteria andPreTaskTimeLessThanOrEqualTo(String value) {
            addCriterion("PRE_TASK_TIME <=", value, "preTaskTime");
            return this;
        }

        public Criteria andPreTaskTimeLike(String value) {
            addCriterion("PRE_TASK_TIME like", value, "preTaskTime");
            return this;
        }

        public Criteria andPreTaskTimeNotLike(String value) {
            addCriterion("PRE_TASK_TIME not like", value, "preTaskTime");
            return this;
        }

        public Criteria andPreTaskTimeIn(List values) {
            addCriterion("PRE_TASK_TIME in", values, "preTaskTime");
            return this;
        }

        public Criteria andPreTaskTimeNotIn(List values) {
            addCriterion("PRE_TASK_TIME not in", values, "preTaskTime");
            return this;
        }

        public Criteria andPreTaskTimeBetween(String value1, String value2) {
            addCriterion("PRE_TASK_TIME between", value1, value2, "preTaskTime");
            return this;
        }

        public Criteria andPreTaskTimeNotBetween(String value1, String value2) {
            addCriterion("PRE_TASK_TIME not between", value1, value2, "preTaskTime");
            return this;
        }

        public Criteria andNextTaskIdIsNull() {
            addCriterion("NEXT_TASK_ID is null");
            return this;
        }

        public Criteria andNextTaskIdIsNotNull() {
            addCriterion("NEXT_TASK_ID is not null");
            return this;
        }

        public Criteria andNextTaskIdEqualTo(String value) {
            addCriterion("NEXT_TASK_ID =", value, "nextTaskId");
            return this;
        }

        public Criteria andNextTaskIdNotEqualTo(String value) {
            addCriterion("NEXT_TASK_ID <>", value, "nextTaskId");
            return this;
        }

        public Criteria andNextTaskIdGreaterThan(String value) {
            addCriterion("NEXT_TASK_ID >", value, "nextTaskId");
            return this;
        }

        public Criteria andNextTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("NEXT_TASK_ID >=", value, "nextTaskId");
            return this;
        }

        public Criteria andNextTaskIdLessThan(String value) {
            addCriterion("NEXT_TASK_ID <", value, "nextTaskId");
            return this;
        }

        public Criteria andNextTaskIdLessThanOrEqualTo(String value) {
            addCriterion("NEXT_TASK_ID <=", value, "nextTaskId");
            return this;
        }

        public Criteria andNextTaskIdLike(String value) {
            addCriterion("NEXT_TASK_ID like", value, "nextTaskId");
            return this;
        }

        public Criteria andNextTaskIdNotLike(String value) {
            addCriterion("NEXT_TASK_ID not like", value, "nextTaskId");
            return this;
        }

        public Criteria andNextTaskIdIn(List values) {
            addCriterion("NEXT_TASK_ID in", values, "nextTaskId");
            return this;
        }

        public Criteria andNextTaskIdNotIn(List values) {
            addCriterion("NEXT_TASK_ID not in", values, "nextTaskId");
            return this;
        }

        public Criteria andNextTaskIdBetween(String value1, String value2) {
            addCriterion("NEXT_TASK_ID between", value1, value2, "nextTaskId");
            return this;
        }

        public Criteria andNextTaskIdNotBetween(String value1, String value2) {
            addCriterion("NEXT_TASK_ID not between", value1, value2, "nextTaskId");
            return this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("TASK_ID is null");
            return this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("TASK_ID is not null");
            return this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("TASK_ID =", value, "taskId");
            return this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("TASK_ID <>", value, "taskId");
            return this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("TASK_ID >", value, "taskId");
            return this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_ID >=", value, "taskId");
            return this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("TASK_ID <", value, "taskId");
            return this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("TASK_ID <=", value, "taskId");
            return this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("TASK_ID like", value, "taskId");
            return this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("TASK_ID not like", value, "taskId");
            return this;
        }

        public Criteria andTaskIdIn(List values) {
            addCriterion("TASK_ID in", values, "taskId");
            return this;
        }

        public Criteria andTaskIdNotIn(List values) {
            addCriterion("TASK_ID not in", values, "taskId");
            return this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("TASK_ID between", value1, value2, "taskId");
            return this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("TASK_ID not between", value1, value2, "taskId");
            return this;
        }

        public Criteria andBusinessKeyIsNull() {
            addCriterion("BUSINESS_KEY is null");
            return this;
        }

        public Criteria andBusinessKeyIsNotNull() {
            addCriterion("BUSINESS_KEY is not null");
            return this;
        }

        public Criteria andBusinessKeyEqualTo(Long value) {
            addCriterion("BUSINESS_KEY =", value, "businessKey");
            return this;
        }

        public Criteria andBusinessKeyNotEqualTo(Long value) {
            addCriterion("BUSINESS_KEY <>", value, "businessKey");
            return this;
        }

        public Criteria andBusinessKeyGreaterThan(Long value) {
            addCriterion("BUSINESS_KEY >", value, "businessKey");
            return this;
        }

        public Criteria andBusinessKeyGreaterThanOrEqualTo(Long value) {
            addCriterion("BUSINESS_KEY >=", value, "businessKey");
            return this;
        }

        public Criteria andBusinessKeyLessThan(Long value) {
            addCriterion("BUSINESS_KEY <", value, "businessKey");
            return this;
        }

        public Criteria andBusinessKeyLessThanOrEqualTo(Long value) {
            addCriterion("BUSINESS_KEY <=", value, "businessKey");
            return this;
        }

        public Criteria andBusinessKeyIn(List values) {
            addCriterion("BUSINESS_KEY in", values, "businessKey");
            return this;
        }

        public Criteria andBusinessKeyNotIn(List values) {
            addCriterion("BUSINESS_KEY not in", values, "businessKey");
            return this;
        }

        public Criteria andBusinessKeyBetween(Long value1, Long value2) {
            addCriterion("BUSINESS_KEY between", value1, value2, "businessKey");
            return this;
        }

        public Criteria andBusinessKeyNotBetween(Long value1, Long value2) {
            addCriterion("BUSINESS_KEY not between", value1, value2, "businessKey");
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
    }
}