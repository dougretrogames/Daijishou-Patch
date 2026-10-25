package com.magneticchen.daijishou.dialog_fragments;

import android.widget.Toast;
import com.magneticchen.daijishou.google_drive.GoogleDrive;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

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

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$progressDialogFragment, this.this$0, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            } else if (i == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            DaijishouSynchronizationModel daijishouSynchronizationModel = DebugAndExperimentalDialogFragment.onCreateDialog$lambda$1(this.$daijishouSynchronization$delegate);
            GoogleDrive googleDrive = daijishouSynchronizationModel != null ? daijishouSynchronizationModel.getGoogleDrive() : null;
            if (googleDrive != null) {
                this.label = 1;
                if (GoogleDrive.deleteAllFiles$default(googleDrive, false, this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }

        DaijishouSynchronizationModel daijishouSynchronizationModel2 = DebugAndExperimentalDialogFragment.onCreateDialog$lambda$1(this.$daijishouSynchronization$delegate);
        GoogleDrive googleDrive2 = daijishouSynchronizationModel2 != null ? daijishouSynchronizationModel2.getGoogleDrive() : null;
        if (googleDrive2 != null) {
            this.label = 2;
            if (GoogleDrive.logAllFiles$default(googleDrive2, false, this, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }

        this.label = 3;
        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$progressDialogFragment, this.this$0, null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
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
