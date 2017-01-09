/**
 * Created by Peter on 1/7/17.
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import codewars.DRoot;

public class DRootExampleTest {
    @Test
    public void Tests() {
        assertEquals( "Nope!" , 7, DRoot.digital_root(16));
        assertEquals( "Not Today, muddah.", 6, DRoot.digital_root(15));
        assertEquals("WTF???", 6, DRoot.digital_root(132189));
    }
}