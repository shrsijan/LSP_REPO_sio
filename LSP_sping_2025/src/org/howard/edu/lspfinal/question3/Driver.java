package org.howard.edu.lspfinal.question3;

/**
 * Driver class to demonstrate the report generation framework.
 */
public class Driver {
    /**
     * Main method demonstrating generation of sales and inventory reports.
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        Report salesReport = new SalesReport();
        salesReport.generateReport();

        System.out.println();

        Report inventoryReport = new InventoryReport();
        inventoryReport.generateReport();
    }
}
