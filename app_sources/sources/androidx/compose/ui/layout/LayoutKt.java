package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import com.magneticchen.daijishou.application_data.Constants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: Layout.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a8\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0087\b¢\u0006\u0002\u0010\n\u001a \u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0087\b¢\u0006\u0002\u0010\u000b\u001a>\u0010\u0000\u001a\u00020\u00012\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00050\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000eH\u0087\b¢\u0006\u0002\u0010\u000f\u001a7\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0011\u001a;\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00050\rH\u0001¢\u0006\u0002\u0010\u0013\u001a3\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a3\u0010\u001b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0014\u0010\u001a¨\u0006\u001c"}, d2 = {"Layout", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "contents", "", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MultiContentMeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "MultiMeasureLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "combineAsVirtualLayouts", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "materializerOf", "Lkotlin/Function1;", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "Lkotlin/ExtensionFunctionType;", "modifierMaterializerOf", "(Landroidx/compose/ui/Modifier;)Lkotlin/jvm/functions/Function3;", "materializerOfWithCompositionLocalInjection", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LayoutKt {

    /* INFO: renamed from: androidx.compose.ui.layout.LayoutKt$MultiMeasureLayout$2, reason: invalid class name */
    /* INFO: compiled from: Layout.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ MeasurePolicy $measurePolicy;
        final /* synthetic */ Modifier $modifier;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, MeasurePolicy measurePolicy, int i, int i2) {
            super(2);
            this.$modifier = modifier;
            this.$content = function2;
            this.$measurePolicy = measurePolicy;
            this.$$changed = i;
            this.$$default = i2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            LayoutKt.MultiMeasureLayout(this.$modifier, this.$content, this.$measurePolicy, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    public static final void Layout(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, MeasurePolicy measurePolicy, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        if ((i2 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = modifierMaterializerOf(modifier);
        int i3 = ((i << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM60constructorimpl = Updater.m60constructorimpl(composer);
        Updater.m67setimpl(composerM60constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m67setimpl(composerM60constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM60constructorimpl.getInserting() || !Intrinsics.areEqual(composerM60constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        function3ModifierMaterializerOf.invoke(SkippableUpdater.m51boximpl(SkippableUpdater.m52constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i3 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
    }

    public static final void Layout(Modifier modifier, MeasurePolicy measurePolicy, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(544976794);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(1)122@4734L23,125@4885L385:Layout.kt#80mrfh");
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        composer.startReplaceableGroup(1405779621);
        ComposerKt.sourceInformation(composer, "CC(ReusableComposeNode):Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(new LayoutKt$Layout$$inlined$ReusableComposeNode$1(constructor));
        } else {
            composer.useNode();
        }
        Composer composerM60constructorimpl = Updater.m60constructorimpl(composer);
        Updater.m67setimpl(composerM60constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m67setimpl(composerM60constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m67setimpl(composerM60constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM60constructorimpl.getInserting() || !Intrinsics.areEqual(composerM60constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final void Layout(List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Modifier modifier, MultiContentMeasurePolicy multiContentMeasurePolicy, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1399185516);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)171@6874L62,168@6760L182:Layout.kt#80mrfh");
        if ((i2 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = combineAsVirtualLayouts(list);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(multiContentMeasurePolicy);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = modifierMaterializerOf(modifier);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM60constructorimpl = Updater.m60constructorimpl(composer);
        Updater.m67setimpl(composerM60constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m67setimpl(composerM60constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM60constructorimpl.getInserting() || !Intrinsics.areEqual(composerM60constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        function3ModifierMaterializerOf.invoke(SkippableUpdater.m51boximpl(SkippableUpdater.m52constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        function2CombineAsVirtualLayouts.invoke(composer, 0);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    /* INFO: renamed from: androidx.compose.ui.layout.LayoutKt$combineAsVirtualLayouts$1, reason: invalid class name */
    /* INFO: compiled from: Layout.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ List<Function2<Composer, Integer, Unit>> $contents;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass1(List<? extends Function2<? super Composer, ? super Integer, Unit>> list) {
            super(2);
            this.$contents = list;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C*180@7168L23,181@7200L298:Layout.kt#80mrfh");
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1953651383, i, -1, "androidx.compose.ui.layout.combineAsVirtualLayouts.<anonymous> (Layout.kt:179)");
                }
                List<Function2<Composer, Integer, Unit>> list = this.$contents;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Function2<Composer, Integer, Unit> function2 = list.get(i2);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    Function0<ComposeUiNode> virtualConstructor = ComposeUiNode.INSTANCE.getVirtualConstructor();
                    composer.startReplaceableGroup(-692256719);
                    ComposerKt.sourceInformation(composer, "CC(ReusableComposeNode)P(1,2)372@13941L9:Composables.kt#9igjgp");
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(virtualConstructor);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM60constructorimpl = Updater.m60constructorimpl(composer);
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM60constructorimpl.getInserting() || !Intrinsics.areEqual(composerM60constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    function2.invoke(composer, 0);
                    composer.endNode();
                    composer.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    public static final Function2<Composer, Integer, Unit> combineAsVirtualLayouts(List<? extends Function2<? super Composer, ? super Integer, Unit>> list) {
        return ComposableLambdaKt.composableLambdaInstance(-1953651383, true, new AnonymousClass1(list));
    }

    /* INFO: renamed from: androidx.compose.ui.layout.LayoutKt$materializerOf$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: Layout.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "invoke-Deg8D_g", "(Landroidx/compose/runtime/Composer;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01211 extends Lambda implements Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> {
        final /* synthetic */ Modifier $modifier;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01211(Modifier modifier) {
            super(3);
            this.$modifier = modifier;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(SkippableUpdater<ComposeUiNode> skippableUpdater, Composer composer, Integer num) {
            m1838invokeDeg8D_g(skippableUpdater.getComposer(), composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke-Deg8D_g, reason: not valid java name */
        public final void m1838invokeDeg8D_g(Composer composer, Composer composer2, int i) {
            ComposerKt.sourceInformation(composer2, "C202@7952L23:Layout.kt#80mrfh");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1586257396, i, -1, "androidx.compose.ui.layout.materializerOf.<anonymous> (Layout.kt:202)");
            }
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, this.$modifier);
            composer.startReplaceableGroup(509942095);
            Composer composerM60constructorimpl = Updater.m60constructorimpl(composer);
            Updater.m67setimpl(composerM60constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM60constructorimpl.getInserting() || !Intrinsics.areEqual(composerM60constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf(Modifier modifier) {
        return ComposableLambdaKt.composableLambdaInstance(-1586257396, true, new C01211(modifier));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Needed only for backwards compatibility. Do not use.")
    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf(Modifier modifier) {
        return ComposableLambdaKt.composableLambdaInstance(-55743822, true, new LayoutKt$materializerOfWithCompositionLocalInjection$1(modifier));
    }

    @Deprecated(message = "This API is unsafe for UI performance at scale - using it incorrectly will lead to exponential performance issues. This API should be avoided whenever possible.")
    public static final void MultiMeasureLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, MeasurePolicy measurePolicy, Composer composer, int i, int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1949933075);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MultiMeasureLayout)P(2)246@9516L23,250@9668L491:Layout.kt#80mrfh");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= Constants.appIconsCacheSize;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(measurePolicy) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1949933075, i3, -1, "androidx.compose.ui.layout.MultiMeasureLayout (Layout.kt:245)");
            }
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Function0<LayoutNode> constructor$ui_release = LayoutNode.INSTANCE.getConstructor$ui_release();
            int i5 = ((i3 << 3) & 896) | 6;
            composerStartRestartGroup.startReplaceableGroup(-692256719);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode)P(1,2)372@13941L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor$ui_release);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM60constructorimpl = Updater.m60constructorimpl(composerStartRestartGroup);
            Updater.m67setimpl(composerM60constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m67setimpl(composerM60constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m64initimpl(composerM60constructorimpl, LayoutKt$MultiMeasureLayout$1$1.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM60constructorimpl.getInserting() || !Intrinsics.areEqual(composerM60constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 6) & 14));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier2, function2, measurePolicy, i, i2));
        }
    }
}
