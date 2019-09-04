package com.hndl.cn.dao.wechat.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WechatAppletsCustomerMsgConfigDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public WechatAppletsCustomerMsgConfigDoExample() {
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

        public Criteria andIsDeleteLike(Integer value) {
            addCriterion("is_delete like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotLike(Integer value) {
            addCriterion("is_delete not like", value, "isDelete");
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

        public Criteria andClientMsgIsNull() {
            addCriterion("client_msg is null");
            return (Criteria) this;
        }

        public Criteria andClientMsgIsNotNull() {
            addCriterion("client_msg is not null");
            return (Criteria) this;
        }

        public Criteria andClientMsgEqualTo(String value) {
            addCriterion("client_msg =", value, "clientMsg");
            return (Criteria) this;
        }

        public Criteria andClientMsgNotEqualTo(String value) {
            addCriterion("client_msg <>", value, "clientMsg");
            return (Criteria) this;
        }

        public Criteria andClientMsgGreaterThan(String value) {
            addCriterion("client_msg >", value, "clientMsg");
            return (Criteria) this;
        }

        public Criteria andClientMsgGreaterThanOrEqualTo(String value) {
            addCriterion("client_msg >=", value, "clientMsg");
            return (Criteria) this;
        }

        public Criteria andClientMsgLessThan(String value) {
            addCriterion("client_msg <", value, "clientMsg");
            return (Criteria) this;
        }

        public Criteria andClientMsgLessThanOrEqualTo(String value) {
            addCriterion("client_msg <=", value, "clientMsg");
            return (Criteria) this;
        }

        public Criteria andClientMsgLike(String value) {
            addCriterion("client_msg like", value, "clientMsg");
            return (Criteria) this;
        }

        public Criteria andClientMsgNotLike(String value) {
            addCriterion("client_msg not like", value, "clientMsg");
            return (Criteria) this;
        }

        public Criteria andClientMsgIn(List<String> values) {
            addCriterion("client_msg in", values, "clientMsg");
            return (Criteria) this;
        }

        public Criteria andClientMsgNotIn(List<String> values) {
            addCriterion("client_msg not in", values, "clientMsg");
            return (Criteria) this;
        }

        public Criteria andClientMsgBetween(String value1, String value2) {
            addCriterion("client_msg between", value1, value2, "clientMsg");
            return (Criteria) this;
        }

        public Criteria andClientMsgNotBetween(String value1, String value2) {
            addCriterion("client_msg not between", value1, value2, "clientMsg");
            return (Criteria) this;
        }

        public Criteria andClientMsgTypeIsNull() {
            addCriterion("client_msg_type is null");
            return (Criteria) this;
        }

        public Criteria andClientMsgTypeIsNotNull() {
            addCriterion("client_msg_type is not null");
            return (Criteria) this;
        }

        public Criteria andClientMsgTypeEqualTo(Integer value) {
            addCriterion("client_msg_type =", value, "clientMsgType");
            return (Criteria) this;
        }

        public Criteria andClientMsgTypeNotEqualTo(Integer value) {
            addCriterion("client_msg_type <>", value, "clientMsgType");
            return (Criteria) this;
        }

        public Criteria andClientMsgTypeGreaterThan(Integer value) {
            addCriterion("client_msg_type >", value, "clientMsgType");
            return (Criteria) this;
        }

        public Criteria andClientMsgTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("client_msg_type >=", value, "clientMsgType");
            return (Criteria) this;
        }

        public Criteria andClientMsgTypeLessThan(Integer value) {
            addCriterion("client_msg_type <", value, "clientMsgType");
            return (Criteria) this;
        }

        public Criteria andClientMsgTypeLessThanOrEqualTo(Integer value) {
            addCriterion("client_msg_type <=", value, "clientMsgType");
            return (Criteria) this;
        }

        public Criteria andClientMsgTypeIn(List<Integer> values) {
            addCriterion("client_msg_type in", values, "clientMsgType");
            return (Criteria) this;
        }

        public Criteria andClientMsgTypeNotIn(List<Integer> values) {
            addCriterion("client_msg_type not in", values, "clientMsgType");
            return (Criteria) this;
        }

        public Criteria andClientMsgTypeBetween(Integer value1, Integer value2) {
            addCriterion("client_msg_type between", value1, value2, "clientMsgType");
            return (Criteria) this;
        }

        public Criteria andClientMsgTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("client_msg_type not between", value1, value2, "clientMsgType");
            return (Criteria) this;
        }

        public Criteria andResponseMsgIsNull() {
            addCriterion("response_msg is null");
            return (Criteria) this;
        }

        public Criteria andResponseMsgIsNotNull() {
            addCriterion("response_msg is not null");
            return (Criteria) this;
        }

        public Criteria andResponseMsgEqualTo(String value) {
            addCriterion("response_msg =", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotEqualTo(String value) {
            addCriterion("response_msg <>", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgGreaterThan(String value) {
            addCriterion("response_msg >", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgGreaterThanOrEqualTo(String value) {
            addCriterion("response_msg >=", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgLessThan(String value) {
            addCriterion("response_msg <", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgLessThanOrEqualTo(String value) {
            addCriterion("response_msg <=", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgLike(String value) {
            addCriterion("response_msg like", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotLike(String value) {
            addCriterion("response_msg not like", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgIn(List<String> values) {
            addCriterion("response_msg in", values, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotIn(List<String> values) {
            addCriterion("response_msg not in", values, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgBetween(String value1, String value2) {
            addCriterion("response_msg between", value1, value2, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotBetween(String value1, String value2) {
            addCriterion("response_msg not between", value1, value2, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgTypeIsNull() {
            addCriterion("response_msg_type is null");
            return (Criteria) this;
        }

        public Criteria andResponseMsgTypeIsNotNull() {
            addCriterion("response_msg_type is not null");
            return (Criteria) this;
        }

        public Criteria andResponseMsgTypeEqualTo(Integer value) {
            addCriterion("response_msg_type =", value, "responseMsgType");
            return (Criteria) this;
        }

        public Criteria andResponseMsgTypeNotEqualTo(Integer value) {
            addCriterion("response_msg_type <>", value, "responseMsgType");
            return (Criteria) this;
        }

        public Criteria andResponseMsgTypeGreaterThan(Integer value) {
            addCriterion("response_msg_type >", value, "responseMsgType");
            return (Criteria) this;
        }

        public Criteria andResponseMsgTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("response_msg_type >=", value, "responseMsgType");
            return (Criteria) this;
        }

        public Criteria andResponseMsgTypeLessThan(Integer value) {
            addCriterion("response_msg_type <", value, "responseMsgType");
            return (Criteria) this;
        }

        public Criteria andResponseMsgTypeLessThanOrEqualTo(Integer value) {
            addCriterion("response_msg_type <=", value, "responseMsgType");
            return (Criteria) this;
        }

        public Criteria andResponseMsgTypeIn(List<Integer> values) {
            addCriterion("response_msg_type in", values, "responseMsgType");
            return (Criteria) this;
        }

        public Criteria andResponseMsgTypeNotIn(List<Integer> values) {
            addCriterion("response_msg_type not in", values, "responseMsgType");
            return (Criteria) this;
        }

        public Criteria andResponseMsgTypeBetween(Integer value1, Integer value2) {
            addCriterion("response_msg_type between", value1, value2, "responseMsgType");
            return (Criteria) this;
        }

        public Criteria andResponseMsgTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("response_msg_type not between", value1, value2, "responseMsgType");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create _user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create _user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdbigEqualTo(Long value) {
            addCriterion("create _user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdbigNotEqualTo(Long value) {
            addCriterion("create _user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Long value) {
            addCriterion("create _user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create _user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Long value) {
            addCriterion("create _user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("create _user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(Long value) {
            addCriterion("create _user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(Long value) {
            addCriterion("create _user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Long> values) {
            addCriterion("create _user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Long> values) {
            addCriterion("create _user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Long value1, Long value2) {
            addCriterion("create _user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("create _user_id not between", value1, value2, "createUserId");
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

        public Criteria andCreateTimeLike(Date value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
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

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(Long value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(Long value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(Long value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(Long value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLike(Long value) {
            addCriterion("update_user_id like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotLike(Long value) {
            addCriterion("update_user_id not like", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<Long> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<Long> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(Long value1, Long value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
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

        public Criteria andUpdateTimeLike(Date value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(Date value) {
            addCriterion("update_time not like", value, "updateTime");
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