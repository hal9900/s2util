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
package org.seasar.util.collection;

import java.util.Enumeration;
import java.util.Vector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.seasar.util.exception.NullArgumentException;
import org.seasar.util.exception.SUnsupportedOperationException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.seasar.util.collection.EnumerationIterator.*;

/**
 * @author shot
 * @author manhole
 */
public class EnumerationIteratorTest {

    /**
     * @see org.junit.rules.ExpectedException
     */
    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * 
     */
    @Test
    public void testEnumerationIterator() {
        Vector<String> vector = new Vector<String>();
        vector.add("a");
        EnumerationIterator<String> itr =
            new EnumerationIterator<String>(vector.elements());
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is("a"));
        assertThat(itr.hasNext(), is(not(true)));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testRemove() throws Exception {
        exception.expect(SUnsupportedOperationException.class);
        exception.expectMessage(is("remove"));
        Vector<String> vector = new Vector<String>();
        vector.add("a");
        EnumerationIterator<String> itr =
            new EnumerationIterator<String>(vector.elements());
        itr.remove();
    }

    /**
     * @throws Exception
     */
    @Test
    public void testNext() throws Exception {
        EnumerationIterator<String> itr =
            new EnumerationIterator<String>(new Vector<String>().elements());
        assertThat(itr.hasNext(), is(not(true)));
    }

    /**
     * @throws Exception
     */
    @Test(expected = NullArgumentException.class)
    public void testConstructorWithNull() throws Exception {
        new EnumerationIterator<String>((Enumeration<String>) null);
    }

    /**
     * @throws Exception
     */
    @SuppressWarnings("unused")
    @Test
    public void testIterable() throws Exception {
        Vector<String> vector = new Vector<String>();
        vector.add("a");
        vector.add("b");
        int count = 0;
        for (String s : iterable(vector.elements())) {
            ++count;
        }
        assertThat(count, is(2));
    }

    /**
     * Test method for
     * {@link org.seasar.util.collection.EnumerationIterator#EnumerationIterator(Enumeration)}
     * .
     */
    @Test
    public void testCopyDestNull() {
        exception.expect(NullArgumentException.class);
        exception.expectMessage(is("[EUTL0008]引数[enumeration]がnullです。"));
        new EnumerationIterator<Object>(null);
    }

}
