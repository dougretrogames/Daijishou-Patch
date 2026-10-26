package com.magneticchen.daijishou.view_models;

import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.dialog_fragments.ChoosePlayableItemFromLibraryDialogFragment;
import com.magneticchen.daijishou.utils.FileUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* INFO: compiled from: DaijishouConsoleViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DaijishouConsoleViewModel$commands$8$execute$3$1 extends Lambda<Unit> implements Function1<PlayableItemEntity, Unit> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ Continuation<DaijishouConsoleViewModel.Companion.CommandResult> $continuation;
    final /* synthetic */ ChoosePlayableItemFromLibraryDialogFragment $dialog;
    final /* synthetic */ Ref.BooleanRef $selected;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* WARN: Multi-variable type inference failed */
    DaijishouConsoleViewModel$commands$8$execute$3$1(Ref.BooleanRef booleanRef, Continuation<?> continuation, AppCompatActivity appCompatActivity, ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragment) {
        super(1);
        this.$selected = booleanRef;
        this.$continuation = (Continuation<DaijishouConsoleViewModel.Companion.CommandResult>) continuation;
        this.$activity = appCompatActivity;
        this.$dialog = choosePlayableItemFromLibraryDialogFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
        invoke2(playableItemEntity);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PlayableItemEntity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.$selected.element = true;
        try {
            Continuation<DaijishouConsoleViewModel.Companion.CommandResult> continuation = this.$continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(com.magneticchen.daijishou.support.DaijishouValueSupport.resultConstructor(new DaijishouConsoleViewModel.Companion.CommandResult("Results:\n" + FileUtils.INSTANCE.getFilePath(this.$activity, it.getUri()), 0, null, false, 14, null)));
        } catch (Exception e) {
            Continuation<DaijishouConsoleViewModel.Companion.CommandResult> continuation2 = this.$continuation;
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(com.magneticchen.daijishou.support.DaijishouValueSupport.resultConstructor(new DaijishouConsoleViewModel.Companion.CommandResult("Results:\n" + ExceptionsKt.stackTraceToString(e), 0, null, false, 14, null)));
        }
        this.$dialog.dismiss();
    }
}
