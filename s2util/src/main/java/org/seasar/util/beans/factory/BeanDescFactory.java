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
package org.seasar.util.beans.factory;

import java.util.concurrent.ConcurrentMap;

import org.seasar.util.beans.BeanDesc;
import org.seasar.util.beans.impl.BeanDescImpl;
import org.seasar.util.misc.Disposable;
import org.seasar.util.misc.DisposableUtil;

import static org.seasar.util.collection.CollectionsUtil.*;
import static org.seasar.util.misc.AssertionUtil.*;

/**
 * {@link BeanDesc}を生成するクラスです。
 * <p>
 * 指定されたJavaBeansのメタデータを扱う{@link BeanDesc}を返します。
 * </p>
 * 
 * <pre>
 * BeanDesc beanDesc = BeanDescFactory.getBeanDesc(Foo.class);
 * </pre>
 * <p>
 * {@link BeanDesc}はキャッシュされます。 キャッシュをクリアするには{@link DisposableUtil#dispose()}
 * を呼び出してください。
 * </p>
 * 
 * @author higa
 * @see BeanDesc
 * @see DisposableUtil
 */
public abstract class BeanDescFactory {

    /** 初期化済みなら{@literal true} */
    private static volatile boolean initialized;

    /** {@link BeanDesc}のキャッシュ */
    private static final ConcurrentMap<Class<?>, BeanDesc> beanDescCache =
        newConcurrentHashMap(1024);

    static {
        initialize();
    }

    /**
     * {@link BeanDesc}を返します。
     * 
     * @param clazz
     *            Beanクラス。{@literal null}であってはいけません
     * @return {@link BeanDesc}
     */
    public static BeanDesc getBeanDesc(final Class<?> clazz) {
        assertArgumentNotNull("clazz", clazz);

        if (!initialized) {
            initialize();
        }
        BeanDesc beanDesc = beanDescCache.get(clazz);
        if (beanDesc == null) {
            beanDesc =
                putIfAbsent(beanDescCache, clazz, new BeanDescImpl(clazz));
        }
        return beanDesc;
    }

    /**
     * 初期化を行ないます。
     */
    public static void initialize() {
        synchronized (BeanDescFactory.class) {
            if (!initialized) {
                DisposableUtil.add(new Disposable() {
                    @Override
                    public void dispose() {
                        clear();
                    }
                });
                initialized = true;
            }
        }
    }

    /**
     * キャッシュをクリアします。
     */
    public static void clear() {
        beanDescCache.clear();
        initialized = false;
    }

}
