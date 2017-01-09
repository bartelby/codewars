package codewars;

/**
 * Created by Peter on 1/7/17.
 */
/*
    My initial thought was to sort, then take the first sorted entry.  However, sorting is O(n Log n)
    Just iterating the list and taking the smallest entry is O(n), a Log n improvement.
 */
public class SmallestIntegerFinder {
    public static int findSmallestInt(int[] args) {
        Integer smallest = args[0];
        for (int i : args) {
            if (i < smallest) {
                smallest = i;
            }
        }
        return smallest;
    }

}
