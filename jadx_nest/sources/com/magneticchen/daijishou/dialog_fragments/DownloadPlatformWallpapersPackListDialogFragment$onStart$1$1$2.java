package com.magneticchen.daijishou.dialog_fragments;

import android.widget.ProgressBar;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
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

/* JADX INFO: compiled from: DownloadPlatformWallpapersPackListDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.DownloadPlatformWallpapersPackListDialogFragment$onStart$1$1$2", f = "DownloadPlatformWallpapersPackListDialogFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class DownloadPlatformWallpapersPackListDialogFragment$onStart$1$1$2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DownloadPlatformWallpapersPackListDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadPlatformWallpapersPackListDialogFragment$onStart$1$1$2(DownloadPlatformWallpapersPackListDialogFragment downloadPlatformWallpapersPackListDialogFragment, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = downloadPlatformWallpapersPackListDialogFragment;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        DownloadPlatformWallpapersPackListDialogFragment$onStart$1$1$2 downloadPlatformWallpapersPackListDialogFragment$onStart$1$1$2 = new DownloadPlatformWallpapersPackListDialogFragment$onStart$1$1$2(this.this$0, continuation);
        downloadPlatformWallpapersPackListDialogFragment$onStart$1$1$2.L$0 = obj;
        return downloadPlatformWallpapersPackListDialogFragment$onStart$1$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((DownloadPlatformWallpapersPackListDialogFragment$onStart$1$1$2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            DaijishouRecyclerView.Adapter adapter = this.this$0.recyclerViewAdapter;
            ProgressBar progressBar = null;
            if (adapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                adapter = null;
            }
            adapter.notifyDataSetChanged();
            this.this$0.getLogger().debug(coroutineScope, "notifyDataSetChanged");
            DaijishouRecyclerView daijishouRecyclerView = this.this$0.recyclerView;
            if (daijishouRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView = null;
            }
            daijishouRecyclerView.requestFocus();
            ProgressBar progressBar2 = this.this$0.progressBar;
            if (progressBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            } else {
                progressBar = progressBar2;
            }
            progressBar.setVisibility(8);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
