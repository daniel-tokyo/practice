/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */


import java.math.BigInteger;
import java.lang.Math;


// F(n) = (sqrt(5)/5) * (pow(((1+sqrt(5))/2), n) - pow((1-sqrt(5))/2, n))
public class FibonacciDirect extends Fibonacci {

    private static final int MAX_LIMITED = 71;

    // Constants for direct method
    private static final double D_FACTOR = Math.sqrt(5) / 5;
    private static final double D_PHI = (1 + Math.sqrt(5)) / 2;
    private static final double D_PSI = (1 - Math.sqrt(5)) / 2;

    public BigInteger calculate() {
        if (m_iNumber >= MAX_LIMITED) {
            throw new IllegalArgumentException("The DIRECT is limied less than " + MAX_LIMITED + "!");
        } else if (m_iNumber < 2) {
            return BigInteger.valueOf(m_iNumber);
        } else {
            double dRes = D_FACTOR * 
                (Math.pow(D_PHI, m_iNumber) - Math.pow(D_PSI, m_iNumber));
            return BigInteger.valueOf(Double.valueOf(dRes).longValue());
        }
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
