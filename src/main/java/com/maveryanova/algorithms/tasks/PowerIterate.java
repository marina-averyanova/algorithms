/* *
 * Power of number.
 *
 * This solution uses iteration.
 */

package com.maveryanova.algorithms.tasks;

import java.util.List;

public class PowerIterate implements Task {
    @Override
    public String getPath() {
        return "3.Power";
    }

    @Override
    public String run(List<String> data) {
        double n = Double.parseDouble(data.get(0));

        long pow = Long.parseLong(data.get(1));

        if (pow == 0) return "1.0";
        if (pow == 1) return String.valueOf(n);

        return String.valueOf(powerIterate(n, pow));
    }

    public double powerIterate(double n, long pow) {
        double res = n;

        for (int i = 2; i <= pow; i++) {
            res = n * res;
        }

        return res;
    }

    /* *
     * timeline
     * ---------------------
     * Test #0  | 0s12ms
     * Test #1  | 0s1ms
     * Test #2  | 0s1ms
     * Test #3  | 0s1ms
     * Test #4  | 0s2ms
     * Test #5  | 0s2ms
     * Test #6  | 0s26ms
     * Test #7  | 0s108ms
     * Test #8  | 1s148ms
     * Test #9  | undefined
     */

}
