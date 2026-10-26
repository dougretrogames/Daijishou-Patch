package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.constraintlayout.motion.widget.Key;
import androidx.profileinstaller.ProfileVerifier;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.magneticchen.daijishou.application_data.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.eclipse.jgit.lib.FileMode;

/* INFO: compiled from: VectorCompose.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a¦\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Group", "", "name", "", Key.ROTATION, "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VectorComposeKt {

    /* INFO: renamed from: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$4, reason: invalid class name */
    /* INFO: compiled from: VectorCompose.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass4 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ List<PathNode> $clipPathData;
        final /* synthetic */ Function2<Composer, Integer, Unit> $content;
        final /* synthetic */ String $name;
        final /* synthetic */ float $pivotX;
        final /* synthetic */ float $pivotY;
        final /* synthetic */ float $rotation;
        final /* synthetic */ float $scaleX;
        final /* synthetic */ float $scaleY;
        final /* synthetic */ float $translationX;
        final /* synthetic */ float $translationY;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* WARN: Multi-variable type inference failed */
        AnonymousClass4(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List<? extends PathNode> list, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
            super(2);
            this.$name = str;
            this.$rotation = f;
            this.$pivotX = f2;
            this.$pivotY = f3;
            this.$scaleX = f4;
            this.$scaleY = f5;
            this.$translationX = f6;
            this.$translationY = f7;
            this.$clipPathData = list;
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
            VectorComposeKt.Group(this.$name, this.$rotation, this.$pivotX, this.$pivotY, this.$scaleX, this.$scaleY, this.$translationX, this.$translationY, this.$clipPathData, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* WARN: Code duplicated, block: B:102:0x0131  */
    /* WARN: Code duplicated, block: B:104:0x013c  */
    /* WARN: Code duplicated, block: B:109:0x0153  */
    /* WARN: Code duplicated, block: B:112:0x015f  */
    /* WARN: Code duplicated, block: B:119:0x0176 A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:120:0x0178  */
    /* WARN: Code duplicated, block: B:123:0x017e  */
    /* WARN: Code duplicated, block: B:125:0x0181  */
    /* WARN: Code duplicated, block: B:127:0x0184  */
    /* WARN: Code duplicated, block: B:130:0x0189  */
    /* WARN: Code duplicated, block: B:131:0x018b  */
    /* WARN: Code duplicated, block: B:134:0x0190  */
    /* WARN: Code duplicated, block: B:136:0x0193  */
    /* WARN: Code duplicated, block: B:137:0x0195  */
    /* WARN: Code duplicated, block: B:140:0x019a  */
    /* WARN: Code duplicated, block: B:142:0x019e  */
    /* WARN: Code duplicated, block: B:143:0x01a4  */
    /* WARN: Code duplicated, block: B:146:0x01af  */
    /* WARN: Code duplicated, block: B:147:0x01bb  */
    /* WARN: Code duplicated, block: B:150:0x01d4  */
    /* WARN: Code duplicated, block: B:153:0x01e0  */
    /* WARN: Code duplicated, block: B:154:0x01e4  */
    /* WARN: Code duplicated, block: B:157:0x0268  */
    /* WARN: Code duplicated, block: B:161:0x0279  */
    /* WARN: Code duplicated, block: B:163:? A[RETURN, SYNTHETIC] */
    /* WARN: Code duplicated, block: B:26:0x0052  */
    /* WARN: Code duplicated, block: B:27:0x0055  */
    /* WARN: Code duplicated, block: B:29:0x0059  */
    /* WARN: Code duplicated, block: B:31:0x0061  */
    /* WARN: Code duplicated, block: B:32:0x0064  */
    /* WARN: Code duplicated, block: B:37:0x006e  */
    /* WARN: Code duplicated, block: B:38:0x0071  */
    /* WARN: Code duplicated, block: B:40:0x0075  */
    /* WARN: Code duplicated, block: B:42:0x007d  */
    /* WARN: Code duplicated, block: B:43:0x0080  */
    /* WARN: Code duplicated, block: B:48:0x008a  */
    /* WARN: Code duplicated, block: B:49:0x008f  */
    /* WARN: Code duplicated, block: B:51:0x0098  */
    /* WARN: Code duplicated, block: B:53:0x009e  */
    /* WARN: Code duplicated, block: B:54:0x00a1  */
    /* WARN: Code duplicated, block: B:58:0x00a9  */
    /* WARN: Code duplicated, block: B:59:0x00b0  */
    /* WARN: Code duplicated, block: B:61:0x00b8  */
    /* WARN: Code duplicated, block: B:63:0x00be  */
    /* WARN: Code duplicated, block: B:64:0x00c1  */
    /* WARN: Code duplicated, block: B:68:0x00c9  */
    /* WARN: Code duplicated, block: B:69:0x00d0  */
    /* WARN: Code duplicated, block: B:71:0x00d8  */
    /* WARN: Code duplicated, block: B:73:0x00de  */
    /* WARN: Code duplicated, block: B:74:0x00e1  */
    /* WARN: Code duplicated, block: B:78:0x00e9  */
    /* WARN: Code duplicated, block: B:79:0x00ee  */
    /* WARN: Code duplicated, block: B:81:0x00f4  */
    /* WARN: Code duplicated, block: B:83:0x00fe  */
    /* WARN: Code duplicated, block: B:84:0x0101  */
    /* WARN: Code duplicated, block: B:89:0x010e  */
    /* WARN: Code duplicated, block: B:92:0x0118  */
    /* WARN: Code duplicated, block: B:94:0x011c  */
    /* WARN: Code duplicated, block: B:96:0x0121  */
    /* WARN: Code duplicated, block: B:98:0x0127  */
    /* WARN: Code duplicated, block: B:99:0x012a  */
    public static final void Group(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List<? extends PathNode> list, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        String str2;
        int i3;
        float f8;
        int i4;
        float f9;
        int i5;
        int i6;
        float f10;
        int i7;
        int i8;
        int i9;
        int i10;
        float f11;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        float f12;
        float f13;
        float f14;
        float f15;
        List<? extends PathNode> emptyPath;
        AnonymousClass1 anonymousClass1;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-213417674);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Group)P(2,5,3,4,6,7,8,9)58@2500L585:VectorCompose.kt#huu6hf");
        int i19 = i2 & 1;
        if (i19 != 0) {
            i3 = i | 6;
            str2 = str;
        } else if ((i & 14) == 0) {
            str2 = str;
            i3 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            str2 = str;
            i3 = i;
        }
        int i20 = i2 & 2;
        if (i20 == 0) {
            if ((i & 112) == 0) {
                f8 = f;
                i3 |= composerStartRestartGroup.changed(f8) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    f9 = f2;
                    if (composerStartRestartGroup.changed(f9)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        f10 = f3;
                        if (composerStartRestartGroup.changed(f10)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        i3 |= 24576;
                    } else if ((i & FileMode.TYPE_GITLINK) == 0) {
                        if (composerStartRestartGroup.changed(f4)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        f11 = f5;
                    } else {
                        f11 = f5;
                        if ((i & 458752) == 0) {
                            if (composerStartRestartGroup.changed(f11)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(f6)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    i14 = i2 & 128;
                    if (i14 != 0) {
                        if ((i & 29360128) == 0) {
                            if (composerStartRestartGroup.changed(f7)) {
                                i15 = 8388608;
                            } else {
                                i15 = 4194304;
                            }
                            i3 |= i15;
                        }
                        i16 = i2 & 256;
                        if (i16 != 0) {
                            i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
                        }
                        if ((i2 & 512) != 0) {
                            if ((1879048192 & i) == 0) {
                                if (composerStartRestartGroup.changedInstance(function2)) {
                                    i17 = 536870912;
                                } else {
                                    i17 = 268435456;
                                }
                            }
                            if (i16 == 256) {
                                i18 = i16;
                                if ((1533916891 & i3) != 306783378 && composerStartRestartGroup.getSkipping()) {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    f18 = f4;
                                    f19 = f6;
                                    emptyPath = list;
                                    f16 = f8;
                                    f17 = f11;
                                    f20 = f7;
                                }
                                f21 = f10;
                                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                                }
                            }
                            i18 = i16;
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i19 != 0) {
                                    str2 = "";
                                }
                                if (i20 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i4 != 0) {
                                    f9 = 0.0f;
                                }
                                if (i6 != 0) {
                                    f10 = 0.0f;
                                }
                                if (i8 != 0) {
                                    f12 = 1.0f;
                                } else {
                                    f12 = f4;
                                }
                                f13 = i10 == 0 ? f11 : 1.0f;
                                if (i12 != 0) {
                                    f14 = 0.0f;
                                } else {
                                    f14 = f6;
                                }
                                f15 = i14 == 0 ? f7 : 0.0f;
                                if (i18 != 0) {
                                    emptyPath = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    emptyPath = list;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if (i18 != 0) {
                                    i3 &= -234881025;
                                }
                                f12 = f4;
                                f15 = f7;
                                emptyPath = list;
                                f13 = f11;
                                f14 = f6;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                            }
                            anonymousClass1 = AnonymousClass1.INSTANCE;
                            composerStartRestartGroup.startReplaceableGroup(-548224868);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(anonymousClass1);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            Composer composerM60constructorimpl = Updater.m60constructorimpl(composerStartRestartGroup);
                            Updater.m67setimpl(composerM60constructorimpl, str2, VectorComposeKt$Group$2$1.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                            Updater.m67setimpl(composerM60constructorimpl, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                            function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            composerStartRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f16 = f8;
                            f17 = f13;
                            f18 = f12;
                            f19 = f14;
                            f20 = f15;
                            f21 = f10;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                            }
                        }
                        i17 = 805306368;
                        i3 |= i17;
                        if (i16 == 256) {
                            i18 = i16;
                            if ((1533916891 & i3) != 306783378) {
                            }
                            f21 = f10;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                            }
                        }
                        i18 = i16;
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                str2 = "";
                            }
                            if (i20 != 0) {
                                f8 = 0.0f;
                            }
                            if (i4 != 0) {
                                f9 = 0.0f;
                            }
                            if (i6 != 0) {
                                f10 = 0.0f;
                            }
                            if (i8 != 0) {
                                f12 = 1.0f;
                            } else {
                                f12 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f14 = 0.0f;
                            } else {
                                f14 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i18 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i19 != 0) {
                                str2 = "";
                            }
                            if (i20 != 0) {
                                f8 = 0.0f;
                            }
                            if (i4 != 0) {
                                f9 = 0.0f;
                            }
                            if (i6 != 0) {
                                f10 = 0.0f;
                            }
                            if (i8 != 0) {
                                f12 = 1.0f;
                            } else {
                                f12 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f14 = 0.0f;
                            } else {
                                f14 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i18 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                        }
                        anonymousClass1 = AnonymousClass1.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl2 = Updater.m60constructorimpl(composerStartRestartGroup);
                        Updater.m67setimpl(composerM60constructorimpl2, str2, VectorComposeKt$Group$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl2, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl2, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl2, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl2, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl2, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl2, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl2, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl2, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                        function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f16 = f8;
                        f17 = f13;
                        f18 = f12;
                        f19 = f14;
                        f20 = f15;
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i3 |= 12582912;
                    i16 = i2 & 256;
                    if (i16 != 0) {
                        i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i17 = 536870912;
                            } else {
                                i17 = 268435456;
                            }
                        }
                        if (i16 == 256) {
                            i18 = i16;
                            if ((1533916891 & i3) != 306783378) {
                            }
                            f21 = f10;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                            }
                        }
                        i18 = i16;
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                str2 = "";
                            }
                            if (i20 != 0) {
                                f8 = 0.0f;
                            }
                            if (i4 != 0) {
                                f9 = 0.0f;
                            }
                            if (i6 != 0) {
                                f10 = 0.0f;
                            }
                            if (i8 != 0) {
                                f12 = 1.0f;
                            } else {
                                f12 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f14 = 0.0f;
                            } else {
                                f14 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i18 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i19 != 0) {
                                str2 = "";
                            }
                            if (i20 != 0) {
                                f8 = 0.0f;
                            }
                            if (i4 != 0) {
                                f9 = 0.0f;
                            }
                            if (i6 != 0) {
                                f10 = 0.0f;
                            }
                            if (i8 != 0) {
                                f12 = 1.0f;
                            } else {
                                f12 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f14 = 0.0f;
                            } else {
                                f14 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i18 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                        }
                        anonymousClass1 = AnonymousClass1.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl3 = Updater.m60constructorimpl(composerStartRestartGroup);
                        Updater.m67setimpl(composerM60constructorimpl3, str2, VectorComposeKt$Group$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl3, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl3, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl3, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl3, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl3, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl3, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl3, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl3, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                        function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f16 = f8;
                        f17 = f13;
                        f18 = f12;
                        f19 = f14;
                        f20 = f15;
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i17 = 805306368;
                    i3 |= i17;
                    if (i16 == 256) {
                        i18 = i16;
                        if ((1533916891 & i3) != 306783378) {
                        }
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i18 = i16;
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl4 = Updater.m60constructorimpl(composerStartRestartGroup);
                    Updater.m67setimpl(composerM60constructorimpl4, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl4, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl4, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl4, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl4, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl4, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl4, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl4, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl4, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                    function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f16 = f8;
                    f17 = f13;
                    f18 = f12;
                    f19 = f14;
                    f20 = f15;
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i3 |= 3072;
                f10 = f3;
                i8 = i2 & 16;
                if (i8 != 0) {
                    i3 |= 24576;
                } else if ((i & FileMode.TYPE_GITLINK) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    f11 = f5;
                } else {
                    f11 = f5;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(f11)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f6)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(f7)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    i16 = i2 & 256;
                    if (i16 != 0) {
                        i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i17 = 536870912;
                            } else {
                                i17 = 268435456;
                            }
                        }
                        if (i16 == 256) {
                            i18 = i16;
                            if ((1533916891 & i3) != 306783378) {
                            }
                            f21 = f10;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                            }
                        }
                        i18 = i16;
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                str2 = "";
                            }
                            if (i20 != 0) {
                                f8 = 0.0f;
                            }
                            if (i4 != 0) {
                                f9 = 0.0f;
                            }
                            if (i6 != 0) {
                                f10 = 0.0f;
                            }
                            if (i8 != 0) {
                                f12 = 1.0f;
                            } else {
                                f12 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f14 = 0.0f;
                            } else {
                                f14 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i18 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i19 != 0) {
                                str2 = "";
                            }
                            if (i20 != 0) {
                                f8 = 0.0f;
                            }
                            if (i4 != 0) {
                                f9 = 0.0f;
                            }
                            if (i6 != 0) {
                                f10 = 0.0f;
                            }
                            if (i8 != 0) {
                                f12 = 1.0f;
                            } else {
                                f12 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f14 = 0.0f;
                            } else {
                                f14 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i18 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                        }
                        anonymousClass1 = AnonymousClass1.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl5 = Updater.m60constructorimpl(composerStartRestartGroup);
                        Updater.m67setimpl(composerM60constructorimpl5, str2, VectorComposeKt$Group$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl5, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl5, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl5, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl5, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl5, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl5, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl5, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl5, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                        function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f16 = f8;
                        f17 = f13;
                        f18 = f12;
                        f19 = f14;
                        f20 = f15;
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i17 = 805306368;
                    i3 |= i17;
                    if (i16 == 256) {
                        i18 = i16;
                        if ((1533916891 & i3) != 306783378) {
                        }
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i18 = i16;
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl6 = Updater.m60constructorimpl(composerStartRestartGroup);
                    Updater.m67setimpl(composerM60constructorimpl6, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl6, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl6, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl6, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl6, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl6, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl6, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl6, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl6, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                    function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f16 = f8;
                    f17 = f13;
                    f18 = f12;
                    f19 = f14;
                    f20 = f15;
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i3 |= 12582912;
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 536870912;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 == 256) {
                        i18 = i16;
                        if ((1533916891 & i3) != 306783378) {
                        }
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i18 = i16;
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl7 = Updater.m60constructorimpl(composerStartRestartGroup);
                    Updater.m67setimpl(composerM60constructorimpl7, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl7, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl7, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl7, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl7, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl7, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl7, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl7, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl7, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                    function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f16 = f8;
                    f17 = f13;
                    f18 = f12;
                    f19 = f14;
                    f20 = f15;
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i17 = 805306368;
                i3 |= i17;
                if (i16 == 256) {
                    i18 = i16;
                    if ((1533916891 & i3) != 306783378) {
                    }
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i18 = i16;
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM60constructorimpl8 = Updater.m60constructorimpl(composerStartRestartGroup);
                Updater.m67setimpl(composerM60constructorimpl8, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl8, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl8, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl8, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl8, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl8, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl8, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl8, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl8, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f16 = f8;
                f17 = f13;
                f18 = f12;
                f19 = f14;
                f20 = f15;
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i3 |= Constants.appIconsCacheSize;
            f9 = f2;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    f10 = f3;
                    if (composerStartRestartGroup.changed(f10)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    i3 |= 24576;
                } else if ((i & FileMode.TYPE_GITLINK) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    f11 = f5;
                } else {
                    f11 = f5;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(f11)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f6)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(f7)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    i16 = i2 & 256;
                    if (i16 != 0) {
                        i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i17 = 536870912;
                            } else {
                                i17 = 268435456;
                            }
                        }
                        if (i16 == 256) {
                            i18 = i16;
                            if ((1533916891 & i3) != 306783378) {
                            }
                            f21 = f10;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                            }
                        }
                        i18 = i16;
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                str2 = "";
                            }
                            if (i20 != 0) {
                                f8 = 0.0f;
                            }
                            if (i4 != 0) {
                                f9 = 0.0f;
                            }
                            if (i6 != 0) {
                                f10 = 0.0f;
                            }
                            if (i8 != 0) {
                                f12 = 1.0f;
                            } else {
                                f12 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f14 = 0.0f;
                            } else {
                                f14 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i18 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i19 != 0) {
                                str2 = "";
                            }
                            if (i20 != 0) {
                                f8 = 0.0f;
                            }
                            if (i4 != 0) {
                                f9 = 0.0f;
                            }
                            if (i6 != 0) {
                                f10 = 0.0f;
                            }
                            if (i8 != 0) {
                                f12 = 1.0f;
                            } else {
                                f12 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f14 = 0.0f;
                            } else {
                                f14 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i18 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                        }
                        anonymousClass1 = AnonymousClass1.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl9 = Updater.m60constructorimpl(composerStartRestartGroup);
                        Updater.m67setimpl(composerM60constructorimpl9, str2, VectorComposeKt$Group$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl9, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl9, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl9, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl9, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl9, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl9, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl9, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl9, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                        function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f16 = f8;
                        f17 = f13;
                        f18 = f12;
                        f19 = f14;
                        f20 = f15;
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i17 = 805306368;
                    i3 |= i17;
                    if (i16 == 256) {
                        i18 = i16;
                        if ((1533916891 & i3) != 306783378) {
                        }
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i18 = i16;
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl10 = Updater.m60constructorimpl(composerStartRestartGroup);
                    Updater.m67setimpl(composerM60constructorimpl10, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl10, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl10, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl10, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl10, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl10, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl10, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl10, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl10, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                    function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f16 = f8;
                    f17 = f13;
                    f18 = f12;
                    f19 = f14;
                    f20 = f15;
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i3 |= 12582912;
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 536870912;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 == 256) {
                        i18 = i16;
                        if ((1533916891 & i3) != 306783378) {
                        }
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i18 = i16;
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl11 = Updater.m60constructorimpl(composerStartRestartGroup);
                    Updater.m67setimpl(composerM60constructorimpl11, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl11, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl11, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl11, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl11, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl11, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl11, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl11, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl11, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                    function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f16 = f8;
                    f17 = f13;
                    f18 = f12;
                    f19 = f14;
                    f20 = f15;
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i17 = 805306368;
                i3 |= i17;
                if (i16 == 256) {
                    i18 = i16;
                    if ((1533916891 & i3) != 306783378) {
                    }
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i18 = i16;
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM60constructorimpl12 = Updater.m60constructorimpl(composerStartRestartGroup);
                Updater.m67setimpl(composerM60constructorimpl12, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl12, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl12, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl12, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl12, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl12, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl12, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl12, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl12, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f16 = f8;
                f17 = f13;
                f18 = f12;
                f19 = f14;
                f20 = f15;
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i3 |= 3072;
            f10 = f3;
            i8 = i2 & 16;
            if (i8 != 0) {
                i3 |= 24576;
            } else if ((i & FileMode.TYPE_GITLINK) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f11 = f5;
            } else {
                f11 = f5;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f11)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f6)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i14 = i2 & 128;
            if (i14 != 0) {
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 536870912;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 == 256) {
                        i18 = i16;
                        if ((1533916891 & i3) != 306783378) {
                        }
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i18 = i16;
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl13 = Updater.m60constructorimpl(composerStartRestartGroup);
                    Updater.m67setimpl(composerM60constructorimpl13, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl13, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl13, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl13, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl13, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl13, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl13, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl13, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl13, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                    function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f16 = f8;
                    f17 = f13;
                    f18 = f12;
                    f19 = f14;
                    f20 = f15;
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i17 = 805306368;
                i3 |= i17;
                if (i16 == 256) {
                    i18 = i16;
                    if ((1533916891 & i3) != 306783378) {
                    }
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i18 = i16;
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM60constructorimpl14 = Updater.m60constructorimpl(composerStartRestartGroup);
                Updater.m67setimpl(composerM60constructorimpl14, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl14, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl14, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl14, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl14, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl14, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl14, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl14, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl14, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f16 = f8;
                f17 = f13;
                f18 = f12;
                f19 = f14;
                f20 = f15;
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i3 |= 12582912;
            i16 = i2 & 256;
            if (i16 != 0) {
                i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 536870912;
                    } else {
                        i17 = 268435456;
                    }
                }
                if (i16 == 256) {
                    i18 = i16;
                    if ((1533916891 & i3) != 306783378) {
                    }
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i18 = i16;
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM60constructorimpl15 = Updater.m60constructorimpl(composerStartRestartGroup);
                Updater.m67setimpl(composerM60constructorimpl15, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl15, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl15, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl15, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl15, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl15, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl15, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl15, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl15, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f16 = f8;
                f17 = f13;
                f18 = f12;
                f19 = f14;
                f20 = f15;
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i17 = 805306368;
            i3 |= i17;
            if (i16 == 256) {
                i18 = i16;
                if ((1533916891 & i3) != 306783378) {
                }
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i18 = i16;
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i19 != 0) {
                    str2 = "";
                }
                if (i20 != 0) {
                    f8 = 0.0f;
                }
                if (i4 != 0) {
                    f9 = 0.0f;
                }
                if (i6 != 0) {
                    f10 = 0.0f;
                }
                if (i8 != 0) {
                    f12 = 1.0f;
                } else {
                    f12 = f4;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f14 = 0.0f;
                } else {
                    f14 = f6;
                }
                if (i14 == 0) {
                }
                if (i18 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            } else {
                if (i19 != 0) {
                    str2 = "";
                }
                if (i20 != 0) {
                    f8 = 0.0f;
                }
                if (i4 != 0) {
                    f9 = 0.0f;
                }
                if (i6 != 0) {
                    f10 = 0.0f;
                }
                if (i8 != 0) {
                    f12 = 1.0f;
                } else {
                    f12 = f4;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f14 = 0.0f;
                } else {
                    f14 = f6;
                }
                if (i14 == 0) {
                }
                if (i18 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
            }
            anonymousClass1 = AnonymousClass1.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-548224868);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(anonymousClass1);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM60constructorimpl16 = Updater.m60constructorimpl(composerStartRestartGroup);
            Updater.m67setimpl(composerM60constructorimpl16, str2, VectorComposeKt$Group$2$1.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl16, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl16, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl16, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl16, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl16, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl16, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl16, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl16, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f16 = f8;
            f17 = f13;
            f18 = f12;
            f19 = f14;
            f20 = f15;
            f21 = f10;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
            }
        }
        i3 |= 48;
        f8 = f;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                f9 = f2;
                if (composerStartRestartGroup.changed(f9)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    f10 = f3;
                    if (composerStartRestartGroup.changed(f10)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    i3 |= 24576;
                } else if ((i & FileMode.TYPE_GITLINK) == 0) {
                    if (composerStartRestartGroup.changed(f4)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    f11 = f5;
                } else {
                    f11 = f5;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(f11)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(f6)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                i14 = i2 & 128;
                if (i14 != 0) {
                    if ((i & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(f7)) {
                            i15 = 8388608;
                        } else {
                            i15 = 4194304;
                        }
                        i3 |= i15;
                    }
                    i16 = i2 & 256;
                    if (i16 != 0) {
                        i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
                    }
                    if ((i2 & 512) != 0) {
                        if ((1879048192 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i17 = 536870912;
                            } else {
                                i17 = 268435456;
                            }
                        }
                        if (i16 == 256) {
                            i18 = i16;
                            if ((1533916891 & i3) != 306783378) {
                            }
                            f21 = f10;
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                            }
                        }
                        i18 = i16;
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i19 != 0) {
                                str2 = "";
                            }
                            if (i20 != 0) {
                                f8 = 0.0f;
                            }
                            if (i4 != 0) {
                                f9 = 0.0f;
                            }
                            if (i6 != 0) {
                                f10 = 0.0f;
                            }
                            if (i8 != 0) {
                                f12 = 1.0f;
                            } else {
                                f12 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f14 = 0.0f;
                            } else {
                                f14 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i18 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        } else {
                            if (i19 != 0) {
                                str2 = "";
                            }
                            if (i20 != 0) {
                                f8 = 0.0f;
                            }
                            if (i4 != 0) {
                                f9 = 0.0f;
                            }
                            if (i6 != 0) {
                                f10 = 0.0f;
                            }
                            if (i8 != 0) {
                                f12 = 1.0f;
                            } else {
                                f12 = f4;
                            }
                            if (i10 == 0) {
                            }
                            if (i12 != 0) {
                                f14 = 0.0f;
                            } else {
                                f14 = f6;
                            }
                            if (i14 == 0) {
                            }
                            if (i18 != 0) {
                                emptyPath = VectorKt.getEmptyPath();
                                i3 &= -234881025;
                            } else {
                                emptyPath = list;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                        }
                        anonymousClass1 = AnonymousClass1.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(anonymousClass1);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        Composer composerM60constructorimpl17 = Updater.m60constructorimpl(composerStartRestartGroup);
                        Updater.m67setimpl(composerM60constructorimpl17, str2, VectorComposeKt$Group$2$1.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl17, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl17, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl17, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl17, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl17, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl17, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl17, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                        Updater.m67setimpl(composerM60constructorimpl17, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                        function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f16 = f8;
                        f17 = f13;
                        f18 = f12;
                        f19 = f14;
                        f20 = f15;
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i17 = 805306368;
                    i3 |= i17;
                    if (i16 == 256) {
                        i18 = i16;
                        if ((1533916891 & i3) != 306783378) {
                        }
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i18 = i16;
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl18 = Updater.m60constructorimpl(composerStartRestartGroup);
                    Updater.m67setimpl(composerM60constructorimpl18, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl18, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl18, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl18, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl18, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl18, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl18, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl18, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl18, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                    function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f16 = f8;
                    f17 = f13;
                    f18 = f12;
                    f19 = f14;
                    f20 = f15;
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i3 |= 12582912;
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 536870912;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 == 256) {
                        i18 = i16;
                        if ((1533916891 & i3) != 306783378) {
                        }
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i18 = i16;
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl19 = Updater.m60constructorimpl(composerStartRestartGroup);
                    Updater.m67setimpl(composerM60constructorimpl19, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl19, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl19, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl19, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl19, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl19, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl19, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl19, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl19, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                    function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f16 = f8;
                    f17 = f13;
                    f18 = f12;
                    f19 = f14;
                    f20 = f15;
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i17 = 805306368;
                i3 |= i17;
                if (i16 == 256) {
                    i18 = i16;
                    if ((1533916891 & i3) != 306783378) {
                    }
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i18 = i16;
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM60constructorimpl110 = Updater.m60constructorimpl(composerStartRestartGroup);
                Updater.m67setimpl(composerM60constructorimpl110, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl110, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl110, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl110, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl110, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl110, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl110, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl110, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl110, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f16 = f8;
                f17 = f13;
                f18 = f12;
                f19 = f14;
                f20 = f15;
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i3 |= 3072;
            f10 = f3;
            i8 = i2 & 16;
            if (i8 != 0) {
                i3 |= 24576;
            } else if ((i & FileMode.TYPE_GITLINK) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f11 = f5;
            } else {
                f11 = f5;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f11)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f6)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i14 = i2 & 128;
            if (i14 != 0) {
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 536870912;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 == 256) {
                        i18 = i16;
                        if ((1533916891 & i3) != 306783378) {
                        }
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i18 = i16;
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl111 = Updater.m60constructorimpl(composerStartRestartGroup);
                    Updater.m67setimpl(composerM60constructorimpl111, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl111, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                    function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f16 = f8;
                    f17 = f13;
                    f18 = f12;
                    f19 = f14;
                    f20 = f15;
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i17 = 805306368;
                i3 |= i17;
                if (i16 == 256) {
                    i18 = i16;
                    if ((1533916891 & i3) != 306783378) {
                    }
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i18 = i16;
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM60constructorimpl112 = Updater.m60constructorimpl(composerStartRestartGroup);
                Updater.m67setimpl(composerM60constructorimpl112, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl112, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl112, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl112, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl112, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl112, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl112, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl112, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl112, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f16 = f8;
                f17 = f13;
                f18 = f12;
                f19 = f14;
                f20 = f15;
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i3 |= 12582912;
            i16 = i2 & 256;
            if (i16 != 0) {
                i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 536870912;
                    } else {
                        i17 = 268435456;
                    }
                }
                if (i16 == 256) {
                    i18 = i16;
                    if ((1533916891 & i3) != 306783378) {
                    }
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i18 = i16;
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM60constructorimpl113 = Updater.m60constructorimpl(composerStartRestartGroup);
                Updater.m67setimpl(composerM60constructorimpl113, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl113, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl113, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl113, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl113, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl113, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl113, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl113, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl113, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f16 = f8;
                f17 = f13;
                f18 = f12;
                f19 = f14;
                f20 = f15;
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i17 = 805306368;
            i3 |= i17;
            if (i16 == 256) {
                i18 = i16;
                if ((1533916891 & i3) != 306783378) {
                }
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i18 = i16;
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i19 != 0) {
                    str2 = "";
                }
                if (i20 != 0) {
                    f8 = 0.0f;
                }
                if (i4 != 0) {
                    f9 = 0.0f;
                }
                if (i6 != 0) {
                    f10 = 0.0f;
                }
                if (i8 != 0) {
                    f12 = 1.0f;
                } else {
                    f12 = f4;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f14 = 0.0f;
                } else {
                    f14 = f6;
                }
                if (i14 == 0) {
                }
                if (i18 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            } else {
                if (i19 != 0) {
                    str2 = "";
                }
                if (i20 != 0) {
                    f8 = 0.0f;
                }
                if (i4 != 0) {
                    f9 = 0.0f;
                }
                if (i6 != 0) {
                    f10 = 0.0f;
                }
                if (i8 != 0) {
                    f12 = 1.0f;
                } else {
                    f12 = f4;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f14 = 0.0f;
                } else {
                    f14 = f6;
                }
                if (i14 == 0) {
                }
                if (i18 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
            }
            anonymousClass1 = AnonymousClass1.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-548224868);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(anonymousClass1);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM60constructorimpl114 = Updater.m60constructorimpl(composerStartRestartGroup);
            Updater.m67setimpl(composerM60constructorimpl114, str2, VectorComposeKt$Group$2$1.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl114, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl114, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl114, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl114, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl114, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl114, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl114, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl114, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f16 = f8;
            f17 = f13;
            f18 = f12;
            f19 = f14;
            f20 = f15;
            f21 = f10;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
            }
        }
        i3 |= Constants.appIconsCacheSize;
        f9 = f2;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                f10 = f3;
                if (composerStartRestartGroup.changed(f10)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                i3 |= 24576;
            } else if ((i & FileMode.TYPE_GITLINK) == 0) {
                if (composerStartRestartGroup.changed(f4)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f11 = f5;
            } else {
                f11 = f5;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(f11)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(f6)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            i14 = i2 & 128;
            if (i14 != 0) {
                if ((i & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(f7)) {
                        i15 = 8388608;
                    } else {
                        i15 = 4194304;
                    }
                    i3 |= i15;
                }
                i16 = i2 & 256;
                if (i16 != 0) {
                    i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
                }
                if ((i2 & 512) != 0) {
                    if ((1879048192 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i17 = 536870912;
                        } else {
                            i17 = 268435456;
                        }
                    }
                    if (i16 == 256) {
                        i18 = i16;
                        if ((1533916891 & i3) != 306783378) {
                        }
                        f21 = f10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                        }
                    }
                    i18 = i16;
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    } else {
                        if (i19 != 0) {
                            str2 = "";
                        }
                        if (i20 != 0) {
                            f8 = 0.0f;
                        }
                        if (i4 != 0) {
                            f9 = 0.0f;
                        }
                        if (i6 != 0) {
                            f10 = 0.0f;
                        }
                        if (i8 != 0) {
                            f12 = 1.0f;
                        } else {
                            f12 = f4;
                        }
                        if (i10 == 0) {
                        }
                        if (i12 != 0) {
                            f14 = 0.0f;
                        } else {
                            f14 = f6;
                        }
                        if (i14 == 0) {
                        }
                        if (i18 != 0) {
                            emptyPath = VectorKt.getEmptyPath();
                            i3 &= -234881025;
                        } else {
                            emptyPath = list;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                    }
                    anonymousClass1 = AnonymousClass1.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(anonymousClass1);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM60constructorimpl115 = Updater.m60constructorimpl(composerStartRestartGroup);
                    Updater.m67setimpl(composerM60constructorimpl115, str2, VectorComposeKt$Group$2$1.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl115, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl115, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl115, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl115, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl115, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl115, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl115, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                    Updater.m67setimpl(composerM60constructorimpl115, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                    function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f16 = f8;
                    f17 = f13;
                    f18 = f12;
                    f19 = f14;
                    f20 = f15;
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i17 = 805306368;
                i3 |= i17;
                if (i16 == 256) {
                    i18 = i16;
                    if ((1533916891 & i3) != 306783378) {
                    }
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i18 = i16;
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM60constructorimpl116 = Updater.m60constructorimpl(composerStartRestartGroup);
                Updater.m67setimpl(composerM60constructorimpl116, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl116, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl116, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl116, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl116, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl116, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl116, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl116, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl116, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f16 = f8;
                f17 = f13;
                f18 = f12;
                f19 = f14;
                f20 = f15;
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i3 |= 12582912;
            i16 = i2 & 256;
            if (i16 != 0) {
                i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 536870912;
                    } else {
                        i17 = 268435456;
                    }
                }
                if (i16 == 256) {
                    i18 = i16;
                    if ((1533916891 & i3) != 306783378) {
                    }
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i18 = i16;
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM60constructorimpl117 = Updater.m60constructorimpl(composerStartRestartGroup);
                Updater.m67setimpl(composerM60constructorimpl117, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl117, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl117, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl117, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl117, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl117, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl117, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl117, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl117, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f16 = f8;
                f17 = f13;
                f18 = f12;
                f19 = f14;
                f20 = f15;
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i17 = 805306368;
            i3 |= i17;
            if (i16 == 256) {
                i18 = i16;
                if ((1533916891 & i3) != 306783378) {
                }
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i18 = i16;
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i19 != 0) {
                    str2 = "";
                }
                if (i20 != 0) {
                    f8 = 0.0f;
                }
                if (i4 != 0) {
                    f9 = 0.0f;
                }
                if (i6 != 0) {
                    f10 = 0.0f;
                }
                if (i8 != 0) {
                    f12 = 1.0f;
                } else {
                    f12 = f4;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f14 = 0.0f;
                } else {
                    f14 = f6;
                }
                if (i14 == 0) {
                }
                if (i18 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            } else {
                if (i19 != 0) {
                    str2 = "";
                }
                if (i20 != 0) {
                    f8 = 0.0f;
                }
                if (i4 != 0) {
                    f9 = 0.0f;
                }
                if (i6 != 0) {
                    f10 = 0.0f;
                }
                if (i8 != 0) {
                    f12 = 1.0f;
                } else {
                    f12 = f4;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f14 = 0.0f;
                } else {
                    f14 = f6;
                }
                if (i14 == 0) {
                }
                if (i18 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
            }
            anonymousClass1 = AnonymousClass1.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-548224868);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(anonymousClass1);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM60constructorimpl118 = Updater.m60constructorimpl(composerStartRestartGroup);
            Updater.m67setimpl(composerM60constructorimpl118, str2, VectorComposeKt$Group$2$1.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl118, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl118, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl118, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl118, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl118, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl118, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl118, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl118, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f16 = f8;
            f17 = f13;
            f18 = f12;
            f19 = f14;
            f20 = f15;
            f21 = f10;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
            }
        }
        i3 |= 3072;
        f10 = f3;
        i8 = i2 & 16;
        if (i8 != 0) {
            i3 |= 24576;
        } else if ((i & FileMode.TYPE_GITLINK) == 0) {
            if (composerStartRestartGroup.changed(f4)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i3 |= i9;
        }
        i10 = i2 & 32;
        if (i10 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            f11 = f5;
        } else {
            f11 = f5;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(f11)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
        }
        i12 = i2 & 64;
        if (i12 != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(f6)) {
                i13 = 1048576;
            } else {
                i13 = 524288;
            }
            i3 |= i13;
        }
        i14 = i2 & 128;
        if (i14 != 0) {
            if ((i & 29360128) == 0) {
                if (composerStartRestartGroup.changed(f7)) {
                    i15 = 8388608;
                } else {
                    i15 = 4194304;
                }
                i3 |= i15;
            }
            i16 = i2 & 256;
            if (i16 != 0) {
                i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
            }
            if ((i2 & 512) != 0) {
                if ((1879048192 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i17 = 536870912;
                    } else {
                        i17 = 268435456;
                    }
                }
                if (i16 == 256) {
                    i18 = i16;
                    if ((1533916891 & i3) != 306783378) {
                    }
                    f21 = f10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                    }
                }
                i18 = i16;
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                } else {
                    if (i19 != 0) {
                        str2 = "";
                    }
                    if (i20 != 0) {
                        f8 = 0.0f;
                    }
                    if (i4 != 0) {
                        f9 = 0.0f;
                    }
                    if (i6 != 0) {
                        f10 = 0.0f;
                    }
                    if (i8 != 0) {
                        f12 = 1.0f;
                    } else {
                        f12 = f4;
                    }
                    if (i10 == 0) {
                    }
                    if (i12 != 0) {
                        f14 = 0.0f;
                    } else {
                        f14 = f6;
                    }
                    if (i14 == 0) {
                    }
                    if (i18 != 0) {
                        emptyPath = VectorKt.getEmptyPath();
                        i3 &= -234881025;
                    } else {
                        emptyPath = list;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                }
                anonymousClass1 = AnonymousClass1.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(anonymousClass1);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM60constructorimpl119 = Updater.m60constructorimpl(composerStartRestartGroup);
                Updater.m67setimpl(composerM60constructorimpl119, str2, VectorComposeKt$Group$2$1.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl119, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl119, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl119, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl119, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl119, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl119, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl119, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
                Updater.m67setimpl(composerM60constructorimpl119, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f16 = f8;
                f17 = f13;
                f18 = f12;
                f19 = f14;
                f20 = f15;
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i17 = 805306368;
            i3 |= i17;
            if (i16 == 256) {
                i18 = i16;
                if ((1533916891 & i3) != 306783378) {
                }
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i18 = i16;
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i19 != 0) {
                    str2 = "";
                }
                if (i20 != 0) {
                    f8 = 0.0f;
                }
                if (i4 != 0) {
                    f9 = 0.0f;
                }
                if (i6 != 0) {
                    f10 = 0.0f;
                }
                if (i8 != 0) {
                    f12 = 1.0f;
                } else {
                    f12 = f4;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f14 = 0.0f;
                } else {
                    f14 = f6;
                }
                if (i14 == 0) {
                }
                if (i18 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            } else {
                if (i19 != 0) {
                    str2 = "";
                }
                if (i20 != 0) {
                    f8 = 0.0f;
                }
                if (i4 != 0) {
                    f9 = 0.0f;
                }
                if (i6 != 0) {
                    f10 = 0.0f;
                }
                if (i8 != 0) {
                    f12 = 1.0f;
                } else {
                    f12 = f4;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f14 = 0.0f;
                } else {
                    f14 = f6;
                }
                if (i14 == 0) {
                }
                if (i18 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
            }
            anonymousClass1 = AnonymousClass1.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-548224868);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(anonymousClass1);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM60constructorimpl1110 = Updater.m60constructorimpl(composerStartRestartGroup);
            Updater.m67setimpl(composerM60constructorimpl1110, str2, VectorComposeKt$Group$2$1.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1110, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1110, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1110, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1110, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1110, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1110, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1110, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1110, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f16 = f8;
            f17 = f13;
            f18 = f12;
            f19 = f14;
            f20 = f15;
            f21 = f10;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
            }
        }
        i3 |= 12582912;
        i16 = i2 & 256;
        if (i16 != 0) {
            i3 |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
        }
        if ((i2 & 512) != 0) {
            if ((1879048192 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i17 = 536870912;
                } else {
                    i17 = 268435456;
                }
            }
            if (i16 == 256) {
                i18 = i16;
                if ((1533916891 & i3) != 306783378) {
                }
                f21 = f10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
                }
            }
            i18 = i16;
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i19 != 0) {
                    str2 = "";
                }
                if (i20 != 0) {
                    f8 = 0.0f;
                }
                if (i4 != 0) {
                    f9 = 0.0f;
                }
                if (i6 != 0) {
                    f10 = 0.0f;
                }
                if (i8 != 0) {
                    f12 = 1.0f;
                } else {
                    f12 = f4;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f14 = 0.0f;
                } else {
                    f14 = f6;
                }
                if (i14 == 0) {
                }
                if (i18 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            } else {
                if (i19 != 0) {
                    str2 = "";
                }
                if (i20 != 0) {
                    f8 = 0.0f;
                }
                if (i4 != 0) {
                    f9 = 0.0f;
                }
                if (i6 != 0) {
                    f10 = 0.0f;
                }
                if (i8 != 0) {
                    f12 = 1.0f;
                } else {
                    f12 = f4;
                }
                if (i10 == 0) {
                }
                if (i12 != 0) {
                    f14 = 0.0f;
                } else {
                    f14 = f6;
                }
                if (i14 == 0) {
                }
                if (i18 != 0) {
                    emptyPath = VectorKt.getEmptyPath();
                    i3 &= -234881025;
                } else {
                    emptyPath = list;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
            }
            anonymousClass1 = AnonymousClass1.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(-548224868);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(anonymousClass1);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM60constructorimpl1111 = Updater.m60constructorimpl(composerStartRestartGroup);
            Updater.m67setimpl(composerM60constructorimpl1111, str2, VectorComposeKt$Group$2$1.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1111, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1111, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1111, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1111, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1111, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1111, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1111, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
            Updater.m67setimpl(composerM60constructorimpl1111, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f16 = f8;
            f17 = f13;
            f18 = f12;
            f19 = f14;
            f20 = f15;
            f21 = f10;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
            }
        }
        i17 = 805306368;
        i3 |= i17;
        if (i16 == 256) {
            i18 = i16;
            if ((1533916891 & i3) != 306783378) {
            }
            f21 = f10;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
            }
        }
        i18 = i16;
        composerStartRestartGroup.startDefaults();
        if ((i & 1) != 0) {
            if (i19 != 0) {
                str2 = "";
            }
            if (i20 != 0) {
                f8 = 0.0f;
            }
            if (i4 != 0) {
                f9 = 0.0f;
            }
            if (i6 != 0) {
                f10 = 0.0f;
            }
            if (i8 != 0) {
                f12 = 1.0f;
            } else {
                f12 = f4;
            }
            if (i10 == 0) {
            }
            if (i12 != 0) {
                f14 = 0.0f;
            } else {
                f14 = f6;
            }
            if (i14 == 0) {
            }
            if (i18 != 0) {
                emptyPath = VectorKt.getEmptyPath();
                i3 &= -234881025;
            } else {
                emptyPath = list;
            }
        } else {
            if (i19 != 0) {
                str2 = "";
            }
            if (i20 != 0) {
                f8 = 0.0f;
            }
            if (i4 != 0) {
                f9 = 0.0f;
            }
            if (i6 != 0) {
                f10 = 0.0f;
            }
            if (i8 != 0) {
                f12 = 1.0f;
            } else {
                f12 = f4;
            }
            if (i10 == 0) {
            }
            if (i12 != 0) {
                f14 = 0.0f;
            } else {
                f14 = f6;
            }
            if (i14 == 0) {
            }
            if (i18 != 0) {
                emptyPath = VectorKt.getEmptyPath();
                i3 &= -234881025;
            } else {
                emptyPath = list;
            }
        }
        composerStartRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
        }
        anonymousClass1 = AnonymousClass1.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(-548224868);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(anonymousClass1);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM60constructorimpl1112 = Updater.m60constructorimpl(composerStartRestartGroup);
        Updater.m67setimpl(composerM60constructorimpl1112, str2, VectorComposeKt$Group$2$1.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl1112, Float.valueOf(f8), VectorComposeKt$Group$2$2.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl1112, Float.valueOf(f9), VectorComposeKt$Group$2$3.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl1112, Float.valueOf(f10), VectorComposeKt$Group$2$4.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl1112, Float.valueOf(f12), VectorComposeKt$Group$2$5.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl1112, Float.valueOf(f13), VectorComposeKt$Group$2$6.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl1112, Float.valueOf(f14), VectorComposeKt$Group$2$7.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl1112, Float.valueOf(f15), VectorComposeKt$Group$2$8.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl1112, emptyPath, VectorComposeKt$Group$2$9.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
        function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 27) & 14));
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        f16 = f8;
        f17 = f13;
        f18 = f12;
        f19 = f14;
        f20 = f15;
        f21 = f10;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(str2, f16, f9, f21, f18, f17, f19, f20, emptyPath, function2, i, i2));
        }
    }

    /* INFO: renamed from: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1, reason: invalid class name */
    /* INFO: compiled from: VectorCompose.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function0<GroupComponent> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GroupComponent invoke() {
            return new GroupComponent();
        }
    }

    /* INFO: renamed from: Path-9cdaXJ4, reason: not valid java name */
    public static final void m1178Path9cdaXJ4(List<? extends PathNode> list, int i, String str, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, Composer composer, int i4, int i5, int i6) {
        int i7;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1478270750);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Path)P(3,4:c#ui.graphics.PathFillType,2!4,10,7:c#ui.graphics.StrokeCap,8:c#ui.graphics.StrokeJoin!1,13)115@5068L876:VectorCompose.kt#huu6hf");
        int defaultFillType = (i6 & 2) != 0 ? VectorKt.getDefaultFillType() : i;
        String str2 = (i6 & 4) != 0 ? "" : str;
        Brush brush3 = (i6 & 8) != 0 ? null : brush;
        float f8 = (i6 & 16) != 0 ? 1.0f : f;
        Brush brush4 = (i6 & 32) == 0 ? brush2 : null;
        float f9 = (i6 & 64) != 0 ? 1.0f : f2;
        float f10 = (i6 & 128) != 0 ? 0.0f : f3;
        int defaultStrokeLineCap = (i6 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i2;
        int defaultStrokeLineJoin = (i6 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i3;
        float f11 = (i6 & 1024) != 0 ? 4.0f : f4;
        float f12 = (i6 & 2048) != 0 ? 0.0f : f5;
        float f13 = (i6 & 4096) != 0 ? 1.0f : f6;
        float f14 = (i6 & 8192) != 0 ? 0.0f : f7;
        if (ComposerKt.isTraceInProgress()) {
            i7 = i4;
            i8 = i5;
            ComposerKt.traceEventStart(-1478270750, i7, i8, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:114)");
        } else {
            i7 = i4;
            i8 = i5;
        }
        VectorComposeKt$Path$1 vectorComposeKt$Path$1 = VectorComposeKt$Path$1.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(1886828752);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
        if (!(composerStartRestartGroup.getApplier() instanceof VectorApplier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(new VectorComposeKt$Path9cdaXJ4$$inlined$ComposeNode$1(vectorComposeKt$Path$1));
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM60constructorimpl = Updater.m60constructorimpl(composerStartRestartGroup);
        Updater.m67setimpl(composerM60constructorimpl, str2, VectorComposeKt$Path$2$1.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl, list, VectorComposeKt$Path$2$2.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl, PathFillType.m806boximpl(defaultFillType), VectorComposeKt$Path$2$3.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl, brush3, VectorComposeKt$Path$2$4.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl, Float.valueOf(f8), VectorComposeKt$Path$2$5.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl, brush4, VectorComposeKt$Path$2$6.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl, Float.valueOf(f9), VectorComposeKt$Path$2$7.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl, Float.valueOf(f10), VectorComposeKt$Path$2$8.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl, StrokeJoin.m887boximpl(defaultStrokeLineJoin), VectorComposeKt$Path$2$9.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl, StrokeCap.m877boximpl(defaultStrokeLineCap), VectorComposeKt$Path$2$10.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl, Float.valueOf(f11), VectorComposeKt$Path$2$11.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl, Float.valueOf(f12), VectorComposeKt$Path$2$12.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl, Float.valueOf(f13), VectorComposeKt$Path$2$13.INSTANCE);
        Updater.m67setimpl(composerM60constructorimpl, Float.valueOf(f14), VectorComposeKt$Path$2$14.INSTANCE);
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            int i9 = i8;
            scopeUpdateScopeEndRestartGroup.updateScope(new VectorComposeKt$Path$3(list, defaultFillType, str2, brush3, f8, brush4, f9, f10, defaultStrokeLineCap, defaultStrokeLineJoin, f11, f12, f13, f14, i7, i9, i6));
        }
    }
}
