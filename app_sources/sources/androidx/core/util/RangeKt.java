package androidx.core.util;

import android.util.Range;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ranges.ClosedRange;

/* INFO: compiled from: Range.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\f\u001a6\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0007\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\n\u001a0\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\t\u001a\u0002H\u0002H\u0087\f¢\u0006\u0002\u0010\n\u001a(\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0007¨\u0006\u000e"}, d2 = {"and", "Landroid/util/Range;", ExifInterface.GPS_DIRECTION_TRUE, "", "other", "plus", "value", "(Landroid/util/Range;Ljava/lang/Comparable;)Landroid/util/Range;", "rangeTo", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Landroid/util/Range;", "toClosedRange", "Lkotlin/ranges/ClosedRange;", "toRange", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RangeKt {
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t, T t2) {
        return new Range<>(t, t2);
    }

    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T t) {
        return range.extend(t);
    }

    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> range2) {
        return range.extend(range2);
    }

    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> range2) {
        return range.intersect(range2);
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: androidx.core.util.RangeKt$toClosedRange$1, reason: invalid class name */
    /* INFO: compiled from: Range.kt */
    @Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001R\u001c\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00018\u00008\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00018\u00008\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"androidx/core/util/RangeKt$toClosedRange$1", "Lkotlin/ranges/ClosedRange;", "endInclusive", "kotlin.jvm.PlatformType", "getEndInclusive", "()Ljava/lang/Comparable;", "start", "getStart", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1<T> implements ClosedRange<T> {
        final /* synthetic */ Range<T> $this_toClosedRange;

        AnonymousClass1(Range<T> range) {
            this.$this_toClosedRange = range;
        }

        /* WARN: Incorrect types in method signature: (TT;)Z */
        @Override // kotlin.ranges.ClosedRange
        public boolean contains(Comparable comparable) {
            return ClosedRange.DefaultImpls.contains(this, comparable);
        }

        @Override // kotlin.ranges.ClosedRange
        public boolean isEmpty() {
            return ClosedRange.DefaultImpls.isEmpty(this);
        }

        /* WARN: Incorrect return type in method signature: ()TT; */
        @Override // kotlin.ranges.ClosedRange
        public Comparable getEndInclusive() {
            return this.$this_toClosedRange.getUpper();
        }

        /* WARN: Incorrect return type in method signature: ()TT; */
        @Override // kotlin.ranges.ClosedRange
        public Comparable getStart() {
            return this.$this_toClosedRange.getLower();
        }
    }

    public static final <T extends Comparable<? super T>> ClosedRange<T> toClosedRange(Range<T> range) {
        return new AnonymousClass1(range);
    }

    public static final <T extends Comparable<? super T>> Range<T> toRange(ClosedRange<T> closedRange) {
        return new Range<>(closedRange.getStart(), closedRange.getEndInclusive());
    }
}
