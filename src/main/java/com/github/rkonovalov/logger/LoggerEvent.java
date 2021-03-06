package com.github.rkonovalov.logger;

/**
 * Log event
 * This event used in {@link AdvancedLogger}
 */

public interface LoggerEvent {
    /**
     * Event
     * @return {@link Object} or {@link ThrowableObject}
     */
    Object onEvent();
}
