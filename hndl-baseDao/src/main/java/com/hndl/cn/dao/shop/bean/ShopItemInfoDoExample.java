package com.hndl.cn.dao.shop.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopItemInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ShopItemInfoDoExample() {
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

        public Criteria andShopItemTempletIdIsNull() {
            addCriterion("shop_item_templet_id is null");
            return (Criteria) this;
        }

        public Criteria andShopItemTempletIdIsNotNull() {
            addCriterion("shop_item_templet_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopItemTempletIdEqualTo(Long value) {
            addCriterion("shop_item_templet_id =", value, "shopItemTempletId");
            return (Criteria) this;
        }

        public Criteria andShopItemTempletIdNotEqualTo(Long value) {
            addCriterion("shop_item_templet_id <>", value, "shopItemTempletId");
            return (Criteria) this;
        }

        public Criteria andShopItemTempletIdGreaterThan(Long value) {
            addCriterion("shop_item_templet_id >", value, "shopItemTempletId");
            return (Criteria) this;
        }

        public Criteria andShopItemTempletIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_item_templet_id >=", value, "shopItemTempletId");
            return (Criteria) this;
        }

        public Criteria andShopItemTempletIdLessThan(Long value) {
            addCriterion("shop_item_templet_id <", value, "shopItemTempletId");
            return (Criteria) this;
        }

        public Criteria andShopItemTempletIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_item_templet_id <=", value, "shopItemTempletId");
            return (Criteria) this;
        }

        public Criteria andShopItemTempletIdIn(List<Long> values) {
            addCriterion("shop_item_templet_id in", values, "shopItemTempletId");
            return (Criteria) this;
        }

        public Criteria andShopItemTempletIdNotIn(List<Long> values) {
            addCriterion("shop_item_templet_id not in", values, "shopItemTempletId");
            return (Criteria) this;
        }

        public Criteria andShopItemTempletIdBetween(Long value1, Long value2) {
            addCriterion("shop_item_templet_id between", value1, value2, "shopItemTempletId");
            return (Criteria) this;
        }

        public Criteria andShopItemTempletIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_item_templet_id not between", value1, value2, "shopItemTempletId");
            return (Criteria) this;
        }

        public Criteria andCurrentItemIdIsNull() {
            addCriterion("current_item_id is null");
            return (Criteria) this;
        }

        public Criteria andCurrentItemIdIsNotNull() {
            addCriterion("current_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentItemIdEqualTo(Long value) {
            addCriterion("current_item_id =", value, "currentItemId");
            return (Criteria) this;
        }

        public Criteria andCurrentItemIdNotEqualTo(Long value) {
            addCriterion("current_item_id <>", value, "currentItemId");
            return (Criteria) this;
        }

        public Criteria andCurrentItemIdGreaterThan(Long value) {
            addCriterion("current_item_id >", value, "currentItemId");
            return (Criteria) this;
        }

        public Criteria andCurrentItemIdGreaterThanOrEqualTo(Long value) {
            addCriterion("current_item_id >=", value, "currentItemId");
            return (Criteria) this;
        }

        public Criteria andCurrentItemIdLessThan(Long value) {
            addCriterion("current_item_id <", value, "currentItemId");
            return (Criteria) this;
        }

        public Criteria andCurrentItemIdLessThanOrEqualTo(Long value) {
            addCriterion("current_item_id <=", value, "currentItemId");
            return (Criteria) this;
        }

        public Criteria andCurrentItemIdIn(List<Long> values) {
            addCriterion("current_item_id in", values, "currentItemId");
            return (Criteria) this;
        }

        public Criteria andCurrentItemIdNotIn(List<Long> values) {
            addCriterion("current_item_id not in", values, "currentItemId");
            return (Criteria) this;
        }

        public Criteria andCurrentItemIdBetween(Long value1, Long value2) {
            addCriterion("current_item_id between", value1, value2, "currentItemId");
            return (Criteria) this;
        }

        public Criteria andCurrentItemIdNotBetween(Long value1, Long value2) {
            addCriterion("current_item_id not between", value1, value2, "currentItemId");
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

        public Criteria andTitleSubIsNull() {
            addCriterion("title_sub is null");
            return (Criteria) this;
        }

        public Criteria andTitleSubIsNotNull() {
            addCriterion("title_sub is not null");
            return (Criteria) this;
        }

        public Criteria andTitleSubEqualTo(String value) {
            addCriterion("title_sub =", value, "titleSub");
            return (Criteria) this;
        }

        public Criteria andTitleSubNotEqualTo(String value) {
            addCriterion("title_sub <>", value, "titleSub");
            return (Criteria) this;
        }

        public Criteria andTitleSubGreaterThan(String value) {
            addCriterion("title_sub >", value, "titleSub");
            return (Criteria) this;
        }

        public Criteria andTitleSubGreaterThanOrEqualTo(String value) {
            addCriterion("title_sub >=", value, "titleSub");
            return (Criteria) this;
        }

        public Criteria andTitleSubLessThan(String value) {
            addCriterion("title_sub <", value, "titleSub");
            return (Criteria) this;
        }

        public Criteria andTitleSubLessThanOrEqualTo(String value) {
            addCriterion("title_sub <=", value, "titleSub");
            return (Criteria) this;
        }

        public Criteria andTitleSubLike(String value) {
            addCriterion("title_sub like", value, "titleSub");
            return (Criteria) this;
        }

        public Criteria andTitleSubNotLike(String value) {
            addCriterion("title_sub not like", value, "titleSub");
            return (Criteria) this;
        }

        public Criteria andTitleSubIn(List<String> values) {
            addCriterion("title_sub in", values, "titleSub");
            return (Criteria) this;
        }

        public Criteria andTitleSubNotIn(List<String> values) {
            addCriterion("title_sub not in", values, "titleSub");
            return (Criteria) this;
        }

        public Criteria andTitleSubBetween(String value1, String value2) {
            addCriterion("title_sub between", value1, value2, "titleSub");
            return (Criteria) this;
        }

        public Criteria andTitleSubNotBetween(String value1, String value2) {
            addCriterion("title_sub not between", value1, value2, "titleSub");
            return (Criteria) this;
        }

        public Criteria andAdImg1IsNull() {
            addCriterion("ad_img1 is null");
            return (Criteria) this;
        }

        public Criteria andAdImg1IsNotNull() {
            addCriterion("ad_img1 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImg1EqualTo(String value) {
            addCriterion("ad_img1 =", value, "adImg1");
            return (Criteria) this;
        }

        public Criteria andAdImg1NotEqualTo(String value) {
            addCriterion("ad_img1 <>", value, "adImg1");
            return (Criteria) this;
        }

        public Criteria andAdImg1GreaterThan(String value) {
            addCriterion("ad_img1 >", value, "adImg1");
            return (Criteria) this;
        }

        public Criteria andAdImg1GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img1 >=", value, "adImg1");
            return (Criteria) this;
        }

        public Criteria andAdImg1LessThan(String value) {
            addCriterion("ad_img1 <", value, "adImg1");
            return (Criteria) this;
        }

        public Criteria andAdImg1LessThanOrEqualTo(String value) {
            addCriterion("ad_img1 <=", value, "adImg1");
            return (Criteria) this;
        }

        public Criteria andAdImg1Like(String value) {
            addCriterion("ad_img1 like", value, "adImg1");
            return (Criteria) this;
        }

        public Criteria andAdImg1NotLike(String value) {
            addCriterion("ad_img1 not like", value, "adImg1");
            return (Criteria) this;
        }

        public Criteria andAdImg1In(List<String> values) {
            addCriterion("ad_img1 in", values, "adImg1");
            return (Criteria) this;
        }

        public Criteria andAdImg1NotIn(List<String> values) {
            addCriterion("ad_img1 not in", values, "adImg1");
            return (Criteria) this;
        }

        public Criteria andAdImg1Between(String value1, String value2) {
            addCriterion("ad_img1 between", value1, value2, "adImg1");
            return (Criteria) this;
        }

        public Criteria andAdImg1NotBetween(String value1, String value2) {
            addCriterion("ad_img1 not between", value1, value2, "adImg1");
            return (Criteria) this;
        }

        public Criteria andAdImg2IsNull() {
            addCriterion("ad_img2 is null");
            return (Criteria) this;
        }

        public Criteria andAdImg2IsNotNull() {
            addCriterion("ad_img2 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImg2EqualTo(String value) {
            addCriterion("ad_img2 =", value, "adImg2");
            return (Criteria) this;
        }

        public Criteria andAdImg2NotEqualTo(String value) {
            addCriterion("ad_img2 <>", value, "adImg2");
            return (Criteria) this;
        }

        public Criteria andAdImg2GreaterThan(String value) {
            addCriterion("ad_img2 >", value, "adImg2");
            return (Criteria) this;
        }

        public Criteria andAdImg2GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img2 >=", value, "adImg2");
            return (Criteria) this;
        }

        public Criteria andAdImg2LessThan(String value) {
            addCriterion("ad_img2 <", value, "adImg2");
            return (Criteria) this;
        }

        public Criteria andAdImg2LessThanOrEqualTo(String value) {
            addCriterion("ad_img2 <=", value, "adImg2");
            return (Criteria) this;
        }

        public Criteria andAdImg2Like(String value) {
            addCriterion("ad_img2 like", value, "adImg2");
            return (Criteria) this;
        }

        public Criteria andAdImg2NotLike(String value) {
            addCriterion("ad_img2 not like", value, "adImg2");
            return (Criteria) this;
        }

        public Criteria andAdImg2In(List<String> values) {
            addCriterion("ad_img2 in", values, "adImg2");
            return (Criteria) this;
        }

        public Criteria andAdImg2NotIn(List<String> values) {
            addCriterion("ad_img2 not in", values, "adImg2");
            return (Criteria) this;
        }

        public Criteria andAdImg2Between(String value1, String value2) {
            addCriterion("ad_img2 between", value1, value2, "adImg2");
            return (Criteria) this;
        }

        public Criteria andAdImg2NotBetween(String value1, String value2) {
            addCriterion("ad_img2 not between", value1, value2, "adImg2");
            return (Criteria) this;
        }

        public Criteria andAdImg3IsNull() {
            addCriterion("ad_img3 is null");
            return (Criteria) this;
        }

        public Criteria andAdImg3IsNotNull() {
            addCriterion("ad_img3 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImg3EqualTo(String value) {
            addCriterion("ad_img3 =", value, "adImg3");
            return (Criteria) this;
        }

        public Criteria andAdImg3NotEqualTo(String value) {
            addCriterion("ad_img3 <>", value, "adImg3");
            return (Criteria) this;
        }

        public Criteria andAdImg3GreaterThan(String value) {
            addCriterion("ad_img3 >", value, "adImg3");
            return (Criteria) this;
        }

        public Criteria andAdImg3GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img3 >=", value, "adImg3");
            return (Criteria) this;
        }

        public Criteria andAdImg3LessThan(String value) {
            addCriterion("ad_img3 <", value, "adImg3");
            return (Criteria) this;
        }

        public Criteria andAdImg3LessThanOrEqualTo(String value) {
            addCriterion("ad_img3 <=", value, "adImg3");
            return (Criteria) this;
        }

        public Criteria andAdImg3Like(String value) {
            addCriterion("ad_img3 like", value, "adImg3");
            return (Criteria) this;
        }

        public Criteria andAdImg3NotLike(String value) {
            addCriterion("ad_img3 not like", value, "adImg3");
            return (Criteria) this;
        }

        public Criteria andAdImg3In(List<String> values) {
            addCriterion("ad_img3 in", values, "adImg3");
            return (Criteria) this;
        }

        public Criteria andAdImg3NotIn(List<String> values) {
            addCriterion("ad_img3 not in", values, "adImg3");
            return (Criteria) this;
        }

        public Criteria andAdImg3Between(String value1, String value2) {
            addCriterion("ad_img3 between", value1, value2, "adImg3");
            return (Criteria) this;
        }

        public Criteria andAdImg3NotBetween(String value1, String value2) {
            addCriterion("ad_img3 not between", value1, value2, "adImg3");
            return (Criteria) this;
        }

        public Criteria andAdImg4IsNull() {
            addCriterion("ad_img4 is null");
            return (Criteria) this;
        }

        public Criteria andAdImg4IsNotNull() {
            addCriterion("ad_img4 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImg4EqualTo(String value) {
            addCriterion("ad_img4 =", value, "adImg4");
            return (Criteria) this;
        }

        public Criteria andAdImg4NotEqualTo(String value) {
            addCriterion("ad_img4 <>", value, "adImg4");
            return (Criteria) this;
        }

        public Criteria andAdImg4GreaterThan(String value) {
            addCriterion("ad_img4 >", value, "adImg4");
            return (Criteria) this;
        }

        public Criteria andAdImg4GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img4 >=", value, "adImg4");
            return (Criteria) this;
        }

        public Criteria andAdImg4LessThan(String value) {
            addCriterion("ad_img4 <", value, "adImg4");
            return (Criteria) this;
        }

        public Criteria andAdImg4LessThanOrEqualTo(String value) {
            addCriterion("ad_img4 <=", value, "adImg4");
            return (Criteria) this;
        }

        public Criteria andAdImg4Like(String value) {
            addCriterion("ad_img4 like", value, "adImg4");
            return (Criteria) this;
        }

        public Criteria andAdImg4NotLike(String value) {
            addCriterion("ad_img4 not like", value, "adImg4");
            return (Criteria) this;
        }

        public Criteria andAdImg4In(List<String> values) {
            addCriterion("ad_img4 in", values, "adImg4");
            return (Criteria) this;
        }

        public Criteria andAdImg4NotIn(List<String> values) {
            addCriterion("ad_img4 not in", values, "adImg4");
            return (Criteria) this;
        }

        public Criteria andAdImg4Between(String value1, String value2) {
            addCriterion("ad_img4 between", value1, value2, "adImg4");
            return (Criteria) this;
        }

        public Criteria andAdImg4NotBetween(String value1, String value2) {
            addCriterion("ad_img4 not between", value1, value2, "adImg4");
            return (Criteria) this;
        }

        public Criteria andAdImg5IsNull() {
            addCriterion("ad_img5 is null");
            return (Criteria) this;
        }

        public Criteria andAdImg5IsNotNull() {
            addCriterion("ad_img5 is not null");
            return (Criteria) this;
        }

        public Criteria andAdImg5EqualTo(String value) {
            addCriterion("ad_img5 =", value, "adImg5");
            return (Criteria) this;
        }

        public Criteria andAdImg5NotEqualTo(String value) {
            addCriterion("ad_img5 <>", value, "adImg5");
            return (Criteria) this;
        }

        public Criteria andAdImg5GreaterThan(String value) {
            addCriterion("ad_img5 >", value, "adImg5");
            return (Criteria) this;
        }

        public Criteria andAdImg5GreaterThanOrEqualTo(String value) {
            addCriterion("ad_img5 >=", value, "adImg5");
            return (Criteria) this;
        }

        public Criteria andAdImg5LessThan(String value) {
            addCriterion("ad_img5 <", value, "adImg5");
            return (Criteria) this;
        }

        public Criteria andAdImg5LessThanOrEqualTo(String value) {
            addCriterion("ad_img5 <=", value, "adImg5");
            return (Criteria) this;
        }

        public Criteria andAdImg5Like(String value) {
            addCriterion("ad_img5 like", value, "adImg5");
            return (Criteria) this;
        }

        public Criteria andAdImg5NotLike(String value) {
            addCriterion("ad_img5 not like", value, "adImg5");
            return (Criteria) this;
        }

        public Criteria andAdImg5In(List<String> values) {
            addCriterion("ad_img5 in", values, "adImg5");
            return (Criteria) this;
        }

        public Criteria andAdImg5NotIn(List<String> values) {
            addCriterion("ad_img5 not in", values, "adImg5");
            return (Criteria) this;
        }

        public Criteria andAdImg5Between(String value1, String value2) {
            addCriterion("ad_img5 between", value1, value2, "adImg5");
            return (Criteria) this;
        }

        public Criteria andAdImg5NotBetween(String value1, String value2) {
            addCriterion("ad_img5 not between", value1, value2, "adImg5");
            return (Criteria) this;
        }

        public Criteria andItemDescIsNull() {
            addCriterion("item_desc is null");
            return (Criteria) this;
        }

        public Criteria andItemDescIsNotNull() {
            addCriterion("item_desc is not null");
            return (Criteria) this;
        }

        public Criteria andItemDescEqualTo(String value) {
            addCriterion("item_desc =", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescNotEqualTo(String value) {
            addCriterion("item_desc <>", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescGreaterThan(String value) {
            addCriterion("item_desc >", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescGreaterThanOrEqualTo(String value) {
            addCriterion("item_desc >=", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescLessThan(String value) {
            addCriterion("item_desc <", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescLessThanOrEqualTo(String value) {
            addCriterion("item_desc <=", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescLike(String value) {
            addCriterion("item_desc like", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescNotLike(String value) {
            addCriterion("item_desc not like", value, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescIn(List<String> values) {
            addCriterion("item_desc in", values, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescNotIn(List<String> values) {
            addCriterion("item_desc not in", values, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescBetween(String value1, String value2) {
            addCriterion("item_desc between", value1, value2, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andItemDescNotBetween(String value1, String value2) {
            addCriterion("item_desc not between", value1, value2, "itemDesc");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(Integer value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(Integer value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(Integer value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(Integer value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(Integer value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<Integer> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<Integer> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(Integer value1, Integer value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andPriceCountIsNull() {
            addCriterion("price_count is null");
            return (Criteria) this;
        }

        public Criteria andPriceCountIsNotNull() {
            addCriterion("price_count is not null");
            return (Criteria) this;
        }

        public Criteria andPriceCountEqualTo(Integer value) {
            addCriterion("price_count =", value, "priceCount");
            return (Criteria) this;
        }

        public Criteria andPriceCountNotEqualTo(Integer value) {
            addCriterion("price_count <>", value, "priceCount");
            return (Criteria) this;
        }

        public Criteria andPriceCountGreaterThan(Integer value) {
            addCriterion("price_count >", value, "priceCount");
            return (Criteria) this;
        }

        public Criteria andPriceCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("price_count >=", value, "priceCount");
            return (Criteria) this;
        }

        public Criteria andPriceCountLessThan(Integer value) {
            addCriterion("price_count <", value, "priceCount");
            return (Criteria) this;
        }

        public Criteria andPriceCountLessThanOrEqualTo(Integer value) {
            addCriterion("price_count <=", value, "priceCount");
            return (Criteria) this;
        }

        public Criteria andPriceCountIn(List<Integer> values) {
            addCriterion("price_count in", values, "priceCount");
            return (Criteria) this;
        }

        public Criteria andPriceCountNotIn(List<Integer> values) {
            addCriterion("price_count not in", values, "priceCount");
            return (Criteria) this;
        }

        public Criteria andPriceCountBetween(Integer value1, Integer value2) {
            addCriterion("price_count between", value1, value2, "priceCount");
            return (Criteria) this;
        }

        public Criteria andPriceCountNotBetween(Integer value1, Integer value2) {
            addCriterion("price_count not between", value1, value2, "priceCount");
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

        public Criteria andRemainCountIsNull() {
            addCriterion("remain_count is null");
            return (Criteria) this;
        }

        public Criteria andRemainCountIsNotNull() {
            addCriterion("remain_count is not null");
            return (Criteria) this;
        }

        public Criteria andRemainCountEqualTo(Integer value) {
            addCriterion("remain_count =", value, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountNotEqualTo(Integer value) {
            addCriterion("remain_count <>", value, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountGreaterThan(Integer value) {
            addCriterion("remain_count >", value, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("remain_count >=", value, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountLessThan(Integer value) {
            addCriterion("remain_count <", value, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountLessThanOrEqualTo(Integer value) {
            addCriterion("remain_count <=", value, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountIn(List<Integer> values) {
            addCriterion("remain_count in", values, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountNotIn(List<Integer> values) {
            addCriterion("remain_count not in", values, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountBetween(Integer value1, Integer value2) {
            addCriterion("remain_count between", value1, value2, "remainCount");
            return (Criteria) this;
        }

        public Criteria andRemainCountNotBetween(Integer value1, Integer value2) {
            addCriterion("remain_count not between", value1, value2, "remainCount");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceIsNull() {
            addCriterion("direct_buy_price is null");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceIsNotNull() {
            addCriterion("direct_buy_price is not null");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceEqualTo(Double value) {
            addCriterion("direct_buy_price =", value, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceNotEqualTo(Double value) {
            addCriterion("direct_buy_price <>", value, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceGreaterThan(Double value) {
            addCriterion("direct_buy_price >", value, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("direct_buy_price >=", value, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceLessThan(Double value) {
            addCriterion("direct_buy_price <", value, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceLessThanOrEqualTo(Double value) {
            addCriterion("direct_buy_price <=", value, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceIn(List<Double> values) {
            addCriterion("direct_buy_price in", values, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceNotIn(List<Double> values) {
            addCriterion("direct_buy_price not in", values, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceBetween(Double value1, Double value2) {
            addCriterion("direct_buy_price between", value1, value2, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceNotBetween(Double value1, Double value2) {
            addCriterion("direct_buy_price not between", value1, value2, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceTypeIsNull() {
            addCriterion("direct_buy_price_type is null");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceTypeIsNotNull() {
            addCriterion("direct_buy_price_type is not null");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceTypeEqualTo(String value) {
            addCriterion("direct_buy_price_type =", value, "directBuyPriceType");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceTypeNotEqualTo(String value) {
            addCriterion("direct_buy_price_type <>", value, "directBuyPriceType");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceTypeGreaterThan(String value) {
            addCriterion("direct_buy_price_type >", value, "directBuyPriceType");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("direct_buy_price_type >=", value, "directBuyPriceType");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceTypeLessThan(String value) {
            addCriterion("direct_buy_price_type <", value, "directBuyPriceType");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceTypeLessThanOrEqualTo(String value) {
            addCriterion("direct_buy_price_type <=", value, "directBuyPriceType");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceTypeLike(String value) {
            addCriterion("direct_buy_price_type like", value, "directBuyPriceType");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceTypeNotLike(String value) {
            addCriterion("direct_buy_price_type not like", value, "directBuyPriceType");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceTypeIn(List<String> values) {
            addCriterion("direct_buy_price_type in", values, "directBuyPriceType");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceTypeNotIn(List<String> values) {
            addCriterion("direct_buy_price_type not in", values, "directBuyPriceType");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceTypeBetween(String value1, String value2) {
            addCriterion("direct_buy_price_type between", value1, value2, "directBuyPriceType");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceTypeNotBetween(String value1, String value2) {
            addCriterion("direct_buy_price_type not between", value1, value2, "directBuyPriceType");
            return (Criteria) this;
        }

        public Criteria andType1IsNull() {
            addCriterion("type1 is null");
            return (Criteria) this;
        }

        public Criteria andType1IsNotNull() {
            addCriterion("type1 is not null");
            return (Criteria) this;
        }

        public Criteria andType1EqualTo(String value) {
            addCriterion("type1 =", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1NotEqualTo(String value) {
            addCriterion("type1 <>", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1GreaterThan(String value) {
            addCriterion("type1 >", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1GreaterThanOrEqualTo(String value) {
            addCriterion("type1 >=", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1LessThan(String value) {
            addCriterion("type1 <", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1LessThanOrEqualTo(String value) {
            addCriterion("type1 <=", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1Like(String value) {
            addCriterion("type1 like", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1NotLike(String value) {
            addCriterion("type1 not like", value, "type1");
            return (Criteria) this;
        }

        public Criteria andType1In(List<String> values) {
            addCriterion("type1 in", values, "type1");
            return (Criteria) this;
        }

        public Criteria andType1NotIn(List<String> values) {
            addCriterion("type1 not in", values, "type1");
            return (Criteria) this;
        }

        public Criteria andType1Between(String value1, String value2) {
            addCriterion("type1 between", value1, value2, "type1");
            return (Criteria) this;
        }

        public Criteria andType1NotBetween(String value1, String value2) {
            addCriterion("type1 not between", value1, value2, "type1");
            return (Criteria) this;
        }

        public Criteria andType2IsNull() {
            addCriterion("type2 is null");
            return (Criteria) this;
        }

        public Criteria andType2IsNotNull() {
            addCriterion("type2 is not null");
            return (Criteria) this;
        }

        public Criteria andType2EqualTo(String value) {
            addCriterion("type2 =", value, "type2");
            return (Criteria) this;
        }

        public Criteria andType2NotEqualTo(String value) {
            addCriterion("type2 <>", value, "type2");
            return (Criteria) this;
        }

        public Criteria andType2GreaterThan(String value) {
            addCriterion("type2 >", value, "type2");
            return (Criteria) this;
        }

        public Criteria andType2GreaterThanOrEqualTo(String value) {
            addCriterion("type2 >=", value, "type2");
            return (Criteria) this;
        }

        public Criteria andType2LessThan(String value) {
            addCriterion("type2 <", value, "type2");
            return (Criteria) this;
        }

        public Criteria andType2LessThanOrEqualTo(String value) {
            addCriterion("type2 <=", value, "type2");
            return (Criteria) this;
        }

        public Criteria andType2Like(String value) {
            addCriterion("type2 like", value, "type2");
            return (Criteria) this;
        }

        public Criteria andType2NotLike(String value) {
            addCriterion("type2 not like", value, "type2");
            return (Criteria) this;
        }

        public Criteria andType2In(List<String> values) {
            addCriterion("type2 in", values, "type2");
            return (Criteria) this;
        }

        public Criteria andType2NotIn(List<String> values) {
            addCriterion("type2 not in", values, "type2");
            return (Criteria) this;
        }

        public Criteria andType2Between(String value1, String value2) {
            addCriterion("type2 between", value1, value2, "type2");
            return (Criteria) this;
        }

        public Criteria andType2NotBetween(String value1, String value2) {
            addCriterion("type2 not between", value1, value2, "type2");
            return (Criteria) this;
        }

        public Criteria andLogoTypeIsNull() {
            addCriterion("logo_type is null");
            return (Criteria) this;
        }

        public Criteria andLogoTypeIsNotNull() {
            addCriterion("logo_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogoTypeEqualTo(String value) {
            addCriterion("logo_type =", value, "logoType");
            return (Criteria) this;
        }

        public Criteria andLogoTypeNotEqualTo(String value) {
            addCriterion("logo_type <>", value, "logoType");
            return (Criteria) this;
        }

        public Criteria andLogoTypeGreaterThan(String value) {
            addCriterion("logo_type >", value, "logoType");
            return (Criteria) this;
        }

        public Criteria andLogoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("logo_type >=", value, "logoType");
            return (Criteria) this;
        }

        public Criteria andLogoTypeLessThan(String value) {
            addCriterion("logo_type <", value, "logoType");
            return (Criteria) this;
        }

        public Criteria andLogoTypeLessThanOrEqualTo(String value) {
            addCriterion("logo_type <=", value, "logoType");
            return (Criteria) this;
        }

        public Criteria andLogoTypeLike(String value) {
            addCriterion("logo_type like", value, "logoType");
            return (Criteria) this;
        }

        public Criteria andLogoTypeNotLike(String value) {
            addCriterion("logo_type not like", value, "logoType");
            return (Criteria) this;
        }

        public Criteria andLogoTypeIn(List<String> values) {
            addCriterion("logo_type in", values, "logoType");
            return (Criteria) this;
        }

        public Criteria andLogoTypeNotIn(List<String> values) {
            addCriterion("logo_type not in", values, "logoType");
            return (Criteria) this;
        }

        public Criteria andLogoTypeBetween(String value1, String value2) {
            addCriterion("logo_type between", value1, value2, "logoType");
            return (Criteria) this;
        }

        public Criteria andLogoTypeNotBetween(String value1, String value2) {
            addCriterion("logo_type not between", value1, value2, "logoType");
            return (Criteria) this;
        }

        public Criteria andBuyMinCountIsNull() {
            addCriterion("buy_min_count is null");
            return (Criteria) this;
        }

        public Criteria andBuyMinCountIsNotNull() {
            addCriterion("buy_min_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuyMinCountEqualTo(Integer value) {
            addCriterion("buy_min_count =", value, "buyMinCount");
            return (Criteria) this;
        }

        public Criteria andBuyMinCountNotEqualTo(Integer value) {
            addCriterion("buy_min_count <>", value, "buyMinCount");
            return (Criteria) this;
        }

        public Criteria andBuyMinCountGreaterThan(Integer value) {
            addCriterion("buy_min_count >", value, "buyMinCount");
            return (Criteria) this;
        }

        public Criteria andBuyMinCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_min_count >=", value, "buyMinCount");
            return (Criteria) this;
        }

        public Criteria andBuyMinCountLessThan(Integer value) {
            addCriterion("buy_min_count <", value, "buyMinCount");
            return (Criteria) this;
        }

        public Criteria andBuyMinCountLessThanOrEqualTo(Integer value) {
            addCriterion("buy_min_count <=", value, "buyMinCount");
            return (Criteria) this;
        }

        public Criteria andBuyMinCountIn(List<Integer> values) {
            addCriterion("buy_min_count in", values, "buyMinCount");
            return (Criteria) this;
        }

        public Criteria andBuyMinCountNotIn(List<Integer> values) {
            addCriterion("buy_min_count not in", values, "buyMinCount");
            return (Criteria) this;
        }

        public Criteria andBuyMinCountBetween(Integer value1, Integer value2) {
            addCriterion("buy_min_count between", value1, value2, "buyMinCount");
            return (Criteria) this;
        }

        public Criteria andBuyMinCountNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_min_count not between", value1, value2, "buyMinCount");
            return (Criteria) this;
        }

        public Criteria andBuyMaxCountIsNull() {
            addCriterion("buy_max_count is null");
            return (Criteria) this;
        }

        public Criteria andBuyMaxCountIsNotNull() {
            addCriterion("buy_max_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuyMaxCountEqualTo(Integer value) {
            addCriterion("buy_max_count =", value, "buyMaxCount");
            return (Criteria) this;
        }

        public Criteria andBuyMaxCountNotEqualTo(Integer value) {
            addCriterion("buy_max_count <>", value, "buyMaxCount");
            return (Criteria) this;
        }

        public Criteria andBuyMaxCountGreaterThan(Integer value) {
            addCriterion("buy_max_count >", value, "buyMaxCount");
            return (Criteria) this;
        }

        public Criteria andBuyMaxCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_max_count >=", value, "buyMaxCount");
            return (Criteria) this;
        }

        public Criteria andBuyMaxCountLessThan(Integer value) {
            addCriterion("buy_max_count <", value, "buyMaxCount");
            return (Criteria) this;
        }

        public Criteria andBuyMaxCountLessThanOrEqualTo(Integer value) {
            addCriterion("buy_max_count <=", value, "buyMaxCount");
            return (Criteria) this;
        }

        public Criteria andBuyMaxCountIn(List<Integer> values) {
            addCriterion("buy_max_count in", values, "buyMaxCount");
            return (Criteria) this;
        }

        public Criteria andBuyMaxCountNotIn(List<Integer> values) {
            addCriterion("buy_max_count not in", values, "buyMaxCount");
            return (Criteria) this;
        }

        public Criteria andBuyMaxCountBetween(Integer value1, Integer value2) {
            addCriterion("buy_max_count between", value1, value2, "buyMaxCount");
            return (Criteria) this;
        }

        public Criteria andBuyMaxCountNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_max_count not between", value1, value2, "buyMaxCount");
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

        public Criteria andItemPropertyIsNull() {
            addCriterion("item_property is null");
            return (Criteria) this;
        }

        public Criteria andItemPropertyIsNotNull() {
            addCriterion("item_property is not null");
            return (Criteria) this;
        }

        public Criteria andItemPropertyEqualTo(String value) {
            addCriterion("item_property =", value, "itemProperty");
            return (Criteria) this;
        }

        public Criteria andItemPropertyNotEqualTo(String value) {
            addCriterion("item_property <>", value, "itemProperty");
            return (Criteria) this;
        }

        public Criteria andItemPropertyGreaterThan(String value) {
            addCriterion("item_property >", value, "itemProperty");
            return (Criteria) this;
        }

        public Criteria andItemPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("item_property >=", value, "itemProperty");
            return (Criteria) this;
        }

        public Criteria andItemPropertyLessThan(String value) {
            addCriterion("item_property <", value, "itemProperty");
            return (Criteria) this;
        }

        public Criteria andItemPropertyLessThanOrEqualTo(String value) {
            addCriterion("item_property <=", value, "itemProperty");
            return (Criteria) this;
        }

        public Criteria andItemPropertyLike(String value) {
            addCriterion("item_property like", value, "itemProperty");
            return (Criteria) this;
        }

        public Criteria andItemPropertyNotLike(String value) {
            addCriterion("item_property not like", value, "itemProperty");
            return (Criteria) this;
        }

        public Criteria andItemPropertyIn(List<String> values) {
            addCriterion("item_property in", values, "itemProperty");
            return (Criteria) this;
        }

        public Criteria andItemPropertyNotIn(List<String> values) {
            addCriterion("item_property not in", values, "itemProperty");
            return (Criteria) this;
        }

        public Criteria andItemPropertyBetween(String value1, String value2) {
            addCriterion("item_property between", value1, value2, "itemProperty");
            return (Criteria) this;
        }

        public Criteria andItemPropertyNotBetween(String value1, String value2) {
            addCriterion("item_property not between", value1, value2, "itemProperty");
            return (Criteria) this;
        }

        public Criteria andCurrentSectionIsNull() {
            addCriterion("current_section is null");
            return (Criteria) this;
        }

        public Criteria andCurrentSectionIsNotNull() {
            addCriterion("current_section is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentSectionEqualTo(Integer value) {
            addCriterion("current_section =", value, "currentSection");
            return (Criteria) this;
        }

        public Criteria andCurrentSectionNotEqualTo(Integer value) {
            addCriterion("current_section <>", value, "currentSection");
            return (Criteria) this;
        }

        public Criteria andCurrentSectionGreaterThan(Integer value) {
            addCriterion("current_section >", value, "currentSection");
            return (Criteria) this;
        }

        public Criteria andCurrentSectionGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_section >=", value, "currentSection");
            return (Criteria) this;
        }

        public Criteria andCurrentSectionLessThan(Integer value) {
            addCriterion("current_section <", value, "currentSection");
            return (Criteria) this;
        }

        public Criteria andCurrentSectionLessThanOrEqualTo(Integer value) {
            addCriterion("current_section <=", value, "currentSection");
            return (Criteria) this;
        }

        public Criteria andCurrentSectionIn(List<Integer> values) {
            addCriterion("current_section in", values, "currentSection");
            return (Criteria) this;
        }

        public Criteria andCurrentSectionNotIn(List<Integer> values) {
            addCriterion("current_section not in", values, "currentSection");
            return (Criteria) this;
        }

        public Criteria andCurrentSectionBetween(Integer value1, Integer value2) {
            addCriterion("current_section between", value1, value2, "currentSection");
            return (Criteria) this;
        }

        public Criteria andCurrentSectionNotBetween(Integer value1, Integer value2) {
            addCriterion("current_section not between", value1, value2, "currentSection");
            return (Criteria) this;
        }

        public Criteria andIsOnlineIsNull() {
            addCriterion("is_online is null");
            return (Criteria) this;
        }

        public Criteria andIsOnlineIsNotNull() {
            addCriterion("is_online is not null");
            return (Criteria) this;
        }

        public Criteria andIsOnlineEqualTo(String value) {
            addCriterion("is_online =", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineNotEqualTo(String value) {
            addCriterion("is_online <>", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineGreaterThan(String value) {
            addCriterion("is_online >", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineGreaterThanOrEqualTo(String value) {
            addCriterion("is_online >=", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLessThan(String value) {
            addCriterion("is_online <", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLessThanOrEqualTo(String value) {
            addCriterion("is_online <=", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineLike(String value) {
            addCriterion("is_online like", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineNotLike(String value) {
            addCriterion("is_online not like", value, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineIn(List<String> values) {
            addCriterion("is_online in", values, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineNotIn(List<String> values) {
            addCriterion("is_online not in", values, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineBetween(String value1, String value2) {
            addCriterion("is_online between", value1, value2, "isOnline");
            return (Criteria) this;
        }

        public Criteria andIsOnlineNotBetween(String value1, String value2) {
            addCriterion("is_online not between", value1, value2, "isOnline");
            return (Criteria) this;
        }

        public Criteria andAllSectionCountIsNull() {
            addCriterion("all_section_count is null");
            return (Criteria) this;
        }

        public Criteria andAllSectionCountIsNotNull() {
            addCriterion("all_section_count is not null");
            return (Criteria) this;
        }

        public Criteria andAllSectionCountEqualTo(Long value) {
            addCriterion("all_section_count =", value, "allSectionCount");
            return (Criteria) this;
        }

        public Criteria andAllSectionCountNotEqualTo(Long value) {
            addCriterion("all_section_count <>", value, "allSectionCount");
            return (Criteria) this;
        }

        public Criteria andAllSectionCountGreaterThan(Long value) {
            addCriterion("all_section_count >", value, "allSectionCount");
            return (Criteria) this;
        }

        public Criteria andAllSectionCountGreaterThanOrEqualTo(Long value) {
            addCriterion("all_section_count >=", value, "allSectionCount");
            return (Criteria) this;
        }

        public Criteria andAllSectionCountLessThan(Long value) {
            addCriterion("all_section_count <", value, "allSectionCount");
            return (Criteria) this;
        }

        public Criteria andAllSectionCountLessThanOrEqualTo(Long value) {
            addCriterion("all_section_count <=", value, "allSectionCount");
            return (Criteria) this;
        }

        public Criteria andAllSectionCountIn(List<Long> values) {
            addCriterion("all_section_count in", values, "allSectionCount");
            return (Criteria) this;
        }

        public Criteria andAllSectionCountNotIn(List<Long> values) {
            addCriterion("all_section_count not in", values, "allSectionCount");
            return (Criteria) this;
        }

        public Criteria andAllSectionCountBetween(Long value1, Long value2) {
            addCriterion("all_section_count between", value1, value2, "allSectionCount");
            return (Criteria) this;
        }

        public Criteria andAllSectionCountNotBetween(Long value1, Long value2) {
            addCriterion("all_section_count not between", value1, value2, "allSectionCount");
            return (Criteria) this;
        }

        public Criteria andLuckUserIdIsNull() {
            addCriterion("luck_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLuckUserIdIsNotNull() {
            addCriterion("luck_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLuckUserIdEqualTo(String value) {
            addCriterion("luck_user_id =", value, "luckUserId");
            return (Criteria) this;
        }

        public Criteria andLuckUserIdNotEqualTo(String value) {
            addCriterion("luck_user_id <>", value, "luckUserId");
            return (Criteria) this;
        }

        public Criteria andLuckUserIdGreaterThan(String value) {
            addCriterion("luck_user_id >", value, "luckUserId");
            return (Criteria) this;
        }

        public Criteria andLuckUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("luck_user_id >=", value, "luckUserId");
            return (Criteria) this;
        }

        public Criteria andLuckUserIdLessThan(String value) {
            addCriterion("luck_user_id <", value, "luckUserId");
            return (Criteria) this;
        }

        public Criteria andLuckUserIdLessThanOrEqualTo(String value) {
            addCriterion("luck_user_id <=", value, "luckUserId");
            return (Criteria) this;
        }

        public Criteria andLuckUserIdLike(String value) {
            addCriterion("luck_user_id like", value, "luckUserId");
            return (Criteria) this;
        }

        public Criteria andLuckUserIdNotLike(String value) {
            addCriterion("luck_user_id not like", value, "luckUserId");
            return (Criteria) this;
        }

        public Criteria andLuckUserIdIn(List<String> values) {
            addCriterion("luck_user_id in", values, "luckUserId");
            return (Criteria) this;
        }

        public Criteria andLuckUserIdNotIn(List<String> values) {
            addCriterion("luck_user_id not in", values, "luckUserId");
            return (Criteria) this;
        }

        public Criteria andLuckUserIdBetween(String value1, String value2) {
            addCriterion("luck_user_id between", value1, value2, "luckUserId");
            return (Criteria) this;
        }

        public Criteria andLuckUserIdNotBetween(String value1, String value2) {
            addCriterion("luck_user_id not between", value1, value2, "luckUserId");
            return (Criteria) this;
        }

        public Criteria andLuckNoIsNull() {
            addCriterion("luck_no is null");
            return (Criteria) this;
        }

        public Criteria andLuckNoIsNotNull() {
            addCriterion("luck_no is not null");
            return (Criteria) this;
        }

        public Criteria andLuckNoEqualTo(String value) {
            addCriterion("luck_no =", value, "luckNo");
            return (Criteria) this;
        }

        public Criteria andLuckNoNotEqualTo(String value) {
            addCriterion("luck_no <>", value, "luckNo");
            return (Criteria) this;
        }

        public Criteria andLuckNoGreaterThan(String value) {
            addCriterion("luck_no >", value, "luckNo");
            return (Criteria) this;
        }

        public Criteria andLuckNoGreaterThanOrEqualTo(String value) {
            addCriterion("luck_no >=", value, "luckNo");
            return (Criteria) this;
        }

        public Criteria andLuckNoLessThan(String value) {
            addCriterion("luck_no <", value, "luckNo");
            return (Criteria) this;
        }

        public Criteria andLuckNoLessThanOrEqualTo(String value) {
            addCriterion("luck_no <=", value, "luckNo");
            return (Criteria) this;
        }

        public Criteria andLuckNoLike(String value) {
            addCriterion("luck_no like", value, "luckNo");
            return (Criteria) this;
        }

        public Criteria andLuckNoNotLike(String value) {
            addCriterion("luck_no not like", value, "luckNo");
            return (Criteria) this;
        }

        public Criteria andLuckNoIn(List<String> values) {
            addCriterion("luck_no in", values, "luckNo");
            return (Criteria) this;
        }

        public Criteria andLuckNoNotIn(List<String> values) {
            addCriterion("luck_no not in", values, "luckNo");
            return (Criteria) this;
        }

        public Criteria andLuckNoBetween(String value1, String value2) {
            addCriterion("luck_no between", value1, value2, "luckNo");
            return (Criteria) this;
        }

        public Criteria andLuckNoNotBetween(String value1, String value2) {
            addCriterion("luck_no not between", value1, value2, "luckNo");
            return (Criteria) this;
        }

        public Criteria andItemStatusIsNull() {
            addCriterion("item_status is null");
            return (Criteria) this;
        }

        public Criteria andItemStatusIsNotNull() {
            addCriterion("item_status is not null");
            return (Criteria) this;
        }

        public Criteria andItemStatusEqualTo(String value) {
            addCriterion("item_status =", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotEqualTo(String value) {
            addCriterion("item_status <>", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusGreaterThan(String value) {
            addCriterion("item_status >", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusGreaterThanOrEqualTo(String value) {
            addCriterion("item_status >=", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusLessThan(String value) {
            addCriterion("item_status <", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusLessThanOrEqualTo(String value) {
            addCriterion("item_status <=", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusLike(String value) {
            addCriterion("item_status like", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotLike(String value) {
            addCriterion("item_status not like", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusIn(List<String> values) {
            addCriterion("item_status in", values, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotIn(List<String> values) {
            addCriterion("item_status not in", values, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusBetween(String value1, String value2) {
            addCriterion("item_status between", value1, value2, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotBetween(String value1, String value2) {
            addCriterion("item_status not between", value1, value2, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andApplyPersonCountIsNull() {
            addCriterion("apply_person_count is null");
            return (Criteria) this;
        }

        public Criteria andApplyPersonCountIsNotNull() {
            addCriterion("apply_person_count is not null");
            return (Criteria) this;
        }

        public Criteria andApplyPersonCountEqualTo(Integer value) {
            addCriterion("apply_person_count =", value, "applyPersonCount");
            return (Criteria) this;
        }

        public Criteria andApplyPersonCountNotEqualTo(Integer value) {
            addCriterion("apply_person_count <>", value, "applyPersonCount");
            return (Criteria) this;
        }

        public Criteria andApplyPersonCountGreaterThan(Integer value) {
            addCriterion("apply_person_count >", value, "applyPersonCount");
            return (Criteria) this;
        }

        public Criteria andApplyPersonCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("apply_person_count >=", value, "applyPersonCount");
            return (Criteria) this;
        }

        public Criteria andApplyPersonCountLessThan(Integer value) {
            addCriterion("apply_person_count <", value, "applyPersonCount");
            return (Criteria) this;
        }

        public Criteria andApplyPersonCountLessThanOrEqualTo(Integer value) {
            addCriterion("apply_person_count <=", value, "applyPersonCount");
            return (Criteria) this;
        }

        public Criteria andApplyPersonCountIn(List<Integer> values) {
            addCriterion("apply_person_count in", values, "applyPersonCount");
            return (Criteria) this;
        }

        public Criteria andApplyPersonCountNotIn(List<Integer> values) {
            addCriterion("apply_person_count not in", values, "applyPersonCount");
            return (Criteria) this;
        }

        public Criteria andApplyPersonCountBetween(Integer value1, Integer value2) {
            addCriterion("apply_person_count between", value1, value2, "applyPersonCount");
            return (Criteria) this;
        }

        public Criteria andApplyPersonCountNotBetween(Integer value1, Integer value2) {
            addCriterion("apply_person_count not between", value1, value2, "applyPersonCount");
            return (Criteria) this;
        }

        public Criteria andOpenDatetimeIsNull() {
            addCriterion("open_datetime is null");
            return (Criteria) this;
        }

        public Criteria andOpenDatetimeIsNotNull() {
            addCriterion("open_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDatetimeEqualTo(Date value) {
            addCriterion("open_datetime =", value, "openDatetime");
            return (Criteria) this;
        }

        public Criteria andOpenDatetimeNotEqualTo(Date value) {
            addCriterion("open_datetime <>", value, "openDatetime");
            return (Criteria) this;
        }

        public Criteria andOpenDatetimeGreaterThan(Date value) {
            addCriterion("open_datetime >", value, "openDatetime");
            return (Criteria) this;
        }

        public Criteria andOpenDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("open_datetime >=", value, "openDatetime");
            return (Criteria) this;
        }

        public Criteria andOpenDatetimeLessThan(Date value) {
            addCriterion("open_datetime <", value, "openDatetime");
            return (Criteria) this;
        }

        public Criteria andOpenDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("open_datetime <=", value, "openDatetime");
            return (Criteria) this;
        }

        public Criteria andOpenDatetimeIn(List<Date> values) {
            addCriterion("open_datetime in", values, "openDatetime");
            return (Criteria) this;
        }

        public Criteria andOpenDatetimeNotIn(List<Date> values) {
            addCriterion("open_datetime not in", values, "openDatetime");
            return (Criteria) this;
        }

        public Criteria andOpenDatetimeBetween(Date value1, Date value2) {
            addCriterion("open_datetime between", value1, value2, "openDatetime");
            return (Criteria) this;
        }

        public Criteria andOpenDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("open_datetime not between", value1, value2, "openDatetime");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeTypeIsNull() {
            addCriterion("buy_prize_type is null");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeTypeIsNotNull() {
            addCriterion("buy_prize_type is not null");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeTypeEqualTo(String value) {
            addCriterion("buy_prize_type =", value, "buyPrizeType");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeTypeNotEqualTo(String value) {
            addCriterion("buy_prize_type <>", value, "buyPrizeType");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeTypeGreaterThan(String value) {
            addCriterion("buy_prize_type >", value, "buyPrizeType");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("buy_prize_type >=", value, "buyPrizeType");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeTypeLessThan(String value) {
            addCriterion("buy_prize_type <", value, "buyPrizeType");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeTypeLessThanOrEqualTo(String value) {
            addCriterion("buy_prize_type <=", value, "buyPrizeType");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeTypeLike(String value) {
            addCriterion("buy_prize_type like", value, "buyPrizeType");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeTypeNotLike(String value) {
            addCriterion("buy_prize_type not like", value, "buyPrizeType");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeTypeIn(List<String> values) {
            addCriterion("buy_prize_type in", values, "buyPrizeType");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeTypeNotIn(List<String> values) {
            addCriterion("buy_prize_type not in", values, "buyPrizeType");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeTypeBetween(String value1, String value2) {
            addCriterion("buy_prize_type between", value1, value2, "buyPrizeType");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeTypeNotBetween(String value1, String value2) {
            addCriterion("buy_prize_type not between", value1, value2, "buyPrizeType");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeCountIsNull() {
            addCriterion("buy_prize_count is null");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeCountIsNotNull() {
            addCriterion("buy_prize_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeCountEqualTo(Integer value) {
            addCriterion("buy_prize_count =", value, "buyPrizeCount");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeCountNotEqualTo(Integer value) {
            addCriterion("buy_prize_count <>", value, "buyPrizeCount");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeCountGreaterThan(Integer value) {
            addCriterion("buy_prize_count >", value, "buyPrizeCount");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_prize_count >=", value, "buyPrizeCount");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeCountLessThan(Integer value) {
            addCriterion("buy_prize_count <", value, "buyPrizeCount");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeCountLessThanOrEqualTo(Integer value) {
            addCriterion("buy_prize_count <=", value, "buyPrizeCount");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeCountIn(List<Integer> values) {
            addCriterion("buy_prize_count in", values, "buyPrizeCount");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeCountNotIn(List<Integer> values) {
            addCriterion("buy_prize_count not in", values, "buyPrizeCount");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeCountBetween(Integer value1, Integer value2) {
            addCriterion("buy_prize_count between", value1, value2, "buyPrizeCount");
            return (Criteria) this;
        }

        public Criteria andBuyPrizeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_prize_count not between", value1, value2, "buyPrizeCount");
            return (Criteria) this;
        }

        public Criteria andIsHelpIsNull() {
            addCriterion("is_help is null");
            return (Criteria) this;
        }

        public Criteria andIsHelpIsNotNull() {
            addCriterion("is_help is not null");
            return (Criteria) this;
        }

        public Criteria andIsHelpEqualTo(String value) {
            addCriterion("is_help =", value, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpNotEqualTo(String value) {
            addCriterion("is_help <>", value, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpGreaterThan(String value) {
            addCriterion("is_help >", value, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpGreaterThanOrEqualTo(String value) {
            addCriterion("is_help >=", value, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpLessThan(String value) {
            addCriterion("is_help <", value, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpLessThanOrEqualTo(String value) {
            addCriterion("is_help <=", value, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpLike(String value) {
            addCriterion("is_help like", value, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpNotLike(String value) {
            addCriterion("is_help not like", value, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpIn(List<String> values) {
            addCriterion("is_help in", values, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpNotIn(List<String> values) {
            addCriterion("is_help not in", values, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpBetween(String value1, String value2) {
            addCriterion("is_help between", value1, value2, "isHelp");
            return (Criteria) this;
        }

        public Criteria andIsHelpNotBetween(String value1, String value2) {
            addCriterion("is_help not between", value1, value2, "isHelp");
            return (Criteria) this;
        }

        public Criteria andCurrentPresentIsNull() {
            addCriterion("current_present is null");
            return (Criteria) this;
        }

        public Criteria andCurrentPresentIsNotNull() {
            addCriterion("current_present is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentPresentEqualTo(String value) {
            addCriterion("current_present =", value, "currentPresent");
            return (Criteria) this;
        }

        public Criteria andCurrentPresentNotEqualTo(String value) {
            addCriterion("current_present <>", value, "currentPresent");
            return (Criteria) this;
        }

        public Criteria andCurrentPresentGreaterThan(String value) {
            addCriterion("current_present >", value, "currentPresent");
            return (Criteria) this;
        }

        public Criteria andCurrentPresentGreaterThanOrEqualTo(String value) {
            addCriterion("current_present >=", value, "currentPresent");
            return (Criteria) this;
        }

        public Criteria andCurrentPresentLessThan(String value) {
            addCriterion("current_present <", value, "currentPresent");
            return (Criteria) this;
        }

        public Criteria andCurrentPresentLessThanOrEqualTo(String value) {
            addCriterion("current_present <=", value, "currentPresent");
            return (Criteria) this;
        }

        public Criteria andCurrentPresentLike(String value) {
            addCriterion("current_present like", value, "currentPresent");
            return (Criteria) this;
        }

        public Criteria andCurrentPresentNotLike(String value) {
            addCriterion("current_present not like", value, "currentPresent");
            return (Criteria) this;
        }

        public Criteria andCurrentPresentIn(List<String> values) {
            addCriterion("current_present in", values, "currentPresent");
            return (Criteria) this;
        }

        public Criteria andCurrentPresentNotIn(List<String> values) {
            addCriterion("current_present not in", values, "currentPresent");
            return (Criteria) this;
        }

        public Criteria andCurrentPresentBetween(String value1, String value2) {
            addCriterion("current_present between", value1, value2, "currentPresent");
            return (Criteria) this;
        }

        public Criteria andCurrentPresentNotBetween(String value1, String value2) {
            addCriterion("current_present not between", value1, value2, "currentPresent");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckyNoBIsNull() {
            addCriterion("chongqin_lucky_no_b is null");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckyNoBIsNotNull() {
            addCriterion("chongqin_lucky_no_b is not null");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckyNoBEqualTo(String value) {
            addCriterion("chongqin_lucky_no_b =", value, "chongqinLuckyNoB");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckyNoBNotEqualTo(String value) {
            addCriterion("chongqin_lucky_no_b <>", value, "chongqinLuckyNoB");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckyNoBGreaterThan(String value) {
            addCriterion("chongqin_lucky_no_b >", value, "chongqinLuckyNoB");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckyNoBGreaterThanOrEqualTo(String value) {
            addCriterion("chongqin_lucky_no_b >=", value, "chongqinLuckyNoB");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckyNoBLessThan(String value) {
            addCriterion("chongqin_lucky_no_b <", value, "chongqinLuckyNoB");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckyNoBLessThanOrEqualTo(String value) {
            addCriterion("chongqin_lucky_no_b <=", value, "chongqinLuckyNoB");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckyNoBLike(String value) {
            addCriterion("chongqin_lucky_no_b like", value, "chongqinLuckyNoB");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckyNoBNotLike(String value) {
            addCriterion("chongqin_lucky_no_b not like", value, "chongqinLuckyNoB");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckyNoBIn(List<String> values) {
            addCriterion("chongqin_lucky_no_b in", values, "chongqinLuckyNoB");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckyNoBNotIn(List<String> values) {
            addCriterion("chongqin_lucky_no_b not in", values, "chongqinLuckyNoB");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckyNoBBetween(String value1, String value2) {
            addCriterion("chongqin_lucky_no_b between", value1, value2, "chongqinLuckyNoB");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckyNoBNotBetween(String value1, String value2) {
            addCriterion("chongqin_lucky_no_b not between", value1, value2, "chongqinLuckyNoB");
            return (Criteria) this;
        }

        public Criteria andCountLuckyNoAIsNull() {
            addCriterion("count_lucky_no_a is null");
            return (Criteria) this;
        }

        public Criteria andCountLuckyNoAIsNotNull() {
            addCriterion("count_lucky_no_a is not null");
            return (Criteria) this;
        }

        public Criteria andCountLuckyNoAEqualTo(String value) {
            addCriterion("count_lucky_no_a =", value, "countLuckyNoA");
            return (Criteria) this;
        }

        public Criteria andCountLuckyNoANotEqualTo(String value) {
            addCriterion("count_lucky_no_a <>", value, "countLuckyNoA");
            return (Criteria) this;
        }

        public Criteria andCountLuckyNoAGreaterThan(String value) {
            addCriterion("count_lucky_no_a >", value, "countLuckyNoA");
            return (Criteria) this;
        }

        public Criteria andCountLuckyNoAGreaterThanOrEqualTo(String value) {
            addCriterion("count_lucky_no_a >=", value, "countLuckyNoA");
            return (Criteria) this;
        }

        public Criteria andCountLuckyNoALessThan(String value) {
            addCriterion("count_lucky_no_a <", value, "countLuckyNoA");
            return (Criteria) this;
        }

        public Criteria andCountLuckyNoALessThanOrEqualTo(String value) {
            addCriterion("count_lucky_no_a <=", value, "countLuckyNoA");
            return (Criteria) this;
        }

        public Criteria andCountLuckyNoALike(String value) {
            addCriterion("count_lucky_no_a like", value, "countLuckyNoA");
            return (Criteria) this;
        }

        public Criteria andCountLuckyNoANotLike(String value) {
            addCriterion("count_lucky_no_a not like", value, "countLuckyNoA");
            return (Criteria) this;
        }

        public Criteria andCountLuckyNoAIn(List<String> values) {
            addCriterion("count_lucky_no_a in", values, "countLuckyNoA");
            return (Criteria) this;
        }

        public Criteria andCountLuckyNoANotIn(List<String> values) {
            addCriterion("count_lucky_no_a not in", values, "countLuckyNoA");
            return (Criteria) this;
        }

        public Criteria andCountLuckyNoABetween(String value1, String value2) {
            addCriterion("count_lucky_no_a between", value1, value2, "countLuckyNoA");
            return (Criteria) this;
        }

        public Criteria andCountLuckyNoANotBetween(String value1, String value2) {
            addCriterion("count_lucky_no_a not between", value1, value2, "countLuckyNoA");
            return (Criteria) this;
        }

        public Criteria andFirstBuyTimeIsNull() {
            addCriterion("first_buy_time is null");
            return (Criteria) this;
        }

        public Criteria andFirstBuyTimeIsNotNull() {
            addCriterion("first_buy_time is not null");
            return (Criteria) this;
        }

        public Criteria andFirstBuyTimeEqualTo(Date value) {
            addCriterion("first_buy_time =", value, "firstBuyTime");
            return (Criteria) this;
        }

        public Criteria andFirstBuyTimeNotEqualTo(Date value) {
            addCriterion("first_buy_time <>", value, "firstBuyTime");
            return (Criteria) this;
        }

        public Criteria andFirstBuyTimeGreaterThan(Date value) {
            addCriterion("first_buy_time >", value, "firstBuyTime");
            return (Criteria) this;
        }

        public Criteria andFirstBuyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("first_buy_time >=", value, "firstBuyTime");
            return (Criteria) this;
        }

        public Criteria andFirstBuyTimeLessThan(Date value) {
            addCriterion("first_buy_time <", value, "firstBuyTime");
            return (Criteria) this;
        }

        public Criteria andFirstBuyTimeLessThanOrEqualTo(Date value) {
            addCriterion("first_buy_time <=", value, "firstBuyTime");
            return (Criteria) this;
        }

        public Criteria andFirstBuyTimeIn(List<Date> values) {
            addCriterion("first_buy_time in", values, "firstBuyTime");
            return (Criteria) this;
        }

        public Criteria andFirstBuyTimeNotIn(List<Date> values) {
            addCriterion("first_buy_time not in", values, "firstBuyTime");
            return (Criteria) this;
        }

        public Criteria andFirstBuyTimeBetween(Date value1, Date value2) {
            addCriterion("first_buy_time between", value1, value2, "firstBuyTime");
            return (Criteria) this;
        }

        public Criteria andFirstBuyTimeNotBetween(Date value1, Date value2) {
            addCriterion("first_buy_time not between", value1, value2, "firstBuyTime");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionIsNull() {
            addCriterion("chongqin_lucky_section is null");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionIsNotNull() {
            addCriterion("chongqin_lucky_section is not null");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionEqualTo(String value) {
            addCriterion("chongqin_lucky_section =", value, "chongqinLuckySection");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionNotEqualTo(String value) {
            addCriterion("chongqin_lucky_section <>", value, "chongqinLuckySection");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionGreaterThan(String value) {
            addCriterion("chongqin_lucky_section >", value, "chongqinLuckySection");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionGreaterThanOrEqualTo(String value) {
            addCriterion("chongqin_lucky_section >=", value, "chongqinLuckySection");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionLessThan(String value) {
            addCriterion("chongqin_lucky_section <", value, "chongqinLuckySection");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionLessThanOrEqualTo(String value) {
            addCriterion("chongqin_lucky_section <=", value, "chongqinLuckySection");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionLike(String value) {
            addCriterion("chongqin_lucky_section like", value, "chongqinLuckySection");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionNotLike(String value) {
            addCriterion("chongqin_lucky_section not like", value, "chongqinLuckySection");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionIn(List<String> values) {
            addCriterion("chongqin_lucky_section in", values, "chongqinLuckySection");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionNotIn(List<String> values) {
            addCriterion("chongqin_lucky_section not in", values, "chongqinLuckySection");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionBetween(String value1, String value2) {
            addCriterion("chongqin_lucky_section between", value1, value2, "chongqinLuckySection");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionNotBetween(String value1, String value2) {
            addCriterion("chongqin_lucky_section not between", value1, value2, "chongqinLuckySection");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionExpectIsNull() {
            addCriterion("chongqin_lucky_section_expect is null");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionExpectIsNotNull() {
            addCriterion("chongqin_lucky_section_expect is not null");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionExpectEqualTo(String value) {
            addCriterion("chongqin_lucky_section_expect =", value, "chongqinLuckySectionExpect");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionExpectNotEqualTo(String value) {
            addCriterion("chongqin_lucky_section_expect <>", value, "chongqinLuckySectionExpect");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionExpectGreaterThan(String value) {
            addCriterion("chongqin_lucky_section_expect >", value, "chongqinLuckySectionExpect");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionExpectGreaterThanOrEqualTo(String value) {
            addCriterion("chongqin_lucky_section_expect >=", value, "chongqinLuckySectionExpect");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionExpectLessThan(String value) {
            addCriterion("chongqin_lucky_section_expect <", value, "chongqinLuckySectionExpect");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionExpectLessThanOrEqualTo(String value) {
            addCriterion("chongqin_lucky_section_expect <=", value, "chongqinLuckySectionExpect");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionExpectLike(String value) {
            addCriterion("chongqin_lucky_section_expect like", value, "chongqinLuckySectionExpect");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionExpectNotLike(String value) {
            addCriterion("chongqin_lucky_section_expect not like", value, "chongqinLuckySectionExpect");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionExpectIn(List<String> values) {
            addCriterion("chongqin_lucky_section_expect in", values, "chongqinLuckySectionExpect");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionExpectNotIn(List<String> values) {
            addCriterion("chongqin_lucky_section_expect not in", values, "chongqinLuckySectionExpect");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionExpectBetween(String value1, String value2) {
            addCriterion("chongqin_lucky_section_expect between", value1, value2, "chongqinLuckySectionExpect");
            return (Criteria) this;
        }

        public Criteria andChongqinLuckySectionExpectNotBetween(String value1, String value2) {
            addCriterion("chongqin_lucky_section_expect not between", value1, value2, "chongqinLuckySectionExpect");
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

        public Criteria andIspushCountIsNull() {
            addCriterion("ispush_count is null");
            return (Criteria) this;
        }

        public Criteria andIspushCountIsNotNull() {
            addCriterion("ispush_count is not null");
            return (Criteria) this;
        }

        public Criteria andIspushCountEqualTo(Integer value) {
            addCriterion("ispush_count =", value, "ispushCount");
            return (Criteria) this;
        }

        public Criteria andIspushCountNotEqualTo(Integer value) {
            addCriterion("ispush_count <>", value, "ispushCount");
            return (Criteria) this;
        }

        public Criteria andIspushCountGreaterThan(Integer value) {
            addCriterion("ispush_count >", value, "ispushCount");
            return (Criteria) this;
        }

        public Criteria andIspushCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ispush_count >=", value, "ispushCount");
            return (Criteria) this;
        }

        public Criteria andIspushCountLessThan(Integer value) {
            addCriterion("ispush_count <", value, "ispushCount");
            return (Criteria) this;
        }

        public Criteria andIspushCountLessThanOrEqualTo(Integer value) {
            addCriterion("ispush_count <=", value, "ispushCount");
            return (Criteria) this;
        }

        public Criteria andIspushCountIn(List<Integer> values) {
            addCriterion("ispush_count in", values, "ispushCount");
            return (Criteria) this;
        }

        public Criteria andIspushCountNotIn(List<Integer> values) {
            addCriterion("ispush_count not in", values, "ispushCount");
            return (Criteria) this;
        }

        public Criteria andIspushCountBetween(Integer value1, Integer value2) {
            addCriterion("ispush_count between", value1, value2, "ispushCount");
            return (Criteria) this;
        }

        public Criteria andIspushCountNotBetween(Integer value1, Integer value2) {
            addCriterion("ispush_count not between", value1, value2, "ispushCount");
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

        public Criteria andOther4IsNull() {
            addCriterion("other4 is null");
            return (Criteria) this;
        }

        public Criteria andOther4IsNotNull() {
            addCriterion("other4 is not null");
            return (Criteria) this;
        }

        public Criteria andOther4EqualTo(String value) {
            addCriterion("other4 =", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotEqualTo(String value) {
            addCriterion("other4 <>", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4GreaterThan(String value) {
            addCriterion("other4 >", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4GreaterThanOrEqualTo(String value) {
            addCriterion("other4 >=", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4LessThan(String value) {
            addCriterion("other4 <", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4LessThanOrEqualTo(String value) {
            addCriterion("other4 <=", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4Like(String value) {
            addCriterion("other4 like", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotLike(String value) {
            addCriterion("other4 not like", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4In(List<String> values) {
            addCriterion("other4 in", values, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotIn(List<String> values) {
            addCriterion("other4 not in", values, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4Between(String value1, String value2) {
            addCriterion("other4 between", value1, value2, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotBetween(String value1, String value2) {
            addCriterion("other4 not between", value1, value2, "other4");
            return (Criteria) this;
        }

        public Criteria andOther5IsNull() {
            addCriterion("other5 is null");
            return (Criteria) this;
        }

        public Criteria andOther5IsNotNull() {
            addCriterion("other5 is not null");
            return (Criteria) this;
        }

        public Criteria andOther5EqualTo(String value) {
            addCriterion("other5 =", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5NotEqualTo(String value) {
            addCriterion("other5 <>", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5GreaterThan(String value) {
            addCriterion("other5 >", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5GreaterThanOrEqualTo(String value) {
            addCriterion("other5 >=", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5LessThan(String value) {
            addCriterion("other5 <", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5LessThanOrEqualTo(String value) {
            addCriterion("other5 <=", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5Like(String value) {
            addCriterion("other5 like", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5NotLike(String value) {
            addCriterion("other5 not like", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5In(List<String> values) {
            addCriterion("other5 in", values, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5NotIn(List<String> values) {
            addCriterion("other5 not in", values, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5Between(String value1, String value2) {
            addCriterion("other5 between", value1, value2, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5NotBetween(String value1, String value2) {
            addCriterion("other5 not between", value1, value2, "other5");
            return (Criteria) this;
        }

        public Criteria andLastLuckNumberIsNull() {
            addCriterion("last_luck_number is null");
            return (Criteria) this;
        }

        public Criteria andLastLuckNumberIsNotNull() {
            addCriterion("last_luck_number is not null");
            return (Criteria) this;
        }

        public Criteria andLastLuckNumberEqualTo(String value) {
            addCriterion("last_luck_number =", value, "lastLuckNumber");
            return (Criteria) this;
        }

        public Criteria andLastLuckNumberNotEqualTo(String value) {
            addCriterion("last_luck_number <>", value, "lastLuckNumber");
            return (Criteria) this;
        }

        public Criteria andLastLuckNumberGreaterThan(String value) {
            addCriterion("last_luck_number >", value, "lastLuckNumber");
            return (Criteria) this;
        }

        public Criteria andLastLuckNumberGreaterThanOrEqualTo(String value) {
            addCriterion("last_luck_number >=", value, "lastLuckNumber");
            return (Criteria) this;
        }

        public Criteria andLastLuckNumberLessThan(String value) {
            addCriterion("last_luck_number <", value, "lastLuckNumber");
            return (Criteria) this;
        }

        public Criteria andLastLuckNumberLessThanOrEqualTo(String value) {
            addCriterion("last_luck_number <=", value, "lastLuckNumber");
            return (Criteria) this;
        }

        public Criteria andLastLuckNumberLike(String value) {
            addCriterion("last_luck_number like", value, "lastLuckNumber");
            return (Criteria) this;
        }

        public Criteria andLastLuckNumberNotLike(String value) {
            addCriterion("last_luck_number not like", value, "lastLuckNumber");
            return (Criteria) this;
        }

        public Criteria andLastLuckNumberIn(List<String> values) {
            addCriterion("last_luck_number in", values, "lastLuckNumber");
            return (Criteria) this;
        }

        public Criteria andLastLuckNumberNotIn(List<String> values) {
            addCriterion("last_luck_number not in", values, "lastLuckNumber");
            return (Criteria) this;
        }

        public Criteria andLastLuckNumberBetween(String value1, String value2) {
            addCriterion("last_luck_number between", value1, value2, "lastLuckNumber");
            return (Criteria) this;
        }

        public Criteria andLastLuckNumberNotBetween(String value1, String value2) {
            addCriterion("last_luck_number not between", value1, value2, "lastLuckNumber");
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