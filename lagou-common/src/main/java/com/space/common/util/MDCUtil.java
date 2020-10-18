package com.space.common.util;

import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @Author LUOZHENGCHAO674
 * @Date 2020-1-17 14:52
 */
public class MDCUtil {

    public static void put(String value) {
        if (!StringUtils.isEmpty(value)) {
            MDC.put("traceId", value);
            return;
        }
        MDC.put("traceId", getTraceId());
    }

    public static String get() {
        return MDC.get("traceId");
    }

    public static void remove() {
        MDC.remove("traceId");
    }

    public static void clear() {
        MDC.clear();
    }

    public static String getTraceId() {
        String traceId = get();
        if (traceId == null) {
            traceId = UUID.randomUUID().toString().replace("-", "");
        }

        return traceId;
    }
}
