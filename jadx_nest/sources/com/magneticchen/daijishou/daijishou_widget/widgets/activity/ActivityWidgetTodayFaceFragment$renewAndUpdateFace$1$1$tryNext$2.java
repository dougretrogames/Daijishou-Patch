package com.magneticchen.daijishou.daijishou_widget.widgets.activity;

import android.graphics.Bitmap;
import com.google.android.material.imageview.ShapeableImageView;
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

/* JADX INFO: compiled from: ActivityWidgetTodayFaceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$2", f = "ActivityWidgetTodayFaceFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    int label;
    final /* synthetic */ ActivityWidgetTodayFaceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$2(ActivityWidgetTodayFaceFragment activityWidgetTodayFaceFragment, Bitmap bitmap, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = activityWidgetTodayFaceFragment;
        this.$bitmap = bitmap;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$2(this.this$0, this.$bitmap, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ShapeableImageView shapeableImageView = this.this$0.background;
            if (shapeableImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
                shapeableImageView = null;
            }
            shapeableImageView.setImageBitmap(this.$bitmap);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
