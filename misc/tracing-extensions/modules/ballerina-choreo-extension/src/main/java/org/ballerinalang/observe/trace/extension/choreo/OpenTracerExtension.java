/*
 * Copyright (c) 2020, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ballerinalang.observe.trace.extension.choreo;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.samplers.GuaranteedThroughputSampler;
import io.opentracing.Tracer;
import org.ballerinalang.jvm.StringUtils;
import org.ballerinalang.jvm.observability.tracer.OpenTracer;
import org.ballerinalang.jvm.values.api.BValueCreator;
import org.ballerinalang.observe.trace.extension.choreo.client.ChoreoClient;
import org.ballerinalang.observe.trace.extension.choreo.client.ChoreoClientHolder;
import org.ballerinalang.observe.trace.extension.choreo.logging.LogFactory;
import org.ballerinalang.observe.trace.extension.choreo.logging.Logger;

import java.util.Objects;

import static org.ballerinalang.observe.trace.extension.choreo.Constants.EXTENSION_NAME;

/**
 * This is the open tracing extension class for {@link OpenTracer}.
 */
public class OpenTracerExtension implements OpenTracer {
    private static final Logger LOGGER = LogFactory.getLogger();

    private ChoreoClient choreoClient;

    @Override
    public void init() {
        choreoClient = ChoreoClientHolder.getChoreoClient();
        if (Objects.isNull(choreoClient)) {
            throw BValueCreator.createErrorValue(
                    StringUtils.fromString("Choreo client is not initialized. Please check Ballerina configurations."),
                    null);
        }
        LOGGER.info("started publishing traces to Choreo");
    }

    @Override
    public Tracer getTracer(String tracerName, String serviceName) {
        if (Objects.isNull(choreoClient)) {
            throw BValueCreator.createErrorValue(
                    StringUtils.fromString("Choreo client is not initialized. Please check Ballerina configurations."),
                    null);
        }

        return new JaegerTracer.Builder(serviceName)
                .withSampler(new GuaranteedThroughputSampler(0.01, 0.5))
                .withReporter(new ChoreoJaegerReporter(2000))
                .build();
    }

    @Override
    public String getName() {
        return EXTENSION_NAME;
    }

}