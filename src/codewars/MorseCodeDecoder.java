package codewars;

/**
 * Created by bartelby on 2/20/17.
 */

import java.util.Arrays;
import java.util.stream.Collectors;

public class MorseCodeDecoder {

    public static String decode(String morseCode) {
        return Arrays.stream(morseCode.trim().split("\\s{2,}"))
                .map(MorseCodeDecoder::decodeWord)
                .collect(Collectors.joining(" "));
    }

    private static String decodeWord(String word) {
        //splitting the word puts it in an array, so its characters can be streamed with Arrays.stream
        return Arrays.stream(word.split("\\s")).map(MorseCode::get).collect(Collectors.joining());
    }

    static class MorseCode {
        static String get(String s) {
            return s;
        }
    }


}


