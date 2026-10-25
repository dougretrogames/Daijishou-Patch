package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: TestModifierUpdater.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"TestModifierUpdaterLayout", "", "onAttached", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/TestModifierUpdater;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TestModifierUpdaterKt {

    /* JADX INFO: renamed from: androidx.compose.ui.layout.TestModifierUpdaterKt$TestModifierUpdaterLayout$2, reason: invalid class name */
    /* JADX INFO: compiled from: TestModifierUpdater.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ Function1<TestModifierUpdater, Unit> $onAttached;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super TestModifierUpdater, Unit> function1, int i) {
            super(2);
            this.$onAttached = function1;
            this.$$changed = i;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            TestModifierUpdaterKt.TestModifierUpdaterLayout(this.$onAttached, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "It is a test API, do not use it in the real applications")
    public static final void TestModifierUpdaterLayout(Function1<? super TestModifierUpdater, Unit> function1, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1673066036);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TestModifierUpdaterLayout)50@1816L23,54@1971L330:TestModifierUpdater.kt#80mrfh");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1673066036, i2, -1, "androidx.compose.ui.layout.TestModifierUpdaterLayout (TestModifierUpdater.kt:49)");
            }
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1 testModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1 = TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.INSTANCE;
            Function0<LayoutNode> constructor$ui_release = LayoutNode.INSTANCE.getConstructor$ui_release();
            composerStartRestartGroup.startReplaceableGroup(1886828752);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(new TestModifierUpdaterKt$TestModifierUpdaterLayout$$inlined$ComposeNode$1(constructor$ui_release));
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM60constructorimpl = Updater.m60constructorimpl(composerStartRestartGroup);
            Updater.m67setimpl(composerM60constructorimpl, testModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM60constructorimpl.getInserting() || !Intrinsics.areEqual(composerM60constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m64initimpl(composerM60constructorimpl, new TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1(function1));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(function1, i));
        }
    }
}
