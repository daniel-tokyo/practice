/**
 * Created at: 2012-04-26 15:09:03
 *
 * $Id:$
 */

import java.util.Random;

public class Tester {

    private static int                  m_iCount = 100;
    private static Tracer               m_oTracer = new Tracer();

    private static TreeFactory.TreeType m_eType = TreeFactory.TreeType.DEFAULT;
    private static String               m_sURL = new String();
    private static TreeFactory          m_oTreeFactory = new TreeFactory(m_oTracer); 

    public static void main(String[] args) {
        try { 
            if (init(args) == false) {
                usage();
            } else {
                m_oTracer.echo("Testing for binary search tree: ");
                m_oTracer.echo("----- build tree -----");
                BinarySearchTree<?> oTree = m_oTreeFactory.build(m_eType, 
                                                                 m_iCount);
                m_oTracer.echo("----- output -----");
                output(oTree);
                m_oTracer.echo("----- END -----");
            } 
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }

    private static void usage() {
        System.out.println("Usage:\n\tjava Tester <Integer|Float|Double|String URL>\n");
        System.out.println("Example:");
        System.out.println("\tjava Tester Integer");
        System.out.println("\tjava Tester Float");
        System.out.println("\tjava Tester Double");
        System.out.println("\tjava Tester String URL");
    }

    private static boolean init(String[] args) {
        boolean bRet = false;
        if (args.length > 0) {
            if ((args[0].compareToIgnoreCase("Integer") == 0) 
                     && (args.length == 1)) {
                m_eType = TreeFactory.TreeType.INTEGER;
                bRet = true;
            } else if ((args[0].compareToIgnoreCase("Float") == 0) 
                     && (args.length == 1)) {
                m_eType = TreeFactory.TreeType.FLOAT;
                bRet = true;
            } else if ((args[0].compareToIgnoreCase("Double") == 0) 
                     && (args.length == 1)) {
                m_eType = TreeFactory.TreeType.DOUBLE;
                bRet = true;
            } else if ((args[0].compareToIgnoreCase("String") == 0) 
                     && (args.length == 2)) {
                m_eType = TreeFactory.TreeType.STRING;
                m_sURL = args[1];
                bRet = true;
            }
        }
        return bRet;
    }

    private static void output(BinarySearchTree<?> oTree) {
        if (oTree != null) {
            m_oTracer.echo("[" + oTree + "]");
        } else {
            m_oTracer.echo("The tree is empty!");
        }
    }
}

class TreeFactory {

    private static Tracer  m_oTracer = null;

    public TreeFactory(Tracer oTracer) {
        m_oTracer = oTracer;
    }

    public enum TreeType {
        DEFAULT, INTEGER, FLOAT, DOUBLE, STRING
    }

    public BinarySearchTree build(TreeType eType, int iCnt) {
        switch (eType) {
            case INTEGER:
                return buildInteger(iCnt);
            case FLOAT:
                return buildFloat(iCnt);
            case DOUBLE:
                return buildDouble(iCnt);
            case STRING:
                return buildString(iCnt);
            default:
                assert false; // ERROR: The tree type is wrong!
                return null;
        }
    }

    private BinarySearchTree<?> buildInteger(int iCnt) {
        return null;
    }

    private BinarySearchTree<?> buildFloat(int iCnt) {
        BinarySearchTree<Float> oTree = new BinarySearchTree<Float>();
        if (oTree != null) {
            Random oRandom = new Random();
            for (int i = 0; i < iCnt; i++) {
                Float ofKey = new Float(oRandom.nextInt(10000) + oRandom.nextFloat());
                String oMsg = "Add [" + ofKey + "]...(" + i + ")";
                if (oTree.add(ofKey) == false) {
                    oMsg +=  " -> failed!";
                }
                m_oTracer.echo(oMsg);
            }
        }
        return oTree;
    }

    private BinarySearchTree<?> buildDouble(int iCnt) {
        return null;
    }

    private BinarySearchTree<?> buildString(int iCnt) {
        return null;
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
