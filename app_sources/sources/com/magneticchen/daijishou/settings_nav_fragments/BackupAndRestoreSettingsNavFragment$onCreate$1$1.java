package com.magneticchen.daijishou.settings_nav_fragments;

import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.google_drive.GoogleDrive;
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

/* INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class BackupAndRestoreSettingsNavFragment$onCreate$1$1 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackupAndRestoreSettingsNavFragment$onCreate$1$1(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment) {
        super(0);
        this.this$0 = backupAndRestoreSettingsNavFragment;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreate$1$1$1, reason: invalid class name */
    /* INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreate$1$1$1", f = "BackupAndRestoreSettingsNavFragment.kt", i = {}, l = {77}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;
        final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = backupAndRestoreSettingsNavFragment;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
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
                if (GoogleDrive.requestSignOut$default(this.this$0.getGoogleDrive(), false, this, 1, null) == coroutine_suspended) {
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

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new AnonymousClass1(this.this$0, null), 3, null);
    }
}
