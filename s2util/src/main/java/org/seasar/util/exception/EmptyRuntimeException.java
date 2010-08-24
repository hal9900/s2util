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
 * 空の場合にスローされる例外です。
 * 
 * @author higa
 */
public class EmptyRuntimeException extends SRuntimeException {

    private static final long serialVersionUID = 4625805280526951642L;

    private final String targetName;

    /**
     * {@link EmptyRuntimeException}を作成します。
     * 
     * @param targetName
     *            対象の名前
     */
    public EmptyRuntimeException(final String targetName) {
        super("EUTL0007", targetName);
        this.targetName = targetName;
    }

    @Override
    public EmptyRuntimeException initCause(final Throwable cause) {
        return (EmptyRuntimeException) super.initCause(cause);
    }

    /**
     * ターゲット名を返します。
     * 
     * @return ターゲット名
     */
    public String getTargetName() {
        return targetName;
    }

}