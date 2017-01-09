package codewars;

/**
 * Created by Peter on 1/7/17.
 */
/*
    A digital root is the recursive sum of all the digits in a number. Given n, take the sum of the digits of n.
    If that value has two digits, continue reducing in this way until a single-digit number is produced.
    This is only applicable to the natural numbers.

Here's how it works (Ruby example given):

digital_root(16)
=> 1 + 6
=> 7

digital_root(942)
=> 9 + 4 + 2
=> 15 ...
=> 1 + 5
=> 6

digital_root(132189)
=> 1 + 3 + 2 + 1 + 8 + 9
=> 24 ...
=> 2 + 4
=> 6

digital_root(493193)
=> 4 + 9 + 3 + 1 + 9 + 3
=> 29 ...
=> 2 + 9
=> 11 ...
=> 1 + 1
=> 2


 */
public class DRoot {
    static int out_val = 0;
    public static int digital_root(int n) {
        if (n < 10) {
            out_val = n;
            return out_val;
        }
        else {
            char[] n_chars = String.valueOf(n).toCharArray();
            int sum = 0;
            for (char c : n_chars) {
                sum += Integer.parseInt("" + c);
            }
            DRoot.digital_root(sum);
        }
        return out_val;
    }
}
