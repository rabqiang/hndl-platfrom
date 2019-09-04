package com.hndl.cn.dao.system.bean;

import java.util.ArrayList;
import java.util.List;

public class TBaseDataDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TBaseDataDoExample() {
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

        public Criteria andDatacodeIsNull() {
            addCriterion("datacode is null");
            return (Criteria) this;
        }

        public Criteria andDatacodeIsNotNull() {
            addCriterion("datacode is not null");
            return (Criteria) this;
        }

        public Criteria andDatacodeEqualTo(String value) {
            addCriterion("datacode =", value, "datacode");
            return (Criteria) this;
        }

        public Criteria andDatacodeNotEqualTo(String value) {
            addCriterion("datacode <>", value, "datacode");
            return (Criteria) this;
        }

        public Criteria andDatacodeGreaterThan(String value) {
            addCriterion("datacode >", value, "datacode");
            return (Criteria) this;
        }

        public Criteria andDatacodeGreaterThanOrEqualTo(String value) {
            addCriterion("datacode >=", value, "datacode");
            return (Criteria) this;
        }

        public Criteria andDatacodeLessThan(String value) {
            addCriterion("datacode <", value, "datacode");
            return (Criteria) this;
        }

        public Criteria andDatacodeLessThanOrEqualTo(String value) {
            addCriterion("datacode <=", value, "datacode");
            return (Criteria) this;
        }

        public Criteria andDatacodeLike(String value) {
            addCriterion("datacode like", value, "datacode");
            return (Criteria) this;
        }

        public Criteria andDatacodeNotLike(String value) {
            addCriterion("datacode not like", value, "datacode");
            return (Criteria) this;
        }

        public Criteria andDatacodeIn(List<String> values) {
            addCriterion("datacode in", values, "datacode");
            return (Criteria) this;
        }

        public Criteria andDatacodeNotIn(List<String> values) {
            addCriterion("datacode not in", values, "datacode");
            return (Criteria) this;
        }

        public Criteria andDatacodeBetween(String value1, String value2) {
            addCriterion("datacode between", value1, value2, "datacode");
            return (Criteria) this;
        }

        public Criteria andDatacodeNotBetween(String value1, String value2) {
            addCriterion("datacode not between", value1, value2, "datacode");
            return (Criteria) this;
        }

        public Criteria andDatanameIsNull() {
            addCriterion("dataname is null");
            return (Criteria) this;
        }

        public Criteria andDatanameIsNotNull() {
            addCriterion("dataname is not null");
            return (Criteria) this;
        }

        public Criteria andDatanameEqualTo(String value) {
            addCriterion("dataname =", value, "dataname");
            return (Criteria) this;
        }

        public Criteria andDatanameNotEqualTo(String value) {
            addCriterion("dataname <>", value, "dataname");
            return (Criteria) this;
        }

        public Criteria andDatanameGreaterThan(String value) {
            addCriterion("dataname >", value, "dataname");
            return (Criteria) this;
        }

        public Criteria andDatanameGreaterThanOrEqualTo(String value) {
            addCriterion("dataname >=", value, "dataname");
            return (Criteria) this;
        }

        public Criteria andDatanameLessThan(String value) {
            addCriterion("dataname <", value, "dataname");
            return (Criteria) this;
        }

        public Criteria andDatanameLessThanOrEqualTo(String value) {
            addCriterion("dataname <=", value, "dataname");
            return (Criteria) this;
        }

        public Criteria andDatanameLike(String value) {
            addCriterion("dataname like", value, "dataname");
            return (Criteria) this;
        }

        public Criteria andDatanameNotLike(String value) {
            addCriterion("dataname not like", value, "dataname");
            return (Criteria) this;
        }

        public Criteria andDatanameIn(List<String> values) {
            addCriterion("dataname in", values, "dataname");
            return (Criteria) this;
        }

        public Criteria andDatanameNotIn(List<String> values) {
            addCriterion("dataname not in", values, "dataname");
            return (Criteria) this;
        }

        public Criteria andDatanameBetween(String value1, String value2) {
            addCriterion("dataname between", value1, value2, "dataname");
            return (Criteria) this;
        }

        public Criteria andDatanameNotBetween(String value1, String value2) {
            addCriterion("dataname not between", value1, value2, "dataname");
            return (Criteria) this;
        }

        public Criteria andDatatypesIsNull() {
            addCriterion("datatypes is null");
            return (Criteria) this;
        }

        public Criteria andDatatypesIsNotNull() {
            addCriterion("datatypes is not null");
            return (Criteria) this;
        }

        public Criteria andDatatypesEqualTo(String value) {
            addCriterion("datatypes =", value, "datatypes");
            return (Criteria) this;
        }

        public Criteria andDatatypesNotEqualTo(String value) {
            addCriterion("datatypes <>", value, "datatypes");
            return (Criteria) this;
        }

        public Criteria andDatatypesGreaterThan(String value) {
            addCriterion("datatypes >", value, "datatypes");
            return (Criteria) this;
        }

        public Criteria andDatatypesGreaterThanOrEqualTo(String value) {
            addCriterion("datatypes >=", value, "datatypes");
            return (Criteria) this;
        }

        public Criteria andDatatypesLessThan(String value) {
            addCriterion("datatypes <", value, "datatypes");
            return (Criteria) this;
        }

        public Criteria andDatatypesLessThanOrEqualTo(String value) {
            addCriterion("datatypes <=", value, "datatypes");
            return (Criteria) this;
        }

        public Criteria andDatatypesLike(String value) {
            addCriterion("datatypes like", value, "datatypes");
            return (Criteria) this;
        }

        public Criteria andDatatypesNotLike(String value) {
            addCriterion("datatypes not like", value, "datatypes");
            return (Criteria) this;
        }

        public Criteria andDatatypesIn(List<String> values) {
            addCriterion("datatypes in", values, "datatypes");
            return (Criteria) this;
        }

        public Criteria andDatatypesNotIn(List<String> values) {
            addCriterion("datatypes not in", values, "datatypes");
            return (Criteria) this;
        }

        public Criteria andDatatypesBetween(String value1, String value2) {
            addCriterion("datatypes between", value1, value2, "datatypes");
            return (Criteria) this;
        }

        public Criteria andDatatypesNotBetween(String value1, String value2) {
            addCriterion("datatypes not between", value1, value2, "datatypes");
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