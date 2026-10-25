package com.magneticchen.daijishou.dialog_fragments;

import android.app.Dialog;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformsIndexJson;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformsIndexPlatformListItemJson;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DownloadPlatformsDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.DownloadPlatformsDialogFragment$onStart$1$1$1$1", f = "DownloadPlatformsDialogFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
final class DownloadPlatformsDialogFragment$onStart$1$1$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ PlatformsIndexJson $it;
    int label;
    final /* synthetic */ DownloadPlatformsDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadPlatformsDialogFragment$onStart$1$1$1$1(DownloadPlatformsDialogFragment downloadPlatformsDialogFragment, Dialog dialog, PlatformsIndexJson platformsIndexJson, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = downloadPlatformsDialogFragment;
        this.$dialog = dialog;
        this.$it = platformsIndexJson;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new DownloadPlatformsDialogFragment$onStart$1$1$1$1(this.this$0, this.$dialog, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((DownloadPlatformsDialogFragment$onStart$1$1$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayAdapter arrayAdapter = this.this$0.adapter;
            if (arrayAdapter == null) {
                return null;
            }
            Dialog dialog = this.$dialog;
            DownloadPlatformsDialogFragment downloadPlatformsDialogFragment = this.this$0;
            PlatformsIndexJson platformsIndexJson = this.$it;
            String string = downloadPlatformsDialogFragment.getString(R.string.select_platforms_no_selections_format);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String str = String.format(string, Arrays.copyOf(new Object[]{Boxing.boxInt(platformsIndexJson.getPlatformList().size())}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            dialog.setTitle(str);
            int size = platformsIndexJson.getPlatformList().size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                PlatformsIndexPlatformListItemJson platformsIndexPlatformListItemJson = platformsIndexJson.getPlatformList().get(i);
                PlatformEntity platformByShortNameStatically = downloadPlatformsDialogFragment.getDaijishouLibrary().getPlatformByShortNameStatically(platformsIndexPlatformListItemJson.getPlatformUniqueId());
                arrayList.add((platformByShortNameStatically == null ? new StringBuilder("⬇️ ") : new StringBuilder("✅ ")).append(platformsIndexPlatformListItemJson.getPlatformName()).toString());
            }
            downloadPlatformsDialogFragment.listViewItems.clear();
            downloadPlatformsDialogFragment.listViewItems.addAll(arrayList);
            arrayAdapter.notifyDataSetChanged();
            ListView listView = downloadPlatformsDialogFragment.listView;
            Intrinsics.checkNotNull(listView);
            listView.requestFocus();
            ProgressBar progressBar = downloadPlatformsDialogFragment.progressBar;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
