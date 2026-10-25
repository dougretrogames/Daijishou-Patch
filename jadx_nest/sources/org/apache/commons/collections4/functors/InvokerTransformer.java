package org.apache.commons.collections4.functors;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes5.dex */
public class InvokerTransformer<T, R> implements Transformer<T, R> {
    private final Object[] iArgs;
    private final String iMethodName;
    private final Class<?>[] iParamTypes;

    public static <I, O> Transformer<I, O> invokerTransformer(String str) {
        return new InvokerTransformer((String) Objects.requireNonNull(str, "methodName"));
    }

    public static <I, O> Transformer<I, O> invokerTransformer(String str, Class<?>[] clsArr, Object[] objArr) {
        Objects.requireNonNull(str, "methodName");
        if ((clsArr == null && objArr != null) || ((clsArr != null && objArr == null) || (clsArr != null && objArr != null && clsArr.length != objArr.length))) {
            throw new IllegalArgumentException("The parameter types must match the arguments");
        }
        if (clsArr == null || clsArr.length == 0) {
            return new InvokerTransformer(str);
        }
        return new InvokerTransformer(str, clsArr, objArr);
    }

    private InvokerTransformer(String str) {
        this.iMethodName = str;
        this.iParamTypes = null;
        this.iArgs = null;
    }

    public InvokerTransformer(String str, Class<?>[] clsArr, Object[] objArr) {
        this.iMethodName = str;
        this.iParamTypes = clsArr != null ? (Class[]) clsArr.clone() : null;
        this.iArgs = objArr != null ? (Object[]) objArr.clone() : null;
    }

    @Override // org.apache.commons.collections4.Transformer
    public R transform(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (R) obj.getClass().getMethod(this.iMethodName, this.iParamTypes).invoke(obj, this.iArgs);
        } catch (IllegalAccessException unused) {
            throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + obj.getClass() + "' cannot be accessed");
        } catch (NoSuchMethodException unused2) {
            throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + obj.getClass() + "' does not exist");
        } catch (InvocationTargetException e) {
            throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + obj.getClass() + "' threw an exception", e);
        }
    }
}
