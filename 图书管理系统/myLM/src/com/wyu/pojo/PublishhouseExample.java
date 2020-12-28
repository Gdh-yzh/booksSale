package com.wyu.pojo;

import java.util.ArrayList;
import java.util.List;

public class PublishhouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PublishhouseExample() {
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

        public Criteria andPublishhousenumberIsNull() {
            addCriterion("publishHouseNumber is null");
            return (Criteria) this;
        }

        public Criteria andPublishhousenumberIsNotNull() {
            addCriterion("publishHouseNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPublishhousenumberEqualTo(Integer value) {
            addCriterion("publishHouseNumber =", value, "publishhousenumber");
            return (Criteria) this;
        }

        public Criteria andPublishhousenumberNotEqualTo(Integer value) {
            addCriterion("publishHouseNumber <>", value, "publishhousenumber");
            return (Criteria) this;
        }

        public Criteria andPublishhousenumberGreaterThan(Integer value) {
            addCriterion("publishHouseNumber >", value, "publishhousenumber");
            return (Criteria) this;
        }

        public Criteria andPublishhousenumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("publishHouseNumber >=", value, "publishhousenumber");
            return (Criteria) this;
        }

        public Criteria andPublishhousenumberLessThan(Integer value) {
            addCriterion("publishHouseNumber <", value, "publishhousenumber");
            return (Criteria) this;
        }

        public Criteria andPublishhousenumberLessThanOrEqualTo(Integer value) {
            addCriterion("publishHouseNumber <=", value, "publishhousenumber");
            return (Criteria) this;
        }

        public Criteria andPublishhousenumberIn(List<Integer> values) {
            addCriterion("publishHouseNumber in", values, "publishhousenumber");
            return (Criteria) this;
        }

        public Criteria andPublishhousenumberNotIn(List<Integer> values) {
            addCriterion("publishHouseNumber not in", values, "publishhousenumber");
            return (Criteria) this;
        }

        public Criteria andPublishhousenumberBetween(Integer value1, Integer value2) {
            addCriterion("publishHouseNumber between", value1, value2, "publishhousenumber");
            return (Criteria) this;
        }

        public Criteria andPublishhousenumberNotBetween(Integer value1, Integer value2) {
            addCriterion("publishHouseNumber not between", value1, value2, "publishhousenumber");
            return (Criteria) this;
        }

        public Criteria andPublishhousenameIsNull() {
            addCriterion("publishHouseName is null");
            return (Criteria) this;
        }

        public Criteria andPublishhousenameIsNotNull() {
            addCriterion("publishHouseName is not null");
            return (Criteria) this;
        }

        public Criteria andPublishhousenameEqualTo(String value) {
            addCriterion("publishHouseName =", value, "publishhousename");
            return (Criteria) this;
        }

        public Criteria andPublishhousenameNotEqualTo(String value) {
            addCriterion("publishHouseName <>", value, "publishhousename");
            return (Criteria) this;
        }

        public Criteria andPublishhousenameGreaterThan(String value) {
            addCriterion("publishHouseName >", value, "publishhousename");
            return (Criteria) this;
        }

        public Criteria andPublishhousenameGreaterThanOrEqualTo(String value) {
            addCriterion("publishHouseName >=", value, "publishhousename");
            return (Criteria) this;
        }

        public Criteria andPublishhousenameLessThan(String value) {
            addCriterion("publishHouseName <", value, "publishhousename");
            return (Criteria) this;
        }

        public Criteria andPublishhousenameLessThanOrEqualTo(String value) {
            addCriterion("publishHouseName <=", value, "publishhousename");
            return (Criteria) this;
        }

        public Criteria andPublishhousenameLike(String value) {
            addCriterion("publishHouseName like", value, "publishhousename");
            return (Criteria) this;
        }

        public Criteria andPublishhousenameNotLike(String value) {
            addCriterion("publishHouseName not like", value, "publishhousename");
            return (Criteria) this;
        }

        public Criteria andPublishhousenameIn(List<String> values) {
            addCriterion("publishHouseName in", values, "publishhousename");
            return (Criteria) this;
        }

        public Criteria andPublishhousenameNotIn(List<String> values) {
            addCriterion("publishHouseName not in", values, "publishhousename");
            return (Criteria) this;
        }

        public Criteria andPublishhousenameBetween(String value1, String value2) {
            addCriterion("publishHouseName between", value1, value2, "publishhousename");
            return (Criteria) this;
        }

        public Criteria andPublishhousenameNotBetween(String value1, String value2) {
            addCriterion("publishHouseName not between", value1, value2, "publishhousename");
            return (Criteria) this;
        }

        public Criteria andLetterIsNull() {
            addCriterion("letter is null");
            return (Criteria) this;
        }

        public Criteria andLetterIsNotNull() {
            addCriterion("letter is not null");
            return (Criteria) this;
        }

        public Criteria andLetterEqualTo(String value) {
            addCriterion("letter =", value, "letter");
            return (Criteria) this;
        }

        public Criteria andLetterNotEqualTo(String value) {
            addCriterion("letter <>", value, "letter");
            return (Criteria) this;
        }

        public Criteria andLetterGreaterThan(String value) {
            addCriterion("letter >", value, "letter");
            return (Criteria) this;
        }

        public Criteria andLetterGreaterThanOrEqualTo(String value) {
            addCriterion("letter >=", value, "letter");
            return (Criteria) this;
        }

        public Criteria andLetterLessThan(String value) {
            addCriterion("letter <", value, "letter");
            return (Criteria) this;
        }

        public Criteria andLetterLessThanOrEqualTo(String value) {
            addCriterion("letter <=", value, "letter");
            return (Criteria) this;
        }

        public Criteria andLetterLike(String value) {
            addCriterion("letter like", value, "letter");
            return (Criteria) this;
        }

        public Criteria andLetterNotLike(String value) {
            addCriterion("letter not like", value, "letter");
            return (Criteria) this;
        }

        public Criteria andLetterIn(List<String> values) {
            addCriterion("letter in", values, "letter");
            return (Criteria) this;
        }

        public Criteria andLetterNotIn(List<String> values) {
            addCriterion("letter not in", values, "letter");
            return (Criteria) this;
        }

        public Criteria andLetterBetween(String value1, String value2) {
            addCriterion("letter between", value1, value2, "letter");
            return (Criteria) this;
        }

        public Criteria andLetterNotBetween(String value1, String value2) {
            addCriterion("letter not between", value1, value2, "letter");
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