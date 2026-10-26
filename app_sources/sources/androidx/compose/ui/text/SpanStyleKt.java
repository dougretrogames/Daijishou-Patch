package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeightKt;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShiftKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransformKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: SpanStyle.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f\u001a+\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u0002H\u000e2\u0006\u0010\u0010\u001a\u0002H\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0011\u001a&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\t\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a*\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0000\u001aÀ\u0001\u0010\u001a\u001a\u00020\b*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u00012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u00010\u00132\b\u00107\u001a\u0004\u0018\u000108H\u0000ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u0018\u0010;\u001a\u0004\u0018\u00010\u0013*\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\u0013H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultColor", "DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "DefaultLetterSpacing", "lerp", "Landroidx/compose/ui/text/SpanStyle;", "start", "stop", "fraction", "", "lerpDiscrete", ExifInterface.GPS_DIRECTION_TRUE, "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;F)Ljava/lang/Object;", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "lerpTextUnitInheritable", "t", "lerpTextUnitInheritable-C3pnCVY", "(JJF)J", "resolveSpanStyleDefaults", "style", "fastMerge", TypedValues.Custom.S_COLOR, "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "fontSize", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "platformStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "fastMerge-dSHsh3o", "(Landroidx/compose/ui/text/SpanStyle;JLandroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)Landroidx/compose/ui/text/SpanStyle;", "mergePlatformStyle", "other", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpanStyleKt {
    private static final long DefaultFontSize = TextUnitKt.getSp(14);
    private static final long DefaultLetterSpacing = TextUnitKt.getSp(0);
    private static final long DefaultBackgroundColor = Color.INSTANCE.m565getTransparent0d7_KjU();
    private static final long DefaultColor = Color.INSTANCE.m556getBlack0d7_KjU();

    public static final <T> T lerpDiscrete(T t, T t2, float f) {
        return ((double) f) < 0.5d ? t : t2;
    }

    /* INFO: renamed from: lerpTextUnitInheritable-C3pnCVY, reason: not valid java name */
    public static final long m2348lerpTextUnitInheritableC3pnCVY(long j, long j2, float f) {
        if (TextUnitKt.m3093isUnspecifiedR2X_6o(j) || TextUnitKt.m3093isUnspecifiedR2X_6o(j2)) {
            return ((TextUnit) lerpDiscrete(TextUnit.m3065boximpl(j), TextUnit.m3065boximpl(j2), f)).getPackedValue();
        }
        return TextUnitKt.m3095lerpC3pnCVY(j, j2, f);
    }

    public static final SpanStyle lerp(SpanStyle spanStyle, SpanStyle spanStyle2, float f) {
        TextForegroundStyle textForegroundStyleLerp = TextDrawStyleKt.lerp(spanStyle.getTextForegroundStyle(), spanStyle2.getTextForegroundStyle(), f);
        FontFamily fontFamily = (FontFamily) lerpDiscrete(spanStyle.getFontFamily(), spanStyle2.getFontFamily(), f);
        long jM2348lerpTextUnitInheritableC3pnCVY = m2348lerpTextUnitInheritableC3pnCVY(spanStyle.getFontSize(), spanStyle2.getFontSize(), f);
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeight2 = spanStyle2.getFontWeight();
        if (fontWeight2 == null) {
            fontWeight2 = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeightLerp = FontWeightKt.lerp(fontWeight, fontWeight2, f);
        FontStyle fontStyle = (FontStyle) lerpDiscrete(spanStyle.getFontStyle(), spanStyle2.getFontStyle(), f);
        FontSynthesis fontSynthesis = (FontSynthesis) lerpDiscrete(spanStyle.getFontSynthesis(), spanStyle2.getFontSynthesis(), f);
        String str = (String) lerpDiscrete(spanStyle.getFontFeatureSettings(), spanStyle2.getFontFeatureSettings(), f);
        long jM2348lerpTextUnitInheritableC3pnCVY2 = m2348lerpTextUnitInheritableC3pnCVY(spanStyle.getLetterSpacing(), spanStyle2.getLetterSpacing(), f);
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        float fM2666unboximpl = baselineShift != null ? baselineShift.m2666unboximpl() : BaselineShift.m2661constructorimpl(0.0f);
        BaselineShift baselineShift2 = spanStyle2.getBaselineShift();
        float fM2673lerpjWV1Mfo = BaselineShiftKt.m2673lerpjWV1Mfo(fM2666unboximpl, baselineShift2 != null ? baselineShift2.m2666unboximpl() : BaselineShift.m2661constructorimpl(0.0f), f);
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.INSTANCE.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = spanStyle2.getTextGeometricTransform();
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = TextGeometricTransform.INSTANCE.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransformLerp = TextGeometricTransformKt.lerp(textGeometricTransform, textGeometricTransform2, f);
        LocaleList localeList = (LocaleList) lerpDiscrete(spanStyle.getLocaleList(), spanStyle2.getLocaleList(), f);
        long jM581lerpjxsXWHM = ColorKt.m581lerpjxsXWHM(spanStyle.getBackground(), spanStyle2.getBackground(), f);
        TextDecoration textDecoration = (TextDecoration) lerpDiscrete(spanStyle.getTextDecoration(), spanStyle2.getTextDecoration(), f);
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        Shadow shadow2 = spanStyle2.getShadow();
        if (shadow2 == null) {
            shadow2 = new Shadow(0L, 0L, 0.0f, 7, null);
        }
        return new SpanStyle(textForegroundStyleLerp, jM2348lerpTextUnitInheritableC3pnCVY, fontWeightLerp, fontStyle, fontSynthesis, fontFamily, str, jM2348lerpTextUnitInheritableC3pnCVY2, BaselineShift.m2660boximpl(fM2673lerpjWV1Mfo), textGeometricTransformLerp, localeList, jM581lerpjxsXWHM, textDecoration, ShadowKt.lerp(shadow, shadow2, f), lerpPlatformStyle(spanStyle.getPlatformStyle(), spanStyle2.getPlatformStyle(), f), (DrawStyle) lerpDiscrete(spanStyle.getDrawStyle(), spanStyle2.getDrawStyle(), f), (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle lerpPlatformStyle(PlatformSpanStyle platformSpanStyle, PlatformSpanStyle platformSpanStyle2, float f) {
        if (platformSpanStyle == null && platformSpanStyle2 == null) {
            return null;
        }
        if (platformSpanStyle == null) {
            platformSpanStyle = PlatformSpanStyle.INSTANCE.getDefault();
        }
        if (platformSpanStyle2 == null) {
            platformSpanStyle2 = PlatformSpanStyle.INSTANCE.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformSpanStyle, platformSpanStyle2, f);
    }

    /* INFO: renamed from: androidx.compose.ui.text.SpanStyleKt$resolveSpanStyleDefaults$1, reason: invalid class name */
    /* INFO: compiled from: SpanStyle.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function0<TextForegroundStyle> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextForegroundStyle invoke() {
            return TextForegroundStyle.INSTANCE.m2797from8_81llA(SpanStyleKt.DefaultColor);
        }
    }

    public static final SpanStyle resolveSpanStyleDefaults(SpanStyle spanStyle) {
        long letterSpacing;
        TextForegroundStyle textForegroundStyleTakeOrElse = spanStyle.getTextForegroundStyle().takeOrElse(AnonymousClass1.INSTANCE);
        long fontSize = TextUnitKt.m3093isUnspecifiedR2X_6o(spanStyle.getFontSize()) ? DefaultFontSize : spanStyle.getFontSize();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontWeight fontWeight2 = fontWeight;
        FontStyle fontStyle = spanStyle.getFontStyle();
        FontStyle fontStyleM2489boximpl = FontStyle.m2489boximpl(fontStyle != null ? fontStyle.m2495unboximpl() : FontStyle.INSTANCE.m2499getNormal_LCdwA());
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        FontSynthesis fontSynthesisM2500boximpl = FontSynthesis.m2500boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m2509getAllGVVA2EU());
        SystemFontFamily fontFamily = spanStyle.getFontFamily();
        if (fontFamily == null) {
            fontFamily = FontFamily.INSTANCE.getDefault();
        }
        FontFamily fontFamily2 = fontFamily;
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings == null) {
            fontFeatureSettings = "";
        }
        String str = fontFeatureSettings;
        if (TextUnitKt.m3093isUnspecifiedR2X_6o(spanStyle.getLetterSpacing())) {
            letterSpacing = DefaultLetterSpacing;
        } else {
            letterSpacing = spanStyle.getLetterSpacing();
        }
        long j = letterSpacing;
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        BaselineShift baselineShiftM2660boximpl = BaselineShift.m2660boximpl(baselineShift != null ? baselineShift.m2666unboximpl() : BaselineShift.INSTANCE.m2670getNoney9eOQZs());
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform == null) {
            textGeometricTransform = TextGeometricTransform.INSTANCE.getNone$ui_text_release();
        }
        TextGeometricTransform textGeometricTransform2 = textGeometricTransform;
        LocaleList localeList = spanStyle.getLocaleList();
        if (localeList == null) {
            localeList = LocaleList.INSTANCE.getCurrent();
        }
        LocaleList localeList2 = localeList;
        long background = spanStyle.getBackground();
        if (background == Color.INSTANCE.m566getUnspecified0d7_KjU()) {
            background = DefaultBackgroundColor;
        }
        long j2 = background;
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.INSTANCE.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.INSTANCE.getNone();
        }
        Shadow shadow2 = shadow;
        PlatformSpanStyle platformStyle = spanStyle.getPlatformStyle();
        Fill drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        return new SpanStyle(textForegroundStyleTakeOrElse, fontSize, fontWeight2, fontStyleM2489boximpl, fontSynthesisM2500boximpl, fontFamily2, str, j, baselineShiftM2660boximpl, textGeometricTransform2, localeList2, j2, textDecoration2, shadow2, platformStyle, drawStyle, (DefaultConstructorMarker) null);
    }

    private static final PlatformSpanStyle mergePlatformStyle(SpanStyle spanStyle, PlatformSpanStyle platformSpanStyle) {
        if (spanStyle.getPlatformStyle() == null) {
            return platformSpanStyle;
        }
        if (platformSpanStyle == null) {
            return spanStyle.getPlatformStyle();
        }
        return spanStyle.getPlatformStyle().merge(platformSpanStyle);
    }

    /* WARN: Code duplicated, block: B:100:0x0185  */
    /* WARN: Code duplicated, block: B:101:0x0188  */
    /* WARN: Code duplicated, block: B:103:0x018e  */
    /* WARN: Code duplicated, block: B:105:0x0194  */
    /* WARN: Code duplicated, block: B:107:0x019a  */
    /* WARN: Code duplicated, block: B:108:0x019f  */
    /* WARN: Code duplicated, block: B:112:0x01ac  */
    /* WARN: Code duplicated, block: B:114:0x01b2  */
    /* WARN: Code duplicated, block: B:116:0x01b8  */
    /* WARN: Code duplicated, block: B:119:0x01c6  */
    /* WARN: Code duplicated, block: B:120:0x01cb  */
    /* WARN: Code duplicated, block: B:77:0x0133  */
    /* WARN: Code duplicated, block: B:78:0x013c  */
    /* WARN: Code duplicated, block: B:7:0x0029 A[PHI: r11
  0x0029: PHI (r11v7 long) = 
  (r11v1 long)
  (r11v1 long)
  (r11v1 long)
  (r11v1 long)
  (r11v1 long)
  (r11v1 long)
  (r11v1 long)
  (r11v1 long)
  (r11v1 long)
  (r11v1 long)
  (r11v1 long)
  (r11v8 long)
 binds: [B:35:0x009a, B:47:0x00cc, B:44:0x00c0, B:41:0x00b4, B:38:0x00a8, B:33:0x008c, B:28:0x007d, B:24:0x006b, B:21:0x0063, B:18:0x0057, B:15:0x004b, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* WARN: Code duplicated, block: B:81:0x014c  */
    /* WARN: Code duplicated, block: B:82:0x0151  */
    /* WARN: Code duplicated, block: B:86:0x015a  */
    /* WARN: Code duplicated, block: B:88:0x0160  */
    /* WARN: Code duplicated, block: B:89:0x0165  */
    /* WARN: Code duplicated, block: B:91:0x0169  */
    /* WARN: Code duplicated, block: B:92:0x016e  */
    /* WARN: Code duplicated, block: B:94:0x0172  */
    /* WARN: Code duplicated, block: B:95:0x0177  */
    /* WARN: Code duplicated, block: B:97:0x017b  */
    /* INFO: renamed from: fastMerge-dSHsh3o, reason: not valid java name */
    public static final SpanStyle m2347fastMergedSHsh3o(SpanStyle spanStyle, long j, Brush brush, float f, long j2, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j3, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j4, TextDecoration textDecoration, Shadow shadow, PlatformSpanStyle platformSpanStyle, DrawStyle drawStyle) {
        long fontSize;
        TextGeometricTransform textGeometricTransform2;
        long background;
        DrawStyle drawStyle2;
        TextForegroundStyle textForegroundStyleM2797from8_81llA;
        FontFamily fontFamily2;
        FontWeight fontWeight2;
        FontStyle fontStyle2;
        FontSynthesis fontSynthesis2;
        long letterSpacing;
        LocaleList localeList2;
        DrawStyle drawStyle3;
        String fontFeatureSettings = str;
        BaselineShift baselineShift2 = baselineShift;
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow2 = shadow;
        if (!TextUnitKt.m3093isUnspecifiedR2X_6o(j2)) {
            fontSize = j2;
            if (!TextUnit.m3072equalsimpl0(fontSize, spanStyle.getFontSize())) {
                textGeometricTransform2 = textGeometricTransform;
                background = j4;
                drawStyle2 = drawStyle;
            }
            if (brush != null) {
                textForegroundStyleM2797from8_81llA = TextForegroundStyle.INSTANCE.from(brush, f);
            } else {
                textForegroundStyleM2797from8_81llA = TextForegroundStyle.INSTANCE.m2797from8_81llA(j);
            }
            TextForegroundStyle textForegroundStyleMerge = spanStyle.getTextForegroundStyle().merge(textForegroundStyleM2797from8_81llA);
            if (fontFamily == null) {
                fontFamily2 = spanStyle.getFontFamily();
            } else {
                fontFamily2 = fontFamily;
            }
            if (TextUnitKt.m3093isUnspecifiedR2X_6o(fontSize)) {
                fontSize = spanStyle.getFontSize();
            }
            if (fontWeight == null) {
                fontWeight2 = spanStyle.getFontWeight();
            } else {
                fontWeight2 = fontWeight;
            }
            if (fontStyle == null) {
                fontStyle2 = spanStyle.getFontStyle();
            } else {
                fontStyle2 = fontStyle;
            }
            if (fontSynthesis == null) {
                fontSynthesis2 = spanStyle.getFontSynthesis();
            } else {
                fontSynthesis2 = fontSynthesis;
            }
            if (fontFeatureSettings == null) {
                fontFeatureSettings = spanStyle.getFontFeatureSettings();
            }
            if (TextUnitKt.m3093isUnspecifiedR2X_6o(j3)) {
                letterSpacing = spanStyle.getLetterSpacing();
            } else {
                letterSpacing = j3;
            }
            if (baselineShift2 == null) {
                baselineShift2 = spanStyle.getBaselineShift();
            }
            if (textGeometricTransform2 == null) {
                textGeometricTransform2 = spanStyle.getTextGeometricTransform();
            }
            if (localeList == null) {
                localeList2 = spanStyle.getLocaleList();
            } else {
                localeList2 = localeList;
            }
            if (background == Color.INSTANCE.m566getUnspecified0d7_KjU()) {
                background = spanStyle.getBackground();
            }
            if (textDecoration2 == null) {
                textDecoration2 = spanStyle.getTextDecoration();
            }
            if (shadow2 == null) {
                shadow2 = spanStyle.getShadow();
            }
            Shadow shadow3 = shadow2;
            PlatformSpanStyle platformSpanStyleMergePlatformStyle = mergePlatformStyle(spanStyle, platformSpanStyle);
            if (drawStyle2 == null) {
                drawStyle3 = spanStyle.getDrawStyle();
            } else {
                drawStyle3 = drawStyle2;
            }
            return new SpanStyle(textForegroundStyleMerge, fontSize, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings, letterSpacing, baselineShift2, textGeometricTransform2, localeList2, background, textDecoration2, shadow3, platformSpanStyleMergePlatformStyle, drawStyle3, (DefaultConstructorMarker) null);
        }
        fontSize = j2;
        if ((brush != null || j == Color.INSTANCE.m566getUnspecified0d7_KjU() || Color.m531equalsimpl0(j, spanStyle.getTextForegroundStyle().mo2674getColor0d7_KjU())) && ((fontStyle == null || Intrinsics.areEqual(fontStyle, spanStyle.getFontStyle())) && ((fontWeight == null || Intrinsics.areEqual(fontWeight, spanStyle.getFontWeight())) && ((fontFamily == null || fontFamily == spanStyle.getFontFamily()) && (TextUnitKt.m3093isUnspecifiedR2X_6o(j3) || TextUnit.m3072equalsimpl0(j3, spanStyle.getLetterSpacing())))))) {
            if ((textDecoration2 == null || Intrinsics.areEqual(textDecoration2, spanStyle.getTextDecoration())) && Intrinsics.areEqual(brush, spanStyle.getTextForegroundStyle().getBrush()) && ((brush == null || f == spanStyle.getTextForegroundStyle().getAlpha()) && ((fontSynthesis == null || Intrinsics.areEqual(fontSynthesis, spanStyle.getFontSynthesis())) && ((fontFeatureSettings == null || Intrinsics.areEqual(fontFeatureSettings, spanStyle.getFontFeatureSettings())) && (baselineShift2 == null || Intrinsics.areEqual(baselineShift2, spanStyle.getBaselineShift())))))) {
                if (textGeometricTransform != null) {
                    textGeometricTransform2 = textGeometricTransform;
                    if (Intrinsics.areEqual(textGeometricTransform2, spanStyle.getTextGeometricTransform())) {
                    }
                } else {
                    textGeometricTransform2 = textGeometricTransform;
                }
                if (localeList == null || Intrinsics.areEqual(localeList, spanStyle.getLocaleList())) {
                    if (j4 != Color.INSTANCE.m566getUnspecified0d7_KjU()) {
                        background = j4;
                        if (Color.m531equalsimpl0(background, spanStyle.getBackground())) {
                        }
                    } else {
                        background = j4;
                    }
                    if ((shadow2 == null || Intrinsics.areEqual(shadow2, spanStyle.getShadow())) && (platformSpanStyle == null || Intrinsics.areEqual(platformSpanStyle, spanStyle.getPlatformStyle()))) {
                        drawStyle2 = drawStyle;
                        if (drawStyle2 == null || Intrinsics.areEqual(drawStyle2, spanStyle.getDrawStyle())) {
                            return spanStyle;
                        }
                    }
                }
                drawStyle2 = drawStyle;
            } else {
                textGeometricTransform2 = textGeometricTransform;
            }
            background = j4;
            drawStyle2 = drawStyle;
        } else {
            textGeometricTransform2 = textGeometricTransform;
            background = j4;
            drawStyle2 = drawStyle;
        }
        if (brush != null) {
            textForegroundStyleM2797from8_81llA = TextForegroundStyle.INSTANCE.from(brush, f);
        } else {
            textForegroundStyleM2797from8_81llA = TextForegroundStyle.INSTANCE.m2797from8_81llA(j);
        }
        TextForegroundStyle textForegroundStyleMerge2 = spanStyle.getTextForegroundStyle().merge(textForegroundStyleM2797from8_81llA);
        if (fontFamily == null) {
            fontFamily2 = spanStyle.getFontFamily();
        } else {
            fontFamily2 = fontFamily;
        }
        if (TextUnitKt.m3093isUnspecifiedR2X_6o(fontSize)) {
            fontSize = spanStyle.getFontSize();
        }
        if (fontWeight == null) {
            fontWeight2 = spanStyle.getFontWeight();
        } else {
            fontWeight2 = fontWeight;
        }
        if (fontStyle == null) {
            fontStyle2 = spanStyle.getFontStyle();
        } else {
            fontStyle2 = fontStyle;
        }
        if (fontSynthesis == null) {
            fontSynthesis2 = spanStyle.getFontSynthesis();
        } else {
            fontSynthesis2 = fontSynthesis;
        }
        if (fontFeatureSettings == null) {
            fontFeatureSettings = spanStyle.getFontFeatureSettings();
        }
        if (TextUnitKt.m3093isUnspecifiedR2X_6o(j3)) {
            letterSpacing = j3;
        } else {
            letterSpacing = spanStyle.getLetterSpacing();
        }
        if (baselineShift2 == null) {
            baselineShift2 = spanStyle.getBaselineShift();
        }
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = spanStyle.getTextGeometricTransform();
        }
        if (localeList == null) {
            localeList2 = spanStyle.getLocaleList();
        } else {
            localeList2 = localeList;
        }
        if (background == Color.INSTANCE.m566getUnspecified0d7_KjU()) {
            background = spanStyle.getBackground();
        }
        if (textDecoration2 == null) {
            textDecoration2 = spanStyle.getTextDecoration();
        }
        if (shadow2 == null) {
            shadow2 = spanStyle.getShadow();
        }
        Shadow shadow4 = shadow2;
        PlatformSpanStyle platformSpanStyleMergePlatformStyle2 = mergePlatformStyle(spanStyle, platformSpanStyle);
        if (drawStyle2 == null) {
            drawStyle3 = spanStyle.getDrawStyle();
        } else {
            drawStyle3 = drawStyle2;
        }
        return new SpanStyle(textForegroundStyleMerge2, fontSize, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, fontFeatureSettings, letterSpacing, baselineShift2, textGeometricTransform2, localeList2, background, textDecoration2, shadow4, platformSpanStyleMergePlatformStyle2, drawStyle3, (DefaultConstructorMarker) null);
    }
}
