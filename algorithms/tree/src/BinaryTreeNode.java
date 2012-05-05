/**
 * Created at: 2012-05-04 19:48:26
 *
 * $Id:$
 */

public abstract class BinaryTreeNode {

    /* protected members */

    protected int m_iKey;
    protected BinaryTreeNode m_oLeft;
    protected BinaryTreeNode m_oRight;

    // constructors

    public BinaryTreeNode() {
        this.m_iKey = 0;
        this.m_oLeft = null;
        this.m_oRight = null;
    }

    public BinaryTreeNode(int iKey) {
        this.m_iKey = iKey;
        this.m_oLeft = null;
        this.m_oRight = null;
    }

    // public methods

    public int getKey() {
        return this.m_iKey;
    }

    public BinaryTreeNode getLeftNode() {
        return this.m_oLeft;
    }

    public BinaryTreeNode getRightNode() {
        return this.m_oRight;
    }

    public String toString() {
        return String.valueOf(this.m_iKey);
    }

    // abstract methods

    abstract boolean add(int iKey); 
    abstract boolean search(int iKey);
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
