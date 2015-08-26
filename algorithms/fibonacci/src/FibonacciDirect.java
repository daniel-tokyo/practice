/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */


import java.lang.Math;


public class FibonacciDirect extends Fibonacci {

    // Constants for direct method
    private static final double D_FACTOR = Math.sqrt(5) / 5;
    private static final double D_PHI = (1 + Math.sqrt(5)) / 2;
    private static final double D_PSI = (1 - Math.sqrt(5)) / 2;

    public FibonacciDirect() {
        m_iMax = 70;
    }

    // F(n) = (sqrt(5)/5) * (pow(((1+sqrt(5))/2), n) - pow((1-sqrt(5))/2, n))
    public long calculate() {
        if (m_iNumber < 2) {
            return m_iNumber;
        } else {
            double dRes = D_FACTOR * 
                (Math.pow(D_PHI, m_iNumber) - Math.pow(D_PSI, m_iNumber));
            return Double.valueOf(dRes).longValue();
        }
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
