package com.magneticchen.daijishou.activities;

import android.widget.TextView;
import com.magneticchen.daijishou.upgrade_scripts.UpgradeScript;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SplashScreenActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$2$nextUpgrade$2", f = "SplashScreenActivity.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class SplashScreenActivity$onCreate$1$2$nextUpgrade$2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ TextView $descriptionTextView;
    final /* synthetic */ UpgradeScript $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SplashScreenActivity$onCreate$1$2$nextUpgrade$2(TextView textView, UpgradeScript upgradeScript, Continuation<?> continuation) {
        super(2, continuation);
        this.$descriptionTextView = textView;
        this.$it = upgradeScript;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new SplashScreenActivity$onCreate$1$2$nextUpgrade$2(this.$descriptionTextView, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((SplashScreenActivity$onCreate$1$2$nextUpgrade$2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
        this.$descriptionTextView.setText(this.$it.getUpgradeDescription());
        return Unit.INSTANCE;
    }
}
