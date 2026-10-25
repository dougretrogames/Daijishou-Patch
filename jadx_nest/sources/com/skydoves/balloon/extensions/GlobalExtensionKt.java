package com.skydoves.balloon.extensions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlobalExtension.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0081\bø\u0001\u0000\u001a\u001a\u0010\u0004\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0081\bø\u0001\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"runOnAfterSDK22", "", "block", "Lkotlin/Function0;", "runOnAfterSDK23", "isAPILevelHigherThan23", "", "balloon_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class GlobalExtensionKt {
    public static final /* synthetic */ boolean isAPILevelHigherThan23() {
        return true;
    }

    public static final /* synthetic */ void runOnAfterSDK22(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke();
    }

    public static final /* synthetic */ void runOnAfterSDK23(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke();
    }
}
