/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */


public class FibonacciRecursive extends Fibonacci {

    public long calculate() {
        return recursive(m_iNumber);
    }

    private static long recursive(long lNumber) {
        if (lNumber < 2) {
            return lNumber;
        } else {
            return (recursive(lNumber-1) + recursive(lNumber-2));
        }
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
