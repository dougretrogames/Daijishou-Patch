package com.magneticchen.daijishou.settings_nav_fragments;

import android.content.Context;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.dialog_fragments.ProgressDialogFragment;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: LibrarySettingsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class LibrarySettingsNavFragment$onCreate$5$1 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ LibrarySettingsNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    LibrarySettingsNavFragment$onCreate$5$1(LibrarySettingsNavFragment librarySettingsNavFragment) {
        super(0);
        this.this$0 = librarySettingsNavFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ProgressDialogFragment progressDialogFragmentNewInstance$default = ProgressDialogFragment.Companion.newInstance$default(ProgressDialogFragment.INSTANCE, null, null, 3, null);
        progressDialogFragmentNewInstance$default.show(this.this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getIO(), null, new AnonymousClass1(this.this$0, progressDialogFragmentNewInstance$default, null), 2, null);
    }

    /* INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.LibrarySettingsNavFragment$onCreate$5$1$1, reason: invalid class name */
    /* INFO: compiled from: LibrarySettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.settings_nav_fragments.LibrarySettingsNavFragment$onCreate$5$1$1", f = "LibrarySettingsNavFragment.kt", i = {}, l = {234}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
        int label;
        final /* synthetic */ LibrarySettingsNavFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LibrarySettingsNavFragment librarySettingsNavFragment, ProgressDialogFragment progressDialogFragment, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = librarySettingsNavFragment;
            this.$progressDialogFragment = progressDialogFragment;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$progressDialogFragment, continuation);
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
                int iClearAllDisjointedPlayableItems = this.this$0.getDaijishouLibrary().clearAllDisjointedPlayableItems();
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C00731(this.$progressDialogFragment, this.this$0, iClearAllDisjointedPlayableItems, null), this) == coroutine_suspended) {
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

        /* INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.LibrarySettingsNavFragment$onCreate$5$1$1$1, reason: invalid class name and collision with other inner class name */
        /* INFO: compiled from: LibrarySettingsNavFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.settings_nav_fragments.LibrarySettingsNavFragment$onCreate$5$1$1$1", f = "LibrarySettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        static final class C00731 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ int $clearedCount;
            final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
            int label;
            final /* synthetic */ LibrarySettingsNavFragment this$0;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00731(ProgressDialogFragment progressDialogFragment, LibrarySettingsNavFragment librarySettingsNavFragment, int i, Continuation<?> continuation) {
                super(2, continuation);
                this.$progressDialogFragment = progressDialogFragment;
                this.this$0 = librarySettingsNavFragment;
                this.$clearedCount = i;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new C00731(this.$progressDialogFragment, this.this$0, this.$clearedCount, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((C00731) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
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
                Context contextRequireContext = this.this$0.requireContext();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = this.this$0.clearedItemsFormatString;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clearedItemsFormatString");
                    str = null;
                }
                String str2 = String.format(str, Arrays.copyOf(new Object[]{Boxing.boxInt(this.$clearedCount)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                Toast.makeText(contextRequireContext, str2, 0).show();
                return Unit.INSTANCE;
            }
        }
    }
}
