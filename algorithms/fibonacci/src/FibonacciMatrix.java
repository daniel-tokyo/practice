/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */

import java.math.BigInteger;


public class FibonacciMatrix extends Fibonacci {

    /*
    public long calculate() {
        if (m_iNumber < 2) {
            return m_iNumber;
        } else {
            long[] laSeed = { 1, 1, 1, 0 };
            return matrixPow(laSeed, m_iNumber)[1];
        }
    }

    private static long[] matrixPow(long[] laMatrix, long lNumber) {
        assert lNumber >= 0;
        long[] laResult = { 1, 0, 0, 1 };
        while (lNumber != 0) {
            if (lNumber % 2 != 0) {
                laResult = matrixMultiply(laResult, laMatrix);
            }
            lNumber /= 2;
            laMatrix = matrixMultiply(laMatrix, laMatrix);
        }
        return laResult;
    }

    private static long[] matrixMultiply(long[] laX, long[] laY) {
        return new long[] {
                (laX[0] * laY[0]) + (laX[1] * laY[2]),
                (laX[0] * laY[1]) + (laX[1] * laY[3]),
                (laX[2] * laY[0]) + (laX[3] * laY[2]),
                (laX[2] * laY[1]) + (laX[3] * laY[3])
        };
    }
    */

    /* 
     * Fast matrix method. Easy to describe, but has a constant factor slowdown compared to doubling method.
     * [1 1]^n   [F(n+1) F(n)  ]
     * [1 0]   = [F(n)   F(n-1)].
     */
    public BigInteger calculate() {
        if (m_iNumber < 2) {
            return BigInteger.valueOf(m_iNumber);
        } else {
            BigInteger[] matrix = {BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO};
            return matrixPow(matrix, m_iNumber)[1];
        }
    }

    // Computes the power of a matrix. The matrix is packed in row-major order.
    private static BigInteger[] matrixPow(BigInteger[] matrix, int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        BigInteger[] result = {BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE};
        while (n != 0) {  // Exponentiation by squaring
            if (n % 2 != 0)
                result = matrixMultiply(result, matrix);
            n /= 2;
            matrix = matrixMultiply(matrix, matrix);
        }
        return result;
    }

    // Multiplies two matrices.
    private static BigInteger[] matrixMultiply(BigInteger[] x, BigInteger[] y) {
        return new BigInteger[] {
            multiply(x[0], y[0]).add(multiply(x[1], y[2])),
                multiply(x[0], y[1]).add(multiply(x[1], y[3])),
                multiply(x[2], y[0]).add(multiply(x[3], y[2])),
                multiply(x[2], y[1]).add(multiply(x[3], y[3]))
        };
    }

    // Multiplies two BigIntegers. This function makes it easy to swap in a faster algorithm like Karatsuba multiplication.
    private static BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
