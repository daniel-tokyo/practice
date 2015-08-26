/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */

import java.math.BigInteger;


// F(n+2) = F(n+1) + F(n)
public class FibonacciLoop extends Fibonacci {

    public BigInteger calculate() {
        BigInteger Fn = BigInteger.ZERO;
        BigInteger Fn1 = BigInteger.ONE;
        for (int i = 0; i < m_iNumber; i++) {
            BigInteger Fn2 = Fn1.add(Fn);
            Fn = Fn1;
            Fn1 = Fn2;
        }
        return Fn;
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
