package com.github.rkonovalov.logger;

import com.sun.istack.internal.NotNull;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * This class expands features of standard Log4J logger
 */

public class AdvancedLogger {
    /**
     * Log4J logger
     */
    private Logger logger;

    /**
     * Packet queue
     */
    private Queue<EventQueueItem> eventList;

    /**
     * Used in packet logging
     */
    private boolean transactionStarted;

    /**
     * Used in packet logging
     */
    private PacketType packetType;

    /**
     * Constructor
     * @param logger {@link Logger} Log4J logger
     * May not be null
     */
    public AdvancedLogger(@NotNull Logger logger) {
        this.logger = logger;
        this.eventList = new LinkedList<>();
        this.transactionStarted = false;
        this.packetType = PacketType.NOT_CRITICAL;
    }

    /**
     * Constructor
     * @param className {@link String} the name of the logger to retrieve
     */
    public AdvancedLogger(String className) {
        this(Logger.getLogger(className));
    }

    /**
     * Constructor
     * @param clazz {@link Class} the class of the logger to retrieve
     * May not be null
     */
    public AdvancedLogger(@NotNull Class clazz) {
        this(clazz.getName());
    }

    /**
     * Constructor
     * @param object {@link Object} the object of the logger to retrieve
     * May not be null
     */
    public AdvancedLogger(@NotNull Object object) {
        this(object.getClass());
    }

    /**
     *
     * @param level {@link Level} log level
     * @param event  {@link LoggerEvent} log event
     * @param eventResult  {@link Object} result of log event
     * Not null when packetType {@link PacketType} is CRITICAL
     */
    private void log(Level level, LoggerEvent event, Object eventResult) {
        if (logger.isEnabledFor(level) && event != null) {
            if (!transactionStarted) {

                /*
                 * If eventResult is null then try to get event result from event
                 */
                if (eventResult == null)
                    eventResult = event.onEvent();

                /*
                 * If eventResult is eventResult then try to log throwable exception
                 */
                if (eventResult instanceof ThrowableObject) {
                    ThrowableObject throwableObject = (ThrowableObject) eventResult;
                    logger.log(level, throwableObject.getObject(), throwableObject.getThrowable());
                } else
                    logger.log(level, eventResult);
            } else {
                /*
                 * Enabled packet logging type, add event in eventList queue
                 */
                eventList.add(new EventQueueItem(event, level, packetType));
            }
        }
    }

    /**
     *
     * @param level {@link Level} log level
     * @param event {@link LoggerEvent} log event
     */
    private void log(Level level, LoggerEvent event) {
        log(level, event, null);
    }

    /**
     * Proceeds all events in eventList queue
     */
    private void proceedEvents() {
        while (eventList.size() > 0) {
            EventQueueItem item = eventList.remove();

            if(item.getPacketType() == PacketType.CRITICAL) {
                log(item.getLevel(), item.getEvent(), item.getEventResult());
            } else
                log(item.getLevel(), item.getEvent());
        }
    }

    /**
     * Starts packet logging
     */
    public void startPacket() {
        eventList.clear();
        transactionStarted = true;
    }

    /**
     * Starts packet logging
     * @param packetType {@link PacketType} packet type
     */
    public void startPacket(PacketType packetType) {
        this.packetType = packetType;
        startPacket();
    }

    /**
     * Stops packet logging and proceed to print all events in eventList queue
     */
    public void stopPacket() {
        transactionStarted = false;
        proceedEvents();
    }

    /**
     * Print event if log level {@link Level} FATAL is enabled
     * @param event {@link LoggerEvent} event may not be null
     * @return {@link AdvancedLogger} instance of AdvancedLogger class
     */
    public AdvancedLogger fatal(LoggerEvent event) {
        log(Level.FATAL, event);
        return this;
    }

    /**
     * Print events if log level {@link Level} FATAL is enabled
     * @param events {@link LoggerEvent} array of event may not be null
     * @return {@link AdvancedLogger} instance of AdvancedLogger class
     */
    public AdvancedLogger fatal(LoggerEvent... events) {
        for (LoggerEvent event : events)
            fatal(event);
        return this;
    }

    /**
     * Print event if log level {@link Level} ERROR is enabled
     * @param event {@link LoggerEvent} event may not be null
     * @return {@link AdvancedLogger} instance of AdvancedLogger class
     */
    public AdvancedLogger error(LoggerEvent event) {
        log(Level.ERROR, event);
        return this;
    }

    /**
     * Print events if log level {@link Level} ERROR is enabled
     * @param events {@link LoggerEvent} array of event may not be null
     * @return {@link AdvancedLogger} instance of AdvancedLogger class
     */
    public AdvancedLogger error(LoggerEvent... events) {
        for (LoggerEvent event : events)
            error(event);
        return this;
    }

    /**
     * Print event if log level {@link Level} WARN is enabled
     * @param event {@link LoggerEvent} event may not be null
     * @return {@link AdvancedLogger} instance of AdvancedLogger class
     */
    public AdvancedLogger warn(LoggerEvent event) {
        log(Level.WARN, event);
        return this;
    }

    /**
     * Print events if log level {@link Level} WARN is enabled
     * @param events {@link LoggerEvent} array of event may not be null
     * @return {@link AdvancedLogger} instance of AdvancedLogger class
     */
    public AdvancedLogger warn(LoggerEvent... events) {
        for (LoggerEvent event : events)
            warn(event);
        return this;
    }

    /**
     * Print event if log level {@link Level} INFO is enabled
     * @param event {@link LoggerEvent} event may not be null
     * @return {@link AdvancedLogger} instance of AdvancedLogger class
     */
    public AdvancedLogger info(LoggerEvent event) {
        log(Level.INFO, event);
        return this;
    }

    /**
     * Print events if log level {@link Level} INFO is enabled
     * @param events {@link LoggerEvent} array of event may not be null
     * @return {@link AdvancedLogger} instance of AdvancedLogger class
     */
    public AdvancedLogger info(LoggerEvent... events) {
        for (LoggerEvent event : events)
            info(event);
        return this;
    }

    /**
     * Print event if log level {@link Level} DEBUG is enabled
     * @param event {@link LoggerEvent} event may not be null
     * @return {@link AdvancedLogger} instance of AdvancedLogger class
     */
    public AdvancedLogger debug(LoggerEvent event) {
        log(Level.DEBUG, event);
        return this;
    }

    /**
     * Print events if log level {@link Level} DEBUG is enabled
     * @param events {@link LoggerEvent} array of event may not be null
     * @return {@link AdvancedLogger} instance of AdvancedLogger class
     */
    public AdvancedLogger debug(LoggerEvent... events) {
        for (LoggerEvent event : events)
            debug(event);
        return this;
    }

    /**
     * Print event if log level {@link Level} TRACE is enabled
     * @param event {@link LoggerEvent} event may not be null
     * @return {@link AdvancedLogger} instance of AdvancedLogger class
     */
    public AdvancedLogger trace(LoggerEvent event) {
        log(Level.TRACE, event);
        return this;
    }

    /**
     * Print events if log level {@link Level} TRACE is enabled
     * @param events {@link LoggerEvent} array of event may not be null
     * @return {@link AdvancedLogger} instance of AdvancedLogger class
     */
    public AdvancedLogger trace(LoggerEvent... events) {
        for (LoggerEvent event : events)
            trace(event);
        return this;
    }
}
