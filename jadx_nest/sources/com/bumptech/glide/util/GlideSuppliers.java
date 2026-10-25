package com.bumptech.glide.util;

/* JADX INFO: loaded from: classes3.dex */
public final class GlideSuppliers {

    public interface GlideSupplier<T> {
        T get();
    }

    private GlideSuppliers() {
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.bumptech.glide.util.GlideSuppliers$1, reason: invalid class name */
    class AnonymousClass1<T> implements GlideSupplier<T> {
        private volatile T instance;
        final /* synthetic */ GlideSupplier val$supplier;

        AnonymousClass1(GlideSupplier glideSupplier) {
            this.val$supplier = glideSupplier;
        }

        @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
        public T get() {
            if (this.instance == null) {
                synchronized (this) {
                    if (this.instance == null) {
                        this.instance = (T) Preconditions.checkNotNull(this.val$supplier.get());
                    }
                }
            }
            return this.instance;
        }
    }

    public static <T> GlideSupplier<T> memorize(GlideSupplier<T> glideSupplier) {
        return new AnonymousClass1(glideSupplier);
    }
}
