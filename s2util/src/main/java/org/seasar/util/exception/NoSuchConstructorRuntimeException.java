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
package org.seasar.util.exception;

import java.lang.reflect.Constructor;

import org.seasar.util.lang.MethodUtil;

import static org.seasar.util.collection.ArrayUtil.*;

/**
 * {@link Constructor}が見つからない場合にスローされる{@link NoSuchMethodException}をラップする例外です。
 * 
 * @author higa
 */
public class NoSuchConstructorRuntimeException extends SRuntimeException {

    private static final long serialVersionUID = 8688818589925114466L;

    private final Class<?> targetClass;

    private final Class<?>[] argTypes;

    /**
     * {@link NoSuchConstructorRuntimeException}を作成します。
     * 
     * @param targetClass
     *            ターゲットクラス
     * @param argTypes
     *            引数型の並び
     * @param cause
     *            原因となった例外
     */
    public NoSuchConstructorRuntimeException(final Class<?> targetClass,
            final Class<?>[] argTypes, final Throwable cause) {
        super(
            "EUTL0064",
            asArray(
                targetClass.getName(),
                MethodUtil.getSignature(targetClass.getSimpleName(), argTypes)),
            cause);
        this.targetClass = targetClass;
        this.argTypes = argTypes;
    }

    /**
     * ターゲットクラスを返します。
     * 
     * @return ターゲットクラス
     */
    public Class<?> getTargetClass() {
        return targetClass;
    }

    /**
     * 引数型の並びを返します。
     * 
     * @return 引数型の並び
     */
    public Class<?>[] getArgTypes() {
        return argTypes;
    }

}
