/**
 * Created at: 2012-05-05 17:33:59
 *
 * $Id:$
 */

public abstract class BinaryTree<T> {

    // protected members

    protected BinaryTreeNode<T> m_oRoot;

    // constructors

    public BinaryTree() {
        this.m_oRoot = null;
    }

    // abstract methods

    abstract boolean makeRoot(T tKey);

    // public methods

    public boolean add(T tKey) {
        return ((this.m_oRoot == null) ? makeRoot(tKey) : this.m_oRoot.add(tKey));
    }

    public boolean search(T tKey) {
        return ((this.m_oRoot == null) ? false : this.m_oRoot.search(tKey));
    }

    public String toString() {
        ToStringHelper oHelper = new ToStringHelper();
        traverseInOrder(this.m_oRoot, oHelper);
        return oHelper.toString();
    }

    // protected methods

    protected void traversePreOrder(BinaryTreeNode<T> oNode, BinaryTreeHelper oHelper) {
        if (oNode != null) {
            oHelper.treat(oNode);
            traversePreOrder(oNode.getLeftNode(), oHelper);
            traversePreOrder(oNode.getRightNode(), oHelper);
        }
    }

    protected void traverseInOrder(BinaryTreeNode<T> oNode, BinaryTreeHelper oHelper) {
        if (oNode != null) {
            traverseInOrder(oNode.getLeftNode(), oHelper);
            oHelper.treat(oNode);
            traverseInOrder(oNode.getRightNode(), oHelper);
        }
    }

    protected void traversePostOrder(BinaryTreeNode<T> oNode, BinaryTreeHelper oHelper) {
        if (oNode != null) {
            traversePostOrder(oNode.getLeftNode(), oHelper);
            traversePostOrder(oNode.getRightNode(), oHelper);
            oHelper.treat(oNode);
        }
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
