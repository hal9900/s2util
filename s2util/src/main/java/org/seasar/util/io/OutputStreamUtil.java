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
package org.seasar.util.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.seasar.util.exception.IORuntimeException;

import static org.seasar.util.misc.AssertionUtil.*;

/**
 * {@link OutputStream}用のユーティリティクラスです。
 * 
 * @author shot
 */
public abstract class OutputStreamUtil {

    /**
     * {@link FileOutputStream}を作成します。
     * 
     * @param file
     *            ファイル。{@literal null}であってはいけません
     * @return ファイルへ出力する{@link FileOutputStream}
     * @see FileOutputStream#FileOutputStream(File)
     */
    public static FileOutputStream create(final File file) {
        assertArgumentNotNull("file", file);

        try {
            return new FileOutputStream(file);
        } catch (final IOException e) {
            throw new IORuntimeException(e);
        }
    }

    /**
     * {@link OutputStream}をflushします。
     * 
     * @param out
     *            出力ストリーム
     */
    public static void flush(final OutputStream out) {
        if (out == null) {
            return;
        }
        try {
            out.flush();
        } catch (final IOException e) {
            throw new IORuntimeException(e);
        }
    }

}
