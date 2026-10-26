package com.magneticchen.daijishou.view_models;

import androidx.lifecycle.ViewModelKt;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformsIndexJson;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.Json;

/* INFO: compiled from: DaijishouSynchronizationModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DaijishouSynchronizationModel$updatePlatformsFromGitHub$1$checkNextPlatform$5 extends Lambda<Unit> implements Function1<PlatformEntity, Unit> {
    final /* synthetic */ CoroutineScope $$this$launch;
    final /* synthetic */ String $baseUri;
    final /* synthetic */ Function1<? super Boolean, Unit> $callback;
    final /* synthetic */ CoroutineExceptionHandler $coroutineExceptionHandler;
    final /* synthetic */ Ref.IntRef $index;
    final /* synthetic */ String $platformUniqueId;
    final /* synthetic */ Ref.IntRef $platformUpdatedCount;
    final /* synthetic */ PlatformsIndexJson $platformsIndexJson;
    final /* synthetic */ Ref.ObjectRef<PlatformsIndexJson> $previousPlatformsIndexJson;
    final /* synthetic */ boolean $updateEveryPlatformThisCycle;
    final /* synthetic */ Json $weakJson;
    final /* synthetic */ DaijishouSynchronizationModel this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* WARN: Multi-variable type inference failed */
    DaijishouSynchronizationModel$updatePlatformsFromGitHub$1$checkNextPlatform$5(DaijishouSynchronizationModel daijishouSynchronizationModel, CoroutineScope coroutineScope, String str, CoroutineExceptionHandler coroutineExceptionHandler, Ref.IntRef intRef, PlatformsIndexJson platformsIndexJson, Ref.IntRef intRef2, boolean z, Ref.ObjectRef<PlatformsIndexJson> objectRef, Json json, String str2, Function1<? super Boolean, Unit> function1) {
        super(1);
        this.this$0 = daijishouSynchronizationModel;
        this.$$this$launch = coroutineScope;
        this.$platformUniqueId = str;
        this.$coroutineExceptionHandler = coroutineExceptionHandler;
        this.$index = intRef;
        this.$platformsIndexJson = platformsIndexJson;
        this.$platformUpdatedCount = intRef2;
        this.$updateEveryPlatformThisCycle = z;
        this.$previousPlatformsIndexJson = objectRef;
        this.$weakJson = json;
        this.$baseUri = str2;
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
        invoke2(platformEntity);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel$updatePlatformsFromGitHub$1$checkNextPlatform$5$1, reason: invalid class name */
    /* INFO: compiled from: DaijishouSynchronizationModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel$updatePlatformsFromGitHub$1$checkNextPlatform$5$1", f = "DaijishouSynchronizationModel.kt", i = {}, l = {240}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ String $baseUri;
        final /* synthetic */ Function1<? super Boolean, Unit> $callback;
        final /* synthetic */ CoroutineExceptionHandler $coroutineExceptionHandler;
        final /* synthetic */ Ref.IntRef $index;
        final /* synthetic */ Ref.IntRef $platformUpdatedCount;
        final /* synthetic */ PlatformsIndexJson $platformsIndexJson;
        final /* synthetic */ Ref.ObjectRef<PlatformsIndexJson> $previousPlatformsIndexJson;
        final /* synthetic */ boolean $updateEveryPlatformThisCycle;
        final /* synthetic */ Json $weakJson;
        int label;
        final /* synthetic */ DaijishouSynchronizationModel this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref.IntRef intRef, PlatformsIndexJson platformsIndexJson, DaijishouSynchronizationModel daijishouSynchronizationModel, Ref.IntRef intRef2, boolean z, Ref.ObjectRef<PlatformsIndexJson> objectRef, Json json, String str, CoroutineScope coroutineScope, Function1<? super Boolean, Unit> function1, CoroutineExceptionHandler coroutineExceptionHandler, Continuation<?> continuation) {
            super(2, continuation);
            this.$index = intRef;
            this.$platformsIndexJson = platformsIndexJson;
            this.this$0 = daijishouSynchronizationModel;
            this.$platformUpdatedCount = intRef2;
            this.$updateEveryPlatformThisCycle = z;
            this.$previousPlatformsIndexJson = objectRef;
            this.$weakJson = json;
            this.$baseUri = str;
            this.$$this$launch = coroutineScope;
            this.$callback = function1;
            this.$coroutineExceptionHandler = coroutineExceptionHandler;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$index, this.$platformsIndexJson, this.this$0, this.$platformUpdatedCount, this.$updateEveryPlatformThisCycle, this.$previousPlatformsIndexJson, this.$weakJson, this.$baseUri, this.$$this$launch, this.$callback, this.$coroutineExceptionHandler, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DaijishouSynchronizationModel.invokeSuspendImpl$checkNextPlatform(this.$index, this.$platformsIndexJson, this.this$0, this.$platformUpdatedCount, this.$updateEveryPlatformThisCycle, this.$previousPlatformsIndexJson, this.$weakJson, this.$baseUri, this.$$this$launch, this.$callback, this.$coroutineExceptionHandler, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PlatformEntity platformEntity) {
        this.this$0.getApplication().getLogger().debug(this.$$this$launch, "Platform with uniqueId \"" + this.$platformUniqueId + "\" updated.");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), Dispatchers.getIO().plus(this.$coroutineExceptionHandler), null, new AnonymousClass1(this.$index, this.$platformsIndexJson, this.this$0, this.$platformUpdatedCount, this.$updateEveryPlatformThisCycle, this.$previousPlatformsIndexJson, this.$weakJson, this.$baseUri, this.$$this$launch, this.$callback, this.$coroutineExceptionHandler, null), 2, null);
    }
}
