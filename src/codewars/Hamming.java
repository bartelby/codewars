package codewars;

/**
 * Created by bartelby on 2/8/17.
 */
/*
    https://www.codewars.com/kata/hamming-numbers/train/java

    A Hamming number is a positive integer of the form 2i3j5k, for some non-negative integers i, j, and k.

Write a function that computes the nth smallest Hamming number.

Specifically:

    The first smallest Hamming number is 1 = 203050
    The second smallest Hamming number is 2 = 213050
    The third smallest Hamming number is 3 = 203150
    The fourth smallest Hamming number is 4 = 223050
    The fifth smallest Hamming number is 5 = 203051

The 20 smallest Hamming numbers are given in example test fixture.

Your code should be able to compute all of the smallest 5,000 (Clojure: 2000) Hamming numbers without timing out.

 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Hamming {
    private static final int ILIM = 30;
    private static final int JLIM = 20;
    private static final int KLIM = 10;

    private static List<Long> hamming_nos = new ArrayList<>();
    private static Long[] harray;
    static {
        for (int i = 0; i < ILIM; i++ ) {
            for (int j = 0; j < JLIM; j++) {
                for (int k = 0; k < KLIM; k++) {
                    hamming_nos.add((long)(Math.pow(2,i)*Math.pow(3,j)*Math.pow(5,k)));
                }
            }
        }
        harray = hamming_nos.toArray(new Long[hamming_nos.size()]);
        Arrays.sort(harray);
    }

    public static long hamming(int n) {
        return harray[n-1];
    }

}