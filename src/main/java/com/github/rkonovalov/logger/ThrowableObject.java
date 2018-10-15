package com.github.rkonovalov.logger;

public class ThrowableObject {
    private Object object;
    private Throwable throwable;

    public ThrowableObject() {
    }

    public ThrowableObject(Object object, Throwable throwable) {
        this.object = object;
        this.throwable = throwable;
    }

    public ThrowableObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public ThrowableObject setObject(Object object) {
        this.object = object;
        return this;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public ThrowableObject setThrowable(Throwable throwable) {
        this.throwable = throwable;
        return this;
    }
}
