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

import static org.seasar.util.collection.ArrayUtil.*;

/**
 * リソースが見つからなかったときにスローされる例外です。
 * 
 * @author higa
 */
public class ResourceNotFoundRuntimeException extends SRuntimeException {

    private static final long serialVersionUID = 9033370905740809950L;

    private final String path;

    /**
     * {@link ResourceNotFoundRuntimeException}を作成します。
     * 
     * @param path
     *            リソースのパス
     */
    public ResourceNotFoundRuntimeException(final String path) {
        super("EUTL0055", asArray(path));
        this.path = path;
    }

    /**
     * パスを返します。
     * 
     * @return パス
     */
    public String getPath() {
        return path;
    }

}
