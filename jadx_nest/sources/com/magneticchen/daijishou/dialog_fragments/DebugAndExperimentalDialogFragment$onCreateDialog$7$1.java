package com.magneticchen.daijishou.dialog_fragments;

import android.widget.Toast;
import com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DebugAndExperimentalDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.DebugAndExperimentalDialogFragment$onCreateDialog$7$1", f = "DebugAndExperimentalDialogFragment.kt", i = {}, l = {127, 128, 129}, m = "invokeSuspendImpl", n = {}, s = {})
final class DebugAndExperimentalDialogFragment$onCreateDialog$7$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ Lazy<DaijishouSynchronizationModel> $daijishouSynchronization$delegate;
    final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
    int label;
    final /* synthetic */ DebugAndExperimentalDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DebugAndExperimentalDialogFragment$onCreateDialog$7$1(Lazy<DaijishouSynchronizationModel> lazy, ProgressDialogFragment progressDialogFragment, DebugAndExperimentalDialogFragment debugAndExperimentalDialogFragment, Continuation<?> continuation) {
        super(2, continuation);
        this.$daijishouSynchronization$delegate = lazy;
        this.$progressDialogFragment = progressDialogFragment;
        this.this$0 = debugAndExperimentalDialogFragment;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new DebugAndExperimentalDialogFragment$onCreateDialog$7$1(this.$daijishouSynchronization$delegate, this.$progressDialogFragment, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((DebugAndExperimentalDialogFragment$onCreateDialog$7$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005a  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.dialog_fragments.DebugAndExperimentalDialogFragment$onCreateDialog$7$1.AnonymousClass1(r7.$progressDialogFragment, r7.this$0, null), r7) == r0) goto L24;
     */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspendImpl(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r1 == 0) goto L27
            if (r1 == r6) goto L23
            if (r1 == r4) goto L1f
            if (r1 != r3) goto L17
            kotlin.ResultKt.throwOnFailure(r8)
            goto L77
        L17:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1f:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5a
        L23:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L42
        L27:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Lazy<com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel> r8 = r7.$daijishouSynchronization$delegate
            com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel r8 = com.magneticchen.daijishou.dialog_fragments.DebugAndExperimentalDialogFragment.access$onCreateDialog$lambda$1(r8)
            com.magneticchen.daijishou.google_drive.GoogleDrive r8 = r8.getGoogleDrive()
            if (r8 == 0) goto L42
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.label = r6
            java.lang.Object r8 = com.magneticchen.daijishou.google_drive.GoogleDrive.deleteAllFiles$default(r8, r2, r1, r6, r5)
            if (r8 != r0) goto L42
            goto L76
        L42:
            kotlin.Lazy<com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel> r8 = r7.$daijishouSynchronization$delegate
            com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel r8 = com.magneticchen.daijishou.dialog_fragments.DebugAndExperimentalDialogFragment.access$onCreateDialog$lambda$1(r8)
            com.magneticchen.daijishou.google_drive.GoogleDrive r8 = r8.getGoogleDrive()
            if (r8 == 0) goto L5a
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.label = r4
            java.lang.Object r8 = com.magneticchen.daijishou.google_drive.GoogleDrive.logAllFiles$default(r8, r2, r1, r6, r5)
            if (r8 != r0) goto L5a
            goto L76
        L5a:
            kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            com.magneticchen.daijishou.dialog_fragments.DebugAndExperimentalDialogFragment$onCreateDialog$7$1$1 r1 = new com.magneticchen.daijishou.dialog_fragments.DebugAndExperimentalDialogFragment$onCreateDialog$7$1$1
            com.magneticchen.daijishou.dialog_fragments.ProgressDialogFragment r2 = r7.$progressDialogFragment
            com.magneticchen.daijishou.dialog_fragments.DebugAndExperimentalDialogFragment r4 = r7.this$0
            r1.<init>(r2, r4, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2 = r7
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r7.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r2)
            if (r8 != r0) goto L77
        L76:
            return r0
        L77:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.dialog_fragments.DebugAndExperimentalDialogFragment$onCreateDialog$7$1.invokeSuspendImpl(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.DebugAndExperimentalDialogFragment$onCreateDialog$7$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: DebugAndExperimentalDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.DebugAndExperimentalDialogFragment$onCreateDialog$7$1$1", f = "DebugAndExperimentalDialogFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
        int label;
        final /* synthetic */ DebugAndExperimentalDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ProgressDialogFragment progressDialogFragment, DebugAndExperimentalDialogFragment debugAndExperimentalDialogFragment, Continuation<?> continuation) {
            super(2, continuation);
            this.$progressDialogFragment = progressDialogFragment;
            this.this$0 = debugAndExperimentalDialogFragment;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$progressDialogFragment, this.this$0, continuation);
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$progressDialogFragment.dismiss();
            Toast.makeText(this.this$0.requireContext(), "Google Drive files deleted. Logs printed.", 0).show();
            return Unit.INSTANCE;
        }
    }
}
