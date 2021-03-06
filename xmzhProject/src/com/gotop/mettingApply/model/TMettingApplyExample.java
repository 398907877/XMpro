package com.gotop.mettingApply.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class TMettingApplyExample {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TMettingApplyExample.class);

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
    public TMettingApplyExample() {
        oredCriteria = new ArrayList();
    }

    /** */
    protected TMettingApplyExample(TMettingApplyExample example) {
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
     * This class corresponds to the database table T_METTING_APPLY
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

        public Criteria andMettingIdIsNull() {
            addCriterion("METTING_ID is null");
            return this;
        }

        public Criteria andMettingIdIsNotNull() {
            addCriterion("METTING_ID is not null");
            return this;
        }

        public Criteria andMettingIdEqualTo(Long value) {
            addCriterion("METTING_ID =", value, "mettingId");
            return this;
        }

        public Criteria andMettingIdNotEqualTo(Long value) {
            addCriterion("METTING_ID <>", value, "mettingId");
            return this;
        }

        public Criteria andMettingIdGreaterThan(Long value) {
            addCriterion("METTING_ID >", value, "mettingId");
            return this;
        }

        public Criteria andMettingIdGreaterThanOrEqualTo(Long value) {
            addCriterion("METTING_ID >=", value, "mettingId");
            return this;
        }

        public Criteria andMettingIdLessThan(Long value) {
            addCriterion("METTING_ID <", value, "mettingId");
            return this;
        }

        public Criteria andMettingIdLessThanOrEqualTo(Long value) {
            addCriterion("METTING_ID <=", value, "mettingId");
            return this;
        }

        public Criteria andMettingIdIn(List values) {
            addCriterion("METTING_ID in", values, "mettingId");
            return this;
        }

        public Criteria andMettingIdNotIn(List values) {
            addCriterion("METTING_ID not in", values, "mettingId");
            return this;
        }

        public Criteria andMettingIdBetween(Long value1, Long value2) {
            addCriterion("METTING_ID between", value1, value2, "mettingId");
            return this;
        }

        public Criteria andMettingIdNotBetween(Long value1, Long value2) {
            addCriterion("METTING_ID not between", value1, value2, "mettingId");
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

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return this;
        }

        public Criteria andTitleIn(List values) {
            addCriterion("TITLE in", values, "title");
            return this;
        }

        public Criteria andTitleNotIn(List values) {
            addCriterion("TITLE not in", values, "title");
            return this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return this;
        }

        public Criteria andContentIn(List values) {
            addCriterion("CONTENT in", values, "content");
            return this;
        }

        public Criteria andContentNotIn(List values) {
            addCriterion("CONTENT not in", values, "content");
            return this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
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

        public Criteria andMettingTimeIsNull() {
            addCriterion("METTING_TIME is null");
            return this;
        }

        public Criteria andMettingTimeIsNotNull() {
            addCriterion("METTING_TIME is not null");
            return this;
        }

        public Criteria andMettingTimeEqualTo(String value) {
            addCriterion("METTING_TIME =", value, "mettingTime");
            return this;
        }

        public Criteria andMettingTimeNotEqualTo(String value) {
            addCriterion("METTING_TIME <>", value, "mettingTime");
            return this;
        }

        public Criteria andMettingTimeGreaterThan(String value) {
            addCriterion("METTING_TIME >", value, "mettingTime");
            return this;
        }

        public Criteria andMettingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("METTING_TIME >=", value, "mettingTime");
            return this;
        }

        public Criteria andMettingTimeLessThan(String value) {
            addCriterion("METTING_TIME <", value, "mettingTime");
            return this;
        }

        public Criteria andMettingTimeLessThanOrEqualTo(String value) {
            addCriterion("METTING_TIME <=", value, "mettingTime");
            return this;
        }

        public Criteria andMettingTimeLike(String value) {
            addCriterion("METTING_TIME like", value, "mettingTime");
            return this;
        }

        public Criteria andMettingTimeNotLike(String value) {
            addCriterion("METTING_TIME not like", value, "mettingTime");
            return this;
        }

        public Criteria andMettingTimeIn(List values) {
            addCriterion("METTING_TIME in", values, "mettingTime");
            return this;
        }

        public Criteria andMettingTimeNotIn(List values) {
            addCriterion("METTING_TIME not in", values, "mettingTime");
            return this;
        }

        public Criteria andMettingTimeBetween(String value1, String value2) {
            addCriterion("METTING_TIME between", value1, value2, "mettingTime");
            return this;
        }

        public Criteria andMettingTimeNotBetween(String value1, String value2) {
            addCriterion("METTING_TIME not between", value1, value2, "mettingTime");
            return this;
        }

        public Criteria andJoinEmpIsNull() {
            addCriterion("JOIN_EMP is null");
            return this;
        }

        public Criteria andJoinEmpIsNotNull() {
            addCriterion("JOIN_EMP is not null");
            return this;
        }

        public Criteria andJoinEmpEqualTo(String value) {
            addCriterion("JOIN_EMP =", value, "joinEmp");
            return this;
        }

        public Criteria andJoinEmpNotEqualTo(String value) {
            addCriterion("JOIN_EMP <>", value, "joinEmp");
            return this;
        }

        public Criteria andJoinEmpGreaterThan(String value) {
            addCriterion("JOIN_EMP >", value, "joinEmp");
            return this;
        }

        public Criteria andJoinEmpGreaterThanOrEqualTo(String value) {
            addCriterion("JOIN_EMP >=", value, "joinEmp");
            return this;
        }

        public Criteria andJoinEmpLessThan(String value) {
            addCriterion("JOIN_EMP <", value, "joinEmp");
            return this;
        }

        public Criteria andJoinEmpLessThanOrEqualTo(String value) {
            addCriterion("JOIN_EMP <=", value, "joinEmp");
            return this;
        }

        public Criteria andJoinEmpLike(String value) {
            addCriterion("JOIN_EMP like", value, "joinEmp");
            return this;
        }

        public Criteria andJoinEmpNotLike(String value) {
            addCriterion("JOIN_EMP not like", value, "joinEmp");
            return this;
        }

        public Criteria andJoinEmpIn(List values) {
            addCriterion("JOIN_EMP in", values, "joinEmp");
            return this;
        }

        public Criteria andJoinEmpNotIn(List values) {
            addCriterion("JOIN_EMP not in", values, "joinEmp");
            return this;
        }

        public Criteria andJoinEmpBetween(String value1, String value2) {
            addCriterion("JOIN_EMP between", value1, value2, "joinEmp");
            return this;
        }

        public Criteria andJoinEmpNotBetween(String value1, String value2) {
            addCriterion("JOIN_EMP not between", value1, value2, "joinEmp");
            return this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return this;
        }

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("CREATE_DATE like", value, "createDate");
            return this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("CREATE_DATE not like", value, "createDate");
            return this;
        }

        public Criteria andCreateDateIn(List values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return this;
        }

        public Criteria andCreateDateNotIn(List values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("CREATE_TIME like", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("CREATE_TIME not like", value, "createTime");
            return this;
        }

        public Criteria andCreateTimeIn(List values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return this;
        }

        public Criteria andCreateTimeNotIn(List values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("CREATOR is null");
            return this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("CREATOR is not null");
            return this;
        }

        public Criteria andCreatorEqualTo(Long value) {
            addCriterion("CREATOR =", value, "creator");
            return this;
        }

        public Criteria andCreatorNotEqualTo(Long value) {
            addCriterion("CREATOR <>", value, "creator");
            return this;
        }

        public Criteria andCreatorGreaterThan(Long value) {
            addCriterion("CREATOR >", value, "creator");
            return this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(Long value) {
            addCriterion("CREATOR >=", value, "creator");
            return this;
        }

        public Criteria andCreatorLessThan(Long value) {
            addCriterion("CREATOR <", value, "creator");
            return this;
        }

        public Criteria andCreatorLessThanOrEqualTo(Long value) {
            addCriterion("CREATOR <=", value, "creator");
            return this;
        }

        public Criteria andCreatorIn(List values) {
            addCriterion("CREATOR in", values, "creator");
            return this;
        }

        public Criteria andCreatorNotIn(List values) {
            addCriterion("CREATOR not in", values, "creator");
            return this;
        }

        public Criteria andCreatorBetween(Long value1, Long value2) {
            addCriterion("CREATOR between", value1, value2, "creator");
            return this;
        }

        public Criteria andCreatorNotBetween(Long value1, Long value2) {
            addCriterion("CREATOR not between", value1, value2, "creator");
            return this;
        }

        public Criteria andOrgidIsNull() {
            addCriterion("ORGID is null");
            return this;
        }

        public Criteria andOrgidIsNotNull() {
            addCriterion("ORGID is not null");
            return this;
        }

        public Criteria andOrgidEqualTo(Long value) {
            addCriterion("ORGID =", value, "orgid");
            return this;
        }

        public Criteria andOrgidNotEqualTo(Long value) {
            addCriterion("ORGID <>", value, "orgid");
            return this;
        }

        public Criteria andOrgidGreaterThan(Long value) {
            addCriterion("ORGID >", value, "orgid");
            return this;
        }

        public Criteria andOrgidGreaterThanOrEqualTo(Long value) {
            addCriterion("ORGID >=", value, "orgid");
            return this;
        }

        public Criteria andOrgidLessThan(Long value) {
            addCriterion("ORGID <", value, "orgid");
            return this;
        }

        public Criteria andOrgidLessThanOrEqualTo(Long value) {
            addCriterion("ORGID <=", value, "orgid");
            return this;
        }

        public Criteria andOrgidIn(List values) {
            addCriterion("ORGID in", values, "orgid");
            return this;
        }

        public Criteria andOrgidNotIn(List values) {
            addCriterion("ORGID not in", values, "orgid");
            return this;
        }

        public Criteria andOrgidBetween(Long value1, Long value2) {
            addCriterion("ORGID between", value1, value2, "orgid");
            return this;
        }

        public Criteria andOrgidNotBetween(Long value1, Long value2) {
            addCriterion("ORGID not between", value1, value2, "orgid");
            return this;
        }

        public Criteria andJoinEmpnameIsNull() {
            addCriterion("JOIN_EMPNAME is null");
            return this;
        }

        public Criteria andJoinEmpnameIsNotNull() {
            addCriterion("JOIN_EMPNAME is not null");
            return this;
        }

        public Criteria andJoinEmpnameEqualTo(String value) {
            addCriterion("JOIN_EMPNAME =", value, "joinEmpname");
            return this;
        }

        public Criteria andJoinEmpnameNotEqualTo(String value) {
            addCriterion("JOIN_EMPNAME <>", value, "joinEmpname");
            return this;
        }

        public Criteria andJoinEmpnameGreaterThan(String value) {
            addCriterion("JOIN_EMPNAME >", value, "joinEmpname");
            return this;
        }

        public Criteria andJoinEmpnameGreaterThanOrEqualTo(String value) {
            addCriterion("JOIN_EMPNAME >=", value, "joinEmpname");
            return this;
        }

        public Criteria andJoinEmpnameLessThan(String value) {
            addCriterion("JOIN_EMPNAME <", value, "joinEmpname");
            return this;
        }

        public Criteria andJoinEmpnameLessThanOrEqualTo(String value) {
            addCriterion("JOIN_EMPNAME <=", value, "joinEmpname");
            return this;
        }

        public Criteria andJoinEmpnameLike(String value) {
            addCriterion("JOIN_EMPNAME like", value, "joinEmpname");
            return this;
        }

        public Criteria andJoinEmpnameNotLike(String value) {
            addCriterion("JOIN_EMPNAME not like", value, "joinEmpname");
            return this;
        }

        public Criteria andJoinEmpnameIn(List values) {
            addCriterion("JOIN_EMPNAME in", values, "joinEmpname");
            return this;
        }

        public Criteria andJoinEmpnameNotIn(List values) {
            addCriterion("JOIN_EMPNAME not in", values, "joinEmpname");
            return this;
        }

        public Criteria andJoinEmpnameBetween(String value1, String value2) {
            addCriterion("JOIN_EMPNAME between", value1, value2, "joinEmpname");
            return this;
        }

        public Criteria andJoinEmpnameNotBetween(String value1, String value2) {
            addCriterion("JOIN_EMPNAME not between", value1, value2, "joinEmpname");
            return this;
        }
    }
}