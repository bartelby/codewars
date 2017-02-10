package codewars;

/**
 * Created by bartelby on 2/8/17.
 */
/*
    https://www.codewars.com/kata/5259510fc76e59579e0009d4/train/java

    I'm sure, you know Google's "Did you mean ...?", when you entered a search term and mistyped a word.
    In this kata we want to implement something similar.

    You'll get an entered term (lowercase string) and an array of known words (also lowercase strings).
    Your task is to find out, which word from the dictionary is most similar to the entered one. The similarity
    is described by the minimum number of letters you have to add, remove or replace in order to get from the
    entered word to one of the dictionary. The lower the number of required changes, the higher the similarity
    between each two words.

    Same words are obviously the most similar ones. A word that needs one letter to be changed is more similar
     to another word that needs 2 (or more) letters to be changed. E.g. the mistyped term berr is more similar t
     o beer (1 letter to be replaced) than to barrel (3 letters to be changed in total).

    Extend the dictionary in a way, that it is able to return you the most similar word from the list of known words.

    Code Examples:

    Dictionary fruits = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});

    fruits.findMostSimilar("strawbery"); // must return "strawberry"
    fruits.findMostSimilar("berry"); // must return "cherry"

    Dictionary things = new Dictionary(new String[]{"stars", "mars", "wars", "codec", "codewars"});
    things.findMostSimilar("coddwars"); // must return "codewars"

    Dictionary languages = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
    languages.findMostSimilar("heaven"); // must return "java"
    languages.findMostSimilar("javascript"); // must return "javascript" (same words are obviously the most similar ones)
 */


import java.lang.Math;

/**
 * Algorithm: find dictionary word with minimum levenshtein distance from test word.
 */
public class Dictionary {

    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    /**
     * @param to - String: the test word
     * @return - String: the most similar dictionary word.
     */
    public String findMostSimilar(String to) {
        String most_similar = "";
        int compare_to = Integer.MAX_VALUE;
        for (String word : words) {
            int distance = levenshteinDistance(to.toCharArray(), word.toCharArray());
            if (distance < compare_to) {
                compare_to = distance;
                most_similar = word;
            }
        }
        return most_similar;
    }
    private int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    /*
        levenshtein distance is the number of characters that must be changed to turn string1 into string2.
        See this for info: https://en.wikipedia.org/wiki/Levenshtein_distance
     */
    public int levenshteinDistance(char[] lhs, char[] rhs) {
        int[][] distance = new int[lhs.length + 1][rhs.length + 1];

        for (int i = 0; i <= lhs.length; i++)
            distance[i][0] = i;
        for (int j = 1; j <= rhs.length; j++)
            distance[0][j] = j;

        for (int i = 1; i <= lhs.length; i++)
            for (int j = 1; j <= rhs.length; j++)
                distance[i][j] = minimum(
                        distance[i - 1][j] + 1,
                        distance[i][j - 1] + 1,
                        distance[i - 1][j - 1] + ((lhs[i - 1] == rhs[j - 1]) ? 0 : 1));

        return distance[lhs.length][rhs.length];
    }

}

