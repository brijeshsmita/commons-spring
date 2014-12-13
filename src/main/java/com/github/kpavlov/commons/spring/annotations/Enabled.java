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

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * Indicates that a component is eligible for registration when evaluated {@linkplain
 * #value expression} is true.
 * <p/>
 * {@code Enabled} may be used in conjunction with {@code Configuration} and {@code Bean} annotations.
 * <p/>
 * For example:
 * Given property file {@code application.properties} with property values <code>my.service.enabled</code> and <code>my.config.enabled</code>. Following code will only instantiate and configure {@code MyService} and {@code MyConfig} if values of appropreate properties are evaluated as <code>true</code>.
 *
 * <pre class="code">
 * &#064;Configuration
 * &#064;PropertySource}("classpath:/application.properties")
 * &#064;Import(MyConfig.class)
 * class AppConfig {
 * ....
 * <p/>
 * &#064;Bean
 * &#064;Enabled("${my.service.enabled}")
 * MyService myService {
 * return new MyService()
 * }
 * }
 * <p/>
 * &#064;Configuration
 * &#064;Enabled("${my.config.enabled}")
 * class MyConfig {
 * ....
 * }
 * </pre>
 *
 * @author Konstantin Pavlov
 * @see org.springframework.context.annotation.Conditional
 * @see BooleanValueCondition
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(BooleanValueCondition.class)
public @interface Enabled {

    /**
     * Expression to evaluate to verify if annotated component is eligible for registration.
     * ${...} placeholders are supported and will be evaluated upon execution.
     * Unresolvable placeholders with no default value will cause an IllegalArgumentException to be thrown.
     *
     * @see org.springframework.core.env.PropertyResolver#resolveRequiredPlaceholders(java.lang.String)
     */
    String value() default "true";
}
