//1. **Zoo Management System** 🦁🐒🐧
//
//        * Abstract class: `Animal` (method `makeSound()`).
//        * Subclasses: `Lion`, `Monkey`, `Penguin`.
//        * Store animals in a `List<Animal>` (demonstrating **polymorphism**).
//        * Features: feed animals, display zoo inventory.
package projects.project1;

import java.util.*;

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();

    //TODO: all the animals don't eat the same thing
    public void feed() {}

    public String toString(){
       return "Hello my name is : " + getName();  
    }
}