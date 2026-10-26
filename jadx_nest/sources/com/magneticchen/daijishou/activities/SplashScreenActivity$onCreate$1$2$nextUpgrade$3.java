package com.magneticchen.daijishou.activities;

import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: SplashScreenActivity.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "succeed", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class SplashScreenActivity$onCreate$1$2$nextUpgrade$3 extends Lambda<Unit> implements Function1<Boolean, Unit> {
    final /* synthetic */ SplashScreenActivity $activity;
    final /* synthetic */ TextView $descriptionTextView;
    final /* synthetic */ Ref.IntRef $index;
    final /* synthetic */ int $upgradedVersion;
    final /* synthetic */ SplashScreenActivity this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    SplashScreenActivity$onCreate$1$2$nextUpgrade$3(Ref.IntRef intRef, SplashScreenActivity splashScreenActivity, int i, SplashScreenActivity splashScreenActivity2, TextView textView) {
        super(1);
        this.$index = intRef;
        this.this$0 = splashScreenActivity;
        this.$upgradedVersion = i;
        this.$activity = splashScreenActivity2;
        this.$descriptionTextView = textView;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$2$nextUpgrade$3$1, reason: invalid class name */
    /* INFO: compiled from: SplashScreenActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$2$nextUpgrade$3$1", f = "SplashScreenActivity.kt", i = {}, l = {171}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ SplashScreenActivity $activity;
        final /* synthetic */ TextView $descriptionTextView;
        final /* synthetic */ Ref.IntRef $index;
        final /* synthetic */ int $upgradedVersion;
        int label;
        final /* synthetic */ SplashScreenActivity this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.IntRef intRef, int i, SplashScreenActivity splashScreenActivity, SplashScreenActivity splashScreenActivity2, TextView textView, Continuation<?> continuation) {
            super(2, continuation);
            this.$index = intRef;
            this.$upgradedVersion = i;
            this.$activity = splashScreenActivity;
            this.this$0 = splashScreenActivity2;
            this.$descriptionTextView = textView;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$index, this.$upgradedVersion, this.$activity, this.this$0, this.$descriptionTextView, continuation);
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

        /* INFO: renamed from: com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$2$nextUpgrade$3$1$1, reason: invalid class name and collision with other inner class name */
        /* INFO: compiled from: SplashScreenActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.activities.SplashScreenActivity$onCreate$1$2$nextUpgrade$3$1$1", f = "SplashScreenActivity.kt", i = {}, l = {172}, m = "invokeSuspendImpl", n = {}, s = {})
        static final class C00541 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ SplashScreenActivity $activity;
            final /* synthetic */ TextView $descriptionTextView;
            final /* synthetic */ Ref.IntRef $index;
            final /* synthetic */ int $upgradedVersion;
            int label;
            final /* synthetic */ SplashScreenActivity this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00541(Ref.IntRef intRef, int i, SplashScreenActivity splashScreenActivity, SplashScreenActivity splashScreenActivity2, TextView textView, Continuation<?> continuation) {
                super(2, continuation);
                this.$index = intRef;
                this.$upgradedVersion = i;
                this.$activity = splashScreenActivity;
                this.this$0 = splashScreenActivity2;
                this.$descriptionTextView = textView;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new C00541(this.$index, this.$upgradedVersion, this.$activity, this.this$0, this.$descriptionTextView, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((C00541) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
                    if (SplashScreenActivity.AnonymousClass1.AnonymousClass2.invokeSuspendImpl$nextUpgrade(this.$index, this.$upgradedVersion, this.$activity, this.this$0, this.$descriptionTextView, this) == coroutine_suspended) {
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

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getDefault(), new C00541(this.$index, this.$upgradedVersion, this.$activity, this.this$0, this.$descriptionTextView, null), this) == coroutine_suspended) {
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

    public final void invoke(boolean z) {
        if (z) {
            this.$index.element++;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new AnonymousClass1(this.$index, this.$upgradedVersion, this.$activity, this.this$0, this.$descriptionTextView, null), 3, null);
        } else {
            Toast.makeText(this.this$0.getApplicationContext(), "Upgrade failed.", 1).show();
            this.this$0.finishWithDelay();
        }
    }
}
