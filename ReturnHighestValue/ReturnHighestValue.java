import java.util.stream.IntStream;

/**
 *  Return the index of the list with highest value
 */
public class ReturnHighestValue {

    public static void main(String args[]) {

        System.out.println("1.a Index With Higher Value (10, 20, 15) = " + getIndexWithHigherValue(10, 20, 15));
        System.out.println("1.b Index With Higher Value (11, 12, 15) = " + getIndexWithHigherValue(11, 12, 15));
        System.out.println("1.c Index With Higher Value (7, 5, 3 )   = " + getIndexWithHigherValue(11, 12, 15));
        System.out.println("2.a Index With Higher Value (10, 20, 15) = " + getIndexWithHigherValue1(10, 20, 15));
        System.out.println("2.b Index With Higher Value (11, 12, 15) = " + getIndexWithHigherValue1(11, 12, 15));
        System.out.println("2.c Index With Higher Value (7, 5, 3 )   = " + getIndexWithHigherValue1(11, 12, 15));

    }

    static int getIndexWithHigherValue(int val0, int val1, int val2) {
        int maxVal = Math.max(val0, Math.max(val1, val2));

        if (maxVal == val0) {
            return 0;
        } else if (maxVal == val1) {
            return 1;
        } else {
            return 2;
        }
    }

    static int getIndexWithHigherValue1(int val0, int val1, int val2) {
        int[] vals = {val0, val1, val2};

        return 	IntStream.range(0, vals.length)
                .reduce((i, j) -> vals[i] >= vals[j] ? i : j)
                .getAsInt();
    }

}