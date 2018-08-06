package com.trustar.coding.challenge.helper;

import com.google.common.base.Strings;
import com.trustar.coding.challenge.obj.NestedInteger;

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerBuilder {

    private static final String COMMA = ",";
    private static final String ARRAY_END = "]";
    private static final String ARRAY_START = "[";

    private ThreadLocal<Integer> lineIndex = ThreadLocal.withInitial(() -> 0);

    public NestedInteger buildNestedList(String line) {

        try {
            NestedInteger nestedInteger = new NestedInteger();
            nestedInteger.setNestedList(new ArrayList<>());
            build(nestedInteger.getNestedList(), line.substring(1, line.lastIndexOf(ARRAY_END)));

            return nestedInteger;
        } finally {
            lineIndex.remove();
        }
    }

    private void build(List<NestedInteger> nestedInteger, String line) {

        for (int i = 0; i < line.length(); i++) {
            if (lineIndex.get() >= line.length()) {
                return;
            }
            String current = getCurrentToken(line);
            lineIndex.set(lineIndex.get() + 1);
            if (Strings.isNullOrEmpty(current)) {
                return;
            }
            switch (current) {
                case ARRAY_START: {
                    NestedInteger element = new NestedInteger();
                    element.setArray(true);
                    List<NestedInteger> childList = new ArrayList<>();
                    element.setNestedList(childList);
                    nestedInteger.add(element);
                    build(childList, line);
                    break;
                }
                case ARRAY_END:
                    return;
                default: {
                    NestedInteger element = new NestedInteger();
                    element.setArray(false);
                    element.setNumber(Integer.parseInt(String.valueOf(current)));
                    nestedInteger.add(element);
                    break;
                }
            }
        }

    }

    private String getCurrentToken(String line) {
        StringBuilder builder = new StringBuilder();
        char currentChar = line.charAt(lineIndex.get());
        if (String.valueOf(currentChar).equals(ARRAY_START)
                || String.valueOf(currentChar).equals(ARRAY_END)) {
            return String.valueOf(currentChar);
        }
        while (!String.valueOf(line.charAt(lineIndex.get())).equals(COMMA)
                && !String.valueOf(line.charAt(lineIndex.get())).equals(ARRAY_END)) {
            builder.append(line.charAt(lineIndex.get()));
            lineIndex.set(lineIndex.get() + 1);
            if (lineIndex.get() == line.length()) {
                break;
            }
        }
        return builder.toString();
    }
}
