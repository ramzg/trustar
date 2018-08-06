package com.trustar.coding.challenge.helper;

import com.trustar.coding.challenge.obj.NestedInteger;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class NestedListBuilderTest {

    @Test
    public void testBuildNestedList() {

        NestedListBuilder builder = new NestedListBuilder();
        List<NestedInteger> nestedIntegers = builder.buildNestedList("[[1,2,[3]],4]");
        assertEquals(nestedIntegers.size(), 2);
        assertTrue(nestedIntegers.get(0).isArray());
        assertNotNull(nestedIntegers.get(0).getNestedList());
        assertEquals(nestedIntegers.get(0).getNestedList().size(), 3);
        assertEquals(nestedIntegers.get(0).getNestedList().get(0).getNumber().intValue(), 1);
        assertEquals(nestedIntegers.get(0).getNestedList().get(1).getNumber().intValue(), 2);
        assertTrue(nestedIntegers.get(0).getNestedList().get(2).isArray());
        assertEquals(nestedIntegers.get(0).getNestedList().get(2).getNestedList().size(), 1);
        assertEquals(nestedIntegers.get(0).getNestedList().get(2).getNestedList().get(0).getNumber().intValue(), 3);
        assertFalse(nestedIntegers.get(1).isArray());
        assertEquals(nestedIntegers.get(1).getNumber().intValue(), 4);


        nestedIntegers = builder.buildNestedList("[[1,2,3],4]");
        assertEquals(nestedIntegers.size(), 2);
        assertTrue(nestedIntegers.get(0).isArray());
        assertNotNull(nestedIntegers.get(0).getNestedList());
        assertEquals(nestedIntegers.get(0).getNestedList().size(), 3);
        assertEquals(nestedIntegers.get(0).getNestedList().get(0).getNumber().intValue(), 1);
        assertEquals(nestedIntegers.get(0).getNestedList().get(1).getNumber().intValue(), 2);
        assertEquals(nestedIntegers.get(0).getNestedList().get(2).getNumber().intValue(), 3);
        assertFalse(nestedIntegers.get(1).isArray());
        assertEquals(nestedIntegers.get(1).getNumber().intValue(), 4);

        nestedIntegers = builder.buildNestedList("[[1,2,3],[4,5,6]");
        assertEquals(nestedIntegers.size(), 2);
        assertTrue(nestedIntegers.get(0).isArray());
        assertNotNull(nestedIntegers.get(0).getNestedList());
        assertEquals(nestedIntegers.get(0).getNestedList().size(), 3);
        assertEquals(nestedIntegers.get(0).getNestedList().get(0).getNumber().intValue(), 1);
        assertEquals(nestedIntegers.get(0).getNestedList().get(1).getNumber().intValue(), 2);
        assertEquals(nestedIntegers.get(0).getNestedList().get(2).getNumber().intValue(), 3);
        assertTrue(nestedIntegers.get(1).isArray());
        assertEquals(nestedIntegers.get(1).getNestedList().size(), 3);
        assertEquals(nestedIntegers.get(1).getNestedList().get(0).getNumber().intValue(), 4);
        assertEquals(nestedIntegers.get(1).getNestedList().get(1).getNumber().intValue(), 5);
        assertEquals(nestedIntegers.get(1).getNestedList().get(2).getNumber().intValue(), 6);

        nestedIntegers = builder.buildNestedList("[[1,2,3],[4,5,6],17]");
        assertEquals(nestedIntegers.size(), 3);
        assertTrue(nestedIntegers.get(0).isArray());
        assertTrue(nestedIntegers.get(1).isArray());
        assertFalse(nestedIntegers.get(2).isArray());
        assertEquals(nestedIntegers.get(2).getNumber().intValue(), 17);


        nestedIntegers = builder.buildNestedList("[[1,2,3],[4143,5,6],7]");
        assertEquals(nestedIntegers.size(), 3);
        assertEquals(nestedIntegers.get(1).getNestedList().get(0).getNumber().intValue(), 4143);

    }
}