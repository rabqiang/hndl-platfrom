package com.hndl.cn.dao.imsinger.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ImsingerWhoComeRecordDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ImsingerWhoComeRecordDoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andVoteSingerId1IsNull() {
            addCriterion("vote_singer_id1 is null");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId1IsNotNull() {
            addCriterion("vote_singer_id1 is not null");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId1EqualTo(Long value) {
            addCriterion("vote_singer_id1 =", value, "voteSingerId1");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId1NotEqualTo(Long value) {
            addCriterion("vote_singer_id1 <>", value, "voteSingerId1");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId1GreaterThan(Long value) {
            addCriterion("vote_singer_id1 >", value, "voteSingerId1");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId1GreaterThanOrEqualTo(Long value) {
            addCriterion("vote_singer_id1 >=", value, "voteSingerId1");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId1LessThan(Long value) {
            addCriterion("vote_singer_id1 <", value, "voteSingerId1");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId1LessThanOrEqualTo(Long value) {
            addCriterion("vote_singer_id1 <=", value, "voteSingerId1");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId1In(List<Long> values) {
            addCriterion("vote_singer_id1 in", values, "voteSingerId1");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId1NotIn(List<Long> values) {
            addCriterion("vote_singer_id1 not in", values, "voteSingerId1");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId1Between(Long value1, Long value2) {
            addCriterion("vote_singer_id1 between", value1, value2, "voteSingerId1");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId1NotBetween(Long value1, Long value2) {
            addCriterion("vote_singer_id1 not between", value1, value2, "voteSingerId1");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId2IsNull() {
            addCriterion("vote_singer_id2 is null");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId2IsNotNull() {
            addCriterion("vote_singer_id2 is not null");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId2EqualTo(Long value) {
            addCriterion("vote_singer_id2 =", value, "voteSingerId2");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId2NotEqualTo(Long value) {
            addCriterion("vote_singer_id2 <>", value, "voteSingerId2");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId2GreaterThan(Long value) {
            addCriterion("vote_singer_id2 >", value, "voteSingerId2");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId2GreaterThanOrEqualTo(Long value) {
            addCriterion("vote_singer_id2 >=", value, "voteSingerId2");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId2LessThan(Long value) {
            addCriterion("vote_singer_id2 <", value, "voteSingerId2");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId2LessThanOrEqualTo(Long value) {
            addCriterion("vote_singer_id2 <=", value, "voteSingerId2");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId2In(List<Long> values) {
            addCriterion("vote_singer_id2 in", values, "voteSingerId2");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId2NotIn(List<Long> values) {
            addCriterion("vote_singer_id2 not in", values, "voteSingerId2");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId2Between(Long value1, Long value2) {
            addCriterion("vote_singer_id2 between", value1, value2, "voteSingerId2");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId2NotBetween(Long value1, Long value2) {
            addCriterion("vote_singer_id2 not between", value1, value2, "voteSingerId2");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId3IsNull() {
            addCriterion("vote_singer_id3 is null");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId3IsNotNull() {
            addCriterion("vote_singer_id3 is not null");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId3EqualTo(Long value) {
            addCriterion("vote_singer_id3 =", value, "voteSingerId3");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId3NotEqualTo(Long value) {
            addCriterion("vote_singer_id3 <>", value, "voteSingerId3");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId3GreaterThan(Long value) {
            addCriterion("vote_singer_id3 >", value, "voteSingerId3");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId3GreaterThanOrEqualTo(Long value) {
            addCriterion("vote_singer_id3 >=", value, "voteSingerId3");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId3LessThan(Long value) {
            addCriterion("vote_singer_id3 <", value, "voteSingerId3");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId3LessThanOrEqualTo(Long value) {
            addCriterion("vote_singer_id3 <=", value, "voteSingerId3");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId3In(List<Long> values) {
            addCriterion("vote_singer_id3 in", values, "voteSingerId3");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId3NotIn(List<Long> values) {
            addCriterion("vote_singer_id3 not in", values, "voteSingerId3");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId3Between(Long value1, Long value2) {
            addCriterion("vote_singer_id3 between", value1, value2, "voteSingerId3");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId3NotBetween(Long value1, Long value2) {
            addCriterion("vote_singer_id3 not between", value1, value2, "voteSingerId3");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId4IsNull() {
            addCriterion("vote_singer_id4 is null");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId4IsNotNull() {
            addCriterion("vote_singer_id4 is not null");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId4EqualTo(Long value) {
            addCriterion("vote_singer_id4 =", value, "voteSingerId4");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId4NotEqualTo(Long value) {
            addCriterion("vote_singer_id4 <>", value, "voteSingerId4");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId4GreaterThan(Long value) {
            addCriterion("vote_singer_id4 >", value, "voteSingerId4");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId4GreaterThanOrEqualTo(Long value) {
            addCriterion("vote_singer_id4 >=", value, "voteSingerId4");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId4LessThan(Long value) {
            addCriterion("vote_singer_id4 <", value, "voteSingerId4");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId4LessThanOrEqualTo(Long value) {
            addCriterion("vote_singer_id4 <=", value, "voteSingerId4");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId4In(List<Long> values) {
            addCriterion("vote_singer_id4 in", values, "voteSingerId4");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId4NotIn(List<Long> values) {
            addCriterion("vote_singer_id4 not in", values, "voteSingerId4");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId4Between(Long value1, Long value2) {
            addCriterion("vote_singer_id4 between", value1, value2, "voteSingerId4");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId4NotBetween(Long value1, Long value2) {
            addCriterion("vote_singer_id4 not between", value1, value2, "voteSingerId4");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId5IsNull() {
            addCriterion("vote_singer_id5 is null");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId5IsNotNull() {
            addCriterion("vote_singer_id5 is not null");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId5EqualTo(Long value) {
            addCriterion("vote_singer_id5 =", value, "voteSingerId5");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId5NotEqualTo(Long value) {
            addCriterion("vote_singer_id5 <>", value, "voteSingerId5");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId5GreaterThan(Long value) {
            addCriterion("vote_singer_id5 >", value, "voteSingerId5");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId5GreaterThanOrEqualTo(Long value) {
            addCriterion("vote_singer_id5 >=", value, "voteSingerId5");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId5LessThan(Long value) {
            addCriterion("vote_singer_id5 <", value, "voteSingerId5");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId5LessThanOrEqualTo(Long value) {
            addCriterion("vote_singer_id5 <=", value, "voteSingerId5");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId5In(List<Long> values) {
            addCriterion("vote_singer_id5 in", values, "voteSingerId5");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId5NotIn(List<Long> values) {
            addCriterion("vote_singer_id5 not in", values, "voteSingerId5");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId5Between(Long value1, Long value2) {
            addCriterion("vote_singer_id5 between", value1, value2, "voteSingerId5");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId5NotBetween(Long value1, Long value2) {
            addCriterion("vote_singer_id5 not between", value1, value2, "voteSingerId5");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId6IsNull() {
            addCriterion("vote_singer_id6 is null");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId6IsNotNull() {
            addCriterion("vote_singer_id6 is not null");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId6EqualTo(Long value) {
            addCriterion("vote_singer_id6 =", value, "voteSingerId6");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId6NotEqualTo(Long value) {
            addCriterion("vote_singer_id6 <>", value, "voteSingerId6");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId6GreaterThan(Long value) {
            addCriterion("vote_singer_id6 >", value, "voteSingerId6");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId6GreaterThanOrEqualTo(Long value) {
            addCriterion("vote_singer_id6 >=", value, "voteSingerId6");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId6LessThan(Long value) {
            addCriterion("vote_singer_id6 <", value, "voteSingerId6");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId6LessThanOrEqualTo(Long value) {
            addCriterion("vote_singer_id6 <=", value, "voteSingerId6");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId6In(List<Long> values) {
            addCriterion("vote_singer_id6 in", values, "voteSingerId6");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId6NotIn(List<Long> values) {
            addCriterion("vote_singer_id6 not in", values, "voteSingerId6");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId6Between(Long value1, Long value2) {
            addCriterion("vote_singer_id6 between", value1, value2, "voteSingerId6");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId6NotBetween(Long value1, Long value2) {
            addCriterion("vote_singer_id6 not between", value1, value2, "voteSingerId6");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId7IsNull() {
            addCriterion("vote_singer_id7 is null");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId7IsNotNull() {
            addCriterion("vote_singer_id7 is not null");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId7EqualTo(Long value) {
            addCriterion("vote_singer_id7 =", value, "voteSingerId7");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId7NotEqualTo(Long value) {
            addCriterion("vote_singer_id7 <>", value, "voteSingerId7");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId7GreaterThan(Long value) {
            addCriterion("vote_singer_id7 >", value, "voteSingerId7");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId7GreaterThanOrEqualTo(Long value) {
            addCriterion("vote_singer_id7 >=", value, "voteSingerId7");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId7LessThan(Long value) {
            addCriterion("vote_singer_id7 <", value, "voteSingerId7");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId7LessThanOrEqualTo(Long value) {
            addCriterion("vote_singer_id7 <=", value, "voteSingerId7");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId7In(List<Long> values) {
            addCriterion("vote_singer_id7 in", values, "voteSingerId7");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId7NotIn(List<Long> values) {
            addCriterion("vote_singer_id7 not in", values, "voteSingerId7");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId7Between(Long value1, Long value2) {
            addCriterion("vote_singer_id7 between", value1, value2, "voteSingerId7");
            return (Criteria) this;
        }

        public Criteria andVoteSingerId7NotBetween(Long value1, Long value2) {
            addCriterion("vote_singer_id7 not between", value1, value2, "voteSingerId7");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
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