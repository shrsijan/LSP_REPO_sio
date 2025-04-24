package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class defining the template method for report generation.
 */
public abstract class Report {
    /**
     * Template method defining the overall workflow.
     * This method is final to prevent alteration of the algorithm structure.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /** Load the report data (subclasses provide details). */
    protected abstract void loadData();

    /** Format the report data (subclasses provide details). */
    protected abstract void formatData();

    /** Print the final report (subclasses provide details). */
    protected abstract void printReport();
}
