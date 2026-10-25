package com.skydoves.balloon;

import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: BalloonPlacement.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J_\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\tHÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018¨\u0006-"}, d2 = {"Lcom/skydoves/balloon/BalloonPlacement;", "", "anchor", "Landroid/view/View;", "subAnchors", "", "align", "Lcom/skydoves/balloon/BalloonAlign;", "xOff", "", "yOff", "type", "Lcom/skydoves/balloon/PlacementType;", "width", "height", "<init>", "(Landroid/view/View;Ljava/util/List;Lcom/skydoves/balloon/BalloonAlign;IILcom/skydoves/balloon/PlacementType;II)V", "getAnchor", "()Landroid/view/View;", "getSubAnchors", "()Ljava/util/List;", "getAlign", "()Lcom/skydoves/balloon/BalloonAlign;", "getXOff", "()I", "getYOff", "getType", "()Lcom/skydoves/balloon/PlacementType;", "getWidth", "getHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "hashCode", "toString", "", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class BalloonPlacement {
    private final BalloonAlign align;
    private final View anchor;
    private final int height;
    private final List<View> subAnchors;
    private final PlacementType type;
    private final int width;
    private final int xOff;
    private final int yOff;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BalloonPlacement copy$default(BalloonPlacement balloonPlacement, View view, List list, BalloonAlign balloonAlign, int i, int i2, PlacementType placementType, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            view = balloonPlacement.anchor;
        }
        if ((i5 & 2) != 0) {
            list = balloonPlacement.subAnchors;
        }
        if ((i5 & 4) != 0) {
            balloonAlign = balloonPlacement.align;
        }
        if ((i5 & 8) != 0) {
            i = balloonPlacement.xOff;
        }
        if ((i5 & 16) != 0) {
            i2 = balloonPlacement.yOff;
        }
        if ((i5 & 32) != 0) {
            placementType = balloonPlacement.type;
        }
        if ((i5 & 64) != 0) {
            i3 = balloonPlacement.width;
        }
        if ((i5 & 128) != 0) {
            i4 = balloonPlacement.height;
        }
        int i6 = i3;
        int i7 = i4;
        int i8 = i2;
        PlacementType placementType2 = placementType;
        return balloonPlacement.copy(view, list, balloonAlign, i, i8, placementType2, i6, i7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final View getAnchor() {
        return this.anchor;
    }

    public final List<View> component2() {
        return this.subAnchors;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final BalloonAlign getAlign() {
        return this.align;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getXOff() {
        return this.xOff;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getYOff() {
        return this.yOff;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final PlacementType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final BalloonPlacement copy(View anchor, List<? extends View> subAnchors, BalloonAlign align, int xOff, int yOff, PlacementType type, int width, int height) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(subAnchors, "subAnchors");
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(type, "type");
        return new BalloonPlacement(anchor, subAnchors, align, xOff, yOff, type, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BalloonPlacement)) {
            return false;
        }
        BalloonPlacement balloonPlacement = (BalloonPlacement) other;
        return Intrinsics.areEqual(this.anchor, balloonPlacement.anchor) && Intrinsics.areEqual(this.subAnchors, balloonPlacement.subAnchors) && this.align == balloonPlacement.align && this.xOff == balloonPlacement.xOff && this.yOff == balloonPlacement.yOff && this.type == balloonPlacement.type && this.width == balloonPlacement.width && this.height == balloonPlacement.height;
    }

    public int hashCode() {
        return (((((((((((((this.anchor.hashCode() * 31) + this.subAnchors.hashCode()) * 31) + this.align.hashCode()) * 31) + Integer.hashCode(this.xOff)) * 31) + Integer.hashCode(this.yOff)) * 31) + this.type.hashCode()) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "BalloonPlacement(anchor=" + this.anchor + ", subAnchors=" + this.subAnchors + ", align=" + this.align + ", xOff=" + this.xOff + ", yOff=" + this.yOff + ", type=" + this.type + ", width=" + this.width + ", height=" + this.height + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BalloonPlacement(View anchor, List<? extends View> subAnchors, BalloonAlign align, int i, int i2, PlacementType type, int i3, int i4) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(subAnchors, "subAnchors");
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(type, "type");
        this.anchor = anchor;
        this.subAnchors = subAnchors;
        this.align = align;
        this.xOff = i;
        this.yOff = i2;
        this.type = type;
        this.width = i3;
        this.height = i4;
    }

    public final View getAnchor() {
        return this.anchor;
    }

    public /* synthetic */ BalloonPlacement(View view, List list, BalloonAlign balloonAlign, int i, int i2, PlacementType placementType, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i5 & 2) != 0 ? CollectionsKt.emptyList() : list, (i5 & 4) != 0 ? BalloonAlign.TOP : balloonAlign, (i5 & 8) != 0 ? 0 : i, (i5 & 16) != 0 ? 0 : i2, (i5 & 32) != 0 ? PlacementType.ALIGNMENT : placementType, (i5 & 64) != 0 ? 0 : i3, (i5 & 128) != 0 ? 0 : i4);
    }

    public final List<View> getSubAnchors() {
        return this.subAnchors;
    }

    public final BalloonAlign getAlign() {
        return this.align;
    }

    public final int getXOff() {
        return this.xOff;
    }

    public final int getYOff() {
        return this.yOff;
    }

    public final PlacementType getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }
}
