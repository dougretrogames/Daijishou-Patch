package com.magneticchen.daijishou.ui.widget.widgets.activity;

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

/* JADX INFO: compiled from: ActivityWidgetContinueFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetContinueFaceFragment$onCreateView$2$1$1", f = "ActivityWidgetContinueFaceFragment.kt", i = {}, l = {100, 106, 114}, m = "invokeSuspend", n = {}, s = {})
final class ActivityWidgetContinueFaceFragment$onCreateView$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ActivityWidgetContinueFaceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActivityWidgetContinueFaceFragment$onCreateView$2$1$1(ActivityWidgetContinueFaceFragment activityWidgetContinueFaceFragment, Continuation<? super ActivityWidgetContinueFaceFragment$onCreateView$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = activityWidgetContinueFaceFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ActivityWidgetContinueFaceFragment$onCreateView$2$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ActivityWidgetContinueFaceFragment$onCreateView$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ba, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r10, r2, r9) == r0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d5, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r2, r4, r9) == r0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f8, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetContinueFaceFragment$onCreateView$2$1$1.AnonymousClass2(r9.this$0, null), r9) == r0) goto L46;
     */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetContinueFaceFragment, int] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetContinueFaceFragment$onCreateView$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: ActivityWidgetContinueFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetContinueFaceFragment$onCreateView$2$1$1$2", f = "ActivityWidgetContinueFaceFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ActivityWidgetContinueFaceFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ActivityWidgetContinueFaceFragment activityWidgetContinueFaceFragment, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = activityWidgetContinueFaceFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ImageView imageView = this.this$0.background;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("background");
                    imageView = null;
                }
                imageView.setImageBitmap(null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
