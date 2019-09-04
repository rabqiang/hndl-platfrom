package com.hndl.cn.dao.common.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonGameInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public CommonGameInfoDoExample() {
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

        public Criteria andGameNameIsNull() {
            addCriterion("game_name is null");
            return (Criteria) this;
        }

        public Criteria andGameNameIsNotNull() {
            addCriterion("game_name is not null");
            return (Criteria) this;
        }

        public Criteria andGameNameEqualTo(String value) {
            addCriterion("game_name =", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotEqualTo(String value) {
            addCriterion("game_name <>", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameGreaterThan(String value) {
            addCriterion("game_name >", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameGreaterThanOrEqualTo(String value) {
            addCriterion("game_name >=", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameLessThan(String value) {
            addCriterion("game_name <", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameLessThanOrEqualTo(String value) {
            addCriterion("game_name <=", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameLike(String value) {
            addCriterion("game_name like", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotLike(String value) {
            addCriterion("game_name not like", value, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameIn(List<String> values) {
            addCriterion("game_name in", values, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotIn(List<String> values) {
            addCriterion("game_name not in", values, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameBetween(String value1, String value2) {
            addCriterion("game_name between", value1, value2, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameNameNotBetween(String value1, String value2) {
            addCriterion("game_name not between", value1, value2, "gameName");
            return (Criteria) this;
        }

        public Criteria andGameDescIsNull() {
            addCriterion("game_desc is null");
            return (Criteria) this;
        }

        public Criteria andGameDescIsNotNull() {
            addCriterion("game_desc is not null");
            return (Criteria) this;
        }

        public Criteria andGameDescEqualTo(String value) {
            addCriterion("game_desc =", value, "gameDesc");
            return (Criteria) this;
        }

        public Criteria andGameDescNotEqualTo(String value) {
            addCriterion("game_desc <>", value, "gameDesc");
            return (Criteria) this;
        }

        public Criteria andGameDescGreaterThan(String value) {
            addCriterion("game_desc >", value, "gameDesc");
            return (Criteria) this;
        }

        public Criteria andGameDescGreaterThanOrEqualTo(String value) {
            addCriterion("game_desc >=", value, "gameDesc");
            return (Criteria) this;
        }

        public Criteria andGameDescLessThan(String value) {
            addCriterion("game_desc <", value, "gameDesc");
            return (Criteria) this;
        }

        public Criteria andGameDescLessThanOrEqualTo(String value) {
            addCriterion("game_desc <=", value, "gameDesc");
            return (Criteria) this;
        }

        public Criteria andGameDescLike(String value) {
            addCriterion("game_desc like", value, "gameDesc");
            return (Criteria) this;
        }

        public Criteria andGameDescNotLike(String value) {
            addCriterion("game_desc not like", value, "gameDesc");
            return (Criteria) this;
        }

        public Criteria andGameDescIn(List<String> values) {
            addCriterion("game_desc in", values, "gameDesc");
            return (Criteria) this;
        }

        public Criteria andGameDescNotIn(List<String> values) {
            addCriterion("game_desc not in", values, "gameDesc");
            return (Criteria) this;
        }

        public Criteria andGameDescBetween(String value1, String value2) {
            addCriterion("game_desc between", value1, value2, "gameDesc");
            return (Criteria) this;
        }

        public Criteria andGameDescNotBetween(String value1, String value2) {
            addCriterion("game_desc not between", value1, value2, "gameDesc");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(Integer value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(Integer value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(Integer value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(Integer value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(Integer value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<Integer> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<Integer> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(Integer value1, Integer value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(Integer value1, Integer value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleSecondIsNull() {
            addCriterion("title_second is null");
            return (Criteria) this;
        }

        public Criteria andTitleSecondIsNotNull() {
            addCriterion("title_second is not null");
            return (Criteria) this;
        }

        public Criteria andTitleSecondEqualTo(String value) {
            addCriterion("title_second =", value, "titleSecond");
            return (Criteria) this;
        }

        public Criteria andTitleSecondNotEqualTo(String value) {
            addCriterion("title_second <>", value, "titleSecond");
            return (Criteria) this;
        }

        public Criteria andTitleSecondGreaterThan(String value) {
            addCriterion("title_second >", value, "titleSecond");
            return (Criteria) this;
        }

        public Criteria andTitleSecondGreaterThanOrEqualTo(String value) {
            addCriterion("title_second >=", value, "titleSecond");
            return (Criteria) this;
        }

        public Criteria andTitleSecondLessThan(String value) {
            addCriterion("title_second <", value, "titleSecond");
            return (Criteria) this;
        }

        public Criteria andTitleSecondLessThanOrEqualTo(String value) {
            addCriterion("title_second <=", value, "titleSecond");
            return (Criteria) this;
        }

        public Criteria andTitleSecondLike(String value) {
            addCriterion("title_second like", value, "titleSecond");
            return (Criteria) this;
        }

        public Criteria andTitleSecondNotLike(String value) {
            addCriterion("title_second not like", value, "titleSecond");
            return (Criteria) this;
        }

        public Criteria andTitleSecondIn(List<String> values) {
            addCriterion("title_second in", values, "titleSecond");
            return (Criteria) this;
        }

        public Criteria andTitleSecondNotIn(List<String> values) {
            addCriterion("title_second not in", values, "titleSecond");
            return (Criteria) this;
        }

        public Criteria andTitleSecondBetween(String value1, String value2) {
            addCriterion("title_second between", value1, value2, "titleSecond");
            return (Criteria) this;
        }

        public Criteria andTitleSecondNotBetween(String value1, String value2) {
            addCriterion("title_second not between", value1, value2, "titleSecond");
            return (Criteria) this;
        }

        public Criteria andApplyCountIsNull() {
            addCriterion("apply_count is null");
            return (Criteria) this;
        }

        public Criteria andApplyCountIsNotNull() {
            addCriterion("apply_count is not null");
            return (Criteria) this;
        }

        public Criteria andApplyCountEqualTo(Integer value) {
            addCriterion("apply_count =", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountNotEqualTo(Integer value) {
            addCriterion("apply_count <>", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountGreaterThan(Integer value) {
            addCriterion("apply_count >", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_count >=", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountLessThan(Integer value) {
            addCriterion("apply_count <", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountLessThanOrEqualTo(Integer value) {
            addCriterion("apply_count <=", value, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountIn(List<Integer> values) {
            addCriterion("apply_count in", values, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountNotIn(List<Integer> values) {
            addCriterion("apply_count not in", values, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountBetween(Integer value1, Integer value2) {
            addCriterion("apply_count between", value1, value2, "applyCount");
            return (Criteria) this;
        }

        public Criteria andApplyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_count not between", value1, value2, "applyCount");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
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

        public Criteria andSectionIsNull() {
            addCriterion("`section` is null");
            return (Criteria) this;
        }

        public Criteria andSectionIsNotNull() {
            addCriterion("`section` is not null");
            return (Criteria) this;
        }

        public Criteria andSectionEqualTo(String value) {
            addCriterion("`section` =", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotEqualTo(String value) {
            addCriterion("`section` <>", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionGreaterThan(String value) {
            addCriterion("`section` >", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionGreaterThanOrEqualTo(String value) {
            addCriterion("`section` >=", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLessThan(String value) {
            addCriterion("`section` <", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLessThanOrEqualTo(String value) {
            addCriterion("`section` <=", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionLike(String value) {
            addCriterion("`section` like", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotLike(String value) {
            addCriterion("`section` not like", value, "section");
            return (Criteria) this;
        }

        public Criteria andSectionIn(List<String> values) {
            addCriterion("`section` in", values, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotIn(List<String> values) {
            addCriterion("`section` not in", values, "section");
            return (Criteria) this;
        }

        public Criteria andSectionBetween(String value1, String value2) {
            addCriterion("`section` between", value1, value2, "section");
            return (Criteria) this;
        }

        public Criteria andSectionNotBetween(String value1, String value2) {
            addCriterion("`section` not between", value1, value2, "section");
            return (Criteria) this;
        }

        public Criteria andFreeTimesIsNull() {
            addCriterion("free_times is null");
            return (Criteria) this;
        }

        public Criteria andFreeTimesIsNotNull() {
            addCriterion("free_times is not null");
            return (Criteria) this;
        }

        public Criteria andFreeTimesEqualTo(Integer value) {
            addCriterion("free_times =", value, "freeTimes");
            return (Criteria) this;
        }

        public Criteria andFreeTimesNotEqualTo(Integer value) {
            addCriterion("free_times <>", value, "freeTimes");
            return (Criteria) this;
        }

        public Criteria andFreeTimesGreaterThan(Integer value) {
            addCriterion("free_times >", value, "freeTimes");
            return (Criteria) this;
        }

        public Criteria andFreeTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("free_times >=", value, "freeTimes");
            return (Criteria) this;
        }

        public Criteria andFreeTimesLessThan(Integer value) {
            addCriterion("free_times <", value, "freeTimes");
            return (Criteria) this;
        }

        public Criteria andFreeTimesLessThanOrEqualTo(Integer value) {
            addCriterion("free_times <=", value, "freeTimes");
            return (Criteria) this;
        }

        public Criteria andFreeTimesIn(List<Integer> values) {
            addCriterion("free_times in", values, "freeTimes");
            return (Criteria) this;
        }

        public Criteria andFreeTimesNotIn(List<Integer> values) {
            addCriterion("free_times not in", values, "freeTimes");
            return (Criteria) this;
        }

        public Criteria andFreeTimesBetween(Integer value1, Integer value2) {
            addCriterion("free_times between", value1, value2, "freeTimes");
            return (Criteria) this;
        }

        public Criteria andFreeTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("free_times not between", value1, value2, "freeTimes");
            return (Criteria) this;
        }

        public Criteria andNoFreeTimesIsNull() {
            addCriterion("no_free_times is null");
            return (Criteria) this;
        }

        public Criteria andNoFreeTimesIsNotNull() {
            addCriterion("no_free_times is not null");
            return (Criteria) this;
        }

        public Criteria andNoFreeTimesEqualTo(Integer value) {
            addCriterion("no_free_times =", value, "noFreeTimes");
            return (Criteria) this;
        }

        public Criteria andNoFreeTimesNotEqualTo(Integer value) {
            addCriterion("no_free_times <>", value, "noFreeTimes");
            return (Criteria) this;
        }

        public Criteria andNoFreeTimesGreaterThan(Integer value) {
            addCriterion("no_free_times >", value, "noFreeTimes");
            return (Criteria) this;
        }

        public Criteria andNoFreeTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("no_free_times >=", value, "noFreeTimes");
            return (Criteria) this;
        }

        public Criteria andNoFreeTimesLessThan(Integer value) {
            addCriterion("no_free_times <", value, "noFreeTimes");
            return (Criteria) this;
        }

        public Criteria andNoFreeTimesLessThanOrEqualTo(Integer value) {
            addCriterion("no_free_times <=", value, "noFreeTimes");
            return (Criteria) this;
        }

        public Criteria andNoFreeTimesIn(List<Integer> values) {
            addCriterion("no_free_times in", values, "noFreeTimes");
            return (Criteria) this;
        }

        public Criteria andNoFreeTimesNotIn(List<Integer> values) {
            addCriterion("no_free_times not in", values, "noFreeTimes");
            return (Criteria) this;
        }

        public Criteria andNoFreeTimesBetween(Integer value1, Integer value2) {
            addCriterion("no_free_times between", value1, value2, "noFreeTimes");
            return (Criteria) this;
        }

        public Criteria andNoFreeTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("no_free_times not between", value1, value2, "noFreeTimes");
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

        public Criteria andPayCountEqualTo(Integer value) {
            addCriterion("pay_count =", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotEqualTo(Integer value) {
            addCriterion("pay_count <>", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountGreaterThan(Integer value) {
            addCriterion("pay_count >", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_count >=", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountLessThan(Integer value) {
            addCriterion("pay_count <", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountLessThanOrEqualTo(Integer value) {
            addCriterion("pay_count <=", value, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountIn(List<Integer> values) {
            addCriterion("pay_count in", values, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotIn(List<Integer> values) {
            addCriterion("pay_count not in", values, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountBetween(Integer value1, Integer value2) {
            addCriterion("pay_count between", value1, value2, "payCount");
            return (Criteria) this;
        }

        public Criteria andPayCountNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_count not between", value1, value2, "payCount");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(String value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(String value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(String value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(String value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(String value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(String value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLike(String value) {
            addCriterion("is_show like", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotLike(String value) {
            addCriterion("is_show not like", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<String> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<String> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(String value1, String value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(String value1, String value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNull() {
            addCriterion("read_count is null");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNotNull() {
            addCriterion("read_count is not null");
            return (Criteria) this;
        }

        public Criteria andReadCountEqualTo(Integer value) {
            addCriterion("read_count =", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotEqualTo(Integer value) {
            addCriterion("read_count <>", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThan(Integer value) {
            addCriterion("read_count >", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_count >=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThan(Integer value) {
            addCriterion("read_count <", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThanOrEqualTo(Integer value) {
            addCriterion("read_count <=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountIn(List<Integer> values) {
            addCriterion("read_count in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotIn(List<Integer> values) {
            addCriterion("read_count not in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountBetween(Integer value1, Integer value2) {
            addCriterion("read_count between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotBetween(Integer value1, Integer value2) {
            addCriterion("read_count not between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andAdUrl1IsNull() {
            addCriterion("ad_url1 is null");
            return (Criteria) this;
        }

        public Criteria andAdUrl1IsNotNull() {
            addCriterion("ad_url1 is not null");
            return (Criteria) this;
        }

        public Criteria andAdUrl1EqualTo(String value) {
            addCriterion("ad_url1 =", value, "adUrl1");
            return (Criteria) this;
        }

        public Criteria andAdUrl1NotEqualTo(String value) {
            addCriterion("ad_url1 <>", value, "adUrl1");
            return (Criteria) this;
        }

        public Criteria andAdUrl1GreaterThan(String value) {
            addCriterion("ad_url1 >", value, "adUrl1");
            return (Criteria) this;
        }

        public Criteria andAdUrl1GreaterThanOrEqualTo(String value) {
            addCriterion("ad_url1 >=", value, "adUrl1");
            return (Criteria) this;
        }

        public Criteria andAdUrl1LessThan(String value) {
            addCriterion("ad_url1 <", value, "adUrl1");
            return (Criteria) this;
        }

        public Criteria andAdUrl1LessThanOrEqualTo(String value) {
            addCriterion("ad_url1 <=", value, "adUrl1");
            return (Criteria) this;
        }

        public Criteria andAdUrl1Like(String value) {
            addCriterion("ad_url1 like", value, "adUrl1");
            return (Criteria) this;
        }

        public Criteria andAdUrl1NotLike(String value) {
            addCriterion("ad_url1 not like", value, "adUrl1");
            return (Criteria) this;
        }

        public Criteria andAdUrl1In(List<String> values) {
            addCriterion("ad_url1 in", values, "adUrl1");
            return (Criteria) this;
        }

        public Criteria andAdUrl1NotIn(List<String> values) {
            addCriterion("ad_url1 not in", values, "adUrl1");
            return (Criteria) this;
        }

        public Criteria andAdUrl1Between(String value1, String value2) {
            addCriterion("ad_url1 between", value1, value2, "adUrl1");
            return (Criteria) this;
        }

        public Criteria andAdUrl1NotBetween(String value1, String value2) {
            addCriterion("ad_url1 not between", value1, value2, "adUrl1");
            return (Criteria) this;
        }

        public Criteria andAdUrl2IsNull() {
            addCriterion("ad_url2 is null");
            return (Criteria) this;
        }

        public Criteria andAdUrl2IsNotNull() {
            addCriterion("ad_url2 is not null");
            return (Criteria) this;
        }

        public Criteria andAdUrl2EqualTo(String value) {
            addCriterion("ad_url2 =", value, "adUrl2");
            return (Criteria) this;
        }

        public Criteria andAdUrl2NotEqualTo(String value) {
            addCriterion("ad_url2 <>", value, "adUrl2");
            return (Criteria) this;
        }

        public Criteria andAdUrl2GreaterThan(String value) {
            addCriterion("ad_url2 >", value, "adUrl2");
            return (Criteria) this;
        }

        public Criteria andAdUrl2GreaterThanOrEqualTo(String value) {
            addCriterion("ad_url2 >=", value, "adUrl2");
            return (Criteria) this;
        }

        public Criteria andAdUrl2LessThan(String value) {
            addCriterion("ad_url2 <", value, "adUrl2");
            return (Criteria) this;
        }

        public Criteria andAdUrl2LessThanOrEqualTo(String value) {
            addCriterion("ad_url2 <=", value, "adUrl2");
            return (Criteria) this;
        }

        public Criteria andAdUrl2Like(String value) {
            addCriterion("ad_url2 like", value, "adUrl2");
            return (Criteria) this;
        }

        public Criteria andAdUrl2NotLike(String value) {
            addCriterion("ad_url2 not like", value, "adUrl2");
            return (Criteria) this;
        }

        public Criteria andAdUrl2In(List<String> values) {
            addCriterion("ad_url2 in", values, "adUrl2");
            return (Criteria) this;
        }

        public Criteria andAdUrl2NotIn(List<String> values) {
            addCriterion("ad_url2 not in", values, "adUrl2");
            return (Criteria) this;
        }

        public Criteria andAdUrl2Between(String value1, String value2) {
            addCriterion("ad_url2 between", value1, value2, "adUrl2");
            return (Criteria) this;
        }

        public Criteria andAdUrl2NotBetween(String value1, String value2) {
            addCriterion("ad_url2 not between", value1, value2, "adUrl2");
            return (Criteria) this;
        }

        public Criteria andAdUrl3IsNull() {
            addCriterion("ad_url3 is null");
            return (Criteria) this;
        }

        public Criteria andAdUrl3IsNotNull() {
            addCriterion("ad_url3 is not null");
            return (Criteria) this;
        }

        public Criteria andAdUrl3EqualTo(String value) {
            addCriterion("ad_url3 =", value, "adUrl3");
            return (Criteria) this;
        }

        public Criteria andAdUrl3NotEqualTo(String value) {
            addCriterion("ad_url3 <>", value, "adUrl3");
            return (Criteria) this;
        }

        public Criteria andAdUrl3GreaterThan(String value) {
            addCriterion("ad_url3 >", value, "adUrl3");
            return (Criteria) this;
        }

        public Criteria andAdUrl3GreaterThanOrEqualTo(String value) {
            addCriterion("ad_url3 >=", value, "adUrl3");
            return (Criteria) this;
        }

        public Criteria andAdUrl3LessThan(String value) {
            addCriterion("ad_url3 <", value, "adUrl3");
            return (Criteria) this;
        }

        public Criteria andAdUrl3LessThanOrEqualTo(String value) {
            addCriterion("ad_url3 <=", value, "adUrl3");
            return (Criteria) this;
        }

        public Criteria andAdUrl3Like(String value) {
            addCriterion("ad_url3 like", value, "adUrl3");
            return (Criteria) this;
        }

        public Criteria andAdUrl3NotLike(String value) {
            addCriterion("ad_url3 not like", value, "adUrl3");
            return (Criteria) this;
        }

        public Criteria andAdUrl3In(List<String> values) {
            addCriterion("ad_url3 in", values, "adUrl3");
            return (Criteria) this;
        }

        public Criteria andAdUrl3NotIn(List<String> values) {
            addCriterion("ad_url3 not in", values, "adUrl3");
            return (Criteria) this;
        }

        public Criteria andAdUrl3Between(String value1, String value2) {
            addCriterion("ad_url3 between", value1, value2, "adUrl3");
            return (Criteria) this;
        }

        public Criteria andAdUrl3NotBetween(String value1, String value2) {
            addCriterion("ad_url3 not between", value1, value2, "adUrl3");
            return (Criteria) this;
        }

        public Criteria andAdUrl4IsNull() {
            addCriterion("ad_url4 is null");
            return (Criteria) this;
        }

        public Criteria andAdUrl4IsNotNull() {
            addCriterion("ad_url4 is not null");
            return (Criteria) this;
        }

        public Criteria andAdUrl4EqualTo(String value) {
            addCriterion("ad_url4 =", value, "adUrl4");
            return (Criteria) this;
        }

        public Criteria andAdUrl4NotEqualTo(String value) {
            addCriterion("ad_url4 <>", value, "adUrl4");
            return (Criteria) this;
        }

        public Criteria andAdUrl4GreaterThan(String value) {
            addCriterion("ad_url4 >", value, "adUrl4");
            return (Criteria) this;
        }

        public Criteria andAdUrl4GreaterThanOrEqualTo(String value) {
            addCriterion("ad_url4 >=", value, "adUrl4");
            return (Criteria) this;
        }

        public Criteria andAdUrl4LessThan(String value) {
            addCriterion("ad_url4 <", value, "adUrl4");
            return (Criteria) this;
        }

        public Criteria andAdUrl4LessThanOrEqualTo(String value) {
            addCriterion("ad_url4 <=", value, "adUrl4");
            return (Criteria) this;
        }

        public Criteria andAdUrl4Like(String value) {
            addCriterion("ad_url4 like", value, "adUrl4");
            return (Criteria) this;
        }

        public Criteria andAdUrl4NotLike(String value) {
            addCriterion("ad_url4 not like", value, "adUrl4");
            return (Criteria) this;
        }

        public Criteria andAdUrl4In(List<String> values) {
            addCriterion("ad_url4 in", values, "adUrl4");
            return (Criteria) this;
        }

        public Criteria andAdUrl4NotIn(List<String> values) {
            addCriterion("ad_url4 not in", values, "adUrl4");
            return (Criteria) this;
        }

        public Criteria andAdUrl4Between(String value1, String value2) {
            addCriterion("ad_url4 between", value1, value2, "adUrl4");
            return (Criteria) this;
        }

        public Criteria andAdUrl4NotBetween(String value1, String value2) {
            addCriterion("ad_url4 not between", value1, value2, "adUrl4");
            return (Criteria) this;
        }

        public Criteria andAdUrl5IsNull() {
            addCriterion("ad_url5 is null");
            return (Criteria) this;
        }

        public Criteria andAdUrl5IsNotNull() {
            addCriterion("ad_url5 is not null");
            return (Criteria) this;
        }

        public Criteria andAdUrl5EqualTo(String value) {
            addCriterion("ad_url5 =", value, "adUrl5");
            return (Criteria) this;
        }

        public Criteria andAdUrl5NotEqualTo(String value) {
            addCriterion("ad_url5 <>", value, "adUrl5");
            return (Criteria) this;
        }

        public Criteria andAdUrl5GreaterThan(String value) {
            addCriterion("ad_url5 >", value, "adUrl5");
            return (Criteria) this;
        }

        public Criteria andAdUrl5GreaterThanOrEqualTo(String value) {
            addCriterion("ad_url5 >=", value, "adUrl5");
            return (Criteria) this;
        }

        public Criteria andAdUrl5LessThan(String value) {
            addCriterion("ad_url5 <", value, "adUrl5");
            return (Criteria) this;
        }

        public Criteria andAdUrl5LessThanOrEqualTo(String value) {
            addCriterion("ad_url5 <=", value, "adUrl5");
            return (Criteria) this;
        }

        public Criteria andAdUrl5Like(String value) {
            addCriterion("ad_url5 like", value, "adUrl5");
            return (Criteria) this;
        }

        public Criteria andAdUrl5NotLike(String value) {
            addCriterion("ad_url5 not like", value, "adUrl5");
            return (Criteria) this;
        }

        public Criteria andAdUrl5In(List<String> values) {
            addCriterion("ad_url5 in", values, "adUrl5");
            return (Criteria) this;
        }

        public Criteria andAdUrl5NotIn(List<String> values) {
            addCriterion("ad_url5 not in", values, "adUrl5");
            return (Criteria) this;
        }

        public Criteria andAdUrl5Between(String value1, String value2) {
            addCriterion("ad_url5 between", value1, value2, "adUrl5");
            return (Criteria) this;
        }

        public Criteria andAdUrl5NotBetween(String value1, String value2) {
            addCriterion("ad_url5 not between", value1, value2, "adUrl5");
            return (Criteria) this;
        }

        public Criteria andRuleUrlIsNull() {
            addCriterion("rule_url is null");
            return (Criteria) this;
        }

        public Criteria andRuleUrlIsNotNull() {
            addCriterion("rule_url is not null");
            return (Criteria) this;
        }

        public Criteria andRuleUrlEqualTo(String value) {
            addCriterion("rule_url =", value, "ruleUrl");
            return (Criteria) this;
        }

        public Criteria andRuleUrlNotEqualTo(String value) {
            addCriterion("rule_url <>", value, "ruleUrl");
            return (Criteria) this;
        }

        public Criteria andRuleUrlGreaterThan(String value) {
            addCriterion("rule_url >", value, "ruleUrl");
            return (Criteria) this;
        }

        public Criteria andRuleUrlGreaterThanOrEqualTo(String value) {
            addCriterion("rule_url >=", value, "ruleUrl");
            return (Criteria) this;
        }

        public Criteria andRuleUrlLessThan(String value) {
            addCriterion("rule_url <", value, "ruleUrl");
            return (Criteria) this;
        }

        public Criteria andRuleUrlLessThanOrEqualTo(String value) {
            addCriterion("rule_url <=", value, "ruleUrl");
            return (Criteria) this;
        }

        public Criteria andRuleUrlLike(String value) {
            addCriterion("rule_url like", value, "ruleUrl");
            return (Criteria) this;
        }

        public Criteria andRuleUrlNotLike(String value) {
            addCriterion("rule_url not like", value, "ruleUrl");
            return (Criteria) this;
        }

        public Criteria andRuleUrlIn(List<String> values) {
            addCriterion("rule_url in", values, "ruleUrl");
            return (Criteria) this;
        }

        public Criteria andRuleUrlNotIn(List<String> values) {
            addCriterion("rule_url not in", values, "ruleUrl");
            return (Criteria) this;
        }

        public Criteria andRuleUrlBetween(String value1, String value2) {
            addCriterion("rule_url between", value1, value2, "ruleUrl");
            return (Criteria) this;
        }

        public Criteria andRuleUrlNotBetween(String value1, String value2) {
            addCriterion("rule_url not between", value1, value2, "ruleUrl");
            return (Criteria) this;
        }

        public Criteria andGuessGroupIsNull() {
            addCriterion("guess_group is null");
            return (Criteria) this;
        }

        public Criteria andGuessGroupIsNotNull() {
            addCriterion("guess_group is not null");
            return (Criteria) this;
        }

        public Criteria andGuessGroupEqualTo(String value) {
            addCriterion("guess_group =", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupNotEqualTo(String value) {
            addCriterion("guess_group <>", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupGreaterThan(String value) {
            addCriterion("guess_group >", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupGreaterThanOrEqualTo(String value) {
            addCriterion("guess_group >=", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupLessThan(String value) {
            addCriterion("guess_group <", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupLessThanOrEqualTo(String value) {
            addCriterion("guess_group <=", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupLike(String value) {
            addCriterion("guess_group like", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupNotLike(String value) {
            addCriterion("guess_group not like", value, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupIn(List<String> values) {
            addCriterion("guess_group in", values, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupNotIn(List<String> values) {
            addCriterion("guess_group not in", values, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupBetween(String value1, String value2) {
            addCriterion("guess_group between", value1, value2, "guessGroup");
            return (Criteria) this;
        }

        public Criteria andGuessGroupNotBetween(String value1, String value2) {
            addCriterion("guess_group not between", value1, value2, "guessGroup");
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

        public Criteria andContentIdIsNull() {
            addCriterion("content_id is null");
            return (Criteria) this;
        }

        public Criteria andContentIdIsNotNull() {
            addCriterion("content_id is not null");
            return (Criteria) this;
        }

        public Criteria andContentIdEqualTo(String value) {
            addCriterion("content_id =", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotEqualTo(String value) {
            addCriterion("content_id <>", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdGreaterThan(String value) {
            addCriterion("content_id >", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdGreaterThanOrEqualTo(String value) {
            addCriterion("content_id >=", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdLessThan(String value) {
            addCriterion("content_id <", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdLessThanOrEqualTo(String value) {
            addCriterion("content_id <=", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdLike(String value) {
            addCriterion("content_id like", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotLike(String value) {
            addCriterion("content_id not like", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdIn(List<String> values) {
            addCriterion("content_id in", values, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotIn(List<String> values) {
            addCriterion("content_id not in", values, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdBetween(String value1, String value2) {
            addCriterion("content_id between", value1, value2, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotBetween(String value1, String value2) {
            addCriterion("content_id not between", value1, value2, "contentId");
            return (Criteria) this;
        }

        public Criteria andShowTitleIsNull() {
            addCriterion("show_title is null");
            return (Criteria) this;
        }

        public Criteria andShowTitleIsNotNull() {
            addCriterion("show_title is not null");
            return (Criteria) this;
        }

        public Criteria andShowTitleEqualTo(String value) {
            addCriterion("show_title =", value, "showTitle");
            return (Criteria) this;
        }

        public Criteria andShowTitleNotEqualTo(String value) {
            addCriterion("show_title <>", value, "showTitle");
            return (Criteria) this;
        }

        public Criteria andShowTitleGreaterThan(String value) {
            addCriterion("show_title >", value, "showTitle");
            return (Criteria) this;
        }

        public Criteria andShowTitleGreaterThanOrEqualTo(String value) {
            addCriterion("show_title >=", value, "showTitle");
            return (Criteria) this;
        }

        public Criteria andShowTitleLessThan(String value) {
            addCriterion("show_title <", value, "showTitle");
            return (Criteria) this;
        }

        public Criteria andShowTitleLessThanOrEqualTo(String value) {
            addCriterion("show_title <=", value, "showTitle");
            return (Criteria) this;
        }

        public Criteria andShowTitleLike(String value) {
            addCriterion("show_title like", value, "showTitle");
            return (Criteria) this;
        }

        public Criteria andShowTitleNotLike(String value) {
            addCriterion("show_title not like", value, "showTitle");
            return (Criteria) this;
        }

        public Criteria andShowTitleIn(List<String> values) {
            addCriterion("show_title in", values, "showTitle");
            return (Criteria) this;
        }

        public Criteria andShowTitleNotIn(List<String> values) {
            addCriterion("show_title not in", values, "showTitle");
            return (Criteria) this;
        }

        public Criteria andShowTitleBetween(String value1, String value2) {
            addCriterion("show_title between", value1, value2, "showTitle");
            return (Criteria) this;
        }

        public Criteria andShowTitleNotBetween(String value1, String value2) {
            addCriterion("show_title not between", value1, value2, "showTitle");
            return (Criteria) this;
        }

        public Criteria andShowDescIsNull() {
            addCriterion("show_desc is null");
            return (Criteria) this;
        }

        public Criteria andShowDescIsNotNull() {
            addCriterion("show_desc is not null");
            return (Criteria) this;
        }

        public Criteria andShowDescEqualTo(String value) {
            addCriterion("show_desc =", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescNotEqualTo(String value) {
            addCriterion("show_desc <>", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescGreaterThan(String value) {
            addCriterion("show_desc >", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescGreaterThanOrEqualTo(String value) {
            addCriterion("show_desc >=", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescLessThan(String value) {
            addCriterion("show_desc <", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescLessThanOrEqualTo(String value) {
            addCriterion("show_desc <=", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescLike(String value) {
            addCriterion("show_desc like", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescNotLike(String value) {
            addCriterion("show_desc not like", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescIn(List<String> values) {
            addCriterion("show_desc in", values, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescNotIn(List<String> values) {
            addCriterion("show_desc not in", values, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescBetween(String value1, String value2) {
            addCriterion("show_desc between", value1, value2, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescNotBetween(String value1, String value2) {
            addCriterion("show_desc not between", value1, value2, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowImgIsNull() {
            addCriterion("show_img is null");
            return (Criteria) this;
        }

        public Criteria andShowImgIsNotNull() {
            addCriterion("show_img is not null");
            return (Criteria) this;
        }

        public Criteria andShowImgEqualTo(String value) {
            addCriterion("show_img =", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgNotEqualTo(String value) {
            addCriterion("show_img <>", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgGreaterThan(String value) {
            addCriterion("show_img >", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgGreaterThanOrEqualTo(String value) {
            addCriterion("show_img >=", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgLessThan(String value) {
            addCriterion("show_img <", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgLessThanOrEqualTo(String value) {
            addCriterion("show_img <=", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgLike(String value) {
            addCriterion("show_img like", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgNotLike(String value) {
            addCriterion("show_img not like", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgIn(List<String> values) {
            addCriterion("show_img in", values, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgNotIn(List<String> values) {
            addCriterion("show_img not in", values, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgBetween(String value1, String value2) {
            addCriterion("show_img between", value1, value2, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgNotBetween(String value1, String value2) {
            addCriterion("show_img not between", value1, value2, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowUrlIsNull() {
            addCriterion("show_url is null");
            return (Criteria) this;
        }

        public Criteria andShowUrlIsNotNull() {
            addCriterion("show_url is not null");
            return (Criteria) this;
        }

        public Criteria andShowUrlEqualTo(String value) {
            addCriterion("show_url =", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlNotEqualTo(String value) {
            addCriterion("show_url <>", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlGreaterThan(String value) {
            addCriterion("show_url >", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlGreaterThanOrEqualTo(String value) {
            addCriterion("show_url >=", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlLessThan(String value) {
            addCriterion("show_url <", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlLessThanOrEqualTo(String value) {
            addCriterion("show_url <=", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlLike(String value) {
            addCriterion("show_url like", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlNotLike(String value) {
            addCriterion("show_url not like", value, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlIn(List<String> values) {
            addCriterion("show_url in", values, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlNotIn(List<String> values) {
            addCriterion("show_url not in", values, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlBetween(String value1, String value2) {
            addCriterion("show_url between", value1, value2, "showUrl");
            return (Criteria) this;
        }

        public Criteria andShowUrlNotBetween(String value1, String value2) {
            addCriterion("show_url not between", value1, value2, "showUrl");
            return (Criteria) this;
        }

        public Criteria andToShopOnclickCountIsNull() {
            addCriterion("to_shop_onclick_count is null");
            return (Criteria) this;
        }

        public Criteria andToShopOnclickCountIsNotNull() {
            addCriterion("to_shop_onclick_count is not null");
            return (Criteria) this;
        }

        public Criteria andToShopOnclickCountEqualTo(Integer value) {
            addCriterion("to_shop_onclick_count =", value, "toShopOnclickCount");
            return (Criteria) this;
        }

        public Criteria andToShopOnclickCountNotEqualTo(Integer value) {
            addCriterion("to_shop_onclick_count <>", value, "toShopOnclickCount");
            return (Criteria) this;
        }

        public Criteria andToShopOnclickCountGreaterThan(Integer value) {
            addCriterion("to_shop_onclick_count >", value, "toShopOnclickCount");
            return (Criteria) this;
        }

        public Criteria andToShopOnclickCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("to_shop_onclick_count >=", value, "toShopOnclickCount");
            return (Criteria) this;
        }

        public Criteria andToShopOnclickCountLessThan(Integer value) {
            addCriterion("to_shop_onclick_count <", value, "toShopOnclickCount");
            return (Criteria) this;
        }

        public Criteria andToShopOnclickCountLessThanOrEqualTo(Integer value) {
            addCriterion("to_shop_onclick_count <=", value, "toShopOnclickCount");
            return (Criteria) this;
        }

        public Criteria andToShopOnclickCountIn(List<Integer> values) {
            addCriterion("to_shop_onclick_count in", values, "toShopOnclickCount");
            return (Criteria) this;
        }

        public Criteria andToShopOnclickCountNotIn(List<Integer> values) {
            addCriterion("to_shop_onclick_count not in", values, "toShopOnclickCount");
            return (Criteria) this;
        }

        public Criteria andToShopOnclickCountBetween(Integer value1, Integer value2) {
            addCriterion("to_shop_onclick_count between", value1, value2, "toShopOnclickCount");
            return (Criteria) this;
        }

        public Criteria andToShopOnclickCountNotBetween(Integer value1, Integer value2) {
            addCriterion("to_shop_onclick_count not between", value1, value2, "toShopOnclickCount");
            return (Criteria) this;
        }

        public Criteria andInitApplyCountIsNull() {
            addCriterion("init_apply_count is null");
            return (Criteria) this;
        }

        public Criteria andInitApplyCountIsNotNull() {
            addCriterion("init_apply_count is not null");
            return (Criteria) this;
        }

        public Criteria andInitApplyCountEqualTo(Integer value) {
            addCriterion("init_apply_count =", value, "initApplyCount");
            return (Criteria) this;
        }

        public Criteria andInitApplyCountNotEqualTo(Integer value) {
            addCriterion("init_apply_count <>", value, "initApplyCount");
            return (Criteria) this;
        }

        public Criteria andInitApplyCountGreaterThan(Integer value) {
            addCriterion("init_apply_count >", value, "initApplyCount");
            return (Criteria) this;
        }

        public Criteria andInitApplyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("init_apply_count >=", value, "initApplyCount");
            return (Criteria) this;
        }

        public Criteria andInitApplyCountLessThan(Integer value) {
            addCriterion("init_apply_count <", value, "initApplyCount");
            return (Criteria) this;
        }

        public Criteria andInitApplyCountLessThanOrEqualTo(Integer value) {
            addCriterion("init_apply_count <=", value, "initApplyCount");
            return (Criteria) this;
        }

        public Criteria andInitApplyCountIn(List<Integer> values) {
            addCriterion("init_apply_count in", values, "initApplyCount");
            return (Criteria) this;
        }

        public Criteria andInitApplyCountNotIn(List<Integer> values) {
            addCriterion("init_apply_count not in", values, "initApplyCount");
            return (Criteria) this;
        }

        public Criteria andInitApplyCountBetween(Integer value1, Integer value2) {
            addCriterion("init_apply_count between", value1, value2, "initApplyCount");
            return (Criteria) this;
        }

        public Criteria andInitApplyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("init_apply_count not between", value1, value2, "initApplyCount");
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