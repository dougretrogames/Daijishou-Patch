package com.magneticchen.daijishou.ui.widget.widgets.activity;

import android.widget.ImageView;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ActivityWidgetContinueFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$2", f = "ActivityWidgetContinueFaceFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Exception $e;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ActivityWidgetContinueFaceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$2(ActivityWidgetContinueFaceFragment activityWidgetContinueFaceFragment, Exception exc, Continuation<? super ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$2> continuation) {
        super(2, continuation);
        this.this$0 = activityWidgetContinueFaceFragment;
        this.$e = exc;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$2 activityWidgetContinueFaceFragment$onCreateView$2$1$1$1$2 = new ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$2(this.this$0, this.$e, continuation);
        activityWidgetContinueFaceFragment$onCreateView$2$1$1$1$2.L$0 = obj;
        return activityWidgetContinueFaceFragment$onCreateView$2$1$1$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ImageView imageView = this.this$0.background;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
                imageView = null;
            }
            imageView.setImageBitmap(null);
            this.this$0.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(this.$e));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
