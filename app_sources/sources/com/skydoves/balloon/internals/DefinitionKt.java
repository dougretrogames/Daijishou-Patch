package com.skydoves.balloon.internals;

import kotlin.Metadata;

/* INFO: compiled from: Definition.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000¢\u0006\u0002\u0010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"NO_INT_VALUE", "", "NO_Float_VALUE", "", "getNO_Float_VALUE$annotations", "()V", "NO_LONG_VALUE", "", "LTR", "SIZE_ARROW_BOUNDARY", "unaryMinus", "predicate", "", "takeIfNotNoIntValue", "(I)Ljava/lang/Integer;", "balloon_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DefinitionKt {
    public static final int LTR = 1;
    public static final float NO_Float_VALUE = 0.0f;
    public static final int NO_INT_VALUE = Integer.MIN_VALUE;
    public static final long NO_LONG_VALUE = -1;
    public static final int SIZE_ARROW_BOUNDARY = 1;

    public static /* synthetic */ void getNO_Float_VALUE$annotations() {
    }

    public static final /* synthetic */ int unaryMinus(int i, boolean z) {
        return z ? -i : i;
    }

    public static final /* synthetic */ Integer takeIfNotNoIntValue(int i) {
        Integer numValueOf = Integer.valueOf(i);
        numValueOf.intValue();
        if (i != Integer.MIN_VALUE) {
            return numValueOf;
        }
        return null;
    }
}
