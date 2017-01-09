package codewars;

/**
 * Created by Peter on 1/7/17.
 */
public class Factorial {
    public int factorial(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException();
        }
        if (n == 0) return 1;
        else return n * factorial(n-1);
    }


}
