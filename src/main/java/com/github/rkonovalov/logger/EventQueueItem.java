package com.github.rkonovalov.logger;

import org.apache.log4j.Level;

/**
 *
 * This class used in {@link AdvancedLogger} as item in packet queue
 */

public class EventQueueItem {
    private LoggerEvent event;
    private Level level;
    private PacketType packetType;
    private Object eventResult;

    /**
     * Constructor
     * @param event {@link LoggerEvent} logger event
     * @param level {@link Level} log level
     * @param packetType {@link PacketType} packet type
     */
    public EventQueueItem(LoggerEvent event, Level level, PacketType packetType) {
        this.event = event;
        this.level = level;
        this.packetType = packetType;

        /*
         * If packetType is critical AdvancedLogger retrieves result from event
         */
        if(packetType == PacketType.CRITICAL)
            this.eventResult = event.onEvent();
    }

    /**
     * Log event
     * @return {@link LoggerEvent} logger event
     */
    public LoggerEvent getEvent() {
        return event;
    }

    /**
     * Log level
     * @return {@link Level} log level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Packet type
     * @return {@link PacketType} packet type
     */
    public PacketType getPacketType() {
        return packetType;
    }

    /**
     * Result of event
     * @return {@link Object} or {@link ThrowableObject} event result
     * When packetType == PacketType.CRITICAL object could be not null
     */
    public Object getEventResult() {
        return eventResult;
    }
}
