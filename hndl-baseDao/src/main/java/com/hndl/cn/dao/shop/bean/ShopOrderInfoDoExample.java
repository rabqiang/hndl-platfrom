package com.hndl.cn.dao.shop.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopOrderInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ShopOrderInfoDoExample() {
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

        public Criteria andCreateTimeLongIsNull() {
            addCriterion("create_time_long is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLongIsNotNull() {
            addCriterion("create_time_long is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLongEqualTo(String value) {
            addCriterion("create_time_long =", value, "createTimeLong");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLongNotEqualTo(String value) {
            addCriterion("create_time_long <>", value, "createTimeLong");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLongGreaterThan(String value) {
            addCriterion("create_time_long >", value, "createTimeLong");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLongGreaterThanOrEqualTo(String value) {
            addCriterion("create_time_long >=", value, "createTimeLong");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLongLessThan(String value) {
            addCriterion("create_time_long <", value, "createTimeLong");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLongLessThanOrEqualTo(String value) {
            addCriterion("create_time_long <=", value, "createTimeLong");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLongLike(String value) {
            addCriterion("create_time_long like", value, "createTimeLong");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLongNotLike(String value) {
            addCriterion("create_time_long not like", value, "createTimeLong");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLongIn(List<String> values) {
            addCriterion("create_time_long in", values, "createTimeLong");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLongNotIn(List<String> values) {
            addCriterion("create_time_long not in", values, "createTimeLong");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLongBetween(String value1, String value2) {
            addCriterion("create_time_long between", value1, value2, "createTimeLong");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLongNotBetween(String value1, String value2) {
            addCriterion("create_time_long not between", value1, value2, "createTimeLong");
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

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Long value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Long value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Long value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Long value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Long value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Long> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Long> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Long value1, Long value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Long value1, Long value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andBuyCountIsNull() {
            addCriterion("buy_count is null");
            return (Criteria) this;
        }

        public Criteria andBuyCountIsNotNull() {
            addCriterion("buy_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuyCountEqualTo(Integer value) {
            addCriterion("buy_count =", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotEqualTo(Integer value) {
            addCriterion("buy_count <>", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountGreaterThan(Integer value) {
            addCriterion("buy_count >", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_count >=", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountLessThan(Integer value) {
            addCriterion("buy_count <", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountLessThanOrEqualTo(Integer value) {
            addCriterion("buy_count <=", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountIn(List<Integer> values) {
            addCriterion("buy_count in", values, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotIn(List<Integer> values) {
            addCriterion("buy_count not in", values, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountBetween(Integer value1, Integer value2) {
            addCriterion("buy_count between", value1, value2, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_count not between", value1, value2, "buyCount");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayCountIsNull() {
            addCriterion("pay_count is null");
            return (Criteria) this;
        }

        public Criteria andPayCountIsNotNull() {
            addCriterion("pay_count is not null");
            return (Criteria) this;
        }

        public Criteria andPayCountEqualTo(Double value) {
            addCriterion("pay_count =", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotEqualTo(Double value) {
            addCriterion("pay_count <>", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountGreaterThan(Double value) {
            addCriterion("pay_count >", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountGreaterThanOrEqualTo(Double value) {
            addCriterion("pay_count >=", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountLessThan(Double value) {
            addCriterion("pay_count <", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountLessThanOrEqualTo(Double value) {
            addCriterion("pay_count <=", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountIn(List<Double> values) {
            addCriterion("pay_count in", values, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotIn(List<Double> values) {
            addCriterion("pay_count not in", values, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountBetween(Double value1, Double value2) {
            addCriterion("pay_count between", value1, value2, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotBetween(Double value1, Double value2) {
            addCriterion("pay_count not between", value1, value2, "payCount");
            return (Criteria) this;
        }

        public Criteria andIsAllBuyIsNull() {
            addCriterion("is_all_buy is null");
            return (Criteria) this;
        }

        public Criteria andIsAllBuyIsNotNull() {
            addCriterion("is_all_buy is not null");
            return (Criteria) this;
        }

        public Criteria andIsAllBuyEqualTo(String value) {
            addCriterion("is_all_buy =", value, "isAllBuy");
            return (Criteria) this;
        }

        public Criteria andIsAllBuyNotEqualTo(String value) {
            addCriterion("is_all_buy <>", value, "isAllBuy");
            return (Criteria) this;
        }

        public Criteria andIsAllBuyGreaterThan(String value) {
            addCriterion("is_all_buy >", value, "isAllBuy");
            return (Criteria) this;
        }

        public Criteria andIsAllBuyGreaterThanOrEqualTo(String value) {
            addCriterion("is_all_buy >=", value, "isAllBuy");
            return (Criteria) this;
        }

        public Criteria andIsAllBuyLessThan(String value) {
            addCriterion("is_all_buy <", value, "isAllBuy");
            return (Criteria) this;
        }

        public Criteria andIsAllBuyLessThanOrEqualTo(String value) {
            addCriterion("is_all_buy <=", value, "isAllBuy");
            return (Criteria) this;
        }

        public Criteria andIsAllBuyLike(String value) {
            addCriterion("is_all_buy like", value, "isAllBuy");
            return (Criteria) this;
        }

        public Criteria andIsAllBuyNotLike(String value) {
            addCriterion("is_all_buy not like", value, "isAllBuy");
            return (Criteria) this;
        }

        public Criteria andIsAllBuyIn(List<String> values) {
            addCriterion("is_all_buy in", values, "isAllBuy");
            return (Criteria) this;
        }

        public Criteria andIsAllBuyNotIn(List<String> values) {
            addCriterion("is_all_buy not in", values, "isAllBuy");
            return (Criteria) this;
        }

        public Criteria andIsAllBuyBetween(String value1, String value2) {
            addCriterion("is_all_buy between", value1, value2, "isAllBuy");
            return (Criteria) this;
        }

        public Criteria andIsAllBuyNotBetween(String value1, String value2) {
            addCriterion("is_all_buy not between", value1, value2, "isAllBuy");
            return (Criteria) this;
        }

        public Criteria andIsTargetIsNull() {
            addCriterion("is_target is null");
            return (Criteria) this;
        }

        public Criteria andIsTargetIsNotNull() {
            addCriterion("is_target is not null");
            return (Criteria) this;
        }

        public Criteria andIsTargetEqualTo(String value) {
            addCriterion("is_target =", value, "isTarget");
            return (Criteria) this;
        }

        public Criteria andIsTargetNotEqualTo(String value) {
            addCriterion("is_target <>", value, "isTarget");
            return (Criteria) this;
        }

        public Criteria andIsTargetGreaterThan(String value) {
            addCriterion("is_target >", value, "isTarget");
            return (Criteria) this;
        }

        public Criteria andIsTargetGreaterThanOrEqualTo(String value) {
            addCriterion("is_target >=", value, "isTarget");
            return (Criteria) this;
        }

        public Criteria andIsTargetLessThan(String value) {
            addCriterion("is_target <", value, "isTarget");
            return (Criteria) this;
        }

        public Criteria andIsTargetLessThanOrEqualTo(String value) {
            addCriterion("is_target <=", value, "isTarget");
            return (Criteria) this;
        }

        public Criteria andIsTargetLike(String value) {
            addCriterion("is_target like", value, "isTarget");
            return (Criteria) this;
        }

        public Criteria andIsTargetNotLike(String value) {
            addCriterion("is_target not like", value, "isTarget");
            return (Criteria) this;
        }

        public Criteria andIsTargetIn(List<String> values) {
            addCriterion("is_target in", values, "isTarget");
            return (Criteria) this;
        }

        public Criteria andIsTargetNotIn(List<String> values) {
            addCriterion("is_target not in", values, "isTarget");
            return (Criteria) this;
        }

        public Criteria andIsTargetBetween(String value1, String value2) {
            addCriterion("is_target between", value1, value2, "isTarget");
            return (Criteria) this;
        }

        public Criteria andIsTargetNotBetween(String value1, String value2) {
            addCriterion("is_target not between", value1, value2, "isTarget");
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

        public Criteria andIpAddressIsNull() {
            addCriterion("ip_address is null");
            return (Criteria) this;
        }

        public Criteria andIpAddressIsNotNull() {
            addCriterion("ip_address is not null");
            return (Criteria) this;
        }

        public Criteria andIpAddressEqualTo(String value) {
            addCriterion("ip_address =", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotEqualTo(String value) {
            addCriterion("ip_address <>", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressGreaterThan(String value) {
            addCriterion("ip_address >", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ip_address >=", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLessThan(String value) {
            addCriterion("ip_address <", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLessThanOrEqualTo(String value) {
            addCriterion("ip_address <=", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLike(String value) {
            addCriterion("ip_address like", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotLike(String value) {
            addCriterion("ip_address not like", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressIn(List<String> values) {
            addCriterion("ip_address in", values, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotIn(List<String> values) {
            addCriterion("ip_address not in", values, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressBetween(String value1, String value2) {
            addCriterion("ip_address between", value1, value2, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotBetween(String value1, String value2) {
            addCriterion("ip_address not between", value1, value2, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdIsNull() {
            addCriterion("out_order_id is null");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdIsNotNull() {
            addCriterion("out_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdEqualTo(String value) {
            addCriterion("out_order_id =", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdNotEqualTo(String value) {
            addCriterion("out_order_id <>", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdGreaterThan(String value) {
            addCriterion("out_order_id >", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("out_order_id >=", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdLessThan(String value) {
            addCriterion("out_order_id <", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdLessThanOrEqualTo(String value) {
            addCriterion("out_order_id <=", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdLike(String value) {
            addCriterion("out_order_id like", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdNotLike(String value) {
            addCriterion("out_order_id not like", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdIn(List<String> values) {
            addCriterion("out_order_id in", values, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdNotIn(List<String> values) {
            addCriterion("out_order_id not in", values, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdBetween(String value1, String value2) {
            addCriterion("out_order_id between", value1, value2, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdNotBetween(String value1, String value2) {
            addCriterion("out_order_id not between", value1, value2, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andIsBackCoinIsNull() {
            addCriterion("is_back_coin is null");
            return (Criteria) this;
        }

        public Criteria andIsBackCoinIsNotNull() {
            addCriterion("is_back_coin is not null");
            return (Criteria) this;
        }

        public Criteria andIsBackCoinEqualTo(String value) {
            addCriterion("is_back_coin =", value, "isBackCoin");
            return (Criteria) this;
        }

        public Criteria andIsBackCoinNotEqualTo(String value) {
            addCriterion("is_back_coin <>", value, "isBackCoin");
            return (Criteria) this;
        }

        public Criteria andIsBackCoinGreaterThan(String value) {
            addCriterion("is_back_coin >", value, "isBackCoin");
            return (Criteria) this;
        }

        public Criteria andIsBackCoinGreaterThanOrEqualTo(String value) {
            addCriterion("is_back_coin >=", value, "isBackCoin");
            return (Criteria) this;
        }

        public Criteria andIsBackCoinLessThan(String value) {
            addCriterion("is_back_coin <", value, "isBackCoin");
            return (Criteria) this;
        }

        public Criteria andIsBackCoinLessThanOrEqualTo(String value) {
            addCriterion("is_back_coin <=", value, "isBackCoin");
            return (Criteria) this;
        }

        public Criteria andIsBackCoinLike(String value) {
            addCriterion("is_back_coin like", value, "isBackCoin");
            return (Criteria) this;
        }

        public Criteria andIsBackCoinNotLike(String value) {
            addCriterion("is_back_coin not like", value, "isBackCoin");
            return (Criteria) this;
        }

        public Criteria andIsBackCoinIn(List<String> values) {
            addCriterion("is_back_coin in", values, "isBackCoin");
            return (Criteria) this;
        }

        public Criteria andIsBackCoinNotIn(List<String> values) {
            addCriterion("is_back_coin not in", values, "isBackCoin");
            return (Criteria) this;
        }

        public Criteria andIsBackCoinBetween(String value1, String value2) {
            addCriterion("is_back_coin between", value1, value2, "isBackCoin");
            return (Criteria) this;
        }

        public Criteria andIsBackCoinNotBetween(String value1, String value2) {
            addCriterion("is_back_coin not between", value1, value2, "isBackCoin");
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

        public Criteria andIsWinningNoticedIsNull() {
            addCriterion("is_winning_noticed is null");
            return (Criteria) this;
        }

        public Criteria andIsWinningNoticedIsNotNull() {
            addCriterion("is_winning_noticed is not null");
            return (Criteria) this;
        }

        public Criteria andIsWinningNoticedEqualTo(String value) {
            addCriterion("is_winning_noticed =", value, "isWinningNoticed");
            return (Criteria) this;
        }

        public Criteria andIsWinningNoticedNotEqualTo(String value) {
            addCriterion("is_winning_noticed <>", value, "isWinningNoticed");
            return (Criteria) this;
        }

        public Criteria andIsWinningNoticedGreaterThan(String value) {
            addCriterion("is_winning_noticed >", value, "isWinningNoticed");
            return (Criteria) this;
        }

        public Criteria andIsWinningNoticedGreaterThanOrEqualTo(String value) {
            addCriterion("is_winning_noticed >=", value, "isWinningNoticed");
            return (Criteria) this;
        }

        public Criteria andIsWinningNoticedLessThan(String value) {
            addCriterion("is_winning_noticed <", value, "isWinningNoticed");
            return (Criteria) this;
        }

        public Criteria andIsWinningNoticedLessThanOrEqualTo(String value) {
            addCriterion("is_winning_noticed <=", value, "isWinningNoticed");
            return (Criteria) this;
        }

        public Criteria andIsWinningNoticedLike(String value) {
            addCriterion("is_winning_noticed like", value, "isWinningNoticed");
            return (Criteria) this;
        }

        public Criteria andIsWinningNoticedNotLike(String value) {
            addCriterion("is_winning_noticed not like", value, "isWinningNoticed");
            return (Criteria) this;
        }

        public Criteria andIsWinningNoticedIn(List<String> values) {
            addCriterion("is_winning_noticed in", values, "isWinningNoticed");
            return (Criteria) this;
        }

        public Criteria andIsWinningNoticedNotIn(List<String> values) {
            addCriterion("is_winning_noticed not in", values, "isWinningNoticed");
            return (Criteria) this;
        }

        public Criteria andIsWinningNoticedBetween(String value1, String value2) {
            addCriterion("is_winning_noticed between", value1, value2, "isWinningNoticed");
            return (Criteria) this;
        }

        public Criteria andIsWinningNoticedNotBetween(String value1, String value2) {
            addCriterion("is_winning_noticed not between", value1, value2, "isWinningNoticed");
            return (Criteria) this;
        }

        public Criteria andIsSendedNoticeIsNull() {
            addCriterion("is_sended_notice is null");
            return (Criteria) this;
        }

        public Criteria andIsSendedNoticeIsNotNull() {
            addCriterion("is_sended_notice is not null");
            return (Criteria) this;
        }

        public Criteria andIsSendedNoticeEqualTo(String value) {
            addCriterion("is_sended_notice =", value, "isSendedNotice");
            return (Criteria) this;
        }

        public Criteria andIsSendedNoticeNotEqualTo(String value) {
            addCriterion("is_sended_notice <>", value, "isSendedNotice");
            return (Criteria) this;
        }

        public Criteria andIsSendedNoticeGreaterThan(String value) {
            addCriterion("is_sended_notice >", value, "isSendedNotice");
            return (Criteria) this;
        }

        public Criteria andIsSendedNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("is_sended_notice >=", value, "isSendedNotice");
            return (Criteria) this;
        }

        public Criteria andIsSendedNoticeLessThan(String value) {
            addCriterion("is_sended_notice <", value, "isSendedNotice");
            return (Criteria) this;
        }

        public Criteria andIsSendedNoticeLessThanOrEqualTo(String value) {
            addCriterion("is_sended_notice <=", value, "isSendedNotice");
            return (Criteria) this;
        }

        public Criteria andIsSendedNoticeLike(String value) {
            addCriterion("is_sended_notice like", value, "isSendedNotice");
            return (Criteria) this;
        }

        public Criteria andIsSendedNoticeNotLike(String value) {
            addCriterion("is_sended_notice not like", value, "isSendedNotice");
            return (Criteria) this;
        }

        public Criteria andIsSendedNoticeIn(List<String> values) {
            addCriterion("is_sended_notice in", values, "isSendedNotice");
            return (Criteria) this;
        }

        public Criteria andIsSendedNoticeNotIn(List<String> values) {
            addCriterion("is_sended_notice not in", values, "isSendedNotice");
            return (Criteria) this;
        }

        public Criteria andIsSendedNoticeBetween(String value1, String value2) {
            addCriterion("is_sended_notice between", value1, value2, "isSendedNotice");
            return (Criteria) this;
        }

        public Criteria andIsSendedNoticeNotBetween(String value1, String value2) {
            addCriterion("is_sended_notice not between", value1, value2, "isSendedNotice");
            return (Criteria) this;
        }

        public Criteria andStartLuckNumberIsNull() {
            addCriterion("start_luck_number is null");
            return (Criteria) this;
        }

        public Criteria andStartLuckNumberIsNotNull() {
            addCriterion("start_luck_number is not null");
            return (Criteria) this;
        }

        public Criteria andStartLuckNumberEqualTo(String value) {
            addCriterion("start_luck_number =", value, "startLuckNumber");
            return (Criteria) this;
        }

        public Criteria andStartLuckNumberNotEqualTo(String value) {
            addCriterion("start_luck_number <>", value, "startLuckNumber");
            return (Criteria) this;
        }

        public Criteria andStartLuckNumberGreaterThan(String value) {
            addCriterion("start_luck_number >", value, "startLuckNumber");
            return (Criteria) this;
        }

        public Criteria andStartLuckNumberGreaterThanOrEqualTo(String value) {
            addCriterion("start_luck_number >=", value, "startLuckNumber");
            return (Criteria) this;
        }

        public Criteria andStartLuckNumberLessThan(String value) {
            addCriterion("start_luck_number <", value, "startLuckNumber");
            return (Criteria) this;
        }

        public Criteria andStartLuckNumberLessThanOrEqualTo(String value) {
            addCriterion("start_luck_number <=", value, "startLuckNumber");
            return (Criteria) this;
        }

        public Criteria andStartLuckNumberLike(String value) {
            addCriterion("start_luck_number like", value, "startLuckNumber");
            return (Criteria) this;
        }

        public Criteria andStartLuckNumberNotLike(String value) {
            addCriterion("start_luck_number not like", value, "startLuckNumber");
            return (Criteria) this;
        }

        public Criteria andStartLuckNumberIn(List<String> values) {
            addCriterion("start_luck_number in", values, "startLuckNumber");
            return (Criteria) this;
        }

        public Criteria andStartLuckNumberNotIn(List<String> values) {
            addCriterion("start_luck_number not in", values, "startLuckNumber");
            return (Criteria) this;
        }

        public Criteria andStartLuckNumberBetween(String value1, String value2) {
            addCriterion("start_luck_number between", value1, value2, "startLuckNumber");
            return (Criteria) this;
        }

        public Criteria andStartLuckNumberNotBetween(String value1, String value2) {
            addCriterion("start_luck_number not between", value1, value2, "startLuckNumber");
            return (Criteria) this;
        }

        public Criteria andEndLuckNumberIsNull() {
            addCriterion("end_luck_number is null");
            return (Criteria) this;
        }

        public Criteria andEndLuckNumberIsNotNull() {
            addCriterion("end_luck_number is not null");
            return (Criteria) this;
        }

        public Criteria andEndLuckNumberEqualTo(String value) {
            addCriterion("end_luck_number =", value, "endLuckNumber");
            return (Criteria) this;
        }

        public Criteria andEndLuckNumberNotEqualTo(String value) {
            addCriterion("end_luck_number <>", value, "endLuckNumber");
            return (Criteria) this;
        }

        public Criteria andEndLuckNumberGreaterThan(String value) {
            addCriterion("end_luck_number >", value, "endLuckNumber");
            return (Criteria) this;
        }

        public Criteria andEndLuckNumberGreaterThanOrEqualTo(String value) {
            addCriterion("end_luck_number >=", value, "endLuckNumber");
            return (Criteria) this;
        }

        public Criteria andEndLuckNumberLessThan(String value) {
            addCriterion("end_luck_number <", value, "endLuckNumber");
            return (Criteria) this;
        }

        public Criteria andEndLuckNumberLessThanOrEqualTo(String value) {
            addCriterion("end_luck_number <=", value, "endLuckNumber");
            return (Criteria) this;
        }

        public Criteria andEndLuckNumberLike(String value) {
            addCriterion("end_luck_number like", value, "endLuckNumber");
            return (Criteria) this;
        }

        public Criteria andEndLuckNumberNotLike(String value) {
            addCriterion("end_luck_number not like", value, "endLuckNumber");
            return (Criteria) this;
        }

        public Criteria andEndLuckNumberIn(List<String> values) {
            addCriterion("end_luck_number in", values, "endLuckNumber");
            return (Criteria) this;
        }

        public Criteria andEndLuckNumberNotIn(List<String> values) {
            addCriterion("end_luck_number not in", values, "endLuckNumber");
            return (Criteria) this;
        }

        public Criteria andEndLuckNumberBetween(String value1, String value2) {
            addCriterion("end_luck_number between", value1, value2, "endLuckNumber");
            return (Criteria) this;
        }

        public Criteria andEndLuckNumberNotBetween(String value1, String value2) {
            addCriterion("end_luck_number not between", value1, value2, "endLuckNumber");
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