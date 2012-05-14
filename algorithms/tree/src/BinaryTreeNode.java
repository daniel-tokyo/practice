/**
 * Created at: 2012-05-04 19:48:26
 *
 * $Id:$
 */

public abstract class BinaryTreeNode<T> {

    /* protected members */

    protected T m_tKey;
    protected BinaryTreeNode<T> m_oLeft;
    protected BinaryTreeNode<T> m_oRight;

    // constructors

    public BinaryTreeNode(T tKey) {
        this.m_tKey = tKey;
        this.m_oLeft = null;
        this.m_oRight = null;
    }

    // public methods

    public T getKey() {
        return this.m_tKey;
    }

    public BinaryTreeNode<T> getLeftNode() {
        return this.m_oLeft;
    }

    public BinaryTreeNode<T> getRightNode() {
        return this.m_oRight;
    }

    public String toString() {
        return String.valueOf(this.m_tKey);
    }

    // abstract methods

    abstract boolean add(T tKey); 
    abstract boolean search(T tKey);
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
