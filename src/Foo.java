/**
 * Created by bartelby on 1/6/17.
 */
public class Foo {
    public static void main(String args[])
    {
        outer :
        for(int i = 0; i < 3; i++)
        {
            for(int j = 3; j >= 0; j--)
            {
                if(i == j) break outer;
                System.out.println(i + " " + j);
            }
        }
    }
        public static Double multiply(Double a, Double b) {
            return a * b;
        }

}

