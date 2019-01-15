package com.qf.express.manage.entity;

import java.util.ArrayList;
import java.util.List;

public class RrightExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RrightExample() {
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

        public Criteria andRightidIsNull() {
            addCriterion("rightid is null");
            return (Criteria) this;
        }

        public Criteria andRightidIsNotNull() {
            addCriterion("rightid is not null");
            return (Criteria) this;
        }

        public Criteria andRightidEqualTo(Integer value) {
            addCriterion("rightid =", value, "rightid");
            return (Criteria) this;
        }

        public Criteria andRightidNotEqualTo(Integer value) {
            addCriterion("rightid <>", value, "rightid");
            return (Criteria) this;
        }

        public Criteria andRightidGreaterThan(Integer value) {
            addCriterion("rightid >", value, "rightid");
            return (Criteria) this;
        }

        public Criteria andRightidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rightid >=", value, "rightid");
            return (Criteria) this;
        }

        public Criteria andRightidLessThan(Integer value) {
            addCriterion("rightid <", value, "rightid");
            return (Criteria) this;
        }

        public Criteria andRightidLessThanOrEqualTo(Integer value) {
            addCriterion("rightid <=", value, "rightid");
            return (Criteria) this;
        }

        public Criteria andRightidIn(List<Integer> values) {
            addCriterion("rightid in", values, "rightid");
            return (Criteria) this;
        }

        public Criteria andRightidNotIn(List<Integer> values) {
            addCriterion("rightid not in", values, "rightid");
            return (Criteria) this;
        }

        public Criteria andRightidBetween(Integer value1, Integer value2) {
            addCriterion("rightid between", value1, value2, "rightid");
            return (Criteria) this;
        }

        public Criteria andRightidNotBetween(Integer value1, Integer value2) {
            addCriterion("rightid not between", value1, value2, "rightid");
            return (Criteria) this;
        }

        public Criteria andRighttextIsNull() {
            addCriterion("righttext is null");
            return (Criteria) this;
        }

        public Criteria andRighttextIsNotNull() {
            addCriterion("righttext is not null");
            return (Criteria) this;
        }

        public Criteria andRighttextEqualTo(String value) {
            addCriterion("righttext =", value, "righttext");
            return (Criteria) this;
        }

        public Criteria andRighttextNotEqualTo(String value) {
            addCriterion("righttext <>", value, "righttext");
            return (Criteria) this;
        }

        public Criteria andRighttextGreaterThan(String value) {
            addCriterion("righttext >", value, "righttext");
            return (Criteria) this;
        }

        public Criteria andRighttextGreaterThanOrEqualTo(String value) {
            addCriterion("righttext >=", value, "righttext");
            return (Criteria) this;
        }

        public Criteria andRighttextLessThan(String value) {
            addCriterion("righttext <", value, "righttext");
            return (Criteria) this;
        }

        public Criteria andRighttextLessThanOrEqualTo(String value) {
            addCriterion("righttext <=", value, "righttext");
            return (Criteria) this;
        }

        public Criteria andRighttextLike(String value) {
            addCriterion("righttext like", value, "righttext");
            return (Criteria) this;
        }

        public Criteria andRighttextNotLike(String value) {
            addCriterion("righttext not like", value, "righttext");
            return (Criteria) this;
        }

        public Criteria andRighttextIn(List<String> values) {
            addCriterion("righttext in", values, "righttext");
            return (Criteria) this;
        }

        public Criteria andRighttextNotIn(List<String> values) {
            addCriterion("righttext not in", values, "righttext");
            return (Criteria) this;
        }

        public Criteria andRighttextBetween(String value1, String value2) {
            addCriterion("righttext between", value1, value2, "righttext");
            return (Criteria) this;
        }

        public Criteria andRighttextNotBetween(String value1, String value2) {
            addCriterion("righttext not between", value1, value2, "righttext");
            return (Criteria) this;
        }

        public Criteria andRighttypeIsNull() {
            addCriterion("righttype is null");
            return (Criteria) this;
        }

        public Criteria andRighttypeIsNotNull() {
            addCriterion("righttype is not null");
            return (Criteria) this;
        }

        public Criteria andRighttypeEqualTo(Integer value) {
            addCriterion("righttype =", value, "righttype");
            return (Criteria) this;
        }

        public Criteria andRighttypeNotEqualTo(Integer value) {
            addCriterion("righttype <>", value, "righttype");
            return (Criteria) this;
        }

        public Criteria andRighttypeGreaterThan(Integer value) {
            addCriterion("righttype >", value, "righttype");
            return (Criteria) this;
        }

        public Criteria andRighttypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("righttype >=", value, "righttype");
            return (Criteria) this;
        }

        public Criteria andRighttypeLessThan(Integer value) {
            addCriterion("righttype <", value, "righttype");
            return (Criteria) this;
        }

        public Criteria andRighttypeLessThanOrEqualTo(Integer value) {
            addCriterion("righttype <=", value, "righttype");
            return (Criteria) this;
        }

        public Criteria andRighttypeIn(List<Integer> values) {
            addCriterion("righttype in", values, "righttype");
            return (Criteria) this;
        }

        public Criteria andRighttypeNotIn(List<Integer> values) {
            addCriterion("righttype not in", values, "righttype");
            return (Criteria) this;
        }

        public Criteria andRighttypeBetween(Integer value1, Integer value2) {
            addCriterion("righttype between", value1, value2, "righttype");
            return (Criteria) this;
        }

        public Criteria andRighttypeNotBetween(Integer value1, Integer value2) {
            addCriterion("righttype not between", value1, value2, "righttype");
            return (Criteria) this;
        }

        public Criteria andRighturlIsNull() {
            addCriterion("righturl is null");
            return (Criteria) this;
        }

        public Criteria andRighturlIsNotNull() {
            addCriterion("righturl is not null");
            return (Criteria) this;
        }

        public Criteria andRighturlEqualTo(String value) {
            addCriterion("righturl =", value, "righturl");
            return (Criteria) this;
        }

        public Criteria andRighturlNotEqualTo(String value) {
            addCriterion("righturl <>", value, "righturl");
            return (Criteria) this;
        }

        public Criteria andRighturlGreaterThan(String value) {
            addCriterion("righturl >", value, "righturl");
            return (Criteria) this;
        }

        public Criteria andRighturlGreaterThanOrEqualTo(String value) {
            addCriterion("righturl >=", value, "righturl");
            return (Criteria) this;
        }

        public Criteria andRighturlLessThan(String value) {
            addCriterion("righturl <", value, "righturl");
            return (Criteria) this;
        }

        public Criteria andRighturlLessThanOrEqualTo(String value) {
            addCriterion("righturl <=", value, "righturl");
            return (Criteria) this;
        }

        public Criteria andRighturlLike(String value) {
            addCriterion("righturl like", value, "righturl");
            return (Criteria) this;
        }

        public Criteria andRighturlNotLike(String value) {
            addCriterion("righturl not like", value, "righturl");
            return (Criteria) this;
        }

        public Criteria andRighturlIn(List<String> values) {
            addCriterion("righturl in", values, "righturl");
            return (Criteria) this;
        }

        public Criteria andRighturlNotIn(List<String> values) {
            addCriterion("righturl not in", values, "righturl");
            return (Criteria) this;
        }

        public Criteria andRighturlBetween(String value1, String value2) {
            addCriterion("righturl between", value1, value2, "righturl");
            return (Criteria) this;
        }

        public Criteria andRighturlNotBetween(String value1, String value2) {
            addCriterion("righturl not between", value1, value2, "righturl");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentid is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentid is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentid =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentid <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentid >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentid >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentid <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentid <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("parentid in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("parentid not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentid between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentid not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andLevelcountIsNull() {
            addCriterion("levelcount is null");
            return (Criteria) this;
        }

        public Criteria andLevelcountIsNotNull() {
            addCriterion("levelcount is not null");
            return (Criteria) this;
        }

        public Criteria andLevelcountEqualTo(Integer value) {
            addCriterion("levelcount =", value, "levelcount");
            return (Criteria) this;
        }

        public Criteria andLevelcountNotEqualTo(Integer value) {
            addCriterion("levelcount <>", value, "levelcount");
            return (Criteria) this;
        }

        public Criteria andLevelcountGreaterThan(Integer value) {
            addCriterion("levelcount >", value, "levelcount");
            return (Criteria) this;
        }

        public Criteria andLevelcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("levelcount >=", value, "levelcount");
            return (Criteria) this;
        }

        public Criteria andLevelcountLessThan(Integer value) {
            addCriterion("levelcount <", value, "levelcount");
            return (Criteria) this;
        }

        public Criteria andLevelcountLessThanOrEqualTo(Integer value) {
            addCriterion("levelcount <=", value, "levelcount");
            return (Criteria) this;
        }

        public Criteria andLevelcountIn(List<Integer> values) {
            addCriterion("levelcount in", values, "levelcount");
            return (Criteria) this;
        }

        public Criteria andLevelcountNotIn(List<Integer> values) {
            addCriterion("levelcount not in", values, "levelcount");
            return (Criteria) this;
        }

        public Criteria andLevelcountBetween(Integer value1, Integer value2) {
            addCriterion("levelcount between", value1, value2, "levelcount");
            return (Criteria) this;
        }

        public Criteria andLevelcountNotBetween(Integer value1, Integer value2) {
            addCriterion("levelcount not between", value1, value2, "levelcount");
            return (Criteria) this;
        }

        public Criteria andIsmenuIsNull() {
            addCriterion("ismenu is null");
            return (Criteria) this;
        }

        public Criteria andIsmenuIsNotNull() {
            addCriterion("ismenu is not null");
            return (Criteria) this;
        }

        public Criteria andIsmenuEqualTo(Boolean value) {
            addCriterion("ismenu =", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuNotEqualTo(Boolean value) {
            addCriterion("ismenu <>", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuGreaterThan(Boolean value) {
            addCriterion("ismenu >", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ismenu >=", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuLessThan(Boolean value) {
            addCriterion("ismenu <", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuLessThanOrEqualTo(Boolean value) {
            addCriterion("ismenu <=", value, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuIn(List<Boolean> values) {
            addCriterion("ismenu in", values, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuNotIn(List<Boolean> values) {
            addCriterion("ismenu not in", values, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuBetween(Boolean value1, Boolean value2) {
            addCriterion("ismenu between", value1, value2, "ismenu");
            return (Criteria) this;
        }

        public Criteria andIsmenuNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ismenu not between", value1, value2, "ismenu");
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