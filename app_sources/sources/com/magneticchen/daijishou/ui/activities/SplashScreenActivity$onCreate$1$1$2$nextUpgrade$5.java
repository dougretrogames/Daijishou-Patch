package com.magneticchen.daijishou.ui.activities;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: SplashScreenActivity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$2$nextUpgrade$5", f = "SplashScreenActivity.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
final class SplashScreenActivity$onCreate$1$1$2$nextUpgrade$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextView $descriptionTextView;
    final /* synthetic */ Ref.IntRef $index;
    final /* synthetic */ int $upgradedVersion;
    int label;
    final /* synthetic */ SplashScreenActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SplashScreenActivity$onCreate$1$1$2$nextUpgrade$5(Ref.IntRef intRef, int i, SplashScreenActivity splashScreenActivity, TextView textView, Continuation<? super SplashScreenActivity$onCreate$1$1$2$nextUpgrade$5> continuation) {
        super(2, continuation);
        this.$index = intRef;
        this.$upgradedVersion = i;
        this.this$0 = splashScreenActivity;
        this.$descriptionTextView = textView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashScreenActivity$onCreate$1$1$2$nextUpgrade$5(this.$index, this.$upgradedVersion, this.this$0, this.$descriptionTextView, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SplashScreenActivity$onCreate$1$1$2$nextUpgrade$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$2$nextUpgrade$5$1, reason: invalid class name */
    /* JADX INFO: compiled from: SplashScreenActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.activities.SplashScreenActivity$onCreate$1$1$2$nextUpgrade$5$1", f = "SplashScreenActivity.kt", i = {}, l = {165}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $descriptionTextView;
        final /* synthetic */ Ref.IntRef $index;
        final /* synthetic */ int $upgradedVersion;
        int label;
        final /* synthetic */ SplashScreenActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.IntRef intRef, int i, SplashScreenActivity splashScreenActivity, TextView textView, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$index = intRef;
            this.$upgradedVersion = i;
            this.this$0 = splashScreenActivity;
            this.$descriptionTextView = textView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$index, this.$upgradedVersion, this.this$0, this.$descriptionTextView, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SplashScreenActivity.AnonymousClass1.C00091.AnonymousClass2.invokeSuspend$nextUpgrade(this.$index, this.$upgradedVersion, this.this$0, this.$descriptionTextView, this) == coroutine_suspended) {
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

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getDefault(), new AnonymousClass1(this.$index, this.$upgradedVersion, this.this$0, this.$descriptionTextView, null), this) == coroutine_suspended) {
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
