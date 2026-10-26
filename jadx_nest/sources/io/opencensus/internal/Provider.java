package io.opencensus.internal;

import java.util.ServiceConfigurationError;

/* INFO: loaded from: classes4.dex */
public final class Provider {
    private Provider() {
    }

    /* WARN: Multi-variable type inference failed */
    public static <T> T createInstance(Class<?> cls, Class<T> cls2) {
        try {
            return (T) cls.asSubclass(cls2).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new ServiceConfigurationError("Provider " + cls.getName() + " could not be instantiated.", e);
        }
    }
}
