package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes5.dex */
public final class InstanceofPredicate extends AbstractPredicate<Object> implements Serializable {
    private static final long serialVersionUID = -6682656911025165584L;
    private final Class<?> iType;

    public static Predicate<Object> instanceOfPredicate(Class<?> cls) {
        return new InstanceofPredicate((Class) Objects.requireNonNull(cls, "type"));
    }

    public InstanceofPredicate(Class<?> cls) {
        this.iType = cls;
    }

    public Class<?> getType() {
        return this.iType;
    }

    @Override // org.apache.commons.collections4.Predicate, java.util.function.Predicate
    public boolean test(Object obj) {
        return this.iType.isInstance(obj);
    }
}
