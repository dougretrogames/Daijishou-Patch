package com.magneticchen.daijishou.view_models;

import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.dialog_fragments.ChoosePlayableItemFromLibraryDialogFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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
final class DaijishouConsoleViewModel$commands$7$execute$2$pickAnItem$result$1$1 extends Lambda<Unit> implements Function1<PlayableItemEntity, Unit> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ DaijishouApplication $application;
    final /* synthetic */ String $args;
    final /* synthetic */ Continuation<DaijishouConsoleViewModel.Companion.CommandResult> $continuation;
    final /* synthetic */ ChoosePlayableItemFromLibraryDialogFragment $dialog;
    final /* synthetic */ Ref.ObjectRef<PlayableItemEntity> $playableItemEntity;
    final /* synthetic */ Ref.BooleanRef $selected;
    final /* synthetic */ List<Pair<String, String>> $tokenReplaceList;
    final /* synthetic */ DaijishouConsoleViewModel$commands$7 this$0;
    final /* synthetic */ DaijishouConsoleViewModel this$1;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* WARN: Multi-variable type inference failed */
    DaijishouConsoleViewModel$commands$7$execute$2$pickAnItem$result$1$1(Ref.ObjectRef<PlayableItemEntity> objectRef, Ref.BooleanRef booleanRef, ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragment, Continuation<?> continuation, DaijishouApplication daijishouApplication, DaijishouConsoleViewModel$commands$7 daijishouConsoleViewModel$commands$7, List<Pair<String, String>> list, DaijishouConsoleViewModel daijishouConsoleViewModel, AppCompatActivity appCompatActivity, String str) {
        super(1);
        this.$playableItemEntity = objectRef;
        this.$selected = booleanRef;
        this.$dialog = choosePlayableItemFromLibraryDialogFragment;
        this.$continuation = (Continuation<DaijishouConsoleViewModel.Companion.CommandResult>) continuation;
        this.$application = daijishouApplication;
        this.this$0 = daijishouConsoleViewModel$commands$7;
        this.$tokenReplaceList = list;
        this.this$1 = daijishouConsoleViewModel;
        this.$activity = appCompatActivity;
        this.$args = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
        invoke2(playableItemEntity);
        return Unit.INSTANCE;
    }

    /* WARN: Multi-variable type inference failed */
    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PlayableItemEntity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.$playableItemEntity.element = it;
        this.$selected.element = true;
        this.$dialog.dismiss();
        Continuation<DaijishouConsoleViewModel.Companion.CommandResult> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(com.magneticchen.daijishou.support.DaijishouValueSupport.resultConstructor(DaijishouConsoleViewModel$commands$7.execute$executeArgs(this.$playableItemEntity, this.$application, this.this$0, this.$tokenReplaceList, this.this$1, this.$activity, this.$args)));
    }
}
