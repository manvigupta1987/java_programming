import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        Worker first = new Worker("first", latch, 1000);
        Worker second = new Worker("second", latch, 2000);
        Worker third = new Worker("third", latch, 2000);
        Worker fourth = new Worker("fourth", latch, 3000);

        first.start();
        second.start();
        third.start();
        fourth.start();

        latch.await();

        // Main thread has started
        System.out.println(Thread.currentThread().getName() +
                " has finished");

    }

}

class Worker extends Thread {
    public int delay;
    private CountDownLatch countDownLatch;
    Worker(String name, CountDownLatch countDownLatch, int delay) {
        super(name);
        this.countDownLatch = countDownLatch;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            this.countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()  + " finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
