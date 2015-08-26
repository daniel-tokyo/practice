/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */


import java.lang.Math;


public class FibonacciDoubling extends Fibonacci {

    public long calculate(long lNumber) {
        if (lNumber < 2) {
            return lNumber;
        } else {
            return doublingTuple(lNumber)[0];
        }
    }

    private static long[] doublingTuple(long lNumber) {
        if (lNumber == 0) {
            return new long[] { 0, 1 };
        } else {
            long[] laTuple = doublingTuple(lNumber/2);
            long lC = laTuple[0] * ((2 * laTuple[1]) - laTuple[0]);
            long lD = (laTuple[1] * laTuple[1]) + (laTuple[0] * laTuple[0]);
            if (lNumber % 2 == 0) {
                return new long[] { lC, lD  };
            } else {
                return new long[] { lD, lC + lD };
            }
        }
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
