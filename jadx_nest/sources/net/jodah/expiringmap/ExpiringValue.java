package net.jodah.expiringmap;

import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* INFO: loaded from: classes5.dex */
public final class ExpiringValue<V> {
    private static final long UNSET_DURATION = -1;
    private final long duration;
    private final ExpirationPolicy expirationPolicy;
    private final TimeUnit timeUnit;
    private final V value;

    public ExpiringValue(V v) {
        this(v, -1L, (TimeUnit) null, (ExpirationPolicy) null);
    }

    public ExpiringValue(V v, ExpirationPolicy expirationPolicy) {
        this(v, -1L, (TimeUnit) null, expirationPolicy);
    }

    public ExpiringValue(V v, long j, TimeUnit timeUnit) {
        this(v, j, timeUnit, (ExpirationPolicy) null);
        timeUnit.getClass();
    }

    public ExpiringValue(V v, ExpirationPolicy expirationPolicy, long j, TimeUnit timeUnit) {
        this(v, j, timeUnit, expirationPolicy);
        timeUnit.getClass();
    }

    private ExpiringValue(V v, long j, TimeUnit timeUnit, ExpirationPolicy expirationPolicy) {
        this.value = v;
        this.expirationPolicy = expirationPolicy;
        this.duration = j;
        this.timeUnit = timeUnit;
    }

    public V getValue() {
        return this.value;
    }

    public ExpirationPolicy getExpirationPolicy() {
        return this.expirationPolicy;
    }

    public long getDuration() {
        return this.duration;
    }

    public TimeUnit getTimeUnit() {
        return this.timeUnit;
    }

    public int hashCode() {
        V v = this.value;
        if (v != null) {
            return v.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ExpiringValue expiringValue = (ExpiringValue) obj;
            V v = this.value;
            if (v == null ? expiringValue.value == null : v.equals(expiringValue.value)) {
                if (this.expirationPolicy == expiringValue.expirationPolicy && this.duration == expiringValue.duration && this.timeUnit == expiringValue.timeUnit) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return "ExpiringValue{value=" + this.value + ", expirationPolicy=" + this.expirationPolicy + ", duration=" + this.duration + ", timeUnit=" + this.timeUnit + AbstractJsonLexerKt.END_OBJ;
    }
}
