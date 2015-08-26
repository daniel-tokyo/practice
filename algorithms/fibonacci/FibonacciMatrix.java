/**
 * $Id: $
 * Create at: 2012-07-26 18:17:11
 */


public class FibonacciMatrix extends Fibonacci {

    public long calculate(long lNumber) {
        if (lNumber < 2) {
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
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
