package com.magneticchen.daijishou.daijishou_widget.widgets.activity;

import android.widget.ImageView;
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

/* INFO: compiled from: ActivityWidgetContinueFaceFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$1", f = "ActivityWidgetContinueFaceFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    int label;
    final /* synthetic */ ActivityWidgetContinueFaceFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$1(ActivityWidgetContinueFaceFragment activityWidgetContinueFaceFragment, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = activityWidgetContinueFaceFragment;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ImageView imageView = this.this$0.background;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
                imageView = null;
            }
            imageView.setImageBitmap(this.this$0.cachedBitmap);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
