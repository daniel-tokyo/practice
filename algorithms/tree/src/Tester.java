/**
 * Created at: 2012-04-26 15:09:03
 *
 * $Id:$
 */

import java.util.Random;

class Tester {

    private static Tracer m_oTracer = new Tracer();

    public static void main(String[] args) {
        try {
            m_oTracer.echo("Testing for binary search tree: ");
            BinarySearchTree oTree = new BinarySearchTree();
            Random oRandom = new Random();
            m_oTracer.echo("----- build tree -----");
            for (int i = 0; i < 100; i++) {
                int iKey = oRandom.nextInt(10000);
                String oMsg = "Add [" + iKey + "]...(" + i + ")";
                if (oTree.add(iKey) == false) {
                    oMsg +=  " -> failed!";
                }
                m_oTracer.echo(oMsg);
            }
            m_oTracer.echo("----- output -----");
            m_oTracer.echo("[" + oTree + "]");
            m_oTracer.echo("----- END -----");
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
