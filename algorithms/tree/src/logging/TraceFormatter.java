/**
 * Created at: 2012-04-27 17:50:45
 *
 * $Id:$
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class TraceFormatter extends Formatter {

    private static final SimpleDateFormat m_soFMT = 
            new SimpleDateFormat("hh:mm:ss.SSS");

    public TraceFormatter() {
        super();
    }

    public String format(LogRecord oRec) {
        StringBuffer oBuf= new StringBuffer();
        oBuf.append("[" + m_soFMT.format(new Date(oRec.getMillis())) + " ");
        oBuf.append(oRec.getLevel().getName() + "] ");
        oBuf.append(oRec.getMessage() + "\n");
        return oBuf.toString();
    }

}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
