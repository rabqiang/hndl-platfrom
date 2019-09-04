package com.hndl.cn.dao.common.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CommonUserInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public CommonUserInfoDoExample() {
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

        public Criteria andNetTypeIsNull() {
            addCriterion("net_type is null");
            return (Criteria) this;
        }

        public Criteria andNetTypeIsNotNull() {
            addCriterion("net_type is not null");
            return (Criteria) this;
        }

        public Criteria andNetTypeEqualTo(String value) {
            addCriterion("net_type =", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeNotEqualTo(String value) {
            addCriterion("net_type <>", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeGreaterThan(String value) {
            addCriterion("net_type >", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeGreaterThanOrEqualTo(String value) {
            addCriterion("net_type >=", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeLessThan(String value) {
            addCriterion("net_type <", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeLessThanOrEqualTo(String value) {
            addCriterion("net_type <=", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeLike(String value) {
            addCriterion("net_type like", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeNotLike(String value) {
            addCriterion("net_type not like", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeIn(List<String> values) {
            addCriterion("net_type in", values, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeNotIn(List<String> values) {
            addCriterion("net_type not in", values, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeBetween(String value1, String value2) {
            addCriterion("net_type between", value1, value2, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeNotBetween(String value1, String value2) {
            addCriterion("net_type not between", value1, value2, "netType");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNull() {
            addCriterion("phone_num is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNotNull() {
            addCriterion("phone_num is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumEqualTo(String value) {
            addCriterion("phone_num =", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotEqualTo(String value) {
            addCriterion("phone_num <>", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThan(String value) {
            addCriterion("phone_num >", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("phone_num >=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThan(String value) {
            addCriterion("phone_num <", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("phone_num <=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLike(String value) {
            addCriterion("phone_num like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotLike(String value) {
            addCriterion("phone_num not like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIn(List<String> values) {
            addCriterion("phone_num in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotIn(List<String> values) {
            addCriterion("phone_num not in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumBetween(String value1, String value2) {
            addCriterion("phone_num between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotBetween(String value1, String value2) {
            addCriterion("phone_num not between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumPersonIsNull() {
            addCriterion("phone_num_person is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumPersonIsNotNull() {
            addCriterion("phone_num_person is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumPersonEqualTo(Long value) {
            addCriterion("phone_num_person =", value, "phoneNumPerson");
            return (Criteria) this;
        }

        public Criteria andPhoneNumPersonNotEqualTo(Long value) {
            addCriterion("phone_num_person <>", value, "phoneNumPerson");
            return (Criteria) this;
        }

        public Criteria andPhoneNumPersonGreaterThan(Long value) {
            addCriterion("phone_num_person >", value, "phoneNumPerson");
            return (Criteria) this;
        }

        public Criteria andPhoneNumPersonGreaterThanOrEqualTo(Long value) {
            addCriterion("phone_num_person >=", value, "phoneNumPerson");
            return (Criteria) this;
        }

        public Criteria andPhoneNumPersonLessThan(Long value) {
            addCriterion("phone_num_person <", value, "phoneNumPerson");
            return (Criteria) this;
        }

        public Criteria andPhoneNumPersonLessThanOrEqualTo(Long value) {
            addCriterion("phone_num_person <=", value, "phoneNumPerson");
            return (Criteria) this;
        }

        public Criteria andPhoneNumPersonIn(List<Long> values) {
            addCriterion("phone_num_person in", values, "phoneNumPerson");
            return (Criteria) this;
        }

        public Criteria andPhoneNumPersonNotIn(List<Long> values) {
            addCriterion("phone_num_person not in", values, "phoneNumPerson");
            return (Criteria) this;
        }

        public Criteria andPhoneNumPersonBetween(Long value1, Long value2) {
            addCriterion("phone_num_person between", value1, value2, "phoneNumPerson");
            return (Criteria) this;
        }

        public Criteria andPhoneNumPersonNotBetween(Long value1, Long value2) {
            addCriterion("phone_num_person not between", value1, value2, "phoneNumPerson");
            return (Criteria) this;
        }

        public Criteria andDynamicPasswordIsNull() {
            addCriterion("dynamic_password is null");
            return (Criteria) this;
        }

        public Criteria andDynamicPasswordIsNotNull() {
            addCriterion("dynamic_password is not null");
            return (Criteria) this;
        }

        public Criteria andDynamicPasswordEqualTo(String value) {
            addCriterion("dynamic_password =", value, "dynamicPassword");
            return (Criteria) this;
        }

        public Criteria andDynamicPasswordNotEqualTo(String value) {
            addCriterion("dynamic_password <>", value, "dynamicPassword");
            return (Criteria) this;
        }

        public Criteria andDynamicPasswordGreaterThan(String value) {
            addCriterion("dynamic_password >", value, "dynamicPassword");
            return (Criteria) this;
        }

        public Criteria andDynamicPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("dynamic_password >=", value, "dynamicPassword");
            return (Criteria) this;
        }

        public Criteria andDynamicPasswordLessThan(String value) {
            addCriterion("dynamic_password <", value, "dynamicPassword");
            return (Criteria) this;
        }

        public Criteria andDynamicPasswordLessThanOrEqualTo(String value) {
            addCriterion("dynamic_password <=", value, "dynamicPassword");
            return (Criteria) this;
        }

        public Criteria andDynamicPasswordLike(String value) {
            addCriterion("dynamic_password like", value, "dynamicPassword");
            return (Criteria) this;
        }

        public Criteria andDynamicPasswordNotLike(String value) {
            addCriterion("dynamic_password not like", value, "dynamicPassword");
            return (Criteria) this;
        }

        public Criteria andDynamicPasswordIn(List<String> values) {
            addCriterion("dynamic_password in", values, "dynamicPassword");
            return (Criteria) this;
        }

        public Criteria andDynamicPasswordNotIn(List<String> values) {
            addCriterion("dynamic_password not in", values, "dynamicPassword");
            return (Criteria) this;
        }

        public Criteria andDynamicPasswordBetween(String value1, String value2) {
            addCriterion("dynamic_password between", value1, value2, "dynamicPassword");
            return (Criteria) this;
        }

        public Criteria andDynamicPasswordNotBetween(String value1, String value2) {
            addCriterion("dynamic_password not between", value1, value2, "dynamicPassword");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("`password` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberLoginIsNull() {
            addCriterion("confirm_number_login is null");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberLoginIsNotNull() {
            addCriterion("confirm_number_login is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberLoginEqualTo(String value) {
            addCriterion("confirm_number_login =", value, "confirmNumberLogin");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberLoginNotEqualTo(String value) {
            addCriterion("confirm_number_login <>", value, "confirmNumberLogin");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberLoginGreaterThan(String value) {
            addCriterion("confirm_number_login >", value, "confirmNumberLogin");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberLoginGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_number_login >=", value, "confirmNumberLogin");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberLoginLessThan(String value) {
            addCriterion("confirm_number_login <", value, "confirmNumberLogin");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberLoginLessThanOrEqualTo(String value) {
            addCriterion("confirm_number_login <=", value, "confirmNumberLogin");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberLoginLike(String value) {
            addCriterion("confirm_number_login like", value, "confirmNumberLogin");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberLoginNotLike(String value) {
            addCriterion("confirm_number_login not like", value, "confirmNumberLogin");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberLoginIn(List<String> values) {
            addCriterion("confirm_number_login in", values, "confirmNumberLogin");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberLoginNotIn(List<String> values) {
            addCriterion("confirm_number_login not in", values, "confirmNumberLogin");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberLoginBetween(String value1, String value2) {
            addCriterion("confirm_number_login between", value1, value2, "confirmNumberLogin");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberLoginNotBetween(String value1, String value2) {
            addCriterion("confirm_number_login not between", value1, value2, "confirmNumberLogin");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberForgetIsNull() {
            addCriterion("confirm_number_forget is null");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberForgetIsNotNull() {
            addCriterion("confirm_number_forget is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberForgetEqualTo(String value) {
            addCriterion("confirm_number_forget =", value, "confirmNumberForget");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberForgetNotEqualTo(String value) {
            addCriterion("confirm_number_forget <>", value, "confirmNumberForget");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberForgetGreaterThan(String value) {
            addCriterion("confirm_number_forget >", value, "confirmNumberForget");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberForgetGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_number_forget >=", value, "confirmNumberForget");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberForgetLessThan(String value) {
            addCriterion("confirm_number_forget <", value, "confirmNumberForget");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberForgetLessThanOrEqualTo(String value) {
            addCriterion("confirm_number_forget <=", value, "confirmNumberForget");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberForgetLike(String value) {
            addCriterion("confirm_number_forget like", value, "confirmNumberForget");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberForgetNotLike(String value) {
            addCriterion("confirm_number_forget not like", value, "confirmNumberForget");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberForgetIn(List<String> values) {
            addCriterion("confirm_number_forget in", values, "confirmNumberForget");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberForgetNotIn(List<String> values) {
            addCriterion("confirm_number_forget not in", values, "confirmNumberForget");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberForgetBetween(String value1, String value2) {
            addCriterion("confirm_number_forget between", value1, value2, "confirmNumberForget");
            return (Criteria) this;
        }

        public Criteria andConfirmNumberForgetNotBetween(String value1, String value2) {
            addCriterion("confirm_number_forget not between", value1, value2, "confirmNumberForget");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNull() {
            addCriterion("is_vip is null");
            return (Criteria) this;
        }

        public Criteria andIsVipIsNotNull() {
            addCriterion("is_vip is not null");
            return (Criteria) this;
        }

        public Criteria andIsVipEqualTo(String value) {
            addCriterion("is_vip =", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotEqualTo(String value) {
            addCriterion("is_vip <>", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThan(String value) {
            addCriterion("is_vip >", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipGreaterThanOrEqualTo(String value) {
            addCriterion("is_vip >=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThan(String value) {
            addCriterion("is_vip <", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLessThanOrEqualTo(String value) {
            addCriterion("is_vip <=", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipLike(String value) {
            addCriterion("is_vip like", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotLike(String value) {
            addCriterion("is_vip not like", value, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipIn(List<String> values) {
            addCriterion("is_vip in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotIn(List<String> values) {
            addCriterion("is_vip not in", values, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipBetween(String value1, String value2) {
            addCriterion("is_vip between", value1, value2, "isVip");
            return (Criteria) this;
        }

        public Criteria andIsVipNotBetween(String value1, String value2) {
            addCriterion("is_vip not between", value1, value2, "isVip");
            return (Criteria) this;
        }

        public Criteria andVipTypeIsNull() {
            addCriterion("vip_type is null");
            return (Criteria) this;
        }

        public Criteria andVipTypeIsNotNull() {
            addCriterion("vip_type is not null");
            return (Criteria) this;
        }

        public Criteria andVipTypeEqualTo(String value) {
            addCriterion("vip_type =", value, "vipType");
            return (Criteria) this;
        }

        public Criteria andVipTypeNotEqualTo(String value) {
            addCriterion("vip_type <>", value, "vipType");
            return (Criteria) this;
        }

        public Criteria andVipTypeGreaterThan(String value) {
            addCriterion("vip_type >", value, "vipType");
            return (Criteria) this;
        }

        public Criteria andVipTypeGreaterThanOrEqualTo(String value) {
            addCriterion("vip_type >=", value, "vipType");
            return (Criteria) this;
        }

        public Criteria andVipTypeLessThan(String value) {
            addCriterion("vip_type <", value, "vipType");
            return (Criteria) this;
        }

        public Criteria andVipTypeLessThanOrEqualTo(String value) {
            addCriterion("vip_type <=", value, "vipType");
            return (Criteria) this;
        }

        public Criteria andVipTypeLike(String value) {
            addCriterion("vip_type like", value, "vipType");
            return (Criteria) this;
        }

        public Criteria andVipTypeNotLike(String value) {
            addCriterion("vip_type not like", value, "vipType");
            return (Criteria) this;
        }

        public Criteria andVipTypeIn(List<String> values) {
            addCriterion("vip_type in", values, "vipType");
            return (Criteria) this;
        }

        public Criteria andVipTypeNotIn(List<String> values) {
            addCriterion("vip_type not in", values, "vipType");
            return (Criteria) this;
        }

        public Criteria andVipTypeBetween(String value1, String value2) {
            addCriterion("vip_type between", value1, value2, "vipType");
            return (Criteria) this;
        }

        public Criteria andVipTypeNotBetween(String value1, String value2) {
            addCriterion("vip_type not between", value1, value2, "vipType");
            return (Criteria) this;
        }

        public Criteria andVipStartDateIsNull() {
            addCriterion("vip_start_date is null");
            return (Criteria) this;
        }

        public Criteria andVipStartDateIsNotNull() {
            addCriterion("vip_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andVipStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("vip_start_date =", value, "vipStartDate");
            return (Criteria) this;
        }

        public Criteria andVipStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("vip_start_date <>", value, "vipStartDate");
            return (Criteria) this;
        }

        public Criteria andVipStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("vip_start_date >", value, "vipStartDate");
            return (Criteria) this;
        }

        public Criteria andVipStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("vip_start_date >=", value, "vipStartDate");
            return (Criteria) this;
        }

        public Criteria andVipStartDateLessThan(Date value) {
            addCriterionForJDBCDate("vip_start_date <", value, "vipStartDate");
            return (Criteria) this;
        }

        public Criteria andVipStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("vip_start_date <=", value, "vipStartDate");
            return (Criteria) this;
        }

        public Criteria andVipStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("vip_start_date in", values, "vipStartDate");
            return (Criteria) this;
        }

        public Criteria andVipStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("vip_start_date not in", values, "vipStartDate");
            return (Criteria) this;
        }

        public Criteria andVipStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("vip_start_date between", value1, value2, "vipStartDate");
            return (Criteria) this;
        }

        public Criteria andVipStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("vip_start_date not between", value1, value2, "vipStartDate");
            return (Criteria) this;
        }

        public Criteria andVipEndDateIsNull() {
            addCriterion("vip_end_date is null");
            return (Criteria) this;
        }

        public Criteria andVipEndDateIsNotNull() {
            addCriterion("vip_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andVipEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("vip_end_date =", value, "vipEndDate");
            return (Criteria) this;
        }

        public Criteria andVipEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("vip_end_date <>", value, "vipEndDate");
            return (Criteria) this;
        }

        public Criteria andVipEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("vip_end_date >", value, "vipEndDate");
            return (Criteria) this;
        }

        public Criteria andVipEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("vip_end_date >=", value, "vipEndDate");
            return (Criteria) this;
        }

        public Criteria andVipEndDateLessThan(Date value) {
            addCriterionForJDBCDate("vip_end_date <", value, "vipEndDate");
            return (Criteria) this;
        }

        public Criteria andVipEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("vip_end_date <=", value, "vipEndDate");
            return (Criteria) this;
        }

        public Criteria andVipEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("vip_end_date in", values, "vipEndDate");
            return (Criteria) this;
        }

        public Criteria andVipEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("vip_end_date not in", values, "vipEndDate");
            return (Criteria) this;
        }

        public Criteria andVipEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("vip_end_date between", value1, value2, "vipEndDate");
            return (Criteria) this;
        }

        public Criteria andVipEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("vip_end_date not between", value1, value2, "vipEndDate");
            return (Criteria) this;
        }

        public Criteria andIsFirstGameWinIsNull() {
            addCriterion("is_first_game_win is null");
            return (Criteria) this;
        }

        public Criteria andIsFirstGameWinIsNotNull() {
            addCriterion("is_first_game_win is not null");
            return (Criteria) this;
        }

        public Criteria andIsFirstGameWinEqualTo(String value) {
            addCriterion("is_first_game_win =", value, "isFirstGameWin");
            return (Criteria) this;
        }

        public Criteria andIsFirstGameWinNotEqualTo(String value) {
            addCriterion("is_first_game_win <>", value, "isFirstGameWin");
            return (Criteria) this;
        }

        public Criteria andIsFirstGameWinGreaterThan(String value) {
            addCriterion("is_first_game_win >", value, "isFirstGameWin");
            return (Criteria) this;
        }

        public Criteria andIsFirstGameWinGreaterThanOrEqualTo(String value) {
            addCriterion("is_first_game_win >=", value, "isFirstGameWin");
            return (Criteria) this;
        }

        public Criteria andIsFirstGameWinLessThan(String value) {
            addCriterion("is_first_game_win <", value, "isFirstGameWin");
            return (Criteria) this;
        }

        public Criteria andIsFirstGameWinLessThanOrEqualTo(String value) {
            addCriterion("is_first_game_win <=", value, "isFirstGameWin");
            return (Criteria) this;
        }

        public Criteria andIsFirstGameWinLike(String value) {
            addCriterion("is_first_game_win like", value, "isFirstGameWin");
            return (Criteria) this;
        }

        public Criteria andIsFirstGameWinNotLike(String value) {
            addCriterion("is_first_game_win not like", value, "isFirstGameWin");
            return (Criteria) this;
        }

        public Criteria andIsFirstGameWinIn(List<String> values) {
            addCriterion("is_first_game_win in", values, "isFirstGameWin");
            return (Criteria) this;
        }

        public Criteria andIsFirstGameWinNotIn(List<String> values) {
            addCriterion("is_first_game_win not in", values, "isFirstGameWin");
            return (Criteria) this;
        }

        public Criteria andIsFirstGameWinBetween(String value1, String value2) {
            addCriterion("is_first_game_win between", value1, value2, "isFirstGameWin");
            return (Criteria) this;
        }

        public Criteria andIsFirstGameWinNotBetween(String value1, String value2) {
            addCriterion("is_first_game_win not between", value1, value2, "isFirstGameWin");
            return (Criteria) this;
        }

        public Criteria andImsSignTotalDayIsNull() {
            addCriterion("ims_sign_total_day is null");
            return (Criteria) this;
        }

        public Criteria andImsSignTotalDayIsNotNull() {
            addCriterion("ims_sign_total_day is not null");
            return (Criteria) this;
        }

        public Criteria andImsSignTotalDayEqualTo(Integer value) {
            addCriterion("ims_sign_total_day =", value, "imsSignTotalDay");
            return (Criteria) this;
        }

        public Criteria andImsSignTotalDayNotEqualTo(Integer value) {
            addCriterion("ims_sign_total_day <>", value, "imsSignTotalDay");
            return (Criteria) this;
        }

        public Criteria andImsSignTotalDayGreaterThan(Integer value) {
            addCriterion("ims_sign_total_day >", value, "imsSignTotalDay");
            return (Criteria) this;
        }

        public Criteria andImsSignTotalDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("ims_sign_total_day >=", value, "imsSignTotalDay");
            return (Criteria) this;
        }

        public Criteria andImsSignTotalDayLessThan(Integer value) {
            addCriterion("ims_sign_total_day <", value, "imsSignTotalDay");
            return (Criteria) this;
        }

        public Criteria andImsSignTotalDayLessThanOrEqualTo(Integer value) {
            addCriterion("ims_sign_total_day <=", value, "imsSignTotalDay");
            return (Criteria) this;
        }

        public Criteria andImsSignTotalDayIn(List<Integer> values) {
            addCriterion("ims_sign_total_day in", values, "imsSignTotalDay");
            return (Criteria) this;
        }

        public Criteria andImsSignTotalDayNotIn(List<Integer> values) {
            addCriterion("ims_sign_total_day not in", values, "imsSignTotalDay");
            return (Criteria) this;
        }

        public Criteria andImsSignTotalDayBetween(Integer value1, Integer value2) {
            addCriterion("ims_sign_total_day between", value1, value2, "imsSignTotalDay");
            return (Criteria) this;
        }

        public Criteria andImsSignTotalDayNotBetween(Integer value1, Integer value2) {
            addCriterion("ims_sign_total_day not between", value1, value2, "imsSignTotalDay");
            return (Criteria) this;
        }

        public Criteria andImsSignContinueDayIsNull() {
            addCriterion("ims_sign_continue_day is null");
            return (Criteria) this;
        }

        public Criteria andImsSignContinueDayIsNotNull() {
            addCriterion("ims_sign_continue_day is not null");
            return (Criteria) this;
        }

        public Criteria andImsSignContinueDayEqualTo(Integer value) {
            addCriterion("ims_sign_continue_day =", value, "imsSignContinueDay");
            return (Criteria) this;
        }

        public Criteria andImsSignContinueDayNotEqualTo(Integer value) {
            addCriterion("ims_sign_continue_day <>", value, "imsSignContinueDay");
            return (Criteria) this;
        }

        public Criteria andImsSignContinueDayGreaterThan(Integer value) {
            addCriterion("ims_sign_continue_day >", value, "imsSignContinueDay");
            return (Criteria) this;
        }

        public Criteria andImsSignContinueDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("ims_sign_continue_day >=", value, "imsSignContinueDay");
            return (Criteria) this;
        }

        public Criteria andImsSignContinueDayLessThan(Integer value) {
            addCriterion("ims_sign_continue_day <", value, "imsSignContinueDay");
            return (Criteria) this;
        }

        public Criteria andImsSignContinueDayLessThanOrEqualTo(Integer value) {
            addCriterion("ims_sign_continue_day <=", value, "imsSignContinueDay");
            return (Criteria) this;
        }

        public Criteria andImsSignContinueDayIn(List<Integer> values) {
            addCriterion("ims_sign_continue_day in", values, "imsSignContinueDay");
            return (Criteria) this;
        }

        public Criteria andImsSignContinueDayNotIn(List<Integer> values) {
            addCriterion("ims_sign_continue_day not in", values, "imsSignContinueDay");
            return (Criteria) this;
        }

        public Criteria andImsSignContinueDayBetween(Integer value1, Integer value2) {
            addCriterion("ims_sign_continue_day between", value1, value2, "imsSignContinueDay");
            return (Criteria) this;
        }

        public Criteria andImsSignContinueDayNotBetween(Integer value1, Integer value2) {
            addCriterion("ims_sign_continue_day not between", value1, value2, "imsSignContinueDay");
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

        public Criteria andPersonNameIsNull() {
            addCriterion("person_name is null");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNotNull() {
            addCriterion("person_name is not null");
            return (Criteria) this;
        }

        public Criteria andPersonNameEqualTo(String value) {
            addCriterion("person_name =", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotEqualTo(String value) {
            addCriterion("person_name <>", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThan(String value) {
            addCriterion("person_name >", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("person_name >=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThan(String value) {
            addCriterion("person_name <", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThanOrEqualTo(String value) {
            addCriterion("person_name <=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLike(String value) {
            addCriterion("person_name like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotLike(String value) {
            addCriterion("person_name not like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameIn(List<String> values) {
            addCriterion("person_name in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotIn(List<String> values) {
            addCriterion("person_name not in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameBetween(String value1, String value2) {
            addCriterion("person_name between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotBetween(String value1, String value2) {
            addCriterion("person_name not between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPrizeGivePhoneIsNull() {
            addCriterion("prize_give_phone is null");
            return (Criteria) this;
        }

        public Criteria andPrizeGivePhoneIsNotNull() {
            addCriterion("prize_give_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeGivePhoneEqualTo(String value) {
            addCriterion("prize_give_phone =", value, "prizeGivePhone");
            return (Criteria) this;
        }

        public Criteria andPrizeGivePhoneNotEqualTo(String value) {
            addCriterion("prize_give_phone <>", value, "prizeGivePhone");
            return (Criteria) this;
        }

        public Criteria andPrizeGivePhoneGreaterThan(String value) {
            addCriterion("prize_give_phone >", value, "prizeGivePhone");
            return (Criteria) this;
        }

        public Criteria andPrizeGivePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("prize_give_phone >=", value, "prizeGivePhone");
            return (Criteria) this;
        }

        public Criteria andPrizeGivePhoneLessThan(String value) {
            addCriterion("prize_give_phone <", value, "prizeGivePhone");
            return (Criteria) this;
        }

        public Criteria andPrizeGivePhoneLessThanOrEqualTo(String value) {
            addCriterion("prize_give_phone <=", value, "prizeGivePhone");
            return (Criteria) this;
        }

        public Criteria andPrizeGivePhoneLike(String value) {
            addCriterion("prize_give_phone like", value, "prizeGivePhone");
            return (Criteria) this;
        }

        public Criteria andPrizeGivePhoneNotLike(String value) {
            addCriterion("prize_give_phone not like", value, "prizeGivePhone");
            return (Criteria) this;
        }

        public Criteria andPrizeGivePhoneIn(List<String> values) {
            addCriterion("prize_give_phone in", values, "prizeGivePhone");
            return (Criteria) this;
        }

        public Criteria andPrizeGivePhoneNotIn(List<String> values) {
            addCriterion("prize_give_phone not in", values, "prizeGivePhone");
            return (Criteria) this;
        }

        public Criteria andPrizeGivePhoneBetween(String value1, String value2) {
            addCriterion("prize_give_phone between", value1, value2, "prizeGivePhone");
            return (Criteria) this;
        }

        public Criteria andPrizeGivePhoneNotBetween(String value1, String value2) {
            addCriterion("prize_give_phone not between", value1, value2, "prizeGivePhone");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMaxIsNull() {
            addCriterion("person_img_url_max is null");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMaxIsNotNull() {
            addCriterion("person_img_url_max is not null");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMaxEqualTo(String value) {
            addCriterion("person_img_url_max =", value, "personImgUrlMax");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMaxNotEqualTo(String value) {
            addCriterion("person_img_url_max <>", value, "personImgUrlMax");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMaxGreaterThan(String value) {
            addCriterion("person_img_url_max >", value, "personImgUrlMax");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMaxGreaterThanOrEqualTo(String value) {
            addCriterion("person_img_url_max >=", value, "personImgUrlMax");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMaxLessThan(String value) {
            addCriterion("person_img_url_max <", value, "personImgUrlMax");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMaxLessThanOrEqualTo(String value) {
            addCriterion("person_img_url_max <=", value, "personImgUrlMax");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMaxLike(String value) {
            addCriterion("person_img_url_max like", value, "personImgUrlMax");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMaxNotLike(String value) {
            addCriterion("person_img_url_max not like", value, "personImgUrlMax");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMaxIn(List<String> values) {
            addCriterion("person_img_url_max in", values, "personImgUrlMax");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMaxNotIn(List<String> values) {
            addCriterion("person_img_url_max not in", values, "personImgUrlMax");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMaxBetween(String value1, String value2) {
            addCriterion("person_img_url_max between", value1, value2, "personImgUrlMax");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMaxNotBetween(String value1, String value2) {
            addCriterion("person_img_url_max not between", value1, value2, "personImgUrlMax");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMinIsNull() {
            addCriterion("person_img_url_min is null");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMinIsNotNull() {
            addCriterion("person_img_url_min is not null");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMinEqualTo(String value) {
            addCriterion("person_img_url_min =", value, "personImgUrlMin");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMinNotEqualTo(String value) {
            addCriterion("person_img_url_min <>", value, "personImgUrlMin");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMinGreaterThan(String value) {
            addCriterion("person_img_url_min >", value, "personImgUrlMin");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMinGreaterThanOrEqualTo(String value) {
            addCriterion("person_img_url_min >=", value, "personImgUrlMin");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMinLessThan(String value) {
            addCriterion("person_img_url_min <", value, "personImgUrlMin");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMinLessThanOrEqualTo(String value) {
            addCriterion("person_img_url_min <=", value, "personImgUrlMin");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMinLike(String value) {
            addCriterion("person_img_url_min like", value, "personImgUrlMin");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMinNotLike(String value) {
            addCriterion("person_img_url_min not like", value, "personImgUrlMin");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMinIn(List<String> values) {
            addCriterion("person_img_url_min in", values, "personImgUrlMin");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMinNotIn(List<String> values) {
            addCriterion("person_img_url_min not in", values, "personImgUrlMin");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMinBetween(String value1, String value2) {
            addCriterion("person_img_url_min between", value1, value2, "personImgUrlMin");
            return (Criteria) this;
        }

        public Criteria andPersonImgUrlMinNotBetween(String value1, String value2) {
            addCriterion("person_img_url_min not between", value1, value2, "personImgUrlMin");
            return (Criteria) this;
        }

        public Criteria andDoudouCountIsNull() {
            addCriterion("doudou_count is null");
            return (Criteria) this;
        }

        public Criteria andDoudouCountIsNotNull() {
            addCriterion("doudou_count is not null");
            return (Criteria) this;
        }

        public Criteria andDoudouCountEqualTo(Integer value) {
            addCriterion("doudou_count =", value, "doudouCount");
            return (Criteria) this;
        }

        public Criteria andDoudouCountNotEqualTo(Integer value) {
            addCriterion("doudou_count <>", value, "doudouCount");
            return (Criteria) this;
        }

        public Criteria andDoudouCountGreaterThan(Integer value) {
            addCriterion("doudou_count >", value, "doudouCount");
            return (Criteria) this;
        }

        public Criteria andDoudouCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("doudou_count >=", value, "doudouCount");
            return (Criteria) this;
        }

        public Criteria andDoudouCountLessThan(Integer value) {
            addCriterion("doudou_count <", value, "doudouCount");
            return (Criteria) this;
        }

        public Criteria andDoudouCountLessThanOrEqualTo(Integer value) {
            addCriterion("doudou_count <=", value, "doudouCount");
            return (Criteria) this;
        }

        public Criteria andDoudouCountIn(List<Integer> values) {
            addCriterion("doudou_count in", values, "doudouCount");
            return (Criteria) this;
        }

        public Criteria andDoudouCountNotIn(List<Integer> values) {
            addCriterion("doudou_count not in", values, "doudouCount");
            return (Criteria) this;
        }

        public Criteria andDoudouCountBetween(Integer value1, Integer value2) {
            addCriterion("doudou_count between", value1, value2, "doudouCount");
            return (Criteria) this;
        }

        public Criteria andDoudouCountNotBetween(Integer value1, Integer value2) {
            addCriterion("doudou_count not between", value1, value2, "doudouCount");
            return (Criteria) this;
        }

        public Criteria andConiCountIsNull() {
            addCriterion("coni_count is null");
            return (Criteria) this;
        }

        public Criteria andConiCountIsNotNull() {
            addCriterion("coni_count is not null");
            return (Criteria) this;
        }

        public Criteria andConiCountEqualTo(Double value) {
            addCriterion("coni_count =", value, "coniCount");
            return (Criteria) this;
        }

        public Criteria andConiCountNotEqualTo(Double value) {
            addCriterion("coni_count <>", value, "coniCount");
            return (Criteria) this;
        }

        public Criteria andConiCountGreaterThan(Double value) {
            addCriterion("coni_count >", value, "coniCount");
            return (Criteria) this;
        }

        public Criteria andConiCountGreaterThanOrEqualTo(Double value) {
            addCriterion("coni_count >=", value, "coniCount");
            return (Criteria) this;
        }

        public Criteria andConiCountLessThan(Double value) {
            addCriterion("coni_count <", value, "coniCount");
            return (Criteria) this;
        }

        public Criteria andConiCountLessThanOrEqualTo(Double value) {
            addCriterion("coni_count <=", value, "coniCount");
            return (Criteria) this;
        }

        public Criteria andConiCountIn(List<Double> values) {
            addCriterion("coni_count in", values, "coniCount");
            return (Criteria) this;
        }

        public Criteria andConiCountNotIn(List<Double> values) {
            addCriterion("coni_count not in", values, "coniCount");
            return (Criteria) this;
        }

        public Criteria andConiCountBetween(Double value1, Double value2) {
            addCriterion("coni_count between", value1, value2, "coniCount");
            return (Criteria) this;
        }

        public Criteria andConiCountNotBetween(Double value1, Double value2) {
            addCriterion("coni_count not between", value1, value2, "coniCount");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdIsNull() {
            addCriterion("weixin_open_id is null");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdIsNotNull() {
            addCriterion("weixin_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdEqualTo(String value) {
            addCriterion("weixin_open_id =", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdNotEqualTo(String value) {
            addCriterion("weixin_open_id <>", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdGreaterThan(String value) {
            addCriterion("weixin_open_id >", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_open_id >=", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdLessThan(String value) {
            addCriterion("weixin_open_id <", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdLessThanOrEqualTo(String value) {
            addCriterion("weixin_open_id <=", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdLike(String value) {
            addCriterion("weixin_open_id like", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdNotLike(String value) {
            addCriterion("weixin_open_id not like", value, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdIn(List<String> values) {
            addCriterion("weixin_open_id in", values, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdNotIn(List<String> values) {
            addCriterion("weixin_open_id not in", values, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdBetween(String value1, String value2) {
            addCriterion("weixin_open_id between", value1, value2, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinOpenIdNotBetween(String value1, String value2) {
            addCriterion("weixin_open_id not between", value1, value2, "weixinOpenId");
            return (Criteria) this;
        }

        public Criteria andWeixinUniIdIsNull() {
            addCriterion("weixin_uni_id is null");
            return (Criteria) this;
        }

        public Criteria andWeixinUniIdIsNotNull() {
            addCriterion("weixin_uni_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinUniIdEqualTo(String value) {
            addCriterion("weixin_uni_id =", value, "weixinUniId");
            return (Criteria) this;
        }

        public Criteria andWeixinUniIdNotEqualTo(String value) {
            addCriterion("weixin_uni_id <>", value, "weixinUniId");
            return (Criteria) this;
        }

        public Criteria andWeixinUniIdGreaterThan(String value) {
            addCriterion("weixin_uni_id >", value, "weixinUniId");
            return (Criteria) this;
        }

        public Criteria andWeixinUniIdGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_uni_id >=", value, "weixinUniId");
            return (Criteria) this;
        }

        public Criteria andWeixinUniIdLessThan(String value) {
            addCriterion("weixin_uni_id <", value, "weixinUniId");
            return (Criteria) this;
        }

        public Criteria andWeixinUniIdLessThanOrEqualTo(String value) {
            addCriterion("weixin_uni_id <=", value, "weixinUniId");
            return (Criteria) this;
        }

        public Criteria andWeixinUniIdLike(String value) {
            addCriterion("weixin_uni_id like", value, "weixinUniId");
            return (Criteria) this;
        }

        public Criteria andWeixinUniIdNotLike(String value) {
            addCriterion("weixin_uni_id not like", value, "weixinUniId");
            return (Criteria) this;
        }

        public Criteria andWeixinUniIdIn(List<String> values) {
            addCriterion("weixin_uni_id in", values, "weixinUniId");
            return (Criteria) this;
        }

        public Criteria andWeixinUniIdNotIn(List<String> values) {
            addCriterion("weixin_uni_id not in", values, "weixinUniId");
            return (Criteria) this;
        }

        public Criteria andWeixinUniIdBetween(String value1, String value2) {
            addCriterion("weixin_uni_id between", value1, value2, "weixinUniId");
            return (Criteria) this;
        }

        public Criteria andWeixinUniIdNotBetween(String value1, String value2) {
            addCriterion("weixin_uni_id not between", value1, value2, "weixinUniId");
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

        public Criteria andQqOpenIdIsNull() {
            addCriterion("qq_open_id is null");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdIsNotNull() {
            addCriterion("qq_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdEqualTo(String value) {
            addCriterion("qq_open_id =", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdNotEqualTo(String value) {
            addCriterion("qq_open_id <>", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdGreaterThan(String value) {
            addCriterion("qq_open_id >", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("qq_open_id >=", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdLessThan(String value) {
            addCriterion("qq_open_id <", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdLessThanOrEqualTo(String value) {
            addCriterion("qq_open_id <=", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdLike(String value) {
            addCriterion("qq_open_id like", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdNotLike(String value) {
            addCriterion("qq_open_id not like", value, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdIn(List<String> values) {
            addCriterion("qq_open_id in", values, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdNotIn(List<String> values) {
            addCriterion("qq_open_id not in", values, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdBetween(String value1, String value2) {
            addCriterion("qq_open_id between", value1, value2, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andQqOpenIdNotBetween(String value1, String value2) {
            addCriterion("qq_open_id not between", value1, value2, "qqOpenId");
            return (Criteria) this;
        }

        public Criteria andIsRobotIsNull() {
            addCriterion("is_robot is null");
            return (Criteria) this;
        }

        public Criteria andIsRobotIsNotNull() {
            addCriterion("is_robot is not null");
            return (Criteria) this;
        }

        public Criteria andIsRobotEqualTo(String value) {
            addCriterion("is_robot =", value, "isRobot");
            return (Criteria) this;
        }

        public Criteria andIsRobotNotEqualTo(String value) {
            addCriterion("is_robot <>", value, "isRobot");
            return (Criteria) this;
        }

        public Criteria andIsRobotGreaterThan(String value) {
            addCriterion("is_robot >", value, "isRobot");
            return (Criteria) this;
        }

        public Criteria andIsRobotGreaterThanOrEqualTo(String value) {
            addCriterion("is_robot >=", value, "isRobot");
            return (Criteria) this;
        }

        public Criteria andIsRobotLessThan(String value) {
            addCriterion("is_robot <", value, "isRobot");
            return (Criteria) this;
        }

        public Criteria andIsRobotLessThanOrEqualTo(String value) {
            addCriterion("is_robot <=", value, "isRobot");
            return (Criteria) this;
        }

        public Criteria andIsRobotLike(String value) {
            addCriterion("is_robot like", value, "isRobot");
            return (Criteria) this;
        }

        public Criteria andIsRobotNotLike(String value) {
            addCriterion("is_robot not like", value, "isRobot");
            return (Criteria) this;
        }

        public Criteria andIsRobotIn(List<String> values) {
            addCriterion("is_robot in", values, "isRobot");
            return (Criteria) this;
        }

        public Criteria andIsRobotNotIn(List<String> values) {
            addCriterion("is_robot not in", values, "isRobot");
            return (Criteria) this;
        }

        public Criteria andIsRobotBetween(String value1, String value2) {
            addCriterion("is_robot between", value1, value2, "isRobot");
            return (Criteria) this;
        }

        public Criteria andIsRobotNotBetween(String value1, String value2) {
            addCriterion("is_robot not between", value1, value2, "isRobot");
            return (Criteria) this;
        }

        public Criteria andRobotOrderIpIsNull() {
            addCriterion("robot_order_ip is null");
            return (Criteria) this;
        }

        public Criteria andRobotOrderIpIsNotNull() {
            addCriterion("robot_order_ip is not null");
            return (Criteria) this;
        }

        public Criteria andRobotOrderIpEqualTo(String value) {
            addCriterion("robot_order_ip =", value, "robotOrderIp");
            return (Criteria) this;
        }

        public Criteria andRobotOrderIpNotEqualTo(String value) {
            addCriterion("robot_order_ip <>", value, "robotOrderIp");
            return (Criteria) this;
        }

        public Criteria andRobotOrderIpGreaterThan(String value) {
            addCriterion("robot_order_ip >", value, "robotOrderIp");
            return (Criteria) this;
        }

        public Criteria andRobotOrderIpGreaterThanOrEqualTo(String value) {
            addCriterion("robot_order_ip >=", value, "robotOrderIp");
            return (Criteria) this;
        }

        public Criteria andRobotOrderIpLessThan(String value) {
            addCriterion("robot_order_ip <", value, "robotOrderIp");
            return (Criteria) this;
        }

        public Criteria andRobotOrderIpLessThanOrEqualTo(String value) {
            addCriterion("robot_order_ip <=", value, "robotOrderIp");
            return (Criteria) this;
        }

        public Criteria andRobotOrderIpLike(String value) {
            addCriterion("robot_order_ip like", value, "robotOrderIp");
            return (Criteria) this;
        }

        public Criteria andRobotOrderIpNotLike(String value) {
            addCriterion("robot_order_ip not like", value, "robotOrderIp");
            return (Criteria) this;
        }

        public Criteria andRobotOrderIpIn(List<String> values) {
            addCriterion("robot_order_ip in", values, "robotOrderIp");
            return (Criteria) this;
        }

        public Criteria andRobotOrderIpNotIn(List<String> values) {
            addCriterion("robot_order_ip not in", values, "robotOrderIp");
            return (Criteria) this;
        }

        public Criteria andRobotOrderIpBetween(String value1, String value2) {
            addCriterion("robot_order_ip between", value1, value2, "robotOrderIp");
            return (Criteria) this;
        }

        public Criteria andRobotOrderIpNotBetween(String value1, String value2) {
            addCriterion("robot_order_ip not between", value1, value2, "robotOrderIp");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNull() {
            addCriterion("app_type is null");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNotNull() {
            addCriterion("app_type is not null");
            return (Criteria) this;
        }

        public Criteria andAppTypeEqualTo(String value) {
            addCriterion("app_type =", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotEqualTo(String value) {
            addCriterion("app_type <>", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThan(String value) {
            addCriterion("app_type >", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThanOrEqualTo(String value) {
            addCriterion("app_type >=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThan(String value) {
            addCriterion("app_type <", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThanOrEqualTo(String value) {
            addCriterion("app_type <=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLike(String value) {
            addCriterion("app_type like", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotLike(String value) {
            addCriterion("app_type not like", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeIn(List<String> values) {
            addCriterion("app_type in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotIn(List<String> values) {
            addCriterion("app_type not in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeBetween(String value1, String value2) {
            addCriterion("app_type between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotBetween(String value1, String value2) {
            addCriterion("app_type not between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andPhoneNameIsNull() {
            addCriterion("phone_name is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNameIsNotNull() {
            addCriterion("phone_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNameEqualTo(String value) {
            addCriterion("phone_name =", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameNotEqualTo(String value) {
            addCriterion("phone_name <>", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameGreaterThan(String value) {
            addCriterion("phone_name >", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameGreaterThanOrEqualTo(String value) {
            addCriterion("phone_name >=", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameLessThan(String value) {
            addCriterion("phone_name <", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameLessThanOrEqualTo(String value) {
            addCriterion("phone_name <=", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameLike(String value) {
            addCriterion("phone_name like", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameNotLike(String value) {
            addCriterion("phone_name not like", value, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameIn(List<String> values) {
            addCriterion("phone_name in", values, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameNotIn(List<String> values) {
            addCriterion("phone_name not in", values, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameBetween(String value1, String value2) {
            addCriterion("phone_name between", value1, value2, "phoneName");
            return (Criteria) this;
        }

        public Criteria andPhoneNameNotBetween(String value1, String value2) {
            addCriterion("phone_name not between", value1, value2, "phoneName");
            return (Criteria) this;
        }

        public Criteria andIsTaskPhoneIsNull() {
            addCriterion("is_task_phone is null");
            return (Criteria) this;
        }

        public Criteria andIsTaskPhoneIsNotNull() {
            addCriterion("is_task_phone is not null");
            return (Criteria) this;
        }

        public Criteria andIsTaskPhoneEqualTo(String value) {
            addCriterion("is_task_phone =", value, "isTaskPhone");
            return (Criteria) this;
        }

        public Criteria andIsTaskPhoneNotEqualTo(String value) {
            addCriterion("is_task_phone <>", value, "isTaskPhone");
            return (Criteria) this;
        }

        public Criteria andIsTaskPhoneGreaterThan(String value) {
            addCriterion("is_task_phone >", value, "isTaskPhone");
            return (Criteria) this;
        }

        public Criteria andIsTaskPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("is_task_phone >=", value, "isTaskPhone");
            return (Criteria) this;
        }

        public Criteria andIsTaskPhoneLessThan(String value) {
            addCriterion("is_task_phone <", value, "isTaskPhone");
            return (Criteria) this;
        }

        public Criteria andIsTaskPhoneLessThanOrEqualTo(String value) {
            addCriterion("is_task_phone <=", value, "isTaskPhone");
            return (Criteria) this;
        }

        public Criteria andIsTaskPhoneLike(String value) {
            addCriterion("is_task_phone like", value, "isTaskPhone");
            return (Criteria) this;
        }

        public Criteria andIsTaskPhoneNotLike(String value) {
            addCriterion("is_task_phone not like", value, "isTaskPhone");
            return (Criteria) this;
        }

        public Criteria andIsTaskPhoneIn(List<String> values) {
            addCriterion("is_task_phone in", values, "isTaskPhone");
            return (Criteria) this;
        }

        public Criteria andIsTaskPhoneNotIn(List<String> values) {
            addCriterion("is_task_phone not in", values, "isTaskPhone");
            return (Criteria) this;
        }

        public Criteria andIsTaskPhoneBetween(String value1, String value2) {
            addCriterion("is_task_phone between", value1, value2, "isTaskPhone");
            return (Criteria) this;
        }

        public Criteria andIsTaskPhoneNotBetween(String value1, String value2) {
            addCriterion("is_task_phone not between", value1, value2, "isTaskPhone");
            return (Criteria) this;
        }

        public Criteria andIsTaskAddressIsNull() {
            addCriterion("is_task_address is null");
            return (Criteria) this;
        }

        public Criteria andIsTaskAddressIsNotNull() {
            addCriterion("is_task_address is not null");
            return (Criteria) this;
        }

        public Criteria andIsTaskAddressEqualTo(String value) {
            addCriterion("is_task_address =", value, "isTaskAddress");
            return (Criteria) this;
        }

        public Criteria andIsTaskAddressNotEqualTo(String value) {
            addCriterion("is_task_address <>", value, "isTaskAddress");
            return (Criteria) this;
        }

        public Criteria andIsTaskAddressGreaterThan(String value) {
            addCriterion("is_task_address >", value, "isTaskAddress");
            return (Criteria) this;
        }

        public Criteria andIsTaskAddressGreaterThanOrEqualTo(String value) {
            addCriterion("is_task_address >=", value, "isTaskAddress");
            return (Criteria) this;
        }

        public Criteria andIsTaskAddressLessThan(String value) {
            addCriterion("is_task_address <", value, "isTaskAddress");
            return (Criteria) this;
        }

        public Criteria andIsTaskAddressLessThanOrEqualTo(String value) {
            addCriterion("is_task_address <=", value, "isTaskAddress");
            return (Criteria) this;
        }

        public Criteria andIsTaskAddressLike(String value) {
            addCriterion("is_task_address like", value, "isTaskAddress");
            return (Criteria) this;
        }

        public Criteria andIsTaskAddressNotLike(String value) {
            addCriterion("is_task_address not like", value, "isTaskAddress");
            return (Criteria) this;
        }

        public Criteria andIsTaskAddressIn(List<String> values) {
            addCriterion("is_task_address in", values, "isTaskAddress");
            return (Criteria) this;
        }

        public Criteria andIsTaskAddressNotIn(List<String> values) {
            addCriterion("is_task_address not in", values, "isTaskAddress");
            return (Criteria) this;
        }

        public Criteria andIsTaskAddressBetween(String value1, String value2) {
            addCriterion("is_task_address between", value1, value2, "isTaskAddress");
            return (Criteria) this;
        }

        public Criteria andIsTaskAddressNotBetween(String value1, String value2) {
            addCriterion("is_task_address not between", value1, value2, "isTaskAddress");
            return (Criteria) this;
        }

        public Criteria andTaskAllDoudouIsNull() {
            addCriterion("task_all_doudou is null");
            return (Criteria) this;
        }

        public Criteria andTaskAllDoudouIsNotNull() {
            addCriterion("task_all_doudou is not null");
            return (Criteria) this;
        }

        public Criteria andTaskAllDoudouEqualTo(Integer value) {
            addCriterion("task_all_doudou =", value, "taskAllDoudou");
            return (Criteria) this;
        }

        public Criteria andTaskAllDoudouNotEqualTo(Integer value) {
            addCriterion("task_all_doudou <>", value, "taskAllDoudou");
            return (Criteria) this;
        }

        public Criteria andTaskAllDoudouGreaterThan(Integer value) {
            addCriterion("task_all_doudou >", value, "taskAllDoudou");
            return (Criteria) this;
        }

        public Criteria andTaskAllDoudouGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_all_doudou >=", value, "taskAllDoudou");
            return (Criteria) this;
        }

        public Criteria andTaskAllDoudouLessThan(Integer value) {
            addCriterion("task_all_doudou <", value, "taskAllDoudou");
            return (Criteria) this;
        }

        public Criteria andTaskAllDoudouLessThanOrEqualTo(Integer value) {
            addCriterion("task_all_doudou <=", value, "taskAllDoudou");
            return (Criteria) this;
        }

        public Criteria andTaskAllDoudouIn(List<Integer> values) {
            addCriterion("task_all_doudou in", values, "taskAllDoudou");
            return (Criteria) this;
        }

        public Criteria andTaskAllDoudouNotIn(List<Integer> values) {
            addCriterion("task_all_doudou not in", values, "taskAllDoudou");
            return (Criteria) this;
        }

        public Criteria andTaskAllDoudouBetween(Integer value1, Integer value2) {
            addCriterion("task_all_doudou between", value1, value2, "taskAllDoudou");
            return (Criteria) this;
        }

        public Criteria andTaskAllDoudouNotBetween(Integer value1, Integer value2) {
            addCriterion("task_all_doudou not between", value1, value2, "taskAllDoudou");
            return (Criteria) this;
        }

        public Criteria andUmengChannelIsNull() {
            addCriterion("umeng_channel is null");
            return (Criteria) this;
        }

        public Criteria andUmengChannelIsNotNull() {
            addCriterion("umeng_channel is not null");
            return (Criteria) this;
        }

        public Criteria andUmengChannelEqualTo(String value) {
            addCriterion("umeng_channel =", value, "umengChannel");
            return (Criteria) this;
        }

        public Criteria andUmengChannelNotEqualTo(String value) {
            addCriterion("umeng_channel <>", value, "umengChannel");
            return (Criteria) this;
        }

        public Criteria andUmengChannelGreaterThan(String value) {
            addCriterion("umeng_channel >", value, "umengChannel");
            return (Criteria) this;
        }

        public Criteria andUmengChannelGreaterThanOrEqualTo(String value) {
            addCriterion("umeng_channel >=", value, "umengChannel");
            return (Criteria) this;
        }

        public Criteria andUmengChannelLessThan(String value) {
            addCriterion("umeng_channel <", value, "umengChannel");
            return (Criteria) this;
        }

        public Criteria andUmengChannelLessThanOrEqualTo(String value) {
            addCriterion("umeng_channel <=", value, "umengChannel");
            return (Criteria) this;
        }

        public Criteria andUmengChannelLike(String value) {
            addCriterion("umeng_channel like", value, "umengChannel");
            return (Criteria) this;
        }

        public Criteria andUmengChannelNotLike(String value) {
            addCriterion("umeng_channel not like", value, "umengChannel");
            return (Criteria) this;
        }

        public Criteria andUmengChannelIn(List<String> values) {
            addCriterion("umeng_channel in", values, "umengChannel");
            return (Criteria) this;
        }

        public Criteria andUmengChannelNotIn(List<String> values) {
            addCriterion("umeng_channel not in", values, "umengChannel");
            return (Criteria) this;
        }

        public Criteria andUmengChannelBetween(String value1, String value2) {
            addCriterion("umeng_channel between", value1, value2, "umengChannel");
            return (Criteria) this;
        }

        public Criteria andUmengChannelNotBetween(String value1, String value2) {
            addCriterion("umeng_channel not between", value1, value2, "umengChannel");
            return (Criteria) this;
        }

        public Criteria andSmsSendCountIsNull() {
            addCriterion("sms_send_count is null");
            return (Criteria) this;
        }

        public Criteria andSmsSendCountIsNotNull() {
            addCriterion("sms_send_count is not null");
            return (Criteria) this;
        }

        public Criteria andSmsSendCountEqualTo(Integer value) {
            addCriterion("sms_send_count =", value, "smsSendCount");
            return (Criteria) this;
        }

        public Criteria andSmsSendCountNotEqualTo(Integer value) {
            addCriterion("sms_send_count <>", value, "smsSendCount");
            return (Criteria) this;
        }

        public Criteria andSmsSendCountGreaterThan(Integer value) {
            addCriterion("sms_send_count >", value, "smsSendCount");
            return (Criteria) this;
        }

        public Criteria andSmsSendCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sms_send_count >=", value, "smsSendCount");
            return (Criteria) this;
        }

        public Criteria andSmsSendCountLessThan(Integer value) {
            addCriterion("sms_send_count <", value, "smsSendCount");
            return (Criteria) this;
        }

        public Criteria andSmsSendCountLessThanOrEqualTo(Integer value) {
            addCriterion("sms_send_count <=", value, "smsSendCount");
            return (Criteria) this;
        }

        public Criteria andSmsSendCountIn(List<Integer> values) {
            addCriterion("sms_send_count in", values, "smsSendCount");
            return (Criteria) this;
        }

        public Criteria andSmsSendCountNotIn(List<Integer> values) {
            addCriterion("sms_send_count not in", values, "smsSendCount");
            return (Criteria) this;
        }

        public Criteria andSmsSendCountBetween(Integer value1, Integer value2) {
            addCriterion("sms_send_count between", value1, value2, "smsSendCount");
            return (Criteria) this;
        }

        public Criteria andSmsSendCountNotBetween(Integer value1, Integer value2) {
            addCriterion("sms_send_count not between", value1, value2, "smsSendCount");
            return (Criteria) this;
        }

        public Criteria andSmsSendLastTimeIsNull() {
            addCriterion("sms_send_last_time is null");
            return (Criteria) this;
        }

        public Criteria andSmsSendLastTimeIsNotNull() {
            addCriterion("sms_send_last_time is not null");
            return (Criteria) this;
        }

        public Criteria andSmsSendLastTimeEqualTo(Date value) {
            addCriterion("sms_send_last_time =", value, "smsSendLastTime");
            return (Criteria) this;
        }

        public Criteria andSmsSendLastTimeNotEqualTo(Date value) {
            addCriterion("sms_send_last_time <>", value, "smsSendLastTime");
            return (Criteria) this;
        }

        public Criteria andSmsSendLastTimeGreaterThan(Date value) {
            addCriterion("sms_send_last_time >", value, "smsSendLastTime");
            return (Criteria) this;
        }

        public Criteria andSmsSendLastTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sms_send_last_time >=", value, "smsSendLastTime");
            return (Criteria) this;
        }

        public Criteria andSmsSendLastTimeLessThan(Date value) {
            addCriterion("sms_send_last_time <", value, "smsSendLastTime");
            return (Criteria) this;
        }

        public Criteria andSmsSendLastTimeLessThanOrEqualTo(Date value) {
            addCriterion("sms_send_last_time <=", value, "smsSendLastTime");
            return (Criteria) this;
        }

        public Criteria andSmsSendLastTimeIn(List<Date> values) {
            addCriterion("sms_send_last_time in", values, "smsSendLastTime");
            return (Criteria) this;
        }

        public Criteria andSmsSendLastTimeNotIn(List<Date> values) {
            addCriterion("sms_send_last_time not in", values, "smsSendLastTime");
            return (Criteria) this;
        }

        public Criteria andSmsSendLastTimeBetween(Date value1, Date value2) {
            addCriterion("sms_send_last_time between", value1, value2, "smsSendLastTime");
            return (Criteria) this;
        }

        public Criteria andSmsSendLastTimeNotBetween(Date value1, Date value2) {
            addCriterion("sms_send_last_time not between", value1, value2, "smsSendLastTime");
            return (Criteria) this;
        }

        public Criteria andContributionValueIsNull() {
            addCriterion("contribution_value is null");
            return (Criteria) this;
        }

        public Criteria andContributionValueIsNotNull() {
            addCriterion("contribution_value is not null");
            return (Criteria) this;
        }

        public Criteria andContributionValueEqualTo(Integer value) {
            addCriterion("contribution_value =", value, "contributionValue");
            return (Criteria) this;
        }

        public Criteria andContributionValueNotEqualTo(Integer value) {
            addCriterion("contribution_value <>", value, "contributionValue");
            return (Criteria) this;
        }

        public Criteria andContributionValueGreaterThan(Integer value) {
            addCriterion("contribution_value >", value, "contributionValue");
            return (Criteria) this;
        }

        public Criteria andContributionValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("contribution_value >=", value, "contributionValue");
            return (Criteria) this;
        }

        public Criteria andContributionValueLessThan(Integer value) {
            addCriterion("contribution_value <", value, "contributionValue");
            return (Criteria) this;
        }

        public Criteria andContributionValueLessThanOrEqualTo(Integer value) {
            addCriterion("contribution_value <=", value, "contributionValue");
            return (Criteria) this;
        }

        public Criteria andContributionValueIn(List<Integer> values) {
            addCriterion("contribution_value in", values, "contributionValue");
            return (Criteria) this;
        }

        public Criteria andContributionValueNotIn(List<Integer> values) {
            addCriterion("contribution_value not in", values, "contributionValue");
            return (Criteria) this;
        }

        public Criteria andContributionValueBetween(Integer value1, Integer value2) {
            addCriterion("contribution_value between", value1, value2, "contributionValue");
            return (Criteria) this;
        }

        public Criteria andContributionValueNotBetween(Integer value1, Integer value2) {
            addCriterion("contribution_value not between", value1, value2, "contributionValue");
            return (Criteria) this;
        }

        public Criteria andContributionLevelIsNull() {
            addCriterion("contribution_level is null");
            return (Criteria) this;
        }

        public Criteria andContributionLevelIsNotNull() {
            addCriterion("contribution_level is not null");
            return (Criteria) this;
        }

        public Criteria andContributionLevelEqualTo(Integer value) {
            addCriterion("contribution_level =", value, "contributionLevel");
            return (Criteria) this;
        }

        public Criteria andContributionLevelNotEqualTo(Integer value) {
            addCriterion("contribution_level <>", value, "contributionLevel");
            return (Criteria) this;
        }

        public Criteria andContributionLevelGreaterThan(Integer value) {
            addCriterion("contribution_level >", value, "contributionLevel");
            return (Criteria) this;
        }

        public Criteria andContributionLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("contribution_level >=", value, "contributionLevel");
            return (Criteria) this;
        }

        public Criteria andContributionLevelLessThan(Integer value) {
            addCriterion("contribution_level <", value, "contributionLevel");
            return (Criteria) this;
        }

        public Criteria andContributionLevelLessThanOrEqualTo(Integer value) {
            addCriterion("contribution_level <=", value, "contributionLevel");
            return (Criteria) this;
        }

        public Criteria andContributionLevelIn(List<Integer> values) {
            addCriterion("contribution_level in", values, "contributionLevel");
            return (Criteria) this;
        }

        public Criteria andContributionLevelNotIn(List<Integer> values) {
            addCriterion("contribution_level not in", values, "contributionLevel");
            return (Criteria) this;
        }

        public Criteria andContributionLevelBetween(Integer value1, Integer value2) {
            addCriterion("contribution_level between", value1, value2, "contributionLevel");
            return (Criteria) this;
        }

        public Criteria andContributionLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("contribution_level not between", value1, value2, "contributionLevel");
            return (Criteria) this;
        }

        public Criteria andLastUserIdIsNull() {
            addCriterion("last_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLastUserIdIsNotNull() {
            addCriterion("last_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastUserIdEqualTo(String value) {
            addCriterion("last_user_id =", value, "lastUserId");
            return (Criteria) this;
        }

        public Criteria andLastUserIdNotEqualTo(String value) {
            addCriterion("last_user_id <>", value, "lastUserId");
            return (Criteria) this;
        }

        public Criteria andLastUserIdGreaterThan(String value) {
            addCriterion("last_user_id >", value, "lastUserId");
            return (Criteria) this;
        }

        public Criteria andLastUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("last_user_id >=", value, "lastUserId");
            return (Criteria) this;
        }

        public Criteria andLastUserIdLessThan(String value) {
            addCriterion("last_user_id <", value, "lastUserId");
            return (Criteria) this;
        }

        public Criteria andLastUserIdLessThanOrEqualTo(String value) {
            addCriterion("last_user_id <=", value, "lastUserId");
            return (Criteria) this;
        }

        public Criteria andLastUserIdLike(String value) {
            addCriterion("last_user_id like", value, "lastUserId");
            return (Criteria) this;
        }

        public Criteria andLastUserIdNotLike(String value) {
            addCriterion("last_user_id not like", value, "lastUserId");
            return (Criteria) this;
        }

        public Criteria andLastUserIdIn(List<String> values) {
            addCriterion("last_user_id in", values, "lastUserId");
            return (Criteria) this;
        }

        public Criteria andLastUserIdNotIn(List<String> values) {
            addCriterion("last_user_id not in", values, "lastUserId");
            return (Criteria) this;
        }

        public Criteria andLastUserIdBetween(String value1, String value2) {
            addCriterion("last_user_id between", value1, value2, "lastUserId");
            return (Criteria) this;
        }

        public Criteria andLastUserIdNotBetween(String value1, String value2) {
            addCriterion("last_user_id not between", value1, value2, "lastUserId");
            return (Criteria) this;
        }

        public Criteria andRequestCodeIsNull() {
            addCriterion("request_code is null");
            return (Criteria) this;
        }

        public Criteria andRequestCodeIsNotNull() {
            addCriterion("request_code is not null");
            return (Criteria) this;
        }

        public Criteria andRequestCodeEqualTo(String value) {
            addCriterion("request_code =", value, "requestCode");
            return (Criteria) this;
        }

        public Criteria andRequestCodeNotEqualTo(String value) {
            addCriterion("request_code <>", value, "requestCode");
            return (Criteria) this;
        }

        public Criteria andRequestCodeGreaterThan(String value) {
            addCriterion("request_code >", value, "requestCode");
            return (Criteria) this;
        }

        public Criteria andRequestCodeGreaterThanOrEqualTo(String value) {
            addCriterion("request_code >=", value, "requestCode");
            return (Criteria) this;
        }

        public Criteria andRequestCodeLessThan(String value) {
            addCriterion("request_code <", value, "requestCode");
            return (Criteria) this;
        }

        public Criteria andRequestCodeLessThanOrEqualTo(String value) {
            addCriterion("request_code <=", value, "requestCode");
            return (Criteria) this;
        }

        public Criteria andRequestCodeLike(String value) {
            addCriterion("request_code like", value, "requestCode");
            return (Criteria) this;
        }

        public Criteria andRequestCodeNotLike(String value) {
            addCriterion("request_code not like", value, "requestCode");
            return (Criteria) this;
        }

        public Criteria andRequestCodeIn(List<String> values) {
            addCriterion("request_code in", values, "requestCode");
            return (Criteria) this;
        }

        public Criteria andRequestCodeNotIn(List<String> values) {
            addCriterion("request_code not in", values, "requestCode");
            return (Criteria) this;
        }

        public Criteria andRequestCodeBetween(String value1, String value2) {
            addCriterion("request_code between", value1, value2, "requestCode");
            return (Criteria) this;
        }

        public Criteria andRequestCodeNotBetween(String value1, String value2) {
            addCriterion("request_code not between", value1, value2, "requestCode");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsEverydayIsNull() {
            addCriterion("show_add_send_sms_everyday is null");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsEverydayIsNotNull() {
            addCriterion("show_add_send_sms_everyday is not null");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsEverydayEqualTo(Integer value) {
            addCriterion("show_add_send_sms_everyday =", value, "showAddSendSmsEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsEverydayNotEqualTo(Integer value) {
            addCriterion("show_add_send_sms_everyday <>", value, "showAddSendSmsEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsEverydayGreaterThan(Integer value) {
            addCriterion("show_add_send_sms_everyday >", value, "showAddSendSmsEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsEverydayGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_add_send_sms_everyday >=", value, "showAddSendSmsEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsEverydayLessThan(Integer value) {
            addCriterion("show_add_send_sms_everyday <", value, "showAddSendSmsEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsEverydayLessThanOrEqualTo(Integer value) {
            addCriterion("show_add_send_sms_everyday <=", value, "showAddSendSmsEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsEverydayIn(List<Integer> values) {
            addCriterion("show_add_send_sms_everyday in", values, "showAddSendSmsEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsEverydayNotIn(List<Integer> values) {
            addCriterion("show_add_send_sms_everyday not in", values, "showAddSendSmsEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsEverydayBetween(Integer value1, Integer value2) {
            addCriterion("show_add_send_sms_everyday between", value1, value2, "showAddSendSmsEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsEverydayNotBetween(Integer value1, Integer value2) {
            addCriterion("show_add_send_sms_everyday not between", value1, value2, "showAddSendSmsEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushEverydayIsNull() {
            addCriterion("show_add_send_jpush_everyday is null");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushEverydayIsNotNull() {
            addCriterion("show_add_send_jpush_everyday is not null");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushEverydayEqualTo(Integer value) {
            addCriterion("show_add_send_jpush_everyday =", value, "showAddSendJpushEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushEverydayNotEqualTo(Integer value) {
            addCriterion("show_add_send_jpush_everyday <>", value, "showAddSendJpushEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushEverydayGreaterThan(Integer value) {
            addCriterion("show_add_send_jpush_everyday >", value, "showAddSendJpushEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushEverydayGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_add_send_jpush_everyday >=", value, "showAddSendJpushEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushEverydayLessThan(Integer value) {
            addCriterion("show_add_send_jpush_everyday <", value, "showAddSendJpushEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushEverydayLessThanOrEqualTo(Integer value) {
            addCriterion("show_add_send_jpush_everyday <=", value, "showAddSendJpushEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushEverydayIn(List<Integer> values) {
            addCriterion("show_add_send_jpush_everyday in", values, "showAddSendJpushEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushEverydayNotIn(List<Integer> values) {
            addCriterion("show_add_send_jpush_everyday not in", values, "showAddSendJpushEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushEverydayBetween(Integer value1, Integer value2) {
            addCriterion("show_add_send_jpush_everyday between", value1, value2, "showAddSendJpushEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushEverydayNotBetween(Integer value1, Integer value2) {
            addCriterion("show_add_send_jpush_everyday not between", value1, value2, "showAddSendJpushEveryday");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsDateIsNull() {
            addCriterion("show_add_send_sms_date is null");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsDateIsNotNull() {
            addCriterion("show_add_send_sms_date is not null");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsDateEqualTo(Date value) {
            addCriterionForJDBCDate("show_add_send_sms_date =", value, "showAddSendSmsDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("show_add_send_sms_date <>", value, "showAddSendSmsDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsDateGreaterThan(Date value) {
            addCriterionForJDBCDate("show_add_send_sms_date >", value, "showAddSendSmsDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("show_add_send_sms_date >=", value, "showAddSendSmsDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsDateLessThan(Date value) {
            addCriterionForJDBCDate("show_add_send_sms_date <", value, "showAddSendSmsDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("show_add_send_sms_date <=", value, "showAddSendSmsDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsDateIn(List<Date> values) {
            addCriterionForJDBCDate("show_add_send_sms_date in", values, "showAddSendSmsDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("show_add_send_sms_date not in", values, "showAddSendSmsDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("show_add_send_sms_date between", value1, value2, "showAddSendSmsDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendSmsDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("show_add_send_sms_date not between", value1, value2, "showAddSendSmsDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushDateIsNull() {
            addCriterion("show_add_send_jpush_date is null");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushDateIsNotNull() {
            addCriterion("show_add_send_jpush_date is not null");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushDateEqualTo(Date value) {
            addCriterionForJDBCDate("show_add_send_jpush_date =", value, "showAddSendJpushDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("show_add_send_jpush_date <>", value, "showAddSendJpushDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushDateGreaterThan(Date value) {
            addCriterionForJDBCDate("show_add_send_jpush_date >", value, "showAddSendJpushDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("show_add_send_jpush_date >=", value, "showAddSendJpushDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushDateLessThan(Date value) {
            addCriterionForJDBCDate("show_add_send_jpush_date <", value, "showAddSendJpushDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("show_add_send_jpush_date <=", value, "showAddSendJpushDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushDateIn(List<Date> values) {
            addCriterionForJDBCDate("show_add_send_jpush_date in", values, "showAddSendJpushDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("show_add_send_jpush_date not in", values, "showAddSendJpushDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("show_add_send_jpush_date between", value1, value2, "showAddSendJpushDate");
            return (Criteria) this;
        }

        public Criteria andShowAddSendJpushDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("show_add_send_jpush_date not between", value1, value2, "showAddSendJpushDate");
            return (Criteria) this;
        }

        public Criteria andLuckyCountIsNull() {
            addCriterion("lucky_count is null");
            return (Criteria) this;
        }

        public Criteria andLuckyCountIsNotNull() {
            addCriterion("lucky_count is not null");
            return (Criteria) this;
        }

        public Criteria andLuckyCountEqualTo(Integer value) {
            addCriterion("lucky_count =", value, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountNotEqualTo(Integer value) {
            addCriterion("lucky_count <>", value, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountGreaterThan(Integer value) {
            addCriterion("lucky_count >", value, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("lucky_count >=", value, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountLessThan(Integer value) {
            addCriterion("lucky_count <", value, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountLessThanOrEqualTo(Integer value) {
            addCriterion("lucky_count <=", value, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountIn(List<Integer> values) {
            addCriterion("lucky_count in", values, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountNotIn(List<Integer> values) {
            addCriterion("lucky_count not in", values, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountBetween(Integer value1, Integer value2) {
            addCriterion("lucky_count between", value1, value2, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andLuckyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("lucky_count not between", value1, value2, "luckyCount");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberActivityIsNull() {
            addCriterion("phone_number_activity is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberActivityIsNotNull() {
            addCriterion("phone_number_activity is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberActivityEqualTo(Long value) {
            addCriterion("phone_number_activity =", value, "phoneNumberActivity");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberActivityNotEqualTo(Long value) {
            addCriterion("phone_number_activity <>", value, "phoneNumberActivity");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberActivityGreaterThan(Long value) {
            addCriterion("phone_number_activity >", value, "phoneNumberActivity");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberActivityGreaterThanOrEqualTo(Long value) {
            addCriterion("phone_number_activity >=", value, "phoneNumberActivity");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberActivityLessThan(Long value) {
            addCriterion("phone_number_activity <", value, "phoneNumberActivity");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberActivityLessThanOrEqualTo(Long value) {
            addCriterion("phone_number_activity <=", value, "phoneNumberActivity");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberActivityIn(List<Long> values) {
            addCriterion("phone_number_activity in", values, "phoneNumberActivity");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberActivityNotIn(List<Long> values) {
            addCriterion("phone_number_activity not in", values, "phoneNumberActivity");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberActivityBetween(Long value1, Long value2) {
            addCriterion("phone_number_activity between", value1, value2, "phoneNumberActivity");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberActivityNotBetween(Long value1, Long value2) {
            addCriterion("phone_number_activity not between", value1, value2, "phoneNumberActivity");
            return (Criteria) this;
        }

        public Criteria andLuckyShopCountIsNull() {
            addCriterion("lucky_shop_count is null");
            return (Criteria) this;
        }

        public Criteria andLuckyShopCountIsNotNull() {
            addCriterion("lucky_shop_count is not null");
            return (Criteria) this;
        }

        public Criteria andLuckyShopCountEqualTo(Integer value) {
            addCriterion("lucky_shop_count =", value, "luckyShopCount");
            return (Criteria) this;
        }

        public Criteria andLuckyShopCountNotEqualTo(Integer value) {
            addCriterion("lucky_shop_count <>", value, "luckyShopCount");
            return (Criteria) this;
        }

        public Criteria andLuckyShopCountGreaterThan(Integer value) {
            addCriterion("lucky_shop_count >", value, "luckyShopCount");
            return (Criteria) this;
        }

        public Criteria andLuckyShopCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("lucky_shop_count >=", value, "luckyShopCount");
            return (Criteria) this;
        }

        public Criteria andLuckyShopCountLessThan(Integer value) {
            addCriterion("lucky_shop_count <", value, "luckyShopCount");
            return (Criteria) this;
        }

        public Criteria andLuckyShopCountLessThanOrEqualTo(Integer value) {
            addCriterion("lucky_shop_count <=", value, "luckyShopCount");
            return (Criteria) this;
        }

        public Criteria andLuckyShopCountIn(List<Integer> values) {
            addCriterion("lucky_shop_count in", values, "luckyShopCount");
            return (Criteria) this;
        }

        public Criteria andLuckyShopCountNotIn(List<Integer> values) {
            addCriterion("lucky_shop_count not in", values, "luckyShopCount");
            return (Criteria) this;
        }

        public Criteria andLuckyShopCountBetween(Integer value1, Integer value2) {
            addCriterion("lucky_shop_count between", value1, value2, "luckyShopCount");
            return (Criteria) this;
        }

        public Criteria andLuckyShopCountNotBetween(Integer value1, Integer value2) {
            addCriterion("lucky_shop_count not between", value1, value2, "luckyShopCount");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenIdIsNull() {
            addCriterion("weibo_open_id is null");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenIdIsNotNull() {
            addCriterion("weibo_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenIdEqualTo(String value) {
            addCriterion("weibo_open_id =", value, "weiboOpenId");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenIdNotEqualTo(String value) {
            addCriterion("weibo_open_id <>", value, "weiboOpenId");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenIdGreaterThan(String value) {
            addCriterion("weibo_open_id >", value, "weiboOpenId");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("weibo_open_id >=", value, "weiboOpenId");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenIdLessThan(String value) {
            addCriterion("weibo_open_id <", value, "weiboOpenId");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenIdLessThanOrEqualTo(String value) {
            addCriterion("weibo_open_id <=", value, "weiboOpenId");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenIdLike(String value) {
            addCriterion("weibo_open_id like", value, "weiboOpenId");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenIdNotLike(String value) {
            addCriterion("weibo_open_id not like", value, "weiboOpenId");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenIdIn(List<String> values) {
            addCriterion("weibo_open_id in", values, "weiboOpenId");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenIdNotIn(List<String> values) {
            addCriterion("weibo_open_id not in", values, "weiboOpenId");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenIdBetween(String value1, String value2) {
            addCriterion("weibo_open_id between", value1, value2, "weiboOpenId");
            return (Criteria) this;
        }

        public Criteria andWeiboOpenIdNotBetween(String value1, String value2) {
            addCriterion("weibo_open_id not between", value1, value2, "weiboOpenId");
            return (Criteria) this;
        }

        public Criteria andStarImgOneIsNull() {
            addCriterion("star_img_one is null");
            return (Criteria) this;
        }

        public Criteria andStarImgOneIsNotNull() {
            addCriterion("star_img_one is not null");
            return (Criteria) this;
        }

        public Criteria andStarImgOneEqualTo(String value) {
            addCriterion("star_img_one =", value, "starImgOne");
            return (Criteria) this;
        }

        public Criteria andStarImgOneNotEqualTo(String value) {
            addCriterion("star_img_one <>", value, "starImgOne");
            return (Criteria) this;
        }

        public Criteria andStarImgOneGreaterThan(String value) {
            addCriterion("star_img_one >", value, "starImgOne");
            return (Criteria) this;
        }

        public Criteria andStarImgOneGreaterThanOrEqualTo(String value) {
            addCriterion("star_img_one >=", value, "starImgOne");
            return (Criteria) this;
        }

        public Criteria andStarImgOneLessThan(String value) {
            addCriterion("star_img_one <", value, "starImgOne");
            return (Criteria) this;
        }

        public Criteria andStarImgOneLessThanOrEqualTo(String value) {
            addCriterion("star_img_one <=", value, "starImgOne");
            return (Criteria) this;
        }

        public Criteria andStarImgOneLike(String value) {
            addCriterion("star_img_one like", value, "starImgOne");
            return (Criteria) this;
        }

        public Criteria andStarImgOneNotLike(String value) {
            addCriterion("star_img_one not like", value, "starImgOne");
            return (Criteria) this;
        }

        public Criteria andStarImgOneIn(List<String> values) {
            addCriterion("star_img_one in", values, "starImgOne");
            return (Criteria) this;
        }

        public Criteria andStarImgOneNotIn(List<String> values) {
            addCriterion("star_img_one not in", values, "starImgOne");
            return (Criteria) this;
        }

        public Criteria andStarImgOneBetween(String value1, String value2) {
            addCriterion("star_img_one between", value1, value2, "starImgOne");
            return (Criteria) this;
        }

        public Criteria andStarImgOneNotBetween(String value1, String value2) {
            addCriterion("star_img_one not between", value1, value2, "starImgOne");
            return (Criteria) this;
        }

        public Criteria andStarImgTwoIsNull() {
            addCriterion("star_img_two is null");
            return (Criteria) this;
        }

        public Criteria andStarImgTwoIsNotNull() {
            addCriterion("star_img_two is not null");
            return (Criteria) this;
        }

        public Criteria andStarImgTwoEqualTo(String value) {
            addCriterion("star_img_two =", value, "starImgTwo");
            return (Criteria) this;
        }

        public Criteria andStarImgTwoNotEqualTo(String value) {
            addCriterion("star_img_two <>", value, "starImgTwo");
            return (Criteria) this;
        }

        public Criteria andStarImgTwoGreaterThan(String value) {
            addCriterion("star_img_two >", value, "starImgTwo");
            return (Criteria) this;
        }

        public Criteria andStarImgTwoGreaterThanOrEqualTo(String value) {
            addCriterion("star_img_two >=", value, "starImgTwo");
            return (Criteria) this;
        }

        public Criteria andStarImgTwoLessThan(String value) {
            addCriterion("star_img_two <", value, "starImgTwo");
            return (Criteria) this;
        }

        public Criteria andStarImgTwoLessThanOrEqualTo(String value) {
            addCriterion("star_img_two <=", value, "starImgTwo");
            return (Criteria) this;
        }

        public Criteria andStarImgTwoLike(String value) {
            addCriterion("star_img_two like", value, "starImgTwo");
            return (Criteria) this;
        }

        public Criteria andStarImgTwoNotLike(String value) {
            addCriterion("star_img_two not like", value, "starImgTwo");
            return (Criteria) this;
        }

        public Criteria andStarImgTwoIn(List<String> values) {
            addCriterion("star_img_two in", values, "starImgTwo");
            return (Criteria) this;
        }

        public Criteria andStarImgTwoNotIn(List<String> values) {
            addCriterion("star_img_two not in", values, "starImgTwo");
            return (Criteria) this;
        }

        public Criteria andStarImgTwoBetween(String value1, String value2) {
            addCriterion("star_img_two between", value1, value2, "starImgTwo");
            return (Criteria) this;
        }

        public Criteria andStarImgTwoNotBetween(String value1, String value2) {
            addCriterion("star_img_two not between", value1, value2, "starImgTwo");
            return (Criteria) this;
        }

        public Criteria andStarImgThreeIsNull() {
            addCriterion("star_img_three is null");
            return (Criteria) this;
        }

        public Criteria andStarImgThreeIsNotNull() {
            addCriterion("star_img_three is not null");
            return (Criteria) this;
        }

        public Criteria andStarImgThreeEqualTo(String value) {
            addCriterion("star_img_three =", value, "starImgThree");
            return (Criteria) this;
        }

        public Criteria andStarImgThreeNotEqualTo(String value) {
            addCriterion("star_img_three <>", value, "starImgThree");
            return (Criteria) this;
        }

        public Criteria andStarImgThreeGreaterThan(String value) {
            addCriterion("star_img_three >", value, "starImgThree");
            return (Criteria) this;
        }

        public Criteria andStarImgThreeGreaterThanOrEqualTo(String value) {
            addCriterion("star_img_three >=", value, "starImgThree");
            return (Criteria) this;
        }

        public Criteria andStarImgThreeLessThan(String value) {
            addCriterion("star_img_three <", value, "starImgThree");
            return (Criteria) this;
        }

        public Criteria andStarImgThreeLessThanOrEqualTo(String value) {
            addCriterion("star_img_three <=", value, "starImgThree");
            return (Criteria) this;
        }

        public Criteria andStarImgThreeLike(String value) {
            addCriterion("star_img_three like", value, "starImgThree");
            return (Criteria) this;
        }

        public Criteria andStarImgThreeNotLike(String value) {
            addCriterion("star_img_three not like", value, "starImgThree");
            return (Criteria) this;
        }

        public Criteria andStarImgThreeIn(List<String> values) {
            addCriterion("star_img_three in", values, "starImgThree");
            return (Criteria) this;
        }

        public Criteria andStarImgThreeNotIn(List<String> values) {
            addCriterion("star_img_three not in", values, "starImgThree");
            return (Criteria) this;
        }

        public Criteria andStarImgThreeBetween(String value1, String value2) {
            addCriterion("star_img_three between", value1, value2, "starImgThree");
            return (Criteria) this;
        }

        public Criteria andStarImgThreeNotBetween(String value1, String value2) {
            addCriterion("star_img_three not between", value1, value2, "starImgThree");
            return (Criteria) this;
        }

        public Criteria andStarIdOneIsNull() {
            addCriterion("star_id_one is null");
            return (Criteria) this;
        }

        public Criteria andStarIdOneIsNotNull() {
            addCriterion("star_id_one is not null");
            return (Criteria) this;
        }

        public Criteria andStarIdOneEqualTo(Long value) {
            addCriterion("star_id_one =", value, "starIdOne");
            return (Criteria) this;
        }

        public Criteria andStarIdOneNotEqualTo(Long value) {
            addCriterion("star_id_one <>", value, "starIdOne");
            return (Criteria) this;
        }

        public Criteria andStarIdOneGreaterThan(Long value) {
            addCriterion("star_id_one >", value, "starIdOne");
            return (Criteria) this;
        }

        public Criteria andStarIdOneGreaterThanOrEqualTo(Long value) {
            addCriterion("star_id_one >=", value, "starIdOne");
            return (Criteria) this;
        }

        public Criteria andStarIdOneLessThan(Long value) {
            addCriterion("star_id_one <", value, "starIdOne");
            return (Criteria) this;
        }

        public Criteria andStarIdOneLessThanOrEqualTo(Long value) {
            addCriterion("star_id_one <=", value, "starIdOne");
            return (Criteria) this;
        }

        public Criteria andStarIdOneIn(List<Long> values) {
            addCriterion("star_id_one in", values, "starIdOne");
            return (Criteria) this;
        }

        public Criteria andStarIdOneNotIn(List<Long> values) {
            addCriterion("star_id_one not in", values, "starIdOne");
            return (Criteria) this;
        }

        public Criteria andStarIdOneBetween(Long value1, Long value2) {
            addCriterion("star_id_one between", value1, value2, "starIdOne");
            return (Criteria) this;
        }

        public Criteria andStarIdOneNotBetween(Long value1, Long value2) {
            addCriterion("star_id_one not between", value1, value2, "starIdOne");
            return (Criteria) this;
        }

        public Criteria andStarIdTwoIsNull() {
            addCriterion("star_id_two is null");
            return (Criteria) this;
        }

        public Criteria andStarIdTwoIsNotNull() {
            addCriterion("star_id_two is not null");
            return (Criteria) this;
        }

        public Criteria andStarIdTwoEqualTo(Long value) {
            addCriterion("star_id_two =", value, "starIdTwo");
            return (Criteria) this;
        }

        public Criteria andStarIdTwoNotEqualTo(Long value) {
            addCriterion("star_id_two <>", value, "starIdTwo");
            return (Criteria) this;
        }

        public Criteria andStarIdTwoGreaterThan(Long value) {
            addCriterion("star_id_two >", value, "starIdTwo");
            return (Criteria) this;
        }

        public Criteria andStarIdTwoGreaterThanOrEqualTo(Long value) {
            addCriterion("star_id_two >=", value, "starIdTwo");
            return (Criteria) this;
        }

        public Criteria andStarIdTwoLessThan(Long value) {
            addCriterion("star_id_two <", value, "starIdTwo");
            return (Criteria) this;
        }

        public Criteria andStarIdTwoLessThanOrEqualTo(Long value) {
            addCriterion("star_id_two <=", value, "starIdTwo");
            return (Criteria) this;
        }

        public Criteria andStarIdTwoIn(List<Long> values) {
            addCriterion("star_id_two in", values, "starIdTwo");
            return (Criteria) this;
        }

        public Criteria andStarIdTwoNotIn(List<Long> values) {
            addCriterion("star_id_two not in", values, "starIdTwo");
            return (Criteria) this;
        }

        public Criteria andStarIdTwoBetween(Long value1, Long value2) {
            addCriterion("star_id_two between", value1, value2, "starIdTwo");
            return (Criteria) this;
        }

        public Criteria andStarIdTwoNotBetween(Long value1, Long value2) {
            addCriterion("star_id_two not between", value1, value2, "starIdTwo");
            return (Criteria) this;
        }

        public Criteria andStarIdThreeIsNull() {
            addCriterion("star_id_three is null");
            return (Criteria) this;
        }

        public Criteria andStarIdThreeIsNotNull() {
            addCriterion("star_id_three is not null");
            return (Criteria) this;
        }

        public Criteria andStarIdThreeEqualTo(Long value) {
            addCriterion("star_id_three =", value, "starIdThree");
            return (Criteria) this;
        }

        public Criteria andStarIdThreeNotEqualTo(Long value) {
            addCriterion("star_id_three <>", value, "starIdThree");
            return (Criteria) this;
        }

        public Criteria andStarIdThreeGreaterThan(Long value) {
            addCriterion("star_id_three >", value, "starIdThree");
            return (Criteria) this;
        }

        public Criteria andStarIdThreeGreaterThanOrEqualTo(Long value) {
            addCriterion("star_id_three >=", value, "starIdThree");
            return (Criteria) this;
        }

        public Criteria andStarIdThreeLessThan(Long value) {
            addCriterion("star_id_three <", value, "starIdThree");
            return (Criteria) this;
        }

        public Criteria andStarIdThreeLessThanOrEqualTo(Long value) {
            addCriterion("star_id_three <=", value, "starIdThree");
            return (Criteria) this;
        }

        public Criteria andStarIdThreeIn(List<Long> values) {
            addCriterion("star_id_three in", values, "starIdThree");
            return (Criteria) this;
        }

        public Criteria andStarIdThreeNotIn(List<Long> values) {
            addCriterion("star_id_three not in", values, "starIdThree");
            return (Criteria) this;
        }

        public Criteria andStarIdThreeBetween(Long value1, Long value2) {
            addCriterion("star_id_three between", value1, value2, "starIdThree");
            return (Criteria) this;
        }

        public Criteria andStarIdThreeNotBetween(Long value1, Long value2) {
            addCriterion("star_id_three not between", value1, value2, "starIdThree");
            return (Criteria) this;
        }

        public Criteria andVoteCountOneIsNull() {
            addCriterion("vote_count_one is null");
            return (Criteria) this;
        }

        public Criteria andVoteCountOneIsNotNull() {
            addCriterion("vote_count_one is not null");
            return (Criteria) this;
        }

        public Criteria andVoteCountOneEqualTo(Integer value) {
            addCriterion("vote_count_one =", value, "voteCountOne");
            return (Criteria) this;
        }

        public Criteria andVoteCountOneNotEqualTo(Integer value) {
            addCriterion("vote_count_one <>", value, "voteCountOne");
            return (Criteria) this;
        }

        public Criteria andVoteCountOneGreaterThan(Integer value) {
            addCriterion("vote_count_one >", value, "voteCountOne");
            return (Criteria) this;
        }

        public Criteria andVoteCountOneGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_count_one >=", value, "voteCountOne");
            return (Criteria) this;
        }

        public Criteria andVoteCountOneLessThan(Integer value) {
            addCriterion("vote_count_one <", value, "voteCountOne");
            return (Criteria) this;
        }

        public Criteria andVoteCountOneLessThanOrEqualTo(Integer value) {
            addCriterion("vote_count_one <=", value, "voteCountOne");
            return (Criteria) this;
        }

        public Criteria andVoteCountOneIn(List<Integer> values) {
            addCriterion("vote_count_one in", values, "voteCountOne");
            return (Criteria) this;
        }

        public Criteria andVoteCountOneNotIn(List<Integer> values) {
            addCriterion("vote_count_one not in", values, "voteCountOne");
            return (Criteria) this;
        }

        public Criteria andVoteCountOneBetween(Integer value1, Integer value2) {
            addCriterion("vote_count_one between", value1, value2, "voteCountOne");
            return (Criteria) this;
        }

        public Criteria andVoteCountOneNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_count_one not between", value1, value2, "voteCountOne");
            return (Criteria) this;
        }

        public Criteria andVoteCountTwoIsNull() {
            addCriterion("vote_count_two is null");
            return (Criteria) this;
        }

        public Criteria andVoteCountTwoIsNotNull() {
            addCriterion("vote_count_two is not null");
            return (Criteria) this;
        }

        public Criteria andVoteCountTwoEqualTo(Integer value) {
            addCriterion("vote_count_two =", value, "voteCountTwo");
            return (Criteria) this;
        }

        public Criteria andVoteCountTwoNotEqualTo(Integer value) {
            addCriterion("vote_count_two <>", value, "voteCountTwo");
            return (Criteria) this;
        }

        public Criteria andVoteCountTwoGreaterThan(Integer value) {
            addCriterion("vote_count_two >", value, "voteCountTwo");
            return (Criteria) this;
        }

        public Criteria andVoteCountTwoGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_count_two >=", value, "voteCountTwo");
            return (Criteria) this;
        }

        public Criteria andVoteCountTwoLessThan(Integer value) {
            addCriterion("vote_count_two <", value, "voteCountTwo");
            return (Criteria) this;
        }

        public Criteria andVoteCountTwoLessThanOrEqualTo(Integer value) {
            addCriterion("vote_count_two <=", value, "voteCountTwo");
            return (Criteria) this;
        }

        public Criteria andVoteCountTwoIn(List<Integer> values) {
            addCriterion("vote_count_two in", values, "voteCountTwo");
            return (Criteria) this;
        }

        public Criteria andVoteCountTwoNotIn(List<Integer> values) {
            addCriterion("vote_count_two not in", values, "voteCountTwo");
            return (Criteria) this;
        }

        public Criteria andVoteCountTwoBetween(Integer value1, Integer value2) {
            addCriterion("vote_count_two between", value1, value2, "voteCountTwo");
            return (Criteria) this;
        }

        public Criteria andVoteCountTwoNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_count_two not between", value1, value2, "voteCountTwo");
            return (Criteria) this;
        }

        public Criteria andVoteCountThreeIsNull() {
            addCriterion("vote_count_three is null");
            return (Criteria) this;
        }

        public Criteria andVoteCountThreeIsNotNull() {
            addCriterion("vote_count_three is not null");
            return (Criteria) this;
        }

        public Criteria andVoteCountThreeEqualTo(Integer value) {
            addCriterion("vote_count_three =", value, "voteCountThree");
            return (Criteria) this;
        }

        public Criteria andVoteCountThreeNotEqualTo(Integer value) {
            addCriterion("vote_count_three <>", value, "voteCountThree");
            return (Criteria) this;
        }

        public Criteria andVoteCountThreeGreaterThan(Integer value) {
            addCriterion("vote_count_three >", value, "voteCountThree");
            return (Criteria) this;
        }

        public Criteria andVoteCountThreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_count_three >=", value, "voteCountThree");
            return (Criteria) this;
        }

        public Criteria andVoteCountThreeLessThan(Integer value) {
            addCriterion("vote_count_three <", value, "voteCountThree");
            return (Criteria) this;
        }

        public Criteria andVoteCountThreeLessThanOrEqualTo(Integer value) {
            addCriterion("vote_count_three <=", value, "voteCountThree");
            return (Criteria) this;
        }

        public Criteria andVoteCountThreeIn(List<Integer> values) {
            addCriterion("vote_count_three in", values, "voteCountThree");
            return (Criteria) this;
        }

        public Criteria andVoteCountThreeNotIn(List<Integer> values) {
            addCriterion("vote_count_three not in", values, "voteCountThree");
            return (Criteria) this;
        }

        public Criteria andVoteCountThreeBetween(Integer value1, Integer value2) {
            addCriterion("vote_count_three between", value1, value2, "voteCountThree");
            return (Criteria) this;
        }

        public Criteria andVoteCountThreeNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_count_three not between", value1, value2, "voteCountThree");
            return (Criteria) this;
        }

        public Criteria andStarDescOneIsNull() {
            addCriterion("star_desc_one is null");
            return (Criteria) this;
        }

        public Criteria andStarDescOneIsNotNull() {
            addCriterion("star_desc_one is not null");
            return (Criteria) this;
        }

        public Criteria andStarDescOneEqualTo(String value) {
            addCriterion("star_desc_one =", value, "starDescOne");
            return (Criteria) this;
        }

        public Criteria andStarDescOneNotEqualTo(String value) {
            addCriterion("star_desc_one <>", value, "starDescOne");
            return (Criteria) this;
        }

        public Criteria andStarDescOneGreaterThan(String value) {
            addCriterion("star_desc_one >", value, "starDescOne");
            return (Criteria) this;
        }

        public Criteria andStarDescOneGreaterThanOrEqualTo(String value) {
            addCriterion("star_desc_one >=", value, "starDescOne");
            return (Criteria) this;
        }

        public Criteria andStarDescOneLessThan(String value) {
            addCriterion("star_desc_one <", value, "starDescOne");
            return (Criteria) this;
        }

        public Criteria andStarDescOneLessThanOrEqualTo(String value) {
            addCriterion("star_desc_one <=", value, "starDescOne");
            return (Criteria) this;
        }

        public Criteria andStarDescOneLike(String value) {
            addCriterion("star_desc_one like", value, "starDescOne");
            return (Criteria) this;
        }

        public Criteria andStarDescOneNotLike(String value) {
            addCriterion("star_desc_one not like", value, "starDescOne");
            return (Criteria) this;
        }

        public Criteria andStarDescOneIn(List<String> values) {
            addCriterion("star_desc_one in", values, "starDescOne");
            return (Criteria) this;
        }

        public Criteria andStarDescOneNotIn(List<String> values) {
            addCriterion("star_desc_one not in", values, "starDescOne");
            return (Criteria) this;
        }

        public Criteria andStarDescOneBetween(String value1, String value2) {
            addCriterion("star_desc_one between", value1, value2, "starDescOne");
            return (Criteria) this;
        }

        public Criteria andStarDescOneNotBetween(String value1, String value2) {
            addCriterion("star_desc_one not between", value1, value2, "starDescOne");
            return (Criteria) this;
        }

        public Criteria andStarDescTwoIsNull() {
            addCriterion("star_desc_two is null");
            return (Criteria) this;
        }

        public Criteria andStarDescTwoIsNotNull() {
            addCriterion("star_desc_two is not null");
            return (Criteria) this;
        }

        public Criteria andStarDescTwoEqualTo(String value) {
            addCriterion("star_desc_two =", value, "starDescTwo");
            return (Criteria) this;
        }

        public Criteria andStarDescTwoNotEqualTo(String value) {
            addCriterion("star_desc_two <>", value, "starDescTwo");
            return (Criteria) this;
        }

        public Criteria andStarDescTwoGreaterThan(String value) {
            addCriterion("star_desc_two >", value, "starDescTwo");
            return (Criteria) this;
        }

        public Criteria andStarDescTwoGreaterThanOrEqualTo(String value) {
            addCriterion("star_desc_two >=", value, "starDescTwo");
            return (Criteria) this;
        }

        public Criteria andStarDescTwoLessThan(String value) {
            addCriterion("star_desc_two <", value, "starDescTwo");
            return (Criteria) this;
        }

        public Criteria andStarDescTwoLessThanOrEqualTo(String value) {
            addCriterion("star_desc_two <=", value, "starDescTwo");
            return (Criteria) this;
        }

        public Criteria andStarDescTwoLike(String value) {
            addCriterion("star_desc_two like", value, "starDescTwo");
            return (Criteria) this;
        }

        public Criteria andStarDescTwoNotLike(String value) {
            addCriterion("star_desc_two not like", value, "starDescTwo");
            return (Criteria) this;
        }

        public Criteria andStarDescTwoIn(List<String> values) {
            addCriterion("star_desc_two in", values, "starDescTwo");
            return (Criteria) this;
        }

        public Criteria andStarDescTwoNotIn(List<String> values) {
            addCriterion("star_desc_two not in", values, "starDescTwo");
            return (Criteria) this;
        }

        public Criteria andStarDescTwoBetween(String value1, String value2) {
            addCriterion("star_desc_two between", value1, value2, "starDescTwo");
            return (Criteria) this;
        }

        public Criteria andStarDescTwoNotBetween(String value1, String value2) {
            addCriterion("star_desc_two not between", value1, value2, "starDescTwo");
            return (Criteria) this;
        }

        public Criteria andStarDescThreeIsNull() {
            addCriterion("star_desc_three is null");
            return (Criteria) this;
        }

        public Criteria andStarDescThreeIsNotNull() {
            addCriterion("star_desc_three is not null");
            return (Criteria) this;
        }

        public Criteria andStarDescThreeEqualTo(String value) {
            addCriterion("star_desc_three =", value, "starDescThree");
            return (Criteria) this;
        }

        public Criteria andStarDescThreeNotEqualTo(String value) {
            addCriterion("star_desc_three <>", value, "starDescThree");
            return (Criteria) this;
        }

        public Criteria andStarDescThreeGreaterThan(String value) {
            addCriterion("star_desc_three >", value, "starDescThree");
            return (Criteria) this;
        }

        public Criteria andStarDescThreeGreaterThanOrEqualTo(String value) {
            addCriterion("star_desc_three >=", value, "starDescThree");
            return (Criteria) this;
        }

        public Criteria andStarDescThreeLessThan(String value) {
            addCriterion("star_desc_three <", value, "starDescThree");
            return (Criteria) this;
        }

        public Criteria andStarDescThreeLessThanOrEqualTo(String value) {
            addCriterion("star_desc_three <=", value, "starDescThree");
            return (Criteria) this;
        }

        public Criteria andStarDescThreeLike(String value) {
            addCriterion("star_desc_three like", value, "starDescThree");
            return (Criteria) this;
        }

        public Criteria andStarDescThreeNotLike(String value) {
            addCriterion("star_desc_three not like", value, "starDescThree");
            return (Criteria) this;
        }

        public Criteria andStarDescThreeIn(List<String> values) {
            addCriterion("star_desc_three in", values, "starDescThree");
            return (Criteria) this;
        }

        public Criteria andStarDescThreeNotIn(List<String> values) {
            addCriterion("star_desc_three not in", values, "starDescThree");
            return (Criteria) this;
        }

        public Criteria andStarDescThreeBetween(String value1, String value2) {
            addCriterion("star_desc_three between", value1, value2, "starDescThree");
            return (Criteria) this;
        }

        public Criteria andStarDescThreeNotBetween(String value1, String value2) {
            addCriterion("star_desc_three not between", value1, value2, "starDescThree");
            return (Criteria) this;
        }

        public Criteria andStarSexOneIsNull() {
            addCriterion("star_sex_one is null");
            return (Criteria) this;
        }

        public Criteria andStarSexOneIsNotNull() {
            addCriterion("star_sex_one is not null");
            return (Criteria) this;
        }

        public Criteria andStarSexOneEqualTo(String value) {
            addCriterion("star_sex_one =", value, "starSexOne");
            return (Criteria) this;
        }

        public Criteria andStarSexOneNotEqualTo(String value) {
            addCriterion("star_sex_one <>", value, "starSexOne");
            return (Criteria) this;
        }

        public Criteria andStarSexOneGreaterThan(String value) {
            addCriterion("star_sex_one >", value, "starSexOne");
            return (Criteria) this;
        }

        public Criteria andStarSexOneGreaterThanOrEqualTo(String value) {
            addCriterion("star_sex_one >=", value, "starSexOne");
            return (Criteria) this;
        }

        public Criteria andStarSexOneLessThan(String value) {
            addCriterion("star_sex_one <", value, "starSexOne");
            return (Criteria) this;
        }

        public Criteria andStarSexOneLessThanOrEqualTo(String value) {
            addCriterion("star_sex_one <=", value, "starSexOne");
            return (Criteria) this;
        }

        public Criteria andStarSexOneLike(String value) {
            addCriterion("star_sex_one like", value, "starSexOne");
            return (Criteria) this;
        }

        public Criteria andStarSexOneNotLike(String value) {
            addCriterion("star_sex_one not like", value, "starSexOne");
            return (Criteria) this;
        }

        public Criteria andStarSexOneIn(List<String> values) {
            addCriterion("star_sex_one in", values, "starSexOne");
            return (Criteria) this;
        }

        public Criteria andStarSexOneNotIn(List<String> values) {
            addCriterion("star_sex_one not in", values, "starSexOne");
            return (Criteria) this;
        }

        public Criteria andStarSexOneBetween(String value1, String value2) {
            addCriterion("star_sex_one between", value1, value2, "starSexOne");
            return (Criteria) this;
        }

        public Criteria andStarSexOneNotBetween(String value1, String value2) {
            addCriterion("star_sex_one not between", value1, value2, "starSexOne");
            return (Criteria) this;
        }

        public Criteria andStarSexTwoIsNull() {
            addCriterion("star_sex_two is null");
            return (Criteria) this;
        }

        public Criteria andStarSexTwoIsNotNull() {
            addCriterion("star_sex_two is not null");
            return (Criteria) this;
        }

        public Criteria andStarSexTwoEqualTo(String value) {
            addCriterion("star_sex_two =", value, "starSexTwo");
            return (Criteria) this;
        }

        public Criteria andStarSexTwoNotEqualTo(String value) {
            addCriterion("star_sex_two <>", value, "starSexTwo");
            return (Criteria) this;
        }

        public Criteria andStarSexTwoGreaterThan(String value) {
            addCriterion("star_sex_two >", value, "starSexTwo");
            return (Criteria) this;
        }

        public Criteria andStarSexTwoGreaterThanOrEqualTo(String value) {
            addCriterion("star_sex_two >=", value, "starSexTwo");
            return (Criteria) this;
        }

        public Criteria andStarSexTwoLessThan(String value) {
            addCriterion("star_sex_two <", value, "starSexTwo");
            return (Criteria) this;
        }

        public Criteria andStarSexTwoLessThanOrEqualTo(String value) {
            addCriterion("star_sex_two <=", value, "starSexTwo");
            return (Criteria) this;
        }

        public Criteria andStarSexTwoLike(String value) {
            addCriterion("star_sex_two like", value, "starSexTwo");
            return (Criteria) this;
        }

        public Criteria andStarSexTwoNotLike(String value) {
            addCriterion("star_sex_two not like", value, "starSexTwo");
            return (Criteria) this;
        }

        public Criteria andStarSexTwoIn(List<String> values) {
            addCriterion("star_sex_two in", values, "starSexTwo");
            return (Criteria) this;
        }

        public Criteria andStarSexTwoNotIn(List<String> values) {
            addCriterion("star_sex_two not in", values, "starSexTwo");
            return (Criteria) this;
        }

        public Criteria andStarSexTwoBetween(String value1, String value2) {
            addCriterion("star_sex_two between", value1, value2, "starSexTwo");
            return (Criteria) this;
        }

        public Criteria andStarSexTwoNotBetween(String value1, String value2) {
            addCriterion("star_sex_two not between", value1, value2, "starSexTwo");
            return (Criteria) this;
        }

        public Criteria andStarSexThreeIsNull() {
            addCriterion("star_sex_three is null");
            return (Criteria) this;
        }

        public Criteria andStarSexThreeIsNotNull() {
            addCriterion("star_sex_three is not null");
            return (Criteria) this;
        }

        public Criteria andStarSexThreeEqualTo(String value) {
            addCriterion("star_sex_three =", value, "starSexThree");
            return (Criteria) this;
        }

        public Criteria andStarSexThreeNotEqualTo(String value) {
            addCriterion("star_sex_three <>", value, "starSexThree");
            return (Criteria) this;
        }

        public Criteria andStarSexThreeGreaterThan(String value) {
            addCriterion("star_sex_three >", value, "starSexThree");
            return (Criteria) this;
        }

        public Criteria andStarSexThreeGreaterThanOrEqualTo(String value) {
            addCriterion("star_sex_three >=", value, "starSexThree");
            return (Criteria) this;
        }

        public Criteria andStarSexThreeLessThan(String value) {
            addCriterion("star_sex_three <", value, "starSexThree");
            return (Criteria) this;
        }

        public Criteria andStarSexThreeLessThanOrEqualTo(String value) {
            addCriterion("star_sex_three <=", value, "starSexThree");
            return (Criteria) this;
        }

        public Criteria andStarSexThreeLike(String value) {
            addCriterion("star_sex_three like", value, "starSexThree");
            return (Criteria) this;
        }

        public Criteria andStarSexThreeNotLike(String value) {
            addCriterion("star_sex_three not like", value, "starSexThree");
            return (Criteria) this;
        }

        public Criteria andStarSexThreeIn(List<String> values) {
            addCriterion("star_sex_three in", values, "starSexThree");
            return (Criteria) this;
        }

        public Criteria andStarSexThreeNotIn(List<String> values) {
            addCriterion("star_sex_three not in", values, "starSexThree");
            return (Criteria) this;
        }

        public Criteria andStarSexThreeBetween(String value1, String value2) {
            addCriterion("star_sex_three between", value1, value2, "starSexThree");
            return (Criteria) this;
        }

        public Criteria andStarSexThreeNotBetween(String value1, String value2) {
            addCriterion("star_sex_three not between", value1, value2, "starSexThree");
            return (Criteria) this;
        }

        public Criteria andStarLevelOneIsNull() {
            addCriterion("star_level_one is null");
            return (Criteria) this;
        }

        public Criteria andStarLevelOneIsNotNull() {
            addCriterion("star_level_one is not null");
            return (Criteria) this;
        }

        public Criteria andStarLevelOneEqualTo(Integer value) {
            addCriterion("star_level_one =", value, "starLevelOne");
            return (Criteria) this;
        }

        public Criteria andStarLevelOneNotEqualTo(Integer value) {
            addCriterion("star_level_one <>", value, "starLevelOne");
            return (Criteria) this;
        }

        public Criteria andStarLevelOneGreaterThan(Integer value) {
            addCriterion("star_level_one >", value, "starLevelOne");
            return (Criteria) this;
        }

        public Criteria andStarLevelOneGreaterThanOrEqualTo(Integer value) {
            addCriterion("star_level_one >=", value, "starLevelOne");
            return (Criteria) this;
        }

        public Criteria andStarLevelOneLessThan(Integer value) {
            addCriterion("star_level_one <", value, "starLevelOne");
            return (Criteria) this;
        }

        public Criteria andStarLevelOneLessThanOrEqualTo(Integer value) {
            addCriterion("star_level_one <=", value, "starLevelOne");
            return (Criteria) this;
        }

        public Criteria andStarLevelOneIn(List<Integer> values) {
            addCriterion("star_level_one in", values, "starLevelOne");
            return (Criteria) this;
        }

        public Criteria andStarLevelOneNotIn(List<Integer> values) {
            addCriterion("star_level_one not in", values, "starLevelOne");
            return (Criteria) this;
        }

        public Criteria andStarLevelOneBetween(Integer value1, Integer value2) {
            addCriterion("star_level_one between", value1, value2, "starLevelOne");
            return (Criteria) this;
        }

        public Criteria andStarLevelOneNotBetween(Integer value1, Integer value2) {
            addCriterion("star_level_one not between", value1, value2, "starLevelOne");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageImgIsNull() {
            addCriterion("personal_homepage_img is null");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageImgIsNotNull() {
            addCriterion("personal_homepage_img is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageImgEqualTo(String value) {
            addCriterion("personal_homepage_img =", value, "personalHomepageImg");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageImgNotEqualTo(String value) {
            addCriterion("personal_homepage_img <>", value, "personalHomepageImg");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageImgGreaterThan(String value) {
            addCriterion("personal_homepage_img >", value, "personalHomepageImg");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageImgGreaterThanOrEqualTo(String value) {
            addCriterion("personal_homepage_img >=", value, "personalHomepageImg");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageImgLessThan(String value) {
            addCriterion("personal_homepage_img <", value, "personalHomepageImg");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageImgLessThanOrEqualTo(String value) {
            addCriterion("personal_homepage_img <=", value, "personalHomepageImg");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageImgLike(String value) {
            addCriterion("personal_homepage_img like", value, "personalHomepageImg");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageImgNotLike(String value) {
            addCriterion("personal_homepage_img not like", value, "personalHomepageImg");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageImgIn(List<String> values) {
            addCriterion("personal_homepage_img in", values, "personalHomepageImg");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageImgNotIn(List<String> values) {
            addCriterion("personal_homepage_img not in", values, "personalHomepageImg");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageImgBetween(String value1, String value2) {
            addCriterion("personal_homepage_img between", value1, value2, "personalHomepageImg");
            return (Criteria) this;
        }

        public Criteria andPersonalHomepageImgNotBetween(String value1, String value2) {
            addCriterion("personal_homepage_img not between", value1, value2, "personalHomepageImg");
            return (Criteria) this;
        }

        public Criteria andPersonalAutographIsNull() {
            addCriterion("personal_autograph is null");
            return (Criteria) this;
        }

        public Criteria andPersonalAutographIsNotNull() {
            addCriterion("personal_autograph is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalAutographEqualTo(String value) {
            addCriterion("personal_autograph =", value, "personalAutograph");
            return (Criteria) this;
        }

        public Criteria andPersonalAutographNotEqualTo(String value) {
            addCriterion("personal_autograph <>", value, "personalAutograph");
            return (Criteria) this;
        }

        public Criteria andPersonalAutographGreaterThan(String value) {
            addCriterion("personal_autograph >", value, "personalAutograph");
            return (Criteria) this;
        }

        public Criteria andPersonalAutographGreaterThanOrEqualTo(String value) {
            addCriterion("personal_autograph >=", value, "personalAutograph");
            return (Criteria) this;
        }

        public Criteria andPersonalAutographLessThan(String value) {
            addCriterion("personal_autograph <", value, "personalAutograph");
            return (Criteria) this;
        }

        public Criteria andPersonalAutographLessThanOrEqualTo(String value) {
            addCriterion("personal_autograph <=", value, "personalAutograph");
            return (Criteria) this;
        }

        public Criteria andPersonalAutographLike(String value) {
            addCriterion("personal_autograph like", value, "personalAutograph");
            return (Criteria) this;
        }

        public Criteria andPersonalAutographNotLike(String value) {
            addCriterion("personal_autograph not like", value, "personalAutograph");
            return (Criteria) this;
        }

        public Criteria andPersonalAutographIn(List<String> values) {
            addCriterion("personal_autograph in", values, "personalAutograph");
            return (Criteria) this;
        }

        public Criteria andPersonalAutographNotIn(List<String> values) {
            addCriterion("personal_autograph not in", values, "personalAutograph");
            return (Criteria) this;
        }

        public Criteria andPersonalAutographBetween(String value1, String value2) {
            addCriterion("personal_autograph between", value1, value2, "personalAutograph");
            return (Criteria) this;
        }

        public Criteria andPersonalAutographNotBetween(String value1, String value2) {
            addCriterion("personal_autograph not between", value1, value2, "personalAutograph");
            return (Criteria) this;
        }

        public Criteria andHeartCountIsNull() {
            addCriterion("heart_count is null");
            return (Criteria) this;
        }

        public Criteria andHeartCountIsNotNull() {
            addCriterion("heart_count is not null");
            return (Criteria) this;
        }

        public Criteria andHeartCountEqualTo(Long value) {
            addCriterion("heart_count =", value, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountNotEqualTo(Long value) {
            addCriterion("heart_count <>", value, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountGreaterThan(Long value) {
            addCriterion("heart_count >", value, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountGreaterThanOrEqualTo(Long value) {
            addCriterion("heart_count >=", value, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountLessThan(Long value) {
            addCriterion("heart_count <", value, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountLessThanOrEqualTo(Long value) {
            addCriterion("heart_count <=", value, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountIn(List<Long> values) {
            addCriterion("heart_count in", values, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountNotIn(List<Long> values) {
            addCriterion("heart_count not in", values, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountBetween(Long value1, Long value2) {
            addCriterion("heart_count between", value1, value2, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountNotBetween(Long value1, Long value2) {
            addCriterion("heart_count not between", value1, value2, "heartCount");
            return (Criteria) this;
        }

        public Criteria andHeartCountTodayIsNull() {
            addCriterion("heart_count_today is null");
            return (Criteria) this;
        }

        public Criteria andHeartCountTodayIsNotNull() {
            addCriterion("heart_count_today is not null");
            return (Criteria) this;
        }

        public Criteria andHeartCountTodayEqualTo(Integer value) {
            addCriterion("heart_count_today =", value, "heartCountToday");
            return (Criteria) this;
        }

        public Criteria andHeartCountTodayNotEqualTo(Integer value) {
            addCriterion("heart_count_today <>", value, "heartCountToday");
            return (Criteria) this;
        }

        public Criteria andHeartCountTodayGreaterThan(Integer value) {
            addCriterion("heart_count_today >", value, "heartCountToday");
            return (Criteria) this;
        }

        public Criteria andHeartCountTodayGreaterThanOrEqualTo(Integer value) {
            addCriterion("heart_count_today >=", value, "heartCountToday");
            return (Criteria) this;
        }

        public Criteria andHeartCountTodayLessThan(Integer value) {
            addCriterion("heart_count_today <", value, "heartCountToday");
            return (Criteria) this;
        }

        public Criteria andHeartCountTodayLessThanOrEqualTo(Integer value) {
            addCriterion("heart_count_today <=", value, "heartCountToday");
            return (Criteria) this;
        }

        public Criteria andHeartCountTodayIn(List<Integer> values) {
            addCriterion("heart_count_today in", values, "heartCountToday");
            return (Criteria) this;
        }

        public Criteria andHeartCountTodayNotIn(List<Integer> values) {
            addCriterion("heart_count_today not in", values, "heartCountToday");
            return (Criteria) this;
        }

        public Criteria andHeartCountTodayBetween(Integer value1, Integer value2) {
            addCriterion("heart_count_today between", value1, value2, "heartCountToday");
            return (Criteria) this;
        }

        public Criteria andHeartCountTodayNotBetween(Integer value1, Integer value2) {
            addCriterion("heart_count_today not between", value1, value2, "heartCountToday");
            return (Criteria) this;
        }

        public Criteria andHeartDonateCountIsNull() {
            addCriterion("heart_donate_count is null");
            return (Criteria) this;
        }

        public Criteria andHeartDonateCountIsNotNull() {
            addCriterion("heart_donate_count is not null");
            return (Criteria) this;
        }

        public Criteria andHeartDonateCountEqualTo(Long value) {
            addCriterion("heart_donate_count =", value, "heartDonateCount");
            return (Criteria) this;
        }

        public Criteria andHeartDonateCountNotEqualTo(Long value) {
            addCriterion("heart_donate_count <>", value, "heartDonateCount");
            return (Criteria) this;
        }

        public Criteria andHeartDonateCountGreaterThan(Long value) {
            addCriterion("heart_donate_count >", value, "heartDonateCount");
            return (Criteria) this;
        }

        public Criteria andHeartDonateCountGreaterThanOrEqualTo(Long value) {
            addCriterion("heart_donate_count >=", value, "heartDonateCount");
            return (Criteria) this;
        }

        public Criteria andHeartDonateCountLessThan(Long value) {
            addCriterion("heart_donate_count <", value, "heartDonateCount");
            return (Criteria) this;
        }

        public Criteria andHeartDonateCountLessThanOrEqualTo(Long value) {
            addCriterion("heart_donate_count <=", value, "heartDonateCount");
            return (Criteria) this;
        }

        public Criteria andHeartDonateCountIn(List<Long> values) {
            addCriterion("heart_donate_count in", values, "heartDonateCount");
            return (Criteria) this;
        }

        public Criteria andHeartDonateCountNotIn(List<Long> values) {
            addCriterion("heart_donate_count not in", values, "heartDonateCount");
            return (Criteria) this;
        }

        public Criteria andHeartDonateCountBetween(Long value1, Long value2) {
            addCriterion("heart_donate_count between", value1, value2, "heartDonateCount");
            return (Criteria) this;
        }

        public Criteria andHeartDonateCountNotBetween(Long value1, Long value2) {
            addCriterion("heart_donate_count not between", value1, value2, "heartDonateCount");
            return (Criteria) this;
        }

        public Criteria andMoneyDonateCountIsNull() {
            addCriterion("money_donate_count is null");
            return (Criteria) this;
        }

        public Criteria andMoneyDonateCountIsNotNull() {
            addCriterion("money_donate_count is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyDonateCountEqualTo(Double value) {
            addCriterion("money_donate_count =", value, "moneyDonateCount");
            return (Criteria) this;
        }

        public Criteria andMoneyDonateCountNotEqualTo(Double value) {
            addCriterion("money_donate_count <>", value, "moneyDonateCount");
            return (Criteria) this;
        }

        public Criteria andMoneyDonateCountGreaterThan(Double value) {
            addCriterion("money_donate_count >", value, "moneyDonateCount");
            return (Criteria) this;
        }

        public Criteria andMoneyDonateCountGreaterThanOrEqualTo(Double value) {
            addCriterion("money_donate_count >=", value, "moneyDonateCount");
            return (Criteria) this;
        }

        public Criteria andMoneyDonateCountLessThan(Double value) {
            addCriterion("money_donate_count <", value, "moneyDonateCount");
            return (Criteria) this;
        }

        public Criteria andMoneyDonateCountLessThanOrEqualTo(Double value) {
            addCriterion("money_donate_count <=", value, "moneyDonateCount");
            return (Criteria) this;
        }

        public Criteria andMoneyDonateCountIn(List<Double> values) {
            addCriterion("money_donate_count in", values, "moneyDonateCount");
            return (Criteria) this;
        }

        public Criteria andMoneyDonateCountNotIn(List<Double> values) {
            addCriterion("money_donate_count not in", values, "moneyDonateCount");
            return (Criteria) this;
        }

        public Criteria andMoneyDonateCountBetween(Double value1, Double value2) {
            addCriterion("money_donate_count between", value1, value2, "moneyDonateCount");
            return (Criteria) this;
        }

        public Criteria andMoneyDonateCountNotBetween(Double value1, Double value2) {
            addCriterion("money_donate_count not between", value1, value2, "moneyDonateCount");
            return (Criteria) this;
        }

        public Criteria andXcxOpenIdIsNull() {
            addCriterion("xcx_open_id is null");
            return (Criteria) this;
        }

        public Criteria andXcxOpenIdIsNotNull() {
            addCriterion("xcx_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andXcxOpenIdEqualTo(String value) {
            addCriterion("xcx_open_id =", value, "xcxOpenId");
            return (Criteria) this;
        }

        public Criteria andXcxOpenIdNotEqualTo(String value) {
            addCriterion("xcx_open_id <>", value, "xcxOpenId");
            return (Criteria) this;
        }

        public Criteria andXcxOpenIdGreaterThan(String value) {
            addCriterion("xcx_open_id >", value, "xcxOpenId");
            return (Criteria) this;
        }

        public Criteria andXcxOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("xcx_open_id >=", value, "xcxOpenId");
            return (Criteria) this;
        }

        public Criteria andXcxOpenIdLessThan(String value) {
            addCriterion("xcx_open_id <", value, "xcxOpenId");
            return (Criteria) this;
        }

        public Criteria andXcxOpenIdLessThanOrEqualTo(String value) {
            addCriterion("xcx_open_id <=", value, "xcxOpenId");
            return (Criteria) this;
        }

        public Criteria andXcxOpenIdLike(String value) {
            addCriterion("xcx_open_id like", value, "xcxOpenId");
            return (Criteria) this;
        }

        public Criteria andXcxOpenIdNotLike(String value) {
            addCriterion("xcx_open_id not like", value, "xcxOpenId");
            return (Criteria) this;
        }

        public Criteria andXcxOpenIdIn(List<String> values) {
            addCriterion("xcx_open_id in", values, "xcxOpenId");
            return (Criteria) this;
        }

        public Criteria andXcxOpenIdNotIn(List<String> values) {
            addCriterion("xcx_open_id not in", values, "xcxOpenId");
            return (Criteria) this;
        }

        public Criteria andXcxOpenIdBetween(String value1, String value2) {
            addCriterion("xcx_open_id between", value1, value2, "xcxOpenId");
            return (Criteria) this;
        }

        public Criteria andXcxOpenIdNotBetween(String value1, String value2) {
            addCriterion("xcx_open_id not between", value1, value2, "xcxOpenId");
            return (Criteria) this;
        }

        public Criteria andSysUniIdIsNull() {
            addCriterion("sys_uni_id is null");
            return (Criteria) this;
        }

        public Criteria andSysUniIdIsNotNull() {
            addCriterion("sys_uni_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysUniIdEqualTo(Long value) {
            addCriterion("sys_uni_id =", value, "sysUniId");
            return (Criteria) this;
        }

        public Criteria andSysUniIdNotEqualTo(Long value) {
            addCriterion("sys_uni_id <>", value, "sysUniId");
            return (Criteria) this;
        }

        public Criteria andSysUniIdGreaterThan(Long value) {
            addCriterion("sys_uni_id >", value, "sysUniId");
            return (Criteria) this;
        }

        public Criteria andSysUniIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sys_uni_id >=", value, "sysUniId");
            return (Criteria) this;
        }

        public Criteria andSysUniIdLessThan(Long value) {
            addCriterion("sys_uni_id <", value, "sysUniId");
            return (Criteria) this;
        }

        public Criteria andSysUniIdLessThanOrEqualTo(Long value) {
            addCriterion("sys_uni_id <=", value, "sysUniId");
            return (Criteria) this;
        }

        public Criteria andSysUniIdIn(List<Long> values) {
            addCriterion("sys_uni_id in", values, "sysUniId");
            return (Criteria) this;
        }

        public Criteria andSysUniIdNotIn(List<Long> values) {
            addCriterion("sys_uni_id not in", values, "sysUniId");
            return (Criteria) this;
        }

        public Criteria andSysUniIdBetween(Long value1, Long value2) {
            addCriterion("sys_uni_id between", value1, value2, "sysUniId");
            return (Criteria) this;
        }

        public Criteria andSysUniIdNotBetween(Long value1, Long value2) {
            addCriterion("sys_uni_id not between", value1, value2, "sysUniId");
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