package com.hndl.cn.dao.system.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemNoticePersonHomeDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public SystemNoticePersonHomeDoExample() {
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

        public Criteria andNormalQuestionCountIsNull() {
            addCriterion("normal_question_count is null");
            return (Criteria) this;
        }

        public Criteria andNormalQuestionCountIsNotNull() {
            addCriterion("normal_question_count is not null");
            return (Criteria) this;
        }

        public Criteria andNormalQuestionCountEqualTo(Integer value) {
            addCriterion("normal_question_count =", value, "normalQuestionCount");
            return (Criteria) this;
        }

        public Criteria andNormalQuestionCountNotEqualTo(Integer value) {
            addCriterion("normal_question_count <>", value, "normalQuestionCount");
            return (Criteria) this;
        }

        public Criteria andNormalQuestionCountGreaterThan(Integer value) {
            addCriterion("normal_question_count >", value, "normalQuestionCount");
            return (Criteria) this;
        }

        public Criteria andNormalQuestionCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("normal_question_count >=", value, "normalQuestionCount");
            return (Criteria) this;
        }

        public Criteria andNormalQuestionCountLessThan(Integer value) {
            addCriterion("normal_question_count <", value, "normalQuestionCount");
            return (Criteria) this;
        }

        public Criteria andNormalQuestionCountLessThanOrEqualTo(Integer value) {
            addCriterion("normal_question_count <=", value, "normalQuestionCount");
            return (Criteria) this;
        }

        public Criteria andNormalQuestionCountIn(List<Integer> values) {
            addCriterion("normal_question_count in", values, "normalQuestionCount");
            return (Criteria) this;
        }

        public Criteria andNormalQuestionCountNotIn(List<Integer> values) {
            addCriterion("normal_question_count not in", values, "normalQuestionCount");
            return (Criteria) this;
        }

        public Criteria andNormalQuestionCountBetween(Integer value1, Integer value2) {
            addCriterion("normal_question_count between", value1, value2, "normalQuestionCount");
            return (Criteria) this;
        }

        public Criteria andNormalQuestionCountNotBetween(Integer value1, Integer value2) {
            addCriterion("normal_question_count not between", value1, value2, "normalQuestionCount");
            return (Criteria) this;
        }

        public Criteria andProductVersionUpdateCountIsNull() {
            addCriterion("product_version_update_count is null");
            return (Criteria) this;
        }

        public Criteria andProductVersionUpdateCountIsNotNull() {
            addCriterion("product_version_update_count is not null");
            return (Criteria) this;
        }

        public Criteria andProductVersionUpdateCountEqualTo(Integer value) {
            addCriterion("product_version_update_count =", value, "productVersionUpdateCount");
            return (Criteria) this;
        }

        public Criteria andProductVersionUpdateCountNotEqualTo(Integer value) {
            addCriterion("product_version_update_count <>", value, "productVersionUpdateCount");
            return (Criteria) this;
        }

        public Criteria andProductVersionUpdateCountGreaterThan(Integer value) {
            addCriterion("product_version_update_count >", value, "productVersionUpdateCount");
            return (Criteria) this;
        }

        public Criteria andProductVersionUpdateCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_version_update_count >=", value, "productVersionUpdateCount");
            return (Criteria) this;
        }

        public Criteria andProductVersionUpdateCountLessThan(Integer value) {
            addCriterion("product_version_update_count <", value, "productVersionUpdateCount");
            return (Criteria) this;
        }

        public Criteria andProductVersionUpdateCountLessThanOrEqualTo(Integer value) {
            addCriterion("product_version_update_count <=", value, "productVersionUpdateCount");
            return (Criteria) this;
        }

        public Criteria andProductVersionUpdateCountIn(List<Integer> values) {
            addCriterion("product_version_update_count in", values, "productVersionUpdateCount");
            return (Criteria) this;
        }

        public Criteria andProductVersionUpdateCountNotIn(List<Integer> values) {
            addCriterion("product_version_update_count not in", values, "productVersionUpdateCount");
            return (Criteria) this;
        }

        public Criteria andProductVersionUpdateCountBetween(Integer value1, Integer value2) {
            addCriterion("product_version_update_count between", value1, value2, "productVersionUpdateCount");
            return (Criteria) this;
        }

        public Criteria andProductVersionUpdateCountNotBetween(Integer value1, Integer value2) {
            addCriterion("product_version_update_count not between", value1, value2, "productVersionUpdateCount");
            return (Criteria) this;
        }

        public Criteria andAboutMangguohudongCountIsNull() {
            addCriterion("about__mangguohudong_count is null");
            return (Criteria) this;
        }

        public Criteria andAboutMangguohudongCountIsNotNull() {
            addCriterion("about__mangguohudong_count is not null");
            return (Criteria) this;
        }

        public Criteria andAboutMangguohudongCountEqualTo(Integer value) {
            addCriterion("about__mangguohudong_count =", value, "aboutMangguohudongCount");
            return (Criteria) this;
        }

        public Criteria andAboutMangguohudongCountNotEqualTo(Integer value) {
            addCriterion("about__mangguohudong_count <>", value, "aboutMangguohudongCount");
            return (Criteria) this;
        }

        public Criteria andAboutMangguohudongCountGreaterThan(Integer value) {
            addCriterion("about__mangguohudong_count >", value, "aboutMangguohudongCount");
            return (Criteria) this;
        }

        public Criteria andAboutMangguohudongCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("about__mangguohudong_count >=", value, "aboutMangguohudongCount");
            return (Criteria) this;
        }

        public Criteria andAboutMangguohudongCountLessThan(Integer value) {
            addCriterion("about__mangguohudong_count <", value, "aboutMangguohudongCount");
            return (Criteria) this;
        }

        public Criteria andAboutMangguohudongCountLessThanOrEqualTo(Integer value) {
            addCriterion("about__mangguohudong_count <=", value, "aboutMangguohudongCount");
            return (Criteria) this;
        }

        public Criteria andAboutMangguohudongCountIn(List<Integer> values) {
            addCriterion("about__mangguohudong_count in", values, "aboutMangguohudongCount");
            return (Criteria) this;
        }

        public Criteria andAboutMangguohudongCountNotIn(List<Integer> values) {
            addCriterion("about__mangguohudong_count not in", values, "aboutMangguohudongCount");
            return (Criteria) this;
        }

        public Criteria andAboutMangguohudongCountBetween(Integer value1, Integer value2) {
            addCriterion("about__mangguohudong_count between", value1, value2, "aboutMangguohudongCount");
            return (Criteria) this;
        }

        public Criteria andAboutMangguohudongCountNotBetween(Integer value1, Integer value2) {
            addCriterion("about__mangguohudong_count not between", value1, value2, "aboutMangguohudongCount");
            return (Criteria) this;
        }

        public Criteria andLaststInfoCountIsNull() {
            addCriterion("lastst_info_count is null");
            return (Criteria) this;
        }

        public Criteria andLaststInfoCountIsNotNull() {
            addCriterion("lastst_info_count is not null");
            return (Criteria) this;
        }

        public Criteria andLaststInfoCountEqualTo(Integer value) {
            addCriterion("lastst_info_count =", value, "laststInfoCount");
            return (Criteria) this;
        }

        public Criteria andLaststInfoCountNotEqualTo(Integer value) {
            addCriterion("lastst_info_count <>", value, "laststInfoCount");
            return (Criteria) this;
        }

        public Criteria andLaststInfoCountGreaterThan(Integer value) {
            addCriterion("lastst_info_count >", value, "laststInfoCount");
            return (Criteria) this;
        }

        public Criteria andLaststInfoCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("lastst_info_count >=", value, "laststInfoCount");
            return (Criteria) this;
        }

        public Criteria andLaststInfoCountLessThan(Integer value) {
            addCriterion("lastst_info_count <", value, "laststInfoCount");
            return (Criteria) this;
        }

        public Criteria andLaststInfoCountLessThanOrEqualTo(Integer value) {
            addCriterion("lastst_info_count <=", value, "laststInfoCount");
            return (Criteria) this;
        }

        public Criteria andLaststInfoCountIn(List<Integer> values) {
            addCriterion("lastst_info_count in", values, "laststInfoCount");
            return (Criteria) this;
        }

        public Criteria andLaststInfoCountNotIn(List<Integer> values) {
            addCriterion("lastst_info_count not in", values, "laststInfoCount");
            return (Criteria) this;
        }

        public Criteria andLaststInfoCountBetween(Integer value1, Integer value2) {
            addCriterion("lastst_info_count between", value1, value2, "laststInfoCount");
            return (Criteria) this;
        }

        public Criteria andLaststInfoCountNotBetween(Integer value1, Integer value2) {
            addCriterion("lastst_info_count not between", value1, value2, "laststInfoCount");
            return (Criteria) this;
        }

        public Criteria andInteractRecordCountIsNull() {
            addCriterion("interact_record_count is null");
            return (Criteria) this;
        }

        public Criteria andInteractRecordCountIsNotNull() {
            addCriterion("interact_record_count is not null");
            return (Criteria) this;
        }

        public Criteria andInteractRecordCountEqualTo(Integer value) {
            addCriterion("interact_record_count =", value, "interactRecordCount");
            return (Criteria) this;
        }

        public Criteria andInteractRecordCountNotEqualTo(Integer value) {
            addCriterion("interact_record_count <>", value, "interactRecordCount");
            return (Criteria) this;
        }

        public Criteria andInteractRecordCountGreaterThan(Integer value) {
            addCriterion("interact_record_count >", value, "interactRecordCount");
            return (Criteria) this;
        }

        public Criteria andInteractRecordCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("interact_record_count >=", value, "interactRecordCount");
            return (Criteria) this;
        }

        public Criteria andInteractRecordCountLessThan(Integer value) {
            addCriterion("interact_record_count <", value, "interactRecordCount");
            return (Criteria) this;
        }

        public Criteria andInteractRecordCountLessThanOrEqualTo(Integer value) {
            addCriterion("interact_record_count <=", value, "interactRecordCount");
            return (Criteria) this;
        }

        public Criteria andInteractRecordCountIn(List<Integer> values) {
            addCriterion("interact_record_count in", values, "interactRecordCount");
            return (Criteria) this;
        }

        public Criteria andInteractRecordCountNotIn(List<Integer> values) {
            addCriterion("interact_record_count not in", values, "interactRecordCount");
            return (Criteria) this;
        }

        public Criteria andInteractRecordCountBetween(Integer value1, Integer value2) {
            addCriterion("interact_record_count between", value1, value2, "interactRecordCount");
            return (Criteria) this;
        }

        public Criteria andInteractRecordCountNotBetween(Integer value1, Integer value2) {
            addCriterion("interact_record_count not between", value1, value2, "interactRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopRecordCountIsNull() {
            addCriterion("shop_record_count is null");
            return (Criteria) this;
        }

        public Criteria andShopRecordCountIsNotNull() {
            addCriterion("shop_record_count is not null");
            return (Criteria) this;
        }

        public Criteria andShopRecordCountEqualTo(Integer value) {
            addCriterion("shop_record_count =", value, "shopRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopRecordCountNotEqualTo(Integer value) {
            addCriterion("shop_record_count <>", value, "shopRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopRecordCountGreaterThan(Integer value) {
            addCriterion("shop_record_count >", value, "shopRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopRecordCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_record_count >=", value, "shopRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopRecordCountLessThan(Integer value) {
            addCriterion("shop_record_count <", value, "shopRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopRecordCountLessThanOrEqualTo(Integer value) {
            addCriterion("shop_record_count <=", value, "shopRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopRecordCountIn(List<Integer> values) {
            addCriterion("shop_record_count in", values, "shopRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopRecordCountNotIn(List<Integer> values) {
            addCriterion("shop_record_count not in", values, "shopRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopRecordCountBetween(Integer value1, Integer value2) {
            addCriterion("shop_record_count between", value1, value2, "shopRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopRecordCountNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_record_count not between", value1, value2, "shopRecordCount");
            return (Criteria) this;
        }

        public Criteria andLuckyRecordCountIsNull() {
            addCriterion("lucky_record_count is null");
            return (Criteria) this;
        }

        public Criteria andLuckyRecordCountIsNotNull() {
            addCriterion("lucky_record_count is not null");
            return (Criteria) this;
        }

        public Criteria andLuckyRecordCountEqualTo(Integer value) {
            addCriterion("lucky_record_count =", value, "luckyRecordCount");
            return (Criteria) this;
        }

        public Criteria andLuckyRecordCountNotEqualTo(Integer value) {
            addCriterion("lucky_record_count <>", value, "luckyRecordCount");
            return (Criteria) this;
        }

        public Criteria andLuckyRecordCountGreaterThan(Integer value) {
            addCriterion("lucky_record_count >", value, "luckyRecordCount");
            return (Criteria) this;
        }

        public Criteria andLuckyRecordCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("lucky_record_count >=", value, "luckyRecordCount");
            return (Criteria) this;
        }

        public Criteria andLuckyRecordCountLessThan(Integer value) {
            addCriterion("lucky_record_count <", value, "luckyRecordCount");
            return (Criteria) this;
        }

        public Criteria andLuckyRecordCountLessThanOrEqualTo(Integer value) {
            addCriterion("lucky_record_count <=", value, "luckyRecordCount");
            return (Criteria) this;
        }

        public Criteria andLuckyRecordCountIn(List<Integer> values) {
            addCriterion("lucky_record_count in", values, "luckyRecordCount");
            return (Criteria) this;
        }

        public Criteria andLuckyRecordCountNotIn(List<Integer> values) {
            addCriterion("lucky_record_count not in", values, "luckyRecordCount");
            return (Criteria) this;
        }

        public Criteria andLuckyRecordCountBetween(Integer value1, Integer value2) {
            addCriterion("lucky_record_count between", value1, value2, "luckyRecordCount");
            return (Criteria) this;
        }

        public Criteria andLuckyRecordCountNotBetween(Integer value1, Integer value2) {
            addCriterion("lucky_record_count not between", value1, value2, "luckyRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopOrderShowInfoRecordCountIsNull() {
            addCriterion("shop_order_show_info_record_count is null");
            return (Criteria) this;
        }

        public Criteria andShopOrderShowInfoRecordCountIsNotNull() {
            addCriterion("shop_order_show_info_record_count is not null");
            return (Criteria) this;
        }

        public Criteria andShopOrderShowInfoRecordCountEqualTo(Integer value) {
            addCriterion("shop_order_show_info_record_count =", value, "shopOrderShowInfoRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopOrderShowInfoRecordCountNotEqualTo(Integer value) {
            addCriterion("shop_order_show_info_record_count <>", value, "shopOrderShowInfoRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopOrderShowInfoRecordCountGreaterThan(Integer value) {
            addCriterion("shop_order_show_info_record_count >", value, "shopOrderShowInfoRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopOrderShowInfoRecordCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_order_show_info_record_count >=", value, "shopOrderShowInfoRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopOrderShowInfoRecordCountLessThan(Integer value) {
            addCriterion("shop_order_show_info_record_count <", value, "shopOrderShowInfoRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopOrderShowInfoRecordCountLessThanOrEqualTo(Integer value) {
            addCriterion("shop_order_show_info_record_count <=", value, "shopOrderShowInfoRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopOrderShowInfoRecordCountIn(List<Integer> values) {
            addCriterion("shop_order_show_info_record_count in", values, "shopOrderShowInfoRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopOrderShowInfoRecordCountNotIn(List<Integer> values) {
            addCriterion("shop_order_show_info_record_count not in", values, "shopOrderShowInfoRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopOrderShowInfoRecordCountBetween(Integer value1, Integer value2) {
            addCriterion("shop_order_show_info_record_count between", value1, value2, "shopOrderShowInfoRecordCount");
            return (Criteria) this;
        }

        public Criteria andShopOrderShowInfoRecordCountNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_order_show_info_record_count not between", value1, value2, "shopOrderShowInfoRecordCount");
            return (Criteria) this;
        }

        public Criteria andBeanCoinCountIsNull() {
            addCriterion("bean_coin_count is null");
            return (Criteria) this;
        }

        public Criteria andBeanCoinCountIsNotNull() {
            addCriterion("bean_coin_count is not null");
            return (Criteria) this;
        }

        public Criteria andBeanCoinCountEqualTo(Integer value) {
            addCriterion("bean_coin_count =", value, "beanCoinCount");
            return (Criteria) this;
        }

        public Criteria andBeanCoinCountNotEqualTo(Integer value) {
            addCriterion("bean_coin_count <>", value, "beanCoinCount");
            return (Criteria) this;
        }

        public Criteria andBeanCoinCountGreaterThan(Integer value) {
            addCriterion("bean_coin_count >", value, "beanCoinCount");
            return (Criteria) this;
        }

        public Criteria andBeanCoinCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("bean_coin_count >=", value, "beanCoinCount");
            return (Criteria) this;
        }

        public Criteria andBeanCoinCountLessThan(Integer value) {
            addCriterion("bean_coin_count <", value, "beanCoinCount");
            return (Criteria) this;
        }

        public Criteria andBeanCoinCountLessThanOrEqualTo(Integer value) {
            addCriterion("bean_coin_count <=", value, "beanCoinCount");
            return (Criteria) this;
        }

        public Criteria andBeanCoinCountIn(List<Integer> values) {
            addCriterion("bean_coin_count in", values, "beanCoinCount");
            return (Criteria) this;
        }

        public Criteria andBeanCoinCountNotIn(List<Integer> values) {
            addCriterion("bean_coin_count not in", values, "beanCoinCount");
            return (Criteria) this;
        }

        public Criteria andBeanCoinCountBetween(Integer value1, Integer value2) {
            addCriterion("bean_coin_count between", value1, value2, "beanCoinCount");
            return (Criteria) this;
        }

        public Criteria andBeanCoinCountNotBetween(Integer value1, Integer value2) {
            addCriterion("bean_coin_count not between", value1, value2, "beanCoinCount");
            return (Criteria) this;
        }

        public Criteria andShopCountIsNull() {
            addCriterion("shop_count is null");
            return (Criteria) this;
        }

        public Criteria andShopCountIsNotNull() {
            addCriterion("shop_count is not null");
            return (Criteria) this;
        }

        public Criteria andShopCountEqualTo(Integer value) {
            addCriterion("shop_count =", value, "shopCount");
            return (Criteria) this;
        }

        public Criteria andShopCountNotEqualTo(Integer value) {
            addCriterion("shop_count <>", value, "shopCount");
            return (Criteria) this;
        }

        public Criteria andShopCountGreaterThan(Integer value) {
            addCriterion("shop_count >", value, "shopCount");
            return (Criteria) this;
        }

        public Criteria andShopCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_count >=", value, "shopCount");
            return (Criteria) this;
        }

        public Criteria andShopCountLessThan(Integer value) {
            addCriterion("shop_count <", value, "shopCount");
            return (Criteria) this;
        }

        public Criteria andShopCountLessThanOrEqualTo(Integer value) {
            addCriterion("shop_count <=", value, "shopCount");
            return (Criteria) this;
        }

        public Criteria andShopCountIn(List<Integer> values) {
            addCriterion("shop_count in", values, "shopCount");
            return (Criteria) this;
        }

        public Criteria andShopCountNotIn(List<Integer> values) {
            addCriterion("shop_count not in", values, "shopCount");
            return (Criteria) this;
        }

        public Criteria andShopCountBetween(Integer value1, Integer value2) {
            addCriterion("shop_count between", value1, value2, "shopCount");
            return (Criteria) this;
        }

        public Criteria andShopCountNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_count not between", value1, value2, "shopCount");
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

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andGoodCountIsNull() {
            addCriterion("good_count is null");
            return (Criteria) this;
        }

        public Criteria andGoodCountIsNotNull() {
            addCriterion("good_count is not null");
            return (Criteria) this;
        }

        public Criteria andGoodCountEqualTo(Integer value) {
            addCriterion("good_count =", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountNotEqualTo(Integer value) {
            addCriterion("good_count <>", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountGreaterThan(Integer value) {
            addCriterion("good_count >", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("good_count >=", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountLessThan(Integer value) {
            addCriterion("good_count <", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountLessThanOrEqualTo(Integer value) {
            addCriterion("good_count <=", value, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountIn(List<Integer> values) {
            addCriterion("good_count in", values, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountNotIn(List<Integer> values) {
            addCriterion("good_count not in", values, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountBetween(Integer value1, Integer value2) {
            addCriterion("good_count between", value1, value2, "goodCount");
            return (Criteria) this;
        }

        public Criteria andGoodCountNotBetween(Integer value1, Integer value2) {
            addCriterion("good_count not between", value1, value2, "goodCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Integer value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Integer value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Integer value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Integer value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Integer> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Integer> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andWelfareCountIsNull() {
            addCriterion("welfare_count is null");
            return (Criteria) this;
        }

        public Criteria andWelfareCountIsNotNull() {
            addCriterion("welfare_count is not null");
            return (Criteria) this;
        }

        public Criteria andWelfareCountEqualTo(Integer value) {
            addCriterion("welfare_count =", value, "welfareCount");
            return (Criteria) this;
        }

        public Criteria andWelfareCountNotEqualTo(Integer value) {
            addCriterion("welfare_count <>", value, "welfareCount");
            return (Criteria) this;
        }

        public Criteria andWelfareCountGreaterThan(Integer value) {
            addCriterion("welfare_count >", value, "welfareCount");
            return (Criteria) this;
        }

        public Criteria andWelfareCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("welfare_count >=", value, "welfareCount");
            return (Criteria) this;
        }

        public Criteria andWelfareCountLessThan(Integer value) {
            addCriterion("welfare_count <", value, "welfareCount");
            return (Criteria) this;
        }

        public Criteria andWelfareCountLessThanOrEqualTo(Integer value) {
            addCriterion("welfare_count <=", value, "welfareCount");
            return (Criteria) this;
        }

        public Criteria andWelfareCountIn(List<Integer> values) {
            addCriterion("welfare_count in", values, "welfareCount");
            return (Criteria) this;
        }

        public Criteria andWelfareCountNotIn(List<Integer> values) {
            addCriterion("welfare_count not in", values, "welfareCount");
            return (Criteria) this;
        }

        public Criteria andWelfareCountBetween(Integer value1, Integer value2) {
            addCriterion("welfare_count between", value1, value2, "welfareCount");
            return (Criteria) this;
        }

        public Criteria andWelfareCountNotBetween(Integer value1, Integer value2) {
            addCriterion("welfare_count not between", value1, value2, "welfareCount");
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