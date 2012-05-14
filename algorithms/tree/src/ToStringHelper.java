/**
 * Created at: 2012-05-06 00:05:34
 *
 * $Id:$
 */

public class ToStringHelper implements BinaryTreeHelper {

    // private members

    private StringBuffer m_oStrBuffer;

    // constructors

    public ToStringHelper() {
        m_oStrBuffer = new StringBuffer();
    }

    // public methods

    // implemnts the interface of BinaryTreeHelper
    public void treat(BinaryTreeNode<?> oNode) {
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
