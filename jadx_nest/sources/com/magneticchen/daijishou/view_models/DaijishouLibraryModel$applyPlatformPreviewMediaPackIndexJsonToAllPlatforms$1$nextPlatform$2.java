package com.magneticchen.daijishou.view_models;

import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DaijishouLibraryModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.view_models.DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToAllPlatforms$1$nextPlatform$2", f = "DaijishouLibraryModel.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToAllPlatforms$1$nextPlatform$2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ List<PlatformEntity> $allPlatforms;
    final /* synthetic */ Function2<? super Boolean, ? super Integer, Unit> $callback;
    final /* synthetic */ Ref.IntRef $index;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToAllPlatforms$1$nextPlatform$2(Function2<? super Boolean, ? super Integer, Unit> function2, Ref.IntRef intRef, List<PlatformEntity> list, Continuation<?> continuation) {
        super(2, continuation);
        this.$callback = function2;
        this.$index = intRef;
        this.$allPlatforms = list;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToAllPlatforms$1$nextPlatform$2(this.$callback, this.$index, this.$allPlatforms, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((DaijishouLibraryModel$applyPlatformPreviewMediaPackIndexJsonToAllPlatforms$1$nextPlatform$2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$callback.invoke(Boxing.boxBoolean(false), Boxing.boxInt((int) ((100 * (this.$index.element + 1)) / this.$allPlatforms.size())));
        return Unit.INSTANCE;
    }
}
