/* *
 * FibonacciNumbers
 *
 * This solution uses recursion.
 */

package com.maveryanova.algoritmms.tasks;

import java.math.BigInteger;
import java.util.List;

public class FiboRecursion implements Task {
    @Override
    public String getPath() {
        return "4.Fibo";
    }

    @Override
    public String run(List<String> data) {
        int n = Integer.parseInt(data.get(0));

        return fib(n).toString();
    }

    private BigInteger fib(int n) {
        if (n == 0) return BigInteger.valueOf(0);
        if (n <= 2) return BigInteger.valueOf(1);
        return fib(n - 1).add(fib(n - 2));
    }

    /* *
     * timeline
     * ---------------------
     * Test #0  | 0s12ms
     * Test #1  | 0s0ms
     * Test #2  | 0s1ms
     * Test #3  | 0s6ms
     * Test #4  | 0s63ms
     * Test #5  | 2s146ms
     * Test #6  | 237s394ms
     * Test #7  | undefined
     * Test #8  | undefined
     * Test #9  | undefined
     * Test #10 | undefined
     * Test #11 | undefined
     * Test #12 | undefined
     *
     */
}
