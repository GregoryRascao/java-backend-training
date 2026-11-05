# Mini Project: Parallel Task Runner

## Goal

Learn how to run multiple tasks in parallel using:

- `ExecutorService`
- `Callable`
- `Future`

## Task

Create a program that runs 3 tasks:

- Task A → waits 1 second, returns `"Task A done"`
- Task B → waits 2 seconds, returns `"Task B done"`
- Task C → waits 3 seconds, returns `"Task C done"`

All tasks should start without waiting for each other.

After that, print their results.

## Requirements

- Use `ExecutorService`
- Use `Callable<String>`
- Use `Future<String>`
- Shut down the executor at the end

## Expected idea

If the tasks run in parallel, the total time should be close to 3 seconds,
not 6 seconds.

## Bonus

- Measure the total execution time
- Print the thread name inside each task