package com.hndl.cn.dao.system.bean;

import java.util.ArrayList;
import java.util.List;

public class TBaseConfigDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TBaseConfigDoExample() {
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

        public Criteria andConfignameIsNull() {
            addCriterion("configname is null");
            return (Criteria) this;
        }

        public Criteria andConfignameIsNotNull() {
            addCriterion("configname is not null");
            return (Criteria) this;
        }

        public Criteria andConfignameEqualTo(String value) {
            addCriterion("configname =", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameNotEqualTo(String value) {
            addCriterion("configname <>", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameGreaterThan(String value) {
            addCriterion("configname >", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameGreaterThanOrEqualTo(String value) {
            addCriterion("configname >=", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameLessThan(String value) {
            addCriterion("configname <", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameLessThanOrEqualTo(String value) {
            addCriterion("configname <=", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameLike(String value) {
            addCriterion("configname like", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameNotLike(String value) {
            addCriterion("configname not like", value, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameIn(List<String> values) {
            addCriterion("configname in", values, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameNotIn(List<String> values) {
            addCriterion("configname not in", values, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameBetween(String value1, String value2) {
            addCriterion("configname between", value1, value2, "configname");
            return (Criteria) this;
        }

        public Criteria andConfignameNotBetween(String value1, String value2) {
            addCriterion("configname not between", value1, value2, "configname");
            return (Criteria) this;
        }

        public Criteria andConfigvalueIsNull() {
            addCriterion("configvalue is null");
            return (Criteria) this;
        }

        public Criteria andConfigvalueIsNotNull() {
            addCriterion("configvalue is not null");
            return (Criteria) this;
        }

        public Criteria andConfigvalueEqualTo(String value) {
            addCriterion("configvalue =", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueNotEqualTo(String value) {
            addCriterion("configvalue <>", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueGreaterThan(String value) {
            addCriterion("configvalue >", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueGreaterThanOrEqualTo(String value) {
            addCriterion("configvalue >=", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueLessThan(String value) {
            addCriterion("configvalue <", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueLessThanOrEqualTo(String value) {
            addCriterion("configvalue <=", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueLike(String value) {
            addCriterion("configvalue like", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueNotLike(String value) {
            addCriterion("configvalue not like", value, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueIn(List<String> values) {
            addCriterion("configvalue in", values, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueNotIn(List<String> values) {
            addCriterion("configvalue not in", values, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueBetween(String value1, String value2) {
            addCriterion("configvalue between", value1, value2, "configvalue");
            return (Criteria) this;
        }

        public Criteria andConfigvalueNotBetween(String value1, String value2) {
            addCriterion("configvalue not between", value1, value2, "configvalue");
            return (Criteria) this;
        }

        public Criteria andAllowmodifyIsNull() {
            addCriterion("allowmodify is null");
            return (Criteria) this;
        }

        public Criteria andAllowmodifyIsNotNull() {
            addCriterion("allowmodify is not null");
            return (Criteria) this;
        }

        public Criteria andAllowmodifyEqualTo(String value) {
            addCriterion("allowmodify =", value, "allowmodify");
            return (Criteria) this;
        }

        public Criteria andAllowmodifyNotEqualTo(String value) {
            addCriterion("allowmodify <>", value, "allowmodify");
            return (Criteria) this;
        }

        public Criteria andAllowmodifyGreaterThan(String value) {
            addCriterion("allowmodify >", value, "allowmodify");
            return (Criteria) this;
        }

        public Criteria andAllowmodifyGreaterThanOrEqualTo(String value) {
            addCriterion("allowmodify >=", value, "allowmodify");
            return (Criteria) this;
        }

        public Criteria andAllowmodifyLessThan(String value) {
            addCriterion("allowmodify <", value, "allowmodify");
            return (Criteria) this;
        }

        public Criteria andAllowmodifyLessThanOrEqualTo(String value) {
            addCriterion("allowmodify <=", value, "allowmodify");
            return (Criteria) this;
        }

        public Criteria andAllowmodifyLike(String value) {
            addCriterion("allowmodify like", value, "allowmodify");
            return (Criteria) this;
        }

        public Criteria andAllowmodifyNotLike(String value) {
            addCriterion("allowmodify not like", value, "allowmodify");
            return (Criteria) this;
        }

        public Criteria andAllowmodifyIn(List<String> values) {
            addCriterion("allowmodify in", values, "allowmodify");
            return (Criteria) this;
        }

        public Criteria andAllowmodifyNotIn(List<String> values) {
            addCriterion("allowmodify not in", values, "allowmodify");
            return (Criteria) this;
        }

        public Criteria andAllowmodifyBetween(String value1, String value2) {
            addCriterion("allowmodify between", value1, value2, "allowmodify");
            return (Criteria) this;
        }

        public Criteria andAllowmodifyNotBetween(String value1, String value2) {
            addCriterion("allowmodify not between", value1, value2, "allowmodify");
            return (Criteria) this;
        }

        public Criteria andConfigtypeIsNull() {
            addCriterion("configtype is null");
            return (Criteria) this;
        }

        public Criteria andConfigtypeIsNotNull() {
            addCriterion("configtype is not null");
            return (Criteria) this;
        }

        public Criteria andConfigtypeEqualTo(String value) {
            addCriterion("configtype =", value, "configtype");
            return (Criteria) this;
        }

        public Criteria andConfigtypeNotEqualTo(String value) {
            addCriterion("configtype <>", value, "configtype");
            return (Criteria) this;
        }

        public Criteria andConfigtypeGreaterThan(String value) {
            addCriterion("configtype >", value, "configtype");
            return (Criteria) this;
        }

        public Criteria andConfigtypeGreaterThanOrEqualTo(String value) {
            addCriterion("configtype >=", value, "configtype");
            return (Criteria) this;
        }

        public Criteria andConfigtypeLessThan(String value) {
            addCriterion("configtype <", value, "configtype");
            return (Criteria) this;
        }

        public Criteria andConfigtypeLessThanOrEqualTo(String value) {
            addCriterion("configtype <=", value, "configtype");
            return (Criteria) this;
        }

        public Criteria andConfigtypeLike(String value) {
            addCriterion("configtype like", value, "configtype");
            return (Criteria) this;
        }

        public Criteria andConfigtypeNotLike(String value) {
            addCriterion("configtype not like", value, "configtype");
            return (Criteria) this;
        }

        public Criteria andConfigtypeIn(List<String> values) {
            addCriterion("configtype in", values, "configtype");
            return (Criteria) this;
        }

        public Criteria andConfigtypeNotIn(List<String> values) {
            addCriterion("configtype not in", values, "configtype");
            return (Criteria) this;
        }

        public Criteria andConfigtypeBetween(String value1, String value2) {
            addCriterion("configtype between", value1, value2, "configtype");
            return (Criteria) this;
        }

        public Criteria andConfigtypeNotBetween(String value1, String value2) {
            addCriterion("configtype not between", value1, value2, "configtype");
            return (Criteria) this;
        }

        public Criteria andValidateruleIsNull() {
            addCriterion("validaterule is null");
            return (Criteria) this;
        }

        public Criteria andValidateruleIsNotNull() {
            addCriterion("validaterule is not null");
            return (Criteria) this;
        }

        public Criteria andValidateruleEqualTo(String value) {
            addCriterion("validaterule =", value, "validaterule");
            return (Criteria) this;
        }

        public Criteria andValidateruleNotEqualTo(String value) {
            addCriterion("validaterule <>", value, "validaterule");
            return (Criteria) this;
        }

        public Criteria andValidateruleGreaterThan(String value) {
            addCriterion("validaterule >", value, "validaterule");
            return (Criteria) this;
        }

        public Criteria andValidateruleGreaterThanOrEqualTo(String value) {
            addCriterion("validaterule >=", value, "validaterule");
            return (Criteria) this;
        }

        public Criteria andValidateruleLessThan(String value) {
            addCriterion("validaterule <", value, "validaterule");
            return (Criteria) this;
        }

        public Criteria andValidateruleLessThanOrEqualTo(String value) {
            addCriterion("validaterule <=", value, "validaterule");
            return (Criteria) this;
        }

        public Criteria andValidateruleLike(String value) {
            addCriterion("validaterule like", value, "validaterule");
            return (Criteria) this;
        }

        public Criteria andValidateruleNotLike(String value) {
            addCriterion("validaterule not like", value, "validaterule");
            return (Criteria) this;
        }

        public Criteria andValidateruleIn(List<String> values) {
            addCriterion("validaterule in", values, "validaterule");
            return (Criteria) this;
        }

        public Criteria andValidateruleNotIn(List<String> values) {
            addCriterion("validaterule not in", values, "validaterule");
            return (Criteria) this;
        }

        public Criteria andValidateruleBetween(String value1, String value2) {
            addCriterion("validaterule between", value1, value2, "validaterule");
            return (Criteria) this;
        }

        public Criteria andValidateruleNotBetween(String value1, String value2) {
            addCriterion("validaterule not between", value1, value2, "validaterule");
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