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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application.properties")
@Import({TestConfig.EnabledConfig.class,
        TestConfig.DisabledConfig.class,
        TestConfig.EnabledEvaluatedConfig.class,
        TestConfig.DisabledEvaluatedConfig.class})
public class TestConfig {

    @Configuration
    @Enabled("true")
    static class EnabledConfig {

    }

    @Configuration
    @Enabled("false")
    static class DisabledConfig {

        public DisabledConfig() {
            throw new AssertionError("DisabledConfig must not be instantiated.");
        }
    }

    @Configuration
    @Enabled("${test.EnabledEvaluatedConfig.enabled}")
    static class EnabledEvaluatedConfig {

    }

    @Configuration
    @Enabled("${test.DisabledEvaluatedConfig.enabled}")
    static class DisabledEvaluatedConfig {

        public DisabledEvaluatedConfig() {
            throw new AssertionError("DisabledEvaluatedConfig must not be instantiated.");
        }
    }

    @Bean
    @Enabled("true")
    String enabledBean() {
        return "Enabled Bean";
    }

    @Bean
    @Enabled("${test.EnabledEvaluatedBean.enabled}")
    String enabledEvaluatedBean() {
        return "Enabled Evaluated Bean";
    }

    @Bean
    @Enabled("false")
    String disabledBean() {
        throw new AssertionError("disabledBean must not be instantiated.");
    }
  @Bean
    @Enabled("${test.DisabledEvaluatedBean.enabled}")
    String disabledEvaluatedBean() {

      throw new AssertionError("disabledEvaluatedBean must not be instantiated.");
    }

}
