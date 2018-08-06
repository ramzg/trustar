package com.trustar.coding.challenge;

import com.trustar.coding.challenge.obj.NestedInteger;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class MainTest {

    @Test
    public void testMain() {
        try {
            Main.main(new String[]{});
        } catch (RuntimeException ex) {
            assertEquals(ex.getMessage(), Main.NO_ARGUMENTS_WERE_SUPPLIED);
        }
        Main.main(new String[] { "[[[1,2,[3]],4],[[1,2,[3]],4]]" });
    }

    @Test
    public void testFlattenNestedInteger() {

        NestedInteger nestedInteger = new NestedInteger();
        List<NestedInteger> childList = new ArrayList<>();
        childList.add(new NestedInteger(1));
        childList.add(new NestedInteger(Arrays.asList(new NestedInteger(2), new NestedInteger(3))));
        childList.add(new NestedInteger(4));
        nestedInteger.setNestedList(childList);

        nestedIntegerBuildAssertionHelper(nestedInteger);

        List<Integer> flattenedList = new ArrayList<>();
        flattenedList = Main.flattenNestedInteger(nestedInteger.getNestedList(), flattenedList);
        assertEquals(flattenedList.size(), 4);
        assertEquals(flattenedList.get(0).intValue(), 1);
        assertEquals(flattenedList.get(1).intValue(), 2);
        assertEquals(flattenedList.get(2).intValue(), 3);
        assertEquals(flattenedList.get(3).intValue(), 4);

        printLists(nestedInteger, flattenedList);

        childList = new ArrayList<>();
        childList.add(new NestedInteger(Arrays.asList(new NestedInteger(2), new NestedInteger(3))));
        childList.add(new NestedInteger(1));
        childList.add(new NestedInteger(4));
        nestedInteger.setNestedList(childList);

        flattenedList = new ArrayList<>();
        flattenedList = Main.flattenNestedInteger(nestedInteger.getNestedList(), flattenedList);
        assertEquals(flattenedList.size(), 4);
        assertEquals(flattenedList.get(0).intValue(), 2);
        assertEquals(flattenedList.get(1).intValue(), 3);
        assertEquals(flattenedList.get(2).intValue(), 1);
        assertEquals(flattenedList.get(3).intValue(), 4);

        printLists(nestedInteger, flattenedList);

        childList = new ArrayList<>();
        childList.add(new NestedInteger(4));
        nestedInteger.setNestedList(childList);

        flattenedList = new ArrayList<>();
        flattenedList = Main.flattenNestedInteger(nestedInteger.getNestedList(), flattenedList);
        assertEquals(flattenedList.size(), 1);
        assertEquals(flattenedList.get(0).intValue(), 4);

        printLists(nestedInteger, flattenedList);

    }

    private void printLists(NestedInteger nestedInteger, List<Integer> flattenedList) {
        System.out.printf("Nested Integer: %s\n", nestedInteger);
        System.out.printf("Flattened List: %s\n\n", flattenedList);
    }

    private void nestedIntegerBuildAssertionHelper(NestedInteger nestedInteger) {
        assertNull(nestedInteger.getNumber());
        assertNotNull(nestedInteger.getNestedList());
        assertEquals(nestedInteger.getNestedList().size(), 3);
        assertEquals(nestedInteger.getNestedList().get(0).getNumber().intValue(), 1);
        assertTrue(nestedInteger.getNestedList().get(1).isArray());
        assertEquals(nestedInteger.getNestedList().get(1).getNestedList().get(0).getNumber().intValue(), 2);
        assertEquals(nestedInteger.getNestedList().get(1).getNestedList().get(1).getNumber().intValue(), 3);
        assertEquals(nestedInteger.getNestedList().get(2).getNumber().intValue(), 4);
    }
}