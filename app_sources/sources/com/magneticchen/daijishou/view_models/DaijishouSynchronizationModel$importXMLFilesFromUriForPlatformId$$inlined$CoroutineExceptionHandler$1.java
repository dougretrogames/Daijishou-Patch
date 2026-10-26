package com.magneticchen.daijishou.view_models;

import androidx.lifecycle.ViewModelKt;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: CoroutineExceptionHandler.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ DaijishouSynchronizationModel this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$$inlined$CoroutineExceptionHandler$1(CoroutineContext.Key<?> companion, DaijishouSynchronizationModel daijishouSynchronizationModel, Function1 function1) {
        super(companion);
        this.this$0 = daijishouSynchronizationModel;
        this.$callback$inlined = function1;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext context, Throwable exception) {
        this.this$0.getLogger().warn(this.this$0, ExceptionsKt.stackTraceToString(exception));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), Dispatchers.getMain(), null, new DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$coroutineExceptionHandler$1$1(this.$callback$inlined, null), 2, null);
    }
}
