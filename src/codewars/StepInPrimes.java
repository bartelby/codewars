package codewars;

/**
 * Created by bartelby on 1/19/17.
 */

/*
    https://www.codewars.com/kata/steps-in-primes/train/java

    The prime numbers are not regularly spaced. For example from 2 to 3 the step is 1. From 3 to 5 the step is 2.
    From 7 to 11 it is 4. Between 2 and 50 we have the following pairs of 2-steps primes:

    3, 5 - 5, 7, - 11, 13, - 17, 19, - 29, 31, - 41, 43

    We will write a function step with parameters:

    g (integer >= 2) which indicates the step we are looking for,

    m (integer >= 2) which gives the start of the search (m inclusive),

    n (integer >= m) which gives the end of the search (n inclusive)

    In the example above step(2, 2, 50) will return [3, 5] which is the first pair between 2 and 50 with a 2-steps.

    So this function should return the first pair of the two prime numbers spaced with a step of g between t
    he limits m, n if these g-steps prime numbers exist otherwise nil or null or None or Nothing or [] (depending on the language).

    In Ocaml if there are no such primes return [].

    In C++ if there are no such primes return the pair {0, 0}.
    Examples:

    step(2, 5, 7) --> [5, 7] or (5, 7) or {5, 7}

    step(2, 5, 5) --> nil or ... or [] in Ocaml or {0, 0} in C++

    step(4, 130, 200) --> [163, 167] or (163, 167) or {163, 167}

    ([193, 197] is also such a 2-steps primes between 130 and 200 but it's not the first pair).

    step(6, 100, 110) --> [101, 107] though there is a prime between 101 and 107 which is 103; the pair 101-103 is a 2-step.
 */
import java.util.Arrays;

public class StepInPrimes {


    private static boolean[] isPrime;

    private static void fillSieve() {
        Arrays.fill(isPrime, true);        // assume all integers are prime.
        isPrime[0] = isPrime[1] = false;       // we know 0 and 1 are not prime.
        for (int i = 0; i < isPrime.length; i++) {
            //if the number is prime,
            //then go through all its multiples and make their values false.
            if (isPrime[i]) {
                for (int j = 2; i * j < isPrime.length; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
    }

    private static long nextPrime(long i, long end) {
        long k = i;
        while (++k < end && !isPrime[(int)k]) {
            continue;
        }
        if (k <= end && k != i && isPrime[(int)k]) return k;
        else return -1;
    }

    public static long[] step(int g, long m, long n) {
        isPrime = new boolean[(int)n+1];
        fillSieve();
        for (long i = m; i <= n; i++) {
            if(!isPrime[(int)i]) continue;
            else {
                int gap = 0;
                long k = i;
                while (gap <= g) {
                    k = nextPrime(k, n);
                    if (k < 2) return null;
                    gap = (int) (k - i);
                    if (gap == g) {
                        long[] ret = new long[2];
                        ret[0] = i;
                        ret[1] = k;
                        return ret;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(step(1, 101, 101));
    }

}