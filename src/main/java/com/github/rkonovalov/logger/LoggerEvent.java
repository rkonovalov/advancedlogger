package com.github.rkonovalov.logger;

/**
 *
 * This event used in {@link AdvancedLogger}
 */

public interface LoggerEvent {
    /**
     * Event
     * @return {@link Object} or {@link ThrowableObject}
     */
    Object onEvent();
}
