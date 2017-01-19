package codewars;

/**
 * Created by bartelby on 1/15/17.
 */
/*
    The most basic encryption method is to map a char to another char by a certain math rule.
    Because every char has an ASCII value, we can manipulate this value with a simple math expression.
    For example 'a' + 1 would give us 'b', because 'a' value is 97 and 'b' value is 98.

    You will need to write a method which does exactly that -get a string as text and an int as the rule of
    manipulation, and should return encrypted text. for example:

    encrypt("a",1) = "b"

    Full ascii table is used on our question (256 chars) - so 0-255 are the valid values.

    https://www.codewars.com/kata/basic-encryption/train/java
 */


public class BasicEncrypt {

    public String encrypt(String text, int rule) {
        String ret = "";
        rule = rule%256;
        byte[] barr = text.getBytes();
        char[] carr = new char[barr.length];
        for (int i = 0; i < barr.length; i++) {
            int shift = 0;
            if(barr[i] + rule >= 0 && barr[i] + rule < 256) shift = barr[i] + rule;
            else if (barr[i] + rule < 0) shift = 256 - rule;
            else shift = barr[i] + rule - 256;
            carr[i] = (char)shift;
        }
        ret = new String(carr);
        return ret;
    }

    public static void main(String[] args) {
        BasicEncrypt me = new BasicEncrypt();
        String s = me.encrypt("wvbnvhshckgeurxwdi", 433);
        if (s != null) {
            System.out.println(s);
        }
        else System.out.println("Sunday Nothing");

    }
}
