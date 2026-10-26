package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.magneticchen.daijishou.application_data.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

/* INFO: compiled from: AndroidPopup.android.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aD\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001a(\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0018\u001a+\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0013\b\b\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010H\u0083\b¢\u0006\u0002\u0010\u001c\u001a\u001c\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002H\u0007\u001a\f\u0010\"\u001a\u00020\u001e*\u00020 H\u0000\u001a\f\u0010#\u001a\u00020$*\u00020%H\u0002\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&²\u0006\u0015\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\b\u0010X\u008a\u0084\u0002"}, d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Popup", "", "alignment", "Landroidx/compose/ui/Alignment;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/unit/IntOffset;", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Landroidx/compose/runtime/Composable;", "Popup-K5zGePQ", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupTestTag", "tag", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isPopupLayout", "", "view", "Landroid/view/View;", "testTag", "isFlagSecureEnabled", "toIntBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/graphics/Rect;", "ui_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidPopup_androidKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(null, AndroidPopup_androidKt$LocalPopupTestTag$1.INSTANCE, 1, null);

    /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$1, reason: invalid class name */
    /* INFO: compiled from: AndroidPopup.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Alignment $alignment;
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ long $offset;
        final /* synthetic */ Function0<Unit> $onDismissRequest;
        final /* synthetic */ PopupProperties $properties;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass1(Alignment alignment, long j, Function0<Unit> function0, PopupProperties popupProperties, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
            super(2);
            this.$alignment = alignment;
            this.$offset = j;
            this.$onDismissRequest = function0;
            this.$properties = popupProperties;
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
            AndroidPopup_androidKt.m3134PopupK5zGePQ(this.$alignment, this.$offset, this.$onDismissRequest, this.$properties, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$9, reason: invalid class name */
    /* INFO: compiled from: AndroidPopup.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass9 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ Function0<Unit> $onDismissRequest;
        final /* synthetic */ PopupPositionProvider $popupPositionProvider;
        final /* synthetic */ PopupProperties $properties;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass9(PopupPositionProvider popupPositionProvider, Function0<Unit> function0, PopupProperties popupProperties, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
            super(2);
            this.$popupPositionProvider = popupPositionProvider;
            this.$onDismissRequest = function0;
            this.$properties = popupProperties;
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
            AndroidPopup_androidKt.Popup(this.$popupPositionProvider, this.$onDismissRequest, this.$properties, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$PopupTestTag$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: AndroidPopup.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01421 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ String $tag;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        C01421(String str, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
            super(2);
            this.$tag = str;
            this.$content = function2;
            this.$$changed = i;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            AndroidPopup_androidKt.PopupTestTag(this.$tag, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* WARN: Code duplicated, block: B:26:0x004e  */
    /* WARN: Code duplicated, block: B:27:0x0051  */
    /* WARN: Code duplicated, block: B:29:0x0055  */
    /* WARN: Code duplicated, block: B:31:0x005d  */
    /* WARN: Code duplicated, block: B:32:0x0060  */
    /* WARN: Code duplicated, block: B:37:0x006a  */
    /* WARN: Code duplicated, block: B:38:0x006d  */
    /* WARN: Code duplicated, block: B:40:0x0071  */
    /* WARN: Code duplicated, block: B:42:0x0079  */
    /* WARN: Code duplicated, block: B:43:0x007c  */
    /* WARN: Code duplicated, block: B:48:0x0086  */
    /* WARN: Code duplicated, block: B:49:0x0089  */
    /* WARN: Code duplicated, block: B:51:0x008f  */
    /* WARN: Code duplicated, block: B:53:0x0097  */
    /* WARN: Code duplicated, block: B:54:0x009a  */
    /* WARN: Code duplicated, block: B:59:0x00a8  */
    /* WARN: Code duplicated, block: B:64:0x00b8 A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:65:0x00ba  */
    /* WARN: Code duplicated, block: B:66:0x00c1  */
    /* WARN: Code duplicated, block: B:68:0x00c4  */
    /* WARN: Code duplicated, block: B:69:0x00ca  */
    /* WARN: Code duplicated, block: B:72:0x00ce  */
    /* WARN: Code duplicated, block: B:74:0x00d1  */
    /* WARN: Code duplicated, block: B:75:0x00e7  */
    /* WARN: Code duplicated, block: B:78:0x00ee  */
    /* WARN: Code duplicated, block: B:81:0x0112  */
    /* WARN: Code duplicated, block: B:83:0x011a  */
    /* WARN: Code duplicated, block: B:86:0x013a  */
    /* WARN: Code duplicated, block: B:90:0x0147  */
    /* WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    /* INFO: renamed from: Popup-K5zGePQ, reason: not valid java name */
    public static final void m3134PopupK5zGePQ(Alignment alignment, long j, Function0<Unit> function0, PopupProperties popupProperties, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        Alignment alignment2;
        int i3;
        long j2;
        int i4;
        Function0<Unit> function1;
        int i5;
        int i6;
        PopupProperties popupProperties2;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function3;
        int i8;
        Alignment topStart;
        long jIntOffset;
        PopupProperties popupProperties3;
        boolean zChanged;
        Object objRememberedValue;
        long j3;
        PopupProperties popupProperties4;
        Function0<Unit> function4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(295309329);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Popup)P(!1,2:c#ui.unit.IntOffset,3,4)195@8726L128,202@8860L165:AndroidPopup.android.kt#2oxthz");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
            alignment2 = alignment;
        } else if ((i & 14) == 0) {
            alignment2 = alignment;
            i3 = (composerStartRestartGroup.changed(alignment2) ? 4 : 2) | i;
        } else {
            alignment2 = alignment;
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 112) == 0) {
                j2 = j;
                i3 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        popupProperties2 = popupProperties;
                        if (composerStartRestartGroup.changed(popupProperties2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i2 & 16) != 0) {
                        if ((57344 & i) == 0) {
                            function3 = function2;
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i8 = 16384;
                            } else {
                                i8 = 8192;
                            }
                            i3 |= i8;
                        }
                        if ((46811 & i3) == 9362 || !composerStartRestartGroup.getSkipping()) {
                            if (i9 != 0) {
                                topStart = Alignment.INSTANCE.getTopStart();
                            } else {
                                topStart = alignment2;
                            }
                            if (i10 != 0) {
                                jIntOffset = IntOffsetKt.IntOffset(0, 0);
                            } else {
                                jIntOffset = j2;
                            }
                            if (i4 != 0) {
                                function1 = null;
                            }
                            if (i6 != 0) {
                                popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                            } else {
                                popupProperties3 = popupProperties2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                            }
                            IntOffset intOffsetM3003boximpl = IntOffset.m3003boximpl(jIntOffset);
                            composerStartRestartGroup.startReplaceableGroup(511388516);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl) | composerStartRestartGroup.changed(topStart);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j3 = jIntOffset;
                            popupProperties4 = popupProperties3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            topStart = alignment2;
                            j3 = j2;
                            popupProperties4 = popupProperties2;
                        }
                        function4 = function1;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
                        }
                    }
                    i3 |= 24576;
                    function3 = function2;
                    if ((46811 & i3) == 9362) {
                        if (i9 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i10 != 0) {
                            jIntOffset = IntOffsetKt.IntOffset(0, 0);
                        } else {
                            jIntOffset = j2;
                        }
                        if (i4 != 0) {
                            function1 = null;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                        }
                        IntOffset intOffsetM3003boximpl2 = IntOffset.m3003boximpl(jIntOffset);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl2) | composerStartRestartGroup.changed(topStart);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j3 = jIntOffset;
                        popupProperties4 = popupProperties3;
                    } else {
                        if (i9 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i10 != 0) {
                            jIntOffset = IntOffsetKt.IntOffset(0, 0);
                        } else {
                            jIntOffset = j2;
                        }
                        if (i4 != 0) {
                            function1 = null;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                        }
                        IntOffset intOffsetM3003boximpl3 = IntOffset.m3003boximpl(jIntOffset);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl3) | composerStartRestartGroup.changed(topStart);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j3 = jIntOffset;
                        popupProperties4 = popupProperties3;
                    }
                    function4 = function1;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
                    }
                }
                i3 |= 3072;
                popupProperties2 = popupProperties;
                if ((i2 & 16) != 0) {
                    if ((57344 & i) == 0) {
                        function3 = function2;
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    }
                    if ((46811 & i3) == 9362) {
                        if (i9 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i10 != 0) {
                            jIntOffset = IntOffsetKt.IntOffset(0, 0);
                        } else {
                            jIntOffset = j2;
                        }
                        if (i4 != 0) {
                            function1 = null;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                        }
                        IntOffset intOffsetM3003boximpl4 = IntOffset.m3003boximpl(jIntOffset);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl4) | composerStartRestartGroup.changed(topStart);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j3 = jIntOffset;
                        popupProperties4 = popupProperties3;
                    } else {
                        if (i9 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i10 != 0) {
                            jIntOffset = IntOffsetKt.IntOffset(0, 0);
                        } else {
                            jIntOffset = j2;
                        }
                        if (i4 != 0) {
                            function1 = null;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                        }
                        IntOffset intOffsetM3003boximpl5 = IntOffset.m3003boximpl(jIntOffset);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl5) | composerStartRestartGroup.changed(topStart);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j3 = jIntOffset;
                        popupProperties4 = popupProperties3;
                    }
                    function4 = function1;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
                    }
                }
                i3 |= 24576;
                function3 = function2;
                if ((46811 & i3) == 9362) {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    } else {
                        jIntOffset = j2;
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                    }
                    IntOffset intOffsetM3003boximpl6 = IntOffset.m3003boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl6) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jIntOffset;
                    popupProperties4 = popupProperties3;
                } else {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    } else {
                        jIntOffset = j2;
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                    }
                    IntOffset intOffsetM3003boximpl7 = IntOffset.m3003boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl7) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jIntOffset;
                    popupProperties4 = popupProperties3;
                }
                function4 = function1;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
                }
            }
            i3 |= Constants.appIconsCacheSize;
            function1 = function0;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i2 & 16) != 0) {
                    if ((57344 & i) == 0) {
                        function3 = function2;
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    }
                    if ((46811 & i3) == 9362) {
                        if (i9 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i10 != 0) {
                            jIntOffset = IntOffsetKt.IntOffset(0, 0);
                        } else {
                            jIntOffset = j2;
                        }
                        if (i4 != 0) {
                            function1 = null;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                        }
                        IntOffset intOffsetM3003boximpl8 = IntOffset.m3003boximpl(jIntOffset);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl8) | composerStartRestartGroup.changed(topStart);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j3 = jIntOffset;
                        popupProperties4 = popupProperties3;
                    } else {
                        if (i9 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i10 != 0) {
                            jIntOffset = IntOffsetKt.IntOffset(0, 0);
                        } else {
                            jIntOffset = j2;
                        }
                        if (i4 != 0) {
                            function1 = null;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                        }
                        IntOffset intOffsetM3003boximpl9 = IntOffset.m3003boximpl(jIntOffset);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl9) | composerStartRestartGroup.changed(topStart);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j3 = jIntOffset;
                        popupProperties4 = popupProperties3;
                    }
                    function4 = function1;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
                    }
                }
                i3 |= 24576;
                function3 = function2;
                if ((46811 & i3) == 9362) {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    } else {
                        jIntOffset = j2;
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                    }
                    IntOffset intOffsetM3003boximpl10 = IntOffset.m3003boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl10) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jIntOffset;
                    popupProperties4 = popupProperties3;
                } else {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    } else {
                        jIntOffset = j2;
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                    }
                    IntOffset intOffsetM3003boximpl11 = IntOffset.m3003boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl11) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jIntOffset;
                    popupProperties4 = popupProperties3;
                }
                function4 = function1;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
                }
            }
            i3 |= 3072;
            popupProperties2 = popupProperties;
            if ((i2 & 16) != 0) {
                if ((57344 & i) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((46811 & i3) == 9362) {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    } else {
                        jIntOffset = j2;
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                    }
                    IntOffset intOffsetM3003boximpl12 = IntOffset.m3003boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl12) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jIntOffset;
                    popupProperties4 = popupProperties3;
                } else {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    } else {
                        jIntOffset = j2;
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                    }
                    IntOffset intOffsetM3003boximpl13 = IntOffset.m3003boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl13) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jIntOffset;
                    popupProperties4 = popupProperties3;
                }
                function4 = function1;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
                }
            }
            i3 |= 24576;
            function3 = function2;
            if ((46811 & i3) == 9362) {
                if (i9 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    jIntOffset = IntOffsetKt.IntOffset(0, 0);
                } else {
                    jIntOffset = j2;
                }
                if (i4 != 0) {
                    function1 = null;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                }
                IntOffset intOffsetM3003boximpl14 = IntOffset.m3003boximpl(jIntOffset);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl14) | composerStartRestartGroup.changed(topStart);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = jIntOffset;
                popupProperties4 = popupProperties3;
            } else {
                if (i9 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    jIntOffset = IntOffsetKt.IntOffset(0, 0);
                } else {
                    jIntOffset = j2;
                }
                if (i4 != 0) {
                    function1 = null;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                }
                IntOffset intOffsetM3003boximpl15 = IntOffset.m3003boximpl(jIntOffset);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl15) | composerStartRestartGroup.changed(topStart);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = jIntOffset;
                popupProperties4 = popupProperties3;
            }
            function4 = function1;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
            }
        }
        i3 |= 48;
        j2 = j;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i2 & 16) != 0) {
                    if ((57344 & i) == 0) {
                        function3 = function2;
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    }
                    if ((46811 & i3) == 9362) {
                        if (i9 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i10 != 0) {
                            jIntOffset = IntOffsetKt.IntOffset(0, 0);
                        } else {
                            jIntOffset = j2;
                        }
                        if (i4 != 0) {
                            function1 = null;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                        }
                        IntOffset intOffsetM3003boximpl16 = IntOffset.m3003boximpl(jIntOffset);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl16) | composerStartRestartGroup.changed(topStart);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j3 = jIntOffset;
                        popupProperties4 = popupProperties3;
                    } else {
                        if (i9 != 0) {
                            topStart = Alignment.INSTANCE.getTopStart();
                        } else {
                            topStart = alignment2;
                        }
                        if (i10 != 0) {
                            jIntOffset = IntOffsetKt.IntOffset(0, 0);
                        } else {
                            jIntOffset = j2;
                        }
                        if (i4 != 0) {
                            function1 = null;
                        }
                        if (i6 != 0) {
                            popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                        } else {
                            popupProperties3 = popupProperties2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                        }
                        IntOffset intOffsetM3003boximpl17 = IntOffset.m3003boximpl(jIntOffset);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl17) | composerStartRestartGroup.changed(topStart);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j3 = jIntOffset;
                        popupProperties4 = popupProperties3;
                    }
                    function4 = function1;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
                    }
                }
                i3 |= 24576;
                function3 = function2;
                if ((46811 & i3) == 9362) {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    } else {
                        jIntOffset = j2;
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                    }
                    IntOffset intOffsetM3003boximpl18 = IntOffset.m3003boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl18) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jIntOffset;
                    popupProperties4 = popupProperties3;
                } else {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    } else {
                        jIntOffset = j2;
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                    }
                    IntOffset intOffsetM3003boximpl19 = IntOffset.m3003boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl19) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jIntOffset;
                    popupProperties4 = popupProperties3;
                }
                function4 = function1;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
                }
            }
            i3 |= 3072;
            popupProperties2 = popupProperties;
            if ((i2 & 16) != 0) {
                if ((57344 & i) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((46811 & i3) == 9362) {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    } else {
                        jIntOffset = j2;
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                    }
                    IntOffset intOffsetM3003boximpl110 = IntOffset.m3003boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl110) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jIntOffset;
                    popupProperties4 = popupProperties3;
                } else {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    } else {
                        jIntOffset = j2;
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                    }
                    IntOffset intOffsetM3003boximpl111 = IntOffset.m3003boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl111) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jIntOffset;
                    popupProperties4 = popupProperties3;
                }
                function4 = function1;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
                }
            }
            i3 |= 24576;
            function3 = function2;
            if ((46811 & i3) == 9362) {
                if (i9 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    jIntOffset = IntOffsetKt.IntOffset(0, 0);
                } else {
                    jIntOffset = j2;
                }
                if (i4 != 0) {
                    function1 = null;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                }
                IntOffset intOffsetM3003boximpl112 = IntOffset.m3003boximpl(jIntOffset);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl112) | composerStartRestartGroup.changed(topStart);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = jIntOffset;
                popupProperties4 = popupProperties3;
            } else {
                if (i9 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    jIntOffset = IntOffsetKt.IntOffset(0, 0);
                } else {
                    jIntOffset = j2;
                }
                if (i4 != 0) {
                    function1 = null;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                }
                IntOffset intOffsetM3003boximpl113 = IntOffset.m3003boximpl(jIntOffset);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl113) | composerStartRestartGroup.changed(topStart);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = jIntOffset;
                popupProperties4 = popupProperties3;
            }
            function4 = function1;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
            }
        }
        i3 |= Constants.appIconsCacheSize;
        function1 = function0;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                popupProperties2 = popupProperties;
                if (composerStartRestartGroup.changed(popupProperties2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i2 & 16) != 0) {
                if ((57344 & i) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((46811 & i3) == 9362) {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    } else {
                        jIntOffset = j2;
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                    }
                    IntOffset intOffsetM3003boximpl114 = IntOffset.m3003boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl114) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jIntOffset;
                    popupProperties4 = popupProperties3;
                } else {
                    if (i9 != 0) {
                        topStart = Alignment.INSTANCE.getTopStart();
                    } else {
                        topStart = alignment2;
                    }
                    if (i10 != 0) {
                        jIntOffset = IntOffsetKt.IntOffset(0, 0);
                    } else {
                        jIntOffset = j2;
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                    }
                    IntOffset intOffsetM3003boximpl115 = IntOffset.m3003boximpl(jIntOffset);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl115) | composerStartRestartGroup.changed(topStart);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jIntOffset;
                    popupProperties4 = popupProperties3;
                }
                function4 = function1;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
                }
            }
            i3 |= 24576;
            function3 = function2;
            if ((46811 & i3) == 9362) {
                if (i9 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    jIntOffset = IntOffsetKt.IntOffset(0, 0);
                } else {
                    jIntOffset = j2;
                }
                if (i4 != 0) {
                    function1 = null;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                }
                IntOffset intOffsetM3003boximpl116 = IntOffset.m3003boximpl(jIntOffset);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl116) | composerStartRestartGroup.changed(topStart);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = jIntOffset;
                popupProperties4 = popupProperties3;
            } else {
                if (i9 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    jIntOffset = IntOffsetKt.IntOffset(0, 0);
                } else {
                    jIntOffset = j2;
                }
                if (i4 != 0) {
                    function1 = null;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                }
                IntOffset intOffsetM3003boximpl117 = IntOffset.m3003boximpl(jIntOffset);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl117) | composerStartRestartGroup.changed(topStart);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = jIntOffset;
                popupProperties4 = popupProperties3;
            }
            function4 = function1;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
            }
        }
        i3 |= 3072;
        popupProperties2 = popupProperties;
        if ((i2 & 16) != 0) {
            if ((57344 & i) == 0) {
                function3 = function2;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((46811 & i3) == 9362) {
                if (i9 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    jIntOffset = IntOffsetKt.IntOffset(0, 0);
                } else {
                    jIntOffset = j2;
                }
                if (i4 != 0) {
                    function1 = null;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                }
                IntOffset intOffsetM3003boximpl118 = IntOffset.m3003boximpl(jIntOffset);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl118) | composerStartRestartGroup.changed(topStart);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = jIntOffset;
                popupProperties4 = popupProperties3;
            } else {
                if (i9 != 0) {
                    topStart = Alignment.INSTANCE.getTopStart();
                } else {
                    topStart = alignment2;
                }
                if (i10 != 0) {
                    jIntOffset = IntOffsetKt.IntOffset(0, 0);
                } else {
                    jIntOffset = j2;
                }
                if (i4 != 0) {
                    function1 = null;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
                }
                IntOffset intOffsetM3003boximpl119 = IntOffset.m3003boximpl(jIntOffset);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl119) | composerStartRestartGroup.changed(topStart);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = jIntOffset;
                popupProperties4 = popupProperties3;
            }
            function4 = function1;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
            }
        }
        i3 |= 24576;
        function3 = function2;
        if ((46811 & i3) == 9362) {
            if (i9 != 0) {
                topStart = Alignment.INSTANCE.getTopStart();
            } else {
                topStart = alignment2;
            }
            if (i10 != 0) {
                jIntOffset = IntOffsetKt.IntOffset(0, 0);
            } else {
                jIntOffset = j2;
            }
            if (i4 != 0) {
                function1 = null;
            }
            if (i6 != 0) {
                popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
            } else {
                popupProperties3 = popupProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
            }
            IntOffset intOffsetM3003boximpl1110 = IntOffset.m3003boximpl(jIntOffset);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl1110) | composerStartRestartGroup.changed(topStart);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = jIntOffset;
            popupProperties4 = popupProperties3;
        } else {
            if (i9 != 0) {
                topStart = Alignment.INSTANCE.getTopStart();
            } else {
                topStart = alignment2;
            }
            if (i10 != 0) {
                jIntOffset = IntOffsetKt.IntOffset(0, 0);
            } else {
                jIntOffset = j2;
            }
            if (i4 != 0) {
                function1 = null;
            }
            if (i6 != 0) {
                popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
            } else {
                popupProperties3 = popupProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(295309329, i3, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:194)");
            }
            IntOffset intOffsetM3003boximpl1111 = IntOffset.m3003boximpl(jIntOffset);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(intOffsetM3003boximpl1111) | composerStartRestartGroup.changed(topStart);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new AlignmentOffsetPositionProvider(topStart, jIntOffset, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Popup((AlignmentOffsetPositionProvider) objRememberedValue, function1, popupProperties3, function3, composerStartRestartGroup, (i3 >> 3) & 8176, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = jIntOffset;
            popupProperties4 = popupProperties3;
        }
        function4 = function1;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(topStart, j3, function4, popupProperties4, function2, i, i2));
        }
    }

    /* WARN: Code duplicated, block: B:26:0x004b  */
    /* WARN: Code duplicated, block: B:27:0x004e  */
    /* WARN: Code duplicated, block: B:29:0x0052  */
    /* WARN: Code duplicated, block: B:31:0x005a  */
    /* WARN: Code duplicated, block: B:32:0x005d  */
    /* WARN: Code duplicated, block: B:37:0x0067  */
    /* WARN: Code duplicated, block: B:38:0x006a  */
    /* WARN: Code duplicated, block: B:40:0x006e  */
    /* WARN: Code duplicated, block: B:42:0x0074  */
    /* WARN: Code duplicated, block: B:43:0x0077  */
    /* WARN: Code duplicated, block: B:47:0x0081  */
    /* WARN: Code duplicated, block: B:51:0x0090 A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:52:0x0092  */
    /* WARN: Code duplicated, block: B:53:0x0095  */
    /* WARN: Code duplicated, block: B:55:0x0099  */
    /* WARN: Code duplicated, block: B:56:0x00af  */
    /* WARN: Code duplicated, block: B:59:0x00b7  */
    /* WARN: Code duplicated, block: B:62:0x014b  */
    /* WARN: Code duplicated, block: B:63:0x0178  */
    /* WARN: Code duplicated, block: B:66:0x01f1  */
    /* WARN: Code duplicated, block: B:69:0x01fd  */
    /* WARN: Code duplicated, block: B:70:0x0201  */
    /* WARN: Code duplicated, block: B:73:0x0226  */
    /* WARN: Code duplicated, block: B:75:0x0234  */
    /* WARN: Code duplicated, block: B:78:0x0271  */
    /* WARN: Code duplicated, block: B:82:0x027e  */
    /* WARN: Code duplicated, block: B:84:? A[RETURN, SYNTHETIC] */
    public static final void Popup(PopupPositionProvider popupPositionProvider, Function0<Unit> function0, PopupProperties popupProperties, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Function0<Unit> function1;
        int i4;
        PopupProperties popupProperties2;
        int i5;
        int i6;
        int i7;
        Function0<Unit> function3;
        PopupProperties popupProperties3;
        View view;
        Density density;
        String str;
        CompositionContext compositionContextRememberCompositionContext;
        State stateRememberUpdatedState;
        UUID uuid;
        Object objRememberedValue;
        Composer composer2;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM60constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Function0<Unit> function4;
        PopupProperties popupProperties4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        PopupPositionProvider popupPositionProvider2 = popupPositionProvider;
        Composer composerStartRestartGroup = composer.startRestartGroup(-830247068);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Popup)P(2,1,3)229@9749L7,230@9788L7,231@9832L7,232@9887L7,233@9923L28,234@9978L29,235@10026L38,236@10087L944,264@11037L417,279@11460L229,288@11695L166,300@12424L175,310@12777L771:AndroidPopup.android.kt#2oxthz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 112) == 0) {
                function1 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                i7 = i3;
                if ((i7 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                    if (i8 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i4 != 0) {
                        popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                    } else {
                        popupProperties3 = popupProperties2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-830247068, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:228)");
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
                    ProvidableCompositionLocal<String> providableCompositionLocal = LocalPopupTestTag;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    str = (String) objConsume3;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    LayoutDirection layoutDirection = (LayoutDirection) objConsume4;
                    compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i7 >> 9) & 14);
                    uuid = (UUID) RememberSaveableKt.m147rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        composer2 = composerStartRestartGroup;
                        PopupLayout popupLayout = new PopupLayout(function3, popupProperties3, str, view, density, popupPositionProvider2, uuid, null, 128, null);
                        popupPositionProvider2 = popupPositionProvider2;
                        popupLayout.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout, stateRememberUpdatedState)));
                        composer2.updateRememberedValue(popupLayout);
                        objRememberedValue = popupLayout;
                    } else {
                        composer2 = composerStartRestartGroup;
                    }
                    composer2.endReplaceableGroup();
                    PopupLayout popupLayout2 = (PopupLayout) objRememberedValue;
                    EffectsKt.DisposableEffect(popupLayout2, new AnonymousClass2(popupLayout2, function3, popupProperties3, str, layoutDirection), composer2, 8);
                    EffectsKt.SideEffect(new AnonymousClass3(popupLayout2, function3, popupProperties3, str, layoutDirection), composer2, 0);
                    EffectsKt.DisposableEffect(popupPositionProvider2, new AnonymousClass4(popupLayout2, popupPositionProvider2), composer2, i7 & 14);
                    EffectsKt.LaunchedEffect(popupLayout2, new AnonymousClass5(popupLayout2, null), composer2, 72);
                    Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new AnonymousClass7(popupLayout2));
                    AnonymousClass8 anonymousClass8 = new AnonymousClass8(popupLayout2, layoutDirection);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierOnGloballyPositioned);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    composerM60constructorimpl = Updater.m60constructorimpl(composer2);
                    Updater.m67setimpl(composerM60constructorimpl, anonymousClass8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m67setimpl(composerM60constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM60constructorimpl.getInserting() || !Intrinsics.areEqual(composerM60constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    function3ModifierMaterializerOf.invoke(SkippableUpdater.m51boximpl(SkippableUpdater.m52constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1097164990, "C:AndroidPopup.android.kt#2oxthz");
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function3;
                    popupProperties4 = popupProperties3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function4 = function1;
                    composer2 = composerStartRestartGroup;
                    popupProperties4 = popupProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(popupPositionProvider2, function4, popupProperties4, function2, i, i2));
                }
            }
            i3 |= Constants.appIconsCacheSize;
            popupProperties2 = popupProperties;
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            i7 = i3;
            if ((i7 & 5851) == 1170) {
                if (i8 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (i4 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-830247068, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:228)");
                }
                ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localView2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume5;
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume6;
                ProvidableCompositionLocal<String> providableCompositionLocal2 = LocalPopupTestTag;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(providableCompositionLocal2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                str = (String) objConsume7;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection2 = (LayoutDirection) objConsume8;
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i7 >> 9) & 14);
                uuid = (UUID) RememberSaveableKt.m147rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    composer2 = composerStartRestartGroup;
                    PopupLayout popupLayout3 = new PopupLayout(function3, popupProperties3, str, view, density, popupPositionProvider2, uuid, null, 128, null);
                    popupPositionProvider2 = popupPositionProvider2;
                    popupLayout3.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout3, stateRememberUpdatedState)));
                    composer2.updateRememberedValue(popupLayout3);
                    objRememberedValue = popupLayout3;
                } else {
                    composer2 = composerStartRestartGroup;
                }
                composer2.endReplaceableGroup();
                PopupLayout popupLayout4 = (PopupLayout) objRememberedValue;
                EffectsKt.DisposableEffect(popupLayout4, new AnonymousClass2(popupLayout4, function3, popupProperties3, str, layoutDirection2), composer2, 8);
                EffectsKt.SideEffect(new AnonymousClass3(popupLayout4, function3, popupProperties3, str, layoutDirection2), composer2, 0);
                EffectsKt.DisposableEffect(popupPositionProvider2, new AnonymousClass4(popupLayout4, popupPositionProvider2), composer2, i7 & 14);
                EffectsKt.LaunchedEffect(popupLayout4, new AnonymousClass5(popupLayout4, null), composer2, 72);
                Modifier modifierOnGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new AnonymousClass7(popupLayout4));
                AnonymousClass8 anonymousClass9 = new AnonymousClass8(popupLayout4, layoutDirection2);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierOnGloballyPositioned2);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composerM60constructorimpl = Updater.m60constructorimpl(composer2);
                Updater.m67setimpl(composerM60constructorimpl, anonymousClass9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m67setimpl(composerM60constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM60constructorimpl.getInserting()) {
                    composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                function3ModifierMaterializerOf2.invoke(SkippableUpdater.m51boximpl(SkippableUpdater.m52constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, 1097164990, "C:AndroidPopup.android.kt#2oxthz");
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function3;
                popupProperties4 = popupProperties3;
            } else {
                if (i8 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (i4 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-830247068, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:228)");
                }
                ProvidableCompositionLocal<View> localView3 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume9 = composerStartRestartGroup.consume(localView3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume9;
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume10 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume10;
                ProvidableCompositionLocal<String> providableCompositionLocal3 = LocalPopupTestTag;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume11 = composerStartRestartGroup.consume(providableCompositionLocal3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                str = (String) objConsume11;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume12 = composerStartRestartGroup.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection3 = (LayoutDirection) objConsume12;
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i7 >> 9) & 14);
                uuid = (UUID) RememberSaveableKt.m147rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    composer2 = composerStartRestartGroup;
                    PopupLayout popupLayout5 = new PopupLayout(function3, popupProperties3, str, view, density, popupPositionProvider2, uuid, null, 128, null);
                    popupPositionProvider2 = popupPositionProvider2;
                    popupLayout5.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout5, stateRememberUpdatedState)));
                    composer2.updateRememberedValue(popupLayout5);
                    objRememberedValue = popupLayout5;
                } else {
                    composer2 = composerStartRestartGroup;
                }
                composer2.endReplaceableGroup();
                PopupLayout popupLayout6 = (PopupLayout) objRememberedValue;
                EffectsKt.DisposableEffect(popupLayout6, new AnonymousClass2(popupLayout6, function3, popupProperties3, str, layoutDirection3), composer2, 8);
                EffectsKt.SideEffect(new AnonymousClass3(popupLayout6, function3, popupProperties3, str, layoutDirection3), composer2, 0);
                EffectsKt.DisposableEffect(popupPositionProvider2, new AnonymousClass4(popupLayout6, popupPositionProvider2), composer2, i7 & 14);
                EffectsKt.LaunchedEffect(popupLayout6, new AnonymousClass5(popupLayout6, null), composer2, 72);
                Modifier modifierOnGloballyPositioned3 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new AnonymousClass7(popupLayout6));
                AnonymousClass8 anonymousClass10 = new AnonymousClass8(popupLayout6, layoutDirection3);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierOnGloballyPositioned3);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composerM60constructorimpl = Updater.m60constructorimpl(composer2);
                Updater.m67setimpl(composerM60constructorimpl, anonymousClass10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m67setimpl(composerM60constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM60constructorimpl.getInserting()) {
                    composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                function3ModifierMaterializerOf3.invoke(SkippableUpdater.m51boximpl(SkippableUpdater.m52constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, 1097164990, "C:AndroidPopup.android.kt#2oxthz");
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function3;
                popupProperties4 = popupProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(popupPositionProvider2, function4, popupProperties4, function2, i, i2));
            }
        }
        i3 |= 48;
        function1 = function0;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                popupProperties2 = popupProperties;
                if (composerStartRestartGroup.changed(popupProperties2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            i7 = i3;
            if ((i7 & 5851) == 1170) {
                if (i8 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (i4 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-830247068, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:228)");
                }
                ProvidableCompositionLocal<View> localView4 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume13 = composerStartRestartGroup.consume(localView4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume13;
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume14 = composerStartRestartGroup.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume14;
                ProvidableCompositionLocal<String> providableCompositionLocal4 = LocalPopupTestTag;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume15 = composerStartRestartGroup.consume(providableCompositionLocal4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                str = (String) objConsume15;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume16 = composerStartRestartGroup.consume(localLayoutDirection4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection4 = (LayoutDirection) objConsume16;
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i7 >> 9) & 14);
                uuid = (UUID) RememberSaveableKt.m147rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    composer2 = composerStartRestartGroup;
                    PopupLayout popupLayout7 = new PopupLayout(function3, popupProperties3, str, view, density, popupPositionProvider2, uuid, null, 128, null);
                    popupPositionProvider2 = popupPositionProvider2;
                    popupLayout7.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout7, stateRememberUpdatedState)));
                    composer2.updateRememberedValue(popupLayout7);
                    objRememberedValue = popupLayout7;
                } else {
                    composer2 = composerStartRestartGroup;
                }
                composer2.endReplaceableGroup();
                PopupLayout popupLayout8 = (PopupLayout) objRememberedValue;
                EffectsKt.DisposableEffect(popupLayout8, new AnonymousClass2(popupLayout8, function3, popupProperties3, str, layoutDirection4), composer2, 8);
                EffectsKt.SideEffect(new AnonymousClass3(popupLayout8, function3, popupProperties3, str, layoutDirection4), composer2, 0);
                EffectsKt.DisposableEffect(popupPositionProvider2, new AnonymousClass4(popupLayout8, popupPositionProvider2), composer2, i7 & 14);
                EffectsKt.LaunchedEffect(popupLayout8, new AnonymousClass5(popupLayout8, null), composer2, 72);
                Modifier modifierOnGloballyPositioned4 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new AnonymousClass7(popupLayout8));
                AnonymousClass8 anonymousClass11 = new AnonymousClass8(popupLayout8, layoutDirection4);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(modifierOnGloballyPositioned4);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composerM60constructorimpl = Updater.m60constructorimpl(composer2);
                Updater.m67setimpl(composerM60constructorimpl, anonymousClass11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m67setimpl(composerM60constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM60constructorimpl.getInserting()) {
                    composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                function3ModifierMaterializerOf4.invoke(SkippableUpdater.m51boximpl(SkippableUpdater.m52constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, 1097164990, "C:AndroidPopup.android.kt#2oxthz");
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function3;
                popupProperties4 = popupProperties3;
            } else {
                if (i8 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (i4 != 0) {
                    popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
                } else {
                    popupProperties3 = popupProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-830247068, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:228)");
                }
                ProvidableCompositionLocal<View> localView5 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume17 = composerStartRestartGroup.consume(localView5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume17;
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume18 = composerStartRestartGroup.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume18;
                ProvidableCompositionLocal<String> providableCompositionLocal5 = LocalPopupTestTag;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume19 = composerStartRestartGroup.consume(providableCompositionLocal5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                str = (String) objConsume19;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume110 = composerStartRestartGroup.consume(localLayoutDirection5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LayoutDirection layoutDirection5 = (LayoutDirection) objConsume110;
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i7 >> 9) & 14);
                uuid = (UUID) RememberSaveableKt.m147rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    composer2 = composerStartRestartGroup;
                    PopupLayout popupLayout9 = new PopupLayout(function3, popupProperties3, str, view, density, popupPositionProvider2, uuid, null, 128, null);
                    popupPositionProvider2 = popupPositionProvider2;
                    popupLayout9.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout9, stateRememberUpdatedState)));
                    composer2.updateRememberedValue(popupLayout9);
                    objRememberedValue = popupLayout9;
                } else {
                    composer2 = composerStartRestartGroup;
                }
                composer2.endReplaceableGroup();
                PopupLayout popupLayout10 = (PopupLayout) objRememberedValue;
                EffectsKt.DisposableEffect(popupLayout10, new AnonymousClass2(popupLayout10, function3, popupProperties3, str, layoutDirection5), composer2, 8);
                EffectsKt.SideEffect(new AnonymousClass3(popupLayout10, function3, popupProperties3, str, layoutDirection5), composer2, 0);
                EffectsKt.DisposableEffect(popupPositionProvider2, new AnonymousClass4(popupLayout10, popupPositionProvider2), composer2, i7 & 14);
                EffectsKt.LaunchedEffect(popupLayout10, new AnonymousClass5(popupLayout10, null), composer2, 72);
                Modifier modifierOnGloballyPositioned5 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new AnonymousClass7(popupLayout10));
                AnonymousClass8 anonymousClass12 = new AnonymousClass8(popupLayout10, layoutDirection5);
                composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(modifierOnGloballyPositioned5);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composerM60constructorimpl = Updater.m60constructorimpl(composer2);
                Updater.m67setimpl(composerM60constructorimpl, anonymousClass12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m67setimpl(composerM60constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM60constructorimpl.getInserting()) {
                    composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                function3ModifierMaterializerOf5.invoke(SkippableUpdater.m51boximpl(SkippableUpdater.m52constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composer2, 1097164990, "C:AndroidPopup.android.kt#2oxthz");
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function3;
                popupProperties4 = popupProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(popupPositionProvider2, function4, popupProperties4, function2, i, i2));
            }
        }
        i3 |= Constants.appIconsCacheSize;
        popupProperties2 = popupProperties;
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        i7 = i3;
        if ((i7 & 5851) == 1170) {
            if (i8 != 0) {
                function3 = null;
            } else {
                function3 = function1;
            }
            if (i4 != 0) {
                popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
            } else {
                popupProperties3 = popupProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-830247068, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:228)");
            }
            ProvidableCompositionLocal<View> localView6 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume111 = composerStartRestartGroup.consume(localView6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            view = (View) objConsume111;
            ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume112 = composerStartRestartGroup.consume(localDensity6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume112;
            ProvidableCompositionLocal<String> providableCompositionLocal6 = LocalPopupTestTag;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume113 = composerStartRestartGroup.consume(providableCompositionLocal6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            str = (String) objConsume113;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume114 = composerStartRestartGroup.consume(localLayoutDirection6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection6 = (LayoutDirection) objConsume114;
            compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i7 >> 9) & 14);
            uuid = (UUID) RememberSaveableKt.m147rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                composer2 = composerStartRestartGroup;
                PopupLayout popupLayout11 = new PopupLayout(function3, popupProperties3, str, view, density, popupPositionProvider2, uuid, null, 128, null);
                popupPositionProvider2 = popupPositionProvider2;
                popupLayout11.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout11, stateRememberUpdatedState)));
                composer2.updateRememberedValue(popupLayout11);
                objRememberedValue = popupLayout11;
            } else {
                composer2 = composerStartRestartGroup;
            }
            composer2.endReplaceableGroup();
            PopupLayout popupLayout12 = (PopupLayout) objRememberedValue;
            EffectsKt.DisposableEffect(popupLayout12, new AnonymousClass2(popupLayout12, function3, popupProperties3, str, layoutDirection6), composer2, 8);
            EffectsKt.SideEffect(new AnonymousClass3(popupLayout12, function3, popupProperties3, str, layoutDirection6), composer2, 0);
            EffectsKt.DisposableEffect(popupPositionProvider2, new AnonymousClass4(popupLayout12, popupPositionProvider2), composer2, i7 & 14);
            EffectsKt.LaunchedEffect(popupLayout12, new AnonymousClass5(popupLayout12, null), composer2, 72);
            Modifier modifierOnGloballyPositioned6 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new AnonymousClass7(popupLayout12));
            AnonymousClass8 anonymousClass13 = new AnonymousClass8(popupLayout12, layoutDirection6);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(modifierOnGloballyPositioned6);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composerM60constructorimpl = Updater.m60constructorimpl(composer2);
            Updater.m67setimpl(composerM60constructorimpl, anonymousClass13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m67setimpl(composerM60constructorimpl, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM60constructorimpl.getInserting()) {
                composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf6.invoke(SkippableUpdater.m51boximpl(SkippableUpdater.m52constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, 1097164990, "C:AndroidPopup.android.kt#2oxthz");
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function3;
            popupProperties4 = popupProperties3;
        } else {
            if (i8 != 0) {
                function3 = null;
            } else {
                function3 = function1;
            }
            if (i4 != 0) {
                popupProperties3 = new PopupProperties(false, false, false, null, false, false, 63, null);
            } else {
                popupProperties3 = popupProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-830247068, i7, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:228)");
            }
            ProvidableCompositionLocal<View> localView7 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume115 = composerStartRestartGroup.consume(localView7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            view = (View) objConsume115;
            ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume116 = composerStartRestartGroup.consume(localDensity7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume116;
            ProvidableCompositionLocal<String> providableCompositionLocal7 = LocalPopupTestTag;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume117 = composerStartRestartGroup.consume(providableCompositionLocal7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            str = (String) objConsume117;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume118 = composerStartRestartGroup.consume(localLayoutDirection7);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection7 = (LayoutDirection) objConsume118;
            compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i7 >> 9) & 14);
            uuid = (UUID) RememberSaveableKt.m147rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) AndroidPopup_androidKt$Popup$popupId$1.INSTANCE, composerStartRestartGroup, 3080, 6);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                composer2 = composerStartRestartGroup;
                PopupLayout popupLayout13 = new PopupLayout(function3, popupProperties3, str, view, density, popupPositionProvider2, uuid, null, 128, null);
                popupPositionProvider2 = popupPositionProvider2;
                popupLayout13.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1302892335, true, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout13, stateRememberUpdatedState)));
                composer2.updateRememberedValue(popupLayout13);
                objRememberedValue = popupLayout13;
            } else {
                composer2 = composerStartRestartGroup;
            }
            composer2.endReplaceableGroup();
            PopupLayout popupLayout14 = (PopupLayout) objRememberedValue;
            EffectsKt.DisposableEffect(popupLayout14, new AnonymousClass2(popupLayout14, function3, popupProperties3, str, layoutDirection7), composer2, 8);
            EffectsKt.SideEffect(new AnonymousClass3(popupLayout14, function3, popupProperties3, str, layoutDirection7), composer2, 0);
            EffectsKt.DisposableEffect(popupPositionProvider2, new AnonymousClass4(popupLayout14, popupPositionProvider2), composer2, i7 & 14);
            EffectsKt.LaunchedEffect(popupLayout14, new AnonymousClass5(popupLayout14, null), composer2, 72);
            Modifier modifierOnGloballyPositioned7 = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new AnonymousClass7(popupLayout14));
            AnonymousClass8 anonymousClass14 = new AnonymousClass8(popupLayout14, layoutDirection7);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(modifierOnGloballyPositioned7);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composerM60constructorimpl = Updater.m60constructorimpl(composer2);
            Updater.m67setimpl(composerM60constructorimpl, anonymousClass14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m67setimpl(composerM60constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM60constructorimpl.getInserting()) {
                composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf7.invoke(SkippableUpdater.m51boximpl(SkippableUpdater.m52constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, 1097164990, "C:AndroidPopup.android.kt#2oxthz");
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function3;
            popupProperties4 = popupProperties3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass9(popupPositionProvider2, function4, popupProperties4, function2, i, i2));
        }
    }

    /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2, reason: invalid class name */
    /* INFO: compiled from: AndroidPopup.android.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ LayoutDirection $layoutDirection;
        final /* synthetic */ Function0<Unit> $onDismissRequest;
        final /* synthetic */ PopupLayout $popupLayout;
        final /* synthetic */ PopupProperties $properties;
        final /* synthetic */ String $testTag;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PopupLayout popupLayout, Function0<Unit> function0, PopupProperties popupProperties, String str, LayoutDirection layoutDirection) {
            super(1);
            this.$popupLayout = popupLayout;
            this.$onDismissRequest = function0;
            this.$properties = popupProperties;
            this.$testTag = str;
            this.$layoutDirection = layoutDirection;
        }

        @Override // kotlin.jvm.functions.Function1
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            this.$popupLayout.show();
            this.$popupLayout.updateParameters(this.$onDismissRequest, this.$properties, this.$testTag, this.$layoutDirection);
            return new AndroidPopup_androidKt$Popup$2$invoke$$inlined$onDispose$1(this.$popupLayout);
        }
    }

    /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3, reason: invalid class name */
    /* INFO: compiled from: AndroidPopup.android.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        final /* synthetic */ LayoutDirection $layoutDirection;
        final /* synthetic */ Function0<Unit> $onDismissRequest;
        final /* synthetic */ PopupLayout $popupLayout;
        final /* synthetic */ PopupProperties $properties;
        final /* synthetic */ String $testTag;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PopupLayout popupLayout, Function0<Unit> function0, PopupProperties popupProperties, String str, LayoutDirection layoutDirection) {
            super(0);
            this.$popupLayout = popupLayout;
            this.$onDismissRequest = function0;
            this.$properties = popupProperties;
            this.$testTag = str;
            this.$layoutDirection = layoutDirection;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$popupLayout.updateParameters(this.$onDismissRequest, this.$properties, this.$testTag, this.$layoutDirection);
        }
    }

    /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$4, reason: invalid class name */
    /* INFO: compiled from: AndroidPopup.android.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass4 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ PopupLayout $popupLayout;
        final /* synthetic */ PopupPositionProvider $popupPositionProvider;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(PopupLayout popupLayout, PopupPositionProvider popupPositionProvider) {
            super(1);
            this.$popupLayout = popupLayout;
            this.$popupPositionProvider = popupPositionProvider;
        }

        @Override // kotlin.jvm.functions.Function1
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            this.$popupLayout.setPositionProvider(this.$popupPositionProvider);
            this.$popupLayout.updatePosition();
            return new AndroidPopup_androidKt$Popup$4$invoke$$inlined$onDispose$1();
        }
    }

    /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5, reason: invalid class name */
    /* INFO: compiled from: AndroidPopup.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5", f = "AndroidPopup.android.kt", i = {0}, l = {303}, m = "invokeSuspend", n = {"$this$LaunchedEffect"}, s = {"L$0"})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PopupLayout $popupLayout;
        private /* synthetic */ Object L$0;
        int label;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(PopupLayout popupLayout, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$popupLayout = popupLayout;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$popupLayout, continuation);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* WARN: Code duplicated, block: B:11:0x0029  */
        /* WARN: Code duplicated, block: B:13:0x003a A[RETURN] */
        /* WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0038 -> B:14:0x003b). Please report as a decompilation issue!!! */
        /* ERROR: decompilerOverflowException in pass: RegionMakerVisitor
            decompiler.core.utils.exceptions.decompilerOverflowException: Regions stack size limit reached
            	at decompiler.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at decompiler.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at decompiler.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r4.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r5)
                goto L3b
            L13:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1b:
                kotlin.ResultKt.throwOnFailure(r5)
                java.lang.Object r5 = r4.L$0
                kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
                r1 = r5
            L23:
                boolean r5 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r5 == 0) goto L41
                androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5$1 r5 = androidx.compose.ui.window.AndroidPopup_androidKt.AnonymousClass5.AnonymousClass1.INSTANCE
                kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                r3 = r4
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r4.L$0 = r1
                r4.label = r2
                java.lang.Object r5 = androidx.compose.ui.platform.InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(r5, r3)
                if (r5 != r0) goto L3b
                return r0
            L3b:
                androidx.compose.ui.window.PopupLayout r5 = r4.$popupLayout
                r5.pollForLocationOnScreenChange()
                goto L23
            L41:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.AnonymousClass5.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$5$1, reason: invalid class name */
        /* INFO: compiled from: AndroidPopup.android.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(1);
            }

            public final void invoke(long j) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }
        }
    }

    /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$7, reason: invalid class name */
    /* INFO: compiled from: AndroidPopup.android.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "childCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass7 extends Lambda implements Function1<LayoutCoordinates, Unit> {
        final /* synthetic */ PopupLayout $popupLayout;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(PopupLayout popupLayout) {
            super(1);
            this.$popupLayout = popupLayout;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
            invoke2(layoutCoordinates);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LayoutCoordinates layoutCoordinates) {
            LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
            Intrinsics.checkNotNull(parentLayoutCoordinates);
            this.$popupLayout.updateParentLayoutCoordinates(parentLayoutCoordinates);
        }
    }

    /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8, reason: invalid class name */
    /* INFO: compiled from: AndroidPopup.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "<anonymous parameter 0>", "", "Landroidx/compose/ui/layout/Measurable;", "<anonymous parameter 1>", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass8 implements MeasurePolicy {
        final /* synthetic */ LayoutDirection $layoutDirection;
        final /* synthetic */ PopupLayout $popupLayout;

        AnonymousClass8(PopupLayout popupLayout, LayoutDirection layoutDirection) {
            this.$popupLayout = popupLayout;
            this.$layoutDirection = layoutDirection;
        }

        /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1, reason: invalid class name */
        /* INFO: compiled from: AndroidPopup.android.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class AnonymousClass1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(1);
            }

            /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* INFO: renamed from: measure-3p2s80s */
        public final MeasureResult mo1841measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
            this.$popupLayout.setParentLayoutDirection(this.$layoutDirection);
            return MeasureScope.layout$default(measureScope, 0, 0, null, AnonymousClass1.INSTANCE, 4, null);
        }
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    public static final void PopupTestTag(String str, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-498879600);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PopupTestTag)P(1)334@13923L75:AndroidPopup.android.kt#2oxthz");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-498879600, i2, -1, "androidx.compose.ui.window.PopupTestTag (AndroidPopup.android.kt:333)");
            }
            CompositionLocalKt.CompositionLocalProvider(LocalPopupTestTag.provides(str), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new C01421(str, function2, i));
        }
    }

    /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: AndroidPopup.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class C01431 implements MeasurePolicy {
        public static final C01431 INSTANCE = new C01431();

        /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1, reason: invalid class name and collision with other inner class name */
        /* INFO: compiled from: AndroidPopup.android.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class C00091 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
            public static final C00091 INSTANCE = new C00091();

            public C00091() {
                super(1);
            }

            /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* INFO: renamed from: measure-3p2s80s */
        public final MeasureResult mo1841measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
            int i;
            int i2;
            int size = list.size();
            if (size == 0) {
                return MeasureScope.layout$default(measureScope, 0, 0, null, C00091.INSTANCE, 4, null);
            }
            int i3 = 0;
            if (size == 1) {
                Placeable placeableMo1824measureBRTryo0 = list.get(0).mo1824measureBRTryo0(j);
                return MeasureScope.layout$default(measureScope, placeableMo1824measureBRTryo0.getWidth(), placeableMo1824measureBRTryo0.getHeight(), null, new AnonymousClass2(placeableMo1824measureBRTryo0), 4, null);
            }
            ArrayList arrayList = new ArrayList(list.size());
            int size2 = list.size();
            for (int i4 = 0; i4 < size2; i4++) {
                arrayList.add(list.get(i4).mo1824measureBRTryo0(j));
            }
            ArrayList arrayList2 = arrayList;
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            if (lastIndex >= 0) {
                int iMax = 0;
                int iMax2 = 0;
                while (true) {
                    Placeable placeable = (Placeable) arrayList2.get(i3);
                    iMax = Math.max(iMax, placeable.getWidth());
                    iMax2 = Math.max(iMax2, placeable.getHeight());
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
                }
                i = iMax;
                i2 = iMax2;
            } else {
                i = 0;
                i2 = 0;
            }
            return MeasureScope.layout$default(measureScope, i, i2, null, new AnonymousClass3(arrayList2), 4, null);
        }

        /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$2, reason: invalid class name */
        /* INFO: compiled from: AndroidPopup.android.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class AnonymousClass2 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
            final /* synthetic */ Placeable $p;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(Placeable placeable) {
                super(1);
                this.$p = placeable;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, this.$p, 0, 0, 0.0f, 4, null);
            }
        }

        /* INFO: renamed from: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$3, reason: invalid class name */
        /* INFO: compiled from: AndroidPopup.android.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class AnonymousClass3 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
            final /* synthetic */ List<Placeable> $placeables;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* WARN: Multi-variable type inference failed */
            public AnonymousClass3(List<? extends Placeable> list) {
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
                int lastIndex = CollectionsKt.getLastIndex(this.$placeables);
                if (lastIndex < 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    Placeable.PlacementScope placementScope2 = placementScope;
                    Placeable.PlacementScope.placeRelative$default(placementScope2, this.$placeables.get(i), 0, 0, 0.0f, 4, null);
                    if (i == lastIndex) {
                        return;
                    }
                    i++;
                    placementScope = placementScope2;
                }
            }
        }
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        composer.startReplaceableGroup(1406149896);
        ComposerKt.sourceInformation(composer, "CC(SimpleStack)P(1)342@14261L979:AndroidPopup.android.kt#2oxthz");
        C01431 c01431 = C01431.INSTANCE;
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        int i2 = (((((i << 3) & 112) | ((i >> 3) & 14)) << 9) & 7168) | 6;
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
        Updater.m67setimpl(composerM60constructorimpl, c01431, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m67setimpl(composerM60constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM60constructorimpl.getInserting() || !Intrinsics.areEqual(composerM60constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM60constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM60constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        function3ModifierMaterializerOf.invoke(SkippableUpdater.m51boximpl(SkippableUpdater.m52constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i2 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    public static final boolean isFlagSecureEnabled(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }

    /* INFO: Access modifiers changed from: private */
    public static final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static /* synthetic */ boolean isPopupLayout$default(View view, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return isPopupLayout(view, str);
    }

    public static final boolean isPopupLayout(View view, String str) {
        if (view instanceof PopupLayout) {
            return str == null || Intrinsics.areEqual(str, ((PopupLayout) view).getTestTag());
        }
        return false;
    }

    /* INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> Popup$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
