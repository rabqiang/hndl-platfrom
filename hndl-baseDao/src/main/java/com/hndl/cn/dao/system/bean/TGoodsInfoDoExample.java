package com.hndl.cn.dao.system.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TGoodsInfoDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TGoodsInfoDoExample() {
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

        public Criteria andGoodscodeIsNull() {
            addCriterion("goodsCode is null");
            return (Criteria) this;
        }

        public Criteria andGoodscodeIsNotNull() {
            addCriterion("goodsCode is not null");
            return (Criteria) this;
        }

        public Criteria andGoodscodeEqualTo(String value) {
            addCriterion("goodsCode =", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeNotEqualTo(String value) {
            addCriterion("goodsCode <>", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeGreaterThan(String value) {
            addCriterion("goodsCode >", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeGreaterThanOrEqualTo(String value) {
            addCriterion("goodsCode >=", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeLessThan(String value) {
            addCriterion("goodsCode <", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeLessThanOrEqualTo(String value) {
            addCriterion("goodsCode <=", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeLike(String value) {
            addCriterion("goodsCode like", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeNotLike(String value) {
            addCriterion("goodsCode not like", value, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeIn(List<String> values) {
            addCriterion("goodsCode in", values, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeNotIn(List<String> values) {
            addCriterion("goodsCode not in", values, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeBetween(String value1, String value2) {
            addCriterion("goodsCode between", value1, value2, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodscodeNotBetween(String value1, String value2) {
            addCriterion("goodsCode not between", value1, value2, "goodscode");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNull() {
            addCriterion("goodsName is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNotNull() {
            addCriterion("goodsName is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameEqualTo(String value) {
            addCriterion("goodsName =", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotEqualTo(String value) {
            addCriterion("goodsName <>", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThan(String value) {
            addCriterion("goodsName >", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThanOrEqualTo(String value) {
            addCriterion("goodsName >=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThan(String value) {
            addCriterion("goodsName <", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThanOrEqualTo(String value) {
            addCriterion("goodsName <=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLike(String value) {
            addCriterion("goodsName like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotLike(String value) {
            addCriterion("goodsName not like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIn(List<String> values) {
            addCriterion("goodsName in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotIn(List<String> values) {
            addCriterion("goodsName not in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameBetween(String value1, String value2) {
            addCriterion("goodsName between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotBetween(String value1, String value2) {
            addCriterion("goodsName not between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIsNull() {
            addCriterion("goodsType is null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIsNotNull() {
            addCriterion("goodsType is not null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeEqualTo(String value) {
            addCriterion("goodsType =", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNotEqualTo(String value) {
            addCriterion("goodsType <>", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeGreaterThan(String value) {
            addCriterion("goodsType >", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeGreaterThanOrEqualTo(String value) {
            addCriterion("goodsType >=", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeLessThan(String value) {
            addCriterion("goodsType <", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeLessThanOrEqualTo(String value) {
            addCriterion("goodsType <=", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeLike(String value) {
            addCriterion("goodsType like", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNotLike(String value) {
            addCriterion("goodsType not like", value, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeIn(List<String> values) {
            addCriterion("goodsType in", values, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNotIn(List<String> values) {
            addCriterion("goodsType not in", values, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeBetween(String value1, String value2) {
            addCriterion("goodsType between", value1, value2, "goodstype");
            return (Criteria) this;
        }

        public Criteria andGoodstypeNotBetween(String value1, String value2) {
            addCriterion("goodsType not between", value1, value2, "goodstype");
            return (Criteria) this;
        }

        public Criteria andNumbersIsNull() {
            addCriterion("numbers is null");
            return (Criteria) this;
        }

        public Criteria andNumbersIsNotNull() {
            addCriterion("numbers is not null");
            return (Criteria) this;
        }

        public Criteria andNumbersEqualTo(Long value) {
            addCriterion("numbers =", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersNotEqualTo(Long value) {
            addCriterion("numbers <>", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersGreaterThan(Long value) {
            addCriterion("numbers >", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersGreaterThanOrEqualTo(Long value) {
            addCriterion("numbers >=", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersLessThan(Long value) {
            addCriterion("numbers <", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersLessThanOrEqualTo(Long value) {
            addCriterion("numbers <=", value, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersIn(List<Long> values) {
            addCriterion("numbers in", values, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersNotIn(List<Long> values) {
            addCriterion("numbers not in", values, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersBetween(Long value1, Long value2) {
            addCriterion("numbers between", value1, value2, "numbers");
            return (Criteria) this;
        }

        public Criteria andNumbersNotBetween(Long value1, Long value2) {
            addCriterion("numbers not between", value1, value2, "numbers");
            return (Criteria) this;
        }

        public Criteria andGoodsbrandIsNull() {
            addCriterion("goodsBrand is null");
            return (Criteria) this;
        }

        public Criteria andGoodsbrandIsNotNull() {
            addCriterion("goodsBrand is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsbrandEqualTo(String value) {
            addCriterion("goodsBrand =", value, "goodsbrand");
            return (Criteria) this;
        }

        public Criteria andGoodsbrandNotEqualTo(String value) {
            addCriterion("goodsBrand <>", value, "goodsbrand");
            return (Criteria) this;
        }

        public Criteria andGoodsbrandGreaterThan(String value) {
            addCriterion("goodsBrand >", value, "goodsbrand");
            return (Criteria) this;
        }

        public Criteria andGoodsbrandGreaterThanOrEqualTo(String value) {
            addCriterion("goodsBrand >=", value, "goodsbrand");
            return (Criteria) this;
        }

        public Criteria andGoodsbrandLessThan(String value) {
            addCriterion("goodsBrand <", value, "goodsbrand");
            return (Criteria) this;
        }

        public Criteria andGoodsbrandLessThanOrEqualTo(String value) {
            addCriterion("goodsBrand <=", value, "goodsbrand");
            return (Criteria) this;
        }

        public Criteria andGoodsbrandLike(String value) {
            addCriterion("goodsBrand like", value, "goodsbrand");
            return (Criteria) this;
        }

        public Criteria andGoodsbrandNotLike(String value) {
            addCriterion("goodsBrand not like", value, "goodsbrand");
            return (Criteria) this;
        }

        public Criteria andGoodsbrandIn(List<String> values) {
            addCriterion("goodsBrand in", values, "goodsbrand");
            return (Criteria) this;
        }

        public Criteria andGoodsbrandNotIn(List<String> values) {
            addCriterion("goodsBrand not in", values, "goodsbrand");
            return (Criteria) this;
        }

        public Criteria andGoodsbrandBetween(String value1, String value2) {
            addCriterion("goodsBrand between", value1, value2, "goodsbrand");
            return (Criteria) this;
        }

        public Criteria andGoodsbrandNotBetween(String value1, String value2) {
            addCriterion("goodsBrand not between", value1, value2, "goodsbrand");
            return (Criteria) this;
        }

        public Criteria andGoodsformatIsNull() {
            addCriterion("goodsFormat is null");
            return (Criteria) this;
        }

        public Criteria andGoodsformatIsNotNull() {
            addCriterion("goodsFormat is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsformatEqualTo(String value) {
            addCriterion("goodsFormat =", value, "goodsformat");
            return (Criteria) this;
        }

        public Criteria andGoodsformatNotEqualTo(String value) {
            addCriterion("goodsFormat <>", value, "goodsformat");
            return (Criteria) this;
        }

        public Criteria andGoodsformatGreaterThan(String value) {
            addCriterion("goodsFormat >", value, "goodsformat");
            return (Criteria) this;
        }

        public Criteria andGoodsformatGreaterThanOrEqualTo(String value) {
            addCriterion("goodsFormat >=", value, "goodsformat");
            return (Criteria) this;
        }

        public Criteria andGoodsformatLessThan(String value) {
            addCriterion("goodsFormat <", value, "goodsformat");
            return (Criteria) this;
        }

        public Criteria andGoodsformatLessThanOrEqualTo(String value) {
            addCriterion("goodsFormat <=", value, "goodsformat");
            return (Criteria) this;
        }

        public Criteria andGoodsformatLike(String value) {
            addCriterion("goodsFormat like", value, "goodsformat");
            return (Criteria) this;
        }

        public Criteria andGoodsformatNotLike(String value) {
            addCriterion("goodsFormat not like", value, "goodsformat");
            return (Criteria) this;
        }

        public Criteria andGoodsformatIn(List<String> values) {
            addCriterion("goodsFormat in", values, "goodsformat");
            return (Criteria) this;
        }

        public Criteria andGoodsformatNotIn(List<String> values) {
            addCriterion("goodsFormat not in", values, "goodsformat");
            return (Criteria) this;
        }

        public Criteria andGoodsformatBetween(String value1, String value2) {
            addCriterion("goodsFormat between", value1, value2, "goodsformat");
            return (Criteria) this;
        }

        public Criteria andGoodsformatNotBetween(String value1, String value2) {
            addCriterion("goodsFormat not between", value1, value2, "goodsformat");
            return (Criteria) this;
        }

        public Criteria andIsshelvesIsNull() {
            addCriterion("isShelves is null");
            return (Criteria) this;
        }

        public Criteria andIsshelvesIsNotNull() {
            addCriterion("isShelves is not null");
            return (Criteria) this;
        }

        public Criteria andIsshelvesEqualTo(Integer value) {
            addCriterion("isShelves =", value, "isshelves");
            return (Criteria) this;
        }

        public Criteria andIsshelvesNotEqualTo(Integer value) {
            addCriterion("isShelves <>", value, "isshelves");
            return (Criteria) this;
        }

        public Criteria andIsshelvesGreaterThan(Integer value) {
            addCriterion("isShelves >", value, "isshelves");
            return (Criteria) this;
        }

        public Criteria andIsshelvesGreaterThanOrEqualTo(Integer value) {
            addCriterion("isShelves >=", value, "isshelves");
            return (Criteria) this;
        }

        public Criteria andIsshelvesLessThan(Integer value) {
            addCriterion("isShelves <", value, "isshelves");
            return (Criteria) this;
        }

        public Criteria andIsshelvesLessThanOrEqualTo(Integer value) {
            addCriterion("isShelves <=", value, "isshelves");
            return (Criteria) this;
        }

        public Criteria andIsshelvesIn(List<Integer> values) {
            addCriterion("isShelves in", values, "isshelves");
            return (Criteria) this;
        }

        public Criteria andIsshelvesNotIn(List<Integer> values) {
            addCriterion("isShelves not in", values, "isshelves");
            return (Criteria) this;
        }

        public Criteria andIsshelvesBetween(Integer value1, Integer value2) {
            addCriterion("isShelves between", value1, value2, "isshelves");
            return (Criteria) this;
        }

        public Criteria andIsshelvesNotBetween(Integer value1, Integer value2) {
            addCriterion("isShelves not between", value1, value2, "isshelves");
            return (Criteria) this;
        }

        public Criteria andShelvesdateIsNull() {
            addCriterion("shelvesDate is null");
            return (Criteria) this;
        }

        public Criteria andShelvesdateIsNotNull() {
            addCriterion("shelvesDate is not null");
            return (Criteria) this;
        }

        public Criteria andShelvesdateEqualTo(Date value) {
            addCriterion("shelvesDate =", value, "shelvesdate");
            return (Criteria) this;
        }

        public Criteria andShelvesdateNotEqualTo(Date value) {
            addCriterion("shelvesDate <>", value, "shelvesdate");
            return (Criteria) this;
        }

        public Criteria andShelvesdateGreaterThan(Date value) {
            addCriterion("shelvesDate >", value, "shelvesdate");
            return (Criteria) this;
        }

        public Criteria andShelvesdateGreaterThanOrEqualTo(Date value) {
            addCriterion("shelvesDate >=", value, "shelvesdate");
            return (Criteria) this;
        }

        public Criteria andShelvesdateLessThan(Date value) {
            addCriterion("shelvesDate <", value, "shelvesdate");
            return (Criteria) this;
        }

        public Criteria andShelvesdateLessThanOrEqualTo(Date value) {
            addCriterion("shelvesDate <=", value, "shelvesdate");
            return (Criteria) this;
        }

        public Criteria andShelvesdateIn(List<Date> values) {
            addCriterion("shelvesDate in", values, "shelvesdate");
            return (Criteria) this;
        }

        public Criteria andShelvesdateNotIn(List<Date> values) {
            addCriterion("shelvesDate not in", values, "shelvesdate");
            return (Criteria) this;
        }

        public Criteria andShelvesdateBetween(Date value1, Date value2) {
            addCriterion("shelvesDate between", value1, value2, "shelvesdate");
            return (Criteria) this;
        }

        public Criteria andShelvesdateNotBetween(Date value1, Date value2) {
            addCriterion("shelvesDate not between", value1, value2, "shelvesdate");
            return (Criteria) this;
        }

        public Criteria andGoodsintegralIsNull() {
            addCriterion("goodsIntegral is null");
            return (Criteria) this;
        }

        public Criteria andGoodsintegralIsNotNull() {
            addCriterion("goodsIntegral is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsintegralEqualTo(Long value) {
            addCriterion("goodsIntegral =", value, "goodsintegral");
            return (Criteria) this;
        }

        public Criteria andGoodsintegralNotEqualTo(Long value) {
            addCriterion("goodsIntegral <>", value, "goodsintegral");
            return (Criteria) this;
        }

        public Criteria andGoodsintegralGreaterThan(Long value) {
            addCriterion("goodsIntegral >", value, "goodsintegral");
            return (Criteria) this;
        }

        public Criteria andGoodsintegralGreaterThanOrEqualTo(Long value) {
            addCriterion("goodsIntegral >=", value, "goodsintegral");
            return (Criteria) this;
        }

        public Criteria andGoodsintegralLessThan(Long value) {
            addCriterion("goodsIntegral <", value, "goodsintegral");
            return (Criteria) this;
        }

        public Criteria andGoodsintegralLessThanOrEqualTo(Long value) {
            addCriterion("goodsIntegral <=", value, "goodsintegral");
            return (Criteria) this;
        }

        public Criteria andGoodsintegralIn(List<Long> values) {
            addCriterion("goodsIntegral in", values, "goodsintegral");
            return (Criteria) this;
        }

        public Criteria andGoodsintegralNotIn(List<Long> values) {
            addCriterion("goodsIntegral not in", values, "goodsintegral");
            return (Criteria) this;
        }

        public Criteria andGoodsintegralBetween(Long value1, Long value2) {
            addCriterion("goodsIntegral between", value1, value2, "goodsintegral");
            return (Criteria) this;
        }

        public Criteria andGoodsintegralNotBetween(Long value1, Long value2) {
            addCriterion("goodsIntegral not between", value1, value2, "goodsintegral");
            return (Criteria) this;
        }

        public Criteria andMarketpriceIsNull() {
            addCriterion("marketPrice is null");
            return (Criteria) this;
        }

        public Criteria andMarketpriceIsNotNull() {
            addCriterion("marketPrice is not null");
            return (Criteria) this;
        }

        public Criteria andMarketpriceEqualTo(Double value) {
            addCriterion("marketPrice =", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceNotEqualTo(Double value) {
            addCriterion("marketPrice <>", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceGreaterThan(Double value) {
            addCriterion("marketPrice >", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("marketPrice >=", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceLessThan(Double value) {
            addCriterion("marketPrice <", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceLessThanOrEqualTo(Double value) {
            addCriterion("marketPrice <=", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceIn(List<Double> values) {
            addCriterion("marketPrice in", values, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceNotIn(List<Double> values) {
            addCriterion("marketPrice not in", values, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceBetween(Double value1, Double value2) {
            addCriterion("marketPrice between", value1, value2, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketpriceNotBetween(Double value1, Double value2) {
            addCriterion("marketPrice not between", value1, value2, "marketprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceIsNull() {
            addCriterion("payPrice is null");
            return (Criteria) this;
        }

        public Criteria andPaypriceIsNotNull() {
            addCriterion("payPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPaypriceEqualTo(Double value) {
            addCriterion("payPrice =", value, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceNotEqualTo(Double value) {
            addCriterion("payPrice <>", value, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceGreaterThan(Double value) {
            addCriterion("payPrice >", value, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceGreaterThanOrEqualTo(Double value) {
            addCriterion("payPrice >=", value, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceLessThan(Double value) {
            addCriterion("payPrice <", value, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceLessThanOrEqualTo(Double value) {
            addCriterion("payPrice <=", value, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceIn(List<Double> values) {
            addCriterion("payPrice in", values, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceNotIn(List<Double> values) {
            addCriterion("payPrice not in", values, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceBetween(Double value1, Double value2) {
            addCriterion("payPrice between", value1, value2, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceNotBetween(Double value1, Double value2) {
            addCriterion("payPrice not between", value1, value2, "payprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceIsNull() {
            addCriterion("costPrice is null");
            return (Criteria) this;
        }

        public Criteria andCostpriceIsNotNull() {
            addCriterion("costPrice is not null");
            return (Criteria) this;
        }

        public Criteria andCostpriceEqualTo(Double value) {
            addCriterion("costPrice =", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceNotEqualTo(Double value) {
            addCriterion("costPrice <>", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceGreaterThan(Double value) {
            addCriterion("costPrice >", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("costPrice >=", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceLessThan(Double value) {
            addCriterion("costPrice <", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceLessThanOrEqualTo(Double value) {
            addCriterion("costPrice <=", value, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceIn(List<Double> values) {
            addCriterion("costPrice in", values, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceNotIn(List<Double> values) {
            addCriterion("costPrice not in", values, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceBetween(Double value1, Double value2) {
            addCriterion("costPrice between", value1, value2, "costprice");
            return (Criteria) this;
        }

        public Criteria andCostpriceNotBetween(Double value1, Double value2) {
            addCriterion("costPrice not between", value1, value2, "costprice");
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

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
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

        public Criteria andIsdeleteEqualTo(Integer value) {
            addCriterion("isDelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Integer value) {
            addCriterion("isDelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Integer value) {
            addCriterion("isDelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isDelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Integer value) {
            addCriterion("isDelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("isDelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Integer> values) {
            addCriterion("isDelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Integer> values) {
            addCriterion("isDelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("isDelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("isDelete not between", value1, value2, "isdelete");
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

        public Criteria andOther4IsNull() {
            addCriterion("other4 is null");
            return (Criteria) this;
        }

        public Criteria andOther4IsNotNull() {
            addCriterion("other4 is not null");
            return (Criteria) this;
        }

        public Criteria andOther4EqualTo(String value) {
            addCriterion("other4 =", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotEqualTo(String value) {
            addCriterion("other4 <>", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4GreaterThan(String value) {
            addCriterion("other4 >", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4GreaterThanOrEqualTo(String value) {
            addCriterion("other4 >=", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4LessThan(String value) {
            addCriterion("other4 <", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4LessThanOrEqualTo(String value) {
            addCriterion("other4 <=", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4Like(String value) {
            addCriterion("other4 like", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotLike(String value) {
            addCriterion("other4 not like", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4In(List<String> values) {
            addCriterion("other4 in", values, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotIn(List<String> values) {
            addCriterion("other4 not in", values, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4Between(String value1, String value2) {
            addCriterion("other4 between", value1, value2, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotBetween(String value1, String value2) {
            addCriterion("other4 not between", value1, value2, "other4");
            return (Criteria) this;
        }

        public Criteria andOther5IsNull() {
            addCriterion("other5 is null");
            return (Criteria) this;
        }

        public Criteria andOther5IsNotNull() {
            addCriterion("other5 is not null");
            return (Criteria) this;
        }

        public Criteria andOther5EqualTo(String value) {
            addCriterion("other5 =", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5NotEqualTo(String value) {
            addCriterion("other5 <>", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5GreaterThan(String value) {
            addCriterion("other5 >", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5GreaterThanOrEqualTo(String value) {
            addCriterion("other5 >=", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5LessThan(String value) {
            addCriterion("other5 <", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5LessThanOrEqualTo(String value) {
            addCriterion("other5 <=", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5Like(String value) {
            addCriterion("other5 like", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5NotLike(String value) {
            addCriterion("other5 not like", value, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5In(List<String> values) {
            addCriterion("other5 in", values, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5NotIn(List<String> values) {
            addCriterion("other5 not in", values, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5Between(String value1, String value2) {
            addCriterion("other5 between", value1, value2, "other5");
            return (Criteria) this;
        }

        public Criteria andOther5NotBetween(String value1, String value2) {
            addCriterion("other5 not between", value1, value2, "other5");
            return (Criteria) this;
        }

        public Criteria andOther6IsNull() {
            addCriterion("other6 is null");
            return (Criteria) this;
        }

        public Criteria andOther6IsNotNull() {
            addCriterion("other6 is not null");
            return (Criteria) this;
        }

        public Criteria andOther6EqualTo(String value) {
            addCriterion("other6 =", value, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6NotEqualTo(String value) {
            addCriterion("other6 <>", value, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6GreaterThan(String value) {
            addCriterion("other6 >", value, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6GreaterThanOrEqualTo(String value) {
            addCriterion("other6 >=", value, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6LessThan(String value) {
            addCriterion("other6 <", value, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6LessThanOrEqualTo(String value) {
            addCriterion("other6 <=", value, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6Like(String value) {
            addCriterion("other6 like", value, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6NotLike(String value) {
            addCriterion("other6 not like", value, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6In(List<String> values) {
            addCriterion("other6 in", values, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6NotIn(List<String> values) {
            addCriterion("other6 not in", values, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6Between(String value1, String value2) {
            addCriterion("other6 between", value1, value2, "other6");
            return (Criteria) this;
        }

        public Criteria andOther6NotBetween(String value1, String value2) {
            addCriterion("other6 not between", value1, value2, "other6");
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