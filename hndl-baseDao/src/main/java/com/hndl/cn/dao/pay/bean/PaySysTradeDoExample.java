package com.hndl.cn.dao.pay.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaySysTradeDoExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PaySysTradeDoExample() {
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

        public Criteria andPayChannelIsNull() {
            addCriterion("pay_channel is null");
            return (Criteria) this;
        }

        public Criteria andPayChannelIsNotNull() {
            addCriterion("pay_channel is not null");
            return (Criteria) this;
        }

        public Criteria andPayChannelEqualTo(Integer value) {
            addCriterion("pay_channel =", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotEqualTo(Integer value) {
            addCriterion("pay_channel <>", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelGreaterThan(Integer value) {
            addCriterion("pay_channel >", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_channel >=", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLessThan(Integer value) {
            addCriterion("pay_channel <", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelLessThanOrEqualTo(Integer value) {
            addCriterion("pay_channel <=", value, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelIn(List<Integer> values) {
            addCriterion("pay_channel in", values, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotIn(List<Integer> values) {
            addCriterion("pay_channel not in", values, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelBetween(Integer value1, Integer value2) {
            addCriterion("pay_channel between", value1, value2, "payChannel");
            return (Criteria) this;
        }

        public Criteria andPayChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_channel not between", value1, value2, "payChannel");
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

        public Criteria andCallbackTimeIsNull() {
            addCriterion("callback_time is null");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeIsNotNull() {
            addCriterion("callback_time is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeEqualTo(Date value) {
            addCriterion("callback_time =", value, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeNotEqualTo(Date value) {
            addCriterion("callback_time <>", value, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeGreaterThan(Date value) {
            addCriterion("callback_time >", value, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("callback_time >=", value, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeLessThan(Date value) {
            addCriterion("callback_time <", value, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeLessThanOrEqualTo(Date value) {
            addCriterion("callback_time <=", value, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeIn(List<Date> values) {
            addCriterion("callback_time in", values, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeNotIn(List<Date> values) {
            addCriterion("callback_time not in", values, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeBetween(Date value1, Date value2) {
            addCriterion("callback_time between", value1, value2, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeNotBetween(Date value1, Date value2) {
            addCriterion("callback_time not between", value1, value2, "callbackTime");
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

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberIsNull() {
            addCriterion("money_number is null");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberIsNotNull() {
            addCriterion("money_number is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberEqualTo(Long value) {
            addCriterion("money_number =", value, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberNotEqualTo(Long value) {
            addCriterion("money_number <>", value, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberGreaterThan(Long value) {
            addCriterion("money_number >", value, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("money_number >=", value, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberLessThan(Long value) {
            addCriterion("money_number <", value, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberLessThanOrEqualTo(Long value) {
            addCriterion("money_number <=", value, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberIn(List<Long> values) {
            addCriterion("money_number in", values, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberNotIn(List<Long> values) {
            addCriterion("money_number not in", values, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberBetween(Long value1, Long value2) {
            addCriterion("money_number between", value1, value2, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andMoneyNumberNotBetween(Long value1, Long value2) {
            addCriterion("money_number not between", value1, value2, "moneyNumber");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNull() {
            addCriterion("pay_state is null");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNotNull() {
            addCriterion("pay_state is not null");
            return (Criteria) this;
        }

        public Criteria andPayStateEqualTo(Integer value) {
            addCriterion("pay_state =", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotEqualTo(Integer value) {
            addCriterion("pay_state <>", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThan(Integer value) {
            addCriterion("pay_state >", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_state >=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThan(Integer value) {
            addCriterion("pay_state <", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThanOrEqualTo(Integer value) {
            addCriterion("pay_state <=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateIn(List<Integer> values) {
            addCriterion("pay_state in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotIn(List<Integer> values) {
            addCriterion("pay_state not in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateBetween(Integer value1, Integer value2) {
            addCriterion("pay_state between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_state not between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andExpand1IsNull() {
            addCriterion("expand1 is null");
            return (Criteria) this;
        }

        public Criteria andExpand1IsNotNull() {
            addCriterion("expand1 is not null");
            return (Criteria) this;
        }

        public Criteria andExpand1EqualTo(String value) {
            addCriterion("expand1 =", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1NotEqualTo(String value) {
            addCriterion("expand1 <>", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1GreaterThan(String value) {
            addCriterion("expand1 >", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1GreaterThanOrEqualTo(String value) {
            addCriterion("expand1 >=", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1LessThan(String value) {
            addCriterion("expand1 <", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1LessThanOrEqualTo(String value) {
            addCriterion("expand1 <=", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1Like(String value) {
            addCriterion("expand1 like", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1NotLike(String value) {
            addCriterion("expand1 not like", value, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1In(List<String> values) {
            addCriterion("expand1 in", values, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1NotIn(List<String> values) {
            addCriterion("expand1 not in", values, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1Between(String value1, String value2) {
            addCriterion("expand1 between", value1, value2, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand1NotBetween(String value1, String value2) {
            addCriterion("expand1 not between", value1, value2, "expand1");
            return (Criteria) this;
        }

        public Criteria andExpand2IsNull() {
            addCriterion("expand2 is null");
            return (Criteria) this;
        }

        public Criteria andExpand2IsNotNull() {
            addCriterion("expand2 is not null");
            return (Criteria) this;
        }

        public Criteria andExpand2EqualTo(String value) {
            addCriterion("expand2 =", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2NotEqualTo(String value) {
            addCriterion("expand2 <>", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2GreaterThan(String value) {
            addCriterion("expand2 >", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2GreaterThanOrEqualTo(String value) {
            addCriterion("expand2 >=", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2LessThan(String value) {
            addCriterion("expand2 <", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2LessThanOrEqualTo(String value) {
            addCriterion("expand2 <=", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2Like(String value) {
            addCriterion("expand2 like", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2NotLike(String value) {
            addCriterion("expand2 not like", value, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2In(List<String> values) {
            addCriterion("expand2 in", values, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2NotIn(List<String> values) {
            addCriterion("expand2 not in", values, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2Between(String value1, String value2) {
            addCriterion("expand2 between", value1, value2, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand2NotBetween(String value1, String value2) {
            addCriterion("expand2 not between", value1, value2, "expand2");
            return (Criteria) this;
        }

        public Criteria andExpand3IsNull() {
            addCriterion("expand3 is null");
            return (Criteria) this;
        }

        public Criteria andExpand3IsNotNull() {
            addCriterion("expand3 is not null");
            return (Criteria) this;
        }

        public Criteria andExpand3EqualTo(String value) {
            addCriterion("expand3 =", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3NotEqualTo(String value) {
            addCriterion("expand3 <>", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3GreaterThan(String value) {
            addCriterion("expand3 >", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3GreaterThanOrEqualTo(String value) {
            addCriterion("expand3 >=", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3LessThan(String value) {
            addCriterion("expand3 <", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3LessThanOrEqualTo(String value) {
            addCriterion("expand3 <=", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3Like(String value) {
            addCriterion("expand3 like", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3NotLike(String value) {
            addCriterion("expand3 not like", value, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3In(List<String> values) {
            addCriterion("expand3 in", values, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3NotIn(List<String> values) {
            addCriterion("expand3 not in", values, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3Between(String value1, String value2) {
            addCriterion("expand3 between", value1, value2, "expand3");
            return (Criteria) this;
        }

        public Criteria andExpand3NotBetween(String value1, String value2) {
            addCriterion("expand3 not between", value1, value2, "expand3");
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