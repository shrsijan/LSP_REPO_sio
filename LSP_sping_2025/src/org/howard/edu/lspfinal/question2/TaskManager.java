package org.howard.edu.lspfinal.question2;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * Manages tasks: adding, retrieving, updating status, and printing grouped by status.
 */
public class TaskManager {
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task to the manager.
     * @param name unique name of the task
     * @param priority integer priority (lower number = higher priority)
     * @param status initial status of the task ("TODO", "IN_PROGRESS", or "DONE")
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException(String.format("Task '%s' already exists.", name));
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its name.
     * @param name name of the task to retrieve
     * @return the Task object
     * @throws TaskNotFoundException if no task with the specified name exists
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task t = tasks.get(name);
        if (t == null) {
            throw new TaskNotFoundException(String.format("Task '%s' not found.", name));
        }
        return t;
    }

    /**
     * Updates the status of an existing task.
     * @param name name of the task
     * @param status new status ("TODO", "IN_PROGRESS", or "DONE")
     * @throws TaskNotFoundException if no task with the specified name exists
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        Task t = getTaskByName(name);
        t.setStatus(status);
    }

    /**
     * Prints all tasks grouped by their status.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        for (String stat : Arrays.asList("TODO", "IN_PROGRESS", "DONE")) {
            System.out.println(stat + ":");
            for (Task t : tasks.values()) {
                if (t.getStatus().equals(stat)) {
                    System.out.println("  " + t);
                }
            }
        }
    }
}
