package com.skydoves.balloon.internals;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: ActivityBalloonLazy.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ActivityBalloonLazy$value$factory$1 extends PropertyReference0Impl {
    ActivityBalloonLazy$value$factory$1(Object obj) {
        super(obj, JvmClassMappingKt.class, "java", "getJavaClass(Lkotlin/reflect/KClass;)Ljava/lang/Class;", 1);
    }

    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return JvmClassMappingKt.getJavaClass((KClass) this.receiver);
    }
}
