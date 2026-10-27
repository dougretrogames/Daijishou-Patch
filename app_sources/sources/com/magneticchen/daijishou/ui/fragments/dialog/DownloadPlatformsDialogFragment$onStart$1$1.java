package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.Dialog;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DownloadPlatformsDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment$onStart$1$1", f = "DownloadPlatformsDialogFragment.kt", i = {}, l = {75, 93}, m = "invokeSuspend", n = {}, s = {})
final class DownloadPlatformsDialogFragment$onStart$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Dialog $dialog;
    int label;
    final /* synthetic */ DownloadPlatformsDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadPlatformsDialogFragment$onStart$1$1(DownloadPlatformsDialogFragment downloadPlatformsDialogFragment, FragmentActivity fragmentActivity, Dialog dialog, Continuation<? super DownloadPlatformsDialogFragment$onStart$1$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadPlatformsDialogFragment;
        this.$activity = fragmentActivity;
        this.$dialog = dialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadPlatformsDialogFragment$onStart$1$1(this.this$0, this.$activity, this.$dialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadPlatformsDialogFragment$onStart$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a4, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment$onStart$1$1.AnonymousClass2(r10.this$0, r11, null), r10) == r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L20
            if (r1 == r4) goto L1c
            if (r1 != r3) goto L14
            kotlin.ResultKt.throwOnFailure(r11)
            goto La7
        L14:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1c:
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L8b
            goto L88
        L20:
            kotlin.ResultKt.throwOnFailure(r11)
            com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment r11 = r10.this$0     // Catch: java.lang.Exception -> L8b
            androidx.fragment.app.FragmentActivity r1 = r10.$activity     // Catch: java.lang.Exception -> L8b
            android.app.Application r1 = r1.getApplication()     // Catch: java.lang.Exception -> L8b
            java.lang.String r5 = "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r5)     // Catch: java.lang.Exception -> L8b
            com.magneticchen.daijishou.DaijishouApplication r1 = (com.magneticchen.daijishou.DaijishouApplication) r1     // Catch: java.lang.Exception -> L8b
            kotlinx.serialization.json.Json r1 = r1.getWeakJson()     // Catch: java.lang.Exception -> L8b
            com.magneticchen.daijishou.data.portables.PlatformsIndexJson$Companion r5 = com.magneticchen.daijishou.data.portables.PlatformsIndexJson.Companion     // Catch: java.lang.Exception -> L8b
            kotlinx.serialization.KSerializer r5 = r5.serializer()     // Catch: java.lang.Exception -> L8b
            kotlinx.serialization.DeserializationStrategy r5 = (kotlinx.serialization.DeserializationStrategy) r5     // Catch: java.lang.Exception -> L8b
            com.magneticchen.daijishou.utils.Utils r6 = com.magneticchen.daijishou.utils.Utils.INSTANCE     // Catch: java.lang.Exception -> L8b
            com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment r7 = r10.this$0     // Catch: java.lang.Exception -> L8b
            android.content.SharedPreferences r7 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment.access$getDefaultSharedPreferences(r7)     // Catch: java.lang.Exception -> L8b
            com.magneticchen.daijishou.data.StringPreference r8 = com.magneticchen.daijishou.data.StringPreference.INDEX_URI     // Catch: java.lang.Exception -> L8b
            java.lang.String r8 = r8.getKey()     // Catch: java.lang.Exception -> L8b
            com.magneticchen.daijishou.data.StringPreference r9 = com.magneticchen.daijishou.data.StringPreference.INDEX_URI     // Catch: java.lang.Exception -> L8b
            java.lang.String r9 = r9.getDefaultValue()     // Catch: java.lang.Exception -> L8b
            java.lang.String r7 = r7.getString(r8, r9)     // Catch: java.lang.Exception -> L8b
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch: java.lang.Exception -> L8b
            java.lang.String r6 = r6.readEntireTextFromURL(r7)     // Catch: java.lang.Exception -> L8b
            java.lang.Object r1 = r1.decodeFromString(r5, r6)     // Catch: java.lang.Exception -> L8b
            com.magneticchen.daijishou.data.portables.PlatformsIndexJson r1 = (com.magneticchen.daijishou.data.portables.PlatformsIndexJson) r1     // Catch: java.lang.Exception -> L8b
            com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment.access$setPlatformsIndexJson$p(r11, r1)     // Catch: java.lang.Exception -> L8b
            com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment r11 = r10.this$0     // Catch: java.lang.Exception -> L8b
            com.magneticchen.daijishou.data.portables.PlatformsIndexJson r11 = com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment.access$getPlatformsIndexJson$p(r11)     // Catch: java.lang.Exception -> L8b
            if (r11 == 0) goto La7
            com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment r1 = r10.this$0     // Catch: java.lang.Exception -> L8b
            android.app.Dialog r5 = r10.$dialog     // Catch: java.lang.Exception -> L8b
            kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> L8b
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6     // Catch: java.lang.Exception -> L8b
            com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment$onStart$1$1$1$1 r7 = new com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment$onStart$1$1$1$1     // Catch: java.lang.Exception -> L8b
            r7.<init>(r1, r5, r11, r2)     // Catch: java.lang.Exception -> L8b
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L8b
            r10.label = r4     // Catch: java.lang.Exception -> L8b
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r6, r7, r10)     // Catch: java.lang.Exception -> L8b
            if (r11 != r0) goto L88
            goto La6
        L88:
            kotlin.Unit r11 = (kotlin.Unit) r11     // Catch: java.lang.Exception -> L8b
            goto La7
        L8b:
            r11 = move-exception
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment$onStart$1$1$2 r4 = new com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment$onStart$1$1$2
            com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment r5 = r10.this$0
            r4.<init>(r5, r11, r2)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r11 = r10
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r10.label = r3
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r11)
            if (r11 != r0) goto La7
        La6:
            return r0
        La7:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment$onStart$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment$onStart$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadPlatformsDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformsDialogFragment$onStart$1$1$2", f = "DownloadPlatformsDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Exception $e;
        int label;
        final /* synthetic */ DownloadPlatformsDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DownloadPlatformsDialogFragment downloadPlatformsDialogFragment, Exception exc, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = downloadPlatformsDialogFragment;
            this.$e = exc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Toast.makeText(this.this$0.getContext(), this.$e.toString(), 0).show();
            return Unit.INSTANCE;
        }
    }
}
