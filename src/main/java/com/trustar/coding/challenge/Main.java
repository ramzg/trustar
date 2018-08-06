package com.trustar.coding.challenge;

import com.trustar.coding.challenge.annotations.PackagePrivateForTest;
import com.trustar.coding.challenge.helper.NestedIntegerBuilder;
import com.trustar.coding.challenge.obj.NestedInteger;

import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        NestedIntegerBuilder builder = new NestedIntegerBuilder();
        for (String arg : args) {
            NestedInteger nestedInteger = builder.buildNestedList(arg);

            List<Integer> flatList = new ArrayList<>();
            flattenNestedInteger(nestedInteger.getNestedList(), flatList);
            System.out.printf("\nNested Integer: %s\n", nestedInteger);
            System.out.printf("\nFlattened List: %s\n\n", flatList);
        }

    }

    @PackagePrivateForTest
    static List<Integer> flattenNestedInteger(List<NestedInteger> nestedInteger, List<Integer> flatList) {
        for (NestedInteger integer : nestedInteger) {
            if (integer.isArray()) {
                flattenNestedInteger(integer.getNestedList(), flatList);
            } else {
                flatList.add(integer.getNumber());
            }
        }
        return flatList;
    }
}
