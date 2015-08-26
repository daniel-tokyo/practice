/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */


public class FibonacciLoop extends Fibonacci {

    // F(n+2) = F(n+1) + F(n)
    public long calculate() {
        long lFn = 0;
        long lFn1= 1;
        for (long i = 0; i < m_iNumber; i++) {
            long lFn2 = lFn1 + lFn;
            lFn = lFn1;
            lFn1 = lFn2;
        }
        return lFn;
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
