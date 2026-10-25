package com.magneticchen.daijishou.dialog_fragments;

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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LoggerDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$8$1", f = "LoggerDialogFragment.kt", i = {}, l = {378, 379}, m = "invokeSuspendImpl", n = {}, s = {})
final class LoggerDialogFragment$onCreateView$8$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ Lazy<DaijishouConsoleViewModel> $console$delegate;
    final /* synthetic */ TextInputEditText $editText;
    int label;
    final /* synthetic */ LoggerDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$8$1.AnonymousClass1(r6.this$0, null), r6) == r0) goto L15;
     */

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspendImpl(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r7)
            goto L66
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4a
        L1e:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Lazy<com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel> r7 = r6.$console$delegate
            com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel r7 = com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment.access$onCreateView$lambda$6(r7)
            com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment r1 = r6.this$0
            androidx.fragment.app.FragmentActivity r1 = r1.requireActivity()
            java.lang.String r4 = "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r4)
            androidx.appcompat.app.AppCompatActivity r1 = (androidx.appcompat.app.AppCompatActivity) r1
            com.google.android.material.textfield.TextInputEditText r4 = r6.$editText
            android.text.Editable r4 = r4.getText()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.label = r3
            java.lang.Object r7 = r7.execute(r1, r4, r5)
            if (r7 != r0) goto L4a
            goto L65
        L4a:
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$8$1$1 r1 = new com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$8$1$1
            com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment r3 = r6.this$0
            r4 = 0
            r1.<init>(r3, r4)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r6.label = r2
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r3)
            if (r7 != r0) goto L66
        L65:
            return r0
        L66:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$8$1.invokeSuspendImpl(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$8$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoggerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$8$1$1", f = "LoggerDialogFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;
        final /* synthetic */ LoggerDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
