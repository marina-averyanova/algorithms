/* *
 * FibonacciNumbers
 *
 * This solution uses matrix.
 */

package com.maveryanova.algoritmms.tasks;

import com.maveryanova.algoritmms.service.BigMatrix2D;

import java.math.BigInteger;
import java.util.List;

public class FiboMatrix implements Task {
    @Override
    public String getPath() {
        return "4.Fibo";
    }

    @Override
    public String run(List<String> data) {
        int n = Integer.parseInt(data.get(0));

        if (n == 1 || n == 2) return "1";

        BigInteger[][] matrix = {
            new BigInteger[]{BigInteger.ONE, BigInteger.ONE},
            new BigInteger[]{BigInteger.ONE, BigInteger.ZERO}
        };

        BigInteger[][] result = BigMatrix2D.power(matrix, n - 1);
        return String.valueOf(result[0][0]);
    }

    /* *
     * timeline
     * ---------------------
     * Test #0  | 0s10ms
     * Test #1  | 0s1ms
     * Test #2  | 0s3ms
     * Test #3  | 0s2ms
     * Test #4  | 0s0ms
     * Test #5  | 0s0ms
     * Test #6  | 0s1ms
     * Test #7  | 0s1ms
     * Test #8  | 0s2ms
     * Test #9  | 0s1ms
     * Test #10 | 0s1ms
     * Test #11 | 1s81ms
     * Test #12 | 6s901ms
     *
     */

}
