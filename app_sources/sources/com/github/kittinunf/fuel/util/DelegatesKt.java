package com.github.kittinunf.fuel.util;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;

/* INFO: compiled from: Delegates.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0000¨\u0006\u0006"}, d2 = {"readWriteLazy", "Lkotlin/properties/ReadWriteProperty;", "", ExifInterface.GPS_DIRECTION_TRUE, "initializer", "Lkotlin/Function0;", "fuel"}, k = 2, mv = {1, 4, 0})
public final class DelegatesKt {
    public static final <T> ReadWriteProperty<Object, T> readWriteLazy(Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return new ReadWriteLazyVal(initializer);
    }
}
