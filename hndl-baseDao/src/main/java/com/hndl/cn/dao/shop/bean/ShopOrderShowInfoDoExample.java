package com.hndl.cn.dao.shop.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopOrderShowInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ShopOrderShowInfoDoExample() {
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

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(String value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(String value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(String value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(String value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(String value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLike(String value) {
            addCriterion("item_id like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotLike(String value) {
            addCriterion("item_id not like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<String> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<String> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(String value1, String value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(String value1, String value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andImg1IsNull() {
            addCriterion("img1 is null");
            return (Criteria) this;
        }

        public Criteria andImg1IsNotNull() {
            addCriterion("img1 is not null");
            return (Criteria) this;
        }

        public Criteria andImg1EqualTo(String value) {
            addCriterion("img1 =", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1NotEqualTo(String value) {
            addCriterion("img1 <>", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1GreaterThan(String value) {
            addCriterion("img1 >", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1GreaterThanOrEqualTo(String value) {
            addCriterion("img1 >=", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1LessThan(String value) {
            addCriterion("img1 <", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1LessThanOrEqualTo(String value) {
            addCriterion("img1 <=", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1Like(String value) {
            addCriterion("img1 like", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1NotLike(String value) {
            addCriterion("img1 not like", value, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1In(List<String> values) {
            addCriterion("img1 in", values, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1NotIn(List<String> values) {
            addCriterion("img1 not in", values, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1Between(String value1, String value2) {
            addCriterion("img1 between", value1, value2, "img1");
            return (Criteria) this;
        }

        public Criteria andImg1NotBetween(String value1, String value2) {
            addCriterion("img1 not between", value1, value2, "img1");
            return (Criteria) this;
        }

        public Criteria andImg2IsNull() {
            addCriterion("img2 is null");
            return (Criteria) this;
        }

        public Criteria andImg2IsNotNull() {
            addCriterion("img2 is not null");
            return (Criteria) this;
        }

        public Criteria andImg2EqualTo(String value) {
            addCriterion("img2 =", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2NotEqualTo(String value) {
            addCriterion("img2 <>", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2GreaterThan(String value) {
            addCriterion("img2 >", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2GreaterThanOrEqualTo(String value) {
            addCriterion("img2 >=", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2LessThan(String value) {
            addCriterion("img2 <", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2LessThanOrEqualTo(String value) {
            addCriterion("img2 <=", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2Like(String value) {
            addCriterion("img2 like", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2NotLike(String value) {
            addCriterion("img2 not like", value, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2In(List<String> values) {
            addCriterion("img2 in", values, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2NotIn(List<String> values) {
            addCriterion("img2 not in", values, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2Between(String value1, String value2) {
            addCriterion("img2 between", value1, value2, "img2");
            return (Criteria) this;
        }

        public Criteria andImg2NotBetween(String value1, String value2) {
            addCriterion("img2 not between", value1, value2, "img2");
            return (Criteria) this;
        }

        public Criteria andImg3IsNull() {
            addCriterion("img3 is null");
            return (Criteria) this;
        }

        public Criteria andImg3IsNotNull() {
            addCriterion("img3 is not null");
            return (Criteria) this;
        }

        public Criteria andImg3EqualTo(String value) {
            addCriterion("img3 =", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3NotEqualTo(String value) {
            addCriterion("img3 <>", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3GreaterThan(String value) {
            addCriterion("img3 >", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3GreaterThanOrEqualTo(String value) {
            addCriterion("img3 >=", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3LessThan(String value) {
            addCriterion("img3 <", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3LessThanOrEqualTo(String value) {
            addCriterion("img3 <=", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3Like(String value) {
            addCriterion("img3 like", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3NotLike(String value) {
            addCriterion("img3 not like", value, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3In(List<String> values) {
            addCriterion("img3 in", values, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3NotIn(List<String> values) {
            addCriterion("img3 not in", values, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3Between(String value1, String value2) {
            addCriterion("img3 between", value1, value2, "img3");
            return (Criteria) this;
        }

        public Criteria andImg3NotBetween(String value1, String value2) {
            addCriterion("img3 not between", value1, value2, "img3");
            return (Criteria) this;
        }

        public Criteria andImg4IsNull() {
            addCriterion("img4 is null");
            return (Criteria) this;
        }

        public Criteria andImg4IsNotNull() {
            addCriterion("img4 is not null");
            return (Criteria) this;
        }

        public Criteria andImg4EqualTo(String value) {
            addCriterion("img4 =", value, "img4");
            return (Criteria) this;
        }

        public Criteria andImg4NotEqualTo(String value) {
            addCriterion("img4 <>", value, "img4");
            return (Criteria) this;
        }

        public Criteria andImg4GreaterThan(String value) {
            addCriterion("img4 >", value, "img4");
            return (Criteria) this;
        }

        public Criteria andImg4GreaterThanOrEqualTo(String value) {
            addCriterion("img4 >=", value, "img4");
            return (Criteria) this;
        }

        public Criteria andImg4LessThan(String value) {
            addCriterion("img4 <", value, "img4");
            return (Criteria) this;
        }

        public Criteria andImg4LessThanOrEqualTo(String value) {
            addCriterion("img4 <=", value, "img4");
            return (Criteria) this;
        }

        public Criteria andImg4Like(String value) {
            addCriterion("img4 like", value, "img4");
            return (Criteria) this;
        }

        public Criteria andImg4NotLike(String value) {
            addCriterion("img4 not like", value, "img4");
            return (Criteria) this;
        }

        public Criteria andImg4In(List<String> values) {
            addCriterion("img4 in", values, "img4");
            return (Criteria) this;
        }

        public Criteria andImg4NotIn(List<String> values) {
            addCriterion("img4 not in", values, "img4");
            return (Criteria) this;
        }

        public Criteria andImg4Between(String value1, String value2) {
            addCriterion("img4 between", value1, value2, "img4");
            return (Criteria) this;
        }

        public Criteria andImg4NotBetween(String value1, String value2) {
            addCriterion("img4 not between", value1, value2, "img4");
            return (Criteria) this;
        }

        public Criteria andImg5IsNull() {
            addCriterion("img5 is null");
            return (Criteria) this;
        }

        public Criteria andImg5IsNotNull() {
            addCriterion("img5 is not null");
            return (Criteria) this;
        }

        public Criteria andImg5EqualTo(String value) {
            addCriterion("img5 =", value, "img5");
            return (Criteria) this;
        }

        public Criteria andImg5NotEqualTo(String value) {
            addCriterion("img5 <>", value, "img5");
            return (Criteria) this;
        }

        public Criteria andImg5GreaterThan(String value) {
            addCriterion("img5 >", value, "img5");
            return (Criteria) this;
        }

        public Criteria andImg5GreaterThanOrEqualTo(String value) {
            addCriterion("img5 >=", value, "img5");
            return (Criteria) this;
        }

        public Criteria andImg5LessThan(String value) {
            addCriterion("img5 <", value, "img5");
            return (Criteria) this;
        }

        public Criteria andImg5LessThanOrEqualTo(String value) {
            addCriterion("img5 <=", value, "img5");
            return (Criteria) this;
        }

        public Criteria andImg5Like(String value) {
            addCriterion("img5 like", value, "img5");
            return (Criteria) this;
        }

        public Criteria andImg5NotLike(String value) {
            addCriterion("img5 not like", value, "img5");
            return (Criteria) this;
        }

        public Criteria andImg5In(List<String> values) {
            addCriterion("img5 in", values, "img5");
            return (Criteria) this;
        }

        public Criteria andImg5NotIn(List<String> values) {
            addCriterion("img5 not in", values, "img5");
            return (Criteria) this;
        }

        public Criteria andImg5Between(String value1, String value2) {
            addCriterion("img5 between", value1, value2, "img5");
            return (Criteria) this;
        }

        public Criteria andImg5NotBetween(String value1, String value2) {
            addCriterion("img5 not between", value1, value2, "img5");
            return (Criteria) this;
        }

        public Criteria andImg6IsNull() {
            addCriterion("img6 is null");
            return (Criteria) this;
        }

        public Criteria andImg6IsNotNull() {
            addCriterion("img6 is not null");
            return (Criteria) this;
        }

        public Criteria andImg6EqualTo(String value) {
            addCriterion("img6 =", value, "img6");
            return (Criteria) this;
        }

        public Criteria andImg6NotEqualTo(String value) {
            addCriterion("img6 <>", value, "img6");
            return (Criteria) this;
        }

        public Criteria andImg6GreaterThan(String value) {
            addCriterion("img6 >", value, "img6");
            return (Criteria) this;
        }

        public Criteria andImg6GreaterThanOrEqualTo(String value) {
            addCriterion("img6 >=", value, "img6");
            return (Criteria) this;
        }

        public Criteria andImg6LessThan(String value) {
            addCriterion("img6 <", value, "img6");
            return (Criteria) this;
        }

        public Criteria andImg6LessThanOrEqualTo(String value) {
            addCriterion("img6 <=", value, "img6");
            return (Criteria) this;
        }

        public Criteria andImg6Like(String value) {
            addCriterion("img6 like", value, "img6");
            return (Criteria) this;
        }

        public Criteria andImg6NotLike(String value) {
            addCriterion("img6 not like", value, "img6");
            return (Criteria) this;
        }

        public Criteria andImg6In(List<String> values) {
            addCriterion("img6 in", values, "img6");
            return (Criteria) this;
        }

        public Criteria andImg6NotIn(List<String> values) {
            addCriterion("img6 not in", values, "img6");
            return (Criteria) this;
        }

        public Criteria andImg6Between(String value1, String value2) {
            addCriterion("img6 between", value1, value2, "img6");
            return (Criteria) this;
        }

        public Criteria andImg6NotBetween(String value1, String value2) {
            addCriterion("img6 not between", value1, value2, "img6");
            return (Criteria) this;
        }

        public Criteria andImg7IsNull() {
            addCriterion("img7 is null");
            return (Criteria) this;
        }

        public Criteria andImg7IsNotNull() {
            addCriterion("img7 is not null");
            return (Criteria) this;
        }

        public Criteria andImg7EqualTo(String value) {
            addCriterion("img7 =", value, "img7");
            return (Criteria) this;
        }

        public Criteria andImg7NotEqualTo(String value) {
            addCriterion("img7 <>", value, "img7");
            return (Criteria) this;
        }

        public Criteria andImg7GreaterThan(String value) {
            addCriterion("img7 >", value, "img7");
            return (Criteria) this;
        }

        public Criteria andImg7GreaterThanOrEqualTo(String value) {
            addCriterion("img7 >=", value, "img7");
            return (Criteria) this;
        }

        public Criteria andImg7LessThan(String value) {
            addCriterion("img7 <", value, "img7");
            return (Criteria) this;
        }

        public Criteria andImg7LessThanOrEqualTo(String value) {
            addCriterion("img7 <=", value, "img7");
            return (Criteria) this;
        }

        public Criteria andImg7Like(String value) {
            addCriterion("img7 like", value, "img7");
            return (Criteria) this;
        }

        public Criteria andImg7NotLike(String value) {
            addCriterion("img7 not like", value, "img7");
            return (Criteria) this;
        }

        public Criteria andImg7In(List<String> values) {
            addCriterion("img7 in", values, "img7");
            return (Criteria) this;
        }

        public Criteria andImg7NotIn(List<String> values) {
            addCriterion("img7 not in", values, "img7");
            return (Criteria) this;
        }

        public Criteria andImg7Between(String value1, String value2) {
            addCriterion("img7 between", value1, value2, "img7");
            return (Criteria) this;
        }

        public Criteria andImg7NotBetween(String value1, String value2) {
            addCriterion("img7 not between", value1, value2, "img7");
            return (Criteria) this;
        }

        public Criteria andImg8IsNull() {
            addCriterion("img8 is null");
            return (Criteria) this;
        }

        public Criteria andImg8IsNotNull() {
            addCriterion("img8 is not null");
            return (Criteria) this;
        }

        public Criteria andImg8EqualTo(String value) {
            addCriterion("img8 =", value, "img8");
            return (Criteria) this;
        }

        public Criteria andImg8NotEqualTo(String value) {
            addCriterion("img8 <>", value, "img8");
            return (Criteria) this;
        }

        public Criteria andImg8GreaterThan(String value) {
            addCriterion("img8 >", value, "img8");
            return (Criteria) this;
        }

        public Criteria andImg8GreaterThanOrEqualTo(String value) {
            addCriterion("img8 >=", value, "img8");
            return (Criteria) this;
        }

        public Criteria andImg8LessThan(String value) {
            addCriterion("img8 <", value, "img8");
            return (Criteria) this;
        }

        public Criteria andImg8LessThanOrEqualTo(String value) {
            addCriterion("img8 <=", value, "img8");
            return (Criteria) this;
        }

        public Criteria andImg8Like(String value) {
            addCriterion("img8 like", value, "img8");
            return (Criteria) this;
        }

        public Criteria andImg8NotLike(String value) {
            addCriterion("img8 not like", value, "img8");
            return (Criteria) this;
        }

        public Criteria andImg8In(List<String> values) {
            addCriterion("img8 in", values, "img8");
            return (Criteria) this;
        }

        public Criteria andImg8NotIn(List<String> values) {
            addCriterion("img8 not in", values, "img8");
            return (Criteria) this;
        }

        public Criteria andImg8Between(String value1, String value2) {
            addCriterion("img8 between", value1, value2, "img8");
            return (Criteria) this;
        }

        public Criteria andImg8NotBetween(String value1, String value2) {
            addCriterion("img8 not between", value1, value2, "img8");
            return (Criteria) this;
        }

        public Criteria andImg9IsNull() {
            addCriterion("img9 is null");
            return (Criteria) this;
        }

        public Criteria andImg9IsNotNull() {
            addCriterion("img9 is not null");
            return (Criteria) this;
        }

        public Criteria andImg9EqualTo(String value) {
            addCriterion("img9 =", value, "img9");
            return (Criteria) this;
        }

        public Criteria andImg9NotEqualTo(String value) {
            addCriterion("img9 <>", value, "img9");
            return (Criteria) this;
        }

        public Criteria andImg9GreaterThan(String value) {
            addCriterion("img9 >", value, "img9");
            return (Criteria) this;
        }

        public Criteria andImg9GreaterThanOrEqualTo(String value) {
            addCriterion("img9 >=", value, "img9");
            return (Criteria) this;
        }

        public Criteria andImg9LessThan(String value) {
            addCriterion("img9 <", value, "img9");
            return (Criteria) this;
        }

        public Criteria andImg9LessThanOrEqualTo(String value) {
            addCriterion("img9 <=", value, "img9");
            return (Criteria) this;
        }

        public Criteria andImg9Like(String value) {
            addCriterion("img9 like", value, "img9");
            return (Criteria) this;
        }

        public Criteria andImg9NotLike(String value) {
            addCriterion("img9 not like", value, "img9");
            return (Criteria) this;
        }

        public Criteria andImg9In(List<String> values) {
            addCriterion("img9 in", values, "img9");
            return (Criteria) this;
        }

        public Criteria andImg9NotIn(List<String> values) {
            addCriterion("img9 not in", values, "img9");
            return (Criteria) this;
        }

        public Criteria andImg9Between(String value1, String value2) {
            addCriterion("img9 between", value1, value2, "img9");
            return (Criteria) this;
        }

        public Criteria andImg9NotBetween(String value1, String value2) {
            addCriterion("img9 not between", value1, value2, "img9");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNull() {
            addCriterion("show_status is null");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNotNull() {
            addCriterion("show_status is not null");
            return (Criteria) this;
        }

        public Criteria andShowStatusEqualTo(String value) {
            addCriterion("show_status =", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotEqualTo(String value) {
            addCriterion("show_status <>", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThan(String value) {
            addCriterion("show_status >", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThanOrEqualTo(String value) {
            addCriterion("show_status >=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThan(String value) {
            addCriterion("show_status <", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThanOrEqualTo(String value) {
            addCriterion("show_status <=", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusLike(String value) {
            addCriterion("show_status like", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotLike(String value) {
            addCriterion("show_status not like", value, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusIn(List<String> values) {
            addCriterion("show_status in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotIn(List<String> values) {
            addCriterion("show_status not in", values, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusBetween(String value1, String value2) {
            addCriterion("show_status between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andShowStatusNotBetween(String value1, String value2) {
            addCriterion("show_status not between", value1, value2, "showStatus");
            return (Criteria) this;
        }

        public Criteria andCheckOperatorIsNull() {
            addCriterion("check_operator is null");
            return (Criteria) this;
        }

        public Criteria andCheckOperatorIsNotNull() {
            addCriterion("check_operator is not null");
            return (Criteria) this;
        }

        public Criteria andCheckOperatorEqualTo(String value) {
            addCriterion("check_operator =", value, "checkOperator");
            return (Criteria) this;
        }

        public Criteria andCheckOperatorNotEqualTo(String value) {
            addCriterion("check_operator <>", value, "checkOperator");
            return (Criteria) this;
        }

        public Criteria andCheckOperatorGreaterThan(String value) {
            addCriterion("check_operator >", value, "checkOperator");
            return (Criteria) this;
        }

        public Criteria andCheckOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("check_operator >=", value, "checkOperator");
            return (Criteria) this;
        }

        public Criteria andCheckOperatorLessThan(String value) {
            addCriterion("check_operator <", value, "checkOperator");
            return (Criteria) this;
        }

        public Criteria andCheckOperatorLessThanOrEqualTo(String value) {
            addCriterion("check_operator <=", value, "checkOperator");
            return (Criteria) this;
        }

        public Criteria andCheckOperatorLike(String value) {
            addCriterion("check_operator like", value, "checkOperator");
            return (Criteria) this;
        }

        public Criteria andCheckOperatorNotLike(String value) {
            addCriterion("check_operator not like", value, "checkOperator");
            return (Criteria) this;
        }

        public Criteria andCheckOperatorIn(List<String> values) {
            addCriterion("check_operator in", values, "checkOperator");
            return (Criteria) this;
        }

        public Criteria andCheckOperatorNotIn(List<String> values) {
            addCriterion("check_operator not in", values, "checkOperator");
            return (Criteria) this;
        }

        public Criteria andCheckOperatorBetween(String value1, String value2) {
            addCriterion("check_operator between", value1, value2, "checkOperator");
            return (Criteria) this;
        }

        public Criteria andCheckOperatorNotBetween(String value1, String value2) {
            addCriterion("check_operator not between", value1, value2, "checkOperator");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIsNull() {
            addCriterion("prize_type is null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIsNotNull() {
            addCriterion("prize_type is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeEqualTo(String value) {
            addCriterion("prize_type =", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotEqualTo(String value) {
            addCriterion("prize_type <>", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThan(String value) {
            addCriterion("prize_type >", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("prize_type >=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThan(String value) {
            addCriterion("prize_type <", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThanOrEqualTo(String value) {
            addCriterion("prize_type <=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLike(String value) {
            addCriterion("prize_type like", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotLike(String value) {
            addCriterion("prize_type not like", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIn(List<String> values) {
            addCriterion("prize_type in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotIn(List<String> values) {
            addCriterion("prize_type not in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeBetween(String value1, String value2) {
            addCriterion("prize_type between", value1, value2, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotBetween(String value1, String value2) {
            addCriterion("prize_type not between", value1, value2, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeCountIsNull() {
            addCriterion("prize_count is null");
            return (Criteria) this;
        }

        public Criteria andPrizeCountIsNotNull() {
            addCriterion("prize_count is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeCountEqualTo(Integer value) {
            addCriterion("prize_count =", value, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountNotEqualTo(Integer value) {
            addCriterion("prize_count <>", value, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountGreaterThan(Integer value) {
            addCriterion("prize_count >", value, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("prize_count >=", value, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountLessThan(Integer value) {
            addCriterion("prize_count <", value, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountLessThanOrEqualTo(Integer value) {
            addCriterion("prize_count <=", value, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountIn(List<Integer> values) {
            addCriterion("prize_count in", values, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountNotIn(List<Integer> values) {
            addCriterion("prize_count not in", values, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountBetween(Integer value1, Integer value2) {
            addCriterion("prize_count between", value1, value2, "prizeCount");
            return (Criteria) this;
        }

        public Criteria andPrizeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("prize_count not between", value1, value2, "prizeCount");
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