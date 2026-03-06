/*
Write a java program to illustrate concept of following inheritance
a.Single-level Inheritance    c.Mutli-level Inheritance
b.Hierarchical Inheritance    d.Multiple Inheritance using Inheritance
 */
package javalab;
// Single-level Inheritance
class Animal {
    void eat() {
        System.out.println("Animal eats food");
    }
}

class Dog extends Animal { // Single-level inheritance
    void bark() {
        System.out.println("Dog barks");
    }
}

// Multi-level Inheritance
class BabyDog extends Dog { // Multi-level inheritance (Animal -> Dog -> BabyDog)
    void weep() {
        System.out.println("BabyDog weeps");
    }
}

// Hierarchical Inheritance
class Cat extends Animal { // Another subclass of Animal
    void meow() {
        System.out.println("Cat meows");
    }
}

// Multiple Inheritance using Interfaces
interface Flyer {
    void fly();
}

interface Swimmer {
    void swim();
}

class Duck implements Flyer, Swimmer { // Multiple inheritance via interfaces
    public void fly() {
        System.out.println("Duck flies");
    }

    public void swim() {
        System.out.println("Duck swims");
    }
}

// Main Class
public class Q18 {
    public static void main(String[] args) {
        System.out.println("Single-level Inheritance");
        Dog dog = new Dog();
        dog.eat(); // inherited from Animal
        dog.bark();

        System.out.println("\nMulti-level Inheritance");
        BabyDog babyDog = new BabyDog();
        babyDog.eat(); // inherited from Animal
        babyDog.bark(); // inherited from Dog
        babyDog.weep();

        System.out.println("\nHierarchical Inheritance");
        Cat cat = new Cat();
        cat.eat(); // inherited from Animal
        cat.meow();

        System.out.println("\nMultiple Inheritance using Interfaces");
        Duck duck = new Duck();
        duck.fly();
        duck.swim();
    }
}

