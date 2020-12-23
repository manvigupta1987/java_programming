package DesignPatterns;

import java.util.ArrayList;
import java.util.List;

//Structural Design Pattern
//The Observer Pattern defines a one to many dependency between objects so that one object changes state, all of its dependents are notified and updated automatically
//One to many dependency is between Subject(One) and Observer(Many).
//There is dependency as Observers themselves don’t have access to data. They are dependent on Subject to provide them data.

public class ObserverPattern {
    public static void main(String[] args) {
        Channel channel = new Channel("Telusko");
        Subscriber subscriber1 = new Subscriber("Manvi");
        Subscriber subscriber2 = new Subscriber("Maruti");
        Subscriber subscriber3 = new Subscriber("Mohit");
        Subscriber subscriber4 = new Subscriber("Sharmila");
        Subscriber subscriber5 = new Subscriber("Lakshman");

        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);
        channel.subscribe(subscriber3);
        channel.subscribe(subscriber4);
        channel.subscribe(subscriber5);

        subscriber1.subscribeChannel(channel);
        subscriber2.subscribeChannel(channel);
        subscriber3.subscribeChannel(channel);
        subscriber4.subscribeChannel(channel);
        subscriber5.subscribeChannel(channel);

        channel.unsubscribe(subscriber1);

        channel.upload("Master the programming");



//        channel.unsubscribe(subscriber2);
//        channel.unsubscribe(subscriber3);
//        channel.unsubscribe(subscriber4);
//        channel.unsubscribe(subscriber5);
    }
}

interface Observer {
    public void update();
    public void subscribeChannel(Channel channel);
}


class Subscriber implements Observer {
    private String name;
    private Channel channel;

    Subscriber(String name) {
        this.name = name;
    }

    public void update() {
        System.out.println("Hey " + name + " Video Uploaded");
    }

    public void subscribeChannel(Channel channel) {
        channel = channel;
    }

}

interface Subject {
    void subscribe(Subscriber sub);
    void unsubscribe(Subscriber sub);
    void upload(String title);
}

class Channel implements Subject {
    List<Subscriber> subscribers;
    String title;

    Channel(String title) {
        subscribers = new ArrayList<>();
        this.title = title;
    }

    public void subscribe(Subscriber sub) {
        subscribers.add(sub);
    }

    public void unsubscribe(Subscriber sub) {
        subscribers.remove(sub);
    }

    void notifySubscriber() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

    public void upload(String title) {
        this.title = title;
        notifySubscriber();
    }
 }