package com.hndl.cn.dao.system.bean;

import java.util.ArrayList;
import java.util.List;

public class TPortalKeytDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public TPortalKeytDoExample() {
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

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appId is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appId is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appId =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appId <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appId >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appId >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appId <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appId <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appId like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appId not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appId in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appId not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appId between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appId not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andChannelidIsNull() {
            addCriterion("channelId is null");
            return (Criteria) this;
        }

        public Criteria andChannelidIsNotNull() {
            addCriterion("channelId is not null");
            return (Criteria) this;
        }

        public Criteria andChannelidEqualTo(String value) {
            addCriterion("channelId =", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotEqualTo(String value) {
            addCriterion("channelId <>", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidGreaterThan(String value) {
            addCriterion("channelId >", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidGreaterThanOrEqualTo(String value) {
            addCriterion("channelId >=", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidLessThan(String value) {
            addCriterion("channelId <", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidLessThanOrEqualTo(String value) {
            addCriterion("channelId <=", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidLike(String value) {
            addCriterion("channelId like", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotLike(String value) {
            addCriterion("channelId not like", value, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidIn(List<String> values) {
            addCriterion("channelId in", values, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotIn(List<String> values) {
            addCriterion("channelId not in", values, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidBetween(String value1, String value2) {
            addCriterion("channelId between", value1, value2, "channelid");
            return (Criteria) this;
        }

        public Criteria andChannelidNotBetween(String value1, String value2) {
            addCriterion("channelId not between", value1, value2, "channelid");
            return (Criteria) this;
        }

        public Criteria andNodetypeIsNull() {
            addCriterion("nodeType is null");
            return (Criteria) this;
        }

        public Criteria andNodetypeIsNotNull() {
            addCriterion("nodeType is not null");
            return (Criteria) this;
        }

        public Criteria andNodetypeEqualTo(String value) {
            addCriterion("nodeType =", value, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeNotEqualTo(String value) {
            addCriterion("nodeType <>", value, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeGreaterThan(String value) {
            addCriterion("nodeType >", value, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeGreaterThanOrEqualTo(String value) {
            addCriterion("nodeType >=", value, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeLessThan(String value) {
            addCriterion("nodeType <", value, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeLessThanOrEqualTo(String value) {
            addCriterion("nodeType <=", value, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeLike(String value) {
            addCriterion("nodeType like", value, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeNotLike(String value) {
            addCriterion("nodeType not like", value, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeIn(List<String> values) {
            addCriterion("nodeType in", values, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeNotIn(List<String> values) {
            addCriterion("nodeType not in", values, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeBetween(String value1, String value2) {
            addCriterion("nodeType between", value1, value2, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeNotBetween(String value1, String value2) {
            addCriterion("nodeType not between", value1, value2, "nodetype");
            return (Criteria) this;
        }

        public Criteria andSysdateIsNull() {
            addCriterion("`sysDate` is null");
            return (Criteria) this;
        }

        public Criteria andSysdateIsNotNull() {
            addCriterion("`sysDate` is not null");
            return (Criteria) this;
        }

        public Criteria andSysdateEqualTo(String value) {
            addCriterion("`sysDate` =", value, "sysdate");
            return (Criteria) this;
        }

        public Criteria andSysdateNotEqualTo(String value) {
            addCriterion("`sysDate` <>", value, "sysdate");
            return (Criteria) this;
        }

        public Criteria andSysdateGreaterThan(String value) {
            addCriterion("`sysDate` >", value, "sysdate");
            return (Criteria) this;
        }

        public Criteria andSysdateGreaterThanOrEqualTo(String value) {
            addCriterion("`sysDate` >=", value, "sysdate");
            return (Criteria) this;
        }

        public Criteria andSysdateLessThan(String value) {
            addCriterion("`sysDate` <", value, "sysdate");
            return (Criteria) this;
        }

        public Criteria andSysdateLessThanOrEqualTo(String value) {
            addCriterion("`sysDate` <=", value, "sysdate");
            return (Criteria) this;
        }

        public Criteria andSysdateLike(String value) {
            addCriterion("`sysDate` like", value, "sysdate");
            return (Criteria) this;
        }

        public Criteria andSysdateNotLike(String value) {
            addCriterion("`sysDate` not like", value, "sysdate");
            return (Criteria) this;
        }

        public Criteria andSysdateIn(List<String> values) {
            addCriterion("`sysDate` in", values, "sysdate");
            return (Criteria) this;
        }

        public Criteria andSysdateNotIn(List<String> values) {
            addCriterion("`sysDate` not in", values, "sysdate");
            return (Criteria) this;
        }

        public Criteria andSysdateBetween(String value1, String value2) {
            addCriterion("`sysDate` between", value1, value2, "sysdate");
            return (Criteria) this;
        }

        public Criteria andSysdateNotBetween(String value1, String value2) {
            addCriterion("`sysDate` not between", value1, value2, "sysdate");
            return (Criteria) this;
        }

        public Criteria andRetkeyIsNull() {
            addCriterion("retKey is null");
            return (Criteria) this;
        }

        public Criteria andRetkeyIsNotNull() {
            addCriterion("retKey is not null");
            return (Criteria) this;
        }

        public Criteria andRetkeyEqualTo(String value) {
            addCriterion("retKey =", value, "retkey");
            return (Criteria) this;
        }

        public Criteria andRetkeyNotEqualTo(String value) {
            addCriterion("retKey <>", value, "retkey");
            return (Criteria) this;
        }

        public Criteria andRetkeyGreaterThan(String value) {
            addCriterion("retKey >", value, "retkey");
            return (Criteria) this;
        }

        public Criteria andRetkeyGreaterThanOrEqualTo(String value) {
            addCriterion("retKey >=", value, "retkey");
            return (Criteria) this;
        }

        public Criteria andRetkeyLessThan(String value) {
            addCriterion("retKey <", value, "retkey");
            return (Criteria) this;
        }

        public Criteria andRetkeyLessThanOrEqualTo(String value) {
            addCriterion("retKey <=", value, "retkey");
            return (Criteria) this;
        }

        public Criteria andRetkeyLike(String value) {
            addCriterion("retKey like", value, "retkey");
            return (Criteria) this;
        }

        public Criteria andRetkeyNotLike(String value) {
            addCriterion("retKey not like", value, "retkey");
            return (Criteria) this;
        }

        public Criteria andRetkeyIn(List<String> values) {
            addCriterion("retKey in", values, "retkey");
            return (Criteria) this;
        }

        public Criteria andRetkeyNotIn(List<String> values) {
            addCriterion("retKey not in", values, "retkey");
            return (Criteria) this;
        }

        public Criteria andRetkeyBetween(String value1, String value2) {
            addCriterion("retKey between", value1, value2, "retkey");
            return (Criteria) this;
        }

        public Criteria andRetkeyNotBetween(String value1, String value2) {
            addCriterion("retKey not between", value1, value2, "retkey");
            return (Criteria) this;
        }

        public Criteria andRetmsgIsNull() {
            addCriterion("retMsg is null");
            return (Criteria) this;
        }

        public Criteria andRetmsgIsNotNull() {
            addCriterion("retMsg is not null");
            return (Criteria) this;
        }

        public Criteria andRetmsgEqualTo(String value) {
            addCriterion("retMsg =", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgNotEqualTo(String value) {
            addCriterion("retMsg <>", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgGreaterThan(String value) {
            addCriterion("retMsg >", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgGreaterThanOrEqualTo(String value) {
            addCriterion("retMsg >=", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgLessThan(String value) {
            addCriterion("retMsg <", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgLessThanOrEqualTo(String value) {
            addCriterion("retMsg <=", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgLike(String value) {
            addCriterion("retMsg like", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgNotLike(String value) {
            addCriterion("retMsg not like", value, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgIn(List<String> values) {
            addCriterion("retMsg in", values, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgNotIn(List<String> values) {
            addCriterion("retMsg not in", values, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgBetween(String value1, String value2) {
            addCriterion("retMsg between", value1, value2, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetmsgNotBetween(String value1, String value2) {
            addCriterion("retMsg not between", value1, value2, "retmsg");
            return (Criteria) this;
        }

        public Criteria andRetcodeIsNull() {
            addCriterion("retCode is null");
            return (Criteria) this;
        }

        public Criteria andRetcodeIsNotNull() {
            addCriterion("retCode is not null");
            return (Criteria) this;
        }

        public Criteria andRetcodeEqualTo(String value) {
            addCriterion("retCode =", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeNotEqualTo(String value) {
            addCriterion("retCode <>", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeGreaterThan(String value) {
            addCriterion("retCode >", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeGreaterThanOrEqualTo(String value) {
            addCriterion("retCode >=", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeLessThan(String value) {
            addCriterion("retCode <", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeLessThanOrEqualTo(String value) {
            addCriterion("retCode <=", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeLike(String value) {
            addCriterion("retCode like", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeNotLike(String value) {
            addCriterion("retCode not like", value, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeIn(List<String> values) {
            addCriterion("retCode in", values, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeNotIn(List<String> values) {
            addCriterion("retCode not in", values, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeBetween(String value1, String value2) {
            addCriterion("retCode between", value1, value2, "retcode");
            return (Criteria) this;
        }

        public Criteria andRetcodeNotBetween(String value1, String value2) {
            addCriterion("retCode not between", value1, value2, "retcode");
            return (Criteria) this;
        }

        public Criteria andSysIsNull() {
            addCriterion("sys is null");
            return (Criteria) this;
        }

        public Criteria andSysIsNotNull() {
            addCriterion("sys is not null");
            return (Criteria) this;
        }

        public Criteria andSysEqualTo(String value) {
            addCriterion("sys =", value, "sys");
            return (Criteria) this;
        }

        public Criteria andSysNotEqualTo(String value) {
            addCriterion("sys <>", value, "sys");
            return (Criteria) this;
        }

        public Criteria andSysGreaterThan(String value) {
            addCriterion("sys >", value, "sys");
            return (Criteria) this;
        }

        public Criteria andSysGreaterThanOrEqualTo(String value) {
            addCriterion("sys >=", value, "sys");
            return (Criteria) this;
        }

        public Criteria andSysLessThan(String value) {
            addCriterion("sys <", value, "sys");
            return (Criteria) this;
        }

        public Criteria andSysLessThanOrEqualTo(String value) {
            addCriterion("sys <=", value, "sys");
            return (Criteria) this;
        }

        public Criteria andSysLike(String value) {
            addCriterion("sys like", value, "sys");
            return (Criteria) this;
        }

        public Criteria andSysNotLike(String value) {
            addCriterion("sys not like", value, "sys");
            return (Criteria) this;
        }

        public Criteria andSysIn(List<String> values) {
            addCriterion("sys in", values, "sys");
            return (Criteria) this;
        }

        public Criteria andSysNotIn(List<String> values) {
            addCriterion("sys not in", values, "sys");
            return (Criteria) this;
        }

        public Criteria andSysBetween(String value1, String value2) {
            addCriterion("sys between", value1, value2, "sys");
            return (Criteria) this;
        }

        public Criteria andSysNotBetween(String value1, String value2) {
            addCriterion("sys not between", value1, value2, "sys");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andHtmlkeyIsNull() {
            addCriterion("htmlKey is null");
            return (Criteria) this;
        }

        public Criteria andHtmlkeyIsNotNull() {
            addCriterion("htmlKey is not null");
            return (Criteria) this;
        }

        public Criteria andHtmlkeyEqualTo(String value) {
            addCriterion("htmlKey =", value, "htmlkey");
            return (Criteria) this;
        }

        public Criteria andHtmlkeyNotEqualTo(String value) {
            addCriterion("htmlKey <>", value, "htmlkey");
            return (Criteria) this;
        }

        public Criteria andHtmlkeyGreaterThan(String value) {
            addCriterion("htmlKey >", value, "htmlkey");
            return (Criteria) this;
        }

        public Criteria andHtmlkeyGreaterThanOrEqualTo(String value) {
            addCriterion("htmlKey >=", value, "htmlkey");
            return (Criteria) this;
        }

        public Criteria andHtmlkeyLessThan(String value) {
            addCriterion("htmlKey <", value, "htmlkey");
            return (Criteria) this;
        }

        public Criteria andHtmlkeyLessThanOrEqualTo(String value) {
            addCriterion("htmlKey <=", value, "htmlkey");
            return (Criteria) this;
        }

        public Criteria andHtmlkeyLike(String value) {
            addCriterion("htmlKey like", value, "htmlkey");
            return (Criteria) this;
        }

        public Criteria andHtmlkeyNotLike(String value) {
            addCriterion("htmlKey not like", value, "htmlkey");
            return (Criteria) this;
        }

        public Criteria andHtmlkeyIn(List<String> values) {
            addCriterion("htmlKey in", values, "htmlkey");
            return (Criteria) this;
        }

        public Criteria andHtmlkeyNotIn(List<String> values) {
            addCriterion("htmlKey not in", values, "htmlkey");
            return (Criteria) this;
        }

        public Criteria andHtmlkeyBetween(String value1, String value2) {
            addCriterion("htmlKey between", value1, value2, "htmlkey");
            return (Criteria) this;
        }

        public Criteria andHtmlkeyNotBetween(String value1, String value2) {
            addCriterion("htmlKey not between", value1, value2, "htmlkey");
            return (Criteria) this;
        }

        public Criteria andSysversionIsNull() {
            addCriterion("sysVersion is null");
            return (Criteria) this;
        }

        public Criteria andSysversionIsNotNull() {
            addCriterion("sysVersion is not null");
            return (Criteria) this;
        }

        public Criteria andSysversionEqualTo(String value) {
            addCriterion("sysVersion =", value, "sysversion");
            return (Criteria) this;
        }

        public Criteria andSysversionNotEqualTo(String value) {
            addCriterion("sysVersion <>", value, "sysversion");
            return (Criteria) this;
        }

        public Criteria andSysversionGreaterThan(String value) {
            addCriterion("sysVersion >", value, "sysversion");
            return (Criteria) this;
        }

        public Criteria andSysversionGreaterThanOrEqualTo(String value) {
            addCriterion("sysVersion >=", value, "sysversion");
            return (Criteria) this;
        }

        public Criteria andSysversionLessThan(String value) {
            addCriterion("sysVersion <", value, "sysversion");
            return (Criteria) this;
        }

        public Criteria andSysversionLessThanOrEqualTo(String value) {
            addCriterion("sysVersion <=", value, "sysversion");
            return (Criteria) this;
        }

        public Criteria andSysversionLike(String value) {
            addCriterion("sysVersion like", value, "sysversion");
            return (Criteria) this;
        }

        public Criteria andSysversionNotLike(String value) {
            addCriterion("sysVersion not like", value, "sysversion");
            return (Criteria) this;
        }

        public Criteria andSysversionIn(List<String> values) {
            addCriterion("sysVersion in", values, "sysversion");
            return (Criteria) this;
        }

        public Criteria andSysversionNotIn(List<String> values) {
            addCriterion("sysVersion not in", values, "sysversion");
            return (Criteria) this;
        }

        public Criteria andSysversionBetween(String value1, String value2) {
            addCriterion("sysVersion between", value1, value2, "sysversion");
            return (Criteria) this;
        }

        public Criteria andSysversionNotBetween(String value1, String value2) {
            addCriterion("sysVersion not between", value1, value2, "sysversion");
            return (Criteria) this;
        }

        public Criteria andImeiIsNull() {
            addCriterion("imei is null");
            return (Criteria) this;
        }

        public Criteria andImeiIsNotNull() {
            addCriterion("imei is not null");
            return (Criteria) this;
        }

        public Criteria andImeiEqualTo(String value) {
            addCriterion("imei =", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotEqualTo(String value) {
            addCriterion("imei <>", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiGreaterThan(String value) {
            addCriterion("imei >", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiGreaterThanOrEqualTo(String value) {
            addCriterion("imei >=", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLessThan(String value) {
            addCriterion("imei <", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLessThanOrEqualTo(String value) {
            addCriterion("imei <=", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiLike(String value) {
            addCriterion("imei like", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotLike(String value) {
            addCriterion("imei not like", value, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiIn(List<String> values) {
            addCriterion("imei in", values, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotIn(List<String> values) {
            addCriterion("imei not in", values, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiBetween(String value1, String value2) {
            addCriterion("imei between", value1, value2, "imei");
            return (Criteria) this;
        }

        public Criteria andImeiNotBetween(String value1, String value2) {
            addCriterion("imei not between", value1, value2, "imei");
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