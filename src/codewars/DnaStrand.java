package cowers;

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Created by Peter on 1/7/17.
 * Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions"
 * for the development and functioning of living organisms.

 If you want to know more http://en.wikipedia.org/wiki/DNA

 In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". You have function with one side
 of the DNA (string, except for Haskell); you need to get the other complementary side. DNA strand is never empty
 or there is no DNA at all (again, except for Haskell).

 DnaStrand.makeComplement("ATTGC") // return "TAACG"

 DnaStrand.makeComplement("GTAT") // return "CATA"
 */
public class DnaStrand {
    public static String makeComplement(String dna) {
        Map<Character,Character> dnaMap = new HashMap<Character, Character>();
        dnaMap.put('A', 'T');
        dnaMap.put('T', 'A');
        dnaMap.put('C','G');
        dnaMap.put('G', 'C');
        Stream<Character> charStream = dna.chars().mapToObj(i -> (char)i );
        Stream<Character> char_stream = charStream.map(s -> dnaMap.get(s));
        Object[] complemented_chars = char_stream.toArray();
        String out = "";
        for (Object o : complemented_chars) {
            out = out + (Character)o;
        }

        return out;
    }

    public static void main(String[] args) {
        String dna = args[0];
        System.out.println(DnaStrand.makeComplement(dna));
    }
}

/*
Here's a much nicer implementation found on codewars:
import java.util.HashMap;
import java.util.stream.Collectors;
public class DnaStrand {
  private static HashMap<Character, Character> map = new HashMap<>(4);
  static {map.put('A', 'T'); map.put('T', 'A'); map.put('C', 'G'); map.put('G', 'C');}
  public static String makeComplement(String dna) {
    return dna.chars().mapToObj(c -> String.valueOf(map.get((char)c))).collect(Collectors.joining());
  }
}


 */
