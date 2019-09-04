package com.hndl.cn.dao.common.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CommonGameLotteryRecordDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public CommonGameLotteryRecordDoExample() {
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

        public Criteria andGameIdIsNull() {
            addCriterion("game_id is null");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNotNull() {
            addCriterion("game_id is not null");
            return (Criteria) this;
        }

        public Criteria andGameIdEqualTo(Long value) {
            addCriterion("game_id =", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotEqualTo(Long value) {
            addCriterion("game_id <>", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThan(Long value) {
            addCriterion("game_id >", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThanOrEqualTo(Long value) {
            addCriterion("game_id >=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThan(Long value) {
            addCriterion("game_id <", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThanOrEqualTo(Long value) {
            addCriterion("game_id <=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdIn(List<Long> values) {
            addCriterion("game_id in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotIn(List<Long> values) {
            addCriterion("game_id not in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdBetween(Long value1, Long value2) {
            addCriterion("game_id between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotBetween(Long value1, Long value2) {
            addCriterion("game_id not between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andSectionIsNull() {
            addCriterion("`section` is null");
            return (Criteria) this;
        }

        public Criteria andSectionIsNotNull() {
            addCriterion("`section` is not null");
            return (Criteria) this;
        }

        public Criteria andSectionEqualTo(Integer value) {
            addCriterion("`section` =", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotEqualTo(Integer value) {
            addCriterion("`section` <>", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionGreaterThan(Integer value) {
            addCriterion("`section` >", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionGreaterThanOrEqualTo(Integer value) {
            addCriterion("`section` >=", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLessThan(Integer value) {
            addCriterion("`section` <", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLessThanOrEqualTo(Integer value) {
            addCriterion("`section` <=", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionIn(List<Integer> values) {
            addCriterion("`section` in", values, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotIn(List<Integer> values) {
            addCriterion("`section` not in", values, "section");
            return (Criteria) this;
        }

        public Criteria andSectionBetween(Integer value1, Integer value2) {
            addCriterion("`section` between", value1, value2, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotBetween(Integer value1, Integer value2) {
            addCriterion("`section` not between", value1, value2, "section");
            return (Criteria) this;
        }

        public Criteria andPrizeIdIsNull() {
            addCriterion("prize_id is null");
            return (Criteria) this;
        }

        public Criteria andPrizeIdIsNotNull() {
            addCriterion("prize_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeIdEqualTo(Long value) {
            addCriterion("prize_id =", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdNotEqualTo(Long value) {
            addCriterion("prize_id <>", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdGreaterThan(Long value) {
            addCriterion("prize_id >", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("prize_id >=", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdLessThan(Long value) {
            addCriterion("prize_id <", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdLessThanOrEqualTo(Long value) {
            addCriterion("prize_id <=", value, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdIn(List<Long> values) {
            addCriterion("prize_id in", values, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdNotIn(List<Long> values) {
            addCriterion("prize_id not in", values, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdBetween(Long value1, Long value2) {
            addCriterion("prize_id between", value1, value2, "prizeId");
            return (Criteria) this;
        }

        public Criteria andPrizeIdNotBetween(Long value1, Long value2) {
            addCriterion("prize_id not between", value1, value2, "prizeId");
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

        public Criteria andIsGivePrizeIsNull() {
            addCriterion("is_give_prize is null");
            return (Criteria) this;
        }

        public Criteria andIsGivePrizeIsNotNull() {
            addCriterion("is_give_prize is not null");
            return (Criteria) this;
        }

        public Criteria andIsGivePrizeEqualTo(String value) {
            addCriterion("is_give_prize =", value, "isGivePrize");
            return (Criteria) this;
        }

        public Criteria andIsGivePrizeNotEqualTo(String value) {
            addCriterion("is_give_prize <>", value, "isGivePrize");
            return (Criteria) this;
        }

        public Criteria andIsGivePrizeGreaterThan(String value) {
            addCriterion("is_give_prize >", value, "isGivePrize");
            return (Criteria) this;
        }

        public Criteria andIsGivePrizeGreaterThanOrEqualTo(String value) {
            addCriterion("is_give_prize >=", value, "isGivePrize");
            return (Criteria) this;
        }

        public Criteria andIsGivePrizeLessThan(String value) {
            addCriterion("is_give_prize <", value, "isGivePrize");
            return (Criteria) this;
        }

        public Criteria andIsGivePrizeLessThanOrEqualTo(String value) {
            addCriterion("is_give_prize <=", value, "isGivePrize");
            return (Criteria) this;
        }

        public Criteria andIsGivePrizeLike(String value) {
            addCriterion("is_give_prize like", value, "isGivePrize");
            return (Criteria) this;
        }

        public Criteria andIsGivePrizeNotLike(String value) {
            addCriterion("is_give_prize not like", value, "isGivePrize");
            return (Criteria) this;
        }

        public Criteria andIsGivePrizeIn(List<String> values) {
            addCriterion("is_give_prize in", values, "isGivePrize");
            return (Criteria) this;
        }

        public Criteria andIsGivePrizeNotIn(List<String> values) {
            addCriterion("is_give_prize not in", values, "isGivePrize");
            return (Criteria) this;
        }

        public Criteria andIsGivePrizeBetween(String value1, String value2) {
            addCriterion("is_give_prize between", value1, value2, "isGivePrize");
            return (Criteria) this;
        }

        public Criteria andIsGivePrizeNotBetween(String value1, String value2) {
            addCriterion("is_give_prize not between", value1, value2, "isGivePrize");
            return (Criteria) this;
        }

        public Criteria andIsFreePlayIsNull() {
            addCriterion("is_free_play is null");
            return (Criteria) this;
        }

        public Criteria andIsFreePlayIsNotNull() {
            addCriterion("is_free_play is not null");
            return (Criteria) this;
        }

        public Criteria andIsFreePlayEqualTo(String value) {
            addCriterion("is_free_play =", value, "isFreePlay");
            return (Criteria) this;
        }

        public Criteria andIsFreePlayNotEqualTo(String value) {
            addCriterion("is_free_play <>", value, "isFreePlay");
            return (Criteria) this;
        }

        public Criteria andIsFreePlayGreaterThan(String value) {
            addCriterion("is_free_play >", value, "isFreePlay");
            return (Criteria) this;
        }

        public Criteria andIsFreePlayGreaterThanOrEqualTo(String value) {
            addCriterion("is_free_play >=", value, "isFreePlay");
            return (Criteria) this;
        }

        public Criteria andIsFreePlayLessThan(String value) {
            addCriterion("is_free_play <", value, "isFreePlay");
            return (Criteria) this;
        }

        public Criteria andIsFreePlayLessThanOrEqualTo(String value) {
            addCriterion("is_free_play <=", value, "isFreePlay");
            return (Criteria) this;
        }

        public Criteria andIsFreePlayLike(String value) {
            addCriterion("is_free_play like", value, "isFreePlay");
            return (Criteria) this;
        }

        public Criteria andIsFreePlayNotLike(String value) {
            addCriterion("is_free_play not like", value, "isFreePlay");
            return (Criteria) this;
        }

        public Criteria andIsFreePlayIn(List<String> values) {
            addCriterion("is_free_play in", values, "isFreePlay");
            return (Criteria) this;
        }

        public Criteria andIsFreePlayNotIn(List<String> values) {
            addCriterion("is_free_play not in", values, "isFreePlay");
            return (Criteria) this;
        }

        public Criteria andIsFreePlayBetween(String value1, String value2) {
            addCriterion("is_free_play between", value1, value2, "isFreePlay");
            return (Criteria) this;
        }

        public Criteria andIsFreePlayNotBetween(String value1, String value2) {
            addCriterion("is_free_play not between", value1, value2, "isFreePlay");
            return (Criteria) this;
        }

        public Criteria andIsVisitorIsNull() {
            addCriterion("is_visitor is null");
            return (Criteria) this;
        }

        public Criteria andIsVisitorIsNotNull() {
            addCriterion("is_visitor is not null");
            return (Criteria) this;
        }

        public Criteria andIsVisitorEqualTo(String value) {
            addCriterion("is_visitor =", value, "isVisitor");
            return (Criteria) this;
        }

        public Criteria andIsVisitorNotEqualTo(String value) {
            addCriterion("is_visitor <>", value, "isVisitor");
            return (Criteria) this;
        }

        public Criteria andIsVisitorGreaterThan(String value) {
            addCriterion("is_visitor >", value, "isVisitor");
            return (Criteria) this;
        }

        public Criteria andIsVisitorGreaterThanOrEqualTo(String value) {
            addCriterion("is_visitor >=", value, "isVisitor");
            return (Criteria) this;
        }

        public Criteria andIsVisitorLessThan(String value) {
            addCriterion("is_visitor <", value, "isVisitor");
            return (Criteria) this;
        }

        public Criteria andIsVisitorLessThanOrEqualTo(String value) {
            addCriterion("is_visitor <=", value, "isVisitor");
            return (Criteria) this;
        }

        public Criteria andIsVisitorLike(String value) {
            addCriterion("is_visitor like", value, "isVisitor");
            return (Criteria) this;
        }

        public Criteria andIsVisitorNotLike(String value) {
            addCriterion("is_visitor not like", value, "isVisitor");
            return (Criteria) this;
        }

        public Criteria andIsVisitorIn(List<String> values) {
            addCriterion("is_visitor in", values, "isVisitor");
            return (Criteria) this;
        }

        public Criteria andIsVisitorNotIn(List<String> values) {
            addCriterion("is_visitor not in", values, "isVisitor");
            return (Criteria) this;
        }

        public Criteria andIsVisitorBetween(String value1, String value2) {
            addCriterion("is_visitor between", value1, value2, "isVisitor");
            return (Criteria) this;
        }

        public Criteria andIsVisitorNotBetween(String value1, String value2) {
            addCriterion("is_visitor not between", value1, value2, "isVisitor");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIsNull() {
            addCriterion("device_number is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIsNotNull() {
            addCriterion("device_number is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberEqualTo(String value) {
            addCriterion("device_number =", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotEqualTo(String value) {
            addCriterion("device_number <>", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberGreaterThan(String value) {
            addCriterion("device_number >", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberGreaterThanOrEqualTo(String value) {
            addCriterion("device_number >=", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLessThan(String value) {
            addCriterion("device_number <", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLessThanOrEqualTo(String value) {
            addCriterion("device_number <=", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberLike(String value) {
            addCriterion("device_number like", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotLike(String value) {
            addCriterion("device_number not like", value, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberIn(List<String> values) {
            addCriterion("device_number in", values, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotIn(List<String> values) {
            addCriterion("device_number not in", values, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberBetween(String value1, String value2) {
            addCriterion("device_number between", value1, value2, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andDeviceNumberNotBetween(String value1, String value2) {
            addCriterion("device_number not between", value1, value2, "deviceNumber");
            return (Criteria) this;
        }

        public Criteria andIsGetPrizeIsNull() {
            addCriterion("is_get_prize is null");
            return (Criteria) this;
        }

        public Criteria andIsGetPrizeIsNotNull() {
            addCriterion("is_get_prize is not null");
            return (Criteria) this;
        }

        public Criteria andIsGetPrizeEqualTo(String value) {
            addCriterion("is_get_prize =", value, "isGetPrize");
            return (Criteria) this;
        }

        public Criteria andIsGetPrizeNotEqualTo(String value) {
            addCriterion("is_get_prize <>", value, "isGetPrize");
            return (Criteria) this;
        }

        public Criteria andIsGetPrizeGreaterThan(String value) {
            addCriterion("is_get_prize >", value, "isGetPrize");
            return (Criteria) this;
        }

        public Criteria andIsGetPrizeGreaterThanOrEqualTo(String value) {
            addCriterion("is_get_prize >=", value, "isGetPrize");
            return (Criteria) this;
        }

        public Criteria andIsGetPrizeLessThan(String value) {
            addCriterion("is_get_prize <", value, "isGetPrize");
            return (Criteria) this;
        }

        public Criteria andIsGetPrizeLessThanOrEqualTo(String value) {
            addCriterion("is_get_prize <=", value, "isGetPrize");
            return (Criteria) this;
        }

        public Criteria andIsGetPrizeLike(String value) {
            addCriterion("is_get_prize like", value, "isGetPrize");
            return (Criteria) this;
        }

        public Criteria andIsGetPrizeNotLike(String value) {
            addCriterion("is_get_prize not like", value, "isGetPrize");
            return (Criteria) this;
        }

        public Criteria andIsGetPrizeIn(List<String> values) {
            addCriterion("is_get_prize in", values, "isGetPrize");
            return (Criteria) this;
        }

        public Criteria andIsGetPrizeNotIn(List<String> values) {
            addCriterion("is_get_prize not in", values, "isGetPrize");
            return (Criteria) this;
        }

        public Criteria andIsGetPrizeBetween(String value1, String value2) {
            addCriterion("is_get_prize between", value1, value2, "isGetPrize");
            return (Criteria) this;
        }

        public Criteria andIsGetPrizeNotBetween(String value1, String value2) {
            addCriterion("is_get_prize not between", value1, value2, "isGetPrize");
            return (Criteria) this;
        }

        public Criteria andVoteIdIsNull() {
            addCriterion("vote_id is null");
            return (Criteria) this;
        }

        public Criteria andVoteIdIsNotNull() {
            addCriterion("vote_id is not null");
            return (Criteria) this;
        }

        public Criteria andVoteIdEqualTo(Long value) {
            addCriterion("vote_id =", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotEqualTo(Long value) {
            addCriterion("vote_id <>", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdGreaterThan(Long value) {
            addCriterion("vote_id >", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdGreaterThanOrEqualTo(Long value) {
            addCriterion("vote_id >=", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdLessThan(Long value) {
            addCriterion("vote_id <", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdLessThanOrEqualTo(Long value) {
            addCriterion("vote_id <=", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdIn(List<Long> values) {
            addCriterion("vote_id in", values, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotIn(List<Long> values) {
            addCriterion("vote_id not in", values, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdBetween(Long value1, Long value2) {
            addCriterion("vote_id between", value1, value2, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotBetween(Long value1, Long value2) {
            addCriterion("vote_id not between", value1, value2, "voteId");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdIsNull() {
            addCriterion("guess_info_id is null");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdIsNotNull() {
            addCriterion("guess_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdEqualTo(Long value) {
            addCriterion("guess_info_id =", value, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdNotEqualTo(Long value) {
            addCriterion("guess_info_id <>", value, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdGreaterThan(Long value) {
            addCriterion("guess_info_id >", value, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("guess_info_id >=", value, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdLessThan(Long value) {
            addCriterion("guess_info_id <", value, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("guess_info_id <=", value, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdIn(List<Long> values) {
            addCriterion("guess_info_id in", values, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdNotIn(List<Long> values) {
            addCriterion("guess_info_id not in", values, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdBetween(Long value1, Long value2) {
            addCriterion("guess_info_id between", value1, value2, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andGuessInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("guess_info_id not between", value1, value2, "guessInfoId");
            return (Criteria) this;
        }

        public Criteria andIsCofirmAddrOutDateIsNull() {
            addCriterion("is_cofirm_addr_out_date is null");
            return (Criteria) this;
        }

        public Criteria andIsCofirmAddrOutDateIsNotNull() {
            addCriterion("is_cofirm_addr_out_date is not null");
            return (Criteria) this;
        }

        public Criteria andIsCofirmAddrOutDateEqualTo(String value) {
            addCriterion("is_cofirm_addr_out_date =", value, "isCofirmAddrOutDate");
            return (Criteria) this;
        }

        public Criteria andIsCofirmAddrOutDateNotEqualTo(String value) {
            addCriterion("is_cofirm_addr_out_date <>", value, "isCofirmAddrOutDate");
            return (Criteria) this;
        }

        public Criteria andIsCofirmAddrOutDateGreaterThan(String value) {
            addCriterion("is_cofirm_addr_out_date >", value, "isCofirmAddrOutDate");
            return (Criteria) this;
        }

        public Criteria andIsCofirmAddrOutDateGreaterThanOrEqualTo(String value) {
            addCriterion("is_cofirm_addr_out_date >=", value, "isCofirmAddrOutDate");
            return (Criteria) this;
        }

        public Criteria andIsCofirmAddrOutDateLessThan(String value) {
            addCriterion("is_cofirm_addr_out_date <", value, "isCofirmAddrOutDate");
            return (Criteria) this;
        }

        public Criteria andIsCofirmAddrOutDateLessThanOrEqualTo(String value) {
            addCriterion("is_cofirm_addr_out_date <=", value, "isCofirmAddrOutDate");
            return (Criteria) this;
        }

        public Criteria andIsCofirmAddrOutDateLike(String value) {
            addCriterion("is_cofirm_addr_out_date like", value, "isCofirmAddrOutDate");
            return (Criteria) this;
        }

        public Criteria andIsCofirmAddrOutDateNotLike(String value) {
            addCriterion("is_cofirm_addr_out_date not like", value, "isCofirmAddrOutDate");
            return (Criteria) this;
        }

        public Criteria andIsCofirmAddrOutDateIn(List<String> values) {
            addCriterion("is_cofirm_addr_out_date in", values, "isCofirmAddrOutDate");
            return (Criteria) this;
        }

        public Criteria andIsCofirmAddrOutDateNotIn(List<String> values) {
            addCriterion("is_cofirm_addr_out_date not in", values, "isCofirmAddrOutDate");
            return (Criteria) this;
        }

        public Criteria andIsCofirmAddrOutDateBetween(String value1, String value2) {
            addCriterion("is_cofirm_addr_out_date between", value1, value2, "isCofirmAddrOutDate");
            return (Criteria) this;
        }

        public Criteria andIsCofirmAddrOutDateNotBetween(String value1, String value2) {
            addCriterion("is_cofirm_addr_out_date not between", value1, value2, "isCofirmAddrOutDate");
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

        public Criteria andStartRecordIdIsNull() {
            addCriterion("start_record_id is null");
            return (Criteria) this;
        }

        public Criteria andStartRecordIdIsNotNull() {
            addCriterion("start_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andStartRecordIdEqualTo(Long value) {
            addCriterion("start_record_id =", value, "startRecordId");
            return (Criteria) this;
        }

        public Criteria andStartRecordIdNotEqualTo(Long value) {
            addCriterion("start_record_id <>", value, "startRecordId");
            return (Criteria) this;
        }

        public Criteria andStartRecordIdGreaterThan(Long value) {
            addCriterion("start_record_id >", value, "startRecordId");
            return (Criteria) this;
        }

        public Criteria andStartRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("start_record_id >=", value, "startRecordId");
            return (Criteria) this;
        }

        public Criteria andStartRecordIdLessThan(Long value) {
            addCriterion("start_record_id <", value, "startRecordId");
            return (Criteria) this;
        }

        public Criteria andStartRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("start_record_id <=", value, "startRecordId");
            return (Criteria) this;
        }

        public Criteria andStartRecordIdIn(List<Long> values) {
            addCriterion("start_record_id in", values, "startRecordId");
            return (Criteria) this;
        }

        public Criteria andStartRecordIdNotIn(List<Long> values) {
            addCriterion("start_record_id not in", values, "startRecordId");
            return (Criteria) this;
        }

        public Criteria andStartRecordIdBetween(Long value1, Long value2) {
            addCriterion("start_record_id between", value1, value2, "startRecordId");
            return (Criteria) this;
        }

        public Criteria andStartRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("start_record_id not between", value1, value2, "startRecordId");
            return (Criteria) this;
        }

        public Criteria andIsStartVoteIsNull() {
            addCriterion("is_start_vote is null");
            return (Criteria) this;
        }

        public Criteria andIsStartVoteIsNotNull() {
            addCriterion("is_start_vote is not null");
            return (Criteria) this;
        }

        public Criteria andIsStartVoteEqualTo(String value) {
            addCriterion("is_start_vote =", value, "isStartVote");
            return (Criteria) this;
        }

        public Criteria andIsStartVoteNotEqualTo(String value) {
            addCriterion("is_start_vote <>", value, "isStartVote");
            return (Criteria) this;
        }

        public Criteria andIsStartVoteGreaterThan(String value) {
            addCriterion("is_start_vote >", value, "isStartVote");
            return (Criteria) this;
        }

        public Criteria andIsStartVoteGreaterThanOrEqualTo(String value) {
            addCriterion("is_start_vote >=", value, "isStartVote");
            return (Criteria) this;
        }

        public Criteria andIsStartVoteLessThan(String value) {
            addCriterion("is_start_vote <", value, "isStartVote");
            return (Criteria) this;
        }

        public Criteria andIsStartVoteLessThanOrEqualTo(String value) {
            addCriterion("is_start_vote <=", value, "isStartVote");
            return (Criteria) this;
        }

        public Criteria andIsStartVoteLike(String value) {
            addCriterion("is_start_vote like", value, "isStartVote");
            return (Criteria) this;
        }

        public Criteria andIsStartVoteNotLike(String value) {
            addCriterion("is_start_vote not like", value, "isStartVote");
            return (Criteria) this;
        }

        public Criteria andIsStartVoteIn(List<String> values) {
            addCriterion("is_start_vote in", values, "isStartVote");
            return (Criteria) this;
        }

        public Criteria andIsStartVoteNotIn(List<String> values) {
            addCriterion("is_start_vote not in", values, "isStartVote");
            return (Criteria) this;
        }

        public Criteria andIsStartVoteBetween(String value1, String value2) {
            addCriterion("is_start_vote between", value1, value2, "isStartVote");
            return (Criteria) this;
        }

        public Criteria andIsStartVoteNotBetween(String value1, String value2) {
            addCriterion("is_start_vote not between", value1, value2, "isStartVote");
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