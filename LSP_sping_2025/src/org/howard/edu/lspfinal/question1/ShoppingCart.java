package org.howard.edu.lspfinal.question1;

/**
 * changed few comments as well as the additems
 * added removeitem and cartsize as it was not in the driver.
 * - referenced the assignment
 */
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simple shopping cart that allows adding items,
 * removing items, applying discount codes, and calculating the total cost.
 */
public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();
    private double discountPercentage = 0.0;

    /**
     * Adds an item to the shopping cart.
     *
     * @param itemName the name of the item (must be non-empty)
     * @param price    the price of the item (must be strictly positive)
     * @throws IllegalArgumentException if itemName is null/empty or price is <= 0
     */
    public void addItem(String itemName, double price) {
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }
        items.put(itemName, price);
    }

    /** Adding this as this is mentioned in the requirement
     * Removes an item from the shopping cart.
     *
     * @param itemName the name of the item to remove
     * @return true if the item was removed, false if it was not found
     */
    public boolean removeItem(String itemName) {
        return items.remove(itemName) != null;
    }

    /** Adding this as this is mentioned in the requirement
     * Returns the number of items in the cart.
     *
     * @return count of items
     */
    public int getCartSize() {
        return items.size();
    }

    /**
     * Calculates and returns the total cost of the cart,
     * applying any discounts currently in effect.
     *
     * @return total cost after applying discount
     */
    public double getTotalCost() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        double discountAmount = total * (discountPercentage / 100.0);
        return total - discountAmount;
    }

    /**
     * Applies a valid discount code to the shopping cart.
     * Supported codes:
     * - "SAVE10": 10% discount
     * - "SAVE20": 20% discount
     *
     * @param code the discount code
     * @throws IllegalArgumentException if the code is invalid
     */
    public void applyDiscountCode(String code) {
        switch (code) {
            case "SAVE10":
                discountPercentage = 10.0;
                break;
            case "SAVE20":
                discountPercentage = 20.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount code.");
        }
    }

    /**
     * Returns the current discount percentage applied to the cart.
     *
     * @return the discount percentage (0.0 if no discount applied)
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
