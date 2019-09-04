package com.hndl.cn.dao.game.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameStarVoteDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public GameStarVoteDoExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIsNull() {
            addCriterion("head_url is null");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIsNotNull() {
            addCriterion("head_url is not null");
            return (Criteria) this;
        }

        public Criteria andHeadUrlEqualTo(String value) {
            addCriterion("head_url =", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotEqualTo(String value) {
            addCriterion("head_url <>", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlGreaterThan(String value) {
            addCriterion("head_url >", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("head_url >=", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLessThan(String value) {
            addCriterion("head_url <", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLessThanOrEqualTo(String value) {
            addCriterion("head_url <=", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLike(String value) {
            addCriterion("head_url like", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotLike(String value) {
            addCriterion("head_url not like", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIn(List<String> values) {
            addCriterion("head_url in", values, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotIn(List<String> values) {
            addCriterion("head_url not in", values, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlBetween(String value1, String value2) {
            addCriterion("head_url between", value1, value2, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotBetween(String value1, String value2) {
            addCriterion("head_url not between", value1, value2, "headUrl");
            return (Criteria) this;
        }

        public Criteria andVoteCountIsNull() {
            addCriterion("vote_count is null");
            return (Criteria) this;
        }

        public Criteria andVoteCountIsNotNull() {
            addCriterion("vote_count is not null");
            return (Criteria) this;
        }

        public Criteria andVoteCountEqualTo(Long value) {
            addCriterion("vote_count =", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountNotEqualTo(Long value) {
            addCriterion("vote_count <>", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountGreaterThan(Long value) {
            addCriterion("vote_count >", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountGreaterThanOrEqualTo(Long value) {
            addCriterion("vote_count >=", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountLessThan(Long value) {
            addCriterion("vote_count <", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountLessThanOrEqualTo(Long value) {
            addCriterion("vote_count <=", value, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountIn(List<Long> values) {
            addCriterion("vote_count in", values, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountNotIn(List<Long> values) {
            addCriterion("vote_count not in", values, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountBetween(Long value1, Long value2) {
            addCriterion("vote_count between", value1, value2, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVoteCountNotBetween(Long value1, Long value2) {
            addCriterion("vote_count not between", value1, value2, "voteCount");
            return (Criteria) this;
        }

        public Criteria andVotePersonCountIsNull() {
            addCriterion("vote_person_count is null");
            return (Criteria) this;
        }

        public Criteria andVotePersonCountIsNotNull() {
            addCriterion("vote_person_count is not null");
            return (Criteria) this;
        }

        public Criteria andVotePersonCountEqualTo(Long value) {
            addCriterion("vote_person_count =", value, "votePersonCount");
            return (Criteria) this;
        }

        public Criteria andVotePersonCountNotEqualTo(Long value) {
            addCriterion("vote_person_count <>", value, "votePersonCount");
            return (Criteria) this;
        }

        public Criteria andVotePersonCountGreaterThan(Long value) {
            addCriterion("vote_person_count >", value, "votePersonCount");
            return (Criteria) this;
        }

        public Criteria andVotePersonCountGreaterThanOrEqualTo(Long value) {
            addCriterion("vote_person_count >=", value, "votePersonCount");
            return (Criteria) this;
        }

        public Criteria andVotePersonCountLessThan(Long value) {
            addCriterion("vote_person_count <", value, "votePersonCount");
            return (Criteria) this;
        }

        public Criteria andVotePersonCountLessThanOrEqualTo(Long value) {
            addCriterion("vote_person_count <=", value, "votePersonCount");
            return (Criteria) this;
        }

        public Criteria andVotePersonCountIn(List<Long> values) {
            addCriterion("vote_person_count in", values, "votePersonCount");
            return (Criteria) this;
        }

        public Criteria andVotePersonCountNotIn(List<Long> values) {
            addCriterion("vote_person_count not in", values, "votePersonCount");
            return (Criteria) this;
        }

        public Criteria andVotePersonCountBetween(Long value1, Long value2) {
            addCriterion("vote_person_count between", value1, value2, "votePersonCount");
            return (Criteria) this;
        }

        public Criteria andVotePersonCountNotBetween(Long value1, Long value2) {
            addCriterion("vote_person_count not between", value1, value2, "votePersonCount");
            return (Criteria) this;
        }

        public Criteria andOther1IsNull() {
            addCriterion("other1 is null");
            return (Criteria) this;
        }

        public Criteria andOther1IsNotNull() {
            addCriterion("other1 is not null");
            return (Criteria) this;
        }

        public Criteria andOther1EqualTo(String value) {
            addCriterion("other1 =", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotEqualTo(String value) {
            addCriterion("other1 <>", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1GreaterThan(String value) {
            addCriterion("other1 >", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1GreaterThanOrEqualTo(String value) {
            addCriterion("other1 >=", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1LessThan(String value) {
            addCriterion("other1 <", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1LessThanOrEqualTo(String value) {
            addCriterion("other1 <=", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1Like(String value) {
            addCriterion("other1 like", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotLike(String value) {
            addCriterion("other1 not like", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1In(List<String> values) {
            addCriterion("other1 in", values, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotIn(List<String> values) {
            addCriterion("other1 not in", values, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1Between(String value1, String value2) {
            addCriterion("other1 between", value1, value2, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotBetween(String value1, String value2) {
            addCriterion("other1 not between", value1, value2, "other1");
            return (Criteria) this;
        }

        public Criteria andOther2IsNull() {
            addCriterion("other2 is null");
            return (Criteria) this;
        }

        public Criteria andOther2IsNotNull() {
            addCriterion("other2 is not null");
            return (Criteria) this;
        }

        public Criteria andOther2EqualTo(String value) {
            addCriterion("other2 =", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotEqualTo(String value) {
            addCriterion("other2 <>", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2GreaterThan(String value) {
            addCriterion("other2 >", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2GreaterThanOrEqualTo(String value) {
            addCriterion("other2 >=", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2LessThan(String value) {
            addCriterion("other2 <", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2LessThanOrEqualTo(String value) {
            addCriterion("other2 <=", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2Like(String value) {
            addCriterion("other2 like", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotLike(String value) {
            addCriterion("other2 not like", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2In(List<String> values) {
            addCriterion("other2 in", values, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotIn(List<String> values) {
            addCriterion("other2 not in", values, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2Between(String value1, String value2) {
            addCriterion("other2 between", value1, value2, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotBetween(String value1, String value2) {
            addCriterion("other2 not between", value1, value2, "other2");
            return (Criteria) this;
        }

        public Criteria andOther3IsNull() {
            addCriterion("other3 is null");
            return (Criteria) this;
        }

        public Criteria andOther3IsNotNull() {
            addCriterion("other3 is not null");
            return (Criteria) this;
        }

        public Criteria andOther3EqualTo(String value) {
            addCriterion("other3 =", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotEqualTo(String value) {
            addCriterion("other3 <>", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3GreaterThan(String value) {
            addCriterion("other3 >", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3GreaterThanOrEqualTo(String value) {
            addCriterion("other3 >=", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3LessThan(String value) {
            addCriterion("other3 <", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3LessThanOrEqualTo(String value) {
            addCriterion("other3 <=", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3Like(String value) {
            addCriterion("other3 like", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotLike(String value) {
            addCriterion("other3 not like", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3In(List<String> values) {
            addCriterion("other3 in", values, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotIn(List<String> values) {
            addCriterion("other3 not in", values, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3Between(String value1, String value2) {
            addCriterion("other3 between", value1, value2, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotBetween(String value1, String value2) {
            addCriterion("other3 not between", value1, value2, "other3");
            return (Criteria) this;
        }

        public Criteria andStartScoreIsNull() {
            addCriterion("start_score is null");
            return (Criteria) this;
        }

        public Criteria andStartScoreIsNotNull() {
            addCriterion("start_score is not null");
            return (Criteria) this;
        }

        public Criteria andStartScoreEqualTo(Double value) {
            addCriterion("start_score =", value, "startScore");
            return (Criteria) this;
        }

        public Criteria andStartScoreNotEqualTo(Double value) {
            addCriterion("start_score <>", value, "startScore");
            return (Criteria) this;
        }

        public Criteria andStartScoreGreaterThan(Double value) {
            addCriterion("start_score >", value, "startScore");
            return (Criteria) this;
        }

        public Criteria andStartScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("start_score >=", value, "startScore");
            return (Criteria) this;
        }

        public Criteria andStartScoreLessThan(Double value) {
            addCriterion("start_score <", value, "startScore");
            return (Criteria) this;
        }

        public Criteria andStartScoreLessThanOrEqualTo(Double value) {
            addCriterion("start_score <=", value, "startScore");
            return (Criteria) this;
        }

        public Criteria andStartScoreIn(List<Double> values) {
            addCriterion("start_score in", values, "startScore");
            return (Criteria) this;
        }

        public Criteria andStartScoreNotIn(List<Double> values) {
            addCriterion("start_score not in", values, "startScore");
            return (Criteria) this;
        }

        public Criteria andStartScoreBetween(Double value1, Double value2) {
            addCriterion("start_score between", value1, value2, "startScore");
            return (Criteria) this;
        }

        public Criteria andStartScoreNotBetween(Double value1, Double value2) {
            addCriterion("start_score not between", value1, value2, "startScore");
            return (Criteria) this;
        }

        public Criteria andWeekVoteCountIsNull() {
            addCriterion("week_vote_count is null");
            return (Criteria) this;
        }

        public Criteria andWeekVoteCountIsNotNull() {
            addCriterion("week_vote_count is not null");
            return (Criteria) this;
        }

        public Criteria andWeekVoteCountEqualTo(Double value) {
            addCriterion("week_vote_count =", value, "weekVoteCount");
            return (Criteria) this;
        }

        public Criteria andWeekVoteCountNotEqualTo(Double value) {
            addCriterion("week_vote_count <>", value, "weekVoteCount");
            return (Criteria) this;
        }

        public Criteria andWeekVoteCountGreaterThan(Double value) {
            addCriterion("week_vote_count >", value, "weekVoteCount");
            return (Criteria) this;
        }

        public Criteria andWeekVoteCountGreaterThanOrEqualTo(Double value) {
            addCriterion("week_vote_count >=", value, "weekVoteCount");
            return (Criteria) this;
        }

        public Criteria andWeekVoteCountLessThan(Double value) {
            addCriterion("week_vote_count <", value, "weekVoteCount");
            return (Criteria) this;
        }

        public Criteria andWeekVoteCountLessThanOrEqualTo(Double value) {
            addCriterion("week_vote_count <=", value, "weekVoteCount");
            return (Criteria) this;
        }

        public Criteria andWeekVoteCountIn(List<Double> values) {
            addCriterion("week_vote_count in", values, "weekVoteCount");
            return (Criteria) this;
        }

        public Criteria andWeekVoteCountNotIn(List<Double> values) {
            addCriterion("week_vote_count not in", values, "weekVoteCount");
            return (Criteria) this;
        }

        public Criteria andWeekVoteCountBetween(Double value1, Double value2) {
            addCriterion("week_vote_count between", value1, value2, "weekVoteCount");
            return (Criteria) this;
        }

        public Criteria andWeekVoteCountNotBetween(Double value1, Double value2) {
            addCriterion("week_vote_count not between", value1, value2, "weekVoteCount");
            return (Criteria) this;
        }

        public Criteria andWeekExpressCountIsNull() {
            addCriterion("week_express_count is null");
            return (Criteria) this;
        }

        public Criteria andWeekExpressCountIsNotNull() {
            addCriterion("week_express_count is not null");
            return (Criteria) this;
        }

        public Criteria andWeekExpressCountEqualTo(Double value) {
            addCriterion("week_express_count =", value, "weekExpressCount");
            return (Criteria) this;
        }

        public Criteria andWeekExpressCountNotEqualTo(Double value) {
            addCriterion("week_express_count <>", value, "weekExpressCount");
            return (Criteria) this;
        }

        public Criteria andWeekExpressCountGreaterThan(Double value) {
            addCriterion("week_express_count >", value, "weekExpressCount");
            return (Criteria) this;
        }

        public Criteria andWeekExpressCountGreaterThanOrEqualTo(Double value) {
            addCriterion("week_express_count >=", value, "weekExpressCount");
            return (Criteria) this;
        }

        public Criteria andWeekExpressCountLessThan(Double value) {
            addCriterion("week_express_count <", value, "weekExpressCount");
            return (Criteria) this;
        }

        public Criteria andWeekExpressCountLessThanOrEqualTo(Double value) {
            addCriterion("week_express_count <=", value, "weekExpressCount");
            return (Criteria) this;
        }

        public Criteria andWeekExpressCountIn(List<Double> values) {
            addCriterion("week_express_count in", values, "weekExpressCount");
            return (Criteria) this;
        }

        public Criteria andWeekExpressCountNotIn(List<Double> values) {
            addCriterion("week_express_count not in", values, "weekExpressCount");
            return (Criteria) this;
        }

        public Criteria andWeekExpressCountBetween(Double value1, Double value2) {
            addCriterion("week_express_count between", value1, value2, "weekExpressCount");
            return (Criteria) this;
        }

        public Criteria andWeekExpressCountNotBetween(Double value1, Double value2) {
            addCriterion("week_express_count not between", value1, value2, "weekExpressCount");
            return (Criteria) this;
        }

        public Criteria andWeekGiveCountIsNull() {
            addCriterion("week_give_count is null");
            return (Criteria) this;
        }

        public Criteria andWeekGiveCountIsNotNull() {
            addCriterion("week_give_count is not null");
            return (Criteria) this;
        }

        public Criteria andWeekGiveCountEqualTo(Double value) {
            addCriterion("week_give_count =", value, "weekGiveCount");
            return (Criteria) this;
        }

        public Criteria andWeekGiveCountNotEqualTo(Double value) {
            addCriterion("week_give_count <>", value, "weekGiveCount");
            return (Criteria) this;
        }

        public Criteria andWeekGiveCountGreaterThan(Double value) {
            addCriterion("week_give_count >", value, "weekGiveCount");
            return (Criteria) this;
        }

        public Criteria andWeekGiveCountGreaterThanOrEqualTo(Double value) {
            addCriterion("week_give_count >=", value, "weekGiveCount");
            return (Criteria) this;
        }

        public Criteria andWeekGiveCountLessThan(Double value) {
            addCriterion("week_give_count <", value, "weekGiveCount");
            return (Criteria) this;
        }

        public Criteria andWeekGiveCountLessThanOrEqualTo(Double value) {
            addCriterion("week_give_count <=", value, "weekGiveCount");
            return (Criteria) this;
        }

        public Criteria andWeekGiveCountIn(List<Double> values) {
            addCriterion("week_give_count in", values, "weekGiveCount");
            return (Criteria) this;
        }

        public Criteria andWeekGiveCountNotIn(List<Double> values) {
            addCriterion("week_give_count not in", values, "weekGiveCount");
            return (Criteria) this;
        }

        public Criteria andWeekGiveCountBetween(Double value1, Double value2) {
            addCriterion("week_give_count between", value1, value2, "weekGiveCount");
            return (Criteria) this;
        }

        public Criteria andWeekGiveCountNotBetween(Double value1, Double value2) {
            addCriterion("week_give_count not between", value1, value2, "weekGiveCount");
            return (Criteria) this;
        }

        public Criteria andWeekGuardCountIsNull() {
            addCriterion("week_guard_count is null");
            return (Criteria) this;
        }

        public Criteria andWeekGuardCountIsNotNull() {
            addCriterion("week_guard_count is not null");
            return (Criteria) this;
        }

        public Criteria andWeekGuardCountEqualTo(Double value) {
            addCriterion("week_guard_count =", value, "weekGuardCount");
            return (Criteria) this;
        }

        public Criteria andWeekGuardCountNotEqualTo(Double value) {
            addCriterion("week_guard_count <>", value, "weekGuardCount");
            return (Criteria) this;
        }

        public Criteria andWeekGuardCountGreaterThan(Double value) {
            addCriterion("week_guard_count >", value, "weekGuardCount");
            return (Criteria) this;
        }

        public Criteria andWeekGuardCountGreaterThanOrEqualTo(Double value) {
            addCriterion("week_guard_count >=", value, "weekGuardCount");
            return (Criteria) this;
        }

        public Criteria andWeekGuardCountLessThan(Double value) {
            addCriterion("week_guard_count <", value, "weekGuardCount");
            return (Criteria) this;
        }

        public Criteria andWeekGuardCountLessThanOrEqualTo(Double value) {
            addCriterion("week_guard_count <=", value, "weekGuardCount");
            return (Criteria) this;
        }

        public Criteria andWeekGuardCountIn(List<Double> values) {
            addCriterion("week_guard_count in", values, "weekGuardCount");
            return (Criteria) this;
        }

        public Criteria andWeekGuardCountNotIn(List<Double> values) {
            addCriterion("week_guard_count not in", values, "weekGuardCount");
            return (Criteria) this;
        }

        public Criteria andWeekGuardCountBetween(Double value1, Double value2) {
            addCriterion("week_guard_count between", value1, value2, "weekGuardCount");
            return (Criteria) this;
        }

        public Criteria andWeekGuardCountNotBetween(Double value1, Double value2) {
            addCriterion("week_guard_count not between", value1, value2, "weekGuardCount");
            return (Criteria) this;
        }

        public Criteria andWeekShareScoreIsNull() {
            addCriterion("week_share_score is null");
            return (Criteria) this;
        }

        public Criteria andWeekShareScoreIsNotNull() {
            addCriterion("week_share_score is not null");
            return (Criteria) this;
        }

        public Criteria andWeekShareScoreEqualTo(Double value) {
            addCriterion("week_share_score =", value, "weekShareScore");
            return (Criteria) this;
        }

        public Criteria andWeekShareScoreNotEqualTo(Double value) {
            addCriterion("week_share_score <>", value, "weekShareScore");
            return (Criteria) this;
        }

        public Criteria andWeekShareScoreGreaterThan(Double value) {
            addCriterion("week_share_score >", value, "weekShareScore");
            return (Criteria) this;
        }

        public Criteria andWeekShareScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("week_share_score >=", value, "weekShareScore");
            return (Criteria) this;
        }

        public Criteria andWeekShareScoreLessThan(Double value) {
            addCriterion("week_share_score <", value, "weekShareScore");
            return (Criteria) this;
        }

        public Criteria andWeekShareScoreLessThanOrEqualTo(Double value) {
            addCriterion("week_share_score <=", value, "weekShareScore");
            return (Criteria) this;
        }

        public Criteria andWeekShareScoreIn(List<Double> values) {
            addCriterion("week_share_score in", values, "weekShareScore");
            return (Criteria) this;
        }

        public Criteria andWeekShareScoreNotIn(List<Double> values) {
            addCriterion("week_share_score not in", values, "weekShareScore");
            return (Criteria) this;
        }

        public Criteria andWeekShareScoreBetween(Double value1, Double value2) {
            addCriterion("week_share_score between", value1, value2, "weekShareScore");
            return (Criteria) this;
        }

        public Criteria andWeekShareScoreNotBetween(Double value1, Double value2) {
            addCriterion("week_share_score not between", value1, value2, "weekShareScore");
            return (Criteria) this;
        }

        public Criteria andWeekWelfareScoreIsNull() {
            addCriterion("week_welfare_score is null");
            return (Criteria) this;
        }

        public Criteria andWeekWelfareScoreIsNotNull() {
            addCriterion("week_welfare_score is not null");
            return (Criteria) this;
        }

        public Criteria andWeekWelfareScoreEqualTo(Double value) {
            addCriterion("week_welfare_score =", value, "weekWelfareScore");
            return (Criteria) this;
        }

        public Criteria andWeekWelfareScoreNotEqualTo(Double value) {
            addCriterion("week_welfare_score <>", value, "weekWelfareScore");
            return (Criteria) this;
        }

        public Criteria andWeekWelfareScoreGreaterThan(Double value) {
            addCriterion("week_welfare_score >", value, "weekWelfareScore");
            return (Criteria) this;
        }

        public Criteria andWeekWelfareScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("week_welfare_score >=", value, "weekWelfareScore");
            return (Criteria) this;
        }

        public Criteria andWeekWelfareScoreLessThan(Double value) {
            addCriterion("week_welfare_score <", value, "weekWelfareScore");
            return (Criteria) this;
        }

        public Criteria andWeekWelfareScoreLessThanOrEqualTo(Double value) {
            addCriterion("week_welfare_score <=", value, "weekWelfareScore");
            return (Criteria) this;
        }

        public Criteria andWeekWelfareScoreIn(List<Double> values) {
            addCriterion("week_welfare_score in", values, "weekWelfareScore");
            return (Criteria) this;
        }

        public Criteria andWeekWelfareScoreNotIn(List<Double> values) {
            addCriterion("week_welfare_score not in", values, "weekWelfareScore");
            return (Criteria) this;
        }

        public Criteria andWeekWelfareScoreBetween(Double value1, Double value2) {
            addCriterion("week_welfare_score between", value1, value2, "weekWelfareScore");
            return (Criteria) this;
        }

        public Criteria andWeekWelfareScoreNotBetween(Double value1, Double value2) {
            addCriterion("week_welfare_score not between", value1, value2, "weekWelfareScore");
            return (Criteria) this;
        }

        public Criteria andPresidentUserIdIsNull() {
            addCriterion("president_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPresidentUserIdIsNotNull() {
            addCriterion("president_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPresidentUserIdEqualTo(Long value) {
            addCriterion("president_user_id =", value, "presidentUserId");
            return (Criteria) this;
        }

        public Criteria andPresidentUserIdNotEqualTo(Long value) {
            addCriterion("president_user_id <>", value, "presidentUserId");
            return (Criteria) this;
        }

        public Criteria andPresidentUserIdGreaterThan(Long value) {
            addCriterion("president_user_id >", value, "presidentUserId");
            return (Criteria) this;
        }

        public Criteria andPresidentUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("president_user_id >=", value, "presidentUserId");
            return (Criteria) this;
        }

        public Criteria andPresidentUserIdLessThan(Long value) {
            addCriterion("president_user_id <", value, "presidentUserId");
            return (Criteria) this;
        }

        public Criteria andPresidentUserIdLessThanOrEqualTo(Long value) {
            addCriterion("president_user_id <=", value, "presidentUserId");
            return (Criteria) this;
        }

        public Criteria andPresidentUserIdIn(List<Long> values) {
            addCriterion("president_user_id in", values, "presidentUserId");
            return (Criteria) this;
        }

        public Criteria andPresidentUserIdNotIn(List<Long> values) {
            addCriterion("president_user_id not in", values, "presidentUserId");
            return (Criteria) this;
        }

        public Criteria andPresidentUserIdBetween(Long value1, Long value2) {
            addCriterion("president_user_id between", value1, value2, "presidentUserId");
            return (Criteria) this;
        }

        public Criteria andPresidentUserIdNotBetween(Long value1, Long value2) {
            addCriterion("president_user_id not between", value1, value2, "presidentUserId");
            return (Criteria) this;
        }

        public Criteria andAllCountIsNull() {
            addCriterion("all_count is null");
            return (Criteria) this;
        }

        public Criteria andAllCountIsNotNull() {
            addCriterion("all_count is not null");
            return (Criteria) this;
        }

        public Criteria andAllCountEqualTo(Double value) {
            addCriterion("all_count =", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotEqualTo(Double value) {
            addCriterion("all_count <>", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountGreaterThan(Double value) {
            addCriterion("all_count >", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountGreaterThanOrEqualTo(Double value) {
            addCriterion("all_count >=", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountLessThan(Double value) {
            addCriterion("all_count <", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountLessThanOrEqualTo(Double value) {
            addCriterion("all_count <=", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountIn(List<Double> values) {
            addCriterion("all_count in", values, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotIn(List<Double> values) {
            addCriterion("all_count not in", values, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountBetween(Double value1, Double value2) {
            addCriterion("all_count between", value1, value2, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotBetween(Double value1, Double value2) {
            addCriterion("all_count not between", value1, value2, "allCount");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBak2IsNull() {
            addCriterion("bak2 is null");
            return (Criteria) this;
        }

        public Criteria andBak2IsNotNull() {
            addCriterion("bak2 is not null");
            return (Criteria) this;
        }

        public Criteria andBak2EqualTo(String value) {
            addCriterion("bak2 =", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotEqualTo(String value) {
            addCriterion("bak2 <>", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2GreaterThan(String value) {
            addCriterion("bak2 >", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2GreaterThanOrEqualTo(String value) {
            addCriterion("bak2 >=", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2LessThan(String value) {
            addCriterion("bak2 <", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2LessThanOrEqualTo(String value) {
            addCriterion("bak2 <=", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2Like(String value) {
            addCriterion("bak2 like", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotLike(String value) {
            addCriterion("bak2 not like", value, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2In(List<String> values) {
            addCriterion("bak2 in", values, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotIn(List<String> values) {
            addCriterion("bak2 not in", values, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2Between(String value1, String value2) {
            addCriterion("bak2 between", value1, value2, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak2NotBetween(String value1, String value2) {
            addCriterion("bak2 not between", value1, value2, "bak2");
            return (Criteria) this;
        }

        public Criteria andBak3IsNull() {
            addCriterion("bak3 is null");
            return (Criteria) this;
        }

        public Criteria andBak3IsNotNull() {
            addCriterion("bak3 is not null");
            return (Criteria) this;
        }

        public Criteria andBak3EqualTo(String value) {
            addCriterion("bak3 =", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotEqualTo(String value) {
            addCriterion("bak3 <>", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3GreaterThan(String value) {
            addCriterion("bak3 >", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3GreaterThanOrEqualTo(String value) {
            addCriterion("bak3 >=", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3LessThan(String value) {
            addCriterion("bak3 <", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3LessThanOrEqualTo(String value) {
            addCriterion("bak3 <=", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3Like(String value) {
            addCriterion("bak3 like", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotLike(String value) {
            addCriterion("bak3 not like", value, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3In(List<String> values) {
            addCriterion("bak3 in", values, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotIn(List<String> values) {
            addCriterion("bak3 not in", values, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3Between(String value1, String value2) {
            addCriterion("bak3 between", value1, value2, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak3NotBetween(String value1, String value2) {
            addCriterion("bak3 not between", value1, value2, "bak3");
            return (Criteria) this;
        }

        public Criteria andBak4IsNull() {
            addCriterion("bak4 is null");
            return (Criteria) this;
        }

        public Criteria andBak4IsNotNull() {
            addCriterion("bak4 is not null");
            return (Criteria) this;
        }

        public Criteria andBak4EqualTo(String value) {
            addCriterion("bak4 =", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4NotEqualTo(String value) {
            addCriterion("bak4 <>", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4GreaterThan(String value) {
            addCriterion("bak4 >", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4GreaterThanOrEqualTo(String value) {
            addCriterion("bak4 >=", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4LessThan(String value) {
            addCriterion("bak4 <", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4LessThanOrEqualTo(String value) {
            addCriterion("bak4 <=", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4Like(String value) {
            addCriterion("bak4 like", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4NotLike(String value) {
            addCriterion("bak4 not like", value, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4In(List<String> values) {
            addCriterion("bak4 in", values, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4NotIn(List<String> values) {
            addCriterion("bak4 not in", values, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4Between(String value1, String value2) {
            addCriterion("bak4 between", value1, value2, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak4NotBetween(String value1, String value2) {
            addCriterion("bak4 not between", value1, value2, "bak4");
            return (Criteria) this;
        }

        public Criteria andBak5IsNull() {
            addCriterion("bak5 is null");
            return (Criteria) this;
        }

        public Criteria andBak5IsNotNull() {
            addCriterion("bak5 is not null");
            return (Criteria) this;
        }

        public Criteria andBak5EqualTo(Integer value) {
            addCriterion("bak5 =", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotEqualTo(Integer value) {
            addCriterion("bak5 <>", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5GreaterThan(Integer value) {
            addCriterion("bak5 >", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5GreaterThanOrEqualTo(Integer value) {
            addCriterion("bak5 >=", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5LessThan(Integer value) {
            addCriterion("bak5 <", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5LessThanOrEqualTo(Integer value) {
            addCriterion("bak5 <=", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5In(List<Integer> values) {
            addCriterion("bak5 in", values, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotIn(List<Integer> values) {
            addCriterion("bak5 not in", values, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5Between(Integer value1, Integer value2) {
            addCriterion("bak5 between", value1, value2, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotBetween(Integer value1, Integer value2) {
            addCriterion("bak5 not between", value1, value2, "bak5");
            return (Criteria) this;
        }

        public Criteria andMaxUserIdIsNull() {
            addCriterion("max_user_id is null");
            return (Criteria) this;
        }

        public Criteria andMaxUserIdIsNotNull() {
            addCriterion("max_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaxUserIdEqualTo(Long value) {
            addCriterion("max_user_id =", value, "maxUserId");
            return (Criteria) this;
        }

        public Criteria andMaxUserIdNotEqualTo(Long value) {
            addCriterion("max_user_id <>", value, "maxUserId");
            return (Criteria) this;
        }

        public Criteria andMaxUserIdGreaterThan(Long value) {
            addCriterion("max_user_id >", value, "maxUserId");
            return (Criteria) this;
        }

        public Criteria andMaxUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("max_user_id >=", value, "maxUserId");
            return (Criteria) this;
        }

        public Criteria andMaxUserIdLessThan(Long value) {
            addCriterion("max_user_id <", value, "maxUserId");
            return (Criteria) this;
        }

        public Criteria andMaxUserIdLessThanOrEqualTo(Long value) {
            addCriterion("max_user_id <=", value, "maxUserId");
            return (Criteria) this;
        }

        public Criteria andMaxUserIdIn(List<Long> values) {
            addCriterion("max_user_id in", values, "maxUserId");
            return (Criteria) this;
        }

        public Criteria andMaxUserIdNotIn(List<Long> values) {
            addCriterion("max_user_id not in", values, "maxUserId");
            return (Criteria) this;
        }

        public Criteria andMaxUserIdBetween(Long value1, Long value2) {
            addCriterion("max_user_id between", value1, value2, "maxUserId");
            return (Criteria) this;
        }

        public Criteria andMaxUserIdNotBetween(Long value1, Long value2) {
            addCriterion("max_user_id not between", value1, value2, "maxUserId");
            return (Criteria) this;
        }

        public Criteria andMaxUserNameIsNull() {
            addCriterion("max_user_name is null");
            return (Criteria) this;
        }

        public Criteria andMaxUserNameIsNotNull() {
            addCriterion("max_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaxUserNameEqualTo(String value) {
            addCriterion("max_user_name =", value, "maxUserName");
            return (Criteria) this;
        }

        public Criteria andMaxUserNameNotEqualTo(String value) {
            addCriterion("max_user_name <>", value, "maxUserName");
            return (Criteria) this;
        }

        public Criteria andMaxUserNameGreaterThan(String value) {
            addCriterion("max_user_name >", value, "maxUserName");
            return (Criteria) this;
        }

        public Criteria andMaxUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("max_user_name >=", value, "maxUserName");
            return (Criteria) this;
        }

        public Criteria andMaxUserNameLessThan(String value) {
            addCriterion("max_user_name <", value, "maxUserName");
            return (Criteria) this;
        }

        public Criteria andMaxUserNameLessThanOrEqualTo(String value) {
            addCriterion("max_user_name <=", value, "maxUserName");
            return (Criteria) this;
        }

        public Criteria andMaxUserNameLike(String value) {
            addCriterion("max_user_name like", value, "maxUserName");
            return (Criteria) this;
        }

        public Criteria andMaxUserNameNotLike(String value) {
            addCriterion("max_user_name not like", value, "maxUserName");
            return (Criteria) this;
        }

        public Criteria andMaxUserNameIn(List<String> values) {
            addCriterion("max_user_name in", values, "maxUserName");
            return (Criteria) this;
        }

        public Criteria andMaxUserNameNotIn(List<String> values) {
            addCriterion("max_user_name not in", values, "maxUserName");
            return (Criteria) this;
        }

        public Criteria andMaxUserNameBetween(String value1, String value2) {
            addCriterion("max_user_name between", value1, value2, "maxUserName");
            return (Criteria) this;
        }

        public Criteria andMaxUserNameNotBetween(String value1, String value2) {
            addCriterion("max_user_name not between", value1, value2, "maxUserName");
            return (Criteria) this;
        }

        public Criteria andMaxUserImgIsNull() {
            addCriterion("max_user_img is null");
            return (Criteria) this;
        }

        public Criteria andMaxUserImgIsNotNull() {
            addCriterion("max_user_img is not null");
            return (Criteria) this;
        }

        public Criteria andMaxUserImgEqualTo(String value) {
            addCriterion("max_user_img =", value, "maxUserImg");
            return (Criteria) this;
        }

        public Criteria andMaxUserImgNotEqualTo(String value) {
            addCriterion("max_user_img <>", value, "maxUserImg");
            return (Criteria) this;
        }

        public Criteria andMaxUserImgGreaterThan(String value) {
            addCriterion("max_user_img >", value, "maxUserImg");
            return (Criteria) this;
        }

        public Criteria andMaxUserImgGreaterThanOrEqualTo(String value) {
            addCriterion("max_user_img >=", value, "maxUserImg");
            return (Criteria) this;
        }

        public Criteria andMaxUserImgLessThan(String value) {
            addCriterion("max_user_img <", value, "maxUserImg");
            return (Criteria) this;
        }

        public Criteria andMaxUserImgLessThanOrEqualTo(String value) {
            addCriterion("max_user_img <=", value, "maxUserImg");
            return (Criteria) this;
        }

        public Criteria andMaxUserImgLike(String value) {
            addCriterion("max_user_img like", value, "maxUserImg");
            return (Criteria) this;
        }

        public Criteria andMaxUserImgNotLike(String value) {
            addCriterion("max_user_img not like", value, "maxUserImg");
            return (Criteria) this;
        }

        public Criteria andMaxUserImgIn(List<String> values) {
            addCriterion("max_user_img in", values, "maxUserImg");
            return (Criteria) this;
        }

        public Criteria andMaxUserImgNotIn(List<String> values) {
            addCriterion("max_user_img not in", values, "maxUserImg");
            return (Criteria) this;
        }

        public Criteria andMaxUserImgBetween(String value1, String value2) {
            addCriterion("max_user_img between", value1, value2, "maxUserImg");
            return (Criteria) this;
        }

        public Criteria andMaxUserImgNotBetween(String value1, String value2) {
            addCriterion("max_user_img not between", value1, value2, "maxUserImg");
            return (Criteria) this;
        }

        public Criteria andMaxUserVoteCountIsNull() {
            addCriterion("max_user_vote_count is null");
            return (Criteria) this;
        }

        public Criteria andMaxUserVoteCountIsNotNull() {
            addCriterion("max_user_vote_count is not null");
            return (Criteria) this;
        }

        public Criteria andMaxUserVoteCountEqualTo(Integer value) {
            addCriterion("max_user_vote_count =", value, "maxUserVoteCount");
            return (Criteria) this;
        }

        public Criteria andMaxUserVoteCountNotEqualTo(Integer value) {
            addCriterion("max_user_vote_count <>", value, "maxUserVoteCount");
            return (Criteria) this;
        }

        public Criteria andMaxUserVoteCountGreaterThan(Integer value) {
            addCriterion("max_user_vote_count >", value, "maxUserVoteCount");
            return (Criteria) this;
        }

        public Criteria andMaxUserVoteCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_user_vote_count >=", value, "maxUserVoteCount");
            return (Criteria) this;
        }

        public Criteria andMaxUserVoteCountLessThan(Integer value) {
            addCriterion("max_user_vote_count <", value, "maxUserVoteCount");
            return (Criteria) this;
        }

        public Criteria andMaxUserVoteCountLessThanOrEqualTo(Integer value) {
            addCriterion("max_user_vote_count <=", value, "maxUserVoteCount");
            return (Criteria) this;
        }

        public Criteria andMaxUserVoteCountIn(List<Integer> values) {
            addCriterion("max_user_vote_count in", values, "maxUserVoteCount");
            return (Criteria) this;
        }

        public Criteria andMaxUserVoteCountNotIn(List<Integer> values) {
            addCriterion("max_user_vote_count not in", values, "maxUserVoteCount");
            return (Criteria) this;
        }

        public Criteria andMaxUserVoteCountBetween(Integer value1, Integer value2) {
            addCriterion("max_user_vote_count between", value1, value2, "maxUserVoteCount");
            return (Criteria) this;
        }

        public Criteria andMaxUserVoteCountNotBetween(Integer value1, Integer value2) {
            addCriterion("max_user_vote_count not between", value1, value2, "maxUserVoteCount");
            return (Criteria) this;
        }

        public Criteria andMaxUserLevelIsNull() {
            addCriterion("max_user_level is null");
            return (Criteria) this;
        }

        public Criteria andMaxUserLevelIsNotNull() {
            addCriterion("max_user_level is not null");
            return (Criteria) this;
        }

        public Criteria andMaxUserLevelEqualTo(Integer value) {
            addCriterion("max_user_level =", value, "maxUserLevel");
            return (Criteria) this;
        }

        public Criteria andMaxUserLevelNotEqualTo(Integer value) {
            addCriterion("max_user_level <>", value, "maxUserLevel");
            return (Criteria) this;
        }

        public Criteria andMaxUserLevelGreaterThan(Integer value) {
            addCriterion("max_user_level >", value, "maxUserLevel");
            return (Criteria) this;
        }

        public Criteria andMaxUserLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_user_level >=", value, "maxUserLevel");
            return (Criteria) this;
        }

        public Criteria andMaxUserLevelLessThan(Integer value) {
            addCriterion("max_user_level <", value, "maxUserLevel");
            return (Criteria) this;
        }

        public Criteria andMaxUserLevelLessThanOrEqualTo(Integer value) {
            addCriterion("max_user_level <=", value, "maxUserLevel");
            return (Criteria) this;
        }

        public Criteria andMaxUserLevelIn(List<Integer> values) {
            addCriterion("max_user_level in", values, "maxUserLevel");
            return (Criteria) this;
        }

        public Criteria andMaxUserLevelNotIn(List<Integer> values) {
            addCriterion("max_user_level not in", values, "maxUserLevel");
            return (Criteria) this;
        }

        public Criteria andMaxUserLevelBetween(Integer value1, Integer value2) {
            addCriterion("max_user_level between", value1, value2, "maxUserLevel");
            return (Criteria) this;
        }

        public Criteria andMaxUserLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("max_user_level not between", value1, value2, "maxUserLevel");
            return (Criteria) this;
        }

        public Criteria andNewCallIsNull() {
            addCriterion("new_call is null");
            return (Criteria) this;
        }

        public Criteria andNewCallIsNotNull() {
            addCriterion("new_call is not null");
            return (Criteria) this;
        }

        public Criteria andNewCallEqualTo(String value) {
            addCriterion("new_call =", value, "newCall");
            return (Criteria) this;
        }

        public Criteria andNewCallNotEqualTo(String value) {
            addCriterion("new_call <>", value, "newCall");
            return (Criteria) this;
        }

        public Criteria andNewCallGreaterThan(String value) {
            addCriterion("new_call >", value, "newCall");
            return (Criteria) this;
        }

        public Criteria andNewCallGreaterThanOrEqualTo(String value) {
            addCriterion("new_call >=", value, "newCall");
            return (Criteria) this;
        }

        public Criteria andNewCallLessThan(String value) {
            addCriterion("new_call <", value, "newCall");
            return (Criteria) this;
        }

        public Criteria andNewCallLessThanOrEqualTo(String value) {
            addCriterion("new_call <=", value, "newCall");
            return (Criteria) this;
        }

        public Criteria andNewCallLike(String value) {
            addCriterion("new_call like", value, "newCall");
            return (Criteria) this;
        }

        public Criteria andNewCallNotLike(String value) {
            addCriterion("new_call not like", value, "newCall");
            return (Criteria) this;
        }

        public Criteria andNewCallIn(List<String> values) {
            addCriterion("new_call in", values, "newCall");
            return (Criteria) this;
        }

        public Criteria andNewCallNotIn(List<String> values) {
            addCriterion("new_call not in", values, "newCall");
            return (Criteria) this;
        }

        public Criteria andNewCallBetween(String value1, String value2) {
            addCriterion("new_call between", value1, value2, "newCall");
            return (Criteria) this;
        }

        public Criteria andNewCallNotBetween(String value1, String value2) {
            addCriterion("new_call not between", value1, value2, "newCall");
            return (Criteria) this;
        }

        public Criteria andNewCallTimeIsNull() {
            addCriterion("new_call_time is null");
            return (Criteria) this;
        }

        public Criteria andNewCallTimeIsNotNull() {
            addCriterion("new_call_time is not null");
            return (Criteria) this;
        }

        public Criteria andNewCallTimeEqualTo(Date value) {
            addCriterion("new_call_time =", value, "newCallTime");
            return (Criteria) this;
        }

        public Criteria andNewCallTimeNotEqualTo(Date value) {
            addCriterion("new_call_time <>", value, "newCallTime");
            return (Criteria) this;
        }

        public Criteria andNewCallTimeGreaterThan(Date value) {
            addCriterion("new_call_time >", value, "newCallTime");
            return (Criteria) this;
        }

        public Criteria andNewCallTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("new_call_time >=", value, "newCallTime");
            return (Criteria) this;
        }

        public Criteria andNewCallTimeLessThan(Date value) {
            addCriterion("new_call_time <", value, "newCallTime");
            return (Criteria) this;
        }

        public Criteria andNewCallTimeLessThanOrEqualTo(Date value) {
            addCriterion("new_call_time <=", value, "newCallTime");
            return (Criteria) this;
        }

        public Criteria andNewCallTimeIn(List<Date> values) {
            addCriterion("new_call_time in", values, "newCallTime");
            return (Criteria) this;
        }

        public Criteria andNewCallTimeNotIn(List<Date> values) {
            addCriterion("new_call_time not in", values, "newCallTime");
            return (Criteria) this;
        }

        public Criteria andNewCallTimeBetween(Date value1, Date value2) {
            addCriterion("new_call_time between", value1, value2, "newCallTime");
            return (Criteria) this;
        }

        public Criteria andNewCallTimeNotBetween(Date value1, Date value2) {
            addCriterion("new_call_time not between", value1, value2, "newCallTime");
            return (Criteria) this;
        }

        public Criteria andNewCallIdIsNull() {
            addCriterion("new_call_id is null");
            return (Criteria) this;
        }

        public Criteria andNewCallIdIsNotNull() {
            addCriterion("new_call_id is not null");
            return (Criteria) this;
        }

        public Criteria andNewCallIdEqualTo(Long value) {
            addCriterion("new_call_id =", value, "newCallId");
            return (Criteria) this;
        }

        public Criteria andNewCallIdNotEqualTo(Long value) {
            addCriterion("new_call_id <>", value, "newCallId");
            return (Criteria) this;
        }

        public Criteria andNewCallIdGreaterThan(Long value) {
            addCriterion("new_call_id >", value, "newCallId");
            return (Criteria) this;
        }

        public Criteria andNewCallIdGreaterThanOrEqualTo(Long value) {
            addCriterion("new_call_id >=", value, "newCallId");
            return (Criteria) this;
        }

        public Criteria andNewCallIdLessThan(Long value) {
            addCriterion("new_call_id <", value, "newCallId");
            return (Criteria) this;
        }

        public Criteria andNewCallIdLessThanOrEqualTo(Long value) {
            addCriterion("new_call_id <=", value, "newCallId");
            return (Criteria) this;
        }

        public Criteria andNewCallIdIn(List<Long> values) {
            addCriterion("new_call_id in", values, "newCallId");
            return (Criteria) this;
        }

        public Criteria andNewCallIdNotIn(List<Long> values) {
            addCriterion("new_call_id not in", values, "newCallId");
            return (Criteria) this;
        }

        public Criteria andNewCallIdBetween(Long value1, Long value2) {
            addCriterion("new_call_id between", value1, value2, "newCallId");
            return (Criteria) this;
        }

        public Criteria andNewCallIdNotBetween(Long value1, Long value2) {
            addCriterion("new_call_id not between", value1, value2, "newCallId");
            return (Criteria) this;
        }

        public Criteria andFanIdIsNull() {
            addCriterion("fan_id is null");
            return (Criteria) this;
        }

        public Criteria andFanIdIsNotNull() {
            addCriterion("fan_id is not null");
            return (Criteria) this;
        }

        public Criteria andFanIdEqualTo(Long value) {
            addCriterion("fan_id =", value, "fanId");
            return (Criteria) this;
        }

        public Criteria andFanIdNotEqualTo(Long value) {
            addCriterion("fan_id <>", value, "fanId");
            return (Criteria) this;
        }

        public Criteria andFanIdGreaterThan(Long value) {
            addCriterion("fan_id >", value, "fanId");
            return (Criteria) this;
        }

        public Criteria andFanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fan_id >=", value, "fanId");
            return (Criteria) this;
        }

        public Criteria andFanIdLessThan(Long value) {
            addCriterion("fan_id <", value, "fanId");
            return (Criteria) this;
        }

        public Criteria andFanIdLessThanOrEqualTo(Long value) {
            addCriterion("fan_id <=", value, "fanId");
            return (Criteria) this;
        }

        public Criteria andFanIdIn(List<Long> values) {
            addCriterion("fan_id in", values, "fanId");
            return (Criteria) this;
        }

        public Criteria andFanIdNotIn(List<Long> values) {
            addCriterion("fan_id not in", values, "fanId");
            return (Criteria) this;
        }

        public Criteria andFanIdBetween(Long value1, Long value2) {
            addCriterion("fan_id between", value1, value2, "fanId");
            return (Criteria) this;
        }

        public Criteria andFanIdNotBetween(Long value1, Long value2) {
            addCriterion("fan_id not between", value1, value2, "fanId");
            return (Criteria) this;
        }

        public Criteria andGuardCountIsNull() {
            addCriterion("guard_count is null");
            return (Criteria) this;
        }

        public Criteria andGuardCountIsNotNull() {
            addCriterion("guard_count is not null");
            return (Criteria) this;
        }

        public Criteria andGuardCountEqualTo(Long value) {
            addCriterion("guard_count =", value, "guardCount");
            return (Criteria) this;
        }

        public Criteria andGuardCountNotEqualTo(Long value) {
            addCriterion("guard_count <>", value, "guardCount");
            return (Criteria) this;
        }

        public Criteria andGuardCountGreaterThan(Long value) {
            addCriterion("guard_count >", value, "guardCount");
            return (Criteria) this;
        }

        public Criteria andGuardCountGreaterThanOrEqualTo(Long value) {
            addCriterion("guard_count >=", value, "guardCount");
            return (Criteria) this;
        }

        public Criteria andGuardCountLessThan(Long value) {
            addCriterion("guard_count <", value, "guardCount");
            return (Criteria) this;
        }

        public Criteria andGuardCountLessThanOrEqualTo(Long value) {
            addCriterion("guard_count <=", value, "guardCount");
            return (Criteria) this;
        }

        public Criteria andGuardCountIn(List<Long> values) {
            addCriterion("guard_count in", values, "guardCount");
            return (Criteria) this;
        }

        public Criteria andGuardCountNotIn(List<Long> values) {
            addCriterion("guard_count not in", values, "guardCount");
            return (Criteria) this;
        }

        public Criteria andGuardCountBetween(Long value1, Long value2) {
            addCriterion("guard_count between", value1, value2, "guardCount");
            return (Criteria) this;
        }

        public Criteria andGuardCountNotBetween(Long value1, Long value2) {
            addCriterion("guard_count not between", value1, value2, "guardCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountIsNull() {
            addCriterion("good_count is null");
            return (Criteria) this;
        }

        public Criteria andGoodCountIsNotNull() {
            addCriterion("good_count is not null");
            return (Criteria) this;
        }

        public Criteria andGoodCountEqualTo(Long value) {
            addCriterion("good_count =", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountNotEqualTo(Long value) {
            addCriterion("good_count <>", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountGreaterThan(Long value) {
            addCriterion("good_count >", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountGreaterThanOrEqualTo(Long value) {
            addCriterion("good_count >=", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountLessThan(Long value) {
            addCriterion("good_count <", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountLessThanOrEqualTo(Long value) {
            addCriterion("good_count <=", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountIn(List<Long> values) {
            addCriterion("good_count in", values, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountNotIn(List<Long> values) {
            addCriterion("good_count not in", values, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountBetween(Long value1, Long value2) {
            addCriterion("good_count between", value1, value2, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountNotBetween(Long value1, Long value2) {
            addCriterion("good_count not between", value1, value2, "goodCount");
            return (Criteria) this;
        }

        public Criteria andNewyearVoteOneIsNull() {
            addCriterion("newyear_vote_one is null");
            return (Criteria) this;
        }

        public Criteria andNewyearVoteOneIsNotNull() {
            addCriterion("newyear_vote_one is not null");
            return (Criteria) this;
        }

        public Criteria andNewyearVoteOneEqualTo(Long value) {
            addCriterion("newyear_vote_one =", value, "newyearVoteOne");
            return (Criteria) this;
        }

        public Criteria andNewyearVoteOneNotEqualTo(Long value) {
            addCriterion("newyear_vote_one <>", value, "newyearVoteOne");
            return (Criteria) this;
        }

        public Criteria andNewyearVoteOneGreaterThan(Long value) {
            addCriterion("newyear_vote_one >", value, "newyearVoteOne");
            return (Criteria) this;
        }

        public Criteria andNewyearVoteOneGreaterThanOrEqualTo(Long value) {
            addCriterion("newyear_vote_one >=", value, "newyearVoteOne");
            return (Criteria) this;
        }

        public Criteria andNewyearVoteOneLessThan(Long value) {
            addCriterion("newyear_vote_one <", value, "newyearVoteOne");
            return (Criteria) this;
        }

        public Criteria andNewyearVoteOneLessThanOrEqualTo(Long value) {
            addCriterion("newyear_vote_one <=", value, "newyearVoteOne");
            return (Criteria) this;
        }

        public Criteria andNewyearVoteOneIn(List<Long> values) {
            addCriterion("newyear_vote_one in", values, "newyearVoteOne");
            return (Criteria) this;
        }

        public Criteria andNewyearVoteOneNotIn(List<Long> values) {
            addCriterion("newyear_vote_one not in", values, "newyearVoteOne");
            return (Criteria) this;
        }

        public Criteria andNewyearVoteOneBetween(Long value1, Long value2) {
            addCriterion("newyear_vote_one between", value1, value2, "newyearVoteOne");
            return (Criteria) this;
        }

        public Criteria andNewyearVoteOneNotBetween(Long value1, Long value2) {
            addCriterion("newyear_vote_one not between", value1, value2, "newyearVoteOne");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIsNull() {
            addCriterion("is_recommend is null");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIsNotNull() {
            addCriterion("is_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andIsRecommendEqualTo(String value) {
            addCriterion("is_recommend =", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotEqualTo(String value) {
            addCriterion("is_recommend <>", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendGreaterThan(String value) {
            addCriterion("is_recommend >", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendGreaterThanOrEqualTo(String value) {
            addCriterion("is_recommend >=", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLessThan(String value) {
            addCriterion("is_recommend <", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLessThanOrEqualTo(String value) {
            addCriterion("is_recommend <=", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLike(String value) {
            addCriterion("is_recommend like", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotLike(String value) {
            addCriterion("is_recommend not like", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIn(List<String> values) {
            addCriterion("is_recommend in", values, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotIn(List<String> values) {
            addCriterion("is_recommend not in", values, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendBetween(String value1, String value2) {
            addCriterion("is_recommend between", value1, value2, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotBetween(String value1, String value2) {
            addCriterion("is_recommend not between", value1, value2, "isRecommend");
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