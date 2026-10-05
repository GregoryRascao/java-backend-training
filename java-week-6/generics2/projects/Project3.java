package generics2.projects;

/**
 * Project 3: Generic Event System
 *
 * In many applications we want to send events and notify listeners.
 * For example:
 * - a user logs in
 * - a file is uploaded
 * - a message is received
 *
 * Your task is to build a simple generic event system.
 *
 * Step 1
 * Create a generic interface:
 *
 * interface EventListener<T>
 *
 * It should contain one method:
 *
 * void onEvent(T event)
 *
 *
 * Step 2
 * Create a generic class:
 *
 * EventBus<T>
 *
 * Inside the class store a list of listeners.
 *
 * List<EventListener<T>> listeners
 *
 *
 * Step 3
 * Implement a method:
 *
 * void register(EventListener<T> listener)
 *
 * This method should add a listener to the list.
 *
 *
 * Step 4
 * Implement a method:
 *
 * void publish(T event)
 *
 * This method should send the event to all registered listeners.
 * Each listener should receive the event by calling:
 *
 * listener.onEvent(event)
 *
 *
 * Step 5
 * In main():
 *
 * - Create an EventBus<String>
 * - Register a listener that prints the event
 * - Publish a few events
 *
 * Example output:
 *
 * Received event: Hello
 * Received event: Generics are powerful
 */
public class Project3 {
    //EventListener<String> listener = event ->
    //        System.out.println("Received: " + event);
}
