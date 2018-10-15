package com.github.rkonovalov.logger;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class AdvancedLogger {
    private Logger logger;

    public AdvancedLogger(Logger logger) {
        this.logger = logger;
    }

    public AdvancedLogger(String className) {
        this(Logger.getLogger(className));
    }

    public AdvancedLogger(Class clazz) {
        this(clazz.getName());
    }

    public AdvancedLogger(Object object) {
        this(object.getClass());
    }

    public void log(Level level, LoggerEvent event) {
        if (logger.isEnabledFor(level) && event != null) {
            Object object = event.onEvent();
            if (object instanceof ThrowableObject) {
                ThrowableObject throwableObject = (ThrowableObject) object;
                logger.log(level, throwableObject.getObject(), throwableObject.getThrowable());
            } else
                logger.log(level, object);
        }
    }

    public AdvancedLogger fatal(LoggerEvent event) {
        log(Level.FATAL, event);
        return this;
    }

    public AdvancedLogger fatal(LoggerEvent... events) {
        for (LoggerEvent event : events)
            fatal(event);
        return this;
    }

    public AdvancedLogger error(LoggerEvent event) {
        log(Level.ERROR, event);
        return this;
    }

    public AdvancedLogger error(LoggerEvent... events) {
        for (LoggerEvent event : events)
            error(event);
        return this;
    }

    public AdvancedLogger warn(LoggerEvent event) {
        log(Level.WARN, event);
        return this;
    }

    public AdvancedLogger warn(LoggerEvent... events) {
        for (LoggerEvent event : events)
            warn(event);
        return this;
    }

    public AdvancedLogger info(LoggerEvent event) {
        log(Level.INFO, event);
        return this;
    }

    public AdvancedLogger info(LoggerEvent... events) {
        for (LoggerEvent event : events)
            info(event);
        return this;
    }

    public AdvancedLogger debug(LoggerEvent event) {
        log(Level.DEBUG, event);
        return this;
    }

    public AdvancedLogger debug(LoggerEvent... events) {
        for (LoggerEvent event : events)
            debug(event);
        return this;
    }

    public AdvancedLogger trace(LoggerEvent event) {
        log(Level.TRACE, event);
        return this;
    }

    public AdvancedLogger trace(LoggerEvent... events) {
        for (LoggerEvent event : events)
            trace(event);
        return this;
    }
}
