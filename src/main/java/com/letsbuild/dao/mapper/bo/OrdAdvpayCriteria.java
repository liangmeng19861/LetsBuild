package com.letsbuild.dao.mapper.bo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrdAdvpayCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public OrdAdvpayCriteria() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
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

        public Criteria andProjectCodeIsNull() {
            addCriterion("project_code is null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNotNull() {
            addCriterion("project_code is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeEqualTo(String value) {
            addCriterion("project_code =", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotEqualTo(String value) {
            addCriterion("project_code <>", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThan(String value) {
            addCriterion("project_code >", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_code >=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThan(String value) {
            addCriterion("project_code <", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThanOrEqualTo(String value) {
            addCriterion("project_code <=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLike(String value) {
            addCriterion("project_code like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotLike(String value) {
            addCriterion("project_code not like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIn(List<String> values) {
            addCriterion("project_code in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotIn(List<String> values) {
            addCriterion("project_code not in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeBetween(String value1, String value2) {
            addCriterion("project_code between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotBetween(String value1, String value2) {
            addCriterion("project_code not between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIsNull() {
            addCriterion("project_leader is null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIsNotNull() {
            addCriterion("project_leader is not null");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderEqualTo(Long value) {
            addCriterion("project_leader =", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotEqualTo(Long value) {
            addCriterion("project_leader <>", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderGreaterThan(Long value) {
            addCriterion("project_leader >", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderGreaterThanOrEqualTo(Long value) {
            addCriterion("project_leader >=", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLessThan(Long value) {
            addCriterion("project_leader <", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderLessThanOrEqualTo(Long value) {
            addCriterion("project_leader <=", value, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderIn(List<Long> values) {
            addCriterion("project_leader in", values, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotIn(List<Long> values) {
            addCriterion("project_leader not in", values, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderBetween(Long value1, Long value2) {
            addCriterion("project_leader between", value1, value2, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProjectLeaderNotBetween(Long value1, Long value2) {
            addCriterion("project_leader not between", value1, value2, "projectLeader");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("province_code is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("province_code is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("province_code =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("province_code <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("province_code >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("province_code >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("province_code <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("province_code <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("province_code like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("province_code not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("province_code in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("province_code not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("province_code between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("province_code not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("city_code is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("city_code is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("city_code =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("city_code <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("city_code >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_code >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("city_code <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("city_code <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("city_code like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("city_code not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("city_code in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("city_code not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("city_code between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("city_code not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andBrandCodeIsNull() {
            addCriterion("brand_code is null");
            return (Criteria) this;
        }

        public Criteria andBrandCodeIsNotNull() {
            addCriterion("brand_code is not null");
            return (Criteria) this;
        }

        public Criteria andBrandCodeEqualTo(String value) {
            addCriterion("brand_code =", value, "brandCode");
            return (Criteria) this;
        }

        public Criteria andBrandCodeNotEqualTo(String value) {
            addCriterion("brand_code <>", value, "brandCode");
            return (Criteria) this;
        }

        public Criteria andBrandCodeGreaterThan(String value) {
            addCriterion("brand_code >", value, "brandCode");
            return (Criteria) this;
        }

        public Criteria andBrandCodeGreaterThanOrEqualTo(String value) {
            addCriterion("brand_code >=", value, "brandCode");
            return (Criteria) this;
        }

        public Criteria andBrandCodeLessThan(String value) {
            addCriterion("brand_code <", value, "brandCode");
            return (Criteria) this;
        }

        public Criteria andBrandCodeLessThanOrEqualTo(String value) {
            addCriterion("brand_code <=", value, "brandCode");
            return (Criteria) this;
        }

        public Criteria andBrandCodeLike(String value) {
            addCriterion("brand_code like", value, "brandCode");
            return (Criteria) this;
        }

        public Criteria andBrandCodeNotLike(String value) {
            addCriterion("brand_code not like", value, "brandCode");
            return (Criteria) this;
        }

        public Criteria andBrandCodeIn(List<String> values) {
            addCriterion("brand_code in", values, "brandCode");
            return (Criteria) this;
        }

        public Criteria andBrandCodeNotIn(List<String> values) {
            addCriterion("brand_code not in", values, "brandCode");
            return (Criteria) this;
        }

        public Criteria andBrandCodeBetween(String value1, String value2) {
            addCriterion("brand_code between", value1, value2, "brandCode");
            return (Criteria) this;
        }

        public Criteria andBrandCodeNotBetween(String value1, String value2) {
            addCriterion("brand_code not between", value1, value2, "brandCode");
            return (Criteria) this;
        }

        public Criteria andMerchantIsNull() {
            addCriterion("merchant is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIsNotNull() {
            addCriterion("merchant is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantEqualTo(String value) {
            addCriterion("merchant =", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotEqualTo(String value) {
            addCriterion("merchant <>", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantGreaterThan(String value) {
            addCriterion("merchant >", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantGreaterThanOrEqualTo(String value) {
            addCriterion("merchant >=", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantLessThan(String value) {
            addCriterion("merchant <", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantLessThanOrEqualTo(String value) {
            addCriterion("merchant <=", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantLike(String value) {
            addCriterion("merchant like", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotLike(String value) {
            addCriterion("merchant not like", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantIn(List<String> values) {
            addCriterion("merchant in", values, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotIn(List<String> values) {
            addCriterion("merchant not in", values, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantBetween(String value1, String value2) {
            addCriterion("merchant between", value1, value2, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotBetween(String value1, String value2) {
            addCriterion("merchant not between", value1, value2, "merchant");
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

        public Criteria andContactName2IsNull() {
            addCriterion("contact_name2 is null");
            return (Criteria) this;
        }

        public Criteria andContactName2IsNotNull() {
            addCriterion("contact_name2 is not null");
            return (Criteria) this;
        }

        public Criteria andContactName2EqualTo(String value) {
            addCriterion("contact_name2 =", value, "contactName2");
            return (Criteria) this;
        }

        public Criteria andContactName2NotEqualTo(String value) {
            addCriterion("contact_name2 <>", value, "contactName2");
            return (Criteria) this;
        }

        public Criteria andContactName2GreaterThan(String value) {
            addCriterion("contact_name2 >", value, "contactName2");
            return (Criteria) this;
        }

        public Criteria andContactName2GreaterThanOrEqualTo(String value) {
            addCriterion("contact_name2 >=", value, "contactName2");
            return (Criteria) this;
        }

        public Criteria andContactName2LessThan(String value) {
            addCriterion("contact_name2 <", value, "contactName2");
            return (Criteria) this;
        }

        public Criteria andContactName2LessThanOrEqualTo(String value) {
            addCriterion("contact_name2 <=", value, "contactName2");
            return (Criteria) this;
        }

        public Criteria andContactName2Like(String value) {
            addCriterion("contact_name2 like", value, "contactName2");
            return (Criteria) this;
        }

        public Criteria andContactName2NotLike(String value) {
            addCriterion("contact_name2 not like", value, "contactName2");
            return (Criteria) this;
        }

        public Criteria andContactName2In(List<String> values) {
            addCriterion("contact_name2 in", values, "contactName2");
            return (Criteria) this;
        }

        public Criteria andContactName2NotIn(List<String> values) {
            addCriterion("contact_name2 not in", values, "contactName2");
            return (Criteria) this;
        }

        public Criteria andContactName2Between(String value1, String value2) {
            addCriterion("contact_name2 between", value1, value2, "contactName2");
            return (Criteria) this;
        }

        public Criteria andContactName2NotBetween(String value1, String value2) {
            addCriterion("contact_name2 not between", value1, value2, "contactName2");
            return (Criteria) this;
        }

        public Criteria andContactTel2IsNull() {
            addCriterion("contact_tel2 is null");
            return (Criteria) this;
        }

        public Criteria andContactTel2IsNotNull() {
            addCriterion("contact_tel2 is not null");
            return (Criteria) this;
        }

        public Criteria andContactTel2EqualTo(String value) {
            addCriterion("contact_tel2 =", value, "contactTel2");
            return (Criteria) this;
        }

        public Criteria andContactTel2NotEqualTo(String value) {
            addCriterion("contact_tel2 <>", value, "contactTel2");
            return (Criteria) this;
        }

        public Criteria andContactTel2GreaterThan(String value) {
            addCriterion("contact_tel2 >", value, "contactTel2");
            return (Criteria) this;
        }

        public Criteria andContactTel2GreaterThanOrEqualTo(String value) {
            addCriterion("contact_tel2 >=", value, "contactTel2");
            return (Criteria) this;
        }

        public Criteria andContactTel2LessThan(String value) {
            addCriterion("contact_tel2 <", value, "contactTel2");
            return (Criteria) this;
        }

        public Criteria andContactTel2LessThanOrEqualTo(String value) {
            addCriterion("contact_tel2 <=", value, "contactTel2");
            return (Criteria) this;
        }

        public Criteria andContactTel2Like(String value) {
            addCriterion("contact_tel2 like", value, "contactTel2");
            return (Criteria) this;
        }

        public Criteria andContactTel2NotLike(String value) {
            addCriterion("contact_tel2 not like", value, "contactTel2");
            return (Criteria) this;
        }

        public Criteria andContactTel2In(List<String> values) {
            addCriterion("contact_tel2 in", values, "contactTel2");
            return (Criteria) this;
        }

        public Criteria andContactTel2NotIn(List<String> values) {
            addCriterion("contact_tel2 not in", values, "contactTel2");
            return (Criteria) this;
        }

        public Criteria andContactTel2Between(String value1, String value2) {
            addCriterion("contact_tel2 between", value1, value2, "contactTel2");
            return (Criteria) this;
        }

        public Criteria andContactTel2NotBetween(String value1, String value2) {
            addCriterion("contact_tel2 not between", value1, value2, "contactTel2");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNull() {
            addCriterion("account_no is null");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNotNull() {
            addCriterion("account_no is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNoEqualTo(String value) {
            addCriterion("account_no =", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotEqualTo(String value) {
            addCriterion("account_no <>", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThan(String value) {
            addCriterion("account_no >", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("account_no >=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThan(String value) {
            addCriterion("account_no <", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThanOrEqualTo(String value) {
            addCriterion("account_no <=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLike(String value) {
            addCriterion("account_no like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotLike(String value) {
            addCriterion("account_no not like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoIn(List<String> values) {
            addCriterion("account_no in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotIn(List<String> values) {
            addCriterion("account_no not in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoBetween(String value1, String value2) {
            addCriterion("account_no between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotBetween(String value1, String value2) {
            addCriterion("account_no not between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNull() {
            addCriterion("account_name is null");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNotNull() {
            addCriterion("account_name is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNameEqualTo(String value) {
            addCriterion("account_name =", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotEqualTo(String value) {
            addCriterion("account_name <>", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThan(String value) {
            addCriterion("account_name >", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("account_name >=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThan(String value) {
            addCriterion("account_name <", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThanOrEqualTo(String value) {
            addCriterion("account_name <=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLike(String value) {
            addCriterion("account_name like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotLike(String value) {
            addCriterion("account_name not like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameIn(List<String> values) {
            addCriterion("account_name in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotIn(List<String> values) {
            addCriterion("account_name not in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameBetween(String value1, String value2) {
            addCriterion("account_name between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotBetween(String value1, String value2) {
            addCriterion("account_name not between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andOpenBankIsNull() {
            addCriterion("open_bank is null");
            return (Criteria) this;
        }

        public Criteria andOpenBankIsNotNull() {
            addCriterion("open_bank is not null");
            return (Criteria) this;
        }

        public Criteria andOpenBankEqualTo(String value) {
            addCriterion("open_bank =", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankNotEqualTo(String value) {
            addCriterion("open_bank <>", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankGreaterThan(String value) {
            addCriterion("open_bank >", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankGreaterThanOrEqualTo(String value) {
            addCriterion("open_bank >=", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankLessThan(String value) {
            addCriterion("open_bank <", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankLessThanOrEqualTo(String value) {
            addCriterion("open_bank <=", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankLike(String value) {
            addCriterion("open_bank like", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankNotLike(String value) {
            addCriterion("open_bank not like", value, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankIn(List<String> values) {
            addCriterion("open_bank in", values, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankNotIn(List<String> values) {
            addCriterion("open_bank not in", values, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankBetween(String value1, String value2) {
            addCriterion("open_bank between", value1, value2, "openBank");
            return (Criteria) this;
        }

        public Criteria andOpenBankNotBetween(String value1, String value2) {
            addCriterion("open_bank not between", value1, value2, "openBank");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("contact_name is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("contact_name =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("contact_name <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("contact_name >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_name >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("contact_name <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("contact_name <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("contact_name like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("contact_name not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("contact_name in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("contact_name not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("contact_name between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("contact_name not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNull() {
            addCriterion("contact_tel is null");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNotNull() {
            addCriterion("contact_tel is not null");
            return (Criteria) this;
        }

        public Criteria andContactTelEqualTo(String value) {
            addCriterion("contact_tel =", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotEqualTo(String value) {
            addCriterion("contact_tel <>", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThan(String value) {
            addCriterion("contact_tel >", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThanOrEqualTo(String value) {
            addCriterion("contact_tel >=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThan(String value) {
            addCriterion("contact_tel <", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThanOrEqualTo(String value) {
            addCriterion("contact_tel <=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLike(String value) {
            addCriterion("contact_tel like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotLike(String value) {
            addCriterion("contact_tel not like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelIn(List<String> values) {
            addCriterion("contact_tel in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotIn(List<String> values) {
            addCriterion("contact_tel not in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelBetween(String value1, String value2) {
            addCriterion("contact_tel between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotBetween(String value1, String value2) {
            addCriterion("contact_tel not between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeIsNull() {
            addCriterion("plan_return_time is null");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeIsNotNull() {
            addCriterion("plan_return_time is not null");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeEqualTo(Timestamp value) {
            addCriterion("plan_return_time =", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeNotEqualTo(Timestamp value) {
            addCriterion("plan_return_time <>", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeGreaterThan(Timestamp value) {
            addCriterion("plan_return_time >", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("plan_return_time >=", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeLessThan(Timestamp value) {
            addCriterion("plan_return_time <", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("plan_return_time <=", value, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeIn(List<Timestamp> values) {
            addCriterion("plan_return_time in", values, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeNotIn(List<Timestamp> values) {
            addCriterion("plan_return_time not in", values, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("plan_return_time between", value1, value2, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPlanReturnTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("plan_return_time not between", value1, value2, "planReturnTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Timestamp value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Timestamp value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Timestamp value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Timestamp value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Timestamp> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Timestamp> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayUserIsNull() {
            addCriterion("pay_user is null");
            return (Criteria) this;
        }

        public Criteria andPayUserIsNotNull() {
            addCriterion("pay_user is not null");
            return (Criteria) this;
        }

        public Criteria andPayUserEqualTo(Long value) {
            addCriterion("pay_user =", value, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserNotEqualTo(Long value) {
            addCriterion("pay_user <>", value, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserGreaterThan(Long value) {
            addCriterion("pay_user >", value, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_user >=", value, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserLessThan(Long value) {
            addCriterion("pay_user <", value, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserLessThanOrEqualTo(Long value) {
            addCriterion("pay_user <=", value, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserIn(List<Long> values) {
            addCriterion("pay_user in", values, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserNotIn(List<Long> values) {
            addCriterion("pay_user not in", values, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserBetween(Long value1, Long value2) {
            addCriterion("pay_user between", value1, value2, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayUserNotBetween(Long value1, Long value2) {
            addCriterion("pay_user not between", value1, value2, "payUser");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNull() {
            addCriterion("pay_amount is null");
            return (Criteria) this;
        }

        public Criteria andPayAmountIsNotNull() {
            addCriterion("pay_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmountEqualTo(Double value) {
            addCriterion("pay_amount =", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotEqualTo(Double value) {
            addCriterion("pay_amount <>", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThan(Double value) {
            addCriterion("pay_amount >", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("pay_amount >=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThan(Double value) {
            addCriterion("pay_amount <", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountLessThanOrEqualTo(Double value) {
            addCriterion("pay_amount <=", value, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountIn(List<Double> values) {
            addCriterion("pay_amount in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotIn(List<Double> values) {
            addCriterion("pay_amount not in", values, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountBetween(Double value1, Double value2) {
            addCriterion("pay_amount between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andPayAmountNotBetween(Double value1, Double value2) {
            addCriterion("pay_amount not between", value1, value2, "payAmount");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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