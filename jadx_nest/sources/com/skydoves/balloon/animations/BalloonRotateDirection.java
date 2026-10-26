package com.skydoves.balloon.animations;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* INFO: compiled from: BalloonRotateDirection.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/skydoves/balloon/animations/BalloonRotateDirection;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RIGHT", "LEFT", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum BalloonRotateDirection {
    RIGHT(1),
    LEFT(-1);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int value;

    public static EnumEntries<BalloonRotateDirection> getEntries() {
        return $ENTRIES;
    }

    BalloonRotateDirection(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
