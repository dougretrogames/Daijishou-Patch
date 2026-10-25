package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformSharable;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformsIndexPlatformListItemJson;
import com.magneticchen.daijishou.utils.Utils;
import java.util.ArrayList;
import java.util.List;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DownloadPlatformsDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2", f = "DownloadPlatformsDialogFragment.kt", i = {}, l = {220}, m = "invokeSuspendImpl", n = {}, s = {})
final class DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ String $baseUri;
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ List<PlatformsIndexPlatformListItemJson> $selectedPlatformList;
    final /* synthetic */ Ref.IntRef $succeedCount;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DownloadPlatformsDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2(List<PlatformsIndexPlatformListItemJson> list, FragmentActivity fragmentActivity, String str, DownloadPlatformsDialogFragment downloadPlatformsDialogFragment, Ref.IntRef intRef, AlertDialog alertDialog, Continuation<?> continuation) {
        super(2, continuation);
        this.$selectedPlatformList = list;
        this.$activity = fragmentActivity;
        this.$baseUri = str;
        this.this$0 = downloadPlatformsDialogFragment;
        this.$succeedCount = intRef;
        this.$dialog = alertDialog;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2 downloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2 = new DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2(this.$selectedPlatformList, this.$activity, this.$baseUri, this.this$0, this.$succeedCount, this.$dialog, continuation);
        downloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2.L$0 = obj;
        return downloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ArrayList arrayList = new ArrayList();
            List<PlatformsIndexPlatformListItemJson> list = this.$selectedPlatformList;
            FragmentActivity fragmentActivity = this.$activity;
            String str = this.$baseUri;
            DownloadPlatformsDialogFragment downloadPlatformsDialogFragment = this.this$0;
            for (PlatformsIndexPlatformListItemJson platformsIndexPlatformListItemJson : list) {
                try {
                    Application application = fragmentActivity.getApplication();
                    Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                    arrayList.add((PlatformSharable) ((DaijishouApplication) application).getWeakJson().decodeFromString(PlatformSharable.INSTANCE.serializer(), Utils.INSTANCE.readEntireTextFromURL(str + platformsIndexPlatformListItemJson.getFilename())));
                } catch (Exception e) {
                    downloadPlatformsDialogFragment.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                }
            }
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = -1;
            this.label = 1;
            if (invokeSuspendImpl$importNext(intRef, arrayList, this.this$0, this.$activity, coroutineScope, this.$succeedCount, this.$dialog, this.$selectedPlatformList, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00de, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r0, r15, r9) == r10) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object invokeSuspendImpl$importNext(kotlin.jvm.internal.Ref.IntRef r21, java.util.List<com.magneticchen.daijishou.daijishou_library_db.portables.PlatformSharable> r22, com.magneticchen.daijishou.dialog_fragments.DownloadPlatformsDialogFragment r23, androidx.fragment.app.FragmentActivity r24, kotlinx.coroutines.CoroutineScope r25, kotlin.jvm.internal.Ref.IntRef r26, android.app.AlertDialog r27, java.util.List<com.magneticchen.daijishou.daijishou_library_db.portables.PlatformsIndexPlatformListItemJson> r28, kotlin.coroutines.Continuation<?> r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.dialog_fragments.DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2.invokeSuspendImpl$importNext(kotlin.jvm.internal.Ref$IntRef, java.util.List, com.magneticchen.daijishou.dialog_fragments.DownloadPlatformsDialogFragment, androidx.fragment.app.FragmentActivity, kotlinx.coroutines.CoroutineScope, kotlin.jvm.internal.Ref$IntRef, android.app.AlertDialog, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
