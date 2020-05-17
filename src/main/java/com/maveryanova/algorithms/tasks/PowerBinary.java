/* *
 * Power of number.
 *
 * This solution uses binary algorithm.
 */

package com.maveryanova.algorithms.tasks;

import java.util.List;

public class PowerBinary implements Task {
    @Override
    public String getPath() {
        return "3.Power";
    }

    @Override
    public String run(List<String> data) {
        Double n = Double.parseDouble(data.get(0));

        long pow = Long.parseLong(data.get(1));

        if (pow == 0) return "1.0";
        if (pow == 1) return String.valueOf(n);

        return String.valueOf(powerBinary(n, pow));
    }

    double powerBinary (double n, long pow) {
        double res = 1;
        while (pow != 0) {
            if (pow % 2 == 1) {
                res = res * n;
                --pow;
            }
            else {
                n = n * n;
                pow >>= 1;
            }
        }
        return res;
    }

    /* *
     * timeline
     * ---------------------
     * Test #0  | 0s11ms
     * Test #1  | 0s0ms
     * Test #2  | 0s0ms
     * Test #3  | 0s0ms
     * Test #4  | 0s0ms
     * Test #5  | 0s0ms
     * Test #6  | 0s0ms
     * Test #7  | 0s0ms
     * Test #8  | 0s0ms
     * Test #9  | 0s0ms
     */

}


