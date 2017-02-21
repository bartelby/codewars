package codewars;

/**
 * Created by bartelby on 2/19/17.
 */

/*
    The prime factorization of a positive integer is a list of the integer's prime factors,
    together with their multiplicities; the process of determining these factors is called
    integer factorization. The fundamental theorem of arithmetic says that every positive
    integer has a single unique prime factorization.

    The prime factorization of 24, for instance, is (2^3) * (3^1).

    Without using the prime library, write a class called PrimeFactorizer that takes in an integer
    greater than 1 and has a method called factor which returns a hash where the keys are prime numbers
    and the values are the multiplicities.

    new PrimeFactorizer().factor(24) //should return { 2 => 3, 3 => 1 }

    https://www.codewars.com/kata/534a0c100d03ad9772000539/train/java

 */

import java.util.HashMap;
import java.util.Map;
public class PrimeFactorizer{
    public Map<Long, Integer> factor(long n) {
        Map<Long, Integer> result = new HashMap<Long, Integer>();
        for(long i = 2; i <= Math.sqrt(n); i++) {
            if(n % i ==0){
                int count = 0;
                while(n % i == 0){
                    count++;
                    n /= i;
                }
                result.put(i, count);
            }

        }
        if(n > 1){
            result.put(n, 1);
        }

        return result;
    }
}