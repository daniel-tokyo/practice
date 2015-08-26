/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */


import java.lang.Math;


public class FibonacciDirect extends Fibonacci {

    // Constants {-----------------------------------------------------

    // Limited numbers
    private static final int MAX_LIMITED_DIRECT = 70;

    // Error Messages
    private static final String S_ERR_NUMBER_DIRECT = 
        new String("The input number cannot be greater than " + MAX_LIMITED_DIRECT + "!");

    // Constants for direct method
    private static final double D_FACTOR = Math.sqrt(5) / 5;
    private static final double D_PHI = (1 + Math.sqrt(5)) / 2;
    private static final double D_PSI = (1 - Math.sqrt(5)) / 2;

    // -----------------------------------------------} End of Constants

    // F(n) = (sqrt(5)/5) * (pow(((1+sqrt(5))/2), n) - pow((1-sqrt(5))/2, n))
    public long calculate(long lNumber) {
        if (lNumber >= MAX_LIMITED_DIRECT) {
            throw new IllegalArgumentException(S_ERR_NUMBER_DIRECT);
        } else if (lNumber < 2) {
            return lNumber;
        } else {
            double dRes = D_FACTOR * 
                (Math.pow(D_PHI, lNumber) - Math.pow(D_PSI, lNumber));
            return Double.valueOf(dRes).longValue();
        }
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
