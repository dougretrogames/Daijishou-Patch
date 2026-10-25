package com.github.kittinunf.fuel.toolbox.extensions;

import com.github.kittinunf.fuel.core.Method;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ForceMethod.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0007"}, d2 = {"forceMethod", "", "Ljava/net/HttpURLConnection;", "method", "Lcom/github/kittinunf/fuel/core/Method;", "clazz", "Ljava/lang/Class;", "fuel"}, k = 2, mv = {1, 4, 0})
public final class ForceMethodKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Method.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Method.PATCH.ordinal()] = 1;
        }
    }

    public static final void forceMethod(HttpURLConnection forceMethod, Method method) throws ProtocolException, IllegalAccessException {
        Intrinsics.checkNotNullParameter(forceMethod, "$this$forceMethod");
        Intrinsics.checkNotNullParameter(method, "method");
        if (WhenMappings.$EnumSwitchMapping$0[method.ordinal()] == 1) {
            try {
                Field declaredField = forceMethod.getClass().getDeclaredField("delegate");
                Intrinsics.checkNotNullExpressionValue(declaredField, "this");
                declaredField.setAccessible(true);
                HttpURLConnection httpURLConnection = (HttpURLConnection) declaredField.get(forceMethod);
                if (httpURLConnection != null) {
                    forceMethod(httpURLConnection, method);
                }
            } catch (NoSuchFieldException unused) {
            }
            forceMethod(forceMethod, forceMethod.getClass(), method);
            return;
        }
        forceMethod.setRequestMethod(method.getValue());
    }

    private static final void forceMethod(HttpURLConnection httpURLConnection, Class<? super HttpURLConnection> cls, Method method) throws IllegalAccessException {
        try {
            Field declaredField = cls.getDeclaredField("method");
            Intrinsics.checkNotNullExpressionValue(declaredField, "this");
            declaredField.setAccessible(true);
            declaredField.set(httpURLConnection, method.getValue());
        } catch (NoSuchFieldException unused) {
            if (HttpURLConnection.class.isAssignableFrom(cls.getSuperclass())) {
                Class<? super Object> superclass = cls.getSuperclass();
                Intrinsics.checkNotNullExpressionValue(superclass, "clazz.superclass");
                forceMethod(httpURLConnection, superclass, method);
            }
        }
    }
}
