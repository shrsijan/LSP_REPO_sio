package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit test cases for IntegerSet, ensuring all methods work properly.
 * Reference: junit.org
 */
public class IntegerSetTest {

    @Test
    @DisplayName("Test case for clear()")
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        assertFalse(set.isEmpty(), "Set should not be empty before clear");

        set.clear();
        assertEquals(true, set.isEmpty(), "Should be empty");
    }

    @Test
    @DisplayName("Test case for length()")
    public void testLength() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length(), "Newly created set should have length 0");

        set.add(10);
        set.add(20);
        set.add(30);
        assertEquals(3, set.length(), "Set should have length 3 after adding three elements");
    }

    @Test
    @DisplayName("Test case for equals(IntegerSet b)")
    public void testEquals() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        // Both empty => equal
        assertTrue(set1.equals(set2), "Two empty sets should be equal");

        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);

        // Same elements, different order => still equal
        assertTrue(set1.equals(set2), "Sets with same elements in different order are equal");

        set2.add(3);
        // set2 now has an extra element => not equal
        assertFalse(set1.equals(set2), "Sets differ in size => not equal");
    }

    @Test
    @DisplayName("Test case for contains(int value)")
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(10);

        assertTrue(set.contains(5), "Set should contain 5");
        assertTrue(set.contains(10), "Set should contain 10");
        assertFalse(set.contains(7), "Set should not contain 7");
    }

    @Test
    @DisplayName("Test case for largest()")
    public void testLargest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(50);
        set.add(3);
        assertEquals(50, set.largest(), "Largest should be 50");

        set.clear();
        assertThrows(IntegerSetException.class, () -> {
            set.largest();
        }, "Expected IntegerSetException for largest() on empty set");
    }

    @Test
    @DisplayName("Test case for smallest()")
    public void testSmallest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(4);
        set.add(2);
        set.add(10);
        set.add(1);
        assertEquals(1, set.smallest(), "Smallest should be 1");

        set.clear();
        assertThrows(IntegerSetException.class, () -> {
            set.smallest();
        }, "Expected IntegerSetException for smallest() on empty set");
    }

    @Test
    @DisplayName("Test case for add(int item)")
    public void testAdd() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(5);  // Duplicate; should not increase length
        assertEquals(1, set.length(), "Adding duplicate should not increase set size");

        set.add(10);
        assertEquals(2, set.length(), "Adding a new element should increase set size");
        assertTrue(set.contains(10), "Set should contain newly added element 10");
    }

    @Test
    @DisplayName("Test case for remove(int item)")
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(10);
        set.add(15);

        set.remove(10);
        assertFalse(set.contains(10), "Removed element should not be in set");
        assertEquals(2, set.length(), "Removing an existing element decreases length");

        // Removing nonexistent element => no change
        set.remove(100);
        assertEquals(2, set.length(), "No change if removed element not in set");
    }

    @Test
    @DisplayName("Test case for union(IntegerSet b)")
    public void testUnion() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);

        set1.union(set2);
        assertTrue(set1.contains(1), "After union, should contain 1");
        assertTrue(set1.contains(2), "After union, should contain 2");
        assertTrue(set1.contains(3), "After union, should contain 3");
        assertEquals(3, set1.length(), "Union merges unique elements");
    }

    @Test
    @DisplayName("Test case for intersect(IntegerSet b)")
    public void testIntersect() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        set1.intersect(set2);
        assertTrue(set1.contains(2), "Intersection should retain 2");
        assertTrue(set1.contains(3), "Intersection should retain 3");
        assertFalse(set1.contains(1), "Intersection should remove 1");
        assertFalse(set1.contains(4), "Intersection should not add 4");
        assertEquals(2, set1.length(), "Intersection result has size 2");
    }

    @Test
    @DisplayName("Test case for diff(IntegerSet b)")
    public void testDiff() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        set1.diff(set2);  // s1 - s2
        assertTrue(set1.contains(1), "Should still contain 1");
        assertTrue(set1.contains(2), "Should still contain 2");
        assertFalse(set1.contains(3), "Should remove 3");
        assertEquals(2, set1.length(), "Result of diff has length 2");
    }

    @Test
    @DisplayName("Test case for complement(IntegerSet b)")
    public void testComplement() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // complement => s1 = all elements in s2 that are NOT in s1
        set1.complement(set2);
        assertTrue(set1.contains(4), "After complement, should contain 4");
        assertTrue(set1.contains(5), "After complement, should contain 5");
        assertEquals(2, set1.length(), "Complement result length is 2");
        assertFalse(set1.contains(2), "Should not contain old elements 2");
        assertFalse(set1.contains(3), "Should not contain old elements 3");
    }

    @Test
    @DisplayName("Test case for isEmpty()")
    public void testIsEmpty() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty(), "Newly created set is empty");

        set.add(10);
        assertFalse(set.isEmpty(), "After adding an element, set is not empty");
    }

    @Test
    @DisplayName("Test case for toString()")
    public void testToString() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString(), "Empty set => []");

        set.add(1);
        set.add(2);
        String result = set.toString();
        // Could be [1, 2] or [2, 1], depending on internal order
        assertTrue(result.equals("[1, 2]") || result.equals("[2, 1]"),
                "String should display elements in the set");
    }
}
