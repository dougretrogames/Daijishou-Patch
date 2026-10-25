package com.magneticchen.daijishou.view_models;

import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformThumbnailsPackIndexJson;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformWallpapersPackIndexJson;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: DaijishouLibraryModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1$nextPreviewMedia$8 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ PlatformEntity $platformEntity;
    final /* synthetic */ String $platformPreviewMediaPackUrlString;
    final /* synthetic */ Ref.ObjectRef<PlatformThumbnailsPackIndexJson> $platformThumbnailsPackIndexJson;
    final /* synthetic */ Ref.ObjectRef<PlatformWallpapersPackIndexJson> $platformWallpapersPackIndexJson;
    final /* synthetic */ Ref.IntRef $previewMediaIndex;
    final /* synthetic */ int $previewMediaType;
    final /* synthetic */ DaijishouLibraryModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToPlatform$1$nextPreviewMedia$8(Ref.IntRef intRef, int i, Ref.ObjectRef<PlatformWallpapersPackIndexJson> objectRef, String str, Function0<Unit> function0, PlatformEntity platformEntity, Ref.ObjectRef<PlatformThumbnailsPackIndexJson> objectRef2, DaijishouLibraryModel daijishouLibraryModel) {
        super(0);
        this.$previewMediaIndex = intRef;
        this.$previewMediaType = i;
        this.$platformWallpapersPackIndexJson = objectRef;
        this.$platformPreviewMediaPackUrlString = str;
        this.$callback = function0;
        this.$platformEntity = platformEntity;
        this.$platformThumbnailsPackIndexJson = objectRef2;
        this.this$0 = daijishouLibraryModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        DaijishouLibraryModel.C02751.invokeSuspendImpl$nextPreviewMedia(this.$previewMediaIndex, this.$previewMediaType, this.$platformWallpapersPackIndexJson, this.$platformPreviewMediaPackUrlString, this.$callback, this.$platformEntity, this.$platformThumbnailsPackIndexJson, this.this$0);
    }
}
