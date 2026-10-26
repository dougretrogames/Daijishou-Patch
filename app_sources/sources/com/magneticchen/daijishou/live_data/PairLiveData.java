package com.magneticchen.daijishou.live_data;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: MoreLiveData.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u0001H\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00040\u0003B!\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/live_data/PairLiveData;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Landroidx/lifecycle/MediatorLiveData;", "Lkotlin/Pair;", "first", "Landroidx/lifecycle/LiveData;", "second", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LiveData;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PairLiveData<A, B> extends MediatorLiveData<Pair<? extends A, ? extends B>> {
    /* WARN: Multi-variable type inference failed */
    public PairLiveData(LiveData<A> first, LiveData<B> second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        addSource(first, new MoreLiveDataKt$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(this, second)));
        addSource(second, new MoreLiveDataKt$sam$androidx_lifecycle_Observer$0(new AnonymousClass2(this, first)));
    }

    /* INFO: renamed from: com.magneticchen.daijishou.live_data.PairLiveData$1, reason: invalid class name */
    /* INFO: compiled from: MoreLiveData.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "it", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function1<A, Unit> {
        final /* synthetic */ LiveData<B> $second;
        final /* synthetic */ PairLiveData<A, B> this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PairLiveData<A, B> pairLiveData, LiveData<B> liveData) {
            super(1);
            this.this$0 = pairLiveData;
            this.$second = liveData;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((A) obj);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(A a) {
            this.this$0.setValue(TuplesKt.to(a, this.$second.getValue()));
        }
    }

    /* INFO: renamed from: com.magneticchen.daijishou.live_data.PairLiveData$2, reason: invalid class name */
    /* INFO: compiled from: MoreLiveData.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0003H\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "it", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Unit> implements Function1<B, Unit> {
        final /* synthetic */ LiveData<A> $first;
        final /* synthetic */ PairLiveData<A, B> this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PairLiveData<A, B> pairLiveData, LiveData<A> liveData) {
            super(1);
            this.this$0 = pairLiveData;
            this.$first = liveData;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((B) obj);
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(B b) {
            this.this$0.setValue(TuplesKt.to(this.$first.getValue(), b));
        }
    }
}
