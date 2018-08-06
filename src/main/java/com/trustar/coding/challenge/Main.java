package com.trustar.coding.challenge;

import com.trustar.coding.challenge.annotations.PackagePrivateForTest;
import com.trustar.coding.challenge.helper.NestedIntegerBuilder;
import com.trustar.coding.challenge.obj.NestedInteger;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {

        if (ArrayUtils.isEmpty(args)) {
            printUsage();
        }

        NestedIntegerBuilder builder = new NestedIntegerBuilder();
        for (String arg : args) {
            NestedInteger nestedInteger = builder.buildNestedList(arg);

            List<Integer> flatList = new ArrayList<>();
            flattenNestedInteger(nestedInteger.getNestedList(), flatList);
            System.out.printf("\nNested Integer: %s\n", nestedInteger);
            System.out.printf("\nFlattened List: %s\n\n", flatList);
        }

    }

    private static void printUsage() {
        System.out.printf("\n\nUsage: %s %s", "java -jar <path-to-jar-with-dependencies>.jar", "<nested-input-list>");
        System.out.printf("\n\nExample: \n-------\n%s\n\n", "java -jar /tmp/true-star-coding-exercise-1.0-SNAPSHOT-jar-with-dependencies.jar [[[[1],2,[3]],[[1,2,[3],6],4]],[[1,2,[3]],4]]");
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
