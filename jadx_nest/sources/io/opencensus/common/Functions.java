package io.opencensus.common;

import javax.annotation.Nullable;

/* INFO: loaded from: classes4.dex */
public final class Functions {
    private static final Function<Object, Void> RETURN_NULL = new AnonymousClass1();
    private static final Function<Object, Void> THROW_ILLEGAL_ARGUMENT_EXCEPTION = new AnonymousClass2();
    private static final Function<Object, Void> THROW_ASSERTION_ERROR = new AnonymousClass3();
    private static final Function<Object, String> RETURN_TO_STRING = new AnonymousClass4();

    private Functions() {
    }

    /* INFO: renamed from: io.opencensus.common.Functions$1, reason: invalid class name */
    class AnonymousClass1 implements Function<Object, Void> {
        @Override // io.opencensus.common.Function
        @Nullable
        public Void apply(Object obj) {
            return null;
        }

        AnonymousClass1() {
        }
    }

    /* INFO: renamed from: io.opencensus.common.Functions$2, reason: invalid class name */
    class AnonymousClass2 implements Function<Object, Void> {
        AnonymousClass2() {
        }

        @Override // io.opencensus.common.Function
        public Void apply(Object obj) {
            throw new IllegalArgumentException();
        }
    }

    /* INFO: renamed from: io.opencensus.common.Functions$3, reason: invalid class name */
    class AnonymousClass3 implements Function<Object, Void> {
        AnonymousClass3() {
        }

        @Override // io.opencensus.common.Function
        public Void apply(Object obj) {
            throw new AssertionError();
        }
    }

    /* INFO: renamed from: io.opencensus.common.Functions$4, reason: invalid class name */
    class AnonymousClass4 implements Function<Object, String> {
        AnonymousClass4() {
        }

        @Override // io.opencensus.common.Function
        public String apply(Object obj) {
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }
    }

    public static <T> Function<Object, T> returnNull() {
        return (Function<Object, T>) RETURN_NULL;
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: io.opencensus.common.Functions$5, reason: invalid class name */
    class AnonymousClass5<T> implements Function<Object, T> {
        final /* synthetic */ Object val$constant;

        AnonymousClass5(Object obj) {
            this.val$constant = obj;
        }

        @Override // io.opencensus.common.Function
        public T apply(Object obj) {
            return (T) this.val$constant;
        }
    }

    public static <T> Function<Object, T> returnConstant(T t) {
        return new AnonymousClass5(t);
    }

    public static Function<Object, String> returnToString() {
        return RETURN_TO_STRING;
    }

    public static <T> Function<Object, T> throwIllegalArgumentException() {
        return (Function<Object, T>) THROW_ILLEGAL_ARGUMENT_EXCEPTION;
    }

    public static <T> Function<Object, T> throwAssertionError() {
        return (Function<Object, T>) THROW_ASSERTION_ERROR;
    }
}
