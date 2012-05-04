/**
 * Created at: 2012-04-27 17:54:49
 *
 * $Id:$
 */

import java.util.logging.ConsoleHandler;

public class TraceHandler extends ConsoleHandler {
    public TraceHandler() {
        super();
        setFormatter(new TraceFormatter());
    }
}

/*{+----------------------------------------- Embira Footer 1.6 ---------+
   | vim<600:set et sw=4 ts=4 sts=4:                                     |
   | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
   +---------------------------------------------------------------------+}*/
