/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */


import java.lang.Math;


public class Fibonacci {

    enum method { RECURSIVE, LOOP, MATRIX, DOUBLING, DIRECT } // input methods

    private static long m_lNumber = 0;
    private static method   m_eMethod = method.DIRECT;

    // Constants {-----------------------------------------------------

    // Error Messages
    private static final String S_ERR_NS  = new String("Not Support!");
    private static final String S_ERR_ARG = new String("Need 2 input arguments!");
    private static final String S_ERR_NUMBER = 
        new String("The input number should be greater than zero!");
    private static final String S_ERR_NUMBER_70 = 
        new String("The input number cannot be greater than 69!");
    private static final String S_ERR_NUMBER_93 = 
        new String("The integer will overflow! The input number cannot be greater than 92!");
    private static final String S_ERR_METHOD = 
        new String("The input algorithm does not support!");

    // Input options
    private static final String S_MTD_REC = new String("recursive");
    private static final String S_MTD_LOP = new String("loop");
    private static final String S_MTD_MTX = new String("matrix");
    private static final String S_MTD_DBL = new String("doubling");
    private static final String S_MTD_DRT = new String("direct");

    // Constants for direct method
    private static final double D_FACTOR = Math.sqrt(5) / 5;
    private static final double D_PHI = (1 + Math.sqrt(5)) / 2;
    private static final double D_PSI = (1 - Math.sqrt(5)) / 2;

    // -----------------------------------------------} End of Constants

    public static void main(String[] args) {
        try {
            parseArguments(args);
            System.out.println("F(" + m_lNumber + ") = " + getFibonacciNumber());
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
            System.out.println("----------");
            usage();
        }
    }

    private static void usage() {
        System.out.println("Usage:");
        System.out.println("\tFibonacci <algorithm> <number>\n");
        System.out.println("\talgorithm: " 
                + S_MTD_REC + ", " 
                + S_MTD_LOP + ", " 
                + S_MTD_MTX + ", " 
                + S_MTD_DBL + ", " 
                + S_MTD_DRT);
        System.out.println("\tnumber:    a natural number greater than zero.\n");
    }

    // Will throw IllegalArgumentException
    private static void parseArguments(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException(S_ERR_ARG);
        } else {
            if ((m_lNumber = Integer.parseInt(args[1])) < 0) {
                throw new IllegalArgumentException(S_ERR_NUMBER);
            } else {
                if (args[0].compareToIgnoreCase(S_MTD_REC) == 0) {
                    m_eMethod = method.RECURSIVE;
                } else if (args[0].compareToIgnoreCase(S_MTD_LOP) == 0) {
                    m_eMethod = method.LOOP;
                } else if (args[0].compareToIgnoreCase(S_MTD_MTX) == 0) {
                    m_eMethod = method.MATRIX;
                } else if (args[0].compareToIgnoreCase(S_MTD_DBL) == 0) {
                    m_eMethod = method.DOUBLING;
                } else if (args[0].compareToIgnoreCase(S_MTD_DRT) == 0) {
                    m_eMethod = method.DIRECT;
                } else {
                    throw new IllegalArgumentException(S_ERR_METHOD);
                }
            }
        }
    }

    private static long getFibonacciNumber() {
        switch (m_eMethod) {
            case RECURSIVE:
                return recursive(m_lNumber);
            case LOOP:
                return loop(m_lNumber);
            case MATRIX:
                return matrix(m_lNumber);
            case DOUBLING:
                return doubling(m_lNumber);
            case DIRECT:
                return direct(m_lNumber);
            default:
                throw new IllegalArgumentException(S_ERR_METHOD);
        }
    }

    private static long recursive(long lNumber) {
        if (lNumber < 0 || lNumber > 92) {
            throw new IllegalArgumentException(S_ERR_NUMBER);
        } else if (lNumber < 2) {
            return lNumber;
        } else {
            return (recursive(lNumber-1) + recursive(lNumber-2));
        }
    }

    // F(n+2) = F(n+1) + F(n)
    private static long loop(long lNumber) {
        if (lNumber < 0) {
            throw new IllegalArgumentException(S_ERR_NUMBER);
        } else if (lNumber >= 93) {
            throw new IllegalArgumentException(S_ERR_NUMBER_93);
        } else {
            long lFn = 0;
            long lFn1= 1;
            for (long i = 0; i < lNumber; i++) {
                long lFn2 = lFn1 + lFn;
                lFn = lFn1;
                lFn1 = lFn2;
            }
            return lFn;
        }
    }

    private static long matrix(long lNumber) {
        if (lNumber < 0) {
            throw new IllegalArgumentException(S_ERR_NUMBER);
        } else if (lNumber >= 93) {
            throw new IllegalArgumentException(S_ERR_NUMBER_93);
        } else if (lNumber < 2) {
            return lNumber;
        } else {
            long[] laSeed = { 1, 1, 1, 0 };
            return matrixPow(laSeed, lNumber)[1];
        }
    }

    private static long[] matrixPow(long[] laMatrix, long lNumber) {
        assert lNumber >= 0;
        long[] laResult = { 1, 0, 0, 1 };
        while (lNumber != 0) {
            if (lNumber % 2 != 0) {
                laResult = matrixMultiply(laResult, laMatrix);
            }
            lNumber /= 2;
            laMatrix = matrixMultiply(laMatrix, laMatrix);
        }
        return laResult;
    }

    private static long[] matrixMultiply(long[] laX, long[] laY) {
        return new long[] {
                (laX[0] * laY[0]) + (laX[1] * laY[2]),
                (laX[0] * laY[1]) + (laX[1] * laY[3]),
                (laX[2] * laY[0]) + (laX[3] * laY[2]),
                (laX[2] * laY[1]) + (laX[3] * laY[3])
        };
    }

    private static long doubling(long lNumber) {
        if (lNumber < 0) {
            throw new IllegalArgumentException(S_ERR_NUMBER);
        } else if (lNumber >= 93) {
            throw new IllegalArgumentException(S_ERR_NUMBER_93);
        } else if (lNumber < 2) {
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

    // F(n) = (sqrt(5)/5) * (pow(((1+sqrt(5))/2), n) - pow((1-sqrt(5))/2, n))
    private static long direct(long lNumber) {
        if (lNumber < 0) {
            throw new IllegalArgumentException(S_ERR_NUMBER);
        } else if (lNumber >= 70) {
            throw new IllegalArgumentException(S_ERR_NUMBER_70);
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
