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
 * {@link IllegalAccessException}をラップする例外です。
 * 
 * @author higa
 */
public class IllegalAccessRuntimeException extends SRuntimeException {

    private static final long serialVersionUID = -3649900343028907465L;

    private final Class<?> targetClass;

    /**
     * {@link IllegalAccessRuntimeException}を作成します。
     * 
     * @param targetClass
     *            ターゲットクラス
     * @param cause
     *            原因となった例外
     */
    public IllegalAccessRuntimeException(final Class<?> targetClass,
            final IllegalAccessException cause) {
        super("EUTL0042", targetClass.getName(), cause);
        initCause(cause);
        this.targetClass = targetClass;
    }

    @Override
    public IllegalAccessRuntimeException initCause(final Throwable cause) {
        return (IllegalAccessRuntimeException) super.initCause(cause);
    }

    /**
     * ターゲットクラスを返します。
     * 
     * @return ターゲットクラス
     */
    public Class<?> getTargetClass() {
        return targetClass;
    }

}