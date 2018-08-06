package com.trustar.coding.challenge.helper;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.trustar.coding.challenge.obj.NestedInteger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NestedArrayBuilder {

    private static final char ARRAY_START = '[';
    private static final char ARRAY_END = ']';
    private static final char COMMA = ',';

    public NestedInteger buildNestedArrayFromFile() throws IOException {
        URL url = Resources.getResource("nested-integer-array.txt");
        String fileContents = Resources.toString(url, Charsets.UTF_8);

        List<NestedInteger> masterList = new ArrayList<NestedInteger>();

        NestedInteger nestedInteger = new NestedInteger();
        masterList.add(nestedInteger);
        String[] lines = fileContents.split("\n");
        for (String line : lines) {
            buildNestedArray(masterList, line.substring(1, line.lastIndexOf(ARRAY_END)));
        }
        return nestedInteger;
    }

    private void buildNestedArray(List<NestedInteger> nestedInteger, String line) {

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if (currentChar == COMMA) {
                continue;
            }
            NestedInteger element = new NestedInteger();
            if (currentChar == ARRAY_START) {
                element.setArray(true);
                List<NestedInteger> childList = new ArrayList<NestedInteger>();
                element.setNestedList(childList);
                buildNestedArray(childList, line.substring(i + 1));
            } else if (currentChar == ARRAY_END) {
                return;
            } else {
                element.setArray(false);
                element.setNumber(Integer.parseInt(String.valueOf(currentChar)));
            }
            nestedInteger.add(element);
        }
    }
}
