package com.hndl.cn.dao.system.bean;

import java.util.ArrayList;
import java.util.List;

public class TBasePowerDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TBasePowerDoExample() {
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

        public Criteria andPoweridIsNull() {
            addCriterion("powerid is null");
            return (Criteria) this;
        }

        public Criteria andPoweridIsNotNull() {
            addCriterion("powerid is not null");
            return (Criteria) this;
        }

        public Criteria andPoweridEqualTo(String value) {
            addCriterion("powerid =", value, "powerid");
            return (Criteria) this;
        }

        public Criteria andPoweridNotEqualTo(String value) {
            addCriterion("powerid <>", value, "powerid");
            return (Criteria) this;
        }

        public Criteria andPoweridGreaterThan(String value) {
            addCriterion("powerid >", value, "powerid");
            return (Criteria) this;
        }

        public Criteria andPoweridGreaterThanOrEqualTo(String value) {
            addCriterion("powerid >=", value, "powerid");
            return (Criteria) this;
        }

        public Criteria andPoweridLessThan(String value) {
            addCriterion("powerid <", value, "powerid");
            return (Criteria) this;
        }

        public Criteria andPoweridLessThanOrEqualTo(String value) {
            addCriterion("powerid <=", value, "powerid");
            return (Criteria) this;
        }

        public Criteria andPoweridLike(String value) {
            addCriterion("powerid like", value, "powerid");
            return (Criteria) this;
        }

        public Criteria andPoweridNotLike(String value) {
            addCriterion("powerid not like", value, "powerid");
            return (Criteria) this;
        }

        public Criteria andPoweridIn(List<String> values) {
            addCriterion("powerid in", values, "powerid");
            return (Criteria) this;
        }

        public Criteria andPoweridNotIn(List<String> values) {
            addCriterion("powerid not in", values, "powerid");
            return (Criteria) this;
        }

        public Criteria andPoweridBetween(String value1, String value2) {
            addCriterion("powerid between", value1, value2, "powerid");
            return (Criteria) this;
        }

        public Criteria andPoweridNotBetween(String value1, String value2) {
            addCriterion("powerid not between", value1, value2, "powerid");
            return (Criteria) this;
        }

        public Criteria andPowernameIsNull() {
            addCriterion("powername is null");
            return (Criteria) this;
        }

        public Criteria andPowernameIsNotNull() {
            addCriterion("powername is not null");
            return (Criteria) this;
        }

        public Criteria andPowernameEqualTo(String value) {
            addCriterion("powername =", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameNotEqualTo(String value) {
            addCriterion("powername <>", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameGreaterThan(String value) {
            addCriterion("powername >", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameGreaterThanOrEqualTo(String value) {
            addCriterion("powername >=", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameLessThan(String value) {
            addCriterion("powername <", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameLessThanOrEqualTo(String value) {
            addCriterion("powername <=", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameLike(String value) {
            addCriterion("powername like", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameNotLike(String value) {
            addCriterion("powername not like", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameIn(List<String> values) {
            addCriterion("powername in", values, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameNotIn(List<String> values) {
            addCriterion("powername not in", values, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameBetween(String value1, String value2) {
            addCriterion("powername between", value1, value2, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameNotBetween(String value1, String value2) {
            addCriterion("powername not between", value1, value2, "powername");
            return (Criteria) this;
        }

        public Criteria andFatheridIsNull() {
            addCriterion("fatherid is null");
            return (Criteria) this;
        }

        public Criteria andFatheridIsNotNull() {
            addCriterion("fatherid is not null");
            return (Criteria) this;
        }

        public Criteria andFatheridEqualTo(String value) {
            addCriterion("fatherid =", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotEqualTo(String value) {
            addCriterion("fatherid <>", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridGreaterThan(String value) {
            addCriterion("fatherid >", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridGreaterThanOrEqualTo(String value) {
            addCriterion("fatherid >=", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridLessThan(String value) {
            addCriterion("fatherid <", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridLessThanOrEqualTo(String value) {
            addCriterion("fatherid <=", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridLike(String value) {
            addCriterion("fatherid like", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotLike(String value) {
            addCriterion("fatherid not like", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridIn(List<String> values) {
            addCriterion("fatherid in", values, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotIn(List<String> values) {
            addCriterion("fatherid not in", values, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridBetween(String value1, String value2) {
            addCriterion("fatherid between", value1, value2, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotBetween(String value1, String value2) {
            addCriterion("fatherid not between", value1, value2, "fatherid");
            return (Criteria) this;
        }

        public Criteria andPowerurlIsNull() {
            addCriterion("powerurl is null");
            return (Criteria) this;
        }

        public Criteria andPowerurlIsNotNull() {
            addCriterion("powerurl is not null");
            return (Criteria) this;
        }

        public Criteria andPowerurlEqualTo(String value) {
            addCriterion("powerurl =", value, "powerurl");
            return (Criteria) this;
        }

        public Criteria andPowerurlNotEqualTo(String value) {
            addCriterion("powerurl <>", value, "powerurl");
            return (Criteria) this;
        }

        public Criteria andPowerurlGreaterThan(String value) {
            addCriterion("powerurl >", value, "powerurl");
            return (Criteria) this;
        }

        public Criteria andPowerurlGreaterThanOrEqualTo(String value) {
            addCriterion("powerurl >=", value, "powerurl");
            return (Criteria) this;
        }

        public Criteria andPowerurlLessThan(String value) {
            addCriterion("powerurl <", value, "powerurl");
            return (Criteria) this;
        }

        public Criteria andPowerurlLessThanOrEqualTo(String value) {
            addCriterion("powerurl <=", value, "powerurl");
            return (Criteria) this;
        }

        public Criteria andPowerurlLike(String value) {
            addCriterion("powerurl like", value, "powerurl");
            return (Criteria) this;
        }

        public Criteria andPowerurlNotLike(String value) {
            addCriterion("powerurl not like", value, "powerurl");
            return (Criteria) this;
        }

        public Criteria andPowerurlIn(List<String> values) {
            addCriterion("powerurl in", values, "powerurl");
            return (Criteria) this;
        }

        public Criteria andPowerurlNotIn(List<String> values) {
            addCriterion("powerurl not in", values, "powerurl");
            return (Criteria) this;
        }

        public Criteria andPowerurlBetween(String value1, String value2) {
            addCriterion("powerurl between", value1, value2, "powerurl");
            return (Criteria) this;
        }

        public Criteria andPowerurlNotBetween(String value1, String value2) {
            addCriterion("powerurl not between", value1, value2, "powerurl");
            return (Criteria) this;
        }

        public Criteria andPowertypeIsNull() {
            addCriterion("powertype is null");
            return (Criteria) this;
        }

        public Criteria andPowertypeIsNotNull() {
            addCriterion("powertype is not null");
            return (Criteria) this;
        }

        public Criteria andPowertypeEqualTo(String value) {
            addCriterion("powertype =", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeNotEqualTo(String value) {
            addCriterion("powertype <>", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeGreaterThan(String value) {
            addCriterion("powertype >", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeGreaterThanOrEqualTo(String value) {
            addCriterion("powertype >=", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeLessThan(String value) {
            addCriterion("powertype <", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeLessThanOrEqualTo(String value) {
            addCriterion("powertype <=", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeLike(String value) {
            addCriterion("powertype like", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeNotLike(String value) {
            addCriterion("powertype not like", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeIn(List<String> values) {
            addCriterion("powertype in", values, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeNotIn(List<String> values) {
            addCriterion("powertype not in", values, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeBetween(String value1, String value2) {
            addCriterion("powertype between", value1, value2, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeNotBetween(String value1, String value2) {
            addCriterion("powertype not between", value1, value2, "powertype");
            return (Criteria) this;
        }

        public Criteria andSequencesIsNull() {
            addCriterion("sequences is null");
            return (Criteria) this;
        }

        public Criteria andSequencesIsNotNull() {
            addCriterion("sequences is not null");
            return (Criteria) this;
        }

        public Criteria andSequencesEqualTo(Integer value) {
            addCriterion("sequences =", value, "sequences");
            return (Criteria) this;
        }

        public Criteria andSequencesNotEqualTo(Integer value) {
            addCriterion("sequences <>", value, "sequences");
            return (Criteria) this;
        }

        public Criteria andSequencesGreaterThan(Integer value) {
            addCriterion("sequences >", value, "sequences");
            return (Criteria) this;
        }

        public Criteria andSequencesGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequences >=", value, "sequences");
            return (Criteria) this;
        }

        public Criteria andSequencesLessThan(Integer value) {
            addCriterion("sequences <", value, "sequences");
            return (Criteria) this;
        }

        public Criteria andSequencesLessThanOrEqualTo(Integer value) {
            addCriterion("sequences <=", value, "sequences");
            return (Criteria) this;
        }

        public Criteria andSequencesIn(List<Integer> values) {
            addCriterion("sequences in", values, "sequences");
            return (Criteria) this;
        }

        public Criteria andSequencesNotIn(List<Integer> values) {
            addCriterion("sequences not in", values, "sequences");
            return (Criteria) this;
        }

        public Criteria andSequencesBetween(Integer value1, Integer value2) {
            addCriterion("sequences between", value1, value2, "sequences");
            return (Criteria) this;
        }

        public Criteria andSequencesNotBetween(Integer value1, Integer value2) {
            addCriterion("sequences not between", value1, value2, "sequences");
            return (Criteria) this;
        }

        public Criteria andExtviewurlIsNull() {
            addCriterion("extviewurl is null");
            return (Criteria) this;
        }

        public Criteria andExtviewurlIsNotNull() {
            addCriterion("extviewurl is not null");
            return (Criteria) this;
        }

        public Criteria andExtviewurlEqualTo(String value) {
            addCriterion("extviewurl =", value, "extviewurl");
            return (Criteria) this;
        }

        public Criteria andExtviewurlNotEqualTo(String value) {
            addCriterion("extviewurl <>", value, "extviewurl");
            return (Criteria) this;
        }

        public Criteria andExtviewurlGreaterThan(String value) {
            addCriterion("extviewurl >", value, "extviewurl");
            return (Criteria) this;
        }

        public Criteria andExtviewurlGreaterThanOrEqualTo(String value) {
            addCriterion("extviewurl >=", value, "extviewurl");
            return (Criteria) this;
        }

        public Criteria andExtviewurlLessThan(String value) {
            addCriterion("extviewurl <", value, "extviewurl");
            return (Criteria) this;
        }

        public Criteria andExtviewurlLessThanOrEqualTo(String value) {
            addCriterion("extviewurl <=", value, "extviewurl");
            return (Criteria) this;
        }

        public Criteria andExtviewurlLike(String value) {
            addCriterion("extviewurl like", value, "extviewurl");
            return (Criteria) this;
        }

        public Criteria andExtviewurlNotLike(String value) {
            addCriterion("extviewurl not like", value, "extviewurl");
            return (Criteria) this;
        }

        public Criteria andExtviewurlIn(List<String> values) {
            addCriterion("extviewurl in", values, "extviewurl");
            return (Criteria) this;
        }

        public Criteria andExtviewurlNotIn(List<String> values) {
            addCriterion("extviewurl not in", values, "extviewurl");
            return (Criteria) this;
        }

        public Criteria andExtviewurlBetween(String value1, String value2) {
            addCriterion("extviewurl between", value1, value2, "extviewurl");
            return (Criteria) this;
        }

        public Criteria andExtviewurlNotBetween(String value1, String value2) {
            addCriterion("extviewurl not between", value1, value2, "extviewurl");
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