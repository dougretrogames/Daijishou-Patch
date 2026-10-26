package co.infinum.retromock;

import java.lang.reflect.Type;

/* INFO: loaded from: classes3.dex */
interface CallWrapper {
    Type getReturnType();

    Object wrap(Object obj, Object[] objArr);
}
