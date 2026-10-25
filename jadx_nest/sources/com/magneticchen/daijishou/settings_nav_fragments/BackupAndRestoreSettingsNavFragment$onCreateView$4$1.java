package com.magneticchen.daijishou.settings_nav_fragments;

import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.google_drive.GoogleDrive;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class BackupAndRestoreSettingsNavFragment$onCreateView$4$1 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ DaijishouApplication.WrappedLogger $logger;
    final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackupAndRestoreSettingsNavFragment$onCreateView$4$1(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, DaijishouApplication.WrappedLogger wrappedLogger) {
        super(0);
        this.this$0 = backupAndRestoreSettingsNavFragment;
        this.$logger = wrappedLogger;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1", f = "BackupAndRestoreSettingsNavFragment.kt", i = {}, l = {236, 237, 243}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ DaijishouApplication.WrappedLogger $logger;
        int label;
        final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, DaijishouApplication.WrappedLogger wrappedLogger, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = backupAndRestoreSettingsNavFragment;
            this.$logger = wrappedLogger;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$logger, continuation);
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

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$4$1.AnonymousClass1.C00721(r7.this$0, null), r7) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$4$1.AnonymousClass1.AnonymousClass2(r7.this$0, null), r7) == r0) goto L24;
         */

        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    GoogleDrive googleDrive = this.this$0.getGoogleDrive();
                    this.label = 1;
                    if (GoogleDrive.deleteAllFiles$default(googleDrive, false, this, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    CoroutineContext mainContext = (CoroutineContext) Dispatchers.getMain();
                    C00721 action = new C00721(this.this$0, null);
                    this.label = 2;
                    if (BuildersKt.withContext(mainContext, action, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Exception e) {
                    this.$logger.error(this.this$0, ExceptionsKt.stackTraceToString(e));
                    CoroutineContext mainContext2 = (CoroutineContext) Dispatchers.getMain();
                    AnonymousClass2 action2 = new AnonymousClass2(this.this$0, null);
                    this.label = 3;
                    if (BuildersKt.withContext(mainContext2, action2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i == 1) {
                try {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext mainContext = (CoroutineContext) Dispatchers.getMain();
                    C00721 action = new C00721(this.this$0, null);
                    this.label = 2;
                    if (BuildersKt.withContext(mainContext, action, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Exception e2) {
                    this.$logger.error(this.this$0, ExceptionsKt.stackTraceToString(e2));
                    CoroutineContext mainContext2 = (CoroutineContext) Dispatchers.getMain();
                    AnonymousClass2 action2 = new AnonymousClass2(this.this$0, null);
                    this.label = 3;
                    if (BuildersKt.withContext(mainContext2, action2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i == 2 || i == 3) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$1", f = "BackupAndRestoreSettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        static final class C00721 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            int label;
            final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00721(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = backupAndRestoreSettingsNavFragment;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new C00721(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((C00721) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
                Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.delete_all_google_drive_successful), 0).show();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$2", f = "BackupAndRestoreSettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        static final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            int label;
            final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = backupAndRestoreSettingsNavFragment;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
                Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.delete_all_google_drive_failed), 0).show();
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.deleting_this_will_take_a_while), 0).show();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getIO(), null, new AnonymousClass1(this.this$0, this.$logger, null), 2, null);
    }
}
