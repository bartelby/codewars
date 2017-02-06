/**
 * Created by bartelby on 1/19/17.
 */
import static org.junit.Assert.*;
import org.junit.Test;
import codewars.Decompose;

public class DecomposeTest {

    @Test
    public void test1() {
        Decompose d = new Decompose();
       // assertEquals("1 2 4 10",  d.decompose(11));
        assertEquals("1 2 3 7 9", d.decompose(12));
        //assertEquals("2 5 8 34 624", d.decompose(625));
        //assertEquals("2 3 5 119 7099", d.decompose(7100));
        //assertEquals("2 6 157 12344", d.decompose(12345));
        //assertEquals("2 8 32 1571 1234566", d.decompose(1234567));
    }
}
