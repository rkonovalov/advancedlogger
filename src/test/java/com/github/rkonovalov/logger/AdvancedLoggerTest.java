package com.github.rkonovalov.logger;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertNotNull;

public class AdvancedLoggerTest {
    private AdvancedLogger defaultLogger;

    @Before
    public void init() {
        defaultLogger = AdvancedLogger.getLogger(AdvancedLoggerTest.class);
        assertNotNull(defaultLogger);
    }

    @Test
    public void testGetLoggerByLogger() {
        AdvancedLogger logger = AdvancedLogger.getLogger(Logger.getLogger(AdvancedLoggerTest.class));
        assertNotNull(logger);
    }

    @Test
    public void testGetLoggerByObject() {
        Object obj = new Object();
        AdvancedLogger logger = AdvancedLogger.getLogger(obj);
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

    @Test
    public void testFatal() {
        AdvancedLogger logger = defaultLogger.fatal(() -> "fatal");
        assertNotNull(logger);
    }

    @Test
    public void testError() {
        AdvancedLogger logger = defaultLogger.error(() -> "error");
        assertNotNull(logger);
    }

    @Test
    public void testWarn() {
        AdvancedLogger logger = defaultLogger.warn(() -> "warn");
        assertNotNull(logger);
    }

    @Test
    public void testInfo() {
        AdvancedLogger logger = defaultLogger.info(() -> "info");
        assertNotNull(logger);
    }

    @Test
    public void testDebug() {
        AdvancedLogger logger = defaultLogger.debug(() -> "debug");
        assertNotNull(logger);
    }

    @Test
    public void testTrace() {
        AdvancedLogger logger = defaultLogger.trace(() -> "trace");
        assertNotNull(logger);
    }


    @Test
    public void testFatals() {
        AdvancedLogger logger = defaultLogger.fatal(() -> "fatal", () -> "message");
        assertNotNull(logger);
    }

    @Test
    public void testErrors() {
        AdvancedLogger logger = defaultLogger.error(() -> "error", () -> "message");
        assertNotNull(logger);
    }

    @Test
    public void testWarns() {
        AdvancedLogger logger = defaultLogger.warn(() -> "warn", () -> "message");
        assertNotNull(logger);
    }

    @Test
    public void testInfos() {
        AdvancedLogger logger = defaultLogger.info(() -> "info", () -> "message");
        assertNotNull(logger);
    }

    @Test
    public void testDebugs() {
        AdvancedLogger logger = defaultLogger.debug(() -> "debug", () -> "message");
        assertNotNull(logger);
    }

    @Test
    public void testTraces() {
        AdvancedLogger logger = defaultLogger.trace(() -> "trace", () -> "message");
        assertNotNull(logger);
    }

    @Test
    public void testPacket() {
        AdvancedLogger logger = defaultLogger.startPacket();
        assertNotNull(logger);
        defaultLogger.fatal(() -> "fatal info")
                .error(() -> "error info")
                .warn(() -> "warn info")
                .info(() -> "info")
                .debug(() -> "debug info")
                .trace(() -> "error info");
        defaultLogger.stopPacket();
    }

    @Test
    public void testThrowable() {
        AdvancedLogger logger = defaultLogger.error(() -> new RuntimeException("error"));
        assertNotNull(logger);
    }

    @Test
    public void testThrowables() {
        AdvancedLogger logger = defaultLogger.error(() -> new RuntimeException("error"), () -> new NullPointerException("second error"));
        assertNotNull(logger);
    }

    @Test
    public void testPacketCritical() {
        AdvancedLogger logger =defaultLogger.startPacket(PacketType.CRITICAL);
        assertNotNull(logger);
        defaultLogger.fatal(() -> "fatal info")
                .error(() -> "error info")
                .warn(() -> "warn info")
                .info(() -> "info")
                .debug(() -> "debug info")
                .trace(() -> "error info");
        defaultLogger.stopPacket();
    }
}
