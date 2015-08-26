/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */

import java.math.BigInteger;


/* 
 * Fast matrix method. Easy to describe, but has a constant factor slowdown compared to doubling method.
 * [1 1]^n   [F(n+1) F(n)  ]
 * [1 0]   = [F(n)   F(n-1)].
 */
public class FibonacciMatrix extends Fibonacci {

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
            x[0].multiply(y[0]).add(x[1].multiply(y[2])),
            x[0].multiply(y[1]).add(x[1].multiply(y[3])),
            x[2].multiply(y[0]).add(x[3].multiply(y[2])),
            x[2].multiply(y[1]).add(x[3].multiply(y[3]))
        };
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
