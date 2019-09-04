package com.hndl.cn.dao.shop.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopItemTempletDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ShopItemTempletDoExample() {
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

        public Criteria andTitleInnerIsNull() {
            addCriterion("title_inner is null");
            return (Criteria) this;
        }

        public Criteria andTitleInnerIsNotNull() {
            addCriterion("title_inner is not null");
            return (Criteria) this;
        }

        public Criteria andTitleInnerEqualTo(String value) {
            addCriterion("title_inner =", value, "titleInner");
            return (Criteria) this;
        }

        public Criteria andTitleInnerNotEqualTo(String value) {
            addCriterion("title_inner <>", value, "titleInner");
            return (Criteria) this;
        }

        public Criteria andTitleInnerGreaterThan(String value) {
            addCriterion("title_inner >", value, "titleInner");
            return (Criteria) this;
        }

        public Criteria andTitleInnerGreaterThanOrEqualTo(String value) {
            addCriterion("title_inner >=", value, "titleInner");
            return (Criteria) this;
        }

        public Criteria andTitleInnerLessThan(String value) {
            addCriterion("title_inner <", value, "titleInner");
            return (Criteria) this;
        }

        public Criteria andTitleInnerLessThanOrEqualTo(String value) {
            addCriterion("title_inner <=", value, "titleInner");
            return (Criteria) this;
        }

        public Criteria andTitleInnerLike(String value) {
            addCriterion("title_inner like", value, "titleInner");
            return (Criteria) this;
        }

        public Criteria andTitleInnerNotLike(String value) {
            addCriterion("title_inner not like", value, "titleInner");
            return (Criteria) this;
        }

        public Criteria andTitleInnerIn(List<String> values) {
            addCriterion("title_inner in", values, "titleInner");
            return (Criteria) this;
        }

        public Criteria andTitleInnerNotIn(List<String> values) {
            addCriterion("title_inner not in", values, "titleInner");
            return (Criteria) this;
        }

        public Criteria andTitleInnerBetween(String value1, String value2) {
            addCriterion("title_inner between", value1, value2, "titleInner");
            return (Criteria) this;
        }

        public Criteria andTitleInnerNotBetween(String value1, String value2) {
            addCriterion("title_inner not between", value1, value2, "titleInner");
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

        public Criteria andDirectBuyPriceIsNull() {
            addCriterion("direct_buy_price is null");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceIsNotNull() {
            addCriterion("direct_buy_price is not null");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceEqualTo(Integer value) {
            addCriterion("direct_buy_price =", value, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceNotEqualTo(Integer value) {
            addCriterion("direct_buy_price <>", value, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceGreaterThan(Integer value) {
            addCriterion("direct_buy_price >", value, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("direct_buy_price >=", value, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceLessThan(Integer value) {
            addCriterion("direct_buy_price <", value, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceLessThanOrEqualTo(Integer value) {
            addCriterion("direct_buy_price <=", value, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceIn(List<Integer> values) {
            addCriterion("direct_buy_price in", values, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceNotIn(List<Integer> values) {
            addCriterion("direct_buy_price not in", values, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceBetween(Integer value1, Integer value2) {
            addCriterion("direct_buy_price between", value1, value2, "directBuyPrice");
            return (Criteria) this;
        }

        public Criteria andDirectBuyPriceNotBetween(Integer value1, Integer value2) {
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

        public Criteria andMaxSectionIsNull() {
            addCriterion("max_section is null");
            return (Criteria) this;
        }

        public Criteria andMaxSectionIsNotNull() {
            addCriterion("max_section is not null");
            return (Criteria) this;
        }

        public Criteria andMaxSectionEqualTo(Integer value) {
            addCriterion("max_section =", value, "maxSection");
            return (Criteria) this;
        }

        public Criteria andMaxSectionNotEqualTo(Integer value) {
            addCriterion("max_section <>", value, "maxSection");
            return (Criteria) this;
        }

        public Criteria andMaxSectionGreaterThan(Integer value) {
            addCriterion("max_section >", value, "maxSection");
            return (Criteria) this;
        }

        public Criteria andMaxSectionGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_section >=", value, "maxSection");
            return (Criteria) this;
        }

        public Criteria andMaxSectionLessThan(Integer value) {
            addCriterion("max_section <", value, "maxSection");
            return (Criteria) this;
        }

        public Criteria andMaxSectionLessThanOrEqualTo(Integer value) {
            addCriterion("max_section <=", value, "maxSection");
            return (Criteria) this;
        }

        public Criteria andMaxSectionIn(List<Integer> values) {
            addCriterion("max_section in", values, "maxSection");
            return (Criteria) this;
        }

        public Criteria andMaxSectionNotIn(List<Integer> values) {
            addCriterion("max_section not in", values, "maxSection");
            return (Criteria) this;
        }

        public Criteria andMaxSectionBetween(Integer value1, Integer value2) {
            addCriterion("max_section between", value1, value2, "maxSection");
            return (Criteria) this;
        }

        public Criteria andMaxSectionNotBetween(Integer value1, Integer value2) {
            addCriterion("max_section not between", value1, value2, "maxSection");
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

        public Criteria andShowOrderPrizeTypeIsNull() {
            addCriterion("show_order_prize_type is null");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeTypeIsNotNull() {
            addCriterion("show_order_prize_type is not null");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeTypeEqualTo(String value) {
            addCriterion("show_order_prize_type =", value, "showOrderPrizeType");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeTypeNotEqualTo(String value) {
            addCriterion("show_order_prize_type <>", value, "showOrderPrizeType");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeTypeGreaterThan(String value) {
            addCriterion("show_order_prize_type >", value, "showOrderPrizeType");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("show_order_prize_type >=", value, "showOrderPrizeType");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeTypeLessThan(String value) {
            addCriterion("show_order_prize_type <", value, "showOrderPrizeType");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeTypeLessThanOrEqualTo(String value) {
            addCriterion("show_order_prize_type <=", value, "showOrderPrizeType");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeTypeLike(String value) {
            addCriterion("show_order_prize_type like", value, "showOrderPrizeType");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeTypeNotLike(String value) {
            addCriterion("show_order_prize_type not like", value, "showOrderPrizeType");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeTypeIn(List<String> values) {
            addCriterion("show_order_prize_type in", values, "showOrderPrizeType");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeTypeNotIn(List<String> values) {
            addCriterion("show_order_prize_type not in", values, "showOrderPrizeType");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeTypeBetween(String value1, String value2) {
            addCriterion("show_order_prize_type between", value1, value2, "showOrderPrizeType");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeTypeNotBetween(String value1, String value2) {
            addCriterion("show_order_prize_type not between", value1, value2, "showOrderPrizeType");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeCountIsNull() {
            addCriterion("show_order_prize_count is null");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeCountIsNotNull() {
            addCriterion("show_order_prize_count is not null");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeCountEqualTo(Integer value) {
            addCriterion("show_order_prize_count =", value, "showOrderPrizeCount");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeCountNotEqualTo(Integer value) {
            addCriterion("show_order_prize_count <>", value, "showOrderPrizeCount");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeCountGreaterThan(Integer value) {
            addCriterion("show_order_prize_count >", value, "showOrderPrizeCount");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_order_prize_count >=", value, "showOrderPrizeCount");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeCountLessThan(Integer value) {
            addCriterion("show_order_prize_count <", value, "showOrderPrizeCount");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeCountLessThanOrEqualTo(Integer value) {
            addCriterion("show_order_prize_count <=", value, "showOrderPrizeCount");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeCountIn(List<Integer> values) {
            addCriterion("show_order_prize_count in", values, "showOrderPrizeCount");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeCountNotIn(List<Integer> values) {
            addCriterion("show_order_prize_count not in", values, "showOrderPrizeCount");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeCountBetween(Integer value1, Integer value2) {
            addCriterion("show_order_prize_count between", value1, value2, "showOrderPrizeCount");
            return (Criteria) this;
        }

        public Criteria andShowOrderPrizeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("show_order_prize_count not between", value1, value2, "showOrderPrizeCount");
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