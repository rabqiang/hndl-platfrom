package com.hndl.cn.dao.welfare.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WelfareGameInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public WelfareGameInfoDoExample() {
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

        public Criteria andPlayCountIsNull() {
            addCriterion("play_count is null");
            return (Criteria) this;
        }

        public Criteria andPlayCountIsNotNull() {
            addCriterion("play_count is not null");
            return (Criteria) this;
        }

        public Criteria andPlayCountEqualTo(Long value) {
            addCriterion("play_count =", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountNotEqualTo(Long value) {
            addCriterion("play_count <>", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountGreaterThan(Long value) {
            addCriterion("play_count >", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountGreaterThanOrEqualTo(Long value) {
            addCriterion("play_count >=", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountLessThan(Long value) {
            addCriterion("play_count <", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountLessThanOrEqualTo(Long value) {
            addCriterion("play_count <=", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountIn(List<Long> values) {
            addCriterion("play_count in", values, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountNotIn(List<Long> values) {
            addCriterion("play_count not in", values, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountBetween(Long value1, Long value2) {
            addCriterion("play_count between", value1, value2, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountNotBetween(Long value1, Long value2) {
            addCriterion("play_count not between", value1, value2, "playCount");
            return (Criteria) this;
        }

        public Criteria andRewardToUrlIsNull() {
            addCriterion("reward_to_url is null");
            return (Criteria) this;
        }

        public Criteria andRewardToUrlIsNotNull() {
            addCriterion("reward_to_url is not null");
            return (Criteria) this;
        }

        public Criteria andRewardToUrlEqualTo(String value) {
            addCriterion("reward_to_url =", value, "rewardToUrl");
            return (Criteria) this;
        }

        public Criteria andRewardToUrlNotEqualTo(String value) {
            addCriterion("reward_to_url <>", value, "rewardToUrl");
            return (Criteria) this;
        }

        public Criteria andRewardToUrlGreaterThan(String value) {
            addCriterion("reward_to_url >", value, "rewardToUrl");
            return (Criteria) this;
        }

        public Criteria andRewardToUrlGreaterThanOrEqualTo(String value) {
            addCriterion("reward_to_url >=", value, "rewardToUrl");
            return (Criteria) this;
        }

        public Criteria andRewardToUrlLessThan(String value) {
            addCriterion("reward_to_url <", value, "rewardToUrl");
            return (Criteria) this;
        }

        public Criteria andRewardToUrlLessThanOrEqualTo(String value) {
            addCriterion("reward_to_url <=", value, "rewardToUrl");
            return (Criteria) this;
        }

        public Criteria andRewardToUrlLike(String value) {
            addCriterion("reward_to_url like", value, "rewardToUrl");
            return (Criteria) this;
        }

        public Criteria andRewardToUrlNotLike(String value) {
            addCriterion("reward_to_url not like", value, "rewardToUrl");
            return (Criteria) this;
        }

        public Criteria andRewardToUrlIn(List<String> values) {
            addCriterion("reward_to_url in", values, "rewardToUrl");
            return (Criteria) this;
        }

        public Criteria andRewardToUrlNotIn(List<String> values) {
            addCriterion("reward_to_url not in", values, "rewardToUrl");
            return (Criteria) this;
        }

        public Criteria andRewardToUrlBetween(String value1, String value2) {
            addCriterion("reward_to_url between", value1, value2, "rewardToUrl");
            return (Criteria) this;
        }

        public Criteria andRewardToUrlNotBetween(String value1, String value2) {
            addCriterion("reward_to_url not between", value1, value2, "rewardToUrl");
            return (Criteria) this;
        }

        public Criteria andDescToUrlIsNull() {
            addCriterion("desc_to_url is null");
            return (Criteria) this;
        }

        public Criteria andDescToUrlIsNotNull() {
            addCriterion("desc_to_url is not null");
            return (Criteria) this;
        }

        public Criteria andDescToUrlEqualTo(String value) {
            addCriterion("desc_to_url =", value, "descToUrl");
            return (Criteria) this;
        }

        public Criteria andDescToUrlNotEqualTo(String value) {
            addCriterion("desc_to_url <>", value, "descToUrl");
            return (Criteria) this;
        }

        public Criteria andDescToUrlGreaterThan(String value) {
            addCriterion("desc_to_url >", value, "descToUrl");
            return (Criteria) this;
        }

        public Criteria andDescToUrlGreaterThanOrEqualTo(String value) {
            addCriterion("desc_to_url >=", value, "descToUrl");
            return (Criteria) this;
        }

        public Criteria andDescToUrlLessThan(String value) {
            addCriterion("desc_to_url <", value, "descToUrl");
            return (Criteria) this;
        }

        public Criteria andDescToUrlLessThanOrEqualTo(String value) {
            addCriterion("desc_to_url <=", value, "descToUrl");
            return (Criteria) this;
        }

        public Criteria andDescToUrlLike(String value) {
            addCriterion("desc_to_url like", value, "descToUrl");
            return (Criteria) this;
        }

        public Criteria andDescToUrlNotLike(String value) {
            addCriterion("desc_to_url not like", value, "descToUrl");
            return (Criteria) this;
        }

        public Criteria andDescToUrlIn(List<String> values) {
            addCriterion("desc_to_url in", values, "descToUrl");
            return (Criteria) this;
        }

        public Criteria andDescToUrlNotIn(List<String> values) {
            addCriterion("desc_to_url not in", values, "descToUrl");
            return (Criteria) this;
        }

        public Criteria andDescToUrlBetween(String value1, String value2) {
            addCriterion("desc_to_url between", value1, value2, "descToUrl");
            return (Criteria) this;
        }

        public Criteria andDescToUrlNotBetween(String value1, String value2) {
            addCriterion("desc_to_url not between", value1, value2, "descToUrl");
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

        public Criteria andReviveDoudouCountIsNull() {
            addCriterion("revive_doudou_count is null");
            return (Criteria) this;
        }

        public Criteria andReviveDoudouCountIsNotNull() {
            addCriterion("revive_doudou_count is not null");
            return (Criteria) this;
        }

        public Criteria andReviveDoudouCountEqualTo(Long value) {
            addCriterion("revive_doudou_count =", value, "reviveDoudouCount");
            return (Criteria) this;
        }

        public Criteria andReviveDoudouCountNotEqualTo(Long value) {
            addCriterion("revive_doudou_count <>", value, "reviveDoudouCount");
            return (Criteria) this;
        }

        public Criteria andReviveDoudouCountGreaterThan(Long value) {
            addCriterion("revive_doudou_count >", value, "reviveDoudouCount");
            return (Criteria) this;
        }

        public Criteria andReviveDoudouCountGreaterThanOrEqualTo(Long value) {
            addCriterion("revive_doudou_count >=", value, "reviveDoudouCount");
            return (Criteria) this;
        }

        public Criteria andReviveDoudouCountLessThan(Long value) {
            addCriterion("revive_doudou_count <", value, "reviveDoudouCount");
            return (Criteria) this;
        }

        public Criteria andReviveDoudouCountLessThanOrEqualTo(Long value) {
            addCriterion("revive_doudou_count <=", value, "reviveDoudouCount");
            return (Criteria) this;
        }

        public Criteria andReviveDoudouCountIn(List<Long> values) {
            addCriterion("revive_doudou_count in", values, "reviveDoudouCount");
            return (Criteria) this;
        }

        public Criteria andReviveDoudouCountNotIn(List<Long> values) {
            addCriterion("revive_doudou_count not in", values, "reviveDoudouCount");
            return (Criteria) this;
        }

        public Criteria andReviveDoudouCountBetween(Long value1, Long value2) {
            addCriterion("revive_doudou_count between", value1, value2, "reviveDoudouCount");
            return (Criteria) this;
        }

        public Criteria andReviveDoudouCountNotBetween(Long value1, Long value2) {
            addCriterion("revive_doudou_count not between", value1, value2, "reviveDoudouCount");
            return (Criteria) this;
        }

        public Criteria andRewardHeartIsNull() {
            addCriterion("reward_heart is null");
            return (Criteria) this;
        }

        public Criteria andRewardHeartIsNotNull() {
            addCriterion("reward_heart is not null");
            return (Criteria) this;
        }

        public Criteria andRewardHeartEqualTo(Long value) {
            addCriterion("reward_heart =", value, "rewardHeart");
            return (Criteria) this;
        }

        public Criteria andRewardHeartNotEqualTo(Long value) {
            addCriterion("reward_heart <>", value, "rewardHeart");
            return (Criteria) this;
        }

        public Criteria andRewardHeartGreaterThan(Long value) {
            addCriterion("reward_heart >", value, "rewardHeart");
            return (Criteria) this;
        }

        public Criteria andRewardHeartGreaterThanOrEqualTo(Long value) {
            addCriterion("reward_heart >=", value, "rewardHeart");
            return (Criteria) this;
        }

        public Criteria andRewardHeartLessThan(Long value) {
            addCriterion("reward_heart <", value, "rewardHeart");
            return (Criteria) this;
        }

        public Criteria andRewardHeartLessThanOrEqualTo(Long value) {
            addCriterion("reward_heart <=", value, "rewardHeart");
            return (Criteria) this;
        }

        public Criteria andRewardHeartIn(List<Long> values) {
            addCriterion("reward_heart in", values, "rewardHeart");
            return (Criteria) this;
        }

        public Criteria andRewardHeartNotIn(List<Long> values) {
            addCriterion("reward_heart not in", values, "rewardHeart");
            return (Criteria) this;
        }

        public Criteria andRewardHeartBetween(Long value1, Long value2) {
            addCriterion("reward_heart between", value1, value2, "rewardHeart");
            return (Criteria) this;
        }

        public Criteria andRewardHeartNotBetween(Long value1, Long value2) {
            addCriterion("reward_heart not between", value1, value2, "rewardHeart");
            return (Criteria) this;
        }

        public Criteria andRestrictScoreIsNull() {
            addCriterion("restrict_score is null");
            return (Criteria) this;
        }

        public Criteria andRestrictScoreIsNotNull() {
            addCriterion("restrict_score is not null");
            return (Criteria) this;
        }

        public Criteria andRestrictScoreEqualTo(Long value) {
            addCriterion("restrict_score =", value, "restrictScore");
            return (Criteria) this;
        }

        public Criteria andRestrictScoreNotEqualTo(Long value) {
            addCriterion("restrict_score <>", value, "restrictScore");
            return (Criteria) this;
        }

        public Criteria andRestrictScoreGreaterThan(Long value) {
            addCriterion("restrict_score >", value, "restrictScore");
            return (Criteria) this;
        }

        public Criteria andRestrictScoreGreaterThanOrEqualTo(Long value) {
            addCriterion("restrict_score >=", value, "restrictScore");
            return (Criteria) this;
        }

        public Criteria andRestrictScoreLessThan(Long value) {
            addCriterion("restrict_score <", value, "restrictScore");
            return (Criteria) this;
        }

        public Criteria andRestrictScoreLessThanOrEqualTo(Long value) {
            addCriterion("restrict_score <=", value, "restrictScore");
            return (Criteria) this;
        }

        public Criteria andRestrictScoreIn(List<Long> values) {
            addCriterion("restrict_score in", values, "restrictScore");
            return (Criteria) this;
        }

        public Criteria andRestrictScoreNotIn(List<Long> values) {
            addCriterion("restrict_score not in", values, "restrictScore");
            return (Criteria) this;
        }

        public Criteria andRestrictScoreBetween(Long value1, Long value2) {
            addCriterion("restrict_score between", value1, value2, "restrictScore");
            return (Criteria) this;
        }

        public Criteria andRestrictScoreNotBetween(Long value1, Long value2) {
            addCriterion("restrict_score not between", value1, value2, "restrictScore");
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

        public Criteria andOther3EqualTo(Integer value) {
            addCriterion("other3 =", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotEqualTo(Integer value) {
            addCriterion("other3 <>", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3GreaterThan(Integer value) {
            addCriterion("other3 >", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3GreaterThanOrEqualTo(Integer value) {
            addCriterion("other3 >=", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3LessThan(Integer value) {
            addCriterion("other3 <", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3LessThanOrEqualTo(Integer value) {
            addCriterion("other3 <=", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3In(List<Integer> values) {
            addCriterion("other3 in", values, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotIn(List<Integer> values) {
            addCriterion("other3 not in", values, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3Between(Integer value1, Integer value2) {
            addCriterion("other3 between", value1, value2, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotBetween(Integer value1, Integer value2) {
            addCriterion("other3 not between", value1, value2, "other3");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("`type` like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("`type` not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andThriyGameUrlIsNull() {
            addCriterion("thriy_game_url is null");
            return (Criteria) this;
        }

        public Criteria andThriyGameUrlIsNotNull() {
            addCriterion("thriy_game_url is not null");
            return (Criteria) this;
        }

        public Criteria andThriyGameUrlEqualTo(String value) {
            addCriterion("thriy_game_url =", value, "thriyGameUrl");
            return (Criteria) this;
        }

        public Criteria andThriyGameUrlNotEqualTo(String value) {
            addCriterion("thriy_game_url <>", value, "thriyGameUrl");
            return (Criteria) this;
        }

        public Criteria andThriyGameUrlGreaterThan(String value) {
            addCriterion("thriy_game_url >", value, "thriyGameUrl");
            return (Criteria) this;
        }

        public Criteria andThriyGameUrlGreaterThanOrEqualTo(String value) {
            addCriterion("thriy_game_url >=", value, "thriyGameUrl");
            return (Criteria) this;
        }

        public Criteria andThriyGameUrlLessThan(String value) {
            addCriterion("thriy_game_url <", value, "thriyGameUrl");
            return (Criteria) this;
        }

        public Criteria andThriyGameUrlLessThanOrEqualTo(String value) {
            addCriterion("thriy_game_url <=", value, "thriyGameUrl");
            return (Criteria) this;
        }

        public Criteria andThriyGameUrlLike(String value) {
            addCriterion("thriy_game_url like", value, "thriyGameUrl");
            return (Criteria) this;
        }

        public Criteria andThriyGameUrlNotLike(String value) {
            addCriterion("thriy_game_url not like", value, "thriyGameUrl");
            return (Criteria) this;
        }

        public Criteria andThriyGameUrlIn(List<String> values) {
            addCriterion("thriy_game_url in", values, "thriyGameUrl");
            return (Criteria) this;
        }

        public Criteria andThriyGameUrlNotIn(List<String> values) {
            addCriterion("thriy_game_url not in", values, "thriyGameUrl");
            return (Criteria) this;
        }

        public Criteria andThriyGameUrlBetween(String value1, String value2) {
            addCriterion("thriy_game_url between", value1, value2, "thriyGameUrl");
            return (Criteria) this;
        }

        public Criteria andThriyGameUrlNotBetween(String value1, String value2) {
            addCriterion("thriy_game_url not between", value1, value2, "thriyGameUrl");
            return (Criteria) this;
        }

        public Criteria andChannelExtIsNull() {
            addCriterion("channel_ext is null");
            return (Criteria) this;
        }

        public Criteria andChannelExtIsNotNull() {
            addCriterion("channel_ext is not null");
            return (Criteria) this;
        }

        public Criteria andChannelExtEqualTo(String value) {
            addCriterion("channel_ext =", value, "channelExt");
            return (Criteria) this;
        }

        public Criteria andChannelExtNotEqualTo(String value) {
            addCriterion("channel_ext <>", value, "channelExt");
            return (Criteria) this;
        }

        public Criteria andChannelExtGreaterThan(String value) {
            addCriterion("channel_ext >", value, "channelExt");
            return (Criteria) this;
        }

        public Criteria andChannelExtGreaterThanOrEqualTo(String value) {
            addCriterion("channel_ext >=", value, "channelExt");
            return (Criteria) this;
        }

        public Criteria andChannelExtLessThan(String value) {
            addCriterion("channel_ext <", value, "channelExt");
            return (Criteria) this;
        }

        public Criteria andChannelExtLessThanOrEqualTo(String value) {
            addCriterion("channel_ext <=", value, "channelExt");
            return (Criteria) this;
        }

        public Criteria andChannelExtLike(String value) {
            addCriterion("channel_ext like", value, "channelExt");
            return (Criteria) this;
        }

        public Criteria andChannelExtNotLike(String value) {
            addCriterion("channel_ext not like", value, "channelExt");
            return (Criteria) this;
        }

        public Criteria andChannelExtIn(List<String> values) {
            addCriterion("channel_ext in", values, "channelExt");
            return (Criteria) this;
        }

        public Criteria andChannelExtNotIn(List<String> values) {
            addCriterion("channel_ext not in", values, "channelExt");
            return (Criteria) this;
        }

        public Criteria andChannelExtBetween(String value1, String value2) {
            addCriterion("channel_ext between", value1, value2, "channelExt");
            return (Criteria) this;
        }

        public Criteria andChannelExtNotBetween(String value1, String value2) {
            addCriterion("channel_ext not between", value1, value2, "channelExt");
            return (Criteria) this;
        }

        public Criteria andPayCallbackUrlIsNull() {
            addCriterion("pay_callback_url is null");
            return (Criteria) this;
        }

        public Criteria andPayCallbackUrlIsNotNull() {
            addCriterion("pay_callback_url is not null");
            return (Criteria) this;
        }

        public Criteria andPayCallbackUrlEqualTo(String value) {
            addCriterion("pay_callback_url =", value, "payCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andPayCallbackUrlNotEqualTo(String value) {
            addCriterion("pay_callback_url <>", value, "payCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andPayCallbackUrlGreaterThan(String value) {
            addCriterion("pay_callback_url >", value, "payCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andPayCallbackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pay_callback_url >=", value, "payCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andPayCallbackUrlLessThan(String value) {
            addCriterion("pay_callback_url <", value, "payCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andPayCallbackUrlLessThanOrEqualTo(String value) {
            addCriterion("pay_callback_url <=", value, "payCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andPayCallbackUrlLike(String value) {
            addCriterion("pay_callback_url like", value, "payCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andPayCallbackUrlNotLike(String value) {
            addCriterion("pay_callback_url not like", value, "payCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andPayCallbackUrlIn(List<String> values) {
            addCriterion("pay_callback_url in", values, "payCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andPayCallbackUrlNotIn(List<String> values) {
            addCriterion("pay_callback_url not in", values, "payCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andPayCallbackUrlBetween(String value1, String value2) {
            addCriterion("pay_callback_url between", value1, value2, "payCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andPayCallbackUrlNotBetween(String value1, String value2) {
            addCriterion("pay_callback_url not between", value1, value2, "payCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andGameKeyIsNull() {
            addCriterion("game_key is null");
            return (Criteria) this;
        }

        public Criteria andGameKeyIsNotNull() {
            addCriterion("game_key is not null");
            return (Criteria) this;
        }

        public Criteria andGameKeyEqualTo(String value) {
            addCriterion("game_key =", value, "gameKey");
            return (Criteria) this;
        }

        public Criteria andGameKeyNotEqualTo(String value) {
            addCriterion("game_key <>", value, "gameKey");
            return (Criteria) this;
        }

        public Criteria andGameKeyGreaterThan(String value) {
            addCriterion("game_key >", value, "gameKey");
            return (Criteria) this;
        }

        public Criteria andGameKeyGreaterThanOrEqualTo(String value) {
            addCriterion("game_key >=", value, "gameKey");
            return (Criteria) this;
        }

        public Criteria andGameKeyLessThan(String value) {
            addCriterion("game_key <", value, "gameKey");
            return (Criteria) this;
        }

        public Criteria andGameKeyLessThanOrEqualTo(String value) {
            addCriterion("game_key <=", value, "gameKey");
            return (Criteria) this;
        }

        public Criteria andGameKeyLike(String value) {
            addCriterion("game_key like", value, "gameKey");
            return (Criteria) this;
        }

        public Criteria andGameKeyNotLike(String value) {
            addCriterion("game_key not like", value, "gameKey");
            return (Criteria) this;
        }

        public Criteria andGameKeyIn(List<String> values) {
            addCriterion("game_key in", values, "gameKey");
            return (Criteria) this;
        }

        public Criteria andGameKeyNotIn(List<String> values) {
            addCriterion("game_key not in", values, "gameKey");
            return (Criteria) this;
        }

        public Criteria andGameKeyBetween(String value1, String value2) {
            addCriterion("game_key between", value1, value2, "gameKey");
            return (Criteria) this;
        }

        public Criteria andGameKeyNotBetween(String value1, String value2) {
            addCriterion("game_key not between", value1, value2, "gameKey");
            return (Criteria) this;
        }

        public Criteria andIsShowChallengeIsNull() {
            addCriterion("is_show_challenge is null");
            return (Criteria) this;
        }

        public Criteria andIsShowChallengeIsNotNull() {
            addCriterion("is_show_challenge is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowChallengeEqualTo(String value) {
            addCriterion("is_show_challenge =", value, "isShowChallenge");
            return (Criteria) this;
        }

        public Criteria andIsShowChallengeNotEqualTo(String value) {
            addCriterion("is_show_challenge <>", value, "isShowChallenge");
            return (Criteria) this;
        }

        public Criteria andIsShowChallengeGreaterThan(String value) {
            addCriterion("is_show_challenge >", value, "isShowChallenge");
            return (Criteria) this;
        }

        public Criteria andIsShowChallengeGreaterThanOrEqualTo(String value) {
            addCriterion("is_show_challenge >=", value, "isShowChallenge");
            return (Criteria) this;
        }

        public Criteria andIsShowChallengeLessThan(String value) {
            addCriterion("is_show_challenge <", value, "isShowChallenge");
            return (Criteria) this;
        }

        public Criteria andIsShowChallengeLessThanOrEqualTo(String value) {
            addCriterion("is_show_challenge <=", value, "isShowChallenge");
            return (Criteria) this;
        }

        public Criteria andIsShowChallengeLike(String value) {
            addCriterion("is_show_challenge like", value, "isShowChallenge");
            return (Criteria) this;
        }

        public Criteria andIsShowChallengeNotLike(String value) {
            addCriterion("is_show_challenge not like", value, "isShowChallenge");
            return (Criteria) this;
        }

        public Criteria andIsShowChallengeIn(List<String> values) {
            addCriterion("is_show_challenge in", values, "isShowChallenge");
            return (Criteria) this;
        }

        public Criteria andIsShowChallengeNotIn(List<String> values) {
            addCriterion("is_show_challenge not in", values, "isShowChallenge");
            return (Criteria) this;
        }

        public Criteria andIsShowChallengeBetween(String value1, String value2) {
            addCriterion("is_show_challenge between", value1, value2, "isShowChallenge");
            return (Criteria) this;
        }

        public Criteria andIsShowChallengeNotBetween(String value1, String value2) {
            addCriterion("is_show_challenge not between", value1, value2, "isShowChallenge");
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