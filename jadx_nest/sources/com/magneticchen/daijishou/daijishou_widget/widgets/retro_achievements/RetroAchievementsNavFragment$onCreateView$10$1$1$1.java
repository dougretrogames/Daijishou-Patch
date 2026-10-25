package com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements;

import android.widget.TextView;
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

/* JADX INFO: compiled from: RetroAchievementsNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsNavFragment$onCreateView$10$1$1$1", f = "RetroAchievementsNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class RetroAchievementsNavFragment$onCreateView$10$1$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    int label;
    final /* synthetic */ RetroAchievementsNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetroAchievementsNavFragment$onCreateView$10$1$1$1(RetroAchievementsNavFragment retroAchievementsNavFragment, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = retroAchievementsNavFragment;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new RetroAchievementsNavFragment$onCreateView$10$1$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((RetroAchievementsNavFragment$onCreateView$10$1$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TextView textView = this.this$0.description;
            String str = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("description");
                textView = null;
            }
            String str2 = this.this$0.loadingDataString;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingDataString");
                str2 = null;
            }
            textView.setText(str2);
            TextView textView2 = this.this$0.motto;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("motto");
                textView2 = null;
            }
            String str3 = this.this$0.noMottoString;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noMottoString");
            } else {
                str = str3;
            }
            textView2.setText(str);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
