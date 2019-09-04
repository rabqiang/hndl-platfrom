package com.hndl.cn.dao.prize.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LuckyTurntableInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public LuckyTurntableInfoDoExample() {
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

        public Criteria andPrizeNameIsNull() {
            addCriterion("prize_name is null");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIsNotNull() {
            addCriterion("prize_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeNameEqualTo(String value) {
            addCriterion("prize_name =", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotEqualTo(String value) {
            addCriterion("prize_name <>", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThan(String value) {
            addCriterion("prize_name >", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameGreaterThanOrEqualTo(String value) {
            addCriterion("prize_name >=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThan(String value) {
            addCriterion("prize_name <", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLessThanOrEqualTo(String value) {
            addCriterion("prize_name <=", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameLike(String value) {
            addCriterion("prize_name like", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotLike(String value) {
            addCriterion("prize_name not like", value, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameIn(List<String> values) {
            addCriterion("prize_name in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotIn(List<String> values) {
            addCriterion("prize_name not in", values, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameBetween(String value1, String value2) {
            addCriterion("prize_name between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andPrizeNameNotBetween(String value1, String value2) {
            addCriterion("prize_name not between", value1, value2, "prizeName");
            return (Criteria) this;
        }

        public Criteria andCreateAdminIdIsNull() {
            addCriterion("create_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateAdminIdIsNotNull() {
            addCriterion("create_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAdminIdEqualTo(Long value) {
            addCriterion("create_admin_id =", value, "createAdminId");
            return (Criteria) this;
        }

        public Criteria andCreateAdminIdNotEqualTo(Long value) {
            addCriterion("create_admin_id <>", value, "createAdminId");
            return (Criteria) this;
        }

        public Criteria andCreateAdminIdGreaterThan(Long value) {
            addCriterion("create_admin_id >", value, "createAdminId");
            return (Criteria) this;
        }

        public Criteria andCreateAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_admin_id >=", value, "createAdminId");
            return (Criteria) this;
        }

        public Criteria andCreateAdminIdLessThan(Long value) {
            addCriterion("create_admin_id <", value, "createAdminId");
            return (Criteria) this;
        }

        public Criteria andCreateAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("create_admin_id <=", value, "createAdminId");
            return (Criteria) this;
        }

        public Criteria andCreateAdminIdIn(List<Long> values) {
            addCriterion("create_admin_id in", values, "createAdminId");
            return (Criteria) this;
        }

        public Criteria andCreateAdminIdNotIn(List<Long> values) {
            addCriterion("create_admin_id not in", values, "createAdminId");
            return (Criteria) this;
        }

        public Criteria andCreateAdminIdBetween(Long value1, Long value2) {
            addCriterion("create_admin_id between", value1, value2, "createAdminId");
            return (Criteria) this;
        }

        public Criteria andCreateAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("create_admin_id not between", value1, value2, "createAdminId");
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

        public Criteria andUpateAdminIdIsNull() {
            addCriterion("upate_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andUpateAdminIdIsNotNull() {
            addCriterion("upate_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpateAdminIdEqualTo(Long value) {
            addCriterion("upate_admin_id =", value, "upateAdminId");
            return (Criteria) this;
        }

        public Criteria andUpateAdminIdNotEqualTo(Long value) {
            addCriterion("upate_admin_id <>", value, "upateAdminId");
            return (Criteria) this;
        }

        public Criteria andUpateAdminIdGreaterThan(Long value) {
            addCriterion("upate_admin_id >", value, "upateAdminId");
            return (Criteria) this;
        }

        public Criteria andUpateAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("upate_admin_id >=", value, "upateAdminId");
            return (Criteria) this;
        }

        public Criteria andUpateAdminIdLessThan(Long value) {
            addCriterion("upate_admin_id <", value, "upateAdminId");
            return (Criteria) this;
        }

        public Criteria andUpateAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("upate_admin_id <=", value, "upateAdminId");
            return (Criteria) this;
        }

        public Criteria andUpateAdminIdIn(List<Long> values) {
            addCriterion("upate_admin_id in", values, "upateAdminId");
            return (Criteria) this;
        }

        public Criteria andUpateAdminIdNotIn(List<Long> values) {
            addCriterion("upate_admin_id not in", values, "upateAdminId");
            return (Criteria) this;
        }

        public Criteria andUpateAdminIdBetween(Long value1, Long value2) {
            addCriterion("upate_admin_id between", value1, value2, "upateAdminId");
            return (Criteria) this;
        }

        public Criteria andUpateAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("upate_admin_id not between", value1, value2, "upateAdminId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andWeightNumIsNull() {
            addCriterion("weight_num is null");
            return (Criteria) this;
        }

        public Criteria andWeightNumIsNotNull() {
            addCriterion("weight_num is not null");
            return (Criteria) this;
        }

        public Criteria andWeightNumEqualTo(Integer value) {
            addCriterion("weight_num =", value, "weightNum");
            return (Criteria) this;
        }

        public Criteria andWeightNumNotEqualTo(Integer value) {
            addCriterion("weight_num <>", value, "weightNum");
            return (Criteria) this;
        }

        public Criteria andWeightNumGreaterThan(Integer value) {
            addCriterion("weight_num >", value, "weightNum");
            return (Criteria) this;
        }

        public Criteria andWeightNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight_num >=", value, "weightNum");
            return (Criteria) this;
        }

        public Criteria andWeightNumLessThan(Integer value) {
            addCriterion("weight_num <", value, "weightNum");
            return (Criteria) this;
        }

        public Criteria andWeightNumLessThanOrEqualTo(Integer value) {
            addCriterion("weight_num <=", value, "weightNum");
            return (Criteria) this;
        }

        public Criteria andWeightNumIn(List<Integer> values) {
            addCriterion("weight_num in", values, "weightNum");
            return (Criteria) this;
        }

        public Criteria andWeightNumNotIn(List<Integer> values) {
            addCriterion("weight_num not in", values, "weightNum");
            return (Criteria) this;
        }

        public Criteria andWeightNumBetween(Integer value1, Integer value2) {
            addCriterion("weight_num between", value1, value2, "weightNum");
            return (Criteria) this;
        }

        public Criteria andWeightNumNotBetween(Integer value1, Integer value2) {
            addCriterion("weight_num not between", value1, value2, "weightNum");
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

        public Criteria andReserveNumIsNull() {
            addCriterion("reserve_num is null");
            return (Criteria) this;
        }

        public Criteria andReserveNumIsNotNull() {
            addCriterion("reserve_num is not null");
            return (Criteria) this;
        }

        public Criteria andReserveNumEqualTo(Integer value) {
            addCriterion("reserve_num =", value, "reserveNum");
            return (Criteria) this;
        }

        public Criteria andReserveNumNotEqualTo(Integer value) {
            addCriterion("reserve_num <>", value, "reserveNum");
            return (Criteria) this;
        }

        public Criteria andReserveNumGreaterThan(Integer value) {
            addCriterion("reserve_num >", value, "reserveNum");
            return (Criteria) this;
        }

        public Criteria andReserveNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("reserve_num >=", value, "reserveNum");
            return (Criteria) this;
        }

        public Criteria andReserveNumLessThan(Integer value) {
            addCriterion("reserve_num <", value, "reserveNum");
            return (Criteria) this;
        }

        public Criteria andReserveNumLessThanOrEqualTo(Integer value) {
            addCriterion("reserve_num <=", value, "reserveNum");
            return (Criteria) this;
        }

        public Criteria andReserveNumIn(List<Integer> values) {
            addCriterion("reserve_num in", values, "reserveNum");
            return (Criteria) this;
        }

        public Criteria andReserveNumNotIn(List<Integer> values) {
            addCriterion("reserve_num not in", values, "reserveNum");
            return (Criteria) this;
        }

        public Criteria andReserveNumBetween(Integer value1, Integer value2) {
            addCriterion("reserve_num between", value1, value2, "reserveNum");
            return (Criteria) this;
        }

        public Criteria andReserveNumNotBetween(Integer value1, Integer value2) {
            addCriterion("reserve_num not between", value1, value2, "reserveNum");
            return (Criteria) this;
        }

        public Criteria andIsEntityIsNull() {
            addCriterion("is_entity is null");
            return (Criteria) this;
        }

        public Criteria andIsEntityIsNotNull() {
            addCriterion("is_entity is not null");
            return (Criteria) this;
        }

        public Criteria andIsEntityEqualTo(Integer value) {
            addCriterion("is_entity =", value, "isEntity");
            return (Criteria) this;
        }

        public Criteria andIsEntityNotEqualTo(Integer value) {
            addCriterion("is_entity <>", value, "isEntity");
            return (Criteria) this;
        }

        public Criteria andIsEntityGreaterThan(Integer value) {
            addCriterion("is_entity >", value, "isEntity");
            return (Criteria) this;
        }

        public Criteria andIsEntityGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_entity >=", value, "isEntity");
            return (Criteria) this;
        }

        public Criteria andIsEntityLessThan(Integer value) {
            addCriterion("is_entity <", value, "isEntity");
            return (Criteria) this;
        }

        public Criteria andIsEntityLessThanOrEqualTo(Integer value) {
            addCriterion("is_entity <=", value, "isEntity");
            return (Criteria) this;
        }

        public Criteria andIsEntityIn(List<Integer> values) {
            addCriterion("is_entity in", values, "isEntity");
            return (Criteria) this;
        }

        public Criteria andIsEntityNotIn(List<Integer> values) {
            addCriterion("is_entity not in", values, "isEntity");
            return (Criteria) this;
        }

        public Criteria andIsEntityBetween(Integer value1, Integer value2) {
            addCriterion("is_entity between", value1, value2, "isEntity");
            return (Criteria) this;
        }

        public Criteria andIsEntityNotBetween(Integer value1, Integer value2) {
            addCriterion("is_entity not between", value1, value2, "isEntity");
            return (Criteria) this;
        }

        public Criteria andPersonMaxGetIsNull() {
            addCriterion("person_max_get is null");
            return (Criteria) this;
        }

        public Criteria andPersonMaxGetIsNotNull() {
            addCriterion("person_max_get is not null");
            return (Criteria) this;
        }

        public Criteria andPersonMaxGetEqualTo(Integer value) {
            addCriterion("person_max_get =", value, "personMaxGet");
            return (Criteria) this;
        }

        public Criteria andPersonMaxGetNotEqualTo(Integer value) {
            addCriterion("person_max_get <>", value, "personMaxGet");
            return (Criteria) this;
        }

        public Criteria andPersonMaxGetGreaterThan(Integer value) {
            addCriterion("person_max_get >", value, "personMaxGet");
            return (Criteria) this;
        }

        public Criteria andPersonMaxGetGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_max_get >=", value, "personMaxGet");
            return (Criteria) this;
        }

        public Criteria andPersonMaxGetLessThan(Integer value) {
            addCriterion("person_max_get <", value, "personMaxGet");
            return (Criteria) this;
        }

        public Criteria andPersonMaxGetLessThanOrEqualTo(Integer value) {
            addCriterion("person_max_get <=", value, "personMaxGet");
            return (Criteria) this;
        }

        public Criteria andPersonMaxGetIn(List<Integer> values) {
            addCriterion("person_max_get in", values, "personMaxGet");
            return (Criteria) this;
        }

        public Criteria andPersonMaxGetNotIn(List<Integer> values) {
            addCriterion("person_max_get not in", values, "personMaxGet");
            return (Criteria) this;
        }

        public Criteria andPersonMaxGetBetween(Integer value1, Integer value2) {
            addCriterion("person_max_get between", value1, value2, "personMaxGet");
            return (Criteria) this;
        }

        public Criteria andPersonMaxGetNotBetween(Integer value1, Integer value2) {
            addCriterion("person_max_get not between", value1, value2, "personMaxGet");
            return (Criteria) this;
        }

        public Criteria andPersonMinDrawIsNull() {
            addCriterion("person_min_draw is null");
            return (Criteria) this;
        }

        public Criteria andPersonMinDrawIsNotNull() {
            addCriterion("person_min_draw is not null");
            return (Criteria) this;
        }

        public Criteria andPersonMinDrawEqualTo(Integer value) {
            addCriterion("person_min_draw =", value, "personMinDraw");
            return (Criteria) this;
        }

        public Criteria andPersonMinDrawNotEqualTo(Integer value) {
            addCriterion("person_min_draw <>", value, "personMinDraw");
            return (Criteria) this;
        }

        public Criteria andPersonMinDrawGreaterThan(Integer value) {
            addCriterion("person_min_draw >", value, "personMinDraw");
            return (Criteria) this;
        }

        public Criteria andPersonMinDrawGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_min_draw >=", value, "personMinDraw");
            return (Criteria) this;
        }

        public Criteria andPersonMinDrawLessThan(Integer value) {
            addCriterion("person_min_draw <", value, "personMinDraw");
            return (Criteria) this;
        }

        public Criteria andPersonMinDrawLessThanOrEqualTo(Integer value) {
            addCriterion("person_min_draw <=", value, "personMinDraw");
            return (Criteria) this;
        }

        public Criteria andPersonMinDrawIn(List<Integer> values) {
            addCriterion("person_min_draw in", values, "personMinDraw");
            return (Criteria) this;
        }

        public Criteria andPersonMinDrawNotIn(List<Integer> values) {
            addCriterion("person_min_draw not in", values, "personMinDraw");
            return (Criteria) this;
        }

        public Criteria andPersonMinDrawBetween(Integer value1, Integer value2) {
            addCriterion("person_min_draw between", value1, value2, "personMinDraw");
            return (Criteria) this;
        }

        public Criteria andPersonMinDrawNotBetween(Integer value1, Integer value2) {
            addCriterion("person_min_draw not between", value1, value2, "personMinDraw");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andShowMessageIsNull() {
            addCriterion("show_message is null");
            return (Criteria) this;
        }

        public Criteria andShowMessageIsNotNull() {
            addCriterion("show_message is not null");
            return (Criteria) this;
        }

        public Criteria andShowMessageEqualTo(Integer value) {
            addCriterion("show_message =", value, "showMessage");
            return (Criteria) this;
        }

        public Criteria andShowMessageNotEqualTo(Integer value) {
            addCriterion("show_message <>", value, "showMessage");
            return (Criteria) this;
        }

        public Criteria andShowMessageGreaterThan(Integer value) {
            addCriterion("show_message >", value, "showMessage");
            return (Criteria) this;
        }

        public Criteria andShowMessageGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_message >=", value, "showMessage");
            return (Criteria) this;
        }

        public Criteria andShowMessageLessThan(Integer value) {
            addCriterion("show_message <", value, "showMessage");
            return (Criteria) this;
        }

        public Criteria andShowMessageLessThanOrEqualTo(Integer value) {
            addCriterion("show_message <=", value, "showMessage");
            return (Criteria) this;
        }

        public Criteria andShowMessageIn(List<Integer> values) {
            addCriterion("show_message in", values, "showMessage");
            return (Criteria) this;
        }

        public Criteria andShowMessageNotIn(List<Integer> values) {
            addCriterion("show_message not in", values, "showMessage");
            return (Criteria) this;
        }

        public Criteria andShowMessageBetween(Integer value1, Integer value2) {
            addCriterion("show_message between", value1, value2, "showMessage");
            return (Criteria) this;
        }

        public Criteria andShowMessageNotBetween(Integer value1, Integer value2) {
            addCriterion("show_message not between", value1, value2, "showMessage");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(Long value) {
            addCriterion("integral =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(Long value) {
            addCriterion("integral <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(Long value) {
            addCriterion("integral >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(Long value) {
            addCriterion("integral >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(Long value) {
            addCriterion("integral <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(Long value) {
            addCriterion("integral <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<Long> values) {
            addCriterion("integral in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<Long> values) {
            addCriterion("integral not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(Long value1, Long value2) {
            addCriterion("integral between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(Long value1, Long value2) {
            addCriterion("integral not between", value1, value2, "integral");
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

        public Criteria andSubheadIsNull() {
            addCriterion("subhead is null");
            return (Criteria) this;
        }

        public Criteria andSubheadIsNotNull() {
            addCriterion("subhead is not null");
            return (Criteria) this;
        }

        public Criteria andSubheadEqualTo(String value) {
            addCriterion("subhead =", value, "subhead");
            return (Criteria) this;
        }

        public Criteria andSubheadNotEqualTo(String value) {
            addCriterion("subhead <>", value, "subhead");
            return (Criteria) this;
        }

        public Criteria andSubheadGreaterThan(String value) {
            addCriterion("subhead >", value, "subhead");
            return (Criteria) this;
        }

        public Criteria andSubheadGreaterThanOrEqualTo(String value) {
            addCriterion("subhead >=", value, "subhead");
            return (Criteria) this;
        }

        public Criteria andSubheadLessThan(String value) {
            addCriterion("subhead <", value, "subhead");
            return (Criteria) this;
        }

        public Criteria andSubheadLessThanOrEqualTo(String value) {
            addCriterion("subhead <=", value, "subhead");
            return (Criteria) this;
        }

        public Criteria andSubheadLike(String value) {
            addCriterion("subhead like", value, "subhead");
            return (Criteria) this;
        }

        public Criteria andSubheadNotLike(String value) {
            addCriterion("subhead not like", value, "subhead");
            return (Criteria) this;
        }

        public Criteria andSubheadIn(List<String> values) {
            addCriterion("subhead in", values, "subhead");
            return (Criteria) this;
        }

        public Criteria andSubheadNotIn(List<String> values) {
            addCriterion("subhead not in", values, "subhead");
            return (Criteria) this;
        }

        public Criteria andSubheadBetween(String value1, String value2) {
            addCriterion("subhead between", value1, value2, "subhead");
            return (Criteria) this;
        }

        public Criteria andSubheadNotBetween(String value1, String value2) {
            addCriterion("subhead not between", value1, value2, "subhead");
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