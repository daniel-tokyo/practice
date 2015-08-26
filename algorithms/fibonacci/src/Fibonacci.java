/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */


public abstract class Fibonacci {

    protected        int    m_iNumber   = 0;
    protected static int    m_iMax      = 93;    // Max limited

    public int getMaxLimited() {
        return m_iMax;
    }

    public void setNumber(int iNumber) {
        if (iNumber < 0 || iNumber >= m_iMax) {
            throw new IllegalArgumentException(
                new String(
                    "The input number should be greater than zero and less than "
                    + m_iMax + "!")
            );
        } else {
            m_iNumber = iNumber;
        }
    }

    public long getNumber() {
        return m_iNumber;
    }

    public String toString() {
        return String.valueOf(calculate());
    }

    abstract long calculate();
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
