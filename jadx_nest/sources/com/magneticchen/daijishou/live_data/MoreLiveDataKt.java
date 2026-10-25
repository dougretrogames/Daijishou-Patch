package com.magneticchen.daijishou.live_data;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MoreLiveData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0004\u001aP\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0004¨\u0006\n"}, d2 = {"combine", "Lcom/magneticchen/daijishou/live_data/PairLiveData;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Landroidx/lifecycle/LiveData;", "other", "Lcom/magneticchen/daijishou/live_data/TripleLiveData;", "C", "second", "third", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class MoreLiveDataKt {
    public static final <A, B> PairLiveData<A, B> combine(LiveData<A> liveData, LiveData<B> other) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return new PairLiveData<>(liveData, other);
    }

    public static final <A, B, C> TripleLiveData<A, B, C> combine(LiveData<A> liveData, LiveData<B> second, LiveData<C> third) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(third, "third");
        return new TripleLiveData<>(liveData, second, third);
    }
}
