package DesignPatterns;

//Creational Pattern :
// Separate the construction of a complex object from its representation so that the same construction process can
// create different representations.”
// It is used to construct a complex object step by step and the final step will return the object.

// Advantages:
//1. The parameters to the constructor are reduced and are provided in highly readable method calls.
//2. Builder design pattern also helps in minimizing the number of parameters in constructor and thus there is no need to pass in null for optional parameters to the constructor.

// Disadvantage:
// Requires building a seprate builder for each different type of product.


public class Builder {
    public static void main(String[] args) {
        Phone android = new PhoneBuilder().setOs("Android")
                                          .setBattery(1)
                                          .setRam(2)
                                          .setProcessor("latest")
                                          .setScreenSize(5.6)
                                          .build();

        System.out.println(android);


    }
}

class PhoneBuilder{
    private String os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    public String getOs() {
        return os;
    }

    public int getRam() {
        return ram;
    }

    public String getProcessor() {
        return processor;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getBattery() {
        return battery;
    }

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public Phone build() {
        Phone phone = new Phone(this);
        return phone;
    }
}

class Phone {
    private String os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    Phone(PhoneBuilder phoneBuilder) {
        this.os = phoneBuilder.getOs();
        this.ram = phoneBuilder.getRam();
        this.processor = phoneBuilder.getProcessor();
        this.screenSize = phoneBuilder.getScreenSize();
        this.battery = phoneBuilder.getBattery();
    }

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                ", screenSize=" + screenSize +
                ", battery=" + battery +
                '}';
    }
}
