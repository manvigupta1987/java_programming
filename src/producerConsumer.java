import java.util.LinkedList;

// The problem describes two processes, the producer and the consumer, which share a common, fixed-size buffer used as a queue.
//
//The producer’s job is to generate data, put it into the buffer, and start again.
//At the same time, the consumer is consuming the data (i.e. removing it from the buffer), one piece at a time.
//Problem
//To make sure that the producer won’t try to add data into the buffer if it’s full and that the consumer won’t try to remove data from an empty buffer.



public class producerConsumer {
    public static void main(String[] args) throws InterruptedException {
        final PC pc = new PC();
        Thread T1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread T2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        T1.start();
        T2.start();

        T1.join();
        T2.join();

    }
}



class PC {

    LinkedList <Integer> linkedList = new LinkedList<>();
    int capacity = 2;

    public void produce() throws InterruptedException {
        int value = 0;
        while(true) {
            synchronized (this) {  // this makes sure that either a producer or consumer thread runs at a time.
                while(linkedList.size() == capacity) {
                    wait();
                }
                System.out.println("Producer produced-"  + value);
                linkedList.add(value++);
                notify(); // In both the methods, we use notify at the end of all statements.
                // The reason is simple, once you have something in list, you can have the consumer thread consume it,
                // or if you have consumed something, you can have the producer produce something.

                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if(linkedList.size() == 0) {
                    wait();
                }
                int val = linkedList.removeFirst();
                System.out.println("Consumer consumed-"  + val);

                notify(); // In both the methods, we use notify at the end of all statements. The reason is simple, once you have something in list, you can have the consumer thread consume it, or if you have consumed something, you can have the producer produce something.
                Thread.sleep(1000);
            }
        }
    }
}