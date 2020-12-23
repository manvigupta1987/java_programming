import java.util.LinkedList;

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
            synchronized (this) {
                while(linkedList.size() == capacity) {
                    wait();
                }
                System.out.println("Producer produced-"  + value);
                linkedList.add(value++);
                notify();

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

                notify();
                Thread.sleep(1000);
            }
        }
    }
}