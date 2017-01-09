/**
 * Created by bartelby on 1/7/17.
 *
 * Your task is to construct a building which will be a pile of n cubes.
 * The cube at the bottom will have a volume of n^3, the cube above will have volume of (n-1)^3 and so on
 * until the top which will have a volume of 1^3.
 *
 * You are given the total volume m of the building. Being given m can you find the number n of cubes you will have to build?
 *
 * The parameter of the function findNb (find_nb, find-nb) will be an integer m FIXME: It's a long.
 * and you have to return the integer n such as n^3 + (n-1)^3 + ... + 1^3 = m if such a n exists or -1 if there is no such n.

 * findNb(1071225) --> 45
 * findNb(91716553919377) --> -1
 *
 */


public class ASum {

    public static long findNb(long m) {
        long sum = 0;
        long lim = (long)java.lang.Math.cbrt(m-1);
        for (long i = 0; i<m; i++) {
            sum += (long)java.lang.Math.pow(i, 3);
            if (sum > m) {
                return -1;
            }
            else if (sum == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long m = Long.parseLong(args[0]);
        System.out.println(ASum.findNb(m));
    }
}