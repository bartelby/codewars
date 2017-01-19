/**
 * Created by bartelby on 1/15/17.
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import codewars.BasicEncrypt;

public class BasicEncryptTest {
    @Test
    public void testDecrypt() throws Exception {
        BasicEncrypt enc = new BasicEncrypt();
        assertEquals("text = '', rule = 1", "",
                enc.encrypt("", 1));
        assertEquals("text = 'a', rule = 1", "b",
                enc.encrypt("a", 1));
        assertEquals("text = 'please encrypt me', rule = 2", "rngcug\"gpet{rv\"og",
                enc.encrypt("please encrypt me", 2));
    }
}
