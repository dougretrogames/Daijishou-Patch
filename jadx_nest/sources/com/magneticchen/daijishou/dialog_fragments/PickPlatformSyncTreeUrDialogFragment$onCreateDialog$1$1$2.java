package com.magneticchen.daijishou.dialog_fragments;

import android.widget.ArrayAdapter;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: PickPlatformSyncTreeUrDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$2 extends Lambda<Unit> implements Function1<PlatformEntity, Unit> {
    final /* synthetic */ ArrayAdapter<?> $adapter;
    final /* synthetic */ PickPlatformSyncTreeUrDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$2(PickPlatformSyncTreeUrDialogFragment pickPlatformSyncTreeUrDialogFragment, ArrayAdapter<?> arrayAdapter) {
        super(1);
        this.this$0 = pickPlatformSyncTreeUrDialogFragment;
        this.$adapter = arrayAdapter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
        invoke2(platformEntity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PlatformEntity platformEntity) {
        if (platformEntity != null) {
            PickPlatformSyncTreeUrDialogFragment pickPlatformSyncTreeUrDialogFragment = this.this$0;
            ArrayAdapter<?> arrayAdapter = this.$adapter;
            pickPlatformSyncTreeUrDialogFragment.setPlatformEntity(platformEntity);
            pickPlatformSyncTreeUrDialogFragment.arrayItems.clear();
            pickPlatformSyncTreeUrDialogFragment.arrayItems.addAll(platformEntity.getItemsSyncTreeUriList());
            arrayAdapter.notifyDataSetChanged();
        }
    }
}
