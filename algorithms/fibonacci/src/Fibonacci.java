/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */

import java.math.BigInteger;


public abstract class Fibonacci {

    protected int m_iNumber = 0;

    public void setNumber(int iNumber) {
        if (iNumber < 0) {
            throw new IllegalArgumentException("The input number should be greater than zero!");
        } else {
            m_iNumber = iNumber;
        }
    }

    public int getNumber() {
        return m_iNumber;
    }

    public String toString() {
        return calculate().toString();
    }

    abstract BigInteger calculate();
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
