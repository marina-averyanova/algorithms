package com.maveryanova.algoritmms.tasks;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Tickets implements Task {

    @Override
    public String getPath() {
        return "1.Tickets";
    }

    @Override
    public String run(List<String> data) {
        int ticketHalfSize = Integer.parseInt(data.get(0));
        double maxValue = Math.pow(10, ticketHalfSize) - 1;

        Long[] luckyAmountsCounter = calculateLuckyAmounts(ticketHalfSize, maxValue);

        return countSum(luckyAmountsCounter).toString();
    }

    private Long[] calculateLuckyAmounts(int ticketHalfSize, double maxValue) {
        int luckyAmounts = 9 * ticketHalfSize + 1;

        Long[] luckyAmountsCounter = new Long[luckyAmounts];
        Arrays.fill(luckyAmountsCounter, 0L);

        for (int i = 0; i <= maxValue; i++) {
            int index = calculateDigitsSum(i);
            luckyAmountsCounter[index] = luckyAmountsCounter[index] + 1;
        }

        return luckyAmountsCounter;
    }

    private int calculateDigitsSum(int num) {
        int mod = num;
        int sum = 0;
        while (mod > 0) {
            sum = sum + mod % 10;
            mod = mod / 10;
        }
        return sum;
    }

    private BigInteger countSum(Long[] counter) {
        BigInteger sum = BigInteger.valueOf(0);

        int halfSize = counter.length / 2;
        boolean isSizeEven = counter.length % 2 == 0;

        for (int i = 0; i < halfSize; i++) {
            BigInteger value = BigInteger.valueOf(counter[i]);
            sum = sum.add(squareBigInt(value));
        }

        BigInteger medianValue = BigInteger.valueOf(0);
        if (!isSizeEven) {
            medianValue = BigInteger.valueOf(counter[halfSize]);
            medianValue = squareBigInt(medianValue);
        }
        sum = sum.multiply(BigInteger.valueOf(2)).add(medianValue);

        return sum;
    }

    private BigInteger squareBigInt(BigInteger value) {
        return value.multiply(value);
    }
}
