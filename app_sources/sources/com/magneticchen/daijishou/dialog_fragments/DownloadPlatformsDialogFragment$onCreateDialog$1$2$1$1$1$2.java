package com.magneticchen.daijishou.dialog_fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformSharable;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformsIndexPlatformListItemJson;
import com.magneticchen.daijishou.utils.Utils;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: DownloadPlatformsDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
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

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
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

    /* INFO: Access modifiers changed from: private */
    public static final Object invokeSuspendImpl$importNext(
            Ref.IntRef intRef,
            List<PlatformSharable> list,
            DownloadPlatformsDialogFragment downloadPlatformsDialogFragment,
            FragmentActivity fragmentActivity,
            CoroutineScope coroutineScope,
            Ref.IntRef succeedCount,
            AlertDialog alertDialog,
            List<PlatformsIndexPlatformListItemJson> selectedPlatformList,
            Continuation<?> continuation) throws Throwable {
        DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$1 continuationImpl;
        if (continuation instanceof DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$1) {
            continuationImpl = (DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$1) continuation;
            if ((continuationImpl.label & Integer.MIN_VALUE) != 0) {
                continuationImpl.label -= Integer.MIN_VALUE;
            } else {
                continuationImpl = new DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$1(continuation);
            }
        } else {
            continuationImpl = new DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$1(continuation);
        }
        Object obj = continuationImpl.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = continuationImpl.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            intRef.element++;
            if (intRef.element < list.size()) {
                PlatformSharable platformSharable = list.get(intRef.element);
                try {
                    DaijishouLibraryModel daijishouLibrary = downloadPlatformsDialogFragment.getDaijishouLibrary();
                    Intrinsics.checkNotNull(fragmentActivity);
                    DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$2 callback = new DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$2(
                            succeedCount,
                            downloadPlatformsDialogFragment,
                            intRef,
                            list,
                            fragmentActivity,
                            coroutineScope,
                            alertDialog,
                            selectedPlatformList);
                    daijishouLibrary.importPlatformWithDialog(fragmentActivity, platformSharable, callback);
                } catch (Exception e) {
                    continuationImpl.L$0 = downloadPlatformsDialogFragment;
                    continuationImpl.L$1 = coroutineScope;
                    continuationImpl.L$2 = e;
                    continuationImpl.label = 1;
                    if (invokeSuspendImpl$importNext(intRef, list, downloadPlatformsDialogFragment, fragmentActivity, coroutineScope, succeedCount, alertDialog, selectedPlatformList, continuationImpl) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    downloadPlatformsDialogFragment.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(e));
                }
            } else {
                CoroutineContext mainContext = (CoroutineContext) Dispatchers.getMain();
                DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$3 withContextAction = new DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$3(
                        alertDialog,
                        downloadPlatformsDialogFragment,
                        succeedCount,
                        selectedPlatformList,
                        null);
                continuationImpl.label = 2;
                if (BuildersKt.withContext(mainContext, withContextAction, continuationImpl) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            Exception exc = (Exception) continuationImpl.L$2;
            CoroutineScope scope = (CoroutineScope) continuationImpl.L$1;
            DownloadPlatformsDialogFragment fragment = (DownloadPlatformsDialogFragment) continuationImpl.L$0;
            ResultKt.throwOnFailure(obj);
            fragment.getLogger().warn(scope, ExceptionsKt.stackTraceToString(exc));
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
