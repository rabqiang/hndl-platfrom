package com.hndl.cn.dao.member.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberMoneyTradeRecordDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public MemberMoneyTradeRecordDoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNamespaceIsNull() {
            addCriterion("namespace is null");
            return (Criteria) this;
        }

        public Criteria andNamespaceIsNotNull() {
            addCriterion("namespace is not null");
            return (Criteria) this;
        }

        public Criteria andNamespaceEqualTo(Integer value) {
            addCriterion("namespace =", value, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceNotEqualTo(Integer value) {
            addCriterion("namespace <>", value, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceGreaterThan(Integer value) {
            addCriterion("namespace >", value, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceGreaterThanOrEqualTo(Integer value) {
            addCriterion("namespace >=", value, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceLessThan(Integer value) {
            addCriterion("namespace <", value, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceLessThanOrEqualTo(Integer value) {
            addCriterion("namespace <=", value, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceIn(List<Integer> values) {
            addCriterion("namespace in", values, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceNotIn(List<Integer> values) {
            addCriterion("namespace not in", values, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceBetween(Integer value1, Integer value2) {
            addCriterion("namespace between", value1, value2, "namespace");
            return (Criteria) this;
        }

        public Criteria andNamespaceNotBetween(Integer value1, Integer value2) {
            addCriterion("namespace not between", value1, value2, "namespace");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_Deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_Deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(String value) {
            addCriterion("is_Deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(String value) {
            addCriterion("is_Deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(String value) {
            addCriterion("is_Deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("is_Deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(String value) {
            addCriterion("is_Deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(String value) {
            addCriterion("is_Deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLike(String value) {
            addCriterion("is_Deleted like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotLike(String value) {
            addCriterion("is_Deleted not like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<String> values) {
            addCriterion("is_Deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<String> values) {
            addCriterion("is_Deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(String value1, String value2) {
            addCriterion("is_Deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(String value1, String value2) {
            addCriterion("is_Deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorIsNull() {
            addCriterion("create_Operator is null");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorIsNotNull() {
            addCriterion("create_Operator is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorEqualTo(String value) {
            addCriterion("create_Operator =", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotEqualTo(String value) {
            addCriterion("create_Operator <>", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorGreaterThan(String value) {
            addCriterion("create_Operator >", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("create_Operator >=", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorLessThan(String value) {
            addCriterion("create_Operator <", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorLessThanOrEqualTo(String value) {
            addCriterion("create_Operator <=", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorLike(String value) {
            addCriterion("create_Operator like", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotLike(String value) {
            addCriterion("create_Operator not like", value, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorIn(List<String> values) {
            addCriterion("create_Operator in", values, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotIn(List<String> values) {
            addCriterion("create_Operator not in", values, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorBetween(String value1, String value2) {
            addCriterion("create_Operator between", value1, value2, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateOperatorNotBetween(String value1, String value2) {
            addCriterion("create_Operator not between", value1, value2, "createOperator");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastOperatorIsNull() {
            addCriterion("last_Operator is null");
            return (Criteria) this;
        }

        public Criteria andLastOperatorIsNotNull() {
            addCriterion("last_Operator is not null");
            return (Criteria) this;
        }

        public Criteria andLastOperatorEqualTo(String value) {
            addCriterion("last_Operator =", value, "lastOperator");
            return (Criteria) this;
        }

        public Criteria andLastOperatorNotEqualTo(String value) {
            addCriterion("last_Operator <>", value, "lastOperator");
            return (Criteria) this;
        }

        public Criteria andLastOperatorGreaterThan(String value) {
            addCriterion("last_Operator >", value, "lastOperator");
            return (Criteria) this;
        }

        public Criteria andLastOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("last_Operator >=", value, "lastOperator");
            return (Criteria) this;
        }

        public Criteria andLastOperatorLessThan(String value) {
            addCriterion("last_Operator <", value, "lastOperator");
            return (Criteria) this;
        }

        public Criteria andLastOperatorLessThanOrEqualTo(String value) {
            addCriterion("last_Operator <=", value, "lastOperator");
            return (Criteria) this;
        }

        public Criteria andLastOperatorLike(String value) {
            addCriterion("last_Operator like", value, "lastOperator");
            return (Criteria) this;
        }

        public Criteria andLastOperatorNotLike(String value) {
            addCriterion("last_Operator not like", value, "lastOperator");
            return (Criteria) this;
        }

        public Criteria andLastOperatorIn(List<String> values) {
            addCriterion("last_Operator in", values, "lastOperator");
            return (Criteria) this;
        }

        public Criteria andLastOperatorNotIn(List<String> values) {
            addCriterion("last_Operator not in", values, "lastOperator");
            return (Criteria) this;
        }

        public Criteria andLastOperatorBetween(String value1, String value2) {
            addCriterion("last_Operator between", value1, value2, "lastOperator");
            return (Criteria) this;
        }

        public Criteria andLastOperatorNotBetween(String value1, String value2) {
            addCriterion("last_Operator not between", value1, value2, "lastOperator");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNull() {
            addCriterion("last_Modify_Time is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNotNull() {
            addCriterion("last_Modify_Time is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeEqualTo(Date value) {
            addCriterion("last_Modify_Time =", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotEqualTo(Date value) {
            addCriterion("last_Modify_Time <>", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThan(Date value) {
            addCriterion("last_Modify_Time >", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_Modify_Time >=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThan(Date value) {
            addCriterion("last_Modify_Time <", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_Modify_Time <=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIn(List<Date> values) {
            addCriterion("last_Modify_Time in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotIn(List<Date> values) {
            addCriterion("last_Modify_Time not in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            addCriterion("last_Modify_Time between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_Modify_Time not between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("`count` is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("`count` is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Double value) {
            addCriterion("`count` =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Double value) {
            addCriterion("`count` <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Double value) {
            addCriterion("`count` >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Double value) {
            addCriterion("`count` >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Double value) {
            addCriterion("`count` <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Double value) {
            addCriterion("`count` <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Double> values) {
            addCriterion("`count` in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Double> values) {
            addCriterion("`count` not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Double value1, Double value2) {
            addCriterion("`count` between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Double value1, Double value2) {
            addCriterion("`count` not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("`type` like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("`type` not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIdIsNull() {
            addCriterion("reason_id is null");
            return (Criteria) this;
        }

        public Criteria andReasonIdIsNotNull() {
            addCriterion("reason_id is not null");
            return (Criteria) this;
        }

        public Criteria andReasonIdEqualTo(String value) {
            addCriterion("reason_id =", value, "reasonId");
            return (Criteria) this;
        }

        public Criteria andReasonIdNotEqualTo(String value) {
            addCriterion("reason_id <>", value, "reasonId");
            return (Criteria) this;
        }

        public Criteria andReasonIdGreaterThan(String value) {
            addCriterion("reason_id >", value, "reasonId");
            return (Criteria) this;
        }

        public Criteria andReasonIdGreaterThanOrEqualTo(String value) {
            addCriterion("reason_id >=", value, "reasonId");
            return (Criteria) this;
        }

        public Criteria andReasonIdLessThan(String value) {
            addCriterion("reason_id <", value, "reasonId");
            return (Criteria) this;
        }

        public Criteria andReasonIdLessThanOrEqualTo(String value) {
            addCriterion("reason_id <=", value, "reasonId");
            return (Criteria) this;
        }

        public Criteria andReasonIdLike(String value) {
            addCriterion("reason_id like", value, "reasonId");
            return (Criteria) this;
        }

        public Criteria andReasonIdNotLike(String value) {
            addCriterion("reason_id not like", value, "reasonId");
            return (Criteria) this;
        }

        public Criteria andReasonIdIn(List<String> values) {
            addCriterion("reason_id in", values, "reasonId");
            return (Criteria) this;
        }

        public Criteria andReasonIdNotIn(List<String> values) {
            addCriterion("reason_id not in", values, "reasonId");
            return (Criteria) this;
        }

        public Criteria andReasonIdBetween(String value1, String value2) {
            addCriterion("reason_id between", value1, value2, "reasonId");
            return (Criteria) this;
        }

        public Criteria andReasonIdNotBetween(String value1, String value2) {
            addCriterion("reason_id not between", value1, value2, "reasonId");
            return (Criteria) this;
        }

        public Criteria andOutTradeIdIsNull() {
            addCriterion("out_trade_id is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeIdIsNotNull() {
            addCriterion("out_trade_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeIdEqualTo(String value) {
            addCriterion("out_trade_id =", value, "outTradeId");
            return (Criteria) this;
        }

        public Criteria andOutTradeIdNotEqualTo(String value) {
            addCriterion("out_trade_id <>", value, "outTradeId");
            return (Criteria) this;
        }

        public Criteria andOutTradeIdGreaterThan(String value) {
            addCriterion("out_trade_id >", value, "outTradeId");
            return (Criteria) this;
        }

        public Criteria andOutTradeIdGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_id >=", value, "outTradeId");
            return (Criteria) this;
        }

        public Criteria andOutTradeIdLessThan(String value) {
            addCriterion("out_trade_id <", value, "outTradeId");
            return (Criteria) this;
        }

        public Criteria andOutTradeIdLessThanOrEqualTo(String value) {
            addCriterion("out_trade_id <=", value, "outTradeId");
            return (Criteria) this;
        }

        public Criteria andOutTradeIdLike(String value) {
            addCriterion("out_trade_id like", value, "outTradeId");
            return (Criteria) this;
        }

        public Criteria andOutTradeIdNotLike(String value) {
            addCriterion("out_trade_id not like", value, "outTradeId");
            return (Criteria) this;
        }

        public Criteria andOutTradeIdIn(List<String> values) {
            addCriterion("out_trade_id in", values, "outTradeId");
            return (Criteria) this;
        }

        public Criteria andOutTradeIdNotIn(List<String> values) {
            addCriterion("out_trade_id not in", values, "outTradeId");
            return (Criteria) this;
        }

        public Criteria andOutTradeIdBetween(String value1, String value2) {
            addCriterion("out_trade_id between", value1, value2, "outTradeId");
            return (Criteria) this;
        }

        public Criteria andOutTradeIdNotBetween(String value1, String value2) {
            addCriterion("out_trade_id not between", value1, value2, "outTradeId");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatusIsNull() {
            addCriterion("out_trade_status is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatusIsNotNull() {
            addCriterion("out_trade_status is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatusEqualTo(String value) {
            addCriterion("out_trade_status =", value, "outTradeStatus");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatusNotEqualTo(String value) {
            addCriterion("out_trade_status <>", value, "outTradeStatus");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatusGreaterThan(String value) {
            addCriterion("out_trade_status >", value, "outTradeStatus");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_status >=", value, "outTradeStatus");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatusLessThan(String value) {
            addCriterion("out_trade_status <", value, "outTradeStatus");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatusLessThanOrEqualTo(String value) {
            addCriterion("out_trade_status <=", value, "outTradeStatus");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatusLike(String value) {
            addCriterion("out_trade_status like", value, "outTradeStatus");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatusNotLike(String value) {
            addCriterion("out_trade_status not like", value, "outTradeStatus");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatusIn(List<String> values) {
            addCriterion("out_trade_status in", values, "outTradeStatus");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatusNotIn(List<String> values) {
            addCriterion("out_trade_status not in", values, "outTradeStatus");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatusBetween(String value1, String value2) {
            addCriterion("out_trade_status between", value1, value2, "outTradeStatus");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatusNotBetween(String value1, String value2) {
            addCriterion("out_trade_status not between", value1, value2, "outTradeStatus");
            return (Criteria) this;
        }

        public Criteria andOutTradeTypeIsNull() {
            addCriterion("out_trade_type is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeTypeIsNotNull() {
            addCriterion("out_trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeTypeEqualTo(String value) {
            addCriterion("out_trade_type =", value, "outTradeType");
            return (Criteria) this;
        }

        public Criteria andOutTradeTypeNotEqualTo(String value) {
            addCriterion("out_trade_type <>", value, "outTradeType");
            return (Criteria) this;
        }

        public Criteria andOutTradeTypeGreaterThan(String value) {
            addCriterion("out_trade_type >", value, "outTradeType");
            return (Criteria) this;
        }

        public Criteria andOutTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_type >=", value, "outTradeType");
            return (Criteria) this;
        }

        public Criteria andOutTradeTypeLessThan(String value) {
            addCriterion("out_trade_type <", value, "outTradeType");
            return (Criteria) this;
        }

        public Criteria andOutTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("out_trade_type <=", value, "outTradeType");
            return (Criteria) this;
        }

        public Criteria andOutTradeTypeLike(String value) {
            addCriterion("out_trade_type like", value, "outTradeType");
            return (Criteria) this;
        }

        public Criteria andOutTradeTypeNotLike(String value) {
            addCriterion("out_trade_type not like", value, "outTradeType");
            return (Criteria) this;
        }

        public Criteria andOutTradeTypeIn(List<String> values) {
            addCriterion("out_trade_type in", values, "outTradeType");
            return (Criteria) this;
        }

        public Criteria andOutTradeTypeNotIn(List<String> values) {
            addCriterion("out_trade_type not in", values, "outTradeType");
            return (Criteria) this;
        }

        public Criteria andOutTradeTypeBetween(String value1, String value2) {
            addCriterion("out_trade_type between", value1, value2, "outTradeType");
            return (Criteria) this;
        }

        public Criteria andOutTradeTypeNotBetween(String value1, String value2) {
            addCriterion("out_trade_type not between", value1, value2, "outTradeType");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNull() {
            addCriterion("game_Id is null");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNotNull() {
            addCriterion("game_Id is not null");
            return (Criteria) this;
        }

        public Criteria andGameIdEqualTo(String value) {
            addCriterion("game_Id =", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotEqualTo(String value) {
            addCriterion("game_Id <>", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThan(String value) {
            addCriterion("game_Id >", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThanOrEqualTo(String value) {
            addCriterion("game_Id >=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThan(String value) {
            addCriterion("game_Id <", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThanOrEqualTo(String value) {
            addCriterion("game_Id <=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLike(String value) {
            addCriterion("game_Id like", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotLike(String value) {
            addCriterion("game_Id not like", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdIn(List<String> values) {
            addCriterion("game_Id in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotIn(List<String> values) {
            addCriterion("game_Id not in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdBetween(String value1, String value2) {
            addCriterion("game_Id between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotBetween(String value1, String value2) {
            addCriterion("game_Id not between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameTypeIsNull() {
            addCriterion("game_Type is null");
            return (Criteria) this;
        }

        public Criteria andGameTypeIsNotNull() {
            addCriterion("game_Type is not null");
            return (Criteria) this;
        }

        public Criteria andGameTypeEqualTo(String value) {
            addCriterion("game_Type =", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotEqualTo(String value) {
            addCriterion("game_Type <>", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeGreaterThan(String value) {
            addCriterion("game_Type >", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeGreaterThanOrEqualTo(String value) {
            addCriterion("game_Type >=", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeLessThan(String value) {
            addCriterion("game_Type <", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeLessThanOrEqualTo(String value) {
            addCriterion("game_Type <=", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeLike(String value) {
            addCriterion("game_Type like", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotLike(String value) {
            addCriterion("game_Type not like", value, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeIn(List<String> values) {
            addCriterion("game_Type in", values, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotIn(List<String> values) {
            addCriterion("game_Type not in", values, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeBetween(String value1, String value2) {
            addCriterion("game_Type between", value1, value2, "gameType");
            return (Criteria) this;
        }

        public Criteria andGameTypeNotBetween(String value1, String value2) {
            addCriterion("game_Type not between", value1, value2, "gameType");
            return (Criteria) this;
        }

        public Criteria andPayTypeUserIsNull() {
            addCriterion("pay_Type_User is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeUserIsNotNull() {
            addCriterion("pay_Type_User is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeUserEqualTo(String value) {
            addCriterion("pay_Type_User =", value, "payTypeUser");
            return (Criteria) this;
        }

        public Criteria andPayTypeUserNotEqualTo(String value) {
            addCriterion("pay_Type_User <>", value, "payTypeUser");
            return (Criteria) this;
        }

        public Criteria andPayTypeUserGreaterThan(String value) {
            addCriterion("pay_Type_User >", value, "payTypeUser");
            return (Criteria) this;
        }

        public Criteria andPayTypeUserGreaterThanOrEqualTo(String value) {
            addCriterion("pay_Type_User >=", value, "payTypeUser");
            return (Criteria) this;
        }

        public Criteria andPayTypeUserLessThan(String value) {
            addCriterion("pay_Type_User <", value, "payTypeUser");
            return (Criteria) this;
        }

        public Criteria andPayTypeUserLessThanOrEqualTo(String value) {
            addCriterion("pay_Type_User <=", value, "payTypeUser");
            return (Criteria) this;
        }

        public Criteria andPayTypeUserLike(String value) {
            addCriterion("pay_Type_User like", value, "payTypeUser");
            return (Criteria) this;
        }

        public Criteria andPayTypeUserNotLike(String value) {
            addCriterion("pay_Type_User not like", value, "payTypeUser");
            return (Criteria) this;
        }

        public Criteria andPayTypeUserIn(List<String> values) {
            addCriterion("pay_Type_User in", values, "payTypeUser");
            return (Criteria) this;
        }

        public Criteria andPayTypeUserNotIn(List<String> values) {
            addCriterion("pay_Type_User not in", values, "payTypeUser");
            return (Criteria) this;
        }

        public Criteria andPayTypeUserBetween(String value1, String value2) {
            addCriterion("pay_Type_User between", value1, value2, "payTypeUser");
            return (Criteria) this;
        }

        public Criteria andPayTypeUserNotBetween(String value1, String value2) {
            addCriterion("pay_Type_User not between", value1, value2, "payTypeUser");
            return (Criteria) this;
        }

        public Criteria andVoteIdIsNull() {
            addCriterion("vote_Id is null");
            return (Criteria) this;
        }

        public Criteria andVoteIdIsNotNull() {
            addCriterion("vote_Id is not null");
            return (Criteria) this;
        }

        public Criteria andVoteIdEqualTo(String value) {
            addCriterion("vote_Id =", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotEqualTo(String value) {
            addCriterion("vote_Id <>", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdGreaterThan(String value) {
            addCriterion("vote_Id >", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdGreaterThanOrEqualTo(String value) {
            addCriterion("vote_Id >=", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdLessThan(String value) {
            addCriterion("vote_Id <", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdLessThanOrEqualTo(String value) {
            addCriterion("vote_Id <=", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdLike(String value) {
            addCriterion("vote_Id like", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotLike(String value) {
            addCriterion("vote_Id not like", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdIn(List<String> values) {
            addCriterion("vote_Id in", values, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotIn(List<String> values) {
            addCriterion("vote_Id not in", values, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdBetween(String value1, String value2) {
            addCriterion("vote_Id between", value1, value2, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotBetween(String value1, String value2) {
            addCriterion("vote_Id not between", value1, value2, "voteId");
            return (Criteria) this;
        }

        public Criteria andGuessGroupIsNull() {
            addCriterion("guess_Group is null");
            return (Criteria) this;
        }

        public Criteria andGuessGroupIsNotNull() {
            addCriterion("guess_Group is not null");
            return (Criteria) this;
        }

        public Criteria andGuessGroupEqualTo(String value) {
            addCriterion("guess_Group =", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupNotEqualTo(String value) {
            addCriterion("guess_Group <>", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupGreaterThan(String value) {
            addCriterion("guess_Group >", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupGreaterThanOrEqualTo(String value) {
            addCriterion("guess_Group >=", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupLessThan(String value) {
            addCriterion("guess_Group <", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupLessThanOrEqualTo(String value) {
            addCriterion("guess_Group <=", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupLike(String value) {
            addCriterion("guess_Group like", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupNotLike(String value) {
            addCriterion("guess_Group not like", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupIn(List<String> values) {
            addCriterion("guess_Group in", values, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupNotIn(List<String> values) {
            addCriterion("guess_Group not in", values, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupBetween(String value1, String value2) {
            addCriterion("guess_Group between", value1, value2, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupNotBetween(String value1, String value2) {
            addCriterion("guess_Group not between", value1, value2, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdIsNull() {
            addCriterion("guess_Info_Id is null");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdIsNotNull() {
            addCriterion("guess_Info_Id is not null");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdEqualTo(String value) {
            addCriterion("guess_Info_Id =", value, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdNotEqualTo(String value) {
            addCriterion("guess_Info_Id <>", value, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdGreaterThan(String value) {
            addCriterion("guess_Info_Id >", value, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("guess_Info_Id >=", value, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdLessThan(String value) {
            addCriterion("guess_Info_Id <", value, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdLessThanOrEqualTo(String value) {
            addCriterion("guess_Info_Id <=", value, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdLike(String value) {
            addCriterion("guess_Info_Id like", value, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdNotLike(String value) {
            addCriterion("guess_Info_Id not like", value, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdIn(List<String> values) {
            addCriterion("guess_Info_Id in", values, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdNotIn(List<String> values) {
            addCriterion("guess_Info_Id not in", values, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdBetween(String value1, String value2) {
            addCriterion("guess_Info_Id between", value1, value2, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdNotBetween(String value1, String value2) {
            addCriterion("guess_Info_Id not between", value1, value2, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNull() {
            addCriterion("is_use is null");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNotNull() {
            addCriterion("is_use is not null");
            return (Criteria) this;
        }

        public Criteria andIsUseEqualTo(String value) {
            addCriterion("is_use =", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotEqualTo(String value) {
            addCriterion("is_use <>", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThan(String value) {
            addCriterion("is_use >", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThanOrEqualTo(String value) {
            addCriterion("is_use >=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThan(String value) {
            addCriterion("is_use <", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThanOrEqualTo(String value) {
            addCriterion("is_use <=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLike(String value) {
            addCriterion("is_use like", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotLike(String value) {
            addCriterion("is_use not like", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseIn(List<String> values) {
            addCriterion("is_use in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotIn(List<String> values) {
            addCriterion("is_use not in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseBetween(String value1, String value2) {
            addCriterion("is_use between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotBetween(String value1, String value2) {
            addCriterion("is_use not between", value1, value2, "isUse");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}