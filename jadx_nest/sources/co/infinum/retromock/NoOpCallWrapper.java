package co.infinum.retromock;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
class NoOpCallWrapper implements CallWrapper {
    private Type returnType;

    @Override // co.infinum.retromock.CallWrapper
    public Object wrap(Object obj, Object[] objArr) {
        return obj;
    }

    public NoOpCallWrapper(Type type) {
        this.returnType = type;
    }

    @Override // co.infinum.retromock.CallWrapper
    public Type getReturnType() {
        return this.returnType;
    }
}
