package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ReflectionAccessFilterHelper {
    private ReflectionAccessFilterHelper() {
    }

    public static boolean isJavaType(Class<?> cls) {
        return isJavaType(cls.getName());
    }

    private static boolean isJavaType(String str) {
        return str.startsWith("java.") || str.startsWith("javax.");
    }

    public static boolean isAndroidType(Class<?> cls) {
        return isAndroidType(cls.getName());
    }

    private static boolean isAndroidType(String str) {
        return str.startsWith("android.") || str.startsWith("androidx.") || isJavaType(str);
    }

    public static boolean isAnyPlatformType(Class<?> cls) {
        String name = cls.getName();
        return isAndroidType(name) || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.");
    }

    public static ReflectionAccessFilter.FilterResult getFilterResult(List<ReflectionAccessFilter> list, Class<?> cls) {
        Iterator<ReflectionAccessFilter> it = list.iterator();
        while (it.hasNext()) {
            ReflectionAccessFilter.FilterResult filterResultCheck = it.next().check(cls);
            if (filterResultCheck != ReflectionAccessFilter.FilterResult.INDECISIVE) {
                return filterResultCheck;
            }
        }
        return ReflectionAccessFilter.FilterResult.ALLOW;
    }

    public static boolean canAccess(AccessibleObject accessibleObject, Object obj) {
        return AccessChecker.INSTANCE.canAccess(accessibleObject, obj);
    }

    private static abstract class AccessChecker {
        public static final AccessChecker INSTANCE;

        public abstract boolean canAccess(AccessibleObject accessibleObject, Object obj);

        private AccessChecker() {
        }

        /* synthetic */ AccessChecker(AnonymousClass1 anonymousClass1) {
            this();
        }

        static {
            AccessChecker anonymousClass1;
            if (JavaVersion.isJava9OrLater()) {
                try {
                    anonymousClass1 = new AnonymousClass1(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
                } catch (NoSuchMethodException unused) {
                    anonymousClass1 = null;
                }
            } else {
                anonymousClass1 = null;
            }
            if (anonymousClass1 == null) {
                anonymousClass1 = new AnonymousClass2();
            }
            INSTANCE = anonymousClass1;
        }

        /* JADX INFO: renamed from: com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$1, reason: invalid class name */
        class AnonymousClass1 extends AccessChecker {
            final /* synthetic */ Method val$canAccessMethod;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Method method) {
                super(null);
                this.val$canAccessMethod = method;
            }

            @Override // com.google.gson.internal.ReflectionAccessFilterHelper.AccessChecker
            public boolean canAccess(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.val$canAccessMethod.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e) {
                    throw new RuntimeException("Failed invoking canAccess", e);
                }
            }
        }

        /* JADX INFO: renamed from: com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$2, reason: invalid class name */
        class AnonymousClass2 extends AccessChecker {
            @Override // com.google.gson.internal.ReflectionAccessFilterHelper.AccessChecker
            public boolean canAccess(AccessibleObject accessibleObject, Object obj) {
                return true;
            }

            AnonymousClass2() {
                super(null);
            }
        }
    }
}
