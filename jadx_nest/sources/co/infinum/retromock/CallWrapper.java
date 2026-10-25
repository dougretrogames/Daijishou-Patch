package co.infinum.retromock;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
interface CallWrapper {
    Type getReturnType();

    Object wrap(Object obj, Object[] objArr);
}
