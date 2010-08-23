/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
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
 * @author higa
 * 
 */
public class SRuntimeExceptionTest {

    /**
     * @throws Exception
     */
    @Test
    public void testSeasarRuntimeException() throws Exception {
        SRuntimeException ex = new SRuntimeException("EUTL0001", "hoge");
        assertThat(ex.getMessageCode(), is("EUTL0001"));
        assertThat(ex.getArgs().length, is(1));
        assertThat(ex.getArgs()[0], is((Object) "hoge"));
        System.out.println(ex.getMessage());
    }

    /**
     * @throws Exception
     */
    @Test
    public void testGetCause() throws Exception {
        Throwable t = new NullPointerException("test");
        SRuntimeException ex =
            new SRuntimeException("EUTL0017", t).initCause(t);
        assertThat(ex.getCause(), is(t));
        ex.printStackTrace();
    }

}
