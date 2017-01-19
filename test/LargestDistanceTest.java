/**
 * Created by bartelby on 1/17/17.
 */

/**
 * Created by bartelby on 1/17/17.
 */
import codewars.LargestDifference;
import junit.framework.TestCase;

public class LargestDistanceTest extends TestCase {
    public void test1() {
        assertEquals(4, LargestDifference.largestDifference(new int[]{9, 4, 1, 10, 3, 4, 0, -1, -2}));
    }

    public void test2() {
        assertEquals(0, LargestDifference.largestDifference(new int[]{3, 2, 1}));
    }
}
