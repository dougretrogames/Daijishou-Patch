package com.skydoves.balloon.internals;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ViewProperty.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ$\u0010\f\u001a\u00028\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u00022\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0096\u0002¢\u0006\u0002\u0010\u0010J,\u0010\u0011\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00022\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00028\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/skydoves/balloon/internals/ViewPropertyDelegate;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/properties/ReadWriteProperty;", "defaultValue", "invalidator", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "propertyValue", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewPropertyDelegate<T> implements ReadWriteProperty<Object, T> {
    private final Function0<Unit> invalidator;
    private T propertyValue;

    public ViewPropertyDelegate(T t, Function0<Unit> invalidator) {
        Intrinsics.checkNotNullParameter(invalidator, "invalidator");
        this.invalidator = invalidator;
        this.propertyValue = t;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public T getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.propertyValue;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object thisRef, KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter(property, "property");
        if (Intrinsics.areEqual(this.propertyValue, value)) {
            return;
        }
        this.propertyValue = value;
        this.invalidator.invoke();
    }
}
