/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */


public class Tester {

    private static Fibonacci m_oFibonacci = null;

    // Constants {-----------------------------------------------------

    // Limited numbers
    private static final int MAX_LIMITED = 93;
    private static final int MAX_LIMITED_DIRECT = 70;

    // Error Messages
    private static final String S_ERR_ARG = new String("Need 2 input arguments!");
    private static final String S_ERR_NUMBER = 
        new String("The input number should be greater than zero!");
    private static final String S_ERR_METHOD = 
        new String("The input algorithm does not support!");

    // Input options
    private static final String S_MTD_REC = new String("recursive");
    private static final String S_MTD_LOP = new String("loop");
    private static final String S_MTD_MTX = new String("matrix");
    private static final String S_MTD_DBL = new String("doubling");
    private static final String S_MTD_DRT = new String("direct");

    // -----------------------------------------------} End of Constants

    public static void main(String[] args) {
        try {
            initFibonacci(args);
            assert(m_oFibonacci != null);
            System.out.println("F(" + m_oFibonacci.getNumber() + ") = " + m_oFibonacci);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            System.out.println("----------");
            usage();
        }
    }

    private static void usage() {
        System.out.println("Usage:");
        System.out.println("\tFibonacci <algorithm> <number>\n");
        System.out.println("\t- algorithm: " 
                + S_MTD_REC + ", " 
                + S_MTD_LOP + ", " 
                + S_MTD_MTX + ", " 
                + S_MTD_DBL + ", " 
                + S_MTD_DRT);
        System.out.println("\t- number:    a natural number greater than zero. The max limited is "
                + MAX_LIMITED + " except direct algorithm is " + MAX_LIMITED_DIRECT + ".\n");
    }

    // Will throw IllegalArgumentException
    private static void initFibonacci(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException(S_ERR_ARG);
        } else {
            int number = Integer.parseInt(args[1]);
            if (number < 0) {
                throw new IllegalArgumentException(S_ERR_NUMBER);
            } else {
                if (args[0].compareToIgnoreCase(S_MTD_REC) == 0) {
                    m_oFibonacci = new FibonacciRecursive();
                } else if (args[0].compareToIgnoreCase(S_MTD_LOP) == 0) {
                    m_oFibonacci = new FibonacciLoop();
                } else if (args[0].compareToIgnoreCase(S_MTD_MTX) == 0) {
                    m_oFibonacci = new FibonacciMatrix();
                } else if (args[0].compareToIgnoreCase(S_MTD_DBL) == 0) {
                    m_oFibonacci = new FibonacciDoubling();
                } else if (args[0].compareToIgnoreCase(S_MTD_DRT) == 0) {
                    m_oFibonacci = new FibonacciDirect();
                } else {
                    throw new IllegalArgumentException(S_ERR_METHOD);
                }
                assert(m_oFibonacci != null);
                m_oFibonacci.setNumber(number);
            }
        }
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
