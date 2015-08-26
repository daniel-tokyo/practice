/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */


public class FibonacciRecursive extends Fibonacci {

    public long calculate(long lNumber) {
        if (lNumber < 2) {
            return lNumber;
        } else {
            return (calculate(lNumber-1) + calculate(lNumber-2));
        }
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
