package com.wyu.pojo;

import java.util.ArrayList;
import java.util.List;

public class TypeReaderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TypeReaderExample() {
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

        public Criteria andReadertypeIsNull() {
            addCriterion("readerType is null");
            return (Criteria) this;
        }

        public Criteria andReadertypeIsNotNull() {
            addCriterion("readerType is not null");
            return (Criteria) this;
        }

        public Criteria andReadertypeEqualTo(String value) {
            addCriterion("readerType =", value, "readertype");
            return (Criteria) this;
        }

        public Criteria andReadertypeNotEqualTo(String value) {
            addCriterion("readerType <>", value, "readertype");
            return (Criteria) this;
        }

        public Criteria andReadertypeGreaterThan(String value) {
            addCriterion("readerType >", value, "readertype");
            return (Criteria) this;
        }

        public Criteria andReadertypeGreaterThanOrEqualTo(String value) {
            addCriterion("readerType >=", value, "readertype");
            return (Criteria) this;
        }

        public Criteria andReadertypeLessThan(String value) {
            addCriterion("readerType <", value, "readertype");
            return (Criteria) this;
        }

        public Criteria andReadertypeLessThanOrEqualTo(String value) {
            addCriterion("readerType <=", value, "readertype");
            return (Criteria) this;
        }

        public Criteria andReadertypeLike(String value) {
            addCriterion("readerType like", value, "readertype");
            return (Criteria) this;
        }

        public Criteria andReadertypeNotLike(String value) {
            addCriterion("readerType not like", value, "readertype");
            return (Criteria) this;
        }

        public Criteria andReadertypeIn(List<String> values) {
            addCriterion("readerType in", values, "readertype");
            return (Criteria) this;
        }

        public Criteria andReadertypeNotIn(List<String> values) {
            addCriterion("readerType not in", values, "readertype");
            return (Criteria) this;
        }

        public Criteria andReadertypeBetween(String value1, String value2) {
            addCriterion("readerType between", value1, value2, "readertype");
            return (Criteria) this;
        }

        public Criteria andReadertypeNotBetween(String value1, String value2) {
            addCriterion("readerType not between", value1, value2, "readertype");
            return (Criteria) this;
        }

        public Criteria andBorrowamountIsNull() {
            addCriterion("borrowAmount is null");
            return (Criteria) this;
        }

        public Criteria andBorrowamountIsNotNull() {
            addCriterion("borrowAmount is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowamountEqualTo(Integer value) {
            addCriterion("borrowAmount =", value, "borrowamount");
            return (Criteria) this;
        }

        public Criteria andBorrowamountNotEqualTo(Integer value) {
            addCriterion("borrowAmount <>", value, "borrowamount");
            return (Criteria) this;
        }

        public Criteria andBorrowamountGreaterThan(Integer value) {
            addCriterion("borrowAmount >", value, "borrowamount");
            return (Criteria) this;
        }

        public Criteria andBorrowamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrowAmount >=", value, "borrowamount");
            return (Criteria) this;
        }

        public Criteria andBorrowamountLessThan(Integer value) {
            addCriterion("borrowAmount <", value, "borrowamount");
            return (Criteria) this;
        }

        public Criteria andBorrowamountLessThanOrEqualTo(Integer value) {
            addCriterion("borrowAmount <=", value, "borrowamount");
            return (Criteria) this;
        }

        public Criteria andBorrowamountIn(List<Integer> values) {
            addCriterion("borrowAmount in", values, "borrowamount");
            return (Criteria) this;
        }

        public Criteria andBorrowamountNotIn(List<Integer> values) {
            addCriterion("borrowAmount not in", values, "borrowamount");
            return (Criteria) this;
        }

        public Criteria andBorrowamountBetween(Integer value1, Integer value2) {
            addCriterion("borrowAmount between", value1, value2, "borrowamount");
            return (Criteria) this;
        }

        public Criteria andBorrowamountNotBetween(Integer value1, Integer value2) {
            addCriterion("borrowAmount not between", value1, value2, "borrowamount");
            return (Criteria) this;
        }

        public Criteria andBorrowdaysIsNull() {
            addCriterion("borrowDays is null");
            return (Criteria) this;
        }

        public Criteria andBorrowdaysIsNotNull() {
            addCriterion("borrowDays is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowdaysEqualTo(Integer value) {
            addCriterion("borrowDays =", value, "borrowdays");
            return (Criteria) this;
        }

        public Criteria andBorrowdaysNotEqualTo(Integer value) {
            addCriterion("borrowDays <>", value, "borrowdays");
            return (Criteria) this;
        }

        public Criteria andBorrowdaysGreaterThan(Integer value) {
            addCriterion("borrowDays >", value, "borrowdays");
            return (Criteria) this;
        }

        public Criteria andBorrowdaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrowDays >=", value, "borrowdays");
            return (Criteria) this;
        }

        public Criteria andBorrowdaysLessThan(Integer value) {
            addCriterion("borrowDays <", value, "borrowdays");
            return (Criteria) this;
        }

        public Criteria andBorrowdaysLessThanOrEqualTo(Integer value) {
            addCriterion("borrowDays <=", value, "borrowdays");
            return (Criteria) this;
        }

        public Criteria andBorrowdaysIn(List<Integer> values) {
            addCriterion("borrowDays in", values, "borrowdays");
            return (Criteria) this;
        }

        public Criteria andBorrowdaysNotIn(List<Integer> values) {
            addCriterion("borrowDays not in", values, "borrowdays");
            return (Criteria) this;
        }

        public Criteria andBorrowdaysBetween(Integer value1, Integer value2) {
            addCriterion("borrowDays between", value1, value2, "borrowdays");
            return (Criteria) this;
        }

        public Criteria andBorrowdaysNotBetween(Integer value1, Integer value2) {
            addCriterion("borrowDays not between", value1, value2, "borrowdays");
            return (Criteria) this;
        }

        public Criteria andRenewtimestimesIsNull() {
            addCriterion("renewTimesTimes is null");
            return (Criteria) this;
        }

        public Criteria andRenewtimestimesIsNotNull() {
            addCriterion("renewTimesTimes is not null");
            return (Criteria) this;
        }

        public Criteria andRenewtimestimesEqualTo(Integer value) {
            addCriterion("renewTimesTimes =", value, "renewtimestimes");
            return (Criteria) this;
        }

        public Criteria andRenewtimestimesNotEqualTo(Integer value) {
            addCriterion("renewTimesTimes <>", value, "renewtimestimes");
            return (Criteria) this;
        }

        public Criteria andRenewtimestimesGreaterThan(Integer value) {
            addCriterion("renewTimesTimes >", value, "renewtimestimes");
            return (Criteria) this;
        }

        public Criteria andRenewtimestimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("renewTimesTimes >=", value, "renewtimestimes");
            return (Criteria) this;
        }

        public Criteria andRenewtimestimesLessThan(Integer value) {
            addCriterion("renewTimesTimes <", value, "renewtimestimes");
            return (Criteria) this;
        }

        public Criteria andRenewtimestimesLessThanOrEqualTo(Integer value) {
            addCriterion("renewTimesTimes <=", value, "renewtimestimes");
            return (Criteria) this;
        }

        public Criteria andRenewtimestimesIn(List<Integer> values) {
            addCriterion("renewTimesTimes in", values, "renewtimestimes");
            return (Criteria) this;
        }

        public Criteria andRenewtimestimesNotIn(List<Integer> values) {
            addCriterion("renewTimesTimes not in", values, "renewtimestimes");
            return (Criteria) this;
        }

        public Criteria andRenewtimestimesBetween(Integer value1, Integer value2) {
            addCriterion("renewTimesTimes between", value1, value2, "renewtimestimes");
            return (Criteria) this;
        }

        public Criteria andRenewtimestimesNotBetween(Integer value1, Integer value2) {
            addCriterion("renewTimesTimes not between", value1, value2, "renewtimestimes");
            return (Criteria) this;
        }

        public Criteria andRenewdaysIsNull() {
            addCriterion("renewDays is null");
            return (Criteria) this;
        }

        public Criteria andRenewdaysIsNotNull() {
            addCriterion("renewDays is not null");
            return (Criteria) this;
        }

        public Criteria andRenewdaysEqualTo(Integer value) {
            addCriterion("renewDays =", value, "renewdays");
            return (Criteria) this;
        }

        public Criteria andRenewdaysNotEqualTo(Integer value) {
            addCriterion("renewDays <>", value, "renewdays");
            return (Criteria) this;
        }

        public Criteria andRenewdaysGreaterThan(Integer value) {
            addCriterion("renewDays >", value, "renewdays");
            return (Criteria) this;
        }

        public Criteria andRenewdaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("renewDays >=", value, "renewdays");
            return (Criteria) this;
        }

        public Criteria andRenewdaysLessThan(Integer value) {
            addCriterion("renewDays <", value, "renewdays");
            return (Criteria) this;
        }

        public Criteria andRenewdaysLessThanOrEqualTo(Integer value) {
            addCriterion("renewDays <=", value, "renewdays");
            return (Criteria) this;
        }

        public Criteria andRenewdaysIn(List<Integer> values) {
            addCriterion("renewDays in", values, "renewdays");
            return (Criteria) this;
        }

        public Criteria andRenewdaysNotIn(List<Integer> values) {
            addCriterion("renewDays not in", values, "renewdays");
            return (Criteria) this;
        }

        public Criteria andRenewdaysBetween(Integer value1, Integer value2) {
            addCriterion("renewDays between", value1, value2, "renewdays");
            return (Criteria) this;
        }

        public Criteria andRenewdaysNotBetween(Integer value1, Integer value2) {
            addCriterion("renewDays not between", value1, value2, "renewdays");
            return (Criteria) this;
        }

        public Criteria andRenewamountIsNull() {
            addCriterion("renewAmount is null");
            return (Criteria) this;
        }

        public Criteria andRenewamountIsNotNull() {
            addCriterion("renewAmount is not null");
            return (Criteria) this;
        }

        public Criteria andRenewamountEqualTo(Integer value) {
            addCriterion("renewAmount =", value, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountNotEqualTo(Integer value) {
            addCriterion("renewAmount <>", value, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountGreaterThan(Integer value) {
            addCriterion("renewAmount >", value, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("renewAmount >=", value, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountLessThan(Integer value) {
            addCriterion("renewAmount <", value, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountLessThanOrEqualTo(Integer value) {
            addCriterion("renewAmount <=", value, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountIn(List<Integer> values) {
            addCriterion("renewAmount in", values, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountNotIn(List<Integer> values) {
            addCriterion("renewAmount not in", values, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountBetween(Integer value1, Integer value2) {
            addCriterion("renewAmount between", value1, value2, "renewamount");
            return (Criteria) this;
        }

        public Criteria andRenewamountNotBetween(Integer value1, Integer value2) {
            addCriterion("renewAmount not between", value1, value2, "renewamount");
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