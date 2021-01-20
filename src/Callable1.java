// Callable using The executor service as we can't create thread using callable.

import java.util.concurrent.*;

public class Callable1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new FactorialTask(5));
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }



}

class FactorialTask implements Callable {

        int number;

        // standard constructors
    FactorialTask(int num) {
        this.number = num;
    }

        public Integer call() throws Exception {
            int fact = 1;
            // ...
            for(int count = number; count > 1; count--) {
                fact = fact * count;
            }

            return fact;
        }

    }

