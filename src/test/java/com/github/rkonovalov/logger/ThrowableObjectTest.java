
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.rkonovalov.logger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Ruslan {@literal <rkonovalov86@gmail.com>}
 * @version 1.0
 */

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
