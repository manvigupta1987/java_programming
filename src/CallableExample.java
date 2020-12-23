import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample {
    public static void main(String[] args) {
        FutureTask[] randomNumberTasks = new FutureTask[5];

        for (int i=0; i< 5; i++) {
            Callable callable = new CallableDemo();
            randomNumberTasks[i] = new FutureTask(callable);
            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }

        for (int i=0; i< 5; i++) {
            // As it implements Future, we can call get()
            try {
                System.out.println(randomNumberTasks[i].get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            // This method blocks till the result is obtained
            // The get method can throw checked exceptions
            // like when it is interrupted. This is the reason
            // for adding the throws clause to main
        }
    }
}

class CallableDemo implements Callable {
    @Override
    public Object call() throws Exception {
        Random generator = new Random();
        Integer randomNumber = generator.nextInt(5);

        Thread.sleep(randomNumber * 1000);

        return randomNumber;
    }
}