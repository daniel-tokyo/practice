/**
 * Created at: 2012-04-26 15:07:09
 *
 * $Id:$
 */

public class BinarySearchTree {

    // private members

    private BSTreeNode m_oRoot;

    // constructors

    public BinarySearchTree() {
        this.m_oRoot = null;
    }

    // public methods

    public boolean add(int iKey) {
        return ((this.m_oRoot == null) ? setRoot(iKey) : this.m_oRoot.add(iKey));
    }

    public boolean search(int iKey) {
        return ((this.m_oRoot == null) ? false : this.m_oRoot.search(iKey));
    }

    public String toString() {
        StringBuilder oStr = new StringBuilder();
        toString(oStr, this.m_oRoot);
        return oStr.toString().trim();
    }

    // private methods

    private boolean setRoot(int iKey) {
        if (this.m_oRoot == null) {
            this.m_oRoot = new BSTreeNode(iKey);
            return true;
        } else {
            return false;
        }
    }

    private void toString(StringBuilder oStr, BSTreeNode oNode) {
        if (oNode != null) {
            toString(oStr, oNode.getLeftNode());
            oStr.append(oNode.toString() + " ");
            toString(oStr, oNode.getRightNode());
        }
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
