package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\fH\u0002¨\u0006\r"}, d2 = {"firstImmediatelyAvailable", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/font/Font;", "", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FontListFontFamilyTypefaceAdapterKt {
    /* INFO: Access modifiers changed from: private */
    public static final Pair<List<Font>, Object> firstImmediatelyAvailable(List<? extends Font> list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1<? super TypefaceRequest, ? extends Object> function1) {
        Object objM2456unboximpl;
        Object objM3752constructorimpl;
        Object objM2456unboximpl2;
        int size = list.size();
        List listMutableListOf = null;
        for (int i = 0; i < size; i++) {
            Font font = list.get(i);
            int loadingStrategy = font.getLoadingStrategy();
            if (!FontLoadingStrategy.m2479equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m2484getBlockingPKNRLFQ())) {
                if (!FontLoadingStrategy.m2479equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m2485getOptionalLocalPKNRLFQ())) {
                    if (FontLoadingStrategy.m2479equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m2483getAsyncPKNRLFQ())) {
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResultM2448get1ASDuI8 = asyncTypefaceCache.m2448get1ASDuI8(font, platformFontLoader);
                        if (asyncTypefaceResultM2448get1ASDuI8 != null) {
                            if (!AsyncTypefaceCache.AsyncTypefaceResult.m2454isPermanentFailureimpl(asyncTypefaceResultM2448get1ASDuI8.m2456unboximpl()) && asyncTypefaceResultM2448get1ASDuI8.m2456unboximpl() != null) {
                                return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m2513synthesizeTypefaceFxwP2eA(typefaceRequest.m2538getFontSynthesisGVVA2EU(), asyncTypefaceResultM2448get1ASDuI8.m2456unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m2537getFontStyle_LCdwA()));
                            }
                        } else if (listMutableListOf == null) {
                            listMutableListOf = CollectionsKt.mutableListOf(font);
                        } else {
                            listMutableListOf.add(font);
                        }
                    } else {
                        throw new IllegalStateException("Unknown font type " + font);
                    }
                } else {
                    synchronized (asyncTypefaceCache.cacheLock) {
                        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key);
                        if (asyncTypefaceResult == null) {
                            asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key);
                        }
                        if (asyncTypefaceResult != null) {
                            objM2456unboximpl2 = asyncTypefaceResult.m2456unboximpl();
                        } else {
                            Unit unit = Unit.INSTANCE;
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                objM3752constructorimpl = Result.m3752constructorimpl(platformFontLoader.loadBlocking(font));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.INSTANCE;
                                objM3752constructorimpl = Result.m3752constructorimpl(ResultKt.createFailure(th));
                            }
                            Object obj = Result.m3758isFailureimpl(objM3752constructorimpl) ? null : objM3752constructorimpl;
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, obj, false, 8, null);
                            objM2456unboximpl2 = obj;
                        }
                    }
                    if (objM2456unboximpl2 != null) {
                        return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m2513synthesizeTypefaceFxwP2eA(typefaceRequest.m2538getFontSynthesisGVVA2EU(), objM2456unboximpl2, font, typefaceRequest.getFontWeight(), typefaceRequest.m2537getFontStyle_LCdwA()));
                    }
                }
            } else {
                synchronized (asyncTypefaceCache.cacheLock) {
                    AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key2);
                    if (asyncTypefaceResult2 == null) {
                        asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key2);
                    }
                    if (asyncTypefaceResult2 != null) {
                        objM2456unboximpl = asyncTypefaceResult2.m2456unboximpl();
                    } else {
                        Unit unit2 = Unit.INSTANCE;
                        try {
                            Object objLoadBlocking = platformFontLoader.loadBlocking(font);
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, objLoadBlocking, false, 8, null);
                            objM2456unboximpl = objLoadBlocking;
                        } catch (Exception e) {
                            throw new IllegalStateException("Unable to load font " + font, e);
                        }
                    }
                }
                if (objM2456unboximpl == null) {
                    throw new IllegalStateException("Unable to load font " + font);
                }
                return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m2513synthesizeTypefaceFxwP2eA(typefaceRequest.m2538getFontSynthesisGVVA2EU(), objM2456unboximpl, font, typefaceRequest.getFontWeight(), typefaceRequest.m2537getFontStyle_LCdwA()));
            }
        }
        return TuplesKt.to(listMutableListOf, function1.invoke(typefaceRequest));
    }
}
