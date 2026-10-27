package com.magneticchen.daijishou.data.migration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.BuildConfig;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.portables.MessageJson;
import com.magneticchen.daijishou.data.portables.MessagesIndexJson;
import com.magneticchen.daijishou.utils.Utils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: ForeverUpgradeScript.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u0010H\u0096@¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/data/migration/ForeverUpgradeScript;", "Lcom/magneticchen/daijishou/data/migration/UpgradeScript;", "()V", "toVersion", "", "getToVersion", "()I", "upgradeDescription", "", "getUpgradeDescription", "()Ljava/lang/String;", "upgrade", "", "appCompatActivity", "Landroidx/appcompat/app/AppCompatActivity;", "callback", "Lkotlin/Function1;", "", "(Landroidx/appcompat/app/AppCompatActivity;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ForeverUpgradeScript extends UpgradeScript {
    private final String upgradeDescription = "Checking messages";
    private final int toVersion = 999999999;

    /* JADX INFO: renamed from: com.magneticchen.daijishou.data.migration.ForeverUpgradeScript$upgrade$1, reason: invalid class name */
    /* JADX INFO: compiled from: ForeverUpgradeScript.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.data.migration.ForeverUpgradeScript", f = "ForeverUpgradeScript.kt", i = {0}, l = {52}, m = "upgrade", n = {"callback"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ForeverUpgradeScript.this.upgrade(null, null, this);
        }
    }

    @Override // com.magneticchen.daijishou.data.migration.UpgradeScript
    public String getUpgradeDescription() {
        return this.upgradeDescription;
    }

    @Override // com.magneticchen.daijishou.data.migration.UpgradeScript
    public int getToVersion() {
        return this.toVersion;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.magneticchen.daijishou.data.migration.UpgradeScript
    public Object upgrade(AppCompatActivity appCompatActivity, Function1<? super Boolean, Unit> function1, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Exception exc;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Utils.INSTANCE.isNetworkAvailable((Context) appCompatActivity)) {
                function1.invoke(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
            try {
                MessagesIndexJson messagesIndexJson = (MessagesIndexJson) Json.Default.decodeFromString(MessagesIndexJson.Companion.serializer(), Utils.INSTANCE.readEntireTextFromURL(Constants.messagesIndexUri));
                Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = -1;
                CoroutineContext main = Dispatchers.getMain();
                try {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(intRef, messagesIndexJson, function1, BuildConfig.VERSION_CODE, appCompatActivity, null);
                    anonymousClass1.L$0 = function1;
                    anonymousClass1.label = 1;
                    if (BuildersKt.withContext(main, anonymousClass2, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Exception e) {
                    exc = e;
                    function1 = function1;
                    exc.printStackTrace();
                    function1.invoke(Boxing.boxBoolean(true));
                }
            } catch (Exception e2) {
                e = e2;
                exc = e;
                exc.printStackTrace();
                function1.invoke(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1 = (Function1) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e3) {
                e = e3;
                exc = e;
                exc.printStackTrace();
                function1.invoke(Boxing.boxBoolean(true));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.data.migration.ForeverUpgradeScript$upgrade$2, reason: invalid class name */
    /* JADX INFO: compiled from: ForeverUpgradeScript.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.data.migration.ForeverUpgradeScript$upgrade$2", f = "ForeverUpgradeScript.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AppCompatActivity $appCompatActivity;
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ Ref.IntRef $index;
        final /* synthetic */ MessagesIndexJson $messagesIndexJson;
        final /* synthetic */ int $version;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Ref.IntRef intRef, MessagesIndexJson messagesIndexJson, Function1<? super Boolean, Unit> function1, int i, AppCompatActivity appCompatActivity, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$index = intRef;
            this.$messagesIndexJson = messagesIndexJson;
            this.$callback = function1;
            this.$version = i;
            this.$appCompatActivity = appCompatActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$index, this.$messagesIndexJson, this.$callback, this.$version, this.$appCompatActivity, continuation);
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
            invokeSuspend$nextMessage(this.$index, this.$messagesIndexJson, this.$callback, this.$version, this.$appCompatActivity);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x003a A[Catch: Exception -> 0x00c2, TryCatch #1 {Exception -> 0x00c2, blocks: (B:6:0x001a, B:8:0x002d, B:14:0x004d, B:10:0x003a, B:12:0x0040), top: B:34:0x001a }] */
        /* JADX WARN: Code duplicated, block: B:12:0x0040 A[Catch: Exception -> 0x00c2, TryCatch #1 {Exception -> 0x00c2, blocks: (B:6:0x001a, B:8:0x002d, B:14:0x004d, B:10:0x003a, B:12:0x0040), top: B:34:0x001a }] */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
        
            if (r12 == r0.intValue()) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static final void invokeSuspend$nextMessage(final kotlin.jvm.internal.Ref.IntRef r9, final com.magneticchen.daijishou.data.portables.MessagesIndexJson r10, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r11, final int r12, final androidx.appcompat.app.AppCompatActivity r13) {
            /*
                Method dump skipped, instruction units count: 203
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.data.migration.ForeverUpgradeScript.AnonymousClass2.invokeSuspend$nextMessage(kotlin.jvm.internal.Ref$IntRef, com.magneticchen.daijishou.data.portables.MessagesIndexJson, kotlin.jvm.functions.Function1, int, androidx.appcompat.app.AppCompatActivity):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$nextMessage$lambda$1(MessageJson messageJson, AppCompatActivity appCompatActivity, Ref.IntRef intRef, MessagesIndexJson messagesIndexJson, Function1 function1, int i, DialogInterface dialogInterface, int i2) {
            String acknowledgmentLink = messageJson.getAcknowledgmentLink();
            if (acknowledgmentLink != null) {
                appCompatActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(acknowledgmentLink)));
            }
            invokeSuspend$nextMessage(intRef, messagesIndexJson, function1, i, appCompatActivity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$nextMessage$lambda$4$lambda$3(MessageJson messageJson, Function1 function1, AppCompatActivity appCompatActivity, DialogInterface dialogInterface, int i) {
            String cancelLink = messageJson.getCancelLink();
            if (cancelLink != null) {
                appCompatActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(cancelLink)));
            }
            function1.invoke(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$nextMessage$lambda$7$lambda$6(MessageJson messageJson, AppCompatActivity appCompatActivity, Ref.IntRef intRef, MessagesIndexJson messagesIndexJson, Function1 function1, int i, DialogInterface dialogInterface, int i2) {
            String neutralLink = messageJson.getNeutralLink();
            if (neutralLink != null) {
                appCompatActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(neutralLink)));
            }
            invokeSuspend$nextMessage(intRef, messagesIndexJson, function1, i, appCompatActivity);
        }
    }
}
