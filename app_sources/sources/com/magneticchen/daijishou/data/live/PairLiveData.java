package com.magneticchen.daijishou.data.live;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class PairLiveData<A, B> extends MediatorLiveData<Pair<? extends A, ? extends B>> {
    public PairLiveData(LiveData<A> first, LiveData<B> second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        addSource(first, new PairLiveData$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(this, second)));
        addSource(second, new PairLiveData$sam$androidx_lifecycle_Observer$0(new AnonymousClass2(this, first)));
    }

    final class AnonymousClass1 extends Lambda<Unit> implements Function1<A, Unit> {
        final /* synthetic */ LiveData<B> $second;
        final /* synthetic */ PairLiveData<A, B> this$0;

        AnonymousClass1(PairLiveData<A, B> pairLiveData, LiveData<B> liveData) {
            super(1);
            this.this$0 = pairLiveData;
            this.$second = liveData;
        }

        @Override
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((A) obj);
            return Unit.INSTANCE;
        }

        public final void invoke2(A a) {
            this.this$0.setValue(TuplesKt.to(a, this.$second.getValue()));
        }
    }

    final class AnonymousClass2 extends Lambda<Unit> implements Function1<B, Unit> {
        final /* synthetic */ LiveData<A> $first;
        final /* synthetic */ PairLiveData<A, B> this$0;

        AnonymousClass2(PairLiveData<A, B> pairLiveData, LiveData<A> liveData) {
            super(1);
            this.this$0 = pairLiveData;
            this.$first = liveData;
        }

        @Override
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((B) obj);
            return Unit.INSTANCE;
        }

        public final void invoke2(B b) {
            this.this$0.setValue(TuplesKt.to(this.$first.getValue(), b));
        }
    }
}
