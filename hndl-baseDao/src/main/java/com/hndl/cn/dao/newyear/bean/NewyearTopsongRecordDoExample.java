package com.hndl.cn.dao.newyear.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NewyearTopsongRecordDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public NewyearTopsongRecordDoExample() {
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

        public Criteria andSongId1IsNull() {
            addCriterion("song_id1 is null");
            return (Criteria) this;
        }

        public Criteria andSongId1IsNotNull() {
            addCriterion("song_id1 is not null");
            return (Criteria) this;
        }

        public Criteria andSongId1EqualTo(Long value) {
            addCriterion("song_id1 =", value, "songId1");
            return (Criteria) this;
        }

        public Criteria andSongId1NotEqualTo(Long value) {
            addCriterion("song_id1 <>", value, "songId1");
            return (Criteria) this;
        }

        public Criteria andSongId1GreaterThan(Long value) {
            addCriterion("song_id1 >", value, "songId1");
            return (Criteria) this;
        }

        public Criteria andSongId1GreaterThanOrEqualTo(Long value) {
            addCriterion("song_id1 >=", value, "songId1");
            return (Criteria) this;
        }

        public Criteria andSongId1LessThan(Long value) {
            addCriterion("song_id1 <", value, "songId1");
            return (Criteria) this;
        }

        public Criteria andSongId1LessThanOrEqualTo(Long value) {
            addCriterion("song_id1 <=", value, "songId1");
            return (Criteria) this;
        }

        public Criteria andSongId1In(List<Long> values) {
            addCriterion("song_id1 in", values, "songId1");
            return (Criteria) this;
        }

        public Criteria andSongId1NotIn(List<Long> values) {
            addCriterion("song_id1 not in", values, "songId1");
            return (Criteria) this;
        }

        public Criteria andSongId1Between(Long value1, Long value2) {
            addCriterion("song_id1 between", value1, value2, "songId1");
            return (Criteria) this;
        }

        public Criteria andSongId1NotBetween(Long value1, Long value2) {
            addCriterion("song_id1 not between", value1, value2, "songId1");
            return (Criteria) this;
        }

        public Criteria andSongId2IsNull() {
            addCriterion("song_id2 is null");
            return (Criteria) this;
        }

        public Criteria andSongId2IsNotNull() {
            addCriterion("song_id2 is not null");
            return (Criteria) this;
        }

        public Criteria andSongId2EqualTo(Long value) {
            addCriterion("song_id2 =", value, "songId2");
            return (Criteria) this;
        }

        public Criteria andSongId2NotEqualTo(Long value) {
            addCriterion("song_id2 <>", value, "songId2");
            return (Criteria) this;
        }

        public Criteria andSongId2GreaterThan(Long value) {
            addCriterion("song_id2 >", value, "songId2");
            return (Criteria) this;
        }

        public Criteria andSongId2GreaterThanOrEqualTo(Long value) {
            addCriterion("song_id2 >=", value, "songId2");
            return (Criteria) this;
        }

        public Criteria andSongId2LessThan(Long value) {
            addCriterion("song_id2 <", value, "songId2");
            return (Criteria) this;
        }

        public Criteria andSongId2LessThanOrEqualTo(Long value) {
            addCriterion("song_id2 <=", value, "songId2");
            return (Criteria) this;
        }

        public Criteria andSongId2In(List<Long> values) {
            addCriterion("song_id2 in", values, "songId2");
            return (Criteria) this;
        }

        public Criteria andSongId2NotIn(List<Long> values) {
            addCriterion("song_id2 not in", values, "songId2");
            return (Criteria) this;
        }

        public Criteria andSongId2Between(Long value1, Long value2) {
            addCriterion("song_id2 between", value1, value2, "songId2");
            return (Criteria) this;
        }

        public Criteria andSongId2NotBetween(Long value1, Long value2) {
            addCriterion("song_id2 not between", value1, value2, "songId2");
            return (Criteria) this;
        }

        public Criteria andSongId3IsNull() {
            addCriterion("song_id3 is null");
            return (Criteria) this;
        }

        public Criteria andSongId3IsNotNull() {
            addCriterion("song_id3 is not null");
            return (Criteria) this;
        }

        public Criteria andSongId3EqualTo(Long value) {
            addCriterion("song_id3 =", value, "songId3");
            return (Criteria) this;
        }

        public Criteria andSongId3NotEqualTo(Long value) {
            addCriterion("song_id3 <>", value, "songId3");
            return (Criteria) this;
        }

        public Criteria andSongId3GreaterThan(Long value) {
            addCriterion("song_id3 >", value, "songId3");
            return (Criteria) this;
        }

        public Criteria andSongId3GreaterThanOrEqualTo(Long value) {
            addCriterion("song_id3 >=", value, "songId3");
            return (Criteria) this;
        }

        public Criteria andSongId3LessThan(Long value) {
            addCriterion("song_id3 <", value, "songId3");
            return (Criteria) this;
        }

        public Criteria andSongId3LessThanOrEqualTo(Long value) {
            addCriterion("song_id3 <=", value, "songId3");
            return (Criteria) this;
        }

        public Criteria andSongId3In(List<Long> values) {
            addCriterion("song_id3 in", values, "songId3");
            return (Criteria) this;
        }

        public Criteria andSongId3NotIn(List<Long> values) {
            addCriterion("song_id3 not in", values, "songId3");
            return (Criteria) this;
        }

        public Criteria andSongId3Between(Long value1, Long value2) {
            addCriterion("song_id3 between", value1, value2, "songId3");
            return (Criteria) this;
        }

        public Criteria andSongId3NotBetween(Long value1, Long value2) {
            addCriterion("song_id3 not between", value1, value2, "songId3");
            return (Criteria) this;
        }

        public Criteria andSongId4IsNull() {
            addCriterion("song_id4 is null");
            return (Criteria) this;
        }

        public Criteria andSongId4IsNotNull() {
            addCriterion("song_id4 is not null");
            return (Criteria) this;
        }

        public Criteria andSongId4EqualTo(Long value) {
            addCriterion("song_id4 =", value, "songId4");
            return (Criteria) this;
        }

        public Criteria andSongId4NotEqualTo(Long value) {
            addCriterion("song_id4 <>", value, "songId4");
            return (Criteria) this;
        }

        public Criteria andSongId4GreaterThan(Long value) {
            addCriterion("song_id4 >", value, "songId4");
            return (Criteria) this;
        }

        public Criteria andSongId4GreaterThanOrEqualTo(Long value) {
            addCriterion("song_id4 >=", value, "songId4");
            return (Criteria) this;
        }

        public Criteria andSongId4LessThan(Long value) {
            addCriterion("song_id4 <", value, "songId4");
            return (Criteria) this;
        }

        public Criteria andSongId4LessThanOrEqualTo(Long value) {
            addCriterion("song_id4 <=", value, "songId4");
            return (Criteria) this;
        }

        public Criteria andSongId4In(List<Long> values) {
            addCriterion("song_id4 in", values, "songId4");
            return (Criteria) this;
        }

        public Criteria andSongId4NotIn(List<Long> values) {
            addCriterion("song_id4 not in", values, "songId4");
            return (Criteria) this;
        }

        public Criteria andSongId4Between(Long value1, Long value2) {
            addCriterion("song_id4 between", value1, value2, "songId4");
            return (Criteria) this;
        }

        public Criteria andSongId4NotBetween(Long value1, Long value2) {
            addCriterion("song_id4 not between", value1, value2, "songId4");
            return (Criteria) this;
        }

        public Criteria andSongId5IsNull() {
            addCriterion("song_id5 is null");
            return (Criteria) this;
        }

        public Criteria andSongId5IsNotNull() {
            addCriterion("song_id5 is not null");
            return (Criteria) this;
        }

        public Criteria andSongId5EqualTo(Long value) {
            addCriterion("song_id5 =", value, "songId5");
            return (Criteria) this;
        }

        public Criteria andSongId5NotEqualTo(Long value) {
            addCriterion("song_id5 <>", value, "songId5");
            return (Criteria) this;
        }

        public Criteria andSongId5GreaterThan(Long value) {
            addCriterion("song_id5 >", value, "songId5");
            return (Criteria) this;
        }

        public Criteria andSongId5GreaterThanOrEqualTo(Long value) {
            addCriterion("song_id5 >=", value, "songId5");
            return (Criteria) this;
        }

        public Criteria andSongId5LessThan(Long value) {
            addCriterion("song_id5 <", value, "songId5");
            return (Criteria) this;
        }

        public Criteria andSongId5LessThanOrEqualTo(Long value) {
            addCriterion("song_id5 <=", value, "songId5");
            return (Criteria) this;
        }

        public Criteria andSongId5In(List<Long> values) {
            addCriterion("song_id5 in", values, "songId5");
            return (Criteria) this;
        }

        public Criteria andSongId5NotIn(List<Long> values) {
            addCriterion("song_id5 not in", values, "songId5");
            return (Criteria) this;
        }

        public Criteria andSongId5Between(Long value1, Long value2) {
            addCriterion("song_id5 between", value1, value2, "songId5");
            return (Criteria) this;
        }

        public Criteria andSongId5NotBetween(Long value1, Long value2) {
            addCriterion("song_id5 not between", value1, value2, "songId5");
            return (Criteria) this;
        }

        public Criteria andSongId6IsNull() {
            addCriterion("song_id6 is null");
            return (Criteria) this;
        }

        public Criteria andSongId6IsNotNull() {
            addCriterion("song_id6 is not null");
            return (Criteria) this;
        }

        public Criteria andSongId6EqualTo(Long value) {
            addCriterion("song_id6 =", value, "songId6");
            return (Criteria) this;
        }

        public Criteria andSongId6NotEqualTo(Long value) {
            addCriterion("song_id6 <>", value, "songId6");
            return (Criteria) this;
        }

        public Criteria andSongId6GreaterThan(Long value) {
            addCriterion("song_id6 >", value, "songId6");
            return (Criteria) this;
        }

        public Criteria andSongId6GreaterThanOrEqualTo(Long value) {
            addCriterion("song_id6 >=", value, "songId6");
            return (Criteria) this;
        }

        public Criteria andSongId6LessThan(Long value) {
            addCriterion("song_id6 <", value, "songId6");
            return (Criteria) this;
        }

        public Criteria andSongId6LessThanOrEqualTo(Long value) {
            addCriterion("song_id6 <=", value, "songId6");
            return (Criteria) this;
        }

        public Criteria andSongId6In(List<Long> values) {
            addCriterion("song_id6 in", values, "songId6");
            return (Criteria) this;
        }

        public Criteria andSongId6NotIn(List<Long> values) {
            addCriterion("song_id6 not in", values, "songId6");
            return (Criteria) this;
        }

        public Criteria andSongId6Between(Long value1, Long value2) {
            addCriterion("song_id6 between", value1, value2, "songId6");
            return (Criteria) this;
        }

        public Criteria andSongId6NotBetween(Long value1, Long value2) {
            addCriterion("song_id6 not between", value1, value2, "songId6");
            return (Criteria) this;
        }

        public Criteria andSongId7IsNull() {
            addCriterion("song_id7 is null");
            return (Criteria) this;
        }

        public Criteria andSongId7IsNotNull() {
            addCriterion("song_id7 is not null");
            return (Criteria) this;
        }

        public Criteria andSongId7EqualTo(Long value) {
            addCriterion("song_id7 =", value, "songId7");
            return (Criteria) this;
        }

        public Criteria andSongId7NotEqualTo(Long value) {
            addCriterion("song_id7 <>", value, "songId7");
            return (Criteria) this;
        }

        public Criteria andSongId7GreaterThan(Long value) {
            addCriterion("song_id7 >", value, "songId7");
            return (Criteria) this;
        }

        public Criteria andSongId7GreaterThanOrEqualTo(Long value) {
            addCriterion("song_id7 >=", value, "songId7");
            return (Criteria) this;
        }

        public Criteria andSongId7LessThan(Long value) {
            addCriterion("song_id7 <", value, "songId7");
            return (Criteria) this;
        }

        public Criteria andSongId7LessThanOrEqualTo(Long value) {
            addCriterion("song_id7 <=", value, "songId7");
            return (Criteria) this;
        }

        public Criteria andSongId7In(List<Long> values) {
            addCriterion("song_id7 in", values, "songId7");
            return (Criteria) this;
        }

        public Criteria andSongId7NotIn(List<Long> values) {
            addCriterion("song_id7 not in", values, "songId7");
            return (Criteria) this;
        }

        public Criteria andSongId7Between(Long value1, Long value2) {
            addCriterion("song_id7 between", value1, value2, "songId7");
            return (Criteria) this;
        }

        public Criteria andSongId7NotBetween(Long value1, Long value2) {
            addCriterion("song_id7 not between", value1, value2, "songId7");
            return (Criteria) this;
        }

        public Criteria andSongId8IsNull() {
            addCriterion("song_id8 is null");
            return (Criteria) this;
        }

        public Criteria andSongId8IsNotNull() {
            addCriterion("song_id8 is not null");
            return (Criteria) this;
        }

        public Criteria andSongId8EqualTo(Long value) {
            addCriterion("song_id8 =", value, "songId8");
            return (Criteria) this;
        }

        public Criteria andSongId8NotEqualTo(Long value) {
            addCriterion("song_id8 <>", value, "songId8");
            return (Criteria) this;
        }

        public Criteria andSongId8GreaterThan(Long value) {
            addCriterion("song_id8 >", value, "songId8");
            return (Criteria) this;
        }

        public Criteria andSongId8GreaterThanOrEqualTo(Long value) {
            addCriterion("song_id8 >=", value, "songId8");
            return (Criteria) this;
        }

        public Criteria andSongId8LessThan(Long value) {
            addCriterion("song_id8 <", value, "songId8");
            return (Criteria) this;
        }

        public Criteria andSongId8LessThanOrEqualTo(Long value) {
            addCriterion("song_id8 <=", value, "songId8");
            return (Criteria) this;
        }

        public Criteria andSongId8In(List<Long> values) {
            addCriterion("song_id8 in", values, "songId8");
            return (Criteria) this;
        }

        public Criteria andSongId8NotIn(List<Long> values) {
            addCriterion("song_id8 not in", values, "songId8");
            return (Criteria) this;
        }

        public Criteria andSongId8Between(Long value1, Long value2) {
            addCriterion("song_id8 between", value1, value2, "songId8");
            return (Criteria) this;
        }

        public Criteria andSongId8NotBetween(Long value1, Long value2) {
            addCriterion("song_id8 not between", value1, value2, "songId8");
            return (Criteria) this;
        }

        public Criteria andSongId9IsNull() {
            addCriterion("song_id9 is null");
            return (Criteria) this;
        }

        public Criteria andSongId9IsNotNull() {
            addCriterion("song_id9 is not null");
            return (Criteria) this;
        }

        public Criteria andSongId9EqualTo(Long value) {
            addCriterion("song_id9 =", value, "songId9");
            return (Criteria) this;
        }

        public Criteria andSongId9NotEqualTo(Long value) {
            addCriterion("song_id9 <>", value, "songId9");
            return (Criteria) this;
        }

        public Criteria andSongId9GreaterThan(Long value) {
            addCriterion("song_id9 >", value, "songId9");
            return (Criteria) this;
        }

        public Criteria andSongId9GreaterThanOrEqualTo(Long value) {
            addCriterion("song_id9 >=", value, "songId9");
            return (Criteria) this;
        }

        public Criteria andSongId9LessThan(Long value) {
            addCriterion("song_id9 <", value, "songId9");
            return (Criteria) this;
        }

        public Criteria andSongId9LessThanOrEqualTo(Long value) {
            addCriterion("song_id9 <=", value, "songId9");
            return (Criteria) this;
        }

        public Criteria andSongId9In(List<Long> values) {
            addCriterion("song_id9 in", values, "songId9");
            return (Criteria) this;
        }

        public Criteria andSongId9NotIn(List<Long> values) {
            addCriterion("song_id9 not in", values, "songId9");
            return (Criteria) this;
        }

        public Criteria andSongId9Between(Long value1, Long value2) {
            addCriterion("song_id9 between", value1, value2, "songId9");
            return (Criteria) this;
        }

        public Criteria andSongId9NotBetween(Long value1, Long value2) {
            addCriterion("song_id9 not between", value1, value2, "songId9");
            return (Criteria) this;
        }

        public Criteria andSongId10IsNull() {
            addCriterion("song_id10 is null");
            return (Criteria) this;
        }

        public Criteria andSongId10IsNotNull() {
            addCriterion("song_id10 is not null");
            return (Criteria) this;
        }

        public Criteria andSongId10EqualTo(Long value) {
            addCriterion("song_id10 =", value, "songId10");
            return (Criteria) this;
        }

        public Criteria andSongId10NotEqualTo(Long value) {
            addCriterion("song_id10 <>", value, "songId10");
            return (Criteria) this;
        }

        public Criteria andSongId10GreaterThan(Long value) {
            addCriterion("song_id10 >", value, "songId10");
            return (Criteria) this;
        }

        public Criteria andSongId10GreaterThanOrEqualTo(Long value) {
            addCriterion("song_id10 >=", value, "songId10");
            return (Criteria) this;
        }

        public Criteria andSongId10LessThan(Long value) {
            addCriterion("song_id10 <", value, "songId10");
            return (Criteria) this;
        }

        public Criteria andSongId10LessThanOrEqualTo(Long value) {
            addCriterion("song_id10 <=", value, "songId10");
            return (Criteria) this;
        }

        public Criteria andSongId10In(List<Long> values) {
            addCriterion("song_id10 in", values, "songId10");
            return (Criteria) this;
        }

        public Criteria andSongId10NotIn(List<Long> values) {
            addCriterion("song_id10 not in", values, "songId10");
            return (Criteria) this;
        }

        public Criteria andSongId10Between(Long value1, Long value2) {
            addCriterion("song_id10 between", value1, value2, "songId10");
            return (Criteria) this;
        }

        public Criteria andSongId10NotBetween(Long value1, Long value2) {
            addCriterion("song_id10 not between", value1, value2, "songId10");
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