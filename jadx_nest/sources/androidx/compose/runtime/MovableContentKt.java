package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: MovableContent.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\u0007\u001a;\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\u0005\"\u0004\b\u0000\u0010\t2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\n\u001aM\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\u0005\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r2\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\u000e\u001a_\u0010\u0002\u001a\u001f\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0005\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u00102#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\u0011\u001aq\u0010\u0002\u001a%\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0002\b\u0005\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u0010\"\u0004\b\u0003\u0010\u00132)\u0010\u0006\u001a%\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\u0014\u001aE\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017\"\u0004\b\u0000\u0010\u00162\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017¢\u0006\u0002\u0010\n\u001aW\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\t2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017¢\u0006\u0002\u0010\u000e\u001ai\u0010\u0015\u001a$\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\r2(\u0010\u0006\u001a$\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017¢\u0006\u0002\u0010\u0011\u001a{\u0010\u0015\u001a*\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017\"\u0004\b\u0000\u0010\u0016\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u00102.\u0010\u0006\u001a*\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0017¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"movableContentKey", "", "movableContentOf", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "content", "(Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "Lkotlin/Function1;", "P", "(Lkotlin/jvm/functions/Function3;)Lkotlin/jvm/functions/Function3;", "Lkotlin/Function2;", "P1", "P2", "(Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function4;", "Lkotlin/Function3;", "P3", "(Lkotlin/jvm/functions/Function5;)Lkotlin/jvm/functions/Function5;", "Lkotlin/Function4;", "P4", "(Lkotlin/jvm/functions/Function6;)Lkotlin/jvm/functions/Function6;", "movableContentWithReceiverOf", "R", "Lkotlin/ExtensionFunctionType;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MovableContentKt {
    public static final int movableContentKey = 126665345;

    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$1, reason: invalid class name */
    /* JADX INFO: compiled from: MovableContent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ MovableContent<Unit> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MovableContent<Unit> movableContent) {
            super(2);
            this.$movableContent = movableContent;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C:MovableContent.kt#9igjgp");
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-642339857, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:39)");
            }
            composer.insertMovableContent(this.$movableContent, Unit.INSTANCE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final Function2<Composer, Integer, Unit> movableContentOf(Function2<? super Composer, ? super Integer, Unit> function2) {
        return ComposableLambdaKt.composableLambdaInstance(-642339857, true, new AnonymousClass1(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-1079330685, true, new MovableContentKt$movableContentOf$movableContent$1(function2)))));
    }

    /* JADX INFO: Add missing generic type declarations: [P] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$2, reason: invalid class name */
    /* JADX INFO: compiled from: MovableContent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "P", "it", "invoke", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2<P> extends Lambda implements Function3<P, Composer, Integer, Unit> {
        final /* synthetic */ MovableContent<P> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MovableContent<P> movableContent) {
            super(3);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Composer composer, Integer num) {
            invoke(obj, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(P p, Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C:MovableContent.kt#9igjgp");
            if ((i & 14) == 0) {
                i |= composer.changed(p) ? 4 : 2;
            }
            if ((i & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-434707029, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:64)");
            }
            composer.insertMovableContent(this.$movableContent, p);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final <P> Function3<P, Composer, Integer, Unit> movableContentOf(Function3<? super P, ? super Composer, ? super Integer, Unit> function3) {
        return ComposableLambdaKt.composableLambdaInstance(-434707029, true, new AnonymousClass2(new MovableContent(function3)));
    }

    /* JADX INFO: Add missing generic type declarations: [P1, P2] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$3, reason: invalid class name */
    /* JADX INFO: compiled from: MovableContent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u0002H\u0003H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "P1", "P2", "p1", "p2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass3<P1, P2> extends Lambda implements Function4<P1, P2, Composer, Integer, Unit> {
        final /* synthetic */ MovableContent<Pair<P1, P2>> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(MovableContent<Pair<P1, P2>> movableContent) {
            super(4);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2, Composer composer, Integer num) {
            invoke(obj, obj2, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(P1 p1, P2 p2, Composer composer, int i) {
            int i2;
            ComposerKt.sourceInformation(composer, "C:MovableContent.kt#9igjgp");
            if ((i & 14) == 0) {
                i2 = (composer.changed(p1) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 112) == 0) {
                i2 |= composer.changed(p2) ? 32 : 16;
            }
            if ((i2 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1200019734, i2, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:89)");
            }
            composer.insertMovableContent(this.$movableContent, TuplesKt.to(p1, p2));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final <P1, P2> Function4<P1, P2, Composer, Integer, Unit> movableContentOf(Function4<? super P1, ? super P2, ? super Composer, ? super Integer, Unit> function4) {
        return ComposableLambdaKt.composableLambdaInstance(-1200019734, true, new AnonymousClass3(new MovableContent(ComposableLambdaKt.composableLambdaInstance(1849814513, true, new MovableContentKt$movableContentOf$movableContent$2(function4)))));
    }

    public static final <P1, P2, P3> Function5<P1, P2, P3, Composer, Integer, Unit> movableContentOf(Function5<? super P1, ? super P2, ? super P3, ? super Composer, ? super Integer, Unit> function5) {
        return ComposableLambdaKt.composableLambdaInstance(-1083870185, true, new AnonymousClass4(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-284417101, true, new MovableContentKt$movableContentOf$movableContent$3(function5)))));
    }

    /* JADX INFO: Add missing generic type declarations: [P1, P2, P3] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$4, reason: invalid class name */
    /* JADX INFO: compiled from: MovableContent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u00032\u0006\u0010\u0007\u001a\u0002H\u0004H\u000b¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "P1", "P2", "P3", "p1", "p2", "p3", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass4<P1, P2, P3> extends Lambda implements Function5<P1, P2, P3, Composer, Integer, Unit> {
        final /* synthetic */ MovableContent<Pair<Pair<P1, P2>, P3>> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(MovableContent<Pair<Pair<P1, P2>, P3>> movableContent) {
            super(5);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2, Object obj3, Composer composer, Integer num) {
            invoke(obj, obj2, obj3, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(P1 p1, P2 p2, P3 p3, Composer composer, int i) {
            int i2;
            ComposerKt.sourceInformation(composer, "C:MovableContent.kt#9igjgp");
            if ((i & 14) == 0) {
                i2 = (composer.changed(p1) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 112) == 0) {
                i2 |= composer.changed(p2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                i2 |= composer.changed(p3) ? 256 : 128;
            }
            if ((i2 & 5851) == 1170 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1083870185, i2, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:118)");
            }
            composer.insertMovableContent(this.$movableContent, TuplesKt.to(TuplesKt.to(p1, p2), p3));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final <P1, P2, P3, P4> Function6<P1, P2, P3, P4, Composer, Integer, Unit> movableContentOf(Function6<? super P1, ? super P2, ? super P3, ? super P4, ? super Composer, ? super Integer, Unit> function6) {
        return ComposableLambdaKt.composableLambdaInstance(-1741877681, true, new AnonymousClass5(new MovableContent(ComposableLambdaKt.composableLambdaInstance(1876318581, true, new MovableContentKt$movableContentOf$movableContent$4(function6)))));
    }

    /* JADX INFO: Add missing generic type declarations: [P1, P2, P3, P4] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentOf$5, reason: invalid class name */
    /* JADX INFO: compiled from: MovableContent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u00032\u0006\u0010\b\u001a\u0002H\u00042\u0006\u0010\t\u001a\u0002H\u0005H\u000b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"<anonymous>", "", "P1", "P2", "P3", "P4", "p1", "p2", "p3", "p4", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass5<P1, P2, P3, P4> extends Lambda implements Function6<P1, P2, P3, P4, Composer, Integer, Unit> {
        final /* synthetic */ MovableContent<Pair<Pair<P1, P2>, Pair<P3, P4>>> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(MovableContent<Pair<Pair<P1, P2>, Pair<P3, P4>>> movableContent) {
            super(6);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2, Object obj3, Object obj4, Composer composer, Integer num) {
            invoke(obj, obj2, obj3, obj4, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(P1 p1, P2 p2, P3 p3, P4 p4, Composer composer, int i) {
            int i2;
            ComposerKt.sourceInformation(composer, "C:MovableContent.kt#9igjgp");
            if ((i & 14) == 0) {
                i2 = (composer.changed(p1) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 112) == 0) {
                i2 |= composer.changed(p2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                i2 |= composer.changed(p3) ? 256 : 128;
            }
            if ((i & 7168) == 0) {
                i2 |= composer.changed(p4) ? 2048 : 1024;
            }
            if ((46811 & i2) == 9362 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1741877681, i2, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:147)");
            }
            composer.insertMovableContent(this.$movableContent, TuplesKt.to(TuplesKt.to(p1, p2), TuplesKt.to(p3, p4)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MovableContent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0002H\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "R", "invoke", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01001<R> extends Lambda implements Function3<R, Composer, Integer, Unit> {
        final /* synthetic */ MovableContent<R> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01001(MovableContent<R> movableContent) {
            super(3);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Composer composer, Integer num) {
            invoke(obj, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(R r, Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C:MovableContent.kt#9igjgp");
            if ((i & 14) == 0) {
                i |= composer.changed(r) ? 4 : 2;
            }
            if ((i & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(506997506, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:172)");
            }
            composer.insertMovableContent(this.$movableContent, r);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final <R> Function3<R, Composer, Integer, Unit> movableContentWithReceiverOf(Function3<? super R, ? super Composer, ? super Integer, Unit> function3) {
        return ComposableLambdaKt.composableLambdaInstance(506997506, true, new C01001(new MovableContent(ComposableLambdaKt.composableLambdaInstance(250838178, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$1(function3)))));
    }

    /* JADX INFO: Add missing generic type declarations: [P, R] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MovableContent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0003H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", "P", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01012<P, R> extends Lambda implements Function4<R, P, Composer, Integer, Unit> {
        final /* synthetic */ MovableContent<Pair<R, P>> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01012(MovableContent<Pair<R, P>> movableContent) {
            super(4);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2, Composer composer, Integer num) {
            invoke(obj, obj2, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(R r, P p, Composer composer, int i) {
            int i2;
            ComposerKt.sourceInformation(composer, "C:MovableContent.kt#9igjgp");
            if ((i & 14) == 0) {
                i2 = (composer.changed(r) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 112) == 0) {
                i2 |= composer.changed(p) ? 32 : 16;
            }
            if ((i2 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(627354118, i2, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:199)");
            }
            composer.insertMovableContent(this.$movableContent, TuplesKt.to(r, p));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final <R, P> Function4<R, P, Composer, Integer, Unit> movableContentWithReceiverOf(Function4<? super R, ? super P, ? super Composer, ? super Integer, Unit> function4) {
        return ComposableLambdaKt.composableLambdaInstance(627354118, true, new C01012(new MovableContent(ComposableLambdaKt.composableLambdaInstance(812082854, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$2(function4)))));
    }

    public static final <R, P1, P2> Function5<R, P1, P2, Composer, Integer, Unit> movableContentWithReceiverOf(Function5<? super R, ? super P1, ? super P2, ? super Composer, ? super Integer, Unit> function5) {
        return ComposableLambdaKt.composableLambdaInstance(583402949, true, new C01023(new MovableContent(ComposableLambdaKt.composableLambdaInstance(-1322148760, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$3(function5)))));
    }

    /* JADX INFO: Add missing generic type declarations: [P1, R, P2] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MovableContent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u0002H\u00022\u0006\u0010\u0005\u001a\u0002H\u00032\u0006\u0010\u0006\u001a\u0002H\u0004H\u000b¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "R", "P1", "P2", "p1", "p2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01023<P1, P2, R> extends Lambda implements Function5<R, P1, P2, Composer, Integer, Unit> {
        final /* synthetic */ MovableContent<Pair<Pair<R, P1>, P2>> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01023(MovableContent<Pair<Pair<R, P1>, P2>> movableContent) {
            super(5);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2, Object obj3, Composer composer, Integer num) {
            invoke(obj, obj2, obj3, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(R r, P1 p1, P2 p2, Composer composer, int i) {
            int i2;
            ComposerKt.sourceInformation(composer, "C:MovableContent.kt#9igjgp");
            if ((i & 14) == 0) {
                i2 = (composer.changed(r) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 112) == 0) {
                i2 |= composer.changed(p1) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                i2 |= composer.changed(p2) ? 256 : 128;
            }
            if ((i2 & 5851) == 1170 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(583402949, i2, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:228)");
            }
            composer.insertMovableContent(this.$movableContent, TuplesKt.to(TuplesKt.to(r, p1), p2));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final <R, P1, P2, P3> Function6<R, P1, P2, P3, Composer, Integer, Unit> movableContentWithReceiverOf(Function6<? super R, ? super P1, ? super P2, ? super P3, ? super Composer, ? super Integer, Unit> function6) {
        return ComposableLambdaKt.composableLambdaInstance(1468683306, true, new C01034(new MovableContent(ComposableLambdaKt.composableLambdaInstance(838586922, true, new MovableContentKt$movableContentWithReceiverOf$movableContent$4(function6)))));
    }

    /* JADX INFO: Add missing generic type declarations: [P1, R, P2, P3] */
    /* JADX INFO: renamed from: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MovableContent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005*\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u00032\u0006\u0010\u0007\u001a\u0002H\u00042\u0006\u0010\b\u001a\u0002H\u0005H\u000b¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "R", "P1", "P2", "P3", "p1", "p2", "p3", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01034<P1, P2, P3, R> extends Lambda implements Function6<R, P1, P2, P3, Composer, Integer, Unit> {
        final /* synthetic */ MovableContent<Pair<Pair<R, P1>, Pair<P2, P3>>> $movableContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01034(MovableContent<Pair<Pair<R, P1>, Pair<P2, P3>>> movableContent) {
            super(6);
            this.$movableContent = movableContent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2, Object obj3, Object obj4, Composer composer, Integer num) {
            invoke(obj, obj2, obj3, obj4, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(R r, P1 p1, P2 p2, P3 p3, Composer composer, int i) {
            int i2;
            ComposerKt.sourceInformation(composer, "C:MovableContent.kt#9igjgp");
            if ((i & 14) == 0) {
                i2 = (composer.changed(r) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 112) == 0) {
                i2 |= composer.changed(p1) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                i2 |= composer.changed(p2) ? 256 : 128;
            }
            if ((i & 7168) == 0) {
                i2 |= composer.changed(p3) ? 2048 : 1024;
            }
            if ((46811 & i2) == 9362 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1468683306, i2, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:257)");
            }
            composer.insertMovableContent(this.$movableContent, TuplesKt.to(TuplesKt.to(r, p1), TuplesKt.to(p2, p3)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }
}
