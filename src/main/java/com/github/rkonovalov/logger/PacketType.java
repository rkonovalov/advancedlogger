package com.github.rkonovalov.logger;

/**
 *
 * This event used in {@link AdvancedLogger} and {@link EventQueueItem}
 */

public enum PacketType {
    /**
     * When LoggerEvent is time critical
     * AdvancedLogger retrieves result from event when add event to queue
     */
    CRITICAL,

    /**
     * When LoggerEvent is not time critical
     * AdvancedLogger retrieves result from event in stopPacket function
     */
    NOT_CRITICAL
}
