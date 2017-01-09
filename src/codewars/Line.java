package codewars;

/**
 * Created by bartelby on 1/9/17.
 * https://www.codewars.com/kata/vasya-clerk/train/java
 */
public class Line {
    public static String Tickets(int[] peopleInLine) {
        int vanyas_25s = 0;
        int vanyas_50s = 0;
        for (int i = 0; i < peopleInLine.length; i++) {
            if(peopleInLine[i] == 25) { vanyas_25s += 1;}
            else if(peopleInLine[i] == 50) {
                vanyas_25s -= 1;
                vanyas_50s += 1;
            }
            else {
                if (vanyas_50s > 0 ) {
                    vanyas_25s -= 1;
                    vanyas_50s -= 1;
                }
                else {vanyas_25s -=3;}
            }
            if (i < peopleInLine.length-1) {
                int next = peopleInLine[i+1];
                if (next == 100 && (vanyas_25s < 3 || (vanyas_25s < 1 && vanyas_50s < 1))) return "NO";
                if(next == 50 && vanyas_25s < 1) return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        int[] tix = {25,25,50,50};
        System.out.println(Line.Tickets(tix));
    }
}