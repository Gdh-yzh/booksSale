package com.wyu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReaderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReaderExample() {
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

        public Criteria andReadernumberIsNull() {
            addCriterion("readerNumber is null");
            return (Criteria) this;
        }

        public Criteria andReadernumberIsNotNull() {
            addCriterion("readerNumber is not null");
            return (Criteria) this;
        }

        public Criteria andReadernumberEqualTo(String value) {
            addCriterion("readerNumber =", value, "readernumber");
            return (Criteria) this;
        }

        public Criteria andReadernumberNotEqualTo(String value) {
            addCriterion("readerNumber <>", value, "readernumber");
            return (Criteria) this;
        }

        public Criteria andReadernumberGreaterThan(String value) {
            addCriterion("readerNumber >", value, "readernumber");
            return (Criteria) this;
        }

        public Criteria andReadernumberGreaterThanOrEqualTo(String value) {
            addCriterion("readerNumber >=", value, "readernumber");
            return (Criteria) this;
        }

        public Criteria andReadernumberLessThan(String value) {
            addCriterion("readerNumber <", value, "readernumber");
            return (Criteria) this;
        }

        public Criteria andReadernumberLessThanOrEqualTo(String value) {
            addCriterion("readerNumber <=", value, "readernumber");
            return (Criteria) this;
        }

        public Criteria andReadernumberLike(String value) {
            addCriterion("readerNumber like", value, "readernumber");
            return (Criteria) this;
        }

        public Criteria andReadernumberNotLike(String value) {
            addCriterion("readerNumber not like", value, "readernumber");
            return (Criteria) this;
        }

        public Criteria andReadernumberIn(List<String> values) {
            addCriterion("readerNumber in", values, "readernumber");
            return (Criteria) this;
        }

        public Criteria andReadernumberNotIn(List<String> values) {
            addCriterion("readerNumber not in", values, "readernumber");
            return (Criteria) this;
        }

        public Criteria andReadernumberBetween(String value1, String value2) {
            addCriterion("readerNumber between", value1, value2, "readernumber");
            return (Criteria) this;
        }

        public Criteria andReadernumberNotBetween(String value1, String value2) {
            addCriterion("readerNumber not between", value1, value2, "readernumber");
            return (Criteria) this;
        }

        public Criteria andReadernameIsNull() {
            addCriterion("readerName is null");
            return (Criteria) this;
        }

        public Criteria andReadernameIsNotNull() {
            addCriterion("readerName is not null");
            return (Criteria) this;
        }

        public Criteria andReadernameEqualTo(String value) {
            addCriterion("readerName =", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameNotEqualTo(String value) {
            addCriterion("readerName <>", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameGreaterThan(String value) {
            addCriterion("readerName >", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameGreaterThanOrEqualTo(String value) {
            addCriterion("readerName >=", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameLessThan(String value) {
            addCriterion("readerName <", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameLessThanOrEqualTo(String value) {
            addCriterion("readerName <=", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameLike(String value) {
            addCriterion("readerName like", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameNotLike(String value) {
            addCriterion("readerName not like", value, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameIn(List<String> values) {
            addCriterion("readerName in", values, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameNotIn(List<String> values) {
            addCriterion("readerName not in", values, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameBetween(String value1, String value2) {
            addCriterion("readerName between", value1, value2, "readername");
            return (Criteria) this;
        }

        public Criteria andReadernameNotBetween(String value1, String value2) {
            addCriterion("readerName not between", value1, value2, "readername");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateIsNull() {
            addCriterion("registrationDate is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateIsNotNull() {
            addCriterion("registrationDate is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateEqualTo(Date value) {
            addCriterion("registrationDate =", value, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateNotEqualTo(Date value) {
            addCriterion("registrationDate <>", value, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateGreaterThan(Date value) {
            addCriterion("registrationDate >", value, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateGreaterThanOrEqualTo(Date value) {
            addCriterion("registrationDate >=", value, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateLessThan(Date value) {
            addCriterion("registrationDate <", value, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateLessThanOrEqualTo(Date value) {
            addCriterion("registrationDate <=", value, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateIn(List<Date> values) {
            addCriterion("registrationDate in", values, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateNotIn(List<Date> values) {
            addCriterion("registrationDate not in", values, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateBetween(Date value1, Date value2) {
            addCriterion("registrationDate between", value1, value2, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateNotBetween(Date value1, Date value2) {
            addCriterion("registrationDate not between", value1, value2, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andExpirationdaysIsNull() {
            addCriterion("expirationDays is null");
            return (Criteria) this;
        }

        public Criteria andExpirationdaysIsNotNull() {
            addCriterion("expirationDays is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationdaysEqualTo(Integer value) {
            addCriterion("expirationDays =", value, "expirationdays");
            return (Criteria) this;
        }

        public Criteria andExpirationdaysNotEqualTo(Integer value) {
            addCriterion("expirationDays <>", value, "expirationdays");
            return (Criteria) this;
        }

        public Criteria andExpirationdaysGreaterThan(Integer value) {
            addCriterion("expirationDays >", value, "expirationdays");
            return (Criteria) this;
        }

        public Criteria andExpirationdaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("expirationDays >=", value, "expirationdays");
            return (Criteria) this;
        }

        public Criteria andExpirationdaysLessThan(Integer value) {
            addCriterion("expirationDays <", value, "expirationdays");
            return (Criteria) this;
        }

        public Criteria andExpirationdaysLessThanOrEqualTo(Integer value) {
            addCriterion("expirationDays <=", value, "expirationdays");
            return (Criteria) this;
        }

        public Criteria andExpirationdaysIn(List<Integer> values) {
            addCriterion("expirationDays in", values, "expirationdays");
            return (Criteria) this;
        }

        public Criteria andExpirationdaysNotIn(List<Integer> values) {
            addCriterion("expirationDays not in", values, "expirationdays");
            return (Criteria) this;
        }

        public Criteria andExpirationdaysBetween(Integer value1, Integer value2) {
            addCriterion("expirationDays between", value1, value2, "expirationdays");
            return (Criteria) this;
        }

        public Criteria andExpirationdaysNotBetween(Integer value1, Integer value2) {
            addCriterion("expirationDays not between", value1, value2, "expirationdays");
            return (Criteria) this;
        }

        public Criteria andReaderstatusnumberIsNull() {
            addCriterion("readerStatusNumber is null");
            return (Criteria) this;
        }

        public Criteria andReaderstatusnumberIsNotNull() {
            addCriterion("readerStatusNumber is not null");
            return (Criteria) this;
        }

        public Criteria andReaderstatusnumberEqualTo(Integer value) {
            addCriterion("readerStatusNumber =", value, "readerstatusnumber");
            return (Criteria) this;
        }

        public Criteria andReaderstatusnumberNotEqualTo(Integer value) {
            addCriterion("readerStatusNumber <>", value, "readerstatusnumber");
            return (Criteria) this;
        }

        public Criteria andReaderstatusnumberGreaterThan(Integer value) {
            addCriterion("readerStatusNumber >", value, "readerstatusnumber");
            return (Criteria) this;
        }

        public Criteria andReaderstatusnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("readerStatusNumber >=", value, "readerstatusnumber");
            return (Criteria) this;
        }

        public Criteria andReaderstatusnumberLessThan(Integer value) {
            addCriterion("readerStatusNumber <", value, "readerstatusnumber");
            return (Criteria) this;
        }

        public Criteria andReaderstatusnumberLessThanOrEqualTo(Integer value) {
            addCriterion("readerStatusNumber <=", value, "readerstatusnumber");
            return (Criteria) this;
        }

        public Criteria andReaderstatusnumberIn(List<Integer> values) {
            addCriterion("readerStatusNumber in", values, "readerstatusnumber");
            return (Criteria) this;
        }

        public Criteria andReaderstatusnumberNotIn(List<Integer> values) {
            addCriterion("readerStatusNumber not in", values, "readerstatusnumber");
            return (Criteria) this;
        }

        public Criteria andReaderstatusnumberBetween(Integer value1, Integer value2) {
            addCriterion("readerStatusNumber between", value1, value2, "readerstatusnumber");
            return (Criteria) this;
        }

        public Criteria andReaderstatusnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("readerStatusNumber not between", value1, value2, "readerstatusnumber");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andReadertypenumberIsNull() {
            addCriterion("readerTypeNumber is null");
            return (Criteria) this;
        }

        public Criteria andReadertypenumberIsNotNull() {
            addCriterion("readerTypeNumber is not null");
            return (Criteria) this;
        }

        public Criteria andReadertypenumberEqualTo(Integer value) {
            addCriterion("readerTypeNumber =", value, "readertypenumber");
            return (Criteria) this;
        }

        public Criteria andReadertypenumberNotEqualTo(Integer value) {
            addCriterion("readerTypeNumber <>", value, "readertypenumber");
            return (Criteria) this;
        }

        public Criteria andReadertypenumberGreaterThan(Integer value) {
            addCriterion("readerTypeNumber >", value, "readertypenumber");
            return (Criteria) this;
        }

        public Criteria andReadertypenumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("readerTypeNumber >=", value, "readertypenumber");
            return (Criteria) this;
        }

        public Criteria andReadertypenumberLessThan(Integer value) {
            addCriterion("readerTypeNumber <", value, "readertypenumber");
            return (Criteria) this;
        }

        public Criteria andReadertypenumberLessThanOrEqualTo(Integer value) {
            addCriterion("readerTypeNumber <=", value, "readertypenumber");
            return (Criteria) this;
        }

        public Criteria andReadertypenumberIn(List<Integer> values) {
            addCriterion("readerTypeNumber in", values, "readertypenumber");
            return (Criteria) this;
        }

        public Criteria andReadertypenumberNotIn(List<Integer> values) {
            addCriterion("readerTypeNumber not in", values, "readertypenumber");
            return (Criteria) this;
        }

        public Criteria andReadertypenumberBetween(Integer value1, Integer value2) {
            addCriterion("readerTypeNumber between", value1, value2, "readertypenumber");
            return (Criteria) this;
        }

        public Criteria andReadertypenumberNotBetween(Integer value1, Integer value2) {
            addCriterion("readerTypeNumber not between", value1, value2, "readertypenumber");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("endDate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("endDate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterion("endDate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterion("endDate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterion("endDate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterion("endDate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterion("endDate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterion("endDate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterion("endDate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterion("endDate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterion("endDate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterion("endDate not between", value1, value2, "enddate");
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