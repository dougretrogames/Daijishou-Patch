package com.magneticchen.daijishou.live_data;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: MoreLiveData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032 \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u00050\u0004B/\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/magneticchen/daijishou/live_data/TripleLiveData;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "Landroidx/lifecycle/MediatorLiveData;", "Lkotlin/Triple;", "first", "Landroidx/lifecycle/LiveData;", "second", "third", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LiveData;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TripleLiveData<A, B, C> extends MediatorLiveData<Triple<? extends A, ? extends B, ? extends C>> {
    /* JADX WARN: Multi-variable type inference failed */
    public TripleLiveData(LiveData<A> first, LiveData<B> second, LiveData<C> third) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(third, "third");
        addSource(first, new MoreLiveDataKt$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(this, second, third)));
        addSource(second, new MoreLiveDataKt$sam$androidx_lifecycle_Observer$0(new AnonymousClass2(this, first, third)));
        addSource(third, new MoreLiveDataKt$sam$androidx_lifecycle_Observer$0(new AnonymousClass3(this, first, second)));
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.live_data.TripleLiveData$1, reason: invalid class name */
    /* JADX INFO: compiled from: MoreLiveData.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u000e\u0010\u0005\u001a\n \u0006*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "it", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda<Unit> implements Function1<A, Unit> {
        final /* synthetic */ LiveData<B> $second;
        final /* synthetic */ LiveData<C> $third;
        final /* synthetic */ TripleLiveData<A, B, C> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TripleLiveData<A, B, C> tripleLiveData, LiveData<B> liveData, LiveData<C> liveData2) {
            super(1);
            this.this$0 = tripleLiveData;
            this.$second = liveData;
            this.$third = liveData2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((A) obj);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(A a) {
            this.this$0.setValue(new Triple(a, this.$second.getValue(), this.$third.getValue()));
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.live_data.TripleLiveData$2, reason: invalid class name */
    /* JADX INFO: compiled from: MoreLiveData.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u000e\u0010\u0005\u001a\n \u0006*\u0004\u0018\u0001H\u0003H\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "it", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Unit> implements Function1<B, Unit> {
        final /* synthetic */ LiveData<A> $first;
        final /* synthetic */ LiveData<C> $third;
        final /* synthetic */ TripleLiveData<A, B, C> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TripleLiveData<A, B, C> tripleLiveData, LiveData<A> liveData, LiveData<C> liveData2) {
            super(1);
            this.this$0 = tripleLiveData;
            this.$first = liveData;
            this.$third = liveData2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((B) obj);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(B b) {
            this.this$0.setValue(new Triple(this.$first.getValue(), b, this.$third.getValue()));
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.live_data.TripleLiveData$3, reason: invalid class name */
    /* JADX INFO: compiled from: MoreLiveData.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u000e\u0010\u0005\u001a\n \u0006*\u0004\u0018\u0001H\u0004H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "it", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass3 extends Lambda<Unit> implements Function1<C, Unit> {
        final /* synthetic */ LiveData<A> $first;
        final /* synthetic */ LiveData<B> $second;
        final /* synthetic */ TripleLiveData<A, B, C> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(TripleLiveData<A, B, C> tripleLiveData, LiveData<A> liveData, LiveData<B> liveData2) {
            super(1);
            this.this$0 = tripleLiveData;
            this.$first = liveData;
            this.$second = liveData2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((C) obj);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(C c) {
            this.this$0.setValue(new Triple(this.$first.getValue(), this.$second.getValue(), c));
        }
    }
}
