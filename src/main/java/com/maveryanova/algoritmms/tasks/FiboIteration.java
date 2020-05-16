/* *
 * FibonacciNumbers
 *
 * This solution uses iteration.
 */

package com.maveryanova.algoritmms.tasks;

import java.math.BigInteger;
import java.util.List;

public class FiboIteration implements Task {
    @Override
    public String getPath() {
        return "4.Fibo";
    }

    @Override
    public String run(List<String> data) {
        int n = Integer.parseInt(data.get(0));

        return fibIteration(n).toString();
    }

    private BigInteger fibIteration(int n) {
        BigInteger fibN2 = BigInteger.valueOf(1);
        BigInteger fibN1 = BigInteger.valueOf(1);
        BigInteger fibN = BigInteger.valueOf(0);
        if (n == 0) return fibN;
        if (n <= 2) return fibN1;

        for (int i = 3; i <= n; i++) {
            fibN = fibN2.add(fibN1);
            fibN2 = fibN1;
            fibN1 = fibN;
        }
        return fibN;
    }

    /* *
     * timeline
     * ---------------------
     * Test #0  | 0s12ms
     * Test #1  | 0s1ms
     * Test #2  | 0s1ms
     * Test #3  | 0s1ms
     * Test #4  | 0s1ms
     * Test #5  | 0s1ms
     * Test #6  | 0s1ms
     * Test #7  | 0s1ms
     * Test #8  | 0s1ms
     * Test #9  | 0s2ms
     * Test #10 | 0s4ms
     * Test #11 | 16s497ms
     * Test #12 | undefined
     */

}
