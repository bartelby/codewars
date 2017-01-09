/**
 * Created by bartelby on 1/7/17.
 * Given the triangle of consecutive odd numbers:

 1
 3     5 (8 = 2^3)
 7     9    11 (27 = 3^3)
 13    15    17    19 (64 = 4^3)
 21    23    25    27    29 (125 = 5^3)
 ...

 Calculate the row sums of this triangle from the row index (starting at index 1) e.g.:

 rowSumOddNumbers(1); // 1
 rowSumOddNumbers(2); // 3 + 5 = 8
 */
class RowSumOddNumbers {
    public static int rowSumOddNumbers(int n) {
        return (int)java.lang.Math.pow(n,3);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int answ = RowSumOddNumbers.rowSumOddNumbers(n);
        System.out.println(answ);
    }
}