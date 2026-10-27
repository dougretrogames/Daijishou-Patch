package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.Dialog;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.portables.PlatformThumbnailsPacksIndexJson;
import com.magneticchen.daijishou.data.portables.PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import java.util.ArrayList;
import java.util.List;
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

/* JADX INFO: compiled from: DownloadPlatformThumbnailsPackListDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$1$1", f = "DownloadPlatformThumbnailsPackListDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ PlatformThumbnailsPacksIndexJson $it;
    int label;
    final /* synthetic */ DownloadPlatformThumbnailsPackListDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$1$1(DownloadPlatformThumbnailsPackListDialogFragment downloadPlatformThumbnailsPackListDialogFragment, Dialog dialog, PlatformThumbnailsPacksIndexJson platformThumbnailsPacksIndexJson, Continuation<? super DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadPlatformThumbnailsPackListDialogFragment;
        this.$dialog = dialog;
        this.$it = platformThumbnailsPacksIndexJson;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$1$1(this.this$0, this.$dialog, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadPlatformThumbnailsPackListDialogFragment$onStart$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ArrayList platformThumbnailsPackList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DaijishouRecyclerView daijishouRecyclerView = this.this$0.recyclerView;
            ProgressBar progressBar = null;
            if (daijishouRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView = null;
            }
            RecyclerView.Adapter adapter = daijishouRecyclerView.getAdapter();
            if (adapter == null) {
                return null;
            }
            Dialog dialog = this.$dialog;
            DownloadPlatformThumbnailsPackListDialogFragment downloadPlatformThumbnailsPackListDialogFragment = this.this$0;
            PlatformThumbnailsPacksIndexJson platformThumbnailsPacksIndexJson = this.$it;
            dialog.setTitle("Platform thumbnails packs");
            downloadPlatformThumbnailsPackListDialogFragment.listViewItems.clear();
            List list = downloadPlatformThumbnailsPackListDialogFragment.listViewItems;
            if (downloadPlatformThumbnailsPackListDialogFragment.getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_NSFW.getKey(), BooleanPreference.USE_NSFW.getDefaultValue())) {
                platformThumbnailsPackList = platformThumbnailsPacksIndexJson.getPlatformThumbnailsPackList();
            } else {
                List<PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson> platformThumbnailsPackList2 = platformThumbnailsPacksIndexJson.getPlatformThumbnailsPackList();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : platformThumbnailsPackList2) {
                    if (!((PlatformThumbnailsPacksIndexPlatformThumbnailPackListItemJson) obj2).getPlatformThumbnailsPackIsNSFW()) {
                        arrayList.add(obj2);
                    }
                }
                platformThumbnailsPackList = arrayList;
            }
            list.addAll(platformThumbnailsPackList);
            adapter.notifyDataSetChanged();
            DaijishouRecyclerView daijishouRecyclerView2 = downloadPlatformThumbnailsPackListDialogFragment.recyclerView;
            if (daijishouRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView2 = null;
            }
            daijishouRecyclerView2.requestFocus();
            ProgressBar progressBar2 = downloadPlatformThumbnailsPackListDialogFragment.progressBar;
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
