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
        defaultLogger.fatal(() -> "fatal");
    }

    @Test
    public void testError() {
        defaultLogger.error(() -> "error");
    }

    @Test
    public void testWarn() {
        defaultLogger.warn(() -> "warn");
    }

    @Test
    public void testInfo() {
        defaultLogger.info(() -> "info");
    }

    @Test
    public void testDebug() {
        defaultLogger.debug(() -> "debug");
    }

    @Test
    public void testTrace() {
        defaultLogger.trace(() -> "trace");
    }


    @Test
    public void testFatals() {
        defaultLogger.fatal(() -> "fatal", () -> "message");
    }

    @Test
    public void testErrors() {
        defaultLogger.error(() -> "error", () -> "message");
    }

    @Test
    public void testWarns() {
        defaultLogger.warn(() -> "warn", () -> "message");
    }

    @Test
    public void testInfos() {
        defaultLogger.info(() -> "info", () -> "message");
    }

    @Test
    public void testDebugs() {
        defaultLogger.debug(() -> "debug", () -> "message");
    }

    @Test
    public void testTraces() {
        defaultLogger.trace(() -> "trace", () -> "message");
    }

    @Test
    public void testPacket() {
        defaultLogger.startPacket();
        defaultLogger.fatal(() -> "fatal info")
                .error(() -> "error info")
                .warn(() -> "warn info")
                .info(() -> "info")
                .debug(() -> "debug info")
                .trace(() -> "error info");
        defaultLogger.stopPacket();
    }

    @Test
    public void testPacketCritical() {
        defaultLogger.startPacket(PacketType.CRITICAL);
        defaultLogger.fatal(() -> "fatal info")
                .error(() -> "error info")
                .warn(() -> "warn info")
                .info(() -> "info")
                .debug(() -> "debug info")
                .trace(() -> "error info");
        defaultLogger.stopPacket();
    }
}
