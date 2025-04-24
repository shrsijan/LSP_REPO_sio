package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when a requested task cannot be found.
 */
public class TaskNotFoundException extends Exception {
    /**
     * Constructs a TaskNotFoundException with the specified detail message.
     * @param message the detail message
     */
    public TaskNotFoundException(String message) {
        super(message);
    }
}
