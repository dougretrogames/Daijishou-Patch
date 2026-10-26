package androidx.compose.ui.window;

import android.view.View;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.magneticchen.daijishou.application_data.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: AndroidDialog.android.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001a*\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0003¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\u0015\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007X\u008a\u0084\u0002"}, d2 = {"Dialog", "", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DialogLayout", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidDialog_androidKt {

    /* INFO: renamed from: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3, reason: invalid class name */
    /* INFO: compiled from: AndroidDialog.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass3 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ Function0<Unit> $onDismissRequest;
        final /* synthetic */ DialogProperties $properties;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass3(Function0<Unit> function0, DialogProperties dialogProperties, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
            super(2);
            this.$onDismissRequest = function0;
            this.$properties = dialogProperties;
            this.$content = function2;
            this.$$changed = i;
            this.$$default = i2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            AndroidDialog_androidKt.Dialog(this.$onDismissRequest, this.$properties, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* INFO: renamed from: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$2, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: AndroidDialog.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01412 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ Modifier $modifier;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        C01412(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
            super(2);
            this.$modifier = modifier;
            this.$content = function2;
            this.$$changed = i;
            this.$$default = i2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            AndroidDialog_androidKt.DialogLayout(this.$modifier, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* WARN: Code duplicated, block: B:26:0x004b  */
    /* WARN: Code duplicated, block: B:27:0x004e  */
    /* WARN: Code duplicated, block: B:29:0x0052  */
    /* WARN: Code duplicated, block: B:31:0x0058  */
    /* WARN: Code duplicated, block: B:32:0x005b  */
    /* WARN: Code duplicated, block: B:40:0x0071 A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:41:0x0073  */
    /* WARN: Code duplicated, block: B:44:0x0088  */
    /* WARN: Code duplicated, block: B:47:0x0108  */
    /* WARN: Code duplicated, block: B:51:0x0115  */
    /* WARN: Code duplicated, block: B:54:0x015b  */
    /* WARN: Code duplicated, block: B:57:0x0164  */
    /* WARN: Code duplicated, block: B:59:? A[RETURN, SYNTHETIC] */
    public static final void Dialog(Function0<Unit> function0, DialogProperties dialogProperties, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        DialogProperties dialogProperties2;
        int i4;
        View view;
        Density density;
        LayoutDirection layoutDirection;
        CompositionContext compositionContextRememberCompositionContext;
        State stateRememberUpdatedState;
        UUID uuid;
        boolean zChanged;
        Object objRememberedValue;
        DialogProperties dialogProperties3;
        LayoutDirection layoutDirection2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2032877254);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Dialog)P(1,2)155@6564L7,156@6603L7,157@6658L7,158@6688L28,159@6743L29,160@6792L38,161@6848L616,182@7470L154,191@7630L193:AndroidDialog.android.kt#2oxthz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 112) == 0) {
                dialogProperties2 = dialogProperties;
                i3 |= composerStartRestartGroup.changed(dialogProperties2) ? 32 : 16;
            }
            if ((i2 & 4) != 0) {
                i3 |= Constants.appIconsCacheSize;
            } else if ((i & 896) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            if ((i3 & 731) == 146 || !composerStartRestartGroup.getSkipping()) {
                if (i5 != 0) {
                    dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2032877254, i3, -1, "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:154)");
                }
                ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localView);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume;
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume2;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume3;
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i3 >> 6) & 14);
                uuid = (UUID) RememberSaveableKt.m147rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) AndroidDialog_androidKt$Dialog$dialogId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    dialogProperties3 = dialogProperties2;
                    layoutDirection2 = layoutDirection;
                    DialogWrapper dialogWrapper = new DialogWrapper(function0, dialogProperties3, view, layoutDirection2, density, uuid);
                    dialogWrapper.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(488261145, true, new AndroidDialog_androidKt$Dialog$dialog$1$1$1(stateRememberUpdatedState)));
                    composerStartRestartGroup.updateRememberedValue(dialogWrapper);
                    objRememberedValue = dialogWrapper;
                } else {
                    dialogProperties3 = dialogProperties2;
                    layoutDirection2 = layoutDirection;
                }
                composerStartRestartGroup.endReplaceableGroup();
                DialogWrapper dialogWrapper2 = (DialogWrapper) objRememberedValue;
                EffectsKt.DisposableEffect(dialogWrapper2, new AnonymousClass1(dialogWrapper2), composerStartRestartGroup, 8);
                EffectsKt.SideEffect(new AnonymousClass2(dialogWrapper2, function0, dialogProperties3, layoutDirection2), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                dialogProperties3 = dialogProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(function0, dialogProperties3, function2, i, i2));
            }
        }
        i3 |= 48;
        dialogProperties2 = dialogProperties;
        if ((i2 & 4) != 0) {
            i3 |= Constants.appIconsCacheSize;
        } else if ((i & 896) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i3 & 731) == 146) {
            if (i5 != 0) {
                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2032877254, i3, -1, "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:154)");
            }
            ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localView2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            view = (View) objConsume4;
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
            compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i3 >> 6) & 14);
            uuid = (UUID) RememberSaveableKt.m147rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) AndroidDialog_androidKt$Dialog$dialogId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                dialogProperties3 = dialogProperties2;
                layoutDirection2 = layoutDirection;
                DialogWrapper dialogWrapper3 = new DialogWrapper(function0, dialogProperties3, view, layoutDirection2, density, uuid);
                dialogWrapper3.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(488261145, true, new AndroidDialog_androidKt$Dialog$dialog$1$1$1(stateRememberUpdatedState)));
                composerStartRestartGroup.updateRememberedValue(dialogWrapper3);
                objRememberedValue = dialogWrapper3;
            } else {
                dialogProperties3 = dialogProperties2;
                layoutDirection2 = layoutDirection;
                DialogWrapper dialogWrapper4 = new DialogWrapper(function0, dialogProperties3, view, layoutDirection2, density, uuid);
                dialogWrapper4.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(488261145, true, new AndroidDialog_androidKt$Dialog$dialog$1$1$1(stateRememberUpdatedState)));
                composerStartRestartGroup.updateRememberedValue(dialogWrapper4);
                objRememberedValue = dialogWrapper4;
            }
            composerStartRestartGroup.endReplaceableGroup();
            DialogWrapper dialogWrapper5 = (DialogWrapper) objRememberedValue;
            EffectsKt.DisposableEffect(dialogWrapper5, new AnonymousClass1(dialogWrapper5), composerStartRestartGroup, 8);
            EffectsKt.SideEffect(new AnonymousClass2(dialogWrapper5, function0, dialogProperties3, layoutDirection2), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i5 != 0) {
                dialogProperties2 = new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2032877254, i3, -1, "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:154)");
            }
            ProvidableCompositionLocal<View> localView3 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume7 = composerStartRestartGroup.consume(localView3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            view = (View) objConsume7;
            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume8 = composerStartRestartGroup.consume(localDensity3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume8;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume9 = composerStartRestartGroup.consume(localLayoutDirection3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            layoutDirection = (LayoutDirection) objConsume9;
            compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i3 >> 6) & 14);
            uuid = (UUID) RememberSaveableKt.m147rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) AndroidDialog_androidKt$Dialog$dialogId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                dialogProperties3 = dialogProperties2;
                layoutDirection2 = layoutDirection;
                DialogWrapper dialogWrapper6 = new DialogWrapper(function0, dialogProperties3, view, layoutDirection2, density, uuid);
                dialogWrapper6.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(488261145, true, new AndroidDialog_androidKt$Dialog$dialog$1$1$1(stateRememberUpdatedState)));
                composerStartRestartGroup.updateRememberedValue(dialogWrapper6);
                objRememberedValue = dialogWrapper6;
            } else {
                dialogProperties3 = dialogProperties2;
                layoutDirection2 = layoutDirection;
                DialogWrapper dialogWrapper7 = new DialogWrapper(function0, dialogProperties3, view, layoutDirection2, density, uuid);
                dialogWrapper7.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(488261145, true, new AndroidDialog_androidKt$Dialog$dialog$1$1$1(stateRememberUpdatedState)));
                composerStartRestartGroup.updateRememberedValue(dialogWrapper7);
                objRememberedValue = dialogWrapper7;
            }
            composerStartRestartGroup.endReplaceableGroup();
            DialogWrapper dialogWrapper8 = (DialogWrapper) objRememberedValue;
            EffectsKt.DisposableEffect(dialogWrapper8, new AnonymousClass1(dialogWrapper8), composerStartRestartGroup, 8);
            EffectsKt.SideEffect(new AnonymousClass2(dialogWrapper8, function0, dialogProperties3, layoutDirection2), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(function0, dialogProperties3, function2, i, i2));
        }
    }

    /* INFO: renamed from: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1, reason: invalid class name */
    /* INFO: compiled from: AndroidDialog.android.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ DialogWrapper $dialog;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DialogWrapper dialogWrapper) {
            super(1);
            this.$dialog = dialogWrapper;
        }

        @Override // kotlin.jvm.functions.Function1
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            this.$dialog.show();
            return new AndroidDialog_androidKt$Dialog$1$invoke$$inlined$onDispose$1(this.$dialog);
        }
    }

    /* INFO: renamed from: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2, reason: invalid class name */
    /* INFO: compiled from: AndroidDialog.android.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        final /* synthetic */ DialogWrapper $dialog;
        final /* synthetic */ LayoutDirection $layoutDirection;
        final /* synthetic */ Function0<Unit> $onDismissRequest;
        final /* synthetic */ DialogProperties $properties;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DialogWrapper dialogWrapper, Function0<Unit> function0, DialogProperties dialogProperties, LayoutDirection layoutDirection) {
            super(0);
            this.$dialog = dialogWrapper;
            this.$onDismissRequest = function0;
            this.$properties = dialogProperties;
            this.$layoutDirection = layoutDirection;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$dialog.updateParameters(this.$onDismissRequest, this.$properties, this.$layoutDirection);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final void DialogLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1177876616);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DialogLayout)P(1)453@17860L455:AndroidDialog.android.kt#2oxthz");
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
        if ((i3 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1177876616, i3, -1, "androidx.compose.ui.window.DialogLayout (AndroidDialog.android.kt:452)");
            }
            C01401 c01401 = C01401.INSTANCE;
            int i5 = ((i3 >> 3) & 14) | Constants.appIconsCacheSize | ((i3 << 3) & 112);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            int i6 = ((i5 << 9) & 7168) | 6;
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM60constructorimpl = Updater.m60constructorimpl(composerStartRestartGroup);
            Updater.m67setimpl(composerM60constructorimpl, c01401, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m67setimpl(composerM60constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM60constructorimpl.getInserting() || !Intrinsics.areEqual(composerM60constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m51boximpl(SkippableUpdater.m52constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 9) & 14));
            composerStartRestartGroup.endReplaceableGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new C01412(modifier, function2, i, i2));
        }
    }

    /* INFO: renamed from: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: AndroidDialog.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01401 implements MeasurePolicy {
        public static final C01401 INSTANCE = new C01401();

        C01401() {
        }

        /* INFO: renamed from: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1$1, reason: invalid class name and collision with other inner class name */
        /* INFO: compiled from: AndroidDialog.android.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class C00081 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
            final /* synthetic */ List<Placeable> $placeables;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* WARN: Multi-variable type inference failed */
            C00081(List<? extends Placeable> list) {
                super(1);
                this.$placeables = list;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                List<Placeable> list = this.$placeables;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i), 0, 0, 0.0f, 4, null);
                }
            }
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* INFO: renamed from: measure-3p2s80s */
        public final MeasureResult mo1841measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
            Object obj;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(list.get(i).mo1824measureBRTryo0(j));
            }
            ArrayList arrayList2 = arrayList;
            Object obj2 = null;
            int i2 = 1;
            if (!arrayList2.isEmpty()) {
                obj = arrayList2.get(0);
                int width = ((Placeable) obj).getWidth();
                int lastIndex = CollectionsKt.getLastIndex(arrayList2);
                if (1 <= lastIndex) {
                    int i3 = 1;
                    while (true) {
                        Object obj3 = arrayList2.get(i3);
                        int width2 = ((Placeable) obj3).getWidth();
                        if (width < width2) {
                            obj = obj3;
                            width = width2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
            } else {
                obj = null;
            }
            Placeable placeable = (Placeable) obj;
            int width3 = placeable != null ? placeable.getWidth() : Constraints.m2842getMinWidthimpl(j);
            if (!arrayList2.isEmpty()) {
                Object obj4 = arrayList2.get(0);
                int height = ((Placeable) obj4).getHeight();
                int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
                if (1 <= lastIndex2) {
                    while (true) {
                        Object obj5 = arrayList2.get(i2);
                        int height2 = ((Placeable) obj5).getHeight();
                        if (height < height2) {
                            obj4 = obj5;
                            height = height2;
                        }
                        if (i2 == lastIndex2) {
                            break;
                        }
                        i2++;
                    }
                }
                obj2 = obj4;
            }
            Placeable placeable2 = (Placeable) obj2;
            return MeasureScope.layout$default(measureScope, width3, placeable2 != null ? placeable2.getHeight() : Constraints.m2841getMinHeightimpl(j), null, new C00081(arrayList2), 4, null);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> Dialog$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
