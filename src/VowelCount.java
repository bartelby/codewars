/**
 * Created by bartelby on 1/7/17.
 */
import java.lang.String;

public class VowelCount {

    public int count_vowels(String s) {
        String consonants = "[bcdfghjklmnpqrstvwxyz\\s]+";
        String vowel_string = s.replaceAll(consonants, "");
        return vowel_string.length();
    }

    public static void main(String[] args) {
        VowelCount me = new VowelCount();
        String s = args[0];
        System.out.println(me.count_vowels(s));
    }
}
