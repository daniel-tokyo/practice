/**
 * Created at: 2012-04-26 15:09:03
 *
 * $Id:$
 */

import java.util.Random;

public class Tester {

    private static BinaryTree<?>        m_oTree = null;
    private static int                  m_iCount = 100;
    private static TreeFactory.TreeType m_eType = TreeFactory.TreeType.DEFAULT;
    private static String               m_sURL = new String();
    private static Tracer               m_oTracer = new Tracer();

    public static void main(String[] args) {
        try { 
            if (init(args) == false) {
                usage();
            } else {
                m_oTracer.echo("Testing for binary search tree: ");
                build();
                output();
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

    private static boolean build() {
        m_oTracer.echo("----- build tree -----");
        if (m_oTree == null) {
            TreeFactory oTreeFactory = new TreeFactory(m_oTracer); 
            m_oTree = oTreeFactory.build(m_eType, m_iCount);
            return (m_oTree != null);
        } else {
            m_oTracer.echo("WARNING: The tree exists!");
            return false;
        }
    }

    private static void output() {
        m_oTracer.echo("----- output -----");
        if (m_oTree != null) {
            m_oTracer.echo("[" + m_oTree + "]");
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

    public BinaryTree<?> build(TreeType eType, int iCnt) {
        switch (eType) {
            case INTEGER:
                return buildIntegerTree(iCnt);
            case FLOAT:
                return buildFloatTree(iCnt);
            case DOUBLE:
                return buildDoubleTree(iCnt);
            case STRING:
                //return buildStringTree(iCnt);
            default:
                assert false; // ERROR: The tree type is wrong!
                return null;
        }
    }

    private BinaryTree<?> buildIntegerTree(int iCnt) {
        BinarySearchTree<Integer> oTree = new BinarySearchTree<Integer>();
        if (oTree != null) {
            Random oRandom = new Random();
            for (int i = 0; i < iCnt; i++) {
                Integer oKey = new Integer(oRandom.nextInt(10000));
                String oMsg = "Add [" + oKey + "]...(" + i + ")";
                if (oTree.add(oKey) == false) {
                    oMsg +=  " -> failed!";
                }
                m_oTracer.echo(oMsg);
            }
        }
        return oTree;
    }

    private BinaryTree<?> buildFloatTree(int iCnt) {
        BinarySearchTree<Float> oTree = new BinarySearchTree<Float>();
        if (oTree != null) {
            Random oRandom = new Random();
            for (int i = 0; i < iCnt; i++) {
                Float oKey = new Float(oRandom.nextInt(10000) + oRandom.nextFloat());
                String oMsg = "Add [" + oKey + "]...(" + i + ")";
                if (oTree.add(oKey) == false) {
                    oMsg +=  " -> failed!";
                }
                m_oTracer.echo(oMsg);
            }
        }
        return oTree;
    }

    private BinaryTree<?> buildDoubleTree(int iCnt) {
        BinarySearchTree<Double> oTree = new BinarySearchTree<Double>();
        if (oTree != null) {
            Random oRandom = new Random();
            for (int i = 0; i < iCnt; i++) {
                Double oKey = new Double(oRandom.nextInt(10000) + oRandom.nextDouble());
                String oMsg = "Add [" + oKey + "]...(" + i + ")";
                if (oTree.add(oKey) == false) {
                    oMsg +=  " -> failed!";
                }
                m_oTracer.echo(oMsg);
            }
        }
        return oTree;
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
