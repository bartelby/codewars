package funct;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.lang.String;

public class Test {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("b","z","A","w","a");
        Collections.sort(names, (a,b) -> b.compareTo(a));
    }
}
