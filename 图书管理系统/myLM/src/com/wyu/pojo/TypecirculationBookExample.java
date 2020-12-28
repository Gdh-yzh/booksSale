package com.wyu.pojo;

import java.util.ArrayList;
import java.util.List;

public class TypecirculationBookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TypecirculationBookExample() {
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

        public Criteria andTypecirculationnumberIsNull() {
            addCriterion("typeCirculationNumber is null");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnumberIsNotNull() {
            addCriterion("typeCirculationNumber is not null");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnumberEqualTo(Integer value) {
            addCriterion("typeCirculationNumber =", value, "typecirculationnumber");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnumberNotEqualTo(Integer value) {
            addCriterion("typeCirculationNumber <>", value, "typecirculationnumber");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnumberGreaterThan(Integer value) {
            addCriterion("typeCirculationNumber >", value, "typecirculationnumber");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("typeCirculationNumber >=", value, "typecirculationnumber");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnumberLessThan(Integer value) {
            addCriterion("typeCirculationNumber <", value, "typecirculationnumber");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnumberLessThanOrEqualTo(Integer value) {
            addCriterion("typeCirculationNumber <=", value, "typecirculationnumber");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnumberIn(List<Integer> values) {
            addCriterion("typeCirculationNumber in", values, "typecirculationnumber");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnumberNotIn(List<Integer> values) {
            addCriterion("typeCirculationNumber not in", values, "typecirculationnumber");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnumberBetween(Integer value1, Integer value2) {
            addCriterion("typeCirculationNumber between", value1, value2, "typecirculationnumber");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("typeCirculationNumber not between", value1, value2, "typecirculationnumber");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnameIsNull() {
            addCriterion("typeCirculationName is null");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnameIsNotNull() {
            addCriterion("typeCirculationName is not null");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnameEqualTo(String value) {
            addCriterion("typeCirculationName =", value, "typecirculationname");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnameNotEqualTo(String value) {
            addCriterion("typeCirculationName <>", value, "typecirculationname");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnameGreaterThan(String value) {
            addCriterion("typeCirculationName >", value, "typecirculationname");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnameGreaterThanOrEqualTo(String value) {
            addCriterion("typeCirculationName >=", value, "typecirculationname");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnameLessThan(String value) {
            addCriterion("typeCirculationName <", value, "typecirculationname");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnameLessThanOrEqualTo(String value) {
            addCriterion("typeCirculationName <=", value, "typecirculationname");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnameLike(String value) {
            addCriterion("typeCirculationName like", value, "typecirculationname");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnameNotLike(String value) {
            addCriterion("typeCirculationName not like", value, "typecirculationname");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnameIn(List<String> values) {
            addCriterion("typeCirculationName in", values, "typecirculationname");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnameNotIn(List<String> values) {
            addCriterion("typeCirculationName not in", values, "typecirculationname");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnameBetween(String value1, String value2) {
            addCriterion("typeCirculationName between", value1, value2, "typecirculationname");
            return (Criteria) this;
        }

        public Criteria andTypecirculationnameNotBetween(String value1, String value2) {
            addCriterion("typeCirculationName not between", value1, value2, "typecirculationname");
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