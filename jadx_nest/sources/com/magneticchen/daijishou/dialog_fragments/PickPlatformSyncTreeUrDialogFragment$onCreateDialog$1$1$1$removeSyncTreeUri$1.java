package com.magneticchen.daijishou.dialog_fragments;

import com.magneticchen.daijishou.view_models.LibraryViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: PickPlatformSyncTreeUrDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$1$removeSyncTreeUri$1 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ int $i;
    final /* synthetic */ boolean $keepRecords;
    final /* synthetic */ PickPlatformSyncTreeUrDialogFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    PickPlatformSyncTreeUrDialogFragment$onCreateDialog$1$1$1$removeSyncTreeUri$1(int i, PickPlatformSyncTreeUrDialogFragment pickPlatformSyncTreeUrDialogFragment, boolean z) {
        super(0);
        this.$i = i;
        this.this$0 = pickPlatformSyncTreeUrDialogFragment;
        this.$keepRecords = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$i >= this.this$0.getPlatformEntity().getItemsSyncTreeUriList().size()) {
            return;
        }
        LibraryViewModel libraryViewModel = this.this$0.libraryViewModel;
        if (libraryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("libraryViewModel");
            libraryViewModel = null;
        }
        libraryViewModel.removeSelectedPlatformSyncTreeUriSafely(this.this$0.getPlatformEntity().getItemsSyncTreeUriList().get(this.$i), this.$keepRecords);
    }
}
