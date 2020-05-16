package com.maveryanova.algoritmms.service;

import java.math.BigInteger;

public class BigMatrix2D {

    public static BigInteger[][] multiplyTwoMatrices(BigInteger[][] first, BigInteger[][] second) {
        BigInteger[][] result = new BigInteger[2][2];

        result[0][0] = first[0][0].multiply(second[0][0]).add(first[0][1].multiply(second[1][0]));
        result[0][1] = first[0][0].multiply(second[0][1]).add(first[0][1].multiply(second[1][1]));
        result[1][0] = first[1][0].multiply(second[0][0]).add(first[1][1].multiply(second[1][0]));
        result[1][1] = first[1][0].multiply(second[0][1]).add(first[1][1].multiply(second[1][1]));

        return result;
    }

    public static BigInteger[][] power (BigInteger[][] matrix, long pow) {
        BigInteger[][] res = {
            new BigInteger[]{BigInteger.ONE, BigInteger.ZERO},
            new BigInteger[]{BigInteger.ZERO, BigInteger.ONE}
        };

        while (pow != 0) {
            if (pow % 2 == 1) {
                res = multiplyTwoMatrices(res, matrix);
                --pow;
            }
            else {
                matrix = multiplyTwoMatrices(matrix, matrix);
                pow >>= 1;
            }
        }
        return res;
    }

}
