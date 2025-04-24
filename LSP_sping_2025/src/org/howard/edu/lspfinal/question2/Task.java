package org.howard.edu.lspfinal.question2;

/**
 * Represents a task with a unique name, priority, and status.
 */
public class Task {
    private final String name;
    private final int priority;
    private String status;

    /**
     * Creates a new Task.
     * @param name unique name of the task
     * @param priority integer priority (lower number = higher priority)
     * @param status initial status of the task ("TODO", "IN_PROGRESS", or "DONE")
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /** @return the task name */
    public String getName() { return name; }

    /** @return the task priority */
    public int getPriority() { return priority; }

    /** @return the task status */
    public String getStatus() { return status; }

    /**
     * Sets a new status for the task.
     * @param status new status ("TODO", "IN_PROGRESS", or "DONE")
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the task.
     * @return formatted string with task details
     */
    @Override
    public String toString() {
        return String.format("Task{name='%s', priority=%d, status='%s'}", name, priority, status);
    }
}
