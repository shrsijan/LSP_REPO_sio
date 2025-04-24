package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when attempting to add a task that already exists.
 */
public class DuplicateTaskException extends Exception {
    /**
     * Constructs a DuplicateTaskException with the specified detail message.
     * @param message the detail message
     */
    public DuplicateTaskException(String message) {
        super(message);
    }
}
