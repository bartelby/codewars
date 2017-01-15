package codewars;

import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;

/**
 * Created by bartelby on 1/15/17.
 */
/*
    Given a positive number n > 1 find the prime factor decomposition of n.
    The result will be a string with the following form :

     "(p1**n1)(p2**n2)...(pk**nk)"

    with the p(i) in increasing order and n(i) empty if n(i) is 1.

    Example: n = 86240 should return "(2**5)(5)(7**2)(11)"

    https://www.codewars.com/kata/54d512e62a5e54c96200019e/train/java

 */
public class PrimeDecomp {



    private static List<Integer> primesToN(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            if(new BigInteger(String.valueOf(i)).isProbablePrime(1)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static String factors(int n) {

        List<Integer> primes = primesToN((int)java.lang.Math.sqrt(n));
        String ret = "";
        for(int prime : primes) {
            int pow = 0;
            while (n % prime == 0) {
               n /= prime;
               if(++pow == 1) ret = ret + "(";
            }
            if(pow == 0) continue;
            if(pow == 1) {
                ret = ret + String.valueOf(prime);
            }
            else ret = ret + String.valueOf(prime) + "**" + String.valueOf(pow);
            ret = ret + ")";
        }
        if(n > 1) ret = ret + "(" + String.valueOf(n) + ")";
        return ret;
    }

    public static void main(String[] args) {
        int n =  7775460;
        System.out.println(factors(n));
    }
}
