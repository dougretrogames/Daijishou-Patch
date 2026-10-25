package com.google.gson;

import com.google.gson.internal.ReflectionAccessFilterHelper;

/* JADX INFO: loaded from: classes4.dex */
public interface ReflectionAccessFilter {
    public static final ReflectionAccessFilter BLOCK_INACCESSIBLE_JAVA = new AnonymousClass1();
    public static final ReflectionAccessFilter BLOCK_ALL_JAVA = new AnonymousClass2();
    public static final ReflectionAccessFilter BLOCK_ALL_ANDROID = new AnonymousClass3();
    public static final ReflectionAccessFilter BLOCK_ALL_PLATFORM = new AnonymousClass4();

    public enum FilterResult {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL
    }

    FilterResult check(Class<?> cls);

    /* JADX INFO: renamed from: com.google.gson.ReflectionAccessFilter$1, reason: invalid class name */
    class AnonymousClass1 implements ReflectionAccessFilter {
        AnonymousClass1() {
        }

        @Override // com.google.gson.ReflectionAccessFilter
        public FilterResult check(Class<?> cls) {
            if (ReflectionAccessFilterHelper.isJavaType(cls)) {
                return FilterResult.BLOCK_INACCESSIBLE;
            }
            return FilterResult.INDECISIVE;
        }
    }

    /* JADX INFO: renamed from: com.google.gson.ReflectionAccessFilter$2, reason: invalid class name */
    class AnonymousClass2 implements ReflectionAccessFilter {
        AnonymousClass2() {
        }

        @Override // com.google.gson.ReflectionAccessFilter
        public FilterResult check(Class<?> cls) {
            if (ReflectionAccessFilterHelper.isJavaType(cls)) {
                return FilterResult.BLOCK_ALL;
            }
            return FilterResult.INDECISIVE;
        }
    }

    /* JADX INFO: renamed from: com.google.gson.ReflectionAccessFilter$3, reason: invalid class name */
    class AnonymousClass3 implements ReflectionAccessFilter {
        AnonymousClass3() {
        }

        @Override // com.google.gson.ReflectionAccessFilter
        public FilterResult check(Class<?> cls) {
            if (ReflectionAccessFilterHelper.isAndroidType(cls)) {
                return FilterResult.BLOCK_ALL;
            }
            return FilterResult.INDECISIVE;
        }
    }

    /* JADX INFO: renamed from: com.google.gson.ReflectionAccessFilter$4, reason: invalid class name */
    class AnonymousClass4 implements ReflectionAccessFilter {
        AnonymousClass4() {
        }

        @Override // com.google.gson.ReflectionAccessFilter
        public FilterResult check(Class<?> cls) {
            if (ReflectionAccessFilterHelper.isAnyPlatformType(cls)) {
                return FilterResult.BLOCK_ALL;
            }
            return FilterResult.INDECISIVE;
        }
    }
}
