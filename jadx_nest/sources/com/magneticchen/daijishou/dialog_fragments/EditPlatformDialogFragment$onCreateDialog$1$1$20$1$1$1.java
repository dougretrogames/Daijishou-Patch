package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.content.Context;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: EditPlatformDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class EditPlatformDialogFragment$onCreateDialog$1$1$20$1$1$1 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.BooleanRef $deletePlayers;
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ PlatformEntity $platformEntity;
    final /* synthetic */ EditPlatformDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditPlatformDialogFragment$onCreateDialog$1$1$20$1$1$1(Ref.BooleanRef booleanRef, EditPlatformDialogFragment editPlatformDialogFragment, PlatformEntity platformEntity, AlertDialog alertDialog, Context context) {
        super(0);
        this.$deletePlayers = booleanRef;
        this.this$0 = editPlatformDialogFragment;
        this.$platformEntity = platformEntity;
        this.$dialog = alertDialog;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$deletePlayers.element = true;
        EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$46$lambda$44$lambda$43$confirmAction(this.this$0, this.$platformEntity, this.$dialog, this.$deletePlayers, this.$context);
    }
}
