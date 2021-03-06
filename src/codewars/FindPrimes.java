package codewars;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by bartelby on 1/16/17.
 */
public class FindPrimes {
    private static boolean[] isPrime;
    public static List<Integer> primes = new ArrayList<Integer>();

    private static void fillSieve(int n) {
        Arrays.fill(isPrime, true);        // assume all integers are prime.
        isPrime[0] = isPrime[1] = false;       // we know 0 and 1 are not prime.
        for (int i = 0; i < n; i++) {
            //if the number is prime,
            //then go through all its multiples and make their values false.
            if (isPrime[i]) {
                for (int j = 2; i * j < n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
    }

    private static int findPrimes() {
        for (int i = 0; i < isPrime.length; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }
        return primes.size();
    }

    public static void main(String[] args) {
        //int n = Integer.parseInt(args[0]);
        int n = (int)Math.floor(Math.sqrt(Integer.MAX_VALUE));
        isPrime = new boolean[Integer.MAX_VALUE];
        long start = System.currentTimeMillis();
        fillSieve(n);
        int found = findPrimes();
        long end = System.currentTimeMillis();
        System.out.println(String.format("Found %d primes in the first %d numbers. Elapsed time: %d milis", found, n, (end-start)));
    }
}
