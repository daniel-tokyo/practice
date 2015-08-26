/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */

import java.math.BigInteger;


public class FibonacciRecursive extends Fibonacci {

    public BigInteger calculate() {
        return recursive(m_iNumber);
    }

    private static BigInteger recursive(long lNumber) {
        if (lNumber < 2) {
            return BigInteger.valueOf(lNumber);
        } else {
            return (recursive(lNumber-1).add(recursive(lNumber-2)));
        }
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
