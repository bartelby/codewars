package codewars;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


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
public class Solution {

    public static int solveSuperMarketQueue(int[] customers, int n) {
        List<TillThread> tills = new ArrayList<TillThread>();
        for(int i=0; i < n; n++) {

        }
        return 42;
    }

    class TillThread implements Runnable {

        public int ticks;
        public void setTicks(int ticks) { this.ticks = ticks;}

        public void run() {}

    }

}
