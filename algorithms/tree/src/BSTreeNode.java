/**
 * Created at: 2012-04-26 15:16:47
 *
 * $Id:$
 */

public class BSTreeNode<T extends Comparable<T>> extends BinaryTreeNode<T> {

    // constructors

    public BSTreeNode(T tKey) {
        super(tKey);
    }

    // public methods

    // implement the abstract method of BinaryTreeNode
    public boolean add(T tKey) {
        boolean bRet = false; // tKey == this.m_tKey
        if (this.m_tKey.compareTo(tKey) > 0) {
            bRet = addLeftNode(tKey);
        } else if (this.m_tKey.compareTo(tKey) < 0) {
            bRet = addRightNode(tKey);
        }
        return bRet;
    }

    public boolean addLeftNode(T tKey) {
        if (this.m_oLeft == null) {
            this.m_oLeft = new BSTreeNode<T>(tKey);
            return true;
        } else {
            return this.m_oLeft.add(tKey);
        }
    }

    public boolean addRightNode(T tKey) {
        if (this.m_oRight == null) {
            this.m_oRight = new BSTreeNode<T>(tKey);
            return true;
        } else {
            return this.m_oRight.add(tKey);
        }
    }

    // implement the abstract method of BinaryTree
    public boolean search(T tKey) {
        boolean bRet = false;
        if (this.m_tKey.compareTo(tKey) == 0) {
            bRet = true;
        } else if (this.m_tKey.compareTo(tKey) > 0) {
            bRet = (this.m_oLeft == null) ? false : this.m_oLeft.search(tKey);
        } else { // tKey > this.m_tKey
            bRet = (this.m_oRight == null) ? false : this.m_oRight.search(tKey);
        }
        return bRet;
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
