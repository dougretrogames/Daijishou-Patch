package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Transformer;

/* INFO: loaded from: classes5.dex */
public class ConstantTransformer<T, R> implements Transformer<T, R>, Serializable {
    public static final Transformer NULL_INSTANCE = new ConstantTransformer(null);
    private static final long serialVersionUID = 6374440726369055124L;
    private final R iConstant;

    public static <I, O> Transformer<I, O> constantTransformer(O o) {
        if (o == null) {
            return nullTransformer();
        }
        return new ConstantTransformer(o);
    }

    public static <I, O> Transformer<I, O> nullTransformer() {
        return NULL_INSTANCE;
    }

    public ConstantTransformer(R r) {
        this.iConstant = r;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConstantTransformer) {
            return Objects.equals(((ConstantTransformer) obj).getConstant(), getConstant());
        }
        return false;
    }

    public R getConstant() {
        return this.iConstant;
    }

    public int hashCode() {
        int iHashCode = "ConstantTransformer".hashCode() << 2;
        return getConstant() != null ? iHashCode | getConstant().hashCode() : iHashCode;
    }

    @Override // org.apache.commons.collections4.Transformer
    public R transform(T t) {
        return this.iConstant;
    }
}
