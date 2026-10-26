package com.google.common.cache;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class LongAddables {
    private static final Supplier<LongAddable> SUPPLIER;

    LongAddables() {
    }

    static {
        Supplier<LongAddable> anonymousClass2;
        try {
            new LongAdder();
            anonymousClass2 = new AnonymousClass1();
        } catch (Throwable unused) {
            anonymousClass2 = new AnonymousClass2();
        }
        SUPPLIER = anonymousClass2;
    }

    /* INFO: renamed from: com.google.common.cache.LongAddables$1, reason: invalid class name */
    class AnonymousClass1 implements Supplier<LongAddable> {
        AnonymousClass1() {
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.Supplier
        public LongAddable get() {
            return new LongAdder();
        }
    }

    /* INFO: renamed from: com.google.common.cache.LongAddables$2, reason: invalid class name */
    class AnonymousClass2 implements Supplier<LongAddable> {
        AnonymousClass2() {
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.Supplier
        public LongAddable get() {
            return new PureJavaLongAddable(null);
        }
    }

    public static LongAddable create() {
        return SUPPLIER.get();
    }

    private static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        /* synthetic */ PureJavaLongAddable(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.cache.LongAddable
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.LongAddable
        public void add(long x) {
            getAndAdd(x);
        }

        @Override // com.google.common.cache.LongAddable
        public long sum() {
            return get();
        }
    }
}
