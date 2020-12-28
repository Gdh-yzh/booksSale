package com.wyu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BorrowExample() {
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

        public Criteria andBorrownumberIsNull() {
            addCriterion("borrowNumber is null");
            return (Criteria) this;
        }

        public Criteria andBorrownumberIsNotNull() {
            addCriterion("borrowNumber is not null");
            return (Criteria) this;
        }

        public Criteria andBorrownumberEqualTo(String value) {
            addCriterion("borrowNumber =", value, "borrownumber");
            return (Criteria) this;
        }

        public Criteria andBorrownumberNotEqualTo(String value) {
            addCriterion("borrowNumber <>", value, "borrownumber");
            return (Criteria) this;
        }

        public Criteria andBorrownumberGreaterThan(String value) {
            addCriterion("borrowNumber >", value, "borrownumber");
            return (Criteria) this;
        }

        public Criteria andBorrownumberGreaterThanOrEqualTo(String value) {
            addCriterion("borrowNumber >=", value, "borrownumber");
            return (Criteria) this;
        }

        public Criteria andBorrownumberLessThan(String value) {
            addCriterion("borrowNumber <", value, "borrownumber");
            return (Criteria) this;
        }

        public Criteria andBorrownumberLessThanOrEqualTo(String value) {
            addCriterion("borrowNumber <=", value, "borrownumber");
            return (Criteria) this;
        }

        public Criteria andBorrownumberLike(String value) {
            addCriterion("borrowNumber like", value, "borrownumber");
            return (Criteria) this;
        }

        public Criteria andBorrownumberNotLike(String value) {
            addCriterion("borrowNumber not like", value, "borrownumber");
            return (Criteria) this;
        }

        public Criteria andBorrownumberIn(List<String> values) {
            addCriterion("borrowNumber in", values, "borrownumber");
            return (Criteria) this;
        }

        public Criteria andBorrownumberNotIn(List<String> values) {
            addCriterion("borrowNumber not in", values, "borrownumber");
            return (Criteria) this;
        }

        public Criteria andBorrownumberBetween(String value1, String value2) {
            addCriterion("borrowNumber between", value1, value2, "borrownumber");
            return (Criteria) this;
        }

        public Criteria andBorrownumberNotBetween(String value1, String value2) {
            addCriterion("borrowNumber not between", value1, value2, "borrownumber");
            return (Criteria) this;
        }

        public Criteria andBooknumberIsNull() {
            addCriterion("bookNumber is null");
            return (Criteria) this;
        }

        public Criteria andBooknumberIsNotNull() {
            addCriterion("bookNumber is not null");
            return (Criteria) this;
        }

        public Criteria andBooknumberEqualTo(String value) {
            addCriterion("bookNumber =", value, "booknumber");
            return (Criteria) this;
        }

        public Criteria andBooknumberNotEqualTo(String value) {
            addCriterion("bookNumber <>", value, "booknumber");
            return (Criteria) this;
        }

        public Criteria andBooknumberGreaterThan(String value) {
            addCriterion("bookNumber >", value, "booknumber");
            return (Criteria) this;
        }

        public Criteria andBooknumberGreaterThanOrEqualTo(String value) {
            addCriterion("bookNumber >=", value, "booknumber");
            return (Criteria) this;
        }

        public Criteria andBooknumberLessThan(String value) {
            addCriterion("bookNumber <", value, "booknumber");
            return (Criteria) this;
        }

        public Criteria andBooknumberLessThanOrEqualTo(String value) {
            addCriterion("bookNumber <=", value, "booknumber");
            return (Criteria) this;
        }

        public Criteria andBooknumberLike(String value) {
            addCriterion("bookNumber like", value, "booknumber");
            return (Criteria) this;
        }

        public Criteria andBooknumberNotLike(String value) {
            addCriterion("bookNumber not like", value, "booknumber");
            return (Criteria) this;
        }

        public Criteria andBooknumberIn(List<String> values) {
            addCriterion("bookNumber in", values, "booknumber");
            return (Criteria) this;
        }

        public Criteria andBooknumberNotIn(List<String> values) {
            addCriterion("bookNumber not in", values, "booknumber");
            return (Criteria) this;
        }

        public Criteria andBooknumberBetween(String value1, String value2) {
            addCriterion("bookNumber between", value1, value2, "booknumber");
            return (Criteria) this;
        }

        public Criteria andBooknumberNotBetween(String value1, String value2) {
            addCriterion("bookNumber not between", value1, value2, "booknumber");
            return (Criteria) this;
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

        public Criteria andBorrowdateIsNull() {
            addCriterion("borrowDate is null");
            return (Criteria) this;
        }

        public Criteria andBorrowdateIsNotNull() {
            addCriterion("borrowDate is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowdateEqualTo(Date value) {
            addCriterion("borrowDate =", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotEqualTo(Date value) {
            addCriterion("borrowDate <>", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateGreaterThan(Date value) {
            addCriterion("borrowDate >", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateGreaterThanOrEqualTo(Date value) {
            addCriterion("borrowDate >=", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateLessThan(Date value) {
            addCriterion("borrowDate <", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateLessThanOrEqualTo(Date value) {
            addCriterion("borrowDate <=", value, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateIn(List<Date> values) {
            addCriterion("borrowDate in", values, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotIn(List<Date> values) {
            addCriterion("borrowDate not in", values, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateBetween(Date value1, Date value2) {
            addCriterion("borrowDate between", value1, value2, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andBorrowdateNotBetween(Date value1, Date value2) {
            addCriterion("borrowDate not between", value1, value2, "borrowdate");
            return (Criteria) this;
        }

        public Criteria andReturndateIsNull() {
            addCriterion("returnDate is null");
            return (Criteria) this;
        }

        public Criteria andReturndateIsNotNull() {
            addCriterion("returnDate is not null");
            return (Criteria) this;
        }

        public Criteria andReturndateEqualTo(Date value) {
            addCriterion("returnDate =", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateNotEqualTo(Date value) {
            addCriterion("returnDate <>", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateGreaterThan(Date value) {
            addCriterion("returnDate >", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateGreaterThanOrEqualTo(Date value) {
            addCriterion("returnDate >=", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateLessThan(Date value) {
            addCriterion("returnDate <", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateLessThanOrEqualTo(Date value) {
            addCriterion("returnDate <=", value, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateIn(List<Date> values) {
            addCriterion("returnDate in", values, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateNotIn(List<Date> values) {
            addCriterion("returnDate not in", values, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateBetween(Date value1, Date value2) {
            addCriterion("returnDate between", value1, value2, "returndate");
            return (Criteria) this;
        }

        public Criteria andReturndateNotBetween(Date value1, Date value2) {
            addCriterion("returnDate not between", value1, value2, "returndate");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusnumberIsNull() {
            addCriterion("borrowStatusNumber is null");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusnumberIsNotNull() {
            addCriterion("borrowStatusNumber is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusnumberEqualTo(Integer value) {
            addCriterion("borrowStatusNumber =", value, "borrowstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusnumberNotEqualTo(Integer value) {
            addCriterion("borrowStatusNumber <>", value, "borrowstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusnumberGreaterThan(Integer value) {
            addCriterion("borrowStatusNumber >", value, "borrowstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrowStatusNumber >=", value, "borrowstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusnumberLessThan(Integer value) {
            addCriterion("borrowStatusNumber <", value, "borrowstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusnumberLessThanOrEqualTo(Integer value) {
            addCriterion("borrowStatusNumber <=", value, "borrowstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusnumberIn(List<Integer> values) {
            addCriterion("borrowStatusNumber in", values, "borrowstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusnumberNotIn(List<Integer> values) {
            addCriterion("borrowStatusNumber not in", values, "borrowstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusnumberBetween(Integer value1, Integer value2) {
            addCriterion("borrowStatusNumber between", value1, value2, "borrowstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBorrowstatusnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("borrowStatusNumber not between", value1, value2, "borrowstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBorrowingstimesIsNull() {
            addCriterion("borrowingsTimes is null");
            return (Criteria) this;
        }

        public Criteria andBorrowingstimesIsNotNull() {
            addCriterion("borrowingsTimes is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowingstimesEqualTo(Integer value) {
            addCriterion("borrowingsTimes =", value, "borrowingstimes");
            return (Criteria) this;
        }

        public Criteria andBorrowingstimesNotEqualTo(Integer value) {
            addCriterion("borrowingsTimes <>", value, "borrowingstimes");
            return (Criteria) this;
        }

        public Criteria andBorrowingstimesGreaterThan(Integer value) {
            addCriterion("borrowingsTimes >", value, "borrowingstimes");
            return (Criteria) this;
        }

        public Criteria andBorrowingstimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrowingsTimes >=", value, "borrowingstimes");
            return (Criteria) this;
        }

        public Criteria andBorrowingstimesLessThan(Integer value) {
            addCriterion("borrowingsTimes <", value, "borrowingstimes");
            return (Criteria) this;
        }

        public Criteria andBorrowingstimesLessThanOrEqualTo(Integer value) {
            addCriterion("borrowingsTimes <=", value, "borrowingstimes");
            return (Criteria) this;
        }

        public Criteria andBorrowingstimesIn(List<Integer> values) {
            addCriterion("borrowingsTimes in", values, "borrowingstimes");
            return (Criteria) this;
        }

        public Criteria andBorrowingstimesNotIn(List<Integer> values) {
            addCriterion("borrowingsTimes not in", values, "borrowingstimes");
            return (Criteria) this;
        }

        public Criteria andBorrowingstimesBetween(Integer value1, Integer value2) {
            addCriterion("borrowingsTimes between", value1, value2, "borrowingstimes");
            return (Criteria) this;
        }

        public Criteria andBorrowingstimesNotBetween(Integer value1, Integer value2) {
            addCriterion("borrowingsTimes not between", value1, value2, "borrowingstimes");
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