package Lab23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Program1 {
    static int mThreads = 1000;
    static int delay = 10;

    public static void main(String[] args) 
    {
        System.out.print("asynchronous sums:");
        for (int i = 0; i < 10; i++)
        {
            System.out.printf(" %4d", asynchronous());
        }
        System.out.print("\n synchronous sums:");
        for (int i = 0; i < 10; i++)
        {
            System.out.printf(" %4d", synchronous());
        }
    }

    static int asynchronous()
    {
        final Integer sum = new Integer();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < mThreads; i++)
        {
            executor.execute(new IncTask(sum, delay));
        }
        executor.shutdown();
        try
        {
            executor.awaitTermination(2*delay, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        return sum.getValue();
    }

    static int synchronous() {
        final Integer sum = new Integer();
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < mThreads; i++)
        {
            synchronized (sum) 
            {
                executor.execute(new IncTask(sum, delay));
            }
        }
        executor.shutdown();
        try 
        {
            executor.awaitTermination(2*delay, TimeUnit.MILLISECONDS);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        return sum.getValue();
    }

}

class Integer {
    private int value;

    Integer() {
        this.reset();
    }

    int getValue() {
        return value;
    }

    void reset() {
        this.value = 0;
    }

    void increment(int amt) {
        this.value += amt;
    }
}


class IncTask implements Runnable 
{
    Integer sum;
    int delay;

    public IncTask(Integer sum, int delay) {
        this.sum = sum;
        this.delay = delay;
    }

    @Override
    public void run() 
    {
        sum.increment(1);
        try
        {
            Thread.sleep(delay); // introduce delay to reveal errors
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}