/**
 * Created by bartelby on 1/7/17.
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.Method;

public class RowSumOddNumbersTest {

    @Test
    public void test1() {
        try {
            Class klazz = Class.forName("RowSumOddNumbers");
            Method m = klazz.getDeclaredMethod("rowSumOddNumbers", Integer.class);
            long t1 = (long)m.invoke(null, 1);
            long t2 = (long)m.invoke(null, 42);
            assertEquals(1, t1);
            assertEquals(74088, t2);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Too Fucking Bad");
        }
        catch (NoSuchMethodException e) {
            System.out.println("It's a weeper, aint it?");
        }
        catch (Exception e) {
            System.out.println("got tired of handling individual exceptions");
        }
    }
}
