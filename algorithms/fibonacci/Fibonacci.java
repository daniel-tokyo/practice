/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */


public abstract class Fibonacci {

    private int m_iNumber = 0;

    // Constants {-----------------------------------------------------

    // Limited numbers
    private static final int MAX_LIMITED = 93;

    // Error Messages
    private static final String S_ERR_NUMBER = 
        new String("The input number should be greater than zero and less than " + MAX_LIMITED + "!");

    // -----------------------------------------------} End of Constants

    public void setNumber(int iNumber) {
        if (iNumber < 0 || iNumber >= MAX_LIMITED) {
            throw new IllegalArgumentException(S_ERR_NUMBER);
        } else {
            m_iNumber = iNumber;
        }
    }

    public long getNumber() {
        return m_iNumber;
    }

    public String toString() {
        return String.valueOf(calculate(m_iNumber));
    }

    abstract long calculate(long lNumber);
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
