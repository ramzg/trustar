package com.trustar.coding.challenge;

import com.trustar.coding.challenge.annotations.PackagePrivateForTest;
import com.trustar.coding.challenge.helper.NestedListBuilder;
import com.trustar.coding.challenge.obj.NestedInteger;

import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        NestedListBuilder builder = new NestedListBuilder();
        for (String arg : args) {
            List<NestedInteger> nestedIntegerList = builder.buildNestedList(arg);

            List<Integer> flatList = new ArrayList<>();
            flattenNestedInteger(nestedIntegerList, flatList);
            System.out.println(flatList);

        }

    }

    @PackagePrivateForTest
    protected static void flattenNestedInteger(List<NestedInteger> nestedInteger, List<Integer> flatList) {
        for (NestedInteger integer : nestedInteger) {
            if (integer.isArray()) {
                flattenNestedInteger(integer.getNestedList(), flatList);
            } else {
                flatList.add(integer.getNumber());
            }
        }
    }
}
