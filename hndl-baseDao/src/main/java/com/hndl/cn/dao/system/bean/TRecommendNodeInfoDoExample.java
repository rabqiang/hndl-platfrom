package com.hndl.cn.dao.system.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TRecommendNodeInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TRecommendNodeInfoDoExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNodeidIsNull() {
            addCriterion("nodeId is null");
            return (Criteria) this;
        }

        public Criteria andNodeidIsNotNull() {
            addCriterion("nodeId is not null");
            return (Criteria) this;
        }

        public Criteria andNodeidEqualTo(String value) {
            addCriterion("nodeId =", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidNotEqualTo(String value) {
            addCriterion("nodeId <>", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidGreaterThan(String value) {
            addCriterion("nodeId >", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidGreaterThanOrEqualTo(String value) {
            addCriterion("nodeId >=", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidLessThan(String value) {
            addCriterion("nodeId <", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidLessThanOrEqualTo(String value) {
            addCriterion("nodeId <=", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidLike(String value) {
            addCriterion("nodeId like", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidNotLike(String value) {
            addCriterion("nodeId not like", value, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidIn(List<String> values) {
            addCriterion("nodeId in", values, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidNotIn(List<String> values) {
            addCriterion("nodeId not in", values, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidBetween(String value1, String value2) {
            addCriterion("nodeId between", value1, value2, "nodeid");
            return (Criteria) this;
        }

        public Criteria andNodeidNotBetween(String value1, String value2) {
            addCriterion("nodeId not between", value1, value2, "nodeid");
            return (Criteria) this;
        }

        public Criteria andRankingIsNull() {
            addCriterion("ranking is null");
            return (Criteria) this;
        }

        public Criteria andRankingIsNotNull() {
            addCriterion("ranking is not null");
            return (Criteria) this;
        }

        public Criteria andRankingEqualTo(Integer value) {
            addCriterion("ranking =", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingNotEqualTo(Integer value) {
            addCriterion("ranking <>", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingGreaterThan(Integer value) {
            addCriterion("ranking >", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingGreaterThanOrEqualTo(Integer value) {
            addCriterion("ranking >=", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingLessThan(Integer value) {
            addCriterion("ranking <", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingLessThanOrEqualTo(Integer value) {
            addCriterion("ranking <=", value, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingIn(List<Integer> values) {
            addCriterion("ranking in", values, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingNotIn(List<Integer> values) {
            addCriterion("ranking not in", values, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingBetween(Integer value1, Integer value2) {
            addCriterion("ranking between", value1, value2, "ranking");
            return (Criteria) this;
        }

        public Criteria andRankingNotBetween(Integer value1, Integer value2) {
            addCriterion("ranking not between", value1, value2, "ranking");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andPicpathIsNull() {
            addCriterion("picPath is null");
            return (Criteria) this;
        }

        public Criteria andPicpathIsNotNull() {
            addCriterion("picPath is not null");
            return (Criteria) this;
        }

        public Criteria andPicpathEqualTo(String value) {
            addCriterion("picPath =", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathNotEqualTo(String value) {
            addCriterion("picPath <>", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathGreaterThan(String value) {
            addCriterion("picPath >", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathGreaterThanOrEqualTo(String value) {
            addCriterion("picPath >=", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathLessThan(String value) {
            addCriterion("picPath <", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathLessThanOrEqualTo(String value) {
            addCriterion("picPath <=", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathLike(String value) {
            addCriterion("picPath like", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathNotLike(String value) {
            addCriterion("picPath not like", value, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathIn(List<String> values) {
            addCriterion("picPath in", values, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathNotIn(List<String> values) {
            addCriterion("picPath not in", values, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathBetween(String value1, String value2) {
            addCriterion("picPath between", value1, value2, "picpath");
            return (Criteria) this;
        }

        public Criteria andPicpathNotBetween(String value1, String value2) {
            addCriterion("picPath not between", value1, value2, "picpath");
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

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
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

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isDelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isDelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(String value) {
            addCriterion("isDelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(String value) {
            addCriterion("isDelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(String value) {
            addCriterion("isDelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(String value) {
            addCriterion("isDelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(String value) {
            addCriterion("isDelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(String value) {
            addCriterion("isDelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLike(String value) {
            addCriterion("isDelete like", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotLike(String value) {
            addCriterion("isDelete not like", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<String> values) {
            addCriterion("isDelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<String> values) {
            addCriterion("isDelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(String value1, String value2) {
            addCriterion("isDelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(String value1, String value2) {
            addCriterion("isDelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIspublishIsNull() {
            addCriterion("isPublish is null");
            return (Criteria) this;
        }

        public Criteria andIspublishIsNotNull() {
            addCriterion("isPublish is not null");
            return (Criteria) this;
        }

        public Criteria andIspublishEqualTo(String value) {
            addCriterion("isPublish =", value, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishNotEqualTo(String value) {
            addCriterion("isPublish <>", value, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishGreaterThan(String value) {
            addCriterion("isPublish >", value, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishGreaterThanOrEqualTo(String value) {
            addCriterion("isPublish >=", value, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishLessThan(String value) {
            addCriterion("isPublish <", value, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishLessThanOrEqualTo(String value) {
            addCriterion("isPublish <=", value, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishLike(String value) {
            addCriterion("isPublish like", value, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishNotLike(String value) {
            addCriterion("isPublish not like", value, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishIn(List<String> values) {
            addCriterion("isPublish in", values, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishNotIn(List<String> values) {
            addCriterion("isPublish not in", values, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishBetween(String value1, String value2) {
            addCriterion("isPublish between", value1, value2, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishNotBetween(String value1, String value2) {
            addCriterion("isPublish not between", value1, value2, "ispublish");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishUserIsNull() {
            addCriterion("publish_user is null");
            return (Criteria) this;
        }

        public Criteria andPublishUserIsNotNull() {
            addCriterion("publish_user is not null");
            return (Criteria) this;
        }

        public Criteria andPublishUserEqualTo(String value) {
            addCriterion("publish_user =", value, "publishUser");
            return (Criteria) this;
        }

        public Criteria andPublishUserNotEqualTo(String value) {
            addCriterion("publish_user <>", value, "publishUser");
            return (Criteria) this;
        }

        public Criteria andPublishUserGreaterThan(String value) {
            addCriterion("publish_user >", value, "publishUser");
            return (Criteria) this;
        }

        public Criteria andPublishUserGreaterThanOrEqualTo(String value) {
            addCriterion("publish_user >=", value, "publishUser");
            return (Criteria) this;
        }

        public Criteria andPublishUserLessThan(String value) {
            addCriterion("publish_user <", value, "publishUser");
            return (Criteria) this;
        }

        public Criteria andPublishUserLessThanOrEqualTo(String value) {
            addCriterion("publish_user <=", value, "publishUser");
            return (Criteria) this;
        }

        public Criteria andPublishUserLike(String value) {
            addCriterion("publish_user like", value, "publishUser");
            return (Criteria) this;
        }

        public Criteria andPublishUserNotLike(String value) {
            addCriterion("publish_user not like", value, "publishUser");
            return (Criteria) this;
        }

        public Criteria andPublishUserIn(List<String> values) {
            addCriterion("publish_user in", values, "publishUser");
            return (Criteria) this;
        }

        public Criteria andPublishUserNotIn(List<String> values) {
            addCriterion("publish_user not in", values, "publishUser");
            return (Criteria) this;
        }

        public Criteria andPublishUserBetween(String value1, String value2) {
            addCriterion("publish_user between", value1, value2, "publishUser");
            return (Criteria) this;
        }

        public Criteria andPublishUserNotBetween(String value1, String value2) {
            addCriterion("publish_user not between", value1, value2, "publishUser");
            return (Criteria) this;
        }

        public Criteria andLContenttypeIsNull() {
            addCriterion("l_contentType is null");
            return (Criteria) this;
        }

        public Criteria andLContenttypeIsNotNull() {
            addCriterion("l_contentType is not null");
            return (Criteria) this;
        }

        public Criteria andLContenttypeEqualTo(String value) {
            addCriterion("l_contentType =", value, "lContenttype");
            return (Criteria) this;
        }

        public Criteria andLContenttypeNotEqualTo(String value) {
            addCriterion("l_contentType <>", value, "lContenttype");
            return (Criteria) this;
        }

        public Criteria andLContenttypeGreaterThan(String value) {
            addCriterion("l_contentType >", value, "lContenttype");
            return (Criteria) this;
        }

        public Criteria andLContenttypeGreaterThanOrEqualTo(String value) {
            addCriterion("l_contentType >=", value, "lContenttype");
            return (Criteria) this;
        }

        public Criteria andLContenttypeLessThan(String value) {
            addCriterion("l_contentType <", value, "lContenttype");
            return (Criteria) this;
        }

        public Criteria andLContenttypeLessThanOrEqualTo(String value) {
            addCriterion("l_contentType <=", value, "lContenttype");
            return (Criteria) this;
        }

        public Criteria andLContenttypeLike(String value) {
            addCriterion("l_contentType like", value, "lContenttype");
            return (Criteria) this;
        }

        public Criteria andLContenttypeNotLike(String value) {
            addCriterion("l_contentType not like", value, "lContenttype");
            return (Criteria) this;
        }

        public Criteria andLContenttypeIn(List<String> values) {
            addCriterion("l_contentType in", values, "lContenttype");
            return (Criteria) this;
        }

        public Criteria andLContenttypeNotIn(List<String> values) {
            addCriterion("l_contentType not in", values, "lContenttype");
            return (Criteria) this;
        }

        public Criteria andLContenttypeBetween(String value1, String value2) {
            addCriterion("l_contentType between", value1, value2, "lContenttype");
            return (Criteria) this;
        }

        public Criteria andLContenttypeNotBetween(String value1, String value2) {
            addCriterion("l_contentType not between", value1, value2, "lContenttype");
            return (Criteria) this;
        }

        public Criteria andLNodeidIsNull() {
            addCriterion("l_nodeId is null");
            return (Criteria) this;
        }

        public Criteria andLNodeidIsNotNull() {
            addCriterion("l_nodeId is not null");
            return (Criteria) this;
        }

        public Criteria andLNodeidEqualTo(String value) {
            addCriterion("l_nodeId =", value, "lNodeid");
            return (Criteria) this;
        }

        public Criteria andLNodeidNotEqualTo(String value) {
            addCriterion("l_nodeId <>", value, "lNodeid");
            return (Criteria) this;
        }

        public Criteria andLNodeidGreaterThan(String value) {
            addCriterion("l_nodeId >", value, "lNodeid");
            return (Criteria) this;
        }

        public Criteria andLNodeidGreaterThanOrEqualTo(String value) {
            addCriterion("l_nodeId >=", value, "lNodeid");
            return (Criteria) this;
        }

        public Criteria andLNodeidLessThan(String value) {
            addCriterion("l_nodeId <", value, "lNodeid");
            return (Criteria) this;
        }

        public Criteria andLNodeidLessThanOrEqualTo(String value) {
            addCriterion("l_nodeId <=", value, "lNodeid");
            return (Criteria) this;
        }

        public Criteria andLNodeidLike(String value) {
            addCriterion("l_nodeId like", value, "lNodeid");
            return (Criteria) this;
        }

        public Criteria andLNodeidNotLike(String value) {
            addCriterion("l_nodeId not like", value, "lNodeid");
            return (Criteria) this;
        }

        public Criteria andLNodeidIn(List<String> values) {
            addCriterion("l_nodeId in", values, "lNodeid");
            return (Criteria) this;
        }

        public Criteria andLNodeidNotIn(List<String> values) {
            addCriterion("l_nodeId not in", values, "lNodeid");
            return (Criteria) this;
        }

        public Criteria andLNodeidBetween(String value1, String value2) {
            addCriterion("l_nodeId between", value1, value2, "lNodeid");
            return (Criteria) this;
        }

        public Criteria andLNodeidNotBetween(String value1, String value2) {
            addCriterion("l_nodeId not between", value1, value2, "lNodeid");
            return (Criteria) this;
        }

        public Criteria andLContentIsNull() {
            addCriterion("l_content is null");
            return (Criteria) this;
        }

        public Criteria andLContentIsNotNull() {
            addCriterion("l_content is not null");
            return (Criteria) this;
        }

        public Criteria andLContentEqualTo(String value) {
            addCriterion("l_content =", value, "lContent");
            return (Criteria) this;
        }

        public Criteria andLContentNotEqualTo(String value) {
            addCriterion("l_content <>", value, "lContent");
            return (Criteria) this;
        }

        public Criteria andLContentGreaterThan(String value) {
            addCriterion("l_content >", value, "lContent");
            return (Criteria) this;
        }

        public Criteria andLContentGreaterThanOrEqualTo(String value) {
            addCriterion("l_content >=", value, "lContent");
            return (Criteria) this;
        }

        public Criteria andLContentLessThan(String value) {
            addCriterion("l_content <", value, "lContent");
            return (Criteria) this;
        }

        public Criteria andLContentLessThanOrEqualTo(String value) {
            addCriterion("l_content <=", value, "lContent");
            return (Criteria) this;
        }

        public Criteria andLContentLike(String value) {
            addCriterion("l_content like", value, "lContent");
            return (Criteria) this;
        }

        public Criteria andLContentNotLike(String value) {
            addCriterion("l_content not like", value, "lContent");
            return (Criteria) this;
        }

        public Criteria andLContentIn(List<String> values) {
            addCriterion("l_content in", values, "lContent");
            return (Criteria) this;
        }

        public Criteria andLContentNotIn(List<String> values) {
            addCriterion("l_content not in", values, "lContent");
            return (Criteria) this;
        }

        public Criteria andLContentBetween(String value1, String value2) {
            addCriterion("l_content between", value1, value2, "lContent");
            return (Criteria) this;
        }

        public Criteria andLContentNotBetween(String value1, String value2) {
            addCriterion("l_content not between", value1, value2, "lContent");
            return (Criteria) this;
        }

        public Criteria andLPicpathIsNull() {
            addCriterion("l_picPath is null");
            return (Criteria) this;
        }

        public Criteria andLPicpathIsNotNull() {
            addCriterion("l_picPath is not null");
            return (Criteria) this;
        }

        public Criteria andLPicpathEqualTo(String value) {
            addCriterion("l_picPath =", value, "lPicpath");
            return (Criteria) this;
        }

        public Criteria andLPicpathNotEqualTo(String value) {
            addCriterion("l_picPath <>", value, "lPicpath");
            return (Criteria) this;
        }

        public Criteria andLPicpathGreaterThan(String value) {
            addCriterion("l_picPath >", value, "lPicpath");
            return (Criteria) this;
        }

        public Criteria andLPicpathGreaterThanOrEqualTo(String value) {
            addCriterion("l_picPath >=", value, "lPicpath");
            return (Criteria) this;
        }

        public Criteria andLPicpathLessThan(String value) {
            addCriterion("l_picPath <", value, "lPicpath");
            return (Criteria) this;
        }

        public Criteria andLPicpathLessThanOrEqualTo(String value) {
            addCriterion("l_picPath <=", value, "lPicpath");
            return (Criteria) this;
        }

        public Criteria andLPicpathLike(String value) {
            addCriterion("l_picPath like", value, "lPicpath");
            return (Criteria) this;
        }

        public Criteria andLPicpathNotLike(String value) {
            addCriterion("l_picPath not like", value, "lPicpath");
            return (Criteria) this;
        }

        public Criteria andLPicpathIn(List<String> values) {
            addCriterion("l_picPath in", values, "lPicpath");
            return (Criteria) this;
        }

        public Criteria andLPicpathNotIn(List<String> values) {
            addCriterion("l_picPath not in", values, "lPicpath");
            return (Criteria) this;
        }

        public Criteria andLPicpathBetween(String value1, String value2) {
            addCriterion("l_picPath between", value1, value2, "lPicpath");
            return (Criteria) this;
        }

        public Criteria andLPicpathNotBetween(String value1, String value2) {
            addCriterion("l_picPath not between", value1, value2, "lPicpath");
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