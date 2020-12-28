package com.wyu.pojo;

import java.util.ArrayList;
import java.util.List;

public class TypebookCfExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TypebookCfExample() {
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

        public Criteria andTypebookCfnumberIsNull() {
            addCriterion("typeBook_CFNumber is null");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnumberIsNotNull() {
            addCriterion("typeBook_CFNumber is not null");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnumberEqualTo(Integer value) {
            addCriterion("typeBook_CFNumber =", value, "typebookCfnumber");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnumberNotEqualTo(Integer value) {
            addCriterion("typeBook_CFNumber <>", value, "typebookCfnumber");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnumberGreaterThan(Integer value) {
            addCriterion("typeBook_CFNumber >", value, "typebookCfnumber");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("typeBook_CFNumber >=", value, "typebookCfnumber");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnumberLessThan(Integer value) {
            addCriterion("typeBook_CFNumber <", value, "typebookCfnumber");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnumberLessThanOrEqualTo(Integer value) {
            addCriterion("typeBook_CFNumber <=", value, "typebookCfnumber");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnumberIn(List<Integer> values) {
            addCriterion("typeBook_CFNumber in", values, "typebookCfnumber");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnumberNotIn(List<Integer> values) {
            addCriterion("typeBook_CFNumber not in", values, "typebookCfnumber");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnumberBetween(Integer value1, Integer value2) {
            addCriterion("typeBook_CFNumber between", value1, value2, "typebookCfnumber");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("typeBook_CFNumber not between", value1, value2, "typebookCfnumber");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnameIsNull() {
            addCriterion("typeBook_CFName is null");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnameIsNotNull() {
            addCriterion("typeBook_CFName is not null");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnameEqualTo(String value) {
            addCriterion("typeBook_CFName =", value, "typebookCfname");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnameNotEqualTo(String value) {
            addCriterion("typeBook_CFName <>", value, "typebookCfname");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnameGreaterThan(String value) {
            addCriterion("typeBook_CFName >", value, "typebookCfname");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnameGreaterThanOrEqualTo(String value) {
            addCriterion("typeBook_CFName >=", value, "typebookCfname");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnameLessThan(String value) {
            addCriterion("typeBook_CFName <", value, "typebookCfname");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnameLessThanOrEqualTo(String value) {
            addCriterion("typeBook_CFName <=", value, "typebookCfname");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnameLike(String value) {
            addCriterion("typeBook_CFName like", value, "typebookCfname");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnameNotLike(String value) {
            addCriterion("typeBook_CFName not like", value, "typebookCfname");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnameIn(List<String> values) {
            addCriterion("typeBook_CFName in", values, "typebookCfname");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnameNotIn(List<String> values) {
            addCriterion("typeBook_CFName not in", values, "typebookCfname");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnameBetween(String value1, String value2) {
            addCriterion("typeBook_CFName between", value1, value2, "typebookCfname");
            return (Criteria) this;
        }

        public Criteria andTypebookCfnameNotBetween(String value1, String value2) {
            addCriterion("typeBook_CFName not between", value1, value2, "typebookCfname");
            return (Criteria) this;
        }

        public Criteria andOverduedailymoneyIsNull() {
            addCriterion("overdueDailyMoney is null");
            return (Criteria) this;
        }

        public Criteria andOverduedailymoneyIsNotNull() {
            addCriterion("overdueDailyMoney is not null");
            return (Criteria) this;
        }

        public Criteria andOverduedailymoneyEqualTo(Float value) {
            addCriterion("overdueDailyMoney =", value, "overduedailymoney");
            return (Criteria) this;
        }

        public Criteria andOverduedailymoneyNotEqualTo(Float value) {
            addCriterion("overdueDailyMoney <>", value, "overduedailymoney");
            return (Criteria) this;
        }

        public Criteria andOverduedailymoneyGreaterThan(Float value) {
            addCriterion("overdueDailyMoney >", value, "overduedailymoney");
            return (Criteria) this;
        }

        public Criteria andOverduedailymoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("overdueDailyMoney >=", value, "overduedailymoney");
            return (Criteria) this;
        }

        public Criteria andOverduedailymoneyLessThan(Float value) {
            addCriterion("overdueDailyMoney <", value, "overduedailymoney");
            return (Criteria) this;
        }

        public Criteria andOverduedailymoneyLessThanOrEqualTo(Float value) {
            addCriterion("overdueDailyMoney <=", value, "overduedailymoney");
            return (Criteria) this;
        }

        public Criteria andOverduedailymoneyIn(List<Float> values) {
            addCriterion("overdueDailyMoney in", values, "overduedailymoney");
            return (Criteria) this;
        }

        public Criteria andOverduedailymoneyNotIn(List<Float> values) {
            addCriterion("overdueDailyMoney not in", values, "overduedailymoney");
            return (Criteria) this;
        }

        public Criteria andOverduedailymoneyBetween(Float value1, Float value2) {
            addCriterion("overdueDailyMoney between", value1, value2, "overduedailymoney");
            return (Criteria) this;
        }

        public Criteria andOverduedailymoneyNotBetween(Float value1, Float value2) {
            addCriterion("overdueDailyMoney not between", value1, value2, "overduedailymoney");
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