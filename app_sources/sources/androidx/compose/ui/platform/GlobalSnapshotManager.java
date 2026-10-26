package androidx.compose.ui.platform;

import androidx.compose.runtime.snapshots.Snapshot;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* INFO: compiled from: GlobalSnapshotManager.android.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/GlobalSnapshotManager;", "", "()V", "sent", "Ljava/util/concurrent/atomic/AtomicBoolean;", "started", "ensureStarted", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GlobalSnapshotManager {
    public static final GlobalSnapshotManager INSTANCE = new GlobalSnapshotManager();
    private static final AtomicBoolean started = new AtomicBoolean(false);
    private static final AtomicBoolean sent = new AtomicBoolean(false);
    public static final int $stable = 8;

    private GlobalSnapshotManager() {
    }

    public final void ensureStarted() {
        if (started.compareAndSet(false, true)) {
            Channel channelChannel$default = ChannelKt.Channel$default(1, null, null, 6, null);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(AndroidUiDispatcher.INSTANCE.getMain()), null, null, new AnonymousClass1(channelChannel$default, null), 3, null);
            Snapshot.INSTANCE.registerGlobalWriteObserver(new AnonymousClass2(channelChannel$default));
        }
    }

    /* INFO: renamed from: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1, reason: invalid class name */
    /* INFO: compiled from: GlobalSnapshotManager.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$1", f = "GlobalSnapshotManager.android.kt", i = {0}, l = {67}, m = "invokeSuspend", n = {"$this$consume$iv$iv"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Unit> $channel;
        Object L$0;
        Object L$1;
        int label;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Channel<Unit> channel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$channel = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$channel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* WARN: Code duplicated, block: B:14:0x0039 A[RETURN] */
        /* WARN: Code duplicated, block: B:17:0x0042 A[Catch: all -> 0x005e, TryCatch #1 {all -> 0x005e, blocks: (B:6:0x0014, B:15:0x003a, B:17:0x0042, B:12:0x002d, B:18:0x0056, B:11:0x0028), top: B:28:0x0008 }] */
        /* WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0037 -> B:15:0x003a). Please report as a decompilation issue!!! */
        /* ERROR: decompilerOverflowException in pass: RegionMakerVisitor
            decompiler.core.utils.exceptions.decompilerOverflowException: Regions stack size limit reached
            	at decompiler.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at decompiler.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at decompiler.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 != r3) goto L18
                java.lang.Object r1 = r6.L$1
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r6.L$0
                kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
                kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L5e
                goto L3a
            L18:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L20:
                kotlin.ResultKt.throwOnFailure(r7)
                kotlinx.coroutines.channels.Channel<kotlin.Unit> r7 = r6.$channel
                r4 = r7
                kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
                kotlinx.coroutines.channels.ChannelIterator r7 = r4.iterator()     // Catch: java.lang.Throwable -> L5e
                r1 = r7
            L2d:
                r6.L$0 = r4     // Catch: java.lang.Throwable -> L5e
                r6.L$1 = r1     // Catch: java.lang.Throwable -> L5e
                r6.label = r3     // Catch: java.lang.Throwable -> L5e
                java.lang.Object r7 = r1.hasNext(r6)     // Catch: java.lang.Throwable -> L5e
                if (r7 != r0) goto L3a
                return r0
            L3a:
                java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L5e
                boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> L5e
                if (r7 == 0) goto L56
                java.lang.Object r7 = r1.next()     // Catch: java.lang.Throwable -> L5e
                kotlin.Unit r7 = (kotlin.Unit) r7     // Catch: java.lang.Throwable -> L5e
                java.util.concurrent.atomic.AtomicBoolean r7 = androidx.compose.ui.platform.GlobalSnapshotManager.access$getSent$p()     // Catch: java.lang.Throwable -> L5e
                r5 = 0
                r7.set(r5)     // Catch: java.lang.Throwable -> L5e
                androidx.compose.runtime.snapshots.Snapshot$Companion r7 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L5e
                r7.sendApplyNotifications()     // Catch: java.lang.Throwable -> L5e
                goto L2d
            L56:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L5e
                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r2)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            L5e:
                r7 = move-exception
                throw r7     // Catch: java.lang.Throwable -> L60
            L60:
                r0 = move-exception
                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r4, r7)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.GlobalSnapshotManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* INFO: renamed from: androidx.compose.ui.platform.GlobalSnapshotManager$ensureStarted$2, reason: invalid class name */
    /* INFO: compiled from: GlobalSnapshotManager.android.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function1<Object, Unit> {
        final /* synthetic */ Channel<Unit> $channel;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Channel<Unit> channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            if (GlobalSnapshotManager.sent.compareAndSet(false, true)) {
                this.$channel.mo5255trySendJP2dKIU(Unit.INSTANCE);
            }
        }
    }
}
