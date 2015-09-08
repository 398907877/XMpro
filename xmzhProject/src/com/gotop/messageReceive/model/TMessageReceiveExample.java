package com.gotop.messageReceive.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class TMessageReceiveExample {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TMessageReceiveExample.class);

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

    /** */
    public TMessageReceiveExample() {
        oredCriteria = new ArrayList();
    }

    /** */
    protected TMessageReceiveExample(TMessageReceiveExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.oracleStart = example.oracleStart;
        this.oracleEnd = example.oracleEnd;
    }

    /** */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /** */
    /** */
    public String getOrderByClause() {
        return orderByClause;
    }

    /** */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /** */
    public Integer getOracleStart() {
        return oracleStart;
    }

    /** */
    public void setOracleStart(Integer oracleStart) {
        this.oracleStart = oracleStart;
    }

    /** */
    public Integer getOracleEnd() {
        return oracleEnd;
    }

    /** */
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
     * This class corresponds to the database table XMZHPT.T_MESSAGE_RECEIVE
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

        public Criteria andRecIdIsNull() {
            addCriterion("REC_ID is null");
            return this;
        }

        public Criteria andRecIdIsNotNull() {
            addCriterion("REC_ID is not null");
            return this;
        }

        public Criteria andRecIdEqualTo(Long value) {
            addCriterion("REC_ID =", value, "recId");
            return this;
        }

        public Criteria andRecIdNotEqualTo(Long value) {
            addCriterion("REC_ID <>", value, "recId");
            return this;
        }

        public Criteria andRecIdGreaterThan(Long value) {
            addCriterion("REC_ID >", value, "recId");
            return this;
        }

        public Criteria andRecIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REC_ID >=", value, "recId");
            return this;
        }

        public Criteria andRecIdLessThan(Long value) {
            addCriterion("REC_ID <", value, "recId");
            return this;
        }

        public Criteria andRecIdLessThanOrEqualTo(Long value) {
            addCriterion("REC_ID <=", value, "recId");
            return this;
        }

        public Criteria andRecIdIn(List values) {
            addCriterion("REC_ID in", values, "recId");
            return this;
        }

        public Criteria andRecIdNotIn(List values) {
            addCriterion("REC_ID not in", values, "recId");
            return this;
        }

        public Criteria andRecIdBetween(Long value1, Long value2) {
            addCriterion("REC_ID between", value1, value2, "recId");
            return this;
        }

        public Criteria andRecIdNotBetween(Long value1, Long value2) {
            addCriterion("REC_ID not between", value1, value2, "recId");
            return this;
        }

        public Criteria andMessageIdIsNull() {
            addCriterion("MESSAGE_ID is null");
            return this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("MESSAGE_ID is not null");
            return this;
        }

        public Criteria andMessageIdEqualTo(Long value) {
            addCriterion("MESSAGE_ID =", value, "messageId");
            return this;
        }

        public Criteria andMessageIdNotEqualTo(Long value) {
            addCriterion("MESSAGE_ID <>", value, "messageId");
            return this;
        }

        public Criteria andMessageIdGreaterThan(Long value) {
            addCriterion("MESSAGE_ID >", value, "messageId");
            return this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MESSAGE_ID >=", value, "messageId");
            return this;
        }

        public Criteria andMessageIdLessThan(Long value) {
            addCriterion("MESSAGE_ID <", value, "messageId");
            return this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(Long value) {
            addCriterion("MESSAGE_ID <=", value, "messageId");
            return this;
        }

        public Criteria andMessageIdIn(List values) {
            addCriterion("MESSAGE_ID in", values, "messageId");
            return this;
        }

        public Criteria andMessageIdNotIn(List values) {
            addCriterion("MESSAGE_ID not in", values, "messageId");
            return this;
        }

        public Criteria andMessageIdBetween(Long value1, Long value2) {
            addCriterion("MESSAGE_ID between", value1, value2, "messageId");
            return this;
        }

        public Criteria andMessageIdNotBetween(Long value1, Long value2) {
            addCriterion("MESSAGE_ID not between", value1, value2, "messageId");
            return this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return this;
        }

        public Criteria andTypeIn(List values) {
            addCriterion("TYPE in", values, "type");
            return this;
        }

        public Criteria andTypeNotIn(List values) {
            addCriterion("TYPE not in", values, "type");
            return this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return this;
        }

        public Criteria andReceiveObjectIsNull() {
            addCriterion("RECEIVE_OBJECT is null");
            return this;
        }

        public Criteria andReceiveObjectIsNotNull() {
            addCriterion("RECEIVE_OBJECT is not null");
            return this;
        }

        public Criteria andReceiveObjectEqualTo(String value) {
            addCriterion("RECEIVE_OBJECT =", value, "receiveObject");
            return this;
        }

        public Criteria andReceiveObjectNotEqualTo(String value) {
            addCriterion("RECEIVE_OBJECT <>", value, "receiveObject");
            return this;
        }

        public Criteria andReceiveObjectGreaterThan(String value) {
            addCriterion("RECEIVE_OBJECT >", value, "receiveObject");
            return this;
        }

        public Criteria andReceiveObjectGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_OBJECT >=", value, "receiveObject");
            return this;
        }

        public Criteria andReceiveObjectLessThan(String value) {
            addCriterion("RECEIVE_OBJECT <", value, "receiveObject");
            return this;
        }

        public Criteria andReceiveObjectLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_OBJECT <=", value, "receiveObject");
            return this;
        }

        public Criteria andReceiveObjectLike(String value) {
            addCriterion("RECEIVE_OBJECT like", value, "receiveObject");
            return this;
        }

        public Criteria andReceiveObjectNotLike(String value) {
            addCriterion("RECEIVE_OBJECT not like", value, "receiveObject");
            return this;
        }

        public Criteria andReceiveObjectIn(List values) {
            addCriterion("RECEIVE_OBJECT in", values, "receiveObject");
            return this;
        }

        public Criteria andReceiveObjectNotIn(List values) {
            addCriterion("RECEIVE_OBJECT not in", values, "receiveObject");
            return this;
        }

        public Criteria andReceiveObjectBetween(String value1, String value2) {
            addCriterion("RECEIVE_OBJECT between", value1, value2, "receiveObject");
            return this;
        }

        public Criteria andReceiveObjectNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_OBJECT not between", value1, value2, "receiveObject");
            return this;
        }

        public Criteria andObjOrgcodeIsNull() {
            addCriterion("OBJ_ORGCODE is null");
            return this;
        }

        public Criteria andObjOrgcodeIsNotNull() {
            addCriterion("OBJ_ORGCODE is not null");
            return this;
        }

        public Criteria andObjOrgcodeEqualTo(String value) {
            addCriterion("OBJ_ORGCODE =", value, "objOrgcode");
            return this;
        }

        public Criteria andObjOrgcodeNotEqualTo(String value) {
            addCriterion("OBJ_ORGCODE <>", value, "objOrgcode");
            return this;
        }

        public Criteria andObjOrgcodeGreaterThan(String value) {
            addCriterion("OBJ_ORGCODE >", value, "objOrgcode");
            return this;
        }

        public Criteria andObjOrgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("OBJ_ORGCODE >=", value, "objOrgcode");
            return this;
        }

        public Criteria andObjOrgcodeLessThan(String value) {
            addCriterion("OBJ_ORGCODE <", value, "objOrgcode");
            return this;
        }

        public Criteria andObjOrgcodeLessThanOrEqualTo(String value) {
            addCriterion("OBJ_ORGCODE <=", value, "objOrgcode");
            return this;
        }

        public Criteria andObjOrgcodeLike(String value) {
            addCriterion("OBJ_ORGCODE like", value, "objOrgcode");
            return this;
        }

        public Criteria andObjOrgcodeNotLike(String value) {
            addCriterion("OBJ_ORGCODE not like", value, "objOrgcode");
            return this;
        }

        public Criteria andObjOrgcodeIn(List values) {
            addCriterion("OBJ_ORGCODE in", values, "objOrgcode");
            return this;
        }

        public Criteria andObjOrgcodeNotIn(List values) {
            addCriterion("OBJ_ORGCODE not in", values, "objOrgcode");
            return this;
        }

        public Criteria andObjOrgcodeBetween(String value1, String value2) {
            addCriterion("OBJ_ORGCODE between", value1, value2, "objOrgcode");
            return this;
        }

        public Criteria andObjOrgcodeNotBetween(String value1, String value2) {
            addCriterion("OBJ_ORGCODE not between", value1, value2, "objOrgcode");
            return this;
        }

        public Criteria andReceiveStatusIsNull() {
            addCriterion("RECEIVE_STATUS is null");
            return this;
        }

        public Criteria andReceiveStatusIsNotNull() {
            addCriterion("RECEIVE_STATUS is not null");
            return this;
        }

        public Criteria andReceiveStatusEqualTo(String value) {
            addCriterion("RECEIVE_STATUS =", value, "receiveStatus");
            return this;
        }

        public Criteria andReceiveStatusNotEqualTo(String value) {
            addCriterion("RECEIVE_STATUS <>", value, "receiveStatus");
            return this;
        }

        public Criteria andReceiveStatusGreaterThan(String value) {
            addCriterion("RECEIVE_STATUS >", value, "receiveStatus");
            return this;
        }

        public Criteria andReceiveStatusGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_STATUS >=", value, "receiveStatus");
            return this;
        }

        public Criteria andReceiveStatusLessThan(String value) {
            addCriterion("RECEIVE_STATUS <", value, "receiveStatus");
            return this;
        }

        public Criteria andReceiveStatusLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_STATUS <=", value, "receiveStatus");
            return this;
        }

        public Criteria andReceiveStatusLike(String value) {
            addCriterion("RECEIVE_STATUS like", value, "receiveStatus");
            return this;
        }

        public Criteria andReceiveStatusNotLike(String value) {
            addCriterion("RECEIVE_STATUS not like", value, "receiveStatus");
            return this;
        }

        public Criteria andReceiveStatusIn(List values) {
            addCriterion("RECEIVE_STATUS in", values, "receiveStatus");
            return this;
        }

        public Criteria andReceiveStatusNotIn(List values) {
            addCriterion("RECEIVE_STATUS not in", values, "receiveStatus");
            return this;
        }

        public Criteria andReceiveStatusBetween(String value1, String value2) {
            addCriterion("RECEIVE_STATUS between", value1, value2, "receiveStatus");
            return this;
        }

        public Criteria andReceiveStatusNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_STATUS not between", value1, value2, "receiveStatus");
            return this;
        }

        public Criteria andReceiveDateIsNull() {
            addCriterion("RECEIVE_DATE is null");
            return this;
        }

        public Criteria andReceiveDateIsNotNull() {
            addCriterion("RECEIVE_DATE is not null");
            return this;
        }

        public Criteria andReceiveDateEqualTo(String value) {
            addCriterion("RECEIVE_DATE =", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateNotEqualTo(String value) {
            addCriterion("RECEIVE_DATE <>", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateGreaterThan(String value) {
            addCriterion("RECEIVE_DATE >", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_DATE >=", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateLessThan(String value) {
            addCriterion("RECEIVE_DATE <", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_DATE <=", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateLike(String value) {
            addCriterion("RECEIVE_DATE like", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateNotLike(String value) {
            addCriterion("RECEIVE_DATE not like", value, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateIn(List values) {
            addCriterion("RECEIVE_DATE in", values, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateNotIn(List values) {
            addCriterion("RECEIVE_DATE not in", values, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateBetween(String value1, String value2) {
            addCriterion("RECEIVE_DATE between", value1, value2, "receiveDate");
            return this;
        }

        public Criteria andReceiveDateNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_DATE not between", value1, value2, "receiveDate");
            return this;
        }

        public Criteria andReceiveTimeIsNull() {
            addCriterion("RECEIVE_TIME is null");
            return this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("RECEIVE_TIME is not null");
            return this;
        }

        public Criteria andReceiveTimeEqualTo(String value) {
            addCriterion("RECEIVE_TIME =", value, "receiveTime");
            return this;
        }

        public Criteria andReceiveTimeNotEqualTo(String value) {
            addCriterion("RECEIVE_TIME <>", value, "receiveTime");
            return this;
        }

        public Criteria andReceiveTimeGreaterThan(String value) {
            addCriterion("RECEIVE_TIME >", value, "receiveTime");
            return this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVE_TIME >=", value, "receiveTime");
            return this;
        }

        public Criteria andReceiveTimeLessThan(String value) {
            addCriterion("RECEIVE_TIME <", value, "receiveTime");
            return this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(String value) {
            addCriterion("RECEIVE_TIME <=", value, "receiveTime");
            return this;
        }

        public Criteria andReceiveTimeLike(String value) {
            addCriterion("RECEIVE_TIME like", value, "receiveTime");
            return this;
        }

        public Criteria andReceiveTimeNotLike(String value) {
            addCriterion("RECEIVE_TIME not like", value, "receiveTime");
            return this;
        }

        public Criteria andReceiveTimeIn(List values) {
            addCriterion("RECEIVE_TIME in", values, "receiveTime");
            return this;
        }

        public Criteria andReceiveTimeNotIn(List values) {
            addCriterion("RECEIVE_TIME not in", values, "receiveTime");
            return this;
        }

        public Criteria andReceiveTimeBetween(String value1, String value2) {
            addCriterion("RECEIVE_TIME between", value1, value2, "receiveTime");
            return this;
        }

        public Criteria andReceiveTimeNotBetween(String value1, String value2) {
            addCriterion("RECEIVE_TIME not between", value1, value2, "receiveTime");
            return this;
        }

        public Criteria andSubmitEmpIsNull() {
            addCriterion("SUBMIT_EMP is null");
            return this;
        }

        public Criteria andSubmitEmpIsNotNull() {
            addCriterion("SUBMIT_EMP is not null");
            return this;
        }

        public Criteria andSubmitEmpEqualTo(Long value) {
            addCriterion("SUBMIT_EMP =", value, "submitEmp");
            return this;
        }

        public Criteria andSubmitEmpNotEqualTo(Long value) {
            addCriterion("SUBMIT_EMP <>", value, "submitEmp");
            return this;
        }

        public Criteria andSubmitEmpGreaterThan(Long value) {
            addCriterion("SUBMIT_EMP >", value, "submitEmp");
            return this;
        }

        public Criteria andSubmitEmpGreaterThanOrEqualTo(Long value) {
            addCriterion("SUBMIT_EMP >=", value, "submitEmp");
            return this;
        }

        public Criteria andSubmitEmpLessThan(Long value) {
            addCriterion("SUBMIT_EMP <", value, "submitEmp");
            return this;
        }

        public Criteria andSubmitEmpLessThanOrEqualTo(Long value) {
            addCriterion("SUBMIT_EMP <=", value, "submitEmp");
            return this;
        }

        public Criteria andSubmitEmpIn(List values) {
            addCriterion("SUBMIT_EMP in", values, "submitEmp");
            return this;
        }

        public Criteria andSubmitEmpNotIn(List values) {
            addCriterion("SUBMIT_EMP not in", values, "submitEmp");
            return this;
        }

        public Criteria andSubmitEmpBetween(Long value1, Long value2) {
            addCriterion("SUBMIT_EMP between", value1, value2, "submitEmp");
            return this;
        }

        public Criteria andSubmitEmpNotBetween(Long value1, Long value2) {
            addCriterion("SUBMIT_EMP not between", value1, value2, "submitEmp");
            return this;
        }

        public Criteria andSubmitTimeIsNull() {
            addCriterion("SUBMIT_TIME is null");
            return this;
        }

        public Criteria andSubmitTimeIsNotNull() {
            addCriterion("SUBMIT_TIME is not null");
            return this;
        }

        public Criteria andSubmitTimeEqualTo(String value) {
            addCriterion("SUBMIT_TIME =", value, "submitTime");
            return this;
        }

        public Criteria andSubmitTimeNotEqualTo(String value) {
            addCriterion("SUBMIT_TIME <>", value, "submitTime");
            return this;
        }

        public Criteria andSubmitTimeGreaterThan(String value) {
            addCriterion("SUBMIT_TIME >", value, "submitTime");
            return this;
        }

        public Criteria andSubmitTimeGreaterThanOrEqualTo(String value) {
            addCriterion("SUBMIT_TIME >=", value, "submitTime");
            return this;
        }

        public Criteria andSubmitTimeLessThan(String value) {
            addCriterion("SUBMIT_TIME <", value, "submitTime");
            return this;
        }

        public Criteria andSubmitTimeLessThanOrEqualTo(String value) {
            addCriterion("SUBMIT_TIME <=", value, "submitTime");
            return this;
        }

        public Criteria andSubmitTimeLike(String value) {
            addCriterion("SUBMIT_TIME like", value, "submitTime");
            return this;
        }

        public Criteria andSubmitTimeNotLike(String value) {
            addCriterion("SUBMIT_TIME not like", value, "submitTime");
            return this;
        }

        public Criteria andSubmitTimeIn(List values) {
            addCriterion("SUBMIT_TIME in", values, "submitTime");
            return this;
        }

        public Criteria andSubmitTimeNotIn(List values) {
            addCriterion("SUBMIT_TIME not in", values, "submitTime");
            return this;
        }

        public Criteria andSubmitTimeBetween(String value1, String value2) {
            addCriterion("SUBMIT_TIME between", value1, value2, "submitTime");
            return this;
        }

        public Criteria andSubmitTimeNotBetween(String value1, String value2) {
            addCriterion("SUBMIT_TIME not between", value1, value2, "submitTime");
            return this;
        }
    }
}