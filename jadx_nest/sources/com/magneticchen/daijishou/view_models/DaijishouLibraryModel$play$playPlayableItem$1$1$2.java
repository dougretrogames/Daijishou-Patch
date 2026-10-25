package com.magneticchen.daijishou.view_models;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: DaijishouLibraryModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DaijishouLibraryModel$play$playPlayableItem$1$1$2 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function1<? super Boolean, Unit> $callback;
    final /* synthetic */ String $packageNameToBeUsed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DaijishouLibraryModel$play$playPlayableItem$1$1$2(String str, Activity activity, Function1<? super Boolean, Unit> function1) {
        super(0);
        this.$packageNameToBeUsed = str;
        this.$activity = activity;
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + this.$packageNameToBeUsed)));
        Function1<? super Boolean, Unit> function1 = this.$callback;
        if (function1 != null) {
            function1.invoke(false);
        }
    }
}
