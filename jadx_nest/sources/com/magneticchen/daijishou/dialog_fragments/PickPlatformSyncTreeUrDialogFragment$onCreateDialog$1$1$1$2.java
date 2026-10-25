package com.magneticchen.daijishou.dialog_fragments;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: PickPlatformSyncTreeUrDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$1$2 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ int $i;
    final /* synthetic */ PickPlatformSyncTreeUrDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$1$2(PickPlatformSyncTreeUrDialogFragment pickPlatformSyncTreeUrDialogFragment, int i) {
        super(0);
        this.this$0 = pickPlatformSyncTreeUrDialogFragment;
        this.$i = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        PickPlatformSyncTreeUrDialogFragment.onCreateDialog$lambda$11$lambda$10$lambda$2$removeSyncTreeUri(this.this$0, this.$i, false);
    }
}
