package com.open.mall.common.trace;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;

import java.util.Objects;

/**
 * TraceUtil
 *
 * @author zhoug
 * @date 2025/5/21 09:46
 */


public class TraceUtil {

    private static Tracer TRACER;

    public TraceUtil(Tracer tracer) {
        TRACER = tracer;
    }

    public static Tracer getTracer() {
        return TRACER;
    }

    public static Span getCurrentSpan() {
        return TRACER.currentSpan();
    }

    public static String getTraceId() {
        return Objects.requireNonNull(TRACER.currentTraceContext().context()).traceId();
    }
}
