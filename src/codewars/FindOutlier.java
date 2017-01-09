package codewars;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by Peter on 1/7/17.
 */
public class FindOutlier{
    public static int find(int[] integers){
        List<Integer> evens = new ArrayList<Integer>();
        List<Integer> odds = new ArrayList<Integer>() ;
        for (int i : integers) {
            if (i%2==0) { evens.add(i); }
            else {odds.add(i);}
        }
        if (evens.size() == 1) {
            return evens.get(0);
        }
        else if (odds.size() == 1) {
            return odds.get(0);
        }
        else {
            throw new IllegalArgumentException("You PROMISED there would only be one outlier!");
        }
    }
}