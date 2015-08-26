/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */


import java.math.BigInteger;


/* 
 * Fast doubling method. Faster than the matrix method.
 * F(2n) = F(n) * (2*F(n+1) - F(n)).
 * F(2n+1) = F(n+1)^2 + F(n)^2.
 * This implementation is the non-recursive version.
 */
public class FibonacciDoubling extends Fibonacci {

    public BigInteger calculate() {
        if (m_iNumber < 2) {
            return BigInteger.valueOf(m_iNumber);
        } else {
            return doubling(m_iNumber);
        }
    }

    private static BigInteger doubling(int n) {
        BigInteger Fn = BigInteger.ZERO;
        BigInteger Fn1 = BigInteger.ONE;
        int m = 0;
        for (int i = 31 - Integer.numberOfLeadingZeros(n); i >= 0; i--) {
            // Double it
            BigInteger F2n = Fn.multiply(Fn1.shiftLeft(1).subtract(Fn));
            BigInteger F2n1 = Fn.multiply(Fn).add(Fn1.multiply(Fn1));
            Fn = F2n;
            Fn1 = F2n1;
            m *= 2;
            // Advance by one conditionally
            if (((n >>> i) & 1) != 0) {
                BigInteger c = Fn.add(Fn1);
                Fn = Fn1;
                Fn1 = c;
                m++;
            }
        }
        return Fn;
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
