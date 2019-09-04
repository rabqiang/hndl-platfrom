package com.hndl.cn.dao.shop.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ShopAppDataDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ShopAppDataDoExample() {
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

        public Criteria andCountTimeIsNull() {
            addCriterion("count_time is null");
            return (Criteria) this;
        }

        public Criteria andCountTimeIsNotNull() {
            addCriterion("count_time is not null");
            return (Criteria) this;
        }

        public Criteria andCountTimeEqualTo(Date value) {
            addCriterionForJDBCDate("count_time =", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("count_time <>", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("count_time >", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("count_time >=", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeLessThan(Date value) {
            addCriterionForJDBCDate("count_time <", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("count_time <=", value, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeIn(List<Date> values) {
            addCriterionForJDBCDate("count_time in", values, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("count_time not in", values, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("count_time between", value1, value2, "countTime");
            return (Criteria) this;
        }

        public Criteria andCountTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("count_time not between", value1, value2, "countTime");
            return (Criteria) this;
        }

        public Criteria andNewUserCountIsNull() {
            addCriterion("new_user_count is null");
            return (Criteria) this;
        }

        public Criteria andNewUserCountIsNotNull() {
            addCriterion("new_user_count is not null");
            return (Criteria) this;
        }

        public Criteria andNewUserCountEqualTo(Long value) {
            addCriterion("new_user_count =", value, "newUserCount");
            return (Criteria) this;
        }

        public Criteria andNewUserCountNotEqualTo(Long value) {
            addCriterion("new_user_count <>", value, "newUserCount");
            return (Criteria) this;
        }

        public Criteria andNewUserCountGreaterThan(Long value) {
            addCriterion("new_user_count >", value, "newUserCount");
            return (Criteria) this;
        }

        public Criteria andNewUserCountGreaterThanOrEqualTo(Long value) {
            addCriterion("new_user_count >=", value, "newUserCount");
            return (Criteria) this;
        }

        public Criteria andNewUserCountLessThan(Long value) {
            addCriterion("new_user_count <", value, "newUserCount");
            return (Criteria) this;
        }

        public Criteria andNewUserCountLessThanOrEqualTo(Long value) {
            addCriterion("new_user_count <=", value, "newUserCount");
            return (Criteria) this;
        }

        public Criteria andNewUserCountIn(List<Long> values) {
            addCriterion("new_user_count in", values, "newUserCount");
            return (Criteria) this;
        }

        public Criteria andNewUserCountNotIn(List<Long> values) {
            addCriterion("new_user_count not in", values, "newUserCount");
            return (Criteria) this;
        }

        public Criteria andNewUserCountBetween(Long value1, Long value2) {
            addCriterion("new_user_count between", value1, value2, "newUserCount");
            return (Criteria) this;
        }

        public Criteria andNewUserCountNotBetween(Long value1, Long value2) {
            addCriterion("new_user_count not between", value1, value2, "newUserCount");
            return (Criteria) this;
        }

        public Criteria andTotalBuyCountIsNull() {
            addCriterion("total_buy_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalBuyCountIsNotNull() {
            addCriterion("total_buy_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalBuyCountEqualTo(Long value) {
            addCriterion("total_buy_count =", value, "totalBuyCount");
            return (Criteria) this;
        }

        public Criteria andTotalBuyCountNotEqualTo(Long value) {
            addCriterion("total_buy_count <>", value, "totalBuyCount");
            return (Criteria) this;
        }

        public Criteria andTotalBuyCountGreaterThan(Long value) {
            addCriterion("total_buy_count >", value, "totalBuyCount");
            return (Criteria) this;
        }

        public Criteria andTotalBuyCountGreaterThanOrEqualTo(Long value) {
            addCriterion("total_buy_count >=", value, "totalBuyCount");
            return (Criteria) this;
        }

        public Criteria andTotalBuyCountLessThan(Long value) {
            addCriterion("total_buy_count <", value, "totalBuyCount");
            return (Criteria) this;
        }

        public Criteria andTotalBuyCountLessThanOrEqualTo(Long value) {
            addCriterion("total_buy_count <=", value, "totalBuyCount");
            return (Criteria) this;
        }

        public Criteria andTotalBuyCountIn(List<Long> values) {
            addCriterion("total_buy_count in", values, "totalBuyCount");
            return (Criteria) this;
        }

        public Criteria andTotalBuyCountNotIn(List<Long> values) {
            addCriterion("total_buy_count not in", values, "totalBuyCount");
            return (Criteria) this;
        }

        public Criteria andTotalBuyCountBetween(Long value1, Long value2) {
            addCriterion("total_buy_count between", value1, value2, "totalBuyCount");
            return (Criteria) this;
        }

        public Criteria andTotalBuyCountNotBetween(Long value1, Long value2) {
            addCriterion("total_buy_count not between", value1, value2, "totalBuyCount");
            return (Criteria) this;
        }

        public Criteria andUserBuyCountIsNull() {
            addCriterion("user_buy_count is null");
            return (Criteria) this;
        }

        public Criteria andUserBuyCountIsNotNull() {
            addCriterion("user_buy_count is not null");
            return (Criteria) this;
        }

        public Criteria andUserBuyCountEqualTo(Long value) {
            addCriterion("user_buy_count =", value, "userBuyCount");
            return (Criteria) this;
        }

        public Criteria andUserBuyCountNotEqualTo(Long value) {
            addCriterion("user_buy_count <>", value, "userBuyCount");
            return (Criteria) this;
        }

        public Criteria andUserBuyCountGreaterThan(Long value) {
            addCriterion("user_buy_count >", value, "userBuyCount");
            return (Criteria) this;
        }

        public Criteria andUserBuyCountGreaterThanOrEqualTo(Long value) {
            addCriterion("user_buy_count >=", value, "userBuyCount");
            return (Criteria) this;
        }

        public Criteria andUserBuyCountLessThan(Long value) {
            addCriterion("user_buy_count <", value, "userBuyCount");
            return (Criteria) this;
        }

        public Criteria andUserBuyCountLessThanOrEqualTo(Long value) {
            addCriterion("user_buy_count <=", value, "userBuyCount");
            return (Criteria) this;
        }

        public Criteria andUserBuyCountIn(List<Long> values) {
            addCriterion("user_buy_count in", values, "userBuyCount");
            return (Criteria) this;
        }

        public Criteria andUserBuyCountNotIn(List<Long> values) {
            addCriterion("user_buy_count not in", values, "userBuyCount");
            return (Criteria) this;
        }

        public Criteria andUserBuyCountBetween(Long value1, Long value2) {
            addCriterion("user_buy_count between", value1, value2, "userBuyCount");
            return (Criteria) this;
        }

        public Criteria andUserBuyCountNotBetween(Long value1, Long value2) {
            addCriterion("user_buy_count not between", value1, value2, "userBuyCount");
            return (Criteria) this;
        }

        public Criteria andNewItemCountIsNull() {
            addCriterion("new_item_count is null");
            return (Criteria) this;
        }

        public Criteria andNewItemCountIsNotNull() {
            addCriterion("new_item_count is not null");
            return (Criteria) this;
        }

        public Criteria andNewItemCountEqualTo(Long value) {
            addCriterion("new_item_count =", value, "newItemCount");
            return (Criteria) this;
        }

        public Criteria andNewItemCountNotEqualTo(Long value) {
            addCriterion("new_item_count <>", value, "newItemCount");
            return (Criteria) this;
        }

        public Criteria andNewItemCountGreaterThan(Long value) {
            addCriterion("new_item_count >", value, "newItemCount");
            return (Criteria) this;
        }

        public Criteria andNewItemCountGreaterThanOrEqualTo(Long value) {
            addCriterion("new_item_count >=", value, "newItemCount");
            return (Criteria) this;
        }

        public Criteria andNewItemCountLessThan(Long value) {
            addCriterion("new_item_count <", value, "newItemCount");
            return (Criteria) this;
        }

        public Criteria andNewItemCountLessThanOrEqualTo(Long value) {
            addCriterion("new_item_count <=", value, "newItemCount");
            return (Criteria) this;
        }

        public Criteria andNewItemCountIn(List<Long> values) {
            addCriterion("new_item_count in", values, "newItemCount");
            return (Criteria) this;
        }

        public Criteria andNewItemCountNotIn(List<Long> values) {
            addCriterion("new_item_count not in", values, "newItemCount");
            return (Criteria) this;
        }

        public Criteria andNewItemCountBetween(Long value1, Long value2) {
            addCriterion("new_item_count between", value1, value2, "newItemCount");
            return (Criteria) this;
        }

        public Criteria andNewItemCountNotBetween(Long value1, Long value2) {
            addCriterion("new_item_count not between", value1, value2, "newItemCount");
            return (Criteria) this;
        }

        public Criteria andItemOpenCountIsNull() {
            addCriterion("item_open_count is null");
            return (Criteria) this;
        }

        public Criteria andItemOpenCountIsNotNull() {
            addCriterion("item_open_count is not null");
            return (Criteria) this;
        }

        public Criteria andItemOpenCountEqualTo(Long value) {
            addCriterion("item_open_count =", value, "itemOpenCount");
            return (Criteria) this;
        }

        public Criteria andItemOpenCountNotEqualTo(Long value) {
            addCriterion("item_open_count <>", value, "itemOpenCount");
            return (Criteria) this;
        }

        public Criteria andItemOpenCountGreaterThan(Long value) {
            addCriterion("item_open_count >", value, "itemOpenCount");
            return (Criteria) this;
        }

        public Criteria andItemOpenCountGreaterThanOrEqualTo(Long value) {
            addCriterion("item_open_count >=", value, "itemOpenCount");
            return (Criteria) this;
        }

        public Criteria andItemOpenCountLessThan(Long value) {
            addCriterion("item_open_count <", value, "itemOpenCount");
            return (Criteria) this;
        }

        public Criteria andItemOpenCountLessThanOrEqualTo(Long value) {
            addCriterion("item_open_count <=", value, "itemOpenCount");
            return (Criteria) this;
        }

        public Criteria andItemOpenCountIn(List<Long> values) {
            addCriterion("item_open_count in", values, "itemOpenCount");
            return (Criteria) this;
        }

        public Criteria andItemOpenCountNotIn(List<Long> values) {
            addCriterion("item_open_count not in", values, "itemOpenCount");
            return (Criteria) this;
        }

        public Criteria andItemOpenCountBetween(Long value1, Long value2) {
            addCriterion("item_open_count between", value1, value2, "itemOpenCount");
            return (Criteria) this;
        }

        public Criteria andItemOpenCountNotBetween(Long value1, Long value2) {
            addCriterion("item_open_count not between", value1, value2, "itemOpenCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayCountIsNull() {
            addCriterion("third_pay_count is null");
            return (Criteria) this;
        }

        public Criteria andThirdPayCountIsNotNull() {
            addCriterion("third_pay_count is not null");
            return (Criteria) this;
        }

        public Criteria andThirdPayCountEqualTo(Double value) {
            addCriterion("third_pay_count =", value, "thirdPayCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayCountNotEqualTo(Double value) {
            addCriterion("third_pay_count <>", value, "thirdPayCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayCountGreaterThan(Double value) {
            addCriterion("third_pay_count >", value, "thirdPayCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayCountGreaterThanOrEqualTo(Double value) {
            addCriterion("third_pay_count >=", value, "thirdPayCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayCountLessThan(Double value) {
            addCriterion("third_pay_count <", value, "thirdPayCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayCountLessThanOrEqualTo(Double value) {
            addCriterion("third_pay_count <=", value, "thirdPayCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayCountIn(List<Double> values) {
            addCriterion("third_pay_count in", values, "thirdPayCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayCountNotIn(List<Double> values) {
            addCriterion("third_pay_count not in", values, "thirdPayCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayCountBetween(Double value1, Double value2) {
            addCriterion("third_pay_count between", value1, value2, "thirdPayCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayCountNotBetween(Double value1, Double value2) {
            addCriterion("third_pay_count not between", value1, value2, "thirdPayCount");
            return (Criteria) this;
        }

        public Criteria andCoinPayCountIsNull() {
            addCriterion("coin_pay_count is null");
            return (Criteria) this;
        }

        public Criteria andCoinPayCountIsNotNull() {
            addCriterion("coin_pay_count is not null");
            return (Criteria) this;
        }

        public Criteria andCoinPayCountEqualTo(Double value) {
            addCriterion("coin_pay_count =", value, "coinPayCount");
            return (Criteria) this;
        }

        public Criteria andCoinPayCountNotEqualTo(Double value) {
            addCriterion("coin_pay_count <>", value, "coinPayCount");
            return (Criteria) this;
        }

        public Criteria andCoinPayCountGreaterThan(Double value) {
            addCriterion("coin_pay_count >", value, "coinPayCount");
            return (Criteria) this;
        }

        public Criteria andCoinPayCountGreaterThanOrEqualTo(Double value) {
            addCriterion("coin_pay_count >=", value, "coinPayCount");
            return (Criteria) this;
        }

        public Criteria andCoinPayCountLessThan(Double value) {
            addCriterion("coin_pay_count <", value, "coinPayCount");
            return (Criteria) this;
        }

        public Criteria andCoinPayCountLessThanOrEqualTo(Double value) {
            addCriterion("coin_pay_count <=", value, "coinPayCount");
            return (Criteria) this;
        }

        public Criteria andCoinPayCountIn(List<Double> values) {
            addCriterion("coin_pay_count in", values, "coinPayCount");
            return (Criteria) this;
        }

        public Criteria andCoinPayCountNotIn(List<Double> values) {
            addCriterion("coin_pay_count not in", values, "coinPayCount");
            return (Criteria) this;
        }

        public Criteria andCoinPayCountBetween(Double value1, Double value2) {
            addCriterion("coin_pay_count between", value1, value2, "coinPayCount");
            return (Criteria) this;
        }

        public Criteria andCoinPayCountNotBetween(Double value1, Double value2) {
            addCriterion("coin_pay_count not between", value1, value2, "coinPayCount");
            return (Criteria) this;
        }

        public Criteria andDouPayCountIsNull() {
            addCriterion("dou_pay_count is null");
            return (Criteria) this;
        }

        public Criteria andDouPayCountIsNotNull() {
            addCriterion("dou_pay_count is not null");
            return (Criteria) this;
        }

        public Criteria andDouPayCountEqualTo(Double value) {
            addCriterion("dou_pay_count =", value, "douPayCount");
            return (Criteria) this;
        }

        public Criteria andDouPayCountNotEqualTo(Double value) {
            addCriterion("dou_pay_count <>", value, "douPayCount");
            return (Criteria) this;
        }

        public Criteria andDouPayCountGreaterThan(Double value) {
            addCriterion("dou_pay_count >", value, "douPayCount");
            return (Criteria) this;
        }

        public Criteria andDouPayCountGreaterThanOrEqualTo(Double value) {
            addCriterion("dou_pay_count >=", value, "douPayCount");
            return (Criteria) this;
        }

        public Criteria andDouPayCountLessThan(Double value) {
            addCriterion("dou_pay_count <", value, "douPayCount");
            return (Criteria) this;
        }

        public Criteria andDouPayCountLessThanOrEqualTo(Double value) {
            addCriterion("dou_pay_count <=", value, "douPayCount");
            return (Criteria) this;
        }

        public Criteria andDouPayCountIn(List<Double> values) {
            addCriterion("dou_pay_count in", values, "douPayCount");
            return (Criteria) this;
        }

        public Criteria andDouPayCountNotIn(List<Double> values) {
            addCriterion("dou_pay_count not in", values, "douPayCount");
            return (Criteria) this;
        }

        public Criteria andDouPayCountBetween(Double value1, Double value2) {
            addCriterion("dou_pay_count between", value1, value2, "douPayCount");
            return (Criteria) this;
        }

        public Criteria andDouPayCountNotBetween(Double value1, Double value2) {
            addCriterion("dou_pay_count not between", value1, value2, "douPayCount");
            return (Criteria) this;
        }

        public Criteria andTotalOrderCountIsNull() {
            addCriterion("total_order_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalOrderCountIsNotNull() {
            addCriterion("total_order_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalOrderCountEqualTo(Integer value) {
            addCriterion("total_order_count =", value, "totalOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalOrderCountNotEqualTo(Integer value) {
            addCriterion("total_order_count <>", value, "totalOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalOrderCountGreaterThan(Integer value) {
            addCriterion("total_order_count >", value, "totalOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_order_count >=", value, "totalOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalOrderCountLessThan(Integer value) {
            addCriterion("total_order_count <", value, "totalOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_order_count <=", value, "totalOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalOrderCountIn(List<Integer> values) {
            addCriterion("total_order_count in", values, "totalOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalOrderCountNotIn(List<Integer> values) {
            addCriterion("total_order_count not in", values, "totalOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("total_order_count between", value1, value2, "totalOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_order_count not between", value1, value2, "totalOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalUserOrderCountIsNull() {
            addCriterion("total_user_order_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalUserOrderCountIsNotNull() {
            addCriterion("total_user_order_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalUserOrderCountEqualTo(Integer value) {
            addCriterion("total_user_order_count =", value, "totalUserOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalUserOrderCountNotEqualTo(Integer value) {
            addCriterion("total_user_order_count <>", value, "totalUserOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalUserOrderCountGreaterThan(Integer value) {
            addCriterion("total_user_order_count >", value, "totalUserOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalUserOrderCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_user_order_count >=", value, "totalUserOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalUserOrderCountLessThan(Integer value) {
            addCriterion("total_user_order_count <", value, "totalUserOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalUserOrderCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_user_order_count <=", value, "totalUserOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalUserOrderCountIn(List<Integer> values) {
            addCriterion("total_user_order_count in", values, "totalUserOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalUserOrderCountNotIn(List<Integer> values) {
            addCriterion("total_user_order_count not in", values, "totalUserOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalUserOrderCountBetween(Integer value1, Integer value2) {
            addCriterion("total_user_order_count between", value1, value2, "totalUserOrderCount");
            return (Criteria) this;
        }

        public Criteria andTotalUserOrderCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_user_order_count not between", value1, value2, "totalUserOrderCount");
            return (Criteria) this;
        }

        public Criteria andActivityUserCountIsNull() {
            addCriterion("activity_user_count is null");
            return (Criteria) this;
        }

        public Criteria andActivityUserCountIsNotNull() {
            addCriterion("activity_user_count is not null");
            return (Criteria) this;
        }

        public Criteria andActivityUserCountEqualTo(Integer value) {
            addCriterion("activity_user_count =", value, "activityUserCount");
            return (Criteria) this;
        }

        public Criteria andActivityUserCountNotEqualTo(Integer value) {
            addCriterion("activity_user_count <>", value, "activityUserCount");
            return (Criteria) this;
        }

        public Criteria andActivityUserCountGreaterThan(Integer value) {
            addCriterion("activity_user_count >", value, "activityUserCount");
            return (Criteria) this;
        }

        public Criteria andActivityUserCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_user_count >=", value, "activityUserCount");
            return (Criteria) this;
        }

        public Criteria andActivityUserCountLessThan(Integer value) {
            addCriterion("activity_user_count <", value, "activityUserCount");
            return (Criteria) this;
        }

        public Criteria andActivityUserCountLessThanOrEqualTo(Integer value) {
            addCriterion("activity_user_count <=", value, "activityUserCount");
            return (Criteria) this;
        }

        public Criteria andActivityUserCountIn(List<Integer> values) {
            addCriterion("activity_user_count in", values, "activityUserCount");
            return (Criteria) this;
        }

        public Criteria andActivityUserCountNotIn(List<Integer> values) {
            addCriterion("activity_user_count not in", values, "activityUserCount");
            return (Criteria) this;
        }

        public Criteria andActivityUserCountBetween(Integer value1, Integer value2) {
            addCriterion("activity_user_count between", value1, value2, "activityUserCount");
            return (Criteria) this;
        }

        public Criteria andActivityUserCountNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_user_count not between", value1, value2, "activityUserCount");
            return (Criteria) this;
        }

        public Criteria andBak1IsNull() {
            addCriterion("bak1 is null");
            return (Criteria) this;
        }

        public Criteria andBak1IsNotNull() {
            addCriterion("bak1 is not null");
            return (Criteria) this;
        }

        public Criteria andBak1EqualTo(String value) {
            addCriterion("bak1 =", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotEqualTo(String value) {
            addCriterion("bak1 <>", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1GreaterThan(String value) {
            addCriterion("bak1 >", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1GreaterThanOrEqualTo(String value) {
            addCriterion("bak1 >=", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1LessThan(String value) {
            addCriterion("bak1 <", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1LessThanOrEqualTo(String value) {
            addCriterion("bak1 <=", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1Like(String value) {
            addCriterion("bak1 like", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotLike(String value) {
            addCriterion("bak1 not like", value, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1In(List<String> values) {
            addCriterion("bak1 in", values, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotIn(List<String> values) {
            addCriterion("bak1 not in", values, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1Between(String value1, String value2) {
            addCriterion("bak1 between", value1, value2, "bak1");
            return (Criteria) this;
        }

        public Criteria andBak1NotBetween(String value1, String value2) {
            addCriterion("bak1 not between", value1, value2, "bak1");
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

        public Criteria andBak5EqualTo(String value) {
            addCriterion("bak5 =", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotEqualTo(String value) {
            addCriterion("bak5 <>", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5GreaterThan(String value) {
            addCriterion("bak5 >", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5GreaterThanOrEqualTo(String value) {
            addCriterion("bak5 >=", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5LessThan(String value) {
            addCriterion("bak5 <", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5LessThanOrEqualTo(String value) {
            addCriterion("bak5 <=", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5Like(String value) {
            addCriterion("bak5 like", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotLike(String value) {
            addCriterion("bak5 not like", value, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5In(List<String> values) {
            addCriterion("bak5 in", values, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotIn(List<String> values) {
            addCriterion("bak5 not in", values, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5Between(String value1, String value2) {
            addCriterion("bak5 between", value1, value2, "bak5");
            return (Criteria) this;
        }

        public Criteria andBak5NotBetween(String value1, String value2) {
            addCriterion("bak5 not between", value1, value2, "bak5");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyCountIsNull() {
            addCriterion("mango_currency_count is null");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyCountIsNotNull() {
            addCriterion("mango_currency_count is not null");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyCountEqualTo(Integer value) {
            addCriterion("mango_currency_count =", value, "mangoCurrencyCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyCountNotEqualTo(Integer value) {
            addCriterion("mango_currency_count <>", value, "mangoCurrencyCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyCountGreaterThan(Integer value) {
            addCriterion("mango_currency_count >", value, "mangoCurrencyCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("mango_currency_count >=", value, "mangoCurrencyCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyCountLessThan(Integer value) {
            addCriterion("mango_currency_count <", value, "mangoCurrencyCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyCountLessThanOrEqualTo(Integer value) {
            addCriterion("mango_currency_count <=", value, "mangoCurrencyCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyCountIn(List<Integer> values) {
            addCriterion("mango_currency_count in", values, "mangoCurrencyCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyCountNotIn(List<Integer> values) {
            addCriterion("mango_currency_count not in", values, "mangoCurrencyCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyCountBetween(Integer value1, Integer value2) {
            addCriterion("mango_currency_count between", value1, value2, "mangoCurrencyCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("mango_currency_count not between", value1, value2, "mangoCurrencyCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartCountIsNull() {
            addCriterion("third_pay_heart_count is null");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartCountIsNotNull() {
            addCriterion("third_pay_heart_count is not null");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartCountEqualTo(Integer value) {
            addCriterion("third_pay_heart_count =", value, "thirdPayHeartCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartCountNotEqualTo(Integer value) {
            addCriterion("third_pay_heart_count <>", value, "thirdPayHeartCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartCountGreaterThan(Integer value) {
            addCriterion("third_pay_heart_count >", value, "thirdPayHeartCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("third_pay_heart_count >=", value, "thirdPayHeartCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartCountLessThan(Integer value) {
            addCriterion("third_pay_heart_count <", value, "thirdPayHeartCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartCountLessThanOrEqualTo(Integer value) {
            addCriterion("third_pay_heart_count <=", value, "thirdPayHeartCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartCountIn(List<Integer> values) {
            addCriterion("third_pay_heart_count in", values, "thirdPayHeartCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartCountNotIn(List<Integer> values) {
            addCriterion("third_pay_heart_count not in", values, "thirdPayHeartCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartCountBetween(Integer value1, Integer value2) {
            addCriterion("third_pay_heart_count between", value1, value2, "thirdPayHeartCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartCountNotBetween(Integer value1, Integer value2) {
            addCriterion("third_pay_heart_count not between", value1, value2, "thirdPayHeartCount");
            return (Criteria) this;
        }

        public Criteria andScoringCountIsNull() {
            addCriterion("scoring_count is null");
            return (Criteria) this;
        }

        public Criteria andScoringCountIsNotNull() {
            addCriterion("scoring_count is not null");
            return (Criteria) this;
        }

        public Criteria andScoringCountEqualTo(Integer value) {
            addCriterion("scoring_count =", value, "scoringCount");
            return (Criteria) this;
        }

        public Criteria andScoringCountNotEqualTo(Integer value) {
            addCriterion("scoring_count <>", value, "scoringCount");
            return (Criteria) this;
        }

        public Criteria andScoringCountGreaterThan(Integer value) {
            addCriterion("scoring_count >", value, "scoringCount");
            return (Criteria) this;
        }

        public Criteria andScoringCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("scoring_count >=", value, "scoringCount");
            return (Criteria) this;
        }

        public Criteria andScoringCountLessThan(Integer value) {
            addCriterion("scoring_count <", value, "scoringCount");
            return (Criteria) this;
        }

        public Criteria andScoringCountLessThanOrEqualTo(Integer value) {
            addCriterion("scoring_count <=", value, "scoringCount");
            return (Criteria) this;
        }

        public Criteria andScoringCountIn(List<Integer> values) {
            addCriterion("scoring_count in", values, "scoringCount");
            return (Criteria) this;
        }

        public Criteria andScoringCountNotIn(List<Integer> values) {
            addCriterion("scoring_count not in", values, "scoringCount");
            return (Criteria) this;
        }

        public Criteria andScoringCountBetween(Integer value1, Integer value2) {
            addCriterion("scoring_count between", value1, value2, "scoringCount");
            return (Criteria) this;
        }

        public Criteria andScoringCountNotBetween(Integer value1, Integer value2) {
            addCriterion("scoring_count not between", value1, value2, "scoringCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyPersonCountIsNull() {
            addCriterion("mango_currency_person_count is null");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyPersonCountIsNotNull() {
            addCriterion("mango_currency_person_count is not null");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyPersonCountEqualTo(Integer value) {
            addCriterion("mango_currency_person_count =", value, "mangoCurrencyPersonCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyPersonCountNotEqualTo(Integer value) {
            addCriterion("mango_currency_person_count <>", value, "mangoCurrencyPersonCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyPersonCountGreaterThan(Integer value) {
            addCriterion("mango_currency_person_count >", value, "mangoCurrencyPersonCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyPersonCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("mango_currency_person_count >=", value, "mangoCurrencyPersonCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyPersonCountLessThan(Integer value) {
            addCriterion("mango_currency_person_count <", value, "mangoCurrencyPersonCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyPersonCountLessThanOrEqualTo(Integer value) {
            addCriterion("mango_currency_person_count <=", value, "mangoCurrencyPersonCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyPersonCountIn(List<Integer> values) {
            addCriterion("mango_currency_person_count in", values, "mangoCurrencyPersonCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyPersonCountNotIn(List<Integer> values) {
            addCriterion("mango_currency_person_count not in", values, "mangoCurrencyPersonCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyPersonCountBetween(Integer value1, Integer value2) {
            addCriterion("mango_currency_person_count between", value1, value2, "mangoCurrencyPersonCount");
            return (Criteria) this;
        }

        public Criteria andMangoCurrencyPersonCountNotBetween(Integer value1, Integer value2) {
            addCriterion("mango_currency_person_count not between", value1, value2, "mangoCurrencyPersonCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartPersonCountIsNull() {
            addCriterion("third_pay_heart_person_count is null");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartPersonCountIsNotNull() {
            addCriterion("third_pay_heart_person_count is not null");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartPersonCountEqualTo(Integer value) {
            addCriterion("third_pay_heart_person_count =", value, "thirdPayHeartPersonCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartPersonCountNotEqualTo(Integer value) {
            addCriterion("third_pay_heart_person_count <>", value, "thirdPayHeartPersonCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartPersonCountGreaterThan(Integer value) {
            addCriterion("third_pay_heart_person_count >", value, "thirdPayHeartPersonCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartPersonCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("third_pay_heart_person_count >=", value, "thirdPayHeartPersonCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartPersonCountLessThan(Integer value) {
            addCriterion("third_pay_heart_person_count <", value, "thirdPayHeartPersonCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartPersonCountLessThanOrEqualTo(Integer value) {
            addCriterion("third_pay_heart_person_count <=", value, "thirdPayHeartPersonCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartPersonCountIn(List<Integer> values) {
            addCriterion("third_pay_heart_person_count in", values, "thirdPayHeartPersonCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartPersonCountNotIn(List<Integer> values) {
            addCriterion("third_pay_heart_person_count not in", values, "thirdPayHeartPersonCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartPersonCountBetween(Integer value1, Integer value2) {
            addCriterion("third_pay_heart_person_count between", value1, value2, "thirdPayHeartPersonCount");
            return (Criteria) this;
        }

        public Criteria andThirdPayHeartPersonCountNotBetween(Integer value1, Integer value2) {
            addCriterion("third_pay_heart_person_count not between", value1, value2, "thirdPayHeartPersonCount");
            return (Criteria) this;
        }

        public Criteria andScoringPersonCountIsNull() {
            addCriterion("scoring_person_count is null");
            return (Criteria) this;
        }

        public Criteria andScoringPersonCountIsNotNull() {
            addCriterion("scoring_person_count is not null");
            return (Criteria) this;
        }

        public Criteria andScoringPersonCountEqualTo(Integer value) {
            addCriterion("scoring_person_count =", value, "scoringPersonCount");
            return (Criteria) this;
        }

        public Criteria andScoringPersonCountNotEqualTo(Integer value) {
            addCriterion("scoring_person_count <>", value, "scoringPersonCount");
            return (Criteria) this;
        }

        public Criteria andScoringPersonCountGreaterThan(Integer value) {
            addCriterion("scoring_person_count >", value, "scoringPersonCount");
            return (Criteria) this;
        }

        public Criteria andScoringPersonCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("scoring_person_count >=", value, "scoringPersonCount");
            return (Criteria) this;
        }

        public Criteria andScoringPersonCountLessThan(Integer value) {
            addCriterion("scoring_person_count <", value, "scoringPersonCount");
            return (Criteria) this;
        }

        public Criteria andScoringPersonCountLessThanOrEqualTo(Integer value) {
            addCriterion("scoring_person_count <=", value, "scoringPersonCount");
            return (Criteria) this;
        }

        public Criteria andScoringPersonCountIn(List<Integer> values) {
            addCriterion("scoring_person_count in", values, "scoringPersonCount");
            return (Criteria) this;
        }

        public Criteria andScoringPersonCountNotIn(List<Integer> values) {
            addCriterion("scoring_person_count not in", values, "scoringPersonCount");
            return (Criteria) this;
        }

        public Criteria andScoringPersonCountBetween(Integer value1, Integer value2) {
            addCriterion("scoring_person_count between", value1, value2, "scoringPersonCount");
            return (Criteria) this;
        }

        public Criteria andScoringPersonCountNotBetween(Integer value1, Integer value2) {
            addCriterion("scoring_person_count not between", value1, value2, "scoringPersonCount");
            return (Criteria) this;
        }

        public Criteria andRechargeCountIsNull() {
            addCriterion("recharge_count is null");
            return (Criteria) this;
        }

        public Criteria andRechargeCountIsNotNull() {
            addCriterion("recharge_count is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeCountEqualTo(Double value) {
            addCriterion("recharge_count =", value, "rechargeCount");
            return (Criteria) this;
        }

        public Criteria andRechargeCountNotEqualTo(Double value) {
            addCriterion("recharge_count <>", value, "rechargeCount");
            return (Criteria) this;
        }

        public Criteria andRechargeCountGreaterThan(Double value) {
            addCriterion("recharge_count >", value, "rechargeCount");
            return (Criteria) this;
        }

        public Criteria andRechargeCountGreaterThanOrEqualTo(Double value) {
            addCriterion("recharge_count >=", value, "rechargeCount");
            return (Criteria) this;
        }

        public Criteria andRechargeCountLessThan(Double value) {
            addCriterion("recharge_count <", value, "rechargeCount");
            return (Criteria) this;
        }

        public Criteria andRechargeCountLessThanOrEqualTo(Double value) {
            addCriterion("recharge_count <=", value, "rechargeCount");
            return (Criteria) this;
        }

        public Criteria andRechargeCountIn(List<Double> values) {
            addCriterion("recharge_count in", values, "rechargeCount");
            return (Criteria) this;
        }

        public Criteria andRechargeCountNotIn(List<Double> values) {
            addCriterion("recharge_count not in", values, "rechargeCount");
            return (Criteria) this;
        }

        public Criteria andRechargeCountBetween(Double value1, Double value2) {
            addCriterion("recharge_count between", value1, value2, "rechargeCount");
            return (Criteria) this;
        }

        public Criteria andRechargeCountNotBetween(Double value1, Double value2) {
            addCriterion("recharge_count not between", value1, value2, "rechargeCount");
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