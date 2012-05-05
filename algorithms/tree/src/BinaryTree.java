/**
 * Created at: 2012-05-05 17:33:59
 *
 * $Id:$
 */

public abstract class BinaryTree {

    // protected members

    protected BinaryTreeNode m_oRoot;

    // constructors

    public BinaryTree() {
        this.m_oRoot = null;
    }

    // abstract methods

    abstract boolean makeRoot(int iKey);

    // public methods

    public boolean add(int iKey) {
        return ((this.m_oRoot == null) ? makeRoot(iKey) : this.m_oRoot.add(iKey));
    }

    public boolean search(int iKey) {
        return ((this.m_oRoot == null) ? false : this.m_oRoot.search(iKey));
    }

    public String toString() {
        ToStringHelper oHelper = new ToStringHelper();
        traverseInOrder(this.m_oRoot, oHelper);
        return oHelper.toString();
    }

    // protected methods

    protected void traversePreOrder(BinaryTreeNode oNode, BinaryTreeHelper oHelper) {
        if (oNode != null) {
            oHelper.treat(oNode);
            traversePreOrder(oNode.getLeftNode(), oHelper);
            traversePreOrder(oNode.getRightNode(), oHelper);
        }
    }

    protected void traverseInOrder(BinaryTreeNode oNode, BinaryTreeHelper oHelper) {
        if (oNode != null) {
            traverseInOrder(oNode.getLeftNode(), oHelper);
            oHelper.treat(oNode);
            traverseInOrder(oNode.getRightNode(), oHelper);
        }
    }

    protected void traversePostOrder(BinaryTreeNode oNode, BinaryTreeHelper oHelper) {
        if (oNode != null) {
            traversePostOrder(oNode.getLeftNode(), oHelper);
            traversePostOrder(oNode.getRightNode(), oHelper);
            oHelper.treat(oNode);
        }
    }
}

class ToStringHelper implements BinaryTreeHelper {

    // private members

    private StringBuffer m_oStrBuffer;

    // constructors

    public ToStringHelper() {
        m_oStrBuffer = new StringBuffer();
    }

    // public methods

    // implemnts the interface of BinaryTreeHelper
    public void treat(BinaryTreeNode oNode) {
        m_oStrBuffer.append(oNode.toString() + " ");
    }

    public String toString() {
        return m_oStrBuffer.toString().trim();
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
