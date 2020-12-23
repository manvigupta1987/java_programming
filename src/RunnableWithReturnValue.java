import java.util.Random;

public class RunnableWithReturnValue {
    public static void main(String[] args) {
        RunnableExample[] runnableExamples = new RunnableExample[5];
        for (int i=0; i<5; i++) {
//            runnableExamples[i] = new RunnableExample();
            Thread t = new Thread(runnableExamples[i]);
            t.start();
        }
        for (int i=0; i<5; i++) {
            try {
                System.out.println(runnableExamples[i].get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunnableExample implements Runnable {
    private  Object result = null;
    @Override
    public void run() {
        Random generator = new Random();
        Integer randomNumber = generator.nextInt(5);

        // As run cannot throw any Exception
        try
        {
            Thread.sleep(randomNumber * 1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // Store the return value in result when done
        result = randomNumber;
        synchronized (this) {
            notifyAll();
        }
    }

    public synchronized Object get() throws InterruptedException {
        while (result == null) {
            wait();
        }
        return result;
    }
}
