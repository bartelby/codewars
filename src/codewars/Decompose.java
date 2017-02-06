package codewars;

/**
 * Created by bartelby on 1/19/17.
 */
/*
    https://www.codewars.com/kata/square-into-squares-protect-trees

    My little sister came back home from school with the following task: given a squared sheet of paper
    she has to cut it in pieces which, when assembled, give squares the sides of which form an increasing
    sequence of numbers. At the beginning it was lot of fun but little by little we were tired of seeing
    the pile of torn paper. So we decided to write a program that could help us and protects trees.
    Task

    Given a positive integral number n, return a strictly increasing sequence (list/array/string depending on the language)
    of numbers, so that the sum of the squares is equal to n².

    If there are multiple solutions (and there will be), return the result with the largest possible values:
    Examples

    decompose(11) must return [1,2,4,10]. Note that there are actually two ways to
    decompose 11², 11² = 121 = 1 + 4 + 16 + 100 = 1² + 2² + 4² + 10² but don't return [2,6,9], since 9 is smaller than 10.

    For decompose(50) don't return [1, 1, 4, 9, 49] but [1, 3, 5, 8, 49] since [1, 1, 4, 9, 49] doesn't form a strictly
    increasing sequence.
    Note

    Neither [n] nor [1,1,1,…,1] are valid solutions. If no valid solution exists, return nil, null,
    Nothing, None (depending on the language) or "" (Java, C#) or {} (C++).

    The function "decompose" will take a positive integer n and return the decomposition of N = n² as:

    "x1 ... xk"

    Hint

    Very often xk will be n-1.

 */
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;


public class Decompose {
    /*
        Try this for an algorithm:
        Starting from n-1, square it and subtract from n^2.
        take square root of n^2 - (n-1)^2.  If an integer value, stop
        otherwise subtract floor of sqrt from (n^2 - (n-1)^2) and take
        sqrt of that.  Keep going until sqrt is < 2.  If it is 1.000... stop.
        If not, repeat starting at n-2, then n-3...
     */

    @Nullable
    private List decompose(int i, long n) {
        List<Integer> components = new ArrayList<Integer>();
        components.add(i);
        int testme = (int)(n*n);
        while(true) {
            int diff = testme - i*i;
//            if (diff == 1 && !components.contains(1))  {
//                components.add(1);
//                return components;
//            }
            double root = Math.sqrt(diff);
            double floor = Math.floor(root);
            components.add((int)floor);
//            else {
//                i--;
//                continue;
//            }
            if(root==floor) {
                boolean duplicates = false;
                for (int k = 0; k < components.size() - 1; k++) {
                    if (components.get(k).equals(components.get(k+1))) {
                        //HANDLE CASE OF DUPLICATE VALUES
                        System.out.println("**********************");
                        duplicates = true;
                    }
                }
                if (!duplicates) {
                    return components;
                }
            }
            else if (floor > 1){
                testme = diff;
                i = (int)floor;
            }
            else return null;
        }
    }

    public String decompose(long n) {
        // this is the outer loop - only gets decremented
        // if no decompositon found for current value of i
        for (int i = (int)n-1; i > 0; i--) {
            List values = decompose(i, n);
            if (values != null) {
                String ret = "";
                int k = 0;
                for(int j = values.size() -1; j >= 0; j--) {
                    ret = ret + " " + String.valueOf(values.get(j));
                }
                return ret.trim();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Decompose me = new Decompose();
        System.out.println(me.decompose(50));
    }

}