package codewars;

/**
 * Created by bartelby on 2/8/17.
 */
import java.lang.Math;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SmithWaterman {
    private static final int MATCH = 2;
    private static final int NO_MATCH = -1;
    private static int[][] V; //NOTE that i is column, j is row
    private static char[] string_x;
    private static char[] string_y;

    /**
     *  This is the top-level method. It implements the
     *  smith-waterman algorithm for local sequence alignment.
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
                if (V[i][j] > max) {
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
        if (V[i][j] > 1) sb.append(string_x[i]);
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
        String wot = lcs("ac","abc");
        System.out.println(wot);
        System.out.println(matrixToString());
    }

}