package com.hndl.cn.dao.game.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameNewyearAnswerDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public GameNewyearAnswerDoExample() {
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

        public Criteria andAnswerNumIsNull() {
            addCriterion("answer_num is null");
            return (Criteria) this;
        }

        public Criteria andAnswerNumIsNotNull() {
            addCriterion("answer_num is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerNumEqualTo(String value) {
            addCriterion("answer_num =", value, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumNotEqualTo(String value) {
            addCriterion("answer_num <>", value, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumGreaterThan(String value) {
            addCriterion("answer_num >", value, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumGreaterThanOrEqualTo(String value) {
            addCriterion("answer_num >=", value, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumLessThan(String value) {
            addCriterion("answer_num <", value, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumLessThanOrEqualTo(String value) {
            addCriterion("answer_num <=", value, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumLike(String value) {
            addCriterion("answer_num like", value, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumNotLike(String value) {
            addCriterion("answer_num not like", value, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumIn(List<String> values) {
            addCriterion("answer_num in", values, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumNotIn(List<String> values) {
            addCriterion("answer_num not in", values, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumBetween(String value1, String value2) {
            addCriterion("answer_num between", value1, value2, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerNumNotBetween(String value1, String value2) {
            addCriterion("answer_num not between", value1, value2, "answerNum");
            return (Criteria) this;
        }

        public Criteria andAnswerValueIsNull() {
            addCriterion("answer_value is null");
            return (Criteria) this;
        }

        public Criteria andAnswerValueIsNotNull() {
            addCriterion("answer_value is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerValueEqualTo(String value) {
            addCriterion("answer_value =", value, "answerValue");
            return (Criteria) this;
        }

        public Criteria andAnswerValueNotEqualTo(String value) {
            addCriterion("answer_value <>", value, "answerValue");
            return (Criteria) this;
        }

        public Criteria andAnswerValueGreaterThan(String value) {
            addCriterion("answer_value >", value, "answerValue");
            return (Criteria) this;
        }

        public Criteria andAnswerValueGreaterThanOrEqualTo(String value) {
            addCriterion("answer_value >=", value, "answerValue");
            return (Criteria) this;
        }

        public Criteria andAnswerValueLessThan(String value) {
            addCriterion("answer_value <", value, "answerValue");
            return (Criteria) this;
        }

        public Criteria andAnswerValueLessThanOrEqualTo(String value) {
            addCriterion("answer_value <=", value, "answerValue");
            return (Criteria) this;
        }

        public Criteria andAnswerValueLike(String value) {
            addCriterion("answer_value like", value, "answerValue");
            return (Criteria) this;
        }

        public Criteria andAnswerValueNotLike(String value) {
            addCriterion("answer_value not like", value, "answerValue");
            return (Criteria) this;
        }

        public Criteria andAnswerValueIn(List<String> values) {
            addCriterion("answer_value in", values, "answerValue");
            return (Criteria) this;
        }

        public Criteria andAnswerValueNotIn(List<String> values) {
            addCriterion("answer_value not in", values, "answerValue");
            return (Criteria) this;
        }

        public Criteria andAnswerValueBetween(String value1, String value2) {
            addCriterion("answer_value between", value1, value2, "answerValue");
            return (Criteria) this;
        }

        public Criteria andAnswerValueNotBetween(String value1, String value2) {
            addCriterion("answer_value not between", value1, value2, "answerValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueIsNull() {
            addCriterion("vote_value is null");
            return (Criteria) this;
        }

        public Criteria andVoteValueIsNotNull() {
            addCriterion("vote_value is not null");
            return (Criteria) this;
        }

        public Criteria andVoteValueEqualTo(String value) {
            addCriterion("vote_value =", value, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueNotEqualTo(String value) {
            addCriterion("vote_value <>", value, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueGreaterThan(String value) {
            addCriterion("vote_value >", value, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueGreaterThanOrEqualTo(String value) {
            addCriterion("vote_value >=", value, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueLessThan(String value) {
            addCriterion("vote_value <", value, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueLessThanOrEqualTo(String value) {
            addCriterion("vote_value <=", value, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueLike(String value) {
            addCriterion("vote_value like", value, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueNotLike(String value) {
            addCriterion("vote_value not like", value, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueIn(List<String> values) {
            addCriterion("vote_value in", values, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueNotIn(List<String> values) {
            addCriterion("vote_value not in", values, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueBetween(String value1, String value2) {
            addCriterion("vote_value between", value1, value2, "voteValue");
            return (Criteria) this;
        }

        public Criteria andVoteValueNotBetween(String value1, String value2) {
            addCriterion("vote_value not between", value1, value2, "voteValue");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("phone_number like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("phone_number not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andIsPushToTvIsNull() {
            addCriterion("is_push_to_tv is null");
            return (Criteria) this;
        }

        public Criteria andIsPushToTvIsNotNull() {
            addCriterion("is_push_to_tv is not null");
            return (Criteria) this;
        }

        public Criteria andIsPushToTvEqualTo(String value) {
            addCriterion("is_push_to_tv =", value, "isPushToTv");
            return (Criteria) this;
        }

        public Criteria andIsPushToTvNotEqualTo(String value) {
            addCriterion("is_push_to_tv <>", value, "isPushToTv");
            return (Criteria) this;
        }

        public Criteria andIsPushToTvGreaterThan(String value) {
            addCriterion("is_push_to_tv >", value, "isPushToTv");
            return (Criteria) this;
        }

        public Criteria andIsPushToTvGreaterThanOrEqualTo(String value) {
            addCriterion("is_push_to_tv >=", value, "isPushToTv");
            return (Criteria) this;
        }

        public Criteria andIsPushToTvLessThan(String value) {
            addCriterion("is_push_to_tv <", value, "isPushToTv");
            return (Criteria) this;
        }

        public Criteria andIsPushToTvLessThanOrEqualTo(String value) {
            addCriterion("is_push_to_tv <=", value, "isPushToTv");
            return (Criteria) this;
        }

        public Criteria andIsPushToTvLike(String value) {
            addCriterion("is_push_to_tv like", value, "isPushToTv");
            return (Criteria) this;
        }

        public Criteria andIsPushToTvNotLike(String value) {
            addCriterion("is_push_to_tv not like", value, "isPushToTv");
            return (Criteria) this;
        }

        public Criteria andIsPushToTvIn(List<String> values) {
            addCriterion("is_push_to_tv in", values, "isPushToTv");
            return (Criteria) this;
        }

        public Criteria andIsPushToTvNotIn(List<String> values) {
            addCriterion("is_push_to_tv not in", values, "isPushToTv");
            return (Criteria) this;
        }

        public Criteria andIsPushToTvBetween(String value1, String value2) {
            addCriterion("is_push_to_tv between", value1, value2, "isPushToTv");
            return (Criteria) this;
        }

        public Criteria andIsPushToTvNotBetween(String value1, String value2) {
            addCriterion("is_push_to_tv not between", value1, value2, "isPushToTv");
            return (Criteria) this;
        }

        public Criteria andIsPushTimeIsNull() {
            addCriterion("is_push_time is null");
            return (Criteria) this;
        }

        public Criteria andIsPushTimeIsNotNull() {
            addCriterion("is_push_time is not null");
            return (Criteria) this;
        }

        public Criteria andIsPushTimeEqualTo(Date value) {
            addCriterion("is_push_time =", value, "isPushTime");
            return (Criteria) this;
        }

        public Criteria andIsPushTimeNotEqualTo(Date value) {
            addCriterion("is_push_time <>", value, "isPushTime");
            return (Criteria) this;
        }

        public Criteria andIsPushTimeGreaterThan(Date value) {
            addCriterion("is_push_time >", value, "isPushTime");
            return (Criteria) this;
        }

        public Criteria andIsPushTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("is_push_time >=", value, "isPushTime");
            return (Criteria) this;
        }

        public Criteria andIsPushTimeLessThan(Date value) {
            addCriterion("is_push_time <", value, "isPushTime");
            return (Criteria) this;
        }

        public Criteria andIsPushTimeLessThanOrEqualTo(Date value) {
            addCriterion("is_push_time <=", value, "isPushTime");
            return (Criteria) this;
        }

        public Criteria andIsPushTimeIn(List<Date> values) {
            addCriterion("is_push_time in", values, "isPushTime");
            return (Criteria) this;
        }

        public Criteria andIsPushTimeNotIn(List<Date> values) {
            addCriterion("is_push_time not in", values, "isPushTime");
            return (Criteria) this;
        }

        public Criteria andIsPushTimeBetween(Date value1, Date value2) {
            addCriterion("is_push_time between", value1, value2, "isPushTime");
            return (Criteria) this;
        }

        public Criteria andIsPushTimeNotBetween(Date value1, Date value2) {
            addCriterion("is_push_time not between", value1, value2, "isPushTime");
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

        public Criteria andIsCorrectIsNull() {
            addCriterion("is_correct is null");
            return (Criteria) this;
        }

        public Criteria andIsCorrectIsNotNull() {
            addCriterion("is_correct is not null");
            return (Criteria) this;
        }

        public Criteria andIsCorrectEqualTo(String value) {
            addCriterion("is_correct =", value, "isCorrect");
            return (Criteria) this;
        }

        public Criteria andIsCorrectNotEqualTo(String value) {
            addCriterion("is_correct <>", value, "isCorrect");
            return (Criteria) this;
        }

        public Criteria andIsCorrectGreaterThan(String value) {
            addCriterion("is_correct >", value, "isCorrect");
            return (Criteria) this;
        }

        public Criteria andIsCorrectGreaterThanOrEqualTo(String value) {
            addCriterion("is_correct >=", value, "isCorrect");
            return (Criteria) this;
        }

        public Criteria andIsCorrectLessThan(String value) {
            addCriterion("is_correct <", value, "isCorrect");
            return (Criteria) this;
        }

        public Criteria andIsCorrectLessThanOrEqualTo(String value) {
            addCriterion("is_correct <=", value, "isCorrect");
            return (Criteria) this;
        }

        public Criteria andIsCorrectLike(String value) {
            addCriterion("is_correct like", value, "isCorrect");
            return (Criteria) this;
        }

        public Criteria andIsCorrectNotLike(String value) {
            addCriterion("is_correct not like", value, "isCorrect");
            return (Criteria) this;
        }

        public Criteria andIsCorrectIn(List<String> values) {
            addCriterion("is_correct in", values, "isCorrect");
            return (Criteria) this;
        }

        public Criteria andIsCorrectNotIn(List<String> values) {
            addCriterion("is_correct not in", values, "isCorrect");
            return (Criteria) this;
        }

        public Criteria andIsCorrectBetween(String value1, String value2) {
            addCriterion("is_correct between", value1, value2, "isCorrect");
            return (Criteria) this;
        }

        public Criteria andIsCorrectNotBetween(String value1, String value2) {
            addCriterion("is_correct not between", value1, value2, "isCorrect");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdIsNull() {
            addCriterion("pay_order_id is null");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdIsNotNull() {
            addCriterion("pay_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdEqualTo(String value) {
            addCriterion("pay_order_id =", value, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdNotEqualTo(String value) {
            addCriterion("pay_order_id <>", value, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdGreaterThan(String value) {
            addCriterion("pay_order_id >", value, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("pay_order_id >=", value, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdLessThan(String value) {
            addCriterion("pay_order_id <", value, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdLessThanOrEqualTo(String value) {
            addCriterion("pay_order_id <=", value, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdLike(String value) {
            addCriterion("pay_order_id like", value, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdNotLike(String value) {
            addCriterion("pay_order_id not like", value, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdIn(List<String> values) {
            addCriterion("pay_order_id in", values, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdNotIn(List<String> values) {
            addCriterion("pay_order_id not in", values, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdBetween(String value1, String value2) {
            addCriterion("pay_order_id between", value1, value2, "payOrderId");
            return (Criteria) this;
        }

        public Criteria andPayOrderIdNotBetween(String value1, String value2) {
            addCriterion("pay_order_id not between", value1, value2, "payOrderId");
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