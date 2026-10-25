package com.magneticchen.daijishou.view_models;

import android.content.Context;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayerEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: DaijishouLibraryModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DaijishouLibraryModel$play$playPlayableItem$1$1$playItWithRules$3 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ Function1<? super Boolean, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isUriDaijishouPlayerTemplate;
    final /* synthetic */ PlayableItemEntity $playableItemEntity;
    final /* synthetic */ Ref.ObjectRef<PlayerEntity> $playerEntityToBeUsed;
    final /* synthetic */ DaijishouLibraryModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DaijishouLibraryModel$play$playPlayableItem$1$1$playItWithRules$3(PlayableItemEntity playableItemEntity, Ref.ObjectRef<PlayerEntity> objectRef, Function1<? super Boolean, Unit> function1, Context context, DaijishouLibraryModel daijishouLibraryModel, boolean z) {
        super(0);
        this.$playableItemEntity = playableItemEntity;
        this.$playerEntityToBeUsed = objectRef;
        this.$callback = function1;
        this.$context = context;
        this.this$0 = daijishouLibraryModel;
        this.$isUriDaijishouPlayerTemplate = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        DaijishouLibraryModel.play$playPlayableItem$lambda$13$lambda$12$playIt(this.$playableItemEntity, this.$playerEntityToBeUsed, this.$callback, this.$context, this.this$0, this.$isUriDaijishouPlayerTemplate);
    }
}
