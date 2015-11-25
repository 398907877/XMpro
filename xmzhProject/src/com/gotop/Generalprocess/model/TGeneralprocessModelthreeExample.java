package com.gotop.Generalprocess.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class TGeneralprocessModelthreeExample {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TGeneralprocessModelthreeExample.class);

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
    public TGeneralprocessModelthreeExample() {
        oredCriteria = new ArrayList();
    }

    /** * @abatorgenerated  */
    protected TGeneralprocessModelthreeExample(TGeneralprocessModelthreeExample example) {
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
     * This class corresponds to the database table T_GENERALPROCESS_MODELTHREE
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

        public Criteria andProcessmodelidIsNull() {
            addCriterion("PROCESSMODELID is null");
            return this;
        }

        public Criteria andProcessmodelidIsNotNull() {
            addCriterion("PROCESSMODELID is not null");
            return this;
        }

        public Criteria andProcessmodelidEqualTo(BigDecimal value) {
            addCriterion("PROCESSMODELID =", value, "processmodelid");
            return this;
        }

        public Criteria andProcessmodelidNotEqualTo(BigDecimal value) {
            addCriterion("PROCESSMODELID <>", value, "processmodelid");
            return this;
        }

        public Criteria andProcessmodelidGreaterThan(BigDecimal value) {
            addCriterion("PROCESSMODELID >", value, "processmodelid");
            return this;
        }

        public Criteria andProcessmodelidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROCESSMODELID >=", value, "processmodelid");
            return this;
        }

        public Criteria andProcessmodelidLessThan(BigDecimal value) {
            addCriterion("PROCESSMODELID <", value, "processmodelid");
            return this;
        }

        public Criteria andProcessmodelidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROCESSMODELID <=", value, "processmodelid");
            return this;
        }

        public Criteria andProcessmodelidIn(List values) {
            addCriterion("PROCESSMODELID in", values, "processmodelid");
            return this;
        }

        public Criteria andProcessmodelidNotIn(List values) {
            addCriterion("PROCESSMODELID not in", values, "processmodelid");
            return this;
        }

        public Criteria andProcessmodelidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROCESSMODELID between", value1, value2, "processmodelid");
            return this;
        }

        public Criteria andProcessmodelidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROCESSMODELID not between", value1, value2, "processmodelid");
            return this;
        }

        public Criteria andFlowIdIsNull() {
            addCriterion("FLOW_ID is null");
            return this;
        }

        public Criteria andFlowIdIsNotNull() {
            addCriterion("FLOW_ID is not null");
            return this;
        }

        public Criteria andFlowIdEqualTo(String value) {
            addCriterion("FLOW_ID =", value, "flowId");
            return this;
        }

        public Criteria andFlowIdNotEqualTo(String value) {
            addCriterion("FLOW_ID <>", value, "flowId");
            return this;
        }

        public Criteria andFlowIdGreaterThan(String value) {
            addCriterion("FLOW_ID >", value, "flowId");
            return this;
        }

        public Criteria andFlowIdGreaterThanOrEqualTo(String value) {
            addCriterion("FLOW_ID >=", value, "flowId");
            return this;
        }

        public Criteria andFlowIdLessThan(String value) {
            addCriterion("FLOW_ID <", value, "flowId");
            return this;
        }

        public Criteria andFlowIdLessThanOrEqualTo(String value) {
            addCriterion("FLOW_ID <=", value, "flowId");
            return this;
        }

        public Criteria andFlowIdLike(String value) {
            addCriterion("FLOW_ID like", value, "flowId");
            return this;
        }

        public Criteria andFlowIdNotLike(String value) {
            addCriterion("FLOW_ID not like", value, "flowId");
            return this;
        }

        public Criteria andFlowIdIn(List values) {
            addCriterion("FLOW_ID in", values, "flowId");
            return this;
        }

        public Criteria andFlowIdNotIn(List values) {
            addCriterion("FLOW_ID not in", values, "flowId");
            return this;
        }

        public Criteria andFlowIdBetween(String value1, String value2) {
            addCriterion("FLOW_ID between", value1, value2, "flowId");
            return this;
        }

        public Criteria andFlowIdNotBetween(String value1, String value2) {
            addCriterion("FLOW_ID not between", value1, value2, "flowId");
            return this;
        }

        public Criteria andIsurgentIsNull() {
            addCriterion("ISURGENT is null");
            return this;
        }

        public Criteria andIsurgentIsNotNull() {
            addCriterion("ISURGENT is not null");
            return this;
        }

        public Criteria andIsurgentEqualTo(String value) {
            addCriterion("ISURGENT =", value, "isurgent");
            return this;
        }

        public Criteria andIsurgentNotEqualTo(String value) {
            addCriterion("ISURGENT <>", value, "isurgent");
            return this;
        }

        public Criteria andIsurgentGreaterThan(String value) {
            addCriterion("ISURGENT >", value, "isurgent");
            return this;
        }

        public Criteria andIsurgentGreaterThanOrEqualTo(String value) {
            addCriterion("ISURGENT >=", value, "isurgent");
            return this;
        }

        public Criteria andIsurgentLessThan(String value) {
            addCriterion("ISURGENT <", value, "isurgent");
            return this;
        }

        public Criteria andIsurgentLessThanOrEqualTo(String value) {
            addCriterion("ISURGENT <=", value, "isurgent");
            return this;
        }

        public Criteria andIsurgentLike(String value) {
            addCriterion("ISURGENT like", value, "isurgent");
            return this;
        }

        public Criteria andIsurgentNotLike(String value) {
            addCriterion("ISURGENT not like", value, "isurgent");
            return this;
        }

        public Criteria andIsurgentIn(List values) {
            addCriterion("ISURGENT in", values, "isurgent");
            return this;
        }

        public Criteria andIsurgentNotIn(List values) {
            addCriterion("ISURGENT not in", values, "isurgent");
            return this;
        }

        public Criteria andIsurgentBetween(String value1, String value2) {
            addCriterion("ISURGENT between", value1, value2, "isurgent");
            return this;
        }

        public Criteria andIsurgentNotBetween(String value1, String value2) {
            addCriterion("ISURGENT not between", value1, value2, "isurgent");
            return this;
        }

        public Criteria andOpninionContentIsNull() {
            addCriterion("OPNINION_CONTENT is null");
            return this;
        }

        public Criteria andOpninionContentIsNotNull() {
            addCriterion("OPNINION_CONTENT is not null");
            return this;
        }

        public Criteria andOpninionContentEqualTo(String value) {
            addCriterion("OPNINION_CONTENT =", value, "opninionContent");
            return this;
        }

        public Criteria andOpninionContentNotEqualTo(String value) {
            addCriterion("OPNINION_CONTENT <>", value, "opninionContent");
            return this;
        }

        public Criteria andOpninionContentGreaterThan(String value) {
            addCriterion("OPNINION_CONTENT >", value, "opninionContent");
            return this;
        }

        public Criteria andOpninionContentGreaterThanOrEqualTo(String value) {
            addCriterion("OPNINION_CONTENT >=", value, "opninionContent");
            return this;
        }

        public Criteria andOpninionContentLessThan(String value) {
            addCriterion("OPNINION_CONTENT <", value, "opninionContent");
            return this;
        }

        public Criteria andOpninionContentLessThanOrEqualTo(String value) {
            addCriterion("OPNINION_CONTENT <=", value, "opninionContent");
            return this;
        }

        public Criteria andOpninionContentLike(String value) {
            addCriterion("OPNINION_CONTENT like", value, "opninionContent");
            return this;
        }

        public Criteria andOpninionContentNotLike(String value) {
            addCriterion("OPNINION_CONTENT not like", value, "opninionContent");
            return this;
        }

        public Criteria andOpninionContentIn(List values) {
            addCriterion("OPNINION_CONTENT in", values, "opninionContent");
            return this;
        }

        public Criteria andOpninionContentNotIn(List values) {
            addCriterion("OPNINION_CONTENT not in", values, "opninionContent");
            return this;
        }

        public Criteria andOpninionContentBetween(String value1, String value2) {
            addCriterion("OPNINION_CONTENT between", value1, value2, "opninionContent");
            return this;
        }

        public Criteria andOpninionContentNotBetween(String value1, String value2) {
            addCriterion("OPNINION_CONTENT not between", value1, value2, "opninionContent");
            return this;
        }

        public Criteria andTasknameIsNull() {
            addCriterion("TASKNAME is null");
            return this;
        }

        public Criteria andTasknameIsNotNull() {
            addCriterion("TASKNAME is not null");
            return this;
        }

        public Criteria andTasknameEqualTo(String value) {
            addCriterion("TASKNAME =", value, "taskname");
            return this;
        }

        public Criteria andTasknameNotEqualTo(String value) {
            addCriterion("TASKNAME <>", value, "taskname");
            return this;
        }

        public Criteria andTasknameGreaterThan(String value) {
            addCriterion("TASKNAME >", value, "taskname");
            return this;
        }

        public Criteria andTasknameGreaterThanOrEqualTo(String value) {
            addCriterion("TASKNAME >=", value, "taskname");
            return this;
        }

        public Criteria andTasknameLessThan(String value) {
            addCriterion("TASKNAME <", value, "taskname");
            return this;
        }

        public Criteria andTasknameLessThanOrEqualTo(String value) {
            addCriterion("TASKNAME <=", value, "taskname");
            return this;
        }

        public Criteria andTasknameLike(String value) {
            addCriterion("TASKNAME like", value, "taskname");
            return this;
        }

        public Criteria andTasknameNotLike(String value) {
            addCriterion("TASKNAME not like", value, "taskname");
            return this;
        }

        public Criteria andTasknameIn(List values) {
            addCriterion("TASKNAME in", values, "taskname");
            return this;
        }

        public Criteria andTasknameNotIn(List values) {
            addCriterion("TASKNAME not in", values, "taskname");
            return this;
        }

        public Criteria andTasknameBetween(String value1, String value2) {
            addCriterion("TASKNAME between", value1, value2, "taskname");
            return this;
        }

        public Criteria andTasknameNotBetween(String value1, String value2) {
            addCriterion("TASKNAME not between", value1, value2, "taskname");
            return this;
        }

        public Criteria andReporttimeIsNull() {
            addCriterion("REPORTTIME is null");
            return this;
        }

        public Criteria andReporttimeIsNotNull() {
            addCriterion("REPORTTIME is not null");
            return this;
        }

        public Criteria andReporttimeEqualTo(String value) {
            addCriterion("REPORTTIME =", value, "reporttime");
            return this;
        }

        public Criteria andReporttimeNotEqualTo(String value) {
            addCriterion("REPORTTIME <>", value, "reporttime");
            return this;
        }

        public Criteria andReporttimeGreaterThan(String value) {
            addCriterion("REPORTTIME >", value, "reporttime");
            return this;
        }

        public Criteria andReporttimeGreaterThanOrEqualTo(String value) {
            addCriterion("REPORTTIME >=", value, "reporttime");
            return this;
        }

        public Criteria andReporttimeLessThan(String value) {
            addCriterion("REPORTTIME <", value, "reporttime");
            return this;
        }

        public Criteria andReporttimeLessThanOrEqualTo(String value) {
            addCriterion("REPORTTIME <=", value, "reporttime");
            return this;
        }

        public Criteria andReporttimeLike(String value) {
            addCriterion("REPORTTIME like", value, "reporttime");
            return this;
        }

        public Criteria andReporttimeNotLike(String value) {
            addCriterion("REPORTTIME not like", value, "reporttime");
            return this;
        }

        public Criteria andReporttimeIn(List values) {
            addCriterion("REPORTTIME in", values, "reporttime");
            return this;
        }

        public Criteria andReporttimeNotIn(List values) {
            addCriterion("REPORTTIME not in", values, "reporttime");
            return this;
        }

        public Criteria andReporttimeBetween(String value1, String value2) {
            addCriterion("REPORTTIME between", value1, value2, "reporttime");
            return this;
        }

        public Criteria andReporttimeNotBetween(String value1, String value2) {
            addCriterion("REPORTTIME not between", value1, value2, "reporttime");
            return this;
        }

        public Criteria andReportcntIsNull() {
            addCriterion("REPORTCNT is null");
            return this;
        }

        public Criteria andReportcntIsNotNull() {
            addCriterion("REPORTCNT is not null");
            return this;
        }

        public Criteria andReportcntEqualTo(String value) {
            addCriterion("REPORTCNT =", value, "reportcnt");
            return this;
        }

        public Criteria andReportcntNotEqualTo(String value) {
            addCriterion("REPORTCNT <>", value, "reportcnt");
            return this;
        }

        public Criteria andReportcntGreaterThan(String value) {
            addCriterion("REPORTCNT >", value, "reportcnt");
            return this;
        }

        public Criteria andReportcntGreaterThanOrEqualTo(String value) {
            addCriterion("REPORTCNT >=", value, "reportcnt");
            return this;
        }

        public Criteria andReportcntLessThan(String value) {
            addCriterion("REPORTCNT <", value, "reportcnt");
            return this;
        }

        public Criteria andReportcntLessThanOrEqualTo(String value) {
            addCriterion("REPORTCNT <=", value, "reportcnt");
            return this;
        }

        public Criteria andReportcntLike(String value) {
            addCriterion("REPORTCNT like", value, "reportcnt");
            return this;
        }

        public Criteria andReportcntNotLike(String value) {
            addCriterion("REPORTCNT not like", value, "reportcnt");
            return this;
        }

        public Criteria andReportcntIn(List values) {
            addCriterion("REPORTCNT in", values, "reportcnt");
            return this;
        }

        public Criteria andReportcntNotIn(List values) {
            addCriterion("REPORTCNT not in", values, "reportcnt");
            return this;
        }

        public Criteria andReportcntBetween(String value1, String value2) {
            addCriterion("REPORTCNT between", value1, value2, "reportcnt");
            return this;
        }

        public Criteria andReportcntNotBetween(String value1, String value2) {
            addCriterion("REPORTCNT not between", value1, value2, "reportcnt");
            return this;
        }
    }
}