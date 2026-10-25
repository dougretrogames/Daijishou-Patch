package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: SnapshotFlow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a?\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0000\u0010\u0002*\u0002H\u0007\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u0002H\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\r\u001a/\u0010\u000e\u001a\u00020\u000f\"\b\b\u0000\u0010\u0002*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0013H\u0002¢\u0006\u0002\b\u0014¨\u0006\u0015"}, d2 = {"snapshotFlow", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "collectAsState", "Landroidx/compose/runtime/State;", "R", "initial", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "intersects", "", "", "Landroidx/compose/runtime/collection/IdentityArraySet;", "other", "", "intersects$SnapshotStateKt__SnapshotFlowKt", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
final /* synthetic */ class SnapshotStateKt__SnapshotFlowKt {
    public static final <T> State<T> collectAsState(StateFlow<? extends T> stateFlow, CoroutineContext coroutineContext, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1439883919);
        ComposerKt.sourceInformation(composer, "C(collectAsState)47@1801L30:SnapshotFlow.kt#9igjgp");
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1439883919, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:47)");
        }
        State<T> stateCollectAsState = SnapshotStateKt.collectAsState(stateFlow, stateFlow.getValue(), coroutineContext2, composer, 520, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateCollectAsState;
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1, reason: invalid class name */
    /* JADX INFO: compiled from: SnapshotFlow.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u0002H\u0003\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Landroidx/compose/runtime/ProduceStateScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1", f = "SnapshotFlow.kt", i = {}, l = {65, 66}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1<R> extends SuspendLambda implements Function2<ProduceStateScope<R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $context;
        final /* synthetic */ Flow<T> $this_collectAsState;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(CoroutineContext coroutineContext, Flow<? extends T> flow, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = coroutineContext;
            this.$this_collectAsState = flow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, this.$this_collectAsState, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProduceStateScope<R> produceStateScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(produceStateScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
        
            if (r1.collect(r2, r6) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r6.$context, new androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.AnonymousClass1.AnonymousClass2(r6.$this_collectAsState, r7, null), r6) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
        
            return r0;
         */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L17:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L59
            L1b:
                kotlin.ResultKt.throwOnFailure(r7)
                java.lang.Object r7 = r6.L$0
                androidx.compose.runtime.ProduceStateScope r7 = (androidx.compose.runtime.ProduceStateScope) r7
                kotlin.coroutines.CoroutineContext r1 = r6.$context
                kotlin.coroutines.EmptyCoroutineContext r4 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
                if (r1 == 0) goto L41
                kotlinx.coroutines.flow.Flow<T> r1 = r6.$this_collectAsState
                androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1 r2 = new androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1
                r2.<init>(r7)
                kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r6.label = r3
                java.lang.Object r7 = r1.collect(r2, r7)
                if (r7 != r0) goto L59
                goto L58
            L41:
                kotlin.coroutines.CoroutineContext r1 = r6.$context
                androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$2 r3 = new androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$2
                kotlinx.coroutines.flow.Flow<T> r4 = r6.$this_collectAsState
                r5 = 0
                r3.<init>(r4, r7, r5)
                kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r6.label = r2
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r7)
                if (r7 != r0) goto L59
            L58:
                return r0
            L59:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SnapshotFlow.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u0002H\u0003\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class C00011<T> implements FlowCollector {
            final /* synthetic */ ProduceStateScope<R> $$this$produceState;

            C00011(ProduceStateScope<R> produceStateScope) {
                this.$$this$produceState = produceStateScope;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T t, Continuation<? super Unit> continuation) {
                this.$$this$produceState.setValue(t);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: SnapshotFlow.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u0002H\u0003\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$2", f = "SnapshotFlow.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProduceStateScope<R> $$this$produceState;
            final /* synthetic */ Flow<T> $this_collectAsState;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Flow<? extends T> flow, ProduceStateScope<R> produceStateScope, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$this_collectAsState = flow;
                this.$$this$produceState = produceStateScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$this_collectAsState, this.$$this$produceState, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$collectAsState$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SnapshotFlow.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u0002H\u0003\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            static final class C00021<T> implements FlowCollector {
                final /* synthetic */ ProduceStateScope<R> $$this$produceState;

                C00021(ProduceStateScope<R> produceStateScope) {
                    this.$$this$produceState = produceStateScope;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, Continuation<? super Unit> continuation) {
                    this.$$this$produceState.setValue(t);
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow<T> flow = this.$this_collectAsState;
                    C00021 c00021 = new C00021(this.$$this$produceState);
                    this.label = 1;
                    if (flow.collect(c00021, this) == coroutine_suspended) {
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
    }

    public static final <T extends R, R> State<R> collectAsState(Flow<? extends T> flow, R r, CoroutineContext coroutineContext, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-606625098);
        ComposerKt.sourceInformation(composer, "C(collectAsState)P(1)62@2343L186:SnapshotFlow.kt#9igjgp");
        if ((i2 & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-606625098, i, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:62)");
        }
        int i3 = i >> 3;
        State<R> stateProduceState = SnapshotStateKt.produceState(r, flow, coroutineContext2, new AnonymousClass1(coroutineContext2, flow, null), composer, (i3 & 8) | 4672 | (i3 & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateProduceState;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SnapshotFlow.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {134, 138, 160}, m = "invokeSuspend", n = {"$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "found", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    static final class C01111<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<T> $block;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01111(Function0<? extends T> function0, Continuation<? super C01111> continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01111 c01111 = new C01111(this.$block, continuation);
            c01111.L$0 = obj;
            return c01111;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
            return ((C01111) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00ca  */
        /* JADX WARN: Code duplicated, block: B:31:0x00d5 A[Catch: all -> 0x0052, TryCatch #1 {all -> 0x0052, blocks: (B:13:0x004d, B:29:0x00d1, B:31:0x00d5, B:36:0x00df, B:39:0x00ed, B:43:0x0103, B:45:0x010c, B:52:0x012a, B:53:0x012d, B:40:0x00f8, B:42:0x0100, B:49:0x0125, B:50:0x0128), top: B:66:0x004d, inners: #4 }] */
        /* JADX WARN: Code duplicated, block: B:35:0x00de  */
        /* JADX WARN: Code duplicated, block: B:39:0x00ed A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #1 {all -> 0x0052, blocks: (B:13:0x004d, B:29:0x00d1, B:31:0x00d5, B:36:0x00df, B:39:0x00ed, B:43:0x0103, B:45:0x010c, B:52:0x012a, B:53:0x012d, B:40:0x00f8, B:42:0x0100, B:49:0x0125, B:50:0x0128), top: B:66:0x004d, inners: #4 }] */
        /* JADX WARN: Code duplicated, block: B:45:0x010c A[Catch: all -> 0x0052, TRY_LEAVE, TryCatch #1 {all -> 0x0052, blocks: (B:13:0x004d, B:29:0x00d1, B:31:0x00d5, B:36:0x00df, B:39:0x00ed, B:43:0x0103, B:45:0x010c, B:52:0x012a, B:53:0x012d, B:40:0x00f8, B:42:0x0100, B:49:0x0125, B:50:0x0128), top: B:66:0x004d, inners: #4 }] */
        /* JADX WARN: Code duplicated, block: B:55:0x012f  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:39:0x00ed, B:54:0x012e], limit reached: 74 */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r10v6 */
        /* JADX WARN: Type inference failed for: r10v8, types: [kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r11v1 */
        /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
        /* JADX WARN: Type inference failed for: r11v5 */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 325
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.C01111.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final <T> Flow<T> snapshotFlow(Function0<? extends T> function0) {
        return FlowKt.flow(new C01111(function0, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean intersects$SnapshotStateKt__SnapshotFlowKt(IdentityArraySet<T> identityArraySet, Set<? extends T> set) {
        if (identityArraySet.size() >= set.size()) {
            if (!(set instanceof IdentityArraySet)) {
                Set<? extends T> set2 = set;
                if ((set2 instanceof Collection) && set2.isEmpty()) {
                    return false;
                }
                Iterator<T> it = set2.iterator();
                while (it.hasNext()) {
                    if (identityArraySet.contains(it.next())) {
                        return true;
                    }
                }
                return false;
            }
            IdentityArraySet identityArraySet2 = (IdentityArraySet) set;
            int size = identityArraySet2.size();
            if (size == 0) {
                return false;
            }
            Object[] values = identityArraySet2.getValues();
            for (int i = 0; i < size; i++) {
                Object obj = values[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                if (identityArraySet.contains(obj)) {
                    return true;
                }
            }
            return false;
        }
        int size2 = identityArraySet.size();
        if (size2 == 0) {
            return false;
        }
        Object[] values2 = identityArraySet.getValues();
        for (int i2 = 0; i2 < size2; i2++) {
            Object obj2 = values2[i2];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            if (set.contains(obj2)) {
                return true;
            }
        }
        return false;
    }
}
