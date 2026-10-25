package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformSharable;
import com.magneticchen.daijishou.daijishou_library_db.portables.PlatformsIndexPlatformListItemJson;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DownloadPlatformsDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "platformEntity", "Lcom/magneticchen/daijishou/daijishou_library_db/PlatformEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$2 extends Lambda<Unit> implements Function1<PlatformEntity, Unit> {
    final /* synthetic */ CoroutineScope $$this$launch;
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ AlertDialog $dialog;
    final /* synthetic */ Ref.IntRef $index;
    final /* synthetic */ List<PlatformSharable> $platformSharableList;
    final /* synthetic */ List<PlatformsIndexPlatformListItemJson> $selectedPlatformList;
    final /* synthetic */ Ref.IntRef $succeedCount;
    final /* synthetic */ DownloadPlatformsDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$2(Ref.IntRef intRef, DownloadPlatformsDialogFragment downloadPlatformsDialogFragment, Ref.IntRef intRef2, List<PlatformSharable> list, FragmentActivity fragmentActivity, CoroutineScope coroutineScope, AlertDialog alertDialog, List<PlatformsIndexPlatformListItemJson> list2) {
        super(1);
        this.$succeedCount = intRef;
        this.this$0 = downloadPlatformsDialogFragment;
        this.$index = intRef2;
        this.$platformSharableList = list;
        this.$activity = fragmentActivity;
        this.$$this$launch = coroutineScope;
        this.$dialog = alertDialog;
        this.$selectedPlatformList = list2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PlatformEntity platformEntity) {
        invoke2(platformEntity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PlatformEntity platformEntity) {
        if (platformEntity != null) {
            this.$succeedCount.element++;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getDefault(), null, new AnonymousClass1(this.$index, this.$platformSharableList, this.this$0, this.$activity, this.$$this$launch, this.$succeedCount, this.$dialog, this.$selectedPlatformList, null), 2, null);
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadPlatformsDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2$importNext$2$1", f = "DownloadPlatformsDialogFragment.kt", i = {}, l = {190}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ FragmentActivity $activity;
        final /* synthetic */ AlertDialog $dialog;
        final /* synthetic */ Ref.IntRef $index;
        final /* synthetic */ List<PlatformSharable> $platformSharableList;
        final /* synthetic */ List<PlatformsIndexPlatformListItemJson> $selectedPlatformList;
        final /* synthetic */ Ref.IntRef $succeedCount;
        int label;
        final /* synthetic */ DownloadPlatformsDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref.IntRef intRef, List<PlatformSharable> list, DownloadPlatformsDialogFragment downloadPlatformsDialogFragment, FragmentActivity fragmentActivity, CoroutineScope coroutineScope, Ref.IntRef intRef2, AlertDialog alertDialog, List<PlatformsIndexPlatformListItemJson> list2, Continuation<?> continuation) {
            super(2, continuation);
            this.$index = intRef;
            this.$platformSharableList = list;
            this.this$0 = downloadPlatformsDialogFragment;
            this.$activity = fragmentActivity;
            this.$$this$launch = coroutineScope;
            this.$succeedCount = intRef2;
            this.$dialog = alertDialog;
            this.$selectedPlatformList = list2;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$index, this.$platformSharableList, this.this$0, this.$activity, this.$$this$launch, this.$succeedCount, this.$dialog, this.$selectedPlatformList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2.invokeSuspendImpl$importNext(this.$index, this.$platformSharableList, this.this$0, this.$activity, this.$$this$launch, this.$succeedCount, this.$dialog, this.$selectedPlatformList, this) == coroutine_suspended) {
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
    }
}
