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


/**
 * {@link IllegalStateException}をラップする例外です。
 * 
 * @author wyukawa
 */
public class SIllegalStateException extends IllegalStateException {

    private static final long serialVersionUID = -2154525994315946504L;

    /**
     * {@link SIllegalStateException}を作成します。
     */
    public SIllegalStateException() {
        super();
    }

    /**
     * {@link SIllegalStateException}を作成します。
     * 
     * @param message
     *            メッセージ
     */
    public SIllegalStateException(String message) {
        super(message);
    }

    /**
     * {@link SIllegalStateException}を作成します。
     * 
     * @param message
     *            メッセージ
     * @param cause
     *            元の例外
     */
    public SIllegalStateException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * {@link SIllegalStateException}を作成します。
     * 
     * @param cause
     *            元の例外
     */
    public SIllegalStateException(Throwable cause) {
        super(cause);
    }

}