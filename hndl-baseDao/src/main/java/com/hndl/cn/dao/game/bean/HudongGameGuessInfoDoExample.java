package com.hndl.cn.dao.game.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HudongGameGuessInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public HudongGameGuessInfoDoExample() {
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

        public Criteria andAImgUrlIsNull() {
            addCriterion("a_img_url is null");
            return (Criteria) this;
        }

        public Criteria andAImgUrlIsNotNull() {
            addCriterion("a_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andAImgUrlEqualTo(String value) {
            addCriterion("a_img_url =", value, "aImgUrl");
            return (Criteria) this;
        }

        public Criteria andAImgUrlNotEqualTo(String value) {
            addCriterion("a_img_url <>", value, "aImgUrl");
            return (Criteria) this;
        }

        public Criteria andAImgUrlGreaterThan(String value) {
            addCriterion("a_img_url >", value, "aImgUrl");
            return (Criteria) this;
        }

        public Criteria andAImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("a_img_url >=", value, "aImgUrl");
            return (Criteria) this;
        }

        public Criteria andAImgUrlLessThan(String value) {
            addCriterion("a_img_url <", value, "aImgUrl");
            return (Criteria) this;
        }

        public Criteria andAImgUrlLessThanOrEqualTo(String value) {
            addCriterion("a_img_url <=", value, "aImgUrl");
            return (Criteria) this;
        }

        public Criteria andAImgUrlLike(String value) {
            addCriterion("a_img_url like", value, "aImgUrl");
            return (Criteria) this;
        }

        public Criteria andAImgUrlNotLike(String value) {
            addCriterion("a_img_url not like", value, "aImgUrl");
            return (Criteria) this;
        }

        public Criteria andAImgUrlIn(List<String> values) {
            addCriterion("a_img_url in", values, "aImgUrl");
            return (Criteria) this;
        }

        public Criteria andAImgUrlNotIn(List<String> values) {
            addCriterion("a_img_url not in", values, "aImgUrl");
            return (Criteria) this;
        }

        public Criteria andAImgUrlBetween(String value1, String value2) {
            addCriterion("a_img_url between", value1, value2, "aImgUrl");
            return (Criteria) this;
        }

        public Criteria andAImgUrlNotBetween(String value1, String value2) {
            addCriterion("a_img_url not between", value1, value2, "aImgUrl");
            return (Criteria) this;
        }

        public Criteria andANameIsNull() {
            addCriterion("a_name is null");
            return (Criteria) this;
        }

        public Criteria andANameIsNotNull() {
            addCriterion("a_name is not null");
            return (Criteria) this;
        }

        public Criteria andANameEqualTo(String value) {
            addCriterion("a_name =", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotEqualTo(String value) {
            addCriterion("a_name <>", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameGreaterThan(String value) {
            addCriterion("a_name >", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameGreaterThanOrEqualTo(String value) {
            addCriterion("a_name >=", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameLessThan(String value) {
            addCriterion("a_name <", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameLessThanOrEqualTo(String value) {
            addCriterion("a_name <=", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameLike(String value) {
            addCriterion("a_name like", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotLike(String value) {
            addCriterion("a_name not like", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameIn(List<String> values) {
            addCriterion("a_name in", values, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotIn(List<String> values) {
            addCriterion("a_name not in", values, "aName");
            return (Criteria) this;
        }

        public Criteria andANameBetween(String value1, String value2) {
            addCriterion("a_name between", value1, value2, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotBetween(String value1, String value2) {
            addCriterion("a_name not between", value1, value2, "aName");
            return (Criteria) this;
        }

        public Criteria andAVoteCountIsNull() {
            addCriterion("a_vote_count is null");
            return (Criteria) this;
        }

        public Criteria andAVoteCountIsNotNull() {
            addCriterion("a_vote_count is not null");
            return (Criteria) this;
        }

        public Criteria andAVoteCountEqualTo(String value) {
            addCriterion("a_vote_count =", value, "aVoteCount");
            return (Criteria) this;
        }

        public Criteria andAVoteCountNotEqualTo(String value) {
            addCriterion("a_vote_count <>", value, "aVoteCount");
            return (Criteria) this;
        }

        public Criteria andAVoteCountGreaterThan(String value) {
            addCriterion("a_vote_count >", value, "aVoteCount");
            return (Criteria) this;
        }

        public Criteria andAVoteCountGreaterThanOrEqualTo(String value) {
            addCriterion("a_vote_count >=", value, "aVoteCount");
            return (Criteria) this;
        }

        public Criteria andAVoteCountLessThan(String value) {
            addCriterion("a_vote_count <", value, "aVoteCount");
            return (Criteria) this;
        }

        public Criteria andAVoteCountLessThanOrEqualTo(String value) {
            addCriterion("a_vote_count <=", value, "aVoteCount");
            return (Criteria) this;
        }

        public Criteria andAVoteCountLike(String value) {
            addCriterion("a_vote_count like", value, "aVoteCount");
            return (Criteria) this;
        }

        public Criteria andAVoteCountNotLike(String value) {
            addCriterion("a_vote_count not like", value, "aVoteCount");
            return (Criteria) this;
        }

        public Criteria andAVoteCountIn(List<String> values) {
            addCriterion("a_vote_count in", values, "aVoteCount");
            return (Criteria) this;
        }

        public Criteria andAVoteCountNotIn(List<String> values) {
            addCriterion("a_vote_count not in", values, "aVoteCount");
            return (Criteria) this;
        }

        public Criteria andAVoteCountBetween(String value1, String value2) {
            addCriterion("a_vote_count between", value1, value2, "aVoteCount");
            return (Criteria) this;
        }

        public Criteria andAVoteCountNotBetween(String value1, String value2) {
            addCriterion("a_vote_count not between", value1, value2, "aVoteCount");
            return (Criteria) this;
        }

        public Criteria andBImgUrlIsNull() {
            addCriterion("b_img_url is null");
            return (Criteria) this;
        }

        public Criteria andBImgUrlIsNotNull() {
            addCriterion("b_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andBImgUrlEqualTo(String value) {
            addCriterion("b_img_url =", value, "bImgUrl");
            return (Criteria) this;
        }

        public Criteria andBImgUrlNotEqualTo(String value) {
            addCriterion("b_img_url <>", value, "bImgUrl");
            return (Criteria) this;
        }

        public Criteria andBImgUrlGreaterThan(String value) {
            addCriterion("b_img_url >", value, "bImgUrl");
            return (Criteria) this;
        }

        public Criteria andBImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("b_img_url >=", value, "bImgUrl");
            return (Criteria) this;
        }

        public Criteria andBImgUrlLessThan(String value) {
            addCriterion("b_img_url <", value, "bImgUrl");
            return (Criteria) this;
        }

        public Criteria andBImgUrlLessThanOrEqualTo(String value) {
            addCriterion("b_img_url <=", value, "bImgUrl");
            return (Criteria) this;
        }

        public Criteria andBImgUrlLike(String value) {
            addCriterion("b_img_url like", value, "bImgUrl");
            return (Criteria) this;
        }

        public Criteria andBImgUrlNotLike(String value) {
            addCriterion("b_img_url not like", value, "bImgUrl");
            return (Criteria) this;
        }

        public Criteria andBImgUrlIn(List<String> values) {
            addCriterion("b_img_url in", values, "bImgUrl");
            return (Criteria) this;
        }

        public Criteria andBImgUrlNotIn(List<String> values) {
            addCriterion("b_img_url not in", values, "bImgUrl");
            return (Criteria) this;
        }

        public Criteria andBImgUrlBetween(String value1, String value2) {
            addCriterion("b_img_url between", value1, value2, "bImgUrl");
            return (Criteria) this;
        }

        public Criteria andBImgUrlNotBetween(String value1, String value2) {
            addCriterion("b_img_url not between", value1, value2, "bImgUrl");
            return (Criteria) this;
        }

        public Criteria andBNameIsNull() {
            addCriterion("b_name is null");
            return (Criteria) this;
        }

        public Criteria andBNameIsNotNull() {
            addCriterion("b_name is not null");
            return (Criteria) this;
        }

        public Criteria andBNameEqualTo(String value) {
            addCriterion("b_name =", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotEqualTo(String value) {
            addCriterion("b_name <>", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameGreaterThan(String value) {
            addCriterion("b_name >", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameGreaterThanOrEqualTo(String value) {
            addCriterion("b_name >=", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLessThan(String value) {
            addCriterion("b_name <", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLessThanOrEqualTo(String value) {
            addCriterion("b_name <=", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLike(String value) {
            addCriterion("b_name like", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotLike(String value) {
            addCriterion("b_name not like", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameIn(List<String> values) {
            addCriterion("b_name in", values, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotIn(List<String> values) {
            addCriterion("b_name not in", values, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameBetween(String value1, String value2) {
            addCriterion("b_name between", value1, value2, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotBetween(String value1, String value2) {
            addCriterion("b_name not between", value1, value2, "bName");
            return (Criteria) this;
        }

        public Criteria andBVoteCountIsNull() {
            addCriterion("b_vote_count is null");
            return (Criteria) this;
        }

        public Criteria andBVoteCountIsNotNull() {
            addCriterion("b_vote_count is not null");
            return (Criteria) this;
        }

        public Criteria andBVoteCountEqualTo(String value) {
            addCriterion("b_vote_count =", value, "bVoteCount");
            return (Criteria) this;
        }

        public Criteria andBVoteCountNotEqualTo(String value) {
            addCriterion("b_vote_count <>", value, "bVoteCount");
            return (Criteria) this;
        }

        public Criteria andBVoteCountGreaterThan(String value) {
            addCriterion("b_vote_count >", value, "bVoteCount");
            return (Criteria) this;
        }

        public Criteria andBVoteCountGreaterThanOrEqualTo(String value) {
            addCriterion("b_vote_count >=", value, "bVoteCount");
            return (Criteria) this;
        }

        public Criteria andBVoteCountLessThan(String value) {
            addCriterion("b_vote_count <", value, "bVoteCount");
            return (Criteria) this;
        }

        public Criteria andBVoteCountLessThanOrEqualTo(String value) {
            addCriterion("b_vote_count <=", value, "bVoteCount");
            return (Criteria) this;
        }

        public Criteria andBVoteCountLike(String value) {
            addCriterion("b_vote_count like", value, "bVoteCount");
            return (Criteria) this;
        }

        public Criteria andBVoteCountNotLike(String value) {
            addCriterion("b_vote_count not like", value, "bVoteCount");
            return (Criteria) this;
        }

        public Criteria andBVoteCountIn(List<String> values) {
            addCriterion("b_vote_count in", values, "bVoteCount");
            return (Criteria) this;
        }

        public Criteria andBVoteCountNotIn(List<String> values) {
            addCriterion("b_vote_count not in", values, "bVoteCount");
            return (Criteria) this;
        }

        public Criteria andBVoteCountBetween(String value1, String value2) {
            addCriterion("b_vote_count between", value1, value2, "bVoteCount");
            return (Criteria) this;
        }

        public Criteria andBVoteCountNotBetween(String value1, String value2) {
            addCriterion("b_vote_count not between", value1, value2, "bVoteCount");
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

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andDirectAddressIsNull() {
            addCriterion("direct_address is null");
            return (Criteria) this;
        }

        public Criteria andDirectAddressIsNotNull() {
            addCriterion("direct_address is not null");
            return (Criteria) this;
        }

        public Criteria andDirectAddressEqualTo(String value) {
            addCriterion("direct_address =", value, "directAddress");
            return (Criteria) this;
        }

        public Criteria andDirectAddressNotEqualTo(String value) {
            addCriterion("direct_address <>", value, "directAddress");
            return (Criteria) this;
        }

        public Criteria andDirectAddressGreaterThan(String value) {
            addCriterion("direct_address >", value, "directAddress");
            return (Criteria) this;
        }

        public Criteria andDirectAddressGreaterThanOrEqualTo(String value) {
            addCriterion("direct_address >=", value, "directAddress");
            return (Criteria) this;
        }

        public Criteria andDirectAddressLessThan(String value) {
            addCriterion("direct_address <", value, "directAddress");
            return (Criteria) this;
        }

        public Criteria andDirectAddressLessThanOrEqualTo(String value) {
            addCriterion("direct_address <=", value, "directAddress");
            return (Criteria) this;
        }

        public Criteria andDirectAddressLike(String value) {
            addCriterion("direct_address like", value, "directAddress");
            return (Criteria) this;
        }

        public Criteria andDirectAddressNotLike(String value) {
            addCriterion("direct_address not like", value, "directAddress");
            return (Criteria) this;
        }

        public Criteria andDirectAddressIn(List<String> values) {
            addCriterion("direct_address in", values, "directAddress");
            return (Criteria) this;
        }

        public Criteria andDirectAddressNotIn(List<String> values) {
            addCriterion("direct_address not in", values, "directAddress");
            return (Criteria) this;
        }

        public Criteria andDirectAddressBetween(String value1, String value2) {
            addCriterion("direct_address between", value1, value2, "directAddress");
            return (Criteria) this;
        }

        public Criteria andDirectAddressNotBetween(String value1, String value2) {
            addCriterion("direct_address not between", value1, value2, "directAddress");
            return (Criteria) this;
        }

        public Criteria andDirectTypeIsNull() {
            addCriterion("direct_type is null");
            return (Criteria) this;
        }

        public Criteria andDirectTypeIsNotNull() {
            addCriterion("direct_type is not null");
            return (Criteria) this;
        }

        public Criteria andDirectTypeEqualTo(String value) {
            addCriterion("direct_type =", value, "directType");
            return (Criteria) this;
        }

        public Criteria andDirectTypeNotEqualTo(String value) {
            addCriterion("direct_type <>", value, "directType");
            return (Criteria) this;
        }

        public Criteria andDirectTypeGreaterThan(String value) {
            addCriterion("direct_type >", value, "directType");
            return (Criteria) this;
        }

        public Criteria andDirectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("direct_type >=", value, "directType");
            return (Criteria) this;
        }

        public Criteria andDirectTypeLessThan(String value) {
            addCriterion("direct_type <", value, "directType");
            return (Criteria) this;
        }

        public Criteria andDirectTypeLessThanOrEqualTo(String value) {
            addCriterion("direct_type <=", value, "directType");
            return (Criteria) this;
        }

        public Criteria andDirectTypeLike(String value) {
            addCriterion("direct_type like", value, "directType");
            return (Criteria) this;
        }

        public Criteria andDirectTypeNotLike(String value) {
            addCriterion("direct_type not like", value, "directType");
            return (Criteria) this;
        }

        public Criteria andDirectTypeIn(List<String> values) {
            addCriterion("direct_type in", values, "directType");
            return (Criteria) this;
        }

        public Criteria andDirectTypeNotIn(List<String> values) {
            addCriterion("direct_type not in", values, "directType");
            return (Criteria) this;
        }

        public Criteria andDirectTypeBetween(String value1, String value2) {
            addCriterion("direct_type between", value1, value2, "directType");
            return (Criteria) this;
        }

        public Criteria andDirectTypeNotBetween(String value1, String value2) {
            addCriterion("direct_type not between", value1, value2, "directType");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(Integer value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(Integer value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(Integer value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(Integer value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(Integer value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<Integer> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<Integer> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(Integer value1, Integer value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(Integer value1, Integer value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andDirectTitleIsNull() {
            addCriterion("direct_title is null");
            return (Criteria) this;
        }

        public Criteria andDirectTitleIsNotNull() {
            addCriterion("direct_title is not null");
            return (Criteria) this;
        }

        public Criteria andDirectTitleEqualTo(String value) {
            addCriterion("direct_title =", value, "directTitle");
            return (Criteria) this;
        }

        public Criteria andDirectTitleNotEqualTo(String value) {
            addCriterion("direct_title <>", value, "directTitle");
            return (Criteria) this;
        }

        public Criteria andDirectTitleGreaterThan(String value) {
            addCriterion("direct_title >", value, "directTitle");
            return (Criteria) this;
        }

        public Criteria andDirectTitleGreaterThanOrEqualTo(String value) {
            addCriterion("direct_title >=", value, "directTitle");
            return (Criteria) this;
        }

        public Criteria andDirectTitleLessThan(String value) {
            addCriterion("direct_title <", value, "directTitle");
            return (Criteria) this;
        }

        public Criteria andDirectTitleLessThanOrEqualTo(String value) {
            addCriterion("direct_title <=", value, "directTitle");
            return (Criteria) this;
        }

        public Criteria andDirectTitleLike(String value) {
            addCriterion("direct_title like", value, "directTitle");
            return (Criteria) this;
        }

        public Criteria andDirectTitleNotLike(String value) {
            addCriterion("direct_title not like", value, "directTitle");
            return (Criteria) this;
        }

        public Criteria andDirectTitleIn(List<String> values) {
            addCriterion("direct_title in", values, "directTitle");
            return (Criteria) this;
        }

        public Criteria andDirectTitleNotIn(List<String> values) {
            addCriterion("direct_title not in", values, "directTitle");
            return (Criteria) this;
        }

        public Criteria andDirectTitleBetween(String value1, String value2) {
            addCriterion("direct_title between", value1, value2, "directTitle");
            return (Criteria) this;
        }

        public Criteria andDirectTitleNotBetween(String value1, String value2) {
            addCriterion("direct_title not between", value1, value2, "directTitle");
            return (Criteria) this;
        }

        public Criteria andInitACountIsNull() {
            addCriterion("init_a_count is null");
            return (Criteria) this;
        }

        public Criteria andInitACountIsNotNull() {
            addCriterion("init_a_count is not null");
            return (Criteria) this;
        }

        public Criteria andInitACountEqualTo(Integer value) {
            addCriterion("init_a_count =", value, "initACount");
            return (Criteria) this;
        }

        public Criteria andInitACountNotEqualTo(Integer value) {
            addCriterion("init_a_count <>", value, "initACount");
            return (Criteria) this;
        }

        public Criteria andInitACountGreaterThan(Integer value) {
            addCriterion("init_a_count >", value, "initACount");
            return (Criteria) this;
        }

        public Criteria andInitACountGreaterThanOrEqualTo(Integer value) {
            addCriterion("init_a_count >=", value, "initACount");
            return (Criteria) this;
        }

        public Criteria andInitACountLessThan(Integer value) {
            addCriterion("init_a_count <", value, "initACount");
            return (Criteria) this;
        }

        public Criteria andInitACountLessThanOrEqualTo(Integer value) {
            addCriterion("init_a_count <=", value, "initACount");
            return (Criteria) this;
        }

        public Criteria andInitACountIn(List<Integer> values) {
            addCriterion("init_a_count in", values, "initACount");
            return (Criteria) this;
        }

        public Criteria andInitACountNotIn(List<Integer> values) {
            addCriterion("init_a_count not in", values, "initACount");
            return (Criteria) this;
        }

        public Criteria andInitACountBetween(Integer value1, Integer value2) {
            addCriterion("init_a_count between", value1, value2, "initACount");
            return (Criteria) this;
        }

        public Criteria andInitACountNotBetween(Integer value1, Integer value2) {
            addCriterion("init_a_count not between", value1, value2, "initACount");
            return (Criteria) this;
        }

        public Criteria andInitBCountIsNull() {
            addCriterion("init_b_count is null");
            return (Criteria) this;
        }

        public Criteria andInitBCountIsNotNull() {
            addCriterion("init_b_count is not null");
            return (Criteria) this;
        }

        public Criteria andInitBCountEqualTo(Integer value) {
            addCriterion("init_b_count =", value, "initBCount");
            return (Criteria) this;
        }

        public Criteria andInitBCountNotEqualTo(Integer value) {
            addCriterion("init_b_count <>", value, "initBCount");
            return (Criteria) this;
        }

        public Criteria andInitBCountGreaterThan(Integer value) {
            addCriterion("init_b_count >", value, "initBCount");
            return (Criteria) this;
        }

        public Criteria andInitBCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("init_b_count >=", value, "initBCount");
            return (Criteria) this;
        }

        public Criteria andInitBCountLessThan(Integer value) {
            addCriterion("init_b_count <", value, "initBCount");
            return (Criteria) this;
        }

        public Criteria andInitBCountLessThanOrEqualTo(Integer value) {
            addCriterion("init_b_count <=", value, "initBCount");
            return (Criteria) this;
        }

        public Criteria andInitBCountIn(List<Integer> values) {
            addCriterion("init_b_count in", values, "initBCount");
            return (Criteria) this;
        }

        public Criteria andInitBCountNotIn(List<Integer> values) {
            addCriterion("init_b_count not in", values, "initBCount");
            return (Criteria) this;
        }

        public Criteria andInitBCountBetween(Integer value1, Integer value2) {
            addCriterion("init_b_count between", value1, value2, "initBCount");
            return (Criteria) this;
        }

        public Criteria andInitBCountNotBetween(Integer value1, Integer value2) {
            addCriterion("init_b_count not between", value1, value2, "initBCount");
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