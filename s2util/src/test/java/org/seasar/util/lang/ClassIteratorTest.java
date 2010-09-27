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
package org.seasar.util.lang;

import org.junit.Test;
import org.seasar.util.exception.SIllegalArgumentException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.seasar.util.TestUtil.*;

/**
 * @author koichik
 * 
 */
public class ClassIteratorTest {

    /**
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        ClassIterator it = new ClassIterator(Integer.class);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(sameClass(Integer.class)));

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(sameClass(Number.class)));

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(sameClass(Object.class)));

        assertThat(it.hasNext(), is(not(true)));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testExcludeObject() throws Exception {
        ClassIterator it = new ClassIterator(Integer.class, false);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(sameClass(Integer.class)));

        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(sameClass(Number.class)));

        assertThat(it.hasNext(), is(not(true)));
    }

    /**
     * @throws Exception
     */
    @Test(expected = SIllegalArgumentException.class)
    public void testInterface() throws Exception {
        new ClassIterator(Iterable.class);
    }
}
