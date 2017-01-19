/**
 * Created by bartelby on 1/19/17.
 */
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import codewars.StepInPrimes;


public class StepInPrimesTest {

    @Test
    public void test() {
        System.out.println("Fixed Tests");
//        assertEquals("[101, 103]", Arrays.toString(StepInPrimes.step(2,100,110)));
//        assertEquals("[103, 107]", Arrays.toString(StepInPrimes.step(4,100,110)));
//        assertEquals("[101, 107]", Arrays.toString(StepInPrimes.step(6,100,110)));
//        assertEquals("[359, 367]", Arrays.toString(StepInPrimes.step(8,300,400)));
//        assertEquals("[307, 317]", Arrays.toString(StepInPrimes.step(10,300,400)));
        assertEquals(null, Arrays.toString(StepInPrimes.step(2, 101, 102)));
    }

}
