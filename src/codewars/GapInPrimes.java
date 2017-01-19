package codewars;

/*
    The prime numbers are not regularly spaced. For example from 2 to 3 the gap is 1. From 3 to 5 the gap is 2.
    From 7 to 11 it is 4. Between 2 and 50 we have the following pairs of 2-gaps primes: 3-5, 5-7, 11-13, 17-19, 29-31, 41-43

    A prime gap of length n is a run of n-1 consecutive composite numbers between two successive primes
    (see: http://mathworld.wolfram.com/PrimeGaps.html).

    We will write a function gap with parameters:

    g (integer >= 2) which indicates the gap we are looking for

    m (integer >= 2) which gives the start of the search (m inclusive)

    n (integer >= m) which gives the end of the search (n inclusive)

    In the example above gap(2, 2, 50) will return [3, 5] or (3, 5) or {3, 5} which is the first pair between 2 and 50 with a 2-gap.

    So this function should return the first pair of two prime numbers spaced with a gap of g between the limits m, n if
    these numbers exist otherwise nil or null or None or Nothing (depending on the language). In C++ return in such a case {0, 0}.

    Examples:

    gap(2, 5, 7) --> [5, 7] or (5, 7) or {5, 7}

    gap(2, 5, 5) --> nil or in C++ {0, 0}

    gap(4, 130, 200) --> [163, 167] or (163, 167) or {163, 167}

    ([193, 197] is also such a 4-gap primes between 130 and 200 but it's not the first pair)

    gap(6,100,110) --> nil or {0, 0} : between 100 and 110 we have 101, 103, 107, 109 but 101-107
    is not a 6-gap because there is 103in between and 103-109is not a 6-gap because there is 107 in between.

    Ref https://en.wikipedia.org/wiki/Prime_gap

    https://www.codewars.com/kata/gap-in-primes/train/java
 */

import java.util.Arrays;

public class GapInPrimes {

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
        while (++i < end && !isPrime[(int)i]) {
            continue;
        }
        if (i <= end) return i;
        else return -1;
    }

    public static long[] gap(int g, long m, long n) {
        isPrime = new boolean[(int)n+1];
        fillSieve();
        for (long i = m; i <= n; i++) {
            if(!isPrime[(int)i]) continue;
            else {
                long k = nextPrime(i, n);
                int gap = (int)(k - i);
                if (gap == g) {
                    long[] ret = new long[2];
                    ret[0] = i;
                    ret[1] = k;
                    return ret;
                }
            }
        }
        return null;
    }

}

// THREE NICE SOLUTIONS BELOW:

//import java.math.BigInteger;
//import java.util.stream.LongStream;
//
//class GapInPrimes {
//    public static long[] gap(long g, long m, long n) {
//        return LongStream.iterate(m % 2 == 0 ? m + 1 : m, l -> l + 2).limit((n - m) / 2).filter(l -> BigInteger.valueOf(l).isProbablePrime(5) && BigInteger.valueOf(l + g).isProbablePrime(5)).filter(l -> {
//            return LongStream.iterate(l + 2, c -> c + 2).limit((g - 2) / 2).parallel().filter(c -> BigInteger.valueOf(c).isProbablePrime(5)).mapToObj(c -> false).findAny().orElse(true);
//        }).mapToObj(l -> new long[]{l, l + g}).findFirst().orElse(null);
//    }
//}

//import java.util.stream.*;
//
//class GapInPrimes {
//    public static long[] gap(int g, long m, long n) {
//        long[] primes = LongStream.rangeClosed(m, n).filter((num) -> {
//            if (num < 2) return false;
//            if (num == 2) return true;
//            if (num % 2 == 0) return false;
//            for (int i = 3; i * i <= num; i += 2)
//                if (num % i == 0) return false;
//            return true;
//        }).toArray();
//
//        for (int i = 1; i < primes.length; i++)
//            if (primes[i] - primes[i - 1] == g)
//                return new long[] {primes[i - 1], primes[i]};
//
//        return null;
//    }
//}

//import java.util.BitSet;
//
//class GapInPrimes {
//    public static long[] gap(int g, long m, long n) {
//        BitSet primes = new BitSet((int) n + 1);
//        primes.set(2, (int) n);
//        int max = 2;
//        while (0 < max && max < n) {
//            for (int i = 2 * max; i < n; i += max)
//                primes.clear(i);
//            max = primes.nextSetBit(max + 1);
//        }
//
//        int left = primes.nextSetBit((int) m);
//        int right = left;
//        while (right >= 0 && right - left != g) {
//            left = right;
//            right = primes.nextSetBit(right + 1);
//        }
//
//        return right >= 0 ? new long[] {left, right} : null;
//    }
//}