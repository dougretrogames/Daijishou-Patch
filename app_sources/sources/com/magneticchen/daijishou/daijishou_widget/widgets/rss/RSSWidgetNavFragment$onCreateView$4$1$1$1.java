package com.magneticchen.daijishou.daijishou_widget.widgets.rss;

import com.magneticchen.daijishou.daijishou_widget.widget_db.RSSWidgetInstanceEntity;
import com.magneticchen.daijishou.repositories.DaijishouWidgetRepository;
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

/* INFO: compiled from: RSSWidgetNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.rss.RSSWidgetNavFragment$onCreateView$4$1$1$1", f = "RSSWidgetNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class RSSWidgetNavFragment$onCreateView$4$1$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ RSSWidgetInstanceEntity $rssWidgetInstanceEntity;
    int label;
    final /* synthetic */ RSSWidgetNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    RSSWidgetNavFragment$onCreateView$4$1$1$1(RSSWidgetNavFragment rSSWidgetNavFragment, RSSWidgetInstanceEntity rSSWidgetInstanceEntity, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = rSSWidgetNavFragment;
        this.$rssWidgetInstanceEntity = rSSWidgetInstanceEntity;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new RSSWidgetNavFragment$onCreateView$4$1$1$1(this.this$0, this.$rssWidgetInstanceEntity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((RSSWidgetNavFragment$onCreateView$4$1$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DaijishouWidgetRepository daijishouWidgetRepository = this.this$0.daijishouWidgetRepository;
            if (daijishouWidgetRepository == null) {
                Intrinsics.throwUninitializedPropertyAccessException("daijishouWidgetRepository");
                daijishouWidgetRepository = null;
            }
            daijishouWidgetRepository.updateRSSWidgetInstance(this.$rssWidgetInstanceEntity);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
