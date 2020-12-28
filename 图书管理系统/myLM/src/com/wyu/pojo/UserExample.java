package com.wyu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUsernumberIsNull() {
            addCriterion("userNumber is null");
            return (Criteria) this;
        }

        public Criteria andUsernumberIsNotNull() {
            addCriterion("userNumber is not null");
            return (Criteria) this;
        }

        public Criteria andUsernumberEqualTo(String value) {
            addCriterion("userNumber =", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberNotEqualTo(String value) {
            addCriterion("userNumber <>", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberGreaterThan(String value) {
            addCriterion("userNumber >", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberGreaterThanOrEqualTo(String value) {
            addCriterion("userNumber >=", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberLessThan(String value) {
            addCriterion("userNumber <", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberLessThanOrEqualTo(String value) {
            addCriterion("userNumber <=", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberLike(String value) {
            addCriterion("userNumber like", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberNotLike(String value) {
            addCriterion("userNumber not like", value, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberIn(List<String> values) {
            addCriterion("userNumber in", values, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberNotIn(List<String> values) {
            addCriterion("userNumber not in", values, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberBetween(String value1, String value2) {
            addCriterion("userNumber between", value1, value2, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernumberNotBetween(String value1, String value2) {
            addCriterion("userNumber not between", value1, value2, "usernumber");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
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

        public Criteria andUserstatusnumberIsNull() {
            addCriterion("userStatusNumber is null");
            return (Criteria) this;
        }

        public Criteria andUserstatusnumberIsNotNull() {
            addCriterion("userStatusNumber is not null");
            return (Criteria) this;
        }

        public Criteria andUserstatusnumberEqualTo(Integer value) {
            addCriterion("userStatusNumber =", value, "userstatusnumber");
            return (Criteria) this;
        }

        public Criteria andUserstatusnumberNotEqualTo(Integer value) {
            addCriterion("userStatusNumber <>", value, "userstatusnumber");
            return (Criteria) this;
        }

        public Criteria andUserstatusnumberGreaterThan(Integer value) {
            addCriterion("userStatusNumber >", value, "userstatusnumber");
            return (Criteria) this;
        }

        public Criteria andUserstatusnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("userStatusNumber >=", value, "userstatusnumber");
            return (Criteria) this;
        }

        public Criteria andUserstatusnumberLessThan(Integer value) {
            addCriterion("userStatusNumber <", value, "userstatusnumber");
            return (Criteria) this;
        }

        public Criteria andUserstatusnumberLessThanOrEqualTo(Integer value) {
            addCriterion("userStatusNumber <=", value, "userstatusnumber");
            return (Criteria) this;
        }

        public Criteria andUserstatusnumberIn(List<Integer> values) {
            addCriterion("userStatusNumber in", values, "userstatusnumber");
            return (Criteria) this;
        }

        public Criteria andUserstatusnumberNotIn(List<Integer> values) {
            addCriterion("userStatusNumber not in", values, "userstatusnumber");
            return (Criteria) this;
        }

        public Criteria andUserstatusnumberBetween(Integer value1, Integer value2) {
            addCriterion("userStatusNumber between", value1, value2, "userstatusnumber");
            return (Criteria) this;
        }

        public Criteria andUserstatusnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("userStatusNumber not between", value1, value2, "userstatusnumber");
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

        public Criteria andRoldnumberIsNull() {
            addCriterion("roldNumber is null");
            return (Criteria) this;
        }

        public Criteria andRoldnumberIsNotNull() {
            addCriterion("roldNumber is not null");
            return (Criteria) this;
        }

        public Criteria andRoldnumberEqualTo(Integer value) {
            addCriterion("roldNumber =", value, "roldnumber");
            return (Criteria) this;
        }

        public Criteria andRoldnumberNotEqualTo(Integer value) {
            addCriterion("roldNumber <>", value, "roldnumber");
            return (Criteria) this;
        }

        public Criteria andRoldnumberGreaterThan(Integer value) {
            addCriterion("roldNumber >", value, "roldnumber");
            return (Criteria) this;
        }

        public Criteria andRoldnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("roldNumber >=", value, "roldnumber");
            return (Criteria) this;
        }

        public Criteria andRoldnumberLessThan(Integer value) {
            addCriterion("roldNumber <", value, "roldnumber");
            return (Criteria) this;
        }

        public Criteria andRoldnumberLessThanOrEqualTo(Integer value) {
            addCriterion("roldNumber <=", value, "roldnumber");
            return (Criteria) this;
        }

        public Criteria andRoldnumberIn(List<Integer> values) {
            addCriterion("roldNumber in", values, "roldnumber");
            return (Criteria) this;
        }

        public Criteria andRoldnumberNotIn(List<Integer> values) {
            addCriterion("roldNumber not in", values, "roldnumber");
            return (Criteria) this;
        }

        public Criteria andRoldnumberBetween(Integer value1, Integer value2) {
            addCriterion("roldNumber between", value1, value2, "roldnumber");
            return (Criteria) this;
        }

        public Criteria andRoldnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("roldNumber not between", value1, value2, "roldnumber");
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