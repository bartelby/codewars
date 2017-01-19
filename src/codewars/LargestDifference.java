package codewars;

/**
 * Created by bartelby on 1/17/17.
 */
/*

    Summary:
    Write a function which takes an array data of numbers and returns the largest
    difference in indexes j - i such that data[i] <= data[j]

    Long Description:
    The largestDifference takes an array of numbers. That array is not sorted. Do not sort it or
    change the order of the elements in any way, or their values.

    Consider all of the pairs of numbers in the array where the first one is
    less than or equal to the second one.From these, find a pair where their positions in the array
    are farthest apart. Return the difference between the indexes of the two array elements in this pair.

    Example:
    LargestDifference.largestDifference(new int[]{1,2,3}); //returns 2,
    //because here j = 2 and i = 0 and 2 - 0 = 2


    https://www.codewars.com/kata/52503c77e5b972f21600000e/train/java
 */
public class LargestDifference {
    public static int largestDifference(int[] data) {
        //First try it the brute force way
        int diff = 0;
        for(int i = 0; i < data.length; i++) {
            for (int j = i+1; j < data.length; j++) {
                if (data[i] <= data[j] && j-i > diff) {
                    diff = j - i;
                }
            }
        }
        return diff;
    }
}
