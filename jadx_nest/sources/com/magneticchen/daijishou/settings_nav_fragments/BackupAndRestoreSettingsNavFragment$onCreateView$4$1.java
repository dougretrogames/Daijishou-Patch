package com.magneticchen.daijishou.settings_nav_fragments;

import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
        public final java.lang.Object invokeSuspendImpl(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 3
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L28
                if (r1 == r5) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L81
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1e:
                kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L26
                goto L81
            L22:
                kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L26
                goto L3e
            L26:
                r8 = move-exception
                goto L59
            L28:
                kotlin.ResultKt.throwOnFailure(r8)
                com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment r8 = r7.this$0     // Catch: java.lang.Exception -> L26
                com.magneticchen.daijishou.google_drive.GoogleDrive r8 = com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment.access$getGoogleDrive(r8)     // Catch: java.lang.Exception -> L26
                r1 = r7
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Exception -> L26
                r7.label = r5     // Catch: java.lang.Exception -> L26
                r6 = 0
                java.lang.Object r8 = com.magneticchen.daijishou.google_drive.GoogleDrive.deleteAllFiles$default(r8, r6, r1, r5, r4)     // Catch: java.lang.Exception -> L26
                if (r8 != r0) goto L3e
                goto L80
            L3e:
                kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L26
                kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8     // Catch: java.lang.Exception -> L26
                com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$1 r1 = new com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$1     // Catch: java.lang.Exception -> L26
                com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment r5 = r7.this$0     // Catch: java.lang.Exception -> L26
                r1.<init>(r5, r4)     // Catch: java.lang.Exception -> L26
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1     // Catch: java.lang.Exception -> L26
                r5 = r7
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Exception -> L26
                r7.label = r3     // Catch: java.lang.Exception -> L26
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r5)     // Catch: java.lang.Exception -> L26
                if (r8 != r0) goto L81
                goto L80
            L59:
                com.magneticchen.daijishou.DaijishouApplication$WrappedLogger r1 = r7.$logger
                com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment r3 = r7.this$0
                java.lang.Throwable r8 = (java.lang.Throwable) r8
                java.lang.String r8 = kotlin.ExceptionsKt.stackTraceToString(r8)
                r1.error(r3, r8)
                kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
                com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$2 r1 = new com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1$2
                com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment r3 = r7.this$0
                r1.<init>(r3, r4)
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                r3 = r7
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r7.label = r2
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r3)
                if (r8 != r0) goto L81
            L80:
                return r0
            L81:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$4$1.AnonymousClass1.invokeSuspendImpl(java.lang.Object):java.lang.Object");
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
