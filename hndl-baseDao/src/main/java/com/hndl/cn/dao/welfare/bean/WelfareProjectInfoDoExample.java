package com.hndl.cn.dao.welfare.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WelfareProjectInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public WelfareProjectInfoDoExample() {
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

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Long value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Long value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Long value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Long value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Long> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Long> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Long value1, Long value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("`state` like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("`state` not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andTitleListIsNull() {
            addCriterion("title_list is null");
            return (Criteria) this;
        }

        public Criteria andTitleListIsNotNull() {
            addCriterion("title_list is not null");
            return (Criteria) this;
        }

        public Criteria andTitleListEqualTo(String value) {
            addCriterion("title_list =", value, "titleList");
            return (Criteria) this;
        }

        public Criteria andTitleListNotEqualTo(String value) {
            addCriterion("title_list <>", value, "titleList");
            return (Criteria) this;
        }

        public Criteria andTitleListGreaterThan(String value) {
            addCriterion("title_list >", value, "titleList");
            return (Criteria) this;
        }

        public Criteria andTitleListGreaterThanOrEqualTo(String value) {
            addCriterion("title_list >=", value, "titleList");
            return (Criteria) this;
        }

        public Criteria andTitleListLessThan(String value) {
            addCriterion("title_list <", value, "titleList");
            return (Criteria) this;
        }

        public Criteria andTitleListLessThanOrEqualTo(String value) {
            addCriterion("title_list <=", value, "titleList");
            return (Criteria) this;
        }

        public Criteria andTitleListLike(String value) {
            addCriterion("title_list like", value, "titleList");
            return (Criteria) this;
        }

        public Criteria andTitleListNotLike(String value) {
            addCriterion("title_list not like", value, "titleList");
            return (Criteria) this;
        }

        public Criteria andTitleListIn(List<String> values) {
            addCriterion("title_list in", values, "titleList");
            return (Criteria) this;
        }

        public Criteria andTitleListNotIn(List<String> values) {
            addCriterion("title_list not in", values, "titleList");
            return (Criteria) this;
        }

        public Criteria andTitleListBetween(String value1, String value2) {
            addCriterion("title_list between", value1, value2, "titleList");
            return (Criteria) this;
        }

        public Criteria andTitleListNotBetween(String value1, String value2) {
            addCriterion("title_list not between", value1, value2, "titleList");
            return (Criteria) this;
        }

        public Criteria andTitleSubListIsNull() {
            addCriterion("title_sub_list is null");
            return (Criteria) this;
        }

        public Criteria andTitleSubListIsNotNull() {
            addCriterion("title_sub_list is not null");
            return (Criteria) this;
        }

        public Criteria andTitleSubListEqualTo(String value) {
            addCriterion("title_sub_list =", value, "titleSubList");
            return (Criteria) this;
        }

        public Criteria andTitleSubListNotEqualTo(String value) {
            addCriterion("title_sub_list <>", value, "titleSubList");
            return (Criteria) this;
        }

        public Criteria andTitleSubListGreaterThan(String value) {
            addCriterion("title_sub_list >", value, "titleSubList");
            return (Criteria) this;
        }

        public Criteria andTitleSubListGreaterThanOrEqualTo(String value) {
            addCriterion("title_sub_list >=", value, "titleSubList");
            return (Criteria) this;
        }

        public Criteria andTitleSubListLessThan(String value) {
            addCriterion("title_sub_list <", value, "titleSubList");
            return (Criteria) this;
        }

        public Criteria andTitleSubListLessThanOrEqualTo(String value) {
            addCriterion("title_sub_list <=", value, "titleSubList");
            return (Criteria) this;
        }

        public Criteria andTitleSubListLike(String value) {
            addCriterion("title_sub_list like", value, "titleSubList");
            return (Criteria) this;
        }

        public Criteria andTitleSubListNotLike(String value) {
            addCriterion("title_sub_list not like", value, "titleSubList");
            return (Criteria) this;
        }

        public Criteria andTitleSubListIn(List<String> values) {
            addCriterion("title_sub_list in", values, "titleSubList");
            return (Criteria) this;
        }

        public Criteria andTitleSubListNotIn(List<String> values) {
            addCriterion("title_sub_list not in", values, "titleSubList");
            return (Criteria) this;
        }

        public Criteria andTitleSubListBetween(String value1, String value2) {
            addCriterion("title_sub_list between", value1, value2, "titleSubList");
            return (Criteria) this;
        }

        public Criteria andTitleSubListNotBetween(String value1, String value2) {
            addCriterion("title_sub_list not between", value1, value2, "titleSubList");
            return (Criteria) this;
        }

        public Criteria andTitleOrgListIsNull() {
            addCriterion("title_org_list is null");
            return (Criteria) this;
        }

        public Criteria andTitleOrgListIsNotNull() {
            addCriterion("title_org_list is not null");
            return (Criteria) this;
        }

        public Criteria andTitleOrgListEqualTo(String value) {
            addCriterion("title_org_list =", value, "titleOrgList");
            return (Criteria) this;
        }

        public Criteria andTitleOrgListNotEqualTo(String value) {
            addCriterion("title_org_list <>", value, "titleOrgList");
            return (Criteria) this;
        }

        public Criteria andTitleOrgListGreaterThan(String value) {
            addCriterion("title_org_list >", value, "titleOrgList");
            return (Criteria) this;
        }

        public Criteria andTitleOrgListGreaterThanOrEqualTo(String value) {
            addCriterion("title_org_list >=", value, "titleOrgList");
            return (Criteria) this;
        }

        public Criteria andTitleOrgListLessThan(String value) {
            addCriterion("title_org_list <", value, "titleOrgList");
            return (Criteria) this;
        }

        public Criteria andTitleOrgListLessThanOrEqualTo(String value) {
            addCriterion("title_org_list <=", value, "titleOrgList");
            return (Criteria) this;
        }

        public Criteria andTitleOrgListLike(String value) {
            addCriterion("title_org_list like", value, "titleOrgList");
            return (Criteria) this;
        }

        public Criteria andTitleOrgListNotLike(String value) {
            addCriterion("title_org_list not like", value, "titleOrgList");
            return (Criteria) this;
        }

        public Criteria andTitleOrgListIn(List<String> values) {
            addCriterion("title_org_list in", values, "titleOrgList");
            return (Criteria) this;
        }

        public Criteria andTitleOrgListNotIn(List<String> values) {
            addCriterion("title_org_list not in", values, "titleOrgList");
            return (Criteria) this;
        }

        public Criteria andTitleOrgListBetween(String value1, String value2) {
            addCriterion("title_org_list between", value1, value2, "titleOrgList");
            return (Criteria) this;
        }

        public Criteria andTitleOrgListNotBetween(String value1, String value2) {
            addCriterion("title_org_list not between", value1, value2, "titleOrgList");
            return (Criteria) this;
        }

        public Criteria andTitleDetailIsNull() {
            addCriterion("title_detail is null");
            return (Criteria) this;
        }

        public Criteria andTitleDetailIsNotNull() {
            addCriterion("title_detail is not null");
            return (Criteria) this;
        }

        public Criteria andTitleDetailEqualTo(String value) {
            addCriterion("title_detail =", value, "titleDetail");
            return (Criteria) this;
        }

        public Criteria andTitleDetailNotEqualTo(String value) {
            addCriterion("title_detail <>", value, "titleDetail");
            return (Criteria) this;
        }

        public Criteria andTitleDetailGreaterThan(String value) {
            addCriterion("title_detail >", value, "titleDetail");
            return (Criteria) this;
        }

        public Criteria andTitleDetailGreaterThanOrEqualTo(String value) {
            addCriterion("title_detail >=", value, "titleDetail");
            return (Criteria) this;
        }

        public Criteria andTitleDetailLessThan(String value) {
            addCriterion("title_detail <", value, "titleDetail");
            return (Criteria) this;
        }

        public Criteria andTitleDetailLessThanOrEqualTo(String value) {
            addCriterion("title_detail <=", value, "titleDetail");
            return (Criteria) this;
        }

        public Criteria andTitleDetailLike(String value) {
            addCriterion("title_detail like", value, "titleDetail");
            return (Criteria) this;
        }

        public Criteria andTitleDetailNotLike(String value) {
            addCriterion("title_detail not like", value, "titleDetail");
            return (Criteria) this;
        }

        public Criteria andTitleDetailIn(List<String> values) {
            addCriterion("title_detail in", values, "titleDetail");
            return (Criteria) this;
        }

        public Criteria andTitleDetailNotIn(List<String> values) {
            addCriterion("title_detail not in", values, "titleDetail");
            return (Criteria) this;
        }

        public Criteria andTitleDetailBetween(String value1, String value2) {
            addCriterion("title_detail between", value1, value2, "titleDetail");
            return (Criteria) this;
        }

        public Criteria andTitleDetailNotBetween(String value1, String value2) {
            addCriterion("title_detail not between", value1, value2, "titleDetail");
            return (Criteria) this;
        }

        public Criteria andDescDetailIsNull() {
            addCriterion("desc_detail is null");
            return (Criteria) this;
        }

        public Criteria andDescDetailIsNotNull() {
            addCriterion("desc_detail is not null");
            return (Criteria) this;
        }

        public Criteria andDescDetailEqualTo(String value) {
            addCriterion("desc_detail =", value, "descDetail");
            return (Criteria) this;
        }

        public Criteria andDescDetailNotEqualTo(String value) {
            addCriterion("desc_detail <>", value, "descDetail");
            return (Criteria) this;
        }

        public Criteria andDescDetailGreaterThan(String value) {
            addCriterion("desc_detail >", value, "descDetail");
            return (Criteria) this;
        }

        public Criteria andDescDetailGreaterThanOrEqualTo(String value) {
            addCriterion("desc_detail >=", value, "descDetail");
            return (Criteria) this;
        }

        public Criteria andDescDetailLessThan(String value) {
            addCriterion("desc_detail <", value, "descDetail");
            return (Criteria) this;
        }

        public Criteria andDescDetailLessThanOrEqualTo(String value) {
            addCriterion("desc_detail <=", value, "descDetail");
            return (Criteria) this;
        }

        public Criteria andDescDetailLike(String value) {
            addCriterion("desc_detail like", value, "descDetail");
            return (Criteria) this;
        }

        public Criteria andDescDetailNotLike(String value) {
            addCriterion("desc_detail not like", value, "descDetail");
            return (Criteria) this;
        }

        public Criteria andDescDetailIn(List<String> values) {
            addCriterion("desc_detail in", values, "descDetail");
            return (Criteria) this;
        }

        public Criteria andDescDetailNotIn(List<String> values) {
            addCriterion("desc_detail not in", values, "descDetail");
            return (Criteria) this;
        }

        public Criteria andDescDetailBetween(String value1, String value2) {
            addCriterion("desc_detail between", value1, value2, "descDetail");
            return (Criteria) this;
        }

        public Criteria andDescDetailNotBetween(String value1, String value2) {
            addCriterion("desc_detail not between", value1, value2, "descDetail");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneIsNull() {
            addCriterion("author_phone is null");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneIsNotNull() {
            addCriterion("author_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneEqualTo(Long value) {
            addCriterion("author_phone =", value, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneNotEqualTo(Long value) {
            addCriterion("author_phone <>", value, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneGreaterThan(Long value) {
            addCriterion("author_phone >", value, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneGreaterThanOrEqualTo(Long value) {
            addCriterion("author_phone >=", value, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneLessThan(Long value) {
            addCriterion("author_phone <", value, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneLessThanOrEqualTo(Long value) {
            addCriterion("author_phone <=", value, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneIn(List<Long> values) {
            addCriterion("author_phone in", values, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneNotIn(List<Long> values) {
            addCriterion("author_phone not in", values, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneBetween(Long value1, Long value2) {
            addCriterion("author_phone between", value1, value2, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andAuthorPhoneNotBetween(Long value1, Long value2) {
            addCriterion("author_phone not between", value1, value2, "authorPhone");
            return (Criteria) this;
        }

        public Criteria andNowHeartIsNull() {
            addCriterion("now_heart is null");
            return (Criteria) this;
        }

        public Criteria andNowHeartIsNotNull() {
            addCriterion("now_heart is not null");
            return (Criteria) this;
        }

        public Criteria andNowHeartEqualTo(Long value) {
            addCriterion("now_heart =", value, "nowHeart");
            return (Criteria) this;
        }

        public Criteria andNowHeartNotEqualTo(Long value) {
            addCriterion("now_heart <>", value, "nowHeart");
            return (Criteria) this;
        }

        public Criteria andNowHeartGreaterThan(Long value) {
            addCriterion("now_heart >", value, "nowHeart");
            return (Criteria) this;
        }

        public Criteria andNowHeartGreaterThanOrEqualTo(Long value) {
            addCriterion("now_heart >=", value, "nowHeart");
            return (Criteria) this;
        }

        public Criteria andNowHeartLessThan(Long value) {
            addCriterion("now_heart <", value, "nowHeart");
            return (Criteria) this;
        }

        public Criteria andNowHeartLessThanOrEqualTo(Long value) {
            addCriterion("now_heart <=", value, "nowHeart");
            return (Criteria) this;
        }

        public Criteria andNowHeartIn(List<Long> values) {
            addCriterion("now_heart in", values, "nowHeart");
            return (Criteria) this;
        }

        public Criteria andNowHeartNotIn(List<Long> values) {
            addCriterion("now_heart not in", values, "nowHeart");
            return (Criteria) this;
        }

        public Criteria andNowHeartBetween(Long value1, Long value2) {
            addCriterion("now_heart between", value1, value2, "nowHeart");
            return (Criteria) this;
        }

        public Criteria andNowHeartNotBetween(Long value1, Long value2) {
            addCriterion("now_heart not between", value1, value2, "nowHeart");
            return (Criteria) this;
        }

        public Criteria andRemainHeartIsNull() {
            addCriterion("remain_heart is null");
            return (Criteria) this;
        }

        public Criteria andRemainHeartIsNotNull() {
            addCriterion("remain_heart is not null");
            return (Criteria) this;
        }

        public Criteria andRemainHeartEqualTo(Long value) {
            addCriterion("remain_heart =", value, "remainHeart");
            return (Criteria) this;
        }

        public Criteria andRemainHeartNotEqualTo(Long value) {
            addCriterion("remain_heart <>", value, "remainHeart");
            return (Criteria) this;
        }

        public Criteria andRemainHeartGreaterThan(Long value) {
            addCriterion("remain_heart >", value, "remainHeart");
            return (Criteria) this;
        }

        public Criteria andRemainHeartGreaterThanOrEqualTo(Long value) {
            addCriterion("remain_heart >=", value, "remainHeart");
            return (Criteria) this;
        }

        public Criteria andRemainHeartLessThan(Long value) {
            addCriterion("remain_heart <", value, "remainHeart");
            return (Criteria) this;
        }

        public Criteria andRemainHeartLessThanOrEqualTo(Long value) {
            addCriterion("remain_heart <=", value, "remainHeart");
            return (Criteria) this;
        }

        public Criteria andRemainHeartIn(List<Long> values) {
            addCriterion("remain_heart in", values, "remainHeart");
            return (Criteria) this;
        }

        public Criteria andRemainHeartNotIn(List<Long> values) {
            addCriterion("remain_heart not in", values, "remainHeart");
            return (Criteria) this;
        }

        public Criteria andRemainHeartBetween(Long value1, Long value2) {
            addCriterion("remain_heart between", value1, value2, "remainHeart");
            return (Criteria) this;
        }

        public Criteria andRemainHeartNotBetween(Long value1, Long value2) {
            addCriterion("remain_heart not between", value1, value2, "remainHeart");
            return (Criteria) this;
        }

        public Criteria andNowMoneyIsNull() {
            addCriterion("now_money is null");
            return (Criteria) this;
        }

        public Criteria andNowMoneyIsNotNull() {
            addCriterion("now_money is not null");
            return (Criteria) this;
        }

        public Criteria andNowMoneyEqualTo(Double value) {
            addCriterion("now_money =", value, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyNotEqualTo(Double value) {
            addCriterion("now_money <>", value, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyGreaterThan(Double value) {
            addCriterion("now_money >", value, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("now_money >=", value, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyLessThan(Double value) {
            addCriterion("now_money <", value, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyLessThanOrEqualTo(Double value) {
            addCriterion("now_money <=", value, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyIn(List<Double> values) {
            addCriterion("now_money in", values, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyNotIn(List<Double> values) {
            addCriterion("now_money not in", values, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyBetween(Double value1, Double value2) {
            addCriterion("now_money between", value1, value2, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNowMoneyNotBetween(Double value1, Double value2) {
            addCriterion("now_money not between", value1, value2, "nowMoney");
            return (Criteria) this;
        }

        public Criteria andNeedMoneyIsNull() {
            addCriterion("need_money is null");
            return (Criteria) this;
        }

        public Criteria andNeedMoneyIsNotNull() {
            addCriterion("need_money is not null");
            return (Criteria) this;
        }

        public Criteria andNeedMoneyEqualTo(Double value) {
            addCriterion("need_money =", value, "needMoney");
            return (Criteria) this;
        }

        public Criteria andNeedMoneyNotEqualTo(Double value) {
            addCriterion("need_money <>", value, "needMoney");
            return (Criteria) this;
        }

        public Criteria andNeedMoneyGreaterThan(Double value) {
            addCriterion("need_money >", value, "needMoney");
            return (Criteria) this;
        }

        public Criteria andNeedMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("need_money >=", value, "needMoney");
            return (Criteria) this;
        }

        public Criteria andNeedMoneyLessThan(Double value) {
            addCriterion("need_money <", value, "needMoney");
            return (Criteria) this;
        }

        public Criteria andNeedMoneyLessThanOrEqualTo(Double value) {
            addCriterion("need_money <=", value, "needMoney");
            return (Criteria) this;
        }

        public Criteria andNeedMoneyIn(List<Double> values) {
            addCriterion("need_money in", values, "needMoney");
            return (Criteria) this;
        }

        public Criteria andNeedMoneyNotIn(List<Double> values) {
            addCriterion("need_money not in", values, "needMoney");
            return (Criteria) this;
        }

        public Criteria andNeedMoneyBetween(Double value1, Double value2) {
            addCriterion("need_money between", value1, value2, "needMoney");
            return (Criteria) this;
        }

        public Criteria andNeedMoneyNotBetween(Double value1, Double value2) {
            addCriterion("need_money not between", value1, value2, "needMoney");
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

        public Criteria andDescribeToUrlIsNull() {
            addCriterion("describe_to_url is null");
            return (Criteria) this;
        }

        public Criteria andDescribeToUrlIsNotNull() {
            addCriterion("describe_to_url is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeToUrlEqualTo(String value) {
            addCriterion("describe_to_url =", value, "describeToUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeToUrlNotEqualTo(String value) {
            addCriterion("describe_to_url <>", value, "describeToUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeToUrlGreaterThan(String value) {
            addCriterion("describe_to_url >", value, "describeToUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeToUrlGreaterThanOrEqualTo(String value) {
            addCriterion("describe_to_url >=", value, "describeToUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeToUrlLessThan(String value) {
            addCriterion("describe_to_url <", value, "describeToUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeToUrlLessThanOrEqualTo(String value) {
            addCriterion("describe_to_url <=", value, "describeToUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeToUrlLike(String value) {
            addCriterion("describe_to_url like", value, "describeToUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeToUrlNotLike(String value) {
            addCriterion("describe_to_url not like", value, "describeToUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeToUrlIn(List<String> values) {
            addCriterion("describe_to_url in", values, "describeToUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeToUrlNotIn(List<String> values) {
            addCriterion("describe_to_url not in", values, "describeToUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeToUrlBetween(String value1, String value2) {
            addCriterion("describe_to_url between", value1, value2, "describeToUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeToUrlNotBetween(String value1, String value2) {
            addCriterion("describe_to_url not between", value1, value2, "describeToUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeTitleIsNull() {
            addCriterion("describe_title is null");
            return (Criteria) this;
        }

        public Criteria andDescribeTitleIsNotNull() {
            addCriterion("describe_title is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeTitleEqualTo(String value) {
            addCriterion("describe_title =", value, "describeTitle");
            return (Criteria) this;
        }

        public Criteria andDescribeTitleNotEqualTo(String value) {
            addCriterion("describe_title <>", value, "describeTitle");
            return (Criteria) this;
        }

        public Criteria andDescribeTitleGreaterThan(String value) {
            addCriterion("describe_title >", value, "describeTitle");
            return (Criteria) this;
        }

        public Criteria andDescribeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("describe_title >=", value, "describeTitle");
            return (Criteria) this;
        }

        public Criteria andDescribeTitleLessThan(String value) {
            addCriterion("describe_title <", value, "describeTitle");
            return (Criteria) this;
        }

        public Criteria andDescribeTitleLessThanOrEqualTo(String value) {
            addCriterion("describe_title <=", value, "describeTitle");
            return (Criteria) this;
        }

        public Criteria andDescribeTitleLike(String value) {
            addCriterion("describe_title like", value, "describeTitle");
            return (Criteria) this;
        }

        public Criteria andDescribeTitleNotLike(String value) {
            addCriterion("describe_title not like", value, "describeTitle");
            return (Criteria) this;
        }

        public Criteria andDescribeTitleIn(List<String> values) {
            addCriterion("describe_title in", values, "describeTitle");
            return (Criteria) this;
        }

        public Criteria andDescribeTitleNotIn(List<String> values) {
            addCriterion("describe_title not in", values, "describeTitle");
            return (Criteria) this;
        }

        public Criteria andDescribeTitleBetween(String value1, String value2) {
            addCriterion("describe_title between", value1, value2, "describeTitle");
            return (Criteria) this;
        }

        public Criteria andDescribeTitleNotBetween(String value1, String value2) {
            addCriterion("describe_title not between", value1, value2, "describeTitle");
            return (Criteria) this;
        }

        public Criteria andDescribeImgUrlIsNull() {
            addCriterion("describe_img_url is null");
            return (Criteria) this;
        }

        public Criteria andDescribeImgUrlIsNotNull() {
            addCriterion("describe_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeImgUrlEqualTo(String value) {
            addCriterion("describe_img_url =", value, "describeImgUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeImgUrlNotEqualTo(String value) {
            addCriterion("describe_img_url <>", value, "describeImgUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeImgUrlGreaterThan(String value) {
            addCriterion("describe_img_url >", value, "describeImgUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("describe_img_url >=", value, "describeImgUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeImgUrlLessThan(String value) {
            addCriterion("describe_img_url <", value, "describeImgUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeImgUrlLessThanOrEqualTo(String value) {
            addCriterion("describe_img_url <=", value, "describeImgUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeImgUrlLike(String value) {
            addCriterion("describe_img_url like", value, "describeImgUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeImgUrlNotLike(String value) {
            addCriterion("describe_img_url not like", value, "describeImgUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeImgUrlIn(List<String> values) {
            addCriterion("describe_img_url in", values, "describeImgUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeImgUrlNotIn(List<String> values) {
            addCriterion("describe_img_url not in", values, "describeImgUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeImgUrlBetween(String value1, String value2) {
            addCriterion("describe_img_url between", value1, value2, "describeImgUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeImgUrlNotBetween(String value1, String value2) {
            addCriterion("describe_img_url not between", value1, value2, "describeImgUrl");
            return (Criteria) this;
        }

        public Criteria andDescribeDescIsNull() {
            addCriterion("describe_desc is null");
            return (Criteria) this;
        }

        public Criteria andDescribeDescIsNotNull() {
            addCriterion("describe_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeDescEqualTo(String value) {
            addCriterion("describe_desc =", value, "describeDesc");
            return (Criteria) this;
        }

        public Criteria andDescribeDescNotEqualTo(String value) {
            addCriterion("describe_desc <>", value, "describeDesc");
            return (Criteria) this;
        }

        public Criteria andDescribeDescGreaterThan(String value) {
            addCriterion("describe_desc >", value, "describeDesc");
            return (Criteria) this;
        }

        public Criteria andDescribeDescGreaterThanOrEqualTo(String value) {
            addCriterion("describe_desc >=", value, "describeDesc");
            return (Criteria) this;
        }

        public Criteria andDescribeDescLessThan(String value) {
            addCriterion("describe_desc <", value, "describeDesc");
            return (Criteria) this;
        }

        public Criteria andDescribeDescLessThanOrEqualTo(String value) {
            addCriterion("describe_desc <=", value, "describeDesc");
            return (Criteria) this;
        }

        public Criteria andDescribeDescLike(String value) {
            addCriterion("describe_desc like", value, "describeDesc");
            return (Criteria) this;
        }

        public Criteria andDescribeDescNotLike(String value) {
            addCriterion("describe_desc not like", value, "describeDesc");
            return (Criteria) this;
        }

        public Criteria andDescribeDescIn(List<String> values) {
            addCriterion("describe_desc in", values, "describeDesc");
            return (Criteria) this;
        }

        public Criteria andDescribeDescNotIn(List<String> values) {
            addCriterion("describe_desc not in", values, "describeDesc");
            return (Criteria) this;
        }

        public Criteria andDescribeDescBetween(String value1, String value2) {
            addCriterion("describe_desc between", value1, value2, "describeDesc");
            return (Criteria) this;
        }

        public Criteria andDescribeDescNotBetween(String value1, String value2) {
            addCriterion("describe_desc not between", value1, value2, "describeDesc");
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

        public Criteria andOther2EqualTo(Integer value) {
            addCriterion("other2 =", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotEqualTo(Integer value) {
            addCriterion("other2 <>", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2GreaterThan(Integer value) {
            addCriterion("other2 >", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2GreaterThanOrEqualTo(Integer value) {
            addCriterion("other2 >=", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2LessThan(Integer value) {
            addCriterion("other2 <", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2LessThanOrEqualTo(Integer value) {
            addCriterion("other2 <=", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2In(List<Integer> values) {
            addCriterion("other2 in", values, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotIn(List<Integer> values) {
            addCriterion("other2 not in", values, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2Between(Integer value1, Integer value2) {
            addCriterion("other2 between", value1, value2, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotBetween(Integer value1, Integer value2) {
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