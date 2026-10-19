package test2.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 7: Testing with Arrange-Act-Assert
 *
 * Have a skim on this one because it is mostly repeated on Exercise6
 *
 * Tasks:
 * Some parts of Exercise 6 is completed on exercise 7, this is focused only on some parts of testing.
 * Try to use built in assert and then JUnit.
 */
public class Exercise7 {
    
    public static void main(String[] args) {
        System.out.println("=== Exercise 6: Todo List Validation ===\n");
        
        int passed = 0;
        int total = 0;
        
        total++;
        if (validateAddTask()) passed++;

        total++;
        if (validateRemoveTask()) passed++;

        total++;
        if (validateCompleteTask()) passed++;

        total++;
        if (validateClearTasks()) passed++;

        total++;
        if (validateCompletedCount()) passed++;

        System.out.println("=".repeat(50));
        System.out.println("Results: " + passed + "/" + total + " validations passed");
        System.out.println("=".repeat(50));
        
    }
    
    // ========== Validation Methods (TO IMPLEMENT) ==========

    // Should verify that adding a task increases the task count
    public static boolean validateAddTask() {
        String testName = "Adding task increases count";
        System.out.println("Running: " + testName);
        
        try {
            // ARRANGE
            TodoList todoList = new TodoList();
            int initialCount = todoList.getTotalCount();

            // ACT
            // TODO: the act

            // ASSERT
            int finalCount = todoList.getTotalCount();
            if (finalCount != initialCount + 1) {
                throw new AssertionError("Expected total count to increase by 1");
            }
            
            System.out.println("  ✓ PASSED\n");
            return true;
            
        } catch (AssertionError e) {
            System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
            return false;
        }
    }

    // Should verify that removing a task decreases the task count
    public static boolean validateRemoveTask() {
        String testName = "Removing task decreases count";
        System.out.println("Running: " + testName);

        try {
            // ARRANGE
            //TODO: arrange
            TodoList todoList;
            Task task;
            int countAfterAdding;

            // ACT
            //todoList.removeTask(task);        //TODO uncomment and fix arrange

            // ASSERT
            /* TODO uncomment
            int finalCount = todoList.getTotalCount();
            if (finalCount != countAfterAdding - 1) {
                throw new AssertionError("Expected total count to decrease by 1");
            }
            */
            System.out.println("  ✓ PASSED\n");
            return true;

        } catch (AssertionError e) {
            System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
            return false;
        }
    }

    // Should verify that marking a task as complete increases completed count
    public static boolean validateCompleteTask() {
        String testName = "Completing task increases completed count";
        System.out.println("Running: " + testName);

        try {
            // ARRANGE

            // ACT


            /* ASSERT
            // TODO uncomment this part and fix
            int finalCompleted = todoList.getCompletedCount();
            if (finalCompleted != initialCompleted + 1) {
                throw new AssertionError("Expected completed count to increase by 1");
            }*/

            System.out.println("  ✓ PASSED\n");
            return true;

        } catch (AssertionError e) {
            System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
            return false;
        }
    }

    // Should verify that clearing removes all tasks
    public static boolean validateClearTasks() {
        String testName = "Clearing tasks removes all items";
        System.out.println("Running: " + testName);

        try {
            // ARRANGE
            TodoList todoList = new TodoList();
            todoList.addTask("Task 1");
            todoList.addTask("Task 2");

            // ACT
            todoList.clear();

            // ASSERT
            //TODO test if totalcount and completed count are OK


            System.out.println("  ✓ PASSED\n");
            return true;

        } catch (AssertionError e) {
            System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
            return false;
        }
    }

    // Should verify that completed count is accurate after completing multiple tasks
    public static boolean validateCompletedCount() {
        String testName = "Completed count is accurate for multiple tasks";
        System.out.println("Running: " + testName);

        try {
            // ARRANGE
            TodoList todoList = new TodoList();
            Task task1 = todoList.addTask("Task A");
            Task task2 = todoList.addTask("Task B");
            todoList.addTask("Task C");

            //TODO act and assert

            System.out.println("  ✓ PASSED\n");
            return true;

        } catch (AssertionError e) {
            System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
            return false;
        }
    }
}

class TodoList {
    private final List<Task> tasks = new ArrayList<>();

    public Task addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        return task;
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void completeTask(Task task) {
        task.setCompleted(true);
    }

    public int getTotalCount() {
        return tasks.size();
    }

    public int getCompletedCount() {
        int completedCount = 0;
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedCount++;
            }
        }
        //TODO REFACTOR using a stream
        return completedCount;
    }

    public void clear() {
        tasks.clear();
    }
}


class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
