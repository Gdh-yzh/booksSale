package com.wyu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andIsbnIsNull() {
            addCriterion("ISBN is null");
            return (Criteria) this;
        }

        public Criteria andIsbnIsNotNull() {
            addCriterion("ISBN is not null");
            return (Criteria) this;
        }

        public Criteria andIsbnEqualTo(String value) {
            addCriterion("ISBN =", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotEqualTo(String value) {
            addCriterion("ISBN <>", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThan(String value) {
            addCriterion("ISBN >", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("ISBN >=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThan(String value) {
            addCriterion("ISBN <", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLessThanOrEqualTo(String value) {
            addCriterion("ISBN <=", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnLike(String value) {
            addCriterion("ISBN like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotLike(String value) {
            addCriterion("ISBN not like", value, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnIn(List<String> values) {
            addCriterion("ISBN in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotIn(List<String> values) {
            addCriterion("ISBN not in", values, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnBetween(String value1, String value2) {
            addCriterion("ISBN between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andIsbnNotBetween(String value1, String value2) {
            addCriterion("ISBN not between", value1, value2, "isbn");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andTranslatorIsNull() {
            addCriterion("translator is null");
            return (Criteria) this;
        }

        public Criteria andTranslatorIsNotNull() {
            addCriterion("translator is not null");
            return (Criteria) this;
        }

        public Criteria andTranslatorEqualTo(String value) {
            addCriterion("translator =", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorNotEqualTo(String value) {
            addCriterion("translator <>", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorGreaterThan(String value) {
            addCriterion("translator >", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorGreaterThanOrEqualTo(String value) {
            addCriterion("translator >=", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorLessThan(String value) {
            addCriterion("translator <", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorLessThanOrEqualTo(String value) {
            addCriterion("translator <=", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorLike(String value) {
            addCriterion("translator like", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorNotLike(String value) {
            addCriterion("translator not like", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorIn(List<String> values) {
            addCriterion("translator in", values, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorNotIn(List<String> values) {
            addCriterion("translator not in", values, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorBetween(String value1, String value2) {
            addCriterion("translator between", value1, value2, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorNotBetween(String value1, String value2) {
            addCriterion("translator not between", value1, value2, "translator");
            return (Criteria) this;
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

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andCallnumberIsNull() {
            addCriterion("callNumber is null");
            return (Criteria) this;
        }

        public Criteria andCallnumberIsNotNull() {
            addCriterion("callNumber is not null");
            return (Criteria) this;
        }

        public Criteria andCallnumberEqualTo(String value) {
            addCriterion("callNumber =", value, "callnumber");
            return (Criteria) this;
        }

        public Criteria andCallnumberNotEqualTo(String value) {
            addCriterion("callNumber <>", value, "callnumber");
            return (Criteria) this;
        }

        public Criteria andCallnumberGreaterThan(String value) {
            addCriterion("callNumber >", value, "callnumber");
            return (Criteria) this;
        }

        public Criteria andCallnumberGreaterThanOrEqualTo(String value) {
            addCriterion("callNumber >=", value, "callnumber");
            return (Criteria) this;
        }

        public Criteria andCallnumberLessThan(String value) {
            addCriterion("callNumber <", value, "callnumber");
            return (Criteria) this;
        }

        public Criteria andCallnumberLessThanOrEqualTo(String value) {
            addCriterion("callNumber <=", value, "callnumber");
            return (Criteria) this;
        }

        public Criteria andCallnumberLike(String value) {
            addCriterion("callNumber like", value, "callnumber");
            return (Criteria) this;
        }

        public Criteria andCallnumberNotLike(String value) {
            addCriterion("callNumber not like", value, "callnumber");
            return (Criteria) this;
        }

        public Criteria andCallnumberIn(List<String> values) {
            addCriterion("callNumber in", values, "callnumber");
            return (Criteria) this;
        }

        public Criteria andCallnumberNotIn(List<String> values) {
            addCriterion("callNumber not in", values, "callnumber");
            return (Criteria) this;
        }

        public Criteria andCallnumberBetween(String value1, String value2) {
            addCriterion("callNumber between", value1, value2, "callnumber");
            return (Criteria) this;
        }

        public Criteria andCallnumberNotBetween(String value1, String value2) {
            addCriterion("callNumber not between", value1, value2, "callnumber");
            return (Criteria) this;
        }

        public Criteria andImglocationIsNull() {
            addCriterion("imgLocation is null");
            return (Criteria) this;
        }

        public Criteria andImglocationIsNotNull() {
            addCriterion("imgLocation is not null");
            return (Criteria) this;
        }

        public Criteria andImglocationEqualTo(String value) {
            addCriterion("imgLocation =", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationNotEqualTo(String value) {
            addCriterion("imgLocation <>", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationGreaterThan(String value) {
            addCriterion("imgLocation >", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationGreaterThanOrEqualTo(String value) {
            addCriterion("imgLocation >=", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationLessThan(String value) {
            addCriterion("imgLocation <", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationLessThanOrEqualTo(String value) {
            addCriterion("imgLocation <=", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationLike(String value) {
            addCriterion("imgLocation like", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationNotLike(String value) {
            addCriterion("imgLocation not like", value, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationIn(List<String> values) {
            addCriterion("imgLocation in", values, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationNotIn(List<String> values) {
            addCriterion("imgLocation not in", values, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationBetween(String value1, String value2) {
            addCriterion("imgLocation between", value1, value2, "imglocation");
            return (Criteria) this;
        }

        public Criteria andImglocationNotBetween(String value1, String value2) {
            addCriterion("imgLocation not between", value1, value2, "imglocation");
            return (Criteria) this;
        }

        public Criteria andClassificationnumberIsNull() {
            addCriterion("classificationNumber is null");
            return (Criteria) this;
        }

        public Criteria andClassificationnumberIsNotNull() {
            addCriterion("classificationNumber is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationnumberEqualTo(Integer value) {
            addCriterion("classificationNumber =", value, "classificationnumber");
            return (Criteria) this;
        }

        public Criteria andClassificationnumberNotEqualTo(Integer value) {
            addCriterion("classificationNumber <>", value, "classificationnumber");
            return (Criteria) this;
        }

        public Criteria andClassificationnumberGreaterThan(Integer value) {
            addCriterion("classificationNumber >", value, "classificationnumber");
            return (Criteria) this;
        }

        public Criteria andClassificationnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("classificationNumber >=", value, "classificationnumber");
            return (Criteria) this;
        }

        public Criteria andClassificationnumberLessThan(Integer value) {
            addCriterion("classificationNumber <", value, "classificationnumber");
            return (Criteria) this;
        }

        public Criteria andClassificationnumberLessThanOrEqualTo(Integer value) {
            addCriterion("classificationNumber <=", value, "classificationnumber");
            return (Criteria) this;
        }

        public Criteria andClassificationnumberIn(List<Integer> values) {
            addCriterion("classificationNumber in", values, "classificationnumber");
            return (Criteria) this;
        }

        public Criteria andClassificationnumberNotIn(List<Integer> values) {
            addCriterion("classificationNumber not in", values, "classificationnumber");
            return (Criteria) this;
        }

        public Criteria andClassificationnumberBetween(Integer value1, Integer value2) {
            addCriterion("classificationNumber between", value1, value2, "classificationnumber");
            return (Criteria) this;
        }

        public Criteria andClassificationnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("classificationNumber not between", value1, value2, "classificationnumber");
            return (Criteria) this;
        }

        public Criteria andSeclassificationIsNull() {
            addCriterion("seClassification is null");
            return (Criteria) this;
        }

        public Criteria andSeclassificationIsNotNull() {
            addCriterion("seClassification is not null");
            return (Criteria) this;
        }

        public Criteria andSeclassificationEqualTo(String value) {
            addCriterion("seClassification =", value, "seclassification");
            return (Criteria) this;
        }

        public Criteria andSeclassificationNotEqualTo(String value) {
            addCriterion("seClassification <>", value, "seclassification");
            return (Criteria) this;
        }

        public Criteria andSeclassificationGreaterThan(String value) {
            addCriterion("seClassification >", value, "seclassification");
            return (Criteria) this;
        }

        public Criteria andSeclassificationGreaterThanOrEqualTo(String value) {
            addCriterion("seClassification >=", value, "seclassification");
            return (Criteria) this;
        }

        public Criteria andSeclassificationLessThan(String value) {
            addCriterion("seClassification <", value, "seclassification");
            return (Criteria) this;
        }

        public Criteria andSeclassificationLessThanOrEqualTo(String value) {
            addCriterion("seClassification <=", value, "seclassification");
            return (Criteria) this;
        }

        public Criteria andSeclassificationLike(String value) {
            addCriterion("seClassification like", value, "seclassification");
            return (Criteria) this;
        }

        public Criteria andSeclassificationNotLike(String value) {
            addCriterion("seClassification not like", value, "seclassification");
            return (Criteria) this;
        }

        public Criteria andSeclassificationIn(List<String> values) {
            addCriterion("seClassification in", values, "seclassification");
            return (Criteria) this;
        }

        public Criteria andSeclassificationNotIn(List<String> values) {
            addCriterion("seClassification not in", values, "seclassification");
            return (Criteria) this;
        }

        public Criteria andSeclassificationBetween(String value1, String value2) {
            addCriterion("seClassification between", value1, value2, "seclassification");
            return (Criteria) this;
        }

        public Criteria andSeclassificationNotBetween(String value1, String value2) {
            addCriterion("seClassification not between", value1, value2, "seclassification");
            return (Criteria) this;
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

        public Criteria andBorrowtimesIsNull() {
            addCriterion("borrowTimes is null");
            return (Criteria) this;
        }

        public Criteria andBorrowtimesIsNotNull() {
            addCriterion("borrowTimes is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowtimesEqualTo(Integer value) {
            addCriterion("borrowTimes =", value, "borrowtimes");
            return (Criteria) this;
        }

        public Criteria andBorrowtimesNotEqualTo(Integer value) {
            addCriterion("borrowTimes <>", value, "borrowtimes");
            return (Criteria) this;
        }

        public Criteria andBorrowtimesGreaterThan(Integer value) {
            addCriterion("borrowTimes >", value, "borrowtimes");
            return (Criteria) this;
        }

        public Criteria andBorrowtimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrowTimes >=", value, "borrowtimes");
            return (Criteria) this;
        }

        public Criteria andBorrowtimesLessThan(Integer value) {
            addCriterion("borrowTimes <", value, "borrowtimes");
            return (Criteria) this;
        }

        public Criteria andBorrowtimesLessThanOrEqualTo(Integer value) {
            addCriterion("borrowTimes <=", value, "borrowtimes");
            return (Criteria) this;
        }

        public Criteria andBorrowtimesIn(List<Integer> values) {
            addCriterion("borrowTimes in", values, "borrowtimes");
            return (Criteria) this;
        }

        public Criteria andBorrowtimesNotIn(List<Integer> values) {
            addCriterion("borrowTimes not in", values, "borrowtimes");
            return (Criteria) this;
        }

        public Criteria andBorrowtimesBetween(Integer value1, Integer value2) {
            addCriterion("borrowTimes between", value1, value2, "borrowtimes");
            return (Criteria) this;
        }

        public Criteria andBorrowtimesNotBetween(Integer value1, Integer value2) {
            addCriterion("borrowTimes not between", value1, value2, "borrowtimes");
            return (Criteria) this;
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

        public Criteria andEntrydateIsNull() {
            addCriterion("entryDate is null");
            return (Criteria) this;
        }

        public Criteria andEntrydateIsNotNull() {
            addCriterion("entryDate is not null");
            return (Criteria) this;
        }

        public Criteria andEntrydateEqualTo(Date value) {
            addCriterion("entryDate =", value, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateNotEqualTo(Date value) {
            addCriterion("entryDate <>", value, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateGreaterThan(Date value) {
            addCriterion("entryDate >", value, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateGreaterThanOrEqualTo(Date value) {
            addCriterion("entryDate >=", value, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateLessThan(Date value) {
            addCriterion("entryDate <", value, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateLessThanOrEqualTo(Date value) {
            addCriterion("entryDate <=", value, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateIn(List<Date> values) {
            addCriterion("entryDate in", values, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateNotIn(List<Date> values) {
            addCriterion("entryDate not in", values, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateBetween(Date value1, Date value2) {
            addCriterion("entryDate between", value1, value2, "entrydate");
            return (Criteria) this;
        }

        public Criteria andEntrydateNotBetween(Date value1, Date value2) {
            addCriterion("entryDate not between", value1, value2, "entrydate");
            return (Criteria) this;
        }

        public Criteria andPublishyearIsNull() {
            addCriterion("publishYear is null");
            return (Criteria) this;
        }

        public Criteria andPublishyearIsNotNull() {
            addCriterion("publishYear is not null");
            return (Criteria) this;
        }

        public Criteria andPublishyearEqualTo(Date value) {
            addCriterionForJDBCDate("publishYear =", value, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearNotEqualTo(Date value) {
            addCriterionForJDBCDate("publishYear <>", value, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearGreaterThan(Date value) {
            addCriterionForJDBCDate("publishYear >", value, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publishYear >=", value, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearLessThan(Date value) {
            addCriterionForJDBCDate("publishYear <", value, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publishYear <=", value, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearIn(List<Date> values) {
            addCriterionForJDBCDate("publishYear in", values, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearNotIn(List<Date> values) {
            addCriterionForJDBCDate("publishYear not in", values, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publishYear between", value1, value2, "publishyear");
            return (Criteria) this;
        }

        public Criteria andPublishyearNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publishYear not between", value1, value2, "publishyear");
            return (Criteria) this;
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