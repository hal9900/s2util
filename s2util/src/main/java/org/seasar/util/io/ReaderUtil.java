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
package org.seasar.util.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import org.seasar.util.exception.IORuntimeException;

import static org.seasar.util.misc.AssertionUtil.*;

/**
 * {@link Reader}用のユーティリティクラスです。
 * 
 * @author higa
 */
public abstract class ReaderUtil {

    private static final int BUF_SIZE = 4096;

    /**
     * {@link BufferedReader}から一行読み込んで返します。
     * 
     * @param reader
     *            {@link BufferedReader}
     * @return 一行の文字列。終端に達した場合は{@literal null}
     * @see BufferedReader#readLine()
     */
    public static String readLine(final BufferedReader reader) {
        try {
            return reader.readLine();
        } catch (final IOException e) {
            throw new IORuntimeException(e);
        }
    }

    /**
     * {@link Reader}からテキストを読み込みます。
     * <p>
     * {@link Reader}はクローズされません。
     * </p>
     * 
     * @param reader
     *            読み込み文字ストリーム
     * @return テキスト
     */
    public static String readText(final Reader reader) {
        assertArgumentNotNull("reader", reader);

        try {
            final BufferedReader in = new BufferedReader(reader);
            final StringBuilder out = new StringBuilder(BUF_SIZE);
            final char[] buf = new char[BUF_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.append(buf, 0, n);
            }
            return new String(out);
        } catch (final IOException e) {
            throw new IORuntimeException(e);
        }
    }

}
