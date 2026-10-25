package com.magneticchen.daijishou.view_models;

import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: DaijishouLibraryModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToAllPlatforms$1$nextPlatform$4 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ List<PlatformEntity> $allPlatforms;
    final /* synthetic */ Function2<? super Boolean, ? super Integer, Unit> $callback;
    final /* synthetic */ Ref.IntRef $index;
    final /* synthetic */ String $platformPreviewMediaPackUrlString;
    final /* synthetic */ int $previewMediaType;
    final /* synthetic */ DaijishouLibraryModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToAllPlatforms$1$nextPlatform$4(Ref.IntRef intRef, List<PlatformEntity> list, DaijishouLibraryModel daijishouLibraryModel, int i, String str, Function2<? super Boolean, ? super Integer, Unit> function2) {
        super(0);
        this.$index = intRef;
        this.$allPlatforms = list;
        this.this$0 = daijishouLibraryModel;
        this.$previewMediaType = i;
        this.$platformPreviewMediaPackUrlString = str;
        this.$callback = function2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        DaijishouLibraryModel.invokeSuspendImpl$nextPlatform(this.$index, this.$allPlatforms, this.this$0, this.$previewMediaType, this.$platformPreviewMediaPackUrlString, this.$callback);
    }
}
