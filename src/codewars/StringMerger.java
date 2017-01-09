package codewars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.lang.Character;

/**
 * Created by bartelby on 1/8/17.
 */
/*
    At a job interview, you are challenged to write an algorithm to check if a given string, s, can be formed
    from two other strings, part1 and part2.
    The restriction is that the characters in part1 and part2 are in the same order as in s.

    The interviewer gives you the following example and tells you to figure out the rest from the given test cases.

    For example:

    'codewars' is a merge from 'cdw' and 'oears':

        s:  c o d e w a r s   = codewars
    part1:  c   d   w         = cdw
    part2:    o   e   a r s   = oears


 */
public class StringMerger {

    public static boolean isMerge(String s, String part1, String part2) {
        if (s.contains(part1) && s.contains(part2) & s.length() == (part1.length() + part2.length())) {
            return true;
        }
        List<Character> ret =  new ArrayList<Character>();
        new StringMerger().merge(new StringMerger().toList(part1), new StringMerger().toList(part2), ret);
        String sRet = new StringMerger().toString(ret);
        return sRet.equals(s);
    }

    private  ArrayList<Character> toList(String s) {
        ArrayList<Character> alc = new ArrayList<>(s.chars().mapToObj(e -> (char) e).collect(Collectors.toList()));
        return alc;
    }

    private  String toString(List<Character> l) {
        return l.stream().map(e->e.toString()).reduce((acc, e) -> acc  + e).get();
    }

    private void merge(List<Character> a, List<Character> b, List<Character> ret) {
        if (a.size() == 0) {
            ret.addAll(b);
            return;
        }
        if (b.size() == 0) {
            ret.addAll(a);
            return;
        } else {
            ret.add(a.remove(0));
            ret.add(b.remove(0));
            merge(a, b, ret);
        }
    }

    public static void main(String[] args) {
            boolean oh_yeah = StringMerger.isMerge("codewars", "code", "wars");
            System.out.println(oh_yeah ? "IT's GOOD!" : "no good...");
    }


}