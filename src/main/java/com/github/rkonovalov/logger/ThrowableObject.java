package com.github.rkonovalov.logger;

/**
 * Throwable object contains message object and exception
 * This class used in {@link AdvancedLogger}
 */

public class ThrowableObject {
    private Object object;
    private Throwable throwable;

    /**
     * Constructor
     */
    public ThrowableObject() {
    }

    /**
     * Constructor
     * @param object the message object
     * @param throwable the exception object, including its stack trace
     */
    public ThrowableObject(Object object, Throwable throwable) {
        this.object = object;
        this.throwable = throwable;
    }

    /**
     * Constructor
     * @param object the message object
     */
    public ThrowableObject(Object object) {
        this.object = object;
    }

    /**
     * The message object
     * @return {@link Object}
     */
    public Object getObject() {
        return object;
    }

    /**
     * The exception object, including its stack trace
     * @return {@link Throwable}
     */
    public Throwable getThrowable() {
        return throwable;
    }
}
