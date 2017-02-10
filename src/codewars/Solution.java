package codewars;



/**
 * Created by Peter on 1/7/17.
 */

/*
https://www.codewars.com/kata/longest-common-subsequence/train/java

Write a function called LCS that accepts two sequences, and returns the longest subsequence common to the passed in sequences.
Subsequence

A subsequence is different from a substring. The terms of a subsequence need not be consecutive terms of the original sequence.
Example subsequence

Subsequences of "abc" = "a", "b", "c", "ab", "ac", "bc"
LCS examples

Solution.lcs("abcdef", "abc") => returns "abc"
Solution.lcs("abcdef", "acf") => returns "acf"
Solution.lcs("132535365", "123456789") => returns "12356"

Notes

    Both arguments will be strings
    Return value must be a string
    Return an empty string if there exists no common subsequence
    Both arguments will have one or more characters (in JavaScript)
    All tests will only have a single longest common subsequence. Don't worry about cases such as LCS( "1234", "3412" ),
    which would have two possible longest common subsequences: "12" and "34".

 */
import java.lang.Math;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    private static final int MATCH = 2;
    private static final int NO_MATCH = -1;
    private static int[][] V; //NOTE that i is column, j is row
    private static char[] string_x;
    private static char[] string_y;

    /**
     * My hypothesis is that the "longest substring" can be found by globally aligning the two strings
     * using the Needleman-Wunsch algorithm.  This method is the top level of my implementation of that
     * algorithm.  For information on global sequence alignment, see:
     * https://en.wikipedia.org/wiki/Needleman-Wunsch_algorithm
     *
     * IMPORTANT NOTE: This is NOT needleman-wunch.  I just tinkered smith-waterman a bit.
     *
     * @param x - String 1
     * @param y - String 2
     * @return String representing the 'longest substring' assuming the longest substring is the one
     *          for which the SW algorithm returns the highest score.
     */
    public static String lcs(String x, String y) {
        init(x,y);
        int max = 0;
        int[] pointer = new int[2];
        for(int i = 1; i < string_x.length; i++) {
            for (int j = 1; j < string_y.length; j++) {
                V[i][j] = score(i,j);
                if (V[i][j] >= max) {
                    max = V[i][j];
                    pointer[0] = i;
                    pointer[1] = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        trackback(pointer, sb);
        String aligned = sb.reverse().toString();
        return aligned;
    }



    /**
     * Calculates the score for any cell i,j in the matrix. The calculation is the maximum of
     *      0
     *      V[i-1][j-1] - s(i,j) where s is MATCH if the strings match at i&j or NO_MATCH
     *      V[i-1][j] - d where d is equal to 1.
     *      V[i][j-1] - d
     * @param i - the position in the vertical string (column)
     * @param j - the position in the horizontal string (row)
     * @return - a match score for the i,j cell in the matrix
     */
    private static int score(int i, int j) {
        int d = 1; //What is ths?  I'm guessing it's 1, but maybe not.
        int max = Math.max(0, V[i-1][j-1] + s(i,j));
        max = Math.max(max, V[i-1][j]-d);
        max = Math.max(max,V[i][j-1]-d);
        return max;
    }

    private static int s(int i, int j) {
        return string_x[i] == string_y[j]  ? MATCH : NO_MATCH;
    }

    /**
     *  Tracks backwards and up through the matrix to find the alignmnent
     * @param pointer - the coordinates in the matrix of the cell with the highest score.  Begin trackback from here.
     * @return
     */
    private static void trackback(int[] pointer, StringBuilder sb) {
        int i = pointer[0];
        int j = pointer[1];
        if(V[i][j] == 0) return;
        if (string_x[i] == string_y[j]) sb.append(string_x[i]);
        int max = Math.max(V[i-1][j-1], V[i][j-1]);
        max = Math.max(max,V[i-1][j]);
        if (V[i-1][j-1] == max) {pointer[0] = i-1; pointer[1] = j-1;}
        else if (V[i-1][j] == max) { pointer[0] = i-1; pointer[1] = j;}
        else { pointer[0] = i; pointer[1] = j-1; }
        trackback(pointer, sb);
    }

    private static String matrixToString() {
        return Arrays.stream(V).map(i->Arrays.toString(i)).collect(Collectors.joining("\n"));
    }


    private static void init(String x, String y) {
        V = new int[x.length()+1][y.length()+1];
        string_x = new char[x.length()+1];
        string_y = new char[y.length()+1];
        for (int i = 1; i < string_x.length; i++) {
            string_x[i] = x.charAt(i-1);
        }
        for(int i = 1; i < string_y.length; i++) {
            string_y[i] = y.charAt(i - 1);
        }
    }

    public static void main(String[] args) {
        String wot = lcs("axcqwf","abcdef");
        System.out.println(wot);
        System.out.println(matrixToString());
    }

}