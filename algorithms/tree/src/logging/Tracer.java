/**
 * Created at: 2012-04-27 18:12:16
 *
 * $Id:$
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class Tracer {

    private static final Logger m_oLogger = 
            Logger.getLogger(Tracer.class.getName());

    public Tracer() {
        m_oLogger.setUseParentHandlers(false);
        m_oLogger.addHandler(new TraceHandler());
    }

    public void echo(String oMsg) {
        m_oLogger.info(oMsg);
    }

    public void echo(Level oLevel, String oMsg) {
        m_oLogger.log(oLevel, oMsg);
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
