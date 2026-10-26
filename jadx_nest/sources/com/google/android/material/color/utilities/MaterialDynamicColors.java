package com.google.android.material.color.utilities;

/* INFO: loaded from: classes3.dex */
public final class MaterialDynamicColors {
    public DynamicColor highestSurface(DynamicScheme dynamicScheme) {
        return dynamicScheme.isDark ? surfaceBright() : surfaceDim();
    }

    public DynamicColor primaryPaletteKeyColor() {
        return DynamicColor.fromPalette("primary_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda72(), new MaterialDynamicColors$$ExternalSyntheticLambda73());
    }

    public DynamicColor secondaryPaletteKeyColor() {
        return DynamicColor.fromPalette("secondary_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda79(), new MaterialDynamicColors$$ExternalSyntheticLambda80());
    }

    public DynamicColor tertiaryPaletteKeyColor() {
        return DynamicColor.fromPalette("tertiary_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda91(), new MaterialDynamicColors$$ExternalSyntheticLambda92());
    }

    public DynamicColor neutralPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda11(), new MaterialDynamicColors$$ExternalSyntheticLambda22());
    }

    public DynamicColor neutralVariantPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_variant_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda144(), new MaterialDynamicColors$$ExternalSyntheticLambda145());
    }

    public DynamicColor background() {
        return new DynamicColor("background", new MaterialDynamicColors$$ExternalSyntheticLambda100(), new MaterialDynamicColors$$ExternalSyntheticLambda101(), true, null, null, null, null);
    }

    public DynamicColor onBackground() {
        return new DynamicColor("on_background", new MaterialDynamicColors$$ExternalSyntheticLambda104(), new MaterialDynamicColors$$ExternalSyntheticLambda105(), false, new MaterialDynamicColors$$ExternalSyntheticLambda106(this), null, new ContrastCurve(3.0d, 3.0d, 4.5d, 7.0d), null);
    }

    /* INFO: renamed from: lambda$onBackground$14$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3267x24678954(DynamicScheme dynamicScheme) {
        return background();
    }

    public DynamicColor surface() {
        return new DynamicColor("surface", new MaterialDynamicColors$$ExternalSyntheticLambda0(), new MaterialDynamicColors$$ExternalSyntheticLambda74(), true, null, null, null, null);
    }

    public DynamicColor surfaceDim() {
        return new DynamicColor("surface_dim", new MaterialDynamicColors$$ExternalSyntheticLambda33(), new MaterialDynamicColors$$ExternalSyntheticLambda44(), true, null, null, null, null);
    }

    public DynamicColor surfaceBright() {
        return new DynamicColor("surface_bright", new MaterialDynamicColors$$ExternalSyntheticLambda110(), new MaterialDynamicColors$$ExternalSyntheticLambda111(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainerLowest() {
        return new DynamicColor("surface_container_lowest", new MaterialDynamicColors$$ExternalSyntheticLambda7(), new MaterialDynamicColors$$ExternalSyntheticLambda8(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainerLow() {
        return new DynamicColor("surface_container_low", new MaterialDynamicColors$$ExternalSyntheticLambda81(), new MaterialDynamicColors$$ExternalSyntheticLambda82(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainer() {
        return new DynamicColor("surface_container", new MaterialDynamicColors$$ExternalSyntheticLambda38(), new MaterialDynamicColors$$ExternalSyntheticLambda39(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainerHigh() {
        return new DynamicColor("surface_container_high", new MaterialDynamicColors$$ExternalSyntheticLambda102(), new MaterialDynamicColors$$ExternalSyntheticLambda103(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainerHighest() {
        return new DynamicColor("surface_container_highest", new MaterialDynamicColors$$ExternalSyntheticLambda150(), new MaterialDynamicColors$$ExternalSyntheticLambda152(), true, null, null, null, null);
    }

    public DynamicColor onSurface() {
        return new DynamicColor("on_surface", new MaterialDynamicColors$$ExternalSyntheticLambda140(), new MaterialDynamicColors$$ExternalSyntheticLambda151(), false, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    public DynamicColor surfaceVariant() {
        return new DynamicColor("surface_variant", new MaterialDynamicColors$$ExternalSyntheticLambda142(), new MaterialDynamicColors$$ExternalSyntheticLambda143(), true, null, null, null, null);
    }

    public DynamicColor onSurfaceVariant() {
        return new DynamicColor("on_surface_variant", new MaterialDynamicColors$$ExternalSyntheticLambda40(), new MaterialDynamicColors$$ExternalSyntheticLambda41(), false, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    public DynamicColor inverseSurface() {
        return new DynamicColor("inverse_surface", new MaterialDynamicColors$$ExternalSyntheticLambda42(), new MaterialDynamicColors$$ExternalSyntheticLambda43(), false, null, null, null, null);
    }

    public DynamicColor inverseOnSurface() {
        return new DynamicColor("inverse_on_surface", new MaterialDynamicColors$$ExternalSyntheticLambda18(), new MaterialDynamicColors$$ExternalSyntheticLambda19(), false, new MaterialDynamicColors$$ExternalSyntheticLambda20(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* INFO: renamed from: lambda$inverseOnSurface$41$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3265xcbcaf83d(DynamicScheme dynamicScheme) {
        return inverseSurface();
    }

    public DynamicColor outline() {
        return new DynamicColor("outline", new MaterialDynamicColors$$ExternalSyntheticLambda9(), new MaterialDynamicColors$$ExternalSyntheticLambda10(), false, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1.5d, 3.0d, 4.5d, 7.0d), null);
    }

    public DynamicColor outlineVariant() {
        return new DynamicColor("outline_variant", new MaterialDynamicColors$$ExternalSyntheticLambda108(), new MaterialDynamicColors$$ExternalSyntheticLambda109(), false, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), null);
    }

    public DynamicColor shadow() {
        return new DynamicColor("shadow", new MaterialDynamicColors$$ExternalSyntheticLambda148(), new MaterialDynamicColors$$ExternalSyntheticLambda149(), false, null, null, null, null);
    }

    public DynamicColor scrim() {
        return new DynamicColor("scrim", new MaterialDynamicColors$$ExternalSyntheticLambda60(), new MaterialDynamicColors$$ExternalSyntheticLambda61(), false, null, null, null, null);
    }

    public DynamicColor surfaceTint() {
        return new DynamicColor("surface_tint", new MaterialDynamicColors$$ExternalSyntheticLambda12(), new MaterialDynamicColors$$ExternalSyntheticLambda13(), true, null, null, null, null);
    }

    public DynamicColor primary() {
        return new DynamicColor("primary", new MaterialDynamicColors$$ExternalSyntheticLambda57(), new MaterialDynamicColors$$ExternalSyntheticLambda58(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new MaterialDynamicColors$$ExternalSyntheticLambda59(this));
    }

    static /* synthetic */ Double lambda$primary$53(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 100.0d : 0.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* INFO: renamed from: lambda$primary$54$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ ToneDeltaPair m3291x39203b5(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryContainer(), primary(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onPrimary() {
        return new DynamicColor("on_primary", new MaterialDynamicColors$$ExternalSyntheticLambda112(), new MaterialDynamicColors$$ExternalSyntheticLambda113(), false, new MaterialDynamicColors$$ExternalSyntheticLambda114(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    static /* synthetic */ Double lambda$onPrimary$56(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* INFO: renamed from: lambda$onPrimary$57$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3270x16f20f37(DynamicScheme dynamicScheme) {
        return primary();
    }

    public DynamicColor primaryContainer() {
        return new DynamicColor("primary_container", new MaterialDynamicColors$$ExternalSyntheticLambda97(), new MaterialDynamicColors$$ExternalSyntheticLambda98(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new MaterialDynamicColors$$ExternalSyntheticLambda99(this));
    }

    static /* synthetic */ Double lambda$primaryContainer$59(DynamicScheme dynamicScheme) {
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(performAlbers(dynamicScheme.sourceColorHct, dynamicScheme));
        }
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 85.0d : 25.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* INFO: renamed from: lambda$primaryContainer$60$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ ToneDeltaPair m3292x8277b1b9(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryContainer(), primary(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onPrimaryContainer() {
        return new DynamicColor("on_primary_container", new MaterialDynamicColors$$ExternalSyntheticLambda135(), new MaterialDynamicColors$$ExternalSyntheticLambda136(this), false, new MaterialDynamicColors$$ExternalSyntheticLambda137(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* INFO: renamed from: lambda$onPrimaryContainer$62$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ Double m3271x617ce7dc(DynamicScheme dynamicScheme) {
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(primaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        }
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 0.0d : 100.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* INFO: renamed from: lambda$onPrimaryContainer$63$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3272x3d3e639d(DynamicScheme dynamicScheme) {
        return primaryContainer();
    }

    public DynamicColor inversePrimary() {
        return new DynamicColor("inverse_primary", new MaterialDynamicColors$$ExternalSyntheticLambda115(), new MaterialDynamicColors$$ExternalSyntheticLambda116(), false, new MaterialDynamicColors$$ExternalSyntheticLambda117(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    /* INFO: renamed from: lambda$inversePrimary$66$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3266x6f94cccc(DynamicScheme dynamicScheme) {
        return inverseSurface();
    }

    public DynamicColor secondary() {
        return new DynamicColor("secondary", new MaterialDynamicColors$$ExternalSyntheticLambda4(), new MaterialDynamicColors$$ExternalSyntheticLambda5(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new MaterialDynamicColors$$ExternalSyntheticLambda6(this));
    }

    /* INFO: renamed from: lambda$secondary$69$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ ToneDeltaPair m3295x991d7367(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryContainer(), secondary(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onSecondary() {
        return new DynamicColor("on_secondary", new MaterialDynamicColors$$ExternalSyntheticLambda1(), new MaterialDynamicColors$$ExternalSyntheticLambda2(), false, new MaterialDynamicColors$$ExternalSyntheticLambda3(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    static /* synthetic */ Double lambda$onSecondary$71(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 10.0d : 100.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* INFO: renamed from: lambda$onSecondary$72$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3277x1ad791fe(DynamicScheme dynamicScheme) {
        return secondary();
    }

    public DynamicColor secondaryContainer() {
        return new DynamicColor("secondary_container", new MaterialDynamicColors$$ExternalSyntheticLambda83(), new MaterialDynamicColors$$ExternalSyntheticLambda84(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new MaterialDynamicColors$$ExternalSyntheticLambda86(this));
    }

    static /* synthetic */ Double lambda$secondaryContainer$74(DynamicScheme dynamicScheme) {
        double d = dynamicScheme.isDark ? 30.0d : 90.0d;
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 30.0d : 85.0d);
        }
        if (!isFidelity(dynamicScheme)) {
            return Double.valueOf(d);
        }
        return Double.valueOf(performAlbers(dynamicScheme.secondaryPalette.getHct(findDesiredChromaByTone(dynamicScheme.secondaryPalette.getHue(), dynamicScheme.secondaryPalette.getChroma(), d, !dynamicScheme.isDark)), dynamicScheme));
    }

    /* INFO: renamed from: lambda$secondaryContainer$75$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ ToneDeltaPair m3296x485cd00f(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryContainer(), secondary(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onSecondaryContainer() {
        return new DynamicColor("on_secondary_container", new MaterialDynamicColors$$ExternalSyntheticLambda25(), new MaterialDynamicColors$$ExternalSyntheticLambda26(this), false, new MaterialDynamicColors$$ExternalSyntheticLambda27(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* INFO: renamed from: lambda$onSecondaryContainer$77$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ Double m3278x4fcce1f2(DynamicScheme dynamicScheme) {
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(secondaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        }
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* INFO: renamed from: lambda$onSecondaryContainer$78$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3279x2b8e5db3(DynamicScheme dynamicScheme) {
        return secondaryContainer();
    }

    public DynamicColor tertiary() {
        return new DynamicColor("tertiary", new MaterialDynamicColors$$ExternalSyntheticLambda67(), new MaterialDynamicColors$$ExternalSyntheticLambda68(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new MaterialDynamicColors$$ExternalSyntheticLambda69(this));
    }

    static /* synthetic */ Double lambda$tertiary$80(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 90.0d : 25.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* INFO: renamed from: lambda$tertiary$81$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ ToneDeltaPair m3299x1f6aa165(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryContainer(), tertiary(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onTertiary() {
        return new DynamicColor("on_tertiary", new MaterialDynamicColors$$ExternalSyntheticLambda107(), new MaterialDynamicColors$$ExternalSyntheticLambda118(), false, new MaterialDynamicColors$$ExternalSyntheticLambda129(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    static /* synthetic */ Double lambda$onTertiary$83(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
        }
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* INFO: renamed from: lambda$onTertiary$84$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3284x36068449(DynamicScheme dynamicScheme) {
        return tertiary();
    }

    public DynamicColor tertiaryContainer() {
        return new DynamicColor("tertiary_container", new MaterialDynamicColors$$ExternalSyntheticLambda159(), new MaterialDynamicColors$$ExternalSyntheticLambda160(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new MaterialDynamicColors$$ExternalSyntheticLambda161(this));
    }

    static /* synthetic */ Double lambda$tertiaryContainer$86(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 60.0d : 49.0d);
        }
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DislikeAnalyzer.fixIfDisliked(dynamicScheme.tertiaryPalette.getHct(performAlbers(dynamicScheme.tertiaryPalette.getHct(dynamicScheme.sourceColorHct.getTone()), dynamicScheme))).getTone());
        }
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* INFO: renamed from: lambda$tertiaryContainer$87$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ ToneDeltaPair m3300x357de1a8(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryContainer(), tertiary(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onTertiaryContainer() {
        return new DynamicColor("on_tertiary_container", new MaterialDynamicColors$$ExternalSyntheticLambda21(), new MaterialDynamicColors$$ExternalSyntheticLambda23(this), false, new MaterialDynamicColors$$ExternalSyntheticLambda24(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* INFO: renamed from: lambda$onTertiaryContainer$89$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ Double m3285xb5c66ea9(DynamicScheme dynamicScheme) {
        if (isMonochrome(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.isDark ? 0.0d : 100.0d);
        }
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.foregroundTone(tertiaryContainer().tone.apply(dynamicScheme).doubleValue(), 4.5d));
        }
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* INFO: renamed from: lambda$onTertiaryContainer$90$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3286x9867113f(DynamicScheme dynamicScheme) {
        return tertiaryContainer();
    }

    public DynamicColor error() {
        return new DynamicColor("error", new MaterialDynamicColors$$ExternalSyntheticLambda32(), new MaterialDynamicColors$$ExternalSyntheticLambda34(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new MaterialDynamicColors$$ExternalSyntheticLambda35(this));
    }

    /* INFO: renamed from: lambda$error$93$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ ToneDeltaPair m3263x590ec46a(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(errorContainer(), error(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onError() {
        return new DynamicColor("on_error", new MaterialDynamicColors$$ExternalSyntheticLambda130(), new MaterialDynamicColors$$ExternalSyntheticLambda131(), false, new MaterialDynamicColors$$ExternalSyntheticLambda132(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* INFO: renamed from: lambda$onError$96$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3268xb6a5d3ac(DynamicScheme dynamicScheme) {
        return error();
    }

    public DynamicColor errorContainer() {
        return new DynamicColor("error_container", new MaterialDynamicColors$$ExternalSyntheticLambda50(), new MaterialDynamicColors$$ExternalSyntheticLambda51(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new MaterialDynamicColors$$ExternalSyntheticLambda52(this));
    }

    /* INFO: renamed from: lambda$errorContainer$99$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ ToneDeltaPair m3264x33346ee5(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(errorContainer(), error(), 15.0d, TonePolarity.NEARER, false);
    }

    public DynamicColor onErrorContainer() {
        return new DynamicColor("on_error_container", new MaterialDynamicColors$$ExternalSyntheticLambda45(), new MaterialDynamicColors$$ExternalSyntheticLambda46(), false, new MaterialDynamicColors$$ExternalSyntheticLambda47(this), null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* INFO: renamed from: lambda$onErrorContainer$102$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3269x2dffdbdb(DynamicScheme dynamicScheme) {
        return errorContainer();
    }

    public DynamicColor primaryFixed() {
        return new DynamicColor("primary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda153(), new MaterialDynamicColors$$ExternalSyntheticLambda154(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new MaterialDynamicColors$$ExternalSyntheticLambda155(this));
    }

    /* INFO: renamed from: lambda$primaryFixed$105$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ ToneDeltaPair m3293xcb141198(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryFixed(), primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public DynamicColor primaryFixedDim() {
        return new DynamicColor("primary_fixed_dim", new MaterialDynamicColors$$ExternalSyntheticLambda156(), new MaterialDynamicColors$$ExternalSyntheticLambda157(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new MaterialDynamicColors$$ExternalSyntheticLambda158(this));
    }

    /* INFO: renamed from: lambda$primaryFixedDim$108$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ ToneDeltaPair m3294x8f195ac5(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(primaryFixed(), primaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public DynamicColor onPrimaryFixed() {
        return new DynamicColor("on_primary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda28(), new MaterialDynamicColors$$ExternalSyntheticLambda29(), false, new MaterialDynamicColors$$ExternalSyntheticLambda30(this), new MaterialDynamicColors$$ExternalSyntheticLambda31(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* INFO: renamed from: lambda$onPrimaryFixed$111$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3273x702e4bf2(DynamicScheme dynamicScheme) {
        return primaryFixedDim();
    }

    /* INFO: renamed from: lambda$onPrimaryFixed$112$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3274x4befc7b3(DynamicScheme dynamicScheme) {
        return primaryFixed();
    }

    public DynamicColor onPrimaryFixedVariant() {
        return new DynamicColor("on_primary_fixed_variant", new MaterialDynamicColors$$ExternalSyntheticLambda122(), new MaterialDynamicColors$$ExternalSyntheticLambda123(), false, new MaterialDynamicColors$$ExternalSyntheticLambda124(this), new MaterialDynamicColors$$ExternalSyntheticLambda125(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    /* INFO: renamed from: lambda$onPrimaryFixedVariant$115$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3275x19d0bbbf(DynamicScheme dynamicScheme) {
        return primaryFixedDim();
    }

    /* INFO: renamed from: lambda$onPrimaryFixedVariant$116$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3276xf5923780(DynamicScheme dynamicScheme) {
        return primaryFixed();
    }

    public DynamicColor secondaryFixed() {
        return new DynamicColor("secondary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda119(), new MaterialDynamicColors$$ExternalSyntheticLambda120(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new MaterialDynamicColors$$ExternalSyntheticLambda121(this));
    }

    /* INFO: renamed from: lambda$secondaryFixed$119$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ ToneDeltaPair m3297x75ece309(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryFixed(), secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public DynamicColor secondaryFixedDim() {
        return new DynamicColor("secondary_fixed_dim", new MaterialDynamicColors$$ExternalSyntheticLambda138(), new MaterialDynamicColors$$ExternalSyntheticLambda139(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new MaterialDynamicColors$$ExternalSyntheticLambda141(this));
    }

    /* INFO: renamed from: lambda$secondaryFixedDim$122$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ ToneDeltaPair m3298x801c242f(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(secondaryFixed(), secondaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public DynamicColor onSecondaryFixed() {
        return new DynamicColor("on_secondary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda14(), new MaterialDynamicColors$$ExternalSyntheticLambda15(), false, new MaterialDynamicColors$$ExternalSyntheticLambda16(this), new MaterialDynamicColors$$ExternalSyntheticLambda17(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* INFO: renamed from: lambda$onSecondaryFixed$125$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3280xf72fd9a3(DynamicScheme dynamicScheme) {
        return secondaryFixedDim();
    }

    /* INFO: renamed from: lambda$onSecondaryFixed$126$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3281xd2f15564(DynamicScheme dynamicScheme) {
        return secondaryFixed();
    }

    public DynamicColor onSecondaryFixedVariant() {
        return new DynamicColor("on_secondary_fixed_variant", new MaterialDynamicColors$$ExternalSyntheticLambda62(), new MaterialDynamicColors$$ExternalSyntheticLambda63(), false, new MaterialDynamicColors$$ExternalSyntheticLambda64(this), new MaterialDynamicColors$$ExternalSyntheticLambda65(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    /* INFO: renamed from: lambda$onSecondaryFixedVariant$129$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3282x26187114(DynamicScheme dynamicScheme) {
        return secondaryFixedDim();
    }

    /* INFO: renamed from: lambda$onSecondaryFixedVariant$130$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3283x8b913aa(DynamicScheme dynamicScheme) {
        return secondaryFixed();
    }

    public DynamicColor tertiaryFixed() {
        return new DynamicColor("tertiary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda53(), new MaterialDynamicColors$$ExternalSyntheticLambda54(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new MaterialDynamicColors$$ExternalSyntheticLambda56(this));
    }

    /* INFO: renamed from: lambda$tertiaryFixed$133$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ ToneDeltaPair m3301x59237289(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryFixed(), tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public DynamicColor tertiaryFixedDim() {
        return new DynamicColor("tertiary_fixed_dim", new MaterialDynamicColors$$ExternalSyntheticLambda126(), new MaterialDynamicColors$$ExternalSyntheticLambda127(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new MaterialDynamicColors$$ExternalSyntheticLambda128(this));
    }

    /* INFO: renamed from: lambda$tertiaryFixedDim$136$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ ToneDeltaPair m3302x24c02d4a(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(tertiaryFixed(), tertiaryFixedDim(), 10.0d, TonePolarity.LIGHTER, true);
    }

    public DynamicColor onTertiaryFixed() {
        return new DynamicColor("on_tertiary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda87(), new MaterialDynamicColors$$ExternalSyntheticLambda88(), false, new MaterialDynamicColors$$ExternalSyntheticLambda89(this), new MaterialDynamicColors$$ExternalSyntheticLambda90(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), null);
    }

    /* INFO: renamed from: lambda$onTertiaryFixed$139$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3287xfe3fcbf0(DynamicScheme dynamicScheme) {
        return tertiaryFixedDim();
    }

    /* INFO: renamed from: lambda$onTertiaryFixed$140$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3288xe0e06e86(DynamicScheme dynamicScheme) {
        return tertiaryFixed();
    }

    public DynamicColor onTertiaryFixedVariant() {
        return new DynamicColor("on_tertiary_fixed_variant", new MaterialDynamicColors$$ExternalSyntheticLambda75(), new MaterialDynamicColors$$ExternalSyntheticLambda76(), false, new MaterialDynamicColors$$ExternalSyntheticLambda77(this), new MaterialDynamicColors$$ExternalSyntheticLambda78(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), null);
    }

    /* INFO: renamed from: lambda$onTertiaryFixedVariant$143$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3289x702fc122(DynamicScheme dynamicScheme) {
        return tertiaryFixedDim();
    }

    /* INFO: renamed from: lambda$onTertiaryFixedVariant$144$com-google-android-material-color-utilities-MaterialDynamicColors, reason: not valid java name */
    /* synthetic */ DynamicColor m3290x4bf13ce3(DynamicScheme dynamicScheme) {
        return tertiaryFixed();
    }

    public DynamicColor controlActivated() {
        return DynamicColor.fromPalette("control_activated", new MaterialDynamicColors$$ExternalSyntheticLambda70(), new MaterialDynamicColors$$ExternalSyntheticLambda71());
    }

    public DynamicColor controlNormal() {
        return DynamicColor.fromPalette("control_normal", new MaterialDynamicColors$$ExternalSyntheticLambda55(), new MaterialDynamicColors$$ExternalSyntheticLambda66());
    }

    public DynamicColor controlHighlight() {
        return new DynamicColor("control_highlight", new MaterialDynamicColors$$ExternalSyntheticLambda93(), new MaterialDynamicColors$$ExternalSyntheticLambda94(), false, null, null, null, null, new MaterialDynamicColors$$ExternalSyntheticLambda95());
    }

    public DynamicColor textPrimaryInverse() {
        return DynamicColor.fromPalette("text_primary_inverse", new MaterialDynamicColors$$ExternalSyntheticLambda36(), new MaterialDynamicColors$$ExternalSyntheticLambda37());
    }

    public DynamicColor textSecondaryAndTertiaryInverse() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse", new MaterialDynamicColors$$ExternalSyntheticLambda48(), new MaterialDynamicColors$$ExternalSyntheticLambda49());
    }

    public DynamicColor textPrimaryInverseDisableOnly() {
        return DynamicColor.fromPalette("text_primary_inverse_disable_only", new MaterialDynamicColors$$ExternalSyntheticLambda133(), new MaterialDynamicColors$$ExternalSyntheticLambda134());
    }

    public DynamicColor textSecondaryAndTertiaryInverseDisabled() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse_disabled", new MaterialDynamicColors$$ExternalSyntheticLambda85(), new MaterialDynamicColors$$ExternalSyntheticLambda96());
    }

    public DynamicColor textHintInverse() {
        return DynamicColor.fromPalette("text_hint_inverse", new MaterialDynamicColors$$ExternalSyntheticLambda146(), new MaterialDynamicColors$$ExternalSyntheticLambda147());
    }

    private static ViewingConditions viewingConditionsForAlbers(DynamicScheme dynamicScheme) {
        return ViewingConditions.defaultWithBackgroundLstar(dynamicScheme.isDark ? 30.0d : 80.0d);
    }

    private static boolean isFidelity(DynamicScheme dynamicScheme) {
        return dynamicScheme.variant == Variant.FIDELITY || dynamicScheme.variant == Variant.CONTENT;
    }

    private static boolean isMonochrome(DynamicScheme dynamicScheme) {
        return dynamicScheme.variant == Variant.MONOCHROME;
    }

    static double findDesiredChromaByTone(double d, double d2, double d3, boolean z) {
        Hct hctFrom = Hct.from(d, d2, d3);
        if (hctFrom.getChroma() < d2) {
            double chroma = hctFrom.getChroma();
            while (hctFrom.getChroma() < d2) {
                d3 += z ? -1.0d : 1.0d;
                Hct hctFrom2 = Hct.from(d, d2, d3);
                if (chroma > hctFrom2.getChroma() || Math.abs(hctFrom2.getChroma() - d2) < 0.4d) {
                    return d3;
                }
                if (Math.abs(hctFrom2.getChroma() - d2) < Math.abs(hctFrom.getChroma() - d2)) {
                    hctFrom = hctFrom2;
                }
                chroma = Math.max(chroma, hctFrom2.getChroma());
            }
        }
        return d3;
    }

    static double performAlbers(Hct hct, DynamicScheme dynamicScheme) {
        Hct hctInViewingConditions = hct.inViewingConditions(viewingConditionsForAlbers(dynamicScheme));
        if (DynamicColor.tonePrefersLightForeground(hct.getTone()) && !DynamicColor.toneAllowsLightForeground(hctInViewingConditions.getTone())) {
            return DynamicColor.enableLightForeground(hct.getTone());
        }
        return DynamicColor.enableLightForeground(hctInViewingConditions.getTone());
    }
}
