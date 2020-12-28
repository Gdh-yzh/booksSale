package com.wyu.pojo;

import java.util.ArrayList;
import java.util.List;

public class StatusBookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatusBookExample() {
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

        public Criteria andBookstatusnumberIsNull() {
            addCriterion("bookStatusNumber is null");
            return (Criteria) this;
        }

        public Criteria andBookstatusnumberIsNotNull() {
            addCriterion("bookStatusNumber is not null");
            return (Criteria) this;
        }

        public Criteria andBookstatusnumberEqualTo(Integer value) {
            addCriterion("bookStatusNumber =", value, "bookstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBookstatusnumberNotEqualTo(Integer value) {
            addCriterion("bookStatusNumber <>", value, "bookstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBookstatusnumberGreaterThan(Integer value) {
            addCriterion("bookStatusNumber >", value, "bookstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBookstatusnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("bookStatusNumber >=", value, "bookstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBookstatusnumberLessThan(Integer value) {
            addCriterion("bookStatusNumber <", value, "bookstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBookstatusnumberLessThanOrEqualTo(Integer value) {
            addCriterion("bookStatusNumber <=", value, "bookstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBookstatusnumberIn(List<Integer> values) {
            addCriterion("bookStatusNumber in", values, "bookstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBookstatusnumberNotIn(List<Integer> values) {
            addCriterion("bookStatusNumber not in", values, "bookstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBookstatusnumberBetween(Integer value1, Integer value2) {
            addCriterion("bookStatusNumber between", value1, value2, "bookstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBookstatusnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("bookStatusNumber not between", value1, value2, "bookstatusnumber");
            return (Criteria) this;
        }

        public Criteria andBookstatusIsNull() {
            addCriterion("bookStatus is null");
            return (Criteria) this;
        }

        public Criteria andBookstatusIsNotNull() {
            addCriterion("bookStatus is not null");
            return (Criteria) this;
        }

        public Criteria andBookstatusEqualTo(String value) {
            addCriterion("bookStatus =", value, "bookstatus");
            return (Criteria) this;
        }

        public Criteria andBookstatusNotEqualTo(String value) {
            addCriterion("bookStatus <>", value, "bookstatus");
            return (Criteria) this;
        }

        public Criteria andBookstatusGreaterThan(String value) {
            addCriterion("bookStatus >", value, "bookstatus");
            return (Criteria) this;
        }

        public Criteria andBookstatusGreaterThanOrEqualTo(String value) {
            addCriterion("bookStatus >=", value, "bookstatus");
            return (Criteria) this;
        }

        public Criteria andBookstatusLessThan(String value) {
            addCriterion("bookStatus <", value, "bookstatus");
            return (Criteria) this;
        }

        public Criteria andBookstatusLessThanOrEqualTo(String value) {
            addCriterion("bookStatus <=", value, "bookstatus");
            return (Criteria) this;
        }

        public Criteria andBookstatusLike(String value) {
            addCriterion("bookStatus like", value, "bookstatus");
            return (Criteria) this;
        }

        public Criteria andBookstatusNotLike(String value) {
            addCriterion("bookStatus not like", value, "bookstatus");
            return (Criteria) this;
        }

        public Criteria andBookstatusIn(List<String> values) {
            addCriterion("bookStatus in", values, "bookstatus");
            return (Criteria) this;
        }

        public Criteria andBookstatusNotIn(List<String> values) {
            addCriterion("bookStatus not in", values, "bookstatus");
            return (Criteria) this;
        }

        public Criteria andBookstatusBetween(String value1, String value2) {
            addCriterion("bookStatus between", value1, value2, "bookstatus");
            return (Criteria) this;
        }

        public Criteria andBookstatusNotBetween(String value1, String value2) {
            addCriterion("bookStatus not between", value1, value2, "bookstatus");
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