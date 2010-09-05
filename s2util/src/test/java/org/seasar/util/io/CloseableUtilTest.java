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

import java.io.IOException;
import java.io.OutputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.seasar.util.exception.IORuntimeException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * @author shot
 */
public class CloseableUtilTest {

    /**
     * @see org.junit.rules.ExpectedException
     */
    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * @throws Exception
     */
    @Test
    public void testCloseSilently() throws Exception {
        NotifyOutputStream out = new NotifyOutputStream();
        CloseableUtil.closeSilently(out);
        assertThat(out.getNotify(), is("closed"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testCloseSilentlyNull() throws Exception {
        CloseableUtil.closeSilently((OutputStream) null);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testCloseSilently_noThrowIOException() throws Exception {
        OutputStream out = new IOExceptionOccurOutputStream();
        CloseableUtil.closeSilently(out);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testClose() throws Exception {
        NotifyOutputStream out = new NotifyOutputStream();
        CloseableUtil.close(out);
        assertThat(out.getNotify(), is("closed"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testCloseNull() throws Exception {
        CloseableUtil.close((OutputStream) null);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testClose_ThrowIOException() throws Exception {
        exception.expect(IORuntimeException.class);
        exception
            .expectMessage(is("[EUTL0040]IO例外が発生しました。理由はjava.io.IOException: close failed"));
        OutputStream out = new IOExceptionOccurOutputStream();
        CloseableUtil.close(out);
    }

    private static class NotifyOutputStream extends OutputStream {
        private String notify_;

        @Override
        public void write(int arg0) throws IOException {
        }

        @Override
        public void close() throws IOException {
            super.close();
            notify_ = "closed";
        }

        public String getNotify() {
            return notify_;
        }
    }

    private static class IOExceptionOccurOutputStream extends OutputStream {

        @Override
        public void write(int arg0) throws IOException {
        }

        @Override
        public void close() throws IOException {
            throw new IOException("close failed");
        }

    }
}
