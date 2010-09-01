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

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.seasar.util.misc.Base64Util;

/**
 * {@link String}用の変換ユーティリティです。
 * 
 * @author higa
 * 
 */
public class StringConversionUtil {

    /**
     * WAVE DASHです。
     */
    public static final int WAVE_DASH = 0x301c;

    /**
     * FULLWIDTH TILDEです。
     */
    public static final int FULLWIDTH_TILDE = 0xff5e;

    /**
     * インスタンスを構築します。
     */
    protected StringConversionUtil() {
    }

    /**
     * 文字列に変換します。
     * 
     * @param value
     *            値
     * @return 変換された結果
     */
    public static String toString(final Object value) {
        return toString(value, null);
    }

    /**
     * 文字列に変換します。
     * 
     * @param value
     *            値
     * @param pattern
     *            パターン
     * @return 変換された結果
     */
    public static String toString(final Object value, final String pattern) {
        if (value == null) {
            return null;
        } else if (value instanceof String) {
            return (String) value;
        } else if (value instanceof java.util.Date) {
            return toString((java.util.Date) value, pattern);
        } else if (value instanceof Number) {
            return toString((Number) value, pattern);
        } else if (value instanceof byte[]) {
            return Base64Util.encode((byte[]) value);
        } else {
            return value.toString();
        }
    }

    /**
     * 文字列に変換します。
     * 
     * @param value
     *            値
     * @param pattern
     *            パターン
     * @return 変換された結果
     */
    public static String toString(final Number value, final String pattern) {
        if (value != null) {
            if (pattern != null) {
                return new DecimalFormat(pattern).format(value);
            }
            return value.toString();
        }
        return null;
    }

    /**
     * 文字列に変換します。
     * 
     * @param value
     *            値
     * @param pattern
     *            パターン
     * @return 変換された結果
     */
    public static String toString(final java.util.Date value,
            final String pattern) {
        if (value != null) {
            if (pattern != null) {
                return new SimpleDateFormat(pattern).format(value);
            }
            return value.toString();
        }
        return null;
    }

    /**
     * WAVE DASH(U+301C)をFULLWIDTH TILDE(U+FF5E)に変換します。
     * 
     * @param source
     *            ソース
     * @return 変換結果
     */
    public static String fromWaveDashToFullwidthTilde(final String source) {
        if (source == null) {
            return null;
        }
        final StringBuffer result = new StringBuffer(source.length());
        char ch;
        for (int i = 0; i < source.length(); i++) {
            ch = source.charAt(i);
            if (ch == WAVE_DASH) {
                ch = FULLWIDTH_TILDE;
            }
            result.append(ch);
        }
        return result.toString();
    }
}
