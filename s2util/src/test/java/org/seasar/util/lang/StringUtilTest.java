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
package org.seasar.util.lang;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * @author higa
 * 
 */
public class StringUtilTest {

    /**
     * @throws Exception
     */
    @Test
    public void testReplace() throws Exception {
        assertEquals("1", "1bc45", StringUtil.replace("12345", "23", "bc"));
        assertEquals("2", "1234ef", StringUtil.replace("12345", "5", "ef"));
        assertEquals("3", "ab2345", StringUtil.replace("12345", "1", "ab"));
        assertEquals("4", "a234a", StringUtil.replace("12341", "1", "a"));
        assertEquals(
            "5",
            "ab234abab234ab",
            StringUtil.replace("1234112341", "1", "ab"));
        assertEquals("6", "a\\nb", StringUtil.replace("a\nb", "\n", "\\n"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testSplit() throws Exception {
        String[] array = StringUtil.split("aaa\nbbb", "\n");
        assertEquals("1", 2, array.length);
        assertEquals("2", "aaa", array[0]);
        assertEquals("3", "bbb", array[1]);
    }

    /**
     * 
     */
    @Test
    public void testSplit2() {
        String[] array = StringUtil.split("aaa, bbb", ", ");
        assertEquals("1", 2, array.length);
        assertEquals("2", "aaa", array[0]);
        assertEquals("3", "bbb", array[1]);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testLtrim() throws Exception {
        assertEquals("1", "trim", StringUtil.ltrim("zzzytrim", "xyz"));
        assertEquals("2", "", StringUtil.ltrim("xyz", "xyz"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testRtrim() throws Exception {
        assertEquals("trim", StringUtil.rtrim("trimxxxx", "x"));
        assertEquals("", StringUtil.rtrim("xyz", "xyz"));
        assertEquals("trimxxxx", StringUtil.rtrim("trimxxxx", "y"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testTrimSuffix() throws Exception {
        assertEquals("aaa", StringUtil.trimSuffix("aaaLogic", "Logic"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testTrimPrefix() throws Exception {
        assertEquals("AAA", StringUtil.trimPrefix("T_AAA", "T_"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testIsBlank() throws Exception {
        assertEquals("1", true, StringUtil.isBlank(" "));
        assertEquals("2", true, StringUtil.isBlank(""));
        assertEquals("3", false, StringUtil.isBlank("a"));
        assertEquals("4", false, StringUtil.isBlank(" a "));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testIsNotBlank() throws Exception {
        assertEquals("1", false, StringUtil.isNotBlank(" "));
        assertEquals("2", false, StringUtil.isNotBlank(""));
        assertEquals("3", true, StringUtil.isNotBlank("a"));
        assertEquals("4", true, StringUtil.isNotBlank(" a "));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testContains() throws Exception {
        assertEquals("1", true, StringUtil.contains("a", 'a'));
        assertEquals("2", true, StringUtil.contains("abc", 'b'));
        assertEquals("3", false, StringUtil.contains("abc", 'd'));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testContains2() throws Exception {
        assertEquals("1", true, StringUtil.contains("a", "a"));
        assertEquals("2", true, StringUtil.contains("abc", "b"));
        assertEquals("3", false, StringUtil.contains("abc", "d"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testEquals() throws Exception {
        assertEquals("1", true, StringUtil.equals("a", "a"));
        assertEquals("2", true, StringUtil.equals(null, null));
        assertEquals("3", false, StringUtil.equals("a", null));
        assertEquals("4", false, StringUtil.equals(null, "a"));
        assertEquals("5", false, StringUtil.equals("a", "b"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testEqualsIgnoreCase() throws Exception {
        assertEquals("1", true, StringUtil.equalsIgnoreCase("a", "a"));
        assertEquals("2", true, StringUtil.equalsIgnoreCase("a", "A"));
        assertEquals("3", true, StringUtil.equalsIgnoreCase("A", "a"));
        assertEquals("4", true, StringUtil.equalsIgnoreCase(null, null));
        assertEquals("5", false, StringUtil.equalsIgnoreCase("a", null));
        assertEquals("6", false, StringUtil.equalsIgnoreCase(null, "a"));
        assertEquals("7", false, StringUtil.equalsIgnoreCase("a", "b"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testCapitalize() throws Exception {
        assertEquals("Abc", StringUtil.capitalize("abc"));
        assertEquals("Abc", StringUtil.capitalize("Abc"));
        assertEquals("ABC", StringUtil.capitalize("ABC"));
        assertEquals("UserId", StringUtil.capitalize("userId"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testDecapitalize() throws Exception {
        assertEquals("abc", StringUtil.decapitalize("abc"));
        assertEquals("abc", StringUtil.decapitalize("Abc"));
        assertEquals("ABC", StringUtil.decapitalize("ABC"));
        assertEquals("userId", StringUtil.decapitalize("UserId"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testEndsWithIgnoreCase() throws Exception {
        assertTrue(StringUtil.endsWithIgnoreCase("setHogeAaa", "Aaa"));
        assertTrue(StringUtil.endsWithIgnoreCase("setHogeAaa", "aaa"));
        assertTrue(StringUtil.endsWithIgnoreCase("aaa_hoge", "HOge"));
        assertFalse(StringUtil.endsWithIgnoreCase("setHogeaa", "Aaa"));
        assertFalse(StringUtil.endsWithIgnoreCase("aa", "Aaa"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testStartsWithIgnoreCase() throws Exception {
        assertTrue(StringUtil.startsWithIgnoreCase("isHoge", "is"));
        assertTrue(StringUtil.startsWithIgnoreCase("isHoge", "IS"));
        assertTrue(StringUtil.startsWithIgnoreCase("ISHoge", "is"));
        assertFalse(StringUtil.startsWithIgnoreCase("isHoge", "iss"));
        assertFalse(StringUtil.startsWithIgnoreCase("is", "iss"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testSubstringFromLast() throws Exception {
        assertEquals("ab", StringUtil.substringFromLast("abc", "c"));
        assertEquals("abcab", StringUtil.substringFromLast("abcabc", "c"));
        assertEquals("abc", StringUtil.substringFromLast("abc", ""));
        assertEquals("abc", StringUtil.substringFromLast("abc", null));
        assertEquals("abc", StringUtil.substringFromLast("abc", "dddd"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testSubstringToLast() throws Exception {
        assertEquals("", StringUtil.substringToLast("abc", "c"));
        assertEquals("c", StringUtil.substringToLast("abc", "b"));
        assertEquals("c", StringUtil.substringToLast("abcbc", "b"));
        assertEquals("abc", StringUtil.substringToLast("abc", ""));
        assertEquals("abc", StringUtil.substringToLast("abc", null));
        assertEquals("abc", StringUtil.substringToLast("abc", "dddd"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testToHex() throws Exception {
        assertEquals("010203", StringUtil.toHex(new byte[] { 1, 2, 3 }));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testToHex2() throws Exception {
        assertEquals("0001", StringUtil.toHex(1));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testAppendHex() throws Exception {
        StringBuilder buf = new StringBuilder();
        StringUtil.appendHex(buf, (byte) 1);
        assertEquals("01", buf.toString());
    }

    /**
     * @throws Exception
     */
    @Test
    public void testCamelize() throws Exception {
        assertNull(StringUtil.camelize(null));
        assertEquals("Emp", StringUtil.camelize("EMP"));
        assertEquals("AaaBbb", StringUtil.camelize("AAA_BBB"));
        assertEquals("UserId", StringUtil.camelize("USER_ID"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testDecamelize() throws Exception {
        assertNull(StringUtil.decamelize(null));
        assertEquals("EMP", StringUtil.decamelize("Emp"));
        assertEquals("AAA_BBB", StringUtil.decamelize("aaaBbb"));
        assertEquals("AAA_BBB", StringUtil.decamelize("AaaBbb"));
        assertEquals("AAA_BBB_C", StringUtil.decamelize("aaaBbbC"));
        assertEquals("USER_ID", StringUtil.decamelize("UserId"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testIsNumver() throws Exception {
        assertFalse(StringUtil.isNumber(null));
        assertTrue(StringUtil.isNumber("0123456789"));
        assertFalse(StringUtil.isNumber("aaaBBBccc"));
        assertFalse(StringUtil.isNumber("０１２３４５６７８９"));
        assertFalse(StringUtil.isNumber(""));
        assertFalse(StringUtil.isNumber("01234abcdef"));
        assertFalse(StringUtil.isNumber("abcdef01234"));
    }

    /**
     * 
     */
    @Test
    public void testIsEmpty() {
        assertTrue(StringUtil.isEmpty(null));
        assertTrue(StringUtil.isEmpty(""));
        assertFalse(StringUtil.isEmpty(" "));
    }

    /**
     * 
     */
    @Test
    public void testIsNotEmpty() {
        assertFalse(StringUtil.isNotEmpty(null));
        assertFalse(StringUtil.isNotEmpty(""));
        assertTrue(StringUtil.isNotEmpty(" "));
    }

    /**
     * 
     */
    @Test
    public void testDefaultString() {
        assertThat(StringUtil.defaultString(null), is(""));
        assertThat(StringUtil.defaultString(""), is(""));
        assertThat(StringUtil.defaultString("aaa"), is("aaa"));
    }

    /**
     * 
     */
    @Test
    public void testDefaultStringDefaultStr() {
        assertThat(StringUtil.defaultString(null, "NULL"), is("NULL"));
        assertThat(StringUtil.defaultString("", "NULL"), is(""));
        assertThat(StringUtil.defaultString("aaa", "NULL"), is("aaa"));
        assertThat(StringUtil.defaultString("aaa", null), is("aaa"));
        assertThat(StringUtil.defaultString(null, null), is(nullValue()));
    }

}
