package com.hndl.cn.dao.welfare.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WelfareOrgInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public WelfareOrgInfoDoExample() {
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

        public Criteria andDonateHeartIsNull() {
            addCriterion("donate_heart is null");
            return (Criteria) this;
        }

        public Criteria andDonateHeartIsNotNull() {
            addCriterion("donate_heart is not null");
            return (Criteria) this;
        }

        public Criteria andDonateHeartEqualTo(Long value) {
            addCriterion("donate_heart =", value, "donateHeart");
            return (Criteria) this;
        }

        public Criteria andDonateHeartNotEqualTo(Long value) {
            addCriterion("donate_heart <>", value, "donateHeart");
            return (Criteria) this;
        }

        public Criteria andDonateHeartGreaterThan(Long value) {
            addCriterion("donate_heart >", value, "donateHeart");
            return (Criteria) this;
        }

        public Criteria andDonateHeartGreaterThanOrEqualTo(Long value) {
            addCriterion("donate_heart >=", value, "donateHeart");
            return (Criteria) this;
        }

        public Criteria andDonateHeartLessThan(Long value) {
            addCriterion("donate_heart <", value, "donateHeart");
            return (Criteria) this;
        }

        public Criteria andDonateHeartLessThanOrEqualTo(Long value) {
            addCriterion("donate_heart <=", value, "donateHeart");
            return (Criteria) this;
        }

        public Criteria andDonateHeartIn(List<Long> values) {
            addCriterion("donate_heart in", values, "donateHeart");
            return (Criteria) this;
        }

        public Criteria andDonateHeartNotIn(List<Long> values) {
            addCriterion("donate_heart not in", values, "donateHeart");
            return (Criteria) this;
        }

        public Criteria andDonateHeartBetween(Long value1, Long value2) {
            addCriterion("donate_heart between", value1, value2, "donateHeart");
            return (Criteria) this;
        }

        public Criteria andDonateHeartNotBetween(Long value1, Long value2) {
            addCriterion("donate_heart not between", value1, value2, "donateHeart");
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

        public Criteria andTypeApplyIsNull() {
            addCriterion("type_apply is null");
            return (Criteria) this;
        }

        public Criteria andTypeApplyIsNotNull() {
            addCriterion("type_apply is not null");
            return (Criteria) this;
        }

        public Criteria andTypeApplyEqualTo(String value) {
            addCriterion("type_apply =", value, "typeApply");
            return (Criteria) this;
        }

        public Criteria andTypeApplyNotEqualTo(String value) {
            addCriterion("type_apply <>", value, "typeApply");
            return (Criteria) this;
        }

        public Criteria andTypeApplyGreaterThan(String value) {
            addCriterion("type_apply >", value, "typeApply");
            return (Criteria) this;
        }

        public Criteria andTypeApplyGreaterThanOrEqualTo(String value) {
            addCriterion("type_apply >=", value, "typeApply");
            return (Criteria) this;
        }

        public Criteria andTypeApplyLessThan(String value) {
            addCriterion("type_apply <", value, "typeApply");
            return (Criteria) this;
        }

        public Criteria andTypeApplyLessThanOrEqualTo(String value) {
            addCriterion("type_apply <=", value, "typeApply");
            return (Criteria) this;
        }

        public Criteria andTypeApplyLike(String value) {
            addCriterion("type_apply like", value, "typeApply");
            return (Criteria) this;
        }

        public Criteria andTypeApplyNotLike(String value) {
            addCriterion("type_apply not like", value, "typeApply");
            return (Criteria) this;
        }

        public Criteria andTypeApplyIn(List<String> values) {
            addCriterion("type_apply in", values, "typeApply");
            return (Criteria) this;
        }

        public Criteria andTypeApplyNotIn(List<String> values) {
            addCriterion("type_apply not in", values, "typeApply");
            return (Criteria) this;
        }

        public Criteria andTypeApplyBetween(String value1, String value2) {
            addCriterion("type_apply between", value1, value2, "typeApply");
            return (Criteria) this;
        }

        public Criteria andTypeApplyNotBetween(String value1, String value2) {
            addCriterion("type_apply not between", value1, value2, "typeApply");
            return (Criteria) this;
        }

        public Criteria andStarIdApplyIsNull() {
            addCriterion("star_id_apply is null");
            return (Criteria) this;
        }

        public Criteria andStarIdApplyIsNotNull() {
            addCriterion("star_id_apply is not null");
            return (Criteria) this;
        }

        public Criteria andStarIdApplyEqualTo(Long value) {
            addCriterion("star_id_apply =", value, "starIdApply");
            return (Criteria) this;
        }

        public Criteria andStarIdApplyNotEqualTo(Long value) {
            addCriterion("star_id_apply <>", value, "starIdApply");
            return (Criteria) this;
        }

        public Criteria andStarIdApplyGreaterThan(Long value) {
            addCriterion("star_id_apply >", value, "starIdApply");
            return (Criteria) this;
        }

        public Criteria andStarIdApplyGreaterThanOrEqualTo(Long value) {
            addCriterion("star_id_apply >=", value, "starIdApply");
            return (Criteria) this;
        }

        public Criteria andStarIdApplyLessThan(Long value) {
            addCriterion("star_id_apply <", value, "starIdApply");
            return (Criteria) this;
        }

        public Criteria andStarIdApplyLessThanOrEqualTo(Long value) {
            addCriterion("star_id_apply <=", value, "starIdApply");
            return (Criteria) this;
        }

        public Criteria andStarIdApplyIn(List<Long> values) {
            addCriterion("star_id_apply in", values, "starIdApply");
            return (Criteria) this;
        }

        public Criteria andStarIdApplyNotIn(List<Long> values) {
            addCriterion("star_id_apply not in", values, "starIdApply");
            return (Criteria) this;
        }

        public Criteria andStarIdApplyBetween(Long value1, Long value2) {
            addCriterion("star_id_apply between", value1, value2, "starIdApply");
            return (Criteria) this;
        }

        public Criteria andStarIdApplyNotBetween(Long value1, Long value2) {
            addCriterion("star_id_apply not between", value1, value2, "starIdApply");
            return (Criteria) this;
        }

        public Criteria andNameApplyIsNull() {
            addCriterion("name_apply is null");
            return (Criteria) this;
        }

        public Criteria andNameApplyIsNotNull() {
            addCriterion("name_apply is not null");
            return (Criteria) this;
        }

        public Criteria andNameApplyEqualTo(String value) {
            addCriterion("name_apply =", value, "nameApply");
            return (Criteria) this;
        }

        public Criteria andNameApplyNotEqualTo(String value) {
            addCriterion("name_apply <>", value, "nameApply");
            return (Criteria) this;
        }

        public Criteria andNameApplyGreaterThan(String value) {
            addCriterion("name_apply >", value, "nameApply");
            return (Criteria) this;
        }

        public Criteria andNameApplyGreaterThanOrEqualTo(String value) {
            addCriterion("name_apply >=", value, "nameApply");
            return (Criteria) this;
        }

        public Criteria andNameApplyLessThan(String value) {
            addCriterion("name_apply <", value, "nameApply");
            return (Criteria) this;
        }

        public Criteria andNameApplyLessThanOrEqualTo(String value) {
            addCriterion("name_apply <=", value, "nameApply");
            return (Criteria) this;
        }

        public Criteria andNameApplyLike(String value) {
            addCriterion("name_apply like", value, "nameApply");
            return (Criteria) this;
        }

        public Criteria andNameApplyNotLike(String value) {
            addCriterion("name_apply not like", value, "nameApply");
            return (Criteria) this;
        }

        public Criteria andNameApplyIn(List<String> values) {
            addCriterion("name_apply in", values, "nameApply");
            return (Criteria) this;
        }

        public Criteria andNameApplyNotIn(List<String> values) {
            addCriterion("name_apply not in", values, "nameApply");
            return (Criteria) this;
        }

        public Criteria andNameApplyBetween(String value1, String value2) {
            addCriterion("name_apply between", value1, value2, "nameApply");
            return (Criteria) this;
        }

        public Criteria andNameApplyNotBetween(String value1, String value2) {
            addCriterion("name_apply not between", value1, value2, "nameApply");
            return (Criteria) this;
        }

        public Criteria andBrandDescApplyIsNull() {
            addCriterion("brand_desc_apply is null");
            return (Criteria) this;
        }

        public Criteria andBrandDescApplyIsNotNull() {
            addCriterion("brand_desc_apply is not null");
            return (Criteria) this;
        }

        public Criteria andBrandDescApplyEqualTo(String value) {
            addCriterion("brand_desc_apply =", value, "brandDescApply");
            return (Criteria) this;
        }

        public Criteria andBrandDescApplyNotEqualTo(String value) {
            addCriterion("brand_desc_apply <>", value, "brandDescApply");
            return (Criteria) this;
        }

        public Criteria andBrandDescApplyGreaterThan(String value) {
            addCriterion("brand_desc_apply >", value, "brandDescApply");
            return (Criteria) this;
        }

        public Criteria andBrandDescApplyGreaterThanOrEqualTo(String value) {
            addCriterion("brand_desc_apply >=", value, "brandDescApply");
            return (Criteria) this;
        }

        public Criteria andBrandDescApplyLessThan(String value) {
            addCriterion("brand_desc_apply <", value, "brandDescApply");
            return (Criteria) this;
        }

        public Criteria andBrandDescApplyLessThanOrEqualTo(String value) {
            addCriterion("brand_desc_apply <=", value, "brandDescApply");
            return (Criteria) this;
        }

        public Criteria andBrandDescApplyLike(String value) {
            addCriterion("brand_desc_apply like", value, "brandDescApply");
            return (Criteria) this;
        }

        public Criteria andBrandDescApplyNotLike(String value) {
            addCriterion("brand_desc_apply not like", value, "brandDescApply");
            return (Criteria) this;
        }

        public Criteria andBrandDescApplyIn(List<String> values) {
            addCriterion("brand_desc_apply in", values, "brandDescApply");
            return (Criteria) this;
        }

        public Criteria andBrandDescApplyNotIn(List<String> values) {
            addCriterion("brand_desc_apply not in", values, "brandDescApply");
            return (Criteria) this;
        }

        public Criteria andBrandDescApplyBetween(String value1, String value2) {
            addCriterion("brand_desc_apply between", value1, value2, "brandDescApply");
            return (Criteria) this;
        }

        public Criteria andBrandDescApplyNotBetween(String value1, String value2) {
            addCriterion("brand_desc_apply not between", value1, value2, "brandDescApply");
            return (Criteria) this;
        }

        public Criteria andPhoneApplyIsNull() {
            addCriterion("phone_apply is null");
            return (Criteria) this;
        }

        public Criteria andPhoneApplyIsNotNull() {
            addCriterion("phone_apply is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneApplyEqualTo(String value) {
            addCriterion("phone_apply =", value, "phoneApply");
            return (Criteria) this;
        }

        public Criteria andPhoneApplyNotEqualTo(String value) {
            addCriterion("phone_apply <>", value, "phoneApply");
            return (Criteria) this;
        }

        public Criteria andPhoneApplyGreaterThan(String value) {
            addCriterion("phone_apply >", value, "phoneApply");
            return (Criteria) this;
        }

        public Criteria andPhoneApplyGreaterThanOrEqualTo(String value) {
            addCriterion("phone_apply >=", value, "phoneApply");
            return (Criteria) this;
        }

        public Criteria andPhoneApplyLessThan(String value) {
            addCriterion("phone_apply <", value, "phoneApply");
            return (Criteria) this;
        }

        public Criteria andPhoneApplyLessThanOrEqualTo(String value) {
            addCriterion("phone_apply <=", value, "phoneApply");
            return (Criteria) this;
        }

        public Criteria andPhoneApplyLike(String value) {
            addCriterion("phone_apply like", value, "phoneApply");
            return (Criteria) this;
        }

        public Criteria andPhoneApplyNotLike(String value) {
            addCriterion("phone_apply not like", value, "phoneApply");
            return (Criteria) this;
        }

        public Criteria andPhoneApplyIn(List<String> values) {
            addCriterion("phone_apply in", values, "phoneApply");
            return (Criteria) this;
        }

        public Criteria andPhoneApplyNotIn(List<String> values) {
            addCriterion("phone_apply not in", values, "phoneApply");
            return (Criteria) this;
        }

        public Criteria andPhoneApplyBetween(String value1, String value2) {
            addCriterion("phone_apply between", value1, value2, "phoneApply");
            return (Criteria) this;
        }

        public Criteria andPhoneApplyNotBetween(String value1, String value2) {
            addCriterion("phone_apply not between", value1, value2, "phoneApply");
            return (Criteria) this;
        }

        public Criteria andJoinDescApplyIsNull() {
            addCriterion("join_desc_apply is null");
            return (Criteria) this;
        }

        public Criteria andJoinDescApplyIsNotNull() {
            addCriterion("join_desc_apply is not null");
            return (Criteria) this;
        }

        public Criteria andJoinDescApplyEqualTo(String value) {
            addCriterion("join_desc_apply =", value, "joinDescApply");
            return (Criteria) this;
        }

        public Criteria andJoinDescApplyNotEqualTo(String value) {
            addCriterion("join_desc_apply <>", value, "joinDescApply");
            return (Criteria) this;
        }

        public Criteria andJoinDescApplyGreaterThan(String value) {
            addCriterion("join_desc_apply >", value, "joinDescApply");
            return (Criteria) this;
        }

        public Criteria andJoinDescApplyGreaterThanOrEqualTo(String value) {
            addCriterion("join_desc_apply >=", value, "joinDescApply");
            return (Criteria) this;
        }

        public Criteria andJoinDescApplyLessThan(String value) {
            addCriterion("join_desc_apply <", value, "joinDescApply");
            return (Criteria) this;
        }

        public Criteria andJoinDescApplyLessThanOrEqualTo(String value) {
            addCriterion("join_desc_apply <=", value, "joinDescApply");
            return (Criteria) this;
        }

        public Criteria andJoinDescApplyLike(String value) {
            addCriterion("join_desc_apply like", value, "joinDescApply");
            return (Criteria) this;
        }

        public Criteria andJoinDescApplyNotLike(String value) {
            addCriterion("join_desc_apply not like", value, "joinDescApply");
            return (Criteria) this;
        }

        public Criteria andJoinDescApplyIn(List<String> values) {
            addCriterion("join_desc_apply in", values, "joinDescApply");
            return (Criteria) this;
        }

        public Criteria andJoinDescApplyNotIn(List<String> values) {
            addCriterion("join_desc_apply not in", values, "joinDescApply");
            return (Criteria) this;
        }

        public Criteria andJoinDescApplyBetween(String value1, String value2) {
            addCriterion("join_desc_apply between", value1, value2, "joinDescApply");
            return (Criteria) this;
        }

        public Criteria andJoinDescApplyNotBetween(String value1, String value2) {
            addCriterion("join_desc_apply not between", value1, value2, "joinDescApply");
            return (Criteria) this;
        }

        public Criteria andMoneyApplyIsNull() {
            addCriterion("money_apply is null");
            return (Criteria) this;
        }

        public Criteria andMoneyApplyIsNotNull() {
            addCriterion("money_apply is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyApplyEqualTo(Double value) {
            addCriterion("money_apply =", value, "moneyApply");
            return (Criteria) this;
        }

        public Criteria andMoneyApplyNotEqualTo(Double value) {
            addCriterion("money_apply <>", value, "moneyApply");
            return (Criteria) this;
        }

        public Criteria andMoneyApplyGreaterThan(Double value) {
            addCriterion("money_apply >", value, "moneyApply");
            return (Criteria) this;
        }

        public Criteria andMoneyApplyGreaterThanOrEqualTo(Double value) {
            addCriterion("money_apply >=", value, "moneyApply");
            return (Criteria) this;
        }

        public Criteria andMoneyApplyLessThan(Double value) {
            addCriterion("money_apply <", value, "moneyApply");
            return (Criteria) this;
        }

        public Criteria andMoneyApplyLessThanOrEqualTo(Double value) {
            addCriterion("money_apply <=", value, "moneyApply");
            return (Criteria) this;
        }

        public Criteria andMoneyApplyIn(List<Double> values) {
            addCriterion("money_apply in", values, "moneyApply");
            return (Criteria) this;
        }

        public Criteria andMoneyApplyNotIn(List<Double> values) {
            addCriterion("money_apply not in", values, "moneyApply");
            return (Criteria) this;
        }

        public Criteria andMoneyApplyBetween(Double value1, Double value2) {
            addCriterion("money_apply between", value1, value2, "moneyApply");
            return (Criteria) this;
        }

        public Criteria andMoneyApplyNotBetween(Double value1, Double value2) {
            addCriterion("money_apply not between", value1, value2, "moneyApply");
            return (Criteria) this;
        }

        public Criteria andOrgUserIsNull() {
            addCriterion("org_user is null");
            return (Criteria) this;
        }

        public Criteria andOrgUserIsNotNull() {
            addCriterion("org_user is not null");
            return (Criteria) this;
        }

        public Criteria andOrgUserEqualTo(String value) {
            addCriterion("org_user =", value, "orgUser");
            return (Criteria) this;
        }

        public Criteria andOrgUserNotEqualTo(String value) {
            addCriterion("org_user <>", value, "orgUser");
            return (Criteria) this;
        }

        public Criteria andOrgUserGreaterThan(String value) {
            addCriterion("org_user >", value, "orgUser");
            return (Criteria) this;
        }

        public Criteria andOrgUserGreaterThanOrEqualTo(String value) {
            addCriterion("org_user >=", value, "orgUser");
            return (Criteria) this;
        }

        public Criteria andOrgUserLessThan(String value) {
            addCriterion("org_user <", value, "orgUser");
            return (Criteria) this;
        }

        public Criteria andOrgUserLessThanOrEqualTo(String value) {
            addCriterion("org_user <=", value, "orgUser");
            return (Criteria) this;
        }

        public Criteria andOrgUserLike(String value) {
            addCriterion("org_user like", value, "orgUser");
            return (Criteria) this;
        }

        public Criteria andOrgUserNotLike(String value) {
            addCriterion("org_user not like", value, "orgUser");
            return (Criteria) this;
        }

        public Criteria andOrgUserIn(List<String> values) {
            addCriterion("org_user in", values, "orgUser");
            return (Criteria) this;
        }

        public Criteria andOrgUserNotIn(List<String> values) {
            addCriterion("org_user not in", values, "orgUser");
            return (Criteria) this;
        }

        public Criteria andOrgUserBetween(String value1, String value2) {
            addCriterion("org_user between", value1, value2, "orgUser");
            return (Criteria) this;
        }

        public Criteria andOrgUserNotBetween(String value1, String value2) {
            addCriterion("org_user not between", value1, value2, "orgUser");
            return (Criteria) this;
        }

        public Criteria andOrgLogoUrlIsNull() {
            addCriterion("org_logo_url is null");
            return (Criteria) this;
        }

        public Criteria andOrgLogoUrlIsNotNull() {
            addCriterion("org_logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andOrgLogoUrlEqualTo(String value) {
            addCriterion("org_logo_url =", value, "orgLogoUrl");
            return (Criteria) this;
        }

        public Criteria andOrgLogoUrlNotEqualTo(String value) {
            addCriterion("org_logo_url <>", value, "orgLogoUrl");
            return (Criteria) this;
        }

        public Criteria andOrgLogoUrlGreaterThan(String value) {
            addCriterion("org_logo_url >", value, "orgLogoUrl");
            return (Criteria) this;
        }

        public Criteria andOrgLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("org_logo_url >=", value, "orgLogoUrl");
            return (Criteria) this;
        }

        public Criteria andOrgLogoUrlLessThan(String value) {
            addCriterion("org_logo_url <", value, "orgLogoUrl");
            return (Criteria) this;
        }

        public Criteria andOrgLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("org_logo_url <=", value, "orgLogoUrl");
            return (Criteria) this;
        }

        public Criteria andOrgLogoUrlLike(String value) {
            addCriterion("org_logo_url like", value, "orgLogoUrl");
            return (Criteria) this;
        }

        public Criteria andOrgLogoUrlNotLike(String value) {
            addCriterion("org_logo_url not like", value, "orgLogoUrl");
            return (Criteria) this;
        }

        public Criteria andOrgLogoUrlIn(List<String> values) {
            addCriterion("org_logo_url in", values, "orgLogoUrl");
            return (Criteria) this;
        }

        public Criteria andOrgLogoUrlNotIn(List<String> values) {
            addCriterion("org_logo_url not in", values, "orgLogoUrl");
            return (Criteria) this;
        }

        public Criteria andOrgLogoUrlBetween(String value1, String value2) {
            addCriterion("org_logo_url between", value1, value2, "orgLogoUrl");
            return (Criteria) this;
        }

        public Criteria andOrgLogoUrlNotBetween(String value1, String value2) {
            addCriterion("org_logo_url not between", value1, value2, "orgLogoUrl");
            return (Criteria) this;
        }

        public Criteria andDonateMoneyIsNull() {
            addCriterion("donate_money is null");
            return (Criteria) this;
        }

        public Criteria andDonateMoneyIsNotNull() {
            addCriterion("donate_money is not null");
            return (Criteria) this;
        }

        public Criteria andDonateMoneyEqualTo(Double value) {
            addCriterion("donate_money =", value, "donateMoney");
            return (Criteria) this;
        }

        public Criteria andDonateMoneyNotEqualTo(Double value) {
            addCriterion("donate_money <>", value, "donateMoney");
            return (Criteria) this;
        }

        public Criteria andDonateMoneyGreaterThan(Double value) {
            addCriterion("donate_money >", value, "donateMoney");
            return (Criteria) this;
        }

        public Criteria andDonateMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("donate_money >=", value, "donateMoney");
            return (Criteria) this;
        }

        public Criteria andDonateMoneyLessThan(Double value) {
            addCriterion("donate_money <", value, "donateMoney");
            return (Criteria) this;
        }

        public Criteria andDonateMoneyLessThanOrEqualTo(Double value) {
            addCriterion("donate_money <=", value, "donateMoney");
            return (Criteria) this;
        }

        public Criteria andDonateMoneyIn(List<Double> values) {
            addCriterion("donate_money in", values, "donateMoney");
            return (Criteria) this;
        }

        public Criteria andDonateMoneyNotIn(List<Double> values) {
            addCriterion("donate_money not in", values, "donateMoney");
            return (Criteria) this;
        }

        public Criteria andDonateMoneyBetween(Double value1, Double value2) {
            addCriterion("donate_money between", value1, value2, "donateMoney");
            return (Criteria) this;
        }

        public Criteria andDonateMoneyNotBetween(Double value1, Double value2) {
            addCriterion("donate_money not between", value1, value2, "donateMoney");
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