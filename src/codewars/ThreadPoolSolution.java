package codewars;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/**
 * Created by Peter on 1/7/17.
 */
/*
    There is a queue for the self-checkout tills at the supermarket. Your task is write a function to calculate
    the total time required for all the customers to check out!

    The function has two input variables:

        customers: an array (list in python) of positive integers representing the queue. Each integer represents a
        customer, and its value is the amount of time they require to check out.
        n: a positive integer, the number of checkout tills.

    The function should return an integer, the total time required.

    Assume that the front person in the queue (i.e. the first element in the array/list) proceeds to a till as soon as
    it becomes free. So, for example:

    N.B. You should assume that all the test input will be valid, as specified above.

    P.S. The situation in this kata can be likened to the more-computer-science-related idea of a thread pool,
    with relation to running multiple processes at the same time: https://en.wikipedia.org/wiki/Thread_poo
 */
public class ThreadPoolSolution {


    public static int solveSuperMarketQueue(int[] customers, int n) {
        //BlockingQueue<Runnable> q = new ArrayBlockingQueue<Runnable>(n);
        ExecutorService threadPool = Executors.newFixedThreadPool(n);
        int[] queued = new int[n];
        //ExecutorService threadPool = new ThreadPoolExecutor(n,n, 100, TimeUnit.SECONDS, q);
        long start = System.currentTimeMillis();
        for (int customer : customers) {
            try {
                threadPool.execute(new TillThread(customer));
            }
            catch (RejectedExecutionException rex) {
            }
        }
        threadPool.shutdown();
        while(!threadPool.isTerminated()) {}
        long end = System.currentTimeMillis();
        // return (int) java.lang.Math.floor((end-start)/100);
        return 42;
    }

    public static void main(String[] args) {
        //int[] customers = {4,7,7,1,2,6,4,1,7,3,5,2,1,7,7,7,6,7,3,1,4,3,6};
        int[] customers = {3,2};
        int tills = 2;
        ThreadPoolSolution me = new ThreadPoolSolution();
        int count = me.solveSuperMarketQueue(customers, tills);
        System.out.println(count);
    }

    private static class TillThread implements Runnable {

        private int ticks = 0;

        TillThread(int ticks) {
            this.ticks = ticks;
        }
        boolean isEmpty() { return ticks == 0;}

        public void run() {
           // try {
            System.out.println(Thread.currentThread().getName());
                while(!isEmpty()) {
                    ticks--;
                 //   Thread.currentThread().sleep(20);
                }
           // }
           // catch (InterruptedException ignore) {}
        }

    }

}