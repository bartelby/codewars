import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import codewars.Solution;

public class SolutionTest {
    @Test
    public void exampleTests() {
        assertEquals("", Solution.lcs("a", "b"));
        assertEquals("abc", Solution.lcs("abcdef", "abc"));
        assertEquals("ac", Solution.lcs("ac","abc"));
        assertEquals("acf", Solution.lcs("axcqwf","abcdef"));
    }
}