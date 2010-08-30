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
package org.seasar.util.convert;

import junit.framework.TestCase;

/**
 * @author shinsuke
 * 
 */
public class StringConversionUtilTest extends TestCase {
    /**
     * @throws Exception
     */
    public void testFromWaveDashToFullwidthTilde() throws Exception {
        assertEquals(
            "abc 123",
            StringConversionUtil.fromWaveDashToFullwidthTilde("abc 123"));
        assertEquals(
            "abc" + String.valueOf((char) StringConversionUtil.FULLWIDTH_TILDE)
                + "123",
            StringConversionUtil.fromWaveDashToFullwidthTilde("abc"
                + String.valueOf((char) StringConversionUtil.WAVE_DASH) + "123"));
    }

    /**
     * @throws Exception
     */
    public void testFromWaveDashToFullwidthTildeForNull() throws Exception {
        assertNull(StringConversionUtil.fromWaveDashToFullwidthTilde(null));
    }

    /**
     * @throws Exception
     */
    public void testFromWaveDashToFullwidthTildeForEmptyString()
            throws Exception {
        assertEquals("", StringConversionUtil.fromWaveDashToFullwidthTilde(""));
    }
}
