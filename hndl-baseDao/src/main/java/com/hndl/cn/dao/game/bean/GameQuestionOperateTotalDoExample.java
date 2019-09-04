package com.hndl.cn.dao.game.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameQuestionOperateTotalDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public GameQuestionOperateTotalDoExample() {
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

        public Criteria andThemeIdIsNull() {
            addCriterion("theme_id is null");
            return (Criteria) this;
        }

        public Criteria andThemeIdIsNotNull() {
            addCriterion("theme_id is not null");
            return (Criteria) this;
        }

        public Criteria andThemeIdEqualTo(Long value) {
            addCriterion("theme_id =", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdNotEqualTo(Long value) {
            addCriterion("theme_id <>", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdGreaterThan(Long value) {
            addCriterion("theme_id >", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("theme_id >=", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdLessThan(Long value) {
            addCriterion("theme_id <", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdLessThanOrEqualTo(Long value) {
            addCriterion("theme_id <=", value, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdIn(List<Long> values) {
            addCriterion("theme_id in", values, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdNotIn(List<Long> values) {
            addCriterion("theme_id not in", values, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdBetween(Long value1, Long value2) {
            addCriterion("theme_id between", value1, value2, "themeId");
            return (Criteria) this;
        }

        public Criteria andThemeIdNotBetween(Long value1, Long value2) {
            addCriterion("theme_id not between", value1, value2, "themeId");
            return (Criteria) this;
        }

        public Criteria andSumTotalIsNull() {
            addCriterion("sum_total is null");
            return (Criteria) this;
        }

        public Criteria andSumTotalIsNotNull() {
            addCriterion("sum_total is not null");
            return (Criteria) this;
        }

        public Criteria andSumTotalEqualTo(Integer value) {
            addCriterion("sum_total =", value, "sumTotal");
            return (Criteria) this;
        }

        public Criteria andSumTotalNotEqualTo(Integer value) {
            addCriterion("sum_total <>", value, "sumTotal");
            return (Criteria) this;
        }

        public Criteria andSumTotalGreaterThan(Integer value) {
            addCriterion("sum_total >", value, "sumTotal");
            return (Criteria) this;
        }

        public Criteria andSumTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("sum_total >=", value, "sumTotal");
            return (Criteria) this;
        }

        public Criteria andSumTotalLessThan(Integer value) {
            addCriterion("sum_total <", value, "sumTotal");
            return (Criteria) this;
        }

        public Criteria andSumTotalLessThanOrEqualTo(Integer value) {
            addCriterion("sum_total <=", value, "sumTotal");
            return (Criteria) this;
        }

        public Criteria andSumTotalIn(List<Integer> values) {
            addCriterion("sum_total in", values, "sumTotal");
            return (Criteria) this;
        }

        public Criteria andSumTotalNotIn(List<Integer> values) {
            addCriterion("sum_total not in", values, "sumTotal");
            return (Criteria) this;
        }

        public Criteria andSumTotalBetween(Integer value1, Integer value2) {
            addCriterion("sum_total between", value1, value2, "sumTotal");
            return (Criteria) this;
        }

        public Criteria andSumTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("sum_total not between", value1, value2, "sumTotal");
            return (Criteria) this;
        }

        public Criteria andLevelTotalIsNull() {
            addCriterion("level_total is null");
            return (Criteria) this;
        }

        public Criteria andLevelTotalIsNotNull() {
            addCriterion("level_total is not null");
            return (Criteria) this;
        }

        public Criteria andLevelTotalEqualTo(String value) {
            addCriterion("level_total =", value, "levelTotal");
            return (Criteria) this;
        }

        public Criteria andLevelTotalNotEqualTo(String value) {
            addCriterion("level_total <>", value, "levelTotal");
            return (Criteria) this;
        }

        public Criteria andLevelTotalGreaterThan(String value) {
            addCriterion("level_total >", value, "levelTotal");
            return (Criteria) this;
        }

        public Criteria andLevelTotalGreaterThanOrEqualTo(String value) {
            addCriterion("level_total >=", value, "levelTotal");
            return (Criteria) this;
        }

        public Criteria andLevelTotalLessThan(String value) {
            addCriterion("level_total <", value, "levelTotal");
            return (Criteria) this;
        }

        public Criteria andLevelTotalLessThanOrEqualTo(String value) {
            addCriterion("level_total <=", value, "levelTotal");
            return (Criteria) this;
        }

        public Criteria andLevelTotalLike(String value) {
            addCriterion("level_total like", value, "levelTotal");
            return (Criteria) this;
        }

        public Criteria andLevelTotalNotLike(String value) {
            addCriterion("level_total not like", value, "levelTotal");
            return (Criteria) this;
        }

        public Criteria andLevelTotalIn(List<String> values) {
            addCriterion("level_total in", values, "levelTotal");
            return (Criteria) this;
        }

        public Criteria andLevelTotalNotIn(List<String> values) {
            addCriterion("level_total not in", values, "levelTotal");
            return (Criteria) this;
        }

        public Criteria andLevelTotalBetween(String value1, String value2) {
            addCriterion("level_total between", value1, value2, "levelTotal");
            return (Criteria) this;
        }

        public Criteria andLevelTotalNotBetween(String value1, String value2) {
            addCriterion("level_total not between", value1, value2, "levelTotal");
            return (Criteria) this;
        }

        public Criteria andUserTimeIsNull() {
            addCriterion("user_time is null");
            return (Criteria) this;
        }

        public Criteria andUserTimeIsNotNull() {
            addCriterion("user_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserTimeEqualTo(Integer value) {
            addCriterion("user_time =", value, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeNotEqualTo(Integer value) {
            addCriterion("user_time <>", value, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeGreaterThan(Integer value) {
            addCriterion("user_time >", value, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_time >=", value, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeLessThan(Integer value) {
            addCriterion("user_time <", value, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeLessThanOrEqualTo(Integer value) {
            addCriterion("user_time <=", value, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeIn(List<Integer> values) {
            addCriterion("user_time in", values, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeNotIn(List<Integer> values) {
            addCriterion("user_time not in", values, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeBetween(Integer value1, Integer value2) {
            addCriterion("user_time between", value1, value2, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_time not between", value1, value2, "userTime");
            return (Criteria) this;
        }

        public Criteria andRigthCountIsNull() {
            addCriterion("rigth_count is null");
            return (Criteria) this;
        }

        public Criteria andRigthCountIsNotNull() {
            addCriterion("rigth_count is not null");
            return (Criteria) this;
        }

        public Criteria andRigthCountEqualTo(Integer value) {
            addCriterion("rigth_count =", value, "rigthCount");
            return (Criteria) this;
        }

        public Criteria andRigthCountNotEqualTo(Integer value) {
            addCriterion("rigth_count <>", value, "rigthCount");
            return (Criteria) this;
        }

        public Criteria andRigthCountGreaterThan(Integer value) {
            addCriterion("rigth_count >", value, "rigthCount");
            return (Criteria) this;
        }

        public Criteria andRigthCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("rigth_count >=", value, "rigthCount");
            return (Criteria) this;
        }

        public Criteria andRigthCountLessThan(Integer value) {
            addCriterion("rigth_count <", value, "rigthCount");
            return (Criteria) this;
        }

        public Criteria andRigthCountLessThanOrEqualTo(Integer value) {
            addCriterion("rigth_count <=", value, "rigthCount");
            return (Criteria) this;
        }

        public Criteria andRigthCountIn(List<Integer> values) {
            addCriterion("rigth_count in", values, "rigthCount");
            return (Criteria) this;
        }

        public Criteria andRigthCountNotIn(List<Integer> values) {
            addCriterion("rigth_count not in", values, "rigthCount");
            return (Criteria) this;
        }

        public Criteria andRigthCountBetween(Integer value1, Integer value2) {
            addCriterion("rigth_count between", value1, value2, "rigthCount");
            return (Criteria) this;
        }

        public Criteria andRigthCountNotBetween(Integer value1, Integer value2) {
            addCriterion("rigth_count not between", value1, value2, "rigthCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountIsNull() {
            addCriterion("error_count is null");
            return (Criteria) this;
        }

        public Criteria andErrorCountIsNotNull() {
            addCriterion("error_count is not null");
            return (Criteria) this;
        }

        public Criteria andErrorCountEqualTo(Integer value) {
            addCriterion("error_count =", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountNotEqualTo(Integer value) {
            addCriterion("error_count <>", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountGreaterThan(Integer value) {
            addCriterion("error_count >", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("error_count >=", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountLessThan(Integer value) {
            addCriterion("error_count <", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountLessThanOrEqualTo(Integer value) {
            addCriterion("error_count <=", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountIn(List<Integer> values) {
            addCriterion("error_count in", values, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountNotIn(List<Integer> values) {
            addCriterion("error_count not in", values, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountBetween(Integer value1, Integer value2) {
            addCriterion("error_count between", value1, value2, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountNotBetween(Integer value1, Integer value2) {
            addCriterion("error_count not between", value1, value2, "errorCount");
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

        public Criteria andAllCountEqualTo(Integer value) {
            addCriterion("all_count =", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotEqualTo(Integer value) {
            addCriterion("all_count <>", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountGreaterThan(Integer value) {
            addCriterion("all_count >", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_count >=", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountLessThan(Integer value) {
            addCriterion("all_count <", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountLessThanOrEqualTo(Integer value) {
            addCriterion("all_count <=", value, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountIn(List<Integer> values) {
            addCriterion("all_count in", values, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotIn(List<Integer> values) {
            addCriterion("all_count not in", values, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountBetween(Integer value1, Integer value2) {
            addCriterion("all_count between", value1, value2, "allCount");
            return (Criteria) this;
        }

        public Criteria andAllCountNotBetween(Integer value1, Integer value2) {
            addCriterion("all_count not between", value1, value2, "allCount");
            return (Criteria) this;
        }

        public Criteria andFriendCountIsNull() {
            addCriterion("friend_count is null");
            return (Criteria) this;
        }

        public Criteria andFriendCountIsNotNull() {
            addCriterion("friend_count is not null");
            return (Criteria) this;
        }

        public Criteria andFriendCountEqualTo(Integer value) {
            addCriterion("friend_count =", value, "friendCount");
            return (Criteria) this;
        }

        public Criteria andFriendCountNotEqualTo(Integer value) {
            addCriterion("friend_count <>", value, "friendCount");
            return (Criteria) this;
        }

        public Criteria andFriendCountGreaterThan(Integer value) {
            addCriterion("friend_count >", value, "friendCount");
            return (Criteria) this;
        }

        public Criteria andFriendCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("friend_count >=", value, "friendCount");
            return (Criteria) this;
        }

        public Criteria andFriendCountLessThan(Integer value) {
            addCriterion("friend_count <", value, "friendCount");
            return (Criteria) this;
        }

        public Criteria andFriendCountLessThanOrEqualTo(Integer value) {
            addCriterion("friend_count <=", value, "friendCount");
            return (Criteria) this;
        }

        public Criteria andFriendCountIn(List<Integer> values) {
            addCriterion("friend_count in", values, "friendCount");
            return (Criteria) this;
        }

        public Criteria andFriendCountNotIn(List<Integer> values) {
            addCriterion("friend_count not in", values, "friendCount");
            return (Criteria) this;
        }

        public Criteria andFriendCountBetween(Integer value1, Integer value2) {
            addCriterion("friend_count between", value1, value2, "friendCount");
            return (Criteria) this;
        }

        public Criteria andFriendCountNotBetween(Integer value1, Integer value2) {
            addCriterion("friend_count not between", value1, value2, "friendCount");
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