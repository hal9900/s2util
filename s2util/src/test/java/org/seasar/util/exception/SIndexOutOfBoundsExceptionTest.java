/*
 * Copyright 2004-2012 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.util.exception;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * @author wyukawa
 * 
 */
public class SIndexOutOfBoundsExceptionTest {

    /**
     * Test method for
     * {@link org.seasar.util.exception.SIndexOutOfBoundsException#SIndexOutOfBoundsException()}
     * .
     */
    @Test
    public void testSIndexOutOfBoundsException() {
        SIndexOutOfBoundsException sIndexOutOfBoundsException =
            new SIndexOutOfBoundsException();
        assertThat(sIndexOutOfBoundsException, is(notNullValue()));
    }

    /**
     * Test method for
     * {@link org.seasar.util.exception.SIndexOutOfBoundsException#SIndexOutOfBoundsException(java.lang.String)}
     * .
     */
    @Test
    public void testSIndexOutOfBoundsExceptionString() {
        SIndexOutOfBoundsException sIndexOutOfBoundsException =
            new SIndexOutOfBoundsException("hoge");
        assertThat(sIndexOutOfBoundsException.getMessage(), is("hoge"));
    }

}
