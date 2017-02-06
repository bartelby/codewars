package codewars;

/**
 * Created by bartelby on 2/6/17.
 */
/*
    John and his wife Ann have decided to go to Codewars.

    On day 0 Ann will do one kata and John - he wants to know how it is working - 0.

    Let us call a(n) the number of katas done by Ann at day n we have a(0) = 1 and in the same manner j(0) = 0.

    They have chosen the following rules:

        On day n the number of katas done by Ann should be n minus the number of katas done by John at day t, t being equal
        to the number of katas done by Ann herself at day n - 1.

        On day n the number of katas done by John should be n minus the number of katas done by Ann at day t, t being equal
        to the number of katas done by John himself at day n - 1.

    Whoops! I think they need to lay out a little clearer exactly what there're getting themselves into!
    Could you write:

        1) two functions ann and john (parameter n) giving the list of the numbers of katas Ann and John should take on each
        day from day 0 to day n - 1 (n days - see first example below)?
        2) The total number of katas taken by ann (function sum_ann(n)) and john (function sum_john(n)) from day 0 (inclusive)
        to day n (exclusive)?

    Examples:

    john(11) -->  [0, 0, 1, 2, 2, 3, 4, 4, 5, 6, 6]
    ann(6) -->  [1, 1, 2, 2, 3, 3]

    sum_john(75) -->  1720
    sum_ann(150) -->  6930

    https://www.codewars.com/kata/57591ef494aba64d14000526/train/java
 */
import java.util.List;
import java.util.ArrayList;

public class Johnann {

    static List<Long> toLong(List<Integer> list) {
        List<Long> lout = new ArrayList<Long>();
        for(Integer i : list) lout.add(Long.valueOf(i.longValue()));
        return lout;
    }

    public static List<Long> john(long n) {
        List<Integer> john = new ArrayList<Integer>();
        List<Integer> ann = new ArrayList<Integer>();
        john.add(0);
        ann.add(1);
        for (int i = 1; i < n; i++) {
            john.add(i - ann.get(john.get(i - 1)));
            ann.add(i - john.get(ann.get(i - 1)));
        }
        return toLong(john);
    }
    public static List<Long> ann(long n) {
        List<Integer> john = new ArrayList<Integer>();
        List<Integer> ann = new ArrayList<Integer>();
        john.add(0);
        ann.add(1);
        for (int i = 1; i < n; i++) {
            john.add(i - ann.get(john.get(i - 1)));
            ann.add(i - john.get(ann.get(i - 1)));
        }
        return toLong(ann);
    }
    public static long sumJohn(long n) {
        List<Long> john = john(n);
        long sum = 0;
        for(long l : john) {
            sum += l;
        }
        return sum;
    }
    public static long sumAnn(long n) {
        List<Long> ann = ann(n);
        long sum = 0;
        for(long l : ann) {
            sum += l;
        }
        return sum;
    }
    public static void main(String[] args) {
        john(11);
    }
}