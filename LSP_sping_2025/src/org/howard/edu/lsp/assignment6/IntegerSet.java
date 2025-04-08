package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.List;

/**
 * IntegerSet is a class that represents a set of integers, backed by an ArrayList.
 * Duplicates are not allowed in this set.
 */
public class IntegerSet  {
    // Store the set elements in an ArrayList.
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor. Initializes the internal list to be empty.
     */
    public IntegerSet() {
    }

    /**
     * Overloaded constructor that accepts an ArrayList of integers.
     * Any duplicates in the passed ArrayList will be ignored while constructing this set.
     * @param set ArrayList of integers
     */
    public IntegerSet(ArrayList<Integer> set) {
        // Add elements individually to avoid duplicates
        for (Integer i : set) {
            add(i);
        }
    }

    /**
     * Clears the internal representation of the set.
     * All elements are removed.
     */
    public void clear() {
        this.set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * @return size of the set
     */
    public int length() {
        return this.set.size();
    }

    /**
     * Checks if this set is equal to another object.
     * Two IntegerSet objects are equal if they contain the same elements (regardless of order).
     * @param o another Object
     * @return true if the sets contain the same elements, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        // If the object is not an IntegerSet, they can't be equal
        if (!(o instanceof IntegerSet)) {
            return false;
        }
        IntegerSet otherSet = (IntegerSet) o;

        // If the two sets don't have the same size, they can't be equal
        if (this.length() != otherSet.length()) {
            return false;
        }

        // Check if every element in this set is contained in the otherSet
        for (Integer value : this.set) {
            if (!otherSet.contains(value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the set contains the given value, otherwise false.
     * @param value integer to look for
     * @return true if value is in the set, false otherwise
     */
    public boolean contains(int value) {
        return this.set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     * @return largest integer
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cannot fetch largest from an empty set.");
        }
        int max = this.set.get(0);
        for (int val : this.set) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    /**
     * Returns the smallest item in the set.
     * @return smallest integer
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cannot fetch smallest from an empty set.");
        }
        int min = this.set.get(0);
        for (int val : this.set) {
            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    /**
     * Adds an item to the set if it is not already present.
     * @param item integer to add
     */
    public void add(int item) {
        if (!this.set.contains(item)) {
            this.set.add(item);
        }
    }

    /**
     * Removes an item from the set if it is present; otherwise, does nothing.
     * @param item integer to remove
     */
    public void remove(int item) {
        this.set.remove(Integer.valueOf(item));
    }

    /**
     * Modifies this set to be the union of itself and another IntegerSet.
     * (i.e., this set will contain all elements that appear in either set.)
     * @param intSetb another IntegerSet
     */
    public void union(IntegerSet intSetb) {
        for (Integer val : intSetb.set) {
            this.add(val);  // add() will handle duplicates
        }
    }

    /**
     * Modifies this set so that it only contains elements also found in intSetb.
     * @param intSetb another IntegerSet
     */
    public void intersect(IntegerSet intSetb) {
        this.set.retainAll(intSetb.set);
    }

    /**
     * Modifies this set by removing any elements that also appear in intSetb.
     * (i.e., set difference s1 - s2)
     * @param intSetb another IntegerSet
     */
    public void diff(IntegerSet intSetb) {
        this.set.removeAll(intSetb.set);
    }

    /**
     * Modifies this set to become the "complement" with respect to intSetb.
     * Interpreted here as: s1 = all elements in s2 that are NOT in s1.
     * @param intSetb another IntegerSet
     */
    public void complement(IntegerSet intSetb) {
        // s1 = s2 - s1
        List<Integer> complementSet = new ArrayList<>(intSetb.set);
        complementSet.removeAll(this.set);
        this.set = complementSet;
    }

    /**
     * Returns true if the set is empty, false otherwise.
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return this.set.isEmpty();
    }

    /**
     * Returns a string representation of the set (for example, [1, 2, 3]).
     * @return string representation of this set
     */
    @Override
    public String toString() {
        return this.set.toString();
    }
}
