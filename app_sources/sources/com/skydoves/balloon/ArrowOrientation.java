package com.skydoves.balloon;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ArrowOrientation.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/skydoves/balloon/ArrowOrientation;", "", "<init>", "(Ljava/lang/String;I)V", "BOTTOM", "TOP", "START", "END", "Companion", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum ArrowOrientation {
    BOTTOM,
    TOP,
    START,
    END;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<ArrowOrientation> getEntries() {
        return $ENTRIES;
    }

    /* INFO: compiled from: ArrowOrientation.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/skydoves/balloon/ArrowOrientation$Companion;", "", "<init>", "()V", "getRTLSupportOrientation", "Lcom/skydoves/balloon/ArrowOrientation;", "isRtlLayout", "", "getRTLSupportOrientation$balloon_release", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        /* INFO: compiled from: ArrowOrientation.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ArrowOrientation.values().length];
                try {
                    iArr[ArrowOrientation.START.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ArrowOrientation.END.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArrowOrientation getRTLSupportOrientation$balloon_release(ArrowOrientation arrowOrientation, boolean z) {
            Intrinsics.checkNotNullParameter(arrowOrientation, "<this>");
            if (z) {
                int i = WhenMappings.$EnumSwitchMapping$0[arrowOrientation.ordinal()];
                if (i == 1) {
                    return ArrowOrientation.END;
                }
                if (i == 2) {
                    return ArrowOrientation.START;
                }
            }
            return arrowOrientation;
        }
    }
}
