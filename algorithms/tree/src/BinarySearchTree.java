/**
 * Created at: 2012-04-26 15:07:09
 *
 * $Id:$
 */

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    // constructors

    public BinarySearchTree() {
        super();
    }

    // private methods

    // implement the abstract method of BinaryTree
    protected boolean makeRoot(T tKey) {
        if (this.m_oRoot == null) {
            this.m_oRoot = new BSTreeNode<T>(tKey);
            return true;
        } else {
            return false;
        }
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
