package com.hndl.cn.dao.coin.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HappyCoinBillInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public HappyCoinBillInfoDoExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNull() {
            addCriterion("is_pay is null");
            return (Criteria) this;
        }

        public Criteria andIsPayIsNotNull() {
            addCriterion("is_pay is not null");
            return (Criteria) this;
        }

        public Criteria andIsPayEqualTo(Integer value) {
            addCriterion("is_pay =", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotEqualTo(Integer value) {
            addCriterion("is_pay <>", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThan(Integer value) {
            addCriterion("is_pay >", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_pay >=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThan(Integer value) {
            addCriterion("is_pay <", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayLessThanOrEqualTo(Integer value) {
            addCriterion("is_pay <=", value, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayIn(List<Integer> values) {
            addCriterion("is_pay in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotIn(List<Integer> values) {
            addCriterion("is_pay not in", values, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayBetween(Integer value1, Integer value2) {
            addCriterion("is_pay between", value1, value2, "isPay");
            return (Criteria) this;
        }

        public Criteria andIsPayNotBetween(Integer value1, Integer value2) {
            addCriterion("is_pay not between", value1, value2, "isPay");
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

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andCoinCountIsNull() {
            addCriterion("coin_count is null");
            return (Criteria) this;
        }

        public Criteria andCoinCountIsNotNull() {
            addCriterion("coin_count is not null");
            return (Criteria) this;
        }

        public Criteria andCoinCountEqualTo(Long value) {
            addCriterion("coin_count =", value, "coinCount");
            return (Criteria) this;
        }

        public Criteria andCoinCountNotEqualTo(Long value) {
            addCriterion("coin_count <>", value, "coinCount");
            return (Criteria) this;
        }

        public Criteria andCoinCountGreaterThan(Long value) {
            addCriterion("coin_count >", value, "coinCount");
            return (Criteria) this;
        }

        public Criteria andCoinCountGreaterThanOrEqualTo(Long value) {
            addCriterion("coin_count >=", value, "coinCount");
            return (Criteria) this;
        }

        public Criteria andCoinCountLessThan(Long value) {
            addCriterion("coin_count <", value, "coinCount");
            return (Criteria) this;
        }

        public Criteria andCoinCountLessThanOrEqualTo(Long value) {
            addCriterion("coin_count <=", value, "coinCount");
            return (Criteria) this;
        }

        public Criteria andCoinCountIn(List<Long> values) {
            addCriterion("coin_count in", values, "coinCount");
            return (Criteria) this;
        }

        public Criteria andCoinCountNotIn(List<Long> values) {
            addCriterion("coin_count not in", values, "coinCount");
            return (Criteria) this;
        }

        public Criteria andCoinCountBetween(Long value1, Long value2) {
            addCriterion("coin_count between", value1, value2, "coinCount");
            return (Criteria) this;
        }

        public Criteria andCoinCountNotBetween(Long value1, Long value2) {
            addCriterion("coin_count not between", value1, value2, "coinCount");
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

        public Criteria andLocalTradeNoIsNull() {
            addCriterion("local_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andLocalTradeNoIsNotNull() {
            addCriterion("local_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andLocalTradeNoEqualTo(Long value) {
            addCriterion("local_trade_no =", value, "localTradeNo");
            return (Criteria) this;
        }

        public Criteria andLocalTradeNoNotEqualTo(Long value) {
            addCriterion("local_trade_no <>", value, "localTradeNo");
            return (Criteria) this;
        }

        public Criteria andLocalTradeNoGreaterThan(Long value) {
            addCriterion("local_trade_no >", value, "localTradeNo");
            return (Criteria) this;
        }

        public Criteria andLocalTradeNoGreaterThanOrEqualTo(Long value) {
            addCriterion("local_trade_no >=", value, "localTradeNo");
            return (Criteria) this;
        }

        public Criteria andLocalTradeNoLessThan(Long value) {
            addCriterion("local_trade_no <", value, "localTradeNo");
            return (Criteria) this;
        }

        public Criteria andLocalTradeNoLessThanOrEqualTo(Long value) {
            addCriterion("local_trade_no <=", value, "localTradeNo");
            return (Criteria) this;
        }

        public Criteria andLocalTradeNoIn(List<Long> values) {
            addCriterion("local_trade_no in", values, "localTradeNo");
            return (Criteria) this;
        }

        public Criteria andLocalTradeNoNotIn(List<Long> values) {
            addCriterion("local_trade_no not in", values, "localTradeNo");
            return (Criteria) this;
        }

        public Criteria andLocalTradeNoBetween(Long value1, Long value2) {
            addCriterion("local_trade_no between", value1, value2, "localTradeNo");
            return (Criteria) this;
        }

        public Criteria andLocalTradeNoNotBetween(Long value1, Long value2) {
            addCriterion("local_trade_no not between", value1, value2, "localTradeNo");
            return (Criteria) this;
        }

        public Criteria andRemoteTradeNoIsNull() {
            addCriterion("remote_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andRemoteTradeNoIsNotNull() {
            addCriterion("remote_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteTradeNoEqualTo(String value) {
            addCriterion("remote_trade_no =", value, "remoteTradeNo");
            return (Criteria) this;
        }

        public Criteria andRemoteTradeNoNotEqualTo(String value) {
            addCriterion("remote_trade_no <>", value, "remoteTradeNo");
            return (Criteria) this;
        }

        public Criteria andRemoteTradeNoGreaterThan(String value) {
            addCriterion("remote_trade_no >", value, "remoteTradeNo");
            return (Criteria) this;
        }

        public Criteria andRemoteTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("remote_trade_no >=", value, "remoteTradeNo");
            return (Criteria) this;
        }

        public Criteria andRemoteTradeNoLessThan(String value) {
            addCriterion("remote_trade_no <", value, "remoteTradeNo");
            return (Criteria) this;
        }

        public Criteria andRemoteTradeNoLessThanOrEqualTo(String value) {
            addCriterion("remote_trade_no <=", value, "remoteTradeNo");
            return (Criteria) this;
        }

        public Criteria andRemoteTradeNoLike(String value) {
            addCriterion("remote_trade_no like", value, "remoteTradeNo");
            return (Criteria) this;
        }

        public Criteria andRemoteTradeNoNotLike(String value) {
            addCriterion("remote_trade_no not like", value, "remoteTradeNo");
            return (Criteria) this;
        }

        public Criteria andRemoteTradeNoIn(List<String> values) {
            addCriterion("remote_trade_no in", values, "remoteTradeNo");
            return (Criteria) this;
        }

        public Criteria andRemoteTradeNoNotIn(List<String> values) {
            addCriterion("remote_trade_no not in", values, "remoteTradeNo");
            return (Criteria) this;
        }

        public Criteria andRemoteTradeNoBetween(String value1, String value2) {
            addCriterion("remote_trade_no between", value1, value2, "remoteTradeNo");
            return (Criteria) this;
        }

        public Criteria andRemoteTradeNoNotBetween(String value1, String value2) {
            addCriterion("remote_trade_no not between", value1, value2, "remoteTradeNo");
            return (Criteria) this;
        }

        public Criteria andOldCoinCountIsNull() {
            addCriterion("old_coin_count is null");
            return (Criteria) this;
        }

        public Criteria andOldCoinCountIsNotNull() {
            addCriterion("old_coin_count is not null");
            return (Criteria) this;
        }

        public Criteria andOldCoinCountEqualTo(Long value) {
            addCriterion("old_coin_count =", value, "oldCoinCount");
            return (Criteria) this;
        }

        public Criteria andOldCoinCountNotEqualTo(Long value) {
            addCriterion("old_coin_count <>", value, "oldCoinCount");
            return (Criteria) this;
        }

        public Criteria andOldCoinCountGreaterThan(Long value) {
            addCriterion("old_coin_count >", value, "oldCoinCount");
            return (Criteria) this;
        }

        public Criteria andOldCoinCountGreaterThanOrEqualTo(Long value) {
            addCriterion("old_coin_count >=", value, "oldCoinCount");
            return (Criteria) this;
        }

        public Criteria andOldCoinCountLessThan(Long value) {
            addCriterion("old_coin_count <", value, "oldCoinCount");
            return (Criteria) this;
        }

        public Criteria andOldCoinCountLessThanOrEqualTo(Long value) {
            addCriterion("old_coin_count <=", value, "oldCoinCount");
            return (Criteria) this;
        }

        public Criteria andOldCoinCountIn(List<Long> values) {
            addCriterion("old_coin_count in", values, "oldCoinCount");
            return (Criteria) this;
        }

        public Criteria andOldCoinCountNotIn(List<Long> values) {
            addCriterion("old_coin_count not in", values, "oldCoinCount");
            return (Criteria) this;
        }

        public Criteria andOldCoinCountBetween(Long value1, Long value2) {
            addCriterion("old_coin_count between", value1, value2, "oldCoinCount");
            return (Criteria) this;
        }

        public Criteria andOldCoinCountNotBetween(Long value1, Long value2) {
            addCriterion("old_coin_count not between", value1, value2, "oldCoinCount");
            return (Criteria) this;
        }

        public Criteria andNewCoinCountIsNull() {
            addCriterion("new_coin_count is null");
            return (Criteria) this;
        }

        public Criteria andNewCoinCountIsNotNull() {
            addCriterion("new_coin_count is not null");
            return (Criteria) this;
        }

        public Criteria andNewCoinCountEqualTo(Long value) {
            addCriterion("new_coin_count =", value, "newCoinCount");
            return (Criteria) this;
        }

        public Criteria andNewCoinCountNotEqualTo(Long value) {
            addCriterion("new_coin_count <>", value, "newCoinCount");
            return (Criteria) this;
        }

        public Criteria andNewCoinCountGreaterThan(Long value) {
            addCriterion("new_coin_count >", value, "newCoinCount");
            return (Criteria) this;
        }

        public Criteria andNewCoinCountGreaterThanOrEqualTo(Long value) {
            addCriterion("new_coin_count >=", value, "newCoinCount");
            return (Criteria) this;
        }

        public Criteria andNewCoinCountLessThan(Long value) {
            addCriterion("new_coin_count <", value, "newCoinCount");
            return (Criteria) this;
        }

        public Criteria andNewCoinCountLessThanOrEqualTo(Long value) {
            addCriterion("new_coin_count <=", value, "newCoinCount");
            return (Criteria) this;
        }

        public Criteria andNewCoinCountIn(List<Long> values) {
            addCriterion("new_coin_count in", values, "newCoinCount");
            return (Criteria) this;
        }

        public Criteria andNewCoinCountNotIn(List<Long> values) {
            addCriterion("new_coin_count not in", values, "newCoinCount");
            return (Criteria) this;
        }

        public Criteria andNewCoinCountBetween(Long value1, Long value2) {
            addCriterion("new_coin_count between", value1, value2, "newCoinCount");
            return (Criteria) this;
        }

        public Criteria andNewCoinCountNotBetween(Long value1, Long value2) {
            addCriterion("new_coin_count not between", value1, value2, "newCoinCount");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Long value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Long value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Long value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Long value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Long> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Long> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Long value1, Long value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andReasonTypeIsNull() {
            addCriterion("reason_type is null");
            return (Criteria) this;
        }

        public Criteria andReasonTypeIsNotNull() {
            addCriterion("reason_type is not null");
            return (Criteria) this;
        }

        public Criteria andReasonTypeEqualTo(Integer value) {
            addCriterion("reason_type =", value, "reasonType");
            return (Criteria) this;
        }

        public Criteria andReasonTypeNotEqualTo(Integer value) {
            addCriterion("reason_type <>", value, "reasonType");
            return (Criteria) this;
        }

        public Criteria andReasonTypeGreaterThan(Integer value) {
            addCriterion("reason_type >", value, "reasonType");
            return (Criteria) this;
        }

        public Criteria andReasonTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reason_type >=", value, "reasonType");
            return (Criteria) this;
        }

        public Criteria andReasonTypeLessThan(Integer value) {
            addCriterion("reason_type <", value, "reasonType");
            return (Criteria) this;
        }

        public Criteria andReasonTypeLessThanOrEqualTo(Integer value) {
            addCriterion("reason_type <=", value, "reasonType");
            return (Criteria) this;
        }

        public Criteria andReasonTypeIn(List<Integer> values) {
            addCriterion("reason_type in", values, "reasonType");
            return (Criteria) this;
        }

        public Criteria andReasonTypeNotIn(List<Integer> values) {
            addCriterion("reason_type not in", values, "reasonType");
            return (Criteria) this;
        }

        public Criteria andReasonTypeBetween(Integer value1, Integer value2) {
            addCriterion("reason_type between", value1, value2, "reasonType");
            return (Criteria) this;
        }

        public Criteria andReasonTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("reason_type not between", value1, value2, "reasonType");
            return (Criteria) this;
        }

        public Criteria andReasonObjIdIsNull() {
            addCriterion("reason_obj_id is null");
            return (Criteria) this;
        }

        public Criteria andReasonObjIdIsNotNull() {
            addCriterion("reason_obj_id is not null");
            return (Criteria) this;
        }

        public Criteria andReasonObjIdEqualTo(String value) {
            addCriterion("reason_obj_id =", value, "reasonObjId");
            return (Criteria) this;
        }

        public Criteria andReasonObjIdNotEqualTo(String value) {
            addCriterion("reason_obj_id <>", value, "reasonObjId");
            return (Criteria) this;
        }

        public Criteria andReasonObjIdGreaterThan(String value) {
            addCriterion("reason_obj_id >", value, "reasonObjId");
            return (Criteria) this;
        }

        public Criteria andReasonObjIdGreaterThanOrEqualTo(String value) {
            addCriterion("reason_obj_id >=", value, "reasonObjId");
            return (Criteria) this;
        }

        public Criteria andReasonObjIdLessThan(String value) {
            addCriterion("reason_obj_id <", value, "reasonObjId");
            return (Criteria) this;
        }

        public Criteria andReasonObjIdLessThanOrEqualTo(String value) {
            addCriterion("reason_obj_id <=", value, "reasonObjId");
            return (Criteria) this;
        }

        public Criteria andReasonObjIdLike(String value) {
            addCriterion("reason_obj_id like", value, "reasonObjId");
            return (Criteria) this;
        }

        public Criteria andReasonObjIdNotLike(String value) {
            addCriterion("reason_obj_id not like", value, "reasonObjId");
            return (Criteria) this;
        }

        public Criteria andReasonObjIdIn(List<String> values) {
            addCriterion("reason_obj_id in", values, "reasonObjId");
            return (Criteria) this;
        }

        public Criteria andReasonObjIdNotIn(List<String> values) {
            addCriterion("reason_obj_id not in", values, "reasonObjId");
            return (Criteria) this;
        }

        public Criteria andReasonObjIdBetween(String value1, String value2) {
            addCriterion("reason_obj_id between", value1, value2, "reasonObjId");
            return (Criteria) this;
        }

        public Criteria andReasonObjIdNotBetween(String value1, String value2) {
            addCriterion("reason_obj_id not between", value1, value2, "reasonObjId");
            return (Criteria) this;
        }

        public Criteria andExpand1IsNull() {
            addCriterion("expand_1 is null");
            return (Criteria) this;
        }

        public Criteria andExpand1IsNotNull() {
            addCriterion("expand_1 is not null");
            return (Criteria) this;
        }

        public Criteria andExpand1EqualTo(String value) {
            addCriterion("expand_1 =", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1NotEqualTo(String value) {
            addCriterion("expand_1 <>", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1GreaterThan(String value) {
            addCriterion("expand_1 >", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1GreaterThanOrEqualTo(String value) {
            addCriterion("expand_1 >=", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1LessThan(String value) {
            addCriterion("expand_1 <", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1LessThanOrEqualTo(String value) {
            addCriterion("expand_1 <=", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1Like(String value) {
            addCriterion("expand_1 like", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1NotLike(String value) {
            addCriterion("expand_1 not like", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1In(List<String> values) {
            addCriterion("expand_1 in", values, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1NotIn(List<String> values) {
            addCriterion("expand_1 not in", values, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1Between(String value1, String value2) {
            addCriterion("expand_1 between", value1, value2, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1NotBetween(String value1, String value2) {
            addCriterion("expand_1 not between", value1, value2, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand2IsNull() {
            addCriterion("expand_2 is null");
            return (Criteria) this;
        }

        public Criteria andExpand2IsNotNull() {
            addCriterion("expand_2 is not null");
            return (Criteria) this;
        }

        public Criteria andExpand2EqualTo(String value) {
            addCriterion("expand_2 =", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2NotEqualTo(String value) {
            addCriterion("expand_2 <>", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2GreaterThan(String value) {
            addCriterion("expand_2 >", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2GreaterThanOrEqualTo(String value) {
            addCriterion("expand_2 >=", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2LessThan(String value) {
            addCriterion("expand_2 <", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2LessThanOrEqualTo(String value) {
            addCriterion("expand_2 <=", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2Like(String value) {
            addCriterion("expand_2 like", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2NotLike(String value) {
            addCriterion("expand_2 not like", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2In(List<String> values) {
            addCriterion("expand_2 in", values, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2NotIn(List<String> values) {
            addCriterion("expand_2 not in", values, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2Between(String value1, String value2) {
            addCriterion("expand_2 between", value1, value2, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2NotBetween(String value1, String value2) {
            addCriterion("expand_2 not between", value1, value2, "expand2");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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