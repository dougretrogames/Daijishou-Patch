package com.magneticchen.daijishou.ui.model;

import android.content.Context;
import android.widget.Toast;
import com.magneticchen.daijishou.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;

/* INFO: compiled from: DaijishouSynchronizationModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$updatePlatformsFromGitHub$1$checkNextPlatform$2", f = "DaijishouSynchronizationModel.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class DaijishouSynchronizationModel$updatePlatformsFromGitHub$1$checkNextPlatform$2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ Ref.IntRef $platformUpdatedCount;
    int label;
    final /* synthetic */ DaijishouSynchronizationModel this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    DaijishouSynchronizationModel$updatePlatformsFromGitHub$1$checkNextPlatform$2(DaijishouSynchronizationModel daijishouSynchronizationModel, Ref.IntRef intRef, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = daijishouSynchronizationModel;
        this.$platformUpdatedCount = intRef;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new DaijishouSynchronizationModel$updatePlatformsFromGitHub$1$checkNextPlatform$2(this.this$0, this.$platformUpdatedCount, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((DaijishouSynchronizationModel$updatePlatformsFromGitHub$1$checkNextPlatform$2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
        Context applicationContext = this.this$0.getApplication().getApplicationContext();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.this$0.getApplication().getString(R.string.n_platforms_updated_format);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Boxing.boxInt(this.$platformUpdatedCount.element)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        Toast.makeText(applicationContext, str, 0).show();
        return Unit.INSTANCE;
    }
}
