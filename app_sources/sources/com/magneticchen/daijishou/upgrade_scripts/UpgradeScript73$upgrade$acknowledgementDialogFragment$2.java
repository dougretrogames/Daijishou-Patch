package com.magneticchen.daijishou.upgrade_scripts;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: UpgradeScript73.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class UpgradeScript73$upgrade$acknowledgementDialogFragment$2 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ Function1<? super Boolean, Unit> $callback;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* WARN: Multi-variable type inference failed */
    UpgradeScript73$upgrade$acknowledgementDialogFragment$2(Function1<? super Boolean, Unit> function1) {
        super(0);
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$callback.invoke(false);
    }
}
