package org.examples.stream;

import java.util.stream.IntStream;

/**
 *  Return the index of the list with highest value
 */
public class ReturnHighestValue {

    public int getIndexWithHigherValue(int val0, int val1, int val2) {
        int maxVal = Math.max(val0, Math.max(val1, val2));

        if (maxVal == val0) {
            return 0;
        } else if (maxVal == val1) {
            return 1;
        } else {
            return 2;
        }
    }

    public int getIndexWithHigherValue1(int val0, int val1, int val2) {
        int[] vals = {val0, val1, val2};

        return 	IntStream.range(0, vals.length)
                .reduce((i, j) -> vals[i] >= vals[j] ? i : j)
                .getAsInt();
    }

}