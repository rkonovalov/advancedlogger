import com.github.rkonovalov.logger.AdvancedLogger;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AdvancedLoggerTest {

    @Test
    public void testgetLoggerByObject() {
        String str = "str";
        AdvancedLogger logger = AdvancedLogger.getLogger(str);
        assertNotNull(logger);
    }

    @Test
    public void testGetLoggerByClass() {
        AdvancedLogger logger = AdvancedLogger.getLogger(AdvancedLoggerTest.class);
        assertNotNull(logger);
    }

    @Test
    public void testGetLoggerByName() {
        AdvancedLogger logger = AdvancedLogger.getLogger("String.class");
        assertNotNull(logger);
    }
}
