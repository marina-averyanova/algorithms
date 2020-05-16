/* *
 * Power of number.
 *
 * This solution uses power of 2.
 */

package com.maveryanova.algoritmms.tasks;

import java.util.List;

public class Power2Power implements Task {
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

        Double res = n;

        Long powerOfTwo = 1L;

        while (powerOfTwo <= pow/2L) {
            res = res * res;
            powerOfTwo = powerOfTwo * 2L;
        }

        for (long i = powerOfTwo + 1L; i <= pow; i++) {
            res = res * n;
        }

        return String.valueOf(res);
    }

    /* *
     * timeline
     * ---------------------
     * Test #0  | 0s12ms
     * Test #1  | 0s0ms
     * Test #2  | 0s0ms
     * Test #3  | 0s0ms
     * Test #4  | 0s3ms
     * Test #5  | 0s16ms
     * Test #6  | 0s24ms
     * Test #7  | 0s200ms
     * Test #8  | 2s20ms
     * Test #9  | 4s345ms
     */

}
