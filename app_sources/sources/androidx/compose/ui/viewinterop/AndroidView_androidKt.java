package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.UiApplier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.magneticchen.daijishou.application_data.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: AndroidView.android.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ay\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u00012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001aK\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a1\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u0001H\u0003¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\b0\u0017\"\b\b\u0000\u0010\b*\u00020\u0002*\u00020\u0014H\u0002\u001a^\u0010\u0018\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00140\u00192\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'\"\"\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"NoOpUpdate", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "AndroidView", ExifInterface.GPS_DIRECTION_TRUE, "factory", "Landroid/content/Context;", "modifier", "Landroidx/compose/ui/Modifier;", "onReset", "onRelease", ConfigConstants.CONFIG_KEY_UPDATE, "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "createAndroidViewNodeFactory", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "requireViewFactoryHolder", "Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "updateViewHolderParams", "Landroidx/compose/runtime/Updater;", "compositeKeyHash", "", "density", "Landroidx/compose/ui/unit/Density;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "compositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "updateViewHolderParams-6NefGtU", "(Landroidx/compose/runtime/Composer;Landroidx/compose/ui/Modifier;ILandroidx/compose/ui/unit/Density;Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/runtime/CompositionLocalMap;)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidView_androidKt {
    private static final Function1<View, Unit> NoOpUpdate = AndroidView_androidKt$NoOpUpdate$1.INSTANCE;

    /* INFO: renamed from: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1, reason: invalid class name */
    /* INFO: compiled from: AndroidView.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Function1<Context, T> $factory;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Function1<T, Unit> $update;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super Context, ? extends T> function1, Modifier modifier, Function1<? super T, Unit> function2, int i, int i2) {
            super(2);
            this.$factory = function1;
            this.$modifier = modifier;
            this.$update = function2;
            this.$$changed = i;
            this.$$default = i2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            AndroidView_androidKt.AndroidView(this.$factory, this.$modifier, this.$update, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* INFO: renamed from: androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4, reason: invalid class name */
    /* INFO: compiled from: AndroidView.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass4 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Function1<Context, T> $factory;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Function1<T, Unit> $onRelease;
        final /* synthetic */ Function1<T, Unit> $onReset;
        final /* synthetic */ Function1<T, Unit> $update;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass4(Function1<? super Context, ? extends T> function1, Modifier modifier, Function1<? super T, Unit> function2, Function1<? super T, Unit> function3, Function1<? super T, Unit> function4, int i, int i2) {
            super(2);
            this.$factory = function1;
            this.$modifier = modifier;
            this.$onReset = function2;
            this.$onRelease = function3;
            this.$update = function4;
            this.$$changed = i;
            this.$$default = i2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            AndroidView_androidKt.AndroidView(this.$factory, this.$modifier, this.$onReset, this.$onRelease, this.$update, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    public static final <T extends View> void AndroidView(Function1<? super Context, ? extends T> function1, Modifier modifier, Function1<? super T, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        Function1<? super T, Unit> function3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1783766393);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AndroidView)107@5478L130:AndroidView.android.kt#z33iqn");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= Constants.appIconsCacheSize;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (i5 != 0) {
                function2 = NoOpUpdate;
            }
            Function1<? super T, Unit> function4 = function2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1783766393, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:106)");
            }
            AndroidView(function1, modifier3, null, NoOpUpdate, function4, composerStartRestartGroup, (i3 & 14) | 3072 | (i3 & 112) | (57344 & (i3 << 6)), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            function3 = function4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            function3 = function2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(function1, modifier2, function3, i, i2));
        }
    }

    /* WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* WARN: Code duplicated, block: B:26:0x0049  */
    /* WARN: Code duplicated, block: B:27:0x004c  */
    /* WARN: Code duplicated, block: B:29:0x0050  */
    /* WARN: Code duplicated, block: B:31:0x0058  */
    /* WARN: Code duplicated, block: B:32:0x005b  */
    /* WARN: Code duplicated, block: B:37:0x0065  */
    /* WARN: Code duplicated, block: B:38:0x0068  */
    /* WARN: Code duplicated, block: B:40:0x006c  */
    /* WARN: Code duplicated, block: B:42:0x0074  */
    /* WARN: Code duplicated, block: B:43:0x0077  */
    /* WARN: Code duplicated, block: B:48:0x0081  */
    /* WARN: Code duplicated, block: B:49:0x0084  */
    /* WARN: Code duplicated, block: B:51:0x008a  */
    /* WARN: Code duplicated, block: B:53:0x0092  */
    /* WARN: Code duplicated, block: B:54:0x0095  */
    /* WARN: Code duplicated, block: B:59:0x00a3  */
    /* WARN: Code duplicated, block: B:64:0x00b2 A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:65:0x00b4  */
    /* WARN: Code duplicated, block: B:66:0x00b9  */
    /* WARN: Code duplicated, block: B:68:0x00bc  */
    /* WARN: Code duplicated, block: B:70:0x00c0  */
    /* WARN: Code duplicated, block: B:72:0x00c5  */
    /* WARN: Code duplicated, block: B:75:0x00ce  */
    /* WARN: Code duplicated, block: B:78:0x0138  */
    /* WARN: Code duplicated, block: B:80:0x015c  */
    /* WARN: Code duplicated, block: B:83:0x0168  */
    /* WARN: Code duplicated, block: B:84:0x0173  */
    /* WARN: Code duplicated, block: B:86:0x019c  */
    /* WARN: Code duplicated, block: B:88:0x01c0  */
    /* WARN: Code duplicated, block: B:91:0x01cc  */
    /* WARN: Code duplicated, block: B:92:0x01d7  */
    /* WARN: Code duplicated, block: B:96:0x01fe  */
    /* WARN: Code duplicated, block: B:99:0x0209  */
    public static final <T extends View> void AndroidView(Function1<? super Context, ? extends T> function1, Modifier modifier, Function1<? super T, Unit> function2, Function1<? super T, Unit> function3, Function1<? super T, Unit> function4, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function1<? super T, Unit> function5;
        int i5;
        int i6;
        Function1<? super T, Unit> function6;
        int i7;
        int i8;
        Function1<? super T, Unit> function7;
        int i9;
        Modifier.Companion companion;
        int currentCompositeKeyHash;
        Modifier modifierMaterializeModifier;
        Density density;
        LayoutDirection layoutDirection;
        CompositionLocalMap currentCompositionLocalMap;
        LifecycleOwner lifecycleOwner;
        SavedStateRegistryOwner savedStateRegistryOwner;
        Function0<LayoutNode> function0CreateAndroidViewNodeFactory;
        Function0<LayoutNode> function0CreateAndroidViewNodeFactory2;
        Function1<? super T, Unit> function8;
        Function1<? super T, Unit> function9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-180024211);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AndroidView)P(!2,3)211@11894L23,213@12018L7,214@12073L7,221@12529L7,222@12600L7:AndroidView.android.kt#z33iqn");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    function5 = function2;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        function6 = function3;
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((57344 & i) == 0) {
                            function7 = function4;
                            if (composerStartRestartGroup.changedInstance(function7)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((46811 & i3) == 9362 || !composerStartRestartGroup.getSkipping()) {
                            if (i10 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = NoOpUpdate;
                            }
                            if (i8 != 0) {
                                function7 = NoOpUpdate;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                            }
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            layoutDirection = (LayoutDirection) objConsume2;
                            currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composerStartRestartGroup.consume(localLifecycleOwner);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            lifecycleOwner = (LifecycleOwner) objConsume3;
                            ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composerStartRestartGroup.consume(localSavedStateRegistryOwner);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume4;
                            if (function5 != null) {
                                composerStartRestartGroup.startReplaceableGroup(-88753355);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                                function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                                composerStartRestartGroup.startReplaceableGroup(1405779621);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                Composer composerM60constructorimpl = Updater.m60constructorimpl(composerStartRestartGroup);
                                m3131updateViewHolderParams6NefGtU(composerM60constructorimpl, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                                Updater.m67setimpl(composerM60constructorimpl, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                                Updater.m67setimpl(composerM60constructorimpl, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                                Updater.m67setimpl(composerM60constructorimpl, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                                composerStartRestartGroup.endNode();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                            } else {
                                composerStartRestartGroup.startReplaceableGroup(-88752490);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                                function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                                composerStartRestartGroup.startReplaceableGroup(1886828752);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composerStartRestartGroup.startNode();
                                if (composerStartRestartGroup.getInserting()) {
                                    composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                                } else {
                                    composerStartRestartGroup.useNode();
                                }
                                Composer composerM60constructorimpl2 = Updater.m60constructorimpl(composerStartRestartGroup);
                                m3131updateViewHolderParams6NefGtU(composerM60constructorimpl2, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                                Updater.m67setimpl(composerM60constructorimpl2, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                                Updater.m67setimpl(composerM60constructorimpl2, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                                composerStartRestartGroup.endNode();
                                composerStartRestartGroup.endReplaceableGroup();
                                composerStartRestartGroup.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            companion = modifier2;
                        }
                        function8 = function5;
                        function9 = function7;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
                        }
                    }
                    i3 |= 24576;
                    function7 = function4;
                    if ((46811 & i3) == 9362) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            function7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume5 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume5;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        layoutDirection = (LayoutDirection) objConsume6;
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner2 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume7 = composerStartRestartGroup.consume(localLifecycleOwner2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        lifecycleOwner = (LifecycleOwner) objConsume7;
                        ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner2 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume8 = composerStartRestartGroup.consume(localSavedStateRegistryOwner2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume8;
                        if (function5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753355);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                            function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl3 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl3, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl3, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl3, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl3, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752490);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                            function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl4 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl4, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl4, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl4, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            function7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume9 = composerStartRestartGroup.consume(localDensity3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume9;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume10 = composerStartRestartGroup.consume(localLayoutDirection3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        layoutDirection = (LayoutDirection) objConsume10;
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner3 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume11 = composerStartRestartGroup.consume(localLifecycleOwner3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        lifecycleOwner = (LifecycleOwner) objConsume11;
                        ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner3 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume12 = composerStartRestartGroup.consume(localSavedStateRegistryOwner3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume12;
                        if (function5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753355);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                            function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl5 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl5, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl5, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl5, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl5, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752490);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                            function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl6 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl6, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl6, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl6, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    function8 = function5;
                    function9 = function7;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
                    }
                }
                i3 |= 3072;
                function6 = function3;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        function7 = function4;
                        if (composerStartRestartGroup.changedInstance(function7)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((46811 & i3) == 9362) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            function7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume13 = composerStartRestartGroup.consume(localDensity4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume13;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume14 = composerStartRestartGroup.consume(localLayoutDirection4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        layoutDirection = (LayoutDirection) objConsume14;
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner4 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume15 = composerStartRestartGroup.consume(localLifecycleOwner4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        lifecycleOwner = (LifecycleOwner) objConsume15;
                        ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner4 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume16 = composerStartRestartGroup.consume(localSavedStateRegistryOwner4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume16;
                        if (function5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753355);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                            function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl7 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl7, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl7, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl7, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl7, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752490);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                            function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl8 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl8, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl8, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl8, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            function7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume17 = composerStartRestartGroup.consume(localDensity5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume17;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume18 = composerStartRestartGroup.consume(localLayoutDirection5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        layoutDirection = (LayoutDirection) objConsume18;
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner5 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume19 = composerStartRestartGroup.consume(localLifecycleOwner5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        lifecycleOwner = (LifecycleOwner) objConsume19;
                        ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner5 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume110 = composerStartRestartGroup.consume(localSavedStateRegistryOwner5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume110;
                        if (function5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753355);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                            function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl9 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl9, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl9, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl9, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl9, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752490);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                            function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl10 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl10, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl10, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl10, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    function8 = function5;
                    function9 = function7;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
                    }
                }
                i3 |= 24576;
                function7 = function4;
                if ((46811 & i3) == 9362) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        function7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume111 = composerStartRestartGroup.consume(localDensity6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume111;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume112 = composerStartRestartGroup.consume(localLayoutDirection6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume112;
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner6 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume113 = composerStartRestartGroup.consume(localLifecycleOwner6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleOwner = (LifecycleOwner) objConsume113;
                    ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner6 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume114 = composerStartRestartGroup.consume(localSavedStateRegistryOwner6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume114;
                    if (function5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753355);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                        function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl11 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl11, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl11, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl11, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl11, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752490);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                        function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl12 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl12, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl12, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl12, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        function7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume115 = composerStartRestartGroup.consume(localDensity7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume115;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume116 = composerStartRestartGroup.consume(localLayoutDirection7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume116;
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner7 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume117 = composerStartRestartGroup.consume(localLifecycleOwner7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleOwner = (LifecycleOwner) objConsume117;
                    ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner7 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume118 = composerStartRestartGroup.consume(localSavedStateRegistryOwner7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume118;
                    if (function5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753355);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                        function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl13 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl13, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl13, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl13, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl13, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752490);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                        function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl14 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl14, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl14, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl14, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                function8 = function5;
                function9 = function7;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
                }
            }
            i3 |= Constants.appIconsCacheSize;
            function5 = function2;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    function6 = function3;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        function7 = function4;
                        if (composerStartRestartGroup.changedInstance(function7)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((46811 & i3) == 9362) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            function7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume119 = composerStartRestartGroup.consume(localDensity8);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume119;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection8 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1110 = composerStartRestartGroup.consume(localLayoutDirection8);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        layoutDirection = (LayoutDirection) objConsume1110;
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner8 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1111 = composerStartRestartGroup.consume(localLifecycleOwner8);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        lifecycleOwner = (LifecycleOwner) objConsume1111;
                        ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner8 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1112 = composerStartRestartGroup.consume(localSavedStateRegistryOwner8);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume1112;
                        if (function5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753355);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                            function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl15 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl15, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl15, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl15, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl15, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752490);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                            function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl16 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl16, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl16, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl16, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            function7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1113 = composerStartRestartGroup.consume(localDensity9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume1113;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection9 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1114 = composerStartRestartGroup.consume(localLayoutDirection9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        layoutDirection = (LayoutDirection) objConsume1114;
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner9 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1115 = composerStartRestartGroup.consume(localLifecycleOwner9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        lifecycleOwner = (LifecycleOwner) objConsume1115;
                        ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner9 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1116 = composerStartRestartGroup.consume(localSavedStateRegistryOwner9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume1116;
                        if (function5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753355);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                            function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl17 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl17, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl17, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl17, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl17, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752490);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                            function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl18 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl18, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl18, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl18, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    function8 = function5;
                    function9 = function7;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
                    }
                }
                i3 |= 24576;
                function7 = function4;
                if ((46811 & i3) == 9362) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        function7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    ProvidableCompositionLocal<Density> localDensity10 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume1117 = composerStartRestartGroup.consume(localDensity10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume1117;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection10 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume1118 = composerStartRestartGroup.consume(localLayoutDirection10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume1118;
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner10 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume1119 = composerStartRestartGroup.consume(localLifecycleOwner10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleOwner = (LifecycleOwner) objConsume1119;
                    ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner10 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11110 = composerStartRestartGroup.consume(localSavedStateRegistryOwner10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume11110;
                    if (function5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753355);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                        function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl19 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl19, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl19, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl19, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl19, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752490);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                        function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl110 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl110, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl110, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl110, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        function7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    ProvidableCompositionLocal<Density> localDensity11 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11111 = composerStartRestartGroup.consume(localDensity11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume11111;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection11 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11112 = composerStartRestartGroup.consume(localLayoutDirection11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume11112;
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner11 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11113 = composerStartRestartGroup.consume(localLifecycleOwner11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleOwner = (LifecycleOwner) objConsume11113;
                    ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner11 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11114 = composerStartRestartGroup.consume(localSavedStateRegistryOwner11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume11114;
                    if (function5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753355);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                        function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl111 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl111, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl111, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl111, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl111, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752490);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                        function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl112 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl112, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl112, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl112, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                function8 = function5;
                function9 = function7;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
                }
            }
            i3 |= 3072;
            function6 = function3;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    function7 = function4;
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((46811 & i3) == 9362) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        function7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    ProvidableCompositionLocal<Density> localDensity12 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11115 = composerStartRestartGroup.consume(localDensity12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume11115;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection12 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11116 = composerStartRestartGroup.consume(localLayoutDirection12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume11116;
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner12 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11117 = composerStartRestartGroup.consume(localLifecycleOwner12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleOwner = (LifecycleOwner) objConsume11117;
                    ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner12 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11118 = composerStartRestartGroup.consume(localSavedStateRegistryOwner12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume11118;
                    if (function5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753355);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                        function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl113 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl113, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl113, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl113, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl113, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752490);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                        function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl114 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl114, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl114, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl114, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        function7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    ProvidableCompositionLocal<Density> localDensity13 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11119 = composerStartRestartGroup.consume(localDensity13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume11119;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection13 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume111110 = composerStartRestartGroup.consume(localLayoutDirection13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume111110;
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner13 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume111111 = composerStartRestartGroup.consume(localLifecycleOwner13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleOwner = (LifecycleOwner) objConsume111111;
                    ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner13 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume111112 = composerStartRestartGroup.consume(localSavedStateRegistryOwner13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume111112;
                    if (function5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753355);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                        function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl115 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl115, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl115, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl115, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl115, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752490);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                        function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl116 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl116, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl116, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl116, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                function8 = function5;
                function9 = function7;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
                }
            }
            i3 |= 24576;
            function7 = function4;
            if ((46811 & i3) == 9362) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    function6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    function7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                ProvidableCompositionLocal<Density> localDensity14 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111113 = composerStartRestartGroup.consume(localDensity14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume111113;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection14 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111114 = composerStartRestartGroup.consume(localLayoutDirection14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume111114;
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner14 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111115 = composerStartRestartGroup.consume(localLifecycleOwner14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                lifecycleOwner = (LifecycleOwner) objConsume111115;
                ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner14 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111116 = composerStartRestartGroup.consume(localSavedStateRegistryOwner14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume111116;
                if (function5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753355);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                    function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl117 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl117, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl117, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl117, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl117, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752490);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                    function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl118 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl118, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl118, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl118, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    function6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    function7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                ProvidableCompositionLocal<Density> localDensity15 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111117 = composerStartRestartGroup.consume(localDensity15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume111117;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection15 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111118 = composerStartRestartGroup.consume(localLayoutDirection15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume111118;
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner15 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111119 = composerStartRestartGroup.consume(localLifecycleOwner15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                lifecycleOwner = (LifecycleOwner) objConsume111119;
                ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner15 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume1111110 = composerStartRestartGroup.consume(localSavedStateRegistryOwner15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume1111110;
                if (function5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753355);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                    function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl119 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl119, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl119, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl119, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl119, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752490);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                    function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl1110 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl1110, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl1110, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl1110, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            function8 = function5;
            function9 = function7;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                function5 = function2;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    function6 = function3;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((57344 & i) == 0) {
                        function7 = function4;
                        if (composerStartRestartGroup.changedInstance(function7)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((46811 & i3) == 9362) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            function7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        ProvidableCompositionLocal<Density> localDensity16 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1111111 = composerStartRestartGroup.consume(localDensity16);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume1111111;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection16 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1111112 = composerStartRestartGroup.consume(localLayoutDirection16);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        layoutDirection = (LayoutDirection) objConsume1111112;
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner16 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1111113 = composerStartRestartGroup.consume(localLifecycleOwner16);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        lifecycleOwner = (LifecycleOwner) objConsume1111113;
                        ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner16 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1111114 = composerStartRestartGroup.consume(localSavedStateRegistryOwner16);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume1111114;
                        if (function5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753355);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                            function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl1111 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl1111, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl1111, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl1111, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl1111, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752490);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                            function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl1112 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl1112, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl1112, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl1112, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = NoOpUpdate;
                        }
                        if (i8 != 0) {
                            function7 = NoOpUpdate;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                        ProvidableCompositionLocal<Density> localDensity17 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1111115 = composerStartRestartGroup.consume(localDensity17);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume1111115;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection17 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1111116 = composerStartRestartGroup.consume(localLayoutDirection17);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        layoutDirection = (LayoutDirection) objConsume1111116;
                        currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner17 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1111117 = composerStartRestartGroup.consume(localLifecycleOwner17);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        lifecycleOwner = (LifecycleOwner) objConsume1111117;
                        ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner17 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume1111118 = composerStartRestartGroup.consume(localSavedStateRegistryOwner17);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume1111118;
                        if (function5 != null) {
                            composerStartRestartGroup.startReplaceableGroup(-88753355);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                            function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1405779621);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl1113 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl1113, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl1113, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl1113, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl1113, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        } else {
                            composerStartRestartGroup.startReplaceableGroup(-88752490);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                            function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                            composerStartRestartGroup.startReplaceableGroup(1886828752);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl1114 = Updater.m60constructorimpl(composerStartRestartGroup);
                            m3131updateViewHolderParams6NefGtU(composerM60constructorimpl1114, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                            Updater.m67setimpl(composerM60constructorimpl1114, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl1114, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            composerStartRestartGroup.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    function8 = function5;
                    function9 = function7;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
                    }
                }
                i3 |= 24576;
                function7 = function4;
                if ((46811 & i3) == 9362) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        function7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    ProvidableCompositionLocal<Density> localDensity18 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume1111119 = composerStartRestartGroup.consume(localDensity18);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume1111119;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection18 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11111110 = composerStartRestartGroup.consume(localLayoutDirection18);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume11111110;
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner18 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111 = composerStartRestartGroup.consume(localLifecycleOwner18);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleOwner = (LifecycleOwner) objConsume11111111;
                    ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner18 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11111112 = composerStartRestartGroup.consume(localSavedStateRegistryOwner18);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume11111112;
                    if (function5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753355);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                        function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl1115 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl1115, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl1115, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl1115, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl1115, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752490);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                        function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl1116 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl1116, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl1116, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl1116, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        function7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    ProvidableCompositionLocal<Density> localDensity19 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11111113 = composerStartRestartGroup.consume(localDensity19);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume11111113;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection19 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11111114 = composerStartRestartGroup.consume(localLayoutDirection19);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume11111114;
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner19 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11111115 = composerStartRestartGroup.consume(localLifecycleOwner19);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleOwner = (LifecycleOwner) objConsume11111115;
                    ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner19 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11111116 = composerStartRestartGroup.consume(localSavedStateRegistryOwner19);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume11111116;
                    if (function5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753355);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                        function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl1117 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl1117, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl1117, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl1117, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl1117, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752490);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                        function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl1118 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl1118, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl1118, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl1118, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                function8 = function5;
                function9 = function7;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
                }
            }
            i3 |= 3072;
            function6 = function3;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    function7 = function4;
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((46811 & i3) == 9362) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        function7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    ProvidableCompositionLocal<Density> localDensity110 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11111117 = composerStartRestartGroup.consume(localDensity110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume11111117;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection110 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11111118 = composerStartRestartGroup.consume(localLayoutDirection110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume11111118;
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner110 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11111119 = composerStartRestartGroup.consume(localLifecycleOwner110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleOwner = (LifecycleOwner) objConsume11111119;
                    ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner110 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume111111110 = composerStartRestartGroup.consume(localSavedStateRegistryOwner110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume111111110;
                    if (function5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753355);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                        function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl1119 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl1119, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl1119, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl1119, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl1119, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752490);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                        function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl11110 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl11110, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl11110, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl11110, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        function7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    ProvidableCompositionLocal<Density> localDensity111 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume111111111 = composerStartRestartGroup.consume(localDensity111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume111111111;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection111 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume111111112 = composerStartRestartGroup.consume(localLayoutDirection111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume111111112;
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner111 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume111111113 = composerStartRestartGroup.consume(localLifecycleOwner111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleOwner = (LifecycleOwner) objConsume111111113;
                    ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner111 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume111111114 = composerStartRestartGroup.consume(localSavedStateRegistryOwner111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume111111114;
                    if (function5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753355);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                        function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl11111 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl11111, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl11111, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl11111, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl11111, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752490);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                        function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl11112 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl11112, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl11112, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl11112, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                function8 = function5;
                function9 = function7;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
                }
            }
            i3 |= 24576;
            function7 = function4;
            if ((46811 & i3) == 9362) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    function6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    function7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                ProvidableCompositionLocal<Density> localDensity112 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111111115 = composerStartRestartGroup.consume(localDensity112);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume111111115;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection112 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111111116 = composerStartRestartGroup.consume(localLayoutDirection112);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume111111116;
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner112 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111111117 = composerStartRestartGroup.consume(localLifecycleOwner112);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                lifecycleOwner = (LifecycleOwner) objConsume111111117;
                ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner112 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111111118 = composerStartRestartGroup.consume(localSavedStateRegistryOwner112);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume111111118;
                if (function5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753355);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                    function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl11113 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl11113, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl11113, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl11113, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl11113, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752490);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                    function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl11114 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl11114, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl11114, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl11114, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    function6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    function7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                ProvidableCompositionLocal<Density> localDensity113 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111111119 = composerStartRestartGroup.consume(localDensity113);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume111111119;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection113 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume1111111110 = composerStartRestartGroup.consume(localLayoutDirection113);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume1111111110;
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner113 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume1111111111 = composerStartRestartGroup.consume(localLifecycleOwner113);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                lifecycleOwner = (LifecycleOwner) objConsume1111111111;
                ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner113 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume1111111112 = composerStartRestartGroup.consume(localSavedStateRegistryOwner113);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume1111111112;
                if (function5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753355);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                    function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl11115 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl11115, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl11115, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl11115, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl11115, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752490);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                    function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl11116 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl11116, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl11116, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl11116, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            function8 = function5;
            function9 = function7;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
            }
        }
        i3 |= Constants.appIconsCacheSize;
        function5 = function2;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                function6 = function3;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((57344 & i) == 0) {
                    function7 = function4;
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((46811 & i3) == 9362) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        function7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    ProvidableCompositionLocal<Density> localDensity114 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111113 = composerStartRestartGroup.consume(localDensity114);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume1111111113;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection114 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111114 = composerStartRestartGroup.consume(localLayoutDirection114);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume1111111114;
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner114 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111115 = composerStartRestartGroup.consume(localLifecycleOwner114);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleOwner = (LifecycleOwner) objConsume1111111115;
                    ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner114 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111116 = composerStartRestartGroup.consume(localSavedStateRegistryOwner114);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume1111111116;
                    if (function5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753355);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                        function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl11117 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl11117, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl11117, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl11117, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl11117, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752490);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                        function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl11118 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl11118, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl11118, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl11118, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = NoOpUpdate;
                    }
                    if (i8 != 0) {
                        function7 = NoOpUpdate;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    ProvidableCompositionLocal<Density> localDensity115 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111117 = composerStartRestartGroup.consume(localDensity115);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume1111111117;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection115 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111118 = composerStartRestartGroup.consume(localLayoutDirection115);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume1111111118;
                    currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner115 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume1111111119 = composerStartRestartGroup.consume(localLifecycleOwner115);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleOwner = (LifecycleOwner) objConsume1111111119;
                    ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner115 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume11111111110 = composerStartRestartGroup.consume(localSavedStateRegistryOwner115);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume11111111110;
                    if (function5 != null) {
                        composerStartRestartGroup.startReplaceableGroup(-88753355);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                        function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1405779621);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl11119 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl11119, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl11119, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl11119, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl11119, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-88752490);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                        function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                        composerStartRestartGroup.startReplaceableGroup(1886828752);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl111110 = Updater.m60constructorimpl(composerStartRestartGroup);
                        m3131updateViewHolderParams6NefGtU(composerM60constructorimpl111110, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                        Updater.m67setimpl(composerM60constructorimpl111110, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl111110, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                function8 = function5;
                function9 = function7;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
                }
            }
            i3 |= 24576;
            function7 = function4;
            if ((46811 & i3) == 9362) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    function6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    function7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                ProvidableCompositionLocal<Density> localDensity116 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume11111111111 = composerStartRestartGroup.consume(localDensity116);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume11111111111;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection116 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume11111111112 = composerStartRestartGroup.consume(localLayoutDirection116);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume11111111112;
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner116 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume11111111113 = composerStartRestartGroup.consume(localLifecycleOwner116);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                lifecycleOwner = (LifecycleOwner) objConsume11111111113;
                ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner116 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume11111111114 = composerStartRestartGroup.consume(localSavedStateRegistryOwner116);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume11111111114;
                if (function5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753355);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                    function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl111111 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl111111, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl111111, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111111, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111111, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752490);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                    function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl111112 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl111112, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl111112, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111112, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    function6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    function7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                ProvidableCompositionLocal<Density> localDensity117 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume11111111115 = composerStartRestartGroup.consume(localDensity117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume11111111115;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection117 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume11111111116 = composerStartRestartGroup.consume(localLayoutDirection117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume11111111116;
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner117 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume11111111117 = composerStartRestartGroup.consume(localLifecycleOwner117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                lifecycleOwner = (LifecycleOwner) objConsume11111111117;
                ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner117 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume11111111118 = composerStartRestartGroup.consume(localSavedStateRegistryOwner117);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume11111111118;
                if (function5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753355);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                    function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl111113 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl111113, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl111113, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111113, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111113, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752490);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                    function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl111114 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl111114, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl111114, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111114, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            function8 = function5;
            function9 = function7;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
            }
        }
        i3 |= 3072;
        function6 = function3;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((57344 & i) == 0) {
                function7 = function4;
                if (composerStartRestartGroup.changedInstance(function7)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((46811 & i3) == 9362) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    function6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    function7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                ProvidableCompositionLocal<Density> localDensity118 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume11111111119 = composerStartRestartGroup.consume(localDensity118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume11111111119;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection118 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111111111110 = composerStartRestartGroup.consume(localLayoutDirection118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume111111111110;
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner118 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111111111111 = composerStartRestartGroup.consume(localLifecycleOwner118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                lifecycleOwner = (LifecycleOwner) objConsume111111111111;
                ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner118 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111111111112 = composerStartRestartGroup.consume(localSavedStateRegistryOwner118);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume111111111112;
                if (function5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753355);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                    function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl111115 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl111115, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl111115, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111115, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111115, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752490);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                    function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl111116 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl111116, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl111116, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111116, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    function6 = NoOpUpdate;
                }
                if (i8 != 0) {
                    function7 = NoOpUpdate;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                ProvidableCompositionLocal<Density> localDensity119 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111111111113 = composerStartRestartGroup.consume(localDensity119);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume111111111113;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection119 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111111111114 = composerStartRestartGroup.consume(localLayoutDirection119);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume111111111114;
                currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner119 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111111111115 = composerStartRestartGroup.consume(localLifecycleOwner119);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                lifecycleOwner = (LifecycleOwner) objConsume111111111115;
                ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner119 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume111111111116 = composerStartRestartGroup.consume(localSavedStateRegistryOwner119);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume111111111116;
                if (function5 != null) {
                    composerStartRestartGroup.startReplaceableGroup(-88753355);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                    function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1405779621);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl111117 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl111117, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl111117, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111117, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111117, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-88752490);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                    function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                    composerStartRestartGroup.startReplaceableGroup(1886828752);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl111118 = Updater.m60constructorimpl(composerStartRestartGroup);
                    m3131updateViewHolderParams6NefGtU(composerM60constructorimpl111118, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                    Updater.m67setimpl(composerM60constructorimpl111118, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111118, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            function8 = function5;
            function9 = function7;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
            }
        }
        i3 |= 24576;
        function7 = function4;
        if ((46811 & i3) == 9362) {
            if (i10 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                function5 = null;
            }
            if (i6 != 0) {
                function6 = NoOpUpdate;
            }
            if (i8 != 0) {
                function7 = NoOpUpdate;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
            }
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ProvidableCompositionLocal<Density> localDensity1110 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume111111111117 = composerStartRestartGroup.consume(localDensity1110);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume111111111117;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1110 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume111111111118 = composerStartRestartGroup.consume(localLayoutDirection1110);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            layoutDirection = (LayoutDirection) objConsume111111111118;
            currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner1110 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume111111111119 = composerStartRestartGroup.consume(localLifecycleOwner1110);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            lifecycleOwner = (LifecycleOwner) objConsume111111111119;
            ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner1110 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111110 = composerStartRestartGroup.consume(localSavedStateRegistryOwner1110);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume1111111111110;
            if (function5 != null) {
                composerStartRestartGroup.startReplaceableGroup(-88753355);
                ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                composerStartRestartGroup.startReplaceableGroup(1405779621);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM60constructorimpl111119 = Updater.m60constructorimpl(composerStartRestartGroup);
                m3131updateViewHolderParams6NefGtU(composerM60constructorimpl111119, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                Updater.m67setimpl(composerM60constructorimpl111119, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl111119, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl111119, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-88752490);
                ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                composerStartRestartGroup.startReplaceableGroup(1886828752);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM60constructorimpl1111110 = Updater.m60constructorimpl(composerStartRestartGroup);
                m3131updateViewHolderParams6NefGtU(composerM60constructorimpl1111110, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                Updater.m67setimpl(composerM60constructorimpl1111110, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl1111110, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i10 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                function5 = null;
            }
            if (i6 != 0) {
                function6 = NoOpUpdate;
            }
            if (i8 != 0) {
                function7 = NoOpUpdate;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-180024211, i3, -1, "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:210)");
            }
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ProvidableCompositionLocal<Density> localDensity1111 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111111 = composerStartRestartGroup.consume(localDensity1111);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume1111111111111;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection1111 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111112 = composerStartRestartGroup.consume(localLayoutDirection1111);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            layoutDirection = (LayoutDirection) objConsume1111111111112;
            currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner1111 = AndroidCompositionLocals_androidKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111113 = composerStartRestartGroup.consume(localLifecycleOwner1111);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            lifecycleOwner = (LifecycleOwner) objConsume1111111111113;
            ProvidableCompositionLocal<SavedStateRegistryOwner> localSavedStateRegistryOwner1111 = AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume1111111111114 = composerStartRestartGroup.consume(localSavedStateRegistryOwner1111);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            savedStateRegistryOwner = (SavedStateRegistryOwner) objConsume1111111111114;
            if (function5 != null) {
                composerStartRestartGroup.startReplaceableGroup(-88753355);
                ComposerKt.sourceInformation(composerStartRestartGroup, "226@12710L37,225@12644L843");
                function0CreateAndroidViewNodeFactory2 = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                composerStartRestartGroup.startReplaceableGroup(1405779621);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ReusableComposeNode$1(function0CreateAndroidViewNodeFactory2));
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM60constructorimpl1111111 = Updater.m60constructorimpl(composerStartRestartGroup);
                m3131updateViewHolderParams6NefGtU(composerM60constructorimpl1111111, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                Updater.m67setimpl(composerM60constructorimpl1111111, function5, AndroidView_androidKt$AndroidView$2$1.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl1111111, function7, AndroidView_androidKt$AndroidView$2$2.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl1111111, function6, AndroidView_androidKt$AndroidView$2$3.INSTANCE);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-88752490);
                ComposerKt.sourceInformation(composerStartRestartGroup, "244@13567L37,243@13509L756");
                function0CreateAndroidViewNodeFactory = createAndroidViewNodeFactory(function1, composerStartRestartGroup, i3 & 14);
                composerStartRestartGroup.startReplaceableGroup(1886828752);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof UiApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(new AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1(function0CreateAndroidViewNodeFactory));
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM60constructorimpl1111112 = Updater.m60constructorimpl(composerStartRestartGroup);
                m3131updateViewHolderParams6NefGtU(composerM60constructorimpl1111112, modifierMaterializeModifier, currentCompositeKeyHash, density, lifecycleOwner, savedStateRegistryOwner, layoutDirection, currentCompositionLocalMap);
                Updater.m67setimpl(composerM60constructorimpl1111112, function7, AndroidView_androidKt$AndroidView$3$1.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl1111112, function6, AndroidView_androidKt$AndroidView$3$2.INSTANCE);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        function8 = function5;
        function9 = function7;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(function1, companion, function8, function6, function9, i, i2));
        }
    }

    private static final <T extends View> Function0<LayoutNode> createAndroidViewNodeFactory(Function1<? super Context, ? extends T> function1, Composer composer, int i) {
        composer.startReplaceableGroup(2030558801);
        ComposerKt.sourceInformation(composer, "C(createAndroidViewNodeFactory)266@14417L23,267@14472L7,268@14506L28,269@14586L7,270@14624L7:AndroidView.android.kt#z33iqn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2030558801, i, -1, "androidx.compose.ui.viewinterop.createAndroidViewNodeFactory (AndroidView.android.kt:265)");
        }
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composer, 0);
        ProvidableCompositionLocal<SaveableStateRegistry> localSaveableStateRegistry = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localSaveableStateRegistry);
        ComposerKt.sourceInformationMarkerEnd(composer);
        SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) objConsume2;
        ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume3 = composer.consume(localView);
        ComposerKt.sourceInformationMarkerEnd(composer);
        C01391 c01391 = new C01391((Context) objConsume, function1, compositionContextRememberCompositionContext, saveableStateRegistry, currentCompositeKeyHash, (View) objConsume3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return c01391;
    }

    /* INFO: renamed from: androidx.compose.ui.viewinterop.AndroidView_androidKt$createAndroidViewNodeFactory$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: AndroidView.android.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/node/LayoutNode;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01391 extends Lambda implements Function0<LayoutNode> {
        final /* synthetic */ int $compositeKeyHash;
        final /* synthetic */ Context $context;
        final /* synthetic */ Function1<Context, T> $factory;
        final /* synthetic */ View $ownerView;
        final /* synthetic */ CompositionContext $parentReference;
        final /* synthetic */ SaveableStateRegistry $stateRegistry;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        C01391(Context context, Function1<? super Context, ? extends T> function1, CompositionContext compositionContext, SaveableStateRegistry saveableStateRegistry, int i, View view) {
            super(0);
            this.$context = context;
            this.$factory = function1;
            this.$parentReference = compositionContext;
            this.$stateRegistry = saveableStateRegistry;
            this.$compositeKeyHash = i;
            this.$ownerView = view;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LayoutNode invoke() {
            Context context = this.$context;
            Function1<Context, T> function1 = this.$factory;
            CompositionContext compositionContext = this.$parentReference;
            SaveableStateRegistry saveableStateRegistry = this.$stateRegistry;
            int i = this.$compositeKeyHash;
            KeyEvent.Callback callback = this.$ownerView;
            Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type androidx.compose.ui.node.Owner");
            return new ViewFactoryHolder(context, function1, compositionContext, saveableStateRegistry, i, (Owner) callback).getLayoutNode();
        }
    }

    /* INFO: renamed from: updateViewHolderParams-6NefGtU, reason: not valid java name */
    private static final <T extends View> void m3131updateViewHolderParams6NefGtU(Composer composer, Modifier modifier, int i, Density density, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, LayoutDirection layoutDirection, CompositionLocalMap compositionLocalMap) {
        Updater.m67setimpl(composer, compositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m67setimpl(composer, modifier, AndroidView_androidKt$updateViewHolderParams$1.INSTANCE);
        Updater.m67setimpl(composer, density, AndroidView_androidKt$updateViewHolderParams$2.INSTANCE);
        Updater.m67setimpl(composer, lifecycleOwner, AndroidView_androidKt$updateViewHolderParams$3.INSTANCE);
        Updater.m67setimpl(composer, savedStateRegistryOwner, AndroidView_androidKt$updateViewHolderParams$4.INSTANCE);
        Updater.m67setimpl(composer, layoutDirection, AndroidView_androidKt$updateViewHolderParams$5.INSTANCE);
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(i))) {
            composer.updateRememberedValue(Integer.valueOf(i));
            composer.apply(Integer.valueOf(i), setCompositeKeyHash);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final <T extends View> ViewFactoryHolder<T> requireViewFactoryHolder(LayoutNode layoutNode) {
        AndroidViewHolder interopViewFactoryHolder = layoutNode.getInteropViewFactoryHolder();
        if (interopViewFactoryHolder == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Intrinsics.checkNotNull(interopViewFactoryHolder, "null cannot be cast to non-null type androidx.compose.ui.viewinterop.ViewFactoryHolder<T of androidx.compose.ui.viewinterop.AndroidView_androidKt.requireViewFactoryHolder>");
        return (ViewFactoryHolder) interopViewFactoryHolder;
    }

    public static final Function1<View, Unit> getNoOpUpdate() {
        return NoOpUpdate;
    }
}
