package com.hndl.cn.dao.common.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonActivityInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public CommonActivityInfoDoExample() {
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

        public Criteria andActivityNameIsNull() {
            addCriterion("activity_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNotNull() {
            addCriterion("activity_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNameEqualTo(String value) {
            addCriterion("activity_name =", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotEqualTo(String value) {
            addCriterion("activity_name <>", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThan(String value) {
            addCriterion("activity_name >", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_name >=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThan(String value) {
            addCriterion("activity_name <", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThanOrEqualTo(String value) {
            addCriterion("activity_name <=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLike(String value) {
            addCriterion("activity_name like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotLike(String value) {
            addCriterion("activity_name not like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameIn(List<String> values) {
            addCriterion("activity_name in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotIn(List<String> values) {
            addCriterion("activity_name not in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameBetween(String value1, String value2) {
            addCriterion("activity_name between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotBetween(String value1, String value2) {
            addCriterion("activity_name not between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNull() {
            addCriterion("subtitle is null");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNotNull() {
            addCriterion("subtitle is not null");
            return (Criteria) this;
        }

        public Criteria andSubtitleEqualTo(String value) {
            addCriterion("subtitle =", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotEqualTo(String value) {
            addCriterion("subtitle <>", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThan(String value) {
            addCriterion("subtitle >", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("subtitle >=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThan(String value) {
            addCriterion("subtitle <", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThanOrEqualTo(String value) {
            addCriterion("subtitle <=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLike(String value) {
            addCriterion("subtitle like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotLike(String value) {
            addCriterion("subtitle not like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleIn(List<String> values) {
            addCriterion("subtitle in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotIn(List<String> values) {
            addCriterion("subtitle not in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleBetween(String value1, String value2) {
            addCriterion("subtitle between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotBetween(String value1, String value2) {
            addCriterion("subtitle not between", value1, value2, "subtitle");
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

        public Criteria andActivityDescIsNull() {
            addCriterion("activity_desc is null");
            return (Criteria) this;
        }

        public Criteria andActivityDescIsNotNull() {
            addCriterion("activity_desc is not null");
            return (Criteria) this;
        }

        public Criteria andActivityDescEqualTo(String value) {
            addCriterion("activity_desc =", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescNotEqualTo(String value) {
            addCriterion("activity_desc <>", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescGreaterThan(String value) {
            addCriterion("activity_desc >", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescGreaterThanOrEqualTo(String value) {
            addCriterion("activity_desc >=", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescLessThan(String value) {
            addCriterion("activity_desc <", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescLessThanOrEqualTo(String value) {
            addCriterion("activity_desc <=", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescLike(String value) {
            addCriterion("activity_desc like", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescNotLike(String value) {
            addCriterion("activity_desc not like", value, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescIn(List<String> values) {
            addCriterion("activity_desc in", values, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescNotIn(List<String> values) {
            addCriterion("activity_desc not in", values, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescBetween(String value1, String value2) {
            addCriterion("activity_desc between", value1, value2, "activityDesc");
            return (Criteria) this;
        }

        public Criteria andActivityDescNotBetween(String value1, String value2) {
            addCriterion("activity_desc not between", value1, value2, "activityDesc");
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

        public Criteria andHttpUrlIsNull() {
            addCriterion("http_url is null");
            return (Criteria) this;
        }

        public Criteria andHttpUrlIsNotNull() {
            addCriterion("http_url is not null");
            return (Criteria) this;
        }

        public Criteria andHttpUrlEqualTo(String value) {
            addCriterion("http_url =", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlNotEqualTo(String value) {
            addCriterion("http_url <>", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlGreaterThan(String value) {
            addCriterion("http_url >", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlGreaterThanOrEqualTo(String value) {
            addCriterion("http_url >=", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlLessThan(String value) {
            addCriterion("http_url <", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlLessThanOrEqualTo(String value) {
            addCriterion("http_url <=", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlLike(String value) {
            addCriterion("http_url like", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlNotLike(String value) {
            addCriterion("http_url not like", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlIn(List<String> values) {
            addCriterion("http_url in", values, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlNotIn(List<String> values) {
            addCriterion("http_url not in", values, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlBetween(String value1, String value2) {
            addCriterion("http_url between", value1, value2, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlNotBetween(String value1, String value2) {
            addCriterion("http_url not between", value1, value2, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
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

        public Criteria andImgUrlMaxIsNull() {
            addCriterion("img_url_max is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlMaxIsNotNull() {
            addCriterion("img_url_max is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlMaxEqualTo(String value) {
            addCriterion("img_url_max =", value, "imgUrlMax");
            return (Criteria) this;
        }

        public Criteria andImgUrlMaxNotEqualTo(String value) {
            addCriterion("img_url_max <>", value, "imgUrlMax");
            return (Criteria) this;
        }

        public Criteria andImgUrlMaxGreaterThan(String value) {
            addCriterion("img_url_max >", value, "imgUrlMax");
            return (Criteria) this;
        }

        public Criteria andImgUrlMaxGreaterThanOrEqualTo(String value) {
            addCriterion("img_url_max >=", value, "imgUrlMax");
            return (Criteria) this;
        }

        public Criteria andImgUrlMaxLessThan(String value) {
            addCriterion("img_url_max <", value, "imgUrlMax");
            return (Criteria) this;
        }

        public Criteria andImgUrlMaxLessThanOrEqualTo(String value) {
            addCriterion("img_url_max <=", value, "imgUrlMax");
            return (Criteria) this;
        }

        public Criteria andImgUrlMaxLike(String value) {
            addCriterion("img_url_max like", value, "imgUrlMax");
            return (Criteria) this;
        }

        public Criteria andImgUrlMaxNotLike(String value) {
            addCriterion("img_url_max not like", value, "imgUrlMax");
            return (Criteria) this;
        }

        public Criteria andImgUrlMaxIn(List<String> values) {
            addCriterion("img_url_max in", values, "imgUrlMax");
            return (Criteria) this;
        }

        public Criteria andImgUrlMaxNotIn(List<String> values) {
            addCriterion("img_url_max not in", values, "imgUrlMax");
            return (Criteria) this;
        }

        public Criteria andImgUrlMaxBetween(String value1, String value2) {
            addCriterion("img_url_max between", value1, value2, "imgUrlMax");
            return (Criteria) this;
        }

        public Criteria andImgUrlMaxNotBetween(String value1, String value2) {
            addCriterion("img_url_max not between", value1, value2, "imgUrlMax");
            return (Criteria) this;
        }

        public Criteria andImgMaxIsNull() {
            addCriterion("img_Max is null");
            return (Criteria) this;
        }

        public Criteria andImgMaxIsNotNull() {
            addCriterion("img_Max is not null");
            return (Criteria) this;
        }

        public Criteria andImgMaxEqualTo(String value) {
            addCriterion("img_Max =", value, "imgMax");
            return (Criteria) this;
        }

        public Criteria andImgMaxNotEqualTo(String value) {
            addCriterion("img_Max <>", value, "imgMax");
            return (Criteria) this;
        }

        public Criteria andImgMaxGreaterThan(String value) {
            addCriterion("img_Max >", value, "imgMax");
            return (Criteria) this;
        }

        public Criteria andImgMaxGreaterThanOrEqualTo(String value) {
            addCriterion("img_Max >=", value, "imgMax");
            return (Criteria) this;
        }

        public Criteria andImgMaxLessThan(String value) {
            addCriterion("img_Max <", value, "imgMax");
            return (Criteria) this;
        }

        public Criteria andImgMaxLessThanOrEqualTo(String value) {
            addCriterion("img_Max <=", value, "imgMax");
            return (Criteria) this;
        }

        public Criteria andImgMaxLike(String value) {
            addCriterion("img_Max like", value, "imgMax");
            return (Criteria) this;
        }

        public Criteria andImgMaxNotLike(String value) {
            addCriterion("img_Max not like", value, "imgMax");
            return (Criteria) this;
        }

        public Criteria andImgMaxIn(List<String> values) {
            addCriterion("img_Max in", values, "imgMax");
            return (Criteria) this;
        }

        public Criteria andImgMaxNotIn(List<String> values) {
            addCriterion("img_Max not in", values, "imgMax");
            return (Criteria) this;
        }

        public Criteria andImgMaxBetween(String value1, String value2) {
            addCriterion("img_Max between", value1, value2, "imgMax");
            return (Criteria) this;
        }

        public Criteria andImgMaxNotBetween(String value1, String value2) {
            addCriterion("img_Max not between", value1, value2, "imgMax");
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

        public Criteria andImgNewUrl1IsNull() {
            addCriterion("img_new_url1 is null");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl1IsNotNull() {
            addCriterion("img_new_url1 is not null");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl1EqualTo(String value) {
            addCriterion("img_new_url1 =", value, "imgNewUrl1");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl1NotEqualTo(String value) {
            addCriterion("img_new_url1 <>", value, "imgNewUrl1");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl1GreaterThan(String value) {
            addCriterion("img_new_url1 >", value, "imgNewUrl1");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl1GreaterThanOrEqualTo(String value) {
            addCriterion("img_new_url1 >=", value, "imgNewUrl1");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl1LessThan(String value) {
            addCriterion("img_new_url1 <", value, "imgNewUrl1");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl1LessThanOrEqualTo(String value) {
            addCriterion("img_new_url1 <=", value, "imgNewUrl1");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl1Like(String value) {
            addCriterion("img_new_url1 like", value, "imgNewUrl1");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl1NotLike(String value) {
            addCriterion("img_new_url1 not like", value, "imgNewUrl1");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl1In(List<String> values) {
            addCriterion("img_new_url1 in", values, "imgNewUrl1");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl1NotIn(List<String> values) {
            addCriterion("img_new_url1 not in", values, "imgNewUrl1");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl1Between(String value1, String value2) {
            addCriterion("img_new_url1 between", value1, value2, "imgNewUrl1");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl1NotBetween(String value1, String value2) {
            addCriterion("img_new_url1 not between", value1, value2, "imgNewUrl1");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl2IsNull() {
            addCriterion("img_new_url2 is null");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl2IsNotNull() {
            addCriterion("img_new_url2 is not null");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl2EqualTo(String value) {
            addCriterion("img_new_url2 =", value, "imgNewUrl2");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl2NotEqualTo(String value) {
            addCriterion("img_new_url2 <>", value, "imgNewUrl2");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl2GreaterThan(String value) {
            addCriterion("img_new_url2 >", value, "imgNewUrl2");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl2GreaterThanOrEqualTo(String value) {
            addCriterion("img_new_url2 >=", value, "imgNewUrl2");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl2LessThan(String value) {
            addCriterion("img_new_url2 <", value, "imgNewUrl2");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl2LessThanOrEqualTo(String value) {
            addCriterion("img_new_url2 <=", value, "imgNewUrl2");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl2Like(String value) {
            addCriterion("img_new_url2 like", value, "imgNewUrl2");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl2NotLike(String value) {
            addCriterion("img_new_url2 not like", value, "imgNewUrl2");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl2In(List<String> values) {
            addCriterion("img_new_url2 in", values, "imgNewUrl2");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl2NotIn(List<String> values) {
            addCriterion("img_new_url2 not in", values, "imgNewUrl2");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl2Between(String value1, String value2) {
            addCriterion("img_new_url2 between", value1, value2, "imgNewUrl2");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl2NotBetween(String value1, String value2) {
            addCriterion("img_new_url2 not between", value1, value2, "imgNewUrl2");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl3IsNull() {
            addCriterion("img_new_url3 is null");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl3IsNotNull() {
            addCriterion("img_new_url3 is not null");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl3EqualTo(String value) {
            addCriterion("img_new_url3 =", value, "imgNewUrl3");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl3NotEqualTo(String value) {
            addCriterion("img_new_url3 <>", value, "imgNewUrl3");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl3GreaterThan(String value) {
            addCriterion("img_new_url3 >", value, "imgNewUrl3");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl3GreaterThanOrEqualTo(String value) {
            addCriterion("img_new_url3 >=", value, "imgNewUrl3");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl3LessThan(String value) {
            addCriterion("img_new_url3 <", value, "imgNewUrl3");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl3LessThanOrEqualTo(String value) {
            addCriterion("img_new_url3 <=", value, "imgNewUrl3");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl3Like(String value) {
            addCriterion("img_new_url3 like", value, "imgNewUrl3");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl3NotLike(String value) {
            addCriterion("img_new_url3 not like", value, "imgNewUrl3");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl3In(List<String> values) {
            addCriterion("img_new_url3 in", values, "imgNewUrl3");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl3NotIn(List<String> values) {
            addCriterion("img_new_url3 not in", values, "imgNewUrl3");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl3Between(String value1, String value2) {
            addCriterion("img_new_url3 between", value1, value2, "imgNewUrl3");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl3NotBetween(String value1, String value2) {
            addCriterion("img_new_url3 not between", value1, value2, "imgNewUrl3");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl4IsNull() {
            addCriterion("img_new_url4 is null");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl4IsNotNull() {
            addCriterion("img_new_url4 is not null");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl4EqualTo(String value) {
            addCriterion("img_new_url4 =", value, "imgNewUrl4");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl4NotEqualTo(String value) {
            addCriterion("img_new_url4 <>", value, "imgNewUrl4");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl4GreaterThan(String value) {
            addCriterion("img_new_url4 >", value, "imgNewUrl4");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl4GreaterThanOrEqualTo(String value) {
            addCriterion("img_new_url4 >=", value, "imgNewUrl4");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl4LessThan(String value) {
            addCriterion("img_new_url4 <", value, "imgNewUrl4");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl4LessThanOrEqualTo(String value) {
            addCriterion("img_new_url4 <=", value, "imgNewUrl4");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl4Like(String value) {
            addCriterion("img_new_url4 like", value, "imgNewUrl4");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl4NotLike(String value) {
            addCriterion("img_new_url4 not like", value, "imgNewUrl4");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl4In(List<String> values) {
            addCriterion("img_new_url4 in", values, "imgNewUrl4");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl4NotIn(List<String> values) {
            addCriterion("img_new_url4 not in", values, "imgNewUrl4");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl4Between(String value1, String value2) {
            addCriterion("img_new_url4 between", value1, value2, "imgNewUrl4");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl4NotBetween(String value1, String value2) {
            addCriterion("img_new_url4 not between", value1, value2, "imgNewUrl4");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl5IsNull() {
            addCriterion("img_new_url5 is null");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl5IsNotNull() {
            addCriterion("img_new_url5 is not null");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl5EqualTo(String value) {
            addCriterion("img_new_url5 =", value, "imgNewUrl5");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl5NotEqualTo(String value) {
            addCriterion("img_new_url5 <>", value, "imgNewUrl5");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl5GreaterThan(String value) {
            addCriterion("img_new_url5 >", value, "imgNewUrl5");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl5GreaterThanOrEqualTo(String value) {
            addCriterion("img_new_url5 >=", value, "imgNewUrl5");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl5LessThan(String value) {
            addCriterion("img_new_url5 <", value, "imgNewUrl5");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl5LessThanOrEqualTo(String value) {
            addCriterion("img_new_url5 <=", value, "imgNewUrl5");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl5Like(String value) {
            addCriterion("img_new_url5 like", value, "imgNewUrl5");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl5NotLike(String value) {
            addCriterion("img_new_url5 not like", value, "imgNewUrl5");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl5In(List<String> values) {
            addCriterion("img_new_url5 in", values, "imgNewUrl5");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl5NotIn(List<String> values) {
            addCriterion("img_new_url5 not in", values, "imgNewUrl5");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl5Between(String value1, String value2) {
            addCriterion("img_new_url5 between", value1, value2, "imgNewUrl5");
            return (Criteria) this;
        }

        public Criteria andImgNewUrl5NotBetween(String value1, String value2) {
            addCriterion("img_new_url5 not between", value1, value2, "imgNewUrl5");
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

        public Criteria andAdImgToType1IsNull() {
            addCriterion("ad_img_to_type1 is null");
            return (Criteria) this;
        }

        public Criteria andAdImgToType1IsNotNull() {
            addCriterion("ad_img_to_type1 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImgToType1EqualTo(String value) {
            addCriterion("ad_img_to_type1 =", value, "adImgToType1");
            return (Criteria) this;
        }

        public Criteria andAdImgToType1NotEqualTo(String value) {
            addCriterion("ad_img_to_type1 <>", value, "adImgToType1");
            return (Criteria) this;
        }

        public Criteria andAdImgToType1GreaterThan(String value) {
            addCriterion("ad_img_to_type1 >", value, "adImgToType1");
            return (Criteria) this;
        }

        public Criteria andAdImgToType1GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img_to_type1 >=", value, "adImgToType1");
            return (Criteria) this;
        }

        public Criteria andAdImgToType1LessThan(String value) {
            addCriterion("ad_img_to_type1 <", value, "adImgToType1");
            return (Criteria) this;
        }

        public Criteria andAdImgToType1LessThanOrEqualTo(String value) {
            addCriterion("ad_img_to_type1 <=", value, "adImgToType1");
            return (Criteria) this;
        }

        public Criteria andAdImgToType1Like(String value) {
            addCriterion("ad_img_to_type1 like", value, "adImgToType1");
            return (Criteria) this;
        }

        public Criteria andAdImgToType1NotLike(String value) {
            addCriterion("ad_img_to_type1 not like", value, "adImgToType1");
            return (Criteria) this;
        }

        public Criteria andAdImgToType1In(List<String> values) {
            addCriterion("ad_img_to_type1 in", values, "adImgToType1");
            return (Criteria) this;
        }

        public Criteria andAdImgToType1NotIn(List<String> values) {
            addCriterion("ad_img_to_type1 not in", values, "adImgToType1");
            return (Criteria) this;
        }

        public Criteria andAdImgToType1Between(String value1, String value2) {
            addCriterion("ad_img_to_type1 between", value1, value2, "adImgToType1");
            return (Criteria) this;
        }

        public Criteria andAdImgToType1NotBetween(String value1, String value2) {
            addCriterion("ad_img_to_type1 not between", value1, value2, "adImgToType1");
            return (Criteria) this;
        }

        public Criteria andAdImgToType2IsNull() {
            addCriterion("ad_img_to_type2 is null");
            return (Criteria) this;
        }

        public Criteria andAdImgToType2IsNotNull() {
            addCriterion("ad_img_to_type2 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImgToType2EqualTo(String value) {
            addCriterion("ad_img_to_type2 =", value, "adImgToType2");
            return (Criteria) this;
        }

        public Criteria andAdImgToType2NotEqualTo(String value) {
            addCriterion("ad_img_to_type2 <>", value, "adImgToType2");
            return (Criteria) this;
        }

        public Criteria andAdImgToType2GreaterThan(String value) {
            addCriterion("ad_img_to_type2 >", value, "adImgToType2");
            return (Criteria) this;
        }

        public Criteria andAdImgToType2GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img_to_type2 >=", value, "adImgToType2");
            return (Criteria) this;
        }

        public Criteria andAdImgToType2LessThan(String value) {
            addCriterion("ad_img_to_type2 <", value, "adImgToType2");
            return (Criteria) this;
        }

        public Criteria andAdImgToType2LessThanOrEqualTo(String value) {
            addCriterion("ad_img_to_type2 <=", value, "adImgToType2");
            return (Criteria) this;
        }

        public Criteria andAdImgToType2Like(String value) {
            addCriterion("ad_img_to_type2 like", value, "adImgToType2");
            return (Criteria) this;
        }

        public Criteria andAdImgToType2NotLike(String value) {
            addCriterion("ad_img_to_type2 not like", value, "adImgToType2");
            return (Criteria) this;
        }

        public Criteria andAdImgToType2In(List<String> values) {
            addCriterion("ad_img_to_type2 in", values, "adImgToType2");
            return (Criteria) this;
        }

        public Criteria andAdImgToType2NotIn(List<String> values) {
            addCriterion("ad_img_to_type2 not in", values, "adImgToType2");
            return (Criteria) this;
        }

        public Criteria andAdImgToType2Between(String value1, String value2) {
            addCriterion("ad_img_to_type2 between", value1, value2, "adImgToType2");
            return (Criteria) this;
        }

        public Criteria andAdImgToType2NotBetween(String value1, String value2) {
            addCriterion("ad_img_to_type2 not between", value1, value2, "adImgToType2");
            return (Criteria) this;
        }

        public Criteria andAdImgToType3IsNull() {
            addCriterion("ad_img_to_type3 is null");
            return (Criteria) this;
        }

        public Criteria andAdImgToType3IsNotNull() {
            addCriterion("ad_img_to_type3 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImgToType3EqualTo(String value) {
            addCriterion("ad_img_to_type3 =", value, "adImgToType3");
            return (Criteria) this;
        }

        public Criteria andAdImgToType3NotEqualTo(String value) {
            addCriterion("ad_img_to_type3 <>", value, "adImgToType3");
            return (Criteria) this;
        }

        public Criteria andAdImgToType3GreaterThan(String value) {
            addCriterion("ad_img_to_type3 >", value, "adImgToType3");
            return (Criteria) this;
        }

        public Criteria andAdImgToType3GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img_to_type3 >=", value, "adImgToType3");
            return (Criteria) this;
        }

        public Criteria andAdImgToType3LessThan(String value) {
            addCriterion("ad_img_to_type3 <", value, "adImgToType3");
            return (Criteria) this;
        }

        public Criteria andAdImgToType3LessThanOrEqualTo(String value) {
            addCriterion("ad_img_to_type3 <=", value, "adImgToType3");
            return (Criteria) this;
        }

        public Criteria andAdImgToType3Like(String value) {
            addCriterion("ad_img_to_type3 like", value, "adImgToType3");
            return (Criteria) this;
        }

        public Criteria andAdImgToType3NotLike(String value) {
            addCriterion("ad_img_to_type3 not like", value, "adImgToType3");
            return (Criteria) this;
        }

        public Criteria andAdImgToType3In(List<String> values) {
            addCriterion("ad_img_to_type3 in", values, "adImgToType3");
            return (Criteria) this;
        }

        public Criteria andAdImgToType3NotIn(List<String> values) {
            addCriterion("ad_img_to_type3 not in", values, "adImgToType3");
            return (Criteria) this;
        }

        public Criteria andAdImgToType3Between(String value1, String value2) {
            addCriterion("ad_img_to_type3 between", value1, value2, "adImgToType3");
            return (Criteria) this;
        }

        public Criteria andAdImgToType3NotBetween(String value1, String value2) {
            addCriterion("ad_img_to_type3 not between", value1, value2, "adImgToType3");
            return (Criteria) this;
        }

        public Criteria andAdImgToType4IsNull() {
            addCriterion("ad_img_to_type4 is null");
            return (Criteria) this;
        }

        public Criteria andAdImgToType4IsNotNull() {
            addCriterion("ad_img_to_type4 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImgToType4EqualTo(String value) {
            addCriterion("ad_img_to_type4 =", value, "adImgToType4");
            return (Criteria) this;
        }

        public Criteria andAdImgToType4NotEqualTo(String value) {
            addCriterion("ad_img_to_type4 <>", value, "adImgToType4");
            return (Criteria) this;
        }

        public Criteria andAdImgToType4GreaterThan(String value) {
            addCriterion("ad_img_to_type4 >", value, "adImgToType4");
            return (Criteria) this;
        }

        public Criteria andAdImgToType4GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img_to_type4 >=", value, "adImgToType4");
            return (Criteria) this;
        }

        public Criteria andAdImgToType4LessThan(String value) {
            addCriterion("ad_img_to_type4 <", value, "adImgToType4");
            return (Criteria) this;
        }

        public Criteria andAdImgToType4LessThanOrEqualTo(String value) {
            addCriterion("ad_img_to_type4 <=", value, "adImgToType4");
            return (Criteria) this;
        }

        public Criteria andAdImgToType4Like(String value) {
            addCriterion("ad_img_to_type4 like", value, "adImgToType4");
            return (Criteria) this;
        }

        public Criteria andAdImgToType4NotLike(String value) {
            addCriterion("ad_img_to_type4 not like", value, "adImgToType4");
            return (Criteria) this;
        }

        public Criteria andAdImgToType4In(List<String> values) {
            addCriterion("ad_img_to_type4 in", values, "adImgToType4");
            return (Criteria) this;
        }

        public Criteria andAdImgToType4NotIn(List<String> values) {
            addCriterion("ad_img_to_type4 not in", values, "adImgToType4");
            return (Criteria) this;
        }

        public Criteria andAdImgToType4Between(String value1, String value2) {
            addCriterion("ad_img_to_type4 between", value1, value2, "adImgToType4");
            return (Criteria) this;
        }

        public Criteria andAdImgToType4NotBetween(String value1, String value2) {
            addCriterion("ad_img_to_type4 not between", value1, value2, "adImgToType4");
            return (Criteria) this;
        }

        public Criteria andAdImgToType5IsNull() {
            addCriterion("ad_img_to_type5 is null");
            return (Criteria) this;
        }

        public Criteria andAdImgToType5IsNotNull() {
            addCriterion("ad_img_to_type5 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImgToType5EqualTo(String value) {
            addCriterion("ad_img_to_type5 =", value, "adImgToType5");
            return (Criteria) this;
        }

        public Criteria andAdImgToType5NotEqualTo(String value) {
            addCriterion("ad_img_to_type5 <>", value, "adImgToType5");
            return (Criteria) this;
        }

        public Criteria andAdImgToType5GreaterThan(String value) {
            addCriterion("ad_img_to_type5 >", value, "adImgToType5");
            return (Criteria) this;
        }

        public Criteria andAdImgToType5GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img_to_type5 >=", value, "adImgToType5");
            return (Criteria) this;
        }

        public Criteria andAdImgToType5LessThan(String value) {
            addCriterion("ad_img_to_type5 <", value, "adImgToType5");
            return (Criteria) this;
        }

        public Criteria andAdImgToType5LessThanOrEqualTo(String value) {
            addCriterion("ad_img_to_type5 <=", value, "adImgToType5");
            return (Criteria) this;
        }

        public Criteria andAdImgToType5Like(String value) {
            addCriterion("ad_img_to_type5 like", value, "adImgToType5");
            return (Criteria) this;
        }

        public Criteria andAdImgToType5NotLike(String value) {
            addCriterion("ad_img_to_type5 not like", value, "adImgToType5");
            return (Criteria) this;
        }

        public Criteria andAdImgToType5In(List<String> values) {
            addCriterion("ad_img_to_type5 in", values, "adImgToType5");
            return (Criteria) this;
        }

        public Criteria andAdImgToType5NotIn(List<String> values) {
            addCriterion("ad_img_to_type5 not in", values, "adImgToType5");
            return (Criteria) this;
        }

        public Criteria andAdImgToType5Between(String value1, String value2) {
            addCriterion("ad_img_to_type5 between", value1, value2, "adImgToType5");
            return (Criteria) this;
        }

        public Criteria andAdImgToType5NotBetween(String value1, String value2) {
            addCriterion("ad_img_to_type5 not between", value1, value2, "adImgToType5");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl1IsNull() {
            addCriterion("ad_img_to_url1 is null");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl1IsNotNull() {
            addCriterion("ad_img_to_url1 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl1EqualTo(String value) {
            addCriterion("ad_img_to_url1 =", value, "adImgToUrl1");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl1NotEqualTo(String value) {
            addCriterion("ad_img_to_url1 <>", value, "adImgToUrl1");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl1GreaterThan(String value) {
            addCriterion("ad_img_to_url1 >", value, "adImgToUrl1");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl1GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img_to_url1 >=", value, "adImgToUrl1");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl1LessThan(String value) {
            addCriterion("ad_img_to_url1 <", value, "adImgToUrl1");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl1LessThanOrEqualTo(String value) {
            addCriterion("ad_img_to_url1 <=", value, "adImgToUrl1");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl1Like(String value) {
            addCriterion("ad_img_to_url1 like", value, "adImgToUrl1");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl1NotLike(String value) {
            addCriterion("ad_img_to_url1 not like", value, "adImgToUrl1");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl1In(List<String> values) {
            addCriterion("ad_img_to_url1 in", values, "adImgToUrl1");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl1NotIn(List<String> values) {
            addCriterion("ad_img_to_url1 not in", values, "adImgToUrl1");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl1Between(String value1, String value2) {
            addCriterion("ad_img_to_url1 between", value1, value2, "adImgToUrl1");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl1NotBetween(String value1, String value2) {
            addCriterion("ad_img_to_url1 not between", value1, value2, "adImgToUrl1");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl2IsNull() {
            addCriterion("ad_img_to_url2 is null");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl2IsNotNull() {
            addCriterion("ad_img_to_url2 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl2EqualTo(String value) {
            addCriterion("ad_img_to_url2 =", value, "adImgToUrl2");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl2NotEqualTo(String value) {
            addCriterion("ad_img_to_url2 <>", value, "adImgToUrl2");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl2GreaterThan(String value) {
            addCriterion("ad_img_to_url2 >", value, "adImgToUrl2");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl2GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img_to_url2 >=", value, "adImgToUrl2");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl2LessThan(String value) {
            addCriterion("ad_img_to_url2 <", value, "adImgToUrl2");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl2LessThanOrEqualTo(String value) {
            addCriterion("ad_img_to_url2 <=", value, "adImgToUrl2");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl2Like(String value) {
            addCriterion("ad_img_to_url2 like", value, "adImgToUrl2");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl2NotLike(String value) {
            addCriterion("ad_img_to_url2 not like", value, "adImgToUrl2");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl2In(List<String> values) {
            addCriterion("ad_img_to_url2 in", values, "adImgToUrl2");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl2NotIn(List<String> values) {
            addCriterion("ad_img_to_url2 not in", values, "adImgToUrl2");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl2Between(String value1, String value2) {
            addCriterion("ad_img_to_url2 between", value1, value2, "adImgToUrl2");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl2NotBetween(String value1, String value2) {
            addCriterion("ad_img_to_url2 not between", value1, value2, "adImgToUrl2");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl3IsNull() {
            addCriterion("ad_img_to_url3 is null");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl3IsNotNull() {
            addCriterion("ad_img_to_url3 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl3EqualTo(String value) {
            addCriterion("ad_img_to_url3 =", value, "adImgToUrl3");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl3NotEqualTo(String value) {
            addCriterion("ad_img_to_url3 <>", value, "adImgToUrl3");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl3GreaterThan(String value) {
            addCriterion("ad_img_to_url3 >", value, "adImgToUrl3");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl3GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img_to_url3 >=", value, "adImgToUrl3");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl3LessThan(String value) {
            addCriterion("ad_img_to_url3 <", value, "adImgToUrl3");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl3LessThanOrEqualTo(String value) {
            addCriterion("ad_img_to_url3 <=", value, "adImgToUrl3");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl3Like(String value) {
            addCriterion("ad_img_to_url3 like", value, "adImgToUrl3");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl3NotLike(String value) {
            addCriterion("ad_img_to_url3 not like", value, "adImgToUrl3");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl3In(List<String> values) {
            addCriterion("ad_img_to_url3 in", values, "adImgToUrl3");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl3NotIn(List<String> values) {
            addCriterion("ad_img_to_url3 not in", values, "adImgToUrl3");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl3Between(String value1, String value2) {
            addCriterion("ad_img_to_url3 between", value1, value2, "adImgToUrl3");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl3NotBetween(String value1, String value2) {
            addCriterion("ad_img_to_url3 not between", value1, value2, "adImgToUrl3");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl4IsNull() {
            addCriterion("ad_img_to_url4 is null");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl4IsNotNull() {
            addCriterion("ad_img_to_url4 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl4EqualTo(String value) {
            addCriterion("ad_img_to_url4 =", value, "adImgToUrl4");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl4NotEqualTo(String value) {
            addCriterion("ad_img_to_url4 <>", value, "adImgToUrl4");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl4GreaterThan(String value) {
            addCriterion("ad_img_to_url4 >", value, "adImgToUrl4");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl4GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img_to_url4 >=", value, "adImgToUrl4");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl4LessThan(String value) {
            addCriterion("ad_img_to_url4 <", value, "adImgToUrl4");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl4LessThanOrEqualTo(String value) {
            addCriterion("ad_img_to_url4 <=", value, "adImgToUrl4");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl4Like(String value) {
            addCriterion("ad_img_to_url4 like", value, "adImgToUrl4");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl4NotLike(String value) {
            addCriterion("ad_img_to_url4 not like", value, "adImgToUrl4");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl4In(List<String> values) {
            addCriterion("ad_img_to_url4 in", values, "adImgToUrl4");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl4NotIn(List<String> values) {
            addCriterion("ad_img_to_url4 not in", values, "adImgToUrl4");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl4Between(String value1, String value2) {
            addCriterion("ad_img_to_url4 between", value1, value2, "adImgToUrl4");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl4NotBetween(String value1, String value2) {
            addCriterion("ad_img_to_url4 not between", value1, value2, "adImgToUrl4");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl5IsNull() {
            addCriterion("ad_img_to_url5 is null");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl5IsNotNull() {
            addCriterion("ad_img_to_url5 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl5EqualTo(String value) {
            addCriterion("ad_img_to_url5 =", value, "adImgToUrl5");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl5NotEqualTo(String value) {
            addCriterion("ad_img_to_url5 <>", value, "adImgToUrl5");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl5GreaterThan(String value) {
            addCriterion("ad_img_to_url5 >", value, "adImgToUrl5");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl5GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img_to_url5 >=", value, "adImgToUrl5");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl5LessThan(String value) {
            addCriterion("ad_img_to_url5 <", value, "adImgToUrl5");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl5LessThanOrEqualTo(String value) {
            addCriterion("ad_img_to_url5 <=", value, "adImgToUrl5");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl5Like(String value) {
            addCriterion("ad_img_to_url5 like", value, "adImgToUrl5");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl5NotLike(String value) {
            addCriterion("ad_img_to_url5 not like", value, "adImgToUrl5");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl5In(List<String> values) {
            addCriterion("ad_img_to_url5 in", values, "adImgToUrl5");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl5NotIn(List<String> values) {
            addCriterion("ad_img_to_url5 not in", values, "adImgToUrl5");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl5Between(String value1, String value2) {
            addCriterion("ad_img_to_url5 between", value1, value2, "adImgToUrl5");
            return (Criteria) this;
        }

        public Criteria andAdImgToUrl5NotBetween(String value1, String value2) {
            addCriterion("ad_img_to_url5 not between", value1, value2, "adImgToUrl5");
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