package codewars;

/**
 * Created by bartelby on 1/8/17.
 */
/*
    I first attempted this using a thread pool and counting the actual time in seconds - this led to excesive
    execution times.  Thinking about it, it seems to me that an effective single-threaded algorithm would be:
        create an array of n till queues
        for each customer
            for each queue
                if queue is empty
                    put customer in queue
            find max and min queue values
            add min to total time
            for each queue
                subtract min from queue
 */
import java.util.ArrayList;
public class Solution {

    public static int solveSuperMarketQueue(int[] cs, int n) {
        int[] queues = new int[n];
        ArrayList<Integer> customers = new ArrayList<Integer>();
        for (int c : cs) { customers.add(c);}
        int total_time = 0;
        while (customers.iterator().hasNext()) {
            for (int queue = 0; queue < queues.length; queue++) {
                if (queues[queue] == 0 && customers.iterator().hasNext()) {
                    queues[queue] = customers.remove(0);
                }
            }
            if (isEmpty(queues) != null) {
                continue;
            }
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i = 0; i < queues.length; i++) {
                min = queues[i] < min ? queues[i] : min;
                max = queues[i] > max ? queues[i] : max;
            }
            total_time += min;
            for (int queue = 0; queue < queues.length; queue++) {
                queues[queue] -= min;
            }
        }
        int max = 0;
        for (int i = 0; i < queues.length; i++) {
            max = queues[i] > max ? queues[i] : max;
        }
        total_time += max;
        return total_time;
    }

    private static Integer isEmpty(int[] queues) {
        for (Integer i = 0; i < queues.length; i++) {
            if (queues[i] == 0) {
                return i;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        //int[] customers = {4,7,7,1,2,6,4,1,7,3,5,2,1,7,7,7,6,7,3,1,4,3,6};
        int[] customers = {3,2};
        //int[] customers = {3};
        int tills = 10;
        int count = Solution.solveSuperMarketQueue(customers, tills);
        System.out.println(count);
    }

}
