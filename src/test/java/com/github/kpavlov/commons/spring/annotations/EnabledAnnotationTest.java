/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Konstantin Pavlov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.kpavlov.commons.spring.annotations;

import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@ContextConfiguration(classes = TestConfig.class)
public class EnabledAnnotationTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    ApplicationContext ctx;

    @Test
    public void testEnabledConfig() throws Exception {
        assertNotNull(ctx.getBean(TestConfig.EnabledConfig.class));
    }

    @Test
    public void testEnabledBean() throws Exception {
        assertEquals("Enabled Bean", ctx.getBean("enabledBean"));
    }

    @Test
    public void testEnabledEvaluatedConfig() throws Exception {
        assertNotNull(ctx.getBean(TestConfig.EnabledEvaluatedConfig.class));
    }

    @Test
    public void testEnabledEvaluatedBean() throws Exception {
        assertEquals("Enabled Evaluated Bean", ctx.getBean("enabledEvaluatedBean"));
    }


    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testDisabledConfig() throws Exception {
        ctx.getBean(TestConfig.DisabledConfig.class);
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testDisabledBean() throws Exception {
        ctx.getBean("disabledBean");
    }


    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testDisabledEvaluatedBean() throws Exception {
        assertNotNull(ctx.getBean("disabledEvaluatedBean"));
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testDisabledEvaluatedConfig() throws Exception {
        ctx.getBean(TestConfig.DisabledEvaluatedConfig.class);
    }


}