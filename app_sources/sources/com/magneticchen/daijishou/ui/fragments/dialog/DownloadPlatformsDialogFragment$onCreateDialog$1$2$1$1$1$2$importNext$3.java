package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.portables.PlatformsIndexPlatformListItemJson;
import java.util.Arrays;
import java.util.List;
import kotlin.ExceptionsKt;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DownloadPlatformsDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$3", f = "DownloadPlatformsDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ List<PlatformsIndexPlatformListItemJson> $selectedPlatformList;
    final /* synthetic */ Ref.IntRef $succeedCount;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DownloadPlatformsDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$3(AlertDialog alertDialog, DownloadPlatformsDialogFragment downloadPlatformsDialogFragment, Ref.IntRef intRef, List<PlatformsIndexPlatformListItemJson> list, Continuation<? super DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$3> continuation) {
        super(2, continuation);
        this.$dialog = alertDialog;
        this.this$0 = downloadPlatformsDialogFragment;
        this.$succeedCount = intRef;
        this.$selectedPlatformList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$3 downloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$3 = new DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$3(this.$dialog, this.this$0, this.$succeedCount, this.$selectedPlatformList, continuation);
        downloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$3.L$0 = obj;
        return downloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        this.$dialog.dismiss();
        try {
            Context context = this.$dialog.getContext();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this.this$0.getString(R.string.imported_platforms_result_format);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String str = String.format(string, Arrays.copyOf(new Object[]{Boxing.boxInt(this.$succeedCount.element), Boxing.boxInt(this.$selectedPlatformList.size() - this.$succeedCount.element)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            Toast.makeText(context, str, 0).show();
        } catch (Exception e) {
            Exception exc = e;
            Toast.makeText(this.$dialog.getContext(), ExceptionsKt.stackTraceToString(exc), 0).show();
            this.this$0.getLogger().warn(coroutineScope, ExceptionsKt.stackTraceToString(exc));
        }
        return Unit.INSTANCE;
    }
}
