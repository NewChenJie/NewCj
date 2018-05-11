package com.cj.domain.oamysql;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AliNewCustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AliNewCustomerExample() {
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

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andOriginUrlIsNull() {
            addCriterion("origin_url is null");
            return (Criteria) this;
        }

        public Criteria andOriginUrlIsNotNull() {
            addCriterion("origin_url is not null");
            return (Criteria) this;
        }

        public Criteria andOriginUrlEqualTo(String value) {
            addCriterion("origin_url =", value, "originUrl");
            return (Criteria) this;
        }

        public Criteria andOriginUrlNotEqualTo(String value) {
            addCriterion("origin_url <>", value, "originUrl");
            return (Criteria) this;
        }

        public Criteria andOriginUrlGreaterThan(String value) {
            addCriterion("origin_url >", value, "originUrl");
            return (Criteria) this;
        }

        public Criteria andOriginUrlGreaterThanOrEqualTo(String value) {
            addCriterion("origin_url >=", value, "originUrl");
            return (Criteria) this;
        }

        public Criteria andOriginUrlLessThan(String value) {
            addCriterion("origin_url <", value, "originUrl");
            return (Criteria) this;
        }

        public Criteria andOriginUrlLessThanOrEqualTo(String value) {
            addCriterion("origin_url <=", value, "originUrl");
            return (Criteria) this;
        }

        public Criteria andOriginUrlLike(String value) {
            addCriterion("origin_url like", value, "originUrl");
            return (Criteria) this;
        }

        public Criteria andOriginUrlNotLike(String value) {
            addCriterion("origin_url not like", value, "originUrl");
            return (Criteria) this;
        }

        public Criteria andOriginUrlIn(List<String> values) {
            addCriterion("origin_url in", values, "originUrl");
            return (Criteria) this;
        }

        public Criteria andOriginUrlNotIn(List<String> values) {
            addCriterion("origin_url not in", values, "originUrl");
            return (Criteria) this;
        }

        public Criteria andOriginUrlBetween(String value1, String value2) {
            addCriterion("origin_url between", value1, value2, "originUrl");
            return (Criteria) this;
        }

        public Criteria andOriginUrlNotBetween(String value1, String value2) {
            addCriterion("origin_url not between", value1, value2, "originUrl");
            return (Criteria) this;
        }

        public Criteria andAliUrlIsNull() {
            addCriterion("ali_url is null");
            return (Criteria) this;
        }

        public Criteria andAliUrlIsNotNull() {
            addCriterion("ali_url is not null");
            return (Criteria) this;
        }

        public Criteria andAliUrlEqualTo(String value) {
            addCriterion("ali_url =", value, "aliUrl");
            return (Criteria) this;
        }

        public Criteria andAliUrlNotEqualTo(String value) {
            addCriterion("ali_url <>", value, "aliUrl");
            return (Criteria) this;
        }

        public Criteria andAliUrlGreaterThan(String value) {
            addCriterion("ali_url >", value, "aliUrl");
            return (Criteria) this;
        }

        public Criteria andAliUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ali_url >=", value, "aliUrl");
            return (Criteria) this;
        }

        public Criteria andAliUrlLessThan(String value) {
            addCriterion("ali_url <", value, "aliUrl");
            return (Criteria) this;
        }

        public Criteria andAliUrlLessThanOrEqualTo(String value) {
            addCriterion("ali_url <=", value, "aliUrl");
            return (Criteria) this;
        }

        public Criteria andAliUrlLike(String value) {
            addCriterion("ali_url like", value, "aliUrl");
            return (Criteria) this;
        }

        public Criteria andAliUrlNotLike(String value) {
            addCriterion("ali_url not like", value, "aliUrl");
            return (Criteria) this;
        }

        public Criteria andAliUrlIn(List<String> values) {
            addCriterion("ali_url in", values, "aliUrl");
            return (Criteria) this;
        }

        public Criteria andAliUrlNotIn(List<String> values) {
            addCriterion("ali_url not in", values, "aliUrl");
            return (Criteria) this;
        }

        public Criteria andAliUrlBetween(String value1, String value2) {
            addCriterion("ali_url between", value1, value2, "aliUrl");
            return (Criteria) this;
        }

        public Criteria andAliUrlNotBetween(String value1, String value2) {
            addCriterion("ali_url not between", value1, value2, "aliUrl");
            return (Criteria) this;
        }

        public Criteria andGmtIdentificationIsNull() {
            addCriterion("gmt_identification is null");
            return (Criteria) this;
        }

        public Criteria andGmtIdentificationIsNotNull() {
            addCriterion("gmt_identification is not null");
            return (Criteria) this;
        }

        public Criteria andGmtIdentificationEqualTo(String value) {
            addCriterion("gmt_identification =", value, "gmtIdentification");
            return (Criteria) this;
        }

        public Criteria andGmtIdentificationNotEqualTo(String value) {
            addCriterion("gmt_identification <>", value, "gmtIdentification");
            return (Criteria) this;
        }

        public Criteria andGmtIdentificationGreaterThan(String value) {
            addCriterion("gmt_identification >", value, "gmtIdentification");
            return (Criteria) this;
        }

        public Criteria andGmtIdentificationGreaterThanOrEqualTo(String value) {
            addCriterion("gmt_identification >=", value, "gmtIdentification");
            return (Criteria) this;
        }

        public Criteria andGmtIdentificationLessThan(String value) {
            addCriterion("gmt_identification <", value, "gmtIdentification");
            return (Criteria) this;
        }

        public Criteria andGmtIdentificationLessThanOrEqualTo(String value) {
            addCriterion("gmt_identification <=", value, "gmtIdentification");
            return (Criteria) this;
        }

        public Criteria andGmtIdentificationLike(String value) {
            addCriterion("gmt_identification like", value, "gmtIdentification");
            return (Criteria) this;
        }

        public Criteria andGmtIdentificationNotLike(String value) {
            addCriterion("gmt_identification not like", value, "gmtIdentification");
            return (Criteria) this;
        }

        public Criteria andGmtIdentificationIn(List<String> values) {
            addCriterion("gmt_identification in", values, "gmtIdentification");
            return (Criteria) this;
        }

        public Criteria andGmtIdentificationNotIn(List<String> values) {
            addCriterion("gmt_identification not in", values, "gmtIdentification");
            return (Criteria) this;
        }

        public Criteria andGmtIdentificationBetween(String value1, String value2) {
            addCriterion("gmt_identification between", value1, value2, "gmtIdentification");
            return (Criteria) this;
        }

        public Criteria andGmtIdentificationNotBetween(String value1, String value2) {
            addCriterion("gmt_identification not between", value1, value2, "gmtIdentification");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andMianbusinessIsNull() {
            addCriterion("mianbusiness is null");
            return (Criteria) this;
        }

        public Criteria andMianbusinessIsNotNull() {
            addCriterion("mianbusiness is not null");
            return (Criteria) this;
        }

        public Criteria andMianbusinessEqualTo(String value) {
            addCriterion("mianbusiness =", value, "mianbusiness");
            return (Criteria) this;
        }

        public Criteria andMianbusinessNotEqualTo(String value) {
            addCriterion("mianbusiness <>", value, "mianbusiness");
            return (Criteria) this;
        }

        public Criteria andMianbusinessGreaterThan(String value) {
            addCriterion("mianbusiness >", value, "mianbusiness");
            return (Criteria) this;
        }

        public Criteria andMianbusinessGreaterThanOrEqualTo(String value) {
            addCriterion("mianbusiness >=", value, "mianbusiness");
            return (Criteria) this;
        }

        public Criteria andMianbusinessLessThan(String value) {
            addCriterion("mianbusiness <", value, "mianbusiness");
            return (Criteria) this;
        }

        public Criteria andMianbusinessLessThanOrEqualTo(String value) {
            addCriterion("mianbusiness <=", value, "mianbusiness");
            return (Criteria) this;
        }

        public Criteria andMianbusinessLike(String value) {
            addCriterion("mianbusiness like", value, "mianbusiness");
            return (Criteria) this;
        }

        public Criteria andMianbusinessNotLike(String value) {
            addCriterion("mianbusiness not like", value, "mianbusiness");
            return (Criteria) this;
        }

        public Criteria andMianbusinessIn(List<String> values) {
            addCriterion("mianbusiness in", values, "mianbusiness");
            return (Criteria) this;
        }

        public Criteria andMianbusinessNotIn(List<String> values) {
            addCriterion("mianbusiness not in", values, "mianbusiness");
            return (Criteria) this;
        }

        public Criteria andMianbusinessBetween(String value1, String value2) {
            addCriterion("mianbusiness between", value1, value2, "mianbusiness");
            return (Criteria) this;
        }

        public Criteria andMianbusinessNotBetween(String value1, String value2) {
            addCriterion("mianbusiness not between", value1, value2, "mianbusiness");
            return (Criteria) this;
        }

        public Criteria andGmtGetIsNull() {
            addCriterion("gmt_get is null");
            return (Criteria) this;
        }

        public Criteria andGmtGetIsNotNull() {
            addCriterion("gmt_get is not null");
            return (Criteria) this;
        }

        public Criteria andGmtGetEqualTo(String value) {
            addCriterion("gmt_get =", value, "gmtGet");
            return (Criteria) this;
        }

        public Criteria andGmtGetNotEqualTo(String value) {
            addCriterion("gmt_get <>", value, "gmtGet");
            return (Criteria) this;
        }

        public Criteria andGmtGetGreaterThan(String value) {
            addCriterion("gmt_get >", value, "gmtGet");
            return (Criteria) this;
        }

        public Criteria andGmtGetGreaterThanOrEqualTo(String value) {
            addCriterion("gmt_get >=", value, "gmtGet");
            return (Criteria) this;
        }

        public Criteria andGmtGetLessThan(String value) {
            addCriterion("gmt_get <", value, "gmtGet");
            return (Criteria) this;
        }

        public Criteria andGmtGetLessThanOrEqualTo(String value) {
            addCriterion("gmt_get <=", value, "gmtGet");
            return (Criteria) this;
        }

        public Criteria andGmtGetLike(String value) {
            addCriterion("gmt_get like", value, "gmtGet");
            return (Criteria) this;
        }

        public Criteria andGmtGetNotLike(String value) {
            addCriterion("gmt_get not like", value, "gmtGet");
            return (Criteria) this;
        }

        public Criteria andGmtGetIn(List<String> values) {
            addCriterion("gmt_get in", values, "gmtGet");
            return (Criteria) this;
        }

        public Criteria andGmtGetNotIn(List<String> values) {
            addCriterion("gmt_get not in", values, "gmtGet");
            return (Criteria) this;
        }

        public Criteria andGmtGetBetween(String value1, String value2) {
            addCriterion("gmt_get between", value1, value2, "gmtGet");
            return (Criteria) this;
        }

        public Criteria andGmtGetNotBetween(String value1, String value2) {
            addCriterion("gmt_get not between", value1, value2, "gmtGet");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }
    }

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