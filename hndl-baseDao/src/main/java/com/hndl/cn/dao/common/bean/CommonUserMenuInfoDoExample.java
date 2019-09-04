package com.hndl.cn.dao.common.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonUserMenuInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public CommonUserMenuInfoDoExample() {
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

        public Criteria andToTypeIsNull() {
            addCriterion("to_type is null");
            return (Criteria) this;
        }

        public Criteria andToTypeIsNotNull() {
            addCriterion("to_type is not null");
            return (Criteria) this;
        }

        public Criteria andToTypeEqualTo(String value) {
            addCriterion("to_type =", value, "toType");
            return (Criteria) this;
        }

        public Criteria andToTypeNotEqualTo(String value) {
            addCriterion("to_type <>", value, "toType");
            return (Criteria) this;
        }

        public Criteria andToTypeGreaterThan(String value) {
            addCriterion("to_type >", value, "toType");
            return (Criteria) this;
        }

        public Criteria andToTypeGreaterThanOrEqualTo(String value) {
            addCriterion("to_type >=", value, "toType");
            return (Criteria) this;
        }

        public Criteria andToTypeLessThan(String value) {
            addCriterion("to_type <", value, "toType");
            return (Criteria) this;
        }

        public Criteria andToTypeLessThanOrEqualTo(String value) {
            addCriterion("to_type <=", value, "toType");
            return (Criteria) this;
        }

        public Criteria andToTypeLike(String value) {
            addCriterion("to_type like", value, "toType");
            return (Criteria) this;
        }

        public Criteria andToTypeNotLike(String value) {
            addCriterion("to_type not like", value, "toType");
            return (Criteria) this;
        }

        public Criteria andToTypeIn(List<String> values) {
            addCriterion("to_type in", values, "toType");
            return (Criteria) this;
        }

        public Criteria andToTypeNotIn(List<String> values) {
            addCriterion("to_type not in", values, "toType");
            return (Criteria) this;
        }

        public Criteria andToTypeBetween(String value1, String value2) {
            addCriterion("to_type between", value1, value2, "toType");
            return (Criteria) this;
        }

        public Criteria andToTypeNotBetween(String value1, String value2) {
            addCriterion("to_type not between", value1, value2, "toType");
            return (Criteria) this;
        }

        public Criteria andToUrlIsNull() {
            addCriterion("to_url is null");
            return (Criteria) this;
        }

        public Criteria andToUrlIsNotNull() {
            addCriterion("to_url is not null");
            return (Criteria) this;
        }

        public Criteria andToUrlEqualTo(String value) {
            addCriterion("to_url =", value, "toUrl");
            return (Criteria) this;
        }

        public Criteria andToUrlNotEqualTo(String value) {
            addCriterion("to_url <>", value, "toUrl");
            return (Criteria) this;
        }

        public Criteria andToUrlGreaterThan(String value) {
            addCriterion("to_url >", value, "toUrl");
            return (Criteria) this;
        }

        public Criteria andToUrlGreaterThanOrEqualTo(String value) {
            addCriterion("to_url >=", value, "toUrl");
            return (Criteria) this;
        }

        public Criteria andToUrlLessThan(String value) {
            addCriterion("to_url <", value, "toUrl");
            return (Criteria) this;
        }

        public Criteria andToUrlLessThanOrEqualTo(String value) {
            addCriterion("to_url <=", value, "toUrl");
            return (Criteria) this;
        }

        public Criteria andToUrlLike(String value) {
            addCriterion("to_url like", value, "toUrl");
            return (Criteria) this;
        }

        public Criteria andToUrlNotLike(String value) {
            addCriterion("to_url not like", value, "toUrl");
            return (Criteria) this;
        }

        public Criteria andToUrlIn(List<String> values) {
            addCriterion("to_url in", values, "toUrl");
            return (Criteria) this;
        }

        public Criteria andToUrlNotIn(List<String> values) {
            addCriterion("to_url not in", values, "toUrl");
            return (Criteria) this;
        }

        public Criteria andToUrlBetween(String value1, String value2) {
            addCriterion("to_url between", value1, value2, "toUrl");
            return (Criteria) this;
        }

        public Criteria andToUrlNotBetween(String value1, String value2) {
            addCriterion("to_url not between", value1, value2, "toUrl");
            return (Criteria) this;
        }

        public Criteria andIsIosHideIsNull() {
            addCriterion("is_ios_hide is null");
            return (Criteria) this;
        }

        public Criteria andIsIosHideIsNotNull() {
            addCriterion("is_ios_hide is not null");
            return (Criteria) this;
        }

        public Criteria andIsIosHideEqualTo(String value) {
            addCriterion("is_ios_hide =", value, "isIosHide");
            return (Criteria) this;
        }

        public Criteria andIsIosHideNotEqualTo(String value) {
            addCriterion("is_ios_hide <>", value, "isIosHide");
            return (Criteria) this;
        }

        public Criteria andIsIosHideGreaterThan(String value) {
            addCriterion("is_ios_hide >", value, "isIosHide");
            return (Criteria) this;
        }

        public Criteria andIsIosHideGreaterThanOrEqualTo(String value) {
            addCriterion("is_ios_hide >=", value, "isIosHide");
            return (Criteria) this;
        }

        public Criteria andIsIosHideLessThan(String value) {
            addCriterion("is_ios_hide <", value, "isIosHide");
            return (Criteria) this;
        }

        public Criteria andIsIosHideLessThanOrEqualTo(String value) {
            addCriterion("is_ios_hide <=", value, "isIosHide");
            return (Criteria) this;
        }

        public Criteria andIsIosHideLike(String value) {
            addCriterion("is_ios_hide like", value, "isIosHide");
            return (Criteria) this;
        }

        public Criteria andIsIosHideNotLike(String value) {
            addCriterion("is_ios_hide not like", value, "isIosHide");
            return (Criteria) this;
        }

        public Criteria andIsIosHideIn(List<String> values) {
            addCriterion("is_ios_hide in", values, "isIosHide");
            return (Criteria) this;
        }

        public Criteria andIsIosHideNotIn(List<String> values) {
            addCriterion("is_ios_hide not in", values, "isIosHide");
            return (Criteria) this;
        }

        public Criteria andIsIosHideBetween(String value1, String value2) {
            addCriterion("is_ios_hide between", value1, value2, "isIosHide");
            return (Criteria) this;
        }

        public Criteria andIsIosHideNotBetween(String value1, String value2) {
            addCriterion("is_ios_hide not between", value1, value2, "isIosHide");
            return (Criteria) this;
        }

        public Criteria andIsAndroidHideIsNull() {
            addCriterion("is_android_hide is null");
            return (Criteria) this;
        }

        public Criteria andIsAndroidHideIsNotNull() {
            addCriterion("is_android_hide is not null");
            return (Criteria) this;
        }

        public Criteria andIsAndroidHideEqualTo(String value) {
            addCriterion("is_android_hide =", value, "isAndroidHide");
            return (Criteria) this;
        }

        public Criteria andIsAndroidHideNotEqualTo(String value) {
            addCriterion("is_android_hide <>", value, "isAndroidHide");
            return (Criteria) this;
        }

        public Criteria andIsAndroidHideGreaterThan(String value) {
            addCriterion("is_android_hide >", value, "isAndroidHide");
            return (Criteria) this;
        }

        public Criteria andIsAndroidHideGreaterThanOrEqualTo(String value) {
            addCriterion("is_android_hide >=", value, "isAndroidHide");
            return (Criteria) this;
        }

        public Criteria andIsAndroidHideLessThan(String value) {
            addCriterion("is_android_hide <", value, "isAndroidHide");
            return (Criteria) this;
        }

        public Criteria andIsAndroidHideLessThanOrEqualTo(String value) {
            addCriterion("is_android_hide <=", value, "isAndroidHide");
            return (Criteria) this;
        }

        public Criteria andIsAndroidHideLike(String value) {
            addCriterion("is_android_hide like", value, "isAndroidHide");
            return (Criteria) this;
        }

        public Criteria andIsAndroidHideNotLike(String value) {
            addCriterion("is_android_hide not like", value, "isAndroidHide");
            return (Criteria) this;
        }

        public Criteria andIsAndroidHideIn(List<String> values) {
            addCriterion("is_android_hide in", values, "isAndroidHide");
            return (Criteria) this;
        }

        public Criteria andIsAndroidHideNotIn(List<String> values) {
            addCriterion("is_android_hide not in", values, "isAndroidHide");
            return (Criteria) this;
        }

        public Criteria andIsAndroidHideBetween(String value1, String value2) {
            addCriterion("is_android_hide between", value1, value2, "isAndroidHide");
            return (Criteria) this;
        }

        public Criteria andIsAndroidHideNotBetween(String value1, String value2) {
            addCriterion("is_android_hide not between", value1, value2, "isAndroidHide");
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

        public Criteria andIsIosVersionHideIsNull() {
            addCriterion("is_ios_version_hide is null");
            return (Criteria) this;
        }

        public Criteria andIsIosVersionHideIsNotNull() {
            addCriterion("is_ios_version_hide is not null");
            return (Criteria) this;
        }

        public Criteria andIsIosVersionHideEqualTo(String value) {
            addCriterion("is_ios_version_hide =", value, "isIosVersionHide");
            return (Criteria) this;
        }

        public Criteria andIsIosVersionHideNotEqualTo(String value) {
            addCriterion("is_ios_version_hide <>", value, "isIosVersionHide");
            return (Criteria) this;
        }

        public Criteria andIsIosVersionHideGreaterThan(String value) {
            addCriterion("is_ios_version_hide >", value, "isIosVersionHide");
            return (Criteria) this;
        }

        public Criteria andIsIosVersionHideGreaterThanOrEqualTo(String value) {
            addCriterion("is_ios_version_hide >=", value, "isIosVersionHide");
            return (Criteria) this;
        }

        public Criteria andIsIosVersionHideLessThan(String value) {
            addCriterion("is_ios_version_hide <", value, "isIosVersionHide");
            return (Criteria) this;
        }

        public Criteria andIsIosVersionHideLessThanOrEqualTo(String value) {
            addCriterion("is_ios_version_hide <=", value, "isIosVersionHide");
            return (Criteria) this;
        }

        public Criteria andIsIosVersionHideLike(String value) {
            addCriterion("is_ios_version_hide like", value, "isIosVersionHide");
            return (Criteria) this;
        }

        public Criteria andIsIosVersionHideNotLike(String value) {
            addCriterion("is_ios_version_hide not like", value, "isIosVersionHide");
            return (Criteria) this;
        }

        public Criteria andIsIosVersionHideIn(List<String> values) {
            addCriterion("is_ios_version_hide in", values, "isIosVersionHide");
            return (Criteria) this;
        }

        public Criteria andIsIosVersionHideNotIn(List<String> values) {
            addCriterion("is_ios_version_hide not in", values, "isIosVersionHide");
            return (Criteria) this;
        }

        public Criteria andIsIosVersionHideBetween(String value1, String value2) {
            addCriterion("is_ios_version_hide between", value1, value2, "isIosVersionHide");
            return (Criteria) this;
        }

        public Criteria andIsIosVersionHideNotBetween(String value1, String value2) {
            addCriterion("is_ios_version_hide not between", value1, value2, "isIosVersionHide");
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