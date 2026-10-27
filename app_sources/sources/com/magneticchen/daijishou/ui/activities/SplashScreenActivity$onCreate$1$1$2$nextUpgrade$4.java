package com.magneticchen.daijishou.ui.activities;

import android.widget.Toast;
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
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$2$nextUpgrade$4", f = "SplashScreenActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SplashScreenActivity$onCreate$1$1$2$nextUpgrade$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Exception $e;
    int label;
    final /* synthetic */ SplashScreenActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SplashScreenActivity$onCreate$1$1$2$nextUpgrade$4(SplashScreenActivity splashScreenActivity, Exception exc, Continuation<? super SplashScreenActivity$onCreate$1$1$2$nextUpgrade$4> continuation) {
        super(2, continuation);
        this.this$0 = splashScreenActivity;
        this.$e = exc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashScreenActivity$onCreate$1$1$2$nextUpgrade$4(this.this$0, this.$e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SplashScreenActivity$onCreate$1$1$2$nextUpgrade$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Toast.makeText(this.this$0.getApplicationContext(), this.$e.toString(), 1).show();
        this.this$0.finishWithDelay();
        return Unit.INSTANCE;
    }
}
