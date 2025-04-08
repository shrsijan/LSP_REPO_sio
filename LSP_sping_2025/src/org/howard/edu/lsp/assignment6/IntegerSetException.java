package org.howard.edu.lsp.assignment6;

/**
 * Custom exception to be thrown when operations fail due to an empty set.
 */
public class IntegerSetException extends Exception {
    /**
     * Constructs an IntegerSetException with a given message.
     * @param message The detail message.
     */
    public IntegerSetException(String message) {
        super(message);
    }
}
