package com.trustar.coding.challenge.obj;

import java.util.List;

public class NestedInteger {
    private Integer number;
    private List<NestedInteger> nestedList;
    private boolean isArray;

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
}
