package DesignPatterns;

// Creational Design Pattern:
//Summary : The singleton pattern is a design pattern that restricts the instantiation of a class to one object. It can be used to create
// single DB connection shared by multiple objects as creating a seprate DB connection for every object may be costly.
// READ it --> https://www.geeksforgeeks.org/singleton-design-pattern/
//https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/
// https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/
//https://medium.com/@kevalpatel2106/digesting-singleton-design-pattern-in-java-5d434f4f322
// https://medium.com/swlh/a-complete-guide-on-singleton-design-pattern-in-java-846c2f8df5fc

// How do you make the class singleton:
// 1. Define the private constuctor and object as static. Create a getInstance public method where instance will only be created when the object is null.

// What are the issues with the singleton :
// 1. Singleton class should be thread safe. To achieve this, we can use following things:
//    --- make the getInstance function synchronized. However, this will decrease the performance of the program as to get the instance of the class, we need to
//        use synchronized everytime.

// 2. Instead of declaring the function getInstance as synchronized, use the synchronized only when the object is null as synchronizaton is not required when
//  object is created. Also, declare the variable as volatile.

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {
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

    //In serialization and deserialization, we store the state in the file and read it later point of time. When we deserialize this, it will create
    // a new instance of the class. To prevent this, we have to provide the implementation of readResolve in our singleton class.
    // Make singleton from serialize and deserialize operation.
    protected Singleton readResolve() {
        return getInstance();
    }

    //Now whenever user will try to create clone of singleton object, it will throw exception and hence our class remains singleton.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
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
