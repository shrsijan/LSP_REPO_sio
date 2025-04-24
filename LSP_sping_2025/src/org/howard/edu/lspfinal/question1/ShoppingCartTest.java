package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test adding valid item")
    void testAddValidItem() {
        cart.addItem("Apple", 1.99);
        assertEquals(1, cart.getCartSize(), "Cart size should be 1 after adding one item");
        assertEquals(1.99, cart.getTotalCost(), 1e-6, "Total cost should equal the price of the added item");
    }

    @Test
    @DisplayName("Test adding item with empty name")
    void testAddItemEmptyName() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("", 5.00),
                "Adding an item with an empty name should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)  ")
    void testAddItemZeroPrice() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("Banana", 0.0),
                "Adding an item with zero price should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    void testAddItemNegativePrice() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem("Orange", -2.50),
                "Adding an item with negative price should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Test removing existing item")
    void testRemoveExistingItem() {
        cart.addItem("Apple", 1.99);
        assertTrue(cart.removeItem("Apple"), "removeItem should return true for an item that exists");
        assertEquals(0, cart.getCartSize(), "Cart should be empty after removing the only item");
    }

    @Test
    @DisplayName("Test removing non-existent item")
    void testRemoveNonExistentItem() {
        assertFalse(cart.removeItem("NonExistent"),
                "removeItem should return false when trying to remove an item not in the cart");
    }

    @Test
    @DisplayName("Test cart size updates correctly after adding/removing")
    void testCartSizeUpdatesCorrectly() {
        cart.addItem("A", 1.00);
        cart.addItem("B", 2.00);
        assertEquals(2, cart.getCartSize(), "Cart size should be 2 after adding two items");
        cart.removeItem("A");
        assertEquals(1, cart.getCartSize(), "Cart size should decrease to 1 after removing one item");
    }

    @Test
    @DisplayName("Test total cost without discount")
    void testTotalCostWithoutDiscount() {
        cart.addItem("Apple", 1.00);
        cart.addItem("Banana", 2.00);
        assertEquals(3.00, cart.getTotalCost(), 1e-6, "Total cost should be sum of all prices when no discount applied");
    }

    @Test
    @DisplayName("Test total cost with discount")
    void testTotalCostWithDiscount() {
        cart.addItem("Apple", 10.00);
        cart.addItem("Banana", 10.00);
        cart.applyDiscountCode("SAVE10");
        assertEquals(18.00, cart.getTotalCost(), 1e-6, "10% discount on $20 total should yield $18");
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    void testTotalCostEmptyCart() {
        assertEquals(0.00, cart.getTotalCost(), 1e-6, "Empty cart should have total cost of $0.00");
    }

    @Test
    @DisplayName("Test for applying \"SAVE10\"")
    void testApplySave10() {
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), 1e-6, "Discount percentage should be 10 after applying SAVE10");
    }

    @Test
    @DisplayName("Test for applying \"SAVE20\"")
    void testApplySave20() {
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), 1e-6, "Discount percentage should be 20 after applying SAVE20");
    }

    @Test
    @DisplayName("Test for applying invalid code (expect exception)")
    void testApplyInvalidDiscountCode() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> cart.applyDiscountCode("SAVE50"),
                        "Invalid code should throw IllegalArgumentException"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> cart.applyDiscountCode(""),
                        "Empty code should throw IllegalArgumentException")
        );
    }
}
