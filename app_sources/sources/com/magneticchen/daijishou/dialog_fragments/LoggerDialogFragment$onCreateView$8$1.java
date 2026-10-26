package com.magneticchen.daijishou.dialog_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: LoggerDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$8$1", f = "LoggerDialogFragment.kt", i = {}, l = {378, 379}, m = "invokeSuspendImpl", n = {}, s = {})
final class LoggerDialogFragment$onCreateView$8$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ Lazy<DaijishouConsoleViewModel> $console$delegate;
    final /* synthetic */ TextInputEditText $editText;
    int label;
    final /* synthetic */ LoggerDialogFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoggerDialogFragment$onCreateView$8$1(LoggerDialogFragment loggerDialogFragment, TextInputEditText textInputEditText, Lazy<DaijishouConsoleViewModel> lazy, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = loggerDialogFragment;
        this.$editText = textInputEditText;
        this.$console$delegate = lazy;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new LoggerDialogFragment$onCreateView$8$1(this.this$0, this.$editText, this.$console$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((LoggerDialogFragment$onCreateView$8$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DaijishouConsoleViewModel console = LoggerDialogFragment.onCreateView$lambda$6(this.$console$delegate);
            FragmentActivity activity = this.this$0.requireActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            String command = String.valueOf(this.$editText.getText());
            this.label = 1;
            if (console.execute(appCompatActivity, command, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnonymousClass1 callback = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getMain(), callback, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$8$1$1, reason: invalid class name */
    /* INFO: compiled from: LoggerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$8$1$1", f = "LoggerDialogFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;
        final /* synthetic */ LoggerDialogFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LoggerDialogFragment loggerDialogFragment, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = loggerDialogFragment;
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DaijishouRecyclerView daijishouRecyclerView = this.this$0.recyclerView;
                if (daijishouRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    daijishouRecyclerView = null;
                }
                daijishouRecyclerView.scrollToPosition(0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
