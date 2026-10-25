package com.skydoves.balloon;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: BalloonCenterAlign.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0007j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/skydoves/balloon/BalloonCenterAlign;", "", "<init>", "(Ljava/lang/String;I)V", "START", "END", "TOP", "BOTTOM", "toAlign", "Lcom/skydoves/balloon/BalloonAlign;", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum BalloonCenterAlign {
    START,
    END,
    TOP,
    BOTTOM;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: compiled from: BalloonCenterAlign.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BalloonCenterAlign.values().length];
            try {
                iArr[BalloonCenterAlign.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BalloonCenterAlign.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BalloonCenterAlign.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BalloonCenterAlign.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<BalloonCenterAlign> getEntries() {
        return $ENTRIES;
    }

    public final BalloonAlign toAlign() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return BalloonAlign.START;
        }
        if (i == 2) {
            return BalloonAlign.END;
        }
        if (i == 3) {
            return BalloonAlign.TOP;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return BalloonAlign.BOTTOM;
    }
}
