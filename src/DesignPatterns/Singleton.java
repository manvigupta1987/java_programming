package DesignPatterns;

// Creational Design Pattern:
//Summary : The singleton pattern is a design pattern that restricts the instantiation of a class to one object.
// READ it --> https://www.geeksforgeeks.org/singleton-design-pattern/
//https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/
// https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/
//https://medium.com/@kevalpatel2106/digesting-singleton-design-pattern-in-java-5d434f4f322
// https://medium.com/swlh/a-complete-guide-on-singleton-design-pattern-in-java-846c2f8df5fc

public class Singleton {
    //Volatile keyword ensures that multiple threads offer the obj variable correctly when it is being initialized to Singleton instance
    private static volatile  Singleton obj = null;
    public String s;
    private Singleton() {
        // prevent from the reflection api.
        if (obj != null) {
            throw new RuntimeException("Use getInstance() method to get the singleton instance" );
        }
        s = "Hello I am a string part of Singleton class";
    }

    // Double checked locking method.
    public static Singleton getInstance() {
        if (obj == null) {
            // It reduces the overhead of calling synchronized multiple times as once a object is created, we dont need to worry about the synchronization.
            synchronized (Singleton.class) {
                if (obj == null) {
                    obj = new Singleton();
                }
            }
        }
        return obj;
    }
}

class Main {
    public static void main(String[] args) {
        // we instantiate the singleton class with 3 objects x, y, z by calling static method getInstance(). But actually after creation of object x,
        // variables y and z are pointed to object x as shown in the diagram.
        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
        Singleton z = Singleton.getInstance();

        x.s = (x.s).toUpperCase();

        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
        System.out.println("\n");
    }
}
