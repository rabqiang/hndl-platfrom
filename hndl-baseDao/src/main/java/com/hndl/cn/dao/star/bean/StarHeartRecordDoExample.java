package com.hndl.cn.dao.star.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StarHeartRecordDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public StarHeartRecordDoExample() {
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

        public Criteria andStarIdIsNull() {
            addCriterion("star_id is null");
            return (Criteria) this;
        }

        public Criteria andStarIdIsNotNull() {
            addCriterion("star_id is not null");
            return (Criteria) this;
        }

        public Criteria andStarIdEqualTo(Long value) {
            addCriterion("star_id =", value, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdNotEqualTo(Long value) {
            addCriterion("star_id <>", value, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdGreaterThan(Long value) {
            addCriterion("star_id >", value, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdGreaterThanOrEqualTo(Long value) {
            addCriterion("star_id >=", value, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdLessThan(Long value) {
            addCriterion("star_id <", value, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdLessThanOrEqualTo(Long value) {
            addCriterion("star_id <=", value, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdIn(List<Long> values) {
            addCriterion("star_id in", values, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdNotIn(List<Long> values) {
            addCriterion("star_id not in", values, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdBetween(Long value1, Long value2) {
            addCriterion("star_id between", value1, value2, "starId");
            return (Criteria) this;
        }

        public Criteria andStarIdNotBetween(Long value1, Long value2) {
            addCriterion("star_id not between", value1, value2, "starId");
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

        public Criteria andHeartCountIsNull() {
            addCriterion("heart_count is null");
            return (Criteria) this;
        }

        public Criteria andHeartCountIsNotNull() {
            addCriterion("heart_count is not null");
            return (Criteria) this;
        }

        public Criteria andHeartCountEqualTo(Integer value) {
            addCriterion("heart_count =", value, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountNotEqualTo(Integer value) {
            addCriterion("heart_count <>", value, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountGreaterThan(Integer value) {
            addCriterion("heart_count >", value, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("heart_count >=", value, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountLessThan(Integer value) {
            addCriterion("heart_count <", value, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountLessThanOrEqualTo(Integer value) {
            addCriterion("heart_count <=", value, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountIn(List<Integer> values) {
            addCriterion("heart_count in", values, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountNotIn(List<Integer> values) {
            addCriterion("heart_count not in", values, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountBetween(Integer value1, Integer value2) {
            addCriterion("heart_count between", value1, value2, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountNotBetween(Integer value1, Integer value2) {
            addCriterion("heart_count not between", value1, value2, "heartCount");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andMeTradeIdIsNull() {
            addCriterion("me_trade_id is null");
            return (Criteria) this;
        }

        public Criteria andMeTradeIdIsNotNull() {
            addCriterion("me_trade_id is not null");
            return (Criteria) this;
        }

        public Criteria andMeTradeIdEqualTo(String value) {
            addCriterion("me_trade_id =", value, "meTradeId");
            return (Criteria) this;
        }

        public Criteria andMeTradeIdNotEqualTo(String value) {
            addCriterion("me_trade_id <>", value, "meTradeId");
            return (Criteria) this;
        }

        public Criteria andMeTradeIdGreaterThan(String value) {
            addCriterion("me_trade_id >", value, "meTradeId");
            return (Criteria) this;
        }

        public Criteria andMeTradeIdGreaterThanOrEqualTo(String value) {
            addCriterion("me_trade_id >=", value, "meTradeId");
            return (Criteria) this;
        }

        public Criteria andMeTradeIdLessThan(String value) {
            addCriterion("me_trade_id <", value, "meTradeId");
            return (Criteria) this;
        }

        public Criteria andMeTradeIdLessThanOrEqualTo(String value) {
            addCriterion("me_trade_id <=", value, "meTradeId");
            return (Criteria) this;
        }

        public Criteria andMeTradeIdLike(String value) {
            addCriterion("me_trade_id like", value, "meTradeId");
            return (Criteria) this;
        }

        public Criteria andMeTradeIdNotLike(String value) {
            addCriterion("me_trade_id not like", value, "meTradeId");
            return (Criteria) this;
        }

        public Criteria andMeTradeIdIn(List<String> values) {
            addCriterion("me_trade_id in", values, "meTradeId");
            return (Criteria) this;
        }

        public Criteria andMeTradeIdNotIn(List<String> values) {
            addCriterion("me_trade_id not in", values, "meTradeId");
            return (Criteria) this;
        }

        public Criteria andMeTradeIdBetween(String value1, String value2) {
            addCriterion("me_trade_id between", value1, value2, "meTradeId");
            return (Criteria) this;
        }

        public Criteria andMeTradeIdNotBetween(String value1, String value2) {
            addCriterion("me_trade_id not between", value1, value2, "meTradeId");
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

        public Criteria andOutTradeStatteIsNull() {
            addCriterion("out_trade_statte is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatteIsNotNull() {
            addCriterion("out_trade_statte is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatteEqualTo(String value) {
            addCriterion("out_trade_statte =", value, "outTradeStatte");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatteNotEqualTo(String value) {
            addCriterion("out_trade_statte <>", value, "outTradeStatte");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatteGreaterThan(String value) {
            addCriterion("out_trade_statte >", value, "outTradeStatte");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatteGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_statte >=", value, "outTradeStatte");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatteLessThan(String value) {
            addCriterion("out_trade_statte <", value, "outTradeStatte");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatteLessThanOrEqualTo(String value) {
            addCriterion("out_trade_statte <=", value, "outTradeStatte");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatteLike(String value) {
            addCriterion("out_trade_statte like", value, "outTradeStatte");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatteNotLike(String value) {
            addCriterion("out_trade_statte not like", value, "outTradeStatte");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatteIn(List<String> values) {
            addCriterion("out_trade_statte in", values, "outTradeStatte");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatteNotIn(List<String> values) {
            addCriterion("out_trade_statte not in", values, "outTradeStatte");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatteBetween(String value1, String value2) {
            addCriterion("out_trade_statte between", value1, value2, "outTradeStatte");
            return (Criteria) this;
        }

        public Criteria andOutTradeStatteNotBetween(String value1, String value2) {
            addCriterion("out_trade_statte not between", value1, value2, "outTradeStatte");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceIsNull() {
            addCriterion("current_balance is null");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceIsNotNull() {
            addCriterion("current_balance is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceEqualTo(Double value) {
            addCriterion("current_balance =", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceNotEqualTo(Double value) {
            addCriterion("current_balance <>", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceGreaterThan(Double value) {
            addCriterion("current_balance >", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("current_balance >=", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceLessThan(Double value) {
            addCriterion("current_balance <", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceLessThanOrEqualTo(Double value) {
            addCriterion("current_balance <=", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceIn(List<Double> values) {
            addCriterion("current_balance in", values, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceNotIn(List<Double> values) {
            addCriterion("current_balance not in", values, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceBetween(Double value1, Double value2) {
            addCriterion("current_balance between", value1, value2, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceNotBetween(Double value1, Double value2) {
            addCriterion("current_balance not between", value1, value2, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceIsNull() {
            addCriterion("after_balance is null");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceIsNotNull() {
            addCriterion("after_balance is not null");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceEqualTo(Double value) {
            addCriterion("after_balance =", value, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceNotEqualTo(Double value) {
            addCriterion("after_balance <>", value, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceGreaterThan(Double value) {
            addCriterion("after_balance >", value, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("after_balance >=", value, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceLessThan(Double value) {
            addCriterion("after_balance <", value, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceLessThanOrEqualTo(Double value) {
            addCriterion("after_balance <=", value, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceIn(List<Double> values) {
            addCriterion("after_balance in", values, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceNotIn(List<Double> values) {
            addCriterion("after_balance not in", values, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceBetween(Double value1, Double value2) {
            addCriterion("after_balance between", value1, value2, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceNotBetween(Double value1, Double value2) {
            addCriterion("after_balance not between", value1, value2, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andCountDayIsNull() {
            addCriterion("count_day is null");
            return (Criteria) this;
        }

        public Criteria andCountDayIsNotNull() {
            addCriterion("count_day is not null");
            return (Criteria) this;
        }

        public Criteria andCountDayEqualTo(Integer value) {
            addCriterion("count_day =", value, "countDay");
            return (Criteria) this;
        }

        public Criteria andCountDayNotEqualTo(Integer value) {
            addCriterion("count_day <>", value, "countDay");
            return (Criteria) this;
        }

        public Criteria andCountDayGreaterThan(Integer value) {
            addCriterion("count_day >", value, "countDay");
            return (Criteria) this;
        }

        public Criteria andCountDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_day >=", value, "countDay");
            return (Criteria) this;
        }

        public Criteria andCountDayLessThan(Integer value) {
            addCriterion("count_day <", value, "countDay");
            return (Criteria) this;
        }

        public Criteria andCountDayLessThanOrEqualTo(Integer value) {
            addCriterion("count_day <=", value, "countDay");
            return (Criteria) this;
        }

        public Criteria andCountDayIn(List<Integer> values) {
            addCriterion("count_day in", values, "countDay");
            return (Criteria) this;
        }

        public Criteria andCountDayNotIn(List<Integer> values) {
            addCriterion("count_day not in", values, "countDay");
            return (Criteria) this;
        }

        public Criteria andCountDayBetween(Integer value1, Integer value2) {
            addCriterion("count_day between", value1, value2, "countDay");
            return (Criteria) this;
        }

        public Criteria andCountDayNotBetween(Integer value1, Integer value2) {
            addCriterion("count_day not between", value1, value2, "countDay");
            return (Criteria) this;
        }

        public Criteria andIsBarrageIsNull() {
            addCriterion("is_barrage is null");
            return (Criteria) this;
        }

        public Criteria andIsBarrageIsNotNull() {
            addCriterion("is_barrage is not null");
            return (Criteria) this;
        }

        public Criteria andIsBarrageEqualTo(String value) {
            addCriterion("is_barrage =", value, "isBarrage");
            return (Criteria) this;
        }

        public Criteria andIsBarrageNotEqualTo(String value) {
            addCriterion("is_barrage <>", value, "isBarrage");
            return (Criteria) this;
        }

        public Criteria andIsBarrageGreaterThan(String value) {
            addCriterion("is_barrage >", value, "isBarrage");
            return (Criteria) this;
        }

        public Criteria andIsBarrageGreaterThanOrEqualTo(String value) {
            addCriterion("is_barrage >=", value, "isBarrage");
            return (Criteria) this;
        }

        public Criteria andIsBarrageLessThan(String value) {
            addCriterion("is_barrage <", value, "isBarrage");
            return (Criteria) this;
        }

        public Criteria andIsBarrageLessThanOrEqualTo(String value) {
            addCriterion("is_barrage <=", value, "isBarrage");
            return (Criteria) this;
        }

        public Criteria andIsBarrageLike(String value) {
            addCriterion("is_barrage like", value, "isBarrage");
            return (Criteria) this;
        }

        public Criteria andIsBarrageNotLike(String value) {
            addCriterion("is_barrage not like", value, "isBarrage");
            return (Criteria) this;
        }

        public Criteria andIsBarrageIn(List<String> values) {
            addCriterion("is_barrage in", values, "isBarrage");
            return (Criteria) this;
        }

        public Criteria andIsBarrageNotIn(List<String> values) {
            addCriterion("is_barrage not in", values, "isBarrage");
            return (Criteria) this;
        }

        public Criteria andIsBarrageBetween(String value1, String value2) {
            addCriterion("is_barrage between", value1, value2, "isBarrage");
            return (Criteria) this;
        }

        public Criteria andIsBarrageNotBetween(String value1, String value2) {
            addCriterion("is_barrage not between", value1, value2, "isBarrage");
            return (Criteria) this;
        }

        public Criteria andIsWinIsNull() {
            addCriterion("is_win is null");
            return (Criteria) this;
        }

        public Criteria andIsWinIsNotNull() {
            addCriterion("is_win is not null");
            return (Criteria) this;
        }

        public Criteria andIsWinEqualTo(String value) {
            addCriterion("is_win =", value, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinNotEqualTo(String value) {
            addCriterion("is_win <>", value, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinGreaterThan(String value) {
            addCriterion("is_win >", value, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinGreaterThanOrEqualTo(String value) {
            addCriterion("is_win >=", value, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinLessThan(String value) {
            addCriterion("is_win <", value, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinLessThanOrEqualTo(String value) {
            addCriterion("is_win <=", value, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinLike(String value) {
            addCriterion("is_win like", value, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinNotLike(String value) {
            addCriterion("is_win not like", value, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinIn(List<String> values) {
            addCriterion("is_win in", values, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinNotIn(List<String> values) {
            addCriterion("is_win not in", values, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinBetween(String value1, String value2) {
            addCriterion("is_win between", value1, value2, "isWin");
            return (Criteria) this;
        }

        public Criteria andIsWinNotBetween(String value1, String value2) {
            addCriterion("is_win not between", value1, value2, "isWin");
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