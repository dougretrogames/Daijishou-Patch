package com.magneticchen.daijishou.support;

import java.lang.reflect.Method;

/**
 * Bridges for Kotlin value-class members whose JVM names contain characters
 * that are not legal in Java source code.
 */
public final class DaijishouValueSupport {

    private static final Method DURATION_IN_WHOLE_MILLISECONDS;

    static {
        Method method = null;
        try {
            method = kotlin.time.Duration.class.getDeclaredMethod("getInWholeMilliseconds-impl", long.class);
            method.setAccessible(true);
        } catch (Throwable ignored) {
            // leave null; the caller falls back to the raw value
        }
        DURATION_IN_WHOLE_MILLISECONDS = method;
    }

    private DaijishouValueSupport() {
    }

    public static long durationInWholeMilliseconds(long duration) {
        Method method = DURATION_IN_WHOLE_MILLISECONDS;
        if (method == null) {
            return duration;
        }
        try {
            return ((Long) method.invoke(null, Long.valueOf(duration))).longValue();
        } catch (Throwable throwable) {
            throw DaijishouSupport.sneakyThrow(throwable);
        }
    }

    public static Object resultConstructor(Object value) {
        return value;
    }
}
