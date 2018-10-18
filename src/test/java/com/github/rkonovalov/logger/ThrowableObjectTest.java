package com.github.rkonovalov.logger;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ThrowableObjectTest {

    @Test
    public void testCreateByObject() {
        Object str = "str";
        ThrowableObject throwableObject = new ThrowableObject(str);
        assertEquals(throwableObject.getObject(), str);
    }

    @Test
    public void testCreateByThrowable() {
        Throwable error = new RuntimeException("error");
        ThrowableObject throwableObject = new ThrowableObject("str", error);
        assertEquals(throwableObject.getThrowable(), error);
    }
}
