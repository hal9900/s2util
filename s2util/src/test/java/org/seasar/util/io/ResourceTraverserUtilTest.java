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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;
import junit.textui.ResultPrinter;
import junit.textui.TestRunner;

import org.junit.Test;
import org.seasar.util.io.ResourceTraverserUtil.FileSystemResourceTraverser;
import org.seasar.util.io.ResourceTraverserUtil.JarFileResourceTraverser;
import org.seasar.util.io.xxx.DummyTest;
import org.seasar.util.lang.ClassUtil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * @author koichik
 */
public class ResourceTraverserUtilTest {

    /**
     * @throws Exception
     */
    @Test
    public void testFromClass_FileSystem() throws Exception {
        ResourceTraverser traverser =
            ResourceTraverserUtil.getResourceTraverser(DummyTest.class);
        assertThat(traverser, is(notNullValue()));
        assertThat(traverser instanceof FileSystemResourceTraverser, is(true));

        assertThat(traverser.isExistClass(DummyTest.class.getName()), is(true));
        assertThat(
            traverser.isExistClass(TestCase.class.getName()),
            is(not(true)));

        final Set<String> set = new HashSet<String>();
        traverser.forEach(new ClassHandler() {
            @Override
            public void processClass(String packageName, String shortClassName) {
                set.add(ClassUtil.concatName(packageName, shortClassName));
            }
        });
        assertThat(set.size() > 0, is(true));
        assertThat(set.contains(DummyTest.class.getName()), is(true));
        assertThat(
            set.contains(ResourceTraverserUtilTest.class.getName()),
            is(true));
        assertThat(set.contains(TestCase.class.getName()), is(not(true)));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testFromClass_JarFile() throws Exception {
        ResourceTraverser traverser =
            ResourceTraverserUtil.getResourceTraverser(TestCase.class);
        assertThat(traverser, is(notNullValue()));
        assertThat(traverser instanceof JarFileResourceTraverser, is(true));

        assertThat(traverser.isExistClass(TestCase.class.getName()), is(true));
        assertThat(
            traverser.isExistClass(DummyTest.class.getName()),
            is(not(true)));

        final Set<String> set = new HashSet<String>();
        traverser.forEach(new ClassHandler() {
            @Override
            public void processClass(String packageName, String shortClassName) {
                set.add(ClassUtil.concatName(packageName, shortClassName));
            }
        });
        assertThat(set.size() > 0, is(true));
        assertThat(set.contains(TestCase.class.getName()), is(true));
        assertThat(set.contains(DummyTest.class.getName()), is(not(true)));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testFromDir_FileSystem() throws Exception {
        ResourceTraverser traverser =
            ResourceTraverserUtil
                .getResourceTraverser("org/seasar/util/io/xxx");
        assertThat(traverser, is(notNullValue()));
        assertThat(traverser instanceof FileSystemResourceTraverser, is(true));

        final List<String> list = new ArrayList<String>();
        traverser.forEach(new ResourceHandler() {
            @Override
            public void processResource(String path, InputStream is) {
                list.add(path);
            }
        });
        assertThat(list.size(), is(1));
        assertThat((list.get(0)).endsWith("DummyTest.class"), is(true));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testFromDir_JarFile() throws Exception {
        ResourceTraverser traverser =
            ResourceTraverserUtil.getResourceTraverser("junit/textui");
        assertThat(traverser, is(notNullValue()));
        assertThat(traverser instanceof JarFileResourceTraverser, is(true));

        final List<String> list = new ArrayList<String>();
        traverser.forEach(new ResourceHandler() {
            @Override
            public void processResource(String path, InputStream is) {
                list.add(path);
            }
        });
        assertThat(list.size(), is(2));
        assertThat(list.get(0), is("junit/textui/ResultPrinter.class"));
        assertThat(list.get(1), is("junit/textui/TestRunner.class"));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testFromRootPackage_FileSystem() throws Exception {
        ResourceTraverser[] traversers =
            ResourceTraverserUtil
                .getResourceTraversers("org.seasar.util.io.xxx");
        assertThat(traversers, is(notNullValue()));
        assertThat(traversers.length, is(1));

        ResourceTraverser traverser = traversers[0];
        assertThat(traverser instanceof FileSystemResourceTraverser, is(true));

        assertThat(traverser.isExistClass("DummyTest"), is(true));
        assertThat(traverser.isExistClass("TestCase"), is(not(true)));

        final Set<String> set = new HashSet<String>();
        traverser.forEach(new ClassHandler() {
            @Override
            public void processClass(String packageName, String shortClassName) {
                set.add(ClassUtil.concatName(packageName, shortClassName));
            }
        });
        assertThat(set.size() > 0, is(true));
        assertThat(set.contains(DummyTest.class.getName()), is(true));
        assertThat(
            set.contains(ResourceTraverserUtilTest.class.getName()),
            is(not(true)));
        assertThat(set.contains(TestCase.class.getName()), is(not(true)));
    }

    /**
     * @throws Exception
     */
    @Test
    public void testFromRootPackage_JarFile() throws Exception {
        ResourceTraverser[] traversers =
            ResourceTraverserUtil.getResourceTraversers("junit.textui");
        assertThat(traversers, is(notNullValue()));
        assertThat(traversers.length, is(1));

        ResourceTraverser traverser = traversers[0];
        assertThat(traverser instanceof JarFileResourceTraverser, is(true));

        assertThat(traverser.isExistClass("TestRunner"), is(true));
        assertThat(traverser.isExistClass("DummyTest"), is(not(true)));

        final Set<String> set = new HashSet<String>();
        traverser.forEach(new ClassHandler() {
            @Override
            public void processClass(String packageName, String shortClassName) {
                set.add(ClassUtil.concatName(packageName, shortClassName));
            }
        });
        assertThat(set.size(), is(2));
        assertThat(set.contains(ResultPrinter.class.getName()), is(true));
        assertThat(set.contains(TestRunner.class.getName()), is(true));
        assertThat(
            set.contains(junit.extensions.TestDecorator.class.getName()),
            is(not(true)));
    }

}