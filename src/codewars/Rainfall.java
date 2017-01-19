package codewars;

/**
 * Created by bartelby on 1/18/17.
 */
/*
    https://www.codewars.com/kata/rainfall/train/java

    data and data1 are two strings with rainfall records of a few cities for months from January to December.
    The records of towns are separated by \n. The name of each town is followed by :.

    data and towns can be seen in "Your Test Cases:".
    Task:

    - function: mean(town, strng) should return the average of rainfall for the city `town` and the `strng` `data` or `data1`.
    - function: variance(town, strng) should return the variance of rainfall for the city `town` and the `strng` `data` or `data1`.

    Examples:

    mean("London", data), 51.19(9999999999996)
    variance("London", data), 57.42(833333333374)

    Notes:

    - if functions `mean`or `variance` have as parameter `town` a city which has no records return `-1`

    - Don't truncate or round: the tests will pass if `abs(your_result - test_result) <= 1e-2`
    - or `abs((your_result - test_result) / test_result) <= 1e-6` depending on the language. (see function assertFuzzyEquals).

    - <http://www.mathsisfun.com/data/standard-deviation.html>
    - `data` and `data1` are adapted from <http://www.worldclimate.com>


 */
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

/*
    NOTE: This is the absolute worst way to do this - there must be nice, new fp-like approaches with map and filter
            steps.  However, I don't know them.
 */

public class Rainfall {

    private static Map<String, List<Double>> parse(String s) {
        Map<String, List<Double>> ret = new HashMap<String, List<Double>>();
        String[] rows = s.split("\n");
        for (String row : rows) {
            String[] splitRow = row.split(":");
            String snumbers = splitRow[1].replaceAll("[a-zA-Z]+", "");
            String[] snumArray = snumbers.split(",");
            Double[] darray = new Double[snumArray.length];
            for(int i = 0; i< darray.length; i++) {
                darray[i] = Double.parseDouble(snumArray[i]);
            }
            ret.put(splitRow[0], Arrays.asList(darray));
        }
        return ret;
    }

    public static double mean(String town, String strng) {
        Map<String, List<Double>> data = parse(strng);
        List<Double> numArray = data.get(town);
        if (numArray == null) return -1;
        Double mean = 0.0;
        for(Double d : numArray) {
            mean += d;
        }
        mean = mean/numArray.size();
        return mean;
    }
    public static double variance(String town, String strng) {
        //Should not repeat like this.
        Map<String, List<Double>> data = parse(strng);
        List<Double> numbers = data.get(town);
        if(numbers == null) return -1;
        Double mean = 0.0, sd = 0.0;
        for (Double d : numbers) { mean += d; }
        mean = mean/numbers.size();
        for (Double d : numbers) { sd += Math.pow(d - mean, 2);}
        Double variance = sd/numbers.size();
        return variance;
    }
}

/*
//NICER SOLUTON
public class Rainfall {

    public static double mean(String town, String strng) {
        for (String piece : strng.split("\n"))
            if (piece.substring(0, piece.indexOf(":")).equals(town))
                return Arrays.stream(piece.replaceAll("(?=[^0-9])(?=[^\\.])[^\\,]", "").split(",")).map(String::trim).mapToDouble(Double::parseDouble).sum() / 12;
        return -1;
    }

    public static double variance(String town, String strng) {
        double mean = mean(town, strng);
        ArrayList<Double> variance = new ArrayList<>();
        for (String piece : strng.split("\n"))
            if (piece.substring(0, piece.indexOf(":")).equals(town))
                Arrays.stream(piece.replaceAll("(?=[^0-9])(?=[^\\.])[^\\,]", "").split(",")).map(String::trim).mapToDouble(Double::parseDouble).forEach((n) -> variance.add((n - mean) * (n - mean)));
        if (variance.isEmpty())
            return -1;
        return variance.stream().mapToDouble(d->d).sum() / 12;
    }
}
 */

