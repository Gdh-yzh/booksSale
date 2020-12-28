package com.wyu.pojo;

import java.util.ArrayList;
import java.util.List;

public class StatusborrowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatusborrowExample() {
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

        public Criteria andStatusborrownumberIsNull() {
            addCriterion("statusBorrowNumber is null");
            return (Criteria) this;
        }

        public Criteria andStatusborrownumberIsNotNull() {
            addCriterion("statusBorrowNumber is not null");
            return (Criteria) this;
        }

        public Criteria andStatusborrownumberEqualTo(Integer value) {
            addCriterion("statusBorrowNumber =", value, "statusborrownumber");
            return (Criteria) this;
        }

        public Criteria andStatusborrownumberNotEqualTo(Integer value) {
            addCriterion("statusBorrowNumber <>", value, "statusborrownumber");
            return (Criteria) this;
        }

        public Criteria andStatusborrownumberGreaterThan(Integer value) {
            addCriterion("statusBorrowNumber >", value, "statusborrownumber");
            return (Criteria) this;
        }

        public Criteria andStatusborrownumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("statusBorrowNumber >=", value, "statusborrownumber");
            return (Criteria) this;
        }

        public Criteria andStatusborrownumberLessThan(Integer value) {
            addCriterion("statusBorrowNumber <", value, "statusborrownumber");
            return (Criteria) this;
        }

        public Criteria andStatusborrownumberLessThanOrEqualTo(Integer value) {
            addCriterion("statusBorrowNumber <=", value, "statusborrownumber");
            return (Criteria) this;
        }

        public Criteria andStatusborrownumberIn(List<Integer> values) {
            addCriterion("statusBorrowNumber in", values, "statusborrownumber");
            return (Criteria) this;
        }

        public Criteria andStatusborrownumberNotIn(List<Integer> values) {
            addCriterion("statusBorrowNumber not in", values, "statusborrownumber");
            return (Criteria) this;
        }

        public Criteria andStatusborrownumberBetween(Integer value1, Integer value2) {
            addCriterion("statusBorrowNumber between", value1, value2, "statusborrownumber");
            return (Criteria) this;
        }

        public Criteria andStatusborrownumberNotBetween(Integer value1, Integer value2) {
            addCriterion("statusBorrowNumber not between", value1, value2, "statusborrownumber");
            return (Criteria) this;
        }

        public Criteria andStatusborrownameIsNull() {
            addCriterion("statusBorrowName is null");
            return (Criteria) this;
        }

        public Criteria andStatusborrownameIsNotNull() {
            addCriterion("statusBorrowName is not null");
            return (Criteria) this;
        }

        public Criteria andStatusborrownameEqualTo(String value) {
            addCriterion("statusBorrowName =", value, "statusborrowname");
            return (Criteria) this;
        }

        public Criteria andStatusborrownameNotEqualTo(String value) {
            addCriterion("statusBorrowName <>", value, "statusborrowname");
            return (Criteria) this;
        }

        public Criteria andStatusborrownameGreaterThan(String value) {
            addCriterion("statusBorrowName >", value, "statusborrowname");
            return (Criteria) this;
        }

        public Criteria andStatusborrownameGreaterThanOrEqualTo(String value) {
            addCriterion("statusBorrowName >=", value, "statusborrowname");
            return (Criteria) this;
        }

        public Criteria andStatusborrownameLessThan(String value) {
            addCriterion("statusBorrowName <", value, "statusborrowname");
            return (Criteria) this;
        }

        public Criteria andStatusborrownameLessThanOrEqualTo(String value) {
            addCriterion("statusBorrowName <=", value, "statusborrowname");
            return (Criteria) this;
        }

        public Criteria andStatusborrownameLike(String value) {
            addCriterion("statusBorrowName like", value, "statusborrowname");
            return (Criteria) this;
        }

        public Criteria andStatusborrownameNotLike(String value) {
            addCriterion("statusBorrowName not like", value, "statusborrowname");
            return (Criteria) this;
        }

        public Criteria andStatusborrownameIn(List<String> values) {
            addCriterion("statusBorrowName in", values, "statusborrowname");
            return (Criteria) this;
        }

        public Criteria andStatusborrownameNotIn(List<String> values) {
            addCriterion("statusBorrowName not in", values, "statusborrowname");
            return (Criteria) this;
        }

        public Criteria andStatusborrownameBetween(String value1, String value2) {
            addCriterion("statusBorrowName between", value1, value2, "statusborrowname");
            return (Criteria) this;
        }

        public Criteria andStatusborrownameNotBetween(String value1, String value2) {
            addCriterion("statusBorrowName not between", value1, value2, "statusborrowname");
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