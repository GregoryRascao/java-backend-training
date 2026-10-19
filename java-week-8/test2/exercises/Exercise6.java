package test2.exercises;

/**
 * Exercise 6: Testing with Arrange-Act-Assert
 * 
 * Tasks:
 * 1. Implement the TodoList class with the specified functionality
 * 2. Write validation methods following the AAA pattern
 * 3. Each validation method should return true if passed, false if failed
 * 4. Count and report how many validations passed/failed
 * 
 * The TodoList should support:
 * - Adding tasks
 * - Removing tasks
 * - Marking tasks as complete
 * - Getting count of all tasks
 * - Getting count of completed tasks
 * - Clearing all tasks
 */
public class Exercise6 {
    
    public static void main(String[] args) {
        System.out.println("=== Exercise 3: Todo List Validation ===\n");
        
        int passed = 0;
        int total = 0;
        
        // * Run each validation method and track results
        // Example:
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
  
        // * Print summary of results
        System.out.println("Total " + total);
        System.out.println("Passed " + passed);
        System.out.println("Total " + total);
        System.out.println("Failed " + (total - passed));
        
    }
    
    // ========== Validation Methods (TO IMPLEMENT) ==========
    
    // TODO: Implement validateAddTask
    // Should verify that adding a task increases the task count
    public static boolean validateAddTask() {
        String testName = "Adding task increases count";
        System.out.println("Running: " + testName);
        
        try {
            // ARRANGE - Create TodoList and get initial count
            TodoList todoList = new TodoList();
            int initialCount = todoList.getTotalCount();
            
            
            // ACT - Add a task
            todoList.addTask("Learn Java");
            
            
            // ASSERT - Verify count increased
            assert todoList.getCompletedCount() == initialCount + 1 : "Should increase";
            
            
            System.out.println("  ✓ PASSED\n");
            return true;
            
        } catch (AssertionError e) {
            System.out.println("  ✗ FAILED: " + e.getMessage() + "\n");
            return false;
        }
    }
    
    // TODO: Implement validateRemoveTask
    // Should verify that removing a task decreases the task count
    public static boolean validateRemoveTask() {
        // Your AAA pattern here
        try {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }
    
    // TODO: Implement validateCompleteTask
    // Should verify that marking a task as complete increases completed count
    public static boolean validateCompleteTask() {
        // Your AAA pattern here
        return false;
    }
    
    // TODO: Implement validateClearTasks
    // Should verify that clearing removes all tasks
    public static boolean validateClearTasks() {
        // Your AAA pattern here
        return false;
    }
    
    // TODO: Implement validateCompletedCount
    // Should verify that completed count is accurate after completing multiple tasks
    public static boolean validateCompletedCount() {
        // Your AAA pattern here
        return false;
    }
}

// TODO: Implement TodoList class
// Should have:
// - List<Task> tasks
// - addTask(String description)
// - removeTask(Task task)
// - completeTask(Task task)
// - getTotalCount()
// - getCompletedCount()
// - clear()


// TODO: Implement Task class
// Should have:
// - String description
// - boolean completed
// - Constructor
// - Getters and setters
