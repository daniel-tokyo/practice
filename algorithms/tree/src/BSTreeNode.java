/**
 * Created at: 2012-04-26 15:16:47
 *
 * $Id:$
 */

public class BSTreeNode extends BinaryTreeNode {

    /* constructors */

    public BSTreeNode() {
        super();
    }

    public BSTreeNode(int iKey) {
        super(iKey);
    }

    /* public methods */

    @overwrite
    public boolean add(int iKey) {
        boolean bRet = false; // iKey == this.m_iKey
        if (iKey < this.m_iKey) {
            bRet = addLeftNode(iKey);
        } else if (iKey > this.m_iKey) {
            bRet = addRightNode(iKey);
        }
        return bRet;
    }

    @overwrite
    public boolean search(int iKey) {
        boolean bRet = false;
        if (iKey == this.m_iKey) {
            bRet = true;
        } else if (iKey < this.m_iKey) {
            bRet = (this.m_oLeft == null) ? false : this.m_oLeft.search(iKey);
        } else { // node.mKey > this.mKey
            bRet = (this.m_oRight == null) ? false : this.m_oRight.search(iKey);
        }
        return bRet;
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
