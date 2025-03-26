package org.howard.edu.lsp.assignment5;

/**
 * A sample driver class to demonstrate testing of IntegerSet methods.
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("Demonstrating IntegerSet functionality...\n");

        // 1. Create two empty sets
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        // 2. Add elements to set1
        System.out.println("Add 1, 2, 3 to set1.");
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Value of set1: " + set1.toString());

        // 3. Add elements to set2
        System.out.println("Add 3, 4, 5 to set2.");
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("Value of set2: " + set2.toString());
        System.out.println();

        // 4. Test largest and smallest
        System.out.println("Smallest value in set1: " + set1.smallest());
        System.out.println("Largest value in set1: " + set1.largest());
        System.out.println("Smallest value in set2: " + set2.smallest());
        System.out.println("Largest value in set2: " + set2.largest());
        System.out.println();

        // 5. Test union
        System.out.println("Performing union of set1 and set2...");
        System.out.println("set1 before union: " + set1.toString());
        System.out.println("set2 before union: " + set2.toString());
        set1.union(set2);
        System.out.println("set1 after union:  " + set1.toString());
        System.out.println("set2 remains:       " + set2.toString());
        System.out.println();

        // 6. Test intersect
        //re-initializing set1 and set2 for a clean demonstration
        set1.clear();
        set2.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        System.out.println("Demonstrating intersection...");
        System.out.println("set1: " + set1.toString());
        System.out.println("set2: " + set2.toString());
        set1.intersect(set2);
        System.out.println("After intersect, set1: " + set1.toString());
        System.out.println("set2 unchanged:        " + set2.toString());
        System.out.println();

        // 7. Test difference
        // reset again
        set1.clear();
        set2.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Demonstrating difference (set1 - set2)...");
        System.out.println("set1: " + set1.toString());
        System.out.println("set2: " + set2.toString());
        set1.diff(set2);
        System.out.println("After diff, set1: " + set1.toString());
        System.out.println("set2 unchanged:  " + set2.toString());
        System.out.println();

        // 8. Test complement
        // interpret complement as s1 = s2 - s1
        set1.clear();
        set2.clear();
        set1.add(1);
        set1.add(2);
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        System.out.println("Demonstrating complement (set1 = set2 - set1)...");
        System.out.println("set1: " + set1.toString());
        System.out.println("set2: " + set2.toString());
        set1.complement(set2);
        System.out.println("After complement, set1: " + set1.toString());
        System.out.println("set2 unchanged:        " + set2.toString());
        System.out.println();

        // 9. Test contains
        System.out.println("Does set1 contain 1? " + set1.contains(1));
        System.out.println("Does set2 contain 1? " + set2.contains(1));
        System.out.println();

        // 10. Test equals
        IntegerSet set3 = new IntegerSet();
        set3.add(3);
        set3.add(4);

        System.out.println("Testing equals...");
        System.out.println("set2: " + set2.toString());
        System.out.println("set3: " + set3.toString());
        System.out.println("Are set2 and set3 equal? " + set2.equals(set3));

        set3.add(2);
        set3.add(1);
        System.out.println("After adding {1,2} to set3, set3 is " + set3.toString());
        System.out.println("Are set2 and set3 equal now? " + set2.equals(set3));
        System.out.println();

        // 11. Test remove
        System.out.println("Removing 4 from set3...");
        set3.remove(4);
        System.out.println("set3 after removing 4: " + set3.toString());
        System.out.println();

        // 12. Test isEmpty
        System.out.println("Is set1 empty? " + set1.isEmpty());
        System.out.println("Clearing set1...");
        set1.clear();
        System.out.println("Is set1 empty now? " + set1.isEmpty());
        System.out.println();
    }
}
