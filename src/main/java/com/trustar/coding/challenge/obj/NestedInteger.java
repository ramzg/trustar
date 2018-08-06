package com.trustar.coding.challenge.obj;

import java.util.List;

public class NestedInteger {
    private Integer number;
    private List<NestedInteger> nestedList;
    private boolean isArray;

    public NestedInteger(int number) {
        this.number = number;
        this.nestedList = null;
        this.isArray = false;
    }

    public NestedInteger(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.isArray = true;
        this.number = null;
    }

    public NestedInteger() {

    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<NestedInteger> getNestedList() {
        return nestedList;
    }

    public void setNestedList(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    public boolean isArray() {
        return isArray;
    }

    public void setArray(boolean array) {
        isArray = array;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (number != null) builder.append(number);
        if (nestedList != null) builder.append(nestedList);

        return builder.toString();
    }
}
