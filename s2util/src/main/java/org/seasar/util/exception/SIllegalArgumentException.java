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

import org.seasar.util.message.MessageFormatter;

/**
 * {@link IllegalArgumentException}をラップする例外です。
 * 
 * @author koichik
 */
public class SIllegalArgumentException extends IllegalArgumentException {

    private static final long serialVersionUID = -3701473506893554853L;

    private final String messageCode;

    private final Object[] args;

    /**
     * {@link SIllegalArgumentException}を作成します。
     * 
     * @param messageCode
     *            メッセージコード
     * @param args
     *            引数の配列
     */
    public SIllegalArgumentException(final String messageCode,
            final Object[] args) {
        this(messageCode, args, null);
    }

    /**
     * {@link SIllegalArgumentException}を作成します。
     * 
     * @param messageCode
     *            メッセージコード
     * @param args
     *            引数の配列
     * @param cause
     *            原因となった例外
     */
    public SIllegalArgumentException(final String messageCode,
            final Object[] args, Throwable cause) {
        super(MessageFormatter.getMessage(messageCode, args), cause);
        this.messageCode = messageCode;
        this.args = args;
    }

    /**
     * メッセージコードを返します。
     * 
     * @return メッセージコード
     */
    public String getMessageCode() {
        return messageCode;
    }

    /**
     * 引数の配列を返します。
     * 
     * @return 引数の配列
     */
    public Object[] getArgs() {
        return args;
    }

}
