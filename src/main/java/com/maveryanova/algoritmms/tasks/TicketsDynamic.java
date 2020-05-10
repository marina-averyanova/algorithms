/* *
 * Lucky tickets 20
 * A ticket with a 2N digit number is considered lucky,
 * if the sum of the N first digits is equal to the sum of the last N digits.
 * Calculate how many happy 2N-digit tickets exist.
 * Initial data: number N from 1 to 10.
 * Conclusion of the result: the number of 2N-digit lucky tickets.
 *
 * This solution is based on dynamic programming.
 */

package com.maveryanova.algoritmms.tasks;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class TicketsDynamic implements Task {

    @Override
    public String getPath() {
        return "1.Tickets";
    }

    @Override
    public String run(List<String> data) {
        int n = Integer.parseInt(data.get(0));

        int[] luckyAmounts1 = new int[10];
        Arrays.fill(luckyAmounts1, 1);

        if (n == 1) return "10";

        int luckyAmountsCount = 9 * n + 1;
        int[] luckyAmountsN = calculateLuckyArrayN(luckyAmounts1, luckyAmountsCount);

        return calculateLuckyTickets(luckyAmountsN).toString();
    }

    private int[] calculateLuckyArrayN(int[] previousArray, int n) {
        int newArrayLength =  previousArray.length + 9;
        int[] newArray = new int[newArrayLength];

        for (int i = 0; i < newArrayLength; i++) {
            int value = 0;

            for (int j = 0; j < 10; j++) {
                int k = i - j;
                if (k >= 0 && k < previousArray.length) {
                    value += previousArray[k];
                }
            }
            newArray[i] = value;
        }
        return newArrayLength == n ? newArray : calculateLuckyArrayN(newArray, n);
    }

    private BigInteger calculateLuckyTickets(int[] arr) {
        BigInteger sum = BigInteger.valueOf(0);
        for (int item : arr) {
            BigInteger value = BigInteger.valueOf(item);
            sum = sum.add(squareBigInt(value));
        }
        return sum;
    }

    private BigInteger squareBigInt(BigInteger value) {
        return value.multiply(value);
    }
}
